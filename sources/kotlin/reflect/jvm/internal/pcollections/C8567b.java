package kotlin.reflect.jvm.internal.pcollections;

import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* renamed from: kotlin.reflect.jvm.internal.pcollections.b */
/* loaded from: classes3.dex */
public final class C8567b<K, V> {
    private static final C8567b<Object, Object> c = new C8567b<>(C8569d.a(), 0);
    private final C8569d<C8565a<MapEntry<K, V>>> a;
    private final int b;

    private C8567b(C8569d<C8565a<MapEntry<K, V>>> c8569d, int i) {
        this.a = c8569d;
        this.b = i;
    }

    private static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[2];
        objArr[0] = "kotlin/reflect/jvm/internal/pcollections/HashPMap";
        if (i != 1) {
            objArr[1] = DXRecyclerLayout.LOAD_MORE_EMPTY;
        } else {
            objArr[1] = "minus";
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", objArr));
    }

    @NotNull
    public static <K, V> C8567b<K, V> b() {
        C8567b<K, V> c8567b = (C8567b<K, V>) c;
        if (c8567b == null) {
            a(0);
        }
        return c8567b;
    }

    private C8565a<MapEntry<K, V>> d(int i) {
        C8565a<MapEntry<K, V>> b = this.a.b(i);
        return b == null ? C8565a.b() : b;
    }

    private static <K, V> int e(C8565a<MapEntry<K, V>> c8565a, Object obj) {
        int i = 0;
        while (c8565a != null && c8565a.size() > 0) {
            if (c8565a.a.key.equals(obj)) {
                return i;
            }
            c8565a = c8565a.b;
            i++;
        }
        return -1;
    }

    public V c(Object obj) {
        for (C8565a d = d(obj.hashCode()); d != null && d.size() > 0; d = d.b) {
            MapEntry mapEntry = (MapEntry) d.a;
            if (mapEntry.key.equals(obj)) {
                return mapEntry.value;
            }
        }
        return null;
    }

    @NotNull
    public C8567b<K, V> f(K k, V v) {
        C8565a<MapEntry<K, V>> d = d(k.hashCode());
        int size = d.size();
        int e = e(d, k);
        if (e != -1) {
            d = d.d(e);
        }
        C8565a<MapEntry<K, V>> f = d.f(new MapEntry<>(k, v));
        return new C8567b<>(this.a.c(k.hashCode(), f), (this.b - size) + f.size());
    }
}
