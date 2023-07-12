package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.CDParamKeys;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ar extends bh {
    private static String c = ar.class.getSimpleName();
    private static long d = 1;
    private static long e = 2;
    private static long f = 4;
    private static long g = 8;
    private static long h = 16;

    @Override // com.uc.webview.export.internal.setup.bh, com.uc.webview.export.internal.setup.UCAsyncTask, java.lang.Runnable
    public void run() {
        String str;
        StringBuilder sb;
        long j = e;
        try {
            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SEARCH_CORE_FILE_TASK_RUN);
            if (!"0".equals((String) UCCore.getGlobalOption(UCCore.PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION))) {
                j = h;
                str = c;
                sb = new StringBuilder(".run stat: ");
            } else {
                ((l) ((l) ((l) onEvent("success", (ValueCallback) new av(this))).onEvent("exception", (ValueCallback) new au(this))).onEvent(UCCore.LEGACY_EVENT_SETUP, (ValueCallback) new at(this))).onEvent("switch", (ValueCallback) new as(this));
                String e2 = com.uc.webview.export.internal.utility.j.e(getContext().getApplicationContext());
                String str2 = c;
                Log.d(str2, ".run sdCoreDecFilePath: " + e2);
                if (!com.uc.webview.export.internal.utility.p.a(e2)) {
                    j = f;
                    Integer num = (Integer) this.mOptions.get(UCCore.OPTION_VERIFY_POLICY);
                    String param = UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_VERIFY_POLICY);
                    if (CDParamKeys.CD_VALUE_VERIFY_ALL_HASH_ASYNC.equals(param)) {
                        num = Integer.valueOf(num.intValue() | UCCore.VERIFY_POLICY_ALL_FULL_HASH);
                    } else if (CDParamKeys.CD_VALUE_VERIFY_ALL_HASH_SYNC.equals(param)) {
                        num = Integer.valueOf(Integer.valueOf(num.intValue() | UCCore.VERIFY_POLICY_ALL_FULL_HASH).intValue() & Integer.MAX_VALUE);
                    }
                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SEARCH_CORE_FILE_SDCARD);
                    this.mCallbacks = null;
                    resetCrashFlag();
                    ((l) ((l) ((l) ((l) ((l) ((l) ((l) ((l) ((l) ((l) ((l) ((l) new b().setParent(this)).setCallbacks(this.mCallbacks)).setOptions(this.mOptions)).setup(UCCore.OPTION_VERIFY_POLICY, (Object) num)).setup(UCCore.OPTION_DEX_FILE_PATH, (Object) null)).setup(UCCore.OPTION_SO_FILE_PATH, (Object) null)).setup(UCCore.OPTION_RES_FILE_PATH, (Object) null)).setup(UCCore.OPTION_UCM_CFG_FILE, (Object) null)).setup(UCCore.OPTION_UCM_KRL_DIR, (Object) null)).setup(UCCore.OPTION_UCM_ZIP_FILE, (Object) e2)).setup(UCCore.OPTION_SHARE_CORE_SETUP_TASK_FLAG, (Object) Boolean.TRUE)).setup(UCCore.OPTION_ENABLE_LOAD_CLASS, (Object) Boolean.FALSE)).start();
                    str = c;
                    sb = new StringBuilder(".run stat: ");
                } else {
                    long j2 = g;
                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SEARCH_CORE_FILE_EXCEPTION);
                    throw new UCSetupException(3036, c + " not found uc core");
                }
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                str = c;
                sb = new StringBuilder(".run stat: ");
            } catch (Throwable th2) {
                String str3 = c;
                Log.d(str3, ".run stat: " + j);
                throw th2;
            }
        }
        sb.append(j);
        Log.d(str, sb.toString());
    }
}
