package com.youku.android.utils;

import android.util.Log;
import androidx.annotation.Keep;
import com.youku.media.arch.instruments.ConfigFetcher;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
@Keep
/* loaded from: classes8.dex */
public class ApsConfigUtils {
    private static final String TAG = "ApsConfigUtils";

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    private static class ApsConfigHolder {
        private static final ApsConfigUtils instance = new ApsConfigUtils();

        private ApsConfigHolder() {
        }
    }

    private ApsConfigUtils() {
    }

    public static ApsConfigUtils getInstance() {
        return ApsConfigHolder.instance;
    }

    public String getConfig(String str, String str2, String str3) {
        Log.d(TAG, "getConfig, namespace: " + str + ", key: " + str2 + ", defVal: " + str3);
        return ConfigFetcher.getInstance() == null ? str3 : ConfigFetcher.getInstance().getConfig(str, str2, str3);
    }

    public Map<String, String> getConfigs(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("get configs from namespace: ");
            sb.append(str);
            sb.append(", fetcher: ");
            sb.append(ConfigFetcher.getInstance() == null ? "null" : ConfigFetcher.getInstance().toString());
            Log.d(TAG, sb.toString());
            if (ConfigFetcher.getInstance() != null) {
                ConfigFetcher.getInstance().getGetterFactory();
            }
        } catch (Throwable unused) {
        }
        return ConfigFetcher.getInstance() == null ? new HashMap() : ConfigFetcher.getInstance().getConfigs(str);
    }
}
