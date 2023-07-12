package com.taobao.orange;

import android.content.Context;
import com.taobao.orange.OConstant;
import com.taobao.orange.aidl.OrangeConfigListenerStub;
import com.taobao.orange.util.AndroidUtil;
import com.taobao.orange.util.OLog;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class OrangeConfigLocal {
    private static final String TAG = "OrangeConfigLocal";
    private static OrangeConfigLocal mInstance = new OrangeConfigLocal();

    private OrangeConfigLocal() {
    }

    @Deprecated
    public static OrangeConfigLocal getInstance() {
        return mInstance;
    }

    @Deprecated
    public void enterBackground() {
        OLog.e(TAG, "OrangeConfigLocal.enterBackground", "@Deprecated please use OrangeConfig");
    }

    @Deprecated
    public void enterForeground() {
        OLog.e(TAG, "OrangeConfigLocal.forceCheckUpdate", "@Deprecated please use OrangeConfig");
    }

    @Deprecated
    public String getConfig(String str, String str2, String str3) {
        return !GlobalOrange.isMainProcess ? str3 : ConfigCenter.getInstance().getConfig(str, str2, str3);
    }

    @Deprecated
    public Map<String, String> getConfigs(String str) {
        if (GlobalOrange.isMainProcess) {
            return ConfigCenter.getInstance().getConfigs(str);
        }
        return null;
    }

    @Deprecated
    public void init(Context context) {
        init(context, null, null);
    }

    @Deprecated
    public void registerListener(String[] strArr, OrangeConfigListener orangeConfigListener) {
        if (strArr == null || strArr.length == 0 || orangeConfigListener == null) {
            return;
        }
        for (String str : strArr) {
            ConfigCenter.getInstance().registerListener(str, new OrangeConfigListenerStub(orangeConfigListener), true);
        }
    }

    @Deprecated
    public void setAppSecret(String str) {
        OLog.e(TAG, "OrangeConfigLocal.setAppSecret", "@Deprecated please use OrangeConfig");
    }

    @Deprecated
    public void setHosts(List<String> list) {
        OLog.e(TAG, "OrangeConfigLocal.setHosts", "@Deprecated please use OrangeConfig");
    }

    @Deprecated
    public void setIndexUpdateMode(int i) {
        OLog.e(TAG, "OrangeConfigLocal.setIndexUpdateMode", "@Deprecated please use OrangeConfig");
    }

    @Deprecated
    public void setUserId(String str) {
        OLog.e(TAG, "OrangeConfigLocal.setUserId", "@Deprecated please use OrangeConfig");
    }

    @Deprecated
    public void unregisterListener(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        for (String str : strArr) {
            ConfigCenter.getInstance().unregisterListeners(str);
        }
    }

    @Deprecated
    public void init(Context context, String str, String str2) {
        init(context, str, str2, OConstant.ENV.ONLINE.getEnvMode());
    }

    @Deprecated
    public void init(Context context, String str, String str2, int i) {
        OLog.e(TAG, "OrangeConfigLocal.init", "@Deprecated please use OrangeConfig");
        if (context == null) {
            return;
        }
        GlobalOrange.isMainProcess = AndroidUtil.isMainProcess(context);
    }

    @Deprecated
    public void registerListener(String[] strArr, OrangeConfigListenerV1 orangeConfigListenerV1) {
        if (strArr == null || strArr.length == 0 || orangeConfigListenerV1 == null) {
            return;
        }
        for (String str : strArr) {
            ConfigCenter.getInstance().registerListener(str, new OrangeConfigListenerStub(orangeConfigListenerV1), true);
        }
    }
}
