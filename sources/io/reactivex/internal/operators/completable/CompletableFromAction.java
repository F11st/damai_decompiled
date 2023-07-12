package io.reactivex.internal.operators.completable;

import io.reactivex.AbstractC8146a;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.C8151a;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import tb.dg0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class CompletableFromAction extends AbstractC8146a {
    final Action run;

    public CompletableFromAction(Action action) {
        this.run = action;
    }

    @Override // io.reactivex.AbstractC8146a
    protected void subscribeActual(CompletableObserver completableObserver) {
        Disposable b = C8151a.b();
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
