package com.taobao.android.dinamicx.template.download;

import androidx.annotation.NonNull;
import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import tb.ry;
import tb.s00;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class c extends ThreadPoolExecutor {
    private static final AtomicLong a = new AtomicLong(0);
    private static final ThreadFactory b = new a();
    private static final Comparator c = new b();
    private static final Comparator d = new C0291c();

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    static class a implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(runnable, "download#" + this.a.getAndIncrement());
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    static class b implements Comparator {
        b() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if ((obj instanceof DXPriorityRunnable) && (obj2 instanceof DXPriorityRunnable)) {
                DXPriorityRunnable dXPriorityRunnable = (DXPriorityRunnable) obj;
                DXPriorityRunnable dXPriorityRunnable2 = (DXPriorityRunnable) obj2;
                int i = dXPriorityRunnable.priority - dXPriorityRunnable2.priority;
                return i == 0 ? (int) (dXPriorityRunnable.SEQ - dXPriorityRunnable2.SEQ) : i;
            }
            return 0;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.template.download.c$c  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    static class C0291c implements Comparator {
        C0291c() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if ((obj instanceof DXPriorityRunnable) && (obj2 instanceof DXPriorityRunnable)) {
                DXPriorityRunnable dXPriorityRunnable = (DXPriorityRunnable) obj;
                DXPriorityRunnable dXPriorityRunnable2 = (DXPriorityRunnable) obj2;
                int i = dXPriorityRunnable.priority - dXPriorityRunnable2.priority;
                return i == 0 ? (int) (dXPriorityRunnable2.SEQ - dXPriorityRunnable.SEQ) : i;
            }
            return 0;
        }
    }

    public c(boolean z) {
        this(5, z);
    }

    public void a() {
        getQueue().clear();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        try {
            if (runnable instanceof DXPriorityRunnable) {
                ((DXPriorityRunnable) runnable).SEQ = a.getAndIncrement();
            }
            super.execute(runnable);
        } catch (Throwable th) {
            s00.b(ry.a(th));
        }
    }

    public c(int i, boolean z) {
        this(i, 128, 3L, TimeUnit.SECONDS, new PriorityBlockingQueue(128, z ? c : d), b);
    }

    public c(int i, boolean z, ThreadFactory threadFactory) {
        this(i, 128, 3L, TimeUnit.SECONDS, new PriorityBlockingQueue(128, z ? c : d), threadFactory);
    }

    public c(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
        try {
            allowCoreThreadTimeOut(true);
        } catch (Throwable unused) {
        }
    }
}
