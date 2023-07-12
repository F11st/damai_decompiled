package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.fs2;
import tb.k50;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class SafePublicationLazyImpl<T> implements Lazy<T>, Serializable {
    @NotNull
    public static final C8175a Companion = new C8175a(null);
    private static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> valueUpdater = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "_value");
    @Nullable
    private volatile Object _value;
    @NotNull

    /* renamed from: final  reason: not valid java name */
    private final Object f1012final;
    @Nullable
    private volatile Function0<? extends T> initializer;

    /* compiled from: Taobao */
    /* renamed from: kotlin.SafePublicationLazyImpl$a */
    /* loaded from: classes3.dex */
    public static final class C8175a {
        private C8175a() {
        }

        public /* synthetic */ C8175a(k50 k50Var) {
            this();
        }
    }

    public SafePublicationLazyImpl(@NotNull Function0<? extends T> function0) {
        b41.i(function0, "initializer");
        this.initializer = function0;
        fs2 fs2Var = fs2.INSTANCE;
        this._value = fs2Var;
        this.f1012final = fs2Var;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.Lazy
    public T getValue() {
        T t = (T) this._value;
        fs2 fs2Var = fs2.INSTANCE;
        if (t != fs2Var) {
            return t;
        }
        Function0<? extends T> function0 = this.initializer;
        if (function0 != null) {
            T invoke = function0.invoke();
            if (valueUpdater.compareAndSet(this, fs2Var, invoke)) {
                this.initializer = null;
                return invoke;
            }
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
