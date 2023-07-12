package tb;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.taobao.android.dinamicx.template.download.C6400c;
import com.taobao.android.dinamicx.template.download.DXPriorityRunnable;
import com.taobao.android.dinamicx.thread.DXDownLoadRunnable;
import com.taobao.android.dinamicx.thread.DXMonitorRunnable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class y00 {
    private static String m = "monitor_thread";
    private static String n = "render_thread";
    private Handler a;
    private C6400c b;
    private C6400c c;
    private C6400c d;
    private ScheduledExecutorService e;
    private HandlerThread f;
    private Handler g;
    private C6400c h;
    private HandlerThread i;
    private C6400c j;
    private C6400c k;
    private C6400c l;

    /* compiled from: Taobao */
    /* renamed from: tb.y00$a */
    /* loaded from: classes11.dex */
    class ThreadFactoryC9941a implements ThreadFactory {
        ThreadFactoryC9941a(y00 y00Var) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "scheduled-thread");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.y00$b */
    /* loaded from: classes11.dex */
    static class ThreadFactoryC9942b implements ThreadFactory {
        ThreadFactoryC9942b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "DX-Trace-Thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.y00$c */
    /* loaded from: classes11.dex */
    public static class C9943c {
        private static final y00 a = new y00(null);
    }

    /* synthetic */ y00(ThreadFactoryC9941a threadFactoryC9941a) {
        this();
    }

    public static void a(Runnable runnable) {
        d().a.removeCallbacks(runnable);
    }

    public static void b() {
        d().j.a();
        d().k.a();
    }

    public static HandlerThread c() {
        return d().i;
    }

    public static y00 d() {
        return C9943c.a;
    }

    public static boolean e(Runnable runnable) {
        return d().a.post(runnable);
    }

    public static void f(DXDownLoadRunnable dXDownLoadRunnable) {
        d().d.execute(dXDownLoadRunnable);
    }

    public static void g(DXMonitorRunnable dXMonitorRunnable) {
        d().g.post(dXMonitorRunnable);
    }

    public static void h(DXPriorityRunnable dXPriorityRunnable) {
        d().l.execute(dXPriorityRunnable);
    }

    public static void i(DXPriorityRunnable dXPriorityRunnable) {
        d().j.execute(dXPriorityRunnable);
    }

    public static void j(DXPriorityRunnable dXPriorityRunnable) {
        d().k.execute(dXPriorityRunnable);
    }

    public static void k(Runnable runnable) {
        if (d().h == null) {
            d().h = new C6400c(2, true, new ThreadFactoryC9942b());
        }
        d().h.execute(runnable);
    }

    public static void l(Runnable runnable) {
        d().c.execute(runnable);
    }

    public static void m(Runnable runnable) {
        d().a.post(runnable);
    }

    public static void n(Runnable runnable, long j) {
        d().a.postDelayed(runnable, j);
    }

    public static boolean o(Runnable runnable) {
        return d().a.postAtFrontOfQueue(runnable);
    }

    public static void p(Runnable runnable) {
        d().b.execute(runnable);
    }

    public static <Params, Progress, Result> void q(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        if (asyncTask == null) {
            return;
        }
        asyncTask.executeOnExecutor(d().b, paramsArr);
    }

    public static ScheduledExecutorService r() {
        return d().e;
    }

    private y00() {
        this.a = new Handler(Looper.getMainLooper());
        this.b = new C6400c(true);
        this.d = new C6400c(true);
        this.e = new ScheduledThreadPoolExecutor(1, new ThreadFactoryC9941a(this));
        HandlerThread handlerThread = new HandlerThread(m);
        this.f = handlerThread;
        handlerThread.start();
        this.g = new Handler(this.f.getLooper());
        HandlerThread handlerThread2 = new HandlerThread(n);
        this.i = handlerThread2;
        handlerThread2.start();
        this.j = new C6400c(1, true);
        this.l = new C6400c(1, true);
        this.k = new C6400c(2, true);
        this.c = new C6400c(2, true);
    }
}
