package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.d;
import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ObservableNever extends d<Object> {
    public static final d<Object> INSTANCE = new ObservableNever();

    private ObservableNever() {
    }

    @Override // io.reactivex.d
    protected void subscribeActual(Observer<? super Object> observer) {
        observer.onSubscribe(EmptyDisposable.NEVER);
    }
}
