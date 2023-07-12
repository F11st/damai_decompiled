package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.hl1;
import tb.wt2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final /* synthetic */ class e {
    @Nullable
    public static final Object a(@NotNull Flow<?> flow, @NotNull Continuation<? super wt2> continuation) {
        Object d;
        Object collect = flow.collect(hl1.INSTANCE, continuation);
        d = kotlin.coroutines.intrinsics.b.d();
        return collect == d ? collect : wt2.INSTANCE;
    }

    @Nullable
    public static final <T> Object b(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super wt2>, ? extends Object> function2, @NotNull Continuation<? super wt2> continuation) {
        Flow b;
        Object d;
        b = f.b(c.u(flow, function2), 0, null, 2, null);
        Object e = c.e(b, continuation);
        d = kotlin.coroutines.intrinsics.b.d();
        return e == d ? e : wt2.INSTANCE;
    }
}
