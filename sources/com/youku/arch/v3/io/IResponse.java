package com.youku.arch.v3.io;

import com.ali.user.open.core.util.ParamsConstants;
import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0016\u0010\u000f\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0004R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\nR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\nR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\nR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00198&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010!\u001a\u0004\u0018\u00010\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\b\"\u0004\b \u0010\nR\u0016\u0010#\u001a\u00020\"8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010%8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lcom/youku/arch/v3/io/IResponse;", "Ljava/io/Serializable;", "", "getId", "()J", "id", "", "getTraceId", "()Ljava/lang/String;", "setTraceId", "(Ljava/lang/String;)V", ParamsConstants.Key.PARAM_TRACE_ID, "getCacheTag", "cacheTag", "getTimestamp", "timestamp", "getRawData", "setRawData", "rawData", "getRetCode", "setRetCode", "retCode", "getRetMessage", "setRetMessage", "retMessage", "Lcom/alibaba/fastjson/JSONObject;", "getJsonObject", "()Lcom/alibaba/fastjson/JSONObject;", "setJsonObject", "(Lcom/alibaba/fastjson/JSONObject;)V", "jsonObject", "getSource", "setSource", "source", "", "isSuccess", "()Z", "Lcom/youku/arch/v3/io/IRequest;", "getRequest", "()Lcom/youku/arch/v3/io/IRequest;", "request", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IResponse extends Serializable {
    @Nullable
    String getCacheTag();

    long getId();

    @Nullable
    JSONObject getJsonObject();

    @Nullable
    String getRawData();

    @Nullable
    IRequest getRequest();

    @Nullable
    String getRetCode();

    @Nullable
    String getRetMessage();

    @Nullable
    String getSource();

    long getTimestamp();

    @Nullable
    String getTraceId();

    boolean isSuccess();

    void setJsonObject(@Nullable JSONObject jSONObject);

    void setRawData(@Nullable String str);

    void setRetCode(@Nullable String str);

    void setRetMessage(@Nullable String str);

    void setSource(@Nullable String str);

    void setTraceId(@Nullable String str);
}
