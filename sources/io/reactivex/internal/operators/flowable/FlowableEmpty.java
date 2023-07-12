package io.reactivex.internal.operators.flowable;

import io.reactivex.b;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class FlowableEmpty extends b<Object> implements ScalarCallable<Object> {
    public static final b<Object> INSTANCE = new FlowableEmpty();

    private FlowableEmpty() {
    }

    @Override // io.reactivex.internal.fuseable.ScalarCallable, java.util.concurrent.Callable
    public Object call() {
        return null;
    }

    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super Object> subscriber) {
        EmptySubscription.complete(subscriber);
    }
}
