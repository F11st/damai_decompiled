package com.alibaba.yymidservice.popup.popupcenter;

import com.youku.uplayer.AliMediaPlayer;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@DebugMetadata(c = "com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager", f = "PopupPriorityManager.kt", i = {0, 0, 1}, l = {164, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT}, m = "lastHandle", n = {"this", "prePopupResult", "this"}, s = {"L$0", "L$1", "L$0"})
/* loaded from: classes8.dex */
public final class PopupPriorityManager$lastHandle$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PopupPriorityManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopupPriorityManager$lastHandle$1(PopupPriorityManager popupPriorityManager, Continuation<? super PopupPriorityManager$lastHandle$1> continuation) {
        super(continuation);
        this.this$0 = popupPriorityManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object g;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        g = this.this$0.g(null, this);
        return g;
    }
}
