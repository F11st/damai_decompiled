package com.alient.onearch.adapter.request;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.youku.arch.v3.data.DataLoadCallback;
import com.youku.arch.v3.data.IDataSource;
import com.youku.arch.v3.data.OneMtopResponse;
import com.youku.arch.v3.data.Response;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.util.LogUtil;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt__StringsKt;
import mtopsdk.common.util.StringUtils;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.MtopBuilder;
import mtopsdk.mtop.util.ErrorConstant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.gn1;
import tb.hi;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u001b\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J \u0010\u0014\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¨\u0006\u0018"}, d2 = {"Lcom/alient/onearch/adapter/request/RemoteDataSource;", "Lcom/youku/arch/v3/data/IDataSource;", "Lcom/alibaba/fastjson/JSONObject;", "jsonObject", "", "parseJsonRetMsg", "raw", "parseRetMsg", "Lcom/youku/arch/v3/io/IRequest;", "request", "Lmtopsdk/mtop/domain/MtopRequest;", "generateMtopRequest", "Lmtopsdk/mtop/domain/MtopResponse;", "response", "getTraceId", "Lcom/youku/arch/v3/data/DataLoadCallback;", "callBack", "Ltb/wt2;", gn1.TYPE_OPEN_URL_METHOD_GET, "mtopResponse", "dispatchResponse", "<init>", "()V", "Companion", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public final class RemoteDataSource implements IDataSource {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String TAG = "RemoteDataSource";
    @NotNull
    private static final Lazy<RemoteDataSource> instance$delegate;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/alient/onearch/adapter/request/RemoteDataSource$Companion;", "", "Lcom/alient/onearch/adapter/request/RemoteDataSource;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/alient/onearch/adapter/request/RemoteDataSource;", "instance", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        @NotNull
        public final RemoteDataSource getInstance() {
            return (RemoteDataSource) RemoteDataSource.instance$delegate.getValue();
        }
    }

    static {
        Lazy<RemoteDataSource> a;
        a = C8177b.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<RemoteDataSource>() { // from class: com.alient.onearch.adapter.request.RemoteDataSource$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RemoteDataSource invoke() {
                return new RemoteDataSource();
            }
        });
        instance$delegate = a;
    }

    private final MtopRequest generateMtopRequest(IRequest iRequest) {
        MtopRequest mtopRequest = new MtopRequest();
        mtopRequest.setApiName(iRequest.getApiName());
        mtopRequest.setVersion(iRequest.getVersion());
        mtopRequest.setNeedSession(iRequest.isNeedSession());
        Map<String, Object> dataParams = iRequest.getDataParams();
        if (dataParams != null && (!dataParams.isEmpty())) {
            if (dataParams.containsKey("params")) {
                String jSONString = JSON.parseObject(String.valueOf(dataParams.get("params"))).toJSONString();
                b41.h(jSONString, "params.toJSONString()");
                dataParams.put("params", jSONString);
            }
            mtopRequest.setData(JSON.toJSONString(dataParams));
        }
        return mtopRequest;
    }

    private final String getTraceId(MtopResponse mtopResponse) {
        return (mtopResponse.getHeaderFields() == null || !mtopResponse.getHeaderFields().containsKey("x-eagleeye-id") || mtopResponse.getHeaderFields().get("x-eagleeye-id") == null) ? "trace null" : String.valueOf(mtopResponse.getHeaderFields().get("x-eagleeye-id"));
    }

    private final String parseJsonRetMsg(JSONObject jSONObject) {
        JSONArray jSONArray;
        if (jSONObject == null || (jSONArray = jSONObject.getJSONArray("ret")) == null || jSONArray.size() <= 0) {
            return null;
        }
        String string = jSONArray.getString(0);
        b41.h(string, "array.getString(0)");
        return parseRetMsg(string);
    }

    private final String parseRetMsg(String str) {
        List t0;
        if (StringUtils.isNotBlank(str)) {
            t0 = StringsKt__StringsKt.t0(str, new String[]{"::"}, false, 0, 6, null);
            Object[] array = t0.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            String[] strArr = (String[]) array;
            if (strArr.length > 1) {
                return strArr[1];
            }
            return null;
        }
        return null;
    }

    public final void dispatchResponse(@NotNull IRequest iRequest, @NotNull MtopResponse mtopResponse, @Nullable DataLoadCallback dataLoadCallback) {
        String str;
        b41.i(iRequest, "request");
        b41.i(mtopResponse, "mtopResponse");
        String str2 = null;
        if (mtopResponse.getBytedata() != null) {
            byte[] bytedata = mtopResponse.getBytedata();
            b41.h(bytedata, "mtopResponse.bytedata");
            str = new String(bytedata, hi.UTF_8);
        } else {
            str = null;
        }
        Response build = new OneMtopResponse.Builder().setMappingCode(mtopResponse.mappingCode).setResponseCode(mtopResponse.getResponseCode()).setId(iRequest.getId()).setTraceId(getTraceId(mtopResponse)).setTimestamp(System.currentTimeMillis()).setSource("remote").setRawData(str).setCacheTag(iRequest.getCacheTag()).setRetCode(mtopResponse.getRetCode()).setRequest(iRequest).build();
        if (dataLoadCallback != null) {
            try {
                dataLoadCallback.onFilter(build);
            } catch (Throwable th) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jsonObject = build.getJsonObject();
                        build.setJsonObject(jsonObject);
                        str2 = parseJsonRetMsg(jsonObject);
                        build.setRetMessage(str2);
                    } catch (JSONException e) {
                        build.setRetCode(ErrorConstant.ERRCODE_JSONDATA_PARSE_ERROR);
                        build.setRetMessage(ErrorConstant.ERRMSG_JSONDATA_PARSE_ERROR);
                        LogUtil.e(TAG, e.getMessage());
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    build.setRetMessage(mtopResponse.getRetMsg());
                }
                dataLoadCallback.onResponse(build);
                throw th;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jsonObject2 = build.getJsonObject();
                build.setJsonObject(jsonObject2);
                str2 = parseJsonRetMsg(jsonObject2);
                build.setRetMessage(str2);
            } catch (JSONException e2) {
                build.setRetCode(ErrorConstant.ERRCODE_JSONDATA_PARSE_ERROR);
                build.setRetMessage(ErrorConstant.ERRMSG_JSONDATA_PARSE_ERROR);
                LogUtil.e(TAG, e2.getMessage());
            }
        }
        if (TextUtils.isEmpty(str2)) {
            build.setRetMessage(mtopResponse.getRetMsg());
        }
        if (dataLoadCallback == null) {
            return;
        }
        dataLoadCallback.onResponse(build);
    }

    @Override // com.youku.arch.v3.data.IDataSource
    public void get(@NotNull IRequest iRequest, @Nullable DataLoadCallback dataLoadCallback) {
        b41.i(iRequest, "request");
        MtopBuilder mtopBuilder = new MtopBuilder(MtopManager.getMtopInstance(), generateMtopRequest(iRequest), AppInfoProviderProxy.getTTID());
        Map<String, Object> dataParams = iRequest.getDataParams();
        if (dataParams != null && dataParams.containsKey("method")) {
            Object obj = dataParams.get("method");
            if (obj instanceof MethodEnum) {
                mtopBuilder.reqMethod((MethodEnum) obj);
            }
        }
        if (!TextUtils.isEmpty(iRequest.getCustomDomain())) {
            mtopBuilder.setCustomDomain(iRequest.getCustomDomain());
        }
        mtopBuilder.headers(iRequest.getHeaders());
        if (iRequest.getTimeout() > 0) {
            mtopBuilder.setConnectionTimeoutMilliSecond(iRequest.getTimeout());
            mtopBuilder.setSocketTimeoutMilliSecond(iRequest.getTimeout());
        }
        MtopResponse syncRequest = mtopBuilder.syncRequest();
        b41.h(syncRequest, "response");
        dispatchResponse(iRequest, syncRequest, dataLoadCallback);
    }
}
