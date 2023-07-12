package com.alibaba.emas.datalab;

import android.app.Application;
import android.util.Log;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: classes15.dex */
public class DatalabTaobaoInit implements Serializable {
    private static final String tag = "Datalab.init";

    public void init(Application application, HashMap<String, Object> hashMap) {
        if (application == null) {
            Log.e(tag, "init error, application is null");
        } else if (hashMap == null) {
            Log.e(tag, "init error, params is null");
        } else {
            String valueOf = hashMap.get("onlineAppKey") != null ? String.valueOf(hashMap.get("onlineAppKey")) : null;
            if (valueOf == null) {
                Log.e(tag, "init error, params appkey is null");
                valueOf = "12278902";
            }
            try {
                Log.e(tag, ">>>>>>> init start >>>>>>>>");
                C3318a b = C3318a.b();
                b.c(application, valueOf + "@android");
                Log.e(tag, ">>>>>>> init success >>>>>>>>");
            } catch (Exception e) {
                Log.e(tag, "init error ", e);
            }
        }
    }
}
