package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.fs2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class UnsafeLazyImpl<T> implements Lazy<T>, Serializable {
    @Nullable
    private Object _value;
    @Nullable
    private Function0<? extends T> initializer;

    public UnsafeLazyImpl(@NotNull Function0<? extends T> function0) {
        b41.i(function0, "initializer");
        this.initializer = function0;
        this._value = fs2.INSTANCE;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.Lazy
    public T getValue() {
        if (this._value == fs2.INSTANCE) {
            Function0<? extends T> function0 = this.initializer;
            b41.f(function0);
            this._value = function0.invoke();
            this.initializer = null;
        }
        return (T) this._value;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this._value != fs2.INSTANCE;
    }

    @NotNull
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
