package io.reactivex.internal.operators.completable;

import io.reactivex.AbstractC8146a;
import io.reactivex.CompletableObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class CompletableNever extends AbstractC8146a {
    public static final AbstractC8146a INSTANCE = new CompletableNever();

    private CompletableNever() {
    }

    @Override // io.reactivex.AbstractC8146a
    protected void subscribeActual(CompletableObserver completableObserver) {
        completableObserver.onSubscribe(EmptyDisposable.NEVER);
    }
}
