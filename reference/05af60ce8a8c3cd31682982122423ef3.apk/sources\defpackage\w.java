package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Message;

/* renamed from: w reason: default package */
class w implements OnClickListener {
    final /* synthetic */ aj a;

    w(aj ajVar) {
        this.a = ajVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        String str = this.a.a.p + this.a.a.o;
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putString("filePath", str);
        message.setData(bundle);
        message.what = 109;
        new e((Context) this.a.a, this.a.a.r, message, "正在执行扫描...").start();
    }
}
