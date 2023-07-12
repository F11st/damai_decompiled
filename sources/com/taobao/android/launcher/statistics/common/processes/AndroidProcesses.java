package com.taobao.android.launcher.statistics.common.processes;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import android.util.Log;
import com.taobao.android.launcher.statistics.common.processes.AndroidAppProcess;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AndroidProcesses {
    private static final int AID_READPROC = 3009;
    public static final String TAG = "AndroidProcesses";
    private static boolean loggingEnabled;

    AndroidProcesses() {
        throw new AssertionError("no instances");
    }

    public static List<AndroidAppProcess> getRunningAppProcesses() {
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        for (File file : new File("/proc").listFiles()) {
            if (file.isDirectory()) {
                try {
                    int parseInt = Integer.parseInt(file.getName());
                    try {
                        arrayList.add(new AndroidAppProcess(parseInt));
                    } catch (IOException e) {
                        log(e, "Error reading from /proc/%d.", Integer.valueOf(parseInt));
                    }
                } catch (AndroidAppProcess.NotAndroidAppProcessException | NumberFormatException unused) {
                }
            }
        }
        return arrayList;
    }

    public static List<AndroidAppProcess> getRunningForegroundApps(Context context) {
        int i;
        ArrayList arrayList = new ArrayList();
        File[] listFiles = new File("/proc").listFiles();
        PackageManager packageManager = context.getPackageManager();
        for (File file : listFiles) {
            if (file.isDirectory()) {
                try {
                    int parseInt = Integer.parseInt(file.getName());
                    try {
                        AndroidAppProcess androidAppProcess = new AndroidAppProcess(parseInt);
                        if (androidAppProcess.foreground && (((i = androidAppProcess.uid) < 1000 || i > 9999) && !androidAppProcess.name.contains(":") && packageManager.getLaunchIntentForPackage(androidAppProcess.getPackageName()) != null)) {
                            arrayList.add(androidAppProcess);
                        }
                    } catch (IOException e) {
                        log(e, "Error reading from /proc/%d.", Integer.valueOf(parseInt));
                    }
                } catch (AndroidAppProcess.NotAndroidAppProcessException | NumberFormatException unused) {
                }
            }
        }
        return arrayList;
    }

    public static List<AndroidProcess> getRunningProcesses() {
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        for (File file : new File("/proc").listFiles()) {
            if (file.isDirectory()) {
                try {
                    int parseInt = Integer.parseInt(file.getName());
                    try {
                        arrayList.add(new AndroidProcess(parseInt));
                    } catch (IOException e) {
                        log(e, "Error reading from /proc/%d.", Integer.valueOf(parseInt));
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        return arrayList;
    }

    public static boolean isLoggingEnabled() {
        return loggingEnabled;
    }

    public static boolean isMyProcessInTheForeground() {
        try {
            return new AndroidAppProcess(Process.myPid()).foreground;
        } catch (Exception e) {
            log(e, "Error finding our own process", new Object[0]);
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
        if (r2[3].contains("hidepid=1") != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:
        if (r2[3].contains("hidepid=2") == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003e, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
        r3.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0066 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isProcessInfoHidden() {
        /*
            r0 = 0
            r1 = 1
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50
            java.lang.String r5 = "/proc/mounts"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50
        Lf:
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4c
            if (r2 == 0) goto L43
            java.lang.String r4 = "\\s+"
            java.lang.String[] r2 = r2.split(r4)     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4c
            int r4 = r2.length     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4c
            r5 = 6
            if (r4 != r5) goto Lf
            r4 = r2[r1]     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4c
            java.lang.String r5 = "/proc"
            boolean r4 = r4.equals(r5)     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4c
            if (r4 == 0) goto Lf
            r4 = 3
            r5 = r2[r4]     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4c
            java.lang.String r6 = "hidepid=1"
            boolean r5 = r5.contains(r6)     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4c
            if (r5 != 0) goto L3e
            r2 = r2[r4]     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4c
            java.lang.String r4 = "hidepid=2"
            boolean r2 = r2.contains(r4)     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4c
            if (r2 == 0) goto L3f
        L3e:
            r0 = 1
        L3f:
            r3.close()     // Catch: java.io.IOException -> L42
        L42:
            return r0
        L43:
            r3.close()     // Catch: java.io.IOException -> L47
            goto L5c
        L47:
            goto L5c
        L49:
            r0 = move-exception
            r2 = r3
            goto L68
        L4c:
            r2 = r3
            goto L50
        L4e:
            r0 = move-exception
            goto L68
        L50:
            java.lang.String r3 = "AndroidProcesses"
            java.lang.String r4 = "Error reading /proc/mounts. Checking if UID 'readproc' exists."
            android.util.Log.d(r3, r4)     // Catch: java.lang.Throwable -> L4e
            if (r2 == 0) goto L5c
            r2.close()     // Catch: java.io.IOException -> L47
        L5c:
            java.lang.String r2 = "readproc"
            int r2 = android.os.Process.getUidForName(r2)
            r3 = 3009(0xbc1, float:4.217E-42)
            if (r2 != r3) goto L67
            r0 = 1
        L67:
            return r0
        L68:
            if (r2 == 0) goto L6d
            r2.close()     // Catch: java.io.IOException -> L6d
        L6d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.launcher.statistics.common.processes.AndroidProcesses.isProcessInfoHidden():boolean");
    }

    public static void log(String str, Object... objArr) {
        if (loggingEnabled) {
            if (objArr.length != 0) {
                str = String.format(str, objArr);
            }
            Log.d(TAG, str);
        }
    }

    public static void setLoggingEnabled(boolean z) {
        loggingEnabled = z;
    }

    public static void log(Throwable th, String str, Object... objArr) {
        if (loggingEnabled) {
            if (objArr.length != 0) {
                str = String.format(str, objArr);
            }
            Log.d(TAG, str, th);
        }
    }
}
