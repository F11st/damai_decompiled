package mtopsdk.mtop.protocol.builder.impl;

import android.text.TextUtils;
import java.util.Map;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.global.MtopConfig;
import mtopsdk.mtop.network.NetParam;
import mtopsdk.mtop.protocol.builder.ProtocolParamBuilder;
import mtopsdk.xstate.XState;
import mtopsdk.xstate.network.NetworkStateReceiver;
import mtopsdk.xstate.util.XStateConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class InnerProtocolParamBuilderImpl implements ProtocolParamBuilder {
    private static final String TAG = "mtopsdk.InnerProtocolParamBuilderImpl";
    private MtopConfig mtopConfig = null;

    private void buildExtParams(MtopContext mtopContext, Map<String, String> map) {
        MtopNetworkProp mtopNetworkProp = mtopContext.property;
        map.put("netType", XState.getValue("netType"));
        map.put(XStateConstants.KEY_NQ, XState.getValue(XStateConstants.KEY_NQ));
        if (map.get(XStateConstants.KEY_UMID_TOKEN) == null) {
            map.put(XStateConstants.KEY_UMID_TOKEN, XState.getValue(mtopContext.mtopInstance.getInstanceId(), XStateConstants.KEY_UMID_TOKEN));
        }
        String str = this.mtopConfig.appVersion;
        if (StringUtils.isNotBlank(str)) {
            map.put(HttpHeaderConstant.X_APP_VER, str);
        }
        String str2 = this.mtopConfig.xOrangeQ;
        if (StringUtils.isNotBlank(str2)) {
            map.put(HttpHeaderConstant.X_ORANGE_Q, str2);
        }
        map.put(HttpHeaderConstant.X_APP_CONF_V, String.valueOf(this.mtopConfig.xAppConfigVersion));
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
        String str5 = mtopNetworkProp.pageName;
        if (str5 != null) {
            map.put(HttpHeaderConstant.X_PAGE_NAME, str5);
        }
        String str6 = mtopNetworkProp.pageUrl;
        if (str6 != null) {
            map.put(HttpHeaderConstant.X_PAGE_URL, str6);
            String str7 = this.mtopConfig.mtopGlobalABTestParams.get(mtopNetworkProp.pageUrl);
            if (str7 != null) {
                map.put(HttpHeaderConstant.X_PAGE_MAB, str7);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x03af  */
    @Override // mtopsdk.mtop.protocol.builder.ProtocolParamBuilder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Map<java.lang.String, java.lang.String> buildParams(mtopsdk.framework.domain.MtopContext r28) {
        /*
            Method dump skipped, instructions count: 1251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.mtop.protocol.builder.impl.InnerProtocolParamBuilderImpl.buildParams(mtopsdk.framework.domain.MtopContext):java.util.Map");
    }
}
