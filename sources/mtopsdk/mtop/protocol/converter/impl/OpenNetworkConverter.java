package mtopsdk.mtop.protocol.converter.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.xstate.util.XStateConstants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class OpenNetworkConverter extends AbstractNetworkConverter {
    private static final String TAG = "mtopsdk.OpenNetworkConverter";
    private static final Map<String, String> headerConversionMap;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        headerConversionMap = concurrentHashMap;
        concurrentHashMap.put(HttpHeaderConstant.X_WUAT, "wua");
        concurrentHashMap.put(HttpHeaderConstant.X_SID, "sid");
        concurrentHashMap.put(HttpHeaderConstant.X_T, "t");
        concurrentHashMap.put(HttpHeaderConstant.X_APPKEY, "appKey");
        concurrentHashMap.put(HttpHeaderConstant.X_TTID, "ttid");
        concurrentHashMap.put(HttpHeaderConstant.X_UTDID, "utdid");
        concurrentHashMap.put("x-sign", "sign");
        concurrentHashMap.put(HttpHeaderConstant.X_PV, XStateConstants.KEY_PV);
        concurrentHashMap.put(HttpHeaderConstant.X_UID, "uid");
        concurrentHashMap.put("x-features", "x-features");
        concurrentHashMap.put(HttpHeaderConstant.X_OPEN_BIZ, XStateConstants.KEY_OPEN_BIZ);
        concurrentHashMap.put(HttpHeaderConstant.X_MINI_APPKEY, XStateConstants.KEY_MINI_APPKEY);
        concurrentHashMap.put(HttpHeaderConstant.X_REQ_APPKEY, XStateConstants.KEY_REQ_APPKEY);
        concurrentHashMap.put(HttpHeaderConstant.X_OPEN_BIZ_DATA, XStateConstants.KEY_OPEN_BIZ_DATA);
        concurrentHashMap.put(HttpHeaderConstant.X_ACT, XStateConstants.KEY_ACCESS_TOKEN);
        concurrentHashMap.put(HttpHeaderConstant.X_APP_VER, HttpHeaderConstant.X_APP_VER);
        concurrentHashMap.put("user-agent", "user-agent");
    }

    @Override // mtopsdk.mtop.protocol.converter.impl.AbstractNetworkConverter
    protected Map<String, String> getHeaderConversionMap() {
        return headerConversionMap;
    }
}
