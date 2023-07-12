package io.reactivex.internal.operators.flowable;

import io.reactivex.b;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import tb.dg0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class FlowableError<T> extends b<T> {
    final Callable<? extends Throwable> errorSupplier;

    public FlowableError(Callable<? extends Throwable> callable) {
        this.errorSupplier = callable;
    }

    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            th = (Throwable) ObjectHelper.requireNonNull(this.errorSupplier.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            dg0.b(th);
        }
        EmptySubscription.error(th, subscriber);
    }
}
