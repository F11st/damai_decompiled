package com.taobao.tao.log.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.taobao.tao.log.LogLevel;
import com.taobao.tao.log.TLogController;
import com.taobao.tao.log.TLogNative;
import com.taobao.tao.log.TLogUtils;
import com.taobao.tao.log.utils.TLogMultiProcessReceiver;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TLogMultiProcessReceiver extends BroadcastReceiver {
    private static final String TAG = "TLogProcessReceiver";

    private void changeLogLevel(Intent intent) {
        if (intent == null) {
            return;
        }
        Log.e(TAG, "TLog MultiProcess changeLogLevel");
        try {
            TLogController.getInstance().setLogLevel((LogLevel) intent.getSerializableExtra(TLogMultiProcessTool.PARAM_LOG_LEVEL));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void changeModuleLevel(Intent intent) {
        if (intent == null) {
            return;
        }
        Log.e(TAG, "TLog MultiProcess changeModuleLevel");
        try {
            String stringExtra = intent.getStringExtra(TLogMultiProcessTool.PARAM_MODULE_LEVEL);
            if ("off".equals(stringExtra)) {
                TLogController.getInstance().cleanModuleFilter();
            } else {
                Map<String, LogLevel> makeModule = TLogUtils.makeModule(stringExtra);
                if (makeModule != null && makeModule.size() > 0) {
                    TLogController.getInstance().addModuleFilter(makeModule);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void flushLog() {
        try {
            Log.e(TAG, "TLog MultiProcess flushLog");
            TLogNative.appenderFlushData(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0066, code lost:
        if (r2 == 1) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0068, code lost:
        if (r2 == 2) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006b, code lost:
        changeModuleLevel(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006f, code lost:
        changeLogLevel(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ void lambda$onReceive$3(android.content.Intent r7) {
        /*
            r6 = this;
            java.lang.String r0 = "TLogProcessReceiver"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L77
            r1.<init>()     // Catch: java.lang.Exception -> L77
            java.lang.String r2 = "Receive action: "
            r1.append(r2)     // Catch: java.lang.Exception -> L77
            java.lang.String r2 = r7.getAction()     // Catch: java.lang.Exception -> L77
            r1.append(r2)     // Catch: java.lang.Exception -> L77
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L77
            android.util.Log.d(r0, r1)     // Catch: java.lang.Exception -> L77
            java.lang.String r1 = "tlog_pid"
            r2 = -1
            int r1 = r7.getIntExtra(r1, r2)     // Catch: java.lang.Exception -> L77
            int r3 = android.os.Process.myPid()     // Catch: java.lang.Exception -> L77
            if (r3 != r1) goto L2d
            java.lang.String r7 = "The sender is current process!"
            android.util.Log.d(r0, r7)     // Catch: java.lang.Exception -> L77
            return
        L2d:
            java.lang.String r0 = r7.getAction()     // Catch: java.lang.Exception -> L77
            int r1 = r0.hashCode()     // Catch: java.lang.Exception -> L77
            r3 = -836891243(0xffffffffce1e0d95, float:-6.6292256E8)
            r4 = 2
            r5 = 1
            if (r1 == r3) goto L5b
            r3 = -730623461(0xffffffffd473921b, float:-4.1845132E12)
            if (r1 == r3) goto L51
            r3 = -268762717(0xffffffffeffb01a3, float:-1.5536543E29)
            if (r1 == r3) goto L47
            goto L64
        L47:
            java.lang.String r1 = "com.taobao.tao.log.change.modulelevel"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L77
            if (r0 == 0) goto L64
            r2 = 2
            goto L64
        L51:
            java.lang.String r1 = "com.taobao.tao.log.flush"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L77
            if (r0 == 0) goto L64
            r2 = 0
            goto L64
        L5b:
            java.lang.String r1 = "com.taobao.tao.log.change.loglevel"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L77
            if (r0 == 0) goto L64
            r2 = 1
        L64:
            if (r2 == 0) goto L73
            if (r2 == r5) goto L6f
            if (r2 == r4) goto L6b
            goto L7b
        L6b:
            r6.changeModuleLevel(r7)     // Catch: java.lang.Exception -> L77
            goto L7b
        L6f:
            r6.changeLogLevel(r7)     // Catch: java.lang.Exception -> L77
            goto L7b
        L73:
            r6.flushLog()     // Catch: java.lang.Exception -> L77
            goto L7b
        L77:
            r7 = move-exception
            r7.printStackTrace()
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.tao.log.utils.TLogMultiProcessReceiver.lambda$onReceive$3(android.content.Intent):void");
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, final Intent intent) {
        if (!TLogMultiProcessTool.isEnable(context)) {
            Log.e(TAG, "The TLogMultiProcessNotify is disable");
        } else if (intent == null || intent.getAction() == null) {
        } else {
            TLogThreadPool.getInstance().execute(new Runnable() { // from class: tb.lk2
                @Override // java.lang.Runnable
                public final void run() {
                    TLogMultiProcessReceiver.this.lambda$onReceive$3(intent);
                }
            });
        }
    }
}
