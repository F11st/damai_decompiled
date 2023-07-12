package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.AbstractC4845j;
import com.google.common.base.C4834e;
import com.google.common.base.Equivalence;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.cache.LocalCache;
import com.google.errorprone.annotations.CheckReturnValue;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import tb.cf;
import tb.du1;
import tb.m8;

/* compiled from: Taobao */
@GwtCompatible(emulated = true)
/* loaded from: classes10.dex */
public final class CacheBuilder<K, V> {
    static final Supplier<? extends AbstractCache$StatsCounter> q = Suppliers.a(new C4847a());
    static final cf r = new cf(0, 0, 0, 0, 0, 0);
    static final AbstractC4845j s;
    private static final Logger t;
    @MonotonicNonNullDecl
    Weigher<? super K, ? super V> f;
    @MonotonicNonNullDecl
    LocalCache.Strength g;
    @MonotonicNonNullDecl
    LocalCache.Strength h;
    @MonotonicNonNullDecl
    Equivalence<Object> l;
    @MonotonicNonNullDecl
    Equivalence<Object> m;
    @MonotonicNonNullDecl
    RemovalListener<? super K, ? super V> n;
    @MonotonicNonNullDecl
    AbstractC4845j o;
    boolean a = true;
    int b = -1;
    int c = -1;
    long d = -1;
    long e = -1;
    long i = -1;
    long j = -1;
    long k = -1;
    Supplier<? extends AbstractCache$StatsCounter> p = q;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    enum NullListener implements RemovalListener<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.RemovalListener
        public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    enum OneWeigher implements Weigher<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.Weigher
        public int weigh(Object obj, Object obj2) {
            return 1;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.cache.CacheBuilder$a */
    /* loaded from: classes10.dex */
    static class C4847a implements AbstractCache$StatsCounter {
        C4847a() {
        }

        @Override // com.google.common.cache.AbstractCache$StatsCounter
        public void recordEviction() {
        }

        @Override // com.google.common.cache.AbstractCache$StatsCounter
        public void recordHits(int i) {
        }

        @Override // com.google.common.cache.AbstractCache$StatsCounter
        public void recordLoadException(long j) {
        }

        @Override // com.google.common.cache.AbstractCache$StatsCounter
        public void recordLoadSuccess(long j) {
        }

        @Override // com.google.common.cache.AbstractCache$StatsCounter
        public void recordMisses(int i) {
        }

        @Override // com.google.common.cache.AbstractCache$StatsCounter
        public cf snapshot() {
            return CacheBuilder.r;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.cache.CacheBuilder$b */
    /* loaded from: classes10.dex */
    static class C4848b implements Supplier<AbstractCache$StatsCounter> {
        C4848b() {
        }

        @Override // com.google.common.base.Supplier
        /* renamed from: a */
        public AbstractCache$StatsCounter get() {
            return new C4891a();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.cache.CacheBuilder$c */
    /* loaded from: classes10.dex */
    static class C4849c extends AbstractC4845j {
        C4849c() {
        }

        @Override // com.google.common.base.AbstractC4845j
        public long a() {
            return 0L;
        }
    }

    static {
        new C4848b();
        s = new C4849c();
        t = Logger.getLogger(CacheBuilder.class.getName());
    }

    private CacheBuilder() {
    }

    private void c() {
        du1.x(this.k == -1, "refreshAfterWrite requires a LoadingCache");
    }

    private void d() {
        if (this.f == null) {
            du1.x(this.e == -1, "maximumWeight requires weigher");
        } else if (this.a) {
            du1.x(this.e != -1, "weigher requires maximumWeight");
        } else if (this.e == -1) {
            t.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
    }

    public static CacheBuilder<Object, Object> y() {
        return new CacheBuilder<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CacheBuilder<K, V> A(LocalCache.Strength strength) {
        LocalCache.Strength strength2 = this.g;
        du1.A(strength2 == null, "Key strength was already set to %s", strength2);
        this.g = (LocalCache.Strength) du1.p(strength);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CacheBuilder<K, V> B(LocalCache.Strength strength) {
        LocalCache.Strength strength2 = this.h;
        du1.A(strength2 == null, "Value strength was already set to %s", strength2);
        this.h = (LocalCache.Strength) du1.p(strength);
        return this;
    }

    public CacheBuilder<K, V> C(AbstractC4845j abstractC4845j) {
        du1.w(this.o == null);
        this.o = (AbstractC4845j) du1.p(abstractC4845j);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GwtIncompatible
    public CacheBuilder<K, V> D(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.m;
        du1.A(equivalence2 == null, "value equivalence was already set to %s", equivalence2);
        this.m = (Equivalence) du1.p(equivalence);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> E(Weigher<? super K1, ? super V1> weigher) {
        du1.w(this.f == null);
        if (this.a) {
            long j = this.d;
            du1.z(j == -1, "weigher can not be combined with maximum size", j);
        }
        this.f = (Weigher) du1.p(weigher);
        return this;
    }

    public <K1 extends K, V1 extends V> Cache<K1, V1> a() {
        d();
        c();
        return new LocalCache.LocalManualCache(this);
    }

    public <K1 extends K, V1 extends V> LoadingCache<K1, V1> b(CacheLoader<? super K1, V1> cacheLoader) {
        d();
        return new LocalCache.LocalLoadingCache(this, cacheLoader);
    }

    public CacheBuilder<K, V> e(int i) {
        int i2 = this.c;
        du1.y(i2 == -1, "concurrency level was already set to %s", i2);
        du1.d(i > 0);
        this.c = i;
        return this;
    }

    public CacheBuilder<K, V> f(long j, TimeUnit timeUnit) {
        long j2 = this.j;
        du1.z(j2 == -1, "expireAfterAccess was already set to %s ns", j2);
        du1.j(j >= 0, "duration cannot be negative: %s %s", j, timeUnit);
        this.j = timeUnit.toNanos(j);
        return this;
    }

    public CacheBuilder<K, V> g(long j, TimeUnit timeUnit) {
        long j2 = this.i;
        du1.z(j2 == -1, "expireAfterWrite was already set to %s ns", j2);
        du1.j(j >= 0, "duration cannot be negative: %s %s", j, timeUnit);
        this.i = timeUnit.toNanos(j);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        int i = this.c;
        if (i == -1) {
            return 4;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long i() {
        long j = this.j;
        if (j == -1) {
            return 0L;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long j() {
        long j = this.i;
        if (j == -1) {
            return 0L;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        int i = this.b;
        if (i == -1) {
            return 16;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Equivalence<Object> l() {
        return (Equivalence) C4834e.a(this.l, m().defaultEquivalence());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalCache.Strength m() {
        return (LocalCache.Strength) C4834e.a(this.g, LocalCache.Strength.STRONG);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long n() {
        if (this.i == 0 || this.j == 0) {
            return 0L;
        }
        return this.f == null ? this.d : this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long o() {
        long j = this.k;
        if (j == -1) {
            return 0L;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <K1 extends K, V1 extends V> RemovalListener<K1, V1> p() {
        return (RemovalListener) C4834e.a(this.n, NullListener.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Supplier<? extends AbstractCache$StatsCounter> q() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC4845j r(boolean z) {
        AbstractC4845j abstractC4845j = this.o;
        return abstractC4845j != null ? abstractC4845j : z ? AbstractC4845j.b() : s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Equivalence<Object> s() {
        return (Equivalence) C4834e.a(this.m, t().defaultEquivalence());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalCache.Strength t() {
        return (LocalCache.Strength) C4834e.a(this.h, LocalCache.Strength.STRONG);
    }

    public String toString() {
        C4834e.C4836b b = C4834e.b(this);
        int i = this.b;
        if (i != -1) {
            b.b("initialCapacity", i);
        }
        int i2 = this.c;
        if (i2 != -1) {
            b.b("concurrencyLevel", i2);
        }
        long j = this.d;
        if (j != -1) {
            b.c("maximumSize", j);
        }
        long j2 = this.e;
        if (j2 != -1) {
            b.c("maximumWeight", j2);
        }
        if (this.i != -1) {
            b.d("expireAfterWrite", this.i + NotificationStyle.NOTIFICATION_STYLE);
        }
        if (this.j != -1) {
            b.d("expireAfterAccess", this.j + NotificationStyle.NOTIFICATION_STYLE);
        }
        LocalCache.Strength strength = this.g;
        if (strength != null) {
            b.d("keyStrength", m8.c(strength.toString()));
        }
        LocalCache.Strength strength2 = this.h;
        if (strength2 != null) {
            b.d("valueStrength", m8.c(strength2.toString()));
        }
        if (this.l != null) {
            b.h("keyEquivalence");
        }
        if (this.m != null) {
            b.h("valueEquivalence");
        }
        if (this.n != null) {
            b.h("removalListener");
        }
        return b.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <K1 extends K, V1 extends V> Weigher<K1, V1> u() {
        return (Weigher) C4834e.a(this.f, OneWeigher.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GwtIncompatible
    public CacheBuilder<K, V> v(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.l;
        du1.A(equivalence2 == null, "key equivalence was already set to %s", equivalence2);
        this.l = (Equivalence) du1.p(equivalence);
        return this;
    }

    public CacheBuilder<K, V> w(long j) {
        long j2 = this.d;
        du1.z(j2 == -1, "maximum size was already set to %s", j2);
        long j3 = this.e;
        du1.z(j3 == -1, "maximum weight was already set to %s", j3);
        du1.x(this.f == null, "maximum size can not be combined with weigher");
        du1.e(j >= 0, "maximum size must not be negative");
        this.d = j;
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> x(long j) {
        long j2 = this.e;
        du1.z(j2 == -1, "maximum weight was already set to %s", j2);
        long j3 = this.d;
        du1.z(j3 == -1, "maximum size was already set to %s", j3);
        this.e = j;
        du1.e(j >= 0, "maximum weight must not be negative");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckReturnValue
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> z(RemovalListener<? super K1, ? super V1> removalListener) {
        du1.w(this.n == null);
        this.n = (RemovalListener) du1.p(removalListener);
        return this;
    }
}
