package defpackage;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import com.ninepvi.shield.MainActivity;
import com.ninepvi.shield.R;

/* renamed from: az reason: default package */
public class az implements OnClickListener {
    final /* synthetic */ MainActivity a;

    public az(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public void onClick(View view) {
        this.a.s.setBackgroundResource(R.drawable.tab_install_app_sel);
        this.a.t.setBackgroundResource(R.drawable.tab_assign_app_nor);
        this.a.u.setBackgroundResource(R.drawable.tab_trust_app_nor);
        this.a.v.setBackgroundResource(R.drawable.tab_scan_result_nor);
        this.a.setTitle("已安装程序");
        Button button = (Button) this.a.findViewById(R.id.bt_content_top);
        button.setText("扫描已安装程序");
        button.setVisibility(0);
        ((ListView) this.a.findViewById(R.id.lv_content)).setAdapter(null);
        new e(this.a, this.a.r, 1).start();
    }
}
