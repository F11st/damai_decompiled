package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.C8234b;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.hl1;
import tb.wt2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: kotlinx.coroutines.flow.e */
/* loaded from: classes11.dex */
public final /* synthetic */ class C8675e {
    @Nullable
    public static final Object a(@NotNull Flow<?> flow, @NotNull Continuation<? super wt2> continuation) {
        Object d;
        Object collect = flow.collect(hl1.INSTANCE, continuation);
        d = C8234b.d();
        return collect == d ? collect : wt2.INSTANCE;
    }

    @Nullable
    public static final <T> Object b(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super wt2>, ? extends Object> function2, @NotNull Continuation<? super wt2> continuation) {
        Flow b;
        Object d;
        b = C8676f.b(C8672c.u(flow, function2), 0, null, 2, null);
        Object e = C8672c.e(b, continuation);
        d = C8234b.d();
        return e == d ? e : wt2.INSTANCE;
    }
}
