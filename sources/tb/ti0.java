package tb;

import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ti0 {
    public static String a(String str) {
        int i;
        int lastIndexOf = str.lastIndexOf("/");
        return (lastIndexOf == -1 || str.length() <= (i = lastIndexOf + 1)) ? str : str.substring(i);
    }

    public static void b(File file, File file2) {
        try {
            if (file2.exists()) {
                file2.delete();
            }
            file.renameTo(file2);
        } catch (Throwable th) {
            ob1.e(th);
        }
    }
}
