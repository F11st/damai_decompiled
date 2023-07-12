package tb;

import android.view.View;
import cn.damai.common.user.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class iv2 extends cn.damai.common.user.b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String USER_HOME_PAGE = "consumer_homepage";

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    private static class b {
        private static final iv2 a = new iv2();
    }

    public static void f(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1361745984")) {
            ipChange.ipc$dispatch("-1361745984", new Object[]{view});
        } else {
            cn.damai.common.user.c.e().G(view, "DNAshow", "top", USER_HOME_PAGE, d23.f());
        }
    }

    public static final iv2 j() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1235411141") ? (iv2) ipChange.ipc$dispatch("-1235411141", new Object[0]) : b.a;
    }

    public a.b g(String str, int i, int i2, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "954754460")) {
            return (a.b) ipChange.ipc$dispatch("954754460", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("city", z20.d());
        hashMap.put("titlelabel", str2);
        return e(str, "dynamic_tab_" + i, "card_" + i2, hashMap, Boolean.TRUE);
    }

    public a.b h(String str, int i, int i2, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "443229274")) {
            return (a.b) ipChange.ipc$dispatch("443229274", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("city", z20.d());
        hashMap.put("titlelabel", str2);
        return e(str, "dynamic_tab_" + i, "card_more_" + i2, hashMap, Boolean.FALSE);
    }

    public a.b i(String str, int i, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-439221375")) {
            return (a.b) ipChange.ipc$dispatch("-439221375", new Object[]{this, str, Integer.valueOf(i), str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("city", z20.d());
        hashMap.put("titlelabel", str2);
        return e(str, "dynamic_tab", "tab_" + i, hashMap, Boolean.FALSE);
    }

    public a.b k() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1912055040") ? (a.b) ipChange.ipc$dispatch("1912055040", new Object[]{this}) : e(USER_HOME_PAGE, "bottom", "submitbtn", null, Boolean.TRUE);
    }

    public a.b l(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-696073015")) {
            return (a.b) ipChange.ipc$dispatch("-696073015", new Object[]{this, Integer.valueOf(i), str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("city", z20.d());
        hashMap.put("titlelabel", str);
        return e(USER_HOME_PAGE, "center", "tab_" + i, hashMap, Boolean.FALSE);
    }

    public a.b m(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2084990161") ? (a.b) ipChange.ipc$dispatch("-2084990161", new Object[]{this, str}) : c(USER_HOME_PAGE, "top", str, Boolean.FALSE);
    }

    public void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "19923378")) {
            ipChange.ipc$dispatch("19923378", new Object[]{this});
        } else {
            cn.damai.common.user.c.e().x(e(USER_HOME_PAGE, "account_info", "portrait", d23.f(), Boolean.TRUE));
        }
    }

    public void o(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1053291652")) {
            ipChange.ipc$dispatch("-1053291652", new Object[]{this, Boolean.valueOf(z)});
        } else {
            cn.damai.common.user.c.e().x(e(USER_HOME_PAGE, "top", "DNAshow", d23.f(), Boolean.valueOf(z)));
        }
    }

    private iv2() {
    }
}
