package com.taobao.ma.common.usertrack;

import com.taobao.ma.common.Version;
import com.taobao.ma.common.constants.MaConstants;
import com.taobao.ma.common.result.MaResult;
import com.taobao.ma.core.Ma;
import com.taobao.ma.util.StringUtils;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTLogger {
    private static void send(Map<String, String> map) {
        UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder(MaConstants.UT_EVENT_NAME);
        uTCustomHitBuilder.setProperties(map);
        UTAnalytics.getInstance().getTracker("ma_tracker").send(uTCustomHitBuilder.build());
    }

    public static void userTrack(MaResult maResult) {
        HashMap hashMap = new HashMap();
        hashMap.put("sdkversion", Version.SDK_VERSION_CODE);
        if (StringUtils.isNotEmpty(Ma.getMaConfig().onesdkversion)) {
            hashMap.put(MaConstants.UT_PARAM_KEY_ONE_SDK_VERSION, Ma.getMaConfig().onesdkversion);
        }
        hashMap.put("type", maResult.getType().toString());
        hashMap.put("content", maResult.getText());
        send(hashMap);
    }

    public static void userTrack(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        send(hashMap);
    }
}
