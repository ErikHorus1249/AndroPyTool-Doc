package defpackage;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.ninepvi.shield.MainActivity;

/* renamed from: aq reason: default package */
public class aq implements OnClickListener {
    final /* synthetic */ MainActivity a;

    public aq(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        new e(this.a, this.a.r, 107).start();
    }
}
