package com.alibaba.yymidservice.popup.popupcenter.view;

import com.alibaba.fastjson.JSONObject;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.nt1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class PopupViewHandle implements PopupViewHandleCallback {
    @NotNull
    private nt1<JSONObject> a;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public enum InterceptType {
        PREAPPEAR,
        SAMEAPPEAR,
        POSRAPPEAR,
        DEFAULT
    }

    public PopupViewHandle() {
        InterceptType interceptType = InterceptType.DEFAULT;
        this.a = new nt1<>();
    }

    @NotNull
    public final nt1<JSONObject> a() {
        return this.a;
    }

    public final void b(@NotNull InterceptType interceptType) {
        b41.i(interceptType, "<set-?>");
    }
}
