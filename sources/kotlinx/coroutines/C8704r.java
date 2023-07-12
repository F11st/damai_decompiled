package kotlinx.coroutines;

import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.f61;
import tb.jn1;
import tb.o40;
import tb.wt2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: kotlinx.coroutines.r */
/* loaded from: classes8.dex */
public final class C8704r extends f61<Job> {
    private final Function1<Throwable, wt2> e;

    /* JADX WARN: Multi-variable type inference failed */
    public C8704r(@NotNull Job job, @NotNull Function1<? super Throwable, wt2> function1) {
        super(job);
        this.e = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ wt2 invoke(Throwable th) {
        t(th);
        return wt2.INSTANCE;
    }

    @Override // tb.cm
    public void t(@Nullable Throwable th) {
        this.e.invoke(th);
    }

    @Override // tb.ma1
    @NotNull
    public String toString() {
        return "InvokeOnCompletion[" + o40.a(this) + '@' + o40.b(this) + jn1.ARRAY_END;
    }
}
