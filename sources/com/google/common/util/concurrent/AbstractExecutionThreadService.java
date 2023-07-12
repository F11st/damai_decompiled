package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;
import tb.jn1;

/* compiled from: Taobao */
@Beta
@GwtIncompatible
/* loaded from: classes10.dex */
public abstract class AbstractExecutionThreadService implements Service {
    private static final Logger b = Logger.getLogger(AbstractExecutionThreadService.class.getName());
    private final Service a = new AbstractC5327c() { // from class: com.google.common.util.concurrent.AbstractExecutionThreadService.1

        /* compiled from: Taobao */
        /* renamed from: com.google.common.util.concurrent.AbstractExecutionThreadService$1$a */
        /* loaded from: classes10.dex */
        class C5292a implements Supplier<String> {
            C5292a() {
            }

            @Override // com.google.common.base.Supplier
            /* renamed from: a */
            public String get() {
                return AbstractExecutionThreadService.this.d();
            }
        }

        @Override // com.google.common.util.concurrent.AbstractC5327c
        protected final void e() {
            MoreExecutors.g(AbstractExecutionThreadService.this.b(), new C5292a()).execute(new Runnable() { // from class: com.google.common.util.concurrent.AbstractExecutionThreadService.1.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AbstractExecutionThreadService.this.f();
                        m();
                        if (isRunning()) {
                            AbstractExecutionThreadService.this.c();
                        }
                        AbstractExecutionThreadService.this.e();
                        n();
                    } catch (Throwable th) {
                        l(th);
                    }
                }
            });
        }

        @Override // com.google.common.util.concurrent.AbstractC5327c
        protected void f() {
            AbstractExecutionThreadService.this.g();
        }

        public String toString() {
            return AbstractExecutionThreadService.this.toString();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.AbstractExecutionThreadService$a */
    /* loaded from: classes10.dex */
    public class ExecutorC5293a implements Executor {
        ExecutorC5293a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            MoreExecutors.d(AbstractExecutionThreadService.this.d(), runnable).start();
        }
    }

    protected AbstractExecutionThreadService() {
    }

    static /* synthetic */ Logger a() {
        return b;
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

    protected Executor b() {
        return new ExecutorC5293a();
    }

    protected abstract void c() throws Exception;

    protected String d() {
        return AbstractExecutionThreadService.class.getSimpleName();
    }

    protected void e() throws Exception {
    }

    protected void f() throws Exception {
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.a.failureCause();
    }

    protected void g() {
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
        return d() + " [" + state() + jn1.ARRAY_END_STR;
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long j, TimeUnit timeUnit) throws TimeoutException {
        this.a.awaitRunning(j, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long j, TimeUnit timeUnit) throws TimeoutException {
        this.a.awaitTerminated(j, timeUnit);
    }
}
