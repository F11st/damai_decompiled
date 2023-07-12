package io.reactivex.internal.operators.flowable;

import io.reactivex.b;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import tb.dg0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class FlowableDefer<T> extends b<T> {
    final Callable<? extends Publisher<? extends T>> supplier;

    public FlowableDefer(Callable<? extends Publisher<? extends T>> callable) {
        this.supplier = callable;
    }

    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            ((Publisher) ObjectHelper.requireNonNull(this.supplier.call(), "The publisher supplied is null")).subscribe(subscriber);
        } catch (Throwable th) {
            dg0.b(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
