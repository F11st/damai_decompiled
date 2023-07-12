package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.CDParamKeys;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.utility.Log;
import com.youku.uplayer.MsgID;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class aq extends bh {
    private static String c = aq.class.getSimpleName();
    private static long d = 1;
    private static long e = 2;
    private static long f = 4;
    private static long g = 8;
    private static long h = 16;
    private static long i = 32;

    @Override // com.uc.webview.export.internal.setup.bh, com.uc.webview.export.internal.setup.UCAsyncTask, java.lang.Runnable
    public void run() {
        String str;
        StringBuilder sb;
        long j = e;
        try {
            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDCARD_SETUP_TASK_RUN);
            if (!com.uc.webview.export.internal.utility.p.a(UCSetupTask.getTotalLoadedUCM())) {
                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDCARD_SETUP_TASK_HAD_INIT);
                str = c;
                sb = new StringBuilder(".run stat: ");
            } else {
                String str2 = (String) getOption(UCCore.OPTION_LOCAL_DIR);
                if (com.uc.webview.export.internal.utility.p.a(str2)) {
                    str2 = com.uc.webview.export.internal.utility.j.d(getContext().getApplicationContext());
                }
                String str3 = c;
                Log.d(str3, ".run locationDecDir: " + str2);
                if (!com.uc.webview.export.internal.utility.p.a(str2)) {
                    j = f;
                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDCARD_SETUP_TASK_LOCATION_DEC);
                    ((l) ((l) ((l) ((l) ((l) setup(UCCore.OPTION_DEX_FILE_PATH, (Object) null)).setup(UCCore.OPTION_SO_FILE_PATH, (Object) null)).setup(UCCore.OPTION_RES_FILE_PATH, (Object) null)).setup(UCCore.OPTION_UCM_LIB_DIR, (Object) null)).setup(UCCore.OPTION_UCM_CFG_FILE, (Object) null)).setup(UCCore.OPTION_UCM_KRL_DIR, (Object) str2);
                    super.run();
                } else {
                    ValueCallback<CALLBACK_TYPE> callback = getCallback(UCCore.EVENT_DELAY_SEARCH_CORE_FILE);
                    String str4 = c;
                    Log.d(str4, ".run delaySeareCoreFileCB: " + callback);
                    if (callback == 0) {
                        String str5 = (String) getOption(UCCore.OPTION_DEC_FILE);
                        if (com.uc.webview.export.internal.utility.p.a(str5)) {
                            str5 = com.uc.webview.export.internal.utility.j.e(getContext().getApplicationContext());
                        }
                        String str6 = c;
                        Log.d(str6, ".run sdCoreDecFilePath: " + str5);
                        if (!com.uc.webview.export.internal.utility.p.a(str5)) {
                            j = g;
                            Integer num = (Integer) this.mOptions.get(UCCore.OPTION_VERIFY_POLICY);
                            String param = UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_VERIFY_POLICY);
                            if (CDParamKeys.CD_VALUE_VERIFY_ALL_HASH_ASYNC.equals(param)) {
                                num = Integer.valueOf(num.intValue() | UCCore.VERIFY_POLICY_ALL_FULL_HASH);
                            } else if (CDParamKeys.CD_VALUE_VERIFY_ALL_HASH_SYNC.equals(param)) {
                                num = Integer.valueOf(Integer.valueOf(num.intValue() | UCCore.VERIFY_POLICY_ALL_FULL_HASH).intValue() & Integer.MAX_VALUE);
                            }
                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDCARD_SETUP_TASK_SDCARD);
                            this.mCallbacks = null;
                            resetCrashFlag();
                            ((l) ((l) ((l) ((l) ((l) ((l) ((l) ((l) ((l) ((l) new b().setParent(this)).setCallbacks(this.mCallbacks)).setOptions(this.mOptions)).setup(UCCore.OPTION_VERIFY_POLICY, (Object) num)).setup(UCCore.OPTION_DEX_FILE_PATH, (Object) null)).setup(UCCore.OPTION_SO_FILE_PATH, (Object) null)).setup(UCCore.OPTION_RES_FILE_PATH, (Object) null)).setup(UCCore.OPTION_UCM_CFG_FILE, (Object) null)).setup(UCCore.OPTION_UCM_KRL_DIR, (Object) null)).setup(UCCore.OPTION_UCM_ZIP_FILE, (Object) str5)).start();
                        } else {
                            long j2 = h;
                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDCARD_SETUP_TASK_EXCEPTION);
                            throw new UCSetupException((int) MsgID.ERRCODE_COMBINE_VIDEO_ERROR, c + " not found uc core");
                        }
                    } else {
                        long j3 = i;
                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDCARD_SETUP_DELAY_SEARCH_CORE_FILE);
                        callback.onReceiveValue(this);
                        throw new UCSetupException(3035, c + " delay search sdcard core file.");
                    }
                }
                str = c;
                sb = new StringBuilder(".run stat: ");
            }
            sb.append(j);
            Log.d(str, sb.toString());
        } catch (Throwable th) {
            String str7 = c;
            Log.d(str7, ".run stat: " + j);
            throw th;
        }
    }
}
