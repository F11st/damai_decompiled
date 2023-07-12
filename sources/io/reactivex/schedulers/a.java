package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.internal.schedulers.ComputationScheduler;
import io.reactivex.internal.schedulers.IoScheduler;
import io.reactivex.internal.schedulers.NewThreadScheduler;
import io.reactivex.internal.schedulers.SingleScheduler;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.Callable;
import tb.i42;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class a {
    @NonNull
    static final Scheduler a = i42.h(new h());
    @NonNull
    static final Scheduler b = i42.e(new b());
    @NonNull
    static final Scheduler c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: io.reactivex.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0408a {
        static final Scheduler a = new ComputationScheduler();
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class b implements Callable<Scheduler> {
        b() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Scheduler call() throws Exception {
            return C0408a.a;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class c implements Callable<Scheduler> {
        c() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Scheduler call() throws Exception {
            return d.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class d {
        static final Scheduler a = new IoScheduler();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class e {
        static final Scheduler a = new NewThreadScheduler();
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class f implements Callable<Scheduler> {
        f() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Scheduler call() throws Exception {
            return e.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class g {
        static final Scheduler a = new SingleScheduler();
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class h implements Callable<Scheduler> {
        h() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Scheduler call() throws Exception {
            return g.a;
        }
    }

    static {
        i42.f(new c());
        c = TrampolineScheduler.instance();
        i42.g(new f());
    }

    @NonNull
    public static Scheduler a() {
        return i42.t(b);
    }

    @NonNull
    public static Scheduler b() {
        return i42.w(a);
    }

    @NonNull
    public static Scheduler c() {
        return c;
    }
}
