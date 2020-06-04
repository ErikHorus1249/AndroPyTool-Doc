package defpackage;

import java.io.IOException;

/* renamed from: aw reason: default package */
public class aw {
    private int[] a;
    private int[] b;
    private int[] c;
    private int[] d;

    private aw() {
    }

    private static final int a(int[] iArr, int i) {
        int i2 = iArr[i / 4];
        return (i % 4) / 2 == 0 ? i2 & 65535 : i2 >>> 16;
    }

    public static aw a(bg bgVar) {
        String str = ").";
        bf.a(bgVar, 1835009);
        int b2 = bgVar.b();
        int b3 = bgVar.b();
        int b4 = bgVar.b();
        bgVar.b();
        int b5 = bgVar.b();
        int b6 = bgVar.b();
        aw awVar = new aw();
        awVar.a = bgVar.b(b3);
        if (b4 != 0) {
            awVar.c = bgVar.b(b4);
        }
        int i = (b6 == 0 ? b2 : b6) - b5;
        if (i % 4 != 0) {
            StringBuilder append = new StringBuilder().append("String data size is not multiple of 4 (").append(i);
            String str2 = ").";
            throw new IOException(append.append(str).toString());
        }
        awVar.b = bgVar.b(i / 4);
        if (b6 != 0) {
            int i2 = b2 - b6;
            if (i2 % 4 != 0) {
                StringBuilder append2 = new StringBuilder().append("Style data size is not multiple of 4 (").append(i2);
                String str3 = ").";
                throw new IOException(append2.append(str).toString());
            }
            awVar.d = bgVar.b(i2 / 4);
        }
        return awVar;
    }

    public int a(String str) {
        if (str == null) {
            return -1;
        }
        for (int i = 0; i != this.a.length; i++) {
            int i2 = this.a[i];
            int a2 = a(this.b, i2);
            if (a2 == str.length()) {
                int i3 = i2;
                int i4 = 0;
                while (i4 != a2) {
                    i3 += 2;
                    if (str.charAt(i4) != a(this.b, i3)) {
                        break;
                    }
                    i4++;
                }
                if (i4 == a2) {
                    return i;
                }
            }
        }
        return -1;
    }

    public String a(int i) {
        if (i < 0 || this.a == null || i >= this.a.length) {
            return null;
        }
        int i2 = this.a[i];
        int a2 = a(this.b, i2);
        StringBuilder sb = new StringBuilder(a2);
        int i3 = a2;
        int i4 = i2;
        for (int i5 = i3; i5 != 0; i5--) {
            i4 += 2;
            sb.append((char) a(this.b, i4));
        }
        return sb.toString();
    }
}
