package com.youku.middlewareservice_impl.provider.analytics;

import android.app.Activity;
import android.view.View;
import com.youku.middlewareservice.provider.analytics.AnalyticsProvider;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class AnalyticsProviderImpl implements AnalyticsProvider {
    @Override // com.youku.middlewareservice.provider.analytics.AnalyticsProvider
    public void addToTrack(Activity activity) {
    }

    @Override // com.youku.middlewareservice.provider.analytics.AnalyticsProvider
    public void clearIgnoreTagForExposureView(View view) {
    }

    @Override // com.youku.middlewareservice.provider.analytics.AnalyticsProvider
    public void commitExposureData() {
    }

    @Override // com.youku.middlewareservice.provider.analytics.AnalyticsProvider
    public void ignorePage(Object obj) {
    }

    @Override // com.youku.middlewareservice.provider.analytics.AnalyticsProvider
    public void pageAppear(Object obj) {
    }

    @Override // com.youku.middlewareservice.provider.analytics.AnalyticsProvider
    public void pageAppearDonotSkip(Object obj) {
    }

    @Override // com.youku.middlewareservice.provider.analytics.AnalyticsProvider
    public void pageDisAppear(Object obj) {
    }

    @Override // com.youku.middlewareservice.provider.analytics.AnalyticsProvider
    public void refreshExposureData() {
    }

    @Override // com.youku.middlewareservice.provider.analytics.AnalyticsProvider
    public void scanView(View view) {
    }

    @Override // com.youku.middlewareservice.provider.analytics.AnalyticsProvider
    public void setIgnoreTagForExposureView(View view) {
    }

    @Override // com.youku.middlewareservice.provider.analytics.AnalyticsProvider
    public void setTrackerTagParam(View view, Map<String, String> map, String str) {
    }

    @Override // com.youku.middlewareservice.provider.analytics.AnalyticsProvider
    public void setTrackerTagParamWithIndex(View view, String str, Map<String, String> map, String str2) {
    }

    @Override // com.youku.middlewareservice.provider.analytics.AnalyticsProvider
    public void skipNextPageBack() {
    }

    @Override // com.youku.middlewareservice.provider.analytics.AnalyticsProvider
    public void startSessionForUt(Activity activity, String str, String str2, Map<String, String> map) {
    }

    @Override // com.youku.middlewareservice.provider.analytics.AnalyticsProvider
    public void startSessionForUt(Activity activity, String str, HashMap<String, String> hashMap) {
    }

    @Override // com.youku.middlewareservice.provider.analytics.AnalyticsProvider
    public void utControlClick(String str, String str2, Map<String, String> map) {
    }

    @Override // com.youku.middlewareservice.provider.analytics.AnalyticsProvider
    public void utCustomEvent(String str, int i, String str2, String str3, String str4, Map<String, String> map) {
    }
}
