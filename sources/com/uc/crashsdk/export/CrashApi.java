package com.uc.crashsdk.export;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.webkit.ValueCallback;
import com.taobao.weex.annotation.JSMethod;
import com.uc.crashsdk.C7133a;
import com.uc.crashsdk.C7143b;
import com.uc.crashsdk.C7145d;
import com.uc.crashsdk.C7146e;
import com.uc.crashsdk.C7152g;
import com.uc.crashsdk.JNIBridge;
import com.uc.crashsdk.a.C7134a;
import com.uc.crashsdk.a.C7137d;
import com.uc.crashsdk.a.C7140g;
import com.uc.crashsdk.a.C7141h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Callable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CrashApi {
    private static CrashApi a = null;
    private static boolean c = true;
    private static boolean d;
    public static final /* synthetic */ int e = 0;
    private boolean b;

    private CrashApi(Context context, CustomInfo customInfo, VersionInfo versionInfo, ICrashClient iCrashClient, boolean z, boolean z2, boolean z3) {
        this.b = false;
        Context a2 = a(context);
        b(a2);
        C7143b.g = z2;
        C7143b.h = z3;
        if (C7143b.L()) {
            b(a2);
            a(a2, customInfo, versionInfo, iCrashClient);
            if (z) {
                a();
            }
            if (C7143b.g && C7146e.e("libcrashsdk.so")) {
                C7143b.f = true;
                b();
            }
        } else if (customInfo != null && versionInfo != null) {
            C7152g.a(customInfo);
            try {
                a(a2, customInfo, versionInfo, iCrashClient);
            } catch (Throwable th) {
                a(th);
            }
            if (z) {
                try {
                    a();
                } catch (Throwable th2) {
                    a(th2);
                }
            }
            try {
                C7143b.M();
                C7141h.a();
                C7137d.a();
                C7140g.j();
            } catch (Throwable th3) {
                C7140g.a(th3);
            }
            try {
                if (!C7143b.a(a2)) {
                    C7134a.d("crashsdk", "registerLifecycleCallbacks failed!");
                }
            } catch (Throwable th4) {
                C7140g.a(th4);
            }
            try {
                C7133a.n();
                C7146e.A();
                C7146e.B();
            } catch (Throwable th5) {
                C7140g.a(th5);
            }
            try {
                if (C7152g.r() && C7143b.F() && !this.b) {
                    C7146e.G();
                    this.b = true;
                }
            } catch (Throwable th6) {
                C7140g.b(th6);
            }
        } else {
            C7134a.d("crashsdk", "VersionInfo and CustomInfo can not be null!");
            throw null;
        }
    }

    private static void a() {
        if (C7143b.a) {
            C7134a.b("Has enabled java log!");
            return;
        }
        C7146e.s();
        C7146e.o();
        C7143b.a = true;
    }

    private static void b() {
        synchronized (C7143b.e) {
            if (C7143b.g && C7143b.f) {
                if (C7143b.b) {
                    C7134a.b("Has enabled native log!");
                    return;
                }
                c();
                C7146e.D();
                C7143b.b = true;
                JNIBridge.cmd(6);
                C7152g.d();
            }
        }
    }

    private static void c() {
        if (C7143b.d) {
            return;
        }
        C7152g.b();
        JNIBridge.cmd(5);
        C7152g.c();
        C7143b.d = true;
    }

    public static synchronized CrashApi createInstance(Context context, CustomInfo customInfo, VersionInfo versionInfo, ICrashClient iCrashClient, boolean z, boolean z2, boolean z3) {
        CrashApi crashApi;
        synchronized (CrashApi.class) {
            if (a == null) {
                a = new CrashApi(context, customInfo, versionInfo, iCrashClient, z, z2, z3);
            }
            crashApi = a;
        }
        return crashApi;
    }

    public static CrashApi createInstanceEx(Context context, String str, boolean z) {
        return createInstanceEx(context, str, z, null);
    }

    public static CrashApi getInstance() {
        return a;
    }

    public int addCachedInfo(String str, String str2) {
        if (str != null && str2 != null) {
            return C7133a.b(str, str2);
        }
        throw null;
    }

    public int addDumpFile(DumpFileInfo dumpFileInfo) {
        String str;
        Objects.requireNonNull(dumpFileInfo);
        String str2 = dumpFileInfo.mCategory;
        if (str2 != null && (str = dumpFileInfo.mFileTobeDump) != null) {
            int i = dumpFileInfo.mLogType;
            if ((1048849 & i) == 0) {
                return 0;
            }
            return C7133a.a(str2, str, dumpFileInfo.mIsEncrypted, dumpFileInfo.mWriteCategory, i, dumpFileInfo.mDeleteAfterDump);
        }
        throw null;
    }

    public void addHeaderInfo(String str, String str2) {
        Objects.requireNonNull(str);
        C7133a.a(str, str2);
    }

    public boolean addStatInfo(String str, String str2) {
        if (a("addStatInfo")) {
            return false;
        }
        if (!C7140g.a(str)) {
            if (str.length() <= 24) {
                if (str2 != null && str2.length() > 512) {
                    str2 = str2.substring(0, 512);
                }
                return C7141h.a(str, str2);
            }
            throw new IllegalArgumentException("key is too long!");
        }
        throw null;
    }

    public void crashSoLoaded() {
        if (a("crashSoLoaded")) {
            return;
        }
        C7143b.f = true;
        b();
        synchronized (C7143b.e) {
            if (C7143b.h && C7143b.f && !C7143b.c) {
                if (!C7143b.d) {
                    c();
                    C7152g.d();
                }
                C7146e.x();
                C7143b.c = true;
            }
        }
        C7133a.n();
        C7146e.m();
    }

    public int createCachedInfo(String str, int i, int i2) {
        Objects.requireNonNull(str);
        if (i > 0) {
            if ((1048849 & i2) == 0) {
                return 0;
            }
            return C7133a.a(str, i, i2);
        }
        throw new IllegalArgumentException("capacity must > 0!");
    }

    public void disableLog(int i) {
        synchronized (C7143b.e) {
            C7143b.b(i);
            if (LogType.isForJava(i) && C7143b.a) {
                C7146e.t();
                C7143b.a = false;
            }
            if (LogType.isForNative(i)) {
                if (C7143b.b) {
                    JNIBridge.cmd(9);
                    C7143b.b = false;
                } else {
                    C7143b.g = false;
                }
            }
            if (LogType.isForANR(i)) {
                C7143b.a(false);
            }
            if (LogType.isForUnexp(i)) {
                if (C7143b.c) {
                    if (C7146e.z()) {
                        C7143b.c = false;
                    }
                } else {
                    C7143b.h = false;
                }
            }
        }
    }

    public boolean generateCustomLog(CustomLogInfo customLogInfo) {
        String str;
        StringBuilder sb;
        Objects.requireNonNull(customLogInfo);
        if (customLogInfo.mData != null && (str = customLogInfo.mLogType) != null) {
            if (!str.contains(JSMethod.NOT_SET) && !customLogInfo.mLogType.contains(" ")) {
                ArrayList<Integer> arrayList = customLogInfo.mDumpTids;
                if (arrayList == null || arrayList.size() <= 0) {
                    sb = null;
                } else {
                    sb = new StringBuilder();
                    Iterator<Integer> it = customLogInfo.mDumpTids.iterator();
                    while (it.hasNext()) {
                        sb.append(it.next().intValue());
                        sb.append(" ");
                    }
                }
                long j = customLogInfo.mAddHeader ? 1L : 0L;
                if (customLogInfo.mAddFooter) {
                    j |= 2;
                }
                if (customLogInfo.mAddLogcat) {
                    j |= 4;
                }
                if (customLogInfo.mAddThreadsDump) {
                    j |= 8;
                }
                if (customLogInfo.mAddBuildId) {
                    j |= 16;
                }
                if (customLogInfo.mUploadNow) {
                    j |= 32;
                }
                return C7146e.a(customLogInfo.mData, customLogInfo.mLogType, j, customLogInfo.mDumpFiles, customLogInfo.mCallbacks, customLogInfo.mCachedInfos, sb != null ? sb.toString() : null);
            }
            throw new IllegalArgumentException("mLogType can not contain char '_' and ' '");
        }
        throw new NullPointerException("mData or mLogType is null!");
    }

    public boolean generateTraces(String str, long j) {
        if (a("generateTraces")) {
            return false;
        }
        if (C7143b.d) {
            return JNIBridge.nativeCmd(12, j, str, null) == 1;
        }
        C7134a.d("crashsdk", "Crash so is not loaded!");
        return false;
    }

    public String getCrashLogUploadUrl() {
        if (a("getCrashLogUploadUrl")) {
            return null;
        }
        return C7146e.k();
    }

    public ParcelFileDescriptor getHostFd() {
        return C7146e.E();
    }

    public ParcelFileDescriptor getIsolatedHostFd() {
        return C7146e.E();
    }

    public int getLastExitType() {
        if (a("getLastExitType")) {
            return 1;
        }
        return C7143b.I();
    }

    public int getLastExitTypeEx() {
        if (a("getLastExitTypeEx")) {
            return 1;
        }
        return C7143b.J();
    }

    public Throwable getUncaughtException() {
        return C7146e.v();
    }

    public int getUnexpReason() {
        if (a("getUnexpReason")) {
            return 100;
        }
        return C7146e.w();
    }

    public void onExit() {
        C7143b.w();
    }

    public boolean registerCallback(int i, ValueCallback<Bundle> valueCallback) {
        Objects.requireNonNull(valueCallback);
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return C7145d.b(valueCallback);
                    }
                    throw new IllegalArgumentException("Unknown event type: " + i);
                }
                return C7145d.d(valueCallback);
            }
            return C7145d.c(valueCallback);
        }
        return C7145d.a(valueCallback);
    }

    public int registerInfoCallback(String str, int i) {
        Objects.requireNonNull(str);
        if ((1048849 & i) == 0) {
            return 0;
        }
        return C7133a.a(str, i, null, 0L, 0);
    }

    public int registerThread(int i, String str) {
        return C7133a.a(i, str);
    }

    public int reportCrashStats(boolean z) {
        if (a("reportCrashStats")) {
            return 0;
        }
        if (C7152g.M()) {
            C7134a.a("CrashApi::reportCrashStats. currentProcessOnly: " + z);
        }
        C7146e.d(z);
        return C7146e.e(z);
    }

    public int resetCrashStats(boolean z) {
        if (a("resetCrashStats")) {
            return 0;
        }
        if (C7152g.M()) {
            C7134a.a("CrashApi::resetCrashStats. currentProcessOnly: " + z);
        }
        return C7146e.f(z);
    }

    public void setForeground(boolean z) {
        C7143b.b(z);
    }

    public boolean setHostFd(ParcelFileDescriptor parcelFileDescriptor) {
        return C7146e.a(parcelFileDescriptor);
    }

    public boolean setIsolatedHostFd(ParcelFileDescriptor parcelFileDescriptor) {
        return C7146e.a(parcelFileDescriptor);
    }

    public void setNewInstall() {
        if (a("setNewInstall")) {
            return;
        }
        C7143b.v();
    }

    public int updateCustomInfo(CustomInfo customInfo) {
        Objects.requireNonNull(customInfo);
        return C7152g.b(customInfo);
    }

    public boolean updateUnexpInfo() {
        if (a("updateUnexpInfo")) {
            return false;
        }
        return C7133a.a(true);
    }

    public void updateVersionInfo(VersionInfo versionInfo) {
        Objects.requireNonNull(versionInfo);
        C7152g.a(versionInfo);
    }

    public void uploadCrashLogs() {
        if (a("uploadCrashLogs")) {
            return;
        }
        C7146e.a(false, true);
    }

    public static CrashApi createInstanceEx(Context context, String str, boolean z, Bundle bundle) {
        return createInstanceEx(context, str, z, bundle, null);
    }

    public static CrashApi createInstanceEx(Context context, String str, boolean z, Bundle bundle, ICrashClient iCrashClient) {
        CrashApi crashApi = a;
        if (crashApi != null) {
            return crashApi;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        c = bundle.getBoolean("useApplicationContext", true);
        Context a2 = a(context);
        b(a2);
        CustomInfo customInfo = new CustomInfo(str);
        customInfo.mEnableStatReport = true;
        customInfo.mZipLog = true;
        customInfo.mPrintStackInfos = z;
        CustomInfo a3 = C7152g.a(customInfo, bundle);
        VersionInfo a4 = C7152g.a(bundle);
        boolean z2 = bundle.getBoolean("enableJavaLog", true);
        boolean z3 = bundle.getBoolean("enableNativeLog", true);
        boolean z4 = bundle.getBoolean("enableUnexpLog", C7143b.F());
        boolean z5 = bundle.getBoolean("enableANRLog", true);
        CrashApi createInstance = createInstance(a2, a3, a4, iCrashClient, z2, z3, z4);
        C7143b.a(z5);
        if (z3 || z4) {
            if (C7146e.e("libcrashsdk.so")) {
                createInstance.crashSoLoaded();
            } else {
                C7134a.d("crashsdk", "load libcrashsdk.so failed!");
            }
        }
        int i = bundle.getInt("uploadLogDelaySeconds", 15);
        if (i >= 0 && C7143b.F()) {
            C7146e.b(i);
        }
        return createInstance;
    }

    public int registerInfoCallback(String str, int i, Callable<String> callable) {
        if (str == null || callable == null) {
            throw null;
        }
        if ((1048849 & i) == 0) {
            return 0;
        }
        return C7133a.a(str, i, callable, 0L, 0);
    }

    public int updateCustomInfo(Bundle bundle) {
        Objects.requireNonNull(bundle);
        return updateCustomInfo(C7152g.a((CustomInfo) null, bundle));
    }

    public void updateVersionInfo(Bundle bundle) {
        Objects.requireNonNull(bundle);
        updateVersionInfo(C7152g.a(bundle));
    }

    private static void a(Context context, CustomInfo customInfo, VersionInfo versionInfo, ICrashClient iCrashClient) {
        C7145d.a(iCrashClient);
        C7152g.a(customInfo, versionInfo);
        if (C7143b.L()) {
            return;
        }
        C7146e.p();
        C7146e.a(context);
        C7146e.b(context);
    }

    public int addDumpFile(String str, String str2, int i, Bundle bundle) {
        DumpFileInfo dumpFileInfo = new DumpFileInfo(str, str2, i);
        if (bundle != null) {
            dumpFileInfo.mIsEncrypted = bundle.getBoolean("mIsEncrypted", dumpFileInfo.mIsEncrypted);
            dumpFileInfo.mWriteCategory = bundle.getBoolean("mWriteCategory", dumpFileInfo.mWriteCategory);
            dumpFileInfo.mDeleteAfterDump = bundle.getBoolean("mDeleteAfterDump", dumpFileInfo.mDeleteAfterDump);
        }
        return addDumpFile(dumpFileInfo);
    }

    private static Context a(Context context) {
        if (context != null) {
            if (!c || (context instanceof Application) || ((context = context.getApplicationContext()) != null && (context instanceof Application))) {
                return context;
            }
            C7134a.d("crashsdk", "Can not get Application context from given context!");
            throw new IllegalArgumentException("Can not get Application context from given context!");
        }
        C7134a.d("crashsdk", "context can not be null!");
        throw null;
    }

    private static void b(Context context) {
        try {
            if (d) {
                return;
            }
            C7140g.a(context);
            C7133a.a = context.getPackageName();
            d = true;
        } catch (Throwable th) {
            a(th);
        }
    }

    private static void a(Throwable th) {
        new C7146e().a(Thread.currentThread(), th, true);
    }

    public boolean generateCustomLog(StringBuffer stringBuffer, String str, Bundle bundle) {
        CustomLogInfo customLogInfo = new CustomLogInfo(stringBuffer, str);
        if (bundle != null) {
            customLogInfo.mAddHeader = bundle.getBoolean("mAddHeader", customLogInfo.mAddHeader);
            customLogInfo.mAddFooter = bundle.getBoolean("mAddFooter", customLogInfo.mAddFooter);
            customLogInfo.mAddLogcat = bundle.getBoolean("mAddLogcat", customLogInfo.mAddLogcat);
            customLogInfo.mUploadNow = bundle.getBoolean("mUploadNow", customLogInfo.mUploadNow);
            customLogInfo.mAddThreadsDump = bundle.getBoolean("mAddThreadsDump", customLogInfo.mAddThreadsDump);
            customLogInfo.mAddBuildId = bundle.getBoolean("mAddBuildId", customLogInfo.mAddBuildId);
            customLogInfo.mDumpFiles = bundle.getStringArrayList("mDumpFiles");
            customLogInfo.mCallbacks = bundle.getStringArrayList("mCallbacks");
            customLogInfo.mCachedInfos = bundle.getStringArrayList("mCachedInfos");
            customLogInfo.mDumpTids = bundle.getIntegerArrayList("mDumpTids");
        }
        return generateCustomLog(customLogInfo);
    }

    private static boolean a(String str) {
        if (C7143b.L()) {
            C7134a.d("crashsdk", "Can not call '" + str + "' in isolated process!");
            return true;
        }
        return false;
    }
}
