package com.youku.live.dago.widgetlib.ailproom.adapter.analytics;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ut.mini.UTAnalytics;
import com.youku.live.dago.widgetlib.ailpbaselib.protocol.AILPAnalyticsProtocol;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.usertrack.IUserTracker;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AILPAnalyticsUTAdapter implements AILPAnalyticsProtocol {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final String TAG = AILPAnalyticsProtocol.class.getSimpleName();
    private Map<String, String> mParamMap;

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.protocol.AILPAnalyticsProtocol
    public void click(String str, String str2, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1597696842")) {
            ipChange.ipc$dispatch("1597696842", new Object[]{this, str, str2, map});
            return;
        }
        String str3 = TAG;
        Log.d(str3, "click pageName= " + str + " eventName= " + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Click(str, str2, (HashMap) map);
    }

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.protocol.AILPAnalyticsProtocol
    public void customEvent(String str, int i, String str2, String str3, String str4, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-313250028")) {
            ipChange.ipc$dispatch("-313250028", new Object[]{this, str, Integer.valueOf(i), str2, str3, str4, map});
            return;
        }
        String str5 = TAG;
        Log.d(str5, "customEvent pageName= " + str + " aArg1= " + str2 + " aArg2= " + str3 + " aArg3= " + str4);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Map<String, String> map2 = this.mParamMap;
        if (map2 != null && (i == 12002 || i == 12003 || i == 12030)) {
            String str6 = map2.get("scm");
            String str7 = this.mParamMap.get("spm-url");
            Log.d(str5, "customEvent scm = " + str6 + " spmUrl = " + str7);
            if (!map.containsKey("scm") && !TextUtils.isEmpty(str6)) {
                map.put("scm", str6);
            }
            if (!map.containsKey("spm-url") && !TextUtils.isEmpty(str7)) {
                map.put("spm-url", str7);
            }
        }
        ((IUserTracker) Dsl.getService(IUserTracker.class)).trackCustom(str, i, str2, str3, str4, map);
    }

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.protocol.AILPAnalyticsProtocol
    public void pageAppear(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1039307729")) {
            ipChange.ipc$dispatch("1039307729", new Object[]{this, context});
            return;
        }
        Log.d(TAG, "pageAppear");
        if (context == null) {
            return;
        }
        UTAnalytics.getInstance().getDefaultTracker().pageAppear(context);
        Map<String, String> pageProperties = UTAnalytics.getInstance().getDefaultTracker().getPageProperties(context);
        if (pageProperties == null) {
            pageProperties = new HashMap<>();
        }
        pageProperties.put("YKLType", "YKLLivePage");
    }

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.protocol.AILPAnalyticsProtocol
    public void pageDisAppear(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-523911987")) {
            ipChange.ipc$dispatch("-523911987", new Object[]{this, context});
            return;
        }
        Log.d(TAG, "pageDisAppear");
        if (context == null) {
            return;
        }
        UTAnalytics.getInstance().getDefaultTracker().pageDisAppear(context);
    }

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.protocol.AILPAnalyticsProtocol
    public void updatePageName(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2014031686")) {
            ipChange.ipc$dispatch("-2014031686", new Object[]{this, context, str});
            return;
        }
        String str2 = TAG;
        Log.d(str2, "updatePageName pageName= " + str);
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        UTAnalytics.getInstance().getDefaultTracker().updatePageName(context, str);
    }

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.protocol.AILPAnalyticsProtocol
    public void updatePageProperties(Context context, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-980018067")) {
            ipChange.ipc$dispatch("-980018067", new Object[]{this, context, map});
            return;
        }
        String str = TAG;
        Log.d(str, "updatePageProperties properties= " + map);
        if (context == null || map == null) {
            return;
        }
        this.mParamMap = UTAnalytics.getInstance().getDefaultTracker().getPageProperties(context);
        UTAnalytics.getInstance().getDefaultTracker().updatePageProperties(context, map);
    }
}
