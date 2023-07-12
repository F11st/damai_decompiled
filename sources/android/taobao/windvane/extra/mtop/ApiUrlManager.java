package android.taobao.windvane.extra.mtop;

import android.taobao.windvane.connect.api.ApiRequest;
import android.taobao.windvane.connect.api.WVApiWrapper;
import mtopsdk.xstate.util.XStateConstants;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ApiUrlManager {
    public static String getUploadTokenUrl(String str) {
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.addParam("api", "com.taobao.mtop.getUploadFileToken");
        apiRequest.addParam("v", "2.0");
        apiRequest.addDataParam("uniqueKey", str);
        return WVApiWrapper.formatUrl(apiRequest, MtopApiAdapter.class);
    }

    public static String getUploadUrl(String str, String str2) {
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.addParam("api", "com.taobao.mtop.uploadFile");
        apiRequest.addParam("v", "2.0");
        apiRequest.addDataParam("uniqueKey", str);
        apiRequest.addDataParam(XStateConstants.KEY_ACCESS_TOKEN, str2);
        return WVApiWrapper.formatUrl(apiRequest, MtopApiAdapter.class);
    }
}
