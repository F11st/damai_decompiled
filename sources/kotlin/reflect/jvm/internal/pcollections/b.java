package kotlin.reflect.jvm.internal.pcollections;

import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class b<K, V> {
    private static final b<Object, Object> c = new b<>(d.a(), 0);
    private final d<a<MapEntry<K, V>>> a;
    private final int b;

    private b(d<a<MapEntry<K, V>>> dVar, int i) {
        this.a = dVar;
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
    public static <K, V> b<K, V> b() {
        b<K, V> bVar = (b<K, V>) c;
        if (bVar == null) {
            a(0);
        }
        return bVar;
    }

    private a<MapEntry<K, V>> d(int i) {
        a<MapEntry<K, V>> b = this.a.b(i);
        return b == null ? a.b() : b;
    }

    private static <K, V> int e(a<MapEntry<K, V>> aVar, Object obj) {
        int i = 0;
        while (aVar != null && aVar.size() > 0) {
            if (aVar.a.key.equals(obj)) {
                return i;
            }
            aVar = aVar.b;
            i++;
        }
        return -1;
    }

    public V c(Object obj) {
        for (a d = d(obj.hashCode()); d != null && d.size() > 0; d = d.b) {
            MapEntry mapEntry = (MapEntry) d.a;
            if (mapEntry.key.equals(obj)) {
                return mapEntry.value;
            }
        }
        return null;
    }

    @NotNull
    public b<K, V> f(K k, V v) {
        a<MapEntry<K, V>> d = d(k.hashCode());
        int size = d.size();
        int e = e(d, k);
        if (e != -1) {
            d = d.d(e);
        }
        a<MapEntry<K, V>> f = d.f(new MapEntry<>(k, v));
        return new b<>(this.a.c(k.hashCode(), f), (this.b - size) + f.size());
    }
}
