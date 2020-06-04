package defpackage;

import android.util.Xml;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: r reason: default package */
public class r {
    public static List a(InputStream inputStream) {
        i iVar;
        ArrayList arrayList;
        String str = "permission";
        ArrayList arrayList2 = new ArrayList();
        i iVar2 = null;
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        int eventType = newPullParser.getEventType();
        ArrayList arrayList3 = arrayList2;
        while (true) {
            int i = eventType;
            if (i != 1) {
                String name = newPullParser.getName();
                switch (i) {
                    case 0:
                        i iVar3 = iVar2;
                        arrayList = new ArrayList();
                        iVar = iVar3;
                        continue;
                    case 2:
                        String str2 = "permission";
                        if (!name.equalsIgnoreCase(str)) {
                            if (iVar2 != null) {
                                if (!name.equalsIgnoreCase("name")) {
                                    if (!name.equalsIgnoreCase("zhExplain")) {
                                        if (name.equalsIgnoreCase("enExplain")) {
                                            iVar2.c(newPullParser.nextText().trim());
                                            iVar = iVar2;
                                            arrayList = arrayList3;
                                            break;
                                        }
                                    } else {
                                        iVar2.b(newPullParser.nextText().trim());
                                        iVar = iVar2;
                                        arrayList = arrayList3;
                                        break;
                                    }
                                } else {
                                    iVar2.a(newPullParser.nextText().trim());
                                    iVar = iVar2;
                                    arrayList = arrayList3;
                                    break;
                                }
                            }
                        } else {
                            iVar = new i();
                            arrayList = arrayList3;
                            continue;
                        }
                    case 3:
                        String str3 = "permission";
                        if (name.equalsIgnoreCase(str)) {
                            arrayList3.add(iVar2);
                        }
                        iVar = iVar2;
                        arrayList = arrayList3;
                        break;
                }
                iVar = iVar2;
                arrayList = arrayList3;
                eventType = newPullParser.next();
                arrayList3 = arrayList;
                iVar2 = iVar;
            } else {
                if (inputStream != null) {
                    inputStream.close();
                }
                return arrayList3;
            }
        }
    }
}
