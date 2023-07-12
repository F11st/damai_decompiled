package com.uc.webview.export.internal.setup;

import android.util.Pair;
import com.uc.webview.export.CDParamKeys;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ap extends bh {
    private static String c = ap.class.getSimpleName();
    private static long d = 1;
    private static long e = 2;
    private static long f = 4;
    private static long g = 8;
    private static long h = 4 << 1;

    @Override // com.uc.webview.export.internal.setup.bh, com.uc.webview.export.internal.setup.UCAsyncTask, java.lang.Runnable
    public void run() {
        long j;
        Log.d(c, "==run.");
        long j2 = e;
        callbackStat(new Pair<>(IWaStat.SHARE_CORE_FAULTTOLERANCE_SETUP_TASK_RUN, null));
        try {
            if (!com.uc.webview.export.internal.utility.p.a(UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_BAK_KRL_DIR))) {
                j = f;
                String str = c;
                Log.d(str, ".run bak krl dir: " + UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_BAK_KRL_DIR));
                callbackStat(new Pair<>(IWaStat.SHARE_CORE_FAULTTOLERANCE_SETUP_TASK_KRL, null));
                ((l) ((l) ((l) ((l) ((l) setup(UCCore.OPTION_DEX_FILE_PATH, (Object) null)).setup(UCCore.OPTION_SO_FILE_PATH, (Object) null)).setup(UCCore.OPTION_RES_FILE_PATH, (Object) null)).setup(UCCore.OPTION_UCM_LIB_DIR, (Object) null)).setup(UCCore.OPTION_UCM_KRL_DIR, (Object) UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_BAK_KRL_DIR))).setup(UCCore.OPTION_UCM_CFG_FILE, (Object) null);
                super.run();
            } else if (!com.uc.webview.export.internal.utility.p.a(UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_BAK_ZIP_FPATH))) {
                j = g;
                String str2 = c;
                Log.d(str2, ".run bak core file: " + UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_BAK_ZIP_FPATH));
                callbackStat(new Pair<>(IWaStat.SHARE_CORE_FAULTTOLERANCE_SETUP_TASK_ZIP, null));
                this.mCallbacks = null;
                resetCrashFlag();
                ((l) ((l) ((l) ((l) ((l) ((l) ((l) ((l) ((l) new b().setParent(this)).setCallbacks(this.mCallbacks)).setOptions(this.mOptions)).setup(UCCore.OPTION_DEX_FILE_PATH, (Object) null)).setup(UCCore.OPTION_SO_FILE_PATH, (Object) null)).setup(UCCore.OPTION_RES_FILE_PATH, (Object) null)).setup(UCCore.OPTION_UCM_CFG_FILE, (Object) null)).setup(UCCore.OPTION_UCM_KRL_DIR, (Object) null)).setup(UCCore.OPTION_UCM_ZIP_FILE, (Object) UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_BAK_ZIP_FPATH))).start();
            } else {
                long j3 = h;
                callbackStat(new Pair<>(IWaStat.SHARE_CORE_FAULTTOLERANCE_SETUP_TASK_EXCEPTION, null));
                throw new UCSetupException(3033, String.format(c + " not config (%s or %s)", CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_BAK_KRL_DIR, CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_BAK_ZIP_FPATH));
            }
            String str3 = c;
            Log.d(str3, ".run stat: " + j);
        } catch (Throwable th) {
            String str4 = c;
            Log.d(str4, ".run stat: " + j2);
            throw th;
        }
    }
}
