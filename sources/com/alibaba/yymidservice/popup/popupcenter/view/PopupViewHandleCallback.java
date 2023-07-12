package com.alibaba.yymidservice.popup.popupcenter.view;

import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.kt1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface PopupViewHandleCallback {
    @Nullable
    <T, K> Object popHandle(@Nullable T t, @Nullable K k, @NotNull Continuation<? super kt1> continuation);
}
