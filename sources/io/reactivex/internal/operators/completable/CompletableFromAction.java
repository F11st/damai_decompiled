package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.a;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import tb.dg0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class CompletableFromAction extends a {
    final Action run;

    public CompletableFromAction(Action action) {
        this.run = action;
    }

    @Override // io.reactivex.a
    protected void subscribeActual(CompletableObserver completableObserver) {
        Disposable b = io.reactivex.disposables.a.b();
        completableObserver.onSubscribe(b);
        try {
            this.run.run();
            if (b.isDisposed()) {
                return;
            }
            completableObserver.onComplete();
        } catch (Throwable th) {
            dg0.b(th);
            if (b.isDisposed()) {
                return;
            }
            completableObserver.onError(th);
        }
    }
}
