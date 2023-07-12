package tb;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@InternalCoroutinesApi
/* loaded from: classes11.dex */
public abstract class v8<T> extends cn1 {
    private static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(v8.class, Object.class, "_consensus");
    private volatile Object _consensus = u8.NO_DECISION;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // tb.cn1
    @NotNull
    public v8<?> a() {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // tb.cn1
    @Nullable
    public final Object c(@Nullable Object obj) {
        Object obj2 = this._consensus;
        if (obj2 == u8.NO_DECISION) {
            obj2 = e(i(obj));
        }
        d(obj, obj2);
        return obj2;
    }

    public abstract void d(T t, @Nullable Object obj);

    @Nullable
    public final Object e(@Nullable Object obj) {
        if (k40.a()) {
            if (!(obj != u8.NO_DECISION)) {
                throw new AssertionError();
            }
        }
        Object obj2 = this._consensus;
        Object obj3 = u8.NO_DECISION;
        return obj2 != obj3 ? obj2 : a.compareAndSet(this, obj3, obj) ? obj : this._consensus;
    }

    @Nullable
    public final Object f() {
        return this._consensus;
    }

    public long g() {
        return 0L;
    }

    public final boolean h() {
        return this._consensus != u8.NO_DECISION;
    }

    @Nullable
    public abstract Object i(T t);
}
