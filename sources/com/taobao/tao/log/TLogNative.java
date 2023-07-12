package com.taobao.tao.log;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.taobao.android.tlog.protocol.TLogSecret;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.taobao.tao.log.statistics.TLogEventHelper;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TLogNative {
    private static final int MAX_CACHE_CAPACITY = 100;
    private static final String TAG = "TLOG.TLogNative";
    private static LogWriteMonitor mLogWriteMonitor;
    private static final ConcurrentLinkedCache<XLoggerInfo> sInitCache = new ConcurrentLinkedCache<>();
    private static int pid = -1;
    private static volatile boolean sOpenSoSuccess = false;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    interface LogWriteMonitor {
        void onLogWrite(int i, String str, String str2, String str3, String str4, String str5, String str6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class XLoggerInfo {
        public int category;
        public int level;
        public String log;
        public String module;
        public long pid;
        public String tag;
        public long tid;
        public long ts;

        XLoggerInfo() {
        }
    }

    @Deprecated
    public static native void addModuleFilter(String str, int i);

    public static native void appenderClose();

    public static native void appenderFlush(boolean z);

    public static void appenderFlushData(boolean z) {
        try {
            if (pid == Process.myPid()) {
                appenderFlush(z);
            }
        } catch (Exception e) {
            Log.e("TLogNative", "appenderFlushData failure", e);
        } catch (UnsatisfiedLinkError e2) {
            Log.e("TLogNative", "appenderFlushData failure, unsatisfied link error", e2);
        }
    }

    public static void appenderOpen(int i, String str, String str2, String str3, String str4, long j, long j2, boolean z, int i2) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
                Log.i(TAG, "create cacheDir");
            }
            File file2 = new File(str2);
            if (!file2.exists()) {
                file2.mkdirs();
                Log.i(TAG, "create logDir");
            }
            System.loadLibrary("c++_shared");
            Log.e(TAG, "loadLibrary AliHALogEngine");
            System.loadLibrary("AliHALogEngine");
            sOpenSoSuccess = initNative(i, str, str2, str3, str4, j, TLogInitializer.getInstance().getTLogFileVersion(), j2 * 1024, z, i2, "");
            pid = Process.myPid();
            Log.e(TAG, "Init TLOG at process: " + pid);
        } catch (Throwable th) {
            th.printStackTrace();
            Log.e(TAG, "appenderOpen exception: " + th.getMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("errMsg", th.getMessage());
            TLogEventHelper.event(TLogEventConst.UT_TLOG_INIT_ERR, hashMap);
        }
    }

    public static native boolean appenderOpen(int i, int i2, String str, String str2, String str3, String str4, long j);

    @Deprecated
    public static native void cleanModuleFilter();

    public static void eventForNative(String str, HashMap<String, String> hashMap) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            TLogEventHelper.event(str, hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static native int getLogLevel();

    public static String getRc4EncryptSecretyKeyValue() {
        try {
            return TLogSecret.getInstance().getRc4EncryptSecretValue(TLogInitializer.getInstance().getSecurityKey());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getRsaPublicKeyMd5Value() {
        return TLogSecret.getInstance().getRsaMd5Value();
    }

    public static String getSecurityKey() {
        String securityKey = TLogInitializer.getInstance().getSecurityKey();
        if (TextUtils.isEmpty(securityKey)) {
            securityKey = "t_remote_debugger";
        }
        if (TLogInitializer.getInstance().isDebugable()) {
            Log.d("SecurityKey", securityKey);
        }
        return securityKey;
    }

    private static native boolean initNative(int i, String str, String str2, String str3, String str4, long j, int i2, long j2, boolean z, int i3, String str5);

    private static boolean isModuleEnabledForLevel(int i, String str) {
        if (TLogController.getInstance().getLogLevel("").getIndex() > i) {
            LogLevel logLevel = TLogController.getInstance().getLogLevel(str);
            return logLevel != null && logLevel.getIndex() <= i;
        }
        return true;
    }

    public static boolean isSoOpen() {
        return sOpenSoSuccess;
    }

    @Deprecated
    public static native void setAppenderMode(int i);

    @Deprecated
    public static native void setConsoleLogOpen(boolean z);

    public static native void setLogLevel(int i);

    private static void setLogWriteMonitor(LogWriteMonitor logWriteMonitor) {
        mLogWriteMonitor = logWriteMonitor;
    }

    private static void writeCacheTLog() {
        if (sOpenSoSuccess) {
            ConcurrentLinkedCache<XLoggerInfo> concurrentLinkedCache = sInitCache;
            if (concurrentLinkedCache.size() > 0) {
                Iterator<XLoggerInfo> iteratorAndClear = concurrentLinkedCache.getIteratorAndClear();
                while (iteratorAndClear.hasNext()) {
                    XLoggerInfo next = iteratorAndClear.next();
                    if (next.category != LogCategory.CodeLog.getIndex() || isModuleEnabledForLevel(next.level, next.module)) {
                        if (next.pid != pid) {
                            Log.e(TAG, String.format("在fork的进程%d, 写tlog (%d). Module=%s", Integer.valueOf(Process.myPid()), Integer.valueOf(pid), next.module));
                        } else if (TextUtils.isEmpty(next.log)) {
                            return;
                        } else {
                            try {
                                writeTLogNative(next.pid, next.tid, next.ts, next.category, next.level, next.module, next.tag, next.log);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeCodeLog(int i, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        if (TLogInitializer.getInstance().getInitState() == 2) {
            writeCacheTLog();
            if (pid != Process.myPid()) {
                Log.e(TAG, String.format("在fork的进程%d, 写CodeLog (%d). Module=%s", Integer.valueOf(Process.myPid()), Integer.valueOf(pid), str));
                return;
            } else if (!sOpenSoSuccess) {
                Log.e(TAG, "sOpenSoSuccess:" + sOpenSoSuccess);
                return;
            } else {
                try {
                    if (isModuleEnabledForLevel(i, str)) {
                        writeCodeLogNative(i, str, str2, str3);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
        }
        XLoggerInfo xLoggerInfo = new XLoggerInfo();
        xLoggerInfo.level = i;
        xLoggerInfo.ts = System.currentTimeMillis();
        xLoggerInfo.category = LogCategory.CodeLog.getIndex();
        xLoggerInfo.pid = Process.myPid();
        xLoggerInfo.tid = Thread.currentThread().getId();
        xLoggerInfo.module = str;
        xLoggerInfo.tag = str2;
        xLoggerInfo.log = str3;
        sInitCache.add(xLoggerInfo);
    }

    private static native void writeCodeLogNative(int i, String str, String str2, String str3);

    public static void writeLog(LogCategory logCategory, LogLevel logLevel, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            Log.w(TAG, "message is empty");
            return;
        }
        if (TLogInitializer.getInstance().getInitState() == 2) {
            writeCacheTLog();
            if (pid != Process.myPid()) {
                Log.e(TAG, String.format("在fork的进程%d, 写tlog (%d). Module=%s", Integer.valueOf(Process.myPid()), Integer.valueOf(pid), str));
            } else if (!sOpenSoSuccess) {
                Log.e(TAG, "sOpenSoSuccess:" + sOpenSoSuccess);
                return;
            } else {
                try {
                    writeTLogNative2(logCategory.getIndex(), logLevel.getIndex(), str, str2, str3);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } else {
            XLoggerInfo xLoggerInfo = new XLoggerInfo();
            xLoggerInfo.level = LogLevel.E.getIndex();
            xLoggerInfo.ts = System.currentTimeMillis();
            xLoggerInfo.category = logCategory.getIndex();
            xLoggerInfo.module = str;
            xLoggerInfo.tag = str2;
            xLoggerInfo.pid = Process.myPid();
            xLoggerInfo.tid = Thread.currentThread().getId();
            xLoggerInfo.log = str3;
            sInitCache.add(xLoggerInfo);
        }
        if (TLogInitializer.getInstance().isDebugable()) {
            Log.d(str, String.format("[%s]%s", logCategory.getName(), str3));
        }
    }

    static void writeSceneLog(LogLevel logLevel, String str, String str2, String str3, int i, String str4, String str5, String str6) {
        if (!TextUtils.isEmpty(str3) && i != 0) {
            if (TLogInitializer.getInstance().getInitState() == 2) {
                writeCacheTLog();
                if (pid != Process.myPid()) {
                    Log.e(TAG, String.format("在fork的进程%d, 写tlog (%d). Module=%s", Integer.valueOf(Process.myPid()), Integer.valueOf(pid), str));
                } else if (!sOpenSoSuccess) {
                    Log.e(TAG, "sOpenSoSuccess:" + sOpenSoSuccess);
                    return;
                } else {
                    try {
                        writeSceneLogNative(logLevel, str, str2, str3, i, str4, str5, str6);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            } else {
                XLoggerInfo xLoggerInfo = new XLoggerInfo();
                xLoggerInfo.level = LogLevel.E.getIndex();
                xLoggerInfo.ts = System.currentTimeMillis();
                xLoggerInfo.category = LogCategory.SceneLog.getIndex();
                xLoggerInfo.module = str;
                xLoggerInfo.tag = str2;
                xLoggerInfo.pid = Process.myPid();
                xLoggerInfo.tid = Thread.currentThread().getId();
                xLoggerInfo.log = str6 + (char) 31 + i + (char) 31 + str4 + (char) 31 + str5 + (char) 31 + str3;
                sInitCache.add(xLoggerInfo);
            }
            if (TLogInitializer.getInstance().isDebugable()) {
                Log.d("SceneLog", String.format("SceneLog\nsceneID=%s\nsceneType=%s\nsceneUrl=%s\nrefUrl=%s\next=%s", str3, Integer.valueOf(i), str4, str5, str6));
                return;
            }
            return;
        }
        Log.w(TAG, "sceneID is null or SCENE_TYPE_UNKNOWN");
    }

    private static native void writeSceneLogNative(LogLevel logLevel, String str, String str2, String str3, int i, String str4, String str5, String str6);

    private static native void writeTLogNative(long j, long j2, long j3, int i, int i2, String str, String str2, String str3);

    private static native void writeTLogNative2(int i, int i2, String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeTraceLog(LogLevel logLevel, String str, String str2, String str3, String str4, String str5, long j, String str6, String str7, String str8, int i, String str9, String str10) {
        String str11;
        String str12;
        char c;
        char c2;
        char c3;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        if (TextUtils.isEmpty(str6)) {
            Log.w(TAG, "The eventName is empty");
            return;
        }
        String format = str6.length() > 1024 ? String.format("%s...", str6.substring(0, 1024)) : str6;
        String format2 = (TextUtils.isEmpty(str10) || str10.length() <= 30720 - format.length()) ? str10 : String.format("%s...", str10.substring(0, 30720 - format.length()));
        if (TLogInitializer.getInstance().getInitState() == 2) {
            writeCacheTLog();
            if (pid != Process.myPid()) {
                str11 = format;
                c = 2;
                c2 = 0;
                c3 = 1;
                str12 = str;
                Log.e(TAG, String.format("在fork的进程%d, 写tlog (%d). Module=%s", Integer.valueOf(Process.myPid()), Integer.valueOf(pid), str12));
                str13 = format2;
            } else if (!sOpenSoSuccess) {
                Log.e(TAG, "sOpenSoSuccess:" + sOpenSoSuccess);
                return;
            } else {
                c = 2;
                String str21 = format2;
                str11 = format;
                c2 = 0;
                c3 = 1;
                try {
                    writeTraceLogNative(logLevel, str, str2, str3, str4, str5, j, str11, str7, str8, i, str9, str21);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                str13 = str21;
                str12 = str;
            }
            str20 = str2;
            str17 = str3;
            str18 = str4;
            str19 = str5;
            str14 = str7;
            str15 = str8;
            str16 = str9;
        } else {
            str11 = format;
            str12 = str;
            c = 2;
            c2 = 0;
            c3 = 1;
            StringBuilder sb = new StringBuilder();
            sb.append(str11);
            sb.append((char) 31);
            sb.append(i);
            sb.append((char) 31);
            str13 = format2;
            sb.append(str13);
            sb.append((char) 31);
            str14 = str7;
            sb.append(str14);
            sb.append((char) 31);
            str15 = str8;
            sb.append(str15);
            sb.append((char) 31);
            sb.append(j);
            sb.append((char) 31);
            str16 = str9;
            sb.append(str16);
            sb.append((char) 31);
            str17 = str3;
            sb.append(str17);
            sb.append((char) 31);
            str18 = str4;
            sb.append(str18);
            sb.append((char) 31);
            str19 = str5;
            sb.append(str19);
            XLoggerInfo xLoggerInfo = new XLoggerInfo();
            xLoggerInfo.level = LogLevel.E.getIndex();
            xLoggerInfo.ts = System.currentTimeMillis();
            xLoggerInfo.category = LogCategory.TraceEventLog.getIndex();
            xLoggerInfo.module = str12;
            str20 = str2;
            xLoggerInfo.tag = str20;
            xLoggerInfo.log = sb.toString();
            xLoggerInfo.pid = Process.myPid();
            xLoggerInfo.tid = Thread.currentThread().getId();
            sInitCache.add(xLoggerInfo);
        }
        if (!TLogInitializer.getInstance().isDebugable() || DXRecyclerLayout.LOAD_MORE_EMPTY.equals(str18)) {
            return;
        }
        Object[] objArr = new Object[12];
        objArr[c2] = str19;
        objArr[c3] = str17;
        objArr[c] = str18;
        objArr[3] = str12;
        objArr[4] = str20;
        objArr[5] = Long.valueOf(j);
        objArr[6] = str11;
        objArr[7] = str14;
        objArr[8] = str15;
        objArr[9] = Integer.valueOf(i);
        objArr[10] = str16;
        objArr[11] = str13;
        Log.d("TraceLog", String.format("TraceLog:\nsceneID=%s\ncntID=%s\nrefID=%s\nmodule=%s\ntag=%s\neventTime=%d\nevent=%s\neventCode=%s\ncodeMsg=%s\neventType=%s\nbizCode=%s\next=%s", objArr));
    }

    private static native void writeTraceLogNative(LogLevel logLevel, String str, String str2, String str3, String str4, String str5, long j, String str6, String str7, String str8, int i, String str9, String str10);
}
