package com.youku.live.dsl.config;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IRemoteConfig extends IConfigBase {
    public static final String CONFIG_VERSION = "configVersion";
    public static final String UPDATE_FROM_CACHE = "fromCache";

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface OnRemoteConfigUpdateListener {
        void onRemoteConfigUpdate(String str, Map<String, String> map);
    }

    String getEnv();

    boolean isInited();

    void registerListener(String[] strArr, OnRemoteConfigUpdateListener onRemoteConfigUpdateListener);

    void unregisterListener(String[] strArr, OnRemoteConfigUpdateListener onRemoteConfigUpdateListener);
}
