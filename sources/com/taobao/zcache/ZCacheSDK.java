package com.taobao.zcache;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class ZCacheSDK {
    public static void init(ZCacheParams zCacheParams) {
        ZCache.setEnv(ZCacheParams.getEnvironment(zCacheParams.env));
        ZCache.setLocale(zCacheParams.locale);
        if (zCacheParams.configPrefix != null || zCacheParams.zipPrefix != null || zCacheParams.updateInterval > 0.0d) {
            ZCacheConfig zCacheConfig = new ZCacheConfig();
            zCacheConfig.configPrefixRelease = zCacheParams.configPrefix;
            zCacheConfig.zipPrefixRelease = zCacheParams.zipPrefix;
            zCacheConfig.configUpdateInterval = zCacheParams.updateInterval;
            ZCache.setConfig(zCacheConfig);
        }
        ZCache.setup(zCacheParams.context, zCacheParams.appKey, zCacheParams.appVersion);
    }

    public static void initExtra() {
    }

    public static void initSub() {
        ZCache.setup(null, null, null);
    }
}
