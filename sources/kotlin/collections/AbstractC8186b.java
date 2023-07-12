package kotlin.collections;

import java.util.AbstractList;
import java.util.List;
import kotlin.SinceKotlin;

/* compiled from: Taobao */
@SinceKotlin(version = "1.1")
/* renamed from: kotlin.collections.b */
/* loaded from: classes3.dex */
public abstract class AbstractC8186b<E> extends AbstractList<E> implements List<E> {
    @Override // java.util.AbstractList, java.util.List
    public abstract void add(int i, E e);

    public abstract int getSize();

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int i) {
        return removeAt(i);
    }

    public abstract E removeAt(int i);

    @Override // java.util.AbstractList, java.util.List
    public abstract E set(int i, E e);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }
}
