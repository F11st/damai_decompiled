package tb;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.net.URL;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ui0 {
    public static String a(l41 l41Var) {
        if (!TextUtils.isEmpty(l41Var.d)) {
            return l41Var.d;
        }
        try {
            return new File(new URL(l41Var.a).getFile()).getName();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b(String str, l41 l41Var) {
        String a = a(l41Var);
        if (TextUtils.isEmpty(a)) {
            return "";
        }
        File file = new File(str, a);
        File file2 = new File(str, a + ".download");
        String absolutePath = file.getAbsolutePath();
        if (file.exists()) {
            long j = l41Var.b;
            if ((0 == j || j == file.length()) && td1.c(l41Var.c, absolutePath)) {
                return file.getAbsolutePath();
            }
        }
        if (file2.exists()) {
            long j2 = l41Var.b;
            if ((0 == j2 || j2 == file2.length()) && td1.c(l41Var.c, file2.getAbsolutePath())) {
                file2.renameTo(file);
                return file.getAbsolutePath();
            }
        }
        return "";
    }

    public static String c(Context context, String str) {
        return d(context, str, true);
    }

    public static String d(Context context, String str, boolean z) {
        File externalCacheDir = z ? context.getExternalCacheDir() : null;
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        StringBuilder sb = new StringBuilder();
        String str2 = File.separator;
        sb.append(str2);
        sb.append("downloadsdk");
        sb.append(str2);
        sb.append(str);
        File file = new File(externalCacheDir, sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static boolean e(File file, File file2) {
        if (file.exists()) {
            if (!file2.exists() || file2.delete()) {
                if (file2.getParentFile().exists() || file2.getParentFile().mkdirs()) {
                    if (!file2.getParentFile().canWrite()) {
                        file2.getParentFile().setWritable(true);
                    }
                    if (file.renameTo(file2)) {
                        return true;
                    }
                    ka0.e("FileUtils", "mvFile", "rename fail", file.getName());
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}
