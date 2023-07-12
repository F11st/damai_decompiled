package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Looper;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class hd extends ha implements Thread.UncaughtExceptionHandler {
    private static ExecutorService e;
    private static WeakReference<Context> g;
    private Context d;
    private List<a> i;
    private static Set<Integer> f = Collections.synchronizedSet(new HashSet());
    private static final ThreadFactory h = new ThreadFactory() { // from class: com.amap.api.mapcore.util.hd.2
        private final AtomicInteger a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pama#" + this.a.getAndIncrement());
        }
    };

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface a {
        void a(Thread thread, Throwable th);
    }

    private hd(Context context, gm gmVar) {
        this.d = context;
        f();
    }

    public static synchronized void b() {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        synchronized (hd.class) {
            try {
                ExecutorService executorService = e;
                if (executorService != null) {
                    executorService.shutdown();
                }
                hy.a();
                if (ha.a != null) {
                    Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                    ha haVar = ha.a;
                    if (defaultUncaughtExceptionHandler == haVar && (uncaughtExceptionHandler = haVar.b) != null) {
                        Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
                    }
                }
                ha.a = null;
            }
        }
    }

    public static void c() {
        WeakReference<Context> weakReference = g;
        if (weakReference != null && weakReference.get() != null) {
            hb.a(g.get());
            return;
        }
        ha haVar = ha.a;
        if (haVar != null) {
            haVar.a();
        }
    }

    public static synchronized ExecutorService d() {
        ExecutorService executorService;
        synchronized (hd.class) {
            try {
                ExecutorService executorService2 = e;
                if (executorService2 == null || executorService2.isShutdown()) {
                    e = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(256), h);
                }
            } catch (Throwable unused) {
            }
            executorService = e;
        }
        return executorService;
    }

    public static synchronized hd e() {
        hd hdVar;
        synchronized (hd.class) {
            hdVar = (hd) ha.a;
        }
        return hdVar;
    }

    private void f() {
        try {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            this.b = defaultUncaughtExceptionHandler;
            if (defaultUncaughtExceptionHandler == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.c = true;
                return;
            }
            String obj = defaultUncaughtExceptionHandler.toString();
            if (!obj.startsWith("com.amap.apis.utils.core.dynamiccore") && (obj.indexOf("com.amap.api") != -1 || obj.indexOf("com.loc") != -1)) {
                this.c = false;
                return;
            }
            Thread.setDefaultUncaughtExceptionHandler(this);
            this.c = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(thread, th);
        if (th == null) {
            return;
        }
        a(th, 0, null, null);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler != null) {
            try {
                Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
            } catch (Throwable unused) {
            }
            this.b.uncaughtException(thread, th);
        }
    }

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            g = new WeakReference<>(context.getApplicationContext());
        } catch (Throwable unused) {
        }
    }

    public static synchronized hd a(Context context, gm gmVar) throws gb {
        synchronized (hd.class) {
            try {
                if (gmVar != null) {
                    if (gmVar.a() != null && !"".equals(gmVar.a())) {
                        if (!f.add(Integer.valueOf(gmVar.hashCode()))) {
                            return (hd) ha.a;
                        }
                        ha haVar = ha.a;
                        if (haVar == null) {
                            ha.a = new hd(context, gmVar);
                        } else {
                            haVar.c = false;
                        }
                        ha haVar2 = ha.a;
                        haVar2.a(context, gmVar, haVar2.c);
                        return (hd) ha.a;
                    }
                    throw new gb("sdk name is invalid");
                }
                throw new gb("sdk info is null");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void c(Throwable th, String str, String str2) {
        try {
            ha haVar = ha.a;
            if (haVar != null) {
                haVar.a(th, 1, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void b(Context context, gm gmVar, String str, String str2, String str3) {
        he.a(context, gmVar, str, 1, str2, str3);
    }

    public void b(Throwable th, String str, String str2) {
        if (th == null) {
            return;
        }
        try {
            a(th, 1, str, str2);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.ha
    public void a(gm gmVar, String str, String str2) {
        he.a(gmVar, this.d, str2, str);
    }

    public static void b(gm gmVar, String str, String str2) {
        try {
            ha haVar = ha.a;
            if (haVar != null) {
                haVar.a(gmVar, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.ha
    public void a(Throwable th, int i, String str, String str2) {
        he.a(this.d, th, i, str, str2);
    }

    public static void a(Context context, gm gmVar, String str, String str2, String str3) {
        he.a(context, gmVar, str, 0, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.ha
    public void a() {
        hb.a(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.ha
    public void a(final Context context, final gm gmVar, final boolean z) {
        try {
            ExecutorService d = d();
            if (d != null && !d.isShutdown()) {
                d.submit(new Runnable() { // from class: com.amap.api.mapcore.util.hd.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            synchronized (Looper.getMainLooper()) {
                                new hl(context, true).a(gmVar);
                            }
                            if (z) {
                                he.a(hd.this.d);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        } catch (RejectedExecutionException unused) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(gm gmVar, String str, String str2, String str3, String str4, String str5) {
        try {
            if (ha.a != null) {
                ha.a.a(gmVar, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",csid:" + str4 + ",code:" + str5, "networkError");
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(gm gmVar, String str, gb gbVar) {
        if (gbVar != null) {
            a(gmVar, str, gbVar.c(), gbVar.d(), gbVar.e(), gbVar.b());
        }
    }

    private void a(Thread thread, Throwable th) {
        for (int i = 0; i < this.i.size() && i < 10; i++) {
            try {
                a aVar = this.i.get(i);
                if (aVar != null) {
                    aVar.a(thread, th);
                }
            } catch (Throwable unused) {
                return;
            }
        }
    }
}
