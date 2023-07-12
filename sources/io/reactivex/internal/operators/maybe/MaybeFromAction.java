package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.c;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.a;
import io.reactivex.functions.Action;
import java.util.concurrent.Callable;
import tb.dg0;
import tb.i42;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class MaybeFromAction<T> extends c<T> implements Callable<T> {
    final Action action;

    public MaybeFromAction(Action action) {
        this.action = action;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        this.action.run();
        return null;
    }

    @Override // io.reactivex.c
    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Disposable b = a.b();
        maybeObserver.onSubscribe(b);
        if (b.isDisposed()) {
            return;
        }
        try {
            this.action.run();
            if (b.isDisposed()) {
                return;
            }
            maybeObserver.onComplete();
        } catch (Throwable th) {
            dg0.b(th);
            if (!b.isDisposed()) {
                maybeObserver.onError(th);
            } else {
                i42.u(th);
            }
        }
    }
}
