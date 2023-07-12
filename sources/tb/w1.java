package tb;

import java.util.Map;
import java.util.Map.Entry;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class w1<E extends Map.Entry<? extends K, ? extends V>, K, V> extends kotlin.collections.c<E> {
    public final boolean a(@NotNull E e) {
        b41.i(e, "element");
        return b(e);
    }

    public abstract boolean b(@NotNull Map.Entry<? extends K, ? extends V> entry);

    public abstract /* bridge */ boolean c(Map.Entry<?, ?> entry);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return a((Map.Entry) obj);
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Map.Entry) {
            return c((Map.Entry) obj);
        }
        return false;
    }
}
