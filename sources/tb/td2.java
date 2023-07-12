package tb;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0528b;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PerformBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PerformSummaryBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PriceBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.open.SocialConstants;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class td2 extends C0528b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String PROJECT_SCREENINGS_PAGE = "screenings";
    public static final String PROJECT_SCREENINGS_PRE_PAGE = "screenings_pre";
    public static final String UT_ACTION_SKU_PROMOTION_INFO = "yhtc_screening_discountinfo";

    /* compiled from: Taobao */
    /* renamed from: tb.td2$a */
    /* loaded from: classes.dex */
    private static class C9714a {
        private static final td2 a = new td2();
    }

    public static final td2 i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1886578139") ? (td2) ipChange.ipc$dispatch("1886578139", new Object[0]) : C9714a.a;
    }

    public C0525a.C0527b f(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "41792908")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("41792908", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e("screenings", "center", "calendar", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b g(long j, PerformBean performBean, PriceBean priceBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1482949434")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1482949434", new Object[]{this, Long.valueOf(j), performBean, priceBean});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        StringBuilder sb = new StringBuilder();
        sb.append(performBean != null ? performBean.performBeginDTStr : "");
        sb.append("&");
        sb.append(priceBean != null ? priceBean.priceName : "");
        hashMap.put("contentlabel", sb.toString());
        return e("screenings", "bottom", SocialConstants.PARAM_APP_DESC, hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b h(long j, PerformBean performBean, PriceBean priceBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "318307273")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("318307273", new Object[]{this, Long.valueOf(j), performBean, priceBean});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        StringBuilder sb = new StringBuilder();
        sb.append(performBean != null ? performBean.performBeginDTStr : "");
        sb.append("&");
        sb.append(priceBean != null ? priceBean.priceName : "");
        hashMap.put("contentlabel", sb.toString());
        return e("screenings", "bottom", "inc", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b j(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1087819610")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1087819610", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e("screenings", "top", "showchange", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b k(long j, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1407383154")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1407383154", new Object[]{this, Long.valueOf(j), Long.valueOf(j2)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        hashMap.put("titlelabel", j2 + "");
        return e("screenings", "bottom", "price_details", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b l(long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-420013931") ? (C0525a.C0527b) ipChange.ipc$dispatch("-420013931", new Object[]{this, Long.valueOf(j)}) : new C0525a.C0527b().d(String.valueOf(j)).i("screenings");
    }

    public C0525a.C0527b m(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-261956557")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-261956557", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e("screenings", "ticketfile", "discountdesc", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b n(long j, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "222978527")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("222978527", new Object[]{this, Long.valueOf(j), Long.valueOf(j2)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        hashMap.put("titlelabel", j2 + "");
        return e("screenings", "center", "seatmap", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b o(long j, PriceBean priceBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1838862711")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1838862711", new Object[]{this, Long.valueOf(j), priceBean, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        hashMap.put("titlelabel", priceBean != null ? String.valueOf(priceBean.skuId) : "");
        hashMap.put("contentlabel", priceBean.priceName);
        return e("screenings", "price", "item_" + i, hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b p(long j, PerformSummaryBean performSummaryBean, String str, int i, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1356885684")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1356885684", new Object[]{this, Long.valueOf(j), performSummaryBean, str, Integer.valueOf(i), str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        hashMap.put("titlelabel", performSummaryBean != null ? String.valueOf(performSummaryBean.performId) : "");
        hashMap.put("contentlabel", str);
        hashMap.put("sku_Info", str2);
        return e("screenings", "center", "selecttime_" + i, hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b q(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1014382192")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1014382192", new Object[]{this, Long.valueOf(j), str});
        }
        if (TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", String.valueOf(j));
            hashMap.put("contentlabel", str);
            return e("screenings", "bottom", "confirmbtn", hashMap, Boolean.TRUE);
        }
        return null;
    }

    public C0525a.C0527b r(long j, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-94447017")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-94447017", new Object[]{this, Long.valueOf(j), str, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        hashMap.put("contentlabel", str);
        return e("screenings", "center", "selectdate_" + i, hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b s(long j, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1178206863")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1178206863", new Object[]{this, Long.valueOf(j), str, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        hashMap.put("contentlabel", str);
        return e("screenings", "top", "month_item_" + i, hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b t(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1070136581")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1070136581", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e("screenings", "center", "alert", hashMap, Boolean.FALSE);
    }

    public void u(PerformBean performBean, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1111657225")) {
            ipChange.ipc$dispatch("-1111657225", new Object[]{this, performBean, str});
        } else if (performBean == null || TextUtils.isEmpty(str)) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", performBean.performId + "");
            hashMap.put("discountinfo", str);
            C0529c.e().A(hashMap, "yhtc_screening_discountinfo", "screenings");
        }
    }

    public void v(View view, long j, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "481748641")) {
            ipChange.ipc$dispatch("481748641", new Object[]{this, view, Long.valueOf(j), Integer.valueOf(i)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("item_id", j + "");
        C0529c.e().G(view, "heat_index", "bottom", PROJECT_SCREENINGS_PRE_PAGE, hashMap);
    }

    public void w(View view, long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-242568966")) {
            ipChange.ipc$dispatch("-242568966", new Object[]{this, view, Long.valueOf(j), str});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(SocialConstants.PARAM_APP_DESC, str);
        hashMap.put("item_id", j + "");
        C0529c.e().G(view, "seatmap", "center", "screenings", hashMap);
    }

    public void x(View view, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1254485795")) {
            ipChange.ipc$dispatch("-1254485795", new Object[]{this, view, Long.valueOf(j)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", j + "");
        C0529c.e().G(view, "alert", "center", "screenings", hashMap);
    }

    public void y(long j, Activity activity, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1302218870")) {
            ipChange.ipc$dispatch("1302218870", new Object[]{this, Long.valueOf(j), activity, Integer.valueOf(i)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("is_seat", i + "");
        C0525a.C0527b c0527b = new C0525a.C0527b();
        c0527b.d(String.valueOf(j)).i("screenings").j(hashMap);
        C0529c.e().l(activity, c0527b);
    }
}
