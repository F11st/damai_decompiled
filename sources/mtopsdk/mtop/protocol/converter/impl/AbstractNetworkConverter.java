package mtopsdk.mtop.protocol.converter.impl;

import android.text.TextUtils;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.global.MtopConfig;
import mtopsdk.mtop.global.SwitchConfig;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.protocol.converter.INetworkConverter;
import mtopsdk.mtop.protocol.converter.util.NetworkConverterUtils;
import mtopsdk.network.domain.ParcelableRequestBodyImpl;
import mtopsdk.network.domain.Request;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class AbstractNetworkConverter implements INetworkConverter {
    private static final String TAG = "mtopsdk.AbstractNetworkConverter";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: mtopsdk.mtop.protocol.converter.impl.AbstractNetworkConverter$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum;

        static {
            int[] iArr = new int[EnvModeEnum.values().length];
            $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum = iArr;
            try {
                iArr[EnvModeEnum.ONLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[EnvModeEnum.PREPARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[EnvModeEnum.TEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[EnvModeEnum.TEST_SANDBOX.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private String getCustomDomain(MtopContext mtopContext) {
        MtopNetworkProp mtopNetworkProp = mtopContext.property;
        if (StringUtils.isNotBlank(mtopNetworkProp.customDomain)) {
            return mtopNetworkProp.customDomain;
        }
        int i = AnonymousClass1.$SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[mtopNetworkProp.envMode.ordinal()];
        if (i == 1) {
            if (StringUtils.isNotBlank(mtopNetworkProp.customOnlineDomain)) {
                return mtopNetworkProp.customOnlineDomain;
            }
            return null;
        } else if (i != 2) {
            if (i == 3 && StringUtils.isNotBlank(mtopNetworkProp.customDailyDomain)) {
                return mtopNetworkProp.customDailyDomain;
            }
            return null;
        } else if (StringUtils.isNotBlank(mtopNetworkProp.customPreDomain)) {
            return mtopNetworkProp.customPreDomain;
        } else {
            return null;
        }
    }

    protected void addMtopSdkProperty(Mtop mtop, Map<String, String> map) {
        if (SwitchConfig.getInstance().isMtopsdkPropertySwitchOpen()) {
            for (Map.Entry<String, String> entry : mtop.getMtopConfig().getMtopProperties().entrySet()) {
                try {
                    String key = entry.getKey();
                    if (StringUtils.isNotBlank(key) && key.startsWith(HttpHeaderConstant.MTOPSDK_PROPERTY_PREFIX)) {
                        map.put(key.substring(8), entry.getValue());
                    }
                } catch (Exception unused) {
                    TBSdkLog.e(TAG, "[addMtopSdkProperty]get mtopsdk properties error,key=" + entry.getKey() + ",value=" + entry.getValue());
                }
            }
        }
    }

    protected String buildBaseUrl(MtopContext mtopContext, String str, String str2) {
        StringBuilder sb = new StringBuilder(64);
        try {
            MtopConfig mtopConfig = mtopContext.mtopInstance.getMtopConfig();
            MtopNetworkProp mtopNetworkProp = mtopContext.property;
            mtopNetworkProp.envMode = mtopConfig.envMode;
            sb.append(mtopNetworkProp.protocol.getProtocol());
            String customDomain = getCustomDomain(mtopContext);
            if (StringUtils.isNotBlank(customDomain)) {
                sb.append(customDomain);
            } else {
                sb.append(mtopConfig.mtopDomain.getDomain(mtopContext.property.envMode));
            }
            sb.append("/");
            sb.append(mtopConfig.entrance.getEntrance());
            sb.append("/");
            sb.append(str);
            sb.append("/");
            sb.append(str2);
            sb.append("/");
        } catch (Exception e) {
            TBSdkLog.e(TAG, mtopContext.seqNo, "[buildBaseUrl] build mtop baseUrl error.", e);
        }
        return sb.toString();
    }

    protected Map<String, String> buildRequestHeaders(Map<String, String> map, Map<String, String> map2, boolean z) {
        Map<String, String> headerConversionMap = getHeaderConversionMap();
        if (headerConversionMap == null) {
            TBSdkLog.e(TAG, "[buildRequestHeaders]headerConversionMap is null,buildRequestHeaders error.");
            return map2;
        }
        HashMap hashMap = new HashMap(64);
        if (map2 != null) {
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (z) {
                    if (value != null) {
                        try {
                            value = URLEncoder.encode(value, "utf-8");
                        } catch (Exception unused) {
                            TBSdkLog.e(TAG, "[buildRequestHeaders]urlEncode " + key + "=" + value + "error");
                        }
                    } else {
                        value = null;
                    }
                }
                hashMap.put(key, value);
            }
        }
        for (Map.Entry<String, String> entry2 : headerConversionMap.entrySet()) {
            String key2 = entry2.getKey();
            String remove = map.remove(entry2.getValue());
            if (remove != null) {
                try {
                    hashMap.put(key2, URLEncoder.encode(remove, "utf-8"));
                } catch (Exception unused2) {
                    TBSdkLog.e(TAG, "[buildRequestHeaders]urlEncode " + key2 + "=" + remove + "error");
                }
            }
        }
        String remove2 = map.remove("lng");
        String remove3 = map.remove("lat");
        if (remove2 != null && remove3 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(remove2);
            sb.append(",");
            sb.append(remove3);
            try {
                hashMap.put(HttpHeaderConstant.X_LOCATION, URLEncoder.encode(sb.toString(), "utf-8"));
            } catch (Exception unused3) {
                TBSdkLog.e(TAG, "[buildRequestHeaders]urlEncode x-location=" + sb.toString() + "error");
            }
        }
        return hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mtopsdk.mtop.protocol.converter.INetworkConverter
    public Request convert(MtopContext mtopContext) {
        String buildBaseUrl;
        URL initUrl;
        byte[] bytes;
        String str = "utf-8";
        MtopNetworkProp mtopNetworkProp = mtopContext.property;
        MtopConfig mtopConfig = mtopContext.mtopInstance.getMtopConfig();
        String str2 = mtopContext.seqNo;
        Request.Builder builder = new Request.Builder();
        builder.seqNo(str2);
        builder.reqContext(mtopNetworkProp.reqContext);
        if (!TextUtils.isEmpty(mtopNetworkProp.bizIdStr)) {
            builder.bizId(mtopNetworkProp.bizIdStr);
        } else {
            builder.bizId(mtopNetworkProp.bizId);
        }
        builder.connectTimeout(mtopNetworkProp.connTimeout);
        builder.readTimeout(mtopNetworkProp.socketTimeout);
        builder.retryTimes(mtopNetworkProp.retryTimes);
        builder.appKey(mtopNetworkProp.reqAppKey);
        builder.authCode(mtopNetworkProp.authCode);
        EnvModeEnum envModeEnum = mtopConfig.envMode;
        if (envModeEnum != null) {
            int i = AnonymousClass1.$SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[envModeEnum.ordinal()];
            if (i == 1) {
                builder.env(0);
            } else if (i == 2) {
                builder.env(1);
            } else if (i == 3 || i == 4) {
                builder.env(2);
            }
        }
        MethodEnum methodEnum = mtopNetworkProp.method;
        Map<String, String> map = mtopContext.protocolParams;
        Map<String, String> map2 = mtopNetworkProp.requestHeaders;
        Map<String, String> map3 = mtopConfig.mtopGlobalHeaders;
        if (!map3.isEmpty()) {
            if (map2 != null) {
                for (Map.Entry<String, String> entry : map3.entrySet()) {
                    String key = entry.getKey();
                    if (!map2.containsKey(key)) {
                        map2.put(key, entry.getValue());
                    }
                }
            } else {
                map2 = map3;
            }
        }
        Map<String, String> buildRequestHeaders = buildRequestHeaders(map, map2, mtopConfig.enableHeaderUrlEncode);
        try {
            String remove = map.remove("api");
            builder.api(remove);
            buildBaseUrl = buildBaseUrl(mtopContext, remove, map.remove("v"));
            mtopContext.baseUrl = buildBaseUrl;
            addMtopSdkProperty(mtopContext.mtopInstance, map);
            Map<String, String> map4 = mtopNetworkProp.queryParameterMap;
            if (map4 != null && !map4.isEmpty()) {
                for (Map.Entry<String, String> entry2 : mtopNetworkProp.queryParameterMap.entrySet()) {
                    map.put(entry2.getKey(), entry2.getValue());
                }
            }
            Map<String, String> map5 = mtopConfig.mtopGlobalQuerys;
            if (!map5.isEmpty()) {
                for (Map.Entry<String, String> entry3 : map5.entrySet()) {
                    String key2 = entry3.getKey();
                    if (!map.containsKey(key2)) {
                        map.put(key2, entry3.getValue());
                    }
                }
            }
            buildRequestHeaders.put("content-type", HttpHeaderConstant.FORM_CONTENT_TYPE);
        } catch (Throwable th) {
            th = th;
            str = null;
            TBSdkLog.e(TAG, str2, "[convert]convert Request failed!", th);
            return str;
        }
        try {
            if (MethodEnum.POST.getMethod().equals(methodEnum.getMethod())) {
                String createParamQueryStr = NetworkConverterUtils.createParamQueryStr(map, "utf-8");
                if (createParamQueryStr != null) {
                    try {
                        bytes = createParamQueryStr.getBytes("utf-8");
                    } catch (Exception unused) {
                        TBSdkLog.e(TAG, "[createParamPostData]getPostData error");
                    }
                    builder.method(methodEnum.getMethod(), new ParcelableRequestBodyImpl(HttpHeaderConstant.FORM_CONTENT_TYPE, bytes));
                    str = null;
                    initUrl = NetworkConverterUtils.initUrl(buildBaseUrl, null);
                }
                bytes = null;
                builder.method(methodEnum.getMethod(), new ParcelableRequestBodyImpl(HttpHeaderConstant.FORM_CONTENT_TYPE, bytes));
                str = null;
                initUrl = NetworkConverterUtils.initUrl(buildBaseUrl, null);
            } else {
                str = null;
                if (!(mtopContext.mtopListener instanceof MtopCallback.MtopCacheListener) && !mtopNetworkProp.useCache) {
                    buildRequestHeaders.put("cache-control", HttpHeaderConstant.NO_CACHE);
                }
                mtopContext.queryParams = map;
                initUrl = NetworkConverterUtils.initUrl(buildBaseUrl, map);
            }
            if (initUrl != null) {
                mtopContext.stats.domain = initUrl.getHost();
                builder.url(initUrl.toString());
            }
            builder.headers(buildRequestHeaders);
            return builder.build();
        } catch (Throwable th2) {
            th = th2;
            TBSdkLog.e(TAG, str2, "[convert]convert Request failed!", th);
            return str;
        }
    }

    protected abstract Map<String, String> getHeaderConversionMap();
}
