package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.a;
import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class CompletableEmpty extends a {
    public static final a INSTANCE = new CompletableEmpty();

    private CompletableEmpty() {
    }

    @Override // io.reactivex.a
    public void subscribeActual(CompletableObserver completableObserver) {
        EmptyDisposable.complete(completableObserver);
    }
}
