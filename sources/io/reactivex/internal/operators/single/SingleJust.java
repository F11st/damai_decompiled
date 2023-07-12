package io.reactivex.internal.operators.single;

import io.reactivex.AbstractC8152e;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.C8151a;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class SingleJust<T> extends AbstractC8152e<T> {
    final T value;

    public SingleJust(T t) {
        this.value = t;
    }

    @Override // io.reactivex.AbstractC8152e
    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        singleObserver.onSubscribe(C8151a.a());
        singleObserver.onSuccess((T) this.value);
    }
}
