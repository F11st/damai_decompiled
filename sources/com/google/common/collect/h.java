package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
abstract class h<R, C, V> implements Table<R, C, V> {
    @MonotonicNonNullDecl
    private transient Set<Table.Cell<R, C, V>> cellSet;
    @MonotonicNonNullDecl
    private transient Collection<V> values;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class a extends j0<Table.Cell<R, C, V>, V> {
        a(h hVar, Iterator it) {
            super(it);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.j0
        /* renamed from: b */
        public V a(Table.Cell<R, C, V> cell) {
            return cell.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class b extends AbstractSet<Table.Cell<R, C, V>> {
        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Table.Cell) {
                Table.Cell cell = (Table.Cell) obj;
                Map map = (Map) Maps.x(h.this.rowMap(), cell.getRowKey());
                return map != null && l.d(map.entrySet(), Maps.j(cell.getColumnKey(), cell.getValue()));
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Table.Cell<R, C, V>> iterator() {
            return h.this.cellIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            if (obj instanceof Table.Cell) {
                Table.Cell cell = (Table.Cell) obj;
                Map map = (Map) Maps.x(h.this.rowMap(), cell.getRowKey());
                return map != null && l.e(map.entrySet(), Maps.j(cell.getColumnKey(), cell.getValue()));
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class c extends AbstractCollection<V> {
        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return h.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return h.this.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return h.this.size();
        }
    }

    abstract Iterator<Table.Cell<R, C, V>> cellIterator();

    @Override // com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        Set<Table.Cell<R, C, V>> set = this.cellSet;
        if (set == null) {
            Set<Table.Cell<R, C, V>> createCellSet = createCellSet();
            this.cellSet = createCellSet;
            return createCellSet;
        }
        return set;
    }

    @Override // com.google.common.collect.Table
    public abstract void clear();

    @Override // com.google.common.collect.Table
    public abstract Set<C> columnKeySet();

    @Override // com.google.common.collect.Table
    public boolean contains(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Map map = (Map) Maps.x(rowMap(), obj);
        return map != null && Maps.w(map, obj2);
    }

    @Override // com.google.common.collect.Table
    public boolean containsColumn(@NullableDecl Object obj) {
        return Maps.w(columnMap(), obj);
    }

    @Override // com.google.common.collect.Table
    public boolean containsRow(@NullableDecl Object obj) {
        return Maps.w(rowMap(), obj);
    }

    @Override // com.google.common.collect.Table
    public boolean containsValue(@NullableDecl Object obj) {
        for (Map<C, V> map : rowMap().values()) {
            if (map.containsValue(obj)) {
                return true;
            }
        }
        return false;
    }

    Set<Table.Cell<R, C, V>> createCellSet() {
        return new b();
    }

    Collection<V> createValues() {
        return new c();
    }

    @Override // com.google.common.collect.Table
    public boolean equals(@NullableDecl Object obj) {
        return Tables.b(this, obj);
    }

    @Override // com.google.common.collect.Table
    public V get(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Map map = (Map) Maps.x(rowMap(), obj);
        if (map == null) {
            return null;
        }
        return (V) Maps.x(map, obj2);
    }

    @Override // com.google.common.collect.Table
    public int hashCode() {
        return cellSet().hashCode();
    }

    @Override // com.google.common.collect.Table
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // com.google.common.collect.Table
    @CanIgnoreReturnValue
    public abstract V put(R r, C c2, V v);

    @Override // com.google.common.collect.Table
    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        for (Table.Cell<? extends R, ? extends C, ? extends V> cell : table.cellSet()) {
            put(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
        }
    }

    @Override // com.google.common.collect.Table
    @CanIgnoreReturnValue
    public abstract V remove(@NullableDecl Object obj, @NullableDecl Object obj2);

    @Override // com.google.common.collect.Table
    public abstract Set<R> rowKeySet();

    public String toString() {
        return rowMap().toString();
    }

    @Override // com.google.common.collect.Table
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection == null) {
            Collection<V> createValues = createValues();
            this.values = createValues;
            return createValues;
        }
        return collection;
    }

    Iterator<V> valuesIterator() {
        return new a(this, cellSet().iterator());
    }
}
