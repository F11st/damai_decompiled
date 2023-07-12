package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.c;
import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class MaybeNever extends c<Object> {
    public static final MaybeNever INSTANCE = new MaybeNever();

    @Override // io.reactivex.c
    protected void subscribeActual(MaybeObserver<? super Object> maybeObserver) {
        maybeObserver.onSubscribe(EmptyDisposable.NEVER);
    }
}
