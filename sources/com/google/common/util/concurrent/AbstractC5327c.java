package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.util.concurrent.C5358m;
import com.google.common.util.concurrent.ListenerCallQueue;
import com.google.common.util.concurrent.Service;
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
/* renamed from: com.google.common.util.concurrent.c */
/* loaded from: classes10.dex */
public abstract class AbstractC5327c implements Service {
    private static final ListenerCallQueue.Event<Service.AbstractC5323b> h = new C5328a();
    private static final ListenerCallQueue.Event<Service.AbstractC5323b> i = new C5329b();
    private static final ListenerCallQueue.Event<Service.AbstractC5323b> j;
    private static final ListenerCallQueue.Event<Service.AbstractC5323b> k;
    private static final ListenerCallQueue.Event<Service.AbstractC5323b> l;
    private static final ListenerCallQueue.Event<Service.AbstractC5323b> m;
    private static final ListenerCallQueue.Event<Service.AbstractC5323b> n;
    private static final ListenerCallQueue.Event<Service.AbstractC5323b> o;
    private final C5358m a = new C5358m();
    private final C5358m.AbstractC5359a b = new C5335h();
    private final C5358m.AbstractC5359a c = new C5336i();
    private final C5358m.AbstractC5359a d = new C5334g();
    private final C5358m.AbstractC5359a e = new C5337j();
    private final ListenerCallQueue<Service.AbstractC5323b> f = new ListenerCallQueue<>();
    private volatile C5338k g = new C5338k(Service.State.NEW);

    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.c$a */
    /* loaded from: classes10.dex */
    static class C5328a implements ListenerCallQueue.Event<Service.AbstractC5323b> {
        C5328a() {
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        /* renamed from: a */
        public void call(Service.AbstractC5323b abstractC5323b) {
            abstractC5323b.c();
        }

        public String toString() {
            return "starting()";
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.c$b */
    /* loaded from: classes10.dex */
    static class C5329b implements ListenerCallQueue.Event<Service.AbstractC5323b> {
        C5329b() {
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        /* renamed from: a */
        public void call(Service.AbstractC5323b abstractC5323b) {
            abstractC5323b.b();
        }

        public String toString() {
            return "running()";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.c$c */
    /* loaded from: classes10.dex */
    public static class C5330c implements ListenerCallQueue.Event<Service.AbstractC5323b> {
        final /* synthetic */ Service.State a;

        C5330c(Service.State state) {
            this.a = state;
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        /* renamed from: a */
        public void call(Service.AbstractC5323b abstractC5323b) {
            abstractC5323b.e(this.a);
        }

        public String toString() {
            return "terminated({from = " + this.a + "})";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.c$d */
    /* loaded from: classes10.dex */
    public static class C5331d implements ListenerCallQueue.Event<Service.AbstractC5323b> {
        final /* synthetic */ Service.State a;

        C5331d(Service.State state) {
            this.a = state;
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        /* renamed from: a */
        public void call(Service.AbstractC5323b abstractC5323b) {
            abstractC5323b.d(this.a);
        }

        public String toString() {
            return "stopping({from = " + this.a + "})";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.c$e */
    /* loaded from: classes10.dex */
    public class C5332e implements ListenerCallQueue.Event<Service.AbstractC5323b> {
        final /* synthetic */ Service.State a;
        final /* synthetic */ Throwable b;

        C5332e(AbstractC5327c abstractC5327c, Service.State state, Throwable th) {
            this.a = state;
            this.b = th;
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        /* renamed from: a */
        public void call(Service.AbstractC5323b abstractC5323b) {
            abstractC5323b.a(this.a, this.b);
        }

        public String toString() {
            return "failed({from = " + this.a + ", cause = " + this.b + "})";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.c$f */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class C5333f {
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
    /* renamed from: com.google.common.util.concurrent.c$g */
    /* loaded from: classes10.dex */
    private final class C5334g extends C5358m.AbstractC5359a {
        C5334g() {
            super(AbstractC5327c.this.a);
        }

        @Override // com.google.common.util.concurrent.C5358m.AbstractC5359a
        public boolean a() {
            return AbstractC5327c.this.state().compareTo(Service.State.RUNNING) >= 0;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.c$h */
    /* loaded from: classes10.dex */
    private final class C5335h extends C5358m.AbstractC5359a {
        C5335h() {
            super(AbstractC5327c.this.a);
        }

        @Override // com.google.common.util.concurrent.C5358m.AbstractC5359a
        public boolean a() {
            return AbstractC5327c.this.state() == Service.State.NEW;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.c$i */
    /* loaded from: classes10.dex */
    private final class C5336i extends C5358m.AbstractC5359a {
        C5336i() {
            super(AbstractC5327c.this.a);
        }

        @Override // com.google.common.util.concurrent.C5358m.AbstractC5359a
        public boolean a() {
            return AbstractC5327c.this.state().compareTo(Service.State.RUNNING) <= 0;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.c$j */
    /* loaded from: classes10.dex */
    private final class C5337j extends C5358m.AbstractC5359a {
        C5337j() {
            super(AbstractC5327c.this.a);
        }

        @Override // com.google.common.util.concurrent.C5358m.AbstractC5359a
        public boolean a() {
            return AbstractC5327c.this.state().isTerminal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.c$k */
    /* loaded from: classes10.dex */
    public static final class C5338k {
        final Service.State a;
        final boolean b;
        @NullableDecl
        final Throwable c;

        C5338k(Service.State state) {
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

        C5338k(Service.State state, boolean z, @NullableDecl Throwable th) {
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
        this.f.d(new C5332e(this, state, th));
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
        switch (C5333f.a[state.ordinal()]) {
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

    private static ListenerCallQueue.Event<Service.AbstractC5323b> o(Service.State state) {
        return new C5331d(state);
    }

    private static ListenerCallQueue.Event<Service.AbstractC5323b> p(Service.State state) {
        return new C5330c(state);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.AbstractC5323b abstractC5323b, Executor executor) {
        this.f.b(abstractC5323b, executor);
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
            int i2 = C5333f.a[state.ordinal()];
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3 || i2 == 4) {
                    this.g = new C5338k(Service.State.FAILED, false, th);
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
                    this.g = new C5338k(Service.State.STOPPING);
                    f();
                } else {
                    this.g = new C5338k(Service.State.RUNNING);
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
            switch (C5333f.a[state.ordinal()]) {
                case 1:
                case 5:
                case 6:
                    throw new IllegalStateException("Cannot notifyStopped() when the service is " + state);
                case 2:
                case 3:
                case 4:
                    this.g = new C5338k(Service.State.TERMINATED);
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
                this.g = new C5338k(Service.State.STARTING);
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
                switch (C5333f.a[state.ordinal()]) {
                    case 1:
                        this.g = new C5338k(Service.State.TERMINATED);
                        k(Service.State.NEW);
                        break;
                    case 2:
                        Service.State state2 = Service.State.STARTING;
                        this.g = new C5338k(state2, true, null);
                        j(state2);
                        d();
                        break;
                    case 3:
                        this.g = new C5338k(Service.State.STOPPING);
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
