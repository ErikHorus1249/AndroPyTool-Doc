package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.ninepvi.shield.MainActivity;

/* renamed from: as reason: default package */
public class as implements OnClickListener {
    final /* synthetic */ MainActivity a;

    public as(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        new e((Context) this.a, this.a.r, 105, "正在添加应用程序到信任...").start();
    }
}
