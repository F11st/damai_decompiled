package tb;

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
/* loaded from: classes8.dex */
public final class gl2 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final gl2 INSTANCE = new gl2();
    private static final int a;
    private static final int b;
    private static final int c;
    private static final ThreadFactory d;
    private static final BlockingQueue<Runnable> e;
    private static ThreadPoolExecutor f;

    /* compiled from: Taobao */
    /* renamed from: tb.gl2$a */
    /* loaded from: classes8.dex */
    public static final class ThreadFactoryC9179a implements ThreadFactory {
        private static transient /* synthetic */ IpChange $ipChange;
        private final AtomicInteger a = new AtomicInteger(1);

        ThreadFactoryC9179a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        @NotNull
        public Thread newThread(@NotNull Runnable runnable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1309570843")) {
                return (Thread) ipChange.ipc$dispatch("1309570843", new Object[]{this, runnable});
            }
            b41.i(runnable, UploadQueueMgr.MSGTYPE_REALTIME);
            return new Thread(runnable, "ShareTask #" + this.a.getAndIncrement());
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        a = availableProcessors;
        b = Math.max(2, Math.min(availableProcessors - 1, 4));
        c = (availableProcessors * 2) + 1;
        d = new ThreadFactoryC9179a();
        e = new LinkedBlockingQueue(512);
    }

    private gl2() {
    }

    @Nullable
    public final ThreadPoolExecutor a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1723241834")) {
            return (ThreadPoolExecutor) ipChange.ipc$dispatch("1723241834", new Object[]{this});
        }
        if (f == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(b, c, 30L, TimeUnit.SECONDS, e, d);
            f = threadPoolExecutor;
            threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        }
        return f;
    }

    public final void b(@Nullable Runnable runnable) {
        ThreadPoolExecutor a2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1359015729")) {
            ipChange.ipc$dispatch("1359015729", new Object[]{this, runnable});
        } else if (runnable == null || (a2 = a()) == null) {
        } else {
            a2.execute(runnable);
        }
    }
}
