package com.uc.crashsdk;

import android.util.SparseArray;
import com.uc.crashsdk.a.h;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class f {
    static final /* synthetic */ boolean a = true;
    private static final Object b = new Object();
    private static final SparseArray<String> c = new SparseArray<>();
    private static final Object d = new Object();
    private static boolean e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i) {
        a(i, 1);
    }

    private static boolean b(int i, int i2) {
        try {
            b.x();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        try {
            String c2 = c(i);
            if (c2 == null) {
                com.uc.crashsdk.a.a.a("crashsdk", "Stat type not exists: " + i, null);
                return false;
            }
            File file = new File(b.c());
            if (!file.exists()) {
                file.createNewFile();
            }
            StringBuffer a2 = a(file);
            if (com.uc.crashsdk.a.g.a(a2)) {
                if (a2 == null) {
                    a2 = new StringBuffer();
                }
                a2.append(jn1.ARRAY_START_STR);
                a2.append(e.h());
                a2.append("]\n");
            }
            a(a2, c2, a(a2, c2) + i2);
            return a(file, a2);
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            return false;
        }
    }

    private static boolean c(String str) {
        if (!com.uc.crashsdk.a.g.a(str) && new File(str).exists()) {
            return a(str, new com.uc.crashsdk.a.e(755, new Object[]{str}));
        }
        return false;
    }

    private static boolean d(String str) {
        if (a || str != null) {
            File file = new File(str);
            StringBuffer a2 = a(file);
            if (com.uc.crashsdk.a.g.a(a2)) {
                return false;
            }
            String a3 = a(a2);
            StringBuffer stringBuffer = null;
            if (a3 != null && a3.length() > 0) {
                SparseArray<String> e2 = e();
                boolean M = g.M();
                if (M) {
                    stringBuffer = new StringBuffer();
                    stringBuffer.append("notifyStatsDetailImpl: processName: ");
                    stringBuffer.append(a3 + StringUtils.LF);
                }
                boolean z = false;
                for (int i = 0; i < e2.size(); i++) {
                    try {
                        int keyAt = e2.keyAt(i);
                        String str2 = e2.get(keyAt);
                        int a4 = a(a2, str2);
                        if (a4 > 0) {
                            if (M) {
                                stringBuffer.append("name: ");
                                stringBuffer.append(str2);
                                stringBuffer.append(", key: ");
                                stringBuffer.append(keyAt);
                                stringBuffer.append(", count: ");
                                stringBuffer.append(a4);
                                stringBuffer.append(StringUtils.LF);
                            }
                            d.a(a3, keyAt, a4);
                            a(a2, str2, 0);
                            z = true;
                        }
                    } finally {
                        if (z) {
                            a(file, a2);
                        }
                    }
                }
                if (M) {
                    com.uc.crashsdk.a.a.a(stringBuffer.toString());
                }
                if (z) {
                    d.a(a3, 1000000, 0);
                }
                return z;
            }
            com.uc.crashsdk.a.a.a("crashsdk", "notifyStatsDetailImpl: process name is invalid", null);
            return false;
        }
        throw new AssertionError();
    }

    private static boolean e(String str) {
        if (!com.uc.crashsdk.a.g.a(str) && new File(str).exists()) {
            return a(str, new com.uc.crashsdk.a.e(756, new Object[]{str}));
        }
        return false;
    }

    private static void f() {
        SparseArray<String> sparseArray = c;
        synchronized (sparseArray) {
            if (sparseArray.size() != 0) {
                return;
            }
            sparseArray.put(100, "start_pv");
            sparseArray.put(102, "start_hpv");
            sparseArray.put(1, "all_all");
            sparseArray.put(2, "all_fg");
            sparseArray.put(101, "all_bg");
            sparseArray.put(3, "java_fg");
            sparseArray.put(4, "java_bg");
            sparseArray.put(7, "native_fg");
            sparseArray.put(8, "native_bg");
            sparseArray.put(27, "native_anr_fg");
            sparseArray.put(28, "native_anr_bg");
            sparseArray.put(9, "native_ok");
            sparseArray.put(10, "unexp_anr");
            sparseArray.put(29, "unexp_lowmem");
            sparseArray.put(30, "unexp_killed");
            sparseArray.put(31, "unexp_exit");
            sparseArray.put(32, "unexp_restart");
            sparseArray.put(11, "unexp_fg");
            sparseArray.put(12, "unexp_bg");
            sparseArray.put(40, "anr_fg");
            sparseArray.put(41, "anr_bg");
            sparseArray.put(42, "anr_cr_fg");
            sparseArray.put(43, "anr_cr_bg");
            sparseArray.put(13, "log_up_succ");
            sparseArray.put(14, "log_up_fail");
            sparseArray.put(15, "log_empty");
            sparseArray.put(200, "log_tmp");
            sparseArray.put(16, "log_abd_all");
            sparseArray.put(22, "log_abd_builtin");
            sparseArray.put(23, "log_abd_custom");
            sparseArray.put(17, "log_large");
            sparseArray.put(18, "log_up_all");
            sparseArray.put(19, "log_up_bytes");
            sparseArray.put(20, "log_up_crash");
            sparseArray.put(21, "log_up_custom");
            sparseArray.put(24, "log_zipped");
            sparseArray.put(201, "log_enced");
            sparseArray.put(25, "log_renamed");
            sparseArray.put(26, "log_safe_skip");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i, int i2) {
        if (i2 == 0) {
            com.uc.crashsdk.a.a.b("Add stat for type " + i + " with count 0!");
            return;
        }
        a(b.c(), new com.uc.crashsdk.a.e(751, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    private static String c(int i) {
        String str;
        f();
        SparseArray<String> sparseArray = c;
        synchronized (sparseArray) {
            str = sparseArray.get(i);
        }
        return str;
    }

    private static SparseArray<String> e() {
        SparseArray<String> clone;
        f();
        SparseArray<String> sparseArray = c;
        synchronized (sparseArray) {
            clone = sparseArray.clone();
        }
        return clone;
    }

    private static StringBuffer a(File file) {
        FileReader fileReader = null;
        if (!file.exists()) {
            return null;
        }
        char[] d2 = d();
        if (d2 == null) {
            com.uc.crashsdk.a.a.a("crashsdk", "readCrashStatData alloc buffer failed!", null);
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                FileReader fileReader2 = new FileReader(file);
                try {
                    int read = fileReader2.read(d2);
                    if (read > 0) {
                        fileReader = null;
                        stringBuffer.append(d2, 0, read);
                    }
                    com.uc.crashsdk.a.g.a(fileReader2);
                } catch (Exception e2) {
                    e = e2;
                    fileReader = fileReader2;
                    com.uc.crashsdk.a.g.a(e);
                    com.uc.crashsdk.a.g.a(fileReader);
                    return stringBuffer;
                } catch (Throwable th) {
                    th = th;
                    fileReader = fileReader2;
                    com.uc.crashsdk.a.g.a(fileReader);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
            }
            return stringBuffer;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(boolean z) {
        if (g.O() && !b.L()) {
            e.j();
            if (!h.e()) {
                h.a(z);
            }
            if (b.F()) {
                d(z);
                a(b.c(), z);
                h.b(z);
            }
        }
    }

    private static String a(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return null;
        }
        int indexOf = stringBuffer.indexOf(jn1.ARRAY_START_STR);
        if (indexOf < 0) {
            com.uc.crashsdk.a.a.a("crashsdk", "getProcessName: Can not found process name start!", null);
            return null;
        }
        int i = indexOf + 1;
        int indexOf2 = stringBuffer.indexOf(jn1.ARRAY_END_STR, i);
        if (indexOf2 < 0) {
            com.uc.crashsdk.a.a.a("crashsdk", "getProcessName: Can not found process name end!", null);
            return null;
        }
        String substring = stringBuffer.substring(i, indexOf2);
        if (substring.length() <= 0) {
            com.uc.crashsdk.a.a.a("crashsdk", "getProcessName: process name is empty", null);
            return null;
        }
        return substring;
    }

    private static boolean b(String str) {
        StringBuffer stringBuffer;
        File file = new File(str);
        StringBuffer a2 = a(file);
        if (com.uc.crashsdk.a.g.a(a2)) {
            return false;
        }
        String a3 = a(a2);
        if (a3 != null && a3.length() > 0) {
            SparseArray<String> e2 = e();
            HashMap hashMap = new HashMap();
            boolean M = g.M();
            if (M) {
                stringBuffer = new StringBuffer();
                stringBuffer.append("reportCrashStatImpl: processName: ");
                stringBuffer.append(a3 + StringUtils.LF);
            } else {
                stringBuffer = null;
            }
            int i = 0;
            boolean z = false;
            while (i < e2.size()) {
                try {
                    int keyAt = e2.keyAt(i);
                    String str2 = e2.get(keyAt);
                    SparseArray<String> sparseArray = e2;
                    int a4 = a(a2, str2);
                    if (a4 > 0) {
                        if (M) {
                            stringBuffer.append("name: ");
                            stringBuffer.append(str2);
                            stringBuffer.append(", key: ");
                            stringBuffer.append(keyAt);
                            stringBuffer.append(", count: ");
                            stringBuffer.append(a4);
                            stringBuffer.append(StringUtils.LF);
                        }
                        h.a(a3, keyAt, a4);
                        hashMap.put(str2, Integer.valueOf(a4));
                        a(a2, str2, 0);
                        z = true;
                    }
                    i++;
                    e2 = sparseArray;
                } catch (Throwable th) {
                    if (z) {
                        a(file, a2);
                        if (hashMap.size() > 0) {
                            String a5 = b.a(str);
                            if (hashMap.size() > 0) {
                                if (com.uc.crashsdk.a.g.a(a3)) {
                                    com.uc.crashsdk.a.a.a("crashsdk", "cacheReportedStatsForCallback: processName is null", null);
                                } else if (com.uc.crashsdk.a.g.a(a5)) {
                                    com.uc.crashsdk.a.a.a("crashsdk", "cacheReportedStatsForCallback: callbackCacheFilePathName is null", null);
                                } else {
                                    a(a5, new com.uc.crashsdk.a.e(754, new Object[]{a3, hashMap, a5}));
                                }
                            }
                        }
                    }
                    throw th;
                }
            }
            if (M) {
                com.uc.crashsdk.a.a.a(stringBuffer.toString());
            }
            if (z) {
                a(file, a2);
                if (hashMap.size() > 0) {
                    String a6 = b.a(str);
                    if (hashMap.size() > 0) {
                        if (com.uc.crashsdk.a.g.a(a3)) {
                            com.uc.crashsdk.a.a.a("crashsdk", "cacheReportedStatsForCallback: processName is null", null);
                        } else if (com.uc.crashsdk.a.g.a(a6)) {
                            com.uc.crashsdk.a.a.a("crashsdk", "cacheReportedStatsForCallback: callbackCacheFilePathName is null", null);
                        } else {
                            a(a6, new com.uc.crashsdk.a.e(754, new Object[]{a3, hashMap, a6}));
                        }
                    }
                }
            }
            return true;
        }
        com.uc.crashsdk.a.a.a("crashsdk", "reportCrashStatImpl: process name is invalid", null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c() {
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(700), 3000L);
    }

    private static int a(StringBuffer stringBuffer, String str) {
        int indexOf = stringBuffer.indexOf(str);
        if (indexOf < 0) {
            return 0;
        }
        int indexOf2 = stringBuffer.indexOf("=", indexOf + str.length());
        if (indexOf2 < 0) {
            com.uc.crashsdk.a.a.b(str + " line not contain '='!");
            return 0;
        }
        int i = indexOf2 + 1;
        int indexOf3 = stringBuffer.indexOf(StringUtils.LF, i);
        if (indexOf3 < 0) {
            indexOf3 = stringBuffer.length();
        }
        try {
            int parseInt = Integer.parseInt(stringBuffer.substring(i, indexOf3));
            if (parseInt < 0) {
                return 0;
            }
            return parseInt;
        } catch (NumberFormatException e2) {
            com.uc.crashsdk.a.g.a(e2);
            return 0;
        }
    }

    private static char[] d() {
        char[] cArr = null;
        int i = 1024;
        while (cArr == null && i > 0) {
            try {
                cArr = new char[i];
            } catch (Throwable unused) {
                i /= 2;
                if (i < 512) {
                    break;
                }
            }
        }
        return cArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004a A[Catch: all -> 0x0056, TryCatch #0 {, blocks: (B:7:0x0008, B:9:0x000c, B:11:0x000e, B:13:0x0016, B:15:0x0018, B:17:0x0020, B:19:0x002a, B:27:0x004a, B:28:0x004d, B:29:0x0054, B:21:0x0031, B:23:0x0037, B:25:0x0042), top: B:34:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void d(boolean r3) {
        /*
            boolean r0 = com.uc.crashsdk.f.e
            if (r0 == 0) goto L5
            return
        L5:
            java.lang.Object r0 = com.uc.crashsdk.f.d
            monitor-enter(r0)
            boolean r1 = com.uc.crashsdk.f.e     // Catch: java.lang.Throwable -> L56
            if (r1 == 0) goto Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L56
            return
        Le:
            java.lang.String r1 = "crash detail"
            boolean r3 = com.uc.crashsdk.a.h.a(r3, r1)     // Catch: java.lang.Throwable -> L56
            if (r3 == 0) goto L18
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L56
            return
        L18:
            r3 = 0
            boolean r1 = com.uc.crashsdk.b.s()     // Catch: java.lang.Throwable -> L56
            r2 = 1
            if (r1 == 0) goto L31
            r3 = 2
            a(r3, r2)     // Catch: java.lang.Throwable -> L56
            boolean r3 = com.uc.crashsdk.b.r()     // Catch: java.lang.Throwable -> L56
            if (r3 == 0) goto L2f
            r3 = 42
            a(r3, r2)     // Catch: java.lang.Throwable -> L56
        L2f:
            r3 = 1
            goto L48
        L31:
            boolean r1 = com.uc.crashsdk.b.t()     // Catch: java.lang.Throwable -> L56
            if (r1 == 0) goto L48
            r3 = 101(0x65, float:1.42E-43)
            a(r3, r2)     // Catch: java.lang.Throwable -> L56
            boolean r3 = com.uc.crashsdk.b.r()     // Catch: java.lang.Throwable -> L56
            if (r3 == 0) goto L2f
            r3 = 43
            a(r3, r2)     // Catch: java.lang.Throwable -> L56
            goto L2f
        L48:
            if (r3 == 0) goto L4d
            a(r2, r2)     // Catch: java.lang.Throwable -> L56
        L4d:
            r3 = 100
            a(r3, r2)     // Catch: java.lang.Throwable -> L56
            com.uc.crashsdk.f.e = r2     // Catch: java.lang.Throwable -> L56
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L56
            return
        L56:
            r3 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L56
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.d(boolean):void");
    }

    private static void a(StringBuffer stringBuffer, String str, int i) {
        int indexOf = stringBuffer.indexOf(str);
        if (indexOf < 0) {
            if (i > 0) {
                stringBuffer.append(str);
                stringBuffer.append("=");
                stringBuffer.append(i);
                stringBuffer.append(StringUtils.LF);
                return;
            }
            return;
        }
        int indexOf2 = stringBuffer.indexOf(StringUtils.LF, indexOf);
        if (indexOf2 < 0) {
            indexOf2 = stringBuffer.length();
        }
        stringBuffer.replace(indexOf, indexOf2, str + "=" + String.valueOf(i));
    }

    private static boolean a(File file, StringBuffer stringBuffer) {
        FileWriter fileWriter = null;
        try {
            try {
                FileWriter fileWriter2 = new FileWriter(file);
                try {
                    String stringBuffer2 = stringBuffer.toString();
                    fileWriter2.write(stringBuffer2, 0, stringBuffer2.length());
                    com.uc.crashsdk.a.g.a(fileWriter2);
                    return true;
                } catch (Exception e2) {
                    e = e2;
                    fileWriter = fileWriter2;
                    com.uc.crashsdk.a.g.a(e);
                    com.uc.crashsdk.a.g.a(fileWriter);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    com.uc.crashsdk.a.g.a(fileWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    private static void a(String str, HashMap<String, Integer> hashMap, String str2) {
        try {
            b.x();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        try {
            File file = new File(str2);
            if (!file.exists()) {
                file.createNewFile();
            }
            StringBuffer a2 = a(file);
            if (com.uc.crashsdk.a.g.a(a2)) {
                if (a2 == null) {
                    a2 = new StringBuffer();
                }
                a2.append(jn1.ARRAY_START_STR);
                a2.append(str);
                a2.append("]\n");
            }
            boolean z = false;
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                int intValue = entry.getValue().intValue();
                if (intValue > 0) {
                    String key = entry.getKey();
                    a(a2, key, intValue + a(a2, key));
                    z = true;
                }
            }
            if (z) {
                a(file, a2);
            }
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(boolean z) {
        if (z) {
            return e(b.e()) ? 1 : 0;
        }
        File[] f = b.f();
        if (f != null) {
            int i = 0;
            for (File file : f) {
                if (e(file.getAbsolutePath())) {
                    i++;
                }
            }
            return i;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b() {
        File[] d2 = b.d();
        if (d2 != null) {
            int i = 0;
            for (File file : d2) {
                if (a(file.getAbsolutePath())) {
                    i++;
                }
            }
            return i;
        }
        return 0;
    }

    public static void b(int i) {
        if (i != 700) {
            return;
        }
        d(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(boolean z) {
        if (z) {
            return c(b.e()) ? 1 : 0;
        }
        File[] f = b.f();
        if (f != null) {
            int i = 0;
            for (File file : f) {
                if (c(file.getAbsolutePath())) {
                    i++;
                }
            }
            return i;
        }
        return 0;
    }

    private static boolean a(String str, com.uc.crashsdk.a.e eVar) {
        return b.a(b, str, eVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(String str, boolean z) {
        if (h.a(z, "crash detail report")) {
            return false;
        }
        return a(str, new com.uc.crashsdk.a.e(752, new Object[]{str}));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a() {
        File[] d2 = b.d();
        if (d2 != null) {
            int i = 0;
            for (File file : d2) {
                if (a(file.getAbsolutePath(), false)) {
                    i++;
                }
            }
            return i;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(String str) {
        return a(str, new com.uc.crashsdk.a.e(753, new Object[]{str}));
    }

    public static boolean a(int i, Object[] objArr) {
        switch (i) {
            case 751:
                if (a || objArr != null) {
                    return b(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                }
                throw new AssertionError();
            case 752:
                if (a || objArr != null) {
                    return b((String) objArr[0]);
                }
                throw new AssertionError();
            case 753:
                if (a || objArr != null) {
                    File file = new File((String) objArr[0]);
                    if (file.exists()) {
                        file.delete();
                        return true;
                    }
                    return false;
                }
                throw new AssertionError();
            case 754:
                if (a || objArr != null) {
                    a((String) objArr[0], (HashMap) objArr[1], (String) objArr[2]);
                    return true;
                }
                throw new AssertionError();
            case 755:
                if (a || objArr != null) {
                    return d((String) objArr[0]);
                }
                throw new AssertionError();
            case 756:
                if (a || objArr != null) {
                    File file2 = new File((String) objArr[0]);
                    if (file2.exists()) {
                        file2.delete();
                        return true;
                    }
                    return false;
                }
                throw new AssertionError();
            default:
                return false;
        }
    }
}
