package kotlin.collections;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: kotlin.collections.a0 */
/* loaded from: classes3.dex */
public final class C8185a0<T> extends AbstractC8186b<T> {
    @NotNull
    private final List<T> a;

    public C8185a0(@NotNull List<T> list) {
        b41.i(list, "delegate");
        this.a = list;
    }

    @Override // kotlin.collections.AbstractC8186b, java.util.AbstractList, java.util.List
    public void add(int i, T t) {
        int F;
        List<T> list = this.a;
        F = C8221s.F(this, i);
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
        E = C8221s.E(this, i);
        return list.get(E);
    }

    @Override // kotlin.collections.AbstractC8186b
    public int getSize() {
        return this.a.size();
    }

    @Override // kotlin.collections.AbstractC8186b
    public T removeAt(int i) {
        int E;
        List<T> list = this.a;
        E = C8221s.E(this, i);
        return list.remove(E);
    }

    @Override // kotlin.collections.AbstractC8186b, java.util.AbstractList, java.util.List
    public T set(int i, T t) {
        int E;
        List<T> list = this.a;
        E = C8221s.E(this, i);
        return list.set(E, t);
    }
}
