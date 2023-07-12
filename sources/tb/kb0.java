package tb;

import android.content.Context;
import android.text.TextUtils;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0528b;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.downloader.adpater.Monitor;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class kb0 extends C0528b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String DM_ADDRESS_LIST_PAGE = "select_address";
    public static final String DM_PURCHASE_PAGE = "confirm";

    /* compiled from: Taobao */
    /* renamed from: tb.kb0$b */
    /* loaded from: classes9.dex */
    private static class C9344b {
        private static final kb0 a = new kb0();
    }

    public static final kb0 u() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "581874523") ? (kb0) ipChange.ipc$dispatch("581874523", new Object[0]) : C9344b.a;
    }

    public C0525a.C0527b A(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1187274473")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1187274473", new Object[]{this, context});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(ua0.b(context)));
        return e("confirm", "distribution", "get_ticket_address", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b B(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-661856702")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-661856702", new Object[]{this, context});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(ua0.b(context)));
        return e("confirm", "discountinfor", "coupon", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b C(Context context, String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-417261537")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-417261537", new Object[]{this, context, str, str2, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(ua0.b(context)));
        hashMap.put("coupon_title", str);
        hashMap.put("coupon_id", str2);
        return e("confirm", "couponlayer", "item_" + i, hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b D(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-163659696")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-163659696", new Object[]{this, context});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", ua0.b(context) + "");
        return e("confirm", "distribution", "selectaddress", hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b E(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1143551579")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1143551579", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        return e(DM_ADDRESS_LIST_PAGE, "bottom", "submitaddress", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b F(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "12046705")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("12046705", new Object[]{this, context});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(ua0.b(context)));
        return e("confirm", "discount", "ticketanswerbtn", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1529152846")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1529152846", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        return e(DM_ADDRESS_LIST_PAGE, "top", "addaddress", hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b g(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1291842503")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1291842503", new Object[]{this, context});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", ua0.b(context) + "");
        return e("confirm", "distribution", "addaddress", hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b h(boolean z, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "982712777")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("982712777", new Object[]{this, Boolean.valueOf(z), str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("titlelabel", str2);
        return e(z ? DM_PURCHASE_PAGE : pp2.ORDER_DETAL_PAGE, "answersdiv", "ticketanswertab", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b i(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1547105146")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1547105146", new Object[]{this, context});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(ua0.b(context)));
        return e("confirm", "distribution", "editdistributionbtn", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b j(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1922807050")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1922807050", new Object[]{this, context});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(ua0.b(context)));
        return e("confirm", "distribution", "close", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b k(Context context, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-647433637")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-647433637", new Object[]{this, context, str, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(ua0.b(context)));
        hashMap.put("contentlabel", str);
        return e("confirm", "distribution", "item_" + i, hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b l(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "643091681")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("643091681", new Object[]{this, context});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", ua0.b(context) + "");
        return e("confirm", "realname", Monitor.POINT_ADD, hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b m(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1086638579")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1086638579", new Object[]{this, context});
        }
        if (context == null) {
            return new C0525a.C0527b().i(DM_ADDRESS_LIST_PAGE);
        }
        long b = ua0.b(context);
        if (b > 0) {
            C0525a.C0527b c0527b = new C0525a.C0527b();
            return c0527b.d(b + "").i(DM_ADDRESS_LIST_PAGE);
        }
        return new C0525a.C0527b().i(DM_ADDRESS_LIST_PAGE);
    }

    public C0525a.C0527b n(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1555805939")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1555805939", new Object[]{this, context});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", ua0.b(context) + "");
        hashMap.put("is_seat", ua0.a(context) ? "1" : "0");
        return e("confirm", "bottom", "submit", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b o(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "607194992")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("607194992", new Object[]{this, context});
        }
        if (context == null) {
            return new C0525a.C0527b().i("confirm");
        }
        long b = ua0.b(context);
        if (b > 0) {
            C0525a.C0527b c0527b = new C0525a.C0527b();
            return c0527b.d(b + "").i("confirm");
        }
        return new C0525a.C0527b().i("confirm");
    }

    public C0525a.C0527b p(Context context, int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1236509763")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1236509763", new Object[]{this, context, Integer.valueOf(i), Boolean.valueOf(z)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", ua0.b(context) + "");
        hashMap.put("status", z ? "1" : "0");
        return e("confirm", "realname", "choose_commonsuer_" + i, hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b q(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1372371820")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1372371820", new Object[]{this, context});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", ua0.b(context) + "");
        return e("confirm", "realname", "more", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b r(long j, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "432584536")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("432584536", new Object[]{this, Long.valueOf(j), Boolean.valueOf(z)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        hashMap.put("is_seat", z ? "1" : "0");
        return new C0525a.C0527b().j(hashMap).i("confirm");
    }

    public C0525a.C0527b s(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2029036594")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-2029036594", new Object[]{this, context});
        }
        if (context == null) {
            return new C0525a.C0527b().i("confirm");
        }
        long b = ua0.b(context);
        boolean a = ua0.a(context);
        if (b > 0) {
            return r(b, a);
        }
        return new C0525a.C0527b().i("confirm");
    }

    public C0525a.C0527b t(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1937388022")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1937388022", new Object[]{this, context});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", ua0.b(context) + "");
        hashMap.put("usercode", z20.E());
        hashMap.put("city", z20.d());
        return e("confirm", "distribution", "select_account", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b v(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-976564678")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-976564678", new Object[]{this, context});
        }
        HashMap hashMap = new HashMap();
        if (context != null) {
            hashMap.put("item_id", String.valueOf(ua0.b(context)));
        }
        hashMap.put("usercode", z20.E());
        return e("confirm", "distribution", "check_machine_address", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b w(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1692349282")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1692349282", new Object[]{this, context, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(ua0.b(context)));
        hashMap.put("usercode", z20.E());
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("titlelabel", str);
        }
        return e("confirm", "distribution", "machine_address_close", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b x(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "217031262")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("217031262", new Object[]{this, context});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", ua0.b(context) + "");
        return e("confirm", "bottom", "order_detail", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b y(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-285291972")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-285291972", new Object[]{this, context});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", ua0.b(context) + "");
        return e("confirm", "pay", "more", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b z(int i, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-207834830")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-207834830", new Object[]{this, Integer.valueOf(i), str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("titlelabel", str2);
        return e("confirm", "pay", "pay_type_" + i, hashMap, Boolean.FALSE);
    }

    private kb0() {
    }
}
