package tb;

import android.view.View;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0529c;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.preloader.Preloader;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class lm2 extends C9548pb {
    private static transient /* synthetic */ IpChange $ipChange;
    private String b;
    private boolean c = false;
    private String d = "主题";

    private void l(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1941078616")) {
            ipChange.ipc$dispatch("1941078616", new Object[]{this, map});
            return;
        }
        C9548pb.h(C9548pb.CNT_CONTENT_TYPE, "theme", map);
        C9548pb.h(C9548pb.CNT_CONTENT_ID, this.b, map);
    }

    public C0525a.C0527b A(int i, String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1654664623")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1654664623", new Object[]{this, Integer.valueOf(i), str, Boolean.valueOf(z)});
        }
        HashMap hashMap = new HashMap();
        C9548pb.f(hashMap);
        C9548pb.g(hashMap);
        C9548pb.h("item_id", str, hashMap);
        l(hashMap);
        String str2 = z ? "commodity" : "theme";
        String str3 = z ? "top" : "center_item";
        return e(str2, str3, "item_" + i, hashMap, Boolean.valueOf(C9548pb.i(2001)));
    }

    public C0525a.C0527b B() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1832979507")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1832979507", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        C9548pb.f(hashMap);
        C9548pb.g(hashMap);
        l(hashMap);
        return e("theme", "center_item", "more", hashMap, Boolean.valueOf(C9548pb.i(2001)));
    }

    public C0525a.C0527b C() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "71132345") ? (C0525a.C0527b) ipChange.ipc$dispatch("71132345", new Object[]{this}) : new C0525a.C0527b().j(new HashMap()).i("commodity");
    }

    public void D(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1058864819")) {
            ipChange.ipc$dispatch("-1058864819", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        HashMap hashMap = new HashMap();
        C9548pb.f(hashMap);
        C9548pb.g(hashMap);
        l(hashMap);
        C9548pb.j(e("theme", "rank", "item_" + i, hashMap, Boolean.valueOf(C9548pb.i(2001))));
    }

    public void E(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "859067074")) {
            ipChange.ipc$dispatch("859067074", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.c = z;
        }
    }

    public void F(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1830188872")) {
            ipChange.ipc$dispatch("1830188872", new Object[]{this, str});
        } else {
            this.b = str;
        }
    }

    public void G(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1613507224")) {
            ipChange.ipc$dispatch("1613507224", new Object[]{this, str});
        } else {
            this.d = str;
        }
    }

    public C0525a.C0527b H() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1079901570")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1079901570", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        C9548pb.f(hashMap);
        C9548pb.g(hashMap);
        l(hashMap);
        return e("theme", "top", "share", hashMap, Boolean.valueOf(C9548pb.i(2101)));
    }

    public C0525a.C0527b I() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "801887135")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("801887135", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        C9548pb.f(hashMap);
        C9548pb.g(hashMap);
        l(hashMap);
        C9548pb.h("quandiid", this.b, hashMap);
        C9548pb.h("source", this.d, hashMap);
        return e("theme", "bottom", "submitbtn", hashMap, Boolean.valueOf(C9548pb.i(2001)));
    }

    public C0525a.C0527b J(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-189056187")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-189056187", new Object[]{this, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        C9548pb.f(hashMap);
        C9548pb.g(hashMap);
        l(hashMap);
        hashMap.put("type", String.valueOf(i));
        return e("theme", "middle", "tab", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b K() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1100241591")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1100241591", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        C9548pb.g(hashMap);
        C9548pb.f(hashMap);
        l(hashMap);
        if (!"圈子".equals(this.d)) {
            C9548pb.h("theme_type", this.c ? "活动主题" : "普通主题", hashMap);
        }
        C9548pb.h("type", this.d, hashMap);
        return new C0525a.C0527b().j(hashMap).i("theme");
    }

    public C0525a.C0527b k(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "130953524")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("130953524", new Object[]{this, str, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        C9548pb.f(hashMap);
        C9548pb.g(hashMap);
        l(hashMap);
        hashMap.put("id", str);
        hashMap.put(Preloader.KEY_SESSION, String.valueOf(i));
        return e("theme", AdUtConstants.XAD_UT_ARG_INTERACTION, "dvote", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b m(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1038924176")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1038924176", new Object[]{this, Integer.valueOf(i), str});
        }
        HashMap hashMap = new HashMap();
        C9548pb.f(hashMap);
        C9548pb.g(hashMap);
        C9548pb.h("contentlabel", str, hashMap);
        l(hashMap);
        return e("theme", gh1.MODULE_BANNER, "item", hashMap, Boolean.valueOf(C9548pb.i(2001)));
    }

    public C0525a.C0527b n(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-713968582")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-713968582", new Object[]{this, str, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        C9548pb.f(hashMap);
        C9548pb.g(hashMap);
        l(hashMap);
        hashMap.put("id", str);
        hashMap.put("type", String.valueOf(i));
        return e("theme", "vote_cancel", "dbtn", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1808027736")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1808027736", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        C9548pb.g(hashMap);
        C9548pb.f(hashMap);
        l(hashMap);
        if (!"圈子".equals(this.d)) {
            C9548pb.h("theme_type", this.c ? "活动主题" : "普通主题", hashMap);
        }
        C9548pb.h("type", this.d, hashMap);
        return new C0525a.C0527b().j(hashMap).i("HotQuanzi");
    }

    public C0525a.C0527b p(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1384073660")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1384073660", new Object[]{this, str});
        }
        HashMap<String, String> f = d23.f();
        f.put("quanziid", str);
        return e("HotQuanzi", "top", "share", f, Boolean.valueOf(C9548pb.i(2101)));
    }

    public C0525a.C0527b q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2028203119")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("2028203119", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        C9548pb.f(hashMap);
        C9548pb.g(hashMap);
        C9548pb.h("quanziid", this.b, hashMap);
        return e("HotQuanzi", "bottom", "submitbtn", hashMap, Boolean.valueOf(C9548pb.i(2001)));
    }

    public void r(View view, int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "602055432")) {
            ipChange.ipc$dispatch("602055432", new Object[]{this, view, Integer.valueOf(i), str});
            return;
        }
        HashMap hashMap = new HashMap();
        C9548pb.f(hashMap);
        C9548pb.g(hashMap);
        C9548pb.h("contentlabel", str, hashMap);
        l(hashMap);
        C0529c.e().G(view, gh1.MODULE_BANNER, "top", "theme", hashMap);
    }

    public void s(View view, String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1716593291")) {
            ipChange.ipc$dispatch("1716593291", new Object[]{this, view, str, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        HashMap hashMap = new HashMap();
        C9548pb.f(hashMap);
        C9548pb.h("id", str, hashMap);
        C9548pb.h("type", String.valueOf(i2), hashMap);
        C9548pb.g(hashMap);
        l(hashMap);
        C0529c e = C0529c.e();
        e.G(view, "dvote_" + i, "recommend", "theme", hashMap);
    }

    public void t(View view, String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1687206315")) {
            ipChange.ipc$dispatch("-1687206315", new Object[]{this, view, str, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        HashMap hashMap = new HashMap();
        C9548pb.h("item_id", str, hashMap);
        C9548pb.g(hashMap);
        C9548pb.h("type", String.valueOf(i2), hashMap);
        C0529c e = C0529c.e();
        e.G(view, "item_" + i, "content", "theme", hashMap);
    }

    public void u(View view, String str, int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1790868971")) {
            ipChange.ipc$dispatch("-1790868971", new Object[]{this, view, str, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        HashMap hashMap = new HashMap();
        C9548pb.f(hashMap);
        C9548pb.g(hashMap);
        C9548pb.h("item_id", str, hashMap);
        l(hashMap);
        C0529c e = C0529c.e();
        e.G(view, "item_" + i, z ? "top" : "center_item", z ? "commodity" : "theme", hashMap);
    }

    public void v(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2008272706")) {
            ipChange.ipc$dispatch("-2008272706", new Object[]{this, view, Integer.valueOf(i)});
            return;
        }
        HashMap hashMap = new HashMap();
        C9548pb.f(hashMap);
        C9548pb.g(hashMap);
        l(hashMap);
        C0529c e = C0529c.e();
        e.G(view, "item_" + i, "rank", "theme", hashMap);
    }

    public void w(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-96523731")) {
            ipChange.ipc$dispatch("-96523731", new Object[]{this, view, str});
            return;
        }
        HashMap hashMap = new HashMap();
        C9548pb.f(hashMap);
        C9548pb.g(hashMap);
        C9548pb.h("id", str, hashMap);
        l(hashMap);
        C0529c.e().G(view, "dvote", "center", "theme", hashMap);
    }

    public C0525a.C0527b x(String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-636512519")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-636512519", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        HashMap hashMap = new HashMap();
        C9548pb.f(hashMap);
        C9548pb.g(hashMap);
        hashMap.put("id", str);
        hashMap.put(Preloader.KEY_SESSION, String.valueOf(i));
        hashMap.put("index", String.valueOf(i2));
        l(hashMap);
        return e("theme", "recommend", "dvote_" + i2, hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b y(HashMap<String, String> hashMap) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-462083621") ? (C0525a.C0527b) ipChange.ipc$dispatch("-462083621", new Object[]{this, hashMap}) : e("HotQuanzi", "top", "join", hashMap, Boolean.valueOf(C9548pb.i(2001)));
    }

    public C0525a.C0527b z(int i, String str, int i2, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2138369701")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("2138369701", new Object[]{this, Integer.valueOf(i), str, Integer.valueOf(i2), str2});
        }
        HashMap hashMap = new HashMap();
        C9548pb.f(hashMap);
        C9548pb.g(hashMap);
        l(hashMap);
        hashMap.put("item_id", str2);
        hashMap.put(C9548pb.PUBLISHER_ID, str);
        hashMap.put("type", String.valueOf(i2));
        return e("theme", "content", "item_" + i, hashMap, Boolean.valueOf(C9548pb.i(2001)));
    }
}
