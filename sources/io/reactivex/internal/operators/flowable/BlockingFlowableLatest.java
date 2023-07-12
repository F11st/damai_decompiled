package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.subscribers.b;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import tb.i42;
import tb.ul1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class BlockingFlowableLatest<T> implements Iterable<T> {
    final Publisher<? extends T> source;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class LatestSubscriberIterator<T> extends b<ul1<T>> implements Iterator<T> {
        ul1<T> iteratorNotification;
        final Semaphore notify = new Semaphore(0);
        final AtomicReference<ul1<T>> value = new AtomicReference<>();

        LatestSubscriberIterator() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            ul1<T> ul1Var = this.iteratorNotification;
            if (ul1Var != null && ul1Var.g()) {
                throw ExceptionHelper.wrapOrThrow(this.iteratorNotification.d());
            }
            ul1<T> ul1Var2 = this.iteratorNotification;
            if ((ul1Var2 == null || ul1Var2.h()) && this.iteratorNotification == null) {
                try {
                    BlockingHelper.verifyNonBlocking();
                    this.notify.acquire();
                    ul1<T> andSet = this.value.getAndSet(null);
                    this.iteratorNotification = andSet;
                    if (andSet.g()) {
                        throw ExceptionHelper.wrapOrThrow(andSet.d());
                    }
                } catch (InterruptedException e) {
                    dispose();
                    this.iteratorNotification = ul1.b(e);
                    throw ExceptionHelper.wrapOrThrow(e);
                }
            }
            return this.iteratorNotification.h();
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext() && this.iteratorNotification.h()) {
                T e = this.iteratorNotification.e();
                this.iteratorNotification = null;
                return e;
            }
            throw new NoSuchElementException();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            i42.u(th);
        }

        @Override // org.reactivestreams.Subscriber
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((ul1) ((ul1) obj));
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }

        public void onNext(ul1<T> ul1Var) {
            if (this.value.getAndSet(ul1Var) == null) {
                this.notify.release();
            }
        }
    }

    public BlockingFlowableLatest(Publisher<? extends T> publisher) {
        this.source = publisher;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        LatestSubscriberIterator latestSubscriberIterator = new LatestSubscriberIterator();
        io.reactivex.b.fromPublisher(this.source).materialize().subscribe((FlowableSubscriber<? super ul1<T>>) latestSubscriberIterator);
        return latestSubscriberIterator;
    }
}
