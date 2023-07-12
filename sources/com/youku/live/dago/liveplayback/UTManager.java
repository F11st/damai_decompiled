package com.youku.live.dago.liveplayback;

import android.text.TextUtils;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ut.mini.UTAnalytics;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.live.dago.liveplayback.widget.Utils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class UTManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "BusinessTrack";

    public static void playHeart(String str, String str2, String str3, String str4, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "238264955")) {
            ipChange.ipc$dispatch("238264955", new Object[]{str, str2, str3, str4, map});
            return;
        }
        String str5 = map != null ? map.get("pageName") : null;
        if (TextUtils.isEmpty(str5)) {
            str5 = "page_youkulive";
        }
        String str6 = str5;
        HashMap hashMap = new HashMap();
        hashMap.put("screen_id", str3);
        hashMap.put("roomid", str);
        hashMap.put("liveid", str);
        if (map != null) {
            hashMap.putAll(map);
        }
        Log.d(TAG, "UTReport:12030---" + str4);
        UTAnalytics.getInstance().getDefaultTracker().send(new UTOriginalCustomHitBuilder(str6, 12030, str, str2, str4, hashMap).build());
        printlog(TAG, "12030", hashMap);
    }

    public static void playStart(String str, String str2, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-465320405")) {
            ipChange.ipc$dispatch("-465320405", new Object[]{str, str2, map});
            return;
        }
        String str3 = map != null ? map.get("pageName") : null;
        if (TextUtils.isEmpty(str3)) {
            str3 = "page_youkulive";
        }
        String str4 = str3;
        HashMap hashMap = new HashMap();
        hashMap.put("roomid", str);
        hashMap.put("liveid", str);
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("client_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        Log.d(TAG, "UTReport:12002");
        UTAnalytics.getInstance().getDefaultTracker().send(new UTOriginalCustomHitBuilder(str4, 12002, str, str2, null, hashMap).build());
        printlog(TAG, "12002", hashMap);
    }

    public static void playStop(String str, String str2, String str3, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1443761223")) {
            ipChange.ipc$dispatch("1443761223", new Object[]{str, str2, str3, map});
            return;
        }
        String str4 = map != null ? map.get("pageName") : null;
        if (TextUtils.isEmpty(str4)) {
            str4 = "page_youkulive";
        }
        String str5 = str4;
        String diffTimeMillis = Utils.getDiffTimeMillis(str3);
        HashMap hashMap = new HashMap();
        hashMap.put("roomid", str);
        hashMap.put("liveid", str);
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("client_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        Log.d(TAG, "UTReport:12003 arg1=" + str + " arg2=" + str2 + " arg3=" + diffTimeMillis);
        UTAnalytics.getInstance().getDefaultTracker().send(new UTOriginalCustomHitBuilder(str5, 12003, str, str2, diffTimeMillis, hashMap).build());
        printlog(TAG, "12003", hashMap);
    }

    public static boolean printlog(String str, String str2, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1680809034")) {
            return ((Boolean) ipChange.ipc$dispatch("-1680809034", new Object[]{str, str2, map})).booleanValue();
        }
        if (str == null || map == null) {
            return false;
        }
        Logger.d(str, "#################################开始 " + str2 + " #####################################");
        printlog(str, map);
        Logger.d(str, "##################################结束 " + str2 + " ####################################");
        return true;
    }

    private static <T> void printlog(String str, Map<String, T> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1332693628")) {
            ipChange.ipc$dispatch("1332693628", new Object[]{str, map});
            return;
        }
        for (Map.Entry<String, T> entry : map.entrySet()) {
            String key = entry.getKey();
            T value = entry.getValue();
            if (key != null) {
                Logger.d(str, key + "=" + value);
            }
        }
    }
}
