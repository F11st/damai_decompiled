package io.flutter.wpkbridge;

import androidx.annotation.Keep;
import io.flutter.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import tb.m80;

/* compiled from: Taobao */
@Keep
/* loaded from: classes3.dex */
public class WPKStatsUtil {
    public static final int CUSTOM_LOG_CATEGORY_EXECUTE_DART_ENTRYPOINT = 101;
    public static final int CUSTOM_LOG_CATEGORY_FIRST_FRAME = 102;
    public static final int CUSTOM_LOG_CATEGORY_FLUTTER_ENGINE_CONSTRUCTED = 100;
    public static final int CUSTOM_LOG_CATEGORY_SHELL_ENSURE_ASYNC_SETUP = 103;
    public static final int CUSTOM_LOG_CATEGORY_START_RENDERING_TO_SURFACE = 104;
    public static final String LOG_TAG = "WPKDebugLog";
    public static final String WPK_CONFIG_STARTUP_SAMPLE_RATE = "ucfe_startup_sample_rate";
    public static final double WPK_DEFAULT_STARTUP_SAMPLE_RATE = 50.0d;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class WPKCustomLogInfo {
        public String bid = "";
        public String frmid = "";
        public String url = "";
        public int category = 0;
        public String msg = "";
        public String c1 = "";
        public String c2 = "";
        public String c3 = "";
        public String c4 = "";
        public String c5 = "";
        public long avgv1 = 0;
        public boolean succ = false;
    }

    public static void commitCustomFile(WPKCustomLogInfo wPKCustomLogInfo, String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        if (customLogInfoToMap(wPKCustomLogInfo, hashMap)) {
            commitFile("custombin", hashMap, str, str2, str3, str4);
        }
    }

    public static void commitCustomRecord(WPKCustomLogInfo wPKCustomLogInfo, String str, String str2) {
        HashMap hashMap = new HashMap();
        if (customLogInfoToMap(wPKCustomLogInfo, hashMap)) {
            commitRecord("jssdkidx", hashMap, str, str2);
        }
    }

    public static void commitFile(String str, Map<String, String> map, String str2, String str3, String str4, String str5) {
        String valueOf = String.valueOf(U4WPKAdapter.goodTimeMillis() / 1000);
        JSONObject jSONObject = null;
        if (map != null) {
            if (str4 != null) {
                try {
                    if (str4.length() > 0) {
                        map.put("linkKey", str4);
                    }
                } catch (Throwable unused) {
                }
            }
            if (str5 != null && str5.length() > 0) {
                map.put("linkID", str5);
            }
            map.put(U4WPKAdapter.KEY_TM, valueOf);
        }
        if (str2 != null && str2.length() > 0) {
            jSONObject = new JSONObject(str2);
        }
        U4WPKAdapter.logFile(str, "kv_data", map, "json_data", jSONObject, "text_data", str3);
    }

    public static void commitRecord(String str, Map<String, String> map, String str2, String str3) {
        if (map == null || map.size() <= 0) {
            return;
        }
        U4StatLine obtain = U4StatLine.obtain();
        obtain.putMap(map);
        if (str2 != null && str2.length() > 0) {
            obtain.kvs("linkKey", str2);
        }
        if (str3 != null && str3.length() > 0) {
            obtain.kvs("linkID", str3);
        }
        obtain.kvs(U4WPKAdapter.KEY_TM, String.valueOf(U4WPKAdapter.goodTimeMillis() / 1000));
        obtain.sendToTarget(U4WPKAdapter.getWPKAdapter(0, str)).recycle();
    }

    private static boolean customLogInfoToMap(WPKCustomLogInfo wPKCustomLogInfo, HashMap<String, String> hashMap) {
        if (wPKCustomLogInfo != null && hashMap != null) {
            try {
                hashMap.put("category", String.valueOf(wPKCustomLogInfo.category));
                hashMap.put("avgv1", String.valueOf(wPKCustomLogInfo.avgv1));
                hashMap.put("succ", wPKCustomLogInfo.succ ? "1" : "0");
                String str = wPKCustomLogInfo.bid;
                if (str != null && !str.isEmpty()) {
                    hashMap.put("bid", wPKCustomLogInfo.bid);
                }
                String str2 = wPKCustomLogInfo.frmid;
                if (str2 != null && !str2.isEmpty()) {
                    hashMap.put("frmid", wPKCustomLogInfo.frmid);
                }
                String str3 = wPKCustomLogInfo.url;
                if (str3 != null && !str3.isEmpty()) {
                    hashMap.put("url", wPKCustomLogInfo.url);
                }
                String str4 = wPKCustomLogInfo.msg;
                if (str4 != null && !str4.isEmpty()) {
                    hashMap.put("msg", wPKCustomLogInfo.msg);
                }
                String str5 = wPKCustomLogInfo.c1;
                if (str5 != null && !str5.isEmpty()) {
                    hashMap.put("c1", wPKCustomLogInfo.c1);
                }
                String str6 = wPKCustomLogInfo.c2;
                if (str6 != null && !str6.isEmpty()) {
                    hashMap.put("c2", wPKCustomLogInfo.c2);
                }
                String str7 = wPKCustomLogInfo.c3;
                if (str7 != null && !str7.isEmpty()) {
                    hashMap.put("c3", wPKCustomLogInfo.c3);
                }
                String str8 = wPKCustomLogInfo.c4;
                if (str8 != null && !str8.isEmpty()) {
                    hashMap.put("c4", wPKCustomLogInfo.c4);
                }
                String str9 = wPKCustomLogInfo.c5;
                if (str9 == null || str9.isEmpty()) {
                    return true;
                }
                hashMap.put("c5", wPKCustomLogInfo.c5);
                return true;
            } catch (Exception e) {
                Log.e(LOG_TAG, "error when call customLogInfoToMap:" + e.toString());
            }
        }
        return false;
    }

    private static boolean getConfBoolean(String str, boolean z) {
        return U4WPKAdapter.getConfigs().optBoolean(str, z);
    }

    private static double getConfDouble(String str, double d) {
        return U4WPKAdapter.getConfigs().optDouble(str, d);
    }

    private static long getConfLong(String str, long j) {
        return U4WPKAdapter.getConfigs().optLong(str, j);
    }

    private static String getConfString(String str, String str2) {
        return U4WPKAdapter.getConfigs().optString(str, str2);
    }

    private static String getConfig() {
        return U4WPKAdapter.getConfigs().toString();
    }

    public static boolean shouldSample(String str, String str2, double d) {
        double d2 = -1.0d;
        if (!str.isEmpty()) {
            double confDouble = getConfDouble(str2.concat(m80.DINAMIC_PREFIX_AT).concat(str), -1.0d);
            d2 = confDouble < 0.0d ? getConfDouble(str2.concat("@*"), -1.0d) : confDouble;
        }
        if (d2 < 0.0d) {
            d2 = getConfDouble(str2, d);
        }
        return Math.random() < d2 / 100.0d;
    }
}
