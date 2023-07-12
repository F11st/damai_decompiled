package com.ali.user.open.ut;

import android.app.Activity;
import android.text.TextUtils;
import com.ali.user.open.core.service.UserTrackerService;
import com.ali.user.open.core.trace.SDKLogger;
import com.alibaba.fastjson.JSON;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UserTrackerImpl implements UserTrackerService {
    public static final String TAG = "login.UserTraceImpl";

    private static Map<String, String> getAppInfo() {
        return new HashMap();
    }

    @Override // com.ali.user.open.core.service.UserTrackerService
    public void pageDisAppear(Activity activity) {
        UTAnalytics.getInstance().getDefaultTracker().pageDisAppear(activity);
    }

    @Override // com.ali.user.open.core.service.UserTrackerService
    public void send(String str, Map<String, String> map) {
        send("", str, map);
    }

    @Override // com.ali.user.open.core.service.UserTrackerService
    public void sendControl(String str, String str2, String str3, Map<String, String> map) {
        UTHitBuilders.UTControlHitBuilder uTControlHitBuilder = new UTHitBuilders.UTControlHitBuilder(str, str2);
        if (!TextUtils.isEmpty(str3)) {
            uTControlHitBuilder.setProperty(UTHitBuilders.UTHitBuilder.FIELD_ARG2, str3);
        }
        uTControlHitBuilder.setProperties(map);
        UTAnalytics.getInstance().getDefaultTracker().send(uTControlHitBuilder.build());
    }

    @Override // com.ali.user.open.core.service.UserTrackerService
    public void skipPage(Activity activity) {
        UTAnalytics.getInstance().getDefaultTracker().skipPage(activity);
    }

    @Override // com.ali.user.open.core.service.UserTrackerService
    public void updatePageName(Activity activity, String str, Map<String, String> map) {
        UTAnalytics.getInstance().getDefaultTracker().pageDisAppear(activity);
        UTAnalytics.getInstance().getDefaultTracker().pageAppearDonotSkip(activity, str);
        if (map != null) {
            UTAnalytics.getInstance().getDefaultTracker().updatePageProperties(activity, map);
        }
    }

    @Override // com.ali.user.open.core.service.UserTrackerService
    public void send(String str, String str2, Map<String, String> map) {
        try {
            UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder(str2);
            StringBuilder sb = new StringBuilder();
            sb.append("[LoginUtAnalytics] sendUT, page=");
            if (!TextUtils.isEmpty(str)) {
                uTCustomHitBuilder.setEventPage(str);
                sb.append(str);
            }
            sb.append(", arg1=");
            sb.append(str2);
            sb.append(",args=");
            Map<String, String> appInfo = getAppInfo();
            if (map != null) {
                appInfo.putAll(map);
                sb.append(JSON.toJSONString(map));
            }
            uTCustomHitBuilder.setProperties(appInfo);
            UTAnalytics.getInstance().getDefaultTracker().send(uTCustomHitBuilder.build());
            SDKLogger.d("login.UserTraceImpl", sb.toString());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
