package defpackage;

/* renamed from: n reason: default package */
final class n {
    private int[] a = new int[32];
    private int b;
    private int c;
    private int d;

    private final int a(int i, boolean z) {
        if (this.b == 0) {
            return -1;
        }
        int i2 = this.b - 1;
        int i3 = i2;
        int i4 = this.d;
        while (i4 != 0) {
            int i5 = this.a[i3];
            int i6 = i3 - 2;
            for (int i7 = i5; i7 != 0; i7--) {
                if (z) {
                    if (this.a[i6] == i) {
                        return this.a[i6 + 1];
                    }
                } else if (this.a[i6 + 1] == i) {
                    return this.a[i6];
                }
                i6 -= 2;
            }
            i4--;
            i3 = i6;
        }
        return -1;
    }

    private final int b(int i, boolean z) {
        if (this.b == 0 || i < 0) {
            return -1;
        }
        int i2 = i;
        int i3 = this.d;
        int i4 = 0;
        while (i3 != 0) {
            int i5 = this.a[i4];
            if (i2 >= i5) {
                i2 -= i5;
                i4 += (i5 * 2) + 2;
                i3--;
            } else {
                int i6 = (i2 * 2) + 1 + i4;
                if (!z) {
                    i6++;
                }
                return this.a[i6];
            }
        }
        return -1;
    }

    private void e(int i) {
        int length = this.a.length - this.b;
        if (length <= i) {
            int[] iArr = new int[((length + this.a.length) * 2)];
            System.arraycopy(this.a, 0, iArr, 0, this.b);
            this.a = iArr;
        }
    }

    public final int a(int i) {
        int i2 = 0;
        if (this.b == 0 || i < 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = i > this.d ? this.d : i; i4 != 0; i4--) {
            int i5 = this.a[i3];
            i2 += i5;
            i3 += (i5 * 2) + 2;
        }
        return i2;
    }

    public final void a() {
        this.b = 0;
        this.c = 0;
        this.d = 0;
    }

    public final void a(int i, int i2) {
        if (this.d == 0) {
            e();
        }
        e(2);
        int i3 = this.b - 1;
        int i4 = this.a[i3];
        this.a[(i3 - 1) - (i4 * 2)] = i4 + 1;
        this.a[i3] = i;
        this.a[i3 + 1] = i2;
        this.a[i3 + 2] = i4 + 1;
        this.b += 2;
        this.c++;
    }

    public final int b() {
        if (this.b == 0) {
            return 0;
        }
        return this.a[this.b - 1];
    }

    public final int b(int i) {
        return b(i, true);
    }

    public final int c(int i) {
        return b(i, false);
    }

    public final boolean c() {
        if (this.b == 0) {
            return false;
        }
        int i = this.b - 1;
        int i2 = this.a[i];
        if (i2 == 0) {
            return false;
        }
        int i3 = i2 - 1;
        int i4 = i - 2;
        this.a[i4] = i3;
        this.a[i4 - ((i3 * 2) + 1)] = i3;
        this.b -= 2;
        this.c--;
        return true;
    }

    public final int d() {
        return this.d;
    }

    public final int d(int i) {
        return a(i, false);
    }

    public final void e() {
        e(2);
        int i = this.b;
        this.a[i] = 0;
        this.a[i + 1] = 0;
        this.b += 2;
        this.d++;
    }

    public final void f() {
        if (this.b != 0) {
            int i = this.b - 1;
            int i2 = this.a[i];
            if ((i - 1) - (i2 * 2) != 0) {
                this.b -= (i2 * 2) + 2;
                this.c -= i2;
                this.d--;
            }
        }
    }
}
