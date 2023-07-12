package kotlin.reflect.jvm.internal.pcollections;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class d<V> {
    private static final d<Object> b = new d<>(c.f);
    private final c<V> a;

    private d(c<V> cVar) {
        this.a = cVar;
    }

    public static <V> d<V> a() {
        return (d<V>) b;
    }

    private d<V> d(c<V> cVar) {
        return cVar == this.a ? this : new d<>(cVar);
    }

    public V b(int i) {
        return this.a.a(i);
    }

    public d<V> c(int i, V v) {
        return d(this.a.b(i, v));
    }
}
