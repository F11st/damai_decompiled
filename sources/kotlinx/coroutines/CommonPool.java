package kotlinx.coroutines;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import tb.eo2;
import tb.ty1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class CommonPool extends ExecutorCoroutineDispatcher {
    @NotNull
    public static final String DEFAULT_PARALLELISM_PROPERTY_NAME = "kotlinx.coroutines.default.parallelism";
    public static final CommonPool INSTANCE = new CommonPool();
    private static final int a;
    private static boolean b;
    private static volatile Executor pool;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class a implements ThreadFactory {
        final /* synthetic */ AtomicInteger a;

        a(AtomicInteger atomicInteger) {
            this.a = atomicInteger;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "CommonPool-worker-" + this.a.incrementAndGet());
            thread.setDaemon(true);
            return thread;
        }
    }

    static {
        String str;
        int i;
        Integer i2;
        try {
            str = System.getProperty(DEFAULT_PARALLELISM_PROPERTY_NAME);
        } catch (Throwable unused) {
            str = null;
        }
        if (str != null) {
            i2 = kotlin.text.n.i(str);
            if (i2 != null && i2.intValue() >= 1) {
                i = i2.intValue();
            } else {
                throw new IllegalStateException(("Expected positive number in kotlinx.coroutines.default.parallelism, but has " + str).toString());
            }
        } else {
            i = -1;
        }
        a = i;
    }

    private CommonPool() {
    }

    private final ExecutorService a() {
        return Executors.newFixedThreadPool(f(), new a(new AtomicInteger()));
    }

    private final ExecutorService c() {
        Class<?> cls;
        ExecutorService executorService;
        if (System.getSecurityManager() != null) {
            return a();
        }
        ExecutorService executorService2 = null;
        try {
            cls = Class.forName("java.util.concurrent.ForkJoinPool");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls != null) {
            if (!b && a < 0) {
                try {
                    Method method = cls.getMethod("commonPool", new Class[0]);
                    Object invoke = method != null ? method.invoke(null, new Object[0]) : null;
                    if (!(invoke instanceof ExecutorService)) {
                        invoke = null;
                    }
                    executorService = (ExecutorService) invoke;
                } catch (Throwable unused2) {
                    executorService = null;
                }
                if (executorService != null) {
                    if (!INSTANCE.g(cls, executorService)) {
                        executorService = null;
                    }
                    if (executorService != null) {
                        return executorService;
                    }
                }
            }
            try {
                Object newInstance = cls.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(INSTANCE.f()));
                if (!(newInstance instanceof ExecutorService)) {
                    newInstance = null;
                }
                executorService2 = (ExecutorService) newInstance;
            } catch (Throwable unused3) {
            }
            return executorService2 != null ? executorService2 : a();
        }
        return a();
    }

    private final synchronized Executor e() {
        Executor executor;
        executor = pool;
        if (executor == null) {
            executor = c();
            pool = executor;
        }
        return executor;
    }

    private final int f() {
        int a2;
        Integer valueOf = Integer.valueOf(a);
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            return valueOf.intValue();
        }
        a2 = ty1.a(Runtime.getRuntime().availableProcessors() - 1, 1);
        return a2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on CommonPool".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        Runnable runnable2;
        try {
            Executor executor = pool;
            if (executor == null) {
                executor = e();
            }
            TimeSource a2 = eo2.a();
            if (a2 == null || (runnable2 = a2.wrapTask(runnable)) == null) {
                runnable2 = runnable;
            }
            executor.execute(runnable2);
        } catch (RejectedExecutionException unused) {
            TimeSource a3 = eo2.a();
            if (a3 != null) {
                a3.unTrackTask();
            }
            DefaultExecutor.INSTANCE.enqueue(runnable);
        }
    }

    public final boolean g(@NotNull Class<?> cls, @NotNull ExecutorService executorService) {
        executorService.submit(new Runnable() { // from class: kotlinx.coroutines.CommonPool$isGoodCommonPool$1
            @Override // java.lang.Runnable
            public final void run() {
            }
        });
        Integer num = null;
        try {
            Object invoke = cls.getMethod("getPoolSize", new Class[0]).invoke(executorService, new Object[0]);
            if (!(invoke instanceof Integer)) {
                invoke = null;
            }
            num = (Integer) invoke;
        } catch (Throwable unused) {
        }
        return num != null && num.intValue() >= 1;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        return "CommonPool";
    }
}
