package kotlinx.coroutines.debug.internal;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.KotlinNothingValueException;
import kotlin.collections.AbstractC8198c;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.bw0;
import tb.k50;
import tb.kj2;
import tb.ty1;
import tb.z1;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public final class ConcurrentWeakMap<K, V> extends z1<K, V> {
    private static final AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size");
    private volatile int _size;
    private final ReferenceQueue<K> a;
    volatile Object core;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$a */
    /* loaded from: classes9.dex */
    public final class C8650a {
        private static final AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(C8650a.class, "load");
        private final int a;
        private final int b;
        AtomicReferenceArray c;
        AtomicReferenceArray d;
        private final int e;
        private volatile int load = 0;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: Taobao */
        /* renamed from: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$a$a */
        /* loaded from: classes9.dex */
        public final class C8651a<E> implements Iterator<E>, KMutableIterator {
            private int a = -1;
            private K b;
            private V c;
            private final Function2<K, V, E> d;

            /* JADX WARN: Multi-variable type inference failed */
            public C8651a(@NotNull Function2<? super K, ? super V, ? extends E> function2) {
                this.d = function2;
                a();
            }

            private final void a() {
                K k;
                while (true) {
                    int i = this.a + 1;
                    this.a = i;
                    if (i >= C8650a.this.e) {
                        return;
                    }
                    bw0 bw0Var = (bw0) C8650a.this.c.get(this.a);
                    if (bw0Var != null && (k = (K) bw0Var.get()) != null) {
                        this.b = k;
                        V v = (V) C8650a.this.d.get(this.a);
                        if (v instanceof C8657c) {
                            v = (V) ((C8657c) v).a;
                        }
                        if (v != null) {
                            this.c = v;
                            return;
                        }
                    }
                }
            }

            @Override // java.util.Iterator
            @NotNull
            /* renamed from: b */
            public Void remove() {
                C8654a.e();
                throw new KotlinNothingValueException();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.a < C8650a.this.e;
            }

            @Override // java.util.Iterator
            public E next() {
                if (this.a < C8650a.this.e) {
                    Function2<K, V, E> function2 = this.d;
                    K k = this.b;
                    if (k == null) {
                        b41.A("key");
                    }
                    V v = this.c;
                    if (v == null) {
                        b41.A("value");
                    }
                    E invoke = function2.invoke(k, v);
                    a();
                    return invoke;
                }
                throw new NoSuchElementException();
            }
        }

        public C8650a(int i) {
            this.e = i;
            this.a = Integer.numberOfLeadingZeros(i) + 1;
            this.b = (i * 2) / 3;
            this.c = new AtomicReferenceArray(i);
            this.d = new AtomicReferenceArray(i);
        }

        private final int d(int i) {
            return (i * (-1640531527)) >>> this.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object g(C8650a c8650a, Object obj, Object obj2, bw0 bw0Var, int i, Object obj3) {
            if ((i & 4) != 0) {
                bw0Var = null;
            }
            return c8650a.f(obj, obj2, bw0Var);
        }

        private final void i(int i) {
            Object obj;
            do {
                obj = this.d.get(i);
                if (obj == null || (obj instanceof C8657c)) {
                    return;
                }
            } while (!this.d.compareAndSet(i, obj, null));
            ConcurrentWeakMap.this.h();
        }

        public final void b(@NotNull bw0<?> bw0Var) {
            int d = d(bw0Var.a);
            while (true) {
                bw0<?> bw0Var2 = (bw0) this.c.get(d);
                if (bw0Var2 == null) {
                    return;
                }
                if (bw0Var2 == bw0Var) {
                    i(d);
                    return;
                }
                if (d == 0) {
                    d = this.e;
                }
                d--;
            }
        }

        @Nullable
        public final V c(@NotNull K k) {
            int d = d(k.hashCode());
            while (true) {
                bw0 bw0Var = (bw0) this.c.get(d);
                if (bw0Var == null) {
                    return null;
                }
                T t = bw0Var.get();
                if (b41.d(k, t)) {
                    V v = (V) this.d.get(d);
                    return v instanceof C8657c ? (V) ((C8657c) v).a : v;
                }
                if (t == 0) {
                    i(d);
                }
                if (d == 0) {
                    d = this.e;
                }
                d--;
            }
        }

        @NotNull
        public final <E> Iterator<E> e(@NotNull Function2<? super K, ? super V, ? extends E> function2) {
            return new C8651a(function2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
            r6 = r5.d.get(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
            if ((r6 instanceof kotlinx.coroutines.debug.internal.C8657c) == false) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0060, code lost:
            r6 = kotlinx.coroutines.debug.internal.C8654a.a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
            return r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x006b, code lost:
            if (r5.d.compareAndSet(r0, r6, r7) == false) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
            return r6;
         */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object f(@org.jetbrains.annotations.NotNull K r6, @org.jetbrains.annotations.Nullable V r7, @org.jetbrains.annotations.Nullable tb.bw0<K> r8) {
            /*
                r5 = this;
                int r0 = r6.hashCode()
                int r0 = r5.d(r0)
                r1 = 0
            L9:
                java.util.concurrent.atomic.AtomicReferenceArray r2 = r5.c
                java.lang.Object r2 = r2.get(r0)
                tb.bw0 r2 = (tb.bw0) r2
                if (r2 != 0) goto L45
                r2 = 0
                if (r7 != 0) goto L17
                return r2
            L17:
                if (r1 != 0) goto L2f
            L19:
                int r1 = r5.load
                int r3 = r5.b
                if (r1 < r3) goto L24
                tb.kj2 r6 = kotlinx.coroutines.debug.internal.C8654a.a()
                return r6
            L24:
                int r3 = r1 + 1
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r4 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.C8650a.g
                boolean r1 = r4.compareAndSet(r5, r1, r3)
                if (r1 == 0) goto L19
                r1 = 1
            L2f:
                if (r8 != 0) goto L3c
                tb.bw0 r8 = new tb.bw0
                kotlinx.coroutines.debug.internal.ConcurrentWeakMap r3 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.this
                java.lang.ref.ReferenceQueue r3 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.f(r3)
                r8.<init>(r6, r3)
            L3c:
                java.util.concurrent.atomic.AtomicReferenceArray r3 = r5.c
                boolean r2 = r3.compareAndSet(r0, r2, r8)
                if (r2 == 0) goto L9
                goto L56
            L45:
                java.lang.Object r2 = r2.get()
                boolean r3 = tb.b41.d(r6, r2)
                if (r3 == 0) goto L6e
                if (r1 == 0) goto L56
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r6 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.C8650a.g
                r6.decrementAndGet(r5)
            L56:
                java.util.concurrent.atomic.AtomicReferenceArray r6 = r5.d
                java.lang.Object r6 = r6.get(r0)
                boolean r8 = r6 instanceof kotlinx.coroutines.debug.internal.C8657c
                if (r8 == 0) goto L65
                tb.kj2 r6 = kotlinx.coroutines.debug.internal.C8654a.a()
                return r6
            L65:
                java.util.concurrent.atomic.AtomicReferenceArray r8 = r5.d
                boolean r8 = r8.compareAndSet(r0, r6, r7)
                if (r8 == 0) goto L56
                return r6
            L6e:
                if (r2 != 0) goto L73
                r5.i(r0)
            L73:
                if (r0 != 0) goto L77
                int r0 = r5.e
            L77:
                int r0 = r0 + (-1)
                goto L9
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.ConcurrentWeakMap.C8650a.f(java.lang.Object, java.lang.Object, tb.bw0):java.lang.Object");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final ConcurrentWeakMap<K, V>.C8650a h() {
            int a;
            Object obj;
            kj2 kj2Var;
            C8657c d;
            while (true) {
                a = ty1.a(ConcurrentWeakMap.this.size(), 4);
                ConcurrentWeakMap<K, V>.C8650a c8650a = (ConcurrentWeakMap<K, V>.C8650a) new C8650a(Integer.highestOneBit(a) * 4);
                int i = this.e;
                for (int i2 = 0; i2 < i; i2++) {
                    bw0 bw0Var = (bw0) this.c.get(i2);
                    Object obj2 = bw0Var != null ? bw0Var.get() : null;
                    if (bw0Var != null && obj2 == null) {
                        i(i2);
                    }
                    while (true) {
                        obj = this.d.get(i2);
                        if (obj instanceof C8657c) {
                            obj = ((C8657c) obj).a;
                            break;
                        }
                        AtomicReferenceArray atomicReferenceArray = this.d;
                        d = C8654a.d(obj);
                        if (atomicReferenceArray.compareAndSet(i2, obj, d)) {
                            break;
                        }
                    }
                    if (obj2 != null && obj != null) {
                        Object f = c8650a.f(obj2, obj, bw0Var);
                        kj2Var = C8654a.a;
                        if (f == kj2Var) {
                            break;
                        }
                    }
                }
                return c8650a;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$b */
    /* loaded from: classes9.dex */
    public static final class C8652b<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
        private final K a;
        private final V b;

        public C8652b(K k, V v) {
            this.a = k;
            this.b = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            C8654a.e();
            throw new KotlinNothingValueException();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$c */
    /* loaded from: classes9.dex */
    private final class C8653c<E> extends AbstractC8198c<E> {
        private final Function2<K, V, E> a;

        /* JADX WARN: Multi-variable type inference failed */
        public C8653c(@NotNull Function2<? super K, ? super V, ? extends E> function2) {
            this.a = function2;
        }

        @Override // kotlin.collections.AbstractC8198c, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e) {
            C8654a.e();
            throw new KotlinNothingValueException();
        }

        @Override // kotlin.collections.AbstractC8198c
        public int getSize() {
            return ConcurrentWeakMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        @NotNull
        public Iterator<E> iterator() {
            return ((C8650a) ConcurrentWeakMap.this.core).e(this.a);
        }
    }

    public ConcurrentWeakMap() {
        this(false, 1, null);
    }

    public /* synthetic */ ConcurrentWeakMap(boolean z, int i, k50 k50Var) {
        this((i & 1) != 0 ? false : z);
    }

    private final void g(bw0<?> bw0Var) {
        ((C8650a) this.core).b(bw0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        b.decrementAndGet(this);
    }

    private final synchronized V i(K k, V v) {
        V v2;
        kj2 kj2Var;
        C8650a c8650a = (C8650a) this.core;
        while (true) {
            v2 = (V) C8650a.g(c8650a, k, v, null, 4, null);
            kj2Var = C8654a.a;
            if (v2 == kj2Var) {
                c8650a = c8650a.h();
                this.core = c8650a;
            }
        }
        return v2;
    }

    @Override // tb.z1
    @NotNull
    public Set<Map.Entry<K, V>> a() {
        return new C8653c(new Function2<K, V, Map.Entry<K, V>>() { // from class: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$entries$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((ConcurrentWeakMap$entries$1<K, V>) obj, obj2);
            }

            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final Map.Entry<K, V> invoke(@NotNull K k, @NotNull V v) {
                return new ConcurrentWeakMap.C8652b(k, v);
            }
        });
    }

    @Override // tb.z1
    @NotNull
    public Set<K> b() {
        return new C8653c(new Function2<K, V, K>() { // from class: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$keys$1
            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final K invoke(@NotNull K k, @NotNull V v) {
                return k;
            }
        });
    }

    @Override // tb.z1
    public int c() {
        return this._size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (K k : keySet()) {
            remove(k);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V get(@NotNull Object obj) {
        if (obj != null) {
            return (V) ((C8650a) this.core).c(obj);
        }
        return null;
    }

    public final void j() {
        if (!(this.a != null)) {
            throw new IllegalStateException("Must be created with weakRefQueue = true".toString());
        }
        while (true) {
            try {
                Reference<? extends K> remove = this.a.remove();
                if (remove == null) {
                    break;
                }
                g((bw0) remove);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
    }

    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V put(@NotNull K k, @NotNull V v) {
        kj2 kj2Var;
        V v2 = (V) C8650a.g((C8650a) this.core, k, v, null, 4, null);
        kj2Var = C8654a.a;
        if (v2 == kj2Var) {
            v2 = i(k, v);
        }
        if (v2 == null) {
            b.incrementAndGet(this);
        }
        return v2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V remove(@NotNull Object obj) {
        kj2 kj2Var;
        if (obj != 0) {
            V v = (V) C8650a.g((C8650a) this.core, obj, null, null, 4, null);
            kj2Var = C8654a.a;
            if (v == kj2Var) {
                v = i(obj, null);
            }
            if (v != null) {
                b.decrementAndGet(this);
            }
            return v;
        }
        return null;
    }

    public ConcurrentWeakMap(boolean z) {
        this._size = 0;
        this.core = new C8650a(16);
        this.a = z ? new ReferenceQueue<>() : null;
    }
}
