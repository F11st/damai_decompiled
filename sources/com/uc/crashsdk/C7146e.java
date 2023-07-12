package com.uc.crashsdk;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Debug;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StatFs;
import android.os.StrictMode;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ali.user.open.core.exception.RpcException;
import com.alibaba.motu.crashreporter2.CrashReporter;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.huawei.hms.utils.FileUtil;
import com.taobao.weex.annotation.JSMethod;
import com.uc.crashsdk.a.C7134a;
import com.uc.crashsdk.a.C7135b;
import com.uc.crashsdk.a.C7136c;
import com.uc.crashsdk.a.C7137d;
import com.uc.crashsdk.a.C7139f;
import com.uc.crashsdk.a.C7140g;
import com.uc.crashsdk.a.C7141h;
import com.uc.crashsdk.a.RunnableC7138e;
import com.uc.crashsdk.export.LogType;
import com.youku.arch.solid.monitor.SolidMonitor;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mtopsdk.common.util.SymbolExpUtil;
import mtopsdk.mtop.intf.MtopParamType;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import tb.lu2;

/* compiled from: Taobao */
/* renamed from: com.uc.crashsdk.e */
/* loaded from: classes11.dex */
public class C7146e implements Thread.UncaughtExceptionHandler {
    private static long b;
    private static String i;
    private final List<FileInputStream> e = new ArrayList();
    static final /* synthetic */ boolean a = true;
    private static final AtomicBoolean c = new AtomicBoolean(false);
    private static boolean d = false;
    private static long f = 0;
    private static long g = -1;
    private static boolean h = true;
    private static String j = "";
    private static String k = null;
    private static String l = null;
    private static String m = null;
    private static final Object n = new Object();
    private static final Object o = new Object();
    private static final Object p = new Object();
    private static final Object q = new Object();
    private static final ArrayList<String> r = new ArrayList<>();
    private static int s = 0;
    private static String t = null;
    private static boolean u = false;
    private static String v = null;
    private static String w = null;
    private static final Object x = new Object();
    private static final Object y = new Object();
    private static Map<String, Integer> z = null;
    private static String A = null;
    private static int B = -1;
    private static int C = -1;
    private static int D = -1;
    private static int E = -1;
    private static int F = -1;
    private static int G = -1;
    private static int H = -1;
    private static String I = "?";
    private static boolean J = false;
    private static boolean K = false;
    private static int L = 0;
    private static int M = 0;
    private static boolean N = false;
    private static RunnableC7138e O = new RunnableC7138e(405);
    private static C7149c P = new C7149c((byte) 0);
    private static boolean Q = false;
    private static final RunnableC7138e R = new RunnableC7138e(412);
    private static Thread.UncaughtExceptionHandler S = null;
    private static Throwable T = null;
    private static boolean U = false;
    private static boolean V = false;
    private static Runnable W = null;
    private static final Object X = new Object();
    private static int Y = 101;
    private static Runnable Z = new RunnableC7138e(407);
    private static final Object aa = new Object();
    private static volatile boolean ab = false;
    private static ParcelFileDescriptor ac = null;
    private static boolean ad = false;
    private static boolean ae = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.uc.crashsdk.e$b */
    /* loaded from: classes11.dex */
    public static class C7148b implements Comparator<File> {
        private C7148b() {
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            File file3 = file;
            File file4 = file2;
            if (file3.lastModified() > file4.lastModified()) {
                return 1;
            }
            return file3.lastModified() < file4.lastModified() ? -1 : 0;
        }

        /* synthetic */ C7148b(byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.uc.crashsdk.e$c */
    /* loaded from: classes11.dex */
    public static class C7149c extends BroadcastReceiver {
        private C7149c() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.BATTERY_CHANGED".equals(action)) {
                int unused = C7146e.B = intent.getIntExtra("level", -1);
                int unused2 = C7146e.C = intent.getIntExtra("scale", -1);
                int unused3 = C7146e.D = intent.getIntExtra("voltage", -1);
                int unused4 = C7146e.E = intent.getIntExtra("health", -1);
                int unused5 = C7146e.F = intent.getIntExtra("plugged", -1);
                int unused6 = C7146e.G = intent.getIntExtra("status", -1);
                int unused7 = C7146e.H = intent.getIntExtra("temperature", -1);
                String unused8 = C7146e.I = intent.getStringExtra("technology");
                if (C7146e.J() >= 2) {
                    C7146e.K();
                    C7146e.L();
                }
            } else if ("android.intent.action.BATTERY_LOW".equals(action) || "android.intent.action.BATTERY_OKAY".equals(action)) {
                boolean unused9 = C7146e.J = "android.intent.action.BATTERY_LOW".equals(action);
                C7146e.K();
            } else if ("android.intent.action.ANR".equals(action)) {
                try {
                    C7146e.d(context);
                } catch (Throwable th) {
                    C7140g.a(th);
                }
            }
        }

        /* synthetic */ C7149c(byte b) {
            this();
        }
    }

    public C7146e() {
        try {
            M();
        } catch (Throwable th) {
            C7140g.a(th);
        }
    }

    public static void A() {
        if (C7152g.q()) {
            C7139f.a(0, new RunnableC7138e(403), 10000L);
        }
    }

    public static void B() {
        if (ab || C7143b.L()) {
            return;
        }
        C7139f.a(1, new RunnableC7138e(RpcException.ErrorCode.API_UNAUTHORIZED), 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void C() {
        C7139f.a(1, new RunnableC7138e(409), 7000L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x003f, code lost:
        if ((java.lang.System.currentTimeMillis() % 3) == 0) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
        if (r0 == 1) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0011, code lost:
        r3 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void D() {
        /*
            int r0 = com.uc.crashsdk.C7152g.L()
            r1 = 4
            r2 = 3
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L13
            if (r0 == r2) goto L13
            if (r0 != r1) goto Lf
            goto L13
        Lf:
            if (r0 != r3) goto L43
        L11:
            r3 = 0
            goto L43
        L13:
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 21
            if (r5 < r6) goto L43
            r6 = 25
            if (r5 > r6) goto L43
            if (r0 != 0) goto L21
            r5 = 0
            goto L22
        L21:
            r5 = 1
        L22:
            r6 = 0
            if (r0 != r2) goto L34
            long r8 = java.lang.System.currentTimeMillis()
            r10 = 10
            long r8 = r8 % r10
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 != 0) goto L33
            r5 = 1
            goto L34
        L33:
            r5 = 0
        L34:
            if (r0 != r1) goto L42
            long r0 = java.lang.System.currentTimeMillis()
            r8 = 3
            long r0 = r0 % r8
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 != 0) goto L11
            goto L43
        L42:
            r3 = r5
        L43:
            if (r3 != 0) goto L4c
            java.lang.String r0 = "crashsdk"
            java.lang.String r1 = "SIG 3 is disabled by settings"
            com.uc.crashsdk.a.C7134a.a(r0, r1)
        L4c:
            boolean r0 = com.uc.crashsdk.C7143b.L()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            android.os.Looper r2 = android.os.Looper.myLooper()
            if (r1 == r2) goto L68
            if (r3 == 0) goto L68
            r1 = 2
            com.uc.crashsdk.a.e r2 = new com.uc.crashsdk.a.e
            r3 = 413(0x19d, float:5.79E-43)
            r2.<init>(r3)
            com.uc.crashsdk.a.C7139f.a(r1, r2)
            goto L69
        L68:
            r4 = r3
        L69:
            r1 = 7
            long r2 = (long) r0
            r0 = 0
            com.uc.crashsdk.JNIBridge.nativeCmd(r1, r2, r0, r0)
            if (r4 == 0) goto L76
            r0 = 8
            com.uc.crashsdk.JNIBridge.cmd(r0)
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.C7146e.D():void");
    }

    public static ParcelFileDescriptor E() {
        if (!C7143b.d) {
            C7134a.d("crashsdk", "Crash so is not loaded!");
            return null;
        }
        ParcelFileDescriptor parcelFileDescriptor = ac;
        if (parcelFileDescriptor != null) {
            return parcelFileDescriptor;
        }
        int cmd = (int) JNIBridge.cmd(14);
        if (cmd == -1) {
            return null;
        }
        ParcelFileDescriptor adoptFd = ParcelFileDescriptor.adoptFd(cmd);
        ac = adoptFd;
        ad = true;
        return adoptFd;
    }

    public static boolean F() {
        return ae;
    }

    public static void G() {
        String V2 = C7152g.V();
        File file = new File(V2);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                C7134a.b("Ucebu can not list folder: " + V2);
                return;
            }
            for (File file2 : listFiles) {
                if (file2.isFile() && file2.getName().contains("ucebu")) {
                    a(false, false);
                    return;
                }
            }
        }
    }

    static /* synthetic */ boolean I() {
        return N();
    }

    static /* synthetic */ int J() {
        int i2 = L + 1;
        L = i2;
        return i2;
    }

    static /* synthetic */ void K() {
        StringBuilder X2;
        if (C7143b.d && (X2 = X()) != null) {
            JNIBridge.set(125, X2.toString());
        }
        K = true;
        Y();
    }

    static /* synthetic */ int L() {
        L = 0;
        return 0;
    }

    private void M() {
        int G2 = C7152g.G();
        for (int i2 = 0; i2 < G2; i2++) {
            try {
                this.e.add(new FileInputStream("/dev/null"));
            } catch (Exception e) {
                C7140g.a(e);
                return;
            }
        }
    }

    private static boolean N() {
        if (C7152g.N()) {
            return true;
        }
        return a();
    }

    private static String O() {
        return C7152g.e() + JSMethod.NOT_SET;
    }

    private static String P() {
        return C7143b.B() ? "fg" : "bg";
    }

    private static byte[] Q() {
        byte[] bArr = null;
        int i2 = 1024;
        while (bArr == null && i2 > 0) {
            try {
                bArr = new byte[i2];
            } catch (Throwable unused) {
                i2 /= 2;
                if (i2 < 16) {
                    break;
                }
            }
        }
        return bArr;
    }

    private static String R() {
        return (!C7143b.F() || d) ? "java" : "ucebujava";
    }

    private static void S() {
        String str;
        BufferedReader bufferedReader;
        Throwable th;
        FileReader fileReader;
        String str2 = "-";
        try {
            str = Build.HARDWARE;
        } catch (Throwable th2) {
            C7140g.a(th2);
            str = "-";
        }
        try {
            fileReader = new FileReader(new File("/proc/cpuinfo"));
            try {
                bufferedReader = new BufferedReader(fileReader, 512);
                int i2 = 0;
                do {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.startsWith("Hardware")) {
                            str = readLine.substring(readLine.indexOf(":") + 1).trim();
                        } else if (readLine.startsWith("Processor")) {
                            str2 = readLine.substring(readLine.indexOf(":") + 1).trim();
                        }
                        i2++;
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            C7140g.a(th);
                            C7140g.a(fileReader);
                            C7140g.a(bufferedReader);
                            k = str;
                            l = str2;
                        } catch (Throwable th4) {
                            C7140g.a(fileReader);
                            C7140g.a(bufferedReader);
                            throw th4;
                        }
                    }
                } while (i2 < 2);
                C7140g.a(fileReader);
            } catch (Throwable th5) {
                bufferedReader = null;
                th = th5;
            }
        } catch (Throwable th6) {
            bufferedReader = null;
            th = th6;
            fileReader = null;
        }
        C7140g.a(bufferedReader);
        k = str;
        l = str2;
    }

    private static String T() {
        return C7152g.U() + "bytes";
    }

    private static boolean U() {
        return Build.VERSION.SDK_INT < 29;
    }

    private static void V() {
        if (N || C7143b.F() || C7143b.L()) {
            return;
        }
        JNIBridge.cmd(18);
    }

    private static void W() {
        C7139f.a(3, new RunnableC7138e(414), 1000L);
    }

    private static StringBuilder X() {
        String str;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("level: ");
            sb.append(B);
            sb.append(StringUtils.LF);
            sb.append("scale: ");
            sb.append(C);
            sb.append(StringUtils.LF);
            switch (E) {
                case 1:
                    str = " (Unknown)";
                    break;
                case 2:
                    str = " (Good)";
                    break;
                case 3:
                    str = " (Overheat)";
                    break;
                case 4:
                    str = " (Dead)";
                    break;
                case 5:
                    str = " (Over voltage)";
                    break;
                case 6:
                    str = " (Unspecified failure)";
                    break;
                case 7:
                    str = " (Cold)";
                    break;
                default:
                    str = " (?)";
                    break;
            }
            sb.append("health: ");
            sb.append(E);
            sb.append(str);
            sb.append(StringUtils.LF);
            int i2 = F;
            String str2 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 4 ? " (?)" : " (Wireless)" : " (USB port)" : " (AC charger)" : " (None)";
            sb.append("pluged: ");
            sb.append(F);
            sb.append(str2);
            sb.append(StringUtils.LF);
            int i3 = G;
            String str3 = i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? " (?)" : " (Full)" : " (Not charging)" : " (Discharging)" : " (Charging)" : " (Unknown)";
            sb.append("status: ");
            sb.append(G);
            sb.append(str3);
            sb.append(StringUtils.LF);
            sb.append("voltage: ");
            sb.append(D);
            sb.append(StringUtils.LF);
            sb.append("temperature: ");
            sb.append(H);
            sb.append(StringUtils.LF);
            sb.append("technology: ");
            sb.append(I);
            sb.append(StringUtils.LF);
            sb.append("battery low: ");
            sb.append(J);
            sb.append(StringUtils.LF);
            return sb;
        } catch (Throwable th) {
            C7140g.a(th);
            return null;
        }
    }

    private static void Y() {
        if (C7143b.c && K && C7133a.c) {
            K = false;
            if (C7139f.b(O)) {
                return;
            }
            C7139f.a(0, O, 2000L);
        }
    }

    private static boolean Z() {
        return C7143b.d && JNIBridge.nativeIsCrashing();
    }

    public static boolean a() {
        if (f == 0) {
            f = 2L;
            if (h(C7143b.b("logs")) == 1) {
                f = 1L;
            }
        }
        return f == 1;
    }

    private static void aa() {
        String W2 = C7152g.W();
        File file = new File(W2);
        if (file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 150) {
                    Arrays.sort(listFiles, new C7148b((byte) 0));
                    int length = listFiles.length - 150;
                    int i2 = length < 0 ? 0 : length;
                    long currentTimeMillis = System.currentTimeMillis();
                    int i3 = 0;
                    int i4 = 0;
                    while (i3 < listFiles.length) {
                        File file2 = listFiles[i3];
                        boolean z2 = i3 < i2;
                        if (!z2 && currentTimeMillis - file2.lastModified() >= 432000000) {
                            z2 = true;
                        }
                        if (!z2) {
                            break;
                        }
                        file2.delete();
                        i4++;
                        if (0 >= 3) {
                            break;
                        }
                        i3++;
                    }
                    C7134a.a("Removed " + i4 + " logs in " + W2);
                }
            } catch (Throwable th) {
                C7140g.a(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b() {
        if (g == -1) {
            g = h(C7143b.b("local"));
        }
        return g;
    }

    private static String j(String str) {
        if (str == null) {
            str = String.valueOf(System.currentTimeMillis()) + new Random().nextInt(65536);
        }
        return String.format(Locale.US, "%s%s_%s_%s_%s_%s_", O(), C7152g.R(), C7152g.T(), i(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL()), i(Build.VERSION.getRELEASE()), str);
    }

    private static String k(String str) {
        return String.format(Locale.US, "%s%s_%s_%s.log", d(), n(), P(), str);
    }

    private static String l(String str) {
        if (C7140g.b(str)) {
            int indexOf = str.indexOf(0);
            if (indexOf >= 0) {
                str = str.substring(0, indexOf);
            }
            return str.trim();
        }
        return "";
    }

    private static String m(String str) {
        String a2 = C7135b.a(str, C7152g.w(), C7152g.v());
        if (!str.equals(a2)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
        return a2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0051, code lost:
        if (r7.endsWith(r3) != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0068, code lost:
        if (r7.indexOf(".log", r7.lastIndexOf(95)) != r7.lastIndexOf(".log")) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean[] n(java.lang.String r7) {
        /*
            boolean r0 = com.uc.crashsdk.C7152g.v()
            boolean r1 = com.uc.crashsdk.C7152g.x()
            r2 = 0
            if (r0 != 0) goto Ld
            if (r1 == 0) goto L6d
        Ld:
            java.lang.String r3 = ".tmp"
            boolean r3 = r7.endsWith(r3)
            if (r3 != 0) goto L6b
            java.lang.String r3 = ".ec"
            boolean r3 = r7.contains(r3)
            if (r3 == 0) goto L1e
            goto L6b
        L1e:
            char r3 = java.io.File.separatorChar
            int r3 = r7.lastIndexOf(r3)
            if (r3 >= 0) goto L27
            r3 = 0
        L27:
            r4 = 0
        L28:
            r5 = 95
            int r3 = r7.indexOf(r5, r3)
            if (r3 < 0) goto L34
            int r4 = r4 + 1
            int r3 = r3 + 1
        L34:
            if (r3 >= 0) goto L28
            r3 = 8
            if (r4 == r3) goto L3b
            goto L6b
        L3b:
            java.lang.String r3 = com.uc.crashsdk.C7152g.w()
            java.lang.String r4 = ".log"
            boolean r6 = r7.endsWith(r4)
            if (r6 != 0) goto L54
            boolean r0 = com.uc.crashsdk.a.C7140g.a(r3)
            if (r0 != 0) goto L6b
            boolean r7 = r7.endsWith(r3)
            if (r7 != 0) goto L5a
            goto L6b
        L54:
            boolean r3 = com.uc.crashsdk.a.C7140g.a(r3)
            if (r3 == 0) goto L5c
        L5a:
            r0 = 0
            goto L6d
        L5c:
            int r3 = r7.lastIndexOf(r5)
            int r3 = r7.indexOf(r4, r3)
            int r7 = r7.lastIndexOf(r4)
            if (r3 == r7) goto L6d
            goto L5a
        L6b:
            r0 = 0
            r1 = 0
        L6d:
            r7 = 2
            boolean[] r7 = new boolean[r7]
            r7[r2] = r0
            r0 = 1
            r7[r0] = r1
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.C7146e.n(java.lang.String):boolean[]");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:3|4|(3:6|(3:9|(1:11)(17:12|13|14|(13:48|49|18|(1:47)(1:21)|22|(1:24)|25|26|27|29|30|31|32)(1:16)|17|18|(0)|47|22|(0)|25|26|27|29|30|31|32)|7)|53)|54|(0)|25|26|27|29|30|31|32) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:(3:6|(3:9|(1:11)(17:12|13|14|(13:48|49|18|(1:47)(1:21)|22|(1:24)|25|26|27|29|30|31|32)(1:16)|17|18|(0)|47|22|(0)|25|26|27|29|30|31|32)|7)|53)|26|27|29|30|31|32) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d9, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00da, code lost:
        r1 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00dc, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00dd, code lost:
        r1 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e1, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e2, code lost:
        com.uc.crashsdk.a.C7140g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e5, code lost:
        com.uc.crashsdk.a.C7140g.a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ea, code lost:
        com.uc.crashsdk.a.C7140g.a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ed, code lost:
        throw r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ae A[Catch: all -> 0x00ee, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0005, B:6:0x0033, B:7:0x0041, B:9:0x0047, B:11:0x0051, B:12:0x0056, B:15:0x0068, B:21:0x0078, B:26:0x0083, B:29:0x00ae, B:33:0x00d5, B:44:0x00e8, B:46:0x00ea, B:47:0x00ed, B:43:0x00e5, B:18:0x0072), top: B:51:0x0005, inners: #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean o(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.C7146e.o(java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a0 A[Catch: all -> 0x0107, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:7:0x0018, B:9:0x0023, B:10:0x002d, B:38:0x00af, B:49:0x00d4, B:56:0x00ef, B:52:0x00df, B:63:0x00fb, B:66:0x0105, B:11:0x0033, B:13:0x003b, B:14:0x0044, B:16:0x004c, B:18:0x0054, B:20:0x005c, B:26:0x006a, B:28:0x0074, B:30:0x0081, B:32:0x008b, B:33:0x0096, B:35:0x00a0), top: B:71:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00af A[Catch: all -> 0x0107, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:7:0x0018, B:9:0x0023, B:10:0x002d, B:38:0x00af, B:49:0x00d4, B:56:0x00ef, B:52:0x00df, B:63:0x00fb, B:66:0x0105, B:11:0x0033, B:13:0x003b, B:14:0x0044, B:16:0x004c, B:18:0x0054, B:20:0x005c, B:26:0x006a, B:28:0x0074, B:30:0x0081, B:32:0x008b, B:33:0x0096, B:35:0x00a0), top: B:71:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean p(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.C7146e.p(java.lang.String):boolean");
    }

    private static Map<String, Integer> q(String str) {
        HashMap hashMap = new HashMap();
        for (String str2 : str.split(SymbolExpUtil.SYMBOL_VERTICALBAR, 30)) {
            String[] split = str2.split(":", 3);
            if (split.length == 2) {
                String trim = split[0].trim();
                if (!C7140g.a(trim)) {
                    int i2 = 1;
                    try {
                        i2 = Integer.parseInt(split[1].trim(), 10);
                    } catch (Throwable th) {
                        C7140g.a(th);
                    }
                    hashMap.put(trim, Integer.valueOf(i2));
                }
            }
        }
        return hashMap;
    }

    private static void r(String str) {
        if (C7152g.q()) {
            try {
                aa();
            } catch (Throwable th) {
                C7140g.a(th);
            }
            if (str == null || "".equals(str)) {
                return;
            }
            try {
                File file = new File(C7152g.W());
                if (!file.exists()) {
                    file.mkdirs();
                }
                C7134a.a("crashsdk", "copy log to: " + file);
                C7140g.a(new File(str), file);
            } catch (Throwable th2) {
                C7140g.a(th2);
            }
        }
    }

    private static String s(String str) {
        return String.format("$^%s^$", str);
    }

    public static void t() {
        Thread.setDefaultUncaughtExceptionHandler(S);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean u() {
        return c.get() || Z();
    }

    public static Throwable v() {
        return T;
    }

    public static int w() {
        if (C7143b.I() == 5) {
            return Y;
        }
        return 100;
    }

    public static void x() {
        long o2 = C7152g.o();
        if (o2 < 0) {
            return;
        }
        boolean z2 = C7143b.I() == 5;
        C7139f.a(0, new RunnableC7138e(401));
        if (z2) {
            RunnableC7138e runnableC7138e = new RunnableC7138e(402);
            W = runnableC7138e;
            C7139f.a(0, runnableC7138e, o2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void y() {
        if (C7143b.c && C7133a.c && !C7139f.b(Z)) {
            C7139f.a(0, Z, 1000L);
        }
    }

    public static boolean z() {
        synchronized (X) {
            Runnable runnable = W;
            if (runnable == null || V) {
                return false;
            }
            C7139f.a(runnable);
            W = null;
            return true;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(thread, th, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d() {
        String str = i;
        if (str != null) {
            return str;
        }
        String j2 = j(null);
        i = j2;
        return j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00af A[Catch: all -> 0x00d3, TRY_LEAVE, TryCatch #1 {all -> 0x00d3, blocks: (B:37:0x009a, B:39:0x00af), top: B:67:0x009a }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e0 A[Catch: all -> 0x0143, TryCatch #0 {all -> 0x0143, blocks: (B:49:0x00da, B:51:0x00e0, B:53:0x00e8, B:54:0x010e, B:56:0x0114, B:58:0x011c), top: B:65:0x00da }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0114 A[Catch: all -> 0x0143, TryCatch #0 {all -> 0x0143, blocks: (B:49:0x00da, B:51:0x00e0, B:53:0x00e8, B:54:0x010e, B:56:0x0114, B:58:0x011c), top: B:65:0x00da }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String e() {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.C7146e.e():java.lang.String");
    }

    public static String f() {
        if (C7140g.a(k)) {
            S();
        }
        return k;
    }

    private static long h(String str) {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("getLong", String.class, Long.TYPE);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return ((Long) declaredMethod.invoke(null, str, 0L)).longValue();
            }
        } catch (Throwable th) {
            C7140g.a(th);
        }
        return 0L;
    }

    private static String i(String str) {
        try {
            return str.replaceAll("[^0-9a-zA-Z-.]", "-");
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static void s() {
        S = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new C7146e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c() {
        i = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i() {
        return d;
    }

    public static boolean b(int i2, Object[] objArr) {
        if (i2 == 451) {
            if (a || objArr != null) {
                return a((String) objArr[0], (C7150d) objArr[1]);
            }
            throw new AssertionError();
        } else if (i2 != 452) {
            if (a) {
                return false;
            }
            throw new AssertionError();
        } else if (a || objArr != null) {
            C7150d c7150d = (C7150d) objArr[1];
            return C7140g.a(new File((String) objArr[0]), String.format(Locale.US, "%d %d %d %d", Long.valueOf(c7150d.a), Long.valueOf(c7150d.b), Integer.valueOf(c7150d.c), Integer.valueOf(c7150d.d)).getBytes());
        } else {
            throw new AssertionError();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006e A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:24:0x004d, B:26:0x0065, B:28:0x006b, B:30:0x006e, B:32:0x0076), top: B:38:0x004d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(java.io.OutputStream r7) {
        /*
            java.lang.String r0 = "UTF-8"
            java.lang.String r1 = "disk info:\n"
            byte[] r1 = r1.getBytes(r0)     // Catch: java.lang.Throwable -> Lc
            r7.write(r1)     // Catch: java.lang.Throwable -> Lc
            goto L10
        Lc:
            r1 = move-exception
            a(r1, r7)
        L10:
            boolean r1 = com.uc.crashsdk.C7146e.ae
            r2 = 0
            if (r1 == 0) goto L2d
            com.uc.crashsdk.C7146e.h = r2
            java.lang.String r1 = "FSSTAT"
            java.lang.String r1 = s(r1)     // Catch: java.lang.Throwable -> L25
            byte[] r0 = r1.getBytes(r0)     // Catch: java.lang.Throwable -> L25
            r7.write(r0)     // Catch: java.lang.Throwable -> L25
            goto L29
        L25:
            r0 = move-exception
            a(r0, r7)
        L29:
            r0 = 1
            com.uc.crashsdk.C7146e.h = r0
            goto L84
        L2d:
            r0 = 0
            java.util.HashSet r1 = new java.util.HashSet     // Catch: java.lang.Throwable -> L46
            r1.<init>()     // Catch: java.lang.Throwable -> L46
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L44
            java.lang.String r3 = com.uc.crashsdk.a.C7140g.b()     // Catch: java.lang.Throwable -> L44
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L44
            java.lang.String r0 = a(r0)     // Catch: java.lang.Throwable -> L44
            a(r7, r0, r1)     // Catch: java.lang.Throwable -> L44
            goto L4d
        L44:
            r0 = move-exception
            goto L4a
        L46:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
        L4a:
            a(r0, r7)
        L4d:
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Throwable -> L80
            java.lang.String r0 = a(r0)     // Catch: java.lang.Throwable -> L80
            a(r7, r0, r1)     // Catch: java.lang.Throwable -> L80
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L80
            java.lang.String r3 = "/storage"
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L80
            boolean r3 = r0.exists()     // Catch: java.lang.Throwable -> L80
            if (r3 == 0) goto L84
            java.io.File[] r0 = r0.listFiles()     // Catch: java.lang.Throwable -> L80
            if (r0 == 0) goto L84
            int r3 = r0.length     // Catch: java.lang.Throwable -> L80
        L6c:
            if (r2 >= r3) goto L84
            r4 = r0[r2]     // Catch: java.lang.Throwable -> L80
            boolean r5 = r4.isDirectory()     // Catch: java.lang.Throwable -> L80
            if (r5 == 0) goto L7d
            java.lang.String r4 = a(r4)     // Catch: java.lang.Throwable -> L80
            a(r7, r4, r1)     // Catch: java.lang.Throwable -> L80
        L7d:
            int r2 = r2 + 1
            goto L6c
        L80:
            r0 = move-exception
            a(r0, r7)
        L84:
            a(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.C7146e.c(java.io.OutputStream):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("JavaMax:    ");
            sb.append(Runtime.getRuntime().maxMemory() / 1024);
            sb.append(" kB\n");
            sb.append("JavaTotal:  ");
            sb.append(Runtime.getRuntime().totalMemory() / 1024);
            sb.append(" kB\n");
            sb.append("JavaFree:   ");
            sb.append(Runtime.getRuntime().freeMemory() / 1024);
            sb.append(" kB\n");
            sb.append("NativeHeap: ");
            sb.append(Debug.getNativeHeapSize() / 1024);
            sb.append(" kB\n");
            sb.append("NativeAllocated: ");
            sb.append(Debug.getNativeHeapAllocatedSize() / 1024);
            sb.append(" kB\n");
            sb.append("NativeFree: ");
            sb.append(Debug.getNativeHeapFreeSize() / 1024);
            sb.append(" kB\n");
            ActivityManager activityManager = (ActivityManager) C7140g.a().getSystemService("activity");
            if (activityManager != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                sb.append("availMem:   ");
                sb.append(memoryInfo.availMem / 1024);
                sb.append(" kB\n");
                sb.append("threshold:  ");
                sb.append(memoryInfo.threshold / 1024);
                sb.append(" kB\n");
                sb.append("lowMemory:  ");
                sb.append(memoryInfo.lowMemory);
                sb.append(StringUtils.LF);
            }
            return sb.toString();
        } catch (Throwable th) {
            C7140g.a(th);
            return "";
        }
    }

    private static void d(OutputStream outputStream) {
        if (C7143b.d) {
            String o2 = C7143b.o();
            h = false;
            if (1 == JNIBridge.cmd(17, o2)) {
                File file = new File(o2);
                try {
                    byte[] e = C7140g.e(file);
                    if (e != null) {
                        outputStream.write(e);
                    }
                } catch (Throwable th) {
                    a(th, outputStream);
                }
                try {
                    file.delete();
                } catch (Throwable th2) {
                    a(th2, outputStream);
                }
                h = true;
                a(outputStream);
            }
            h = true;
            return;
        }
        File[] fileArr = null;
        int i2 = 900;
        try {
            i2 = C7152g.H();
            fileArr = new File("/proc/self/fd").listFiles();
            if (fileArr != null) {
                outputStream.write(String.format(Locale.US, "opened file count: %d, write limit: %d.\n", Integer.valueOf(fileArr.length), Integer.valueOf(i2)).getBytes("UTF-8"));
            } else {
                outputStream.write("[DEBUG] listFiles failed!\n".getBytes("UTF-8"));
            }
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        if (fileArr != null) {
            try {
                if (fileArr.length >= i2) {
                    outputStream.write("opened files:\n".getBytes("UTF-8"));
                    StringBuilder sb = new StringBuilder();
                    for (File file2 : fileArr) {
                        sb.append(file2.getName());
                        sb.append(" -> ");
                        sb.append(file2.getCanonicalPath());
                        sb.append(StringUtils.LF);
                    }
                    outputStream.write(sb.toString().getBytes("UTF-8"));
                }
            } catch (Throwable th4) {
                a(th4, outputStream);
            }
        }
        a(outputStream);
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x009b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x006f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void f(java.io.OutputStream r11) {
        /*
            java.lang.String r0 = "UTF-8"
            boolean r1 = com.uc.crashsdk.C7143b.d
            if (r1 != 0) goto L7
            return
        L7:
            java.lang.String r1 = "solib build id:\n"
            byte[] r1 = r1.getBytes(r0)     // Catch: java.lang.Throwable -> L11
            r11.write(r1)     // Catch: java.lang.Throwable -> L11
            goto L15
        L11:
            r1 = move-exception
            a(r1, r11)
        L15:
            r1 = 0
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lc3
            r2.<init>()     // Catch: java.lang.Throwable -> Lc3
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> Lc3
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r5 = "/proc/self/maps"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> Lc3
            r3.<init>(r4)     // Catch: java.lang.Throwable -> Lc3
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> Lbf
            r5 = 512(0x200, float:7.17E-43)
            r4.<init>(r3, r5)     // Catch: java.lang.Throwable -> Lbf
        L2e:
            java.lang.String r1 = r4.readLine()     // Catch: java.lang.Throwable -> Lbd
            if (r1 == 0) goto Lb9
            java.lang.String r5 = ".so"
            boolean r5 = r1.endsWith(r5)     // Catch: java.lang.Throwable -> Lbd
            if (r5 == 0) goto L2e
            r5 = 47
            int r5 = r1.indexOf(r5)     // Catch: java.lang.Throwable -> Lbd
            r6 = -1
            if (r5 == r6) goto L2e
            java.lang.String r1 = r1.substring(r5)     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r5 = "/data/"
            boolean r5 = r1.contains(r5)     // Catch: java.lang.Throwable -> Lbd
            r6 = 0
            r7 = 1
            if (r5 != 0) goto L5e
            java.lang.String r5 = com.uc.crashsdk.C7133a.a     // Catch: java.lang.Throwable -> Lbd
            boolean r5 = r1.contains(r5)     // Catch: java.lang.Throwable -> Lbd
            if (r5 == 0) goto L5c
            goto L5e
        L5c:
            r5 = 0
            goto L5f
        L5e:
            r5 = 1
        L5f:
            if (r5 == 0) goto L2e
            boolean r5 = r2.contains(r1)     // Catch: java.lang.Throwable -> Lbd
            if (r5 != 0) goto L2e
            r2.add(r1)     // Catch: java.lang.Throwable -> Lbd
            boolean r5 = com.uc.crashsdk.C7146e.ae     // Catch: java.lang.Throwable -> Lbd
            r8 = 2
            if (r5 == 0) goto L9b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L96
            r5.<init>()     // Catch: java.lang.Throwable -> L96
            java.lang.String r9 = "SOBUILDID"
            java.lang.String r10 = "$^%s`%s^$"
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch: java.lang.Throwable -> L96
            r8[r6] = r9     // Catch: java.lang.Throwable -> L96
            r8[r7] = r1     // Catch: java.lang.Throwable -> L96
            java.lang.String r1 = java.lang.String.format(r10, r8)     // Catch: java.lang.Throwable -> L96
            r5.append(r1)     // Catch: java.lang.Throwable -> L96
            java.lang.String r1 = "\n"
            r5.append(r1)     // Catch: java.lang.Throwable -> L96
            java.lang.String r1 = r5.toString()     // Catch: java.lang.Throwable -> L96
            byte[] r1 = r1.getBytes(r0)     // Catch: java.lang.Throwable -> L96
            r11.write(r1)     // Catch: java.lang.Throwable -> L96
            goto L2e
        L96:
            r1 = move-exception
            a(r1, r11)     // Catch: java.lang.Throwable -> Lbd
            goto L2e
        L9b:
            r5 = 3
            r9 = 0
            java.lang.String r5 = com.uc.crashsdk.JNIBridge.nativeGet(r5, r9, r1)     // Catch: java.lang.Throwable -> Lbd
            java.util.Locale r9 = java.util.Locale.US     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r10 = "%s: %s\n"
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch: java.lang.Throwable -> Lbd
            r8[r6] = r1     // Catch: java.lang.Throwable -> Lbd
            r8[r7] = r5     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r1 = java.lang.String.format(r9, r10, r8)     // Catch: java.lang.Throwable -> Lbd
            byte[] r1 = r1.getBytes(r0)     // Catch: java.lang.Throwable -> Lbd
            r11.write(r1)     // Catch: java.lang.Throwable -> Lbd
            goto L2e
        Lb9:
            com.uc.crashsdk.a.C7140g.a(r3)
            goto Lcb
        Lbd:
            r0 = move-exception
            goto Lc1
        Lbf:
            r0 = move-exception
            r4 = r1
        Lc1:
            r1 = r3
            goto Lc5
        Lc3:
            r0 = move-exception
            r4 = r1
        Lc5:
            a(r0, r11)     // Catch: java.lang.Throwable -> Ld2
            com.uc.crashsdk.a.C7140g.a(r1)
        Lcb:
            com.uc.crashsdk.a.C7140g.a(r4)
            a(r11)
            return
        Ld2:
            r11 = move-exception
            com.uc.crashsdk.a.C7140g.a(r1)
            com.uc.crashsdk.a.C7140g.a(r4)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.C7146e.f(java.io.OutputStream):void");
    }

    public static String k() {
        String str = w;
        if (C7140g.a(str)) {
            synchronized (x) {
                str = C7140g.a(C7143b.i(), C7152g.P() ? "https://up4-intl.ucweb.com/upload" : "https://up4.ucweb.com/upload", true);
                w = str;
            }
        }
        return str;
    }

    public static void l() {
        synchronized (x) {
            w = null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(int i2, Object[] objArr) {
        int i3;
        switch (i2) {
            case 401:
                JNIBridge.nativeCmd(10, C7143b.I() == 5 ? 1L : 0L, null, null);
                C7133a.c = true;
                C7133a.a(false);
                K = true;
                Y();
                y();
                return;
            case 402:
                Object obj = X;
                synchronized (obj) {
                    if (W == null) {
                        return;
                    }
                    V = true;
                    if (C7143b.q()) {
                        return;
                    }
                    if (!C7137d.e()) {
                        C7134a.c("DEBUG", C7137d.b());
                        return;
                    } else if (!d(LogType.UNEXP_TYPE)) {
                        C7134a.d("DEBUG", "unexp sample miss");
                        return;
                    } else {
                        int nativeGenerateUnexpLog = JNIBridge.nativeGenerateUnexpLog(C7152g.o(), C7152g.p());
                        if (nativeGenerateUnexpLog != 0) {
                            C7151f.a(11);
                            if ((nativeGenerateUnexpLog & LogType.UNEXP_KILL_PROCESS) != 0) {
                                Y = 105;
                                i3 = 30;
                            } else if ((nativeGenerateUnexpLog & 8448) != 0) {
                                Y = 104;
                                i3 = 31;
                            } else if ((nativeGenerateUnexpLog & LogType.UNEXP_RESTART) != 0) {
                                Y = 106;
                                i3 = 32;
                            } else {
                                if ((nativeGenerateUnexpLog & 1280) != 0) {
                                    Y = 103;
                                    C7151f.a(10);
                                } else if ((nativeGenerateUnexpLog & 2304) != 0) {
                                    Y = 107;
                                    C7151f.a(29);
                                } else {
                                    Y = 102;
                                }
                                a(true);
                            }
                            C7151f.a(i3);
                            a(true);
                        }
                        synchronized (obj) {
                            W = null;
                        }
                        return;
                    }
                }
            case 403:
                aa();
                return;
            case 404:
            default:
                if (!a) {
                    throw new AssertionError();
                }
                return;
            case 405:
                K = false;
                StringBuilder X2 = X();
                String g2 = C7143b.g();
                if (X2 != null) {
                    C7140g.a(new File(g2), X2.toString());
                    return;
                }
                return;
            case 406:
                if (!a && objArr == null) {
                    throw new AssertionError();
                }
                a((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Boolean) objArr[2]).booleanValue());
                return;
            case 407:
                try {
                    C7133a.d();
                    return;
                } catch (Throwable th) {
                    C7140g.a(th);
                    return;
                }
            case RpcException.ErrorCode.API_UNAUTHORIZED /* 408 */:
                synchronized (aa) {
                    if (!ab && C7152g.O() && C7143b.z()) {
                        C7143b.s();
                        C7141h.f();
                        C7151f.c();
                        if (C7143b.F()) {
                            C();
                        }
                        if (C7152g.O()) {
                            a(Calendar.getInstance());
                        }
                        ab = true;
                        return;
                    }
                    return;
                }
            case 409:
                d(false);
                return;
            case 410:
                a(false, true);
                return;
            case 411:
                if (C7143b.d) {
                    JNIBridge.set(28, d(LogType.NATIVE_TYPE));
                    JNIBridge.set(29, d("anr"));
                    return;
                }
                return;
            case 412:
                if (!Q && C7143b.B() && C7152g.K()) {
                    b(C7140g.a());
                    return;
                } else if (Q) {
                    if (C7143b.B() && C7152g.K()) {
                        return;
                    }
                    try {
                        C7140g.a().unregisterReceiver(P);
                        Q = false;
                        return;
                    } catch (Throwable th2) {
                        C7140g.a(th2);
                        return;
                    }
                } else {
                    return;
                }
            case 413:
                JNIBridge.cmd(8);
                return;
            case 414:
                try {
                    if (d(C7140g.a())) {
                        return;
                    }
                    int i4 = M + 1;
                    M = i4;
                    if (i4 < 10) {
                        W();
                        return;
                    } else if (C7143b.d) {
                        JNIBridge.set(130, "(get failed)");
                        return;
                    } else {
                        return;
                    }
                } catch (Throwable th3) {
                    C7140g.a(th3);
                    return;
                }
            case 415:
                if (!a && objArr == null) {
                    throw new AssertionError();
                }
                long longValue = ((Long) objArr[0]).longValue();
                Calendar calendar = Calendar.getInstance();
                if (calendar.getTimeInMillis() >= longValue) {
                    C7141h.g();
                    C7151f.a(100);
                    d(true);
                    C7151f.a(true);
                    C7141h.b();
                } else {
                    C7141h.h();
                    C7141h.i();
                    C7141h.c();
                }
                a(calendar);
                break;
            case TypedValues.Cycle.TYPE_PATH_ROTATE /* 416 */:
                break;
        }
        V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.uc.crashsdk.e$a */
    /* loaded from: classes11.dex */
    public static class C7147a extends OutputStream {
        private final long a;
        private final OutputStream b;
        private int c = 0;
        private int d = 0;
        private boolean e = false;

        C7147a(long j, OutputStream outputStream) {
            this.a = j;
            this.b = outputStream;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private int a(byte[] r7, int r8, int r9) {
            /*
                r6 = this;
                int r0 = r6.d
                int r0 = r0 + r9
                r6.d = r0
                boolean r0 = r6.e
                if (r0 == 0) goto Lb
                r7 = 0
                return r7
            Lb:
                int r0 = com.uc.crashsdk.C7152g.y()
                if (r0 <= 0) goto L19
                int r1 = r6.c
                int r2 = r1 + r9
                if (r2 <= r0) goto L19
                int r0 = r0 - r1
                goto L1a
            L19:
                r0 = r9
            L1a:
                int r1 = r6.c
                int r1 = r1 + r0
                r6.c = r1
                long r1 = r6.a
                r3 = 0
                int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r5 == 0) goto L30
                java.lang.String r1 = new java.lang.String
                r1.<init>(r7, r8, r0)
                r6.b(r1)
                goto L35
            L30:
                java.io.OutputStream r1 = r6.b
                r1.write(r7, r8, r0)
            L35:
                if (r0 >= r9) goto L3a
                r7 = 1
                r6.e = r7
            L3a:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.C7146e.C7147a.a(byte[], int, int):int");
        }

        private void b(String str) {
            if (C7143b.d) {
                JNIBridge.nativeClientWriteData(this.a, str);
            }
        }

        @Override // java.io.OutputStream
        public final void write(int i) {
            if (C7146e.h && C7146e.I()) {
                C7134a.d("DEBUG", String.format(Locale.US, "%c", Integer.valueOf(i)));
            }
            if (this.a != 0) {
                b(String.format(Locale.US, "%c", Integer.valueOf(i)));
            } else {
                this.b.write(i);
            }
            this.c++;
            this.d++;
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr, int i, int i2) {
            if (C7146e.h && C7146e.I()) {
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, i, bArr2, 0, i2);
                if (i2 != 1 || bArr2[0] != 10) {
                    try {
                        C7134a.d("DEBUG", new String(bArr2));
                    } catch (Throwable unused) {
                    }
                }
            }
            a(bArr, i, i2);
        }

        final void a() {
            try {
                if (this.d - this.c > 0) {
                    a(StringUtils.LF);
                    a("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
                }
                a(String.format(Locale.US, "Full: %d bytes, write: %d bytes, limit: %d bytes, reject: %d bytes.\n", Integer.valueOf(this.d), Integer.valueOf(this.c), Integer.valueOf(C7152g.y()), Integer.valueOf(this.d - this.c)));
            } catch (Throwable th) {
                C7140g.a(th);
            }
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr) {
            if (C7146e.h && C7146e.I() && (bArr.length != 1 || bArr[0] != 10)) {
                try {
                    C7134a.d("DEBUG", new String(bArr));
                } catch (Throwable unused) {
                }
            }
            a(bArr, 0, bArr.length);
        }

        final void a(String str) {
            if (C7146e.h && C7146e.I()) {
                C7134a.d("DEBUG", str);
            }
            if (this.a != 0) {
                b(str);
            } else {
                this.b.write(str.getBytes("UTF-8"));
            }
        }
    }

    public static String h() {
        String str = m;
        if (str != null) {
            return str;
        }
        String a2 = a(Process.myPid());
        m = a2;
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.uc.crashsdk.e$d */
    /* loaded from: classes11.dex */
    public static class C7150d {
        long a;
        long b;
        int c;
        int d;
        boolean e;
        boolean f;
        boolean g;

        private C7150d() {
            this.a = 0L;
            this.b = 0L;
            this.c = 0;
            this.d = 0;
            this.e = false;
            this.f = false;
            this.g = false;
        }

        /* synthetic */ C7150d(byte b) {
            this();
        }
    }

    public static void j() {
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(StrictMode.getThreadPolicy()).permitNetwork().build());
        } catch (Throwable th) {
            C7140g.a(th);
        }
    }

    public static void m() {
        if (ae) {
            return;
        }
        C7139f.a(1, new RunnableC7138e(411), 1000L);
    }

    public static void p() {
        String str;
        Throwable th;
        if (C7140g.a(A)) {
            String str2 = null;
            try {
                File file = new File(C7152g.U() + "unique");
                if (file.exists()) {
                    str = C7140g.a(file, 48, false);
                    try {
                        if (str != null) {
                            try {
                                if (str.length() == 36) {
                                    str2 = str.replaceAll("[^0-9a-zA-Z-]", "-");
                                }
                            } catch (Exception e) {
                                C7140g.a(e);
                            }
                        }
                        str2 = str;
                    } catch (Throwable th2) {
                        th = th2;
                        C7140g.a(th);
                        str2 = str;
                        A = str2;
                    }
                }
                if (C7140g.a(str2)) {
                    C7143b.G();
                    str2 = UUID.randomUUID().toString();
                    if (!C7140g.a(str2)) {
                        C7140g.a(file, str2.getBytes());
                    }
                }
            } catch (Throwable th3) {
                str = str2;
                th = th3;
            }
            A = str2;
        }
    }

    public static String q() {
        return A;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void r() {
        N = false;
        if (!C7143b.B()) {
            C7139f.a(3, new RunnableC7138e(TypedValues.Cycle.TYPE_PATH_ROTATE), 11000L);
        }
        if (U()) {
            return;
        }
        M = 0;
        W();
    }

    private static void b(OutputStream outputStream, String str, String str2) {
        String str3;
        String str4;
        try {
            outputStream.write("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            Locale locale = Locale.US;
            outputStream.write(String.format(locale, "Basic Information: 'pid: %d/tid: %d/time: %s'\n", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()), n()).getBytes("UTF-8"));
            Object[] objArr = new Object[3];
            objArr[0] = e();
            if (C7140g.a(l)) {
                S();
            }
            objArr[1] = l;
            objArr[2] = f();
            outputStream.write(String.format(locale, "Cpu Information: 'abi: %s/processor: %s/hardware: %s'\n", objArr).getBytes("UTF-8"));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            Locale locale2 = Locale.US;
            outputStream.write(String.format(locale2, "Mobile Information: 'model: %s/version: %s/sdk: %d'\n", com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL(), Build.VERSION.getRELEASE(), Integer.valueOf(Build.VERSION.SDK_INT)).getBytes("UTF-8"));
            outputStream.write(("Build fingerprint: '" + android.os.Build.FINGERPRINT + "'\n").getBytes("UTF-8"));
            Object[] objArr2 = new Object[4];
            objArr2[0] = a(new Date(b));
            objArr2[1] = Long.valueOf(Runtime.getRuntime().maxMemory());
            objArr2[2] = C7140g.d();
            objArr2[3] = C7143b.B() ? "fg" : "bg";
            outputStream.write(String.format(locale2, "Runtime Information: 'start: %s/maxheap: %s/primaryabi: %s/ground: %s'\n", objArr2).getBytes("UTF-8"));
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        try {
            Locale locale3 = Locale.US;
            outputStream.write(String.format(locale3, "Application Information: 'version: %s/subversion: %s/buildseq: %s/versioncode: %d'\n", C7152g.R(), C7152g.S(), C7152g.T(), Integer.valueOf(C7133a.c())).getBytes("UTF-8"));
            String str5 = "0";
            String str6 = "";
            if (C7143b.d) {
                String nativeGet = JNIBridge.nativeGet(1, 0L, null);
                str4 = JNIBridge.nativeGet(2, 0L, null);
                str5 = nativeGet;
            } else {
                str4 = "";
            }
            outputStream.write(String.format(locale3, "CrashSDK Information: 'version: %s/nativeseq: %s/javaseq: %s/arch: %s/target: %s'\n", CrashReporter._VERSION, str5, "200915125514", str4, "release").getBytes("UTF-8"));
            if (str != null) {
                str6 = str;
            }
            outputStream.write(("Report Name: " + str6.substring(str6.lastIndexOf(47) + 1) + StringUtils.LF).getBytes("UTF-8"));
        } catch (Throwable th4) {
            a(th4, outputStream);
        }
        try {
            if (ae) {
                str3 = s("UUID");
            } else {
                str3 = A;
            }
            outputStream.write(String.format("UUID: %s\n", str3).getBytes("UTF-8"));
            outputStream.write(("Log Type: " + str2 + StringUtils.LF).getBytes("UTF-8"));
        } catch (Throwable th5) {
            a(th5, outputStream);
        }
        try {
            String E2 = C7143b.E();
            if (C7140g.a(E2)) {
                E2 = "(none)";
            }
            outputStream.write(("Activity: " + E2 + StringUtils.LF).getBytes("UTF-8"));
        } catch (Throwable th6) {
            a(th6, outputStream);
        }
        a(outputStream);
        try {
            C7133a.a(outputStream, "UTF-8");
            if (ae) {
                h = false;
                outputStream.write(s(MtopParamType.HEADER).getBytes("UTF-8"));
                h = true;
            }
        } catch (Throwable th7) {
            a(th7, outputStream);
        }
        a(outputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String n() {
        return a(new Date());
    }

    private static void g(OutputStream outputStream) {
        String m2;
        try {
            outputStream.write("recent status:\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            if (ae) {
                m2 = s("LASTVER");
            } else {
                m2 = C7133a.m();
            }
            outputStream.write(String.format(Locale.US, "last version: '%s'\n", m2).getBytes("UTF-8"));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            ArrayList<String> arrayList = r;
            synchronized (arrayList) {
                if (t != null) {
                    outputStream.write(String.format(Locale.US, "generating log: %s\n", t).getBytes("UTF-8"));
                }
                if (s > 0 || arrayList.size() > 0) {
                    outputStream.write(String.format(Locale.US, "generated %d logs, recent are:\n", Integer.valueOf(s)).getBytes("UTF-8"));
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        outputStream.write(String.format(Locale.US, "* %s\n", it.next()).getBytes("UTF-8"));
                    }
                }
            }
            Locale locale = Locale.US;
            outputStream.write(String.format(locale, "dumping all threads: %s\n", Boolean.valueOf(u)).getBytes("UTF-8"));
            String str = v;
            if (str != null) {
                outputStream.write(String.format(locale, "dumping threads: %s\n", str).getBytes("UTF-8"));
            }
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        a(outputStream);
    }

    public static void c(String str) {
        synchronized (y) {
            String l2 = C7143b.l();
            C7135b.a(l2, str + StringUtils.LF);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(boolean z2) {
        boolean z3 = true;
        if (!Q ? !z2 || !C7152g.K() : z2 && C7152g.K()) {
            z3 = false;
        }
        if (z3) {
            RunnableC7138e runnableC7138e = R;
            if (C7139f.b(runnableC7138e)) {
                C7139f.a(runnableC7138e);
            }
            C7139f.a(0, runnableC7138e, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z2) {
        File[] listFiles;
        try {
            if (C7143b.y() && (listFiles = new File(C7152g.V()).listFiles()) != null) {
                int l2 = C7152g.l();
                int m2 = C7152g.m();
                if (listFiles.length < Math.min(l2, m2)) {
                    return;
                }
                int i2 = 0;
                int i3 = 0;
                for (File file : listFiles) {
                    if (b(file)) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
                int i4 = (!z2 || i2 < l2) ? 0 : (i2 - l2) + 1;
                int i5 = (z2 || i3 < m2) ? 0 : (i3 - m2) + 1;
                if (i4 == 0 && i5 == 0) {
                    return;
                }
                Arrays.sort(listFiles, new C7148b((byte) 0));
                int i6 = i4;
                int i7 = i5;
                for (File file2 : listFiles) {
                    boolean b2 = b(file2);
                    if (b2 && i6 > 0) {
                        C7134a.a("crashsdk", "Delete oldest crash log: " + file2.getPath());
                        file2.delete();
                        i6 += -1;
                    } else if (!b2 && i7 > 0) {
                        C7134a.a("crashsdk", "Delete oldest custom log: " + file2.getPath());
                        file2.delete();
                        i7 += -1;
                    }
                    if (i6 == 0 && i7 == 0) {
                        break;
                    }
                }
                C7151f.a(16, i4 + i5);
                if (i4 > 0) {
                    C7151f.a(22, i4);
                }
                if (i5 > 0) {
                    C7151f.a(23, i5);
                }
            }
        } catch (Throwable th) {
            C7140g.a(th);
        }
    }

    public static int f(boolean z2) {
        int b2;
        if (z2) {
            b2 = C7151f.a(C7143b.c()) ? 1 : 0;
        } else {
            b2 = C7151f.b();
        }
        int b3 = C7151f.b(z2);
        return b3 > b2 ? b3 : b2;
    }

    public static void o() {
        b = System.currentTimeMillis();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0025 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void e(java.io.OutputStream r12) {
        /*
            java.lang.String r0 = "UTF-8"
            r1 = 0
            r2 = 0
            int r3 = com.uc.crashsdk.C7152g.I()     // Catch: java.lang.Throwable -> L1c
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L1a
            java.lang.String r5 = "/proc/self/task"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L1a
            java.io.File[] r2 = r4.listFiles()     // Catch: java.lang.Throwable -> L1a
            if (r2 != 0) goto L16
            return
        L16:
            int r4 = r2.length     // Catch: java.lang.Throwable -> L1a
            if (r4 >= r3) goto L23
            return
        L1a:
            r4 = move-exception
            goto L1f
        L1c:
            r4 = move-exception
            r3 = 300(0x12c, float:4.2E-43)
        L1f:
            com.uc.crashsdk.a.C7140g.a(r4)
            r4 = 0
        L23:
            if (r2 != 0) goto L26
            return
        L26:
            java.lang.String r5 = "threads info:\n"
            byte[] r5 = r5.getBytes(r0)     // Catch: java.lang.Throwable -> L8e
            r12.write(r5)     // Catch: java.lang.Throwable -> L8e
            java.util.Locale r5 = java.util.Locale.US     // Catch: java.lang.Throwable -> L8e
            java.lang.String r6 = "threads count: %d, dump limit: %d.\n"
            r7 = 2
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L8e
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L8e
            r8[r1] = r4     // Catch: java.lang.Throwable -> L8e
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L8e
            r4 = 1
            r8[r4] = r3     // Catch: java.lang.Throwable -> L8e
            java.lang.String r3 = java.lang.String.format(r5, r6, r8)     // Catch: java.lang.Throwable -> L8e
            byte[] r3 = r3.getBytes(r0)     // Catch: java.lang.Throwable -> L8e
            r12.write(r3)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r3 = " tid     name\n"
            byte[] r3 = r3.getBytes(r0)     // Catch: java.lang.Throwable -> L8e
            r12.write(r3)     // Catch: java.lang.Throwable -> L8e
            int r3 = r2.length     // Catch: java.lang.Throwable -> L8e
            r5 = 0
        L59:
            if (r5 >= r3) goto L92
            r6 = r2[r5]     // Catch: java.lang.Throwable -> L8e
            java.io.File r8 = new java.io.File     // Catch: java.lang.Throwable -> L8e
            java.lang.String r9 = r6.getPath()     // Catch: java.lang.Throwable -> L8e
            java.lang.String r10 = "comm"
            r8.<init>(r9, r10)     // Catch: java.lang.Throwable -> L8e
            r9 = 128(0x80, float:1.8E-43)
            java.lang.String r8 = com.uc.crashsdk.a.C7140g.a(r8, r9, r1)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r8 = l(r8)     // Catch: java.lang.Throwable -> L8e
            java.util.Locale r9 = java.util.Locale.US     // Catch: java.lang.Throwable -> L8e
            java.lang.String r10 = "%5s %s\n"
            java.lang.Object[] r11 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L8e
            java.lang.String r6 = r6.getName()     // Catch: java.lang.Throwable -> L8e
            r11[r1] = r6     // Catch: java.lang.Throwable -> L8e
            r11[r4] = r8     // Catch: java.lang.Throwable -> L8e
            java.lang.String r6 = java.lang.String.format(r9, r10, r11)     // Catch: java.lang.Throwable -> L8e
            byte[] r6 = r6.getBytes(r0)     // Catch: java.lang.Throwable -> L8e
            r12.write(r6)     // Catch: java.lang.Throwable -> L8e
            int r5 = r5 + 1
            goto L59
        L8e:
            r0 = move-exception
            a(r0, r12)
        L92:
            a(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.C7146e.e(java.io.OutputStream):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder f(String str) {
        return a(Thread.currentThread().getStackTrace(), str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(String str) {
        if (ae) {
            return true;
        }
        try {
            return p(str);
        } catch (Throwable th) {
            C7140g.a(th);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(Context context) {
        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        boolean z2 = false;
        if (activityManager == null || (processesInErrorState = activityManager.getProcessesInErrorState()) == null) {
            return false;
        }
        int myPid = Process.myPid();
        Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.ProcessErrorStateInfo next = it.next();
            if (next.pid == myPid) {
                N = true;
                if (N()) {
                    C7134a.d("crashsdk", "ANR occurred in process: " + next.processName);
                }
                if (C7143b.d) {
                    JNIBridge.set(130, next.longMsg);
                }
                z2 = true;
            }
        }
        if (!z2 && C7143b.d) {
            V();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0063, code lost:
        r3.write(r4.getBytes("UTF-8"));
        r3.write(org.apache.commons.lang3.StringUtils.LF.getBytes("UTF-8"));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r8, java.lang.String r9) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L79
            r1 = 26
            java.lang.String r2 = "ps"
            if (r0 < r1) goto Lf
            java.lang.String r0 = "-ef"
            java.lang.String[] r0 = new java.lang.String[]{r2, r0}     // Catch: java.lang.Throwable -> L79
            goto L13
        Lf:
            java.lang.String[] r0 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L79
        L13:
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L79
            java.lang.Process r0 = r1.exec(r0)     // Catch: java.lang.Throwable -> L79
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L79
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L79
            java.io.InputStream r0 = r0.getInputStream()     // Catch: java.lang.Throwable -> L79
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L79
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L79
            boolean r0 = com.uc.crashsdk.a.C7140g.b(r8)     // Catch: java.lang.Throwable -> L79
            boolean r2 = com.uc.crashsdk.a.C7140g.b(r9)     // Catch: java.lang.Throwable -> L79
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L79
            r3.<init>()     // Catch: java.lang.Throwable -> L79
        L36:
            java.lang.String r4 = r1.readLine()     // Catch: java.lang.Throwable -> L79
            java.lang.String r5 = "UTF-8"
            if (r4 == 0) goto L74
            r6 = 1
            if (r0 == 0) goto L47
            boolean r7 = r4.contains(r8)     // Catch: java.lang.Throwable -> L79
            if (r7 != 0) goto L61
        L47:
            if (r2 == 0) goto L50
            boolean r7 = r4.contains(r9)     // Catch: java.lang.Throwable -> L79
            if (r7 == 0) goto L50
            goto L61
        L50:
            r7 = 47
            int r7 = r4.indexOf(r7)     // Catch: java.lang.Throwable -> L79
            if (r7 >= 0) goto L60
            r7 = 46
            int r7 = r4.indexOf(r7)     // Catch: java.lang.Throwable -> L79
            if (r7 > 0) goto L61
        L60:
            r6 = 0
        L61:
            if (r6 == 0) goto L36
            byte[] r4 = r4.getBytes(r5)     // Catch: java.lang.Throwable -> L79
            r3.write(r4)     // Catch: java.lang.Throwable -> L79
            java.lang.String r4 = "\n"
            byte[] r4 = r4.getBytes(r5)     // Catch: java.lang.Throwable -> L79
            r3.write(r4)     // Catch: java.lang.Throwable -> L79
            goto L36
        L74:
            java.lang.String r8 = r3.toString(r5)     // Catch: java.lang.Throwable -> L79
            return r8
        L79:
            r8 = move-exception
            com.uc.crashsdk.a.C7140g.a(r8)
            java.lang.String r8 = "exception exists."
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.C7146e.a(java.lang.String, java.lang.String):java.lang.String");
    }

    public static void d(boolean z2) {
        C7151f.d(false);
        if (z2) {
            C7151f.a(C7143b.c(), false);
            C7141h.i();
            return;
        }
        C7151f.a();
        C7141h.i();
    }

    public static boolean e(String str) {
        try {
            if (C7140g.b(str) && str.startsWith(SolidMonitor.CHECK_TYPE_LIB) && str.endsWith(".so")) {
                System.loadLibrary(str.substring(3, str.length() - 3));
                return true;
            }
            return false;
        } catch (Throwable th) {
            C7140g.a(th);
            return false;
        }
    }

    public static int e(boolean z2) {
        return C7151f.a(z2);
    }

    private static BufferedReader a(InputStreamReader inputStreamReader) {
        BufferedReader bufferedReader = null;
        int i2 = 8192;
        while (bufferedReader == null && i2 > 0) {
            try {
                bufferedReader = new BufferedReader(inputStreamReader, i2);
            } catch (Throwable unused) {
                i2 /= 2;
                if (i2 < 512) {
                    break;
                }
            }
        }
        return bufferedReader;
    }

    private static void a(OutputStream outputStream) {
        try {
            outputStream.write("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
    }

    private static String a(File file) {
        String str;
        try {
            str = file.getCanonicalPath();
        } catch (Throwable unused) {
            str = null;
        }
        return C7140g.a(str) ? file.getPath() : str;
    }

    private static void a(OutputStream outputStream, String str, Set<String> set) {
        if (C7140g.a(str) || set.contains(str) || str.equals("/storage/emulated")) {
            return;
        }
        set.add(str);
        try {
            StatFs statFs = new StatFs(str);
            long a2 = a(statFs, "getBlockCountLong", "getBlockCount");
            long a3 = a(statFs, "getBlockSizeLong", "getBlockSize");
            if ((a2 / 1024) * a3 < FileUtil.LOCAL_REPORT_FILE_MAX_SIZE) {
                return;
            }
            long a4 = a(statFs, "getAvailableBlocksLong", "getAvailableBlocks");
            long a5 = a(statFs, "getFreeBlocksLong", "getFreeBlocks");
            try {
                Locale locale = Locale.US;
                outputStream.write(String.format(locale, "%s:\n", str).getBytes("UTF-8"));
                double d2 = a3;
                outputStream.write(String.format(locale, "  total:      %d kB\n", Long.valueOf((long) (((a2 * 1.0d) * d2) / 1024.0d))).getBytes("UTF-8"));
                outputStream.write(String.format(locale, "  available:  %d kB\n", Long.valueOf((long) (((a4 * 1.0d) * d2) / 1024.0d))).getBytes("UTF-8"));
                outputStream.write(String.format(locale, "  free:       %d kB\n", Long.valueOf((long) (((a5 * 1.0d) * d2) / 1024.0d))).getBytes("UTF-8"));
                outputStream.write(String.format(locale, "  block size: %d B\n\n", Long.valueOf(a3)).getBytes("UTF-8"));
            } catch (Throwable th) {
                a(th, outputStream);
            }
        } catch (Throwable unused) {
        }
    }

    private static void b(OutputStream outputStream) {
        BufferedReader bufferedReader = null;
        try {
            outputStream.write("logcat:\n".getBytes("UTF-8"));
        } finally {
            try {
                C7140g.a(bufferedReader);
                a(outputStream);
            } finally {
            }
        }
        if (C7152g.n() <= 0) {
            outputStream.write("[DEBUG] custom java logcat lines count is 0!\n".getBytes("UTF-8"));
            a(outputStream);
            return;
        }
        int n2 = C7152g.n();
        bufferedReader = a(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"logcat", "-d", "-b", "events", "-b", lu2.MAIN, "-v", "threadtime", "-t", String.valueOf(n2)}).getInputStream()));
        if (bufferedReader == null) {
            outputStream.write("[DEBUG] alloc buffer failed!\n".getBytes("UTF-8"));
            a(outputStream);
            return;
        }
        h = false;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            i2++;
            if (i3 < n2 && !readLine.contains(" I auditd ") && !readLine.contains(" I liblog ")) {
                outputStream.write(readLine.getBytes("UTF-8"));
                outputStream.write(StringUtils.LF.getBytes("UTF-8"));
                i3++;
            }
        }
        outputStream.write(String.format(Locale.US, "[DEBUG] Read %d lines, wrote %d lines.\n", Integer.valueOf(i2), Integer.valueOf(i3)).getBytes("UTF-8"));
        h = true;
        C7140g.a(bufferedReader);
        a(outputStream);
    }

    private static long a(StatFs statFs, String str, String str2) {
        try {
            if (Build.VERSION.SDK_INT >= 18) {
                Method declaredMethod = StatFs.class.getDeclaredMethod(str, new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(statFs, new Object[0]);
                if (invoke != null && (invoke instanceof Long)) {
                    return ((Long) invoke).longValue();
                }
            }
        } catch (Throwable unused) {
        }
        try {
            Method declaredMethod2 = StatFs.class.getDeclaredMethod(str2, new Class[0]);
            declaredMethod2.setAccessible(true);
            Object invoke2 = declaredMethod2.invoke(statFs, new Object[0]);
            if (invoke2 == null || !(invoke2 instanceof Integer)) {
                return 0L;
            }
            return ((Integer) invoke2).intValue();
        } catch (Throwable th) {
            C7140g.a(th);
            return 0L;
        }
    }

    private static void b(C7147a c7147a) {
        h = false;
        try {
            c7147a.write((s("LOG_END") + StringUtils.LF).getBytes("UTF-8"));
        } catch (Throwable th) {
            C7140g.a(th);
        }
        h = true;
    }

    private static void a(C7147a c7147a) {
        try {
            c7147a.a(String.format(Locale.US, "log end: %s\n", n()));
        } catch (Throwable th) {
            a(th, c7147a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(OutputStream outputStream, String str, int i2) {
        int i3;
        DataInputStream dataInputStream;
        int i4;
        DataInputStream dataInputStream2 = null;
        int i5 = 0;
        try {
            File file = new File(str);
            if (file.exists()) {
                byte[] Q2 = Q();
                if (Q2 == null) {
                    outputStream.write("(alloc buffer failed!)\n".getBytes("UTF-8"));
                    return 0;
                }
                dataInputStream = new DataInputStream(new FileInputStream(file));
                i4 = 0;
                i3 = 0;
                loop0: while (true) {
                    boolean z2 = false;
                    while (true) {
                        try {
                            int read = dataInputStream.read(Q2);
                            if (read == -1) {
                                break loop0;
                            }
                            i4 += read;
                            int i6 = i2 - i3;
                            if (read <= i6 + 32) {
                                i6 = read;
                            }
                            if (i6 > 0 && !z2) {
                                outputStream.write(Q2, 0, i6);
                                i3 += i6;
                            }
                            if (!z2) {
                                if (i6 < read || i3 >= i2) {
                                    z2 = true;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            i5 = i3;
                            dataInputStream2 = dataInputStream;
                            try {
                                a(th, outputStream);
                                C7140g.a(dataInputStream2);
                                i3 = i5;
                                a(outputStream);
                                return i3;
                            } finally {
                                C7140g.a(dataInputStream2);
                            }
                        }
                    }
                }
            } else {
                outputStream.write(("file: '" + str + "' not exists!\n").getBytes("UTF-8"));
                dataInputStream = null;
                i4 = 0;
                i3 = 0;
            }
            if (i3 > 0) {
                outputStream.write(StringUtils.LF.getBytes("UTF-8"));
            }
            if (i3 < i4) {
                outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(i4 - i3)).getBytes("UTF-8"));
            }
        } catch (Throwable th2) {
            th = th2;
        }
        a(outputStream);
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(OutputStream outputStream, String str, int i2) {
        int i3 = 0;
        if (str == null) {
            a(outputStream);
            return 0;
        }
        try {
            String a2 = C7135b.a(str);
            if (a2 == null) {
                a2 = "file: '" + str + "' not found or decode failed!";
            }
            int length = a2.length();
            if (length <= i2 + 32) {
                i2 = length;
            }
            if (i2 > 0) {
                try {
                    outputStream.write(a2.getBytes("UTF-8"), 0, i2);
                    outputStream.write(StringUtils.LF.getBytes("UTF-8"));
                } catch (Throwable th) {
                    th = th;
                    i3 = i2;
                    a(th, outputStream);
                    i2 = i3;
                    a(outputStream);
                    return i2;
                }
            }
            if (i2 < a2.length()) {
                outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(a2.length() - i2)).getBytes("UTF-8"));
            }
        } catch (Throwable th2) {
            th = th2;
        }
        a(outputStream);
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(int i2) {
        try {
            String a2 = C7140g.a(new File(String.format(Locale.US, "/proc/%d/cmdline", Integer.valueOf(i2))), 128, false);
            return C7140g.b(a2) ? l(a2) : "unknown";
        } catch (Throwable th) {
            C7140g.a(th);
            return "unknown";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(boolean z2) {
        try {
            boolean z3 = C7152g.r() && C7143b.F() && !d;
            if (!z3) {
                z3 = C7152g.s();
            }
            if (z3) {
                if (z2) {
                    String k2 = k();
                    if (C7140g.a(k2)) {
                        return;
                    }
                    j();
                    a(k2, false, false);
                    return;
                }
                a(true, false);
            }
        } catch (Throwable th) {
            C7140g.a(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:157:0x02d5 A[Catch: all -> 0x032f, TRY_LEAVE, TryCatch #14 {all -> 0x032f, blocks: (B:17:0x003c, B:51:0x0103, B:82:0x017f, B:88:0x018e, B:90:0x0192, B:95:0x01a6, B:101:0x01b1, B:120:0x01f7, B:125:0x020b, B:149:0x02bf, B:155:0x02d1, B:157:0x02d5, B:162:0x02e9, B:173:0x02fd, B:175:0x0301, B:180:0x0315, B:181:0x0317, B:130:0x0223, B:182:0x031d, B:91:0x0194, B:28:0x008f, B:35:0x00bb, B:37:0x00c1, B:39:0x00cb, B:29:0x0098, B:31:0x00a9, B:158:0x02d7, B:96:0x01a8, B:163:0x02eb, B:43:0x00e8, B:111:0x01cb, B:113:0x01cf, B:114:0x01e1, B:116:0x01e7, B:69:0x0125, B:168:0x02f4, B:102:0x01b4, B:11:0x002e, B:13:0x0032, B:78:0x015e, B:47:0x00f5, B:121:0x01fd, B:107:0x01bd, B:83:0x0185, B:19:0x0045, B:52:0x0106, B:24:0x004e, B:150:0x02c8, B:176:0x0303, B:57:0x010f, B:74:0x0139, B:63:0x011a), top: B:216:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0301 A[Catch: all -> 0x032f, TRY_LEAVE, TryCatch #14 {all -> 0x032f, blocks: (B:17:0x003c, B:51:0x0103, B:82:0x017f, B:88:0x018e, B:90:0x0192, B:95:0x01a6, B:101:0x01b1, B:120:0x01f7, B:125:0x020b, B:149:0x02bf, B:155:0x02d1, B:157:0x02d5, B:162:0x02e9, B:173:0x02fd, B:175:0x0301, B:180:0x0315, B:181:0x0317, B:130:0x0223, B:182:0x031d, B:91:0x0194, B:28:0x008f, B:35:0x00bb, B:37:0x00c1, B:39:0x00cb, B:29:0x0098, B:31:0x00a9, B:158:0x02d7, B:96:0x01a8, B:163:0x02eb, B:43:0x00e8, B:111:0x01cb, B:113:0x01cf, B:114:0x01e1, B:116:0x01e7, B:69:0x0125, B:168:0x02f4, B:102:0x01b4, B:11:0x002e, B:13:0x0032, B:78:0x015e, B:47:0x00f5, B:121:0x01fd, B:107:0x01bd, B:83:0x0185, B:19:0x0045, B:52:0x0106, B:24:0x004e, B:150:0x02c8, B:176:0x0303, B:57:0x010f, B:74:0x0139, B:63:0x011a), top: B:216:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x034d A[Catch: all -> 0x035d, TryCatch #9 {all -> 0x035d, blocks: (B:201:0x0349, B:203:0x034d, B:205:0x0357), top: B:222:0x0349 }] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0356  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.lang.Throwable r16, java.lang.String r17, long r18, boolean r20) {
        /*
            Method dump skipped, instructions count: 881
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.C7146e.a(java.lang.Throwable, java.lang.String, long, boolean):java.lang.String");
    }

    private static boolean b(File file) {
        int indexOf;
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(95);
        if (lastIndexOf > 0 && (indexOf = name.indexOf(46, lastIndexOf)) > 0) {
            String substring = name.substring(lastIndexOf + 1, indexOf);
            return "java".equals(substring) || "ucebujava".equals(substring) || LogType.NATIVE_TYPE.equals(substring) || "ucebujni".equals(substring) || LogType.UNEXP_TYPE.equals(substring) || "anr".equals(substring);
        }
        return false;
    }

    private static String b(String str, boolean z2, boolean z3) {
        if (z2) {
            try {
                str = m(str);
            } catch (Throwable th) {
                C7140g.a(th);
            }
        }
        if (z3) {
            try {
                return a(str);
            } catch (Throwable th2) {
                C7140g.a(th2);
                return str;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(String str, String str2, boolean z2) {
        C7141h.a(str, str2, false, z2);
    }

    public static void b(String str) {
        synchronized (x) {
            w = str;
            C7135b.a(C7143b.i(), str + StringUtils.LF);
        }
    }

    private static void b(String str, String str2) {
        try {
            C7145d.a(str, h(), str2);
        } catch (Throwable th) {
            C7140g.a(th);
        }
    }

    public static void b(Context context) {
        if (C7152g.K()) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
                intentFilter.addAction("android.intent.action.BATTERY_LOW");
                intentFilter.addAction("android.intent.action.BATTERY_OKAY");
                context.registerReceiver(P, intentFilter, null, C7139f.a(1));
                Q = true;
            } catch (Throwable th) {
                C7140g.a(th);
            }
        }
    }

    public static void b(int i2) {
        C7139f.a(0, new RunnableC7138e(410), i2 * 1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        int lastIndexOf;
        int indexOf;
        int i2;
        int indexOf2;
        File file;
        byte[] e;
        if (C7152g.x() && (lastIndexOf = str.lastIndexOf(47)) > 0 && (indexOf = str.indexOf(95, lastIndexOf)) > lastIndexOf && (indexOf2 = str.indexOf(95, (i2 = indexOf + 1))) > indexOf) {
            String d2 = C7140g.d(CrashReporter._MAGIC + str.substring(lastIndexOf + 1, indexOf) + str.substring(i2, indexOf2));
            if (d2 == null || (e = C7140g.e((file = new File(str)))) == null || e.length <= 0) {
                return str;
            }
            byte[] bArr = null;
            try {
                bArr = C7136c.b(e, d2.substring(0, 16).getBytes());
            } catch (Throwable th) {
                C7140g.a(th);
            }
            if (bArr == null) {
                return str;
            }
            String str2 = str + ".ec";
            File file2 = new File(str2 + ".tmp");
            if (C7140g.a(file2, bArr)) {
                if (!file2.renameTo(new File(str2))) {
                    file2.delete();
                    return str;
                }
                file.delete();
                return str2;
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Throwable th, OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.write("[DEBUG] CrashHandler occurred new exception:\n".getBytes("UTF-8"));
                th.printStackTrace(new PrintStream(outputStream));
                outputStream.write("\n\n".getBytes("UTF-8"));
            } catch (Throwable th2) {
                C7140g.a(th2);
            }
        }
        C7140g.a(th);
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02f2 A[Catch: all -> 0x0432, TryCatch #2 {all -> 0x043d, blocks: (B:175:0x042c, B:176:0x042e, B:182:0x043b, B:4:0x000a, B:6:0x0010, B:8:0x001f, B:9:0x0034, B:11:0x003a, B:12:0x004d, B:14:0x005d, B:16:0x0067, B:147:0x03bd, B:18:0x006d, B:20:0x007b, B:22:0x008d, B:25:0x00ae, B:27:0x00be, B:31:0x00cb, B:42:0x00f7, B:38:0x00e9, B:62:0x01c4, B:64:0x01d8, B:66:0x01dc, B:67:0x01de, B:69:0x01e3, B:70:0x01e5, B:71:0x01ea, B:81:0x020d, B:82:0x0223, B:84:0x0229, B:86:0x0232, B:88:0x023e, B:90:0x025d, B:91:0x0270, B:93:0x0282, B:95:0x0290, B:96:0x02a1, B:110:0x02e3, B:113:0x02f2, B:116:0x02fe, B:119:0x030d, B:121:0x031b, B:123:0x0328, B:126:0x032f, B:130:0x033c, B:132:0x0348, B:134:0x0362, B:135:0x0367, B:137:0x0377, B:139:0x0384, B:145:0x03ae, B:150:0x03d1, B:152:0x03d8, B:154:0x03df, B:156:0x03e6, B:158:0x03ed, B:160:0x03f4, B:166:0x0406, B:168:0x040d, B:170:0x0414, B:172:0x041b, B:164:0x03ff, B:138:0x037e, B:140:0x03a1, B:142:0x03a6, B:98:0x02a7, B:100:0x02ad, B:103:0x02b5, B:105:0x02b9, B:107:0x02cd, B:109:0x02d1, B:75:0x01f4, B:77:0x0202, B:79:0x0208, B:61:0x01c1, B:173:0x0423), top: B:193:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0348 A[Catch: all -> 0x0432, TryCatch #2 {all -> 0x043d, blocks: (B:175:0x042c, B:176:0x042e, B:182:0x043b, B:4:0x000a, B:6:0x0010, B:8:0x001f, B:9:0x0034, B:11:0x003a, B:12:0x004d, B:14:0x005d, B:16:0x0067, B:147:0x03bd, B:18:0x006d, B:20:0x007b, B:22:0x008d, B:25:0x00ae, B:27:0x00be, B:31:0x00cb, B:42:0x00f7, B:38:0x00e9, B:62:0x01c4, B:64:0x01d8, B:66:0x01dc, B:67:0x01de, B:69:0x01e3, B:70:0x01e5, B:71:0x01ea, B:81:0x020d, B:82:0x0223, B:84:0x0229, B:86:0x0232, B:88:0x023e, B:90:0x025d, B:91:0x0270, B:93:0x0282, B:95:0x0290, B:96:0x02a1, B:110:0x02e3, B:113:0x02f2, B:116:0x02fe, B:119:0x030d, B:121:0x031b, B:123:0x0328, B:126:0x032f, B:130:0x033c, B:132:0x0348, B:134:0x0362, B:135:0x0367, B:137:0x0377, B:139:0x0384, B:145:0x03ae, B:150:0x03d1, B:152:0x03d8, B:154:0x03df, B:156:0x03e6, B:158:0x03ed, B:160:0x03f4, B:166:0x0406, B:168:0x040d, B:170:0x0414, B:172:0x041b, B:164:0x03ff, B:138:0x037e, B:140:0x03a1, B:142:0x03a6, B:98:0x02a7, B:100:0x02ad, B:103:0x02b5, B:105:0x02b9, B:107:0x02cd, B:109:0x02d1, B:75:0x01f4, B:77:0x0202, B:79:0x0208, B:61:0x01c1, B:173:0x0423), top: B:193:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03a1 A[Catch: all -> 0x0432, TryCatch #2 {all -> 0x043d, blocks: (B:175:0x042c, B:176:0x042e, B:182:0x043b, B:4:0x000a, B:6:0x0010, B:8:0x001f, B:9:0x0034, B:11:0x003a, B:12:0x004d, B:14:0x005d, B:16:0x0067, B:147:0x03bd, B:18:0x006d, B:20:0x007b, B:22:0x008d, B:25:0x00ae, B:27:0x00be, B:31:0x00cb, B:42:0x00f7, B:38:0x00e9, B:62:0x01c4, B:64:0x01d8, B:66:0x01dc, B:67:0x01de, B:69:0x01e3, B:70:0x01e5, B:71:0x01ea, B:81:0x020d, B:82:0x0223, B:84:0x0229, B:86:0x0232, B:88:0x023e, B:90:0x025d, B:91:0x0270, B:93:0x0282, B:95:0x0290, B:96:0x02a1, B:110:0x02e3, B:113:0x02f2, B:116:0x02fe, B:119:0x030d, B:121:0x031b, B:123:0x0328, B:126:0x032f, B:130:0x033c, B:132:0x0348, B:134:0x0362, B:135:0x0367, B:137:0x0377, B:139:0x0384, B:145:0x03ae, B:150:0x03d1, B:152:0x03d8, B:154:0x03df, B:156:0x03e6, B:158:0x03ed, B:160:0x03f4, B:166:0x0406, B:168:0x040d, B:170:0x0414, B:172:0x041b, B:164:0x03ff, B:138:0x037e, B:140:0x03a1, B:142:0x03a6, B:98:0x02a7, B:100:0x02ad, B:103:0x02b5, B:105:0x02b9, B:107:0x02cd, B:109:0x02d1, B:75:0x01f4, B:77:0x0202, B:79:0x0208, B:61:0x01c1, B:173:0x0423), top: B:193:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x03ae A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01d8 A[Catch: all -> 0x0432, TryCatch #2 {all -> 0x043d, blocks: (B:175:0x042c, B:176:0x042e, B:182:0x043b, B:4:0x000a, B:6:0x0010, B:8:0x001f, B:9:0x0034, B:11:0x003a, B:12:0x004d, B:14:0x005d, B:16:0x0067, B:147:0x03bd, B:18:0x006d, B:20:0x007b, B:22:0x008d, B:25:0x00ae, B:27:0x00be, B:31:0x00cb, B:42:0x00f7, B:38:0x00e9, B:62:0x01c4, B:64:0x01d8, B:66:0x01dc, B:67:0x01de, B:69:0x01e3, B:70:0x01e5, B:71:0x01ea, B:81:0x020d, B:82:0x0223, B:84:0x0229, B:86:0x0232, B:88:0x023e, B:90:0x025d, B:91:0x0270, B:93:0x0282, B:95:0x0290, B:96:0x02a1, B:110:0x02e3, B:113:0x02f2, B:116:0x02fe, B:119:0x030d, B:121:0x031b, B:123:0x0328, B:126:0x032f, B:130:0x033c, B:132:0x0348, B:134:0x0362, B:135:0x0367, B:137:0x0377, B:139:0x0384, B:145:0x03ae, B:150:0x03d1, B:152:0x03d8, B:154:0x03df, B:156:0x03e6, B:158:0x03ed, B:160:0x03f4, B:166:0x0406, B:168:0x040d, B:170:0x0414, B:172:0x041b, B:164:0x03ff, B:138:0x037e, B:140:0x03a1, B:142:0x03a6, B:98:0x02a7, B:100:0x02ad, B:103:0x02b5, B:105:0x02b9, B:107:0x02cd, B:109:0x02d1, B:75:0x01f4, B:77:0x0202, B:79:0x0208, B:61:0x01c1, B:173:0x0423), top: B:193:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x020d A[Catch: all -> 0x0432, TryCatch #2 {all -> 0x043d, blocks: (B:175:0x042c, B:176:0x042e, B:182:0x043b, B:4:0x000a, B:6:0x0010, B:8:0x001f, B:9:0x0034, B:11:0x003a, B:12:0x004d, B:14:0x005d, B:16:0x0067, B:147:0x03bd, B:18:0x006d, B:20:0x007b, B:22:0x008d, B:25:0x00ae, B:27:0x00be, B:31:0x00cb, B:42:0x00f7, B:38:0x00e9, B:62:0x01c4, B:64:0x01d8, B:66:0x01dc, B:67:0x01de, B:69:0x01e3, B:70:0x01e5, B:71:0x01ea, B:81:0x020d, B:82:0x0223, B:84:0x0229, B:86:0x0232, B:88:0x023e, B:90:0x025d, B:91:0x0270, B:93:0x0282, B:95:0x0290, B:96:0x02a1, B:110:0x02e3, B:113:0x02f2, B:116:0x02fe, B:119:0x030d, B:121:0x031b, B:123:0x0328, B:126:0x032f, B:130:0x033c, B:132:0x0348, B:134:0x0362, B:135:0x0367, B:137:0x0377, B:139:0x0384, B:145:0x03ae, B:150:0x03d1, B:152:0x03d8, B:154:0x03df, B:156:0x03e6, B:158:0x03ed, B:160:0x03f4, B:166:0x0406, B:168:0x040d, B:170:0x0414, B:172:0x041b, B:164:0x03ff, B:138:0x037e, B:140:0x03a1, B:142:0x03a6, B:98:0x02a7, B:100:0x02ad, B:103:0x02b5, B:105:0x02b9, B:107:0x02cd, B:109:0x02d1, B:75:0x01f4, B:77:0x0202, B:79:0x0208, B:61:0x01c1, B:173:0x0423), top: B:193:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0223 A[Catch: all -> 0x0432, TryCatch #2 {all -> 0x043d, blocks: (B:175:0x042c, B:176:0x042e, B:182:0x043b, B:4:0x000a, B:6:0x0010, B:8:0x001f, B:9:0x0034, B:11:0x003a, B:12:0x004d, B:14:0x005d, B:16:0x0067, B:147:0x03bd, B:18:0x006d, B:20:0x007b, B:22:0x008d, B:25:0x00ae, B:27:0x00be, B:31:0x00cb, B:42:0x00f7, B:38:0x00e9, B:62:0x01c4, B:64:0x01d8, B:66:0x01dc, B:67:0x01de, B:69:0x01e3, B:70:0x01e5, B:71:0x01ea, B:81:0x020d, B:82:0x0223, B:84:0x0229, B:86:0x0232, B:88:0x023e, B:90:0x025d, B:91:0x0270, B:93:0x0282, B:95:0x0290, B:96:0x02a1, B:110:0x02e3, B:113:0x02f2, B:116:0x02fe, B:119:0x030d, B:121:0x031b, B:123:0x0328, B:126:0x032f, B:130:0x033c, B:132:0x0348, B:134:0x0362, B:135:0x0367, B:137:0x0377, B:139:0x0384, B:145:0x03ae, B:150:0x03d1, B:152:0x03d8, B:154:0x03df, B:156:0x03e6, B:158:0x03ed, B:160:0x03f4, B:166:0x0406, B:168:0x040d, B:170:0x0414, B:172:0x041b, B:164:0x03ff, B:138:0x037e, B:140:0x03a1, B:142:0x03a6, B:98:0x02a7, B:100:0x02ad, B:103:0x02b5, B:105:0x02b9, B:107:0x02cd, B:109:0x02d1, B:75:0x01f4, B:77:0x0202, B:79:0x0208, B:61:0x01c1, B:173:0x0423), top: B:193:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.lang.String r31, boolean r32, boolean r33) {
        /*
            Method dump skipped, instructions count: 1099
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.C7146e.a(java.lang.String, boolean, boolean):void");
    }

    public static boolean a(boolean z2, boolean z3) {
        if (!d) {
            if (C7143b.d) {
                JNIBridge.set(1, true);
            }
            d = true;
        }
        try {
            String k2 = k();
            if (C7140g.a(k2)) {
                C7134a.a("crashsdk", "CrashHandler url is empty!");
                return false;
            }
            Object obj = n;
            synchronized (obj) {
                if (C7139f.a(z2 ? 1 : 0, new RunnableC7138e(406, new Object[]{k2, Boolean.valueOf(z3), Boolean.valueOf(z2)})) && z2) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        C7140g.a(e);
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            C7140g.a(th);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v7 */
    private static boolean a(String str, RunnableC7138e runnableC7138e) {
        boolean z2;
        FileChannel fileChannel;
        Exception e;
        synchronized (o) {
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e2) {
                    C7140g.a(e2);
                }
            }
            ?? r5 = 0;
            r5 = null;
            FileLock lock = null;
            z2 = false;
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    fileChannel = new RandomAccessFile(file, "rw").getChannel();
                } catch (Exception e3) {
                    try {
                        C7140g.a(e3);
                        fileChannel = null;
                    } catch (Exception e4) {
                        fileChannel = null;
                        e = e4;
                        C7140g.a(e);
                        C7140g.a(fileChannel);
                        return z2;
                    }
                }
                if (fileChannel != null) {
                    try {
                        lock = fileChannel.lock();
                    } catch (Exception e5) {
                        try {
                            C7140g.a(e5);
                        } catch (Exception e6) {
                            e = e6;
                            C7140g.a(e);
                            C7140g.a(fileChannel);
                            return z2;
                        }
                    }
                }
                try {
                    z2 = runnableC7138e.a();
                    C7140g.a(fileChannel);
                } finally {
                    if (lock != null) {
                        try {
                            lock.release();
                        } catch (Exception e7) {
                            C7140g.a(e7);
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                r5 = file;
                C7140g.a((Closeable) r5);
                throw th;
            }
        }
        return z2;
    }

    private static boolean a(String str, C7150d c7150d) {
        String a2 = C7140g.a(new File(str), 64, false);
        if (a2 == null) {
            return false;
        }
        try {
            Matcher matcher = Pattern.compile("(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)").matcher(a2);
            if (matcher.find()) {
                long parseLong = Long.parseLong(matcher.group(1));
                if (System.currentTimeMillis() - parseLong < 86400000) {
                    c7150d.b = Long.parseLong(matcher.group(2));
                    c7150d.c = Integer.parseInt(matcher.group(3));
                    c7150d.d = Integer.parseInt(matcher.group(4));
                    c7150d.a = parseLong;
                }
            }
        } catch (Throwable th) {
            C7140g.a(th);
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v3 */
    public static boolean a(StringBuffer stringBuffer, String str, long j2, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, String str2) {
        long j3;
        boolean z2;
        boolean a2;
        if (c.get()) {
            C7134a.b("Processing java crash, skip generate custom log: " + str);
            return false;
        }
        boolean z3 = ae || C7143b.L();
        if (!z3 && !C7137d.e()) {
            C7134a.c("DEBUG", C7137d.b());
            return false;
        } else if (!d(str)) {
            C7134a.d("DEBUG", "custom log sample miss: " + str);
            return false;
        } else if (Z()) {
            C7134a.b("Processing native crash, skip generate custom log: " + str);
            return false;
        } else if (stringBuffer == null || str == null) {
            return false;
        } else {
            String str3 = C7152g.V() + k(str);
            ?? r11 = (j2 & 32) != 0 ? 1 : 0;
            if (z3) {
                long nativeClientCreateConnection = C7143b.d ? JNIBridge.nativeClientCreateConnection(str3, "custom", str, r11) : 0L;
                if (nativeClientCreateConnection == 0) {
                    C7134a.d("DEBUG", "skip custom log: " + str);
                    return false;
                }
                j3 = nativeClientCreateConnection;
            } else if (a(h(), str, (boolean) r11)) {
                return false;
            } else {
                C7152g.a();
                a(false);
                j3 = 0;
            }
            synchronized (p) {
                z2 = r11;
                a2 = a(str3, j3, stringBuffer, str, j2, arrayList, arrayList2, arrayList3, str2);
            }
            if (a2 && !z3) {
                b(h(), str, z2);
            }
            if (j3 != 0) {
                JNIBridge.nativeClientCloseConnection(j3);
            }
            if (a2) {
                if (!z3) {
                    r(str3);
                }
                if (!z3) {
                    str3 = a(m(str3));
                }
                b(str3, str);
                if (!z2 || z3) {
                    return true;
                }
                try {
                    a(true, false);
                    return true;
                } catch (Throwable th) {
                    C7140g.a(th);
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(String str, String str2, boolean z2) {
        if (o(str2)) {
            C7141h.a(str, str2, true, z2);
            C7134a.b(String.format(Locale.US, "Custom log '%s' has reach max count!", str2));
            return true;
        }
        return false;
    }

    private static void a(C7147a c7147a, String str, long j2) {
        String nativeDumpThreads;
        String str2 = null;
        if (C7143b.d) {
            try {
                c7147a.flush();
            } catch (Throwable th) {
                C7140g.a(th);
            }
            nativeDumpThreads = JNIBridge.nativeDumpThreads(str, j2);
            if (ae || nativeDumpThreads == null || nativeDumpThreads.length() >= 512 || !nativeDumpThreads.startsWith("/") || nativeDumpThreads.indexOf(10) >= 0) {
                str2 = nativeDumpThreads;
            } else {
                if (!new File(nativeDumpThreads).exists()) {
                    str2 = "Can not found " + nativeDumpThreads;
                }
                String str3 = str2;
                str2 = nativeDumpThreads;
                nativeDumpThreads = str3;
            }
        } else {
            nativeDumpThreads = "Native not initialized, skip dump!";
        }
        if (nativeDumpThreads != null) {
            try {
                c7147a.write(nativeDumpThreads.getBytes("UTF-8"));
                c7147a.write(StringUtils.LF.getBytes("UTF-8"));
            } catch (Throwable th2) {
                C7140g.a(th2);
            }
            a((OutputStream) c7147a);
        } else if (str2 != null && !ae) {
            b(c7147a, str2, 1048576);
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
        }
        try {
            c7147a.flush();
        } catch (Throwable th3) {
            C7140g.a(th3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.lang.String r18, long r19, java.lang.StringBuffer r21, java.lang.String r22, long r23, java.util.ArrayList<java.lang.String> r25, java.util.ArrayList<java.lang.String> r26, java.util.ArrayList<java.lang.String> r27, java.lang.String r28) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.C7146e.a(java.lang.String, long, java.lang.StringBuffer, java.lang.String, long, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.lang.String):boolean");
    }

    private static String a(Date date) {
        return String.format(Locale.US, "%d%02d%02d%02d%02d%02d", Integer.valueOf(date.getYear() + 1900), Integer.valueOf(date.getMonth() + 1), Integer.valueOf(date.getDate()), Integer.valueOf(date.getHours()), Integer.valueOf(date.getMinutes()), Integer.valueOf(date.getSeconds()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(OutputStream outputStream, String str, String str2, int i2, boolean z2, boolean z3) {
        h = false;
        try {
            Locale locale = Locale.US;
            Object[] objArr = new Object[5];
            objArr[0] = str;
            objArr[1] = str2;
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(z2 ? 1 : 0);
            objArr[4] = Integer.valueOf(z3 ? 1 : 0);
            outputStream.write(String.format(locale, "$^%s`%s`%d`%d,%d^$", objArr).getBytes("UTF-8"));
        } catch (Throwable th) {
            C7140g.a(th);
        }
        h = true;
        a(outputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(OutputStream outputStream, String str, String str2) {
        h = false;
        try {
            outputStream.write(String.format(Locale.US, "$^%s`%s^$", str, str2).getBytes("UTF-8"));
        } catch (Throwable th) {
            C7140g.a(th);
        }
        h = true;
    }

    public static void a(Context context) {
        try {
            if (U()) {
                context.registerReceiver(new C7149c((byte) 0), new IntentFilter("android.intent.action.ANR"), null, C7139f.a(3));
            }
        } catch (Throwable th) {
            C7140g.a(th);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:(1:365)|(3:397|398|(16:401|402|403|404|(1:370)|371|372|373|374|(1:376)|377|(1:381)|382|(1:385)|387|(2:389|390)(1:391)))|367|(1:370)|371|372|373|374|(0)|377|(2:379|381)|382|(1:385)|387|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(15:142|(3:174|175|(16:178|179|180|181|(1:147)|148|149|151|152|(1:154)|155|(1:159)|160|(1:163)|165|(2:167|168)(1:169)))|144|(1:147)|148|149|151|152|(0)|155|(2:157|159)|160|(1:163)|165|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(15:191|(3:223|224|(16:227|228|229|230|(1:196)|197|198|200|201|(1:203)|204|(1:208)|209|(1:212)|214|(2:216|217)(1:218)))|193|(1:196)|197|198|200|201|(0)|204|(2:206|208)|209|(1:212)|214|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(15:71|(3:103|104|(15:107|108|109|(1:76)|77|78|79|80|(1:82)|83|(1:87)|88|(1:91)|93|(2:95|96)(1:97)))|73|(1:76)|77|78|79|80|(0)|83|(2:85|87)|88|(1:91)|93|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(16:310|(1:314)|(3:346|347|(16:350|351|352|353|(1:319)|320|321|322|323|(1:325)|326|(1:330)|331|(1:334)|336|(2:338|339)(1:340)))|316|(1:319)|320|321|322|323|(0)|326|(2:328|330)|331|(1:334)|336|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(18:11|(5:14|15|16|(1:18)|12)|66|19|(3:52|53|(15:56|57|58|(1:24)|25|26|27|28|(1:30)|31|(1:35)|36|(1:39)|41|(2:43|44)(1:46)))|21|(1:24)|25|26|27|28|(0)|31|(2:33|35)|36|(1:39)|41|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(19:471|472|(1:476)|(3:508|509|(18:512|513|514|515|(0)|507|482|483|484|485|(0)|488|(2:490|492)|493|(1:496)|498|(0)|501))|478|(0)|507|482|483|484|485|(0)|488|(0)|493|(0)|498|(0)|501) */
    /* JADX WARN: Can't wrap try/catch for region: R(21:413|414|415|(1:417)|419|(1:423)|(3:456|457|(17:460|461|462|463|(0)|455|429|430|431|432|(0)|435|(2:437|439)|440|(1:443)|445|(0)(0)))|425|(0)|455|429|430|431|432|(0)|435|(0)|440|(0)|445|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(34:117|118|(2:121|119)|122|123|124|125|126|127|(1:525)|131|132|133|134|(5:136|137|(1:139)(1:302)|140|(15:142|(3:174|175|(16:178|179|180|181|(1:147)|148|149|151|152|(1:154)|155|(1:159)|160|(1:163)|165|(2:167|168)(1:169)))|144|(1:147)|148|149|151|152|(0)|155|(2:157|159)|160|(1:163)|165|(0)(0))(2:189|(15:191|(3:223|224|(16:227|228|229|230|(1:196)|197|198|200|201|(1:203)|204|(1:208)|209|(1:212)|214|(2:216|217)(1:218)))|193|(1:196)|197|198|200|201|(0)|204|(2:206|208)|209|(1:212)|214|(0)(0))(1:238)))(5:(1:304)|305|(1:307)(1:412)|308|(16:310|(1:314)|(3:346|347|(16:350|351|352|353|(1:319)|320|321|322|323|(1:325)|326|(1:330)|331|(1:334)|336|(2:338|339)(1:340)))|316|(1:319)|320|321|322|323|(0)|326|(2:328|330)|331|(1:334)|336|(0)(0))(1:(15:(1:365)|(3:397|398|(16:401|402|403|404|(1:370)|371|372|373|374|(1:376)|377|(1:381)|382|(1:385)|387|(2:389|390)(1:391)))|367|(1:370)|371|372|373|374|(0)|377|(2:379|381)|382|(1:385)|387|(0)(0))))|239|(5:244|(1:246)|247|248|249)|250|(1:254)|(3:287|288|(16:291|292|293|294|(1:286)(1:259)|260|261|262|263|(1:265)|266|(1:270)|271|(1:274)|276|(2:278|279)(1:280)))|256|(0)|286|260|261|262|263|(0)|266|(2:268|270)|271|(1:274)|276|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0134, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0135, code lost:
        com.uc.crashsdk.a.C7140g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0227, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0228, code lost:
        com.uc.crashsdk.a.C7140g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x025f, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0260, code lost:
        com.uc.crashsdk.a.C7140g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x02a6, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x02a7, code lost:
        com.uc.crashsdk.a.C7140g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x02de, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x02df, code lost:
        com.uc.crashsdk.a.C7140g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x0348, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x0349, code lost:
        com.uc.crashsdk.a.C7140g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x0380, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x0381, code lost:
        com.uc.crashsdk.a.C7140g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x03c7, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x03c8, code lost:
        com.uc.crashsdk.a.C7140g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x03ff, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x0400, code lost:
        com.uc.crashsdk.a.C7140g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:367:0x04cb, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:368:0x04cc, code lost:
        com.uc.crashsdk.a.C7140g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x0503, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x0504, code lost:
        com.uc.crashsdk.a.C7140g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:422:0x0580, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:423:0x0581, code lost:
        com.uc.crashsdk.a.C7140g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:437:0x05b8, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:438:0x05b9, code lost:
        com.uc.crashsdk.a.C7140g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007b, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007c, code lost:
        com.uc.crashsdk.a.C7140g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:468:0x0607, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:469:0x0608, code lost:
        com.uc.crashsdk.a.C7140g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:483:0x063f, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:484:0x0640, code lost:
        com.uc.crashsdk.a.C7140g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b3, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b4, code lost:
        com.uc.crashsdk.a.C7140g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00fc, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00fd, code lost:
        com.uc.crashsdk.a.C7140g.a(r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01cf A[Catch: all -> 0x01e6, TRY_ENTER, TRY_LEAVE, TryCatch #42 {all -> 0x051a, blocks: (B:148:0x01fd, B:188:0x0274, B:190:0x027a, B:232:0x02f9, B:233:0x02fe, B:235:0x0302, B:132:0x01cf, B:133:0x01d2, B:135:0x01d8, B:136:0x01dd, B:143:0x01ea), top: B:559:0x01cd }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x021e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0248 A[Catch: all -> 0x025f, TryCatch #46 {all -> 0x025f, blocks: (B:169:0x022c, B:172:0x0237, B:174:0x0248, B:176:0x024c, B:177:0x024f, B:180:0x0257), top: B:565:0x022c }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0255 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x029d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02c7 A[Catch: all -> 0x02de, TryCatch #45 {all -> 0x02de, blocks: (B:211:0x02ab, B:214:0x02b6, B:216:0x02c7, B:218:0x02cb, B:219:0x02ce, B:222:0x02d6), top: B:563:0x02ab }] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02d4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x033f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0369 A[Catch: all -> 0x0380, TryCatch #29 {all -> 0x0380, blocks: (B:265:0x034d, B:268:0x0358, B:270:0x0369, B:272:0x036d, B:273:0x0370, B:276:0x0378), top: B:537:0x034d }] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0376 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:282:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x03be A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:311:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x03e8 A[Catch: all -> 0x03ff, TryCatch #27 {all -> 0x03ff, blocks: (B:309:0x03cc, B:312:0x03d7, B:314:0x03e8, B:316:0x03ec, B:317:0x03ef, B:320:0x03f7), top: B:533:0x03cc }] */
    /* JADX WARN: Removed duplicated region for block: B:319:0x03f5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:326:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0444 A[Catch: all -> 0x0518, TryCatch #41 {all -> 0x0518, blocks: (B:328:0x0414, B:331:0x0426, B:333:0x042c, B:335:0x0444, B:336:0x0447, B:342:0x0477, B:240:0x0310, B:337:0x046e), top: B:559:0x01cd }] */
    /* JADX WARN: Removed duplicated region for block: B:362:0x04bf A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:371:0x04da  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x04ec A[Catch: all -> 0x0503, TryCatch #30 {all -> 0x0503, blocks: (B:369:0x04d0, B:372:0x04db, B:374:0x04ec, B:376:0x04f0, B:377:0x04f3, B:380:0x04fb), top: B:539:0x04d0 }] */
    /* JADX WARN: Removed duplicated region for block: B:379:0x04f9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:386:0x0510  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0072 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:417:0x0574 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:426:0x058f  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x05a1 A[Catch: all -> 0x05b8, TryCatch #23 {all -> 0x05b8, blocks: (B:424:0x0585, B:427:0x0590, B:429:0x05a1, B:431:0x05a5, B:432:0x05a8, B:435:0x05b0), top: B:525:0x0585 }] */
    /* JADX WARN: Removed duplicated region for block: B:434:0x05ae A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:441:0x05c5  */
    /* JADX WARN: Removed duplicated region for block: B:463:0x05fb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:472:0x0616  */
    /* JADX WARN: Removed duplicated region for block: B:475:0x0628 A[Catch: all -> 0x063f, TryCatch #26 {all -> 0x063f, blocks: (B:470:0x060c, B:473:0x0617, B:475:0x0628, B:477:0x062c, B:478:0x062f, B:481:0x0637), top: B:531:0x060c }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x0635 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:487:0x064c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009c A[Catch: all -> 0x00b3, TryCatch #17 {all -> 0x00b3, blocks: (B:45:0x0080, B:48:0x008b, B:50:0x009c, B:52:0x00a0, B:53:0x00a3, B:56:0x00ab), top: B:515:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:523:0x04a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:572:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:573:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:574:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:575:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:576:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:577:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:578:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:579:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x011d A[Catch: all -> 0x0134, TryCatch #19 {all -> 0x0134, blocks: (B:88:0x0101, B:91:0x010c, B:93:0x011d, B:95:0x0121, B:96:0x0124, B:99:0x012c), top: B:519:0x0101 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012a A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.Thread r22, java.lang.Throwable r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 1620
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.C7146e.a(java.lang.Thread, java.lang.Throwable, boolean):void");
    }

    private static void a(Throwable th) {
        try {
            C7134a.d("DEBUG", a(th.getStackTrace(), (String) null).toString());
        } catch (Throwable unused) {
        }
    }

    private static void a(Calendar calendar) {
        if (C7152g.Q()) {
            long timeInMillis = calendar.getTimeInMillis();
            calendar.add(5, 1);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            long timeInMillis2 = calendar.getTimeInMillis();
            long j2 = timeInMillis2 - timeInMillis;
            long j3 = DateUtils.MILLIS_PER_HOUR;
            if (j2 <= DateUtils.MILLIS_PER_HOUR) {
                j3 = 1000 + j2;
            }
            C7139f.a(0, new RunnableC7138e(415, new Object[]{Long.valueOf(timeInMillis2)}), j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder a(StackTraceElement[] stackTraceElementArr, String str) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            boolean z2 = str == null;
            int i3 = 0;
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                i3++;
                sb.append("  at ");
                sb.append(stackTraceElement.toString());
                sb.append(StringUtils.LF);
                if (!z2 && stackTraceElement.getMethodName().contains(str)) {
                    sb.delete(0, sb.length());
                    z2 = true;
                    i3 = 0;
                }
            }
            i2 = i3;
        }
        if (i2 == 0) {
            sb.append("  (no java stack)\n");
        }
        return sb;
    }

    public static boolean a(ParcelFileDescriptor parcelFileDescriptor) {
        if (ad) {
            C7134a.d("crashsdk", "Can not call setHostFd and getHostFd in the same process!");
            return false;
        } else if (!C7143b.d) {
            C7134a.d("crashsdk", "Crash so is not loaded!");
            return false;
        } else {
            if (ac != null) {
                C7134a.c("crashsdk", "Has already set host fd!");
            }
            ac = parcelFileDescriptor;
            int fd = parcelFileDescriptor.getFd();
            int nativeCmd = (int) JNIBridge.nativeCmd(13, fd, null, null);
            ae = nativeCmd != -1;
            return fd == -1 || nativeCmd != -1;
        }
    }
}
