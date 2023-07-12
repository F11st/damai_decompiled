package tb;

import android.os.Handler;
import android.os.Looper;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ec0 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final ec0 INSTANCE = new ec0();
    private static final int a;
    private static final int b;
    private static final int c;
    private static final ThreadFactory d;
    private static final BlockingQueue<Runnable> e;
    private static ThreadPoolExecutor f;

    /* compiled from: Taobao */
    /* renamed from: tb.ec0$a */
    /* loaded from: classes7.dex */
    public static final class ThreadFactoryC9095a implements ThreadFactory {
        private static transient /* synthetic */ IpChange $ipChange;
        private final AtomicInteger a = new AtomicInteger(1);

        ThreadFactoryC9095a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        @NotNull
        public Thread newThread(@NotNull Runnable runnable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "885998256")) {
                return (Thread) ipChange.ipc$dispatch("885998256", new Object[]{this, runnable});
            }
            b41.i(runnable, UploadQueueMgr.MSGTYPE_REALTIME);
            return new Thread(runnable, "DoloresTask #" + this.a.getAndIncrement());
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        a = availableProcessors;
        int max = Math.max(2, Math.min(availableProcessors - 1, 4));
        b = max;
        int i = (availableProcessors * 2) + 1;
        c = i;
        ThreadFactoryC9095a threadFactoryC9095a = new ThreadFactoryC9095a();
        d = threadFactoryC9095a;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(512);
        e = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(max, i, 30L, TimeUnit.SECONDS, linkedBlockingQueue, threadFactoryC9095a);
        f = threadPoolExecutor;
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    }

    private ec0() {
    }

    public final void a(@NotNull Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2138304919")) {
            ipChange.ipc$dispatch("2138304919", new Object[]{this, runnable});
            return;
        }
        b41.i(runnable, "runnable");
        if (b41.d(Looper.myLooper(), Looper.getMainLooper())) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    public final void b(@Nullable Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1570554902")) {
            ipChange.ipc$dispatch("-1570554902", new Object[]{this, runnable});
        } else if (runnable == null || (threadPoolExecutor = f) == null) {
        } else {
            threadPoolExecutor.execute(runnable);
        }
    }
}
