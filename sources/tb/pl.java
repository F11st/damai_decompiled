package tb;

import android.text.TextUtils;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0528b;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class pl extends C0528b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String DISCOVER_SHOWCALENDAR_PAGE = "showcalendar";
    public static final String FEED_BACK_SCROT_PAGE = "scrot4help";
    public static final String HOME_CITYSELECT_PAGE = "cityselect";
    public static final String HOME_PAGE = "home";
    public static final String MY_ALIME_PAGE = "onlineservice";
    public static final String PROJECT_ADD_BUY_PERSON_PAGE = "addbuyperson";
    public static final String PROJECT_DETAIL_PAGE = "projectdetail";
    public static final String PROJECT_SHARE_PAGE = "share";
    private static pl b;

    public static pl j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1877799285")) {
            return (pl) ipChange.ipc$dispatch("1877799285", new Object[0]);
        }
        if (b == null) {
            b = new pl();
        }
        return b;
    }

    private C0525a.C0527b m(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1538647952") ? (C0525a.C0527b) ipChange.ipc$dispatch("1538647952", new Object[]{this, str, str2, str3, str4}) : new C0525a.C0527b().k(str3).a(str2).d(str4).i(str);
    }

    public C0525a.C0527b f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2886902")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-2886902", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("city", str + "市");
        }
        return e(HOME_CITYSELECT_PAGE, "citylist", "cityname", hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-981965707")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-981965707", new Object[]{this});
        }
        String d = z20.d();
        if (TextUtils.isEmpty(d)) {
            d = "北京";
        }
        return m(HOME_CITYSELECT_PAGE, d, null, null);
    }

    public C0525a.C0527b h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-506489548") ? (C0525a.C0527b) ipChange.ipc$dispatch("-506489548", new Object[]{this}) : e(FEED_BACK_SCROT_PAGE, FEED_BACK_SCROT_PAGE, "scrot4helpbtn", new HashMap(), Boolean.TRUE);
    }

    public C0525a.C0527b i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1574231525") ? (C0525a.C0527b) ipChange.ipc$dispatch("1574231525", new Object[]{this}) : b(FEED_BACK_SCROT_PAGE);
    }

    public C0525a.C0527b k() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1426231309") ? (C0525a.C0527b) ipChange.ipc$dispatch("1426231309", new Object[]{this}) : b(MY_ALIME_PAGE);
    }

    public C0525a.C0527b l(long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2147346134") ? (C0525a.C0527b) ipChange.ipc$dispatch("-2147346134", new Object[]{this, Long.valueOf(j)}) : m("addbuyperson", null, null, String.valueOf(j));
    }

    public C0525a.C0527b n() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-795675066") ? (C0525a.C0527b) ipChange.ipc$dispatch("-795675066", new Object[]{this}) : e("home", "performalert", "close", new HashMap(), Boolean.FALSE);
    }

    public C0525a.C0527b o(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-543566704")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-543566704", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("status", str);
        }
        return e("home", "performalert", "not_remind", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b p(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "293790924")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("293790924", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("ticket_id", str);
        }
        return e("home", "performalert", "digital_ticket", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b q(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1226672266")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1226672266", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        if (str != null) {
            hashMap.put("usercode", str);
        }
        if (str2 != null) {
            hashMap.put("contentlabel", str2);
        }
        return e("error", "center", "submit_error", hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b r(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-898513692")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-898513692", new Object[]{this, Long.valueOf(j), str});
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(String.valueOf(j))) {
            hashMap.put("item_id", String.valueOf(j));
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("titlelabel", str);
        }
        return e("share", "item", "canlebtn", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b s(long j, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-249341044")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-249341044", new Object[]{this, Long.valueOf(j), str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(String.valueOf(j))) {
            hashMap.put("item_id", String.valueOf(j));
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("titlelabel", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("contentlabel", str2);
        }
        return e("share", "item", str3, hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b t(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "940669273")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("940669273", new Object[]{this, str, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("contentlabel", str);
        }
        return e("home", "tabbar", "item_" + i, hashMap, Boolean.TRUE);
    }
}
