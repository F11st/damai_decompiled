package com.youku.live.dsl.usertrack;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import cn.damai.common.user.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ut.mini.UTAnalytics;
import java.util.Map;
import tb.cb1;
import tb.rv2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IUserTrackerImp implements IUserTracker {
    private static transient /* synthetic */ IpChange $ipChange;
    private static IUserTracker sInstance;

    public static IUserTracker getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1284881263")) {
            return (IUserTracker) ipChange.ipc$dispatch("1284881263", new Object[0]);
        }
        if (sInstance == null) {
            synchronized (IUserTracker.class) {
                if (sInstance == null) {
                    sInstance = new IUserTrackerImp();
                }
            }
        }
        return sInstance;
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public Map<String, String> getLastClickParams() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1771571968") ? (Map) ipChange.ipc$dispatch("1771571968", new Object[]{this}) : rv2.d();
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void pageAppear(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-868702747")) {
            ipChange.ipc$dispatch("-868702747", new Object[]{this, obj});
        } else {
            c.e().r(obj);
        }
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void pageAppearDonotSkip(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1107069750")) {
            ipChange.ipc$dispatch("1107069750", new Object[]{this, obj});
        } else {
            c.e().s(this);
        }
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void pageDisAppear(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-105523387")) {
            ipChange.ipc$dispatch("-105523387", new Object[]{this, obj});
            return;
        }
        try {
            Map<String, String> b = rv2.b(UTAnalytics.getInstance().getDefaultTracker().getPageProperties(obj));
            String str = b.get("utparam-cnt");
            if (TextUtils.isEmpty(str)) {
                str = "{\"abtest\":\"0\"}";
            }
            rv2.f(str);
            updatePageProperties(obj, b);
            UTAnalytics.getInstance().getDefaultTracker().updatePageUtparam(obj, str);
            cb1.a("pageDisAppear->" + b.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        c.e().t(obj);
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void setLastClickParams(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "874619022")) {
            ipChange.ipc$dispatch("874619022", new Object[]{this, map});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void skipPage(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-874710405")) {
            ipChange.ipc$dispatch("-874710405", new Object[]{this, obj});
        } else {
            c.e().J(this);
        }
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void startSessionForUt(Activity activity, String str, String str2, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1585971638")) {
            ipChange.ipc$dispatch("1585971638", new Object[]{this, activity, str, str2, map});
            return;
        }
        updatePageName(activity, str);
        updatePageProperties(activity, map);
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void track4Click(String str, String str2, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1395174963")) {
            ipChange.ipc$dispatch("1395174963", new Object[]{this, str, str2, map});
        } else {
            c.e().y(str, str2, map);
        }
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void track4Click(String str, String str2, String... strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1323233075")) {
            ipChange.ipc$dispatch("-1323233075", new Object[]{this, str, str2, strArr});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void track4Show(String str, String str2, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-30977174")) {
            ipChange.ipc$dispatch("-30977174", new Object[]{this, str, str2, map});
        } else {
            c.e().D(str, str2, "", "", map, 2201);
        }
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void trackCustom(String str, int i, String str2, String str3, String str4, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1607114255")) {
            ipChange.ipc$dispatch("1607114255", new Object[]{this, str, Integer.valueOf(i), str2, str3, str4, map});
        } else {
            c.e().D(str, str2, str3, str4, map, i);
        }
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void updateNextPageUtParam(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1194569756")) {
            ipChange.ipc$dispatch("-1194569756", new Object[]{this, str});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void updateNextPageUtParam(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1495792555")) {
            ipChange.ipc$dispatch("1495792555", new Object[]{this, map});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void updatePageName(Object obj, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1789776144")) {
            ipChange.ipc$dispatch("-1789776144", new Object[]{this, obj, str});
        } else {
            c.e().N(obj, str);
        }
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void updatePageProperties(Object obj, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "239625927")) {
            ipChange.ipc$dispatch("239625927", new Object[]{this, obj, map});
        } else {
            c.e().O(obj, map);
        }
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void updatePageUrl(Object obj, Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1445631035")) {
            ipChange.ipc$dispatch("-1445631035", new Object[]{this, obj, uri});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IUserTracker
    public void trackCustom(String str, String str2, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-907007920")) {
            ipChange.ipc$dispatch("-907007920", new Object[]{this, str, str2, map});
        } else {
            c.e().D(str, str2, "", "", map, 19999);
        }
    }
}
