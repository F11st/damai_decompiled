package tb;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.builders.MapBuilder;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class bd1<K, V> extends w1<Map.Entry<K, V>, K, V> {
    @NotNull
    private final MapBuilder<K, V> a;

    public bd1(@NotNull MapBuilder<K, V> mapBuilder) {
        b41.i(mapBuilder, "backing");
        this.a = mapBuilder;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(@NotNull Collection<? extends Map.Entry<K, V>> collection) {
        b41.i(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // tb.w1
    public boolean b(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        b41.i(entry, "element");
        return this.a.containsEntry$kotlin_stdlib(entry);
    }

    @Override // tb.w1
    public boolean c(@NotNull Map.Entry entry) {
        b41.i(entry, "element");
        return this.a.removeEntry$kotlin_stdlib(entry);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        b41.i(collection, "elements");
        return this.a.containsAllEntries$kotlin_stdlib(collection);
    }

    @Override // kotlin.collections.AbstractC8198c, java.util.AbstractCollection, java.util.Collection, java.util.Set
    /* renamed from: d */
    public boolean add(@NotNull Map.Entry<K, V> entry) {
        b41.i(entry, "element");
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.collections.AbstractC8198c
    public int getSize() {
        return this.a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    @NotNull
    public Iterator<Map.Entry<K, V>> iterator() {
        return this.a.entriesIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(@NotNull Collection<? extends Object> collection) {
        b41.i(collection, "elements");
        this.a.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(@NotNull Collection<? extends Object> collection) {
        b41.i(collection, "elements");
        this.a.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }
}
