package defpackage;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import com.ninepvi.shield.MainActivity;
import com.ninepvi.shield.R;

/* renamed from: bd reason: default package */
public class bd implements OnClickListener {
    final /* synthetic */ MainActivity a;

    public bd(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public void onClick(View view) {
        this.a.s.setBackgroundResource(R.drawable.tab_install_app_nor);
        this.a.t.setBackgroundResource(R.drawable.tab_assign_app_sel);
        this.a.u.setBackgroundResource(R.drawable.tab_trust_app_nor);
        this.a.v.setBackgroundResource(R.drawable.tab_scan_result_nor);
        this.a.setTitle("指定扫描APK");
        ((Button) this.a.findViewById(R.id.bt_content_top)).setVisibility(4);
        ((ListView) this.a.findViewById(R.id.lv_content)).setAdapter(null);
        new e(this.a, this.a.r, 2).start();
    }
}
