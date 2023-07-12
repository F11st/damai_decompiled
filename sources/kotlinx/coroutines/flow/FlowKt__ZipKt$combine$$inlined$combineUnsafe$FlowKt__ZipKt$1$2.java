package kotlinx.coroutines.flow;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.cn0;
import tb.i32;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "", AdvanceSetting.NETWORK_TYPE, "Ltb/wt2;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1$lambda$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2", f = "Zip.kt", i = {0, 0, 0, 0, 1, 1}, l = {336, 336}, m = "invokeSuspend", n = {"$this$combineInternal", AdvanceSetting.NETWORK_TYPE, "continuation", "args", "$this$combineInternal", AdvanceSetting.NETWORK_TYPE}, s = {"L$0", "L$1", "L$3", "L$4", "L$0", "L$1"})
/* loaded from: classes11.dex */
public final class FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2 extends SuspendLambda implements Function3<FlowCollector<Object>, Object[], Continuation<? super wt2>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    private FlowCollector p$;
    private Object[] p$0;
    final /* synthetic */ cn0 this$0;

    public FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2(Continuation continuation, cn0 cn0Var) {
        super(3, continuation);
    }

    @NotNull
    public final Continuation<wt2> create(@NotNull FlowCollector<Object> flowCollector, @NotNull Object[] objArr, @NotNull Continuation<? super wt2> continuation) {
        FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2 flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2 = new FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2(continuation, this.this$0);
        flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2.p$ = flowCollector;
        flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2.p$0 = objArr;
        return flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<Object> flowCollector, Object[] objArr, Continuation<? super wt2> continuation) {
        return ((FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2) create(flowCollector, objArr, continuation)).invokeSuspend(wt2.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object d;
        d = kotlin.coroutines.intrinsics.b.d();
        int i = this.label;
        if (i == 0) {
            i32.b(obj);
            throw null;
        }
        if (i == 1) {
            Object[] objArr = (Object[]) this.L$4;
            Continuation continuation = (Continuation) this.L$3;
            i32.b(obj);
            this.L$0 = (FlowCollector) this.L$0;
            this.L$1 = (Object[]) this.L$1;
            this.label = 2;
            if (((FlowCollector) this.L$2).emit(obj, this) == d) {
                return d;
            }
        } else if (i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Object[] objArr2 = (Object[]) this.L$1;
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            i32.b(obj);
        }
        return wt2.INSTANCE;
    }
}
