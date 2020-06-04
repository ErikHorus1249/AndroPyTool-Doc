package defpackage;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.ninepvi.shield.MainActivity;

/* renamed from: v reason: default package */
public class v implements OnClickListener {
    final /* synthetic */ MainActivity a;

    public v(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.finish();
    }
}
