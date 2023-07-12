package com.youku.media.arch.instruments;

import com.youku.media.arch.instruments.ConfigFetcher;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface GetterFactory {

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface Provider {
        GetterFactory getFactory();
    }

    void fillinPersistentNamespaces(ConfigFetcher configFetcher);

    ConfigFetcher.ConfigGetter getGetter();

    void notifyCachedNamespaceAdded(String str);

    void notifyCachedNamespaceRemoved(String str);

    boolean skipDefaultCache();
}
