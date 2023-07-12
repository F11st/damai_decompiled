package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.util.concurrent.ListenerCallQueue;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.m;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;

/* compiled from: Taobao */
@Beta
@GwtIncompatible
/* loaded from: classes10.dex */
public abstract class c implements Service {
    private static final ListenerCallQueue.Event<Service.b> h = new a();
    private static final ListenerCallQueue.Event<Service.b> i = new b();
    private static final ListenerCallQueue.Event<Service.b> j;
    private static final ListenerCallQueue.Event<Service.b> k;
    private static final ListenerCallQueue.Event<Service.b> l;
    private static final ListenerCallQueue.Event<Service.b> m;
    private static final ListenerCallQueue.Event<Service.b> n;
    private static final ListenerCallQueue.Event<Service.b> o;
    private final m a = new m();
    private final m.a b = new h();
    private final m.a c = new i();
    private final m.a d = new g();
    private final m.a e = new j();
    private final ListenerCallQueue<Service.b> f = new ListenerCallQueue<>();
    private volatile k g = new k(Service.State.NEW);

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class a implements ListenerCallQueue.Event<Service.b> {
        a() {
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        /* renamed from: a */
        public void call(Service.b bVar) {
            bVar.c();
        }

        public String toString() {
            return "starting()";
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class b implements ListenerCallQueue.Event<Service.b> {
        b() {
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        /* renamed from: a */
        public void call(Service.b bVar) {
            bVar.b();
        }

        public String toString() {
            return "running()";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.c$c  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0242c implements ListenerCallQueue.Event<Service.b> {
        final /* synthetic */ Service.State a;

        C0242c(Service.State state) {
            this.a = state;
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        /* renamed from: a */
        public void call(Service.b bVar) {
            bVar.e(this.a);
        }

        public String toString() {
            return "terminated({from = " + this.a + "})";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class d implements ListenerCallQueue.Event<Service.b> {
        final /* synthetic */ Service.State a;

        d(Service.State state) {
            this.a = state;
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        /* renamed from: a */
        public void call(Service.b bVar) {
            bVar.d(this.a);
        }

        public String toString() {
            return "stopping({from = " + this.a + "})";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class e implements ListenerCallQueue.Event<Service.b> {
        final /* synthetic */ Service.State a;
        final /* synthetic */ Throwable b;

        e(c cVar, Service.State state, Throwable th) {
            this.a = state;
            this.b = th;
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        /* renamed from: a */
        public void call(Service.b bVar) {
            bVar.a(this.a, this.b);
        }

        public String toString() {
            return "failed({from = " + this.a + ", cause = " + this.b + "})";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class f {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Service.State.values().length];
            a = iArr;
            try {
                iArr[Service.State.NEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Service.State.STARTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Service.State.RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Service.State.STOPPING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Service.State.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Service.State.FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private final class g extends m.a {
        g() {
            super(c.this.a);
        }

        @Override // com.google.common.util.concurrent.m.a
        public boolean a() {
            return c.this.state().compareTo(Service.State.RUNNING) >= 0;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private final class h extends m.a {
        h() {
            super(c.this.a);
        }

        @Override // com.google.common.util.concurrent.m.a
        public boolean a() {
            return c.this.state() == Service.State.NEW;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private final class i extends m.a {
        i() {
            super(c.this.a);
        }

        @Override // com.google.common.util.concurrent.m.a
        public boolean a() {
            return c.this.state().compareTo(Service.State.RUNNING) <= 0;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private final class j extends m.a {
        j() {
            super(c.this.a);
        }

        @Override // com.google.common.util.concurrent.m.a
        public boolean a() {
            return c.this.state().isTerminal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class k {
        final Service.State a;
        final boolean b;
        @NullableDecl
        final Throwable c;

        k(Service.State state) {
            this(state, false, null);
        }

        Service.State a() {
            if (this.b && this.a == Service.State.STARTING) {
                return Service.State.STOPPING;
            }
            return this.a;
        }

        Throwable b() {
            Service.State state = this.a;
            du1.A(state == Service.State.FAILED, "failureCause() is only valid if the service has failed, service is %s", state);
            return this.c;
        }

        k(Service.State state, boolean z, @NullableDecl Throwable th) {
            du1.k(!z || state == Service.State.STARTING, "shutdownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", state);
            du1.l(!((state == Service.State.FAILED) ^ (th != null)), "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", state, th);
            this.a = state;
            this.b = z;
            this.c = th;
        }
    }

    static {
        Service.State state = Service.State.STARTING;
        j = o(state);
        Service.State state2 = Service.State.RUNNING;
        k = o(state2);
        l = p(Service.State.NEW);
        m = p(state);
        n = p(state2);
        o = p(Service.State.STOPPING);
    }

    @GuardedBy("monitor")
    private void b(Service.State state) {
        Service.State state2 = state();
        if (state2 != state) {
            if (state2 == Service.State.FAILED) {
                throw new IllegalStateException("Expected the service " + this + " to be " + state + ", but the service has FAILED", failureCause());
            }
            throw new IllegalStateException("Expected the service " + this + " to be " + state + ", but was " + state2);
        }
    }

    private void c() {
        if (this.a.k()) {
            return;
        }
        this.f.c();
    }

    private void g(Service.State state, Throwable th) {
        this.f.d(new e(this, state, th));
    }

    private void h() {
        this.f.d(i);
    }

    private void i() {
        this.f.d(h);
    }

    private void j(Service.State state) {
        if (state == Service.State.STARTING) {
            this.f.d(j);
        } else if (state == Service.State.RUNNING) {
            this.f.d(k);
        } else {
            throw new AssertionError();
        }
    }

    private void k(Service.State state) {
        switch (f.a[state.ordinal()]) {
            case 1:
                this.f.d(l);
                return;
            case 2:
                this.f.d(m);
                return;
            case 3:
                this.f.d(n);
                return;
            case 4:
                this.f.d(o);
                return;
            case 5:
            case 6:
                throw new AssertionError();
            default:
                return;
        }
    }

    private static ListenerCallQueue.Event<Service.b> o(Service.State state) {
        return new d(state);
    }

    private static ListenerCallQueue.Event<Service.b> p(Service.State state) {
        return new C0242c(state);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.b bVar, Executor executor) {
        this.f.b(bVar, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.a.h(this.d);
        try {
            b(Service.State.RUNNING);
        } finally {
            this.a.m();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.a.h(this.e);
        try {
            b(Service.State.TERMINATED);
        } finally {
            this.a.m();
        }
    }

    @ForOverride
    protected void d() {
    }

    @ForOverride
    protected abstract void e();

    @ForOverride
    protected abstract void f();

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.g.b();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return state() == Service.State.RUNNING;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l(Throwable th) {
        du1.p(th);
        this.a.f();
        try {
            Service.State state = state();
            int i2 = f.a[state.ordinal()];
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3 || i2 == 4) {
                    this.g = new k(Service.State.FAILED, false, th);
                    g(state, th);
                } else if (i2 != 5) {
                }
                return;
            }
            throw new IllegalStateException("Failed while in state:" + state, th);
        } finally {
            this.a.m();
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void m() {
        this.a.f();
        try {
            if (this.g.a == Service.State.STARTING) {
                if (this.g.b) {
                    this.g = new k(Service.State.STOPPING);
                    f();
                } else {
                    this.g = new k(Service.State.RUNNING);
                    h();
                }
                return;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Cannot notifyStarted() when the service is " + this.g.a);
            l(illegalStateException);
            throw illegalStateException;
        } finally {
            this.a.m();
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void n() {
        this.a.f();
        try {
            Service.State state = state();
            switch (f.a[state.ordinal()]) {
                case 1:
                case 5:
                case 6:
                    throw new IllegalStateException("Cannot notifyStopped() when the service is " + state);
                case 2:
                case 3:
                case 4:
                    this.g = new k(Service.State.TERMINATED);
                    k(state);
                    break;
            }
        } finally {
            this.a.m();
            c();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service startAsync() {
        if (this.a.g(this.b)) {
            try {
                this.g = new k(Service.State.STARTING);
                i();
                e();
            } finally {
                try {
                    return this;
                } finally {
                }
            }
            return this;
        }
        throw new IllegalStateException("Service " + this + " has already been started");
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.g.a();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service stopAsync() {
        if (this.a.g(this.c)) {
            try {
                Service.State state = state();
                switch (f.a[state.ordinal()]) {
                    case 1:
                        this.g = new k(Service.State.TERMINATED);
                        k(Service.State.NEW);
                        break;
                    case 2:
                        Service.State state2 = Service.State.STARTING;
                        this.g = new k(state2, true, null);
                        j(state2);
                        d();
                        break;
                    case 3:
                        this.g = new k(Service.State.STOPPING);
                        j(Service.State.RUNNING);
                        f();
                        break;
                    case 4:
                    case 5:
                    case 6:
                        throw new AssertionError("isStoppable is incorrectly implemented, saw: " + state);
                }
            } finally {
                try {
                } finally {
                }
            }
        }
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long j2, TimeUnit timeUnit) throws TimeoutException {
        if (this.a.i(this.d, j2, timeUnit)) {
            try {
                b(Service.State.RUNNING);
                return;
            } finally {
                this.a.m();
            }
        }
        throw new TimeoutException("Timed out waiting for " + this + " to reach the RUNNING state.");
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long j2, TimeUnit timeUnit) throws TimeoutException {
        if (this.a.i(this.e, j2, timeUnit)) {
            try {
                b(Service.State.TERMINATED);
                return;
            } finally {
                this.a.m();
            }
        }
        throw new TimeoutException("Timed out waiting for " + this + " to reach a terminal state. Current state: " + state());
    }
}
