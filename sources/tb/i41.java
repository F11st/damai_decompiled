package tb;

import android.text.TextUtils;
import android.view.View;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0528b;
import cn.damai.common.user.C0529c;
import cn.damai.issue.view.CorrelationView;
import cn.damai.model.IssueViewModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class i41 extends C0528b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String PAGE_EVALUATE_SUBMIT = "evaluate_submit";
    private static i41 b;
    private static IssueViewModel c;
    private static CorrelationView d;

    public static void f(View view, int i, int i2, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "582741869")) {
            ipChange.ipc$dispatch("582741869", new Object[]{view, Integer.valueOf(i), Integer.valueOf(i2), str, str2});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("dm_tag", str);
        f.put("dm_id", str2);
        m(f);
        C0529c.e().G(view, "dm_tag_" + i, "dm_" + i2, b.k(), f);
    }

    public static void g(boolean z, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2110107377")) {
            ipChange.ipc$dispatch("2110107377", new Object[]{Boolean.valueOf(z), Long.valueOf(j)});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("type", z ? "2" : "1");
        m(f);
        C0529c.e().C("popups", "top", i().k(), "1.0", j, f, 2201);
    }

    public static void h(View view, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-319257105")) {
            ipChange.ipc$dispatch("-319257105", new Object[]{view, str, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("tag", str);
        m(f);
        C0529c e = C0529c.e();
        e.G(view, "tag_" + i, "tag", b.k(), f);
    }

    public static i41 i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1425991323")) {
            return (i41) ipChange.ipc$dispatch("-1425991323", new Object[0]);
        }
        if (b == null) {
            b = new i41();
        }
        return b;
    }

    private String k() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "94346506") ? (String) ipChange.ipc$dispatch("94346506", new Object[]{this}) : PAGE_EVALUATE_SUBMIT;
    }

    public static Map<String, String> m(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-259601958")) {
            return (Map) ipChange.ipc$dispatch("-259601958", new Object[]{map});
        }
        IssueViewModel issueViewModel = c;
        if (issueViewModel != null) {
            map.put("item_id", issueViewModel.getmItemId());
            map.put("store_id", c.getStoreId());
            CorrelationView correlationView = d;
            if (correlationView != null && correlationView.getCorrelationId() != null) {
                map.put("scriptId", d.getCorrelationId());
            }
            map.put("style", TextUtils.isEmpty(c.getItemType()) ? "0" : c.getItemType());
        }
        return map;
    }

    public static void n(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2012422597")) {
            ipChange.ipc$dispatch("2012422597", new Object[]{str});
            return;
        }
        i41 i = i();
        HashMap<String, String> f = d23.f();
        m(f);
        f.put("dm_id", str);
        C0529c.e().x(i.e(i.k(), "dm", "dm", f, Boolean.FALSE));
    }

    public static void o(String str, Integer num, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-74423803")) {
            ipChange.ipc$dispatch("-74423803", new Object[]{str, num, str2, Integer.valueOf(i)});
        } else if (num == null) {
        } else {
            i41 i2 = i();
            HashMap<String, String> f = d23.f();
            m(f);
            f.put("dm_id", str);
            f.put("dm_tag", str2);
            C0529c.e().x(i2.e(i2.k(), "dm_" + num, "dm_tag_" + i, f, Boolean.FALSE));
        }
    }

    public static void p(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1963754703")) {
            ipChange.ipc$dispatch("1963754703", new Object[]{str, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("tag", str);
        m(f);
        i41 i2 = i();
        String k = i().k();
        C0529c.e().x(i2.e(k, "tag", "tag_" + i, f, Boolean.FALSE));
    }

    public static void v() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-996817866")) {
            ipChange.ipc$dispatch("-996817866", new Object[0]);
            return;
        }
        i41 i = i();
        HashMap<String, String> f = d23.f();
        m(f);
        C0529c.e().x(i.e(i.k(), "popups", "cancel", f, Boolean.FALSE));
    }

    public static void w() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1498031185")) {
            ipChange.ipc$dispatch("-1498031185", new Object[0]);
            return;
        }
        i41 i = i();
        HashMap<String, String> f = d23.f();
        m(f);
        C0529c.e().x(i.e(i.k(), "popups", "confirm", f, Boolean.FALSE));
    }

    public static void x() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1259784748")) {
            ipChange.ipc$dispatch("1259784748", new Object[0]);
            return;
        }
        i41 i = i();
        HashMap<String, String> f = d23.f();
        m(f);
        C0529c.e().x(i.e(i.k(), "popups", "delete", f, Boolean.FALSE));
    }

    public static void y() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "9995083")) {
            ipChange.ipc$dispatch("9995083", new Object[0]);
            return;
        }
        i41 i = i();
        HashMap<String, String> f = d23.f();
        m(f);
        C0529c.e().x(i.e(i.k(), "popups", "load", f, Boolean.FALSE));
    }

    public C0525a.C0527b j() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1592266519") ? (C0525a.C0527b) ipChange.ipc$dispatch("-1592266519", new Object[]{this}) : b(k());
    }

    public void l(IssueViewModel issueViewModel, CorrelationView correlationView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2104421496")) {
            ipChange.ipc$dispatch("-2104421496", new Object[]{this, issueViewModel, correlationView});
            return;
        }
        c = issueViewModel;
        d = correlationView;
    }

    public void q(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-720249791")) {
            ipChange.ipc$dispatch("-720249791", new Object[]{this, str});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        m(hashMap);
        C0529c.e().x(e(k(), "bottom", str, hashMap, Boolean.TRUE));
    }

    public void r() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1631874744")) {
            ipChange.ipc$dispatch("-1631874744", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        C0529c.e().x(e(k(), "top", b82.SEARCH_ITEM_ASSOCIATE, hashMap, Boolean.TRUE));
    }

    public void s(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "975789987")) {
            ipChange.ipc$dispatch("975789987", new Object[]{this, str, str2});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("item_id", str2);
        }
        C0529c.e().x(e(k(), "top", "cancel_comment", hashMap, Boolean.FALSE));
    }

    public void t(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1584179091")) {
            ipChange.ipc$dispatch("1584179091", new Object[]{this, map});
            return;
        }
        m(map);
        C0529c.e().z(e(k(), "bottom", "release", map, Boolean.TRUE));
    }

    public void u(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2100051685")) {
            ipChange.ipc$dispatch("2100051685", new Object[]{this, str, str2});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("item_id", str2);
        }
        C0529c.e().x(e(k(), "top", "tips", hashMap, Boolean.TRUE));
    }
}
