package tb;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class av1 {
    private static String a;

    public static String a() {
        Context a2 = uu1.d().a();
        if (TextUtils.isEmpty(a)) {
            String c = c();
            if (TextUtils.isEmpty(c) && a2 != null) {
                c = b(a2);
            }
            a = c;
        }
        return a;
    }

    private static String b(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return null;
        }
        String str = a;
        if (str != null) {
            return str;
        }
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return null;
        }
        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.RunningAppProcessInfo next = it.next();
            if (next != null && next.pid == myPid) {
                a = next.processName;
                break;
            }
        }
        return a;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String c() {
        /*
            int r0 = android.os.Process.myPid()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "/proc/"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = "/cmdline"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]
            r2 = 0
            r3 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L3b
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L3b
            int r0 = r4.read(r1)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L32
            r4.close()     // Catch: java.lang.Exception -> L2d
            goto L42
        L2d:
            goto L42
        L2f:
            r0 = move-exception
            r3 = r4
            goto L35
        L32:
            goto L3c
        L34:
            r0 = move-exception
        L35:
            if (r3 == 0) goto L3a
            r3.close()     // Catch: java.lang.Exception -> L3a
        L3a:
            throw r0
        L3b:
            r4 = r3
        L3c:
            if (r4 == 0) goto L41
            r4.close()     // Catch: java.lang.Exception -> L41
        L41:
            r0 = 0
        L42:
            if (r0 <= 0) goto L4d
            java.lang.String r3 = new java.lang.String
            r3.<init>(r1, r2, r0)
            java.lang.String r3 = r3.trim()
        L4d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.av1.c():java.lang.String");
    }
}
