package com.youku.usercenter.passport.statistics;

import android.text.TextUtils;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class Statistics {
    private static final String PARAM_BIND_FROM = "bindFrom";
    private static final String PARAM_LOGIN_FROM = "loginFrom";
    private static String sBindFrom;
    private static String sLastSpm;
    private static String sLoginFrom;
    private static String sLoginType;

    public static void CustomEvent(String str, String str2, Map<String, String> map) {
        try {
            appendBindFrom(map);
            appendLoginFrom(map);
            UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder(str2);
            uTCustomHitBuilder.setEventPage(str);
            uTCustomHitBuilder.setProperties(map);
            UTAnalytics.getInstance().getDefaultTracker().send(uTCustomHitBuilder.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void appendBindFrom(Map<String, String> map) {
        if (TextUtils.isEmpty(sBindFrom) || map == null) {
            return;
        }
        map.put(PARAM_BIND_FROM, sBindFrom);
    }

    private static void appendLoginFrom(Map<String, String> map) {
        if (TextUtils.isEmpty(sLoginFrom) || map == null) {
            return;
        }
        map.put("loginFrom", sLoginFrom);
    }

    public static void setLoginFrom(String str) {
        sLoginFrom = str;
    }
}
