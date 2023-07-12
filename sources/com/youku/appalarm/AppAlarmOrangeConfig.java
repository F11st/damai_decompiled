package com.youku.appalarm;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.orange.OrangeConfig;
import com.taobao.tao.log.TLogInitializer;
import com.ut.device.UTDevice;
import com.youku.us.baseframework.util.StringUtil;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AppAlarmOrangeConfig {
    private static final String NAMESPACE_SWITCH = "ykmcAlarm_android";
    private static final String SDK_SWITCH = "1";
    private static final String SDK_SWITCH_NO_VALUE = "0";
    private static final String TAG = "AppAlarmOrangeConfig";
    private static AppAlarmOrangeConfig sAlarmOrangeConfig;
    private Context mContext;

    private AppAlarmOrangeConfig() {
    }

    public static AppAlarmOrangeConfig getInstance() {
        if (sAlarmOrangeConfig == null) {
            synchronized (AppAlarmOrangeConfig.class) {
                if (sAlarmOrangeConfig == null) {
                    sAlarmOrangeConfig = new AppAlarmOrangeConfig();
                }
            }
        }
        return sAlarmOrangeConfig;
    }

    public boolean getMainSwitch() {
        try {
            return "1".equals(OrangeConfig.getInstance().getConfig(NAMESPACE_SWITCH, "switch", "0"));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getVIPSwitch() {
        try {
            return "1".equals(OrangeConfig.getInstance().getConfig(NAMESPACE_SWITCH, "VIPSwitch", "0"));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isInRange(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (StringUtil.equalsIgnoreCase(str, str2.trim())) {
                return true;
            }
        }
        return false;
    }

    public boolean isMatchBlackListBiztype(String str) {
        if (str != null && getMainSwitch()) {
            try {
                String config = OrangeConfig.getInstance().getConfig(NAMESPACE_SWITCH, "blackList", "");
                if (TextUtils.isEmpty(config)) {
                    return false;
                }
                return isInRange(str, config.split(","));
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public boolean isMatchWhiteList() {
        try {
            String config = OrangeConfig.getInstance().getConfig(NAMESPACE_SWITCH, "whiteList", "");
            if (!TextUtils.isEmpty(config)) {
                String[] split = config.split(",");
                if (this.mContext == null) {
                    this.mContext = TLogInitializer.getInstance().getContext();
                }
                try {
                    if (isInRange(UTDevice.getUtdid(this.mContext), split)) {
                        return true;
                    }
                } catch (Exception unused) {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isVIPMainSwitchOn() {
        return OrangeConfig.getInstance().getConfigs(NAMESPACE_SWITCH) != null && getMainSwitch() && getVIPSwitch() && isMatchWhiteList();
    }
}
