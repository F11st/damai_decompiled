package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.i32;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "Ltb/wt2;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1", f = "Share.kt", i = {0, 0, 0}, l = {415}, m = "invokeSuspend", n = {"$this$launch", "state", "$this$collect$iv"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes11.dex */
final class FlowKt__ShareKt$launchSharingDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super wt2>, Object> {
    final /* synthetic */ CompletableDeferred $result;
    final /* synthetic */ Flow $upstream;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private CoroutineScope p$;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class a implements FlowCollector<Object> {
        final /* synthetic */ CoroutineScope b;
        final /* synthetic */ Ref$ObjectRef c;

        public a(CoroutineScope coroutineScope, Ref$ObjectRef ref$ObjectRef) {
            this.b = coroutineScope;
            this.c = ref$ObjectRef;
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [T, kotlinx.coroutines.flow.MutableStateFlow] */
        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(Object obj, @NotNull Continuation continuation) {
            wt2 wt2Var;
            Object d;
            Ref$ObjectRef ref$ObjectRef = this.c;
            MutableStateFlow mutableStateFlow = (MutableStateFlow) ref$ObjectRef.element;
            if (mutableStateFlow != null) {
                mutableStateFlow.setValue(obj);
                wt2Var = wt2.INSTANCE;
            } else {
                ?? a = m.a(obj);
                FlowKt__ShareKt$launchSharingDeferred$1.this.$result.complete(c.a(a));
                wt2 wt2Var2 = wt2.INSTANCE;
                ref$ObjectRef.element = a;
                wt2Var = wt2Var2;
            }
            d = kotlin.coroutines.intrinsics.b.d();
            return wt2Var == d ? wt2Var : wt2.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowKt__ShareKt$launchSharingDeferred$1(Flow flow, CompletableDeferred completableDeferred, Continuation continuation) {
        super(2, continuation);
        this.$upstream = flow;
        this.$result = completableDeferred;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<wt2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__ShareKt$launchSharingDeferred$1 flowKt__ShareKt$launchSharingDeferred$1 = new FlowKt__ShareKt$launchSharingDeferred$1(this.$upstream, this.$result, continuation);
        flowKt__ShareKt$launchSharingDeferred$1.p$ = (CoroutineScope) obj;
        return flowKt__ShareKt$launchSharingDeferred$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super wt2> continuation) {
        return ((FlowKt__ShareKt$launchSharingDeferred$1) create(coroutineScope, continuation)).invokeSuspend(wt2.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object d;
        d = kotlin.coroutines.intrinsics.b.d();
        int i = this.label;
        try {
            if (i == 0) {
                i32.b(obj);
                CoroutineScope coroutineScope = this.p$;
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.element = null;
                Flow flow = this.$upstream;
                a aVar = new a(coroutineScope, ref$ObjectRef);
                this.L$0 = coroutineScope;
                this.L$1 = ref$ObjectRef;
                this.L$2 = flow;
                this.label = 1;
                if (flow.collect(aVar, this) == d) {
                    return d;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                Flow flow2 = (Flow) this.L$2;
                Ref$ObjectRef ref$ObjectRef2 = (Ref$ObjectRef) this.L$1;
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                i32.b(obj);
            }
            return wt2.INSTANCE;
        } catch (Throwable th) {
            this.$result.completeExceptionally(th);
            throw th;
        }
    }
}
