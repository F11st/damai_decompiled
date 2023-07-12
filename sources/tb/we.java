package tb;

import android.content.Context;
import com.taobao.tao.log.TLogConstant;
import com.youku.arch.solid.monitor.SolidMonitor;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class we {
    private static void a(File file, boolean z, boolean z2) {
        File[] listFiles;
        if (file == null || !file.exists() || file.isFile() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                if (!z2 || !file2.getName().startsWith("UTCrashHandler")) {
                    b(file2);
                }
            } else if (!z || !file2.getName().equals(SolidMonitor.CHECK_TYPE_LIB)) {
                a(file2, false, z2);
                file2.delete();
            }
        }
    }

    private static void b(File file) {
        File file2 = new File(file.getAbsolutePath() + TLogConstant.RUBBISH_DIR);
        file.renameTo(file2);
        file2.delete();
    }

    public static void clear(Context context, boolean z) {
        a(context.getFilesDir().getParentFile(), true, z);
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null || externalCacheDir.getParentFile() == null) {
            return;
        }
        File parentFile = externalCacheDir.getParentFile();
        a(parentFile, true, z);
        parentFile.delete();
    }

    public static void deleteDir(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                deleteDir(file2);
            }
        }
        file.delete();
    }

    public static void clear(Context context) {
        clear(context, true);
    }
}
