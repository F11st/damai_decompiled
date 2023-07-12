package com.alibaba.security.common.d;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.weex.annotation.JSMethod;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import tv.cjump.jni.DeviceUtils;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class p {
    private static final String A = "ro.build.uiversion";
    private static final String B = "ro.build.MiFavor_version";
    private static final String C = "ro.rom.version";
    private static final String D = "ro.build.rom.id";
    private static final String E = "unknown";
    private static final String a = "SystemUtils";
    private static final String v = "ro.build.version.emui";
    private static final String w = "ro.vivo.os.build.display.id";
    private static final String x = "ro.build.version.incremental";
    private static final String y = "ro.build.version.opporom";
    private static final String z = "ro.letv.release.version";
    private static final String[] b = {"huawei"};
    private static final String[] c = {"vivo"};
    private static final String[] d = {"xiaomi"};
    private static final String[] e = {"oppo"};
    private static final String[] f = {"leeco", "letv"};
    private static final String[] g = {"360", "qiku"};
    private static final String[] h = {"zte"};
    private static final String[] i = {"oneplus"};
    private static final String[] j = {"nubia"};
    private static final String[] k = {"coolpad", "yulong"};
    private static final String[] l = {"lg", "lge"};
    private static final String[] m = {"google"};
    private static final String[] n = {"samsung"};
    private static final String[] o = {"meizu"};
    private static final String[] p = {"lenovo"};
    private static final String[] q = {"smartisan"};
    private static final String[] r = {"htc"};
    private static final String[] s = {"sony"};
    private static final String[] t = {"gionee", "amigo"};
    private static final String[] u = {"motorola"};
    private static a F = null;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class a {
        String a;
        String b;

        public final String toString() {
            return "RomInfo{name=" + this.a + ", version=" + this.b + "}";
        }

        private String b() {
            return this.b;
        }

        private String a() {
            return this.a;
        }
    }

    private p() {
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0063: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:25:0x0063 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.lang.String r6) {
        /*
            java.lang.String r0 = "Exception while closing InputStream"
            java.lang.String r1 = "SystemUtils"
            r2 = 0
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.lang.String r4 = "getprop "
            java.lang.String r5 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.lang.String r4 = r4.concat(r5)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.lang.Process r3 = r3.exec(r4)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.io.InputStream r3 = r3.getInputStream()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            r3 = 1024(0x400, float:1.435E-42)
            r4.<init>(r5, r3)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.lang.String r3 = r4.readLine()     // Catch: java.io.IOException -> L3f java.lang.Throwable -> L62
            r4.close()     // Catch: java.io.IOException -> L3f java.lang.Throwable -> L62
            r4.close()     // Catch: java.io.IOException -> L32
            goto L3b
        L32:
            boolean r6 = com.alibaba.security.common.c.a.a()
            if (r6 == 0) goto L3b
            com.alibaba.security.common.c.a.c(r1, r0)
        L3b:
            return r3
        L3c:
            r6 = move-exception
            goto L64
        L3e:
            r4 = r2
        L3f:
            boolean r3 = com.alibaba.security.common.c.a.a()     // Catch: java.lang.Throwable -> L62
            if (r3 == 0) goto L52
            java.lang.String r3 = "Unable to read sysprop "
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> L62
            java.lang.String r6 = r3.concat(r6)     // Catch: java.lang.Throwable -> L62
            com.alibaba.security.common.c.a.c(r1, r6)     // Catch: java.lang.Throwable -> L62
        L52:
            if (r4 == 0) goto L61
            r4.close()     // Catch: java.io.IOException -> L58
            goto L61
        L58:
            boolean r6 = com.alibaba.security.common.c.a.a()
            if (r6 == 0) goto L61
            com.alibaba.security.common.c.a.c(r1, r0)
        L61:
            return r2
        L62:
            r6 = move-exception
            r2 = r4
        L64:
            if (r2 == 0) goto L73
            r2.close()     // Catch: java.io.IOException -> L6a
            goto L73
        L6a:
            boolean r2 = com.alibaba.security.common.c.a.a()
            if (r2 == 0) goto L73
            com.alibaba.security.common.c.a.c(r1, r0)
        L73:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.d.p.a(java.lang.String):java.lang.String");
    }

    public static boolean b() {
        return c[0].equals(x().a);
    }

    public static boolean c() {
        return d[0].equals(x().a);
    }

    public static boolean d() {
        return e[0].equals(x().a);
    }

    public static boolean e() {
        return o[0].equals(x().a);
    }

    public static boolean f() {
        String[] strArr;
        if (DeviceUtils.ABI_X86.equalsIgnoreCase(Build.getCPU_ABI()) || DeviceUtils.ABI_X86.equalsIgnoreCase(android.os.Build.CPU_ABI2)) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 21 && (strArr = android.os.Build.SUPPORTED_ABIS) != null) {
            for (String str : strArr) {
                if (str != null && str.toLowerCase().contains(DeviceUtils.ABI_X86)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x00c6 -> B:102:0x00c9). Please submit an issue!!! */
    public static boolean g() {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        String lowerCase;
        String[] split;
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream2);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                        try {
                            do {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine != null) {
                                        lowerCase = readLine.trim().toLowerCase();
                                    }
                                    break;
                                } catch (Exception unused) {
                                    fileInputStream = fileInputStream2;
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                    if (inputStreamReader != null) {
                                        try {
                                            inputStreamReader.close();
                                        } catch (IOException e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    return false;
                                } catch (Throwable th) {
                                    th = th;
                                    fileInputStream = fileInputStream2;
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    if (inputStreamReader != null) {
                                        try {
                                            inputStreamReader.close();
                                        } catch (IOException e5) {
                                            e5.printStackTrace();
                                        }
                                    }
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException e6) {
                                            e6.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            } while (!lowerCase.startsWith("features"));
                            break;
                            fileInputStream2.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                        for (String str : lowerCase.split(" ")) {
                            if (str.contains("neon") || "asimd".equals(str)) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e8) {
                                    e8.printStackTrace();
                                }
                                try {
                                    inputStreamReader.close();
                                } catch (IOException e9) {
                                    e9.printStackTrace();
                                }
                                try {
                                    bufferedReader.close();
                                    return true;
                                } catch (IOException e10) {
                                    e10.printStackTrace();
                                    return true;
                                }
                            }
                        }
                        try {
                            inputStreamReader.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                        bufferedReader.close();
                    } catch (Exception unused2) {
                        bufferedReader = null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = null;
                    }
                } catch (Exception unused3) {
                    inputStreamReader = null;
                    bufferedReader = null;
                } catch (Throwable th3) {
                    th = th3;
                    inputStreamReader = null;
                    bufferedReader = null;
                }
            } catch (Exception unused4) {
                inputStreamReader = null;
                bufferedReader = null;
            } catch (Throwable th4) {
                th = th4;
                inputStreamReader = null;
                bufferedReader = null;
            }
        } catch (IOException e12) {
            e12.printStackTrace();
        }
        return false;
    }

    public static String h() {
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = android.os.Build.SUPPORTED_ABIS;
            StringBuffer stringBuffer = new StringBuffer();
            if (strArr != null) {
                for (String str : strArr) {
                    stringBuffer.append(str);
                    stringBuffer.append(";");
                }
            }
            return stringBuffer.toString();
        }
        return com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getCPU_ABI();
    }

    public static long i() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 2048);
            String readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                bufferedReader.close();
                return 0L;
            }
            String substring = readLine.substring(readLine.indexOf("MemTotal:"));
            if (TextUtils.isEmpty(substring)) {
                bufferedReader.close();
                return 0L;
            }
            bufferedReader.close();
            return Long.parseLong(substring.replaceAll("\\D+", "")) * 1024;
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static boolean j() {
        return g[0].equals(x().a);
    }

    private static boolean k() {
        return h[0].equals(x().a);
    }

    private static boolean l() {
        return i[0].equals(x().a);
    }

    private static boolean m() {
        return j[0].equals(x().a);
    }

    private static boolean n() {
        return k[0].equals(x().a);
    }

    private static boolean o() {
        return l[0].equals(x().a);
    }

    private static boolean p() {
        return m[0].equals(x().a);
    }

    private static boolean q() {
        return n[0].equals(x().a);
    }

    private static boolean r() {
        return p[0].equals(x().a);
    }

    private static boolean s() {
        return q[0].equals(x().a);
    }

    private static boolean t() {
        return r[0].equals(x().a);
    }

    private static boolean u() {
        return s[0].equals(x().a);
    }

    private static boolean v() {
        return t[0].equals(x().a);
    }

    private static boolean w() {
        return u[0].equals(x().a);
    }

    private static a x() {
        a aVar = F;
        if (aVar != null) {
            return aVar;
        }
        F = new a();
        String z2 = z();
        String y2 = y();
        String[] strArr = b;
        if (a(z2, y2, strArr)) {
            F.a = strArr[0];
            String b2 = b("ro.build.version.emui");
            String[] split = b2.split(JSMethod.NOT_SET);
            if (split.length > 1) {
                F.b = split[1];
            } else {
                F.b = b2;
            }
            return F;
        }
        String[] strArr2 = c;
        if (a(z2, y2, strArr2)) {
            a aVar2 = F;
            aVar2.a = strArr2[0];
            aVar2.b = b(w);
            return F;
        }
        String[] strArr3 = d;
        if (a(z2, y2, strArr3)) {
            a aVar3 = F;
            aVar3.a = strArr3[0];
            aVar3.b = b(x);
            return F;
        }
        String[] strArr4 = e;
        if (a(z2, y2, strArr4)) {
            a aVar4 = F;
            aVar4.a = strArr4[0];
            aVar4.b = b(y);
            return F;
        }
        String[] strArr5 = f;
        if (a(z2, y2, strArr5)) {
            a aVar5 = F;
            aVar5.a = strArr5[0];
            aVar5.b = b(z);
            return F;
        }
        String[] strArr6 = g;
        if (a(z2, y2, strArr6)) {
            a aVar6 = F;
            aVar6.a = strArr6[0];
            aVar6.b = b(A);
            return F;
        }
        String[] strArr7 = h;
        if (a(z2, y2, strArr7)) {
            a aVar7 = F;
            aVar7.a = strArr7[0];
            aVar7.b = b(B);
            return F;
        }
        String[] strArr8 = i;
        if (a(z2, y2, strArr8)) {
            a aVar8 = F;
            aVar8.a = strArr8[0];
            aVar8.b = b(C);
            return F;
        }
        String[] strArr9 = j;
        if (a(z2, y2, strArr9)) {
            a aVar9 = F;
            aVar9.a = strArr9[0];
            aVar9.b = b(D);
            return F;
        }
        String[] strArr10 = k;
        if (a(z2, y2, strArr10)) {
            F.a = strArr10[0];
        } else {
            String[] strArr11 = l;
            if (a(z2, y2, strArr11)) {
                F.a = strArr11[0];
            } else {
                String[] strArr12 = m;
                if (a(z2, y2, strArr12)) {
                    F.a = strArr12[0];
                } else {
                    String[] strArr13 = n;
                    if (a(z2, y2, strArr13)) {
                        F.a = strArr13[0];
                    } else {
                        String[] strArr14 = o;
                        if (a(z2, y2, strArr14)) {
                            F.a = strArr14[0];
                        } else {
                            String[] strArr15 = p;
                            if (a(z2, y2, strArr15)) {
                                F.a = strArr15[0];
                            } else {
                                String[] strArr16 = q;
                                if (a(z2, y2, strArr16)) {
                                    F.a = strArr16[0];
                                } else {
                                    String[] strArr17 = r;
                                    if (a(z2, y2, strArr17)) {
                                        F.a = strArr17[0];
                                    } else {
                                        String[] strArr18 = s;
                                        if (a(z2, y2, strArr18)) {
                                            F.a = strArr18[0];
                                        } else {
                                            String[] strArr19 = t;
                                            if (a(z2, y2, strArr19)) {
                                                F.a = strArr19[0];
                                            } else {
                                                String[] strArr20 = u;
                                                if (a(z2, y2, strArr20)) {
                                                    F.a = strArr20[0];
                                                } else {
                                                    F.a = y2;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        F.b = b("");
        return F;
    }

    private static String y() {
        try {
            String manufacturer = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER();
            return !TextUtils.isEmpty(manufacturer) ? manufacturer.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    private static String z() {
        try {
            String brand = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND();
            return !TextUtils.isEmpty(brand) ? brand.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    private static String b(String str) {
        String a2 = !TextUtils.isEmpty(str) ? a(str) : "";
        if (TextUtils.isEmpty(a2) || a2.equals("unknown")) {
            try {
                String str2 = android.os.Build.DISPLAY;
                if (!TextUtils.isEmpty(str2)) {
                    a2 = str2.toLowerCase();
                }
            } catch (Throwable unused) {
            }
        }
        return TextUtils.isEmpty(a2) ? "unknown" : a2;
    }

    public static boolean a() {
        return b[0].equals(x().a);
    }

    private static boolean a(String str, String str2, String... strArr) {
        for (String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }

    public static long a(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return 0L;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }
}
