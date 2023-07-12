package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;
import tb.nm1;

/* compiled from: Taobao */
@Beta
@GwtCompatible(emulated = true)
/* loaded from: classes10.dex */
public final class ArrayTable<R, C, V> extends AbstractC5180h<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    private final V[][] array;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableList<C> columnList;
    @MonotonicNonNullDecl
    private transient ArrayTable<R, C, V>.C4930f columnMap;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableList<R> rowList;
    @MonotonicNonNullDecl
    private transient ArrayTable<R, C, V>.C4932h rowMap;

    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.ArrayTable$a */
    /* loaded from: classes10.dex */
    class C4923a extends AbstractC5151a<Table.Cell<R, C, V>> {
        C4923a(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractC5151a
        /* renamed from: b */
        public Table.Cell<R, C, V> a(int i) {
            return ArrayTable.this.getCell(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.ArrayTable$b */
    /* loaded from: classes10.dex */
    public class C4924b extends Tables.AbstractC5130b<R, C, V> {
        final int a;
        final int b;
        final /* synthetic */ int c;

        C4924b(int i) {
            this.c = i;
            this.a = i / ArrayTable.this.columnList.size();
            this.b = i % ArrayTable.this.columnList.size();
        }

        @Override // com.google.common.collect.Table.Cell
        public C getColumnKey() {
            return (C) ArrayTable.this.columnList.get(this.b);
        }

        @Override // com.google.common.collect.Table.Cell
        public R getRowKey() {
            return (R) ArrayTable.this.rowList.get(this.a);
        }

        @Override // com.google.common.collect.Table.Cell
        public V getValue() {
            return (V) ArrayTable.this.at(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.ArrayTable$c */
    /* loaded from: classes10.dex */
    class C4925c extends AbstractC5151a<V> {
        C4925c(int i) {
            super(i);
        }

        @Override // com.google.common.collect.AbstractC5151a
        protected V a(int i) {
            return (V) ArrayTable.this.getValue(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.ArrayTable$d */
    /* loaded from: classes10.dex */
    public static abstract class AbstractC4926d<K, V> extends Maps.AbstractC5060k<K, V> {
        private final ImmutableMap<K, Integer> a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: com.google.common.collect.ArrayTable$d$a */
        /* loaded from: classes10.dex */
        public class C4927a extends AbstractC5157b<K, V> {
            final /* synthetic */ int a;

            C4927a(int i) {
                this.a = i;
            }

            @Override // com.google.common.collect.AbstractC5157b, java.util.Map.Entry
            public K getKey() {
                return (K) AbstractC4926d.this.c(this.a);
            }

            @Override // com.google.common.collect.AbstractC5157b, java.util.Map.Entry
            public V getValue() {
                return (V) AbstractC4926d.this.e(this.a);
            }

            @Override // com.google.common.collect.AbstractC5157b, java.util.Map.Entry
            public V setValue(V v) {
                return (V) AbstractC4926d.this.f(this.a, v);
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.google.common.collect.ArrayTable$d$b */
        /* loaded from: classes10.dex */
        class C4928b extends AbstractC5151a<Map.Entry<K, V>> {
            C4928b(int i) {
                super(i);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractC5151a
            /* renamed from: b */
            public Map.Entry<K, V> a(int i) {
                return AbstractC4926d.this.b(i);
            }
        }

        /* synthetic */ AbstractC4926d(ImmutableMap immutableMap, C4923a c4923a) {
            this(immutableMap);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.AbstractC5060k
        public Iterator<Map.Entry<K, V>> a() {
            return new C4928b(size());
        }

        Map.Entry<K, V> b(int i) {
            du1.n(i, size());
            return new C4927a(i);
        }

        K c(int i) {
            return this.a.keySet().asList().get(i);
        }

        @Override // com.google.common.collect.Maps.AbstractC5060k, java.util.AbstractMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@NullableDecl Object obj) {
            return this.a.containsKey(obj);
        }

        abstract String d();

        @NullableDecl
        abstract V e(int i);

        @NullableDecl
        abstract V f(int i, V v);

        @Override // java.util.AbstractMap, java.util.Map
        public V get(@NullableDecl Object obj) {
            Integer num = this.a.get(obj);
            if (num == null) {
                return null;
            }
            return e(num.intValue());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k, V v) {
            Integer num = this.a.get(k);
            if (num != null) {
                return f(num.intValue(), v);
            }
            throw new IllegalArgumentException(d() + " " + k + " not in " + this.a.keySet());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.a.size();
        }

        private AbstractC4926d(ImmutableMap<K, Integer> immutableMap) {
            this.a = immutableMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.ArrayTable$e */
    /* loaded from: classes10.dex */
    public class C4929e extends AbstractC4926d<R, V> {
        final int b;

        C4929e(int i) {
            super(ArrayTable.this.rowKeyToIndex, null);
            this.b = i;
        }

        @Override // com.google.common.collect.ArrayTable.AbstractC4926d
        String d() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.AbstractC4926d
        V e(int i) {
            return (V) ArrayTable.this.at(i, this.b);
        }

        @Override // com.google.common.collect.ArrayTable.AbstractC4926d
        V f(int i, V v) {
            return (V) ArrayTable.this.set(i, this.b, v);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.ArrayTable$f */
    /* loaded from: classes10.dex */
    private class C4930f extends AbstractC4926d<C, Map<R, V>> {
        /* synthetic */ C4930f(ArrayTable arrayTable, C4923a c4923a) {
            this();
        }

        @Override // com.google.common.collect.ArrayTable.AbstractC4926d
        String d() {
            return "Column";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.AbstractC4926d
        /* renamed from: g */
        public Map<R, V> e(int i) {
            return new C4929e(i);
        }

        @Override // com.google.common.collect.ArrayTable.AbstractC4926d, java.util.AbstractMap, java.util.Map
        /* renamed from: h */
        public Map<R, V> put(C c, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.AbstractC4926d
        /* renamed from: i */
        public Map<R, V> f(int i, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        private C4930f() {
            super(ArrayTable.this.columnKeyToIndex, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.ArrayTable$g */
    /* loaded from: classes10.dex */
    public class C4931g extends AbstractC4926d<C, V> {
        final int b;

        C4931g(int i) {
            super(ArrayTable.this.columnKeyToIndex, null);
            this.b = i;
        }

        @Override // com.google.common.collect.ArrayTable.AbstractC4926d
        String d() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.AbstractC4926d
        V e(int i) {
            return (V) ArrayTable.this.at(this.b, i);
        }

        @Override // com.google.common.collect.ArrayTable.AbstractC4926d
        V f(int i, V v) {
            return (V) ArrayTable.this.set(this.b, i, v);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.ArrayTable$h */
    /* loaded from: classes10.dex */
    private class C4932h extends AbstractC4926d<R, Map<C, V>> {
        /* synthetic */ C4932h(ArrayTable arrayTable, C4923a c4923a) {
            this();
        }

        @Override // com.google.common.collect.ArrayTable.AbstractC4926d
        String d() {
            return "Row";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.AbstractC4926d
        /* renamed from: g */
        public Map<C, V> e(int i) {
            return new C4931g(i);
        }

        @Override // com.google.common.collect.ArrayTable.AbstractC4926d, java.util.AbstractMap, java.util.Map
        /* renamed from: h */
        public Map<C, V> put(R r, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.AbstractC4926d
        /* renamed from: i */
        public Map<C, V> f(int i, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        private C4932h() {
            super(ArrayTable.this.rowKeyToIndex, null);
        }
    }

    private ArrayTable(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        ImmutableList<R> copyOf = ImmutableList.copyOf(iterable);
        this.rowList = copyOf;
        ImmutableList<C> copyOf2 = ImmutableList.copyOf(iterable2);
        this.columnList = copyOf2;
        du1.d(copyOf.isEmpty() == copyOf2.isEmpty());
        this.rowKeyToIndex = Maps.k(copyOf);
        this.columnKeyToIndex = Maps.k(copyOf2);
        this.array = (V[][]) ((Object[][]) Array.newInstance(Object.class, copyOf.size(), copyOf2.size()));
        eraseAll();
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        return new ArrayTable<>(iterable, iterable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Table.Cell<R, C, V> getCell(int i) {
        return new C4924b(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V getValue(int i) {
        return at(i / this.columnList.size(), i % this.columnList.size());
    }

    public V at(int i, int i2) {
        du1.n(i, this.rowList.size());
        du1.n(i2, this.columnList.size());
        return this.array[i][i2];
    }

    @Override // com.google.common.collect.AbstractC5180h
    Iterator<Table.Cell<R, C, V>> cellIterator() {
        return new C4923a(size());
    }

    @Override // com.google.common.collect.AbstractC5180h, com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.AbstractC5180h, com.google.common.collect.Table
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Table
    public Map<R, V> column(C c) {
        du1.p(c);
        Integer num = this.columnKeyToIndex.get(c);
        return num == null ? ImmutableMap.of() : new C4929e(num.intValue());
    }

    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    @Override // com.google.common.collect.Table
    public Map<C, Map<R, V>> columnMap() {
        ArrayTable<R, C, V>.C4930f c4930f = this.columnMap;
        if (c4930f == null) {
            ArrayTable<R, C, V>.C4930f c4930f2 = new C4930f(this, null);
            this.columnMap = c4930f2;
            return c4930f2;
        }
        return c4930f;
    }

    @Override // com.google.common.collect.AbstractC5180h, com.google.common.collect.Table
    public boolean contains(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return containsRow(obj) && containsColumn(obj2);
    }

    @Override // com.google.common.collect.AbstractC5180h, com.google.common.collect.Table
    public boolean containsColumn(@NullableDecl Object obj) {
        return this.columnKeyToIndex.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractC5180h, com.google.common.collect.Table
    public boolean containsRow(@NullableDecl Object obj) {
        return this.rowKeyToIndex.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractC5180h, com.google.common.collect.Table
    public boolean containsValue(@NullableDecl Object obj) {
        V[][] vArr;
        for (V[] vArr2 : this.array) {
            for (V v : vArr2) {
                if (nm1.a(obj, v)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractC5180h, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @CanIgnoreReturnValue
    public V erase(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return set(num.intValue(), num2.intValue(), null);
    }

    public void eraseAll() {
        for (V[] vArr : this.array) {
            Arrays.fill(vArr, (Object) null);
        }
    }

    @Override // com.google.common.collect.AbstractC5180h, com.google.common.collect.Table
    public V get(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return at(num.intValue(), num2.intValue());
    }

    @Override // com.google.common.collect.AbstractC5180h, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractC5180h, com.google.common.collect.Table
    public boolean isEmpty() {
        return this.rowList.isEmpty() || this.columnList.isEmpty();
    }

    @Override // com.google.common.collect.AbstractC5180h, com.google.common.collect.Table
    @CanIgnoreReturnValue
    public V put(R r, C c, @NullableDecl V v) {
        du1.p(r);
        du1.p(c);
        Integer num = this.rowKeyToIndex.get(r);
        du1.l(num != null, "Row %s not in %s", r, this.rowList);
        Integer num2 = this.columnKeyToIndex.get(c);
        du1.l(num2 != null, "Column %s not in %s", c, this.columnList);
        return set(num.intValue(), num2.intValue(), v);
    }

    @Override // com.google.common.collect.AbstractC5180h, com.google.common.collect.Table
    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        super.putAll(table);
    }

    @Override // com.google.common.collect.AbstractC5180h, com.google.common.collect.Table
    @CanIgnoreReturnValue
    @Deprecated
    public V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Table
    public Map<C, V> row(R r) {
        du1.p(r);
        Integer num = this.rowKeyToIndex.get(r);
        return num == null ? ImmutableMap.of() : new C4931g(num.intValue());
    }

    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    @Override // com.google.common.collect.Table
    public Map<R, Map<C, V>> rowMap() {
        ArrayTable<R, C, V>.C4932h c4932h = this.rowMap;
        if (c4932h == null) {
            ArrayTable<R, C, V>.C4932h c4932h2 = new C4932h(this, null);
            this.rowMap = c4932h2;
            return c4932h2;
        }
        return c4932h;
    }

    @CanIgnoreReturnValue
    public V set(int i, int i2, @NullableDecl V v) {
        du1.n(i, this.rowList.size());
        du1.n(i2, this.columnList.size());
        V[][] vArr = this.array;
        V v2 = vArr[i][i2];
        vArr[i][i2] = v;
        return v2;
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return this.rowList.size() * this.columnList.size();
    }

    @GwtIncompatible
    public V[][] toArray(Class<V> cls) {
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) cls, this.rowList.size(), this.columnList.size()));
        for (int i = 0; i < this.rowList.size(); i++) {
            V[][] vArr2 = this.array;
            System.arraycopy(vArr2[i], 0, vArr[i], 0, vArr2[i].length);
        }
        return vArr;
    }

    @Override // com.google.common.collect.AbstractC5180h
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractC5180h, com.google.common.collect.Table
    public Collection<V> values() {
        return super.values();
    }

    @Override // com.google.common.collect.AbstractC5180h
    Iterator<V> valuesIterator() {
        return new C4925c(size());
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Table<R, C, V> table) {
        return table instanceof ArrayTable ? new ArrayTable<>((ArrayTable) table) : new ArrayTable<>(table);
    }

    @Override // com.google.common.collect.AbstractC5180h, com.google.common.collect.Table
    public ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    @Override // com.google.common.collect.AbstractC5180h, com.google.common.collect.Table
    public ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ArrayTable(Table<R, C, V> table) {
        this(table.rowKeySet(), table.columnKeySet());
        putAll(table);
    }

    private ArrayTable(ArrayTable<R, C, V> arrayTable) {
        ImmutableList<R> immutableList = arrayTable.rowList;
        this.rowList = immutableList;
        ImmutableList<C> immutableList2 = arrayTable.columnList;
        this.columnList = immutableList2;
        this.rowKeyToIndex = arrayTable.rowKeyToIndex;
        this.columnKeyToIndex = arrayTable.columnKeyToIndex;
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance(Object.class, immutableList.size(), immutableList2.size()));
        this.array = vArr;
        for (int i = 0; i < this.rowList.size(); i++) {
            V[][] vArr2 = arrayTable.array;
            System.arraycopy(vArr2[i], 0, vArr[i], 0, vArr2[i].length);
        }
    }
}
