package com.taobao.phenix.cache.disk;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CacheUnavailableException extends Exception {
    public CacheUnavailableException(DiskCache diskCache, String str) {
        super("disk cache=" + diskCache + " open failed, url=" + str);
    }
}
