package com.alibaba.yymidservice.popup.popupcenter.view;

import io.flutter.wpkbridge.WPKFactory;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@DebugMetadata(c = "com.alibaba.yymidservice.popup.popupcenter.view.PopupDialogKt", f = "PopupDialog.kt", i = {0}, l = {23, 25}, m = "showDialog", n = {WPKFactory.INIT_KEY_CONTEXT}, s = {"L$0"})
/* loaded from: classes8.dex */
public final class PopupDialogKt$showDialog$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PopupDialogKt$showDialog$1(Continuation<? super PopupDialogKt$showDialog$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return PopupDialogKt.a(null, null, this);
    }
}
