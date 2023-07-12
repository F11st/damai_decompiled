package com.taobao.zcache.global;

import android.content.Context;
import android.os.Handler;
import com.taobao.zcache.ZCache;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class ZCacheGlobal {
    public static final int DAILY = 2;
    private static ZCacheGlobal INSTANCE = null;
    public static final int ONLINE = 0;
    public static final int PRE = 1;
    public static final String TAG = "ZCache3.0";
    public static final int ZCacheFeatureDefault = 0;
    public static final int ZCacheFeatureDisableIncrement = 65536;
    public static final int ZCacheFeatureEncryptA = 1;
    public static final int ZCacheFeatureUseOldAWPServerAPI = 131072;
    public static final int ZCacheFeatureWaitUntilUpdateQueue = 2;
    private Context context;

    public static ZCacheGlobal instance() {
        if (INSTANCE == null) {
            synchronized (ZCacheGlobal.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ZCacheGlobal();
                }
            }
        }
        return INSTANCE;
    }

    public String appKey() {
        return null;
    }

    public String appVersion() {
        return null;
    }

    public Context context() {
        return this.context;
    }

    public int env() {
        return 0;
    }

    public Handler handler() {
        return null;
    }

    public void setAppKey(String str) {
    }

    public void setAppVersion(String str) {
    }

    @Deprecated
    public void setContext(Context context) {
        this.context = context;
        ZCache.setContext(context);
    }

    public void setEnv(int i) {
    }
}
