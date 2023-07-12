package com.taobao.weex.devtools.inspector.jsonrpc.protocol;

import android.annotation.SuppressLint;
import com.taobao.weex.devtools.json.annotation.JsonProperty;
import com.taobao.weex.devtools.json.annotation.JsonValue;
import javax.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: Taobao */
@SuppressLint({"UsingDefaultJsonDeserializer", "EmptyJsonPropertyUse"})
/* loaded from: classes11.dex */
public class JsonRpcError {
    @JsonProperty(required = true)
    public ErrorCode code;
    @JsonProperty
    public JSONObject data;
    @JsonProperty(required = true)
    public String message;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum ErrorCode {
        PARSER_ERROR(-32700),
        INVALID_REQUEST(-32600),
        METHOD_NOT_FOUND(-32601),
        INVALID_PARAMS(-32602),
        INTERNAL_ERROR(-32603);
        
        private final int mProtocolValue;

        ErrorCode(int i) {
            this.mProtocolValue = i;
        }

        @JsonValue
        public int getProtocolValue() {
            return this.mProtocolValue;
        }
    }

    public JsonRpcError() {
    }

    public JsonRpcError(ErrorCode errorCode, String str, @Nullable JSONObject jSONObject) {
        this.code = errorCode;
        this.message = str;
        this.data = jSONObject;
    }
}
