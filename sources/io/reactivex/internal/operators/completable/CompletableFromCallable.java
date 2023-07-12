package io.reactivex.internal.operators.completable;

import io.reactivex.AbstractC8146a;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.C8151a;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.Callable;
import tb.dg0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class CompletableFromCallable extends AbstractC8146a {
    final Callable<?> callable;

    public CompletableFromCallable(Callable<?> callable) {
        this.callable = callable;
    }

    @Override // io.reactivex.AbstractC8146a
    protected void subscribeActual(CompletableObserver completableObserver) {
        Disposable b = C8151a.b();
        completableObserver.onSubscribe(b);
        try {
            this.callable.call();
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
