package tb;

import android.app.ActivityManager;
import android.content.Context;
import com.efs.sdk.base.Constants;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class j83 {
    public static String a;

    public static String a(int i) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + i + "/cmdline")));
        } catch (Throwable th) {
            th = th;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read = bufferedReader.read();
                if (read <= 0) {
                    sb.trimToSize();
                    String sb2 = sb.toString();
                    try {
                        bufferedReader.close();
                        return sb2;
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                        return sb2;
                    }
                }
                sb.append((char) read);
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = bufferedReader;
            try {
                w63.c(Constants.TAG, "get process name error", th);
                return "";
            } finally {
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
            }
        }
    }

    public static boolean b(Context context, String str) {
        try {
            int intValue = Integer.valueOf(str).intValue();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == intValue) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            w63.c(Constants.TAG, "Process exist judge error", th);
            return true;
        }
    }
}
