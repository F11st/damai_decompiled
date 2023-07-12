package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC8147b;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class FlowableEmpty extends AbstractC8147b<Object> implements ScalarCallable<Object> {
    public static final AbstractC8147b<Object> INSTANCE = new FlowableEmpty();

    private FlowableEmpty() {
    }

    @Override // io.reactivex.internal.fuseable.ScalarCallable, java.util.concurrent.Callable
    public Object call() {
        return null;
    }

    @Override // io.reactivex.AbstractC8147b
    public void subscribeActual(Subscriber<? super Object> subscriber) {
        EmptySubscription.complete(subscriber);
    }
}
