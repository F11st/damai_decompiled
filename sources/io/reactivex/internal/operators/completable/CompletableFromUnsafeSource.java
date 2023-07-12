package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.a;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class CompletableFromUnsafeSource extends a {
    final CompletableSource source;

    public CompletableFromUnsafeSource(CompletableSource completableSource) {
        this.source = completableSource;
    }

    @Override // io.reactivex.a
    protected void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(completableObserver);
    }
}
