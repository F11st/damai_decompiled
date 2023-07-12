package com.taobao.zcache.custom;

import java.io.InputStream;
import java.util.Map;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class ZCustomCacheManager {
    private static ZCustomCacheManager instance;

    public static ZCustomCacheManager getInstance() {
        if (instance == null) {
            synchronized (ZCustomCacheManager.class) {
                if (instance == null) {
                    instance = new ZCustomCacheManager();
                }
            }
        }
        return instance;
    }

    @Deprecated
    public InputStream getCacheResource(String str, String[] strArr, Map<String, String> map, Map<String, String> map2) {
        return null;
    }

    @Deprecated
    public void registerHandler(ZCustomCacheHandler zCustomCacheHandler) {
    }
}
