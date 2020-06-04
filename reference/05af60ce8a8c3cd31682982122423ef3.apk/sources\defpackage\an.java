package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.ninepvi.shield.MainActivity;
import com.ninepvi.shield.R;
import java.util.Iterator;

/* renamed from: an reason: default package */
public class an implements OnItemClickListener {
    final /* synthetic */ MainActivity a;

    public an(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        TextView textView = (TextView) view.findViewById(R.id.activityInfo_packageName);
        if (textView.getText() != null && textView.getText().toString() != null && !textView.getText().toString().equals("")) {
            if (this.a.e == null) {
                Intent intent = new Intent("android.intent.action.MAIN", null);
                intent.addCategory("android.intent.category.LAUNCHER");
                this.a.e = this.a.getPackageManager().queryIntentActivities(intent, 0);
            }
            String trim = ((TextView) view.findViewById(R.id.activityInfo_packageName)).getText().toString().trim();
            Iterator it = this.a.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ResolveInfo resolveInfo = (ResolveInfo) it.next();
                if (resolveInfo.activityInfo.applicationInfo.packageName.equals(trim)) {
                    MainActivity.g = resolveInfo;
                    break;
                }
            }
            new e((Context) this.a, this.a.r, 104, "正在扫描所选择程序，请稍等....").start();
        }
    }
}
