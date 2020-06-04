package defpackage;

import android.app.AlertDialog.Builder;
import android.os.Handler;
import android.os.Message;
import com.ninepvi.shield.R;
import com.ninepvi.shield.TrustAppActivity;

/* renamed from: be reason: default package */
public class be extends Handler {
    final /* synthetic */ TrustAppActivity a;

    public be(TrustAppActivity trustAppActivity) {
        this.a = trustAppActivity;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                new Builder(this.a).setIcon(R.drawable.alert_dialog_icon).setTitle(R.string.s_title_prompt).setMessage("目前还没有信任程序").setPositiveButton("返回", new at(this)).show();
                return;
            default:
                return;
        }
    }
}
