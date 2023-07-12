package com.loc;

import android.content.Context;
import android.os.Looper;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import tb.y33;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class an extends y33 implements Thread.UncaughtExceptionHandler {
    private static ExecutorService e;
    private static Set<Integer> f = Collections.synchronizedSet(new HashSet());
    private static WeakReference<Context> g;
    private Context d;

    static {
        new ThreadFactory() { // from class: com.loc.an.2
            private final AtomicInteger a = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "pama#" + this.a.getAndIncrement()) { // from class: com.loc.an.2.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public final void run() {
                        try {
                            super.run();
                        } catch (Throwable unused) {
                        }
                    }
                };
            }
        };
    }

    private an(Context context) {
        this.d = context;
        try {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            this.a = defaultUncaughtExceptionHandler;
            if (defaultUncaughtExceptionHandler == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.b = true;
                return;
            }
            String obj = defaultUncaughtExceptionHandler.toString();
            if (!obj.startsWith("com.amap.apis.utils.core.dynamiccore") && (obj.indexOf("com.amap.api") != -1 || obj.indexOf("com.loc") != -1)) {
                this.b = false;
                return;
            }
            Thread.setDefaultUncaughtExceptionHandler(this);
            this.b = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static synchronized an g(Context context, u1 u1Var) throws k {
        synchronized (an.class) {
            try {
                if (u1Var != null) {
                    if (u1Var.a() == null || "".equals(u1Var.a())) {
                        throw new k("sdk name is invalid");
                    }
                    if (!f.add(Integer.valueOf(u1Var.hashCode()))) {
                        return (an) y33.c;
                    }
                    y33 y33Var = y33.c;
                    if (y33Var == null) {
                        y33.c = new an(context);
                    } else {
                        y33Var.b = false;
                    }
                    y33 y33Var2 = y33.c;
                    y33Var2.c(u1Var, y33Var2.b);
                    return (an) y33.c;
                }
                throw new k("sdk info is null");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void h(u1 u1Var, String str, k kVar) {
        if (kVar != null) {
            j(u1Var, str, kVar.c(), kVar.d(), kVar.e(), kVar.b());
        }
    }

    public static void i(u1 u1Var, String str, String str2, String str3, String str4) {
        j(u1Var, str, str2, str3, "", str4);
    }

    public static void j(u1 u1Var, String str, String str2, String str3, String str4, String str5) {
        try {
            if (y33.c != null) {
                y33.c.b(u1Var, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",csid:" + str4 + ",code:" + str5, "networkError");
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized void k() {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        synchronized (an.class) {
            try {
                ExecutorService executorService = e;
                if (executorService != null) {
                    executorService.shutdown();
                }
                v.e();
                if (y33.c != null) {
                    Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                    y33 y33Var = y33.c;
                    if (defaultUncaughtExceptionHandler == y33Var && (uncaughtExceptionHandler = y33Var.a) != null) {
                        Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
                    }
                }
                y33.c = null;
            }
        }
    }

    public static void l(u1 u1Var, String str, String str2) {
        try {
            y33 y33Var = y33.c;
            if (y33Var != null) {
                y33Var.b(u1Var, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void m(Throwable th, String str, String str2) {
        try {
            y33 y33Var = y33.c;
            if (y33Var != null) {
                y33Var.d(th, 1, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void n() {
        WeakReference<Context> weakReference = g;
        if (weakReference != null && weakReference.get() != null) {
            al.c(g.get());
            return;
        }
        y33 y33Var = y33.c;
        if (y33Var != null) {
            y33Var.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tb.y33
    public final void a() {
        al.c(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tb.y33
    public final void b(u1 u1Var, String str, String str2) {
        ao.h(u1Var, this.d, str2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tb.y33
    public final void c(final u1 u1Var, final boolean z) {
        try {
            o0.f().d(new ck() { // from class: com.loc.an.1
                @Override // com.loc.ck
                public final void a() {
                    try {
                        synchronized (Looper.getMainLooper()) {
                            al.e(u1Var);
                        }
                        if (z) {
                            ao.d(an.this.d);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tb.y33
    public final void d(Throwable th, int i, String str, String str2) {
        ao.f(this.d, th, i, str, str2);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        if (th == null) {
            return;
        }
        d(th, 0, null, null);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
        if (uncaughtExceptionHandler != null) {
            try {
                Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
            } catch (Throwable unused) {
            }
            this.a.uncaughtException(thread, th);
        }
    }
}
