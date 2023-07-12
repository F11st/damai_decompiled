package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.e;
import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class SingleNever extends e<Object> {
    public static final e<Object> INSTANCE = new SingleNever();

    private SingleNever() {
    }

    @Override // io.reactivex.e
    protected void subscribeActual(SingleObserver<? super Object> singleObserver) {
        singleObserver.onSubscribe(EmptyDisposable.NEVER);
    }
}
