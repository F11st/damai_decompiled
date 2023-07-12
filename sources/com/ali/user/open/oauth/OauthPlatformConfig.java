package com.ali.user.open.oauth;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class OauthPlatformConfig {
    private static Map<String, AppCredential> sPlateformConfigs = new HashMap();

    public static AppCredential getOauthConfigByPlatform(String str) {
        return sPlateformConfigs.get(str);
    }

    public static void setOauthConfig(String str, AppCredential appCredential) {
        sPlateformConfigs.put(str, appCredential);
    }
}
