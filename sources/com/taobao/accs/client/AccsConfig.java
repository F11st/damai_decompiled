package com.taobao.accs.client;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsException;
import com.taobao.accs.IProcessName;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes8.dex */
public class AccsConfig {
    private static final String TAG = "AccsConfig";
    public static AccsClientConfig.Builder mBuilder;
    private static boolean mInitConfig;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public enum ACCS_GROUP {
        TAOBAO,
        ALIYUN,
        OPEN
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public enum SECURITY_TYPE {
        SECURITY_TAOBAO,
        SECURITY_OPEN,
        SECURITY_OFF
    }

    public static void build() {
        try {
            AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(ACCSManager.getDefaultConfig(null));
            if (AccsClientConfig.loadedStaticConfig && configByTag != null) {
                ALog.w(TAG, "default config already exists", new Object[0]);
            }
            getBuilder().build();
        } catch (AccsException e) {
            ALog.e(TAG, "build config error", e, new Object[0]);
        }
    }

    public static void disableInappKeepAlive() {
        getBuilder().setKeepAlive(false);
    }

    private static AccsClientConfig.Builder getBuilder() {
        if (!TextUtils.isEmpty(ACCSManager.mDefaultAppkey)) {
            if (mBuilder == null) {
                mBuilder = new AccsClientConfig.Builder().setAppKey(ACCSManager.mDefaultAppkey).setTag(ACCSManager.getDefaultConfig(null)).setAutoUnit(true);
            }
            return mBuilder;
        }
        throw new RuntimeException("old interface!!, please AccsManager.setAppkey() first!");
    }

    public static void setAccsCenterHosts(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            ALog.i(TAG, "setAccsCenterHost", "env", Integer.valueOf(ACCSManager.mEnv), "releaseHost", str, "prepareHost", str2, "dailyHost", str3);
            int i = ACCSManager.mEnv;
            if (i == 1) {
                getBuilder().setInappHost(str2);
                return;
            } else if (i != 2) {
                getBuilder().setInappHost(str);
                return;
            } else {
                getBuilder().setInappHost(str3);
                return;
            }
        }
        ALog.e(TAG, "setAccsCenterHost null", new Object[0]);
    }

    public static void setAccsCenterIps(String[] strArr, String[] strArr2, String[] strArr3) {
    }

    public static void setAuthCode(String str) {
        getBuilder().setAutoCode(str);
        AdapterGlobalClientInfo.mAuthCode = str;
    }

    public static void setChannelHosts(String str, String str2, String str3) {
        ALog.i(TAG, "env", Integer.valueOf(ACCSManager.mEnv), "setChannelHosts", "releaseHost", str, "prepareHost", str2, "dailyHost", str3);
        int i = ACCSManager.mEnv;
        if (i == 1) {
            getBuilder().setChannelHost(str2);
        } else if (i != 2) {
            getBuilder().setChannelHost(str);
        } else {
            getBuilder().setChannelHost(str3);
        }
    }

    public static void setChannelIps(String[] strArr, String[] strArr2, String[] strArr3) {
    }

    public static void setChannelProcessName(String str) {
        GlobalConfig.setChannelProcessName(str);
    }

    public static void setChannelReuse(boolean z, ACCS_GROUP accs_group) {
        GlobalConfig.setChannelReuse(z, accs_group);
    }

    public static void setControlFrameMaxRetry(int i) {
        GlobalConfig.setControlFrameMaxRetry(i);
    }

    public static void setCurrProcessNameImpl(IProcessName iProcessName) {
        GlobalConfig.setCurrProcessNameImpl(iProcessName);
    }

    public static void setEnableForground(Context context, boolean z) {
        GlobalConfig.setEnableForground(context, z);
    }

    public static void setMainProcessName(String str) {
        GlobalConfig.setMainProcessName(str);
    }

    public static void setSecurityGuardOff(SECURITY_TYPE security_type) {
        AdapterGlobalClientInfo.mSecurityType = security_type.ordinal();
    }

    public static void setTnetPubkey(int i, int i2) {
        ALog.i(TAG, "setTnetPubkey", "pubKey", Integer.valueOf(i), "channelPubKey", Integer.valueOf(i2));
        getBuilder().setInappPubKey(i).setChannelPubKey(i2);
    }
}
