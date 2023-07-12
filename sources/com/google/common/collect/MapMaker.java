package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.C4834e;
import com.google.common.base.Equivalence;
import com.google.common.collect.MapMakerInternalMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import tb.du1;
import tb.m8;

/* compiled from: Taobao */
@GwtCompatible(emulated = true)
/* loaded from: classes10.dex */
public final class MapMaker {
    boolean a;
    int b = -1;
    int c = -1;
    @MonotonicNonNullDecl
    MapMakerInternalMap.Strength d;
    @MonotonicNonNullDecl
    MapMakerInternalMap.Strength e;
    @MonotonicNonNullDecl
    Equivalence<Object> f;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    enum Dummy {
        VALUE
    }

    @CanIgnoreReturnValue
    public MapMaker a(int i) {
        int i2 = this.c;
        du1.y(i2 == -1, "concurrency level was already set to %s", i2);
        du1.d(i > 0);
        this.c = i;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        int i = this.c;
        if (i == -1) {
            return 4;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        int i = this.b;
        if (i == -1) {
            return 16;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Equivalence<Object> d() {
        return (Equivalence) C4834e.a(this.f, e().defaultEquivalence());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapMakerInternalMap.Strength e() {
        return (MapMakerInternalMap.Strength) C4834e.a(this.d, MapMakerInternalMap.Strength.STRONG);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapMakerInternalMap.Strength f() {
        return (MapMakerInternalMap.Strength) C4834e.a(this.e, MapMakerInternalMap.Strength.STRONG);
    }

    @CanIgnoreReturnValue
    public MapMaker g(int i) {
        int i2 = this.b;
        du1.y(i2 == -1, "initial capacity was already set to %s", i2);
        du1.d(i >= 0);
        this.b = i;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    @GwtIncompatible
    public MapMaker h(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.f;
        du1.A(equivalence2 == null, "key equivalence was already set to %s", equivalence2);
        this.f = (Equivalence) du1.p(equivalence);
        this.a = true;
        return this;
    }

    public <K, V> ConcurrentMap<K, V> i() {
        if (!this.a) {
            return new ConcurrentHashMap(c(), 0.75f, b());
        }
        return MapMakerInternalMap.create(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapMaker j(MapMakerInternalMap.Strength strength) {
        MapMakerInternalMap.Strength strength2 = this.d;
        du1.A(strength2 == null, "Key strength was already set to %s", strength2);
        this.d = (MapMakerInternalMap.Strength) du1.p(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.a = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapMaker k(MapMakerInternalMap.Strength strength) {
        MapMakerInternalMap.Strength strength2 = this.e;
        du1.A(strength2 == null, "Value strength was already set to %s", strength2);
        this.e = (MapMakerInternalMap.Strength) du1.p(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.a = true;
        }
        return this;
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public MapMaker l() {
        return j(MapMakerInternalMap.Strength.WEAK);
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
        MapMakerInternalMap.Strength strength = this.d;
        if (strength != null) {
            b.d("keyStrength", m8.c(strength.toString()));
        }
        MapMakerInternalMap.Strength strength2 = this.e;
        if (strength2 != null) {
            b.d("valueStrength", m8.c(strength2.toString()));
        }
        if (this.f != null) {
            b.h("keyEquivalence");
        }
        return b.toString();
    }
}
