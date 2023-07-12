package kotlinx.coroutines.flow;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final /* synthetic */ class FlowKt__DistinctKt {
    private static final Function1<Object, Object> a = new Function1<Object, Object>() { // from class: kotlinx.coroutines.flow.FlowKt__DistinctKt$defaultKeySelector$1
        @Override // kotlin.jvm.functions.Function1
        @Nullable
        public final Object invoke(@Nullable Object obj) {
            return obj;
        }
    };
    private static final Function2<Object, Object, Boolean> b = new Function2<Object, Object, Boolean>() { // from class: kotlinx.coroutines.flow.FlowKt__DistinctKt$defaultAreEquivalent$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Boolean invoke(Object obj, Object obj2) {
            return Boolean.valueOf(invoke2(obj, obj2));
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final boolean invoke2(@Nullable Object obj, @Nullable Object obj2) {
            return b41.d(obj, obj2);
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Flow<T> a(@NotNull Flow<? extends T> flow) {
        return flow instanceof StateFlow ? flow : b(flow, a, b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> Flow<T> b(Flow<? extends T> flow, Function1<? super T, ? extends Object> function1, Function2<Object, Object, Boolean> function2) {
        if (flow instanceof DistinctFlowImpl) {
            DistinctFlowImpl distinctFlowImpl = (DistinctFlowImpl) flow;
            if (distinctFlowImpl.b == function1 && distinctFlowImpl.c == function2) {
                return flow;
            }
        }
        return new DistinctFlowImpl(flow, function1, function2);
    }
}
