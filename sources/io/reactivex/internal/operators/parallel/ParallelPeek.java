package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.LongConsumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.a;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.dg0;
import tb.i42;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ParallelPeek<T> extends a<T> {
    final Consumer<? super T> onAfterNext;
    final Action onAfterTerminated;
    final Action onCancel;
    final Action onComplete;
    final Consumer<? super Throwable> onError;
    final Consumer<? super T> onNext;
    final LongConsumer onRequest;
    final Consumer<? super Subscription> onSubscribe;
    final a<T> source;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class ParallelPeekSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> actual;
        boolean done;
        final ParallelPeek<T> parent;
        Subscription s;

        ParallelPeekSubscriber(Subscriber<? super T> subscriber, ParallelPeek<T> parallelPeek) {
            this.actual = subscriber;
            this.parent = parallelPeek;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            try {
                this.parent.onCancel.run();
            } catch (Throwable th) {
                dg0.b(th);
                i42.u(th);
            }
            this.s.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            try {
                this.parent.onComplete.run();
                this.actual.onComplete();
                try {
                    this.parent.onAfterTerminated.run();
                } catch (Throwable th) {
                    dg0.b(th);
                    i42.u(th);
                }
            } catch (Throwable th2) {
                dg0.b(th2);
                this.actual.onError(th2);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                i42.u(th);
                return;
            }
            this.done = true;
            try {
                this.parent.onError.accept(th);
            } catch (Throwable th2) {
                dg0.b(th2);
                th = new CompositeException(th, th2);
            }
            this.actual.onError(th);
            try {
                this.parent.onAfterTerminated.run();
            } catch (Throwable th3) {
                dg0.b(th3);
                i42.u(th3);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                this.parent.onNext.accept(t);
                this.actual.onNext(t);
                try {
                    this.parent.onAfterNext.accept(t);
                } catch (Throwable th) {
                    dg0.b(th);
                    onError(th);
                }
            } catch (Throwable th2) {
                dg0.b(th2);
                onError(th2);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                try {
                    this.parent.onSubscribe.accept(subscription);
                    this.actual.onSubscribe(this);
                } catch (Throwable th) {
                    dg0.b(th);
                    subscription.cancel();
                    this.actual.onSubscribe(EmptySubscription.INSTANCE);
                    onError(th);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            try {
                this.parent.onRequest.accept(j);
            } catch (Throwable th) {
                dg0.b(th);
                i42.u(th);
            }
            this.s.request(j);
        }
    }

    public ParallelPeek(a<T> aVar, Consumer<? super T> consumer, Consumer<? super T> consumer2, Consumer<? super Throwable> consumer3, Action action, Action action2, Consumer<? super Subscription> consumer4, LongConsumer longConsumer, Action action3) {
        this.source = aVar;
        this.onNext = (Consumer) ObjectHelper.requireNonNull(consumer, "onNext is null");
        this.onAfterNext = (Consumer) ObjectHelper.requireNonNull(consumer2, "onAfterNext is null");
        this.onError = (Consumer) ObjectHelper.requireNonNull(consumer3, "onError is null");
        this.onComplete = (Action) ObjectHelper.requireNonNull(action, "onComplete is null");
        this.onAfterTerminated = (Action) ObjectHelper.requireNonNull(action2, "onAfterTerminated is null");
        this.onSubscribe = (Consumer) ObjectHelper.requireNonNull(consumer4, "onSubscribe is null");
        this.onRequest = (LongConsumer) ObjectHelper.requireNonNull(longConsumer, "onRequest is null");
        this.onCancel = (Action) ObjectHelper.requireNonNull(action3, "onCancel is null");
    }

    @Override // io.reactivex.parallel.a
    public int parallelism() {
        return this.source.parallelism();
    }

    @Override // io.reactivex.parallel.a
    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber<? super T>[] subscriberArr2 = new Subscriber[length];
            for (int i = 0; i < length; i++) {
                subscriberArr2[i] = new ParallelPeekSubscriber(subscriberArr[i], this);
            }
            this.source.subscribe(subscriberArr2);
        }
    }
}
