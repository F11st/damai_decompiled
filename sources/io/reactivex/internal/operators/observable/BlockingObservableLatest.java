package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.d;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.b;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import tb.i42;
import tb.ul1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class BlockingObservableLatest<T> implements Iterable<T> {
    final ObservableSource<T> source;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class BlockingObservableLatestIterator<T> extends b<ul1<T>> implements Iterator<T> {
        ul1<T> iteratorNotification;
        final Semaphore notify = new Semaphore(0);
        final AtomicReference<ul1<T>> value = new AtomicReference<>();

        BlockingObservableLatestIterator() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            ul1<T> ul1Var = this.iteratorNotification;
            if (ul1Var != null && ul1Var.g()) {
                throw ExceptionHelper.wrapOrThrow(this.iteratorNotification.d());
            }
            if (this.iteratorNotification == null) {
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
            if (hasNext()) {
                T e = this.iteratorNotification.e();
                this.iteratorNotification = null;
                return e;
            }
            throw new NoSuchElementException();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            i42.u(th);
        }

        @Override // io.reactivex.Observer
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

    public BlockingObservableLatest(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        BlockingObservableLatestIterator blockingObservableLatestIterator = new BlockingObservableLatestIterator();
        d.wrap(this.source).materialize().subscribe(blockingObservableLatestIterator);
        return blockingObservableLatestIterator;
    }
}
