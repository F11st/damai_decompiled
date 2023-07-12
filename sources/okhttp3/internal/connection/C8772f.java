package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Proxy;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.C8735a;
import okhttp3.C8831s;
import okhttp3.internal.C8753a;
import okhttp3.internal.connection.C8772f;
import okhttp3.internal.connection.C8776i;
import tb.ps1;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.connection.f */
/* loaded from: classes2.dex */
public final class C8772f {
    private static final Executor g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C8753a.I("OkHttp ConnectionPool", true));
    private final int a;
    private final long b;
    private final Runnable c = new Runnable() { // from class: tb.dz1
        @Override // java.lang.Runnable
        public final void run() {
            C8772f.this.e();
        }
    };
    private final Deque<C8770e> d = new ArrayDeque();
    final C8773g e = new C8773g();
    boolean f;

    public C8772f(int i, long j, TimeUnit timeUnit) {
        this.a = i;
        this.b = timeUnit.toNanos(j);
        if (j > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        while (true) {
            long b = b(System.nanoTime());
            if (b == -1) {
                return;
            }
            if (b > 0) {
                long j = b / 1000000;
                long j2 = b - (1000000 * j);
                synchronized (this) {
                    try {
                        wait(j, (int) j2);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    private int f(C8770e c8770e, long j) {
        List<Reference<C8776i>> list = c8770e.o;
        int i = 0;
        while (i < list.size()) {
            Reference<C8776i> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                ps1.j().r("A connection to " + c8770e.route().a().l() + " was leaked. Did you forget to close a response body?", ((C8776i.C8778b) reference).a);
                list.remove(i);
                c8770e.j = true;
                if (list.isEmpty()) {
                    c8770e.p = j - this.b;
                    return 0;
                }
            }
        }
        return list.size();
    }

    long b(long j) {
        synchronized (this) {
            C8770e c8770e = null;
            long j2 = Long.MIN_VALUE;
            int i = 0;
            int i2 = 0;
            for (C8770e c8770e2 : this.d) {
                if (f(c8770e2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - c8770e2.p;
                    if (j3 > j2) {
                        c8770e = c8770e2;
                        j2 = j3;
                    }
                }
            }
            long j4 = this.b;
            if (j2 < j4 && i <= this.a) {
                if (i > 0) {
                    return j4 - j2;
                } else if (i2 > 0) {
                    return j4;
                } else {
                    this.f = false;
                    return -1L;
                }
            }
            this.d.remove(c8770e);
            C8753a.h(c8770e.socket());
            return 0L;
        }
    }

    public void c(C8831s c8831s, IOException iOException) {
        if (c8831s.b().type() != Proxy.Type.DIRECT) {
            C8735a a = c8831s.a();
            a.i().connectFailed(a.l().D(), c8831s.b().address(), iOException);
        }
        this.e.b(c8831s);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(C8770e c8770e) {
        if (!c8770e.j && this.a != 0) {
            notifyAll();
            return false;
        }
        this.d.remove(c8770e);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(C8770e c8770e) {
        if (!this.f) {
            this.f = true;
            g.execute(this.c);
        }
        this.d.add(c8770e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(C8735a c8735a, C8776i c8776i, @Nullable List<C8831s> list, boolean z) {
        for (C8770e c8770e : this.d) {
            if (!z || c8770e.m()) {
                if (c8770e.k(c8735a, list)) {
                    c8776i.a(c8770e);
                    return true;
                }
            }
        }
        return false;
    }
}
