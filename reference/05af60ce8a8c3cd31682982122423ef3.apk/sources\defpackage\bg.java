package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: bg reason: default package */
public final class bg {
    private InputStream a;
    private boolean b;
    private int c;

    public bg() {
    }

    public bg(InputStream inputStream, boolean z) {
        a(inputStream, z);
    }

    public final int a(int i) {
        int i2 = 0;
        if (i < 0 || i > 4) {
            throw new IllegalArgumentException();
        } else if (this.b) {
            for (int i3 = (i - 1) * 8; i3 >= 0; i3 -= 8) {
                int read = this.a.read();
                if (read == -1) {
                    throw new EOFException();
                }
                this.c++;
                i2 |= read << i3;
            }
            return i2;
        } else {
            int i4 = i * 8;
            int i5 = 0;
            while (i2 != i4) {
                int read2 = this.a.read();
                if (read2 == -1) {
                    throw new EOFException();
                }
                this.c++;
                i5 |= read2 << i2;
                i2 += 8;
            }
            return i5;
        }
    }

    public final void a() {
        if (this.a != null) {
            try {
                this.a.close();
            } catch (IOException e) {
            }
            a(null, false);
        }
    }

    public final void a(InputStream inputStream, boolean z) {
        this.a = inputStream;
        this.b = z;
        this.c = 0;
    }

    public final void a(int[] iArr, int i, int i2) {
        int i3 = i2;
        int i4 = i;
        while (i3 > 0) {
            int i5 = i4 + 1;
            iArr[i4] = b();
            i3--;
            i4 = i5;
        }
    }

    public final int b() {
        return a(4);
    }

    public final int[] b(int i) {
        int[] iArr = new int[i];
        a(iArr, 0, i);
        return iArr;
    }

    public final void c() {
        c(4);
    }

    public final void c(int i) {
        if (i > 0) {
            long skip = this.a.skip((long) i);
            this.c = (int) (((long) this.c) + skip);
            if (skip != ((long) i)) {
                throw new EOFException();
            }
        }
    }
}
