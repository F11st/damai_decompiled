package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.a;
import io.reactivex.e;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class SingleJust<T> extends e<T> {
    final T value;

    public SingleJust(T t) {
        this.value = t;
    }

    @Override // io.reactivex.e
    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        singleObserver.onSubscribe(a.a());
        singleObserver.onSuccess((T) this.value);
    }
}
