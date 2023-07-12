package io.reactivex.internal.operators.flowable;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.b;
import io.reactivex.disposables.Disposable;
import io.reactivex.e;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ArrayListSupplier;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscription;
import tb.dg0;
import tb.i42;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class FlowableToListSingle<T, U extends Collection<? super T>> extends e<U> implements FuseToFlowable<U> {
    final Callable<U> collectionSupplier;
    final b<T> source;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class ToListSubscriber<T, U extends Collection<? super T>> implements FlowableSubscriber<T>, Disposable {
        final SingleObserver<? super U> actual;
        Subscription s;
        U value;

        ToListSubscriber(SingleObserver<? super U> singleObserver, U u) {
            this.actual = singleObserver;
            this.value = u;
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
            this.actual.onSuccess(this.value);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.value = null;
            this.s = SubscriptionHelper.CANCELLED;
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.value.add(t);
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

    public FlowableToListSingle(b<T> bVar) {
        this(bVar, ArrayListSupplier.asCallable());
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public b<U> fuseToFlowable() {
        return i42.l(new FlowableToList(this.source, this.collectionSupplier));
    }

    @Override // io.reactivex.e
    protected void subscribeActual(SingleObserver<? super U> singleObserver) {
        try {
            this.source.subscribe((FlowableSubscriber) new ToListSubscriber(singleObserver, (Collection) ObjectHelper.requireNonNull(this.collectionSupplier.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            dg0.b(th);
            EmptyDisposable.error(th, singleObserver);
        }
    }

    public FlowableToListSingle(b<T> bVar, Callable<U> callable) {
        this.source = bVar;
        this.collectionSupplier = callable;
    }
}
