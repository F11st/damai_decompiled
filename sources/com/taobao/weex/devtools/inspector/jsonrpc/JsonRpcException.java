package com.taobao.weex.devtools.inspector.jsonrpc;

import com.taobao.weex.devtools.common.Util;
import com.taobao.weex.devtools.inspector.jsonrpc.protocol.JsonRpcError;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class JsonRpcException extends Exception {
    private final JsonRpcError mErrorMessage;

    public JsonRpcException(JsonRpcError jsonRpcError) {
        super(jsonRpcError.code + ": " + jsonRpcError.message);
        this.mErrorMessage = (JsonRpcError) Util.throwIfNull(jsonRpcError);
    }

    public JsonRpcError getErrorMessage() {
        return this.mErrorMessage;
    }
}
