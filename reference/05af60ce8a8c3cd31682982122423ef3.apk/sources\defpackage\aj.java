package defpackage;

import android.app.AlertDialog.Builder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.ninepvi.shield.MainActivity;
import com.ninepvi.shield.R;
import java.io.File;

/* renamed from: aj reason: default package */
public class aj implements OnItemClickListener {
    final /* synthetic */ MainActivity a;

    public aj(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str = "确定";
        String str2 = ".APK";
        File file = new File((String) this.a.n.get(i));
        if (file.isDirectory()) {
            this.a.e((String) this.a.n.get(i));
            return;
        }
        this.a.o = file.getName().toUpperCase();
        String str3 = ".APK";
        if (this.a.o.indexOf(str2) != -1) {
            String str4 = ".APK";
            if (this.a.o.substring(this.a.o.indexOf(str2)).length() == 4) {
                Builder message = new Builder(this.a).setIcon(R.drawable.alert_dialog_icon).setTitle(R.string.s_title_prompt).setMessage("确定扫描[" + this.a.o + "]文件吗？");
                String str5 = "确定";
                message.setPositiveButton(str, new w(this)).setNegativeButton("取消", new ac(this)).show();
                return;
            }
        }
        String str6 = "确定";
        new Builder(this.a).setIcon(R.drawable.alert_dialog_icon).setTitle(R.string.s_title_prompt).setMessage("请选择APK格式的文件").setPositiveButton(str, new y(this)).show();
    }
}
