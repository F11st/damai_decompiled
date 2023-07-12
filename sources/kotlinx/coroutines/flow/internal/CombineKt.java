package kotlinx.coroutines.flow.internal;

import kotlin.PublishedApi;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.C8234b;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.nk0;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class CombineKt {
    @PublishedApi
    @Nullable
    public static final <R, T> Object a(@NotNull FlowCollector<? super R> flowCollector, @NotNull Flow<? extends T>[] flowArr, @NotNull Function0<T[]> function0, @NotNull Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super wt2>, ? extends Object> function3, @NotNull Continuation<? super wt2> continuation) {
        Object d;
        Object a = nk0.a(new CombineKt$combineInternal$2(flowCollector, flowArr, function0, function3, null), continuation);
        d = C8234b.d();
        return a == d ? a : wt2.INSTANCE;
    }
}
