package com.youku.middlewareservice.provider.analytics;

import android.app.Activity;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface AnalyticsProvider {
    void addToTrack(Activity activity);

    void clearIgnoreTagForExposureView(View view);

    void commitExposureData();

    void ignorePage(Object obj);

    void pageAppear(Object obj);

    void pageAppearDonotSkip(Object obj);

    void pageDisAppear(Object obj);

    void refreshExposureData();

    void scanView(View view);

    void setIgnoreTagForExposureView(View view);

    void setTrackerTagParam(View view, Map<String, String> map, String str);

    void setTrackerTagParamWithIndex(View view, String str, Map<String, String> map, String str2);

    void skipNextPageBack();

    void startSessionForUt(Activity activity, String str, String str2, Map<String, String> map);

    void startSessionForUt(Activity activity, String str, HashMap<String, String> hashMap);

    void utControlClick(String str, String str2, Map<String, String> map);

    void utCustomEvent(String str, int i, String str2, String str3, String str4, Map<String, String> map);
}
