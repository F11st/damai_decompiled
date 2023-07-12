package com.uc.crashsdk;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.taobao.windvane.util.ConfigStorage;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.alibaba.aliweex.adapter.module.audio.IWXAudio;
import com.alibaba.wireless.security.SecExceptionCode;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.uc.crashsdk.a.C7134a;
import com.uc.crashsdk.a.C7139f;
import com.uc.crashsdk.a.C7140g;
import com.uc.crashsdk.a.C7141h;
import com.uc.crashsdk.a.RunnableC7138e;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: Taobao */
/* renamed from: com.uc.crashsdk.b */
/* loaded from: classes11.dex */
public class C7143b {
    private static boolean A = false;
    private static boolean B = false;
    private static boolean C = false;
    private static boolean D = false;
    private static boolean E = false;
    private static boolean F = false;
    private static String H = null;
    private static int I = 0;
    private static boolean J = false;
    private static boolean K = false;
    private static boolean L = true;
    private static RandomAccessFile M = null;
    private static boolean N = false;
    private static String P = null;
    private static boolean Q = false;
    private static volatile Object[] R = null;
    public static boolean a = false;
    public static boolean b = false;
    public static boolean c = false;
    public static boolean d = false;
    public static boolean f = false;
    public static boolean g = true;
    public static boolean h = false;
    static final /* synthetic */ boolean i = true;
    private static String j;
    private static String k;
    private static String l;
    private static String m;
    private static String n;
    private static String o;
    private static String p;
    private static String q;
    private static String r;
    private static String s;
    private static String t;
    private static String u;
    private static String v;
    private static String w;
    private static boolean x;
    private static boolean y;
    private static volatile boolean z;
    public static final Object e = new Object();
    private static final Object G = new Object();
    private static final Object O = new Object();
    private static Runnable S = new RunnableC7138e(101);
    private static boolean T = false;
    private static long U = 0;
    private static final Object V = new Object();
    private static long W = 0;
    private static boolean X = false;
    private static boolean Y = false;
    private static boolean Z = false;
    private static long aa = 0;
    private static final WeakHashMap<Activity, Integer> ab = new WeakHashMap<>();
    private static boolean ac = false;
    private static String ad = null;
    private static boolean ae = false;
    private static boolean af = false;
    private static boolean ag = false;
    private static boolean ah = false;
    private static boolean ai = false;
    private static final Object aj = new Object();
    private static PendingIntent ak = null;

    public static boolean A() {
        return Y || !ad();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean B() {
        return Y && !x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void C() {
        C7139f.a(2, new RunnableC7138e(100));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void D() {
        String str;
        if (!d || (str = ad) == null) {
            return;
        }
        JNIBridge.set((int) SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String E() {
        String str = ad;
        return str == null ? "" : str;
    }

    public static boolean F() {
        if (!ae) {
            if (!C7140g.a(C7133a.a) && C7133a.a.equals(C7146e.h())) {
                af = true;
                if (d) {
                    JNIBridge.set(2, true);
                }
            }
            ae = true;
        }
        return af;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void G() {
        ag = true;
        if (d) {
            JNIBridge.set(34, true);
        }
    }

    public static boolean H() {
        return ag;
    }

    public static int I() {
        boolean U2 = U();
        return t() ? U2 ? 3 : 6 : s() ? U2 ? 2 : 5 : U2 ? 4 : 1;
    }

    public static int J() {
        boolean V2 = V();
        boolean W2 = W();
        boolean X2 = X();
        if (t()) {
            if (V2) {
                return 12;
            }
            if (W2) {
                return 14;
            }
            return X2 ? 16 : 98;
        } else if (s()) {
            if (V2) {
                return 11;
            }
            if (W2) {
                return 13;
            }
            return X2 ? 15 : 97;
        } else {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void K() {
        if (d) {
            JNIBridge.nativeSet(27, I, "12", null);
            JNIBridge.set(30, L);
        }
    }

    public static boolean L() {
        if (!ai) {
            synchronized (aj) {
                if (!ai) {
                    ah = ae();
                    ai = true;
                }
            }
        }
        return ah;
    }

    public static void M() {
        if (C7146e.F() || L() || ak != null || C7152g.h() < 0) {
            return;
        }
        try {
            Context a2 = C7140g.a();
            Intent launchIntentForPackage = a2.getPackageManager().getLaunchIntentForPackage(a2.getPackageName());
            launchIntentForPackage.addFlags(335544320);
            ak = PendingIntent.getActivity(a2, 0, launchIntentForPackage, 0);
        } catch (Throwable th) {
            C7140g.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean N() {
        if (ak == null) {
            C7134a.b("Restart intent is null!");
            return false;
        }
        try {
            C7134a.a("crashsdk", "restarting ...");
            ((AlarmManager) C7140g.a().getSystemService(NotificationCompat.CATEGORY_ALARM)).set(1, System.currentTimeMillis() + 200, ak);
            return true;
        } catch (Throwable th) {
            C7140g.a(th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean O() {
        ac = true;
        return true;
    }

    private static String Q() {
        if (j == null) {
            j = d("ss");
        }
        return j;
    }

    private static String R() {
        if (l == null) {
            l = d("ctn");
        }
        return l;
    }

    private static String S() {
        if (m == null) {
            m = d("cta");
        }
        return m;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0070 A[Catch: all -> 0x0074, TRY_LEAVE, TryCatch #1 {, blocks: (B:9:0x000c, B:11:0x0010, B:13:0x0012, B:19:0x0056, B:21:0x005a, B:23:0x005e, B:25:0x0062, B:32:0x0078, B:33:0x007a, B:26:0x006a, B:28:0x0070), top: B:39:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void T() {
        /*
            boolean r0 = com.uc.crashsdk.C7143b.z
            if (r0 != 0) goto L7f
            boolean r0 = com.uc.crashsdk.C7143b.y
            if (r0 == 0) goto L9
            goto L7f
        L9:
            java.lang.Object r0 = com.uc.crashsdk.C7143b.G
            monitor-enter(r0)
            boolean r1 = com.uc.crashsdk.C7143b.z     // Catch: java.lang.Throwable -> L7c
            if (r1 == 0) goto L12
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7c
            return
        L12:
            java.lang.String r1 = com.uc.crashsdk.C7152g.U()     // Catch: java.lang.Throwable -> L7c
            f(r1)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r1 = p()     // Catch: java.lang.Throwable -> L7c
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L7c
            java.lang.String r3 = b()     // Catch: java.lang.Throwable -> L7c
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L7c
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L7c
            java.lang.String r4 = R()     // Catch: java.lang.Throwable -> L7c
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r4 = "f"
            boolean r4 = r4.equals(r1)     // Catch: java.lang.Throwable -> L7c
            com.uc.crashsdk.C7143b.A = r4     // Catch: java.lang.Throwable -> L7c
            java.lang.String r4 = "b"
            boolean r1 = r4.equals(r1)     // Catch: java.lang.Throwable -> L7c
            com.uc.crashsdk.C7143b.B = r1     // Catch: java.lang.Throwable -> L7c
            boolean r1 = r2.exists()     // Catch: java.lang.Throwable -> L7c
            com.uc.crashsdk.C7143b.D = r1     // Catch: java.lang.Throwable -> L7c
            boolean r1 = r3.exists()     // Catch: java.lang.Throwable -> L7c
            com.uc.crashsdk.C7143b.E = r1     // Catch: java.lang.Throwable -> L7c
            boolean r2 = com.uc.crashsdk.C7143b.D     // Catch: java.lang.Throwable -> L7c
            r3 = 1
            if (r2 != 0) goto L55
            if (r1 == 0) goto L53
            goto L55
        L53:
            r1 = 0
            goto L56
        L55:
            r1 = 1
        L56:
            com.uc.crashsdk.C7143b.C = r1     // Catch: java.lang.Throwable -> L7c
            if (r1 != 0) goto L6a
            boolean r1 = com.uc.crashsdk.C7143b.A     // Catch: java.lang.Throwable -> L7c
            if (r1 != 0) goto L62
            boolean r1 = com.uc.crashsdk.C7143b.B     // Catch: java.lang.Throwable -> L7c
            if (r1 == 0) goto L6a
        L62:
            boolean r1 = r()     // Catch: java.lang.Throwable -> L7c
            com.uc.crashsdk.C7143b.F = r1     // Catch: java.lang.Throwable -> L7c
            com.uc.crashsdk.C7143b.C = r1     // Catch: java.lang.Throwable -> L7c
        L6a:
            boolean r1 = z()     // Catch: java.lang.Throwable -> L74
            if (r1 == 0) goto L78
            Z()     // Catch: java.lang.Throwable -> L74
            goto L78
        L74:
            r1 = move-exception
            com.uc.crashsdk.a.C7140g.a(r1)     // Catch: java.lang.Throwable -> L7c
        L78:
            com.uc.crashsdk.C7143b.z = r3     // Catch: java.lang.Throwable -> L7c
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7c
            return
        L7c:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7c
            throw r1
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.C7143b.T():void");
    }

    private static boolean U() {
        T();
        return C;
    }

    private static boolean V() {
        T();
        return D;
    }

    private static boolean W() {
        T();
        return E;
    }

    private static boolean X() {
        T();
        return F;
    }

    private static void Y() {
        if (d) {
            JNIBridge.set(26, x);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0041 -> B:29:0x0044). Please submit an issue!!! */
    private static void Z() {
        if (!T) {
            T = true;
            try {
                new File(b()).delete();
            } catch (Throwable th) {
                C7140g.a(th);
            }
            try {
                new File(R()).delete();
            } catch (Throwable th2) {
                C7140g.a(th2);
            }
            try {
                if (d) {
                    JNIBridge.cmd(16);
                } else {
                    new File(S()).delete();
                }
            } catch (Throwable th3) {
                C7140g.a(th3);
            }
        }
        Object[] ab2 = ab();
        if (!ab2[0].equals(P) && R == null) {
            a(ab2);
            return;
        }
        Q = true;
        aa();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        String str = H;
        if (str != null) {
            return str;
        }
        String h2 = C7146e.h();
        if (C7140g.a(h2)) {
            H = "LLUN";
        } else {
            int i2 = 0;
            if (h2.length() > 48) {
                h2 = h2.substring(0, 48);
                i2 = h2.length() - 48;
            }
            StringBuilder sb = new StringBuilder();
            byte[] bytes = h2.getBytes();
            for (int length = bytes.length - 1; length >= 0; length--) {
                byte b2 = bytes[length];
                if (b2 == 46) {
                    sb.append(YKUpsConvert.CHAR_ZERO);
                } else if (b2 == 58) {
                    sb.append('1');
                } else if (b2 >= 97 && b2 <= 122) {
                    sb.append((char) ((b2 + 65) - 97));
                } else if (b2 >= 65 && b2 <= 90) {
                    sb.append((char) b2);
                } else if (b2 >= 48 && b2 <= 57) {
                    sb.append((char) b2);
                } else {
                    sb.append('2');
                }
            }
            if (i2 > 0) {
                sb.append(String.valueOf(i2));
            }
            H = sb.toString();
        }
        return H;
    }

    private static void aa() {
        if (!C7139f.b(S)) {
            C7139f.a(1, S);
            return;
        }
        Object[] objArr = R;
        if (objArr == null || !ab()[0].equals(objArr[0])) {
            C7139f.a(S);
            C7139f.a(1, S);
        }
    }

    private static Object[] ab() {
        synchronized (V) {
            long j2 = W + 1;
            W = j2;
            if (x) {
                return new Object[]{"e", Long.valueOf(j2)};
            } else if (B()) {
                return new Object[]{"f", Long.valueOf(W)};
            } else {
                return new Object[]{"b", Long.valueOf(W)};
            }
        }
    }

    private static Object ac() {
        Object a2;
        Object a3 = a((Application) C7140g.a(), Application.class, "mLoadedApk");
        if (a3 == null || (a2 = a(a3, (Class<?>) null, "mActivityThread")) == null) {
            try {
                Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentActivityThread", new Class[0]);
                if (declaredMethod != null) {
                    declaredMethod.setAccessible(true);
                    return declaredMethod.invoke(null, new Object[0]);
                }
            } catch (Throwable th) {
                C7140g.a(th);
            }
            return null;
        }
        return a2;
    }

    private static boolean ad() {
        String a2 = C7140g.a(new File("/proc/self/cgroup"), 512, false);
        if (C7140g.a(a2)) {
            return false;
        }
        return a2.contains("/bg_non_interactive") || a2.contains("/background");
    }

    private static boolean ae() {
        try {
            Method declaredMethod = Process.class.getDeclaredMethod("isIsolated", new Class[0]);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, new Object[0]);
                if (invoke != null && (invoke instanceof Boolean)) {
                    return ((Boolean) invoke).booleanValue();
                }
            }
        } catch (Throwable th) {
            C7140g.a(th);
        }
        int myUid = Process.myUid() % 100000;
        return myUid >= 99000 && myUid <= 99999;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b() {
        if (k == null) {
            k = d("ctj");
        }
        return k;
    }

    private static String d(String str) {
        return C7152g.U() + a() + "." + str;
    }

    private static File[] e(String str) {
        if (i || str.length() > 0) {
            File[] listFiles = new File(C7152g.U()).listFiles();
            if (listFiles != null) {
                ArrayList arrayList = new ArrayList();
                for (File file : listFiles) {
                    if (file.getPath().endsWith(str)) {
                        arrayList.add(file);
                    }
                }
                return (File[]) arrayList.toArray(new File[arrayList.size()]);
            }
            return null;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File[] f() {
        return e(".stcb");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g() {
        if (v == null) {
            v = d("bati");
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h() {
        if (w == null) {
            w = d("hdr");
        }
        return w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String i() {
        if (q == null) {
            q = C7152g.U() + "up";
        }
        return q;
    }

    public static String j() {
        if (r == null) {
            r = C7152g.U() + "authu";
        }
        return r;
    }

    public static String k() {
        if (s == null) {
            s = C7152g.U() + "statu";
        }
        return s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String l() {
        if (t == null) {
            t = C7152g.U() + "poli";
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String m() {
        if (u == null) {
            u = C7152g.U() + "ver";
        }
        return u;
    }

    public static String n() {
        return C7152g.U() + "bvu";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String o() {
        return C7152g.U() + "fds";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String p() {
        return C7140g.a(new File(Q()), 8, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean q() {
        return y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean r() {
        if (!J) {
            if (d) {
                K = JNIBridge.cmd(15) == 1;
            } else {
                K = new File(S()).exists();
            }
            J = true;
        }
        return K;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean s() {
        T();
        return A;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean t() {
        T();
        return B;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean u() {
        return x;
    }

    public static void v() {
        boolean z2;
        f(C7152g.U());
        y = true;
        A = false;
        B = false;
        C = false;
        D = false;
        E = false;
        F = false;
        String[] strArr = {".st", ".wa", ".callback", ".ctn", ".ctj", ".cta", ".signal"};
        String[] strArr2 = {"up", "authu", "statu", "poli"};
        File[] listFiles = new File(C7152g.U()).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                String name = file.getName();
                int i2 = 0;
                while (true) {
                    if (i2 >= 7) {
                        z2 = false;
                        break;
                    } else if (name.endsWith(strArr[i2])) {
                        z2 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (!z2) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= 4) {
                            break;
                        } else if (name.equals(strArr2[i3])) {
                            z2 = true;
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                if (z2) {
                    C7134a.a("crashsdk", "delete file: " + file.getPath());
                    C7140g.a(file);
                }
            }
        }
        Z();
    }

    public static void w() {
        if (x) {
            return;
        }
        x = true;
        if (L() || C7146e.u()) {
            return;
        }
        f(C7152g.U());
        Y();
        Z();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean x() {
        return f(C7152g.U());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean y() {
        return f(C7152g.V());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean z() {
        return X || !ad();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c() {
        if (n == null) {
            n = d("st");
        }
        return n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File[] d() {
        return e(".st");
    }

    private static boolean f(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.isDirectory()) {
            return true;
        }
        C7134a.a("crashsdk", "Crash log directory was placed by a file!", null);
        if (file.delete()) {
            file.mkdirs();
            return true;
        }
        return false;
    }

    public static String b(String str) {
        return "debug.crs." + str;
    }

    public static void b(boolean z2) {
        if (C7146e.u()) {
            return;
        }
        if (z2 && x) {
            if (C7152g.M()) {
                Log.v("crashsdk", "setForeground, reset sExited to false!!!");
            }
            x = false;
            Y();
        }
        boolean z3 = C7146e.F() || L();
        long currentTimeMillis = System.currentTimeMillis();
        if (X && !Y && z2) {
            long j2 = aa;
            if (j2 != 0 && !z3 && currentTimeMillis - j2 > ConfigStorage.DEFAULT_SMALL_MAX_AGE) {
                C7139f.a(1, new RunnableC7138e(104), 1000L);
            }
        }
        aa = currentTimeMillis;
        Y = z2;
        if (z2) {
            X = true;
        }
        if (d) {
            JNIBridge.nativeSetForeground(z2);
        }
        if (x || z3) {
            return;
        }
        T();
        Z();
        if (z2) {
            C7133a.a(false);
            if (!Z) {
                C7146e.B();
                Z = true;
            }
        }
        if (!N) {
            aa();
        }
        C7146e.c(z2);
    }

    public static boolean c(int i2) {
        return (i2 & I) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e() {
        if (o == null) {
            o = d("stcb");
        }
        return o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        if (str == null || str.length() <= 0 || !str.endsWith(".st")) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".st");
        if (i || lastIndexOf >= 0) {
            String substring = str.substring(0, lastIndexOf);
            if (substring.length() <= 0) {
                return null;
            }
            return substring + ".stcb";
        }
        throw new AssertionError();
    }

    public static void a(boolean z2) {
        L = z2;
        if (d) {
            JNIBridge.set(30, z2);
        }
    }

    public static void b(int i2) {
        I = i2;
        K();
    }

    private static void a(Object[] objArr) {
        R = objArr;
        synchronized (O) {
            String str = (String) objArr[0];
            long longValue = ((Long) objArr[1]).longValue();
            if (longValue < U) {
                C7134a.c("crashsdk", String.format(Locale.US, "Update state generation %d, last is: %d", Long.valueOf(longValue), Long.valueOf(U)));
                return;
            }
            U = longValue;
            String Q2 = Q();
            if (d) {
                RandomAccessFile randomAccessFile = M;
                if (randomAccessFile != null) {
                    C7140g.a(randomAccessFile);
                    M = null;
                }
                boolean nativeChangeState = JNIBridge.nativeChangeState(Q2, str, N);
                N = false;
                if (!nativeChangeState) {
                    C7134a.b("write state failed: " + str);
                }
            } else {
                RandomAccessFile randomAccessFile2 = M;
                if (randomAccessFile2 == null || N) {
                    if (randomAccessFile2 != null) {
                        C7140g.a(randomAccessFile2);
                        M = null;
                    }
                    try {
                        RandomAccessFile randomAccessFile3 = new RandomAccessFile(Q2, "rw");
                        M = randomAccessFile3;
                        randomAccessFile3.seek(0L);
                        N = false;
                    } catch (Exception e2) {
                        C7140g.a(e2);
                    }
                }
                try {
                    M.write(str.getBytes());
                    M.seek(0L);
                } catch (Exception e3) {
                    C7140g.a(e3);
                }
            }
            P = str;
            R = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context) {
        C7134a.a("Restart APP");
        if (context == null) {
            return;
        }
        if (p == null) {
            p = d("rt");
        }
        File file = new File(p);
        long j2 = -1;
        try {
            j2 = Long.parseLong(C7140g.d(file));
        } catch (Throwable th) {
            C7140g.a(th);
        }
        boolean z2 = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (C7152g.h() >= 0 && (j2 <= 0 || currentTimeMillis - j2 > C7152g.h())) {
            f(C7152g.U());
            C7140g.a(file, String.valueOf(currentTimeMillis));
            z2 = true;
        }
        C7134a.a("lastTime: " + j2 + ", currentTime: " + currentTimeMillis + ", needRestart: " + z2);
        if (z2) {
            try {
                C7145d.a(true);
            } catch (Throwable th2) {
                C7140g.a(th2);
            }
            N();
        }
    }

    public static boolean a(Context context) {
        try {
            ((Application) context).registerActivityLifecycleCallbacks(new C7144c());
            if (C7152g.J()) {
                C();
                return true;
            }
            return true;
        } catch (Throwable th) {
            C7140g.a(th);
            return false;
        }
    }

    public static void a(int i2) {
        Object a2;
        Activity activity;
        int i3;
        boolean z2 = false;
        boolean z3 = true;
        switch (i2) {
            case 100:
                Object ac2 = ac();
                if (ac2 == null || (a2 = a(ac2, (Class<?>) null, "mActivities")) == null) {
                    return;
                }
                try {
                    boolean z4 = false;
                    for (Map.Entry entry : ((Map) a2).entrySet()) {
                        Object value = entry.getValue();
                        if (value != null && (activity = (Activity) a(value, (Class<?>) null, "activity")) != null) {
                            boolean booleanValue = ((Boolean) a(value, (Class<?>) null, IWXAudio.KEY_PAUSED)).booleanValue();
                            boolean booleanValue2 = ((Boolean) a(value, (Class<?>) null, DXRecyclerLayout.LOAD_MORE_STOPED)).booleanValue();
                            WeakHashMap<Activity, Integer> weakHashMap = ab;
                            synchronized (weakHashMap) {
                                if (booleanValue || booleanValue2) {
                                    i3 = 2;
                                } else {
                                    i3 = 1;
                                    z4 = true;
                                }
                                weakHashMap.put(activity, Integer.valueOf(i3));
                            }
                        }
                        z2 = true;
                    }
                    if (z2) {
                        b(z4);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    C7140g.a(th);
                    return;
                }
            case 101:
                try {
                    if (new File(Q()).exists()) {
                        z3 = false;
                    }
                    N = z3;
                    if (z3 || Q) {
                        a(ab());
                        Q = false;
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    C7140g.a(th2);
                    return;
                }
            case 102:
                C7139f.a(1, new RunnableC7138e(103));
                return;
            case 103:
                try {
                    C7140g.a(new File(S()));
                    return;
                } catch (Throwable th3) {
                    C7140g.a(th3);
                    return;
                }
            case 104:
                C7141h.d();
                C7151f.a(102);
                if (F()) {
                    C7146e.C();
                    return;
                }
                return;
            default:
                if (!i) {
                    throw new AssertionError();
                }
                return;
        }
    }

    private static Object a(Object obj, Class<?> cls, String str) {
        if (obj == null) {
            return null;
        }
        if (cls == null) {
            cls = obj.getClass();
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Throwable th) {
            C7140g.a(th);
            return null;
        }
    }

    public static boolean a(Object obj, String str, RunnableC7138e runnableC7138e) {
        FileChannel fileChannel;
        boolean z2;
        synchronized (obj) {
            FileChannel fileChannel2 = null;
            r1 = null;
            FileLock lock = null;
            fileChannel2 = null;
            boolean z3 = false;
            if (d) {
                int nativeOpenFile = JNIBridge.nativeOpenFile(str);
                if (nativeOpenFile < 0) {
                    C7134a.a("crashsdk", "Can not open file: " + str, null);
                    return false;
                }
                boolean nativeLockFile = JNIBridge.nativeLockFile(nativeOpenFile, true);
                try {
                    z2 = runnableC7138e.a();
                    JNIBridge.nativeCloseFile(nativeOpenFile);
                } finally {
                    if (nativeLockFile) {
                        JNIBridge.nativeLockFile(nativeOpenFile, false);
                    }
                }
            } else {
                File file = new File(str);
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (Exception e2) {
                        C7140g.a(e2);
                    }
                }
                try {
                    try {
                        fileChannel = new RandomAccessFile(file, "rw").getChannel();
                    } catch (Throwable th) {
                        th = th;
                        C7140g.a(fileChannel2);
                        throw th;
                    }
                } catch (Exception e3) {
                    try {
                        C7140g.a(e3);
                        fileChannel = null;
                    } catch (Exception e4) {
                        e = e4;
                        C7140g.a(e);
                        C7140g.a(fileChannel2);
                        z2 = z3;
                        return z2;
                    }
                }
                if (fileChannel != null) {
                    try {
                        try {
                            lock = fileChannel.lock();
                        } catch (Throwable th2) {
                            fileChannel2 = fileChannel;
                            th = th2;
                            C7140g.a(fileChannel2);
                            throw th;
                        }
                    } catch (Exception e5) {
                        try {
                            C7140g.a(e5);
                        } catch (Exception e6) {
                            e = e6;
                            fileChannel2 = fileChannel;
                            C7140g.a(e);
                            C7140g.a(fileChannel2);
                            z2 = z3;
                            return z2;
                        }
                    }
                }
                try {
                    z3 = runnableC7138e.a();
                    C7140g.a(fileChannel);
                    z2 = z3;
                } finally {
                    if (lock != null) {
                        try {
                            lock.release();
                        } catch (Exception e7) {
                            C7140g.a(e7);
                        }
                    }
                }
            }
            return z2;
        }
    }
}
