package defpackage;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.ninepvi.shield.MainActivity;

/* renamed from: at reason: default package */
class at implements OnClickListener {
    final /* synthetic */ be a;

    at(be beVar) {
        this.a = beVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.a.startActivity(new Intent(this.a.a, MainActivity.class));
    }
}
