package tb;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class s52<T> implements FlowableSubscriber<T>, Subscription {
    final Subscriber<? super T> a;
    Subscription b;
    boolean c;

    public s52(Subscriber<? super T> subscriber) {
        this.a = subscriber;
    }

    void a() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.a.onSubscribe(EmptySubscription.INSTANCE);
            try {
                this.a.onError(nullPointerException);
            } catch (Throwable th) {
                dg0.b(th);
                i42.u(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            dg0.b(th2);
            i42.u(new CompositeException(nullPointerException, th2));
        }
    }

    void b() {
        this.c = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.a.onSubscribe(EmptySubscription.INSTANCE);
            try {
                this.a.onError(nullPointerException);
            } catch (Throwable th) {
                dg0.b(th);
                i42.u(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            dg0.b(th2);
            i42.u(new CompositeException(nullPointerException, th2));
        }
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        try {
            this.b.cancel();
        } catch (Throwable th) {
            dg0.b(th);
            i42.u(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.c) {
            return;
        }
        this.c = true;
        if (this.b == null) {
            a();
            return;
        }
        try {
            this.a.onComplete();
        } catch (Throwable th) {
            dg0.b(th);
            i42.u(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.c) {
            i42.u(th);
            return;
        }
        this.c = true;
        if (this.b == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.a.onSubscribe(EmptySubscription.INSTANCE);
                try {
                    this.a.onError(new CompositeException(th, nullPointerException));
                    return;
                } catch (Throwable th2) {
                    dg0.b(th2);
                    i42.u(new CompositeException(th, nullPointerException, th2));
                    return;
                }
            } catch (Throwable th3) {
                dg0.b(th3);
                i42.u(new CompositeException(th, nullPointerException, th3));
                return;
            }
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        try {
            this.a.onError(th);
        } catch (Throwable th4) {
            dg0.b(th4);
            i42.u(new CompositeException(th, th4));
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (this.c) {
            return;
        }
        if (this.b == null) {
            b();
        } else if (t == null) {
            NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            try {
                this.b.cancel();
                onError(nullPointerException);
            } catch (Throwable th) {
                dg0.b(th);
                onError(new CompositeException(nullPointerException, th));
            }
        } else {
            try {
                this.a.onNext(t);
            } catch (Throwable th2) {
                dg0.b(th2);
                try {
                    this.b.cancel();
                    onError(th2);
                } catch (Throwable th3) {
                    dg0.b(th3);
                    onError(new CompositeException(th2, th3));
                }
            }
        }
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.b, subscription)) {
            this.b = subscription;
            try {
                this.a.onSubscribe(this);
            } catch (Throwable th) {
                dg0.b(th);
                this.c = true;
                try {
                    subscription.cancel();
                    i42.u(th);
                } catch (Throwable th2) {
                    dg0.b(th2);
                    i42.u(new CompositeException(th, th2));
                }
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        try {
            this.b.request(j);
        } catch (Throwable th) {
            dg0.b(th);
            try {
                this.b.cancel();
                i42.u(th);
            } catch (Throwable th2) {
                dg0.b(th2);
                i42.u(new CompositeException(th, th2));
            }
        }
    }
}
