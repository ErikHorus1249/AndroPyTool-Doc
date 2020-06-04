package defpackage;

import android.util.Xml;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: d reason: default package */
public class d {
    public static boolean b = true;
    byte[] a;
    private String c;
    private String d;
    private String e;
    private int f = 0;
    private String g;
    private HttpURLConnection h;
    private OutputStream i;
    private InputStream j;
    private final String k;
    private final String l;
    private String m;
    private String n;

    public d() {
        String str = "";
        String str2 = "";
        this.c = str;
        String str3 = "";
        this.d = str;
        String str4 = "";
        this.e = str;
        String str5 = "";
        this.g = str;
        this.h = null;
        this.a = null;
        this.k = "10.0.0.172:80";
        this.l = "http://";
    }

    public d(String str) {
        String str2 = "";
        String str3 = "";
        this.c = str2;
        String str4 = "";
        this.d = str2;
        String str5 = "";
        this.e = str2;
        String str6 = "";
        this.g = str2;
        this.h = null;
        this.a = null;
        this.k = "10.0.0.172:80";
        this.l = "http://";
        String str7 = "";
        a(str, str2, "GET", 0);
    }

    public d(String str, String str2) {
        String str3 = "";
        String str4 = "";
        this.c = str3;
        String str5 = "";
        this.d = str3;
        String str6 = "";
        this.e = str3;
        String str7 = "";
        this.g = str3;
        this.h = null;
        this.a = null;
        this.k = "10.0.0.172:80";
        this.l = "http://";
        String str8 = "";
        a(str, str3, str2, 0);
    }

    public d(String str, String str2, int i2) {
        String str3 = "";
        String str4 = "";
        this.c = str3;
        String str5 = "";
        this.d = str3;
        String str6 = "";
        this.e = str3;
        String str7 = "";
        this.g = str3;
        this.h = null;
        this.a = null;
        this.k = "10.0.0.172:80";
        this.l = "http://";
        String str8 = "";
        a(str, str3, str2, i2);
    }

    public d(String str, String str2, String str3) {
        String str4 = "";
        String str5 = "";
        this.c = str4;
        String str6 = "";
        this.d = str4;
        String str7 = "";
        this.e = str4;
        String str8 = "";
        this.g = str4;
        this.h = null;
        this.a = null;
        this.k = "10.0.0.172:80";
        this.l = "http://";
        a(str, str2, str3, 0);
    }

    private void a(String str, String str2, String str3, int i2) {
        try {
            this.c = str;
            this.d = str3;
            this.e = str2;
            this.f = i2;
            if (str != null) {
                String[] e2 = e(str);
                this.m = e2[0];
                this.n = e2[1];
                if (b) {
                    this.h = (HttpURLConnection) new URL("http://10.0.0.172:80" + this.n).openConnection();
                    this.h.setRequestProperty("X-Online-Host", this.m);
                } else {
                    this.h = (HttpURLConnection) new URL(str).openConnection();
                }
                this.h.setConnectTimeout(50000);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private void b() {
        String str = "";
        String headerField = this.h.getHeaderField("Result-Code");
        if (headerField == null) {
            String str2 = "";
            headerField = str;
        }
        ak.m = headerField;
        String headerField2 = this.h.getHeaderField("Content-Length");
        if (headerField2 == null) {
            String str3 = "";
            headerField2 = str;
        }
        ak.n = headerField2;
        String headerField3 = this.h.getHeaderField("Set-Cookie");
        if (headerField3 == null) {
            String str4 = "";
            headerField3 = str;
        }
        ak.l = headerField3;
        ak.k = new StringBuffer();
        for (Entry entry : this.h.getHeaderFields().entrySet()) {
            Object key = entry.getKey();
            ak.k.append(key + ":" + entry.getValue() + "/n");
        }
    }

    private void d(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            this.i = this.h.getOutputStream();
            this.i.write(bArr);
            this.i.flush();
            this.i.close();
        }
    }

    private void e(byte[] bArr) {
        String str;
        String str2 = "#";
        String str3 = ":";
        String str4 = "";
        try {
            this.h.setDoOutput(true);
            this.h.setDoInput(true);
            this.h.setRequestMethod(this.d);
            HashMap hashMap = new HashMap();
            hashMap.put("Accept-Charset", "utf-8, iso-8859-1, utf-16, *;q=0.7");
            hashMap.put("Accept", "application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
            hashMap.put("Accept-Language", "zh-CN, en-US");
            hashMap.put("Cache-Control", "no-store");
            hashMap.put("Connection", "Keep-Alive");
            hashMap.put("Proxy-Connection", "Keep-Alive");
            if (this.g != null && !this.g.equals("")) {
                if (this.g.contains("#")) {
                    for (String split : this.g.split("#")) {
                        String[] split2 = split.split(":");
                        hashMap.put(split2[0], split2[1]);
                    }
                } else if (this.g.contains(":")) {
                    String[] split3 = this.g.split(":");
                    hashMap.put(split3[0], split3[1]);
                }
            }
            for (Entry entry : hashMap.entrySet()) {
                this.h.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            if (!ak.i.equals("")) {
                this.h.setRequestProperty("User-Agent", ak.i);
            }
            if (ak.l.equals("") || !this.c.contains("opcode")) {
            }
            if (this.e != null && !this.e.equals("")) {
                this.h.setRequestProperty("Action", this.e);
                this.h.setRequestProperty("ClientHash", ak.h);
                this.h.setRequestProperty("Version", ak.d);
                HttpURLConnection httpURLConnection = this.h;
                String str5 = "User-Id";
                if (ak.f != null) {
                    str = ak.f;
                } else {
                    String str6 = "";
                    str = str4;
                }
                httpURLConnection.setRequestProperty(str5, str);
                this.h.setRequestProperty("APIVersion", "1.1.0");
                this.h.setRequestProperty("x-up-calling-line-id", "13867222424");
            }
            if (this.d.equals("POST")) {
                if (bArr == null || bArr.length == 0) {
                    this.h.setRequestProperty("Content-length", "0");
                } else {
                    this.h.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    this.h.setRequestProperty("Content-length", bArr.length + "");
                }
            }
            for (Entry entry2 : this.h.getRequestProperties().entrySet()) {
                entry2.getKey();
                entry2.getValue();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private String[] e(String str) {
        String str2 = "http://";
        String str3 = "/";
        String[] strArr = new String[2];
        String str4 = "http://";
        int length = str2.length();
        String str5 = "http://";
        if (str.toLowerCase().indexOf(str2) == -1) {
            return null;
        }
        String str6 = "/";
        int indexOf = str.indexOf(str3, length);
        if (indexOf == -1) {
            strArr[0] = str.substring(length, str.length());
            String str7 = "/";
            strArr[1] = str3;
            return strArr;
        }
        strArr[0] = str.substring(length, indexOf);
        strArr[1] = str.substring(indexOf);
        return strArr;
    }

    public InputStream a(String str) {
        return a(str.getBytes());
    }

    public InputStream a(byte[] bArr) {
        e(bArr);
        if (!(bArr == null || bArr.length == 0)) {
            d(bArr);
        }
        this.j = this.h.getInputStream();
        b();
        return this.j;
    }

    public void a() {
        if (this.h != null) {
            this.h.disconnect();
            this.h = null;
        }
        if (this.j != null) {
            this.j.close();
            this.j = null;
        }
        if (this.i != null) {
            this.i.close();
            this.i = null;
        }
    }

    public byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (this.f <= 0) {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } else {
            byte[] bArr2 = new byte[1024];
            int i2 = 1;
            while (true) {
                int read2 = inputStream.read(bArr2);
                if (read2 == -1 || this.f < i2) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read2);
                i2++;
            }
        }
        byteArrayOutputStream.flush();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return byteArray;
    }

    public byte[] b(String str) {
        return b(str.getBytes());
    }

    public byte[] b(byte[] bArr) {
        byte[] a2 = a(a(bArr));
        a();
        return a2;
    }

    public String c(String str) {
        return new String(b(str.getBytes()));
    }

    public List c(byte[] bArr) {
        k kVar;
        List list;
        String str = "request";
        InputStream a2 = a(bArr);
        if (ak.n == null || ak.n.equals("") || ak.n.equals("0")) {
            return null;
        }
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(a2, "UTF-8");
        k kVar2 = null;
        List list2 = null;
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            switch (eventType) {
                case 0:
                    k kVar3 = kVar2;
                    list = new ArrayList();
                    kVar = kVar3;
                    break;
                case 2:
                    String str2 = "request";
                    kVar = str.equalsIgnoreCase(newPullParser.getName()) ? new k() : kVar2;
                    if (kVar != null) {
                        if ("url".equalsIgnoreCase(newPullParser.getName())) {
                            kVar.b(newPullParser.nextText());
                        } else if ("method".equalsIgnoreCase(newPullParser.getName())) {
                            kVar.c(newPullParser.nextText());
                        } else if ("data".equalsIgnoreCase(newPullParser.getName())) {
                            kVar.d(newPullParser.nextText());
                        } else if ("isReturn".equalsIgnoreCase(newPullParser.getName())) {
                            kVar.e(newPullParser.nextText());
                        } else if ("downSize".equalsIgnoreCase(newPullParser.getName())) {
                            kVar.f(newPullParser.nextText());
                        } else if ("requestPropertys".equalsIgnoreCase(newPullParser.getName())) {
                            kVar.a(newPullParser.nextText());
                        }
                    }
                    if (!"opcode".equalsIgnoreCase(newPullParser.getName())) {
                        if (!"returnUrls".equalsIgnoreCase(newPullParser.getName())) {
                            if (!"returnMsgs".equalsIgnoreCase(newPullParser.getName())) {
                                if (!"sequence".equalsIgnoreCase(newPullParser.getName())) {
                                    if (!"sync".equalsIgnoreCase(newPullParser.getName())) {
                                        list = list2;
                                        break;
                                    } else {
                                        k.e = newPullParser.nextText();
                                        list = list2;
                                        break;
                                    }
                                } else {
                                    k.d = newPullParser.nextText();
                                    list = list2;
                                    break;
                                }
                            } else {
                                k.c = newPullParser.nextText();
                                list = list2;
                                break;
                            }
                        } else {
                            k.b = newPullParser.nextText();
                            list = list2;
                            break;
                        }
                    } else {
                        k.a = newPullParser.nextText();
                        list = list2;
                        break;
                    }
                case 3:
                    String str3 = "request";
                    if (str.equalsIgnoreCase(newPullParser.getName())) {
                        list2.add(kVar2);
                        kVar = null;
                        list = list2;
                        break;
                    }
                default:
                    kVar = kVar2;
                    list = list2;
                    break;
            }
            list2 = list;
            kVar2 = kVar;
        }
        return list2;
    }

    public void d(String str) {
        this.g = str;
    }
}
