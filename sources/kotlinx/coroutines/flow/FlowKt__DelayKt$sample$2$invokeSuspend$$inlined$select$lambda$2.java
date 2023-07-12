package kotlinx.coroutines.flow;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.cm1;
import tb.i32;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0006\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "Ltb/wt2;", AdvanceSetting.NETWORK_TYPE, "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$2", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes11.dex */
final class FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$2 extends SuspendLambda implements Function2<wt2, Continuation<? super wt2>, Object> {
    final /* synthetic */ FlowCollector $downstream$inlined;
    final /* synthetic */ Ref$ObjectRef $lastValue$inlined;
    final /* synthetic */ ReceiveChannel $ticker$inlined;
    final /* synthetic */ Ref$ObjectRef $values$inlined;
    Object L$0;
    Object L$1;
    int label;
    private wt2 p$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$2(Continuation continuation, Ref$ObjectRef ref$ObjectRef, ReceiveChannel receiveChannel, Ref$ObjectRef ref$ObjectRef2, FlowCollector flowCollector) {
        super(2, continuation);
        this.$values$inlined = ref$ObjectRef;
        this.$ticker$inlined = receiveChannel;
        this.$lastValue$inlined = ref$ObjectRef2;
        this.$downstream$inlined = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<wt2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$2 flowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$2 = new FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$2(continuation, this.$values$inlined, this.$ticker$inlined, this.$lastValue$inlined, this.$downstream$inlined);
        flowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$2.p$0 = (wt2) obj;
        return flowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(wt2 wt2Var, Continuation<? super wt2> continuation) {
        return ((FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$2) create(wt2Var, continuation)).invokeSuspend(wt2.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object d;
        d = kotlin.coroutines.intrinsics.b.d();
        int i = this.label;
        if (i == 0) {
            i32.b(obj);
            wt2 wt2Var = this.p$0;
            Ref$ObjectRef ref$ObjectRef = this.$lastValue$inlined;
            Object obj2 = ref$ObjectRef.element;
            if (obj2 != null) {
                ref$ObjectRef.element = null;
                FlowCollector flowCollector = this.$downstream$inlined;
                Object obj3 = obj2 != cm1.NULL ? obj2 : null;
                this.L$0 = wt2Var;
                this.L$1 = obj2;
                this.label = 1;
                if (flowCollector.emit(obj3, this) == d) {
                    return d;
                }
            } else {
                return wt2.INSTANCE;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            wt2 wt2Var2 = (wt2) this.L$0;
            i32.b(obj);
        }
        return wt2.INSTANCE;
    }
}
