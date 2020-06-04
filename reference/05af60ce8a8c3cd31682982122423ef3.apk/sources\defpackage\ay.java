package defpackage;

/* renamed from: ay reason: default package */
public class ay {
    private static final char[] a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    public static String a(byte[] bArr) {
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer((bArr.length * 3) / 2);
        int i = length - 3;
        int i2 = 0;
        int i3 = 0;
        while (i3 <= i) {
            byte b = ((bArr[i3] & 255) << 16) | ((bArr[i3 + 1] & 255) << 8) | (bArr[i3 + 2] & 255);
            stringBuffer.append(a[(b >> 18) & 63]);
            stringBuffer.append(a[(b >> 12) & 63]);
            stringBuffer.append(a[(b >> 6) & 63]);
            stringBuffer.append(a[b & 63]);
            i3 += 3;
            int i4 = i2 + 1;
            if (i2 >= 14) {
                stringBuffer.append(" ");
                i2 = 0;
            } else {
                i2 = i4;
            }
        }
        if (i3 == (0 + length) - 2) {
            int i5 = ((bArr[i3] & 255) << 16) | ((bArr[i3 + 1] & 255) << 8);
            stringBuffer.append(a[(i5 >> 18) & 63]);
            stringBuffer.append(a[(i5 >> 12) & 63]);
            stringBuffer.append(a[(i5 >> 6) & 63]);
            stringBuffer.append("=");
        } else if (i3 == (length + 0) - 1) {
            int i6 = (bArr[i3] & 255) << 16;
            stringBuffer.append(a[(i6 >> 18) & 63]);
            stringBuffer.append(a[(i6 >> 12) & 63]);
            stringBuffer.append("==");
        }
        return stringBuffer.toString();
    }
}
