package tb;

import android.view.View;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0528b;
import cn.damai.common.user.C0529c;
import cn.damai.user.userprofile.FeedsViewModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class xa0 extends C0528b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String DM_PAY_SUCCESS = "payresult";

    /* compiled from: Taobao */
    /* renamed from: tb.xa0$b */
    /* loaded from: classes9.dex */
    private static class C9913b {
        private static final xa0 a = new xa0();
    }

    public static final xa0 h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1678214929") ? (xa0) ipChange.ipc$dispatch("-1678214929", new Object[0]) : C9913b.a;
    }

    public C0525a.C0527b f(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "504972396") ? (C0525a.C0527b) ipChange.ipc$dispatch("504972396", new Object[]{this, str}) : new C0525a.C0527b().h(str).i(DM_PAY_SUCCESS);
    }

    public C0525a.C0527b g(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "893779712") ? (C0525a.C0527b) ipChange.ipc$dispatch("893779712", new Object[]{this, str, str2, str3}) : new C0525a.C0527b().h(str).k(str2).b(str3).i(DM_PAY_SUCCESS);
    }

    public C0525a.C0527b i(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1578325319")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1578325319", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        hashMap.put("item_id", str2);
        hashMap.put("city", z20.d());
        hashMap.put(FeedsViewModel.ARG_USERID, z20.i());
        hashMap.put("usercode", z20.E());
        return e(DM_PAY_SUCCESS, "banners", "bannerimg", hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b j(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1542154686")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1542154686", new Object[]{this, str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("orderid", str2);
        hashMap.put("usercode", z20.E());
        hashMap.put("titlelabel", str3);
        return e(DM_PAY_SUCCESS, "center", BaseCellItem.TYPE_BUTTON, hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b k(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-563501950")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-563501950", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("authorize_type", str);
        return e(DM_PAY_SUCCESS, "center", "btn", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b l(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "428813463")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("428813463", new Object[]{this, str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str2);
        hashMap.put("orderid", str);
        hashMap.put("usercode", z20.E());
        hashMap.put("vip_status", str3);
        return e(DM_PAY_SUCCESS, "center", "point", hashMap, Boolean.TRUE);
    }

    public void m(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2021380464")) {
            ipChange.ipc$dispatch("2021380464", new Object[]{this, view, str});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("authorize_type", str);
        C0529c.e().G(view, "btn", "center", DM_PAY_SUCCESS, hashMap);
    }

    public void n(View view, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2094881509")) {
            ipChange.ipc$dispatch("-2094881509", new Object[]{this, view, str, str2, str3});
        } else if (view == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", str2);
            hashMap.put("orderid", str);
            hashMap.put("usercode", z20.E());
            hashMap.put("vip_status", str3);
            C0529c.e().G(view, "point", "center", DM_PAY_SUCCESS, hashMap);
        }
    }

    private xa0() {
    }
}
