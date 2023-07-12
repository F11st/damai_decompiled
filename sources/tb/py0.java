package tb;

import android.text.TextUtils;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0528b;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.discover.bean.VoteBean;
import cn.damai.commonbusiness.discover.bean.VoteInfoBean;
import cn.damai.commonbusiness.search.bean.MarketTagBean;
import cn.damai.homepage.R$id;
import cn.damai.homepage.bean.KeyWord;
import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.tetris.component.discover.bean.ProjectInNote;
import cn.damai.tetris.component.home.bean.HomeTitleBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.preloader.Preloader;
import com.youku.vpm.track.OnePlayTrack;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class py0 extends C0528b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CHANNEL_PAGE = "new_category";
    public static final String CUSTOM_PUSH = "recstate";
    public static final String CUSTOM_VIPALERTSHOW = "vipalertshow";
    public static final String GrougId = "dispatchCardCode";
    public static final String HOME_PAGE = "home";
    public static final int NEW_FUNCTION_BEGIN_ACTION_TYPE = 0;
    public static final int NEW_FUNCTION_CLOSE_ACTION_TYPE = 1;
    public static final String PUSH_PAGE = "recmessage";
    public static final String RECOMMEND = "recommend";
    public static final String WELCOME_PAGE = "welcome";
    private static py0 d;
    int b = 0;
    List<HomeTitleBean.Title> c;

    public static py0 I() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1592506281")) {
            return (py0) ipChange.ipc$dispatch("1592506281", new Object[0]);
        }
        if (d == null) {
            d = new py0();
        }
        return d;
    }

    private String R() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "736868864")) {
            return (String) ipChange.ipc$dispatch("736868864", new Object[]{this});
        }
        List<HomeTitleBean.Title> list = this.c;
        return (list == null || this.b >= list.size() || this.c.get(this.b) == null || TextUtils.isEmpty(this.c.get(this.b).name)) ? "为你推荐" : this.c.get(this.b).name;
    }

    public static void f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "480882812")) {
            ipChange.ipc$dispatch("480882812", new Object[]{str});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("vip_status", str);
        C0529c.e().x(I().e("home", "vip_becomevipalert", "enter", f, Boolean.TRUE));
    }

    public static void g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2116862103")) {
            ipChange.ipc$dispatch("2116862103", new Object[]{str});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("pop_type", str);
        C0529c.e().x(I().e("home", "vip_pop", "close", f, Boolean.FALSE));
    }

    public static void h(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "274075830")) {
            ipChange.ipc$dispatch("274075830", new Object[]{str});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("pop_type", str);
        C0529c.e().x(I().e("home", "vip_pop", "enter", f, Boolean.TRUE));
    }

    public static void o(long j, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-276175963")) {
            ipChange.ipc$dispatch("-276175963", new Object[]{Long.valueOf(j), str, str2, str3});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("city", z20.d() + "市");
        f.put("contentlabel", str + "," + str2);
        if (!TextUtils.isEmpty(str3)) {
            f.put("imageUrl", str3);
        }
        C0529c.e().C("aditem", "advertsalert", "home", "1.0", j, f, 2201);
    }

    public static void p(long j, String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1638339440")) {
            ipChange.ipc$dispatch("-1638339440", new Object[]{Long.valueOf(j), str, str2, str3, str4});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("type", str3);
        f.put("people_id", str2);
        if (!TextUtils.isEmpty(str4)) {
            f.put("imageUrl", str4);
        }
        C0529c.e().C("close", "newfun_alert", "home", "1.0", j, f, 2201);
    }

    public static void q(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1475940489")) {
            ipChange.ipc$dispatch("-1475940489", new Object[]{Long.valueOf(j), str});
            return;
        }
        HashMap<String, String> g = d23.g();
        g.put("vip_status", str);
        C0529c.e().C("enter", "vip_becomevipalert", "home", "1.0", j, g, 2201);
    }

    public static void r(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-624004178")) {
            ipChange.ipc$dispatch("-624004178", new Object[]{Long.valueOf(j), str});
            return;
        }
        HashMap<String, String> g = d23.g();
        g.put("pop_type", str);
        C0529c.e().C("enter", "vip_pop", "home", "1.0", j, g, 2201);
    }

    private String v() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1583411482")) {
            return (String) ipChange.ipc$dispatch("1583411482", new Object[]{this});
        }
        return x() + "_item_";
    }

    private String x() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2114505570")) {
            return (String) ipChange.ipc$dispatch("2114505570", new Object[]{this});
        }
        List<HomeTitleBean.Title> list = this.c;
        return (list == null || this.b >= list.size() || this.c.get(this.b) == null || TextUtils.isEmpty(this.c.get(this.b).dispatchCardCode)) ? "default" : this.c.get(this.b).dispatchCardCode;
    }

    public C0525a.C0527b A() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "703814265")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("703814265", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d() + "市");
        return e("home", "top", "city", hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b B(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1348724028")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1348724028", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d() + "市");
        hashMap.put("titlelabel", str);
        return e("home", "tabbaralert", "vipalertclick", hashMap, Boolean.TRUE);
    }

    public Map<String, String> C(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-978972905")) {
            return (Map) ipChange.ipc$dispatch("-978972905", new Object[]{this, str});
        }
        if (str == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(z20.d())) {
            hashMap.put("city", z20.d() + "市");
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("titlelabel", str);
        }
        return hashMap;
    }

    public C0525a.C0527b D() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1266496679") ? (C0525a.C0527b) ipChange.ipc$dispatch("1266496679", new Object[]{this}) : c("home", "top", fy1.HOME_SCAN_PAGE, Boolean.TRUE);
    }

    public C0525a.C0527b E(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-39156034")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-39156034", new Object[]{this, str});
        }
        HashMap<String, String> f = d23.f();
        f.put("presetword", str);
        f.put("city", z20.d() + "市");
        return e("home", "top", "search", f, Boolean.TRUE);
    }

    public C0525a.C0527b F(String str, KeyWord keyWord) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1847529669")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1847529669", new Object[]{this, str, keyWord});
        }
        HashMap<String, String> f = d23.f();
        f.put("city", z20.d() + "市");
        if (keyWord != null) {
            if (!TextUtils.isEmpty(keyWord.comboDispatchSystem)) {
                f.put("dispatch_system", keyWord.comboDispatchSystem);
            }
            if (!TextUtils.isEmpty(keyWord.comboDispatchId)) {
                f.put("dispatch_id", keyWord.comboDispatchId);
            }
        }
        if (!TextUtils.isEmpty(str)) {
            f.put("keyword", str);
        }
        return e("home", "top", "searchtext", f, Boolean.TRUE);
    }

    public C0525a.C0527b G(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1876078395")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1876078395", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("item_id", str);
        hashMap.put("target_id", str2);
        return e("home", "evaluate_alert", "close", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b H(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1311972164")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1311972164", new Object[]{this, str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("item_id", str);
        hashMap.put("titlelabel", str3);
        hashMap.put("target_id", str2);
        return e("home", "evaluate_alert", "evalute", hashMap, Boolean.TRUE);
    }

    public Map<String, String> J(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1996421457")) {
            return (Map) ipChange.ipc$dispatch("1996421457", new Object[]{this, str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            hashMap.put("contentlabel", str2 + "^" + str3);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("titlelabel", str);
        }
        return hashMap;
    }

    public C0525a.C0527b K(NoteBean noteBean, int i, int i2, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "465215157")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("465215157", new Object[]{this, noteBean, Integer.valueOf(i), Integer.valueOf(i2), str, str2});
        }
        HashMap<String, String> d2 = d23.d();
        d23.h(d2, "usercode", z20.E());
        d23.h(d2, "city", z20.d() + "市");
        d23.h(d2, "titlelabel", R());
        d23.h(d2, GrougId, x());
        d23.h(d2, "alg", noteBean.alg);
        d23.h(d2, "card_id", noteBean.id);
        d23.h(d2, "card_type", str2);
        d23.h(d2, "content_id", noteBean.id);
        d23.h(d2, "content_type", str2);
        d23.h(d2, C9548pb.PRE_CONTENT_ID, noteBean.id);
        d23.h(d2, C9548pb.PRE_CONTENT_TYPE, "note");
        d23.h(d2, "pagenum", i + "");
        if (!TextUtils.isEmpty(str)) {
            d23.h(d2, "item_id", str);
        }
        return e("home", "bottom", v() + i2, d2, Boolean.TRUE);
    }

    public C0525a.C0527b L(NoteBean noteBean, int i, int i2, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "764653242")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("764653242", new Object[]{this, noteBean, Integer.valueOf(i), Integer.valueOf(i2), str, str2});
        }
        HashMap<String, String> d2 = d23.d();
        d23.h(d2, "usercode", z20.E());
        d23.h(d2, "city", z20.d() + "市");
        d23.h(d2, "titlelabel", R());
        d23.h(d2, GrougId, x());
        d23.h(d2, "alg", noteBean.alg);
        d23.h(d2, "card_id", noteBean.id);
        d23.h(d2, "card_type", str2);
        d23.h(d2, "content_id", noteBean.id);
        d23.h(d2, "content_type", str2);
        d23.h(d2, C9548pb.PRE_CONTENT_ID, noteBean.id);
        d23.h(d2, C9548pb.PRE_CONTENT_TYPE, "note");
        d23.h(d2, "pagenum", i + "");
        if (!TextUtils.isEmpty(str)) {
            d23.h(d2, "item_id", str);
        }
        return e("home", "bottom", x() + "_item_product_" + i2, d2, Boolean.TRUE);
    }

    public C0525a.C0527b M(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, String str7, String str8) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2133542365")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("2133542365", new Object[]{this, str, str2, str3, str4, str5, str6, Integer.valueOf(i), Integer.valueOf(i2), str7, str8});
        }
        String str9 = TextUtils.isEmpty(str7) ? str8 : str7;
        if (!TextUtils.isEmpty(str5)) {
            if (str5.equals("5")) {
                return N(str, str9, str2, str3, str4, str5, str6, "", "", i, i2, str6, "ranklist");
            }
            if (str5.equals("7")) {
                return N(str, str9, str2, str3, str4, str5, str6, "", "", i, i2, str6, u70.DETAILED_PAGE);
            }
            return N(str, str9, str2, str3, str4, str5, str6, "", "", i, i2, "", "");
        }
        return N(str, str9, str2, str3, str4, str5, str6, "", "", i, i2, "", "");
    }

    public C0525a.C0527b N(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, int i2, String str10, String str11) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-812273221")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-812273221", new Object[]{this, str, str2, str3, str4, str5, str6, str7, str8, str9, Integer.valueOf(i), Integer.valueOf(i2), str10, str11});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d() + "市");
        hashMap.put("titlelabel", R());
        hashMap.put(GrougId, x());
        hashMap.put("contentlabel", R());
        hashMap.put("item_id", str3);
        hashMap.put("alg", str4);
        hashMap.put("scm", str5);
        hashMap.put("card_type", str6);
        hashMap.put("card_id", str7);
        hashMap.put("content_type", str6);
        hashMap.put("content_id", str7);
        hashMap.put("pageNum", i + "");
        hashMap.put("biz_id", str8);
        hashMap.put("biz_type", str9);
        hashMap.put("usercode", z20.E());
        return e("home", "bottom", v() + i2, hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b O(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "203411953")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("203411953", new Object[]{this, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        return N(str, TextUtils.isEmpty(str2) ? str3 : str2, str4, str5, str6, str7, str8, str9, str10, i, i2, "", "");
    }

    public void P(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1738946967")) {
            ipChange.ipc$dispatch("-1738946967", new Object[]{this, str, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("titlelabel", str);
        C0529c e = C0529c.e();
        py0 I = I();
        e.x(I.e("home", "bottom", "tab_" + i, f, Boolean.FALSE));
    }

    public void Q(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-185676707")) {
            ipChange.ipc$dispatch("-185676707", new Object[]{this, str, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> d2 = d23.d();
        d23.h(d2, "usercode", z20.E());
        d23.h(d2, "city", z20.d() + "市");
        d23.h(d2, "titlelabel", R());
        d23.h(d2, GrougId, x());
        d23.h(d2, "card_id", str);
        d23.h(d2, "card_type", "11");
        C0529c e = C0529c.e();
        e.x(e("home", "bottom", v() + i, d2, Boolean.TRUE));
    }

    public C0525a.C0527b S(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "284595976")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("284595976", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("item_id", str);
        }
        return e("home", TypedValues.Custom.S_FLOAT, "live_item", hashMap, Boolean.TRUE);
    }

    public void T(View view, String str, String str2, String str3, String str4, String str5, String str6, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-458940978")) {
            ipChange.ipc$dispatch("-458940978", new Object[]{this, view, str, str2, str3, str4, str5, str6, Integer.valueOf(i)});
        } else if (TextUtils.isEmpty(str5)) {
            Y(view, str, str2, str3, str4, str5, str6, "", "", i, "", "", null);
        } else if (str5.equals("5")) {
            Y(view, str, str2, str3, str4, str5, str6, "", "", i, str6, "ranklist", null);
        } else if (str5.equals("7")) {
            Y(view, str, str2, str3, str4, str5, str6, "", "", i, str6, u70.DETAILED_PAGE, null);
        } else {
            Y(view, str, str2, str3, str4, str5, str6, "", "", i, "", "", null);
        }
    }

    public void U(View view, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9, String str10) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2076794418")) {
            ipChange.ipc$dispatch("-2076794418", new Object[]{this, view, str, str2, str3, str4, str5, str6, str7, str8, Integer.valueOf(i), str9, str10});
        } else {
            W(view, str, "", str2, str3, str4, str5, str6, str7, str8, i, str9, str10, null);
        }
    }

    public void V(View view, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, String str10, String str11) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "802156164")) {
            ipChange.ipc$dispatch("802156164", new Object[]{this, view, str, str2, str3, str4, str5, str6, str7, str8, str9, Integer.valueOf(i), str10, str11});
        } else {
            W(view, str, str2, str3, str4, str5, str6, str7, str8, str9, i, str10, str11, null);
        }
    }

    public void W(View view, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, String str10, String str11, String str12) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1730028195")) {
            ipChange.ipc$dispatch("1730028195", new Object[]{this, view, str, str2, str3, str4, str5, str6, str7, str8, str9, Integer.valueOf(i), str10, str11, str12});
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d() + "市");
            hashMap.put("titlelabel", R());
            hashMap.put("contentlabel", R());
            hashMap.put("item_id", str3);
            hashMap.put("alg", str4);
            hashMap.put("scm", str5);
            hashMap.put("card_type", str6);
            hashMap.put("card_id", str7);
            hashMap.put("content_type", str6);
            hashMap.put("content_id", str7);
            hashMap.put("biz_id", str8);
            hashMap.put("biz_type", str9);
            hashMap.put(C9548pb.PRE_CONTENT_ID, str10);
            hashMap.put(C9548pb.PRE_CONTENT_TYPE, str11);
            if (!TextUtils.isEmpty(str12)) {
                hashMap.put("discount_type", str12);
            }
            C0529c e = C0529c.e();
            e.G(view, v() + i, "bottom", "home", hashMap);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void X(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, String str7) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "964891856")) {
            ipChange.ipc$dispatch("964891856", new Object[]{this, view, str, str2, str3, str4, str5, str6, Integer.valueOf(i), str7});
        } else if (TextUtils.isEmpty(str5)) {
            Y(view, str, str2, str3, str4, str5, str6, "", "", i, "", "", str7);
        } else if (str5.equals("5")) {
            Y(view, str, str2, str3, str4, str5, str6, "", "", i, str6, "ranklist", str7);
        } else if (str5.equals("7")) {
            Y(view, str, str2, str3, str4, str5, str6, "", "", i, str6, u70.DETAILED_PAGE, str7);
        } else {
            Y(view, str, str2, str3, str4, str5, str6, "", "", i, "", "", str7);
        }
    }

    public void Y(View view, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9, String str10, String str11) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1995374062")) {
            ipChange.ipc$dispatch("1995374062", new Object[]{this, view, str, str2, str3, str4, str5, str6, str7, str8, Integer.valueOf(i), str9, str10, str11});
        } else {
            W(view, str, "", str2, str3, str4, str5, str6, str7, str8, i, str9, str10, str11);
        }
    }

    public void Z(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1548382129")) {
            ipChange.ipc$dispatch("-1548382129", new Object[]{this, view, str});
            return;
        }
        try {
            HashMap<String, String> f = d23.f();
            f.put("presetword", str);
            C0529c.e().G(view, "searchtext", "top", "home", f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a0(View view, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1674521156")) {
            ipChange.ipc$dispatch("1674521156", new Object[]{this, view, str, str2});
            return;
        }
        try {
            HashMap<String, String> f = d23.f();
            f.put("city", z20.d() + "市");
            f.put("presetword", str);
            C0529c.e().G(view, "search", "top", str2, f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b0(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1841817636")) {
            ipChange.ipc$dispatch("1841817636", new Object[]{this, view, str});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(str, str);
        }
        C0529c.e().G(view, "live_item", TypedValues.Custom.S_FLOAT, "home", hashMap);
    }

    public void c0(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-464476394")) {
            ipChange.ipc$dispatch("-464476394", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.b = i;
        }
    }

    public void d0(List<HomeTitleBean.Title> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1905781692")) {
            ipChange.ipc$dispatch("1905781692", new Object[]{this, list});
        } else {
            this.c = list;
        }
    }

    public void i(VoteInfoBean voteInfoBean, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-92236693")) {
            ipChange.ipc$dispatch("-92236693", new Object[]{this, voteInfoBean, str});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("titlelabel", R());
        f.put(GrougId, x());
        f.put("id", voteInfoBean.id);
        C0529c.e().x(I().e("home", "vote_cancel", "dbtn", f, Boolean.FALSE));
    }

    public void j(VoteInfoBean voteInfoBean, VoteBean voteBean, int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-595968142")) {
            ipChange.ipc$dispatch("-595968142", new Object[]{this, voteInfoBean, voteBean, Integer.valueOf(i), str});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("titlelabel", R());
        f.put(GrougId, x());
        f.put("id", voteInfoBean.id);
        f.put("index", i + "");
        f.put(Preloader.KEY_SESSION, voteBean.posInVoteList + "");
        f.put("card_type", "12");
        f.put("card_id", voteInfoBean.id);
        C0529c e = C0529c.e();
        py0 I = I();
        e.x(I.e("home", "bottom", "dvote_" + i, f, Boolean.FALSE));
    }

    public void k(View view, String str, int i, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-194793077")) {
            ipChange.ipc$dispatch("-194793077", new Object[]{this, view, str, Integer.valueOf(i), str2, str3});
            return;
        }
        HashMap<String, String> d2 = d23.d();
        d23.h(d2, "city", z20.d() + "市");
        d23.h(d2, "titlelabel", R());
        d23.h(d2, GrougId, x());
        d23.h(d2, "card_id", str);
        d23.h(d2, "card_type", str3);
        d23.h(d2, "content_id", str);
        d23.h(d2, "content_type", str3);
        d23.h(d2, "usercode", z20.E());
        if (!TextUtils.isEmpty(str2)) {
            d23.h(d2, "item_id", str2);
        }
        C0529c e = C0529c.e();
        e.G(view, v() + i, "bottom", "home", d2);
    }

    public void l(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1316853552")) {
            ipChange.ipc$dispatch("1316853552", new Object[]{this, view});
        } else {
            C0529c.e().G(view, "DNAshow", "card", "home", d23.g());
        }
    }

    public void m(View view, VoteInfoBean voteInfoBean, int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-812110052")) {
            ipChange.ipc$dispatch("-812110052", new Object[]{this, view, voteInfoBean, Integer.valueOf(i), str});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("titlelabel", R());
        f.put(GrougId, x());
        f.put("id", voteInfoBean.id);
        C0529c e = C0529c.e();
        e.G(view, "dvote_" + i, v(), "home", f);
    }

    public void n(View view, NoteBean noteBean, int i, int i2, String str) {
        MarketTagBean gotTopTag;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1403992692")) {
            ipChange.ipc$dispatch("-1403992692", new Object[]{this, view, noteBean, Integer.valueOf(i), Integer.valueOf(i2), str});
            return;
        }
        HashMap<String, String> d2 = d23.d();
        d23.h(d2, "city", z20.d() + "市");
        d23.h(d2, "titlelabel", R());
        d23.h(d2, GrougId, x());
        d23.h(d2, "alg", noteBean.alg);
        d23.h(d2, "card_id", noteBean.id);
        d23.h(d2, "card_type", "14");
        d23.h(d2, "content_id", noteBean.id);
        d23.h(d2, "content_type", "14");
        d23.h(d2, C9548pb.PRE_CONTENT_ID, noteBean.id);
        d23.h(d2, C9548pb.PRE_CONTENT_TYPE, "note");
        d23.h(d2, "pagenum", i + "");
        d23.h(d2, "usercode", z20.E());
        ProjectInNote projectInNote = noteBean.project;
        if (projectInNote != null && (gotTopTag = projectInNote.gotTopTag(true)) != null && !TextUtils.isEmpty(gotTopTag.type)) {
            d2.put("discount_type", gotTopTag.type);
        }
        if (!TextUtils.isEmpty(str)) {
            d23.h(d2, "item_id", str);
            int i3 = R$id.ll_card_note_proj;
            if (view.findViewById(i3) != null) {
                C0529c e = C0529c.e();
                View findViewById = view.findViewById(i3);
                e.G(findViewById, x() + "_item_product_" + i2, "bottom", "home", d2);
            }
        }
        C0529c e2 = C0529c.e();
        e2.G(view, v() + i2, "bottom", "home", d2);
    }

    public C0525a.C0527b s(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1128981500")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1128981500", new Object[]{this, str});
        }
        HashMap<String, String> f = d23.f();
        f.put("city", z20.d() + "市");
        f.put("presetword", str);
        return e(CHANNEL_PAGE, "top", "search", f, Boolean.TRUE);
    }

    public C0525a.C0527b t(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-502921496")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-502921496", new Object[]{this, str});
        }
        HashMap<String, String> f = d23.f();
        f.put("city", z20.d() + "市");
        return e(CHANNEL_PAGE, "top", "searchtext", f, Boolean.TRUE);
    }

    public C0525a.C0527b u(String str, int i, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1421665824")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1421665824", new Object[]{this, str, Integer.valueOf(i), str2, str3});
        }
        HashMap<String, String> d2 = d23.d();
        d23.h(d2, "usercode", z20.E());
        d23.h(d2, "city", z20.d() + "市");
        d23.h(d2, "titlelabel", R());
        d23.h(d2, GrougId, x());
        d23.h(d2, "card_id", str);
        d23.h(d2, "card_type", str3);
        d23.h(d2, "content_id", str);
        d23.h(d2, "content_type", str3);
        if (!TextUtils.isEmpty(str2)) {
            d23.h(d2, "item_id", str2);
        }
        return e("home", "bottom", v() + i, d2, Boolean.TRUE);
    }

    public C0525a.C0527b w() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1873695603") ? (C0525a.C0527b) ipChange.ipc$dispatch("1873695603", new Object[]{this}) : e("home", "card", "DNAshow", d23.g(), Boolean.FALSE);
    }

    public C0525a.C0527b y(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-158305126")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-158305126", new Object[]{this, str, str2, str3, str4, str5});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d() + "市");
        hashMap.put("contentlabel", str + "," + str2);
        hashMap.put("adv_code", str3);
        hashMap.put("people_id", str4);
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put("imageUrl", str5);
        }
        return e("home", "advertsalert", "aditem_0", hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b z(String str, String str2, int i, String str3) {
        String str4;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1321244977")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1321244977", new Object[]{this, str, str2, Integer.valueOf(i), str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", str2);
        hashMap.put("people_id", str);
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("imageUrl", str3);
        }
        if (i == 0) {
            str4 = OnePlayTrack.PlayType.BEGIN;
        } else if (i != 1) {
            throw new NullPointerException("dPoint 无法赋值，因为actionType是不支持的类型！actionType当前值为：" + i);
        } else {
            str4 = "close";
            z = false;
        }
        return e("home", "newfun_alert", str4, hashMap, Boolean.valueOf(z));
    }
}
