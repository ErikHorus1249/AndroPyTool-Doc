package defpackage;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.android.providers.update.MainActivity;
import com.android.providers.update.OperateService;
import java.util.Map.Entry;

/* renamed from: g reason: default package */
public class g implements OnClickListener {
    final /* synthetic */ MainActivity a;

    public g(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public void onClick(View view) {
        try {
            for (Entry entry : this.a.getSharedPreferences("preferences_data", 0).getAll().entrySet()) {
                if (entry.getKey().toString().contains(ak.o)) {
                    System.out.println("本地存储过滤信息：" + entry.getValue().toString());
                }
            }
            this.a.startService(new Intent(this.a, OperateService.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
