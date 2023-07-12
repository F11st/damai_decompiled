package com.alibaba.ability;

import android.os.Handler;
import android.os.Looper;
import com.alibaba.ability.utils.OrangeUtils;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.alibaba.android.schedule.MegaScheduler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.b;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.ri1;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public final class MegaUtils {
    @NotNull
    public static final MegaUtils INSTANCE = new MegaUtils();
    private static final Lazy a;
    private static final Lazy b;
    private static final Lazy c;

    static {
        Lazy b2;
        Lazy b3;
        Lazy b4;
        b2 = b.b(new Function0<ThreadPoolExecutor>() { // from class: com.alibaba.ability.MegaUtils$sThreadPool$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ThreadPoolExecutor invoke() {
                return new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ri1("MegaKit", 0, 2, null));
            }
        });
        a = b2;
        b3 = b.b(new Function0<MegaScheduler>() { // from class: com.alibaba.ability.MegaUtils$sMegaSchedule$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MegaScheduler invoke() {
                return new MegaScheduler("MegaKit", 3);
            }
        });
        b = b3;
        b4 = b.b(new Function0<Handler>() { // from class: com.alibaba.ability.MegaUtils$sHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        c = b4;
    }

    private MegaUtils() {
    }

    private final Handler a() {
        return (Handler) c.getValue();
    }

    private final MegaScheduler b() {
        return (MegaScheduler) b.getValue();
    }

    private final ExecutorService c() {
        return (ExecutorService) a.getValue();
    }

    @JvmStatic
    public static final void d(@NotNull Runnable runnable, long j) {
        b41.i(runnable, "run");
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        b41.h(mainLooper, "Looper.getMainLooper()");
        if (currentThread == mainLooper.getThread() && j <= 0) {
            runnable.run();
        } else {
            INSTANCE.a().postDelayed(runnable, j);
        }
    }

    @JvmStatic
    public static final void e(@NotNull Runnable runnable) {
        b41.i(runnable, UploadQueueMgr.MSGTYPE_REALTIME);
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        b41.h(mainLooper, "Looper.getMainLooper()");
        if (currentThread != mainLooper.getThread()) {
            runnable.run();
        }
        if (OrangeUtils.b()) {
            MegaScheduler.i(INSTANCE.b(), runnable, 0L, 2, null);
        } else {
            INSTANCE.c().submit(runnable);
        }
    }
}
