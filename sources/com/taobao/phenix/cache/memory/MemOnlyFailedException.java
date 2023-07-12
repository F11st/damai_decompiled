package com.taobao.phenix.cache.memory;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MemOnlyFailedException extends Exception {
    public MemOnlyFailedException() {
        super("no memory cache , MemCache cannot conduct final result at memOnly=true");
    }
}
