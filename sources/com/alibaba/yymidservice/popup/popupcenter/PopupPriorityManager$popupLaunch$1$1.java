package com.alibaba.yymidservice.popup.popupcenter;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.wt2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@DebugMetadata(c = "com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager$popupLaunch$1$1", f = "PopupPriorityManager.kt", i = {}, l = {121, 124, 127}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
public final class PopupPriorityManager$popupLaunch$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super wt2>, Object> {
    int label;
    final /* synthetic */ PopupPriorityManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopupPriorityManager$popupLaunch$1$1(PopupPriorityManager popupPriorityManager, Continuation<? super PopupPriorityManager$popupLaunch$1$1> continuation) {
        super(2, continuation);
        this.this$0 = popupPriorityManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<wt2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PopupPriorityManager$popupLaunch$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super wt2> continuation) {
        return ((PopupPriorityManager$popupLaunch$1$1) create(coroutineScope, continuation)).invokeSuspend(wt2.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004c A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.d()
            int r1 = r5.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L25
            if (r1 == r4) goto L21
            if (r1 == r3) goto L1d
            if (r1 != r2) goto L15
            tb.i32.b(r6)
            goto L4d
        L15:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1d:
            tb.i32.b(r6)
            goto L40
        L21:
            tb.i32.b(r6)
            goto L33
        L25:
            tb.i32.b(r6)
            com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager r6 = r5.this$0
            r5.label = r4
            java.lang.Object r6 = com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager.d(r6, r5)
            if (r6 != r0) goto L33
            return r0
        L33:
            tb.kt1 r6 = (tb.kt1) r6
            com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager r1 = r5.this$0
            r5.label = r3
            java.lang.Object r6 = com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager.b(r1, r6, r5)
            if (r6 != r0) goto L40
            return r0
        L40:
            tb.kt1 r6 = (tb.kt1) r6
            com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager r1 = r5.this$0
            r5.label = r2
            java.lang.Object r6 = com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager.a(r1, r6, r5)
            if (r6 != r0) goto L4d
            return r0
        L4d:
            tb.i23 r6 = tb.i23.INSTANCE
            java.lang.String r0 = "PopupManager"
            java.lang.String r1 = "PopupPriorityManager 弹窗逻辑执行完成fromStartToEnd设置false "
            r6.a(r0, r1)
            com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager r6 = r5.this$0
            com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager.c(r6)
            tb.wt2 r6 = tb.wt2.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager$popupLaunch$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
