package com.youku.arch.v3.data;

import android.text.TextUtils;
import com.ali.user.open.core.util.ParamsConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u00014B\u000f\u0012\u0006\u00101\u001a\u000200¢\u0006\u0004\b2\u00103R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\rR$\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR$\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000fR$\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000fR$\u0010\"\u001a\u0004\u0018\u00010!8F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001b\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020-8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00065"}, d2 = {"Lcom/youku/arch/v3/data/Response;", "Lcom/youku/arch/v3/io/IResponse;", "", "id", "J", "getId", "()J", "setId", "(J)V", "", ParamsConstants.Key.PARAM_TRACE_ID, "Ljava/lang/String;", "getTraceId", "()Ljava/lang/String;", "setTraceId", "(Ljava/lang/String;)V", "timestamp", "getTimestamp", "setTimestamp", "cacheTag", "getCacheTag", "rawData", "getRawData", "setRawData", "source", "getSource", "setSource", "retCode", "getRetCode", "setRetCode", "retMessage", "getRetMessage", "setRetMessage", "Lcom/alibaba/fastjson/JSONObject;", "jsonObject", "Lcom/alibaba/fastjson/JSONObject;", "getJsonObject", "()Lcom/alibaba/fastjson/JSONObject;", "setJsonObject", "(Lcom/alibaba/fastjson/JSONObject;)V", "Lcom/youku/arch/v3/io/IRequest;", "request", "Lcom/youku/arch/v3/io/IRequest;", "getRequest", "()Lcom/youku/arch/v3/io/IRequest;", "", "isSuccess", "()Z", "Lcom/youku/arch/v3/data/Response$Builder;", "builder", "<init>", "(Lcom/youku/arch/v3/data/Response$Builder;)V", "Builder", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class Response implements IResponse {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private final String cacheTag;
    private long id;
    @Nullable
    private JSONObject jsonObject;
    @Nullable
    private String rawData;
    @Nullable
    private final IRequest request;
    @Nullable
    private String retCode;
    @Nullable
    private String retMessage;
    @Nullable
    private String source;
    private long timestamp;
    @Nullable
    private String traceId;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0005J\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\bJ\b\u0010\u001b\u001a\u00020\u001aH\u0016R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u001cR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001dR\u0016\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001cR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u001dR\u0018\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u001dR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u001dR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001dR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u001dR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u001eR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u001f¨\u0006\""}, d2 = {"Lcom/youku/arch/v3/data/Response$Builder;", "", "Lcom/youku/arch/v3/io/IRequest;", "request", "setRequest", "", "id", "setId", "", ParamsConstants.Key.PARAM_TRACE_ID, "setTraceId", "timestamp", "setTimestamp", "rawData", "setRawData", "source", "setSource", "retCode", "setRetCode", "retMessage", "setRetMessage", "Lcom/alibaba/fastjson/JSONObject;", "jsonObject", "setJsonObject", "cacheTag", "setCacheTag", "Lcom/youku/arch/v3/data/Response;", "build", "J", "Ljava/lang/String;", "Lcom/alibaba/fastjson/JSONObject;", "Lcom/youku/arch/v3/io/IRequest;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static class Builder {
        private static transient /* synthetic */ IpChange $ipChange;
        @JvmField
        @Nullable
        public String cacheTag;
        @JvmField
        public long id;
        @JvmField
        @Nullable
        public JSONObject jsonObject;
        @JvmField
        @Nullable
        public String rawData;
        @JvmField
        @Nullable
        public IRequest request;
        @JvmField
        @Nullable
        public String retCode;
        @JvmField
        @Nullable
        public String retMessage;
        @JvmField
        @Nullable
        public String source;
        @JvmField
        public long timestamp = System.currentTimeMillis();
        @JvmField
        @Nullable
        public String traceId;

        @NotNull
        public Response build() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1946519943") ? (Response) ipChange.ipc$dispatch("1946519943", new Object[]{this}) : new Response(this);
        }

        @NotNull
        public final Builder setCacheTag(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1869125554")) {
                return (Builder) ipChange.ipc$dispatch("-1869125554", new Object[]{this, str});
            }
            this.cacheTag = str;
            return this;
        }

        @NotNull
        public final Builder setId(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-687773883")) {
                return (Builder) ipChange.ipc$dispatch("-687773883", new Object[]{this, Long.valueOf(j)});
            }
            this.id = j;
            return this;
        }

        @NotNull
        public final Builder setJsonObject(@Nullable JSONObject jSONObject) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "268080285")) {
                return (Builder) ipChange.ipc$dispatch("268080285", new Object[]{this, jSONObject});
            }
            this.jsonObject = jSONObject;
            return this;
        }

        @NotNull
        public final Builder setRawData(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-978017144")) {
                return (Builder) ipChange.ipc$dispatch("-978017144", new Object[]{this, str});
            }
            this.rawData = str;
            return this;
        }

        @NotNull
        public final Builder setRequest(@NotNull IRequest iRequest) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-775603776")) {
                return (Builder) ipChange.ipc$dispatch("-775603776", new Object[]{this, iRequest});
            }
            b41.i(iRequest, "request");
            this.request = iRequest;
            return this;
        }

        @NotNull
        public final Builder setRetCode(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1447283764")) {
                return (Builder) ipChange.ipc$dispatch("-1447283764", new Object[]{this, str});
            }
            this.retCode = str;
            return this;
        }

        @NotNull
        public final Builder setRetMessage(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1488342560")) {
                return (Builder) ipChange.ipc$dispatch("1488342560", new Object[]{this, str});
            }
            this.retMessage = str;
            return this;
        }

        @NotNull
        public final Builder setSource(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2099045707")) {
                return (Builder) ipChange.ipc$dispatch("2099045707", new Object[]{this, str});
            }
            this.source = str;
            return this;
        }

        @NotNull
        public final Builder setTimestamp(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "467571212")) {
                return (Builder) ipChange.ipc$dispatch("467571212", new Object[]{this, Long.valueOf(j)});
            }
            this.timestamp = j;
            return this;
        }

        @NotNull
        public final Builder setTraceId(@NotNull String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1381510662")) {
                return (Builder) ipChange.ipc$dispatch("-1381510662", new Object[]{this, str});
            }
            b41.i(str, ParamsConstants.Key.PARAM_TRACE_ID);
            this.traceId = str;
            return this;
        }
    }

    public Response(@NotNull Builder builder) {
        b41.i(builder, "builder");
        this.id = builder.id;
        this.traceId = builder.traceId;
        this.timestamp = builder.timestamp;
        this.rawData = builder.rawData;
        this.cacheTag = builder.cacheTag;
        this.source = builder.source;
        this.retCode = builder.retCode;
        this.retMessage = builder.retMessage;
        JSONObject jSONObject = builder.jsonObject;
        if (jSONObject != null) {
            this.jsonObject = jSONObject;
        }
        this.request = builder.request;
    }

    @Override // com.youku.arch.v3.io.IResponse
    @Nullable
    public final String getCacheTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1606941082") ? (String) ipChange.ipc$dispatch("1606941082", new Object[]{this}) : this.cacheTag;
    }

    @Override // com.youku.arch.v3.io.IResponse
    public final long getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-997949641") ? ((Long) ipChange.ipc$dispatch("-997949641", new Object[]{this})).longValue() : this.id;
    }

    @Override // com.youku.arch.v3.io.IResponse
    @Nullable
    public final JSONObject getJsonObject() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1341682871")) {
            return (JSONObject) ipChange.ipc$dispatch("1341682871", new Object[]{this});
        }
        if (this.jsonObject == null && !TextUtils.isEmpty(this.rawData)) {
            this.jsonObject = JSON.parseObject(this.rawData);
        }
        return this.jsonObject;
    }

    @Override // com.youku.arch.v3.io.IResponse
    @Nullable
    public final String getRawData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1956377914") ? (String) ipChange.ipc$dispatch("-1956377914", new Object[]{this}) : this.rawData;
    }

    @Override // com.youku.arch.v3.io.IResponse
    @Nullable
    public final IRequest getRequest() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1455565772") ? (IRequest) ipChange.ipc$dispatch("1455565772", new Object[]{this}) : this.request;
    }

    @Override // com.youku.arch.v3.io.IResponse
    @Nullable
    public final String getRetCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-487231742") ? (String) ipChange.ipc$dispatch("-487231742", new Object[]{this}) : this.retCode;
    }

    @Override // com.youku.arch.v3.io.IResponse
    @Nullable
    public final String getRetMessage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-70101944") ? (String) ipChange.ipc$dispatch("-70101944", new Object[]{this}) : this.retMessage;
    }

    @Override // com.youku.arch.v3.io.IResponse
    @Nullable
    public final String getSource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2024823613") ? (String) ipChange.ipc$dispatch("2024823613", new Object[]{this}) : this.source;
    }

    @Override // com.youku.arch.v3.io.IResponse
    public final long getTimestamp() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "27984810") ? ((Long) ipChange.ipc$dispatch("27984810", new Object[]{this})).longValue() : this.timestamp;
    }

    @Override // com.youku.arch.v3.io.IResponse
    @Nullable
    public final String getTraceId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-73839340") ? (String) ipChange.ipc$dispatch("-73839340", new Object[]{this}) : this.traceId;
    }

    @Override // com.youku.arch.v3.io.IResponse
    public boolean isSuccess() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1198293599") ? ((Boolean) ipChange.ipc$dispatch("1198293599", new Object[]{this})).booleanValue() : b41.d("SUCCESS", this.retCode);
    }

    public final void setId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1086254099")) {
            ipChange.ipc$dispatch("-1086254099", new Object[]{this, Long.valueOf(j)});
        } else {
            this.id = j;
        }
    }

    @Override // com.youku.arch.v3.io.IResponse
    public final void setJsonObject(@Nullable JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "144759877")) {
            ipChange.ipc$dispatch("144759877", new Object[]{this, jSONObject});
        } else {
            this.jsonObject = jSONObject;
        }
    }

    @Override // com.youku.arch.v3.io.IResponse
    public final void setRawData(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2134426768")) {
            ipChange.ipc$dispatch("-2134426768", new Object[]{this, str});
        } else {
            this.rawData = str;
        }
    }

    @Override // com.youku.arch.v3.io.IResponse
    public final void setRetCode(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "459431604")) {
            ipChange.ipc$dispatch("459431604", new Object[]{this, str});
        } else {
            this.retCode = str;
        }
    }

    @Override // com.youku.arch.v3.io.IResponse
    public final void setRetMessage(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "11923606")) {
            ipChange.ipc$dispatch("11923606", new Object[]{this, str});
        } else {
            this.retMessage = str;
        }
    }

    @Override // com.youku.arch.v3.io.IResponse
    public final void setSource(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1244897857")) {
            ipChange.ipc$dispatch("1244897857", new Object[]{this, str});
        } else {
            this.source = str;
        }
    }

    public final void setTimestamp(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-963882942")) {
            ipChange.ipc$dispatch("-963882942", new Object[]{this, Long.valueOf(j)});
        } else {
            this.timestamp = j;
        }
    }

    @Override // com.youku.arch.v3.io.IResponse
    public final void setTraceId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "389694178")) {
            ipChange.ipc$dispatch("389694178", new Object[]{this, str});
        } else {
            this.traceId = str;
        }
    }
}
