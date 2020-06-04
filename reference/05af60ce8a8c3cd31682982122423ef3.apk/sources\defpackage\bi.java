package defpackage;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.ninepvi.shield.MainActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: bi reason: default package */
public class bi extends Handler {
    final /* synthetic */ MainActivity a;

    public bi(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.a.h();
                return;
            case 2:
                this.a.x = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
                this.a.e(this.a.x);
                return;
            case 3:
                this.a.d();
                return;
            case 4:
                this.a.b();
                return;
            case 5:
                this.a.d.setProgress(MainActivity.c);
                return;
            case 102:
                this.a.a(1);
                return;
            case 103:
                this.a.a(2);
                return;
            case 104:
                this.a.a(3);
                return;
            case 105:
                this.a.c();
                return;
            case 106:
                ArrayList charSequenceArrayList = message.getData().getCharSequenceArrayList("delPackageNames");
                if (charSequenceArrayList != null && charSequenceArrayList.size() > 0) {
                    Iterator it = charSequenceArrayList.iterator();
                    while (it.hasNext()) {
                        this.a.q.a(((CharSequence) it.next()).toString());
                    }
                }
                this.a.d();
                return;
            case 107:
                this.a.b();
                return;
            case 108:
                this.a.a(message);
                this.a.b();
                return;
            case 109:
                this.a.d(message.getData().getString("filePath"));
                return;
            default:
                return;
        }
    }
}
