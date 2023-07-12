package tb;

import android.util.Log;
import cn.damai.common.util.PriorityTask;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class nu1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static ThreadPoolExecutor a;

    /* compiled from: Taobao */
    /* renamed from: tb.nu1$a */
    /* loaded from: classes4.dex */
    public static class C9486a extends ThreadPoolExecutor {
        private static transient /* synthetic */ IpChange $ipChange;

        public C9486a(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
            super(i, i2, j, timeUnit, blockingQueue);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        protected void afterExecute(Runnable runnable, Throwable th) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-226194561")) {
                ipChange.ipc$dispatch("-226194561", new Object[]{this, runnable, th});
                return;
            }
            super.afterExecute(runnable, th);
            if (runnable instanceof PriorityTask) {
                Log.d("PriorityExecutor", "afterExecute:" + runnable.toString());
            }
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        protected void beforeExecute(Thread thread, Runnable runnable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-859867566")) {
                ipChange.ipc$dispatch("-859867566", new Object[]{this, thread, runnable});
                return;
            }
            super.beforeExecute(thread, runnable);
            if (runnable instanceof PriorityTask) {
                Log.d("PriorityExecutor", "beforeExecute:" + runnable.toString());
            }
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        Log.e("LauncherApplication_xxx", " threadPoolnum: " + availableProcessors);
        a = new C9486a(availableProcessors + 1, (availableProcessors * 2) + 1, 0L, TimeUnit.SECONDS, new PriorityBlockingQueue());
    }

    public static void a(PriorityTask priorityTask) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2119702697")) {
            ipChange.ipc$dispatch("-2119702697", new Object[]{priorityTask});
        } else {
            a.execute(priorityTask);
        }
    }
}
