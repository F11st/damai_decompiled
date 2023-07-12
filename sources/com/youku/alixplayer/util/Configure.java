package com.youku.alixplayer.util;

import android.util.Log;
import androidx.annotation.Keep;
import com.youku.media.arch.instruments.ConfigFetcher;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
@Keep
/* loaded from: classes5.dex */
public class Configure {
    private static Map<String, String> sLoacalMap = new HashMap();

    public static Map<String, String> allConfigs(String str) {
        return ConfigFetcher.getInstance().getConfigs(str);
    }

    public static void changeLocalConfig(String str, String str2, String str3) {
        sLoacalMap.put(str2, str3);
    }

    public static String getConfig(String str, String str2, String str3) {
        Log.d("ALIX_LOG", "getConfig: ns" + str + ", key:" + str2 + ", defaultValue:" + str3);
        return ConfigFetcher.getInstance().getConfig(str, str2, str3);
    }

    public static String getLocalConfig(String str, String str2, String str3) {
        return sLoacalMap.get(str2) == null ? str3 : sLoacalMap.get(str2);
    }
}
