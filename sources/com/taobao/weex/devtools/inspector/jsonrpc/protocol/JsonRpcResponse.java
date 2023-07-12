package com.taobao.weex.devtools.inspector.jsonrpc.protocol;

import android.annotation.SuppressLint;
import com.taobao.weex.devtools.json.annotation.JsonProperty;
import org.json.JSONObject;

/* compiled from: Taobao */
@SuppressLint({"UsingDefaultJsonDeserializer", "EmptyJsonPropertyUse"})
/* loaded from: classes11.dex */
public class JsonRpcResponse {
    @JsonProperty
    public JSONObject error;
    @JsonProperty(required = true)
    public long id;
    @JsonProperty
    public JSONObject result;
}
