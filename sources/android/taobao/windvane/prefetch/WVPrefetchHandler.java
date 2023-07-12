package android.taobao.windvane.prefetch;

import android.net.Uri;
import android.taobao.windvane.connect.ConnectManager;
import android.taobao.windvane.connect.HttpConnectListener;
import android.taobao.windvane.connect.HttpResponse;
import android.taobao.windvane.jsbridge.api.WVAPI;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.amap.api.services.cloud.CloudSearch;
import com.taobao.weaver.prefetch.PrefetchDataCallback;
import com.taobao.weaver.prefetch.PrefetchDataResponse;
import com.taobao.weaver.prefetch.PrefetchHandler;
import com.taobao.weaver.prefetch.PrefetchType;
import com.taobao.weaver.prefetch.WMLPrefetchDecision;
import com.youku.playerservice.axp.definition.FirstSliceCode;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVPrefetchHandler implements PrefetchHandler {
    private static String GET_DATA = "Prefetch.getData";
    private static String REQUEST_DATA = "Prefetch.requestData";
    private static String TEST_KEY = "test";

    public WMLPrefetchDecision isSupported(String str, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject(map);
        boolean booleanValue = jSONObject.getBoolean("isSupport") != null ? jSONObject.getBoolean("isSupport").booleanValue() : false;
        String queryParameter = Uri.parse(str).getQueryParameter("apiName");
        WMLPrefetchDecision wMLPrefetchDecision = new WMLPrefetchDecision();
        if (GET_DATA.equals(queryParameter) || REQUEST_DATA.equals(queryParameter) || booleanValue) {
            wMLPrefetchDecision.externalKey = TEST_KEY;
            if (map.containsKey("externalKey")) {
                wMLPrefetchDecision.externalKey = jSONObject.getString("externalKey");
            }
            wMLPrefetchDecision.status = PrefetchType.SUPPORTED;
        }
        return wMLPrefetchDecision;
    }

    public String prefetchData(String str, Map<String, Object> map, final PrefetchDataCallback prefetchDataCallback) {
        JSONObject jSONObject = new JSONObject(map);
        if (jSONObject.getBoolean("isLocal") != null ? jSONObject.getBoolean("isLocal").booleanValue() : true) {
            HashMap hashMap = new HashMap();
            hashMap.put("client", "TBClient");
            hashMap.put("apiName", WVAPI.PluginName.API_PREFETCH);
            hashMap.put("type", CloudSearch.SearchBound.LOCAL_SHAPE);
            PrefetchDataResponse prefetchDataResponse = new PrefetchDataResponse();
            prefetchDataResponse.data = hashMap;
            prefetchDataResponse.usageLimit = 10;
            prefetchDataResponse.maxAge = 500;
            prefetchDataCallback.onComplete(prefetchDataResponse);
            return null;
        }
        ConnectManager.getInstance().connect(str, new HttpConnectListener<HttpResponse>() { // from class: android.taobao.windvane.prefetch.WVPrefetchHandler.1
            @Override // android.taobao.windvane.connect.HttpConnectListener
            public void onFinish(HttpResponse httpResponse, int i) {
                if (httpResponse != null && httpResponse.getData().length != 0) {
                    try {
                        String str2 = new String(httpResponse.getData(), "utf-8");
                        PrefetchDataResponse prefetchDataResponse2 = new PrefetchDataResponse();
                        prefetchDataResponse2.data = JSON.parseObject(str2);
                        prefetchDataResponse2.maxAge = 500;
                        prefetchDataResponse2.usageLimit = 10;
                        prefetchDataCallback.onComplete(prefetchDataResponse2);
                        return;
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                prefetchDataCallback.onError(FirstSliceCode.FS_NULL, "getData Error");
            }
        });
        return null;
    }
}
