package com.uc.crashsdk;

import android.os.Looper;
import android.os.Process;
import com.uc.crashsdk.a.C7134a;
import com.uc.crashsdk.a.C7139f;
import com.uc.crashsdk.a.C7140g;
import com.uc.crashsdk.a.RunnableC7138e;
import com.uc.crashsdk.export.LogType;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.io.File;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class JNIBridge {
    private static int addCachedInfo(String str, String str2) {
        return C7133a.b(str, str2);
    }

    private static int addDumpFile(String str, String str2, boolean z, boolean z2, int i, boolean z3) {
        return C7133a.a(str, str2, z, z2, i, z3);
    }

    private static void addHeaderInfo(String str, String str2) {
        C7133a.a(str, str2);
    }

    public static long cmd(int i) {
        return nativeCmd(i, 0L, null, null);
    }

    private static int createCachedInfo(String str, int i, int i2) {
        return C7133a.a(str, i, i2);
    }

    private static boolean generateCustomLog(String str, String str2, long j, String str3, String str4, String str5, String str6) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        return C7146e.a(stringBuffer, str2, j, C7133a.c(str3), C7133a.c(str4), C7133a.c(str5), str6);
    }

    protected static String getCallbackInfo(String str, boolean z) {
        return C7133a.a(str, z);
    }

    private static String getDatasForClientJavaLog(int i, String str) {
        boolean equals = "$all$".equals(str);
        if (i == 1) {
            if (equals) {
                return C7133a.h();
            }
            return C7133a.a(str);
        } else if (i == 2) {
            if (equals) {
                return C7133a.j();
            }
            return C7133a.a(str, true);
        } else if (i == 3) {
            if (equals) {
                return C7133a.l();
            }
            return C7133a.b(str);
        } else if (i == 4) {
            return C7146e.d(str) ? "1" : "0";
        } else {
            return null;
        }
    }

    private static String getJavaStackTrace(Thread thread, int i) {
        if (i != 0 && i == Process.myPid()) {
            thread = Looper.getMainLooper().getThread();
        }
        if (thread != null) {
            return C7146e.a(thread.getStackTrace(), "getJavaStackTrace").toString();
        }
        return null;
    }

    public static native boolean nativeAddCachedInfo(String str, String str2);

    public static native int nativeAddCallbackInfo(String str, int i, long j, int i2);

    public static native int nativeAddDumpFile(String str, String str2, boolean z, boolean z2, int i, boolean z3);

    public static native void nativeAddHeaderInfo(String str, String str2);

    public static native boolean nativeChangeState(String str, String str2, boolean z);

    public static native void nativeClientCloseConnection(long j);

    public static native long nativeClientCreateConnection(String str, String str2, String str3, int i);

    public static native int nativeClientWriteData(long j, String str);

    public static native void nativeCloseFile(int i);

    public static native long nativeCmd(int i, long j, String str, Object[] objArr);

    public static native void nativeCrash(int i, int i2);

    public static native int nativeCreateCachedInfo(String str, int i, int i2);

    public static native String nativeDumpThreads(String str, long j);

    public static native int nativeGenerateUnexpLog(long j, int i);

    public static native String nativeGet(int i, long j, String str);

    public static native String nativeGetCallbackInfo(String str, long j, int i, boolean z);

    public static native boolean nativeIsCrashing();

    public static native boolean nativeLockFile(int i, boolean z);

    public static native int nativeLog(int i, String str, String str2);

    public static native int nativeOpenFile(String str);

    public static native long nativeSet(int i, long j, String str, Object[] objArr);

    public static native void nativeSetForeground(boolean z);

    private static void onCrashLogGenerated(String str, String str2, String str3, boolean z) {
        boolean equals = C7146e.h().equals(str2);
        boolean equals2 = LogType.NATIVE_TYPE.equals(str3);
        if (!C7146e.F()) {
            if (equals && equals2) {
                try {
                    C7151f.c(true);
                } catch (Throwable th) {
                    C7140g.a(th);
                }
            }
            str = C7146e.a(str);
        }
        C7145d.a(str, str2, str3);
        if (C7146e.F()) {
            return;
        }
        if (z || (!equals && C7152g.s())) {
            C7146e.a(false, false);
        } else if (equals) {
            C7146e.b(equals2);
        }
    }

    private static void onCrashRestarting() {
        C7145d.a(false);
        C7143b.N();
    }

    private static void onKillProcess(String str, int i, int i2) {
        String str2 = "onKillProcess. SIG: " + i2;
        if (C7146e.a()) {
            C7134a.b("crashsdk", str2);
        } else {
            C7134a.a("crashsdk", str2);
        }
        StringBuilder f = C7146e.f("onKillProcess");
        Locale locale = Locale.US;
        f.insert(0, String.format(locale, "State in disk: '%s'\n", C7143b.p()));
        f.insert(0, String.format(locale, "SIG: %d, fg: %s, exiting: %s, main process: %s, time: %s\n", Integer.valueOf(i2), Boolean.valueOf(C7143b.B()), Boolean.valueOf(C7143b.u()), Boolean.valueOf(C7143b.F()), C7146e.n()));
        f.insert(0, String.format(locale, "Kill PID: %d (%s) by pid: %d (%s) tid: %d (%s)\n", Integer.valueOf(i), C7146e.a(i), Integer.valueOf(Process.myPid()), C7146e.a(Process.myPid()), Integer.valueOf(Process.myTid()), Thread.currentThread().getName()));
        String sb = f.toString();
        if (C7146e.a()) {
            C7134a.b("crashsdk", sb);
        } else {
            C7134a.a("crashsdk", sb);
        }
        if (C7143b.L()) {
            return;
        }
        C7140g.a(new File(str), sb.getBytes());
    }

    private static String onNativeEvent(int i, long j, Object[] objArr) {
        switch (i) {
            case 1:
                return String.valueOf(Runtime.getRuntime().maxMemory());
            case 2:
                return C7146e.d();
            case 3:
                if (objArr != null && objArr.length == 2 && (objArr[0] instanceof String) && (objArr[1] instanceof String)) {
                    return C7146e.a((String) objArr[0], (String) objArr[1]);
                }
                return null;
            case 4:
                return C7146e.g();
            case 5:
                C7133a.a(true);
                break;
            case 6:
                return C7140g.d();
            case 7:
                C7139f.a(2, new RunnableC7138e(102), DanmakuFactory.DEFAULT_DANMAKU_DURATION);
                C7146e.r();
                break;
        }
        return null;
    }

    private static int onPreClientCustomLog(String str, String str2, boolean z) {
        C7152g.a();
        C7146e.a(false);
        if (C7146e.a(str, str2, z)) {
            return 0;
        }
        C7146e.b(str, str2, z);
        return 1;
    }

    private static int registerCurrentThread(String str, int i) {
        return C7133a.a(i, str);
    }

    private static int registerInfoCallback(String str, int i, long j, int i2) {
        return C7133a.a(str, i, null, j, i2);
    }

    public static long set(int i, boolean z) {
        return nativeSet(i, z ? 1L : 0L, null, null);
    }

    public static long cmd(int i, String str) {
        return nativeCmd(i, 0L, str, null);
    }

    public static long set(int i, long j) {
        return nativeSet(i, j, null, null);
    }

    public static long set(int i, String str) {
        return nativeSet(i, 0L, str, null);
    }
}
