package defpackage;

import android.os.Environment;

/* renamed from: o reason: default package */
class o extends Thread {
    final /* synthetic */ ag a;

    o(ag agVar) {
        this.a = agVar;
    }

    public void run() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            this.a.a.g();
        }
        this.a.a.d.cancel();
    }
}
