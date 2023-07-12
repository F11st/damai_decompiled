package com.taobao.zcache;

import android.content.Context;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class ZCacheParams {
    public String appKey;
    public String appVersion;
    public String configPrefix;
    public Context context;
    public int env;
    public String locale;
    public double updateInterval = 0.0d;
    public boolean useOldPlatform = false;
    public String zipPrefix;

    public static Environment getEnvironment(int i) {
        if (i != 1) {
            if (i != 2) {
                return Environment.Release;
            }
            return Environment.Daily;
        }
        return Environment.Debug;
    }
}
