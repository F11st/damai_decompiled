package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.c;
import io.reactivex.disposables.a;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class MaybeError<T> extends c<T> {
    final Throwable error;

    public MaybeError(Throwable th) {
        this.error = th;
    }

    @Override // io.reactivex.c
    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(a.a());
        maybeObserver.onError(this.error);
    }
}
