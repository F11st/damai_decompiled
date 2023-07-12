package kotlinx.coroutines;

import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ag;
import tb.jn1;
import tb.o40;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
final class p extends ag {
    private final Function1<Throwable, wt2> a;

    /* JADX WARN: Multi-variable type inference failed */
    public p(@NotNull Function1<? super Throwable, wt2> function1) {
        this.a = function1;
    }

    @Override // tb.bg
    public void a(@Nullable Throwable th) {
        this.a.invoke(th);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ wt2 invoke(Throwable th) {
        a(th);
        return wt2.INSTANCE;
    }

    @NotNull
    public String toString() {
        return "InvokeOnCancel[" + o40.a(this.a) + '@' + o40.b(this) + jn1.ARRAY_END;
    }
}
