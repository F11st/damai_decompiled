package com.youku.live.dago.liveplayback.widget;

import android.content.Context;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ut.mini.UTAnalytics;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.youku.live.dago.liveplayback.NetWorkUtil;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PlayerPerformanceHelper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String TAG = "PlayerPerformanceHelper";

    public static void reportSecondPlay(Context context, String str, boolean z, String str2, Map<String, String> map, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1014184075")) {
            ipChange.ipc$dispatch("1014184075", new Object[]{context, str, Boolean.valueOf(z), str2, map, Long.valueOf(j)});
        } else if (context != null) {
            String str3 = TAG;
            Log.e(str3, "time cost 秒开:" + (System.currentTimeMillis() - j));
            HashMap hashMap = new HashMap();
            hashMap.put("first_play_time_cost", (System.currentTimeMillis() - j) + "");
            hashMap.put("network", NetWorkUtil.getCurrentNetworkType(context) + "");
            hashMap.put("os_type", "Android");
            hashMap.put("enter_room_type", str);
            hashMap.put("is_fast_play", z ? "1" : "0");
            hashMap.put("mic_order", str2);
            hashMap.putAll(map);
            UTAnalytics.getInstance().getDefaultTracker().send(new UTOriginalCustomHitBuilder("page_first_play", 19999, "room_performance_firstplay", "", "", hashMap).build());
        }
    }
}
