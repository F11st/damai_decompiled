package com.amap.api.col.s;

import android.content.Context;
import android.os.Looper;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class cl extends ci implements Thread.UncaughtExceptionHandler {
    private static WeakReference<Context> f;
    private Context d;
    private static Set<Integer> e = Collections.synchronizedSet(new HashSet());
    private static final ThreadFactory g = new ThreadFactory() { // from class: com.amap.api.col.s.cl.2
        private final AtomicInteger a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pama#" + this.a.getAndIncrement()) { // from class: com.amap.api.col.s.cl.2.1
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

    private cl(Context context) {
        this.d = context;
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

    public static void c(Throwable th, String str, String str2) {
        try {
            ci ciVar = ci.a;
            if (ciVar != null) {
                ciVar.a(th, 1, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public final void b(Throwable th, String str, String str2) {
        if (th == null) {
            return;
        }
        try {
            a(th, 1, str, str2);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
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

    public static synchronized cl a(Context context, bv bvVar) throws bj {
        synchronized (cl.class) {
            try {
                if (bvVar != null) {
                    if (bvVar.b() != null && !"".equals(bvVar.b())) {
                        if (!e.add(Integer.valueOf(bvVar.hashCode()))) {
                            return (cl) ci.a;
                        }
                        ci ciVar = ci.a;
                        if (ciVar == null) {
                            ci.a = new cl(context);
                        } else {
                            ciVar.c = false;
                        }
                        ci ciVar2 = ci.a;
                        ciVar2.a(bvVar, ciVar2.c);
                        return (cl) ci.a;
                    }
                    throw new bj("sdk name is invalid");
                }
                throw new bj("sdk info is null");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void b() {
        WeakReference<Context> weakReference = f;
        if (weakReference != null && weakReference.get() != null) {
            cj.a(f.get());
            return;
        }
        ci ciVar = ci.a;
        if (ciVar != null) {
            ciVar.a();
        }
    }

    public static synchronized cl c() {
        cl clVar;
        synchronized (cl.class) {
            clVar = (cl) ci.a;
        }
        return clVar;
    }

    public static void b(bv bvVar, String str, String str2) {
        try {
            ci ciVar = ci.a;
            if (ciVar != null) {
                ciVar.a(bvVar, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.ci
    public final void a(bv bvVar, String str, String str2) {
        cm.a(bvVar, this.d, str2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.ci
    public final void a(Throwable th, int i, String str, String str2) {
        cm.a(this.d, th, i, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.ci
    public final void a() {
        cj.a(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.ci
    public final void a(final bv bvVar, final boolean z) {
        try {
            ed.a().b(new ee() { // from class: com.amap.api.col.s.cl.1
                @Override // com.amap.api.col.s.ee
                public final void a() {
                    try {
                        synchronized (Looper.getMainLooper()) {
                            cj.a(bvVar);
                        }
                        if (z) {
                            cm.a(cl.this.d);
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

    public static void a(bv bvVar, String str, String str2, String str3, String str4) {
        a(bvVar, str, str2, str3, "", str4);
    }

    public static void a(bv bvVar, String str, String str2, String str3, String str4, String str5) {
        try {
            if (ci.a != null) {
                ci.a.a(bvVar, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",csid:" + str4 + ",code:" + str5, "networkError");
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(bv bvVar, String str, bj bjVar) {
        a(bvVar, str, bjVar.c(), bjVar.d(), bjVar.e(), bjVar.b());
    }
}
