package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import androidx.annotation.RestrictTo;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes.dex */
abstract class ModernAsyncTask<Params, Progress, Result> {
    private static final int CORE_POOL_SIZE = 5;
    private static final int KEEP_ALIVE = 1;
    private static final String LOG_TAG = "AsyncTask";
    private static final int MAXIMUM_POOL_SIZE = 128;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    public static final Executor THREAD_POOL_EXECUTOR;
    private static volatile Executor sDefaultExecutor;
    private static InternalHandler sHandler;
    private static final BlockingQueue<Runnable> sPoolWorkQueue;
    private static final ThreadFactory sThreadFactory;
    private final FutureTask<Result> mFuture;
    private final WorkerRunnable<Params, Result> mWorker;
    private volatile Status mStatus = Status.PENDING;
    final AtomicBoolean mCancelled = new AtomicBoolean();
    final AtomicBoolean mTaskInvoked = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: androidx.loader.content.ModernAsyncTask$4  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$androidx$loader$content$ModernAsyncTask$Status;

        static {
            int[] iArr = new int[Status.values().length];
            $SwitchMap$androidx$loader$content$ModernAsyncTask$Status = iArr;
            try {
                iArr[Status.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$loader$content$ModernAsyncTask$Status[Status.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class AsyncTaskResult<Data> {
        final Data[] mData;
        final ModernAsyncTask mTask;

        AsyncTaskResult(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.mTask = modernAsyncTask;
            this.mData = dataArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class InternalHandler extends Handler {
        InternalHandler() {
            super(Looper.getMainLooper());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AsyncTaskResult asyncTaskResult = (AsyncTaskResult) message.obj;
            int i = message.what;
            if (i == 1) {
                asyncTaskResult.mTask.finish(asyncTaskResult.mData[0]);
            } else if (i != 2) {
            } else {
                asyncTaskResult.mTask.onProgressUpdate(asyncTaskResult.mData);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        Params[] mParams;

        WorkerRunnable() {
        }
    }

    static {
        ThreadFactory threadFactory = new ThreadFactory() { // from class: androidx.loader.content.ModernAsyncTask.1
            private final AtomicInteger mCount = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "ModernAsyncTask #" + this.mCount.getAndIncrement());
            }
        };
        sThreadFactory = threadFactory;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        sPoolWorkQueue = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, linkedBlockingQueue, threadFactory);
        THREAD_POOL_EXECUTOR = threadPoolExecutor;
        sDefaultExecutor = threadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ModernAsyncTask() {
        WorkerRunnable<Params, Result> workerRunnable = new WorkerRunnable<Params, Result>() { // from class: androidx.loader.content.ModernAsyncTask.2
            @Override // java.util.concurrent.Callable
            public Result call() throws Exception {
                ModernAsyncTask.this.mTaskInvoked.set(true);
                Result result = null;
                try {
                    Process.setThreadPriority(10);
                    result = (Result) ModernAsyncTask.this.doInBackground(this.mParams);
                    Binder.flushPendingCommands();
                    return result;
                } finally {
                }
            }
        };
        this.mWorker = workerRunnable;
        this.mFuture = new FutureTask<Result>(workerRunnable) { // from class: androidx.loader.content.ModernAsyncTask.3
            @Override // java.util.concurrent.FutureTask
            protected void done() {
                try {
                    ModernAsyncTask.this.postResultIfNotInvoked(get());
                } catch (InterruptedException e) {
                    Log.w(ModernAsyncTask.LOG_TAG, e);
                } catch (CancellationException unused) {
                    ModernAsyncTask.this.postResultIfNotInvoked(null);
                } catch (ExecutionException e2) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
                } catch (Throwable th) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", th);
                }
            }
        };
    }

    private static Handler getHandler() {
        InternalHandler internalHandler;
        synchronized (ModernAsyncTask.class) {
            if (sHandler == null) {
                sHandler = new InternalHandler();
            }
            internalHandler = sHandler;
        }
        return internalHandler;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void setDefaultExecutor(Executor executor) {
        sDefaultExecutor = executor;
    }

    public final boolean cancel(boolean z) {
        this.mCancelled.set(true);
        return this.mFuture.cancel(z);
    }

    protected abstract Result doInBackground(Params... paramsArr);

    public final ModernAsyncTask<Params, Progress, Result> execute(Params... paramsArr) {
        return executeOnExecutor(sDefaultExecutor, paramsArr);
    }

    public final ModernAsyncTask<Params, Progress, Result> executeOnExecutor(Executor executor, Params... paramsArr) {
        if (this.mStatus != Status.PENDING) {
            int i = AnonymousClass4.$SwitchMap$androidx$loader$content$ModernAsyncTask$Status[this.mStatus.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("We should never reach this state");
                }
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        this.mStatus = Status.RUNNING;
        onPreExecute();
        this.mWorker.mParams = paramsArr;
        executor.execute(this.mFuture);
        return this;
    }

    void finish(Result result) {
        if (isCancelled()) {
            onCancelled(result);
        } else {
            onPostExecute(result);
        }
        this.mStatus = Status.FINISHED;
    }

    public final Result get() throws InterruptedException, ExecutionException {
        return this.mFuture.get();
    }

    public final Status getStatus() {
        return this.mStatus;
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    protected void onCancelled() {
    }

    protected void onCancelled(Result result) {
        onCancelled();
    }

    protected void onPostExecute(Result result) {
    }

    protected void onPreExecute() {
    }

    protected void onProgressUpdate(Progress... progressArr) {
    }

    Result postResult(Result result) {
        getHandler().obtainMessage(1, new AsyncTaskResult(this, result)).sendToTarget();
        return result;
    }

    void postResultIfNotInvoked(Result result) {
        if (this.mTaskInvoked.get()) {
            return;
        }
        postResult(result);
    }

    protected final void publishProgress(Progress... progressArr) {
        if (isCancelled()) {
            return;
        }
        getHandler().obtainMessage(2, new AsyncTaskResult(this, progressArr)).sendToTarget();
    }

    public static void execute(Runnable runnable) {
        sDefaultExecutor.execute(runnable);
    }

    public final Result get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mFuture.get(j, timeUnit);
    }
}
