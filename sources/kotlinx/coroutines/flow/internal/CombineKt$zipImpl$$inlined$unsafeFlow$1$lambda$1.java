package kotlinx.coroutines.flow.internal;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.i32;
import tb.wt2;
import tb.xk;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T1", "T2", "R", "Lkotlinx/coroutines/CoroutineScope;", "Ltb/wt2;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes11.dex */
public final class CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super wt2>, Object> {
    final /* synthetic */ FlowCollector $this_unsafeFlow;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ xk this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"T1", "T2", "R", "Lkotlinx/coroutines/channels/ProducerScope;", "", "Ltb/wt2;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$second$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ProducerScope<? super Object>, Continuation<? super wt2>, Object> {
        Object L$0;
        Object L$1;
        int label;
        private ProducerScope p$;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<wt2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.p$ = (ProducerScope) obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super Object> producerScope, Continuation<? super wt2> continuation) {
            return ((AnonymousClass1) create(producerScope, continuation)).invokeSuspend(wt2.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.d();
            int i = this.label;
            if (i == 0) {
                i32.b(obj);
                xk xkVar = CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.this.this$0;
                throw null;
            } else if (i == 1) {
                Flow flow = (Flow) this.L$1;
                ProducerScope producerScope = (ProducerScope) this.L$0;
                i32.b(obj);
                return wt2.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T1", "T2", "R", "Ltb/wt2;", AdvanceSetting.NETWORK_TYPE, "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$2", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$3  reason: invalid class name */
    /* loaded from: classes11.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<wt2, Continuation<? super wt2>, Object> {
        final /* synthetic */ Object $cnt;
        final /* synthetic */ CoroutineContext $scopeContext;
        final /* synthetic */ ReceiveChannel $second;
        Object L$0;
        Object L$1;
        int label;
        private wt2 p$0;

        /* compiled from: Taobao */
        /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$3$a */
        /* loaded from: classes11.dex */
        public static final class a implements FlowCollector<Object> {
            final /* synthetic */ AnonymousClass3 a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(CoroutineContext coroutineContext, Object obj, ReceiveChannel receiveChannel, Continuation continuation) {
            super(2, continuation);
            this.$scopeContext = coroutineContext;
            this.$cnt = obj;
            this.$second = receiveChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<wt2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$scopeContext, this.$cnt, this.$second, continuation);
            anonymousClass3.p$0 = (wt2) obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(wt2 wt2Var, Continuation<? super wt2> continuation) {
            return ((AnonymousClass3) create(wt2Var, continuation)).invokeSuspend(wt2.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.d();
            int i = this.label;
            if (i == 0) {
                i32.b(obj);
                xk xkVar = CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.this.this$0;
                throw null;
            } else if (i == 1) {
                Flow flow = (Flow) this.L$1;
                wt2 wt2Var = (wt2) this.L$0;
                i32.b(obj);
                return wt2.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1(FlowCollector flowCollector, Continuation continuation, xk xkVar) {
        super(2, continuation);
        this.$this_unsafeFlow = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<wt2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = new CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1(this.$this_unsafeFlow, continuation, this.this$0);
        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.p$ = (CoroutineScope) obj;
        return combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super wt2> continuation) {
        return ((CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) create(coroutineScope, continuation)).invokeSuspend(wt2.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a0, code lost:
        if (r1.isClosedForReceive() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a2, code lost:
        kotlinx.coroutines.channels.ReceiveChannel.a.b(r1, null, 1, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b4, code lost:
        if (r1.isClosedForReceive() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b9, code lost:
        return tb.wt2.INSTANCE;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r1v5 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r21) {
        /*
            r20 = this;
            r8 = r20
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.d()
            int r1 = r8.label
            r9 = 1
            r10 = 0
            if (r1 == 0) goto L32
            if (r1 != r9) goto L2a
            java.lang.Object r0 = r8.L$3
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            java.lang.Object r0 = r8.L$2
            kotlinx.coroutines.CompletableJob r0 = (kotlinx.coroutines.CompletableJob) r0
            java.lang.Object r0 = r8.L$1
            r1 = r0
            kotlinx.coroutines.channels.ReceiveChannel r1 = (kotlinx.coroutines.channels.ReceiveChannel) r1
            java.lang.Object r0 = r8.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            tb.i32.b(r21)     // Catch: java.lang.Throwable -> L24 kotlinx.coroutines.flow.internal.AbortFlowException -> L27
            goto L9c
        L24:
            r0 = move-exception
            goto Lba
        L27:
            r0 = move-exception
            goto Lab
        L2a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L32:
            tb.i32.b(r21)
            kotlinx.coroutines.CoroutineScope r11 = r8.p$
            r3 = 0
            r4 = 0
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$1 r5 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$1
            r5.<init>(r10)
            r6 = 3
            r7 = 0
            r2 = r11
            kotlinx.coroutines.channels.ReceiveChannel r12 = kotlinx.coroutines.channels.ProduceKt.e(r2, r3, r4, r5, r6, r7)
            kotlinx.coroutines.CompletableJob r7 = tb.d61.b(r10, r9, r10)
            java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>"
            java.util.Objects.requireNonNull(r12, r1)
            r1 = r12
            kotlinx.coroutines.channels.SendChannel r1 = (kotlinx.coroutines.channels.SendChannel) r1
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$2 r2 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$2
            r2.<init>()
            r1.invokeOnClose(r2)
            kotlin.coroutines.CoroutineContext r13 = r11.getCoroutineContext()     // Catch: java.lang.Throwable -> La6 kotlinx.coroutines.flow.internal.AbortFlowException -> La9
            java.lang.Object r14 = kotlinx.coroutines.internal.ThreadContextKt.b(r13)     // Catch: java.lang.Throwable -> La6 kotlinx.coroutines.flow.internal.AbortFlowException -> La9
            kotlin.coroutines.CoroutineContext r1 = r11.getCoroutineContext()     // Catch: java.lang.Throwable -> La6 kotlinx.coroutines.flow.internal.AbortFlowException -> La9
            kotlin.coroutines.CoroutineContext r15 = r1.plus(r7)     // Catch: java.lang.Throwable -> La6 kotlinx.coroutines.flow.internal.AbortFlowException -> La9
            tb.wt2 r16 = tb.wt2.INSTANCE     // Catch: java.lang.Throwable -> La6 kotlinx.coroutines.flow.internal.AbortFlowException -> La9
            r17 = 0
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$3 r18 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$3     // Catch: java.lang.Throwable -> La6 kotlinx.coroutines.flow.internal.AbortFlowException -> La9
            r6 = 0
            r1 = r18
            r2 = r20
            r3 = r13
            r4 = r14
            r5 = r12
            r1.<init>(r3, r4, r5, r6)     // Catch: java.lang.Throwable -> La6 kotlinx.coroutines.flow.internal.AbortFlowException -> La9
            r6 = 4
            r19 = 0
            r8.L$0 = r11     // Catch: java.lang.Throwable -> La6 kotlinx.coroutines.flow.internal.AbortFlowException -> La9
            r8.L$1 = r12     // Catch: java.lang.Throwable -> La6 kotlinx.coroutines.flow.internal.AbortFlowException -> La9
            r8.L$2 = r7     // Catch: java.lang.Throwable -> La6 kotlinx.coroutines.flow.internal.AbortFlowException -> La9
            r8.L$3 = r13     // Catch: java.lang.Throwable -> La6 kotlinx.coroutines.flow.internal.AbortFlowException -> La9
            r8.L$4 = r14     // Catch: java.lang.Throwable -> La6 kotlinx.coroutines.flow.internal.AbortFlowException -> La9
            r8.label = r9     // Catch: java.lang.Throwable -> La6 kotlinx.coroutines.flow.internal.AbortFlowException -> La9
            r1 = r15
            r2 = r16
            r3 = r17
            r4 = r18
            r5 = r20
            r7 = r19
            java.lang.Object r1 = kotlinx.coroutines.flow.internal.a.c(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> La6 kotlinx.coroutines.flow.internal.AbortFlowException -> La9
            if (r1 != r0) goto L9b
            return r0
        L9b:
            r1 = r12
        L9c:
            boolean r0 = r1.isClosedForReceive()
            if (r0 != 0) goto Lb7
        La2:
            kotlinx.coroutines.channels.ReceiveChannel.a.b(r1, r10, r9, r10)
            goto Lb7
        La6:
            r0 = move-exception
            r1 = r12
            goto Lba
        La9:
            r0 = move-exception
            r1 = r12
        Lab:
            kotlinx.coroutines.flow.FlowCollector r2 = r8.$this_unsafeFlow     // Catch: java.lang.Throwable -> L24
            tb.ok0.a(r0, r2)     // Catch: java.lang.Throwable -> L24
            boolean r0 = r1.isClosedForReceive()
            if (r0 != 0) goto Lb7
            goto La2
        Lb7:
            tb.wt2 r0 = tb.wt2.INSTANCE
            return r0
        Lba:
            boolean r2 = r1.isClosedForReceive()
            if (r2 != 0) goto Lc3
            kotlinx.coroutines.channels.ReceiveChannel.a.b(r1, r10, r9, r10)
        Lc3:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
