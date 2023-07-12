package com.alibaba.yymidservice.popup.popupcenter.view;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@DebugMetadata(c = "com.alibaba.yymidservice.popup.popupcenter.view.MiddlePriortyDefaultHandle", f = "MiddlePriortyDefaultHandle.kt", i = {}, l = {15, 17}, m = "popHandle", n = {}, s = {})
/* loaded from: classes8.dex */
public final class MiddlePriortyDefaultHandle$popHandle$1<T, K> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MiddlePriortyDefaultHandle this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiddlePriortyDefaultHandle$popHandle$1(MiddlePriortyDefaultHandle middlePriortyDefaultHandle, Continuation<? super MiddlePriortyDefaultHandle$popHandle$1> continuation) {
        super(continuation);
        this.this$0 = middlePriortyDefaultHandle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.popHandle(null, null, this);
    }
}
