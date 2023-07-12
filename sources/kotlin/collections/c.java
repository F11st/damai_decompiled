package kotlin.collections;

import java.util.AbstractSet;
import java.util.Set;
import kotlin.SinceKotlin;

/* compiled from: Taobao */
@SinceKotlin(version = "1.1")
/* loaded from: classes3.dex */
public abstract class c<E> extends AbstractSet<E> implements Set<E> {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean add(E e);

    public abstract int getSize();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }
}
