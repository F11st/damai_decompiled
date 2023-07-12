package com.amap.api.mapcore.util;

import com.amap.api.mapcore.util.jk;
import com.taobao.weex.common.Constants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class jj {
    private static jj a;
    private ExecutorService b;
    private ConcurrentHashMap<jk, Future<?>> c = new ConcurrentHashMap<>();
    private jk.a d = new jk.a() { // from class: com.amap.api.mapcore.util.jj.1
        @Override // com.amap.api.mapcore.util.jk.a
        public void a(jk jkVar) {
        }

        @Override // com.amap.api.mapcore.util.jk.a
        public void b(jk jkVar) {
            jj.this.a(jkVar, false);
        }

        @Override // com.amap.api.mapcore.util.jk.a
        public void c(jk jkVar) {
            jj.this.a(jkVar, true);
        }
    };

    private jj(int i) {
        try {
            this.b = new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(256));
        } catch (Throwable th) {
            hd.c(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    public static jj b(int i) {
        return new jj(i);
    }

    public static synchronized jj a(int i) {
        jj jjVar;
        synchronized (jj.class) {
            if (a == null) {
                a = new jj(i);
            }
            jjVar = a;
        }
        return jjVar;
    }

    private void b() {
        try {
            for (Map.Entry<jk, Future<?>> entry : this.c.entrySet()) {
                Future<?> future = this.c.get(entry.getKey());
                if (future != null) {
                    try {
                        future.cancel(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            this.c.clear();
            this.b.shutdown();
        } catch (Throwable th) {
            hd.c(th, "TPool", Constants.Event.SLOT_LIFECYCLE.DESTORY);
            th.printStackTrace();
        }
    }

    public void a(jk jkVar) throws gb {
        ExecutorService executorService;
        try {
            if (!b(jkVar) && (executorService = this.b) != null && !executorService.isShutdown()) {
                jkVar.e = this.d;
                try {
                    Future<?> submit = this.b.submit(jkVar);
                    if (submit == null) {
                        return;
                    }
                    a(jkVar, submit);
                } catch (RejectedExecutionException unused) {
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            hd.c(th, "TPool", "addTask");
            throw new gb("thread pool has exception");
        }
    }

    public static synchronized void a() {
        synchronized (jj.class) {
            try {
                jj jjVar = a;
                if (jjVar != null) {
                    jjVar.b();
                    a = null;
                }
            } finally {
            }
        }
    }

    private synchronized boolean b(jk jkVar) {
        boolean z;
        try {
            z = this.c.containsKey(jkVar);
        } catch (Throwable th) {
            hd.c(th, "TPool", "contain");
            th.printStackTrace();
            z = false;
        }
        return z;
    }

    private synchronized void a(jk jkVar, Future<?> future) {
        try {
            this.c.put(jkVar, future);
        } catch (Throwable th) {
            hd.c(th, "TPool", "addQueue");
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(jk jkVar, boolean z) {
        try {
            Future<?> remove = this.c.remove(jkVar);
            if (z && remove != null) {
                remove.cancel(true);
            }
        } finally {
        }
    }
}
