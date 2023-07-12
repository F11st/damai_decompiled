package com.google.common.collect;

import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.C4834e;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;

/* compiled from: Taobao */
@GwtCompatible(emulated = true)
/* loaded from: classes10.dex */
public final class TreeMultiset<E> extends AbstractC5177g<E> implements Serializable {
    @GwtIncompatible
    private static final long serialVersionUID = 1;
    private final transient C5138e<E> header;
    private final transient GeneralRange<E> range;
    private final transient C5139f<C5138e<E>> rootReference;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum Aggregate {
        SIZE { // from class: com.google.common.collect.TreeMultiset.Aggregate.1
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            int nodeAggregate(C5138e<?> c5138e) {
                return ((C5138e) c5138e).b;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            long treeAggregate(@NullableDecl C5138e<?> c5138e) {
                if (c5138e == null) {
                    return 0L;
                }
                return ((C5138e) c5138e).d;
            }
        },
        DISTINCT { // from class: com.google.common.collect.TreeMultiset.Aggregate.2
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            int nodeAggregate(C5138e<?> c5138e) {
                return 1;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            long treeAggregate(@NullableDecl C5138e<?> c5138e) {
                if (c5138e == null) {
                    return 0L;
                }
                return ((C5138e) c5138e).c;
            }
        };

        abstract int nodeAggregate(C5138e<?> c5138e);

        abstract long treeAggregate(@NullableDecl C5138e<?> c5138e);

        /* synthetic */ Aggregate(C5134a c5134a) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.TreeMultiset$a */
    /* loaded from: classes10.dex */
    public class C5134a extends Multisets.AbstractC5082b<E> {
        final /* synthetic */ C5138e a;

        C5134a(C5138e c5138e) {
            this.a = c5138e;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int getCount() {
            int x = this.a.x();
            return x == 0 ? TreeMultiset.this.count(getElement()) : x;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public E getElement() {
            return (E) this.a.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.TreeMultiset$b */
    /* loaded from: classes10.dex */
    public class C5135b implements Iterator<Multiset.Entry<E>> {
        C5138e<E> a;
        @NullableDecl
        Multiset.Entry<E> b;

        C5135b() {
            this.a = TreeMultiset.this.firstNode();
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public Multiset.Entry<E> next() {
            if (hasNext()) {
                Multiset.Entry<E> wrapEntry = TreeMultiset.this.wrapEntry(this.a);
                this.b = wrapEntry;
                if (((C5138e) this.a).i != TreeMultiset.this.header) {
                    this.a = ((C5138e) this.a).i;
                } else {
                    this.a = null;
                }
                return wrapEntry;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.a == null) {
                return false;
            }
            if (TreeMultiset.this.range.tooHigh(this.a.y())) {
                this.a = null;
                return false;
            }
            return true;
        }

        @Override // java.util.Iterator
        public void remove() {
            C5191k.e(this.b != null);
            TreeMultiset.this.setCount(this.b.getElement(), 0);
            this.b = null;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.TreeMultiset$c */
    /* loaded from: classes10.dex */
    class C5136c implements Iterator<Multiset.Entry<E>> {
        C5138e<E> a;
        Multiset.Entry<E> b = null;

        C5136c() {
            this.a = TreeMultiset.this.lastNode();
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public Multiset.Entry<E> next() {
            if (hasNext()) {
                Multiset.Entry<E> wrapEntry = TreeMultiset.this.wrapEntry(this.a);
                this.b = wrapEntry;
                if (((C5138e) this.a).h != TreeMultiset.this.header) {
                    this.a = ((C5138e) this.a).h;
                } else {
                    this.a = null;
                }
                return wrapEntry;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.a == null) {
                return false;
            }
            if (TreeMultiset.this.range.tooLow(this.a.y())) {
                this.a = null;
                return false;
            }
            return true;
        }

        @Override // java.util.Iterator
        public void remove() {
            C5191k.e(this.b != null);
            TreeMultiset.this.setCount(this.b.getElement(), 0);
            this.b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.TreeMultiset$d */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class C5137d {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BoundType.values().length];
            a = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.TreeMultiset$e */
    /* loaded from: classes10.dex */
    public static final class C5138e<E> {
        @NullableDecl
        private final E a;
        private int b;
        private int c;
        private long d;
        private int e;
        @NullableDecl
        private C5138e<E> f;
        @NullableDecl
        private C5138e<E> g;
        @NullableDecl
        private C5138e<E> h;
        @NullableDecl
        private C5138e<E> i;

        C5138e(@NullableDecl E e, int i) {
            du1.d(i > 0);
            this.a = e;
            this.b = i;
            this.d = i;
            this.c = 1;
            this.e = 1;
            this.f = null;
            this.g = null;
        }

        private C5138e<E> A() {
            int s = s();
            if (s == -2) {
                if (this.g.s() > 0) {
                    this.g = this.g.I();
                }
                return H();
            } else if (s != 2) {
                C();
                return this;
            } else {
                if (this.f.s() < 0) {
                    this.f = this.f.H();
                }
                return I();
            }
        }

        private void B() {
            D();
            C();
        }

        private void C() {
            this.e = Math.max(z(this.f), z(this.g)) + 1;
        }

        private void D() {
            this.c = TreeMultiset.distinctElements(this.f) + 1 + TreeMultiset.distinctElements(this.g);
            this.d = this.b + L(this.f) + L(this.g);
        }

        private C5138e<E> F(C5138e<E> c5138e) {
            C5138e<E> c5138e2 = this.g;
            if (c5138e2 == null) {
                return this.f;
            }
            this.g = c5138e2.F(c5138e);
            this.c--;
            this.d -= c5138e.b;
            return A();
        }

        private C5138e<E> G(C5138e<E> c5138e) {
            C5138e<E> c5138e2 = this.f;
            if (c5138e2 == null) {
                return this.g;
            }
            this.f = c5138e2.G(c5138e);
            this.c--;
            this.d -= c5138e.b;
            return A();
        }

        private C5138e<E> H() {
            du1.w(this.g != null);
            C5138e<E> c5138e = this.g;
            this.g = c5138e.f;
            c5138e.f = this;
            c5138e.d = this.d;
            c5138e.c = this.c;
            B();
            c5138e.C();
            return c5138e;
        }

        private C5138e<E> I() {
            du1.w(this.f != null);
            C5138e<E> c5138e = this.f;
            this.f = c5138e.g;
            c5138e.g = this;
            c5138e.d = this.d;
            c5138e.c = this.c;
            B();
            c5138e.C();
            return c5138e;
        }

        private static long L(@NullableDecl C5138e<?> c5138e) {
            if (c5138e == null) {
                return 0L;
            }
            return ((C5138e) c5138e).d;
        }

        private C5138e<E> q(E e, int i) {
            C5138e<E> c5138e = new C5138e<>(e, i);
            this.f = c5138e;
            TreeMultiset.successor(this.h, c5138e, this);
            this.e = Math.max(2, this.e);
            this.c++;
            this.d += i;
            return this;
        }

        private C5138e<E> r(E e, int i) {
            C5138e<E> c5138e = new C5138e<>(e, i);
            this.g = c5138e;
            TreeMultiset.successor(this, c5138e, this.i);
            this.e = Math.max(2, this.e);
            this.c++;
            this.d += i;
            return this;
        }

        private int s() {
            return z(this.f) - z(this.g);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        @NullableDecl
        public C5138e<E> t(Comparator<? super E> comparator, E e) {
            int compare = comparator.compare(e, (E) this.a);
            if (compare < 0) {
                C5138e<E> c5138e = this.f;
                return c5138e == null ? this : (C5138e) C4834e.a(c5138e.t(comparator, e), this);
            } else if (compare == 0) {
                return this;
            } else {
                C5138e<E> c5138e2 = this.g;
                if (c5138e2 == null) {
                    return null;
                }
                return c5138e2.t(comparator, e);
            }
        }

        private C5138e<E> v() {
            int i = this.b;
            this.b = 0;
            TreeMultiset.successor(this.h, this.i);
            C5138e<E> c5138e = this.f;
            if (c5138e == null) {
                return this.g;
            }
            C5138e<E> c5138e2 = this.g;
            if (c5138e2 == null) {
                return c5138e;
            }
            if (c5138e.e >= c5138e2.e) {
                C5138e<E> c5138e3 = this.h;
                c5138e3.f = c5138e.F(c5138e3);
                c5138e3.g = this.g;
                c5138e3.c = this.c - 1;
                c5138e3.d = this.d - i;
                return c5138e3.A();
            }
            C5138e<E> c5138e4 = this.i;
            c5138e4.g = c5138e2.G(c5138e4);
            c5138e4.f = this.f;
            c5138e4.c = this.c - 1;
            c5138e4.d = this.d - i;
            return c5138e4.A();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        @NullableDecl
        public C5138e<E> w(Comparator<? super E> comparator, E e) {
            int compare = comparator.compare(e, (E) this.a);
            if (compare > 0) {
                C5138e<E> c5138e = this.g;
                return c5138e == null ? this : (C5138e) C4834e.a(c5138e.w(comparator, e), this);
            } else if (compare == 0) {
                return this;
            } else {
                C5138e<E> c5138e2 = this.f;
                if (c5138e2 == null) {
                    return null;
                }
                return c5138e2.w(comparator, e);
            }
        }

        private static int z(@NullableDecl C5138e<?> c5138e) {
            if (c5138e == null) {
                return 0;
            }
            return ((C5138e) c5138e).e;
        }

        /* JADX WARN: Multi-variable type inference failed */
        C5138e<E> E(Comparator<? super E> comparator, @NullableDecl E e, int i, int[] iArr) {
            int compare = comparator.compare(e, (E) this.a);
            if (compare < 0) {
                C5138e<E> c5138e = this.f;
                if (c5138e == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f = c5138e.E(comparator, e, i, iArr);
                if (iArr[0] > 0) {
                    if (i >= iArr[0]) {
                        this.c--;
                        this.d -= iArr[0];
                    } else {
                        this.d -= i;
                    }
                }
                return iArr[0] == 0 ? this : A();
            } else if (compare > 0) {
                C5138e<E> c5138e2 = this.g;
                if (c5138e2 == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.g = c5138e2.E(comparator, e, i, iArr);
                if (iArr[0] > 0) {
                    if (i >= iArr[0]) {
                        this.c--;
                        this.d -= iArr[0];
                    } else {
                        this.d -= i;
                    }
                }
                return A();
            } else {
                int i2 = this.b;
                iArr[0] = i2;
                if (i >= i2) {
                    return v();
                }
                this.b = i2 - i;
                this.d -= i;
                return this;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        C5138e<E> J(Comparator<? super E> comparator, @NullableDecl E e, int i, int i2, int[] iArr) {
            int compare = comparator.compare(e, (E) this.a);
            if (compare < 0) {
                C5138e<E> c5138e = this.f;
                if (c5138e == null) {
                    iArr[0] = 0;
                    return (i != 0 || i2 <= 0) ? this : q(e, i2);
                }
                this.f = c5138e.J(comparator, e, i, i2, iArr);
                if (iArr[0] == i) {
                    if (i2 == 0 && iArr[0] != 0) {
                        this.c--;
                    } else if (i2 > 0 && iArr[0] == 0) {
                        this.c++;
                    }
                    this.d += i2 - iArr[0];
                }
                return A();
            } else if (compare > 0) {
                C5138e<E> c5138e2 = this.g;
                if (c5138e2 == null) {
                    iArr[0] = 0;
                    return (i != 0 || i2 <= 0) ? this : r(e, i2);
                }
                this.g = c5138e2.J(comparator, e, i, i2, iArr);
                if (iArr[0] == i) {
                    if (i2 == 0 && iArr[0] != 0) {
                        this.c--;
                    } else if (i2 > 0 && iArr[0] == 0) {
                        this.c++;
                    }
                    this.d += i2 - iArr[0];
                }
                return A();
            } else {
                int i3 = this.b;
                iArr[0] = i3;
                if (i == i3) {
                    if (i2 == 0) {
                        return v();
                    }
                    this.d += i2 - i3;
                    this.b = i2;
                }
                return this;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        C5138e<E> K(Comparator<? super E> comparator, @NullableDecl E e, int i, int[] iArr) {
            int i2;
            int compare = comparator.compare(e, (E) this.a);
            if (compare < 0) {
                C5138e<E> c5138e = this.f;
                if (c5138e == null) {
                    iArr[0] = 0;
                    return i > 0 ? q(e, i) : this;
                }
                this.f = c5138e.K(comparator, e, i, iArr);
                if (i == 0 && iArr[0] != 0) {
                    this.c--;
                } else if (i > 0 && iArr[0] == 0) {
                    this.c++;
                }
                this.d += i - iArr[0];
                return A();
            } else if (compare > 0) {
                C5138e<E> c5138e2 = this.g;
                if (c5138e2 == null) {
                    iArr[0] = 0;
                    return i > 0 ? r(e, i) : this;
                }
                this.g = c5138e2.K(comparator, e, i, iArr);
                if (i == 0 && iArr[0] != 0) {
                    this.c--;
                } else if (i > 0 && iArr[0] == 0) {
                    this.c++;
                }
                this.d += i - iArr[0];
                return A();
            } else {
                iArr[0] = this.b;
                if (i == 0) {
                    return v();
                }
                this.d += i - i2;
                this.b = i;
                return this;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        C5138e<E> p(Comparator<? super E> comparator, @NullableDecl E e, int i, int[] iArr) {
            int compare = comparator.compare(e, (E) this.a);
            if (compare < 0) {
                C5138e<E> c5138e = this.f;
                if (c5138e == null) {
                    iArr[0] = 0;
                    return q(e, i);
                }
                int i2 = c5138e.e;
                C5138e<E> p = c5138e.p(comparator, e, i, iArr);
                this.f = p;
                if (iArr[0] == 0) {
                    this.c++;
                }
                this.d += i;
                return p.e == i2 ? this : A();
            } else if (compare > 0) {
                C5138e<E> c5138e2 = this.g;
                if (c5138e2 == null) {
                    iArr[0] = 0;
                    return r(e, i);
                }
                int i3 = c5138e2.e;
                C5138e<E> p2 = c5138e2.p(comparator, e, i, iArr);
                this.g = p2;
                if (iArr[0] == 0) {
                    this.c++;
                }
                this.d += i;
                return p2.e == i3 ? this : A();
            } else {
                int i4 = this.b;
                iArr[0] = i4;
                long j = i;
                du1.d(((long) i4) + j <= 2147483647L);
                this.b += i;
                this.d += j;
                return this;
            }
        }

        public String toString() {
            return Multisets.g(y(), x()).toString();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int u(Comparator<? super E> comparator, E e) {
            int compare = comparator.compare(e, (E) this.a);
            if (compare < 0) {
                C5138e<E> c5138e = this.f;
                if (c5138e == null) {
                    return 0;
                }
                return c5138e.u(comparator, e);
            } else if (compare > 0) {
                C5138e<E> c5138e2 = this.g;
                if (c5138e2 == null) {
                    return 0;
                }
                return c5138e2.u(comparator, e);
            } else {
                return this.b;
            }
        }

        int x() {
            return this.b;
        }

        E y() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.TreeMultiset$f */
    /* loaded from: classes10.dex */
    public static final class C5139f<T> {
        @NullableDecl
        private T a;

        private C5139f() {
        }

        public void a(@NullableDecl T t, T t2) {
            if (this.a == t) {
                this.a = t2;
                return;
            }
            throw new ConcurrentModificationException();
        }

        void b() {
            this.a = null;
        }

        @NullableDecl
        public T c() {
            return this.a;
        }

        /* synthetic */ C5139f(C5134a c5134a) {
            this();
        }
    }

    TreeMultiset(C5139f<C5138e<E>> c5139f, GeneralRange<E> generalRange, C5138e<E> c5138e) {
        super(generalRange.comparator());
        this.rootReference = c5139f;
        this.range = generalRange;
        this.header = c5138e;
    }

    private long aggregateAboveRange(Aggregate aggregate, @NullableDecl C5138e<E> c5138e) {
        long treeAggregate;
        long aggregateAboveRange;
        if (c5138e == null) {
            return 0L;
        }
        int compare = comparator().compare(this.range.getUpperEndpoint(), ((C5138e) c5138e).a);
        if (compare > 0) {
            return aggregateAboveRange(aggregate, ((C5138e) c5138e).g);
        }
        if (compare == 0) {
            int i = C5137d.a[this.range.getUpperBoundType().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return aggregate.treeAggregate(((C5138e) c5138e).g);
                }
                throw new AssertionError();
            }
            treeAggregate = aggregate.nodeAggregate(c5138e);
            aggregateAboveRange = aggregate.treeAggregate(((C5138e) c5138e).g);
        } else {
            treeAggregate = aggregate.treeAggregate(((C5138e) c5138e).g) + aggregate.nodeAggregate(c5138e);
            aggregateAboveRange = aggregateAboveRange(aggregate, ((C5138e) c5138e).f);
        }
        return treeAggregate + aggregateAboveRange;
    }

    private long aggregateBelowRange(Aggregate aggregate, @NullableDecl C5138e<E> c5138e) {
        long treeAggregate;
        long aggregateBelowRange;
        if (c5138e == null) {
            return 0L;
        }
        int compare = comparator().compare(this.range.getLowerEndpoint(), ((C5138e) c5138e).a);
        if (compare < 0) {
            return aggregateBelowRange(aggregate, ((C5138e) c5138e).f);
        }
        if (compare == 0) {
            int i = C5137d.a[this.range.getLowerBoundType().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return aggregate.treeAggregate(((C5138e) c5138e).f);
                }
                throw new AssertionError();
            }
            treeAggregate = aggregate.nodeAggregate(c5138e);
            aggregateBelowRange = aggregate.treeAggregate(((C5138e) c5138e).f);
        } else {
            treeAggregate = aggregate.treeAggregate(((C5138e) c5138e).f) + aggregate.nodeAggregate(c5138e);
            aggregateBelowRange = aggregateBelowRange(aggregate, ((C5138e) c5138e).g);
        }
        return treeAggregate + aggregateBelowRange;
    }

    private long aggregateForEntries(Aggregate aggregate) {
        C5138e<E> c = this.rootReference.c();
        long treeAggregate = aggregate.treeAggregate(c);
        if (this.range.hasLowerBound()) {
            treeAggregate -= aggregateBelowRange(aggregate, c);
        }
        return this.range.hasUpperBound() ? treeAggregate - aggregateAboveRange(aggregate, c) : treeAggregate;
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset<>(Ordering.natural());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NullableDecl
    public C5138e<E> firstNode() {
        C5138e<E> c5138e;
        if (this.rootReference.c() == null) {
            return null;
        }
        if (!this.range.hasLowerBound()) {
            c5138e = ((C5138e) this.header).i;
        } else {
            E lowerEndpoint = this.range.getLowerEndpoint();
            c5138e = this.rootReference.c().t(comparator(), lowerEndpoint);
            if (c5138e == null) {
                return null;
            }
            if (this.range.getLowerBoundType() == BoundType.OPEN && comparator().compare(lowerEndpoint, c5138e.y()) == 0) {
                c5138e = ((C5138e) c5138e).i;
            }
        }
        if (c5138e == this.header || !this.range.contains(c5138e.y())) {
            return null;
        }
        return c5138e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NullableDecl
    public C5138e<E> lastNode() {
        C5138e<E> c5138e;
        if (this.rootReference.c() == null) {
            return null;
        }
        if (!this.range.hasUpperBound()) {
            c5138e = ((C5138e) this.header).h;
        } else {
            E upperEndpoint = this.range.getUpperEndpoint();
            c5138e = this.rootReference.c().w(comparator(), upperEndpoint);
            if (c5138e == null) {
                return null;
            }
            if (this.range.getUpperBoundType() == BoundType.OPEN && comparator().compare(upperEndpoint, c5138e.y()) == 0) {
                c5138e = ((C5138e) c5138e).h;
            }
        }
        if (c5138e == this.header || !this.range.contains(c5138e.y())) {
            return null;
        }
        return c5138e;
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        C5174f0.a(AbstractC5177g.class, "comparator").b(this, comparator);
        C5174f0.a(TreeMultiset.class, "range").b(this, GeneralRange.all(comparator));
        C5174f0.a(TreeMultiset.class, "rootReference").b(this, new C5139f(null));
        C5138e c5138e = new C5138e(null, 1);
        C5174f0.a(TreeMultiset.class, "header").b(this, c5138e);
        successor(c5138e, c5138e);
        C5174f0.f(this, objectInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void successor(C5138e<T> c5138e, C5138e<T> c5138e2) {
        ((C5138e) c5138e).i = c5138e2;
        ((C5138e) c5138e2).h = c5138e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Multiset.Entry<E> wrapEntry(C5138e<E> c5138e) {
        return new C5134a(c5138e);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(elementSet().comparator());
        C5174f0.k(this, objectOutputStream);
    }

    @Override // com.google.common.collect.AbstractC5165d, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int add(@NullableDecl E e, int i) {
        C5191k.b(i, "occurrences");
        if (i == 0) {
            return count(e);
        }
        du1.d(this.range.contains(e));
        C5138e<E> c = this.rootReference.c();
        if (c == null) {
            comparator().compare(e, e);
            C5138e<E> c5138e = new C5138e<>(e, i);
            C5138e<E> c5138e2 = this.header;
            successor(c5138e2, c5138e, c5138e2);
            this.rootReference.a(c, c5138e);
            return 0;
        }
        int[] iArr = new int[1];
        this.rootReference.a(c, c.p(comparator(), e, i, iArr));
        return iArr[0];
    }

    @Override // com.google.common.collect.AbstractC5165d, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        if (!this.range.hasLowerBound() && !this.range.hasUpperBound()) {
            C5138e<E> c5138e = ((C5138e) this.header).i;
            while (true) {
                C5138e<E> c5138e2 = this.header;
                if (c5138e != c5138e2) {
                    C5138e<E> c5138e3 = ((C5138e) c5138e).i;
                    ((C5138e) c5138e).b = 0;
                    ((C5138e) c5138e).f = null;
                    ((C5138e) c5138e).g = null;
                    ((C5138e) c5138e).h = null;
                    ((C5138e) c5138e).i = null;
                    c5138e = c5138e3;
                } else {
                    successor(c5138e2, c5138e2);
                    this.rootReference.b();
                    return;
                }
            }
        } else {
            Iterators.d(entryIterator());
        }
    }

    @Override // com.google.common.collect.AbstractC5177g, com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // com.google.common.collect.AbstractC5165d, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@NullableDecl Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@NullableDecl Object obj) {
        try {
            C5138e<E> c = this.rootReference.c();
            if (this.range.contains(obj) && c != null) {
                return c.u(comparator(), obj);
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.AbstractC5177g
    Iterator<Multiset.Entry<E>> descendingEntryIterator() {
        return new C5136c();
    }

    @Override // com.google.common.collect.AbstractC5177g, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset descendingMultiset() {
        return super.descendingMultiset();
    }

    @Override // com.google.common.collect.AbstractC5165d
    int distinctElements() {
        return Ints.j(aggregateForEntries(Aggregate.DISTINCT));
    }

    @Override // com.google.common.collect.AbstractC5165d
    Iterator<E> elementIterator() {
        return Multisets.e(entryIterator());
    }

    @Override // com.google.common.collect.AbstractC5177g, com.google.common.collect.AbstractC5165d, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractC5165d
    public Iterator<Multiset.Entry<E>> entryIterator() {
        return new C5135b();
    }

    @Override // com.google.common.collect.AbstractC5165d, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractC5177g, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry firstEntry() {
        return super.firstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> headMultiset(@NullableDecl E e, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.upTo(comparator(), e, boundType)), this.header);
    }

    @Override // com.google.common.collect.AbstractC5165d, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator<E> iterator() {
        return Multisets.i(this);
    }

    @Override // com.google.common.collect.AbstractC5177g, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry lastEntry() {
        return super.lastEntry();
    }

    @Override // com.google.common.collect.AbstractC5177g, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // com.google.common.collect.AbstractC5177g, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry pollLastEntry() {
        return super.pollLastEntry();
    }

    @Override // com.google.common.collect.AbstractC5165d, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(@NullableDecl Object obj, int i) {
        C5191k.b(i, "occurrences");
        if (i == 0) {
            return count(obj);
        }
        C5138e<E> c = this.rootReference.c();
        int[] iArr = new int[1];
        try {
            if (this.range.contains(obj) && c != null) {
                this.rootReference.a(c, c.E(comparator(), obj, i, iArr));
                return iArr[0];
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.AbstractC5165d, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int setCount(@NullableDecl E e, int i) {
        C5191k.b(i, AdUtConstants.XAD_UT_ARG_COUNT);
        if (!this.range.contains(e)) {
            du1.d(i == 0);
            return 0;
        }
        C5138e<E> c = this.rootReference.c();
        if (c == null) {
            if (i > 0) {
                add(e, i);
            }
            return 0;
        }
        int[] iArr = new int[1];
        this.rootReference.a(c, c.K(comparator(), e, i, iArr));
        return iArr[0];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return Ints.j(aggregateForEntries(Aggregate.SIZE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractC5177g, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset subMultiset(@NullableDecl Object obj, BoundType boundType, @NullableDecl Object obj2, BoundType boundType2) {
        return super.subMultiset(obj, boundType, obj2, boundType2);
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> tailMultiset(@NullableDecl E e, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.downTo(comparator(), e, boundType)), this.header);
    }

    public static <E> TreeMultiset<E> create(@NullableDecl Comparator<? super E> comparator) {
        return comparator == null ? new TreeMultiset<>(Ordering.natural()) : new TreeMultiset<>(comparator);
    }

    static int distinctElements(@NullableDecl C5138e<?> c5138e) {
        if (c5138e == null) {
            return 0;
        }
        return ((C5138e) c5138e).c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void successor(C5138e<T> c5138e, C5138e<T> c5138e2, C5138e<T> c5138e3) {
        successor(c5138e, c5138e2);
        successor(c5138e2, c5138e3);
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> iterable) {
        TreeMultiset<E> create = create();
        C5152a0.a(create, iterable);
        return create;
    }

    TreeMultiset(Comparator<? super E> comparator) {
        super(comparator);
        this.range = GeneralRange.all(comparator);
        C5138e<E> c5138e = new C5138e<>(null, 1);
        this.header = c5138e;
        successor(c5138e, c5138e);
        this.rootReference = new C5139f<>(null);
    }

    @Override // com.google.common.collect.AbstractC5165d, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public boolean setCount(@NullableDecl E e, int i, int i2) {
        C5191k.b(i2, "newCount");
        C5191k.b(i, "oldCount");
        du1.d(this.range.contains(e));
        C5138e<E> c = this.rootReference.c();
        if (c != null) {
            int[] iArr = new int[1];
            this.rootReference.a(c, c.J(comparator(), e, i, i2, iArr));
            return iArr[0] == i;
        } else if (i == 0) {
            if (i2 > 0) {
                add(e, i2);
            }
            return true;
        } else {
            return false;
        }
    }
}
