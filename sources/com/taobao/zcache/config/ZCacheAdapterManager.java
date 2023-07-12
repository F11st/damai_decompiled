package com.taobao.zcache.config;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ZCacheAdapterManager {
    private static ZCacheAdapterManager instance;
    private IZCacheUpdate update;

    public static ZCacheAdapterManager getInstance() {
        if (instance == null) {
            synchronized (ZCacheAdapterManager.class) {
                if (instance == null) {
                    instance = new ZCacheAdapterManager();
                }
            }
        }
        return instance;
    }

    @Deprecated
    public Object getRequest() {
        return null;
    }

    public IZCacheUpdate getUpdateImpl() {
        return this.update;
    }

    @Deprecated
    public void setRequest(Object obj) {
    }

    public void setUpdateImpl(IZCacheUpdate iZCacheUpdate) {
        this.update = iZCacheUpdate;
    }
}
