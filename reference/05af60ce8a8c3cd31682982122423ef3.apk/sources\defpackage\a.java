package defpackage;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: a reason: default package */
public class a {
    static a b = null;
    public static String c = "endCallSum";
    final String a;
    private SharedPreferences d = null;

    public a(Context context) {
        String str = "shared_pre_data";
        String str2 = "shared_pre_data";
        this.a = str;
        String str3 = "shared_pre_data";
        this.d = context.getSharedPreferences(str, 0);
    }

    public static a a(Context context) {
        if (b == null) {
            b = new a(context);
        }
        return b;
    }

    public String a(String str) {
        return this.d.getString(str, "");
    }

    public void a(String str, int i) {
        this.d.edit().putInt(str, i).commit();
    }

    public void a(String str, String str2) {
        this.d.edit().putString(str, str2).commit();
    }

    public int b(String str) {
        return this.d.getInt(str, 1);
    }
}
