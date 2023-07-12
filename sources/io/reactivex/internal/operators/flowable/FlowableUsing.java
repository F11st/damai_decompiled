package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.dg0;
import tb.i42;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class FlowableUsing<T, D> extends b<T> {
    final Consumer<? super D> disposer;
    final boolean eager;
    final Callable<? extends D> resourceSupplier;
    final Function<? super D, ? extends Publisher<? extends T>> sourceSupplier;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class UsingSubscriber<T, D> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 5904473792286235046L;
        final Subscriber<? super T> actual;
        final Consumer<? super D> disposer;
        final boolean eager;
        final D resource;
        Subscription s;

        UsingSubscriber(Subscriber<? super T> subscriber, D d, Consumer<? super D> consumer, boolean z) {
            this.actual = subscriber;
            this.resource = d;
            this.disposer = consumer;
            this.eager = z;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            disposeAfter();
            this.s.cancel();
        }

        void disposeAfter() {
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept((D) this.resource);
                } catch (Throwable th) {
                    dg0.b(th);
                    i42.u(th);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.eager) {
                if (compareAndSet(false, true)) {
                    try {
                        this.disposer.accept((D) this.resource);
                    } catch (Throwable th) {
                        dg0.b(th);
                        this.actual.onError(th);
                        return;
                    }
                }
                this.s.cancel();
                this.actual.onComplete();
                return;
            }
            this.actual.onComplete();
            this.s.cancel();
            disposeAfter();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.eager) {
                Throwable th2 = null;
                if (compareAndSet(false, true)) {
                    try {
                        this.disposer.accept((D) this.resource);
                    } catch (Throwable th3) {
                        th2 = th3;
                        dg0.b(th2);
                    }
                }
                this.s.cancel();
                if (th2 != null) {
                    this.actual.onError(new CompositeException(th, th2));
                    return;
                } else {
                    this.actual.onError(th);
                    return;
                }
            }
            this.actual.onError(th);
            this.s.cancel();
            disposeAfter();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.s.request(j);
        }
    }

    public FlowableUsing(Callable<? extends D> callable, Function<? super D, ? extends Publisher<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        this.resourceSupplier = callable;
        this.sourceSupplier = function;
        this.disposer = consumer;
        this.eager = z;
    }

    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            D call = this.resourceSupplier.call();
            try {
                ((Publisher) ObjectHelper.requireNonNull(this.sourceSupplier.apply(call), "The sourceSupplier returned a null Publisher")).subscribe(new UsingSubscriber(subscriber, call, this.disposer, this.eager));
            } catch (Throwable th) {
                dg0.b(th);
                try {
                    this.disposer.accept(call);
                    EmptySubscription.error(th, subscriber);
                } catch (Throwable th2) {
                    dg0.b(th2);
                    EmptySubscription.error(new CompositeException(th, th2), subscriber);
                }
            }
        } catch (Throwable th3) {
            dg0.b(th3);
            EmptySubscription.error(th3, subscriber);
        }
    }
}
