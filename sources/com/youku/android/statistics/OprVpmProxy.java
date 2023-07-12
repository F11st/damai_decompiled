package com.youku.android.statistics;

import android.util.Log;
import java.util.LinkedHashSet;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OprVpmProxy {
    private static final String MODULE = "vpm";
    public static final String OPR2_DANMAKU_ABNORMAL = "opr_danmaku_abnormal_2.0";
    public static final String OPR2_DANMAKU_SUMMARY = "opr_danmaku_summary_2.0";
    private static final String TAG = "OprVpmProxy";
    private static boolean isRegistBarrageAbnormal;
    private static boolean isRegistBarrageSummary;

    public static void commitBarrageAbnormal(Map<String, String> map, Map<String, Double> map2) {
        if (map == null || map2 == null) {
            Log.e(TAG, "commitBarrageAbnormal --> param is null.");
            return;
        }
        if (!isRegistBarrageAbnormal) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (map.size() > 0) {
                linkedHashSet.addAll(map.keySet());
            }
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            if (map2.size() > 0) {
                linkedHashSet2.addAll(map2.keySet());
            }
            long currentTimeMillis = System.currentTimeMillis();
            OprUtProxy.getInstance().register(MODULE, OPR2_DANMAKU_ABNORMAL, linkedHashSet2, linkedHashSet);
            Log.d(TAG, "register barrage event cost:" + (System.currentTimeMillis() - currentTimeMillis));
            isRegistBarrageSummary = true;
        }
        OprUtProxy.getInstance().commit(MODULE, OPR2_DANMAKU_ABNORMAL, map, map2);
    }

    public static void commitBarrageSummary(Map<String, String> map, Map<String, Double> map2) {
        if (map == null || map2 == null) {
            Log.e(TAG, "commitBarrageSummary --> param is null.");
            return;
        }
        if (!isRegistBarrageSummary) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (map.size() > 0) {
                linkedHashSet.addAll(map.keySet());
            }
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            if (map2.size() > 0) {
                linkedHashSet2.addAll(map2.keySet());
            }
            long currentTimeMillis = System.currentTimeMillis();
            OprUtProxy.getInstance().register(MODULE, OPR2_DANMAKU_SUMMARY, linkedHashSet2, linkedHashSet);
            Log.d(TAG, "register barrage event cost:" + (System.currentTimeMillis() - currentTimeMillis));
            isRegistBarrageSummary = true;
        }
        OprUtProxy.getInstance().commit(MODULE, OPR2_DANMAKU_SUMMARY, map, map2);
    }
}
