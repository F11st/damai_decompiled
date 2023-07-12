package tb;

import android.os.HandlerThread;
import androidx.annotation.NonNull;
import com.taobao.monitor.common.IHandlerThreadMaker;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class vm2 {
    private static Executor a;
    private static IHandlerThreadMaker b;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static class a implements ThreadFactory {
        final /* synthetic */ AtomicInteger a;

        a(AtomicInteger atomicInteger) {
            this.a = atomicInteger;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(runnable, "APM-common-" + this.a.getAndIncrement());
        }
    }

    public static HandlerThread a(String str) {
        IHandlerThreadMaker iHandlerThreadMaker = b;
        if (iHandlerThreadMaker == null) {
            return new HandlerThread(str);
        }
        return iHandlerThreadMaker.make(str);
    }

    public static void b(Executor executor) {
        a = executor;
    }

    public static void c(IHandlerThreadMaker iHandlerThreadMaker) {
        b = iHandlerThreadMaker;
    }

    public static void d(Runnable runnable) {
        if (a == null) {
            a aVar = new a(new AtomicInteger(0));
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 0L, timeUnit, new LinkedBlockingQueue(), aVar, new ThreadPoolExecutor.AbortPolicy());
            threadPoolExecutor.setKeepAliveTime(3000L, timeUnit);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            a = threadPoolExecutor;
        }
        a.execute(runnable);
    }
}
