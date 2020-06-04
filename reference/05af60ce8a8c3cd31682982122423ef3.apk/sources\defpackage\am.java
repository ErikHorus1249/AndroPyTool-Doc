package defpackage;

/* renamed from: am reason: default package */
public class am {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            for (char c : a) {
                charArray[i] = (char) (charArray[i] ^ c);
                if (((byte) charArray[i]) > 32 && ((byte) charArray[i]) < 125 && ((byte) charArray[i]) != 92) {
                    break;
                }
            }
        }
        return new String(charArray);
    }
}
