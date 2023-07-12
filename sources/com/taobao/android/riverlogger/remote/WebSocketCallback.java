package com.taobao.android.riverlogger.remote;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
interface WebSocketCallback {
    void onSocketClose(int i, String str);

    void onSocketError(String str);

    void onSocketMessage(String str);
}
