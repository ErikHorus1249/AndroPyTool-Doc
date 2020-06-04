package defpackage;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import com.ninepvi.shield.MainActivity;
import com.ninepvi.shield.R;

/* renamed from: ax reason: default package */
public class ax implements OnClickListener {
    final /* synthetic */ MainActivity a;

    public ax(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public void onClick(View view) {
        this.a.s.setBackgroundResource(R.drawable.tab_install_app_nor);
        this.a.t.setBackgroundResource(R.drawable.tab_assign_app_nor);
        this.a.u.setBackgroundResource(R.drawable.tab_trust_app_nor);
        this.a.v.setBackgroundResource(R.drawable.tab_scan_result_sel);
        Button button = (Button) this.a.findViewById(R.id.bt_content_top);
        button.setText("信任已勾选程序");
        button.setVisibility(0);
        ((ListView) this.a.findViewById(R.id.lv_content)).setAdapter(null);
        this.a.setTitle("扫描结果");
        new e(this.a, this.a.r, 4).start();
    }
}
