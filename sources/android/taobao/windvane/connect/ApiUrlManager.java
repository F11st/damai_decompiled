package android.taobao.windvane.connect;

import android.taobao.windvane.connect.api.ApiRequest;
import android.taobao.windvane.connect.api.WVApiWrapper;
import android.taobao.windvane.util.TaoLog;
import java.util.Hashtable;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ApiUrlManager {
    private static String TAG = "core.ApiUrlManager";
    private static Map<String, String> configUrlMap = new Hashtable();

    public static String getConfigUrl(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = configUrlMap.get(str);
        if (str3 != null) {
            return logUrl(str3);
        }
        synchronized (TAG) {
            String str4 = configUrlMap.get(str);
            if (str4 != null) {
                return logUrl(str4);
            }
            ApiRequest apiRequest = new ApiRequest();
            apiRequest.addParam("biztype", str2);
            apiRequest.addParam("api", str);
            String formatUrl = WVApiWrapper.formatUrl(apiRequest, CdnApiAdapter.class);
            configUrlMap.put(str, formatUrl);
            return logUrl(formatUrl);
        }
    }

    private static String logUrl(String str) {
        String str2 = TAG;
        TaoLog.d(str2, "config url: " + str);
        return str;
    }
}
