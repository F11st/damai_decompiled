package com.alibaba.aliweex.adapter.module;

import android.text.TextUtils;
import com.alibaba.aliweex.adapter.adapter.WXAPMAdapter;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.performance.WXInstanceApm;
import com.taobao.weex.utils.WXUtils;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXPerformanceModule extends WXModule {
    private static final String KEY_PROPERTIES_JS_MTOP_TIME = "wxMtopTime";
    private static final String KEY_PROPERTIES_JS_PREFETCH_TIME = "wxJSDataPrefetchTime";
    private static final String KEY_PROPERTIES_PREFETCH_SUCCESS = "wxJSDataPrefetchSuccess";
    public static final String KEY_STAGE_JS_ASYNC_DATA_END = "wxJSAsyncDataEnd";
    public static final String KEY_STAGE_JS_ASYNC_DATA_START = "wxJSAsyncDataStart";
    private long mStartTime = -1;
    private long mEndTime = -1;

    @JSMethod
    public void onStage(String str) {
        if (this.mWXSDKInstance == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.mWXSDKInstance.getApmForInstance().r(str);
    }

    @JSMethod
    public void recordAsyncTime(Map<String, String> map) {
        if (map == null) {
            return;
        }
        String str = KEY_PROPERTIES_JS_PREFETCH_TIME;
        if (!map.containsKey(KEY_PROPERTIES_JS_PREFETCH_TIME)) {
            if (!map.containsKey(KEY_PROPERTIES_JS_MTOP_TIME)) {
                return;
            }
            str = KEY_PROPERTIES_JS_MTOP_TIME;
        }
        long j = -1;
        try {
            j = Long.valueOf(map.get(str)).longValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (j < 0) {
            return;
        }
        if (this.mStartTime < 0) {
            long fixUnixTime = WXUtils.getFixUnixTime() - j;
            this.mStartTime = fixUnixTime;
            this.mEndTime = fixUnixTime;
            this.mWXSDKInstance.getApmForInstance().s(KEY_STAGE_JS_ASYNC_DATA_START, this.mStartTime);
        }
        this.mEndTime += j;
        this.mWXSDKInstance.getApmForInstance().s(KEY_STAGE_JS_ASYNC_DATA_END, this.mEndTime);
        if (map.containsKey(KEY_PROPERTIES_PREFETCH_SUCCESS)) {
            this.mWXSDKInstance.getApmForInstance().e(KEY_PROPERTIES_PREFETCH_SUCCESS, Integer.valueOf("true".equalsIgnoreCase(map.get(KEY_PROPERTIES_PREFETCH_SUCCESS)) ? 1 : 0));
        }
    }

    @JSMethod
    public void recordInteractionTime() {
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance == null) {
            return;
        }
        wXSDKInstance.getApmForInstance().k = true;
        this.mWXSDKInstance.getApmForInstance().r(WXInstanceApm.KEY_PAGE_STAGES_INTERACTION);
    }

    @JSMethod
    public void setProperty(String str, String str2) {
        if (this.mWXSDKInstance == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.mWXSDKInstance.getApmForInstance().e(str, str2);
    }

    @JSMethod
    public void setStats(String str, double d) {
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance == null) {
            return;
        }
        wXSDKInstance.getApmForInstance().g(str, d);
    }

    @JSMethod
    public void showPerformanceInoInRelease(Boolean bool) {
        if (bool == null) {
            return;
        }
        WXAPMAdapter.h = bool.booleanValue();
    }
}
