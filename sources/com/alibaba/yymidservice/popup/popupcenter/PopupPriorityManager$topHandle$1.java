package com.alibaba.yymidservice.popup.popupcenter;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@DebugMetadata(c = "com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager", f = "PopupPriorityManager.kt", i = {0, 1}, l = {146, 151}, m = "topHandle", n = {"this", "this"}, s = {"L$0", "L$0"})
/* loaded from: classes8.dex */
public final class PopupPriorityManager$topHandle$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PopupPriorityManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopupPriorityManager$topHandle$1(PopupPriorityManager popupPriorityManager, Continuation<? super PopupPriorityManager$topHandle$1> continuation) {
        super(continuation);
        this.this$0 = popupPriorityManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object r;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        r = this.this$0.r(this);
        return r;
    }
}
