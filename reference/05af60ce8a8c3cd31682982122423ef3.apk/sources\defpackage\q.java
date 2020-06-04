package defpackage;

import android.util.Xml;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: q reason: default package */
public class q {
    public static String a(InputStream inputStream) {
        String str = "";
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        int eventType = newPullParser.getEventType();
        while (true) {
            int i = eventType;
            String str2 = str;
            int i2 = i;
            if (i2 != 1) {
                switch (i2) {
                    case 0:
                        str = str2;
                        break;
                    case 2:
                        if ("userid".equalsIgnoreCase(newPullParser.getName())) {
                            str = newPullParser.nextText();
                            break;
                        }
                    default:
                        str = str2;
                        break;
                }
                eventType = newPullParser.next();
            } else {
                ak.f = str2;
                return str2;
            }
        }
    }
}
