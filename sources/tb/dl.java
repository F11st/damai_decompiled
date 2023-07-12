package tb;

import android.text.TextUtils;
import android.view.View;
import cn.damai.category.category.ui.StarFragment;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0528b;
import cn.damai.common.user.C0529c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class dl extends C0528b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String EVALUATE_DETAIL_PAGE = "evaluate_detail";
    public static final String EVALUATE_LIST_PAGE = "evaluate_all";
    public static final String EVALUATE_SUCCESS_PAGE = "evaluate_success";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.dl$a */
    /* loaded from: classes4.dex */
    public static class C9049a {
        private static final dl a = new dl();
    }

    private Map<String, String> A(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-496528788")) {
            return (Map) ipChange.ipc$dispatch("-496528788", new Object[]{this, str, str2, str3, str4});
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("usercode", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("titlelabel", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("evaluate_id", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("publiser_id", str4);
        }
        return hashMap;
    }

    public static final dl I() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1415610469") ? (dl) ipChange.ipc$dispatch("1415610469", new Object[0]) : C9049a.a;
    }

    public static void Q(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2065175130")) {
            ipChange.ipc$dispatch("-2065175130", new Object[]{Integer.valueOf(i), str});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("type", i + "");
        f.put("item_id", str);
        C0529c.e().x(I().e(EVALUATE_LIST_PAGE, "want-tips", "favorite", f, Boolean.FALSE));
    }

    public static void f(String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1361870605")) {
            ipChange.ipc$dispatch("-1361870605", new Object[]{str, Long.valueOf(j)});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("item_id", str);
        C0529c.e().C("favorite", "want-tips", EVALUATE_LIST_PAGE, "1.0", j, f, 2201);
    }

    private Map<String, String> i(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "656215576") ? (Map) ipChange.ipc$dispatch("656215576", new Object[]{this, str, str2, str3, str4}) : j(str, str2, str3, str4, null);
    }

    private Map<String, String> j(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1649132638")) {
            return (Map) ipChange.ipc$dispatch("-1649132638", new Object[]{this, str, str2, str3, str4, str5});
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("type", str);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("item_id", str3);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("usercode", str2);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("titlelabel", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put("circle_id", str5);
        }
        return hashMap;
    }

    public C0525a.C0527b B(String str, String str2, String str3, String str4, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1991285519")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1991285519", new Object[]{this, str, str2, str3, str4, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        Map<String, String> A = A(z20.E(), str3, str, str2);
        if (!TextUtils.isEmpty(str4)) {
            A.put("video_id", str4);
        }
        return e(EVALUATE_LIST_PAGE, "evaluate_tab_" + i, "pic_" + i3, A, Boolean.FALSE);
    }

    public C0525a.C0527b C(String str, String str2, String str3, String str4, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "754128530")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("754128530", new Object[]{this, str, str2, str3, str4, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        Map<String, String> A = A(z20.E(), str4, str, str2);
        A.put("scriptId", str3);
        return e(EVALUATE_LIST_PAGE, "evaluate_tab_" + i, "item_" + i2, A, Boolean.TRUE);
    }

    public C0525a.C0527b D(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "466920924")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("466920924", new Object[]{this, str, str2, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(z20.E())) {
            hashMap.put("usercode", z20.E());
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("titlelabel", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("scriptId", str2);
        }
        return e(EVALUATE_LIST_PAGE, pp2.PROJECT_EVALUATE, "tab_" + i, hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b E(String str, String str2, String str3, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-411410618")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-411410618", new Object[]{this, str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        return e(EVALUATE_LIST_PAGE, "evaluate_tab_" + i, "likes_" + i2, A(z20.E(), str3, str, str2), Boolean.FALSE);
    }

    public C0525a.C0527b F(String str, String str2, String str3, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1101039888")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1101039888", new Object[]{this, str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        return e(EVALUATE_LIST_PAGE, "evaluate_tab_" + i, "reply_" + i2, A(z20.E(), str3, str, str2), Boolean.TRUE);
    }

    public C0525a.C0527b G(String str, String str2, String str3, String str4, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "600120901")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("600120901", new Object[]{this, str, str2, str3, str4, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        Map<String, String> A = A(z20.E(), str4, str, str2);
        A.put("scriptId", str3);
        return e(EVALUATE_LIST_PAGE, "evaluate_tab_" + i, "share_" + i2, A, Boolean.FALSE);
    }

    public C0525a.C0527b H(String str, String str2, String str3, String str4, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "403516685")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("403516685", new Object[]{this, str, str2, str3, str4, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        Map<String, String> A = A(z20.E(), str4, str, str2);
        A.put("scriptId", str3);
        return e(EVALUATE_LIST_PAGE, "evaluate_tab_" + i, "portrait_" + i2, A, Boolean.TRUE);
    }

    public C0525a.C0527b J(String str, String str2, String str3, String str4, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "929236791")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("929236791", new Object[]{this, str, str2, str3, str4, Integer.valueOf(i)});
        }
        Map<String, String> l = l(z20.E(), str, str2, str3);
        if (!TextUtils.isEmpty(str4)) {
            l.put("storeId", str4);
        }
        return e(i == 0 ? EVALUATE_LIST_PAGE : EVALUATE_DETAIL_PAGE, TextUtils.isEmpty(str3) ? "scriptkill_store" : "scriptkill", "item", l, Boolean.TRUE);
    }

    public C0525a.C0527b K(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1007538133")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1007538133", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("style", str);
        hashMap.put("id", str2);
        return e(EVALUATE_SUCCESS_PAGE, "item", "more", hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b L(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "89863617")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("89863617", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("storeId", str);
        return e(EVALUATE_SUCCESS_PAGE, "evaluate_gift_vip", "item", hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b M() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1030966942")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1030966942", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        return new C0525a.C0527b().j(hashMap).i(EVALUATE_SUCCESS_PAGE);
    }

    public C0525a.C0527b N(String str, int i, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2132625947")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-2132625947", new Object[]{this, str, Integer.valueOf(i), str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("style", str);
        hashMap.put("scriptId", str2);
        return e(EVALUATE_SUCCESS_PAGE, "scriptkill", "item_" + i, hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b O(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-640244441")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-640244441", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("style", str);
        hashMap.put("id", str2);
        return e(EVALUATE_SUCCESS_PAGE, "share", "item", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b P(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-816506998")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-816506998", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        hashMap.put("item_id", str2);
        hashMap.put("usercode", z20.E());
        return e(EVALUATE_LIST_PAGE, "bottom", pp2.PROJECT_EVALUATE, hashMap, Boolean.TRUE);
    }

    public void g(View view, String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2070375294")) {
            ipChange.ipc$dispatch("2070375294", new Object[]{this, view, str, str2, Integer.valueOf(i)});
            return;
        }
        try {
            HashMap<String, String> f = d23.f();
            if (!TextUtils.isEmpty(str)) {
                f.put("scriptId", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                f.put("storeId", str2);
            }
            C0529c.e().G(view, "item", TextUtils.isEmpty(str) ? "scriptkill_store" : "scriptkill", i == 0 ? EVALUATE_LIST_PAGE : EVALUATE_DETAIL_PAGE, f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public C0525a.C0527b h(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1104893264")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1104893264", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("usercode", str2);
        return new C0525a.C0527b().j(hashMap).i(EVALUATE_DETAIL_PAGE);
    }

    public Map<String, String> k(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "850680800")) {
            return (Map) ipChange.ipc$dispatch("850680800", new Object[]{this, str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("usercode", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("evaluate_id", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("publiser_id", str3);
        }
        return hashMap;
    }

    public Map<String, String> l(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2114889578")) {
            return (Map) ipChange.ipc$dispatch("2114889578", new Object[]{this, str, str2, str3, str4});
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("usercode", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("evaluate_id", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("publiser_id", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("scriptId", str4);
        }
        return hashMap;
    }

    public C0525a.C0527b m(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-924358688")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-924358688", new Object[]{this, str, str2, str3, str4, str5, str6, str7});
        }
        return e(EVALUATE_DETAIL_PAGE, "card", "enter_circle", j(str, z20.E(), str2, str3 + "&" + str4 + "&" + str6 + "&" + str5, str7), Boolean.TRUE);
    }

    public C0525a.C0527b n(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1880074601")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1880074601", new Object[]{this, str, str2, Integer.valueOf(i)});
        }
        return e(EVALUATE_DETAIL_PAGE, "comment_" + i, "delete", k(z20.E(), str, str2), Boolean.FALSE);
    }

    public C0525a.C0527b o(String str, String str2, int i, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2076121732")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("2076121732", new Object[]{this, str, str2, Integer.valueOf(i), str3, str4});
        }
        Map<String, String> l = l(z20.E(), str, str2, str4);
        if (!TextUtils.isEmpty(str3)) {
            l.put("item_id", str3);
        }
        return e(EVALUATE_DETAIL_PAGE, "card", "pic_" + i, l, Boolean.FALSE);
    }

    public C0525a.C0527b p(String str, String str2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1204712078") ? (C0525a.C0527b) ipChange.ipc$dispatch("-1204712078", new Object[]{this, str, str2}) : e(EVALUATE_DETAIL_PAGE, "bottom", "reply_btn", k(z20.E(), str, str2), Boolean.FALSE);
    }

    public C0525a.C0527b q(String str, String str2, String str3, String str4, String str5, String str6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1957232429")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1957232429", new Object[]{this, str, str2, str3, str4, str5, str6});
        }
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        String valueOf = String.valueOf(str3);
        return e(EVALUATE_DETAIL_PAGE, "card", "reply_btn", i(str, str2, valueOf, str4 + "&" + str5 + "&" + str6), Boolean.FALSE);
    }

    public C0525a.C0527b r(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1159081343")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1159081343", new Object[]{this, str, str2, str3, str4, str5, str6, str7});
        }
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        String valueOf = String.valueOf(str3);
        Map<String, String> i = i(str, str2, valueOf, str4 + "&" + str5 + "&" + str6);
        if (!TextUtils.isEmpty(str7)) {
            i.put("scriptId", str7);
        }
        return e(EVALUATE_DETAIL_PAGE, "card", "portrait", i, Boolean.TRUE);
    }

    public C0525a.C0527b s(boolean z, String str, String str2, int i, String str3, String str4) {
        String str5;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-789770456")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-789770456", new Object[]{this, Boolean.valueOf(z), str, str2, Integer.valueOf(i), str3, str4});
        }
        if (z) {
            str5 = "card";
        } else {
            str5 = "comment_" + i;
        }
        String str6 = str5;
        Map<String, String> k = k(z20.E(), str, str2);
        if (!TextUtils.isEmpty(str4)) {
            k.put("scriptId", str4);
        }
        if (!TextUtils.isEmpty(str3)) {
            k.put("item_id", str3);
        }
        return e(EVALUATE_DETAIL_PAGE, str6, "portrait", k, Boolean.TRUE);
    }

    public C0525a.C0527b t(boolean z, String str, String str2, int i) {
        String str3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-748215216")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-748215216", new Object[]{this, Boolean.valueOf(z), str, str2, Integer.valueOf(i)});
        }
        if (z) {
            str3 = "bottom";
        } else {
            str3 = "comment_" + i;
        }
        return e(EVALUATE_DETAIL_PAGE, str3, "likes", k(z20.E(), str, str2), Boolean.FALSE);
    }

    public C0525a.C0527b u(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "478346624")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("478346624", new Object[]{this, str, str2, str3, str4, str5});
        }
        Map<String, String> l = l(z20.E(), str3, str4, str5);
        if (!TextUtils.isEmpty(str2)) {
            l.put("repertoire_id", str2);
        }
        if (!TextUtils.isEmpty(str)) {
            l.put("item_id", str);
        }
        return e(EVALUATE_DETAIL_PAGE, gb.PROJECT_PAGE, "item", l, Boolean.TRUE);
    }

    public C0525a.C0527b v(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2049214634")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-2049214634", new Object[]{this, str, str2, str3, str4});
        }
        Map<String, String> l = l(z20.E(), str, str2, str4);
        if (!TextUtils.isEmpty(str3)) {
            l.put("item_id", str3);
        }
        return e(EVALUATE_LIST_PAGE, "top", StarFragment.KEY_FOLLOW, l, Boolean.FALSE);
    }

    public C0525a.C0527b w(String str, String str2, String str3, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2059219253")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("2059219253", new Object[]{this, str, str2, str3, Integer.valueOf(i)});
        }
        Map<String, String> k = k(z20.E(), str2, str3);
        return e(EVALUATE_DETAIL_PAGE, "comment_" + i, str, k, Boolean.FALSE);
    }

    public C0525a.C0527b x(String str, String str2, String str3, String str4, String str5, String str6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1107449243")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1107449243", new Object[]{this, str, str2, str3, str4, str5, str6});
        }
        Map<String, String> l = l(z20.E(), str4, str5, str6);
        if (!TextUtils.isEmpty(str3)) {
            l.put("repertoire_id", str3);
        }
        if (!TextUtils.isEmpty(str2)) {
            l.put("item_id", str2);
        }
        return e(EVALUATE_DETAIL_PAGE, str, "share", l, Boolean.FALSE);
    }

    public C0525a.C0527b y(String str, String str2, String str3, String str4, String str5, String str6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1975936610")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1975936610", new Object[]{this, str, str2, str3, str4, str5, str6});
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String E = z20.E();
        return e(EVALUATE_DETAIL_PAGE, "card", "forward", i(str, E, str2, str3 + "&" + str4 + "&" + str5 + "&" + str6), Boolean.TRUE);
    }

    public C0525a.C0527b z(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1334966537")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1334966537", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", str);
        return new C0525a.C0527b().j(hashMap).i(EVALUATE_LIST_PAGE);
    }
}
