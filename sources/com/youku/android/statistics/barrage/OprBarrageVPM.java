package com.youku.android.statistics.barrage;

import android.util.Log;
import com.youku.android.statistics.OprVpmProxy;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OprBarrageVPM {
    public static final String TAG = "OprBarrageVPM";

    public void submitBarrageAbnormal(Map<String, String> map, Map<String, Double> map2) {
        Log.d(TAG, "submitBarrageAbnormal");
        OprVpmProxy.commitBarrageAbnormal(map, map2);
    }

    public void submitBarrageSummary(Map<String, String> map, Map<String, Double> map2) {
        Log.d(TAG, "submitBarrageSummary");
        OprVpmProxy.commitBarrageSummary(map, map2);
    }
}
