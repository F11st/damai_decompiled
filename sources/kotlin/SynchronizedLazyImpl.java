package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.fs2;
import tb.k50;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class SynchronizedLazyImpl<T> implements Lazy<T>, Serializable {
    @Nullable
    private volatile Object _value;
    @Nullable
    private Function0<? extends T> initializer;
    @NotNull
    private final Object lock;

    public SynchronizedLazyImpl(@NotNull Function0<? extends T> function0, @Nullable Object obj) {
        b41.i(function0, "initializer");
        this.initializer = function0;
        this._value = fs2.INSTANCE;
        this.lock = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.Lazy
    public T getValue() {
        T t;
        T t2 = (T) this._value;
        fs2 fs2Var = fs2.INSTANCE;
        if (t2 != fs2Var) {
            return t2;
        }
        synchronized (this.lock) {
            t = (T) this._value;
            if (t == fs2Var) {
                Function0<? extends T> function0 = this.initializer;
                b41.f(function0);
                t = function0.invoke();
                this._value = t;
                this.initializer = null;
            }
        }
        return t;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this._value != fs2.INSTANCE;
    }

    @NotNull
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ SynchronizedLazyImpl(Function0 function0, Object obj, int i, k50 k50Var) {
        this(function0, (i & 2) != 0 ? null : obj);
    }
}
