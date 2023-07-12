package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.a;
import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class CompletableNever extends a {
    public static final a INSTANCE = new CompletableNever();

    private CompletableNever() {
    }

    @Override // io.reactivex.a
    protected void subscribeActual(CompletableObserver completableObserver) {
        completableObserver.onSubscribe(EmptyDisposable.NEVER);
    }
}
