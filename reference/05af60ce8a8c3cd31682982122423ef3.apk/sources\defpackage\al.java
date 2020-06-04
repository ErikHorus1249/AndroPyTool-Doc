package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.ninepvi.shield.MainActivity;
import com.ninepvi.shield.R;
import java.util.ArrayList;

/* renamed from: al reason: default package */
public class al implements OnClickListener {
    final /* synthetic */ MainActivity a;

    public al(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public void onClick(View view) {
        ListView listView = (ListView) this.a.findViewById(R.id.lv_content);
        ArrayList arrayList = new ArrayList();
        if (listView != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= listView.getChildCount()) {
                    break;
                }
                if (((CheckBox) listView.getChildAt(i2).findViewById(R.id.cb_cancel_trust)).isChecked()) {
                    arrayList.add(((TextView) listView.getChildAt(i2).findViewById(R.id.activityInfo_name)).getText() + "|" + ((TextView) listView.getChildAt(i2).findViewById(R.id.activityInfo_packageName)).getText());
                }
                i = i2 + 1;
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            this.a.c("请勾选要信任的程序");
            return;
        }
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putCharSequenceArrayList("trustPackageNames", arrayList);
        message.setData(bundle);
        message.what = 108;
        new e((Context) this.a, this.a.r, message, "正在执行添加...").start();
    }
}
