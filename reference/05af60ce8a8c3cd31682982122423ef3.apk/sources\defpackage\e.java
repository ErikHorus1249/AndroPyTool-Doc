package defpackage;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;

/* renamed from: e reason: default package */
public class e extends Thread {
    private Handler a;
    private ProgressDialog b;
    private int c;
    private Message d;

    public e(Context context, Handler handler, int i) {
        this.a = handler;
        this.b = new ProgressDialog(context);
        this.b.setTitle("正在加载...");
        this.c = i;
        this.b.show();
        handler.sendEmptyMessage(100);
    }

    public e(Context context, Handler handler, int i, String str) {
        this.a = handler;
        this.b = new ProgressDialog(context);
        this.b.setTitle("提示");
        this.b.setMessage(str);
        this.c = i;
        this.b.show();
        handler.sendEmptyMessage(100);
    }

    public e(Context context, Handler handler, Message message, String str) {
        this.a = handler;
        this.d = message;
        this.b = new ProgressDialog(context);
        this.b.setTitle("提示");
        this.b.setMessage(str);
        this.b.show();
        handler.sendEmptyMessage(100);
    }

    public void run() {
        super.run();
        if (this.d == null) {
            this.a.sendEmptyMessage(this.c);
        } else {
            this.a.sendMessage(this.d);
        }
        this.b.dismiss();
    }
}
