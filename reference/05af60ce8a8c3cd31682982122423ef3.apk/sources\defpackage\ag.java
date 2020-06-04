package defpackage;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.ninepvi.shield.MainActivity;

/* renamed from: ag reason: default package */
public class ag implements OnClickListener {
    final /* synthetic */ MainActivity a;

    public ag(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public void onClick(View view) {
        this.a.w = new Intent("android.intent.action.MAIN", null);
        this.a.w.addCategory("android.intent.category.LAUNCHER");
        this.a.e = this.a.getPackageManager().queryIntentActivities(this.a.w, 0);
        this.a.d = new ProgressDialog(this.a);
        this.a.d.setProgressStyle(1);
        this.a.d.setTitle("提示");
        this.a.d.setMessage("正在扫描已经安装程序...");
        this.a.d.setMax(this.a.e.size());
        this.a.d.setIndeterminate(false);
        this.a.d.setCancelable(true);
        this.a.d.show();
        new o(this).start();
    }
}
