package kotlinx.coroutines;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.pa2;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ltb/pa2;", "Lkotlinx/coroutines/ChildJob;", "Ltb/wt2;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {0, 0, 1, 1, 1, 1, 1, 1}, l = {949, 951}, m = "invokeSuspend", n = {"$this$sequence", "state", "$this$sequence", "state", "list", "this_$iv", "cur$iv", AdvanceSetting.NETWORK_TYPE}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* loaded from: classes8.dex */
final class JobSupport$children$1 extends RestrictedSuspendLambda implements Function2<pa2<? super ChildJob>, Continuation<? super wt2>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    private pa2 p$;
    final /* synthetic */ JobSupport this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JobSupport$children$1(JobSupport jobSupport, Continuation continuation) {
        super(2, continuation);
        this.this$0 = jobSupport;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<wt2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        JobSupport$children$1 jobSupport$children$1 = new JobSupport$children$1(this.this$0, continuation);
        jobSupport$children$1.p$ = (pa2) obj;
        return jobSupport$children$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(pa2<? super ChildJob> pa2Var, Continuation<? super wt2> continuation) {
        return ((JobSupport$children$1) create(pa2Var, continuation)).invokeSuspend(wt2.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0081 -> B:27:0x009d). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x009a -> B:27:0x009d). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.d()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3a
            if (r1 == r3) goto L32
            if (r1 != r2) goto L2a
            java.lang.Object r1 = r10.L$5
            tb.mi r1 = (tb.mi) r1
            java.lang.Object r1 = r10.L$4
            tb.ma1 r1 = (tb.ma1) r1
            java.lang.Object r4 = r10.L$3
            tb.ka1 r4 = (tb.ka1) r4
            java.lang.Object r5 = r10.L$2
            tb.xk1 r5 = (tb.xk1) r5
            java.lang.Object r6 = r10.L$1
            java.lang.Object r7 = r10.L$0
            tb.pa2 r7 = (tb.pa2) r7
            tb.i32.b(r11)
            r11 = r10
            goto L9d
        L2a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L32:
            java.lang.Object r0 = r10.L$0
            tb.pa2 r0 = (tb.pa2) r0
            tb.i32.b(r11)
            goto La2
        L3a:
            tb.i32.b(r11)
            tb.pa2 r11 = r10.p$
            kotlinx.coroutines.JobSupport r1 = r10.this$0
            java.lang.Object r1 = r1.getState$kotlinx_coroutines_core()
            boolean r4 = r1 instanceof tb.mi
            if (r4 == 0) goto L5b
            r2 = r1
            tb.mi r2 = (tb.mi) r2
            kotlinx.coroutines.ChildJob r2 = r2.e
            r10.L$0 = r11
            r10.L$1 = r1
            r10.label = r3
            java.lang.Object r11 = r11.a(r2, r10)
            if (r11 != r0) goto La2
            return r0
        L5b:
            boolean r4 = r1 instanceof kotlinx.coroutines.Incomplete
            if (r4 == 0) goto La2
            r4 = r1
            kotlinx.coroutines.Incomplete r4 = (kotlinx.coroutines.Incomplete) r4
            tb.xk1 r4 = r4.getList()
            if (r4 == 0) goto La2
            java.lang.Object r5 = r4.j()
        */
        //  java.lang.String r6 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            java.util.Objects.requireNonNull(r5, r6)
            tb.ma1 r5 = (tb.ma1) r5
            r7 = r11
            r6 = r1
            r1 = r5
            r11 = r10
            r5 = r4
        L78:
            boolean r8 = tb.b41.d(r1, r4)
            r8 = r8 ^ r3
            if (r8 == 0) goto La2
            boolean r8 = r1 instanceof tb.mi
            if (r8 == 0) goto L9d
            r8 = r1
            tb.mi r8 = (tb.mi) r8
            kotlinx.coroutines.ChildJob r9 = r8.e
            r11.L$0 = r7
            r11.L$1 = r6
            r11.L$2 = r5
            r11.L$3 = r4
            r11.L$4 = r1
            r11.L$5 = r8
            r11.label = r2
            java.lang.Object r8 = r7.a(r9, r11)
            if (r8 != r0) goto L9d
            return r0
        L9d:
            tb.ma1 r1 = r1.k()
            goto L78
        La2:
            tb.wt2 r11 = tb.wt2.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport$children$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
