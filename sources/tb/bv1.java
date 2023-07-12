package tb;

import android.app.ActivityManager;
import android.os.Process;
import com.taobao.login4android.session.SessionManager;
import java.io.File;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bv1 {
    public static long a() {
        File file = new File("/proc/" + Process.myPid() + "/comm");
        if (file.exists()) {
            return file.lastModified();
        }
        return -1L;
    }

    public static boolean b() {
        String str;
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            str = fu0.e().a().getPackageName() + SessionManager.CHANNEL_PROCESS;
            activityManager = (ActivityManager) fu0.e().a().getSystemService("activity");
        } catch (Throwable th) {
            e30.a("ProcessUtils", th);
        }
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo != null && str.equals(runningAppProcessInfo.processName)) {
                return true;
            }
        }
        return false;
    }
}
