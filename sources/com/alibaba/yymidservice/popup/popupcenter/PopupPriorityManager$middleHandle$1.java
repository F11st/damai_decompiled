package com.alibaba.yymidservice.popup.popupcenter;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@DebugMetadata(c = "com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager", f = "PopupPriorityManager.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 8}, l = {191, 192, 196, 198, 209, 213, 232, 243, 244}, m = "middleHandle", n = {"this", "prePopupResult", "interceptPreViewHandle", "interceptSameViewHandle", "interceptPostViewHandle", "this", "prePopupResult", "interceptSameViewHandle", "interceptPostViewHandle", "this", "prePopupResult", "interceptSameViewHandle", "interceptPostViewHandle", "this", "prePopupResult", "interceptPostViewHandle", "detailBean", "this", "interceptPostViewHandle", "detailBean", "map", "this", "interceptPostViewHandle", "detailBean", "map", "this", "interceptPostViewHandle", "detailBean", "map", "interceptPostViewHandle", "middleResult", "middleResult"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$0"})
/* loaded from: classes8.dex */
public final class PopupPriorityManager$middleHandle$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PopupPriorityManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopupPriorityManager$middleHandle$1(PopupPriorityManager popupPriorityManager, Continuation<? super PopupPriorityManager$middleHandle$1> continuation) {
        super(continuation);
        this.this$0 = popupPriorityManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object i;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        i = this.this$0.i(null, this);
        return i;
    }
}
