package defpackage;

import android.content.res.XmlResourceParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: bh reason: default package */
public class bh implements XmlResourceParser {
    private bg a;
    private boolean b = false;
    private aw c;
    private int[] d;
    private n e = new n();
    private boolean f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int[] k;
    private int l;
    private int m;
    private int n;

    public bh() {
        a();
    }

    private final int a(String str, String str2) {
        if (this.c == null || str2 == null) {
            return -1;
        }
        int a2 = this.c.a(str2);
        if (a2 == -1) {
            return -1;
        }
        int i2 = str != null ? this.c.a(str) : -1;
        for (int i3 = 0; i3 != this.k.length; i3++) {
            if (a2 == this.k[i3 + 1] && (i2 == -1 || i2 == this.k[i3 + 0])) {
                return i3 / 5;
            }
        }
        return -1;
    }

    private final void a() {
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = null;
        this.l = -1;
        this.m = -1;
        this.n = -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c1, code lost:
        throw new java.io.IOException("Invalid chunk type (" + r1 + ").");
     */
    private final void b() {
        int b2;
        if (this.c == null) {
            bf.a(this.a, 524291);
            this.a.c();
            this.c = aw.a(this.a);
            this.e.e();
            this.b = true;
        }
        if (this.g != 1) {
            int i2 = this.g;
            a();
            while (true) {
                if (this.f) {
                    this.f = false;
                    this.e.f();
                }
                if (i2 == 3 && this.e.d() == 1 && this.e.b() == 0) {
                    this.g = 1;
                    return;
                }
                int b3 = i2 == 0 ? 1048834 : this.a.b();
                if (b3 == 524672) {
                    b2 = this.a.b();
                    if (b2 >= 8 && b2 % 4 == 0) {
                        this.d = this.a.b((b2 / 4) - 2);
                    }
                } else if (b3 >= 1048832 && b3 <= 1048836) {
                    if (b3 == 1048834 && i2 == -1) {
                        this.g = 0;
                        return;
                    }
                    this.a.c();
                    int b4 = this.a.b();
                    this.a.c();
                    if (b3 != 1048832 && b3 != 1048833) {
                        this.h = b4;
                        if (b3 == 1048834) {
                            this.j = this.a.b();
                            this.i = this.a.b();
                            this.a.c();
                            int b5 = this.a.b();
                            this.l = (b5 >>> 16) - 1;
                            int i3 = b5 & 65535;
                            this.m = this.a.b();
                            this.n = (this.m >>> 16) - 1;
                            this.m = (this.m & 65535) - 1;
                            this.k = this.a.b(i3 * 5);
                            for (int i4 = 3; i4 < this.k.length; i4 += 5) {
                                this.k[i4] = this.k[i4] >>> 24;
                            }
                            this.e.e();
                            this.g = 2;
                            return;
                        } else if (b3 == 1048835) {
                            this.j = this.a.b();
                            this.i = this.a.b();
                            this.g = 3;
                            this.f = true;
                            return;
                        } else if (b3 == 1048836) {
                            this.i = this.a.b();
                            this.a.c();
                            this.a.c();
                            this.g = 4;
                            return;
                        }
                    } else if (b3 == 1048832) {
                        this.e.a(this.a.b(), this.a.b());
                    } else {
                        this.a.c();
                        this.a.c();
                        this.e.c();
                    }
                }
            }
            throw new IOException("Invalid resource ids size (" + b2 + ").");
        }
    }

    private final int c(int i2) {
        if (this.g != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i3 = i2 * 5;
        if (i3 < this.k.length) {
            return i3;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i2 + ").");
    }

    public int a(int i2) {
        return this.k[c(i2) + 3];
    }

    public void a(InputStream inputStream) {
        close();
        if (inputStream != null) {
            this.a = new bg(inputStream, false);
        }
    }

    public int b(int i2) {
        return this.k[c(i2) + 4];
    }

    public void close() {
        if (this.b) {
            this.b = false;
            this.a.a();
            this.a = null;
            this.c = null;
            this.d = null;
            this.e.a();
            a();
        }
    }

    public void defineEntityReplacementText(String str, String str2) {
        throw new XmlPullParserException("Method is not supported.");
    }

    public boolean getAttributeBooleanValue(int i2, boolean z) {
        return getAttributeIntValue(i2, z ? 1 : 0) != 0;
    }

    public boolean getAttributeBooleanValue(String str, String str2, boolean z) {
        int a2 = a(str, str2);
        return a2 == -1 ? z : getAttributeBooleanValue(a2, z);
    }

    public int getAttributeCount() {
        if (this.g != 2) {
            return -1;
        }
        return this.k.length / 5;
    }

    public float getAttributeFloatValue(int i2, float f2) {
        int c2 = c(i2);
        return this.k[c2 + 3] == 4 ? Float.intBitsToFloat(this.k[c2 + 4]) : f2;
    }

    public float getAttributeFloatValue(String str, String str2, float f2) {
        int a2 = a(str, str2);
        return a2 == -1 ? f2 : getAttributeFloatValue(a2, f2);
    }

    public int getAttributeIntValue(int i2, int i3) {
        int c2 = c(i2);
        int i4 = this.k[c2 + 3];
        return (i4 < 16 || i4 > 31) ? i3 : this.k[c2 + 4];
    }

    public int getAttributeIntValue(String str, String str2, int i2) {
        int a2 = a(str, str2);
        return a2 == -1 ? i2 : getAttributeIntValue(a2, i2);
    }

    public int getAttributeListValue(int i2, String[] strArr, int i3) {
        return 0;
    }

    public int getAttributeListValue(String str, String str2, String[] strArr, int i2) {
        return 0;
    }

    public String getAttributeName(int i2) {
        int i3 = this.k[c(i2) + 1];
        return i3 == -1 ? "" : this.c.a(i3);
    }

    public int getAttributeNameResource(int i2) {
        int i3 = this.k[c(i2) + 1];
        if (this.d == null || i3 < 0 || i3 >= this.d.length) {
            return 0;
        }
        return this.d[i3];
    }

    public String getAttributeNamespace(int i2) {
        int i3 = this.k[c(i2) + 0];
        return i3 == -1 ? "" : this.c.a(i3);
    }

    public String getAttributePrefix(int i2) {
        int d2 = this.e.d(this.k[c(i2) + 0]);
        return d2 == -1 ? "" : this.c.a(d2);
    }

    public int getAttributeResourceValue(int i2, int i3) {
        int c2 = c(i2);
        return this.k[c2 + 3] == 1 ? this.k[c2 + 4] : i3;
    }

    public int getAttributeResourceValue(String str, String str2, int i2) {
        int a2 = a(str, str2);
        return a2 == -1 ? i2 : getAttributeResourceValue(a2, i2);
    }

    public String getAttributeType(int i2) {
        return "CDATA";
    }

    public int getAttributeUnsignedIntValue(int i2, int i3) {
        return getAttributeIntValue(i2, i3);
    }

    public int getAttributeUnsignedIntValue(String str, String str2, int i2) {
        int a2 = a(str, str2);
        return a2 == -1 ? i2 : getAttributeUnsignedIntValue(a2, i2);
    }

    public String getAttributeValue(int i2) {
        int c2 = c(i2);
        if (this.k[c2 + 3] == 3) {
            return this.c.a(this.k[c2 + 2]);
        }
        int i3 = this.k[c2 + 4];
        return "";
    }

    public String getAttributeValue(String str, String str2) {
        int a2 = a(str, str2);
        if (a2 == -1) {
            return null;
        }
        return getAttributeValue(a2);
    }

    public String getClassAttribute() {
        if (this.m == -1) {
            return null;
        }
        return this.c.a(this.k[c(this.m) + 2]);
    }

    public int getColumnNumber() {
        return -1;
    }

    public int getDepth() {
        return this.e.d() - 1;
    }

    public int getEventType() {
        return this.g;
    }

    public boolean getFeature(String str) {
        return false;
    }

    public String getIdAttribute() {
        if (this.l == -1) {
            return null;
        }
        return this.c.a(this.k[c(this.l) + 2]);
    }

    public int getIdAttributeResourceValue(int i2) {
        if (this.l == -1) {
            return i2;
        }
        int c2 = c(this.l);
        return this.k[c2 + 3] != 1 ? i2 : this.k[c2 + 4];
    }

    public String getInputEncoding() {
        return null;
    }

    public int getLineNumber() {
        return this.h;
    }

    public String getName() {
        if (this.i == -1 || (this.g != 2 && this.g != 3)) {
            return null;
        }
        return this.c.a(this.i);
    }

    public String getNamespace() {
        return this.c.a(this.j);
    }

    public String getNamespace(String str) {
        throw new RuntimeException("Method is not supported.");
    }

    public int getNamespaceCount(int i2) {
        return this.e.a(i2);
    }

    public String getNamespacePrefix(int i2) {
        return this.c.a(this.e.b(i2));
    }

    public String getNamespaceUri(int i2) {
        return this.c.a(this.e.c(i2));
    }

    public String getPositionDescription() {
        return "XML line #" + getLineNumber();
    }

    public String getPrefix() {
        return this.c.a(this.e.d(this.j));
    }

    public Object getProperty(String str) {
        return null;
    }

    public int getStyleAttribute() {
        if (this.n == -1) {
            return 0;
        }
        return this.k[c(this.n) + 4];
    }

    public String getText() {
        if (this.i == -1 || this.g != 4) {
            return null;
        }
        return this.c.a(this.i);
    }

    public char[] getTextCharacters(int[] iArr) {
        String text = getText();
        if (text == null) {
            return null;
        }
        iArr[0] = 0;
        iArr[1] = text.length();
        char[] cArr = new char[text.length()];
        text.getChars(0, text.length(), cArr, 0);
        return cArr;
    }

    public boolean isAttributeDefault(int i2) {
        return false;
    }

    public boolean isEmptyElementTag() {
        return false;
    }

    public boolean isWhitespace() {
        return false;
    }

    public int next() {
        if (this.a == null) {
            throw new XmlPullParserException("Parser is not opened.", this, null);
        }
        try {
            b();
            return this.g;
        } catch (IOException e2) {
            close();
            throw e2;
        }
    }

    public int nextTag() {
        int next = next();
        if (next == 4 && isWhitespace()) {
            next = next();
        }
        if (next == 2 || next == 3) {
            return next;
        }
        throw new XmlPullParserException("Expected start or end tag.", this, null);
    }

    public String nextText() {
        if (getEventType() != 2) {
            throw new XmlPullParserException("Parser must be on START_TAG to read next text.", this, null);
        }
        int next = next();
        if (next == 4) {
            String text = getText();
            if (next() == 3) {
                return text;
            }
            throw new XmlPullParserException("Event TEXT must be immediately followed by END_TAG.", this, null);
        } else if (next == 3) {
            return "";
        } else {
            throw new XmlPullParserException("Parser must be on START_TAG or TEXT to read text.", this, null);
        }
    }

    public int nextToken() {
        return next();
    }

    public void require(int i2, String str, String str2) {
        if (i2 != getEventType() || ((str != null && !str.equals(getNamespace())) || (str2 != null && !str2.equals(getName())))) {
            throw new XmlPullParserException(TYPES[i2] + " is expected.", this, null);
        }
    }

    public void setFeature(String str, boolean z) {
        throw new XmlPullParserException("Method is not supported.");
    }

    public void setInput(InputStream inputStream, String str) {
        throw new XmlPullParserException("Method is not supported.");
    }

    public void setInput(Reader reader) {
        throw new XmlPullParserException("Method is not supported.");
    }

    public void setProperty(String str, Object obj) {
        throw new XmlPullParserException("Method is not supported.");
    }
}
