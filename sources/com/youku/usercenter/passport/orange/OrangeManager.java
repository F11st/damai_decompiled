package com.youku.usercenter.passport.orange;

import com.taobao.orange.OrangeConfig;
import com.youku.usercenter.passport.util.Logger;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class OrangeManager {
    static final String NAMESPACE_DEFAULT = "passport_config";
    private static final String NAMESPACE_ROLLBACK_SWITCH = "passport_switch_rollback";
    private static final String NAMESPACE_URLS = "passport_urls";

    public static boolean getRollbackSwitch(String str) {
        try {
            return Boolean.parseBoolean(OrangeConfig.getInstance().getConfig(NAMESPACE_ROLLBACK_SWITCH, str, "false"));
        } catch (Exception e) {
            Logger.printStackTrace(e);
            return false;
        }
    }

    public static String getUrl(String str) {
        return OrangeConfig.getInstance().getConfig(NAMESPACE_URLS, str, null);
    }

    public static void init() {
        OrangeConfig.getInstance().getConfigs(NAMESPACE_DEFAULT);
        OrangeConfig.getInstance().getConfigs(NAMESPACE_URLS);
        OrangeConfig.getInstance().getConfigs(NAMESPACE_ROLLBACK_SWITCH);
        OrangeConfig.getInstance().registerListener(new String[]{NAMESPACE_DEFAULT}, new OConfigListener());
    }
}
