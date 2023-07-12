package com.taobao.weex.devtools.inspector.protocol.module;

import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcPeer;
import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcResult;
import com.taobao.weex.devtools.inspector.protocol.ChromeDevtoolsDomain;
import com.taobao.weex.devtools.inspector.protocol.ChromeDevtoolsMethod;
import com.taobao.weex.devtools.json.annotation.JsonProperty;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Profiler implements ChromeDevtoolsDomain {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class ProfileHeader {
        @JsonProperty(required = true)
        String title;
        @JsonProperty(required = true)
        String typeId;
        @JsonProperty(required = true)
        int uid;

        private ProfileHeader() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class ProfileHeaderResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public List<ProfileHeader> headers;

        private ProfileHeaderResponse() {
        }
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult getProfileHeaders(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        ProfileHeaderResponse profileHeaderResponse = new ProfileHeaderResponse();
        profileHeaderResponse.headers = Collections.emptyList();
        return profileHeaderResponse;
    }

    @ChromeDevtoolsMethod
    public void setSamplingInterval(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
    }
}
