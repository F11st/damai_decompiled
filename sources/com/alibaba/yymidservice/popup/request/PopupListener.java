package com.alibaba.yymidservice.popup.request;

import com.alibaba.yymidservice.popup.request.bean.PopupResponseBean;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface PopupListener {
    void clickUpReport();

    void onFail(@Nullable String str, @Nullable String str2);

    void onSuccess(@NotNull PopupResponseBean popupResponseBean);
}
