package com.taobao.android.utils.pools;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface Pools$Pool<T> {
    T acquire();

    boolean release(T t);

    void shutdown();
}
