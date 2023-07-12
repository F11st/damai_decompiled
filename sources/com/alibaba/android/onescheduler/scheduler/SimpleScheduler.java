package com.alibaba.android.onescheduler.scheduler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.alibaba.android.onescheduler.IScheduler;
import com.alibaba.android.onescheduler.TaskType;
import com.alibaba.android.onescheduler.task.InnerDepentTask;
import com.alibaba.android.onescheduler.task.InnerOneTask;
import com.alibaba.android.onescheduler.threadpool.ListenableFutureTask;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;
import tb.qg0;
import tb.tf0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class SimpleScheduler implements IScheduler {
    private ExecutorService a = Executors.newSingleThreadExecutor(new a(this));
    private Handler b;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    class a implements ThreadFactory {
        a(SimpleScheduler simpleScheduler) {
        }

        @Override // java.util.concurrent.ThreadFactory
        @NonNull
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("OST-Scheduler");
            thread.setPriority(10);
            return thread;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    class b extends Handler {
        final /* synthetic */ FutureTask a;
        final /* synthetic */ Executor b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(SimpleScheduler simpleScheduler, Looper looper, FutureTask futureTask, Executor executor) {
            super(looper);
            this.a = futureTask;
            this.b = executor;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            tf0.a().e(this.a);
            this.b.execute(this.a);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[TaskType.values().length];
            a = iArr;
            try {
                iArr[TaskType.IO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[TaskType.CPU.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[TaskType.RPC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.alibaba.android.onescheduler.IScheduler
    public void schedule(@NonNull final InnerOneTask innerOneTask) {
        Executor executor = innerOneTask.getExecutor();
        if (executor == null) {
            int i = c.a[innerOneTask.getTaskType().ordinal()];
            if (i == 1) {
                executor = qg0.c().b();
            } else if (i == 2) {
                executor = qg0.c().a();
            } else if (i != 3) {
                executor = qg0.c().d();
            } else {
                executor = qg0.c().e();
            }
        }
        FutureTask futureTask = innerOneTask.getFutureTask();
        if (innerOneTask instanceof InnerDepentTask) {
            ((ListenableFutureTask) futureTask).addListener(new Runnable() { // from class: com.alibaba.android.onescheduler.scheduler.SimpleScheduler.2
                @Override // java.lang.Runnable
                public void run() {
                    ((InnerDepentTask) innerOneTask).tryRunSuccessor();
                }
            }, this.a);
        }
        if (innerOneTask.getDelayTime() > 0 && System.currentTimeMillis() - innerOneTask.getAddedTime() < innerOneTask.getDelayTime()) {
            Message obtain = Message.obtain();
            obtain.what = innerOneTask.hashCode();
            obtain.obj = innerOneTask;
            if (this.b == null) {
                this.b = new b(this, Looper.getMainLooper(), futureTask, executor);
            }
            this.b.sendMessageDelayed(obtain, System.currentTimeMillis() - innerOneTask.getAddedTime());
            return;
        }
        tf0.a().e(futureTask);
        executor.execute(futureTask);
    }
}
