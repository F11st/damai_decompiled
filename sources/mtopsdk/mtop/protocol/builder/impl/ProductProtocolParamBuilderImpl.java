package mtopsdk.mtop.protocol.builder.impl;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.features.MtopFeatureManager;
import mtopsdk.mtop.global.MtopConfig;
import mtopsdk.mtop.global.SDKUtils;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.network.NetParam;
import mtopsdk.mtop.protocol.builder.ProtocolParamBuilder;
import mtopsdk.security.ISign;
import mtopsdk.xstate.XState;
import mtopsdk.xstate.network.NetworkStateReceiver;
import mtopsdk.xstate.util.XStateConstants;
import org.json.JSONException;
import org.json.JSONObject;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ProductProtocolParamBuilderImpl implements ProtocolParamBuilder {
    private static final String TAG = "mtopsdk.ProductProtocolParamBuilderImpl";
    private MtopConfig mtopConfig = null;

    private void buildExtParams(MtopContext mtopContext, Map<String, String> map) {
        MtopNetworkProp mtopNetworkProp = mtopContext.property;
        map.put("netType", XState.getValue("netType"));
        map.put(XStateConstants.KEY_NQ, XState.getValue(XStateConstants.KEY_NQ));
        map.put(XStateConstants.KEY_UMID_TOKEN, XState.getValue(mtopContext.mtopInstance.getInstanceId(), XStateConstants.KEY_UMID_TOKEN));
        String str = this.mtopConfig.appVersion;
        if (StringUtils.isNotBlank(str)) {
            map.put(HttpHeaderConstant.X_APP_VER, str);
        }
        String str2 = this.mtopConfig.xOrangeQ;
        if (StringUtils.isNotBlank(str2)) {
            map.put(HttpHeaderConstant.X_ORANGE_Q, str2);
        }
        String value = XState.getValue("ua");
        if (value != null) {
            map.put("user-agent", value);
        }
        map.put(HttpHeaderConstant.CLIENT_TRACE_ID, mtopNetworkProp.clientTraceId);
        map.put(HttpHeaderConstant.F_REFER, "mtop");
        if (mtopNetworkProp.netParam > 0) {
            JSONObject jSONObject = new JSONObject();
            if ((mtopNetworkProp.netParam & 1) != 0) {
                String str3 = NetworkStateReceiver.ssid;
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        jSONObject.put(NetParam.NetParamKey.SSID, str3);
                    } catch (JSONException e) {
                        TBSdkLog.w(TAG, "set wifi ssid error.", e);
                    }
                }
            }
            if ((mtopNetworkProp.netParam & 2) != 0) {
                String str4 = NetworkStateReceiver.bssid;
                if (!TextUtils.isEmpty(str4)) {
                    try {
                        jSONObject.put(NetParam.NetParamKey.BSSID, str4);
                    } catch (JSONException e2) {
                        TBSdkLog.w(TAG, "set wifi bssid error.", e2);
                    }
                }
            }
            if (jSONObject.length() > 0) {
                map.put(HttpHeaderConstant.X_NETINFO, jSONObject.toString());
            }
        }
    }

    @Override // mtopsdk.mtop.protocol.builder.ProtocolParamBuilder
    public Map<String, String> buildParams(MtopContext mtopContext) {
        String str;
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        Mtop mtop = mtopContext.mtopInstance;
        String instanceId = mtop.getInstanceId();
        MtopConfig mtopConfig = mtop.getMtopConfig();
        this.mtopConfig = mtopConfig;
        ISign iSign = mtopConfig.sign;
        if (iSign == null) {
            String str3 = mtopContext.seqNo;
            TBSdkLog.e(TAG, str3, instanceId + " ISign of mtopConfig in mtopInstance is null");
            return null;
        }
        MtopRequest mtopRequest = mtopContext.mtopRequest;
        MtopNetworkProp mtopNetworkProp = mtopContext.property;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("data", mtopRequest.getData());
        if (StringUtils.isNotBlank(mtopNetworkProp.reqBizExt)) {
            hashMap.put(XStateConstants.KEY_REQBIZ_EXT, mtopNetworkProp.reqBizExt);
        }
        long mtopTotalFeatures = MtopFeatureManager.getMtopTotalFeatures(mtop);
        if (mtopNetworkProp.reqSource == 1) {
            mtopTotalFeatures |= MtopFeatureManager.getMtopFeatureValue(11);
        }
        hashMap.put("x-features", String.valueOf(mtopTotalFeatures));
        String value = XState.getValue("lat");
        if (StringUtils.isNotBlank(value)) {
            String value2 = XState.getValue("lng");
            if (StringUtils.isNotBlank(value2)) {
                hashMap.put("lat", value);
                hashMap.put("lng", value2);
            }
        }
        hashMap.put(XStateConstants.KEY_PV, "1.0");
        hashMap.put("utdid", mtop.getUtdid());
        hashMap.put("uid", StringUtils.isNotBlank(mtopNetworkProp.reqUserId) ? mtopNetworkProp.reqUserId : mtop.getMultiAccountUserId(mtopNetworkProp.userInfo));
        if (StringUtils.isBlank(mtopNetworkProp.reqAppKey)) {
            MtopConfig mtopConfig2 = this.mtopConfig;
            mtopNetworkProp.reqAppKey = mtopConfig2.appKey;
            mtopNetworkProp.authCode = mtopConfig2.authCode;
        }
        String str4 = mtopNetworkProp.reqAppKey;
        String str5 = mtopNetworkProp.authCode;
        hashMap.put("appKey", str4);
        String valueOf = String.valueOf(SDKUtils.getCorrectionTime());
        hashMap.put("t", valueOf);
        String apiName = mtopRequest.getApiName();
        Locale locale = Locale.US;
        hashMap.put("api", apiName.toLowerCase(locale));
        hashMap.put("v", mtopRequest.getVersion().toLowerCase(locale));
        hashMap.put("sid", mtop.getMultiAccountSid(mtopNetworkProp.userInfo));
        hashMap.put("ttid", mtopNetworkProp.ttid);
        long currentTimeMillis2 = System.currentTimeMillis();
        String mtopApiSign = iSign.getMtopApiSign(hashMap, str4, str5);
        mtopContext.stats.computeSignTime = System.currentTimeMillis() - currentTimeMillis2;
        if (StringUtils.isBlank(mtopApiSign)) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("apiKey=");
            sb.append(mtopRequest.getKey());
            sb.append(" call getMtopApiSign failed.[appKey=");
            sb.append(str4);
            sb.append(", authCode=");
            sb.append(str5);
            sb.append(jn1.ARRAY_END_STR);
            TBSdkLog.e(TAG, mtopContext.seqNo, sb.toString());
            return hashMap;
        }
        hashMap.put("sign", mtopApiSign);
        if (mtopNetworkProp.wuaFlag >= 0) {
            long currentTimeMillis3 = System.currentTimeMillis();
            str = valueOf;
            str2 = str5;
            String secBodyDataEx = iSign.getSecBodyDataEx(valueOf, str4, str5, null, mtopNetworkProp.wuaFlag);
            mtopContext.stats.computeWuaTime = System.currentTimeMillis() - currentTimeMillis3;
            hashMap.put("wua", secBodyDataEx);
            if (StringUtils.isBlank(secBodyDataEx) && TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                String str6 = mtopContext.seqNo;
                TBSdkLog.e(TAG, str6, mtopRequest.getKey() + " call getSecurityBodyDataEx for wua failed.");
            }
        } else {
            str = valueOf;
            str2 = str5;
        }
        long currentTimeMillis4 = System.currentTimeMillis();
        String secBodyDataEx2 = iSign.getSecBodyDataEx(str, str4, str2, null, 8);
        mtopContext.stats.computeMiniWuaTime = System.currentTimeMillis() - currentTimeMillis4;
        hashMap.put(HttpHeaderConstant.X_MINI_WUA, secBodyDataEx2);
        if (StringUtils.isBlank(secBodyDataEx2)) {
            String str7 = mtopContext.seqNo;
            TBSdkLog.e(TAG, str7, mtopRequest.getKey() + " call getSecurityBodyDataEx for mini_wua failed.");
        }
        buildExtParams(mtopContext, hashMap);
        mtopContext.stats.buildParamsTime = System.currentTimeMillis() - currentTimeMillis;
        return hashMap;
    }
}
