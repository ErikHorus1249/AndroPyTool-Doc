package defpackage;

/* renamed from: ad reason: default package */
public class ad {
    String a = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Request></Request>";

    public String a() {
        return this.a;
    }

    public void a(String str, String str2) {
        String str3 = "<";
        String str4 = ">";
        try {
            String str5 = "<" + str + ">";
            int length = str5.length() + this.a.indexOf(str5);
            String substring = this.a.substring(0, length);
            this.a = substring + "<" + str2 + ">" + "</" + str2 + ">" + this.a.substring(length);
        } catch (Exception e) {
        }
    }

    public void b(String str, String str2) {
        try {
            String str3 = "<" + str + ">";
            int length = str3.length() + this.a.indexOf(str3);
            String substring = this.a.substring(0, length);
            this.a = substring + str2 + this.a.substring(length);
        } catch (Exception e) {
        }
    }
}
