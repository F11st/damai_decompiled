package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.c;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class MaybeFromFuture<T> extends c<T> {
    final Future<? extends T> future;
    final long timeout;
    final TimeUnit unit;

    public MaybeFromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        this.future = future;
        this.timeout = j;
        this.unit = timeUnit;
    }

    @Override // io.reactivex.c
    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Object obj;
        Disposable b = a.b();
        maybeObserver.onSubscribe(b);
        if (b.isDisposed()) {
            return;
        }
        try {
            long j = this.timeout;
            if (j <= 0) {
                obj = (T) this.future.get();
            } else {
                obj = (T) this.future.get(j, this.unit);
            }
            if (b.isDisposed()) {
                return;
            }
            if (obj == null) {
                maybeObserver.onComplete();
            } else {
                maybeObserver.onSuccess(obj);
            }
        } catch (InterruptedException e) {
            if (b.isDisposed()) {
                return;
            }
            maybeObserver.onError(e);
        } catch (ExecutionException e2) {
            if (b.isDisposed()) {
                return;
            }
            maybeObserver.onError(e2.getCause());
        } catch (TimeoutException e3) {
            if (b.isDisposed()) {
                return;
            }
            maybeObserver.onError(e3);
        }
    }
}
