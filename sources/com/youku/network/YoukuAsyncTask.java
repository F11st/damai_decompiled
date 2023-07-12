package com.youku.network;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public abstract class YoukuAsyncTask<Params, Progress, Result> {
    private static final LinkedBlockingQueue<Runnable> a;
    private static final ThreadFactory b;
    private static final ThreadPoolExecutor c;
    private static final HandlerC7972a d;
    private volatile Status e;

    /* compiled from: Taobao */
    /* renamed from: com.youku.network.YoukuAsyncTask$3  reason: invalid class name */
    /* loaded from: classes13.dex */
    class AnonymousClass3 extends FutureTask<Object> {
        AnonymousClass3(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            Message obtainMessage;
            Object obj = null;
            try {
                obj = get();
            } catch (InterruptedException e) {
                Log.w("HttpCommunication.YoukuAsyncTask", e);
            } catch (CancellationException unused) {
                obtainMessage = YoukuAsyncTask.d.obtainMessage(3, new C7973b(YoukuAsyncTask.this, null));
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
            } catch (Throwable th) {
                throw new RuntimeException("An error occured while executing doInBackground()", th);
            }
            obtainMessage = YoukuAsyncTask.d.obtainMessage(1, new C7973b(YoukuAsyncTask.this, obj));
            obtainMessage.sendToTarget();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* compiled from: Taobao */
    /* renamed from: com.youku.network.YoukuAsyncTask$a */
    /* loaded from: classes13.dex */
    private static class HandlerC7972a extends Handler {
        private HandlerC7972a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C7973b c7973b = (C7973b) message.obj;
            int i = message.what;
            if (i == 1) {
                c7973b.a.b(c7973b.b[0]);
            } else if (i == 2) {
                c7973b.a.a((Object[]) c7973b.b);
            } else if (i != 3) {
            } else {
                c7973b.a.a();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.youku.network.YoukuAsyncTask$b */
    /* loaded from: classes13.dex */
    private static class C7973b<Data> {
        final YoukuAsyncTask a;
        final Data[] b;

        C7973b(YoukuAsyncTask youkuAsyncTask, Data... dataArr) {
            this.a = youkuAsyncTask;
            this.b = dataArr;
        }
    }

    static {
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>(5);
        a = linkedBlockingQueue;
        ThreadFactory threadFactory = new ThreadFactory() { // from class: com.youku.network.YoukuAsyncTask.1
            private final AtomicInteger a = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "YoukuAsyncTask #" + this.a.getAndIncrement());
            }
        };
        b = threadFactory;
        c = new ThreadPoolExecutor(5, 10, 10L, TimeUnit.SECONDS, linkedBlockingQueue, threadFactory, new ThreadPoolExecutor.DiscardOldestPolicy());
        d = new HandlerC7972a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Result result) {
        a((YoukuAsyncTask<Params, Progress, Result>) result);
        this.e = Status.FINISHED;
    }

    protected void a() {
    }

    protected void a(Result result) {
    }

    protected void a(Progress... progressArr) {
    }
}
