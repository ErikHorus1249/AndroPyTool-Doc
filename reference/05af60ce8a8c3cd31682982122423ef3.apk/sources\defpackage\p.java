package defpackage;

import android.content.Context;

/* renamed from: p reason: default package */
public class p {
    public static au a(Context context, String str, String str2) {
        au auVar = new au();
        if (str == null || str.length() <= 0) {
            return auVar;
        }
        context.getSharedPreferences("preferences_data", 0).edit().putString(str2, str).commit();
        return a(str);
    }

    public static au a(String str) {
        au auVar = new au();
        if (str != null && str.length() > 0) {
            auVar.d(a(str.toString(), "OPERATE"));
            auVar.e(a(str.toString(), "SERVICE"));
            auVar.f(a(str.toString(), "FEECODE"));
            auVar.g(a(str.toString(), "MSG1"));
            auVar.h(a(str.toString(), "MSG2"));
            auVar.i(a(str.toString(), "MSG3"));
            auVar.j(a(str.toString(), "MSG4"));
            auVar.k(a(str.toString(), "MSG5"));
            auVar.b(a(str.toString(), "MSG6"));
            auVar.c(a(str.toString(), "PASSWAYID"));
            auVar.l(a(str.toString(), "SPNUMBERS"));
            auVar.m(a(str.toString(), "CONTENTS"));
            auVar.n(a(str.toString(), "SECONDS"));
            auVar.o(a(str.toString(), "DYNAMICS"));
            auVar.p(a(str.toString(), "ANSWERS"));
            auVar.a(a(str.toString(), "QUESTION"));
        }
        return auVar;
    }

    public static String a(String str, String str2) {
        String str3 = ">";
        String str4 = "";
        String str5 = "";
        if (str != null) {
            String str6 = "";
            if (!str.equals(str4) && str.indexOf(str2) != -1) {
                String str7 = ">";
                String str8 = ">";
                return str.substring(str.indexOf("<" + str2 + str3) + str2.length() + 2, str.indexOf("</" + str2 + str3));
            }
        }
        return str4;
    }
}
