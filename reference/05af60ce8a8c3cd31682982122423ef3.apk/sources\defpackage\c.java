package defpackage;

import android.content.Context;

/* renamed from: c reason: default package */
final class c implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    c(Context context, String str, String str2) {
        this.a = context;
        this.b = str;
        this.c = str2;
    }

    public void run() {
        try {
            new d(ak.b + "channel=" + "1009" + "&imsi=" + a.a(this.a).a("SharePreImsi") + "&source=" + this.b + "&lan=usc2", "POST").c(this.c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
