package io.reactivex.internal.operators.maybe;

import io.reactivex.AbstractC8148c;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.C8151a;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class MaybeError<T> extends AbstractC8148c<T> {
    final Throwable error;

    public MaybeError(Throwable th) {
        this.error = th;
    }

    @Override // io.reactivex.AbstractC8148c
    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(C8151a.a());
        maybeObserver.onError(this.error);
    }
}
