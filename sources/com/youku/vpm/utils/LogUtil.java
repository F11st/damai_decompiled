package com.youku.vpm.utils;

import android.util.Log;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class LogUtil {
    public static boolean sIsDebug;

    public static void d(String str, String str2) {
        Log.d(str, str2);
    }

    private static <T> void printLog(String str, Map<String, T> map) {
        for (Map.Entry<String, T> entry : map.entrySet()) {
            String key = entry.getKey();
            T value = entry.getValue();
            if (key != null) {
                d(str, key + "=" + value);
            }
        }
    }

    public static void printLog(String str, Map<String, String> map, Map<String, Double> map2) {
        d(str, "#################################开始 " + str + " #####################################");
        printLog(str, map);
        printLog(str, map2);
        d(str, "#################################结束 " + str + " #####################################");
    }

    public static <T> void printlog(String str, Map<String, T> map) {
        d(str, "#################################开始 " + str + " #####################################");
        for (Map.Entry<String, T> entry : map.entrySet()) {
            String key = entry.getKey();
            T value = entry.getValue();
            if (key != null) {
                d(str, key + "=" + value);
            }
        }
        d(str, "#################################结束 " + str + " #####################################");
    }
}
