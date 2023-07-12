package kotlinx.coroutines.flow;

import com.alibaba.wireless.security.SecExceptionCode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.i32;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/flow/SharingCommand;", "Ltb/wt2;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedLazily$command$1", f = "SharingStarted.kt", i = {0, 0, 0}, l = {SecExceptionCode.SEC_ERROR_STA_STORE_LOW_VERSION_DATA_FILE}, m = "invokeSuspend", n = {"$this$flow", "started", "$this$collect$iv"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes11.dex */
final class StartedLazily$command$1 extends SuspendLambda implements Function2<FlowCollector<? super SharingCommand>, Continuation<? super wt2>, Object> {
    final /* synthetic */ StateFlow $subscriptionCount;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private FlowCollector p$;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartedLazily$command$1(StateFlow stateFlow, Continuation continuation) {
        super(2, continuation);
        this.$subscriptionCount = stateFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<wt2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        StartedLazily$command$1 startedLazily$command$1 = new StartedLazily$command$1(this.$subscriptionCount, continuation);
        startedLazily$command$1.p$ = (FlowCollector) obj;
        return startedLazily$command$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super SharingCommand> flowCollector, Continuation<? super wt2> continuation) {
        return ((StartedLazily$command$1) create(flowCollector, continuation)).invokeSuspend(wt2.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object d;
        d = kotlin.coroutines.intrinsics.b.d();
        int i = this.label;
        if (i == 0) {
            i32.b(obj);
            FlowCollector flowCollector = this.p$;
            Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            ref$BooleanRef.element = false;
            StateFlow stateFlow = this.$subscriptionCount;
            StartedLazily$command$1$invokeSuspend$$inlined$collect$1 startedLazily$command$1$invokeSuspend$$inlined$collect$1 = new StartedLazily$command$1$invokeSuspend$$inlined$collect$1(flowCollector, ref$BooleanRef);
            this.L$0 = flowCollector;
            this.L$1 = ref$BooleanRef;
            this.L$2 = stateFlow;
            this.label = 1;
            if (stateFlow.collect(startedLazily$command$1$invokeSuspend$$inlined$collect$1, this) == d) {
                return d;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Flow flow = (Flow) this.L$2;
            Ref$BooleanRef ref$BooleanRef2 = (Ref$BooleanRef) this.L$1;
            FlowCollector flowCollector2 = (FlowCollector) this.L$0;
            i32.b(obj);
        }
        return wt2.INSTANCE;
    }
}
