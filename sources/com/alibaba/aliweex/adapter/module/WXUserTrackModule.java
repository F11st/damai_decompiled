package com.alibaba.aliweex.adapter.module;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import com.taobao.statistic.CT;
import com.taobao.statistic.TBS;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.utils.WXLogUtils;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.ut.mini.internal.UTTeamWork;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXUserTrackModule extends WXModule {
    public static final String CLICK = "click";
    public static final String CLICK_WITH_PAGENAME = "clickWithPageName";
    public static final String CUSTOM = "other";
    public static final String ENTER = "enter";
    public static final String EXPOSE = "expose";
    public static final String UPDATE_NEXT_PROP = "updateNextProp";

    @JSMethod
    public void addPerfPoint(Map<String, String> map) {
        WXSDKInstance wXSDKInstance;
        if (map == null || map.size() == 0 || (wXSDKInstance = this.mWXSDKInstance) == null || wXSDKInstance.getContext() == null) {
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                WXLogUtils.d("commitNetPoint", "Key = " + entry.getKey() + ", Value = " + entry.getValue());
                int intValue = Integer.valueOf(entry.getValue()).intValue();
                WXSDKInstance y = WXSDKManager.v().y(this.mWXSDKInstance.getInstanceId());
                y.mwxDims[intValue] = entry.getKey();
                long j = currentTimeMillis - y.mRenderStartTime;
                if (j > 0) {
                    y.measureTimes[intValue] = j;
                }
            }
        } catch (Exception e) {
            WXLogUtils.e(WXLogUtils.getStackTrace(e));
        }
    }

    @JSMethod
    public void clearIgnoreTagForExposureView(String str) {
        try {
            WXComponent wXComponent = WXSDKManager.v().G().getWXComponent(this.mWXSDKInstance.getInstanceId(), str);
            if (wXComponent == null) {
                return;
            }
            UTTeamWork.getInstance().clearIgnoreTagForExposureView(wXComponent.getHostView());
        } catch (Throwable unused) {
        }
    }

    public void click(String str, String str2, Map<String, String> map) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        UTHitBuilders.UTControlHitBuilder uTControlHitBuilder = !TextUtils.isEmpty(str) ? new UTHitBuilders.UTControlHitBuilder(str, str2) : new UTHitBuilders.UTControlHitBuilder(str2);
        uTControlHitBuilder.setProperties(map);
        UTAnalytics.getInstance().getDefaultTracker().send(uTControlHitBuilder.build());
    }

    @Deprecated
    public void clickWithPageName(String str, String str2, String str3, Map<String, String> map) {
        if (str == null || str2 == null || str3 == null || map == null) {
            return;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                stringBuffer.append(entry.getKey());
                stringBuffer.append("=");
                stringBuffer.append(entry.getValue());
                stringBuffer.append(",");
            }
            TBS.Adv.ctrlClickedOnPage(str, CT.Button, str3, stringBuffer.toString());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @JSMethod
    @Deprecated
    public void commit(String str, String str2, String str3, Map<String, String> map) {
        commitut(str, -1, str2, str3, "", "", "", map);
    }

    @JSMethod
    @Deprecated
    public void commitEvent(String str, int i, String str2, String str3, String str4, Map<String, String> map) {
        custom(str, str2, map);
    }

    @JSMethod
    public void commitut(String str, int i, String str2, String str3, String str4, String str5, String str6, Map<String, String> map) {
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance == null || wXSDKInstance.getContext() == null) {
            return;
        }
        if ("click".equals(str)) {
            click(str2, str3, map);
        } else if (EXPOSE.equals(str)) {
            expose(str2, i, str4, str5, str6, map);
        } else if ("enter".equals(str)) {
            enter(str2, str3, map);
        } else if ("other".equals(str)) {
            custom(str2, str4, map);
        } else if (UPDATE_NEXT_PROP.equals(str)) {
            updateNextProp(map);
        } else if (CLICK_WITH_PAGENAME.equals(str)) {
            clickWithPageName(str2, "click", str3, map);
        }
    }

    public void custom(String str, String str2, Map<String, String> map) {
        UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder(str2);
        uTCustomHitBuilder.setEventPage(str);
        uTCustomHitBuilder.setProperties(map);
        UTAnalytics.getInstance().getDefaultTracker().send(uTCustomHitBuilder.build());
    }

    @JSMethod
    public void customAdvance(String str, int i, String str2, String str3, String str4, Map<String, String> map) {
        UTAnalytics.getInstance().getDefaultTracker().send(new UTOriginalCustomHitBuilder(str, i, str2, str3, str4, map).build());
    }

    public void enter(String str, String str2, Map<String, String> map) {
        UTAnalytics.getInstance().getDefaultTracker().updatePageName(this.mWXSDKInstance.getContext(), str);
        UTAnalytics.getInstance().getDefaultTracker().updatePageProperties(this.mWXSDKInstance.getContext(), map);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        UTAnalytics.getInstance().getDefaultTracker().updatePageUrl(this.mWXSDKInstance.getContext(), Uri.parse(str2));
    }

    public void expose(String str, int i, String str2, String str3, String str4, Map<String, String> map) {
        UTAnalytics.getInstance().getDefaultTracker().send(new UTOriginalCustomHitBuilder(str, i < 0 ? 2201 : i, str2, str3, str4, map).build());
    }

    @JSMethod
    public void getPageSpmPre(JSCallback jSCallback) {
        String pageSpmPre = this.mWXSDKInstance.getContext() instanceof Activity ? UTAnalytics.getInstance().getDefaultTracker().getPageSpmPre((Activity) this.mWXSDKInstance.getContext()) : "";
        HashMap hashMap = new HashMap(1);
        hashMap.put("spmPre", pageSpmPre);
        jSCallback.invoke(hashMap);
    }

    @JSMethod
    public void getPageSpmUrl(JSCallback jSCallback) {
        String pageSpmUrl = this.mWXSDKInstance.getContext() instanceof Activity ? UTAnalytics.getInstance().getDefaultTracker().getPageSpmUrl((Activity) this.mWXSDKInstance.getContext()) : "";
        HashMap hashMap = new HashMap(1);
        hashMap.put("spmUrl", pageSpmUrl);
        jSCallback.invoke(hashMap);
    }

    @JSMethod
    public void pageAppear() {
        UTAnalytics.getInstance().getDefaultTracker().pageAppearDonotSkip(this.mWXSDKInstance.getContext());
    }

    @JSMethod
    public void pageDisAppear() {
        UTAnalytics.getInstance().getDefaultTracker().pageDisAppear(this.mWXSDKInstance.getContext());
    }

    @JSMethod
    public void refreshBlockExposureData(String str) {
        try {
            UTAnalytics.getInstance().getDefaultTracker().refreshExposureData(str);
        } catch (Throwable unused) {
        }
    }

    @JSMethod
    public void refreshExposureViewWithBlock(String str, String str2) {
        try {
            UTAnalytics.getInstance().getDefaultTracker().refreshExposureDataByViewId(str, str2);
        } catch (Throwable unused) {
        }
    }

    @JSMethod
    public void refreshPageExposure() {
        try {
            UTAnalytics.getInstance().getDefaultTracker().refreshExposureData();
        } catch (Throwable unused) {
        }
    }

    @JSMethod
    public void setExposureView(String str, String str2, Map<String, String> map) {
        try {
            WXComponent wXComponent = WXSDKManager.v().G().getWXComponent(this.mWXSDKInstance.getInstanceId(), str);
            if (wXComponent == null) {
                return;
            }
            UTAnalytics.getInstance().getDefaultTracker().setExposureTag(wXComponent.getHostView(), str2, str, map);
        } catch (Throwable unused) {
        }
    }

    @JSMethod
    public void setIgnoreTagForExposureView(String str) {
        try {
            WXComponent wXComponent = WXSDKManager.v().G().getWXComponent(this.mWXSDKInstance.getInstanceId(), str);
            if (wXComponent == null) {
                return;
            }
            UTTeamWork.getInstance().setIgnoreTagForExposureView(wXComponent.getHostView());
        } catch (Throwable unused) {
        }
    }

    @JSMethod
    public void skipPage() {
        UTAnalytics.getInstance().getDefaultTracker().skipPage(this.mWXSDKInstance.getContext());
    }

    @JSMethod
    public void updateNextPageUtparam(String str) {
        UTAnalytics.getInstance().getDefaultTracker().updateNextPageUtparam(str);
    }

    public void updateNextProp(Map<String, String> map) {
        UTAnalytics.getInstance().getDefaultTracker().updateNextPageProperties(map);
    }

    @JSMethod
    public void updatePageUtparam(String str) {
        UTAnalytics.getInstance().getDefaultTracker().updatePageUtparam(this.mWXSDKInstance.getContext(), str);
    }
}
