package io.reactivex.internal.operators.flowable;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.b;
import io.reactivex.disposables.Disposable;
import io.reactivex.e;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;
import tb.i42;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class FlowableElementAtSingle<T> extends e<T> implements FuseToFlowable<T> {
    final T defaultValue;
    final long index;
    final b<T> source;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class ElementAtSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final SingleObserver<? super T> actual;
        long count;
        final T defaultValue;
        boolean done;
        final long index;
        Subscription s;

        ElementAtSubscriber(SingleObserver<? super T> singleObserver, long j, T t) {
            this.actual = singleObserver;
            this.index = j;
            this.defaultValue = t;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.s.cancel();
            this.s = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.s == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.s = SubscriptionHelper.CANCELLED;
            if (this.done) {
                return;
            }
            this.done = true;
            T t = this.defaultValue;
            if (t != null) {
                this.actual.onSuccess(t);
            } else {
                this.actual.onError(new NoSuchElementException());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                i42.u(th);
                return;
            }
            this.done = true;
            this.s = SubscriptionHelper.CANCELLED;
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j = this.count;
            if (j == this.index) {
                this.done = true;
                this.s.cancel();
                this.s = SubscriptionHelper.CANCELLED;
                this.actual.onSuccess(t);
                return;
            }
            this.count = j + 1;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(AbsPerformance.LONG_NIL);
            }
        }
    }

    public FlowableElementAtSingle(b<T> bVar, long j, T t) {
        this.source = bVar;
        this.index = j;
        this.defaultValue = t;
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public b<T> fuseToFlowable() {
        return i42.l(new FlowableElementAt(this.source, this.index, this.defaultValue, true));
    }

    @Override // io.reactivex.e
    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe((FlowableSubscriber) new ElementAtSubscriber(singleObserver, this.index, this.defaultValue));
    }
}
