package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import tb.jn1;

/* compiled from: Taobao */
@Beta
@GwtIncompatible
/* loaded from: classes10.dex */
public abstract class AbstractScheduledService implements Service {
    private static final Logger b = Logger.getLogger(AbstractScheduledService.class.getName());
    private final AbstractC5327c a = new ServiceDelegate(this, null);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.AbstractScheduledService$a */
    /* loaded from: classes10.dex */
    public class C5305a extends Service.AbstractC5323b {
        final /* synthetic */ ScheduledExecutorService a;

        C5305a(AbstractScheduledService abstractScheduledService, ScheduledExecutorService scheduledExecutorService) {
            this.a = scheduledExecutorService;
        }

        @Override // com.google.common.util.concurrent.Service.AbstractC5323b
        public void a(Service.State state, Throwable th) {
            this.a.shutdown();
        }

        @Override // com.google.common.util.concurrent.Service.AbstractC5323b
        public void e(Service.State state) {
            this.a.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.AbstractScheduledService$b */
    /* loaded from: classes10.dex */
    public class ThreadFactoryC5306b implements ThreadFactory {
        ThreadFactoryC5306b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return MoreExecutors.d(AbstractScheduledService.this.f(), runnable);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.AbstractScheduledService$c */
    /* loaded from: classes10.dex */
    public static abstract class AbstractC5307c {
    }

    protected AbstractScheduledService() {
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.AbstractC5323b abstractC5323b, Executor executor) {
        this.a.addListener(abstractC5323b, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.a.awaitRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.a.awaitTerminated();
    }

    protected ScheduledExecutorService c() {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new ThreadFactoryC5306b());
        addListener(new C5305a(this, newSingleThreadScheduledExecutor), MoreExecutors.a());
        return newSingleThreadScheduledExecutor;
    }

    protected abstract void d() throws Exception;

    protected abstract AbstractC5307c e();

    protected String f() {
        return AbstractScheduledService.class.getSimpleName();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.a.failureCause();
    }

    protected void g() throws Exception {
    }

    protected void h() throws Exception {
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.a.isRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service startAsync() {
        this.a.startAsync();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.a.state();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service stopAsync() {
        this.a.stopAsync();
        return this;
    }

    public String toString() {
        return f() + " [" + state() + jn1.ARRAY_END_STR;
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long j, TimeUnit timeUnit) throws TimeoutException {
        this.a.awaitRunning(j, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long j, TimeUnit timeUnit) throws TimeoutException {
        this.a.awaitTerminated(j, timeUnit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class ServiceDelegate extends AbstractC5327c {
        @MonotonicNonNullDecl
        private volatile Future<?> p;
        @MonotonicNonNullDecl
        private volatile ScheduledExecutorService q;
        private final ReentrantLock r;
        private final Runnable s;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        class Task implements Runnable {
            Task() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ServiceDelegate.this.r.lock();
                try {
                } finally {
                    try {
                    } finally {
                    }
                }
                if (ServiceDelegate.this.p.isCancelled()) {
                    return;
                }
                AbstractScheduledService.this.d();
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.google.common.util.concurrent.AbstractScheduledService$ServiceDelegate$a */
        /* loaded from: classes10.dex */
        class C5304a implements Supplier<String> {
            C5304a() {
            }

            @Override // com.google.common.base.Supplier
            /* renamed from: a */
            public String get() {
                return AbstractScheduledService.this.f() + " " + ServiceDelegate.this.state();
            }
        }

        private ServiceDelegate() {
            this.r = new ReentrantLock();
            this.s = new Task();
        }

        @Override // com.google.common.util.concurrent.AbstractC5327c
        protected final void e() {
            this.q = MoreExecutors.h(AbstractScheduledService.this.c(), new C5304a());
            this.q.execute(new Runnable() { // from class: com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.2
                @Override // java.lang.Runnable
                public void run() {
                    ServiceDelegate.this.r.lock();
                    try {
                        AbstractScheduledService.this.h();
                        AbstractScheduledService.this.e();
                        AbstractC5327c unused = AbstractScheduledService.this.a;
                        ScheduledExecutorService unused2 = ServiceDelegate.this.q;
                        Runnable unused3 = ServiceDelegate.this.s;
                        throw null;
                    } catch (Throwable th) {
                        try {
                            ServiceDelegate.this.l(th);
                            if (ServiceDelegate.this.p != null) {
                                ServiceDelegate.this.p.cancel(false);
                            }
                        } finally {
                            ServiceDelegate.this.r.unlock();
                        }
                    }
                }
            });
        }

        @Override // com.google.common.util.concurrent.AbstractC5327c
        protected final void f() {
            this.p.cancel(false);
            this.q.execute(new Runnable() { // from class: com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ServiceDelegate.this.r.lock();
                        if (ServiceDelegate.this.state() != Service.State.STOPPING) {
                            ServiceDelegate.this.r.unlock();
                            return;
                        }
                        AbstractScheduledService.this.g();
                        ServiceDelegate.this.r.unlock();
                        ServiceDelegate.this.n();
                    } catch (Throwable th) {
                        ServiceDelegate.this.l(th);
                    }
                }
            });
        }

        public String toString() {
            return AbstractScheduledService.this.toString();
        }

        /* synthetic */ ServiceDelegate(AbstractScheduledService abstractScheduledService, C5305a c5305a) {
            this();
        }
    }
}
