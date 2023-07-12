package tb;

import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
final class ha0 extends ag {
    private final DisposableHandle a;

    public ha0(@NotNull DisposableHandle disposableHandle) {
        this.a = disposableHandle;
    }

    @Override // tb.bg
    public void a(@Nullable Throwable th) {
        this.a.dispose();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ wt2 invoke(Throwable th) {
        a(th);
        return wt2.INSTANCE;
    }

    @NotNull
    public String toString() {
        return "DisposeOnCancel[" + this.a + jn1.ARRAY_END;
    }
}
