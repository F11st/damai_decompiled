package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class t8 {
    @NotNull
    public v8<?> a;

    public abstract void a(@NotNull v8<?> v8Var, @Nullable Object obj);

    @NotNull
    public final v8<?> b() {
        v8<?> v8Var = this.a;
        if (v8Var == null) {
            b41.A("atomicOp");
        }
        return v8Var;
    }

    @Nullable
    public abstract Object c(@NotNull v8<?> v8Var);

    public final void d(@NotNull v8<?> v8Var) {
        this.a = v8Var;
    }
}
