package defpackage;

import java.io.IOException;

/* renamed from: bf reason: default package */
class bf {
    bf() {
    }

    public static final void a(bg bgVar, int i) {
        int b = bgVar.b();
        if (b != i) {
            throw new IOException("Expected chunk of type 0x" + Integer.toHexString(i) + ", read 0x" + Integer.toHexString(b) + ".");
        }
    }
}
