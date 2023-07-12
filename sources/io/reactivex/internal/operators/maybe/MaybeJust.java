package io.reactivex.internal.operators.maybe;

import io.reactivex.AbstractC8148c;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.C8151a;
import io.reactivex.internal.fuseable.ScalarCallable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class MaybeJust<T> extends AbstractC8148c<T> implements ScalarCallable<T> {
    final T value;

    public MaybeJust(T t) {
        this.value = t;
    }

    @Override // io.reactivex.internal.fuseable.ScalarCallable, java.util.concurrent.Callable
    public T call() {
        return this.value;
    }

    @Override // io.reactivex.AbstractC8148c
    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(C8151a.a());
        maybeObserver.onSuccess((T) this.value);
    }
}
