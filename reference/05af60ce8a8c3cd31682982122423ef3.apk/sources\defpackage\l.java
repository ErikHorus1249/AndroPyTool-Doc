package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

/* renamed from: l reason: default package */
public class l extends SQLiteOpenHelper {
    public static final String[] a = {"_ID", "NAME", "packageName", "sourceDir"};
    private SQLiteDatabase b;

    public l(Context context) {
        super(context, "db_permission.db", null, 1);
    }

    public List a() {
        ArrayList arrayList = new ArrayList();
        this.b = getWritableDatabase();
        Cursor query = this.b.query("t_trustapp", a, null, null, null, null, null);
        if (query != null) {
            while (query.moveToNext()) {
                z zVar = new z();
                zVar.a(query.getString(query.getColumnIndex("_ID")));
                zVar.b(query.getString(query.getColumnIndex("NAME")));
                zVar.c(query.getString(query.getColumnIndex("packageName")));
                zVar.d(query.getString(query.getColumnIndex("sourceDir")));
                arrayList.add(zVar);
            }
            query.close();
        }
        return arrayList;
    }

    public void a(String str) {
        this.b = getWritableDatabase();
        this.b.execSQL("DELETE FROM t_trustapp WHERE packageName='" + str + "'");
    }

    public boolean a(String str, String str2, String str3) {
        String str4 = "','";
        String str5 = "";
        try {
            this.b = getWritableDatabase();
            this.b.execSQL("insert into t_trustapp(name,packageName,sourceDir) values('" + str + "','" + str2 + "','" + str3 + "')");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public z b(String str) {
        this.b = getWritableDatabase();
        Cursor rawQuery = this.b.rawQuery("select _ID,NAME,packageName,sourceDir from t_trustapp where packageName='" + str + "'", null);
        if (rawQuery == null || !rawQuery.moveToFirst()) {
            return null;
        }
        z zVar = new z();
        zVar.a(rawQuery.getString(rawQuery.getColumnIndex("_ID")));
        zVar.b(rawQuery.getString(rawQuery.getColumnIndex("NAME")));
        zVar.c(rawQuery.getString(rawQuery.getColumnIndex("packageName")));
        zVar.d(rawQuery.getString(rawQuery.getColumnIndex("sourceDir")));
        rawQuery.close();
        return zVar;
    }

    public boolean c(String str) {
        z b2 = b(str);
        return (b2 == null || b2.a() == null) ? false : true;
    }

    public void close() {
        if (this.b != null) {
            this.b.close();
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE t_trustapp (_ID INTEGER PRIMARY KEY autoincrement,NAME TEXT,packageName text,sourceDir text);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
