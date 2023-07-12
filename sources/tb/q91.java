package tb;

import android.view.View;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0529c;
import cn.damai.user.star.StarIndexFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class q91 extends C9548pb {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String PAGE_NAME = "content";
    private String b;
    private String c;

    private void k(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1284462264")) {
            ipChange.ipc$dispatch("1284462264", new Object[]{this, map});
            return;
        }
        C9548pb.h(C9548pb.CNT_CONTENT_TYPE, "note", map);
        C9548pb.h(C9548pb.CNT_CONTENT_ID, this.b, map);
        C9548pb.h(C9548pb.PUBLISHER_ID, this.c, map);
    }

    private void l(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2117990898")) {
            ipChange.ipc$dispatch("2117990898", new Object[]{this, map});
            return;
        }
        C9548pb.h(C9548pb.PRE_CONTENT_TYPE, "note", map);
        C9548pb.h(C9548pb.PRE_CONTENT_ID, this.b, map);
        C9548pb.h(C9548pb.PUBLISHER_ID, this.c, map);
    }

    public C0525a.C0527b A(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2097944486")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("2097944486", new Object[]{this, Integer.valueOf(i), str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("usercode", z20.E());
        C9548pb.h(C9548pb.PUBLISHER_ID, this.c, hashMap);
        if (i == 0) {
            C9548pb.h("repertoire_id", str, hashMap);
        } else if (i == 1) {
            C9548pb.h("music_ip", str, hashMap);
        } else if (i == 2) {
            C9548pb.h("item_id", str, hashMap);
        }
        return e("content", "tour_item", "item_card", hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b B() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1262520660") ? (C0525a.C0527b) ipChange.ipc$dispatch("-1262520660", new Object[]{this}) : new C0525a.C0527b().j(C()).a(z20.d()).i("content");
    }

    public HashMap<String, String> C() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1841108612")) {
            return (HashMap) ipChange.ipc$dispatch("1841108612", new Object[]{this});
        }
        HashMap<String, String> hashMap = new HashMap<>();
        C9548pb.g(hashMap);
        C9548pb.f(hashMap);
        k(hashMap);
        return hashMap;
    }

    public C0525a.C0527b D(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-637307630")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-637307630", new Object[]{this, str, str2, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("titlelabel", str);
        hashMap.put("card_id", str2);
        hashMap.put("usercode", z20.E());
        l(hashMap);
        return e("content", "recommend", "card_" + i, hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b E(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "925388695")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("925388695", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        C9548pb.f(hashMap);
        C9548pb.g(hashMap);
        C9548pb.h("scriptId", str, hashMap);
        l(hashMap);
        return e("content", "scriptkill", "item", hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b F() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1077492023")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1077492023", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("usercode", z20.E());
        k(hashMap);
        return e("content", "center", "award_share", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b G(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2089701347")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("2089701347", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        C9548pb.f(hashMap);
        C9548pb.g(hashMap);
        C9548pb.h("storeId", str, hashMap);
        l(hashMap);
        return e("content", "scriptkill_store", "item", hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b H(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1497855685")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1497855685", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("titlelabel", str);
        hashMap.put("card_id", str2);
        hashMap.put("usercode", z20.E());
        l(hashMap);
        return e("content", "center", "theme", hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b I() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1827955769") ? (C0525a.C0527b) ipChange.ipc$dispatch("1827955769", new Object[]{this}) : e("content", "top", "DNAshow", d23.g(), Boolean.TRUE);
    }

    public C0525a.C0527b J(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1187776839")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1187776839", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("titlelabel", "关注");
        hashMap.put("biz_id", str);
        hashMap.put("usercode", z20.E());
        hashMap.put("status", str2);
        k(hashMap);
        return e("content", "top", "follow_btn", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b K(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "308348979")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("308348979", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("titlelabel", "关注");
        hashMap.put("biz_id", str);
        hashMap.put("usercode", z20.E());
        k(hashMap);
        return e("content", "top", "portrait", hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b L(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1417873433")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1417873433", new Object[]{this, str, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("titlelabel", str);
        hashMap.put("usercode", z20.E());
        C9548pb.h(C9548pb.PUBLISHER_ID, this.c, hashMap);
        return e("content", "tour_item", "item_" + i, hashMap, Boolean.TRUE);
    }

    public void M(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-342910155")) {
            ipChange.ipc$dispatch("-342910155", new Object[]{this, view});
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d());
            hashMap.put("usercode", z20.E());
            k(hashMap);
            C0529c.e().G(view, "favorite", "center", "content", hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void N(View view, String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-271903499")) {
            ipChange.ipc$dispatch("-271903499", new Object[]{this, view, str, str2, Integer.valueOf(i)});
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d());
            hashMap.put("titlelabel", str);
            hashMap.put("card_id", str2);
            hashMap.put("usercode", z20.E());
            k(hashMap);
            C9548pb.h(C9548pb.PRE_CONTENT_TYPE, "note", hashMap);
            C9548pb.h(C9548pb.PRE_CONTENT_ID, str2, hashMap);
            C0529c e = C0529c.e();
            e.G(view, "card_" + i, "recommend", "content", hashMap);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void O(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1213702058")) {
            ipChange.ipc$dispatch("1213702058", new Object[]{this, view});
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d());
            hashMap.put("usercode", z20.E());
            k(hashMap);
            C0529c.e().G(view, "award_share", "center", "content", hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void P(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1354968668")) {
            ipChange.ipc$dispatch("-1354968668", new Object[]{this, view});
            return;
        }
        try {
            C0529c.e().G(view, "DNAshow", "top", "content", d23.g());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Q(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "526832376")) {
            ipChange.ipc$dispatch("526832376", new Object[]{this, str});
        } else {
            this.b = str;
        }
    }

    public void R(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-671473246")) {
            ipChange.ipc$dispatch("-671473246", new Object[]{this, str});
        } else {
            this.c = str;
        }
    }

    public void m(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1044297838")) {
            ipChange.ipc$dispatch("1044297838", new Object[]{this, view, str});
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            C9548pb.f(hashMap);
            C9548pb.g(hashMap);
            C9548pb.h("scriptId", str, hashMap);
            k(hashMap);
            C0529c.e().G(view, "item", "scriptkill", "content", hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void n(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1657011892")) {
            ipChange.ipc$dispatch("-1657011892", new Object[]{this, view, str});
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            C9548pb.f(hashMap);
            C9548pb.g(hashMap);
            C9548pb.h("storeId", str, hashMap);
            k(hashMap);
            C0529c.e().G(view, "item", "scriptkill_store", "content", hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void o(View view, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "468646654")) {
            ipChange.ipc$dispatch("468646654", new Object[]{this, view, str, str2});
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            C9548pb.f(hashMap);
            C9548pb.g(hashMap);
            C9548pb.h("titlelabel", str, hashMap);
            C9548pb.h(C9548pb.PRE_CONTENT_TYPE, "theme", hashMap);
            C9548pb.h(C9548pb.PRE_CONTENT_ID, str2, hashMap);
            k(hashMap);
            C0529c.e().G(view, "theme", "center", "content", hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public C0525a.C0527b p(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-20763168")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-20763168", new Object[]{this, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("usercode", z20.E());
        k(hashMap);
        return e("content", StarIndexFragment.Default_PAGE, "card_" + i, hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b q(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "271942766")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("271942766", new Object[]{this, str, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("usercode", z20.E());
        C9548pb.h("titlelabel", str, hashMap);
        k(hashMap);
        return e("content", "top", "picture_item_" + i, hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b r() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1617341393")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1617341393", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("usercode", z20.E());
        k(hashMap);
        return e("content", "bottom", "likesbtn", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b s() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-753339525")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-753339525", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("usercode", z20.E());
        k(hashMap);
        return e("content", "bottom", "reply_btn", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b t(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "163312881")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("163312881", new Object[]{this, Boolean.valueOf(z)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("usercode", z20.E());
        k(hashMap);
        C9548pb.h("status", z ? "0" : "1", hashMap);
        return e("content", "bottom", "favorite", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b u() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1239467827")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1239467827", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("usercode", z20.E());
        k(hashMap);
        return e("content", "brand", "card", hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b v(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-828972996")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-828972996", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("titlelabel", str);
        hashMap.put("card_id", str2);
        hashMap.put("usercode", z20.E());
        l(hashMap);
        return e("content", "center", "circle", hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b w() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1300974306")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1300974306", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("usercode", z20.E());
        k(hashMap);
        return e("content", "center", "favorite", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b x(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-681052046")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-681052046", new Object[]{this, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("usercode", z20.E());
        k(hashMap);
        return e("content", "evaluate_list_" + i, "likesbtn", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b y(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1426202020")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1426202020", new Object[]{this, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("usercode", z20.E());
        k(hashMap);
        return e("content", "evaluate_list_" + i, "reply_btn", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b z(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1933761530")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1933761530", new Object[]{this, Integer.valueOf(i)});
        }
        HashMap<String, String> f = d23.f();
        return e("content", "favorite_user", "item_" + i, f, Boolean.TRUE);
    }
}
