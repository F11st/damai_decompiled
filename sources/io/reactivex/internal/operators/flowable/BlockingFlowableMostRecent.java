package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.b;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subscribers.a;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class BlockingFlowableMostRecent<T> implements Iterable<T> {
    final T initialValue;
    final b<T> source;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class MostRecentSubscriber<T> extends a<T> {
        volatile Object value;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        public final class Iterator implements java.util.Iterator<T> {
            private Object buf;

            Iterator() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                Object obj = MostRecentSubscriber.this.value;
                this.buf = obj;
                return !NotificationLite.isComplete(obj);
            }

            @Override // java.util.Iterator
            public T next() {
                try {
                    if (this.buf == null) {
                        this.buf = MostRecentSubscriber.this.value;
                    }
                    if (!NotificationLite.isComplete(this.buf)) {
                        if (!NotificationLite.isError(this.buf)) {
                            return (T) NotificationLite.getValue(this.buf);
                        }
                        throw ExceptionHelper.wrapOrThrow(NotificationLite.getError(this.buf));
                    }
                    throw new NoSuchElementException();
                } finally {
                    this.buf = null;
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        MostRecentSubscriber(T t) {
            this.value = NotificationLite.next(t);
        }

        public MostRecentSubscriber<T>.Iterator getIterable() {
            return new Iterator();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.value = NotificationLite.complete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.value = NotificationLite.error(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.value = NotificationLite.next(t);
        }
    }

    public BlockingFlowableMostRecent(b<T> bVar, T t) {
        this.source = bVar;
        this.initialValue = t;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        MostRecentSubscriber mostRecentSubscriber = new MostRecentSubscriber(this.initialValue);
        this.source.subscribe((FlowableSubscriber) mostRecentSubscriber);
        return mostRecentSubscriber.getIterable();
    }
}
