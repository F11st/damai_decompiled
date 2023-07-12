package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class cn1 {
    @Nullable
    public abstract v8<?> a();

    public final boolean b(@NotNull cn1 cn1Var) {
        v8<?> a;
        v8<?> a2 = a();
        return (a2 == null || (a = cn1Var.a()) == null || a2.g() >= a.g()) ? false : true;
    }

    @Nullable
    public abstract Object c(@Nullable Object obj);

    @NotNull
    public String toString() {
        return o40.a(this) + '@' + o40.b(this);
    }
}
