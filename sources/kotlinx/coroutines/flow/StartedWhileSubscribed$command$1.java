package kotlinx.coroutines.flow;

import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.youku.uplayer.AliMediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/flow/SharingCommand;", "", AdUtConstants.XAD_UT_ARG_COUNT, "Ltb/wt2;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4}, l = {AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_DOWNLOAD_TIMEOUT_FACTOR, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_IS_WIFI, 185, AliMediaPlayer.UPLAYER_UPS_START_GEAR, AliMediaPlayer.UPLAYER_PROPERTY_DRM_LICENSE_URI}, m = "invokeSuspend", n = {"$this$transformLatest", AdUtConstants.XAD_UT_ARG_COUNT, "$this$transformLatest", AdUtConstants.XAD_UT_ARG_COUNT, "$this$transformLatest", AdUtConstants.XAD_UT_ARG_COUNT, "$this$transformLatest", AdUtConstants.XAD_UT_ARG_COUNT, "$this$transformLatest", AdUtConstants.XAD_UT_ARG_COUNT}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
/* loaded from: classes11.dex */
final class StartedWhileSubscribed$command$1 extends SuspendLambda implements Function3<FlowCollector<? super SharingCommand>, Integer, Continuation<? super wt2>, Object> {
    int I$0;
    Object L$0;
    int label;
    private FlowCollector p$;
    private int p$0;
    final /* synthetic */ C8687l this$0;

    StartedWhileSubscribed$command$1(C8687l c8687l, Continuation continuation) {
        super(3, continuation);
    }

    @NotNull
    public final Continuation<wt2> create(@NotNull FlowCollector<? super SharingCommand> flowCollector, int i, @NotNull Continuation<? super wt2> continuation) {
        StartedWhileSubscribed$command$1 startedWhileSubscribed$command$1 = new StartedWhileSubscribed$command$1(this.this$0, continuation);
        startedWhileSubscribed$command$1.p$ = flowCollector;
        startedWhileSubscribed$command$1.p$0 = i;
        return startedWhileSubscribed$command$1;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super SharingCommand> flowCollector, Integer num, Continuation<? super wt2> continuation) {
        return ((StartedWhileSubscribed$command$1) create(flowCollector, num.intValue(), continuation)).invokeSuspend(wt2.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a2  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.C8233a.d()
            int r1 = r10.label
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L47
            if (r1 == r6) goto L3f
            if (r1 == r5) goto L35
            if (r1 == r4) goto L2b
            if (r1 == r3) goto L20
            if (r1 != r2) goto L18
            goto L3f
        L18:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L20:
            int r1 = r10.I$0
            java.lang.Object r3 = r10.L$0
            kotlinx.coroutines.flow.FlowCollector r3 = (kotlinx.coroutines.flow.FlowCollector) r3
            tb.i32.b(r11)
            goto La3
        L2b:
            int r1 = r10.I$0
            java.lang.Object r4 = r10.L$0
            kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
            tb.i32.b(r11)
            goto L8f
        L35:
            int r1 = r10.I$0
            java.lang.Object r5 = r10.L$0
            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
            tb.i32.b(r11)
            goto L73
        L3f:
            java.lang.Object r0 = r10.L$0
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            tb.i32.b(r11)
            goto Lb3
        L47:
            tb.i32.b(r11)
            kotlinx.coroutines.flow.FlowCollector r11 = r10.p$
            int r1 = r10.p$0
            if (r1 <= 0) goto L5f
            kotlinx.coroutines.flow.SharingCommand r2 = kotlinx.coroutines.flow.SharingCommand.START
            r10.L$0 = r11
            r10.I$0 = r1
            r10.label = r6
            java.lang.Object r11 = r11.emit(r2, r10)
            if (r11 != r0) goto Lb3
            return r0
        L5f:
            kotlinx.coroutines.flow.l r6 = r10.this$0
            long r6 = kotlinx.coroutines.flow.C8687l.b(r6)
            r10.L$0 = r11
            r10.I$0 = r1
            r10.label = r5
            java.lang.Object r5 = kotlinx.coroutines.C8696j.a(r6, r10)
            if (r5 != r0) goto L72
            return r0
        L72:
            r5 = r11
        L73:
            kotlinx.coroutines.flow.l r11 = r10.this$0
            long r6 = kotlinx.coroutines.flow.C8687l.a(r11)
            r8 = 0
            int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r11 <= 0) goto La4
            kotlinx.coroutines.flow.SharingCommand r11 = kotlinx.coroutines.flow.SharingCommand.STOP
            r10.L$0 = r5
            r10.I$0 = r1
            r10.label = r4
            java.lang.Object r11 = r5.emit(r11, r10)
            if (r11 != r0) goto L8e
            return r0
        L8e:
            r4 = r5
        L8f:
            kotlinx.coroutines.flow.l r11 = r10.this$0
            long r5 = kotlinx.coroutines.flow.C8687l.a(r11)
            r10.L$0 = r4
            r10.I$0 = r1
            r10.label = r3
            java.lang.Object r11 = kotlinx.coroutines.C8696j.a(r5, r10)
            if (r11 != r0) goto La2
            return r0
        La2:
            r3 = r4
        La3:
            r5 = r3
        La4:
            kotlinx.coroutines.flow.SharingCommand r11 = kotlinx.coroutines.flow.SharingCommand.STOP_AND_RESET_REPLAY_CACHE
            r10.L$0 = r5
            r10.I$0 = r1
            r10.label = r2
            java.lang.Object r11 = r5.emit(r11, r10)
            if (r11 != r0) goto Lb3
            return r0
        Lb3:
            tb.wt2 r11 = tb.wt2.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StartedWhileSubscribed$command$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
