package kotlin.reflect.jvm.internal.pcollections;

/* compiled from: Taobao */
/* renamed from: kotlin.reflect.jvm.internal.pcollections.d */
/* loaded from: classes3.dex */
final class C8569d<V> {
    private static final C8569d<Object> b = new C8569d<>(C8568c.f);
    private final C8568c<V> a;

    private C8569d(C8568c<V> c8568c) {
        this.a = c8568c;
    }

    public static <V> C8569d<V> a() {
        return (C8569d<V>) b;
    }

    private C8569d<V> d(C8568c<V> c8568c) {
        return c8568c == this.a ? this : new C8569d<>(c8568c);
    }

    public V b(int i) {
        return this.a.a(i);
    }

    public C8569d<V> c(int i, V v) {
        return d(this.a.b(i, v));
    }
}
