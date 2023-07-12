package com.taobao.orange.launch;

import android.app.Application;
import com.taobao.orange.OConfig;
import com.taobao.orange.OConstant;
import com.taobao.orange.OrangeConfig;
import com.taobao.orange.util.OLog;
import com.uc.webview.export.extension.UCCore;
import java.io.Serializable;
import java.util.HashMap;
import tb.jn1;

/* loaded from: classes11.dex */
public class TaobaoLaunchOrange implements Serializable {
    private static final String TAG = "TbLaunchOrange";

    public void init(Application application, HashMap<String, Object> hashMap) {
        String str;
        String str2;
        OLog.d(TAG, "init start", new Object[0]);
        String str3 = jn1.MUL;
        OConstant.ENV env = OConstant.ENV.ONLINE;
        int envMode = env.getEnvMode();
        try {
            str2 = (String) hashMap.get("appVersion");
            try {
                envMode = ((Integer) hashMap.get("envIndex")).intValue();
                if (envMode == env.getEnvMode()) {
                    str = (String) hashMap.get("onlineAppKey");
                } else if (envMode == OConstant.ENV.PREPARE.getEnvMode()) {
                    str = (String) hashMap.get("preAppKey");
                } else {
                    str = (String) hashMap.get("dailyAppkey");
                }
            } catch (Throwable th) {
                th = th;
                str3 = str2;
                OLog.e(TAG, UCCore.LEGACY_EVENT_INIT, th, new Object[0]);
                str = "21646297";
                str2 = str3;
                OrangeConfig.getInstance().init(application, new OConfig.Builder().setAppKey(str).setAppVersion(str2).setEnv(envMode).setServerType(OConstant.SERVER.TAOBAO.ordinal()).setIndexUpdateMode(OConstant.UPDMODE.O_XMD.ordinal()).setReportAck(false).setStatUsedConfig(true).setTime(-1L).build());
            }
        } catch (Throwable th2) {
            th = th2;
        }
        OrangeConfig.getInstance().init(application, new OConfig.Builder().setAppKey(str).setAppVersion(str2).setEnv(envMode).setServerType(OConstant.SERVER.TAOBAO.ordinal()).setIndexUpdateMode(OConstant.UPDMODE.O_XMD.ordinal()).setReportAck(false).setStatUsedConfig(true).setTime(-1L).build());
    }
}
