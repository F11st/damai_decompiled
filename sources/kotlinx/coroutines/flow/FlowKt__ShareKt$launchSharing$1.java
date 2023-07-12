package kotlinx.coroutines.flow;

import com.alibaba.wireless.security.SecExceptionCode;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.i32;
import tb.id;
import tb.pk0;
import tb.wt2;
import tb.zb2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "Ltb/wt2;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1", f = "Share.kt", i = {0, 1, 2, 3}, l = {SecExceptionCode.SEC_ERROR_STA_STORE_KEY_NOT_EXSITED, 210, 211, 217}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$launch", "$this$launch"}, s = {"L$0", "L$0", "L$0", "L$0"})
/* loaded from: classes11.dex */
public final class FlowKt__ShareKt$launchSharing$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super wt2>, Object> {
    final /* synthetic */ Object $initialValue;
    final /* synthetic */ MutableSharedFlow $shared;
    final /* synthetic */ SharingStarted $started;
    final /* synthetic */ Flow $upstream;
    Object L$0;
    int label;
    private CoroutineScope p$;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", AdvanceSetting.NETWORK_TYPE, "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1", f = "Share.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Integer, Continuation<? super Boolean>, Object> {
        int label;
        private int p$0;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<wt2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            Number number = (Number) obj;
            number.intValue();
            anonymousClass1.p$0 = number.intValue();
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Integer num, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass1) create(num, continuation)).invokeSuspend(wt2.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.d();
            if (this.label == 0) {
                i32.b(obj);
                return id.a(this.p$0 > 0);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "Lkotlinx/coroutines/flow/SharingCommand;", AdvanceSetting.NETWORK_TYPE, "Ltb/wt2;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2", f = "Share.kt", i = {0}, l = {219}, m = "invokeSuspend", n = {AdvanceSetting.NETWORK_TYPE}, s = {"L$0"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2  reason: invalid class name */
    /* loaded from: classes11.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<SharingCommand, Continuation<? super wt2>, Object> {
        Object L$0;
        int label;
        private SharingCommand p$0;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<wt2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.p$0 = (SharingCommand) obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SharingCommand sharingCommand, Continuation<? super wt2> continuation) {
            return ((AnonymousClass2) create(sharingCommand, continuation)).invokeSuspend(wt2.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object d;
            d = kotlin.coroutines.intrinsics.b.d();
            int i = this.label;
            if (i == 0) {
                i32.b(obj);
                SharingCommand sharingCommand = this.p$0;
                int i2 = pk0.$EnumSwitchMapping$0[sharingCommand.ordinal()];
                if (i2 == 1) {
                    FlowKt__ShareKt$launchSharing$1 flowKt__ShareKt$launchSharing$1 = FlowKt__ShareKt$launchSharing$1.this;
                    Flow flow = flowKt__ShareKt$launchSharing$1.$upstream;
                    MutableSharedFlow mutableSharedFlow = flowKt__ShareKt$launchSharing$1.$shared;
                    this.L$0 = sharingCommand;
                    this.label = 1;
                    if (flow.collect(mutableSharedFlow, this) == d) {
                        return d;
                    }
                } else if (i2 == 3) {
                    FlowKt__ShareKt$launchSharing$1 flowKt__ShareKt$launchSharing$12 = FlowKt__ShareKt$launchSharing$1.this;
                    Object obj2 = flowKt__ShareKt$launchSharing$12.$initialValue;
                    if (obj2 == zb2.NO_VALUE) {
                        flowKt__ShareKt$launchSharing$12.$shared.resetReplayCache();
                    } else {
                        flowKt__ShareKt$launchSharing$12.$shared.tryEmit(obj2);
                    }
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                SharingCommand sharingCommand2 = (SharingCommand) this.L$0;
                i32.b(obj);
            }
            return wt2.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowKt__ShareKt$launchSharing$1(SharingStarted sharingStarted, Flow flow, MutableSharedFlow mutableSharedFlow, Object obj, Continuation continuation) {
        super(2, continuation);
        this.$started = sharingStarted;
        this.$upstream = flow;
        this.$shared = mutableSharedFlow;
        this.$initialValue = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<wt2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__ShareKt$launchSharing$1 flowKt__ShareKt$launchSharing$1 = new FlowKt__ShareKt$launchSharing$1(this.$started, this.$upstream, this.$shared, this.$initialValue, continuation);
        flowKt__ShareKt$launchSharing$1.p$ = (CoroutineScope) obj;
        return flowKt__ShareKt$launchSharing$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super wt2> continuation) {
        return ((FlowKt__ShareKt$launchSharing$1) create(coroutineScope, continuation)).invokeSuspend(wt2.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0078 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.d()
            int r1 = r8.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L2d
            if (r1 == r5) goto L25
            if (r1 == r4) goto L1d
            if (r1 == r3) goto L25
            if (r1 != r2) goto L15
            goto L25
        L15:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1d:
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            tb.i32.b(r9)
            goto L6a
        L25:
            java.lang.Object r0 = r8.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            tb.i32.b(r9)
            goto L99
        L2d:
            tb.i32.b(r9)
            kotlinx.coroutines.CoroutineScope r1 = r8.p$
            kotlinx.coroutines.flow.SharingStarted r9 = r8.$started
            kotlinx.coroutines.flow.SharingStarted$a r6 = kotlinx.coroutines.flow.SharingStarted.Companion
            kotlinx.coroutines.flow.SharingStarted r7 = r6.a()
            if (r9 != r7) goto L4b
            kotlinx.coroutines.flow.Flow r9 = r8.$upstream
            kotlinx.coroutines.flow.MutableSharedFlow r2 = r8.$shared
            r8.L$0 = r1
            r8.label = r5
            java.lang.Object r9 = r9.collect(r2, r8)
            if (r9 != r0) goto L99
            return r0
        L4b:
            kotlinx.coroutines.flow.SharingStarted r9 = r8.$started
            kotlinx.coroutines.flow.SharingStarted r5 = r6.b()
            r6 = 0
            if (r9 != r5) goto L79
            kotlinx.coroutines.flow.MutableSharedFlow r9 = r8.$shared
            kotlinx.coroutines.flow.StateFlow r9 = r9.getSubscriptionCount()
            kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1 r2 = new kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1
            r2.<init>(r6)
            r8.L$0 = r1
            r8.label = r4
            java.lang.Object r9 = kotlinx.coroutines.flow.c.m(r9, r2, r8)
            if (r9 != r0) goto L6a
            return r0
        L6a:
            kotlinx.coroutines.flow.Flow r9 = r8.$upstream
            kotlinx.coroutines.flow.MutableSharedFlow r2 = r8.$shared
            r8.L$0 = r1
            r8.label = r3
            java.lang.Object r9 = r9.collect(r2, r8)
            if (r9 != r0) goto L99
            return r0
        L79:
            kotlinx.coroutines.flow.SharingStarted r9 = r8.$started
            kotlinx.coroutines.flow.MutableSharedFlow r3 = r8.$shared
            kotlinx.coroutines.flow.StateFlow r3 = r3.getSubscriptionCount()
            kotlinx.coroutines.flow.Flow r9 = r9.command(r3)
            kotlinx.coroutines.flow.Flow r9 = kotlinx.coroutines.flow.c.j(r9)
            kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2 r3 = new kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2
            r3.<init>(r6)
            r8.L$0 = r1
            r8.label = r2
            java.lang.Object r9 = kotlinx.coroutines.flow.c.f(r9, r3, r8)
            if (r9 != r0) goto L99
            return r0
        L99:
            tb.wt2 r9 = tb.wt2.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
