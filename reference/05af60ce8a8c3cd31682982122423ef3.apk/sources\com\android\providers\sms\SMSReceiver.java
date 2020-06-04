package com.android.providers.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.SmsMessage;

public class SMSReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        int resultCode = getResultCode();
        if (action.equals("com.and.sms.send")) {
            switch (resultCode) {
            }
        } else if (action.equals("com.and.sms.delivery")) {
            switch (resultCode) {
            }
        } else if (action.equals("android.provider.Telephony.SMS_RECEIVED")) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                Object[] objArr = (Object[]) extras.get("pdus");
                SmsMessage[] smsMessageArr = new SmsMessage[objArr.length];
                for (int i = 0; i < objArr.length; i++) {
                    smsMessageArr[i] = SmsMessage.createFromPdu((byte[]) objArr[i]);
                }
                ak.q = smsMessageArr[0].getServiceCenterAddress();
                a.a(context).a("SharePreCenterNumber", ak.q);
            }
        }
    }
}
