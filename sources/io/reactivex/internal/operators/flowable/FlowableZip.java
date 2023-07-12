package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.b;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.i42;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class FlowableZip<T, R> extends b<R> {
    final int bufferSize;
    final boolean delayError;
    final Publisher<? extends T>[] sources;
    final Iterable<? extends Publisher<? extends T>> sourcesIterable;
    final Function<? super Object[], ? extends R> zipper;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class ZipCoordinator<T, R> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = -2434867452883857743L;
        final Subscriber<? super R> actual;
        volatile boolean cancelled;
        final Object[] current;
        final boolean delayErrors;
        final AtomicThrowable errors;
        final AtomicLong requested;
        final ZipSubscriber<T, R>[] subscribers;
        final Function<? super Object[], ? extends R> zipper;

        ZipCoordinator(Subscriber<? super R> subscriber, Function<? super Object[], ? extends R> function, int i, int i2, boolean z) {
            this.actual = subscriber;
            this.zipper = function;
            this.delayErrors = z;
            ZipSubscriber<T, R>[] zipSubscriberArr = new ZipSubscriber[i];
            for (int i3 = 0; i3 < i; i3++) {
                zipSubscriberArr[i3] = new ZipSubscriber<>(this, i2);
            }
            this.current = new Object[i];
            this.subscribers = zipSubscriberArr;
            this.requested = new AtomicLong();
            this.errors = new AtomicThrowable();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
        }

        void cancelAll() {
            for (ZipSubscriber<T, R> zipSubscriber : this.subscribers) {
                zipSubscriber.cancel();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:127:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00cd, code lost:
            if (r16 != 0) goto L109;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00d1, code lost:
            if (r18.cancelled == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00d3, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00d6, code lost:
            if (r18.delayErrors != false) goto L72;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00de, code lost:
            if (r18.errors.get() == null) goto L72;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00e0, code lost:
            cancelAll();
            r2.onError(r18.errors.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00ec, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00ed, code lost:
            r6 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x00ee, code lost:
            if (r6 >= r4) goto L106;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00f0, code lost:
            r0 = r3[r6];
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x00f4, code lost:
            if (r5[r6] != null) goto L105;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00f6, code lost:
            r10 = r0.done;
            r0 = r0.queue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00fa, code lost:
            if (r0 == null) goto L97;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x00fc, code lost:
            r0 = r0.poll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x0101, code lost:
            r0 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x0102, code lost:
            if (r0 != null) goto L96;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x0104, code lost:
            r11 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x0106, code lost:
            r11 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x0107, code lost:
            if (r10 == false) goto L91;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x0109, code lost:
            if (r11 == false) goto L91;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x010b, code lost:
            cancelAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x0116, code lost:
            if (r18.errors.get() == null) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x0118, code lost:
            r2.onError(r18.errors.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x0122, code lost:
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x0125, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x0126, code lost:
            if (r11 != false) goto L95;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x0128, code lost:
            r5[r6] = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x012b, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x012c, code lost:
            tb.dg0.b(r0);
            r18.errors.addThrowable(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x0136, code lost:
            if (r18.delayErrors == false) goto L101;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x0138, code lost:
            cancelAll();
            r2.onError(r18.errors.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x0144, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x0145, code lost:
            r6 = r6 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x014c, code lost:
            if (r12 == 0) goto L118;
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x014e, code lost:
            r0 = r3.length;
            r15 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x0150, code lost:
            if (r15 >= r0) goto L114;
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x0152, code lost:
            r3[r15].request(r12);
            r15 = r15 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x0161, code lost:
            if (r8 == com.youku.live.livesdk.monitor.performance.AbsPerformance.LONG_NIL) goto L118;
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x0163, code lost:
            r18.requested.addAndGet(-r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x0169, code lost:
            r7 = addAndGet(-r7);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drain() {
            /*
                Method dump skipped, instructions count: 369
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableZip.ZipCoordinator.drain():void");
        }

        void error(ZipSubscriber<T, R> zipSubscriber, Throwable th) {
            if (this.errors.addThrowable(th)) {
                zipSubscriber.done = true;
                drain();
                return;
            }
            i42.u(th);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        void subscribe(Publisher<? extends T>[] publisherArr, int i) {
            ZipSubscriber<T, R>[] zipSubscriberArr = this.subscribers;
            for (int i2 = 0; i2 < i && !this.cancelled; i2++) {
                if (!this.delayErrors && this.errors.get() != null) {
                    return;
                }
                publisherArr[i2].subscribe(zipSubscriberArr[i2]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class ZipSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4627193790118206028L;
        volatile boolean done;
        final int limit;
        final ZipCoordinator<T, R> parent;
        final int prefetch;
        long produced;
        SimpleQueue<T> queue;
        int sourceMode;

        ZipSubscriber(ZipCoordinator<T, R> zipCoordinator, int i) {
            this.parent = zipCoordinator;
            this.prefetch = i;
            this.limit = i - (i >> 2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.parent.error(this, th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.sourceMode != 2) {
                this.queue.offer(t);
            }
            this.parent.drain();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        subscription.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                subscription.request(this.prefetch);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (this.sourceMode != 1) {
                long j2 = this.produced + j;
                if (j2 >= this.limit) {
                    this.produced = 0L;
                    get().request(j2);
                    return;
                }
                this.produced = j2;
            }
        }
    }

    public FlowableZip(Publisher<? extends T>[] publisherArr, Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i, boolean z) {
        this.sources = publisherArr;
        this.sourcesIterable = iterable;
        this.zipper = function;
        this.bufferSize = i;
        this.delayError = z;
    }

    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super R> subscriber) {
        int length;
        Publisher<? extends T>[] publisherArr = this.sources;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            length = 0;
            for (Publisher<? extends T> publisher : this.sourcesIterable) {
                if (length == publisherArr.length) {
                    Publisher<? extends T>[] publisherArr2 = new Publisher[(length >> 2) + length];
                    System.arraycopy(publisherArr, 0, publisherArr2, 0, length);
                    publisherArr = publisherArr2;
                }
                publisherArr[length] = publisher;
                length++;
            }
        } else {
            length = publisherArr.length;
        }
        int i = length;
        if (i == 0) {
            EmptySubscription.complete(subscriber);
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(subscriber, this.zipper, i, this.bufferSize, this.delayError);
        subscriber.onSubscribe(zipCoordinator);
        zipCoordinator.subscribe(publisherArr, i);
    }
}
