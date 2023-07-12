package tb;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class ml2 {
    @JvmField
    public static final int BLOCKING_DEFAULT_PARALLELISM;
    @JvmField
    public static final int CORE_POOL_SIZE;
    @NotNull
    public static final String DEFAULT_DISPATCHER_NAME = "Dispatchers.Default";
    @NotNull
    public static final String DEFAULT_SCHEDULER_NAME = "DefaultDispatcher";
    @JvmField
    public static final long IDLE_WORKER_KEEP_ALIVE_NS;
    @JvmField
    public static final int MAX_POOL_SIZE;
    public static final int TASK_NON_BLOCKING = 0;
    public static final int TASK_PROBABLY_BLOCKING = 1;
    @JvmField
    public static final long WORK_STEALING_TIME_RESOLUTION_NS;
    @JvmField
    @NotNull
    public static do2 a;

    static {
        long e;
        int d;
        int a2;
        int d2;
        int f;
        int d3;
        long e2;
        e = pj2.e("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        WORK_STEALING_TIME_RESOLUTION_NS = e;
        d = pj2.d("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, null);
        BLOCKING_DEFAULT_PARALLELISM = d;
        a2 = ty1.a(nj2.a(), 2);
        d2 = pj2.d("kotlinx.coroutines.scheduler.core.pool.size", a2, 1, 0, 8, null);
        CORE_POOL_SIZE = d2;
        f = ty1.f(nj2.a() * 128, d2, CoroutineScheduler.MAX_SUPPORTED_POOL_SIZE);
        d3 = pj2.d("kotlinx.coroutines.scheduler.max.pool.size", f, 0, CoroutineScheduler.MAX_SUPPORTED_POOL_SIZE, 4, null);
        MAX_POOL_SIZE = d3;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        e2 = pj2.e("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null);
        IDLE_WORKER_KEEP_ALIVE_NS = timeUnit.toNanos(e2);
        a = si1.INSTANCE;
    }
}
