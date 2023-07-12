package kotlinx.coroutines.flow;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.uplayer.AliMediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.i32;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", AdvanceSetting.NETWORK_TYPE, "Ltb/wt2;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1", f = "Migration.kt", i = {0, 0, 1, 1, 1, 1}, l = {AliMediaPlayer.TYPE_SUBTITLE_LIB_PATH, 216}, m = "invokeSuspend", n = {"$this$transformLatest", AdvanceSetting.NETWORK_TYPE, "$this$transformLatest", AdvanceSetting.NETWORK_TYPE, "$this$emitAll$iv", "flow$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes11.dex */
public final class FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<Object>, Object, Continuation<? super wt2>, Object> {
    final /* synthetic */ Function2 $transform;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    private FlowCollector p$;
    private Object p$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(Function2 function2, Continuation continuation) {
        super(3, continuation);
        this.$transform = function2;
    }

    @NotNull
    public final Continuation<wt2> create(@NotNull FlowCollector<Object> flowCollector, Object obj, @NotNull Continuation<? super wt2> continuation) {
        FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1 flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1 = new FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(this.$transform, continuation);
        flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1.p$ = flowCollector;
        flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1.p$0 = obj;
        return flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<Object> flowCollector, Object obj, Continuation<? super wt2> continuation) {
        return ((FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1) create(flowCollector, obj, continuation)).invokeSuspend(wt2.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object d;
        FlowCollector flowCollector;
        FlowCollector flowCollector2;
        Object obj2;
        d = kotlin.coroutines.intrinsics.b.d();
        int i = this.label;
        if (i == 0) {
            i32.b(obj);
            flowCollector = this.p$;
            Object obj3 = this.p$0;
            Function2 function2 = this.$transform;
            this.L$0 = flowCollector;
            this.L$1 = obj3;
            this.L$2 = flowCollector;
            this.label = 1;
            Object invoke = function2.invoke(obj3, this);
            if (invoke == d) {
                return d;
            }
            flowCollector2 = flowCollector;
            obj2 = obj3;
            obj = invoke;
        } else if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Flow flow = (Flow) this.L$3;
            FlowCollector flowCollector3 = (FlowCollector) this.L$2;
            FlowCollector flowCollector4 = (FlowCollector) this.L$0;
            i32.b(obj);
            return wt2.INSTANCE;
        } else {
            flowCollector = (FlowCollector) this.L$2;
            obj2 = this.L$1;
            flowCollector2 = (FlowCollector) this.L$0;
            i32.b(obj);
        }
        Flow flow2 = (Flow) obj;
        this.L$0 = flowCollector2;
        this.L$1 = obj2;
        this.L$2 = flowCollector;
        this.L$3 = flow2;
        this.label = 2;
        if (flow2.collect(flowCollector, this) == d) {
            return d;
        }
        return wt2.INSTANCE;
    }
}
