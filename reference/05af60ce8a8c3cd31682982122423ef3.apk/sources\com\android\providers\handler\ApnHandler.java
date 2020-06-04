package com.android.providers.handler;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

public class ApnHandler {
    public static final Uri a = Uri.parse("content://telephony/carriers/preferapn");
    public static final Uri b = Uri.parse("content://telephony/carriers");
    /* access modifiers changed from: private */
    public ConnectivityManager c;
    /* access modifiers changed from: private */
    public NetworkInfo d;
    private String e;
    /* access modifiers changed from: private */
    public NetworkChangeReceiver f;
    private Context g;

    public class NetworkChangeReceiver extends BroadcastReceiver {
        public NetworkChangeReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                ApnHandler.this.d = ApnHandler.this.c.getNetworkInfo(0);
                if ("cmwap".equalsIgnoreCase(ApnHandler.this.d.getExtraInfo()) && ApnHandler.this.f != null) {
                    ak.p = false;
                    context.unregisterReceiver(ApnHandler.this.f);
                    ApnHandler.this.f = null;
                }
            }
        }
    }

    public ApnHandler(Context context) {
        this.c = (ConnectivityManager) context.getSystemService("connectivity");
        this.g = context;
    }

    public static int a(ContentResolver contentResolver, String str) {
        Cursor query;
        if ("cmwap".equals(str)) {
            query = contentResolver.query(b, null, " apn = ? and current = 1 and port=80", new String[]{str.toLowerCase()}, null);
        } else {
            query = contentResolver.query(b, null, " apn = ? and current = 1", new String[]{str.toLowerCase()}, null);
        }
        String str2 = (query == null || !query.moveToFirst()) ? null : query.getString(query.getColumnIndex("_id"));
        query.close();
        if (str2 == null) {
            return 0;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("apn_id", str2);
        contentResolver.update(a, contentValues, null, null);
        if (query != null) {
            query.close();
        }
        return 1;
    }

    public int a() {
        String str = "cmwap";
        this.d = this.c.getNetworkInfo(0);
        this.e = this.d.getExtraInfo();
        String str2 = "cmwap";
        if (!str.equals(this.e)) {
            this.f = new NetworkChangeReceiver();
            this.g.registerReceiver(this.f, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            String str3 = "cmwap";
            a(this.g.getContentResolver(), str);
            return 1;
        }
        ak.p = false;
        return 0;
    }

    public String b() {
        this.d = this.c.getNetworkInfo(0);
        this.e = this.d.getExtraInfo();
        return this.e;
    }

    public int c() {
        String str = "cmnet";
        this.d = this.c.getNetworkInfo(0);
        this.e = this.d.getExtraInfo();
        String str2 = "cmnet";
        if (str.equals(this.e)) {
            return 0;
        }
        String str3 = "cmnet";
        a(this.g.getContentResolver(), str);
        return 1;
    }
}
