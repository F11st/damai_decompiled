package com.taobao.weex.devtools.inspector.protocol.module;

import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcResult;
import com.taobao.weex.devtools.json.annotation.JsonProperty;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SimpleBooleanResult implements JsonRpcResult {
    @JsonProperty(required = true)
    public boolean result;

    public SimpleBooleanResult() {
    }

    public SimpleBooleanResult(boolean z) {
        this.result = z;
    }
}
