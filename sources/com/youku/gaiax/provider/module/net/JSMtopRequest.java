package com.youku.gaiax.provider.module.net;

import anet.channel.request.a;
import com.alibaba.fastjson.JSONObject;
import com.alipay.sdk.m.p.e;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import mtopsdk.mtop.domain.MethodEnum;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0016\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/youku/gaiax/provider/module/net/JSMtopRequest;", "Lcom/youku/gaiax/provider/module/net/YYBaseMtopRequest;", "Ljava/io/Serializable;", "Lmtopsdk/mtop/domain/MethodEnum;", "getHttpMethod", "", "", "getPictureParams", "getApiName", "getVersion", "", "getNeedEcode", "getNeedSession", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "Lcom/alibaba/fastjson/JSONObject;", "data", "Lcom/alibaba/fastjson/JSONObject;", "getData", "()Lcom/alibaba/fastjson/JSONObject;", "setData", "(Lcom/alibaba/fastjson/JSONObject;)V", "bodyParams", "<init>", "(Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;)V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class JSMtopRequest extends YYBaseMtopRequest implements Serializable {
    @Nullable
    private JSONObject bodyParams;
    @NotNull
    private JSONObject data;
    @NotNull
    private String url;

    public JSMtopRequest(@NotNull String str, @NotNull JSONObject jSONObject) {
        b41.i(str, "url");
        b41.i(jSONObject, "data");
        this.url = str;
        this.data = jSONObject;
        JSONObject jSONObject2 = jSONObject.getJSONObject("body");
        this.bodyParams = jSONObject2 == null ? new JSONObject() : jSONObject2;
        Boolean bool = this.data.getBoolean("enableWUA");
        setUseWua(Boolean.valueOf(bool == null ? false : bool.booleanValue()));
    }

    @Override // com.youku.gaiax.provider.module.net.YYBaseMtopRequest
    @NotNull
    public String getApiName() {
        return this.url;
    }

    @NotNull
    public final JSONObject getData() {
        return this.data;
    }

    @Override // com.youku.gaiax.provider.module.net.YYBaseMtopRequest
    @NotNull
    public MethodEnum getHttpMethod() {
        String string;
        JSONObject jSONObject = this.data;
        if (jSONObject == null || (string = jSONObject.getString("method")) == null) {
            string = "GET";
        }
        switch (string.hashCode()) {
            case 70454:
                if (string.equals("GET")) {
                    return MethodEnum.GET;
                }
                break;
            case 2213344:
                if (string.equals(a.c.HEAD)) {
                    return MethodEnum.HEAD;
                }
                break;
            case 2461856:
                if (string.equals("POST")) {
                    return MethodEnum.POST;
                }
                break;
            case 75900968:
                if (string.equals("PATCH")) {
                    return MethodEnum.PATCH;
                }
                break;
        }
        return MethodEnum.GET;
    }

    @Override // com.youku.gaiax.provider.module.net.YYBaseMtopRequest
    public boolean getNeedEcode() {
        Boolean bool;
        JSONObject jSONObject = this.bodyParams;
        boolean z = false;
        if (jSONObject != null && (bool = jSONObject.getBoolean("api_need_encode")) != null) {
            z = bool.booleanValue();
        }
        JSONObject jSONObject2 = this.bodyParams;
        if (jSONObject2 != null) {
            jSONObject2.remove("api_need_encode");
        }
        return z;
    }

    @Override // com.youku.gaiax.provider.module.net.YYBaseMtopRequest
    public boolean getNeedSession() {
        Boolean bool;
        JSONObject jSONObject = this.bodyParams;
        boolean z = false;
        if (jSONObject != null && (bool = jSONObject.getBoolean("api_need_session")) != null) {
            z = bool.booleanValue();
        }
        JSONObject jSONObject2 = this.bodyParams;
        if (jSONObject2 != null) {
            jSONObject2.remove("api_need_session");
        }
        return z;
    }

    @Override // com.youku.gaiax.provider.module.net.YYBaseMtopRequest
    @Nullable
    public Map<String, String> getPictureParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject jSONObject = this.bodyParams;
        if (jSONObject != null) {
            for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
                String key = entry.getKey();
                b41.h(key, "it.key");
                linkedHashMap.put(key, entry.getValue().toString());
            }
        }
        return linkedHashMap;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @Override // com.youku.gaiax.provider.module.net.YYBaseMtopRequest
    @NotNull
    public String getVersion() {
        String string;
        String string2;
        JSONObject jSONObject = this.data;
        String str = "";
        if (jSONObject != null && (string2 = jSONObject.getString(e.l)) != null) {
            str = string2;
        }
        JSONObject jSONObject2 = this.bodyParams;
        if (jSONObject2 != null && (string = jSONObject2.getString(e.l)) != null) {
            str = string;
        }
        JSONObject jSONObject3 = this.bodyParams;
        if (jSONObject3 != null) {
            jSONObject3.remove(e.l);
        }
        return str;
    }

    public final void setData(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "<set-?>");
        this.data = jSONObject;
    }

    public final void setUrl(@NotNull String str) {
        b41.i(str, "<set-?>");
        this.url = str;
    }
}
