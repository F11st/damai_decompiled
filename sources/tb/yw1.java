package tb;

import android.view.View;
import cn.damai.common.user.a;
import cn.damai.commonbusiness.yymember.bean.MemberGuideInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class yw1 extends cn.damai.common.user.b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String PROJECT_PAGE = "preferentialexplain";
    public static final String PROJECT_SCREENINGS_PAGE = "screenings";
    public static final String UT_ACTION_SKU_PROMOTION_INFO = "yhtc_screening_discountinfo";

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    private static class a {
        private static final yw1 a = new yw1();
    }

    public static final yw1 f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2052402459") ? (yw1) ipChange.ipc$dispatch("2052402459", new Object[0]) : a.a;
    }

    public a.b g(String str, long j, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-237661376")) {
            return (a.b) ipChange.ipc$dispatch("-237661376", new Object[]{this, str, Long.valueOf(j), str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        hashMap.put("coupon_id", str2);
        return e(str, "center", "get_coupon", hashMap, Boolean.FALSE);
    }

    public a.b h(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "749558298")) {
            return (a.b) ipChange.ipc$dispatch("749558298", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("user_type", str2);
        return e(str, "center", MemberGuideInfo.authorize, hashMap, Boolean.FALSE);
    }

    public a.b i(String str, String str2, String str3, String str4, String str5, String str6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1184151171")) {
            return (a.b) ipChange.ipc$dispatch("1184151171", new Object[]{this, str, str2, str3, str4, str5, str6});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str2);
        hashMap.put("usercode", z20.E());
        hashMap.put("vip_status", str3);
        hashMap.put("btn_status", str4);
        hashMap.put("vipitem_id", str5);
        hashMap.put("redeemnow_type", str6);
        return e(str, "center", "exchange", hashMap, Boolean.FALSE);
    }

    public a.b j(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1696696567")) {
            return (a.b) ipChange.ipc$dispatch("-1696696567", new Object[]{this, str, str2, str3, str4});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str2);
        hashMap.put("usercode", z20.E());
        hashMap.put("vip_status", str3);
        hashMap.put("vipitem_id", str4);
        return e(str, "vipalert", "cancel", hashMap, Boolean.FALSE);
    }

    public a.b k(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "270862051")) {
            return (a.b) ipChange.ipc$dispatch("270862051", new Object[]{this, str, str2, str3, str4});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str2);
        hashMap.put("usercode", z20.E());
        hashMap.put("vip_status", str3);
        hashMap.put("vipitem_id", str4);
        return e(str, "vipalert", "confirm", hashMap, Boolean.FALSE);
    }

    public void l(View view, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-300276498")) {
            ipChange.ipc$dispatch("-300276498", new Object[]{this, view, str, str2});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("user_type", str2);
        cn.damai.common.user.c.e().G(view, MemberGuideInfo.authorize, "center", str, hashMap);
    }

    public void m(View view, String str, String str2, String str3, String str4, String str5, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1957673844")) {
            ipChange.ipc$dispatch("-1957673844", new Object[]{this, view, str, str2, str3, str4, str5, Integer.valueOf(i)});
        } else if (view == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", str2);
            hashMap.put("usercode", z20.E());
            hashMap.put("vip_status", str3);
            hashMap.put("btn_status", str4);
            hashMap.put("vipitem_id", str5);
            cn.damai.common.user.c e = cn.damai.common.user.c.e();
            e.G(view, "item_" + i, "center", str, hashMap);
        }
    }
}
