package com.alibaba.android.ultron.vfw.event;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface ViewRenderErrorListener {
    public static final String CODE_BIND_ERROR = "bind_view_error";
    public static final String CODE_CREATE_ERROR = "create_view_error";

    void onError(String str, String str2, String str3);
}
