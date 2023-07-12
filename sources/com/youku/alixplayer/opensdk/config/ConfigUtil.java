package com.youku.alixplayer.opensdk.config;

import com.youku.alixplayer.IConfigCenter;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ConfigUtil {
    private static IConfigCenterFactory mConfigCenterFactory;

    public static IConfigCenter getConfigCenter() {
        IConfigCenterFactory iConfigCenterFactory = mConfigCenterFactory;
        if (iConfigCenterFactory != null) {
            return iConfigCenterFactory.getConfigCenter();
        }
        return null;
    }

    public static void setConfigCenterFactory(IConfigCenterFactory iConfigCenterFactory) {
        mConfigCenterFactory = iConfigCenterFactory;
    }
}
