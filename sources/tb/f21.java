package tb;

import kotlinx.coroutines.Incomplete;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class f21 implements Incomplete {
    @NotNull
    private final xk1 a;

    public f21(@NotNull xk1 xk1Var) {
        this.a = xk1Var;
    }

    @Override // kotlinx.coroutines.Incomplete
    @NotNull
    public xk1 getList() {
        return this.a;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return false;
    }

    @NotNull
    public String toString() {
        return k40.c() ? getList().t("New") : super.toString();
    }
}
