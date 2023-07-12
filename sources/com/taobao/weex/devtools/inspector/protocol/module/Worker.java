package com.taobao.weex.devtools.inspector.protocol.module;

import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcPeer;
import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcResult;
import com.taobao.weex.devtools.inspector.protocol.ChromeDevtoolsDomain;
import com.taobao.weex.devtools.inspector.protocol.ChromeDevtoolsMethod;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Worker implements ChromeDevtoolsDomain {
    @ChromeDevtoolsMethod
    public JsonRpcResult canInspectWorkers(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        return new SimpleBooleanResult(true);
    }
}
