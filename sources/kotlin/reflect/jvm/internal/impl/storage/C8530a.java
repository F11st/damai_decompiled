package kotlin.reflect.jvm.internal.impl.storage;

/* compiled from: Taobao */
/* renamed from: kotlin.reflect.jvm.internal.impl.storage.a */
/* loaded from: classes3.dex */
class C8530a<T> {
    private final T a;
    private final Thread b = Thread.currentThread();

    /* JADX INFO: Access modifiers changed from: package-private */
    public C8530a(T t) {
        this.a = t;
    }

    public T a() {
        if (b()) {
            return this.a;
        }
        throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
    }

    public boolean b() {
        return this.b == Thread.currentThread();
    }
}
