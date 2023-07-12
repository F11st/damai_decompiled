package com.taobao.weex.devtools.inspector.jsonrpc;

import com.taobao.weex.devtools.inspector.jsonrpc.protocol.JsonRpcResponse;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface PendingRequestCallback {
    void onResponse(JsonRpcPeer jsonRpcPeer, JsonRpcResponse jsonRpcResponse);
}
