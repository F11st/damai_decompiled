package tb;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import cn.damai.common.user.a;
import cn.damai.uikit.banner.sub.BannerItem;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class mv2 extends cn.damai.common.user.b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String DISCOUNT_TICKET_PAGE = "discount";
    public static final String MORE_DISCOUNT_PAGE = "more_discount";
    private final String b;

    public mv2(int i, @Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            this.b = str;
        } else if (i == 8) {
            this.b = "discount";
        } else if (i == 7) {
            this.b = MORE_DISCOUNT_PAGE;
        } else {
            this.b = "discount";
        }
    }

    public static void g(a.b bVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2123505402")) {
            ipChange.ipc$dispatch("2123505402", new Object[]{bVar});
        } else if (bVar == null) {
        } else {
            cn.damai.common.user.c.e().x(bVar);
        }
    }

    public static a.b i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-467829951") ? (a.b) ipChange.ipc$dispatch("-467829951", new Object[0]) : new a.b().i("discount");
    }

    private boolean n(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-395629404") ? ((Boolean) ipChange.ipc$dispatch("-395629404", new Object[]{this, Integer.valueOf(i)})).booleanValue() : i == 2001;
    }

    public static a.b o() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-397145098") ? (a.b) ipChange.ipc$dispatch("-397145098", new Object[0]) : new a.b().i(MORE_DISCOUNT_PAGE);
    }

    private void q(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "154834688")) {
            ipChange.ipc$dispatch("154834688", new Object[]{this, map});
            return;
        }
        String E = z20.E();
        if (TextUtils.isEmpty(E)) {
            return;
        }
        map.put("usercode", E);
    }

    public a.b f(BannerItem bannerItem, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1159977714")) {
            return (a.b) ipChange.ipc$dispatch("-1159977714", new Object[]{this, bannerItem, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        q(hashMap);
        hashMap.put("contentlabel", bannerItem.bannerUrl());
        String str = this.b;
        return e(str, gh1.MODULE_BANNER, "item_" + i, hashMap, Boolean.valueOf(n(2001)));
    }

    public a.b h(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-280297816")) {
            return (a.b) ipChange.ipc$dispatch("-280297816", new Object[]{this, Integer.valueOf(i), str});
        }
        HashMap hashMap = new HashMap();
        q(hashMap);
        hashMap.put("coupon_id", str);
        String str2 = this.b;
        return e(str2, "top", "coupon_item_" + i, hashMap, Boolean.valueOf(n(2101)));
    }

    public void j(View view, int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1092491901")) {
            ipChange.ipc$dispatch("-1092491901", new Object[]{this, view, Integer.valueOf(i), str});
            return;
        }
        HashMap hashMap = new HashMap();
        q(hashMap);
        hashMap.put("coupon_id", str);
        cn.damai.common.user.c e = cn.damai.common.user.c.e();
        e.G(view, "coupon_item_" + i, "top", this.b, hashMap);
    }

    public void k(View view, int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "93200132")) {
            ipChange.ipc$dispatch("93200132", new Object[]{this, view, Integer.valueOf(i), str});
            return;
        }
        HashMap hashMap = new HashMap();
        q(hashMap);
        hashMap.put("item_id", str);
        cn.damai.common.user.c e = cn.damai.common.user.c.e();
        e.G(view, "item_" + i, "recent", this.b, hashMap);
    }

    public void l(View view, int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1778614485")) {
            ipChange.ipc$dispatch("-1778614485", new Object[]{this, view, Integer.valueOf(i), str});
            return;
        }
        HashMap hashMap = new HashMap();
        q(hashMap);
        hashMap.put("item_id", str);
        cn.damai.common.user.c e = cn.damai.common.user.c.e();
        e.G(view, "item_" + i, "more", this.b, hashMap);
    }

    public void m(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1741734146")) {
            ipChange.ipc$dispatch("-1741734146", new Object[]{this, view});
            return;
        }
        HashMap hashMap = new HashMap();
        q(hashMap);
        cn.damai.common.user.c.e().G(view, "more", "recent", this.b, hashMap);
    }

    public a.b p(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1163241770")) {
            return (a.b) ipChange.ipc$dispatch("-1163241770", new Object[]{this, Integer.valueOf(i), str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        q(hashMap);
        String str2 = this.b;
        return e(str2, "recent", "item_" + i, hashMap, Boolean.valueOf(n(2001)));
    }

    public a.b r() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "630832240")) {
            return (a.b) ipChange.ipc$dispatch("630832240", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        q(hashMap);
        return e(this.b, "top", "share", hashMap, Boolean.valueOf(n(2101)));
    }

    public a.b s(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1377903857")) {
            return (a.b) ipChange.ipc$dispatch("-1377903857", new Object[]{this, Integer.valueOf(i), str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        q(hashMap);
        String str2 = this.b;
        return e(str2, "more", "item_" + i, hashMap, Boolean.valueOf(n(2001)));
    }

    public a.b t() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-645265173")) {
            return (a.b) ipChange.ipc$dispatch("-645265173", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        q(hashMap);
        return e(this.b, "recent", "more", hashMap, Boolean.valueOf(n(2001)));
    }
}
