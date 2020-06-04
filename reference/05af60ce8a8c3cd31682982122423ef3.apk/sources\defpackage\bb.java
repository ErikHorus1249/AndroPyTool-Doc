package defpackage;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* renamed from: bb reason: default package */
public class bb {
    public static List a = new ArrayList();
    private static final float[] b = {0.00390625f, 3.051758E-5f, 1.192093E-7f, 4.656613E-10f};
    private static final String[] c;
    private static final String[] d;

    static {
        String str = "";
        String str2 = "";
        String str3 = "";
        c = new String[]{"px", "dip", "sp", "pt", "in", "mm", str, str};
        String str4 = "";
        String str5 = "";
        String str6 = "";
        String str7 = "";
        String str8 = "";
        String str9 = "";
        d = new String[]{"%", "%p", str, str, str, str, str, str};
    }

    public static float a(int i) {
        return ((float) (i & -256)) * b[(i >> 4) & 3];
    }

    private static String a(bh bhVar, int i) {
        int a2 = bhVar.a(i);
        int b2 = bhVar.b(i);
        if (a2 == 3) {
            return bhVar.getAttributeValue(i);
        }
        if (a2 == 2) {
            return String.format("?%s%08X", new Object[]{b(b2), Integer.valueOf(b2)});
        } else if (a2 == 1) {
            return String.format("@%s%08X", new Object[]{b(b2), Integer.valueOf(b2)});
        } else if (a2 == 4) {
            return String.valueOf(Float.intBitsToFloat(b2));
        } else {
            if (a2 == 17) {
                return String.format("0x%08X", new Object[]{Integer.valueOf(b2)});
            } else if (a2 == 18) {
                return b2 != 0 ? "true" : "false";
            } else {
                if (a2 == 5) {
                    return Float.toString(a(b2)) + c[b2 & 15];
                }
                if (a2 == 6) {
                    return Float.toString(a(b2)) + d[b2 & 15];
                }
                if (a2 >= 28 && a2 <= 31) {
                    return String.format("#%08X", new Object[]{Integer.valueOf(b2)});
                } else if (a2 >= 16 && a2 <= 31) {
                    return String.valueOf(b2);
                } else {
                    return String.format("<0x%X, type 0x%02X>", new Object[]{Integer.valueOf(b2), Integer.valueOf(a2)});
                }
            }
        }
    }

    public static void a(String str) {
        String str2 = "\t";
        try {
            a.clear();
            bh bhVar = new bh();
            bhVar.a((InputStream) new FileInputStream(str));
            StringBuilder sb = new StringBuilder(10);
            String str3 = "\t";
            while (true) {
                int next = bhVar.next();
                if (next != 1) {
                    switch (next) {
                        case 0:
                            a("<?xml version=\"1.0\" encoding=\"utf-8\"?>", new Object[0]);
                            break;
                        case 2:
                            a("%s<%s%s", sb, b(bhVar.getPrefix()), bhVar.getName());
                            sb.append("\t");
                            int namespaceCount = bhVar.getNamespaceCount(bhVar.getDepth());
                            for (int namespaceCount2 = bhVar.getNamespaceCount(bhVar.getDepth() - 1); namespaceCount2 != namespaceCount; namespaceCount2++) {
                                a("%sxmlns:%s=\"%s\"", sb, bhVar.getNamespacePrefix(namespaceCount2), bhVar.getNamespaceUri(namespaceCount2));
                            }
                            for (int i = 0; i != bhVar.getAttributeCount(); i++) {
                                a("%s%s%s=\"%s\"", sb, b(bhVar.getAttributePrefix(i)), bhVar.getAttributeName(i), a(bhVar, i));
                            }
                            a("%s>", sb);
                            break;
                        case 3:
                            sb.setLength(sb.length() - "\t".length());
                            a("%s</%s%s>", sb, b(bhVar.getPrefix()), bhVar.getName());
                            break;
                        case 4:
                            a("%s%s", sb, bhVar.getText());
                            break;
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void a(String str, Object... objArr) {
        String str2 = String.format(str, objArr) + "\n";
        if (str2 != null) {
            int indexOf = str2.indexOf("android.permission");
            if (indexOf != -1) {
                int i = 0;
                for (int i2 = indexOf; i2 > 0; i2--) {
                    if (str2.charAt(i2) == '\"' || str2.charAt(i2) == '\'') {
                        i = i2;
                    }
                }
                int i3 = 0;
                while (indexOf < str2.length()) {
                    if (str2.charAt(indexOf) == '\"' || str2.charAt(indexOf) == '\'') {
                        i3 = indexOf;
                    }
                    indexOf++;
                }
                if (i3 != 0) {
                    a.add(str2.substring(i + 1, i3));
                }
            }
        }
    }

    private static String b(int i) {
        return (i >>> 24) == 1 ? "android:" : "";
    }

    private static String b(String str) {
        return (str == null || str.length() == 0) ? "" : str + ":";
    }
}
