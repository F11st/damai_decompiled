package com.youku.live.livesdk.widgets.dialog;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.analytics.AnalyticsAgent;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.usertrack.IUserTracker;
import com.youku.live.widgets.WidgetSDKEngine;
import com.youku.live.widgets.protocol.Orientation;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class InterceptDialogHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    private static InterceptDialogHelper sInstance;
    private String showIds = "";

    public static InterceptDialogHelper getsInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "699586620")) {
            return (InterceptDialogHelper) ipChange.ipc$dispatch("699586620", new Object[0]);
        }
        if (sInstance == null) {
            sInstance = new InterceptDialogHelper();
        }
        return sInstance;
    }

    public void addLiveId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "280763694")) {
            ipChange.ipc$dispatch("280763694", new Object[]{this, str});
            return;
        }
        this.showIds += str + "&";
    }

    public boolean containsLiveId(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-192189274") ? ((Boolean) ipChange.ipc$dispatch("-192189274", new Object[]{this, str})).booleanValue() : !TextUtils.isEmpty(this.showIds) && this.showIds.contains(str);
    }

    public String getDirection() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2070481835") ? (String) ipChange.ipc$dispatch("2070481835", new Object[]{this}) : WidgetSDKEngine.getOrientation() == Orientation.ORIENTATION_LANDSCAPE ? "fplayer" : "vplayer";
    }

    public void reportDialogCloseButtonClick(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2036364906")) {
            ipChange.ipc$dispatch("-2036364906", new Object[]{this, str, str2, str3, str4, str5});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("spm", "a2h08.8176999.likai.guanbi");
        hashMap.put("liveid", str2);
        hashMap.put("screenid", str3);
        hashMap.put("type", str4);
        hashMap.put("direction", getDirection());
        hashMap.put("interact_type", "50");
        hashMap.put("kaiguan", str5);
        track4Click(str, "likai-guanbi", hashMap);
    }

    public void reportDialogCloseButtonShow(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2026503703")) {
            ipChange.ipc$dispatch("-2026503703", new Object[]{this, str, str2, str3, str4});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("spm", "a2h08.8176999.likai.guanbi");
        hashMap.put("liveid", str2);
        hashMap.put("screenid", str3);
        hashMap.put("type", str4);
        hashMap.put("direction", getDirection());
        hashMap.put("interact_type", "50");
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Show(str, "likai-guanbi", hashMap);
    }

    public void reportDialogLeftButtonClick(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2025733279")) {
            ipChange.ipc$dispatch("-2025733279", new Object[]{this, str, str2, str3, str4});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("spm", "a2h08.8176999.likai.tuichu");
        hashMap.put("liveid", str2);
        hashMap.put("screenid", str3);
        hashMap.put("type", str4);
        hashMap.put("direction", getDirection());
        hashMap.put("interact_type", "50");
        track4Click(str, "likai-tuichu", hashMap);
    }

    public void reportDialogLeftButtonShow(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2130881868")) {
            ipChange.ipc$dispatch("-2130881868", new Object[]{this, str, str2, str3, str4});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("spm", "a2h08.8176999.likai.tuichu");
        hashMap.put("liveid", str2);
        hashMap.put("screenid", str3);
        hashMap.put("type", str4);
        hashMap.put("direction", getDirection());
        hashMap.put("interact_type", "50");
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Show(str, "likai-tuichu", hashMap);
    }

    public void reportDialogRightButtonClick(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-424650310")) {
            ipChange.ipc$dispatch("-424650310", new Object[]{this, str, str2, str3, str4, str5});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("spm", "a2h08.8176999.likai.tiaozhuan");
        hashMap.put("liveid", str2);
        hashMap.put("screenid", str3);
        hashMap.put("type", str4);
        hashMap.put("direction", getDirection());
        hashMap.put("interact_type", "50");
        hashMap.put("url", str5);
        track4Click(str, "likai-tiaozhuan", hashMap);
    }

    public void reportDialogRightButtonShow(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1798471375")) {
            ipChange.ipc$dispatch("1798471375", new Object[]{this, str, str2, str3, str4, str5});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("spm", "a2h08.8176999.likai.tiaozhuan");
        hashMap.put("liveid", str2);
        hashMap.put("screenid", str3);
        hashMap.put("type", str4);
        hashMap.put("direction", getDirection());
        hashMap.put("interact_type", "50");
        hashMap.put("url", str5);
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Show(str, "likai-tiaozhuan", hashMap);
    }

    public void track4Click(String str, String str2, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1972782300")) {
            ipChange.ipc$dispatch("-1972782300", new Object[]{this, str, str2, map});
        } else {
            AnalyticsAgent.utCustomEvent(str, 2101, str2, (String) null, (String) null, map);
        }
    }
}
