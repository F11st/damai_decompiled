package kotlin.collections;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class a0<T> extends b<T> {
    @NotNull
    private final List<T> a;

    public a0(@NotNull List<T> list) {
        b41.i(list, "delegate");
        this.a = list;
    }

    @Override // kotlin.collections.b, java.util.AbstractList, java.util.List
    public void add(int i, T t) {
        int F;
        List<T> list = this.a;
        F = s.F(this, i);
        list.add(F, t);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        int E;
        List<T> list = this.a;
        E = s.E(this, i);
        return list.get(E);
    }

    @Override // kotlin.collections.b
    public int getSize() {
        return this.a.size();
    }

    @Override // kotlin.collections.b
    public T removeAt(int i) {
        int E;
        List<T> list = this.a;
        E = s.E(this, i);
        return list.remove(E);
    }

    @Override // kotlin.collections.b, java.util.AbstractList, java.util.List
    public T set(int i, T t) {
        int E;
        List<T> list = this.a;
        E = s.E(this, i);
        return list.set(E, t);
    }
}
