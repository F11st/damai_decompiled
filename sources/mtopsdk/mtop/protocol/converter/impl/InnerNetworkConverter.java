package mtopsdk.mtop.protocol.converter.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.security.util.SignConstants;
import mtopsdk.xstate.util.XStateConstants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class InnerNetworkConverter extends AbstractNetworkConverter {
    private static final String TAG = "mtopsdk.InnerNetworkConverter";
    private static final Map<String, String> headerConversionMap;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(64);
        headerConversionMap = concurrentHashMap;
        concurrentHashMap.put(HttpHeaderConstant.X_SID, "sid");
        concurrentHashMap.put(HttpHeaderConstant.X_T, "t");
        concurrentHashMap.put(HttpHeaderConstant.X_APPKEY, "appKey");
        concurrentHashMap.put(HttpHeaderConstant.X_TTID, "ttid");
        concurrentHashMap.put(HttpHeaderConstant.X_DEVID, "deviceId");
        concurrentHashMap.put(HttpHeaderConstant.X_UTDID, "utdid");
        concurrentHashMap.put("x-sign", "sign");
        concurrentHashMap.put(HttpHeaderConstant.X_NQ, XStateConstants.KEY_NQ);
        concurrentHashMap.put(HttpHeaderConstant.X_NETTYPE, "netType");
        concurrentHashMap.put(HttpHeaderConstant.X_PV, XStateConstants.KEY_PV);
        concurrentHashMap.put(HttpHeaderConstant.X_UID, "uid");
        concurrentHashMap.put("x-umt", XStateConstants.KEY_UMID_TOKEN);
        concurrentHashMap.put(HttpHeaderConstant.X_REQBIZ_EXT, XStateConstants.KEY_REQBIZ_EXT);
        concurrentHashMap.put(HttpHeaderConstant.X_ROUTER_ID, XStateConstants.KEY_ROUTER_ID);
        concurrentHashMap.put(HttpHeaderConstant.X_PLACE_ID, XStateConstants.KEY_PLACE_ID);
        concurrentHashMap.put(HttpHeaderConstant.X_OPEN_BIZ, XStateConstants.KEY_OPEN_BIZ);
        concurrentHashMap.put(HttpHeaderConstant.X_MINI_APPKEY, XStateConstants.KEY_MINI_APPKEY);
        concurrentHashMap.put(HttpHeaderConstant.X_REQ_APPKEY, XStateConstants.KEY_REQ_APPKEY);
        concurrentHashMap.put(HttpHeaderConstant.X_OPEN_BIZ_DATA, XStateConstants.KEY_OPEN_BIZ_DATA);
        concurrentHashMap.put(HttpHeaderConstant.X_ACT, XStateConstants.KEY_ACCESS_TOKEN);
        concurrentHashMap.put(HttpHeaderConstant.X_MINI_WUA, HttpHeaderConstant.X_MINI_WUA);
        concurrentHashMap.put(HttpHeaderConstant.X_APP_CONF_V, HttpHeaderConstant.X_APP_CONF_V);
        concurrentHashMap.put(HttpHeaderConstant.X_EXTTYPE, HttpHeaderConstant.KEY_EXTTYPE);
        concurrentHashMap.put(HttpHeaderConstant.X_EXTDATA, "extdata");
        concurrentHashMap.put("x-features", "x-features");
        concurrentHashMap.put(HttpHeaderConstant.X_PAGE_NAME, HttpHeaderConstant.X_PAGE_NAME);
        concurrentHashMap.put(HttpHeaderConstant.X_PAGE_URL, HttpHeaderConstant.X_PAGE_URL);
        concurrentHashMap.put(HttpHeaderConstant.X_PAGE_MAB, HttpHeaderConstant.X_PAGE_MAB);
        concurrentHashMap.put(HttpHeaderConstant.X_APP_VER, HttpHeaderConstant.X_APP_VER);
        concurrentHashMap.put(HttpHeaderConstant.X_ORANGE_Q, HttpHeaderConstant.X_ORANGE_Q);
        concurrentHashMap.put("user-agent", "user-agent");
        concurrentHashMap.put(HttpHeaderConstant.CLIENT_TRACE_ID, HttpHeaderConstant.CLIENT_TRACE_ID);
        concurrentHashMap.put(HttpHeaderConstant.F_REFER, HttpHeaderConstant.F_REFER);
        concurrentHashMap.put(HttpHeaderConstant.X_NETINFO, HttpHeaderConstant.X_NETINFO);
        concurrentHashMap.put(SignConstants.MIDDLE_OUTPUT_X_SG_EXT, SignConstants.MIDDLE_OUTPUT_X_SG_EXT);
    }

    @Override // mtopsdk.mtop.protocol.converter.impl.AbstractNetworkConverter
    protected Map<String, String> getHeaderConversionMap() {
        return headerConversionMap;
    }
}
