package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.annotations.Nullable;
import io.reactivex.b;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Subscriber;
import tb.i42;
import tb.jm;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class MaybeMergeArray<T> extends b<T> {
    final MaybeSource<? extends T>[] sources;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class ClqSimpleQueue<T> extends ConcurrentLinkedQueue<T> implements SimpleQueueWithConsumerIndex<T> {
        private static final long serialVersionUID = -4025173261791142821L;
        int consumerIndex;
        final AtomicInteger producerIndex = new AtomicInteger();

        ClqSimpleQueue() {
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int consumerIndex() {
            return this.consumerIndex;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public void drop() {
            poll();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T t, T t2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex, io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            T t = (T) super.poll();
            if (t != null) {
                this.consumerIndex++;
            }
            return t;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int producerIndex() {
            return this.producerIndex.get();
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T t) {
            this.producerIndex.getAndIncrement();
            return super.offer(t);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class MergeMaybeObserver<T> extends BasicIntQueueSubscription<T> implements MaybeObserver<T> {
        private static final long serialVersionUID = -660395290758764731L;
        final Subscriber<? super T> actual;
        volatile boolean cancelled;
        long consumed;
        boolean outputFused;
        final SimpleQueueWithConsumerIndex<Object> queue;
        final int sourceCount;
        final jm set = new jm();
        final AtomicLong requested = new AtomicLong();
        final AtomicThrowable error = new AtomicThrowable();

        MergeMaybeObserver(Subscriber<? super T> subscriber, int i, SimpleQueueWithConsumerIndex<Object> simpleQueueWithConsumerIndex) {
            this.actual = subscriber;
            this.sourceCount = i;
            this.queue = simpleQueueWithConsumerIndex;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.set.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.queue.clear();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        void drainFused() {
            Subscriber<? super T> subscriber = this.actual;
            SimpleQueueWithConsumerIndex<Object> simpleQueueWithConsumerIndex = this.queue;
            int i = 1;
            while (!this.cancelled) {
                Throwable th = this.error.get();
                if (th != null) {
                    simpleQueueWithConsumerIndex.clear();
                    subscriber.onError(th);
                    return;
                }
                boolean z = simpleQueueWithConsumerIndex.producerIndex() == this.sourceCount;
                if (!simpleQueueWithConsumerIndex.isEmpty()) {
                    subscriber.onNext(null);
                }
                if (z) {
                    subscriber.onComplete();
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
            simpleQueueWithConsumerIndex.clear();
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
            if (r7 != 0) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0058, code lost:
            if (r10.error.get() == null) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x005a, code lost:
            r1.clear();
            r0.onError(r10.error.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x006d, code lost:
            if (r1.peek() != io.reactivex.internal.util.NotificationLite.COMPLETE) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x006f, code lost:
            r1.drop();
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0079, code lost:
            if (r1.consumerIndex() != r10.sourceCount) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x007b, code lost:
            r0.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x007e, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x007f, code lost:
            r10.consumed = r2;
            r4 = addAndGet(-r4);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drainNormal() {
            /*
                r10 = this;
                org.reactivestreams.Subscriber<? super T> r0 = r10.actual
                io.reactivex.internal.operators.maybe.MaybeMergeArray$SimpleQueueWithConsumerIndex<java.lang.Object> r1 = r10.queue
                long r2 = r10.consumed
                r4 = 1
            L7:
                java.util.concurrent.atomic.AtomicLong r5 = r10.requested
                long r5 = r5.get()
            Ld:
                int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r7 == 0) goto L4e
                boolean r8 = r10.cancelled
                if (r8 == 0) goto L19
                r1.clear()
                return
            L19:
                io.reactivex.internal.util.AtomicThrowable r8 = r10.error
                java.lang.Object r8 = r8.get()
                java.lang.Throwable r8 = (java.lang.Throwable) r8
                if (r8 == 0) goto L30
                r1.clear()
                io.reactivex.internal.util.AtomicThrowable r1 = r10.error
                java.lang.Throwable r1 = r1.terminate()
                r0.onError(r1)
                return
            L30:
                int r8 = r1.consumerIndex()
                int r9 = r10.sourceCount
                if (r8 != r9) goto L3c
                r0.onComplete()
                return
            L3c:
                java.lang.Object r8 = r1.poll()
                if (r8 != 0) goto L43
                goto L4e
            L43:
                io.reactivex.internal.util.NotificationLite r7 = io.reactivex.internal.util.NotificationLite.COMPLETE
                if (r8 == r7) goto Ld
                r0.onNext(r8)
                r7 = 1
                long r2 = r2 + r7
                goto Ld
            L4e:
                if (r7 != 0) goto L7f
                io.reactivex.internal.util.AtomicThrowable r5 = r10.error
                java.lang.Object r5 = r5.get()
                java.lang.Throwable r5 = (java.lang.Throwable) r5
                if (r5 == 0) goto L67
                r1.clear()
                io.reactivex.internal.util.AtomicThrowable r1 = r10.error
                java.lang.Throwable r1 = r1.terminate()
                r0.onError(r1)
                return
            L67:
                java.lang.Object r5 = r1.peek()
                io.reactivex.internal.util.NotificationLite r6 = io.reactivex.internal.util.NotificationLite.COMPLETE
                if (r5 != r6) goto L73
                r1.drop()
                goto L67
            L73:
                int r5 = r1.consumerIndex()
                int r6 = r10.sourceCount
                if (r5 != r6) goto L7f
                r0.onComplete()
                return
            L7f:
                r10.consumed = r2
                int r4 = -r4
                int r4 = r10.addAndGet(r4)
                if (r4 != 0) goto L7
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.maybe.MaybeMergeArray.MergeMaybeObserver.drainNormal():void");
        }

        boolean isCancelled() {
            return this.cancelled;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.queue.offer(NotificationLite.COMPLETE);
            drain();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            if (this.error.addThrowable(th)) {
                this.set.dispose();
                this.queue.offer(NotificationLite.COMPLETE);
                drain();
                return;
            }
            i42.u(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            this.set.add(disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            this.queue.offer(t);
            drain();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() throws Exception {
            T t;
            do {
                t = (T) this.queue.poll();
            } while (t == NotificationLite.COMPLETE);
            return t;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 2) != 0) {
                this.outputFused = true;
                return 2;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface SimpleQueueWithConsumerIndex<T> extends SimpleQueue<T> {
        int consumerIndex();

        void drop();

        T peek();

        @Override // java.util.Queue, io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex, io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        T poll();

        int producerIndex();
    }

    public MaybeMergeArray(MaybeSource<? extends T>[] maybeSourceArr) {
        this.sources = maybeSourceArr;
    }

    @Override // io.reactivex.b
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        SimpleQueueWithConsumerIndex clqSimpleQueue;
        MaybeSource[] maybeSourceArr = this.sources;
        int length = maybeSourceArr.length;
        if (length <= b.bufferSize()) {
            clqSimpleQueue = new MpscFillOnceSimpleQueue(length);
        } else {
            clqSimpleQueue = new ClqSimpleQueue();
        }
        MergeMaybeObserver mergeMaybeObserver = new MergeMaybeObserver(subscriber, length, clqSimpleQueue);
        subscriber.onSubscribe(mergeMaybeObserver);
        AtomicThrowable atomicThrowable = mergeMaybeObserver.error;
        for (MaybeSource maybeSource : maybeSourceArr) {
            if (mergeMaybeObserver.isCancelled() || atomicThrowable.get() != null) {
                return;
            }
            maybeSource.subscribe(mergeMaybeObserver);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class MpscFillOnceSimpleQueue<T> extends AtomicReferenceArray<T> implements SimpleQueueWithConsumerIndex<T> {
        private static final long serialVersionUID = -7969063454040569579L;
        int consumerIndex;
        final AtomicInteger producerIndex;

        MpscFillOnceSimpleQueue(int i) {
            super(i);
            this.producerIndex = new AtomicInteger();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            while (poll() != null && !isEmpty()) {
            }
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int consumerIndex() {
            return this.consumerIndex;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public void drop() {
            int i = this.consumerIndex;
            lazySet(i, null);
            this.consumerIndex = i + 1;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.consumerIndex == producerIndex();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T t) {
            ObjectHelper.requireNonNull(t, "value is null");
            int andIncrement = this.producerIndex.getAndIncrement();
            if (andIncrement < length()) {
                lazySet(andIncrement, t);
                return true;
            }
            return false;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public T peek() {
            int i = this.consumerIndex;
            if (i == length()) {
                return null;
            }
            return get(i);
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex, java.util.Queue, io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            int i = this.consumerIndex;
            if (i == length()) {
                return null;
            }
            AtomicInteger atomicInteger = this.producerIndex;
            do {
                T t = get(i);
                if (t != null) {
                    this.consumerIndex = i + 1;
                    lazySet(i, null);
                    return t;
                }
            } while (atomicInteger.get() != i);
            return null;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int producerIndex() {
            return this.producerIndex.get();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T t, T t2) {
            throw new UnsupportedOperationException();
        }
    }
}
