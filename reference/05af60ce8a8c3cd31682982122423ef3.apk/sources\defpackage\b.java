package defpackage;

import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* renamed from: b reason: default package */
public class b {
    public static int a = 4096;

    public static void a(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File a2 : listFiles) {
                    a(a2);
                }
            }
            file.delete();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r1.closeEntry();
        r4.flush();
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
        r3 = new java.io.File(r7);
        a(r3);
        r3.createNewFile();
        r4 = new java.io.FileOutputStream(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0030, code lost:
        r3 = r1.read(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0035, code lost:
        if (r3 == -1) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0037, code lost:
        r4.write(r2, 0, r3);
     */
    public static void a(String str, String str2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
            byte[] bArr = new byte[256];
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    if (nextEntry.getName().equals("AndroidManifest.xml")) {
                        break;
                    }
                } else {
                    break;
                }
            }
            fileInputStream.close();
            zipInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
