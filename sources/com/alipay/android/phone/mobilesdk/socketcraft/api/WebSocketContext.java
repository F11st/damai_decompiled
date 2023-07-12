package com.alipay.android.phone.mobilesdk.socketcraft.api;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface WebSocketContext {
    public static final String RESERVED_PREFIX = "ws.";

    void clear();

    Object getAttribute(String str);

    Object removeAttribute(String str);

    void setAttribute(String str, Object obj);
}
