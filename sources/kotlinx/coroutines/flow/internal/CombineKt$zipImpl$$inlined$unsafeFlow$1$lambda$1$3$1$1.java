package kotlinx.coroutines.flow.internal;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.i32;
import tb.wt2;
import tb.xk;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T1", "T2", "R", "Ltb/wt2;", AdvanceSetting.NETWORK_TYPE, "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$2$invokeSuspend$$inlined$collect$1$lambda$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes11.dex */
final class CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$3$1$1 extends SuspendLambda implements Function2<wt2, Continuation<? super wt2>, Object> {
    final /* synthetic */ Object $value;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private wt2 p$0;
    final /* synthetic */ CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.AnonymousClass3.a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$3$1$1(Object obj, Continuation continuation, CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.AnonymousClass3.a aVar) {
        super(2, continuation);
        this.$value = obj;
        this.this$0 = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<wt2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$3$1$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$3$1$1 = new CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$3$1$1(this.$value, continuation, this.this$0);
        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$3$1$1.p$0 = (wt2) obj;
        return combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$3$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(wt2 wt2Var, Continuation<? super wt2> continuation) {
        return ((CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$3$1$1) create(wt2Var, continuation)).invokeSuspend(wt2.INSTANCE);
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
            ReceiveChannel receiveChannel = this.this$0.a.$second;
            this.L$0 = wt2Var;
            this.label = 1;
            obj = kotlinx.coroutines.channels.b.j0(receiveChannel, this);
            if (obj == d) {
                return d;
            }
        } else if (i != 1) {
            if (i == 2) {
                Object obj2 = this.L$1;
                i32.b(obj);
                this.L$0 = (wt2) this.L$0;
                this.L$1 = obj2;
                this.label = 3;
                if (((FlowCollector) this.L$2).emit(obj, this) == d) {
                    return d;
                }
            } else if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                wt2 wt2Var2 = (wt2) this.L$0;
                i32.b(obj);
            }
            return wt2.INSTANCE;
        } else {
            wt2 wt2Var3 = (wt2) this.L$0;
            i32.b(obj);
        }
        if (obj != null) {
            CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.this;
            FlowCollector flowCollector = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.$this_unsafeFlow;
            xk xkVar = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.this$0;
            throw null;
        }
        throw new AbortFlowException(CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.this.$this_unsafeFlow);
    }
}
