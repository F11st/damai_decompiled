package tb;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ua2<T> implements FlowableSubscriber<T>, Subscription {
    final Subscriber<? super T> a;
    final boolean b;
    Subscription c;
    boolean d;
    AppendOnlyLinkedArrayList<Object> e;
    volatile boolean f;

    public ua2(Subscriber<? super T> subscriber) {
        this(subscriber, false);
    }

    void a() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.e;
                if (appendOnlyLinkedArrayList == null) {
                    this.d = false;
                    return;
                }
                this.e = null;
            }
        } while (!appendOnlyLinkedArrayList.accept((Subscriber<? super T>) this.a));
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.c.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.f) {
            return;
        }
        synchronized (this) {
            if (this.f) {
                return;
            }
            if (this.d) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.e;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                    this.e = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.add(NotificationLite.complete());
                return;
            }
            this.f = true;
            this.d = true;
            this.a.onComplete();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.f) {
            i42.u(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f) {
                if (this.d) {
                    this.f = true;
                    AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.e;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                        this.e = appendOnlyLinkedArrayList;
                    }
                    Object error = NotificationLite.error(th);
                    if (this.b) {
                        appendOnlyLinkedArrayList.add(error);
                    } else {
                        appendOnlyLinkedArrayList.setFirst(error);
                    }
                    return;
                }
                this.f = true;
                this.d = true;
                z = false;
            }
            if (z) {
                i42.u(th);
            } else {
                this.a.onError(th);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (this.f) {
            return;
        }
        if (t == null) {
            this.c.cancel();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.f) {
                return;
            }
            if (this.d) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.e;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                    this.e = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.add(NotificationLite.next(t));
                return;
            }
            this.d = true;
            this.a.onNext(t);
            a();
        }
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.c, subscription)) {
            this.c = subscription;
            this.a.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        this.c.request(j);
    }

    public ua2(Subscriber<? super T> subscriber, boolean z) {
        this.a = subscriber;
        this.b = z;
    }
}
