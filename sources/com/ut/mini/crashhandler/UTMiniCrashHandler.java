package com.ut.mini.crashhandler;

import android.content.Context;
import java.lang.Thread;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTMiniCrashHandler implements Thread.UncaughtExceptionHandler {
    private static final String TAG = "UTCrashHandler";
    private static UTMiniCrashHandler s_instance = new UTMiniCrashHandler();
    private static volatile boolean mCrashing = false;
    private Thread.UncaughtExceptionHandler mDefaultHandler = null;
    private IUTCrashCaughtListner mListener = null;
    private Context mContext = null;
    private boolean mIsTurnOff = true;

    private UTMiniCrashHandler() {
    }

    private void _initialize() {
        if (this.mIsTurnOff) {
            this.mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
            this.mIsTurnOff = false;
        }
    }

    public static UTMiniCrashHandler getInstance() {
        return s_instance;
    }

    public boolean isTurnOff() {
        return this.mIsTurnOff;
    }

    public void setCrashCaughtListener(IUTCrashCaughtListner iUTCrashCaughtListner) {
        this.mListener = iUTCrashCaughtListner;
    }

    public void turnOff() {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mDefaultHandler;
        if (uncaughtExceptionHandler != null) {
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
            this.mDefaultHandler = null;
        }
        this.mIsTurnOff = true;
    }

    public void turnOn(Context context) {
        _initialize();
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x009d, code lost:
        if (r1 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a6, code lost:
        if (r1 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a8, code lost:
        r1.uncaughtException(r12, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ac, code lost:
        android.os.Process.killProcess(android.os.Process.myPid());
        java.lang.System.exit(10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b6, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:?, code lost:
        return;
     */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void uncaughtException(java.lang.Thread r12, java.lang.Throwable r13) {
        /*
            r11 = this;
            r0 = 10
            boolean r1 = com.ut.mini.crashhandler.UTMiniCrashHandler.mCrashing     // Catch: java.lang.Throwable -> La0
            if (r1 == 0) goto L19
            java.lang.Thread$UncaughtExceptionHandler r1 = r11.mDefaultHandler
            if (r1 == 0) goto Le
            r1.uncaughtException(r12, r13)
            goto L18
        Le:
            int r12 = android.os.Process.myPid()
            android.os.Process.killProcess(r12)
            java.lang.System.exit(r0)
        L18:
            return
        L19:
            r1 = 1
            com.ut.mini.crashhandler.UTMiniCrashHandler.mCrashing = r1     // Catch: java.lang.Throwable -> La0
            r2 = 0
            if (r13 == 0) goto L29
            java.lang.String r3 = "Caught Exception By UTCrashHandler.Please see log as follows!"
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> La0
            com.alibaba.analytics.utils.Logger.i(r3, r4)     // Catch: java.lang.Throwable -> La0
            r13.printStackTrace()     // Catch: java.lang.Throwable -> La0
        L29:
            com.ut.mini.crashhandler.UTExceptionParser$UTExceptionItem r3 = com.ut.mini.crashhandler.UTExceptionParser.parse(r13)     // Catch: java.lang.Throwable -> La0
            if (r3 == 0) goto L9b
            java.lang.String r4 = r3.mCrashDetail     // Catch: java.lang.Throwable -> La0
            if (r4 == 0) goto L9b
            java.lang.String r4 = r3.getExpName()     // Catch: java.lang.Throwable -> La0
            if (r4 == 0) goto L9b
            java.lang.String r4 = r3.getMd5()     // Catch: java.lang.Throwable -> La0
            if (r4 == 0) goto L9b
            r4 = 0
            com.ut.mini.crashhandler.IUTCrashCaughtListner r5 = r11.mListener     // Catch: java.lang.Throwable -> La0
            if (r5 == 0) goto L4d
            java.util.Map r4 = r5.onCrashCaught(r12, r13)     // Catch: java.lang.Throwable -> L49
            goto L4d
        L49:
            r5 = move-exception
            r5.printStackTrace()     // Catch: java.lang.Throwable -> La0
        L4d:
            if (r4 != 0) goto L54
            java.util.HashMap r4 = new java.util.HashMap     // Catch: java.lang.Throwable -> La0
            r4.<init>()     // Catch: java.lang.Throwable -> La0
        L54:
            r9 = r4
            java.lang.String r4 = "StackTrace"
            java.lang.String r5 = r3.getCrashDetail()     // Catch: java.lang.Throwable -> La0
            r9.put(r4, r5)     // Catch: java.lang.Throwable -> La0
            com.ut.mini.internal.UTOriginalCustomHitBuilder r10 = new com.ut.mini.internal.UTOriginalCustomHitBuilder     // Catch: java.lang.Throwable -> La0
            java.lang.String r4 = "UT"
            r5 = 1
            java.lang.String r6 = r3.getMd5()     // Catch: java.lang.Throwable -> La0
            java.lang.String r7 = r3.getExpName()     // Catch: java.lang.Throwable -> La0
            r8 = 0
            r3 = r10
            r3.<init>(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> La0
            java.lang.String r3 = "_priority"
            java.lang.String r4 = "5"
            r10.setProperty(r3, r4)     // Catch: java.lang.Throwable -> La0
            java.lang.String r3 = "_sls"
            java.lang.String r4 = "yes"
            r10.setProperty(r3, r4)     // Catch: java.lang.Throwable -> La0
            com.ut.mini.UTAnalytics r3 = com.ut.mini.UTAnalytics.getInstance()     // Catch: java.lang.Throwable -> La0
            com.ut.mini.UTTracker r3 = r3.getDefaultTracker()     // Catch: java.lang.Throwable -> La0
            if (r3 == 0) goto L90
            java.util.Map r1 = r10.build()     // Catch: java.lang.Throwable -> La0
            r3.send(r1)     // Catch: java.lang.Throwable -> La0
            goto L9b
        L90:
            java.lang.String r3 = "Record crash stacktrace error"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> La0
            java.lang.String r4 = "Fatal Error,must call setRequestAuthentication method first."
            r1[r2] = r4     // Catch: java.lang.Throwable -> La0
            com.alibaba.analytics.utils.Logger.i(r3, r1)     // Catch: java.lang.Throwable -> La0
        L9b:
            java.lang.Thread$UncaughtExceptionHandler r1 = r11.mDefaultHandler
            if (r1 == 0) goto Lac
            goto La8
        La0:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> Lb7
            java.lang.Thread$UncaughtExceptionHandler r1 = r11.mDefaultHandler
            if (r1 == 0) goto Lac
        La8:
            r1.uncaughtException(r12, r13)
            goto Lb6
        Lac:
            int r12 = android.os.Process.myPid()
            android.os.Process.killProcess(r12)
            java.lang.System.exit(r0)
        Lb6:
            return
        Lb7:
            r1 = move-exception
            java.lang.Thread$UncaughtExceptionHandler r2 = r11.mDefaultHandler
            if (r2 == 0) goto Lc2
            java.lang.Thread$UncaughtExceptionHandler r0 = r11.mDefaultHandler
            r0.uncaughtException(r12, r13)
            goto Lcc
        Lc2:
            int r12 = android.os.Process.myPid()
            android.os.Process.killProcess(r12)
            java.lang.System.exit(r0)
        Lcc:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ut.mini.crashhandler.UTMiniCrashHandler.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }
}
