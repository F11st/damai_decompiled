package io.reactivex.internal.operators.completable;

import io.reactivex.AbstractC8146a;
import io.reactivex.CompletableObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class CompletableEmpty extends AbstractC8146a {
    public static final AbstractC8146a INSTANCE = new CompletableEmpty();

    private CompletableEmpty() {
    }

    @Override // io.reactivex.AbstractC8146a
    public void subscribeActual(CompletableObserver completableObserver) {
        EmptyDisposable.complete(completableObserver);
    }
}
