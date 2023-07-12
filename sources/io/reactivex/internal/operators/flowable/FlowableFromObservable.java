package io.reactivex.internal.operators.flowable;

import io.reactivex.Observer;
import io.reactivex.b;
import io.reactivex.d;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class FlowableFromObservable<T> extends b<T> {
    private final d<T> upstream;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static class SubscriberObserver<T> implements Observer<T>, Subscription {
        private Disposable d;
        private final Subscriber<? super T> s;

        SubscriberObserver(Subscriber<? super T> subscriber) {
            this.s = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.d.dispose();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.s.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.s.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.s.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.d = disposable;
            this.s.onSubscribe(this);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
        }
    }

    public FlowableFromObservable(d<T> dVar) {
        this.upstream = dVar;
    }

    @Override // io.reactivex.b
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.upstream.subscribe(new SubscriberObserver(subscriber));
    }
}
