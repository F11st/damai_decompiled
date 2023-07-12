package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.collect.Table;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;
import tb.jn1;
import tb.nm1;

/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
public final class Tables {
    private static final Function<? extends Map<?, ?>, ? extends Map<?, ?>> a = new a();

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static final class ImmutableCell<R, C, V> extends b<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;
        @NullableDecl
        private final C columnKey;
        @NullableDecl
        private final R rowKey;
        @NullableDecl
        private final V value;

        ImmutableCell(@NullableDecl R r, @NullableDecl C c, @NullableDecl V v) {
            this.rowKey = r;
            this.columnKey = c;
            this.value = v;
        }

        @Override // com.google.common.collect.Table.Cell
        public C getColumnKey() {
            return this.columnKey;
        }

        @Override // com.google.common.collect.Table.Cell
        public R getRowKey() {
            return this.rowKey;
        }

        @Override // com.google.common.collect.Table.Cell
        public V getValue() {
            return this.value;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static final class UnmodifiableRowSortedMap<R, C, V> extends UnmodifiableTable<R, C, V> implements RowSortedTable<R, C, V> {
        private static final long serialVersionUID = 0;

        public UnmodifiableRowSortedMap(RowSortedTable<R, ? extends C, ? extends V> rowSortedTable) {
            super(rowSortedTable);
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.y, com.google.common.collect.Table
        public SortedSet<R> rowKeySet() {
            return Collections.unmodifiableSortedSet(delegate().rowKeySet());
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.y, com.google.common.collect.Table
        public SortedMap<R, Map<C, V>> rowMap() {
            return Collections.unmodifiableSortedMap(Maps.E(delegate().rowMap(), Tables.a()));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.y, com.google.common.collect.t
        public RowSortedTable<R, C, V> delegate() {
            return (RowSortedTable) super.delegate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class UnmodifiableTable<R, C, V> extends y<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final Table<? extends R, ? extends C, ? extends V> delegate;

        UnmodifiableTable(Table<? extends R, ? extends C, ? extends V> table) {
            this.delegate = (Table) du1.p(table);
        }

        @Override // com.google.common.collect.y, com.google.common.collect.Table
        public Set<Table.Cell<R, C, V>> cellSet() {
            return Collections.unmodifiableSet(super.cellSet());
        }

        @Override // com.google.common.collect.y, com.google.common.collect.Table
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.y, com.google.common.collect.Table
        public Map<R, V> column(@NullableDecl C c) {
            return Collections.unmodifiableMap(super.column(c));
        }

        @Override // com.google.common.collect.y, com.google.common.collect.Table
        public Set<C> columnKeySet() {
            return Collections.unmodifiableSet(super.columnKeySet());
        }

        @Override // com.google.common.collect.y, com.google.common.collect.Table
        public Map<C, Map<R, V>> columnMap() {
            return Collections.unmodifiableMap(Maps.D(super.columnMap(), Tables.a()));
        }

        @Override // com.google.common.collect.y, com.google.common.collect.Table
        public V put(@NullableDecl R r, @NullableDecl C c, @NullableDecl V v) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.y, com.google.common.collect.Table
        public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.y, com.google.common.collect.Table
        public V remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.y, com.google.common.collect.Table
        public Map<C, V> row(@NullableDecl R r) {
            return Collections.unmodifiableMap(super.row(r));
        }

        @Override // com.google.common.collect.y, com.google.common.collect.Table
        public Set<R> rowKeySet() {
            return Collections.unmodifiableSet(super.rowKeySet());
        }

        @Override // com.google.common.collect.y, com.google.common.collect.Table
        public Map<R, Map<C, V>> rowMap() {
            return Collections.unmodifiableMap(Maps.D(super.rowMap(), Tables.a()));
        }

        @Override // com.google.common.collect.y, com.google.common.collect.Table
        public Collection<V> values() {
            return Collections.unmodifiableCollection(super.values());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.y, com.google.common.collect.t
        public Table<R, C, V> delegate() {
            return (Table<? extends R, ? extends C, ? extends V>) this.delegate;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class a implements Function<Map<Object, Object>, Map<Object, Object>> {
        a() {
        }

        @Override // com.google.common.base.Function
        /* renamed from: a */
        public Map<Object, Object> apply(Map<Object, Object> map) {
            return Collections.unmodifiableMap(map);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static abstract class b<R, C, V> implements Table.Cell<R, C, V> {
        @Override // com.google.common.collect.Table.Cell
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Table.Cell) {
                Table.Cell cell = (Table.Cell) obj;
                return nm1.a(getRowKey(), cell.getRowKey()) && nm1.a(getColumnKey(), cell.getColumnKey()) && nm1.a(getValue(), cell.getValue());
            }
            return false;
        }

        @Override // com.google.common.collect.Table.Cell
        public int hashCode() {
            return nm1.b(getRowKey(), getColumnKey(), getValue());
        }

        public String toString() {
            return jn1.BRACKET_START_STR + getRowKey() + "," + getColumnKey() + ")=" + getValue();
        }
    }

    static /* synthetic */ Function a() {
        return d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(Table<?, ?, ?> table, @NullableDecl Object obj) {
        if (obj == table) {
            return true;
        }
        if (obj instanceof Table) {
            return table.cellSet().equals(((Table) obj).cellSet());
        }
        return false;
    }

    public static <R, C, V> Table.Cell<R, C, V> c(@NullableDecl R r, @NullableDecl C c, @NullableDecl V v) {
        return new ImmutableCell(r, c, v);
    }

    private static <K, V> Function<Map<K, V>, Map<K, V>> d() {
        return (Function<Map<K, V>, Map<K, V>>) a;
    }
}
