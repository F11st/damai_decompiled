package com.taobao.tcommon.core;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface Pool<T> {
    T offer();

    boolean recycle(T t);
}
