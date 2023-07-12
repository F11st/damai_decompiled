package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.i42;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ParallelRunOn<T> extends a<T> {
    final int prefetch;
    final Scheduler scheduler;
    final a<? extends T> source;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static abstract class BaseRunOnSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 9222303586456402150L;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        Throwable error;
        final int limit;
        final int prefetch;
        final SpscArrayQueue<T> queue;
        final AtomicLong requested = new AtomicLong();
        Subscription s;
        final Scheduler.Worker worker;

        BaseRunOnSubscriber(int i, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            this.prefetch = i;
            this.queue = spscArrayQueue;
            this.limit = i - (i >> 2);
            this.worker = worker;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.cancel();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            schedule();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.done) {
                i42.u(th);
                return;
            }
            this.error = th;
            this.done = true;
            schedule();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            if (!this.queue.offer(t)) {
                this.s.cancel();
                onError(new MissingBackpressureException("Queue is full?!"));
                return;
            }
            schedule();
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                schedule();
            }
        }

        final void schedule() {
            if (getAndIncrement() == 0) {
                this.worker.schedule(this);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    final class MultiWorkerCallback implements SchedulerMultiWorkerSupport.WorkerCallback {
        final Subscriber<T>[] parents;
        final Subscriber<? super T>[] subscribers;

        MultiWorkerCallback(Subscriber<? super T>[] subscriberArr, Subscriber<T>[] subscriberArr2) {
            this.subscribers = subscriberArr;
            this.parents = subscriberArr2;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport.WorkerCallback
        public void onWorker(int i, Scheduler.Worker worker) {
            ParallelRunOn.this.createSubscriber(i, this.subscribers, this.parents, worker);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class RunOnConditionalSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        final ConditionalSubscriber<? super T> actual;

        RunOnConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, int i, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            super(i, spscArrayQueue, worker);
            this.actual = conditionalSubscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(this.prefetch);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
            if (r13 != 0) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x006b, code lost:
            if (r18.cancelled == false) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x006d, code lost:
            r2.clear();
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0070, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0073, code lost:
            if (r18.done == false) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0075, code lost:
            r13 = r18.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0077, code lost:
            if (r13 == null) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0079, code lost:
            r2.clear();
            r3.onError(r13);
            r18.worker.dispose();
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0084, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0089, code lost:
            if (r2.isEmpty() == false) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x008b, code lost:
            r3.onComplete();
            r18.worker.dispose();
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0093, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0096, code lost:
            if (r11 == 0) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x009f, code lost:
            if (r7 == com.youku.live.livesdk.monitor.performance.AbsPerformance.LONG_NIL) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00a1, code lost:
            r18.requested.addAndGet(-r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00a7, code lost:
            r7 = get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00ab, code lost:
            if (r7 != r6) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00ad, code lost:
            r18.consumed = r1;
            r6 = addAndGet(-r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00b4, code lost:
            if (r6 != 0) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00b6, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00b7, code lost:
            r6 = r7;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r18 = this;
                r0 = r18
                int r1 = r0.consumed
                io.reactivex.internal.queue.SpscArrayQueue<T> r2 = r0.queue
                io.reactivex.internal.fuseable.ConditionalSubscriber<? super T> r3 = r0.actual
                int r4 = r0.limit
                r5 = 1
                r6 = 1
            Lc:
                java.util.concurrent.atomic.AtomicLong r7 = r0.requested
                long r7 = r7.get()
                r9 = 0
                r11 = r9
            L15:
                int r13 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
                if (r13 == 0) goto L67
                boolean r14 = r0.cancelled
                if (r14 == 0) goto L21
                r2.clear()
                return
            L21:
                boolean r14 = r0.done
                if (r14 == 0) goto L35
                java.lang.Throwable r15 = r0.error
                if (r15 == 0) goto L35
                r2.clear()
                r3.onError(r15)
                io.reactivex.Scheduler$Worker r1 = r0.worker
                r1.dispose()
                return
            L35:
                java.lang.Object r15 = r2.poll()
                r16 = 0
                if (r15 != 0) goto L40
                r17 = 1
                goto L42
            L40:
                r17 = 0
            L42:
                if (r14 == 0) goto L4f
                if (r17 == 0) goto L4f
                r3.onComplete()
                io.reactivex.Scheduler$Worker r1 = r0.worker
                r1.dispose()
                return
            L4f:
                if (r17 == 0) goto L52
                goto L67
            L52:
                boolean r13 = r3.tryOnNext(r15)
                if (r13 == 0) goto L5b
                r13 = 1
                long r11 = r11 + r13
            L5b:
                int r1 = r1 + 1
                if (r1 != r4) goto L15
                org.reactivestreams.Subscription r13 = r0.s
                long r14 = (long) r1
                r13.request(r14)
                r1 = 0
                goto L15
            L67:
                if (r13 != 0) goto L94
                boolean r13 = r0.cancelled
                if (r13 == 0) goto L71
                r2.clear()
                return
            L71:
                boolean r13 = r0.done
                if (r13 == 0) goto L94
                java.lang.Throwable r13 = r0.error
                if (r13 == 0) goto L85
                r2.clear()
                r3.onError(r13)
                io.reactivex.Scheduler$Worker r1 = r0.worker
                r1.dispose()
                return
            L85:
                boolean r13 = r2.isEmpty()
                if (r13 == 0) goto L94
                r3.onComplete()
                io.reactivex.Scheduler$Worker r1 = r0.worker
                r1.dispose()
                return
            L94:
                int r13 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
                if (r13 == 0) goto La7
                r9 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r13 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                if (r13 == 0) goto La7
                java.util.concurrent.atomic.AtomicLong r7 = r0.requested
                long r8 = -r11
                r7.addAndGet(r8)
            La7:
                int r7 = r18.get()
                if (r7 != r6) goto Lb7
                r0.consumed = r1
                int r6 = -r6
                int r6 = r0.addAndGet(r6)
                if (r6 != 0) goto Lc
                return
            Lb7:
                r6 = r7
                goto Lc
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelRunOn.RunOnConditionalSubscriber.run():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class RunOnSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        final Subscriber<? super T> actual;

        RunOnSubscriber(Subscriber<? super T> subscriber, int i, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            super(i, spscArrayQueue, worker);
            this.actual = subscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(this.prefetch);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x0064, code lost:
            if (r13 != 0) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0068, code lost:
            if (r18.cancelled == false) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x006a, code lost:
            r2.clear();
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x006d, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0070, code lost:
            if (r18.done == false) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0072, code lost:
            r13 = r18.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0074, code lost:
            if (r13 == null) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0076, code lost:
            r2.clear();
            r3.onError(r13);
            r18.worker.dispose();
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0081, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0086, code lost:
            if (r2.isEmpty() == false) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0088, code lost:
            r3.onComplete();
            r18.worker.dispose();
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0090, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0093, code lost:
            if (r11 == 0) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x009c, code lost:
            if (r7 == com.youku.live.livesdk.monitor.performance.AbsPerformance.LONG_NIL) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x009e, code lost:
            r18.requested.addAndGet(-r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00a4, code lost:
            r7 = get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00a8, code lost:
            if (r7 != r6) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00aa, code lost:
            r18.consumed = r1;
            r6 = addAndGet(-r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00b1, code lost:
            if (r6 != 0) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00b3, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00b4, code lost:
            r6 = r7;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r18 = this;
                r0 = r18
                int r1 = r0.consumed
                io.reactivex.internal.queue.SpscArrayQueue<T> r2 = r0.queue
                org.reactivestreams.Subscriber<? super T> r3 = r0.actual
                int r4 = r0.limit
                r5 = 1
                r6 = 1
            Lc:
                java.util.concurrent.atomic.AtomicLong r7 = r0.requested
                long r7 = r7.get()
                r9 = 0
                r11 = r9
            L15:
                int r13 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
                if (r13 == 0) goto L64
                boolean r14 = r0.cancelled
                if (r14 == 0) goto L21
                r2.clear()
                return
            L21:
                boolean r14 = r0.done
                if (r14 == 0) goto L35
                java.lang.Throwable r15 = r0.error
                if (r15 == 0) goto L35
                r2.clear()
                r3.onError(r15)
                io.reactivex.Scheduler$Worker r1 = r0.worker
                r1.dispose()
                return
            L35:
                java.lang.Object r15 = r2.poll()
                r16 = 0
                if (r15 != 0) goto L40
                r17 = 1
                goto L42
            L40:
                r17 = 0
            L42:
                if (r14 == 0) goto L4f
                if (r17 == 0) goto L4f
                r3.onComplete()
                io.reactivex.Scheduler$Worker r1 = r0.worker
                r1.dispose()
                return
            L4f:
                if (r17 == 0) goto L52
                goto L64
            L52:
                r3.onNext(r15)
                r13 = 1
                long r11 = r11 + r13
                int r1 = r1 + 1
                if (r1 != r4) goto L15
                org.reactivestreams.Subscription r13 = r0.s
                long r14 = (long) r1
                r13.request(r14)
                r1 = 0
                goto L15
            L64:
                if (r13 != 0) goto L91
                boolean r13 = r0.cancelled
                if (r13 == 0) goto L6e
                r2.clear()
                return
            L6e:
                boolean r13 = r0.done
                if (r13 == 0) goto L91
                java.lang.Throwable r13 = r0.error
                if (r13 == 0) goto L82
                r2.clear()
                r3.onError(r13)
                io.reactivex.Scheduler$Worker r1 = r0.worker
                r1.dispose()
                return
            L82:
                boolean r13 = r2.isEmpty()
                if (r13 == 0) goto L91
                r3.onComplete()
                io.reactivex.Scheduler$Worker r1 = r0.worker
                r1.dispose()
                return
            L91:
                int r13 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
                if (r13 == 0) goto La4
                r9 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r13 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                if (r13 == 0) goto La4
                java.util.concurrent.atomic.AtomicLong r7 = r0.requested
                long r8 = -r11
                r7.addAndGet(r8)
            La4:
                int r7 = r18.get()
                if (r7 != r6) goto Lb4
                r0.consumed = r1
                int r6 = -r6
                int r6 = r0.addAndGet(r6)
                if (r6 != 0) goto Lc
                return
            Lb4:
                r6 = r7
                goto Lc
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelRunOn.RunOnSubscriber.run():void");
        }
    }

    public ParallelRunOn(a<? extends T> aVar, Scheduler scheduler, int i) {
        this.source = aVar;
        this.scheduler = scheduler;
        this.prefetch = i;
    }

    void createSubscriber(int i, Subscriber<? super T>[] subscriberArr, Subscriber<T>[] subscriberArr2, Scheduler.Worker worker) {
        Subscriber<? super T> subscriber = subscriberArr[i];
        SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.prefetch);
        if (subscriber instanceof ConditionalSubscriber) {
            subscriberArr2[i] = new RunOnConditionalSubscriber((ConditionalSubscriber) subscriber, this.prefetch, spscArrayQueue, worker);
        } else {
            subscriberArr2[i] = new RunOnSubscriber(subscriber, this.prefetch, spscArrayQueue, worker);
        }
    }

    @Override // io.reactivex.parallel.a
    public int parallelism() {
        return this.source.parallelism();
    }

    @Override // io.reactivex.parallel.a
    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber<T>[] subscriberArr2 = new Subscriber[length];
            Scheduler scheduler = this.scheduler;
            if (scheduler instanceof SchedulerMultiWorkerSupport) {
                ((SchedulerMultiWorkerSupport) scheduler).createWorkers(length, new MultiWorkerCallback(subscriberArr, subscriberArr2));
            } else {
                for (int i = 0; i < length; i++) {
                    createSubscriber(i, subscriberArr, subscriberArr2, this.scheduler.createWorker());
                }
            }
            this.source.subscribe(subscriberArr2);
        }
    }
}
