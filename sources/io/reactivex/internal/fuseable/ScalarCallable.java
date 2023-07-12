package io.reactivex.internal.fuseable;

import java.util.concurrent.Callable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface ScalarCallable<T> extends Callable<T> {
    @Override // java.util.concurrent.Callable
    T call();
}
