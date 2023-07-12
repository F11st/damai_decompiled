package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.C8234b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.cm1;
import tb.i32;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "", "value", "Ltb/wt2;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$2", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes11.dex */
final class FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$2 extends SuspendLambda implements Function2<Object, Continuation<? super wt2>, Object> {
    final /* synthetic */ FlowCollector $downstream$inlined;
    final /* synthetic */ Ref$ObjectRef $lastValue$inlined;
    final /* synthetic */ Ref$LongRef $timeoutMillis$inlined;
    final /* synthetic */ Ref$ObjectRef $values$inlined;
    Object L$0;
    int label;
    private Object p$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$2(Continuation continuation, Ref$ObjectRef ref$ObjectRef, Ref$LongRef ref$LongRef, FlowCollector flowCollector, Ref$ObjectRef ref$ObjectRef2) {
        super(2, continuation);
        this.$lastValue$inlined = ref$ObjectRef;
        this.$timeoutMillis$inlined = ref$LongRef;
        this.$downstream$inlined = flowCollector;
        this.$values$inlined = ref$ObjectRef2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<wt2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$2 flowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$2 = new FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$2(continuation, this.$lastValue$inlined, this.$timeoutMillis$inlined, this.$downstream$inlined, this.$values$inlined);
        flowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$2.p$0 = obj;
        return flowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super wt2> continuation) {
        return ((FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$2) create(obj, continuation)).invokeSuspend(wt2.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, tb.kj2] */
    /* JADX WARN: Type inference failed for: r6v1, types: [T, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object d;
        d = C8234b.d();
        int i = this.label;
        if (i == 0) {
            i32.b(obj);
            ?? r6 = this.p$0;
            if (r6 == 0) {
                Object obj2 = this.$lastValue$inlined.element;
                if (obj2 != null) {
                    FlowCollector flowCollector = this.$downstream$inlined;
                    if (obj2 == cm1.NULL) {
                        obj2 = null;
                    }
                    this.L$0 = r6;
                    this.label = 1;
                    if (flowCollector.emit(obj2, this) == d) {
                        return d;
                    }
                }
            } else {
                this.$lastValue$inlined.element = r6;
                return wt2.INSTANCE;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            i32.b(obj);
        }
        this.$lastValue$inlined.element = cm1.DONE;
        return wt2.INSTANCE;
    }
}
