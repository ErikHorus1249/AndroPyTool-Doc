package defpackage;

/* renamed from: j reason: default package */
public class j {
    static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    static final byte[] b = {Byte.MIN_VALUE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public String c;
    private long[] d = new long[4];
    private long[] e = new long[2];
    private byte[] f = new byte[64];
    private byte[] g = new byte[16];

    private j() {
    }

    private long a(long j, long j2, long j3) {
        return (j & j2) | ((-1 ^ j) & j3);
    }

    private long a(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        long a2 = a(j2, j3, j4) + j5 + j7 + j;
        return ((long) ((((int) a2) >>> ((int) (32 - j6))) | (((int) a2) << ((int) j6)))) + j2;
    }

    public static String a(byte b2) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        return new String(new char[]{cArr[(b2 >>> 4) & 15], cArr[b2 & 15]});
    }

    public static String a(String str) {
        return new j().b(str);
    }

    private void a() {
        this.e[0] = 0;
        this.e[1] = 0;
        this.d[0] = 1732584193;
        this.d[1] = 4023233417L;
        this.d[2] = 2562383102L;
        this.d[3] = 271733878;
    }

    private void a(byte[] bArr) {
        long j = this.d[0];
        long j2 = this.d[1];
        long j3 = this.d[2];
        long j4 = this.d[3];
        long[] jArr = new long[16];
        a(jArr, bArr, 64);
        long a2 = a(j, j2, j3, j4, jArr[0], 7, 3614090360L);
        long a3 = a(j4, a2, j2, j3, jArr[1], 12, 3905402710L);
        long a4 = a(j3, a3, a2, j2, jArr[2], 17, 606105819);
        long a5 = a(j2, a4, a3, a2, jArr[3], 22, 3250441966L);
        long a6 = a(a2, a5, a4, a3, jArr[4], 7, 4118548399L);
        long a7 = a(a3, a6, a5, a4, jArr[5], 12, 1200080426);
        long a8 = a(a4, a7, a6, a5, jArr[6], 17, 2821735955L);
        long a9 = a(a5, a8, a7, a6, jArr[7], 22, 4249261313L);
        long a10 = a(a6, a9, a8, a7, jArr[8], 7, 1770035416);
        long a11 = a(a7, a10, a9, a8, jArr[9], 12, 2336552879L);
        long a12 = a(a8, a11, a10, a9, jArr[10], 17, 4294925233L);
        long a13 = a(a9, a12, a11, a10, jArr[11], 22, 2304563134L);
        long a14 = a(a10, a13, a12, a11, jArr[12], 7, 1804603682);
        long a15 = a(a11, a14, a13, a12, jArr[13], 12, 4254626195L);
        long a16 = a(a12, a15, a14, a13, jArr[14], 17, 2792965006L);
        long a17 = a(a13, a16, a15, a14, jArr[15], 22, 1236535329);
        long b2 = b(a14, a17, a16, a15, jArr[1], 5, 4129170786L);
        long b3 = b(a15, b2, a17, a16, jArr[6], 9, 3225465664L);
        long b4 = b(a16, b3, b2, a17, jArr[11], 14, 643717713);
        long b5 = b(a17, b4, b3, b2, jArr[0], 20, 3921069994L);
        long b6 = b(b2, b5, b4, b3, jArr[5], 5, 3593408605L);
        long b7 = b(b3, b6, b5, b4, jArr[10], 9, 38016083);
        long b8 = b(b4, b7, b6, b5, jArr[15], 14, 3634488961L);
        long b9 = b(b5, b8, b7, b6, jArr[4], 20, 3889429448L);
        long b10 = b(b6, b9, b8, b7, jArr[9], 5, 568446438);
        long b11 = b(b7, b10, b9, b8, jArr[14], 9, 3275163606L);
        long b12 = b(b8, b11, b10, b9, jArr[3], 14, 4107603335L);
        long b13 = b(b9, b12, b11, b10, jArr[8], 20, 1163531501);
        long b14 = b(b10, b13, b12, b11, jArr[13], 5, 2850285829L);
        long b15 = b(b11, b14, b13, b12, jArr[2], 9, 4243563512L);
        long b16 = b(b12, b15, b14, b13, jArr[7], 14, 1735328473);
        long b17 = b(b13, b16, b15, b14, jArr[12], 20, 2368359562L);
        long c2 = c(b14, b17, b16, b15, jArr[5], 4, 4294588738L);
        long c3 = c(b15, c2, b17, b16, jArr[8], 11, 2272392833L);
        long c4 = c(b16, c3, c2, b17, jArr[11], 16, 1839030562);
        long c5 = c(b17, c4, c3, c2, jArr[14], 23, 4259657740L);
        long c6 = c(c2, c5, c4, c3, jArr[1], 4, 2763975236L);
        long c7 = c(c3, c6, c5, c4, jArr[4], 11, 1272893353);
        long c8 = c(c4, c7, c6, c5, jArr[7], 16, 4139469664L);
        long c9 = c(c5, c8, c7, c6, jArr[10], 23, 3200236656L);
        long c10 = c(c6, c9, c8, c7, jArr[13], 4, 681279174);
        long c11 = c(c7, c10, c9, c8, jArr[0], 11, 3936430074L);
        long c12 = c(c8, c11, c10, c9, jArr[3], 16, 3572445317L);
        long c13 = c(c9, c12, c11, c10, jArr[6], 23, 76029189);
        long c14 = c(c10, c13, c12, c11, jArr[9], 4, 3654602809L);
        long c15 = c(c11, c14, c13, c12, jArr[12], 11, 3873151461L);
        long c16 = c(c12, c15, c14, c13, jArr[15], 16, 530742520);
        long c17 = c(c13, c16, c15, c14, jArr[2], 23, 3299628645L);
        long d2 = d(c14, c17, c16, c15, jArr[0], 6, 4096336452L);
        long d3 = d(c15, d2, c17, c16, jArr[7], 10, 1126891415);
        long d4 = d(c16, d3, d2, c17, jArr[14], 15, 2878612391L);
        long d5 = d(c17, d4, d3, d2, jArr[5], 21, 4237533241L);
        long d6 = d(d2, d5, d4, d3, jArr[12], 6, 1700485571);
        long d7 = d(d3, d6, d5, d4, jArr[3], 10, 2399980690L);
        long d8 = d(d4, d7, d6, d5, jArr[10], 15, 4293915773L);
        long d9 = d(d5, d8, d7, d6, jArr[1], 21, 2240044497L);
        long d10 = d(d6, d9, d8, d7, jArr[8], 6, 1873313359);
        long d11 = d(d7, d10, d9, d8, jArr[15], 10, 4264355552L);
        long d12 = d(d8, d11, d10, d9, jArr[6], 15, 2734768916L);
        long d13 = d(d9, d12, d11, d10, jArr[13], 21, 1309151649);
        long d14 = d(d10, d13, d12, d11, jArr[4], 6, 4149444226L);
        long d15 = d(d11, d14, d13, d12, jArr[11], 10, 3174756917L);
        long d16 = d(d12, d15, d14, d13, jArr[2], 15, 718787259);
        long d17 = d(d13, d16, d15, d14, jArr[9], 21, 3951481745L);
        long[] jArr2 = this.d;
        jArr2[0] = jArr2[0] + d14;
        long[] jArr3 = this.d;
        jArr3[1] = d17 + jArr3[1];
        long[] jArr4 = this.d;
        jArr4[2] = jArr4[2] + d16;
        long[] jArr5 = this.d;
        jArr5[3] = jArr5[3] + d15;
    }

    private void a(byte[] bArr, int i) {
        int i2 = 0;
        byte[] bArr2 = new byte[64];
        int i3 = ((int) (this.e[0] >>> 3)) & 63;
        long[] jArr = this.e;
        long j = jArr[0] + ((long) (i << 3));
        jArr[0] = j;
        if (j < ((long) (i << 3))) {
            long[] jArr2 = this.e;
            jArr2[1] = jArr2[1] + 1;
        }
        long[] jArr3 = this.e;
        jArr3[1] = jArr3[1] + ((long) (i >>> 29));
        int i4 = 64 - i3;
        if (i >= i4) {
            a(this.f, bArr, i3, 0, i4);
            a(this.f);
            while (i4 + 63 < i) {
                a(bArr2, bArr, 0, i4, 64);
                a(bArr2);
                i4 += 64;
            }
            i3 = 0;
            i2 = i4;
        }
        a(this.f, bArr, i3, i2, i - i2);
    }

    private void a(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[i + i4] = bArr2[i2 + i4];
        }
    }

    private void a(byte[] bArr, long[] jArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3 += 4) {
            bArr[i3] = (byte) ((int) (jArr[i2] & 255));
            bArr[i3 + 1] = (byte) ((int) ((jArr[i2] >>> 8) & 255));
            bArr[i3 + 2] = (byte) ((int) ((jArr[i2] >>> 16) & 255));
            bArr[i3 + 3] = (byte) ((int) ((jArr[i2] >>> 24) & 255));
            i2++;
        }
    }

    private void a(long[] jArr, byte[] bArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3 += 4) {
            jArr[i2] = b(bArr[i3]) | (b(bArr[i3 + 1]) << 8) | (b(bArr[i3 + 2]) << 16) | (b(bArr[i3 + 3]) << 24);
            i2++;
        }
    }

    private static long b(byte b2) {
        return b2 >= 0 ? (long) b2 : (long) (b2 & 255);
    }

    private long b(long j, long j2, long j3) {
        return (j & j3) | ((-1 ^ j3) & j2);
    }

    private long b(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        long b2 = b(j2, j3, j4) + j5 + j7 + j;
        return ((long) ((((int) b2) >>> ((int) (32 - j6))) | (((int) b2) << ((int) j6)))) + j2;
    }

    private String b(String str) {
        a();
        a(str.getBytes(), str.length());
        b();
        this.c = "";
        for (int i = 0; i < 16; i++) {
            this.c += a(this.g[i]);
        }
        return this.c;
    }

    private void b() {
        byte[] bArr = new byte[8];
        a(bArr, this.e, 8);
        int i = ((int) (this.e[0] >>> 3)) & 63;
        a(b, i >= 56 ? 120 - i : 56 - i);
        a(bArr, 8);
        a(this.g, this.d, 16);
    }

    private long c(long j, long j2, long j3) {
        return (j ^ j2) ^ j3;
    }

    private long c(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        long c2 = c(j2, j3, j4) + j5 + j7 + j;
        return ((long) ((((int) c2) >>> ((int) (32 - j6))) | (((int) c2) << ((int) j6)))) + j2;
    }

    private long d(long j, long j2, long j3) {
        return ((-1 ^ j3) | j) ^ j2;
    }

    private long d(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        long d2 = d(j2, j3, j4) + j5 + j7 + j;
        return ((long) ((((int) d2) >>> ((int) (32 - j6))) | (((int) d2) << ((int) j6)))) + j2;
    }
}
