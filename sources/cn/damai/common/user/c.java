package cn.damai.common.user;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import cn.damai.common.AppConfig;
import cn.damai.common.user.UTExposureInfo;
import cn.damai.common.user.a;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders;
import com.ut.mini.UTTracker;
import com.ut.mini.exposure.ExposureUtils;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.ut.mini.internal.UTTeamWork;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import tb.hm1;
import tb.o23;
import tb.rv2;
import tb.wh2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class c {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int EXPOSURE_ENENTID = 2201;
    public static final int VIDEO_PLAYER_END_ENENTID = 12003;
    public static final int VIDEO_PLAYER_START_ENENTID = 12002;
    ArrayList<UTExposureInfo.UTExposureBean> a;
    Map<String, String> b;
    UTExposureInfo.UTExposureBean c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public static class b {
        private static final c a = new c();
    }

    private void a(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2088221418")) {
            ipChange.ipc$dispatch("-2088221418", new Object[]{this, map});
        } else if (map != null) {
            try {
                if (map.containsKey("city")) {
                    if (hm1.a(map.get("city"))) {
                        map.put("city", z20.d());
                    } else {
                        String str = map.get("city");
                        if (!TextUtils.isEmpty(str)) {
                            if (str.endsWith("市") && str.length() > 1) {
                                map.put("city", str.substring(0, str.length() - 1));
                            }
                        } else {
                            map.put("city", z20.d());
                        }
                    }
                } else {
                    map.put("city", z20.d());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String c(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1501840605")) {
            return (String) ipChange.ipc$dispatch("-1501840605", new Object[]{this, str, str2, str3});
        }
        if (!TextUtils.isEmpty(str2) && h(str2.substring(str2.length() - 1)) && str2.contains(JSMethod.NOT_SET)) {
            str2 = str2.substring(0, str2.lastIndexOf(JSMethod.NOT_SET));
        }
        if (!TextUtils.isEmpty(str3) && h(str3.substring(str3.length() - 1)) && str3.contains(JSMethod.NOT_SET)) {
            str3 = str3.substring(0, str3.lastIndexOf(JSMethod.NOT_SET));
        }
        return "page_" + str + JSMethod.NOT_SET + str2 + JSMethod.NOT_SET + str3;
    }

    public static final c e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-36379293") ? (c) ipChange.ipc$dispatch("-36379293", new Object[0]) : b.a;
    }

    private Map<String, String> f(cn.damai.common.user.a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "4480989")) {
            return (Map) ipChange.ipc$dispatch("4480989", new Object[]{this, aVar});
        }
        Map<String, String> hashMap = new HashMap<>();
        if (aVar == null) {
            return hashMap;
        }
        if (aVar.u() != null) {
            hashMap = aVar.u();
        }
        if (!TextUtils.isEmpty(aVar.p())) {
            hashMap.put("item_id", aVar.p());
        }
        if (!TextUtils.isEmpty(aVar.m())) {
            hashMap.put("city", aVar.m());
        }
        a(hashMap);
        if (!TextUtils.isEmpty(aVar.q())) {
            hashMap.put("keyword", aVar.q());
        }
        if (!TextUtils.isEmpty(aVar.s())) {
            hashMap.put("orderid", aVar.s());
        }
        if (!TextUtils.isEmpty(aVar.v())) {
            hashMap.put("titlelabel", aVar.v());
        }
        if (!TextUtils.isEmpty(aVar.n())) {
            hashMap.put("contentlabel", aVar.n());
        }
        hashMap.put("spm-cnt", "a2o4t." + aVar.t() + ".0.0");
        return hashMap;
    }

    private boolean h(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1034050576")) {
            return ((Boolean) ipChange.ipc$dispatch("-1034050576", new Object[]{this, str})).booleanValue();
        }
        try {
            return Pattern.compile("[0-9]*").matcher(str).matches();
        } catch (Exception unused) {
            return false;
        }
    }

    private void i(cn.damai.common.user.a aVar, boolean z) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1394001846")) {
            ipChange.ipc$dispatch("1394001846", new Object[]{this, aVar, Boolean.valueOf(z)});
            return;
        }
        HashMap hashMap = new HashMap();
        if (aVar.u() != null) {
            hashMap.putAll(aVar.u());
        }
        a(hashMap);
        hashMap.remove("PreABTrackInfo");
        hashMap.put("spm", "a2o4t." + aVar.t() + "." + aVar.r() + "." + aVar.w());
        if (z) {
            hashMap.put("dm_event_id", "2001");
        }
        String r = aVar.r();
        if (!TextUtils.isEmpty(r) && h(r.substring(r.length() - 1)) && r.contains(JSMethod.NOT_SET)) {
            r = r.substring(0, r.lastIndexOf(JSMethod.NOT_SET));
        }
        String w = aVar.w();
        if (!TextUtils.isEmpty(aVar.o())) {
            str = aVar.o();
        } else {
            if (!TextUtils.isEmpty(w) && h(w.substring(w.length() - 1)) && w.contains(JSMethod.NOT_SET)) {
                w = w.substring(0, w.lastIndexOf(JSMethod.NOT_SET));
            }
            str = r + JSMethod.NOT_SET + w;
        }
        UTHitBuilders.UTControlHitBuilder uTControlHitBuilder = new UTHitBuilders.UTControlHitBuilder("page_" + aVar.t(), str);
        uTControlHitBuilder.setProperties(hashMap);
        UTAnalytics.getInstance().getDefaultTracker().send(uTControlHitBuilder.build());
    }

    public void A(Map<String, String> map, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2015646408")) {
            ipChange.ipc$dispatch("-2015646408", new Object[]{this, map, str, str2});
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        a(map);
        UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder(str);
        uTCustomHitBuilder.setEventPage("page_" + str2);
        uTCustomHitBuilder.setProperties(map);
        try {
            UTAnalytics.getInstance().getDefaultTracker().send(uTCustomHitBuilder.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void B(String str, String str2, ArrayList<UTExposureInfo.UTExposureBean> arrayList, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1709756700")) {
            ipChange.ipc$dispatch("-1709756700", new Object[]{this, str, str2, arrayList, Integer.valueOf(i)});
            return;
        }
        String str3 = "page_" + str2;
        String c = c(str2, str, "");
        Map<String, String> map = this.b;
        if (map != null) {
            map.clear();
        } else {
            this.b = new HashMap();
        }
        if (arrayList != null) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (arrayList.get(i2) != null) {
                    if (arrayList.get(i2).exargs == null) {
                        arrayList.get(i2).exargs = new HashMap();
                    }
                    a(arrayList.get(i2).exargs);
                }
            }
        }
        this.b.put("expdata", JSON.toJSONString(arrayList));
        try {
            UTAnalytics.getInstance().getDefaultTracker().send(new UTOriginalCustomHitBuilder(str3, i, c, null, null, this.b).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void C(String str, String str2, String str3, String str4, long j, Map<String, String> map, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1426247301")) {
            ipChange.ipc$dispatch("-1426247301", new Object[]{this, str, str2, str3, str4, Long.valueOf(j), map, Integer.valueOf(i)});
        } else if (j > 500) {
            String str5 = "page_" + str3;
            String c = c(str3, str2, str);
            String str6 = ("a2o4t." + str3 + "." + str2) + "." + str;
            ArrayList<UTExposureInfo.UTExposureBean> arrayList = this.a;
            if (arrayList != null) {
                arrayList.clear();
            } else {
                this.a = new ArrayList<>();
            }
            if (map == null) {
                map = new HashMap<>();
            }
            a(map);
            UTExposureInfo.UTExposureBean uTExposureBean = new UTExposureInfo.UTExposureBean();
            this.c = uTExposureBean;
            uTExposureBean.area = str4;
            uTExposureBean.duration = j;
            uTExposureBean.exargs = map;
            uTExposureBean.viewid = str6;
            uTExposureBean.spm = str6;
            this.a.add(uTExposureBean);
            String jSONString = JSON.toJSONString(this.a);
            Map<String, String> map2 = this.b;
            if (map2 != null) {
                map2.clear();
            } else {
                this.b = new HashMap();
            }
            this.b.put("expdata", jSONString);
            try {
                UTAnalytics.getInstance().getDefaultTracker().send(new UTOriginalCustomHitBuilder(str5, i, c, null, null, this.b).build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void D(String str, String str2, String str3, String str4, Map<String, String> map, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2070071929")) {
            ipChange.ipc$dispatch("-2070071929", new Object[]{this, str, str2, str3, str4, map, Integer.valueOf(i)});
            return;
        }
        if (map == null) {
            try {
                map = new HashMap<>();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        Map<String, String> map2 = map;
        a(map2);
        UTAnalytics.getInstance().getDefaultTracker().send(new UTOriginalCustomHitBuilder(str, i, str2, str3, str4, map2).build());
    }

    public void E(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1243906269")) {
            ipChange.ipc$dispatch("1243906269", new Object[]{this, str, str2});
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
        } else {
            try {
                UTAnalytics.getInstance().updateUserAccount(str, str2, null);
                e().H("havanaid", str2);
                if (TextUtils.isEmpty(z20.E())) {
                    return;
                }
                e().H("usercode", z20.E());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void F(View view, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "499908540")) {
            ipChange.ipc$dispatch("499908540", new Object[]{this, view, str, str2, str3});
            return;
        }
        String c = c(str3, str2, str);
        String str4 = ("a2o4t." + str3 + "." + str2) + "." + str;
        HashMap hashMap = new HashMap();
        hashMap.put("spm", str4);
        a(hashMap);
        try {
            UTAnalytics.getInstance().getDefaultTracker().setExposureTag(view, c, str4, hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void G(View view, String str, String str2, String str3, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1581706313")) {
            ipChange.ipc$dispatch("1581706313", new Object[]{this, view, str, str2, str3, map});
            return;
        }
        String c = c(str3, str2, str);
        String str4 = ("a2o4t." + str3 + "." + str2) + "." + str;
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("spm", str4);
        a(map);
        try {
            UTAnalytics.getInstance().getDefaultTracker().setExposureTag(view, c, str4, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void H(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1941710401")) {
            ipChange.ipc$dispatch("-1941710401", new Object[]{this, str, str2});
            return;
        }
        try {
            UTAnalytics.getInstance().getDefaultTracker().setGlobalProperty(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<View> I(List<View> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "869509504")) {
            return (List) ipChange.ipc$dispatch("869509504", new Object[]{this, list});
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            View view = list.get(i);
            Object tag = view.getTag(ExposureUtils.ut_exprosure_tag);
            if (tag != null && (tag instanceof Map)) {
                arrayList.add(view);
                ExposureUtils.setIgnoreTagForExposureView(view);
            }
        }
        return arrayList;
    }

    public void J(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "16942483")) {
            ipChange.ipc$dispatch("16942483", new Object[]{this, obj});
            return;
        }
        try {
            UTAnalytics.getInstance().getDefaultTracker().skipPage(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void K(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1932956128")) {
            ipChange.ipc$dispatch("-1932956128", new Object[]{this, activity});
            return;
        }
        try {
            UTTeamWork.getInstance().startExpoTrack(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void L(Activity activity, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1825487106")) {
            ipChange.ipc$dispatch("-1825487106", new Object[]{this, activity, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            try {
                UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
                defaultTracker.updatePageName(activity, "page_" + str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void M(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "305662448")) {
            ipChange.ipc$dispatch("305662448", new Object[]{this, context, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            try {
                UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
                defaultTracker.updatePageName(context, "page_" + str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void N(Object obj, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1982991864")) {
            ipChange.ipc$dispatch("-1982991864", new Object[]{this, obj, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            try {
                if (!str.startsWith("page_")) {
                    str = "page_" + str;
                }
                UTAnalytics.getInstance().getDefaultTracker().updatePageName(obj, str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void O(Object obj, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-593711953")) {
            ipChange.ipc$dispatch("-593711953", new Object[]{this, obj, map});
        } else if (obj == null || map == null) {
        } else {
            try {
                UTAnalytics.getInstance().getDefaultTracker().updatePageProperties(obj, map);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void b(List<View> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-554435812")) {
            ipChange.ipc$dispatch("-554435812", new Object[]{this, list});
        } else if (wh2.e(list) > 0) {
            for (int i = 0; i < list.size(); i++) {
                View view = list.get(i);
                if (view != null) {
                    ExposureUtils.clearIgnoreTagForExposureView(view);
                }
            }
        }
    }

    public List<View> d(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-71698051")) {
            return (List) ipChange.ipc$dispatch("-71698051", new Object[]{this, view});
        }
        ArrayList arrayList = new ArrayList();
        if (view != null && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                arrayList.add(childAt);
                arrayList.addAll(d(childAt));
            }
        }
        return arrayList;
    }

    public Map<String, String> g(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "193099774")) {
            return (Map) ipChange.ipc$dispatch("193099774", new Object[]{this, obj});
        }
        if (obj == null) {
            return new HashMap();
        }
        try {
            return UTAnalytics.getInstance().getDefaultTracker().getPageProperties(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap();
        }
    }

    public void j(Activity activity, a.b bVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1002920744")) {
            ipChange.ipc$dispatch("-1002920744", new Object[]{this, activity, bVar});
        } else if (bVar == null) {
        } else {
            try {
                UTAnalytics.getInstance().getDefaultTracker().pageDisAppear(activity);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void k(Activity activity, a.b bVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1790607733")) {
            ipChange.ipc$dispatch("-1790607733", new Object[]{this, activity, bVar});
        } else if (bVar == null) {
        } else {
            cn.damai.common.user.a m = bVar.m();
            try {
                UTAnalytics.getInstance().getDefaultTracker().pageAppear(activity);
                UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
                defaultTracker.updatePageName(activity, "page_" + m.t());
                UTAnalytics.getInstance().getDefaultTracker().updatePageProperties(activity, f(m));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void l(Activity activity, a.b bVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-183490391")) {
            ipChange.ipc$dispatch("-183490391", new Object[]{this, activity, bVar});
        } else if (bVar == null) {
        } else {
            try {
                UTAnalytics.getInstance().getDefaultTracker().updatePageProperties(activity, f(bVar.m()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void m(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1275590228")) {
            ipChange.ipc$dispatch("-1275590228", new Object[]{this, activity});
        } else {
            J(activity);
        }
    }

    public void n(Activity activity, a.b bVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-699722548")) {
            ipChange.ipc$dispatch("-699722548", new Object[]{this, activity, bVar});
        } else if (bVar == null) {
        } else {
            cn.damai.common.user.a m = bVar.m();
            try {
                UTAnalytics.getInstance().getDefaultTracker().pageDisAppear(activity);
                UTAnalytics.getInstance().getDefaultTracker().pageAppearDonotSkip(activity);
                UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
                defaultTracker.updatePageName(activity, "page_" + m.t());
                UTAnalytics.getInstance().getDefaultTracker().updatePageProperties(activity, f(m));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void o(Fragment fragment, a.b bVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-737062618")) {
            ipChange.ipc$dispatch("-737062618", new Object[]{this, fragment, bVar});
        } else if (bVar == null) {
        } else {
            cn.damai.common.user.a m = bVar.m();
            try {
                UTAnalytics.getInstance().getDefaultTracker().pageDisAppear(fragment.getActivity());
                UTAnalytics.getInstance().getDefaultTracker().pageAppearDonotSkip(fragment.getActivity());
                UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
                FragmentActivity activity = fragment.getActivity();
                defaultTracker.updatePageName(activity, "page_" + m.t());
                UTAnalytics.getInstance().getDefaultTracker().updatePageProperties(fragment.getActivity(), f(m));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void p(Fragment fragment, a.b bVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1417648731")) {
            ipChange.ipc$dispatch("1417648731", new Object[]{this, fragment, bVar});
        } else if (bVar == null) {
        } else {
            cn.damai.common.user.a m = bVar.m();
            try {
                UTAnalytics.getInstance().getDefaultTracker().pageAppearDonotSkip(fragment.getActivity());
                UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
                FragmentActivity activity = fragment.getActivity();
                defaultTracker.updatePageName(activity, "page_" + m.t());
                UTAnalytics.getInstance().getDefaultTracker().updatePageProperties(fragment.getActivity(), f(m));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void q(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-135828245")) {
            ipChange.ipc$dispatch("-135828245", new Object[]{this, activity});
            return;
        }
        try {
            UTAnalytics.getInstance().getDefaultTracker().pageDisAppear(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void r(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1311230717")) {
            ipChange.ipc$dispatch("1311230717", new Object[]{this, obj});
            return;
        }
        try {
            UTAnalytics.getInstance().getDefaultTracker().pageAppear(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void s(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "19505438")) {
            ipChange.ipc$dispatch("19505438", new Object[]{this, obj});
            return;
        }
        try {
            UTAnalytics.getInstance().getDefaultTracker().pageAppearDonotSkip(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void t(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1908180179")) {
            ipChange.ipc$dispatch("-1908180179", new Object[]{this, obj});
            return;
        }
        try {
            UTAnalytics.getInstance().getDefaultTracker().pageDisAppear(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void u() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1168957255")) {
            ipChange.ipc$dispatch("-1168957255", new Object[]{this});
            return;
        }
        try {
            UTAnalytics.getInstance().getDefaultTracker().refreshExposureData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void v(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-873583283")) {
            ipChange.ipc$dispatch("-873583283", new Object[]{this, str, str2});
            return;
        }
        try {
            UTAnalytics.getInstance().getDefaultTracker().refreshExposureData(c(str2, str, ""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void w(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "254861491")) {
            ipChange.ipc$dispatch("254861491", new Object[]{this, str});
            return;
        }
        try {
            UTAnalytics.getInstance().getDefaultTracker().removeGlobalProperty(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void x(a.b bVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1404349866")) {
            ipChange.ipc$dispatch("-1404349866", new Object[]{this, bVar});
        } else if (bVar == null) {
        } else {
            cn.damai.common.user.a m = bVar.m();
            try {
                HashMap hashMap = new HashMap();
                if (m.u() != null) {
                    hashMap.putAll(m.u());
                }
                a(hashMap);
                if (m.x()) {
                    hashMap.put("spm-url", "a2o4t." + m.t() + "." + m.r() + "." + m.w());
                    hashMap.remove("ABTrackInfo");
                    UTAnalytics.getInstance().getDefaultTracker().updateNextPageProperties(hashMap);
                }
                i(m, m.x());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void y(String str, String str2, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1567924608")) {
            ipChange.ipc$dispatch("1567924608", new Object[]{this, str, str2, map});
            return;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                if (AppConfig.v()) {
                    throw new NullPointerException("pageName is null!!!请传入正确的pageName");
                }
                return;
            }
            if (map != null && map.containsKey("arg1")) {
                str2 = map.get("arg1");
                map.remove("arg1");
            }
            if (TextUtils.isEmpty(str2)) {
                if (AppConfig.v()) {
                    throw new NullPointerException("widegtName is null!!!请传入正确的点击控件名称");
                }
                return;
            }
            UTHitBuilders.UTControlHitBuilder uTControlHitBuilder = new UTHitBuilders.UTControlHitBuilder(str, str2);
            Map<String, String> a2 = o23.c().a(map);
            o23.c();
            o23.e(a2, uTControlHitBuilder);
            UTAnalytics.getInstance().getDefaultTracker().send(uTControlHitBuilder.build());
            rv2.e(a2);
            UTAnalytics.getInstance().getDefaultTracker().updateNextPageProperties(rv2.d());
            UTAnalytics.getInstance().getDefaultTracker().updateNextPageUtparam(a2.get("utparam"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void z(a.b bVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-147974387")) {
            ipChange.ipc$dispatch("-147974387", new Object[]{this, bVar});
        } else if (bVar == null) {
        } else {
            cn.damai.common.user.a m = bVar.m();
            try {
                HashMap hashMap = new HashMap();
                if (m.u() != null) {
                    hashMap.putAll(m.u());
                }
                a(hashMap);
                if (m.x()) {
                    hashMap.put("spm-url", "a2o4t." + m.t() + "." + m.r() + "." + m.w());
                    hashMap.put("skipbk", "1");
                    UTAnalytics.getInstance().getDefaultTracker().updateNextPageProperties(hashMap);
                }
                i(m, m.x());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private c() {
        this.a = new ArrayList<>();
        this.b = new HashMap();
        this.c = new UTExposureInfo.UTExposureBean();
    }
}
