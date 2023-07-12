package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
final class o12 extends zb {
    private final ma1 a;

    public o12(@NotNull ma1 ma1Var) {
        this.a = ma1Var;
    }

    @Override // tb.bg
    public void a(@Nullable Throwable th) {
        this.a.p();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ wt2 invoke(Throwable th) {
        a(th);
        return wt2.INSTANCE;
    }

    @NotNull
    public String toString() {
        return "RemoveOnCancel[" + this.a + jn1.ARRAY_END;
    }
}
