package com.youku.middlewareservice.provider;

import android.util.Log;
import com.alibaba.fastjson.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class UriProviderProxy {
    private static UriProvider sProxy;

    public static UriProvider getProxy() {
        return sProxy;
    }

    public static String getUriParamsFromJson(JSONObject jSONObject) {
        try {
            UriProvider uriProvider = sProxy;
            if (uriProvider == null) {
                return null;
            }
            return uriProvider.getUriParamsFromJson(jSONObject);
        } catch (Throwable th) {
            Log.e("OneService", "methodName: getUriParamsFromJsonThrowable: " + th.toString());
            return null;
        }
    }

    public static void inject(Class cls) {
        if (sProxy == null && UriProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (UriProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
