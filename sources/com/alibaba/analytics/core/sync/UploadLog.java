package com.alibaba.analytics.core.sync;

import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.config.AbstractC3111d;
import com.alibaba.analytics.core.network.NetworkUtil;
import com.alibaba.analytics.utils.Logger;
import com.youku.arch.v3.core.Constants;
import com.youku.resource.utils.WoodpeckerLocalConfigCenter;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class UploadLog {
    protected int a = 3;
    protected IUploadExcuted b = null;
    protected NetworkStatus c = NetworkStatus.ALL;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public enum NetworkStatus {
        ALL,
        WIFI,
        TWO_GENERATION,
        THRID_GENERATION,
        FOUR_GENERATION,
        NONE
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public NetworkStatus a() {
        String h = NetworkUtil.h();
        if ("2G".equalsIgnoreCase(h)) {
            return NetworkStatus.TWO_GENERATION;
        }
        if ("3G".equalsIgnoreCase(h)) {
            return NetworkStatus.THRID_GENERATION;
        }
        if ("4G".equalsIgnoreCase(h)) {
            return NetworkStatus.FOUR_GENERATION;
        }
        if ("Wi-Fi".equalsIgnoreCase(h)) {
            return NetworkStatus.WIFI;
        }
        return NetworkStatus.NONE;
    }

    public void b(String str) {
        JSONObject jSONObject;
        Iterator<String> keys;
        String str2;
        if (!TextUtils.isEmpty(str)) {
            try {
                AbstractC3111d i = Variables.n().i();
                if (i == null || (jSONObject = new JSONObject(str).getJSONObject(Constants.CONFIG)) == null) {
                    return;
                }
                Iterator<String> keys2 = jSONObject.keys();
                if (keys2 != null && keys2.hasNext()) {
                    while (keys2.hasNext()) {
                        String next = keys2.next();
                        if (!TextUtils.isEmpty(next)) {
                            HashMap hashMap = new HashMap();
                            JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                            if (jSONObject2 != null && (keys = jSONObject2.keys()) != null) {
                                while (keys.hasNext()) {
                                    String next2 = keys.next();
                                    if (jSONObject2.get(next2) == null) {
                                        str2 = null;
                                    } else {
                                        str2 = jSONObject2.get(next2) + "";
                                    }
                                    hashMap.put(next2, str2);
                                }
                            }
                            Logger.f("Config Update", "namespace", next, WoodpeckerLocalConfigCenter.SP_CONFIGS_KEY, hashMap);
                            i.o(next, hashMap);
                        }
                    }
                    AbstractC3111d.m("1");
                    return;
                }
                Logger.m(null, "No Config Update");
                return;
            } catch (Throwable th) {
                Logger.h("", th, new Object[0]);
                return;
            }
        }
        Logger.v(null, "Config Is Empty");
    }

    public void c(NetworkStatus networkStatus) {
        this.c = networkStatus;
    }

    public void d(IUploadExcuted iUploadExcuted) {
        this.b = iUploadExcuted;
    }

    public void e(int i) {
        if (i >= 1 && i <= 10) {
            this.a = i;
        } else {
            this.a = 3;
        }
    }
}
