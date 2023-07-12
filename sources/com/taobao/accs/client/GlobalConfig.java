package com.taobao.accs.client;

import android.content.Context;
import com.taobao.accs.ChannelService;
import com.taobao.accs.IProcessName;
import com.taobao.accs.client.AccsConfig;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.OrangeAdapter;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class GlobalConfig {
    private static final String TAG = "GlobalConfig";
    public static AccsConfig.ACCS_GROUP mGroup = AccsConfig.ACCS_GROUP.TAOBAO;
    public static boolean enableCookie = true;

    public static void setChannelProcessName(String str) {
        AdapterGlobalClientInfo.mChannelProcessName = str;
        try {
            GlobalClientInfo.getContext().getSharedPreferences(Constants.SP_FILE_NAME, 4).edit().putBoolean(Constants.SP_KEY_ASP_ENABLE, false).apply();
        } catch (Exception e) {
            ALog.e(TAG, "setChannelProcessName err", e, new Object[0]);
        }
    }

    public static void setChannelReuse(boolean z, AccsConfig.ACCS_GROUP accs_group) {
        GlobalClientInfo.mSupprotElection = z;
        mGroup = accs_group;
    }

    public static void setControlFrameMaxRetry(int i) {
        Message.CONTROL_MAX_RETRY_TIMES = i;
    }

    public static void setCurrProcessNameImpl(IProcessName iProcessName) {
        AdapterGlobalClientInfo.mProcessNameImpl = iProcessName;
    }

    public static void setEnableForground(Context context, boolean z) {
        ALog.i(TAG, "setEnableForground", "enable", Boolean.valueOf(z));
        OrangeAdapter.saveConfigToSP(context, ChannelService.SUPPORT_FOREGROUND_VERSION_KEY, z ? 21 : 0);
    }

    public static void setMainProcessName(String str) {
        AdapterGlobalClientInfo.mMainProcessName = str;
    }
}
