package tb;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.preference.PreferenceManager;
import com.alibaba.mtl.appmonitor.AppMonitor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ku2 {
    public static final String IS_ENABLE_HOTPATCH_KEY = "is_enable_hotpatch";
    private static String a = "hotpatch";

    public static void a(String str, String str2, String str3, String str4) {
        AppMonitor.Alarm.commitFail(a, str, str2, str3, str4);
    }

    public static void b(String str, String str2) {
        AppMonitor.Alarm.commitSuccess(a, str, str2);
    }

    public static void c(File file, File file2) throws IOException {
        Throwable th;
        FileChannel fileChannel;
        FileChannel channel;
        for (int i = 0; i < 3; i++) {
            FileChannel fileChannel2 = null;
            try {
                if (!file2.exists()) {
                    if (!file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    file2.createNewFile();
                }
                channel = new FileInputStream(file).getChannel();
            } catch (Throwable th2) {
                th = th2;
                fileChannel = null;
            }
            try {
                fileChannel2 = new FileOutputStream(file2).getChannel();
                channel.transferTo(0L, channel.size(), fileChannel2);
                channel.close();
                if (fileChannel2 != null) {
                    fileChannel2.close();
                    return;
                }
                return;
            } catch (Throwable th3) {
                th = th3;
                fileChannel = fileChannel2;
                fileChannel2 = channel;
                try {
                    file2.delete();
                    if (i == 2) {
                        throw new IOException("Failed to copy file[src=" + file.getAbsolutePath() + ", dest=" + file2.getAbsolutePath() + jn1.ARRAY_END_STR, th);
                    }
                } finally {
                    if (fileChannel2 != null) {
                        fileChannel2.close();
                    }
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                }
            }
        }
    }

    public static boolean d(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                d(file2);
            }
        }
        return file.delete();
    }

    private static String e(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return null;
        }
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && runningAppProcesses.size() != 0) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == myPid) {
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static boolean f(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean g(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application).getBoolean(IS_ENABLE_HOTPATCH_KEY, true);
    }

    public static boolean h(Context context) {
        String e = e(context);
        String packageName = context.getPackageName();
        return (e == null || packageName == null || !e.equals(packageName)) ? false : true;
    }

    public static boolean i(Application application) {
        return g(application) && sz0.b(application);
    }
}
