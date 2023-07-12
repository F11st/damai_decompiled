package com.taobao.zcache;

import android.app.Application;
import android.content.Context;
import java.util.HashMap;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class ZCacheInitializer {
    public static void init(Context context, String str, String str2, int i, boolean z, String str3, String str4, String str5, double d) {
        ZCache.setEnv(ZCacheParams.getEnvironment(i));
        ZCache.setLocale(str5);
        if (str3 != null || str4 != null || d > 0.0d) {
            ZCacheConfig zCacheConfig = new ZCacheConfig();
            zCacheConfig.configPrefixRelease = str3;
            zCacheConfig.zipPrefixRelease = str4;
            zCacheConfig.configUpdateInterval = d;
            ZCache.setConfig(zCacheConfig);
        }
        ZCache.setup(context, str, str2);
    }

    public static void initConfig() {
    }

    public static void initSubProcess() {
        ZCache.setup(null, null, null);
    }

    public static void startUpdateQueue() {
    }

    public void init(Application application, HashMap<String, Object> hashMap) {
    }
}
