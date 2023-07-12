package tb;

import androidx.annotation.NonNull;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class x53 {
    private static ThreadPoolExecutor a = new ThreadPoolExecutor(2, 2, 10, TimeUnit.MINUTES, new LinkedBlockingQueue(Integer.MAX_VALUE), new ThreadPoolExecutor.DiscardOldestPolicy());

    public static Future<?> a(@NonNull Runnable runnable) {
        try {
            return a.submit(runnable);
        } catch (Throwable th) {
            w63.c("efs.util.concurrent", "submit task error!", th);
            return null;
        }
    }
}
