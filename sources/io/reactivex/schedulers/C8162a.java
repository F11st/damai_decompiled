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
/* renamed from: io.reactivex.schedulers.a */
/* loaded from: classes3.dex */
public final class C8162a {
    @NonNull
    static final Scheduler a = i42.h(new CallableC8170h());
    @NonNull
    static final Scheduler b = i42.e(new CallableC8164b());
    @NonNull
    static final Scheduler c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: io.reactivex.schedulers.a$a */
    /* loaded from: classes3.dex */
    public static final class C8163a {
        static final Scheduler a = new ComputationScheduler();
    }

    /* compiled from: Taobao */
    /* renamed from: io.reactivex.schedulers.a$b */
    /* loaded from: classes3.dex */
    static final class CallableC8164b implements Callable<Scheduler> {
        CallableC8164b() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Scheduler call() throws Exception {
            return C8163a.a;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: io.reactivex.schedulers.a$c */
    /* loaded from: classes3.dex */
    static final class CallableC8165c implements Callable<Scheduler> {
        CallableC8165c() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Scheduler call() throws Exception {
            return C8166d.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: io.reactivex.schedulers.a$d */
    /* loaded from: classes3.dex */
    public static final class C8166d {
        static final Scheduler a = new IoScheduler();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: io.reactivex.schedulers.a$e */
    /* loaded from: classes3.dex */
    public static final class C8167e {
        static final Scheduler a = new NewThreadScheduler();
    }

    /* compiled from: Taobao */
    /* renamed from: io.reactivex.schedulers.a$f */
    /* loaded from: classes3.dex */
    static final class CallableC8168f implements Callable<Scheduler> {
        CallableC8168f() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Scheduler call() throws Exception {
            return C8167e.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: io.reactivex.schedulers.a$g */
    /* loaded from: classes3.dex */
    public static final class C8169g {
        static final Scheduler a = new SingleScheduler();
    }

    /* compiled from: Taobao */
    /* renamed from: io.reactivex.schedulers.a$h */
    /* loaded from: classes3.dex */
    static final class CallableC8170h implements Callable<Scheduler> {
        CallableC8170h() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Scheduler call() throws Exception {
            return C8169g.a;
        }
    }

    static {
        i42.f(new CallableC8165c());
        c = TrampolineScheduler.instance();
        i42.g(new CallableC8168f());
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
