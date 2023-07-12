package com.alibaba.wireless.security.framework.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import com.youku.arch.solid.monitor.SolidMonitor;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import tv.cjump.jni.DeviceUtils;

/* compiled from: Taobao */
/* renamed from: com.alibaba.wireless.security.framework.utils.e */
/* loaded from: classes8.dex */
public class C4017e {
    private static String[] a = {"armeabi", "armeabi-v7a", DeviceUtils.ABI_X86, "arm64-v8a", "x86_64"};
    private static boolean b = true;
    private static boolean c = false;
    private static boolean d = true;
    private static boolean e = false;
    private static boolean f = true;
    private static boolean g;

    public static String a(Context context) {
        try {
            int myPid = Process.myPid();
            if (context != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        String str = runningAppProcessInfo.processName;
                        return str != null ? str : "";
                    }
                }
                return "";
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(ClassLoader classLoader, String str) {
        if (classLoader == null || str == null || "".equals(str)) {
            return null;
        }
        String a2 = a(classLoader, str, true);
        return a2 == null ? a(classLoader, str, false) : a2;
    }

    private static String a(ClassLoader classLoader, String str, boolean z) {
        if (classLoader != null) {
            try {
                Method method = z ? classLoader.getClass().getMethod("findLibrary", String.class) : classLoader.getClass().getDeclaredMethod("findLibrary", String.class);
                if (method != null) {
                    if (!method.isAccessible()) {
                        method.setAccessible(true);
                    }
                    Object invoke = method.invoke(classLoader, str);
                    if (invoke != null && (invoke instanceof String)) {
                        return (String) invoke;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean a(String str, String str2, File file) {
        boolean z;
        ZipFile zipFile;
        String[] strArr;
        boolean z2 = false;
        z2 = false;
        ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new ZipFile(str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e = e2;
        }
        try {
            try {
                z = false;
                for (String str3 : a) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append(SolidMonitor.CHECK_TYPE_LIB);
                        String str4 = File.separator;
                        sb.append(str4);
                        sb.append(str3);
                        sb.append(str4);
                        sb.append(str2);
                        ZipEntry entry = zipFile.getEntry(sb.toString());
                        if (entry != null && entry.getSize() != 0 && C4012a.a(entry.getName())) {
                            z = a(zipFile, entry, file);
                        }
                    } catch (IOException e3) {
                        e = e3;
                        z2 = z;
                        zipFile2 = zipFile;
                        FLOG.w("", e);
                        if (zipFile2 != null) {
                            z = z2;
                            zipFile = zipFile2;
                            zipFile.close();
                            return z;
                        }
                        return z2;
                    }
                }
            } catch (IOException e4) {
                e = e4;
            }
            try {
                zipFile.close();
            } catch (IOException unused) {
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.io.FileOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.util.zip.ZipFile r9, java.util.zip.ZipEntry r10, java.io.File r11) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.utils.C4017e.a(java.util.zip.ZipFile, java.util.zip.ZipEntry, java.io.File):boolean");
    }

    public static boolean b(Context context) {
        if (f) {
            try {
                String a2 = a(context);
                String packageName = context.getPackageName();
                if ("com.ali.money.shield".equals(packageName)) {
                    packageName = packageName + ":fore";
                }
                g = a2.equals(packageName);
                f = false;
            } catch (Exception unused) {
            }
        }
        return g;
    }

    public static boolean c(Context context) {
        boolean z;
        PackageInfo packageInfo;
        if (b) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (Throwable unused) {
            }
            if (packageInfo != null) {
                int i = packageInfo.applicationInfo.flags;
                if ((i & 1) != 0 && (i & 128) == 0) {
                    z = true;
                    c = z;
                    b = false;
                }
            }
            z = false;
            c = z;
            b = false;
        }
        return c;
    }

    public static boolean d(Context context) {
        boolean z;
        PackageInfo packageInfo;
        if (d) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (Throwable unused) {
            }
            if (packageInfo != null) {
                if ((packageInfo.applicationInfo.flags & 128) != 0) {
                    z = true;
                    e = z;
                    d = false;
                }
            }
            z = false;
            e = z;
            d = false;
        }
        return e;
    }
}
