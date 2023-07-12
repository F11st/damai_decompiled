package org.apache.commons.lang3.concurrent;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface ConcurrentInitializer<T> {
    T get() throws ConcurrentException;
}
