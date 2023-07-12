package com.youku.live.dsl.usertrack;

import android.app.Activity;
import android.net.Uri;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IUserTrackerVirtualImp implements IUserTracker {
    private static transient /* synthetic */ IpChange $ipChange;
    private final Map<String, String> mEmptyMap = new HashMap(1);

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public Map<String, String> getLastClickParams() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1282521915") ? (Map) ipChange.ipc$dispatch("-1282521915", new Object[]{this}) : this.mEmptyMap;
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void pageAppear(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1525975594")) {
            ipChange.ipc$dispatch("1525975594", new Object[]{this, obj});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void pageAppearDonotSkip(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1445766289")) {
            ipChange.ipc$dispatch("1445766289", new Object[]{this, obj});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void pageDisAppear(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "350146784")) {
            ipChange.ipc$dispatch("350146784", new Object[]{this, obj});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void setLastClickParams(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "686989161")) {
            ipChange.ipc$dispatch("686989161", new Object[]{this, map});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void skipPage(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-228643840")) {
            ipChange.ipc$dispatch("-228643840", new Object[]{this, obj});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void startSessionForUt(Activity activity, String str, String str2, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2138803003")) {
            ipChange.ipc$dispatch("2138803003", new Object[]{this, activity, str, str2, map});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void track4Click(String str, String str2, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "911687992")) {
            ipChange.ipc$dispatch("911687992", new Object[]{this, str, str2, map});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void track4Click(String str, String str2, String... strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1695848786")) {
            ipChange.ipc$dispatch("1695848786", new Object[]{this, str, str2, strArr});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void track4Show(String str, String str2, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "923257797")) {
            ipChange.ipc$dispatch("923257797", new Object[]{this, str, str2, map});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void trackCustom(String str, int i, String str2, String str3, String str4, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-672597462")) {
            ipChange.ipc$dispatch("-672597462", new Object[]{this, str, Integer.valueOf(i), str2, str3, str4, map});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void trackCustom(String str, String str2, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1390494891")) {
            ipChange.ipc$dispatch("-1390494891", new Object[]{this, str, str2, map});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void updateNextPageUtParam(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2124710273")) {
            ipChange.ipc$dispatch("-2124710273", new Object[]{this, str});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void updateNextPageUtParam(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-432944400")) {
            ipChange.ipc$dispatch("-432944400", new Object[]{this, map});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void updatePageName(Object obj, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1045864075")) {
            ipChange.ipc$dispatch("-1045864075", new Object[]{this, obj, str});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void updatePageProperties(Object obj, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "92826146")) {
            ipChange.ipc$dispatch("92826146", new Object[]{this, obj, map});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void updatePageUrl(Object obj, Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "754023306")) {
            ipChange.ipc$dispatch("754023306", new Object[]{this, obj, uri});
        }
    }
}
