package tb;

import android.content.Context;
import android.os.Process;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class q33 {
    private static String a = "efs";
    private static File b;

    public static File a(Context context) {
        File dir = context.getDir(a, 0);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }

    public static File b(Context context, String str) {
        return new File(h(context, str), "efs_cst");
    }

    public static File c(Context context, String str) {
        return new File(h(context, str), "efs_config");
    }

    public static File d(Context context, String str) {
        return new File(h(context, str), "efs_flow");
    }

    public static File e(Context context, String str) {
        File file = new File(h(context, str), "ready");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File f(Context context, String str) {
        File file = new File(e(context, str), String.valueOf(Process.myPid()));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File g(Context context, String str) {
        File file = new File(h(context, str), "upload");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File h(Context context, String str) {
        if (b == null) {
            synchronized (q33.class) {
                if (b == null) {
                    b = a(context);
                }
            }
        }
        File file = new File(b, str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
