package defpackage;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.ninepvi.shield.MainActivity;

/* renamed from: ar reason: default package */
public class ar implements OnClickListener {
    final /* synthetic */ MainActivity a;

    public ar(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.startActivityForResult(new Intent("android.intent.action.DELETE", Uri.parse("package:" + MainActivity.g.activityInfo.processName)), 1);
    }
}
