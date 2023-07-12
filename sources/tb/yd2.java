package tb;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.markers.KMutableIterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class yd2<T> extends AbstractSet<T> {
    @NotNull
    public static final b Companion = new b(null);
    @Nullable
    private Object a;
    private int b;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static final class a<T> implements Iterator<T>, KMutableIterator {
        @NotNull
        private final Iterator<T> a;

        public a(@NotNull T[] tArr) {
            b41.i(tArr, "array");
            this.a = r7.a(tArr);
        }

        @Override // java.util.Iterator
        @NotNull
        /* renamed from: a */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.a.next();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(k50 k50Var) {
            this();
        }

        @JvmStatic
        @NotNull
        public final <T> yd2<T> a() {
            return new yd2<>(null);
        }

        @JvmStatic
        @NotNull
        public final <T> yd2<T> b(@NotNull Collection<? extends T> collection) {
            b41.i(collection, "set");
            yd2<T> yd2Var = new yd2<>(null);
            yd2Var.addAll(collection);
            return yd2Var;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static final class c<T> implements Iterator<T>, KMutableIterator {
        private final T a;
        private boolean b = true;

        public c(T t) {
            this.a = t;
        }

        @Override // java.util.Iterator
        @NotNull
        /* renamed from: a */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.b) {
                this.b = false;
                return this.a;
            }
            throw new NoSuchElementException();
        }
    }

    private yd2() {
    }

    public /* synthetic */ yd2(k50 k50Var) {
        this();
    }

    @JvmStatic
    @NotNull
    public static final <T> yd2<T> a() {
        return Companion.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(T t) {
        boolean r;
        Object[] objArr;
        LinkedHashSet e;
        if (size() == 0) {
            this.a = t;
        } else if (size() == 1) {
            if (b41.d(this.a, t)) {
                return false;
            }
            this.a = new Object[]{this.a, t};
        } else if (size() < 5) {
            Object obj = this.a;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            Object[] objArr2 = (Object[]) obj;
            r = ArraysKt___ArraysKt.r(objArr2, t);
            if (r) {
                return false;
            }
            if (size() == 4) {
                e = kotlin.collections.e0.e(Arrays.copyOf(objArr2, objArr2.length));
                e.add(t);
                wt2 wt2Var = wt2.INSTANCE;
                objArr = e;
            } else {
                Object[] copyOf = Arrays.copyOf(objArr2, size() + 1);
                b41.h(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                copyOf[copyOf.length - 1] = t;
                wt2 wt2Var2 = wt2.INSTANCE;
                objArr = copyOf;
            }
            this.a = objArr;
        } else {
            Object obj2 = this.a;
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
            if (!tq2.d(obj2).add(t)) {
                return false;
            }
        }
        c(size() + 1);
        return true;
    }

    public int b() {
        return this.b;
    }

    public void c(int i) {
        this.b = i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.a = null;
        c(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        boolean r;
        if (size() == 0) {
            return false;
        }
        if (size() == 1) {
            return b41.d(this.a, obj);
        }
        if (size() >= 5) {
            Object obj2 = this.a;
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
            return ((Set) obj2).contains(obj);
        }
        Object obj3 = this.a;
        Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        r = ArraysKt___ArraysKt.r((Object[]) obj3, obj);
        return r;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    @NotNull
    public Iterator<T> iterator() {
        if (size() == 0) {
            return Collections.emptySet().iterator();
        }
        if (size() == 1) {
            return new c(this.a);
        }
        if (size() < 5) {
            Object obj = this.a;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return new a((Object[]) obj);
        }
        Object obj2 = this.a;
        Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        return tq2.d(obj2).iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return b();
    }
}
