package com.taobao.weex.devtools.inspector.protocol.module;

import android.content.Context;
import com.taobao.weex.devtools.common.Util;
import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcException;
import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcPeer;
import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcResult;
import com.taobao.weex.devtools.inspector.jsonrpc.protocol.JsonRpcError;
import com.taobao.weex.devtools.inspector.network.AsyncPrettyPrinterInitializer;
import com.taobao.weex.devtools.inspector.network.NetworkPeerManager;
import com.taobao.weex.devtools.inspector.network.ResponseBodyData;
import com.taobao.weex.devtools.inspector.network.ResponseBodyFileManager;
import com.taobao.weex.devtools.inspector.protocol.ChromeDevtoolsDomain;
import com.taobao.weex.devtools.inspector.protocol.ChromeDevtoolsMethod;
import com.taobao.weex.devtools.inspector.protocol.module.Console;
import com.taobao.weex.devtools.inspector.protocol.module.Page;
import com.taobao.weex.devtools.json.annotation.JsonProperty;
import com.taobao.weex.devtools.json.annotation.JsonValue;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Network implements ChromeDevtoolsDomain {
    private final NetworkPeerManager mNetworkPeerManager;
    private final ResponseBodyFileManager mResponseBodyFileManager;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class DataReceivedParams {
        @JsonProperty(required = true)
        public int dataLength;
        @JsonProperty(required = true)
        public int encodedDataLength;
        @JsonProperty(required = true)
        public String requestId;
        @JsonProperty(required = true)
        public double timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class GetResponseBodyResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public boolean base64Encoded;
        @JsonProperty(required = true)
        public String body;

        private GetResponseBodyResponse() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class Initiator {
        @JsonProperty
        public List<Console.CallFrame> stack;
        @JsonProperty(required = true)
        public String type;
        @JsonProperty
        public String url;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum InitiatorType {
        PARSER("parser"),
        SCRIPT("script"),
        OTHER("other");
        
        private final String mProtocolValue;

        InitiatorType(String str) {
            this.mProtocolValue = str;
        }

        @JsonValue
        public String getProtocolValue() {
            return this.mProtocolValue;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class LoadingFailedParams {
        @JsonProperty(required = true)
        public String errorText;
        @JsonProperty(required = true)
        public String requestId;
        @JsonProperty(required = true)
        public double timestamp;
        @JsonProperty
        public Page.ResourceType type;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class LoadingFinishedParams {
        @JsonProperty(required = true)
        public String requestId;
        @JsonProperty(required = true)
        public double timestamp;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class Request {
        @JsonProperty(required = true)
        public JSONObject headers;
        @JsonProperty(required = true)
        public String method;
        @JsonProperty
        public String postData;
        @JsonProperty(required = true)
        public String url;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class RequestWillBeSentParams {
        @JsonProperty(required = true)
        public String documentURL;
        @JsonProperty(required = true)
        public String frameId;
        @JsonProperty(required = true)
        public Initiator initiator;
        @JsonProperty(required = true)
        public String loaderId;
        @JsonProperty
        public Response redirectResponse;
        @JsonProperty(required = true)
        public Request request;
        @JsonProperty(required = true)
        public String requestId;
        @JsonProperty(required = true)
        public double timestamp;
        @JsonProperty
        public Page.ResourceType type;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class ResourceTiming {
        @JsonProperty(required = true)
        public double connectEnd;
        @JsonProperty(required = true)
        public double connectStart;
        @JsonProperty(required = true)
        public double dnsEnd;
        @JsonProperty(required = true)
        public double dnsStart;
        @JsonProperty(required = true)
        public double proxyEnd;
        @JsonProperty(required = true)
        public double proxyStart;
        @JsonProperty(required = true)
        public double receiveHeadersEnd;
        @JsonProperty(required = true)
        public double requestTime;
        @JsonProperty(required = true)
        public double sendEnd;
        @JsonProperty(required = true)
        public double sendStart;
        @JsonProperty(required = true)
        public double sslEnd;
        @JsonProperty(required = true)
        public double sslStart;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class Response {
        @JsonProperty(required = true)
        public int connectionId;
        @JsonProperty(required = true)
        public boolean connectionReused;
        @JsonProperty(required = true)
        public Boolean fromDiskCache;
        @JsonProperty(required = true)
        public JSONObject headers;
        @JsonProperty
        public String headersText;
        @JsonProperty(required = true)
        public String mimeType;
        @JsonProperty
        public JSONObject requestHeaders;
        @JsonProperty
        public String requestHeadersTest;
        @JsonProperty(required = true)
        public int status;
        @JsonProperty(required = true)
        public String statusText;
        @JsonProperty
        public ResourceTiming timing;
        @JsonProperty(required = true)
        public String url;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class ResponseReceivedParams {
        @JsonProperty(required = true)
        public String frameId;
        @JsonProperty(required = true)
        public String loaderId;
        @JsonProperty(required = true)
        public String requestId;
        @JsonProperty(required = true)
        public Response response;
        @JsonProperty(required = true)
        public double timestamp;
        @JsonProperty(required = true)
        public Page.ResourceType type;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class WebSocketClosedParams {
        @JsonProperty(required = true)
        public String requestId;
        @JsonProperty(required = true)
        public double timestamp;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class WebSocketCreatedParams {
        @JsonProperty(required = true)
        public String requestId;
        @JsonProperty(required = true)
        public String url;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class WebSocketFrame {
        @JsonProperty(required = true)
        public boolean mask;
        @JsonProperty(required = true)
        public int opcode;
        @JsonProperty(required = true)
        public String payloadData;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class WebSocketFrameErrorParams {
        @JsonProperty(required = true)
        public String errorMessage;
        @JsonProperty(required = true)
        public String requestId;
        @JsonProperty(required = true)
        public double timestamp;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class WebSocketFrameReceivedParams {
        @JsonProperty(required = true)
        public String requestId;
        @JsonProperty(required = true)
        public WebSocketFrame response;
        @JsonProperty(required = true)
        public double timestamp;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class WebSocketFrameSentParams {
        @JsonProperty(required = true)
        public String requestId;
        @JsonProperty(required = true)
        public WebSocketFrame response;
        @JsonProperty(required = true)
        public double timestamp;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class WebSocketHandshakeResponseReceivedParams {
        @JsonProperty(required = true)
        public String requestId;
        @JsonProperty(required = true)
        public WebSocketResponse response;
        @JsonProperty(required = true)
        public double timestamp;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class WebSocketRequest {
        @JsonProperty(required = true)
        public JSONObject headers;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class WebSocketResponse {
        @JsonProperty(required = true)
        public JSONObject headers;
        @JsonProperty
        public String headersText;
        @JsonProperty
        public JSONObject requestHeaders;
        @JsonProperty
        public String requestHeadersText;
        @JsonProperty(required = true)
        public int status;
        @JsonProperty(required = true)
        public String statusText;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class WebSocketWillSendHandshakeRequestParams {
        @JsonProperty(required = true)
        public WebSocketRequest request;
        @JsonProperty(required = true)
        public String requestId;
        @JsonProperty(required = true)
        public double timestamp;
        @JsonProperty(required = true)
        public double wallTime;
    }

    public Network(Context context) {
        NetworkPeerManager orCreateInstance = NetworkPeerManager.getOrCreateInstance(context);
        this.mNetworkPeerManager = orCreateInstance;
        this.mResponseBodyFileManager = orCreateInstance.getResponseBodyFileManager();
    }

    private GetResponseBodyResponse readResponseBody(String str) throws IOException, JsonRpcException {
        GetResponseBodyResponse getResponseBodyResponse = new GetResponseBodyResponse();
        try {
            ResponseBodyData readFile = this.mResponseBodyFileManager.readFile(str);
            getResponseBodyResponse.body = readFile.data;
            getResponseBodyResponse.base64Encoded = readFile.base64Encoded;
            return getResponseBodyResponse;
        } catch (OutOfMemoryError e) {
            throw new JsonRpcException(new JsonRpcError(JsonRpcError.ErrorCode.INTERNAL_ERROR, e.toString(), null));
        }
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mNetworkPeerManager.removePeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mNetworkPeerManager.addPeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult getResponseBody(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) throws JsonRpcException {
        try {
            return readResponseBody(jSONObject.getString("requestId"));
        } catch (IOException e) {
            throw new JsonRpcException(new JsonRpcError(JsonRpcError.ErrorCode.INTERNAL_ERROR, e.toString(), null));
        } catch (JSONException e2) {
            throw new JsonRpcException(new JsonRpcError(JsonRpcError.ErrorCode.INTERNAL_ERROR, e2.toString(), null));
        }
    }

    public void setPrettyPrinterInitializer(AsyncPrettyPrinterInitializer asyncPrettyPrinterInitializer) {
        Util.throwIfNull(asyncPrettyPrinterInitializer);
        this.mNetworkPeerManager.setPrettyPrinterInitializer(asyncPrettyPrinterInitializer);
    }

    @ChromeDevtoolsMethod
    public void setUserAgentOverride(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
    }
}
