package tb;

import androidx.annotation.NonNull;
import com.alibaba.android.onescheduler.TaskType;
import com.alibaba.android.onescheduler.threadpool.C3243a;
import com.alibaba.android.onescheduler.threadpool.IExecutorServiceFactory;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class pg0 implements IExecutorServiceFactory {

    /* compiled from: Taobao */
    /* renamed from: tb.pg0$a */
    /* loaded from: classes5.dex */
    class RejectedExecutionHandlerC9555a implements RejectedExecutionHandler {
        @NonNull
        private ExecutorService a;
        final /* synthetic */ ThreadFactory b;
        final /* synthetic */ ng0 c;

        RejectedExecutionHandlerC9555a(pg0 pg0Var, ThreadFactory threadFactory, ng0 ng0Var) {
            this.b = threadFactory;
            this.c = ng0Var;
            this.a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 1L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(@NonNull Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            tf0.a().g(TaskType.IO, this.c.c());
            this.a.submit(runnable);
        }
    }

    @Override // com.alibaba.android.onescheduler.threadpool.IExecutorServiceFactory
    @NonNull
    public ListeningExecutorService createCpuExecutorService(@NonNull ng0 ng0Var) {
        return new C3243a(ng0Var, TaskType.CPU);
    }

    @Override // com.alibaba.android.onescheduler.threadpool.IExecutorServiceFactory
    @NonNull
    public ListeningExecutorService createIOExecutorService(@NonNull ng0 ng0Var) {
        ThreadFactory e = ng0Var.e() != null ? ng0Var.e() : Executors.defaultThreadFactory();
        int d = ng0Var.d();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(ng0Var.a(), ng0Var.c(), ng0Var.b(), TimeUnit.MILLISECONDS, d > 0 ? new LinkedBlockingQueue(d) : new SynchronousQueue(), e, new RejectedExecutionHandlerC9555a(this, e, ng0Var));
        threadPoolExecutor.allowCoreThreadTimeOut(ng0Var.f());
        return MoreExecutors.c(threadPoolExecutor);
    }

    @Override // com.alibaba.android.onescheduler.threadpool.IExecutorServiceFactory
    @NonNull
    public ListeningExecutorService createNormalExecutorService(@NonNull ng0 ng0Var) {
        return new C3243a(ng0Var, TaskType.NORMAL);
    }

    @Override // com.alibaba.android.onescheduler.threadpool.IExecutorServiceFactory
    @NonNull
    public ListeningExecutorService createRpcExecutorService(ng0 ng0Var) {
        return new C3243a(ng0Var, TaskType.RPC);
    }
}
