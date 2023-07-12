package com.uc.crashsdk;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.weex.annotation.JSMethod;
import com.uc.crashsdk.a.C7134a;
import com.uc.crashsdk.a.C7137d;
import com.uc.crashsdk.a.C7140g;
import com.uc.crashsdk.a.C7141h;
import com.uc.crashsdk.export.CustomInfo;
import com.uc.crashsdk.export.VersionInfo;
import java.io.File;
import java.lang.reflect.Field;
import java.util.zip.ZipFile;

/* compiled from: Taobao */
/* renamed from: com.uc.crashsdk.g */
/* loaded from: classes11.dex */
public class C7152g {
    static final /* synthetic */ boolean a = true;
    private static CustomInfo b;
    private static VersionInfo c;
    private static String e;
    private static String f;
    private static String g;
    private static String h;
    private static final Object d = new Object();
    private static final Object i = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long A() {
        return b.mMaxUploadBytesPerDay;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int B() {
        return b.mMaxUploadBuiltinLogCountPerDay;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int C() {
        return b.mMaxUploadCustomLogCountPerDay;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int D() {
        return b.mMaxCustomLogCountPerTypePerDay;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int E() {
        return b.mInfoUpdateInterval;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int F() {
        return b.mInfoSaveFrequency;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int G() {
        return b.mReservedJavaFileHandleCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int H() {
        return b.mFdDumpMinLimit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int I() {
        return b.mThreadsDumpMinLimit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean J() {
        return b.mAutoDetectLifeCycle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean K() {
        return b.mMonitorBattery;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int L() {
        return b.mAnrTraceStrategy;
    }

    public static boolean M() {
        CustomInfo customInfo = b;
        return customInfo == null || customInfo.mDebug;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean N() {
        CustomInfo customInfo = b;
        return customInfo == null || customInfo.mPrintStackInfos;
    }

    public static boolean O() {
        return b.mEnableStatReport;
    }

    public static boolean P() {
        return b.mIsInternational;
    }

    public static boolean Q() {
        return b.mAddPvForNewDay;
    }

    public static String R() {
        if (C7140g.a(c.mVersion)) {
            return C7133a.a();
        }
        return a(c.mVersion);
    }

    public static String S() {
        return C7140g.a(c.mSubVersion) ? "release" : c.mSubVersion;
    }

    public static String T() {
        if (C7140g.a(c.mBuildId)) {
            return X();
        }
        return a(c.mBuildId);
    }

    public static String U() {
        if (f == null) {
            f = C7140g.b() + File.separatorChar + b.mTagFilesFolderName + File.separatorChar;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String V() {
        if (g == null) {
            g = C7140g.b() + File.separatorChar + b.mCrashLogsFolderName + File.separatorChar;
        }
        return g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String W() {
        String path;
        if (h == null) {
            if (!C7140g.a(b.mLogsBackupPathName)) {
                String trim = b.mLogsBackupPathName.trim();
                String str = File.separator;
                if (!trim.endsWith(str)) {
                    trim = trim + str;
                }
                h = trim;
            } else {
                if (!C7143b.L()) {
                    try {
                        path = Environment.getExternalStorageDirectory().getPath();
                    } catch (Throwable th) {
                        C7140g.a(th);
                    }
                    h = path + File.separatorChar + b.mCrashLogsFolderName + File.separatorChar;
                }
                path = "/sdcard";
                h = path + File.separatorChar + b.mCrashLogsFolderName + File.separatorChar;
            }
        }
        return h;
    }

    private static String X() {
        ZipFile zipFile;
        Throwable th;
        String str = e;
        if (str != null) {
            return str;
        }
        try {
            try {
                zipFile = new ZipFile(C7140g.c());
            } catch (Throwable th2) {
                zipFile = null;
                th = th2;
            }
        } catch (Throwable unused) {
        }
        try {
            e = Long.toHexString(zipFile.getEntry("classes.dex").getCrc());
            C7134a.a("crashsdk", "version unique build id: " + e);
            zipFile.close();
        } catch (Throwable th3) {
            th = th3;
            try {
                e = "";
                C7140g.a(th);
                if (zipFile != null) {
                    zipFile.close();
                }
                return e;
            } catch (Throwable th4) {
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th4;
            }
        }
        return e;
    }

    private static void Y() {
        if (C7143b.d) {
            JNIBridge.nativeSet(24, 1L, C7133a.b, null);
        }
    }

    public static void a(CustomInfo customInfo, VersionInfo versionInfo) {
        CustomInfo customInfo2 = new CustomInfo(customInfo);
        b = customInfo2;
        c(customInfo2);
        c = new VersionInfo(versionInfo);
        if (C7143b.L()) {
            return;
        }
        try {
            a();
        } catch (Throwable th) {
            C7140g.a(th);
        }
    }

    public static void b() {
        JNIBridge.set(103, C7140g.b());
        JNIBridge.set(104, b.mTagFilesFolderName);
        JNIBridge.set(105, b.mCrashLogsFolderName);
        JNIBridge.set(106, W());
        JNIBridge.set(107, C7146e.h());
        JNIBridge.set(108, C7143b.a());
        JNIBridge.set(109, R());
        JNIBridge.set(110, S());
        JNIBridge.set(111, T());
        JNIBridge.set(112, "200915125514");
        JNIBridge.set(116, Build.getMODEL());
        JNIBridge.set(117, Build.VERSION.getRELEASE());
        JNIBridge.set(118, C7146e.q());
        JNIBridge.set(5, b.mCallNativeDefaultHandler);
        JNIBridge.set(6, b.mDumpUserSolibBuildId);
        JNIBridge.set(7, b.mReservedNativeMemoryBytes);
        JNIBridge.set(100, b.mNativeCrashLogFileName);
        JNIBridge.set(101, b.mUnexpCrashLogFileName);
        JNIBridge.set(35, b.mEnableMemoryGroup);
        JNIBridge.set(36, b.mEnableLibcMallocDetail);
        JNIBridge.set(131, b.mLibcMallocDetailConfig);
        JNIBridge.set(102, b.mAppId);
    }

    private static void c(CustomInfo customInfo) {
        if (customInfo.mZippedLogExtension == null) {
            customInfo.mZippedLogExtension = "";
        }
        if (!customInfo.mZippedLogExtension.equals(".tmp")) {
            if (customInfo.mOmitJavaCrash) {
                customInfo.mCallJavaDefaultHandler = false;
            }
            if (customInfo.mOmitNativeCrash) {
                customInfo.mCallNativeDefaultHandler = false;
            }
            long b2 = C7146e.b();
            if (b2 >= 1) {
                customInfo.mMaxBuiltinLogFilesCount = 200;
                customInfo.mMaxCustomLogFilesCount = 100;
                customInfo.mMaxUploadBytesPerDay = 268435456L;
                customInfo.mMaxUploadBuiltinLogCountPerDay = 2000;
                customInfo.mMaxUploadCustomLogCountPerDay = 2000;
                customInfo.mMaxCustomLogCountPerTypePerDay = 100;
                customInfo.mMaxAnrLogCountPerProcess = 100;
                customInfo.mAnrTraceStrategy = 2;
                if (b2 >= 2) {
                    customInfo.mSyncUploadSetupCrashLogs = true;
                    customInfo.mSyncUploadLogs = true;
                    if (b2 >= 3) {
                        customInfo.mBackupLogs = true;
                        customInfo.mPrintStackInfos = true;
                        customInfo.mDebug = true;
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("mZippedLogExtension can not be '.tmp'!");
    }

    public static void d() {
        JNIBridge.set(23, b.mIsInternational);
        if (C7143b.H()) {
            JNIBridge.set(34, true);
        }
        if (C7146e.i()) {
            JNIBridge.set(1, true);
        }
        JNIBridge.set(10, b.mFdDumpMinLimit);
        JNIBridge.nativeCmd(3, b.mReservedNativeFileHandleCount, null, null);
        JNIBridge.nativeSetForeground(C7143b.B());
        JNIBridge.set(2, C7143b.F());
        C7133a.e();
        C7133a.g();
        C7133a.i();
        C7133a.k();
        JNIBridge.set(113, C7133a.a);
        JNIBridge.cmd(1);
        JNIBridge.set(22, b.mThreadsDumpMinLimit);
        JNIBridge.set(122, C7133a.a());
        JNIBridge.set(33, C7133a.c());
        Y();
        C7143b.K();
        C7143b.D();
        C7140g.k();
    }

    public static String e() {
        return b.mAppId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f() {
        if (C7140g.b(b.mJavaCrashLogFileName) || C7140g.b(b.mNativeCrashLogFileName)) {
            return true;
        }
        return C7140g.b(b.mUnexpCrashLogFileName);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g() {
        return b.mJavaCrashLogFileName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h() {
        return b.mCrashRestartInterval;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i() {
        return b.mCallJavaDefaultHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean j() {
        return b.mDumpHprofDataForJavaOOM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean k() {
        return b.mRenameFileToDefaultName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int l() {
        return b.mMaxBuiltinLogFilesCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m() {
        return b.mMaxCustomLogFilesCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int n() {
        return b.mMaxJavaLogcatLineCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int o() {
        return b.mUnexpDelayMillSeconds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int p() {
        return b.mUnexpSubTypes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean q() {
        return b.mBackupLogs;
    }

    public static boolean r() {
        return b.mSyncUploadSetupCrashLogs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean s() {
        return b.mSyncUploadLogs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean t() {
        return b.mOmitJavaCrash;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean u() {
        return b.mAutoDeleteOldVersionStats;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean v() {
        return b.mZipLog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String w() {
        return b.mZippedLogExtension;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean x() {
        return b.mEncryptLog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int y() {
        return b.mLogMaxBytesLimit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int z() {
        return b.mLogMaxUploadBytesLimit;
    }

    public static void a(CustomInfo customInfo) {
        boolean z = a;
        if (!z && customInfo.mTagFilesFolderName == null) {
            throw new AssertionError();
        }
        if (!z && customInfo.mCrashLogsFolderName == null) {
            throw new AssertionError();
        }
        if (customInfo.mTagFilesFolderName.equals(customInfo.mCrashLogsFolderName)) {
            throw new IllegalArgumentException("mTagFilesFolderName and mCrashLogsFolderName can not be set to the same!");
        }
    }

    public static void a(VersionInfo versionInfo) {
        synchronized (d) {
            c = new VersionInfo(versionInfo);
            C7146e.c();
            if (C7143b.d) {
                JNIBridge.set(109, R());
                JNIBridge.set(110, S());
                JNIBridge.set(111, T());
                JNIBridge.set(112, "200915125514");
                JNIBridge.cmd(2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        C7143b.y();
        C7143b.x();
        if (b.mBackupLogs) {
            File file = new File(W());
            if (file.exists()) {
                return;
            }
            file.mkdirs();
        }
    }

    private static String a(String str) {
        return (str == null || !str.contains(JSMethod.NOT_SET)) ? str : str.replaceAll(JSMethod.NOT_SET, "-");
    }

    public static CustomInfo a(CustomInfo customInfo, Bundle bundle) {
        if (customInfo == null) {
            CustomInfo customInfo2 = b;
            if (customInfo2 == null) {
                customInfo = new CustomInfo();
            } else {
                customInfo = new CustomInfo(customInfo2);
            }
        }
        Field[] fields = customInfo.getClass().getFields();
        for (String str : bundle.keySet()) {
            for (Field field : fields) {
                if (field.getName().equals(str)) {
                    Object obj = bundle.get(str);
                    try {
                        field.set(customInfo, obj);
                    } catch (Exception e2) {
                        C7140g.a(e2);
                        StringBuilder sb = new StringBuilder("Field ");
                        sb.append(str);
                        sb.append(" must be a ");
                        sb.append(field.getType().getName());
                        sb.append(", but give a ");
                        sb.append(obj != null ? obj.getClass().getName() : "(null)");
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
            }
        }
        return customInfo;
    }

    public static int b(CustomInfo customInfo) {
        int i2;
        int i3;
        boolean z;
        boolean z2;
        synchronized (i) {
            i2 = 0;
            if (customInfo != null) {
                c(customInfo);
                if (b == null) {
                    b = new CustomInfo();
                }
                CustomInfo customInfo2 = b;
                boolean z3 = true;
                if (a(customInfo.mAppId, customInfo2.mAppId)) {
                    i3 = 0;
                    z = false;
                } else {
                    String str = customInfo.mAppId;
                    customInfo2.mAppId = str;
                    if (C7143b.d) {
                        JNIBridge.set(102, str);
                    }
                    i3 = 1;
                    z = true;
                }
                if (!a(customInfo.mJavaCrashLogFileName, customInfo2.mJavaCrashLogFileName)) {
                    customInfo2.mJavaCrashLogFileName = customInfo.mJavaCrashLogFileName;
                    i3++;
                }
                if (!a(customInfo.mNativeCrashLogFileName, customInfo2.mNativeCrashLogFileName)) {
                    String str2 = customInfo.mNativeCrashLogFileName;
                    customInfo2.mNativeCrashLogFileName = str2;
                    if (C7143b.d) {
                        JNIBridge.set(100, str2);
                    }
                    i3++;
                    z = true;
                }
                if (!a(customInfo.mUnexpCrashLogFileName, customInfo2.mUnexpCrashLogFileName)) {
                    String str3 = customInfo.mUnexpCrashLogFileName;
                    customInfo2.mUnexpCrashLogFileName = str3;
                    if (C7143b.d) {
                        JNIBridge.set(101, str3);
                    }
                    i3++;
                    z = true;
                }
                if (z) {
                    C7146e.c();
                    if (C7143b.d) {
                        JNIBridge.cmd(2);
                    }
                }
                boolean z4 = customInfo2.mPrintStackInfos;
                boolean z5 = customInfo.mPrintStackInfos;
                if (z4 != z5) {
                    customInfo2.mPrintStackInfos = z5;
                    if (C7143b.d) {
                        JNIBridge.set(11, z5);
                    }
                    i3++;
                }
                boolean z6 = customInfo2.mDebug;
                boolean z7 = customInfo.mDebug;
                if (z6 != z7) {
                    customInfo2.mDebug = z7;
                    if (C7143b.d) {
                        JNIBridge.set(18, z7);
                    }
                    i3++;
                }
                boolean z8 = customInfo2.mBackupLogs;
                boolean z9 = customInfo.mBackupLogs;
                if (z8 != z9) {
                    customInfo2.mBackupLogs = z9;
                    if (C7143b.d) {
                        JNIBridge.set(12, z9);
                    }
                    i3++;
                }
                boolean z10 = customInfo2.mOmitNativeCrash;
                boolean z11 = customInfo.mOmitNativeCrash;
                if (z10 != z11) {
                    customInfo2.mOmitNativeCrash = z11;
                    if (C7143b.d) {
                        JNIBridge.set(21, z11);
                    }
                    i3++;
                }
                int i4 = customInfo2.mCrashRestartInterval;
                int i5 = customInfo.mCrashRestartInterval;
                if (i4 != i5) {
                    customInfo2.mCrashRestartInterval = i5;
                    if (C7143b.d) {
                        JNIBridge.set(13, i5);
                    }
                    if (customInfo2.mCrashRestartInterval >= 0) {
                        C7143b.M();
                    }
                    i3++;
                }
                int i6 = customInfo2.mMaxBuiltinLogFilesCount;
                int i7 = customInfo.mMaxBuiltinLogFilesCount;
                if (i6 != i7) {
                    customInfo2.mMaxBuiltinLogFilesCount = i7;
                    if (C7143b.d) {
                        JNIBridge.set(14, i7);
                    }
                    i3++;
                }
                int i8 = customInfo2.mMaxNativeLogcatLineCount;
                int i9 = customInfo.mMaxNativeLogcatLineCount;
                if (i8 != i9) {
                    customInfo2.mMaxNativeLogcatLineCount = i9;
                    if (C7143b.d) {
                        JNIBridge.set(15, i9);
                    }
                    i3++;
                }
                int i10 = customInfo2.mMaxJavaLogcatLineCount;
                int i11 = customInfo.mMaxJavaLogcatLineCount;
                if (i10 != i11) {
                    customInfo2.mMaxJavaLogcatLineCount = i11;
                    i3++;
                }
                int i12 = customInfo2.mMaxUnexpLogcatLineCount;
                int i13 = customInfo.mMaxUnexpLogcatLineCount;
                if (i12 != i13) {
                    customInfo2.mMaxUnexpLogcatLineCount = i13;
                    if (C7143b.d) {
                        JNIBridge.set(16, i13);
                    }
                    i3++;
                }
                int i14 = customInfo2.mMaxAnrLogcatLineCount;
                int i15 = customInfo.mMaxAnrLogcatLineCount;
                if (i14 != i15) {
                    customInfo2.mMaxAnrLogcatLineCount = i15;
                    if (C7143b.d) {
                        JNIBridge.set(31, i15);
                    }
                    i3++;
                }
                boolean z12 = customInfo2.mZipLog;
                boolean z13 = customInfo.mZipLog;
                if (z12 != z13) {
                    customInfo2.mZipLog = z13;
                    i3++;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (a(customInfo.mZippedLogExtension, customInfo2.mZippedLogExtension)) {
                    z3 = z2;
                } else {
                    customInfo2.mZippedLogExtension = customInfo.mZippedLogExtension;
                    i3++;
                }
                if (z3 && C7143b.d) {
                    JNIBridge.nativeSet(3, customInfo2.mZipLog ? 1L : 0L, customInfo2.mZippedLogExtension, null);
                }
                int i16 = customInfo2.mLogMaxBytesLimit;
                int i17 = customInfo.mLogMaxBytesLimit;
                if (i16 != i17) {
                    customInfo2.mLogMaxBytesLimit = i17;
                    if (C7143b.d) {
                        JNIBridge.set(4, i17);
                    }
                    i3++;
                }
                boolean z14 = customInfo2.mEncryptLog;
                boolean z15 = customInfo.mEncryptLog;
                if (z14 != z15) {
                    customInfo2.mEncryptLog = z15;
                    i3++;
                }
                boolean z16 = customInfo2.mSyncUploadSetupCrashLogs;
                boolean z17 = customInfo.mSyncUploadSetupCrashLogs;
                if (z16 != z17) {
                    customInfo2.mSyncUploadSetupCrashLogs = z17;
                    i3++;
                }
                boolean z18 = customInfo2.mSyncUploadLogs;
                boolean z19 = customInfo.mSyncUploadLogs;
                if (z18 != z19) {
                    customInfo2.mSyncUploadLogs = z19;
                    i3++;
                }
                int i18 = customInfo2.mMaxCustomLogFilesCount;
                int i19 = customInfo.mMaxCustomLogFilesCount;
                if (i18 != i19) {
                    customInfo2.mMaxCustomLogFilesCount = i19;
                    i3++;
                }
                boolean z20 = customInfo2.mOmitJavaCrash;
                boolean z21 = customInfo.mOmitJavaCrash;
                if (z20 != z21) {
                    customInfo2.mOmitJavaCrash = z21;
                    i3++;
                }
                int i20 = customInfo2.mLogMaxUploadBytesLimit;
                int i21 = customInfo.mLogMaxUploadBytesLimit;
                if (i20 != i21) {
                    customInfo2.mLogMaxUploadBytesLimit = i21;
                    i3++;
                }
                long j = customInfo2.mMaxUploadBytesPerDay;
                long j2 = customInfo.mMaxUploadBytesPerDay;
                if (j != j2) {
                    customInfo2.mMaxUploadBytesPerDay = j2;
                    i3++;
                }
                int i22 = customInfo2.mMaxUploadBuiltinLogCountPerDay;
                int i23 = customInfo.mMaxUploadBuiltinLogCountPerDay;
                if (i22 != i23) {
                    customInfo2.mMaxUploadBuiltinLogCountPerDay = i23;
                    i3++;
                }
                int i24 = customInfo2.mMaxUploadCustomLogCountPerDay;
                int i25 = customInfo.mMaxUploadCustomLogCountPerDay;
                if (i24 != i25) {
                    customInfo2.mMaxUploadCustomLogCountPerDay = i25;
                    i3++;
                }
                int i26 = customInfo2.mMaxCustomLogCountPerTypePerDay;
                int i27 = customInfo.mMaxCustomLogCountPerTypePerDay;
                if (i26 != i27) {
                    customInfo2.mMaxCustomLogCountPerTypePerDay = i27;
                    i3++;
                }
                int i28 = customInfo2.mMaxAnrLogCountPerProcess;
                int i29 = customInfo.mMaxAnrLogCountPerProcess;
                if (i28 != i29) {
                    customInfo2.mMaxAnrLogCountPerProcess = i29;
                    if (C7143b.d) {
                        JNIBridge.set(32, b.mMaxAnrLogCountPerProcess);
                    }
                    i3++;
                }
                boolean z22 = customInfo2.mCallJavaDefaultHandler;
                boolean z23 = customInfo.mCallJavaDefaultHandler;
                if (z22 != z23) {
                    customInfo2.mCallJavaDefaultHandler = z23;
                    i3++;
                }
                boolean z24 = customInfo2.mCallNativeDefaultHandler;
                boolean z25 = customInfo.mCallNativeDefaultHandler;
                if (z24 != z25) {
                    customInfo2.mCallNativeDefaultHandler = z25;
                    i3++;
                    if (C7143b.d) {
                        JNIBridge.set(5, b.mCallNativeDefaultHandler);
                    }
                }
                boolean z26 = customInfo2.mDumpUserSolibBuildId;
                boolean z27 = customInfo.mDumpUserSolibBuildId;
                if (z26 != z27) {
                    customInfo2.mDumpUserSolibBuildId = z27;
                    i3++;
                    if (C7143b.d) {
                        JNIBridge.set(6, b.mDumpUserSolibBuildId);
                    }
                }
                boolean z28 = customInfo2.mDumpHprofDataForJavaOOM;
                boolean z29 = customInfo.mDumpHprofDataForJavaOOM;
                if (z28 != z29) {
                    customInfo2.mDumpHprofDataForJavaOOM = z29;
                    i3++;
                }
                boolean z30 = customInfo2.mRenameFileToDefaultName;
                boolean z31 = customInfo.mRenameFileToDefaultName;
                if (z30 != z31) {
                    customInfo2.mRenameFileToDefaultName = z31;
                    i3++;
                }
                boolean z32 = customInfo2.mAutoDeleteOldVersionStats;
                boolean z33 = customInfo.mAutoDeleteOldVersionStats;
                if (z32 != z33) {
                    customInfo2.mAutoDeleteOldVersionStats = z33;
                    i3++;
                }
                int i30 = customInfo2.mFdDumpMinLimit;
                int i31 = customInfo.mFdDumpMinLimit;
                if (i30 != i31) {
                    customInfo2.mFdDumpMinLimit = i31;
                    if (C7143b.d) {
                        JNIBridge.set(10, i31);
                    }
                    i3++;
                }
                int i32 = customInfo2.mThreadsDumpMinLimit;
                int i33 = customInfo.mThreadsDumpMinLimit;
                if (i32 != i33) {
                    customInfo2.mThreadsDumpMinLimit = i33;
                    if (C7143b.d) {
                        JNIBridge.set(22, i33);
                    }
                    i3++;
                }
                int i34 = customInfo2.mInfoUpdateInterval;
                int i35 = customInfo.mInfoUpdateInterval;
                if (i34 != i35) {
                    if (i34 <= 0 && i35 > 0) {
                        C7133a.a(false);
                    }
                    customInfo2.mInfoUpdateInterval = customInfo.mInfoUpdateInterval;
                    i3++;
                }
                int i36 = customInfo2.mInfoSaveFrequency;
                int i37 = customInfo.mInfoSaveFrequency;
                if (i36 != i37) {
                    customInfo2.mInfoSaveFrequency = i37;
                    i3++;
                }
                long j3 = customInfo2.mDisableBackgroundSignals;
                long j4 = customInfo.mDisableBackgroundSignals;
                if (j3 != j4) {
                    customInfo2.mDisableBackgroundSignals = j4;
                    if (C7143b.d) {
                        JNIBridge.set(9, j4);
                    }
                    i3++;
                }
                boolean z34 = customInfo2.mEnableStatReport;
                boolean z35 = customInfo.mEnableStatReport;
                if (z34 != z35) {
                    customInfo2.mEnableStatReport = z35;
                    if (z35) {
                        C7146e.B();
                    }
                    i3++;
                }
                boolean z36 = customInfo2.mIsInternational;
                boolean z37 = customInfo.mIsInternational;
                if (z36 != z37) {
                    customInfo2.mIsInternational = z37;
                    if (C7143b.d) {
                        JNIBridge.set(23, z37);
                    }
                    C7146e.l();
                    C7137d.c();
                    C7141h.k();
                    i3++;
                }
                boolean z38 = customInfo2.mAutoDetectLifeCycle;
                boolean z39 = customInfo.mAutoDetectLifeCycle;
                if (z38 != z39) {
                    customInfo2.mAutoDetectLifeCycle = z39;
                    if (z39) {
                        C7143b.C();
                    }
                    i3++;
                }
                boolean z40 = customInfo2.mMonitorBattery;
                boolean z41 = customInfo.mMonitorBattery;
                if (z40 != z41) {
                    customInfo2.mMonitorBattery = z41;
                    C7146e.c(C7143b.B());
                    i3++;
                }
                int i38 = customInfo2.mUnexpSubTypes;
                int i39 = customInfo.mUnexpSubTypes;
                if (i38 != i39) {
                    customInfo2.mUnexpSubTypes = i39;
                    i3++;
                }
                boolean z42 = customInfo2.mEnableMemoryGroup;
                boolean z43 = customInfo.mEnableMemoryGroup;
                if (z42 != z43) {
                    customInfo2.mEnableMemoryGroup = z43;
                    if (C7143b.d) {
                        JNIBridge.set(35, z43);
                    }
                    i3++;
                }
                boolean z44 = customInfo2.mEnableLibcMallocDetail;
                boolean z45 = customInfo.mEnableLibcMallocDetail;
                if (z44 != z45) {
                    customInfo2.mEnableLibcMallocDetail = z45;
                    if (C7143b.d) {
                        JNIBridge.set(36, z45);
                    }
                    i3++;
                }
                String str4 = customInfo2.mLibcMallocDetailConfig;
                String str5 = customInfo.mLibcMallocDetailConfig;
                if (str4 != str5) {
                    customInfo2.mLibcMallocDetailConfig = str5;
                    if (C7143b.d) {
                        JNIBridge.set(131, str5);
                    }
                    i3++;
                }
                i2 = i3;
            }
        }
        return i2;
    }

    public static void c() {
        JNIBridge.set(11, N());
        JNIBridge.set(12, b.mBackupLogs);
        JNIBridge.set(13, b.mCrashRestartInterval);
        JNIBridge.set(14, b.mMaxBuiltinLogFilesCount);
        JNIBridge.set(15, b.mMaxNativeLogcatLineCount);
        JNIBridge.set(16, b.mMaxUnexpLogcatLineCount);
        JNIBridge.set(31, b.mMaxAnrLogcatLineCount);
        JNIBridge.set(18, M());
        JNIBridge.set(20, Build.VERSION.SDK_INT);
        JNIBridge.set(21, b.mOmitNativeCrash);
        JNIBridge.set(32, b.mMaxAnrLogCountPerProcess);
        JNIBridge.set(8, b.mDisableSignals);
        JNIBridge.set(9, b.mDisableBackgroundSignals);
        CustomInfo customInfo = b;
        JNIBridge.nativeSet(3, customInfo.mZipLog ? 1L : 0L, customInfo.mZippedLogExtension, null);
        JNIBridge.set(4, b.mLogMaxBytesLimit);
        JNIBridge.set(119, android.os.Build.FINGERPRINT);
    }

    public static VersionInfo a(Bundle bundle) {
        VersionInfo versionInfo;
        VersionInfo versionInfo2 = c;
        if (versionInfo2 == null) {
            versionInfo = new VersionInfo();
        } else {
            versionInfo = new VersionInfo(versionInfo2);
        }
        String string = bundle.getString("mVersion");
        if (!C7140g.a(string)) {
            versionInfo.mVersion = string;
        }
        String string2 = bundle.getString("mSubVersion");
        if (!C7140g.a(string2)) {
            versionInfo.mSubVersion = string2;
        }
        String string3 = bundle.getString("mBuildId");
        if (!C7140g.a(string3)) {
            versionInfo.mBuildId = string3;
        }
        String string4 = bundle.getString("crver");
        if (!C7140g.a(string4)) {
            C7133a.b = string4;
            Y();
        }
        return versionInfo;
    }

    private static boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }
}
