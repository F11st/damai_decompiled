package tb;

import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class sa2<T> extends mn0<T> {
    final mn0<T> a;
    boolean b;
    AppendOnlyLinkedArrayList<Object> c;
    volatile boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public sa2(mn0<T> mn0Var) {
        this.a = mn0Var;
    }

    void b() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        while (true) {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.c;
                if (appendOnlyLinkedArrayList == null) {
                    this.b = false;
                    return;
                }
                this.c = null;
            }
            appendOnlyLinkedArrayList.accept(this.a);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.d) {
            return;
        }
        synchronized (this) {
            if (this.d) {
                return;
            }
            this.d = true;
            if (this.b) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.c;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                    this.c = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.add(NotificationLite.complete());
                return;
            }
            this.b = true;
            this.a.onComplete();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.d) {
            i42.u(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.d) {
                this.d = true;
                if (this.b) {
                    AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.c;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                        this.c = appendOnlyLinkedArrayList;
                    }
                    appendOnlyLinkedArrayList.setFirst(NotificationLite.error(th));
                    return;
                }
                this.b = true;
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
        if (this.d) {
            return;
        }
        synchronized (this) {
            if (this.d) {
                return;
            }
            if (this.b) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.c;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                    this.c = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.add(NotificationLite.next(t));
                return;
            }
            this.b = true;
            this.a.onNext(t);
            b();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        boolean z = true;
        if (!this.d) {
            synchronized (this) {
                if (!this.d) {
                    if (this.b) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.c;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.c = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.subscription(subscription));
                        return;
                    }
                    this.b = true;
                    z = false;
                }
            }
        }
        if (z) {
            subscription.cancel();
            return;
        }
        this.a.onSubscribe(subscription);
        b();
    }

    @Override // io.reactivex.b
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.a.subscribe(subscriber);
    }
}
