package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

/* compiled from: Taobao */
@Beta
@GwtCompatible
/* loaded from: classes10.dex */
public interface AsyncCallable<V> {
    ListenableFuture<V> call() throws Exception;
}
