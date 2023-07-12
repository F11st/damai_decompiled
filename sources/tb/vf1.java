package tb;

import android.text.TextUtils;
import android.view.View;
import cn.damai.category.category.ui.StarFragment;
import cn.damai.common.user.a;
import cn.damai.commonbusiness.yymember.bean.MemberGuideInfo;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class vf1 extends cn.damai.common.user.b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String COLLECT = "collect";
    public static final String FANS_LIST_PAGE = "fans_list";
    public static final String FEED_BACK_LIST_PAGE = "addfeedback";
    public static final String FEED_BACK_PAGE = "submitfeedback";
    public static final String FOLLOW_LIST_PAGE = "follow_list";
    public static final String LOGISTICS_DETAIL = "logistics_info";
    public static final String MY_ACCOUTMANAGE_SAFE_PAGE = "accoutsecurity";
    public static final String MY_ADDRESSMANAGE_PAGE = "addressmanage";
    public static final String MY_COUPON_PAGE = "mycoupon";
    public static final String MY_FEED_BACL_DETAIL_PAGE = "feedbackdetail";
    public static final String MY_FEED_BACL_LIST_PAGE = "myfeedback";
    public static final String MY_PAGE = "my";
    public static final String MY_POINT_PAGE = "point";
    public static final String REALNAME_AUTHCENTER_PAGE = "realnamestatus";
    public static final String REALNAME_AUTHFAIL_PAGE = "realnamefail";
    public static final String REALNAME_AUTH_PAGE = "realnamecheck";
    public static final String REALNAME_FAILURE_REASON_PAGE = "failure_reason";
    public static final String REALNAME_VERIFYFAIL_PAGE = "realnameverifyfail";
    public static final String REALNAME_VERIFY_PAGE = "realnameverify";
    public static final String WANT_PRAISE_PAGE = "likes_and_favorite";

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    private static class b {
        private static final vf1 a = new vf1();
    }

    public static final vf1 x() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1243186603") ? (vf1) ipChange.ipc$dispatch("-1243186603", new Object[0]) : b.a;
    }

    public a.b A(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1417943230")) {
            return (a.b) ipChange.ipc$dispatch("-1417943230", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("crowd_type", str);
        return e(MY_PAGE, "bottom", "close", hashMap, Boolean.FALSE);
    }

    public a.b B() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-273075862") ? (a.b) ipChange.ipc$dispatch("-273075862", new Object[]{this}) : b(MY_PAGE);
    }

    public a.b C() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1975086500") ? (a.b) ipChange.ipc$dispatch("1975086500", new Object[]{this}) : e(MY_COUPON_PAGE, "top", "coupon_exchange", new HashMap(), Boolean.FALSE);
    }

    public a.b D(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-820932773")) {
            return (a.b) ipChange.ipc$dispatch("-820932773", new Object[]{this, str, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("coupon_id", str);
        hashMap.put("status", String.valueOf(i));
        return e(MY_COUPON_PAGE, "top", "coupon_submit", hashMap, Boolean.FALSE);
    }

    public a.b E(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2008847643")) {
            return (a.b) ipChange.ipc$dispatch("-2008847643", new Object[]{this, str, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("coupon_id", str);
        return e(MY_COUPON_PAGE, "not_use", "coupon_item_" + i, hashMap, Boolean.TRUE);
    }

    public a.b F() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "426493455") ? (a.b) ipChange.ipc$dispatch("426493455", new Object[]{this}) : b(MY_FEED_BACL_DETAIL_PAGE);
    }

    public a.b G() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2023229980") ? (a.b) ipChange.ipc$dispatch("2023229980", new Object[]{this}) : b(MY_FEED_BACL_LIST_PAGE);
    }

    public a.b H() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "503084406") ? (a.b) ipChange.ipc$dispatch("503084406", new Object[]{this}) : c(MY_PAGE, "top", "loginbutton", Boolean.FALSE);
    }

    public a.b I() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-734916264") ? (a.b) ipChange.ipc$dispatch("-734916264", new Object[]{this}) : c(MY_PAGE, "top", "message", Boolean.TRUE);
    }

    public a.b J() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-812071176") ? (a.b) ipChange.ipc$dispatch("-812071176", new Object[]{this}) : c(MY_PAGE, "top", "more", Boolean.TRUE);
    }

    public a.b K() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "647714756")) {
            return (a.b) ipChange.ipc$dispatch("647714756", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.i());
        return e(MY_PAGE, "center", "entrance", hashMap, Boolean.TRUE);
    }

    public void L(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-329451281")) {
            ipChange.ipc$dispatch("-329451281", new Object[]{this, view});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.i());
        cn.damai.common.user.c.e().G(view, "entrance", "center", MY_PAGE, hashMap);
    }

    public a.b M() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-740804297") ? (a.b) ipChange.ipc$dispatch("-740804297", new Object[]{this}) : b("point");
    }

    public a.b N() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "123199731") ? (a.b) ipChange.ipc$dispatch("123199731", new Object[]{this}) : b(REALNAME_AUTHCENTER_PAGE);
    }

    public a.b O() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "434994520")) {
            return (a.b) ipChange.ipc$dispatch("434994520", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        return e(REALNAME_AUTH_PAGE, "center", "canlebtn", hashMap, Boolean.FALSE);
    }

    public a.b P() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1304672622")) {
            return (a.b) ipChange.ipc$dispatch("1304672622", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        return e(REALNAME_AUTH_PAGE, "center", "face_recognition", hashMap, Boolean.FALSE);
    }

    public a.b Q() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1498567973") ? (a.b) ipChange.ipc$dispatch("-1498567973", new Object[]{this}) : b(REALNAME_AUTHFAIL_PAGE);
    }

    public a.b R() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-359384898") ? (a.b) ipChange.ipc$dispatch("-359384898", new Object[]{this}) : b(REALNAME_AUTH_PAGE);
    }

    public a.b S() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "904414204")) {
            return (a.b) ipChange.ipc$dispatch("904414204", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        return e(REALNAME_AUTH_PAGE, "top", MonitorType.SKIP, hashMap, Boolean.FALSE);
    }

    public a.b T() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1711227075")) {
            return (a.b) ipChange.ipc$dispatch("1711227075", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        return e(REALNAME_AUTH_PAGE, "bottom", "submit", hashMap, Boolean.FALSE);
    }

    public a.b U() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1358212580")) {
            return (a.b) ipChange.ipc$dispatch("-1358212580", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        return e(MY_PAGE, "top", "suggest_realnamecheck", hashMap, Boolean.TRUE);
    }

    public a.b V() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1618358258")) {
            return (a.b) ipChange.ipc$dispatch("-1618358258", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        return e(REALNAME_AUTHCENTER_PAGE, "top", pl.MY_ALIME_PAGE, hashMap, Boolean.FALSE);
    }

    public a.b W() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2050639073")) {
            return (a.b) ipChange.ipc$dispatch("-2050639073", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        return e(REALNAME_AUTH_PAGE, "select_person", "select_personbtn", hashMap, Boolean.FALSE);
    }

    public a.b X() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-405075113")) {
            return (a.b) ipChange.ipc$dispatch("-405075113", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        return e(REALNAME_AUTH_PAGE, "select_person", "select_person", hashMap, Boolean.FALSE);
    }

    public a.b Y() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "508094872") ? (a.b) ipChange.ipc$dispatch("508094872", new Object[]{this}) : b(REALNAME_FAILURE_REASON_PAGE);
    }

    public a.b Z() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "582389932") ? (a.b) ipChange.ipc$dispatch("582389932", new Object[]{this}) : b(REALNAME_VERIFYFAIL_PAGE);
    }

    public a.b a0() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1097731919") ? (a.b) ipChange.ipc$dispatch("1097731919", new Object[]{this}) : b(REALNAME_VERIFY_PAGE);
    }

    public a.b b0(String str, int i, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1996531140")) {
            return (a.b) ipChange.ipc$dispatch("-1996531140", new Object[]{this, str, Integer.valueOf(i), str2, str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", str2);
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("tab_type", str3);
        }
        return e(str, StarFragment.KEY_FOLLOW, "item_" + i, hashMap, Boolean.FALSE);
    }

    public a.b c0(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "126533514")) {
            return (a.b) ipChange.ipc$dispatch("126533514", new Object[]{this, Integer.valueOf(i), str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        return e(WANT_PRAISE_PAGE, "wantsee", "item_" + i, hashMap, Boolean.FALSE);
    }

    public a.b d0() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1844774316") ? (a.b) ipChange.ipc$dispatch("-1844774316", new Object[]{this}) : e(MY_PAGE, "bottom", "submitbtn", null, Boolean.TRUE);
    }

    public a.b e0(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "798766877")) {
            return (a.b) ipChange.ipc$dispatch("798766877", new Object[]{this, Integer.valueOf(i), str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("city", z20.d());
        hashMap.put("titlelabel", str);
        return e(MY_PAGE, "center", "tab_" + i, hashMap, Boolean.FALSE);
    }

    public a.b f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-252376387") ? (a.b) ipChange.ipc$dispatch("-252376387", new Object[]{this}) : c(MY_ACCOUTMANAGE_SAFE_PAGE, "list", "loginpassword", Boolean.TRUE);
    }

    public a.b f0(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1202385687")) {
            return (a.b) ipChange.ipc$dispatch("-1202385687", new Object[]{this, Integer.valueOf(i), str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        return e(WANT_PRAISE_PAGE, "top", "tab_" + i, hashMap, Boolean.FALSE);
    }

    public a.b g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "537433890") ? (a.b) ipChange.ipc$dispatch("537433890", new Object[]{this}) : c(MY_ACCOUTMANAGE_SAFE_PAGE, "list", "mobilebind", Boolean.TRUE);
    }

    public a.b g0(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1999093045") ? (a.b) ipChange.ipc$dispatch("-1999093045", new Object[]{this, str}) : e(MY_PAGE, "listtools", str, null, Boolean.TRUE);
    }

    public a.b h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "769330620") ? (a.b) ipChange.ipc$dispatch("769330620", new Object[]{this}) : c(MY_ACCOUTMANAGE_SAFE_PAGE, "list", "paypassword", Boolean.TRUE);
    }

    public a.b h0() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1450780918") ? (a.b) ipChange.ipc$dispatch("1450780918", new Object[]{this}) : c(MY_PAGE, "center", "anouncement", Boolean.FALSE);
    }

    public a.b i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2123595017") ? (a.b) ipChange.ipc$dispatch("2123595017", new Object[]{this}) : c(MY_ACCOUTMANAGE_SAFE_PAGE, "list", REALNAME_AUTH_PAGE, Boolean.TRUE);
    }

    public a.b i0(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-939460989") ? (a.b) ipChange.ipc$dispatch("-939460989", new Object[]{this, str}) : c(MY_PAGE, "top", str, Boolean.FALSE);
    }

    public a.b j() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1153927608") ? (a.b) ipChange.ipc$dispatch("-1153927608", new Object[]{this}) : b(MY_ACCOUTMANAGE_SAFE_PAGE);
    }

    public a.b j0(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-471548160")) {
            return (a.b) ipChange.ipc$dispatch("-471548160", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("vip_status", str);
        return e(MY_PAGE, "listtools", "vipcenter", hashMap, Boolean.TRUE);
    }

    public a.b k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-307002306")) {
            return (a.b) ipChange.ipc$dispatch("-307002306", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        return e(MY_ACCOUTMANAGE_SAFE_PAGE, "viptipalert", "close", hashMap, Boolean.FALSE);
    }

    public a.b k0(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1822442683")) {
            return (a.b) ipChange.ipc$dispatch("-1822442683", new Object[]{this, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        return e(MY_FEED_BACL_LIST_PAGE, "feedbacklist", "feedbackdetail_" + i, hashMap, Boolean.TRUE);
    }

    public a.b l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1621652544")) {
            return (a.b) ipChange.ipc$dispatch("-1621652544", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        return e(MY_ACCOUTMANAGE_SAFE_PAGE, "viptipalert", "continue", hashMap, Boolean.TRUE);
    }

    public a.b l0() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1138426835") ? (a.b) ipChange.ipc$dispatch("1138426835", new Object[]{this}) : e(FEED_BACK_LIST_PAGE, "top", MY_FEED_BACL_LIST_PAGE, new HashMap(), Boolean.TRUE);
    }

    public a.b m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "140577199")) {
            return (a.b) ipChange.ipc$dispatch("140577199", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        return e(MY_ACCOUTMANAGE_SAFE_PAGE, "list", "myvip", hashMap, Boolean.TRUE);
    }

    public void m0(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-492739032")) {
            ipChange.ipc$dispatch("-492739032", new Object[]{this, view});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        cn.damai.common.user.c.e().G(view, "alert", "viptipalert", MY_ACCOUTMANAGE_SAFE_PAGE, hashMap);
    }

    public a.b n() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-89130042") ? (a.b) ipChange.ipc$dispatch("-89130042", new Object[]{this}) : c(MY_ADDRESSMANAGE_PAGE, "bottom", "addaddress", Boolean.TRUE);
    }

    public void n0(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-780894015")) {
            ipChange.ipc$dispatch("-780894015", new Object[]{this, view});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        cn.damai.common.user.c.e().G(view, "myvip", "list", MY_ACCOUTMANAGE_SAFE_PAGE, hashMap);
    }

    public a.b o() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1562665490") ? (a.b) ipChange.ipc$dispatch("-1562665490", new Object[]{this}) : b(MY_ADDRESSMANAGE_PAGE);
    }

    public void o0(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2034401085")) {
            ipChange.ipc$dispatch("-2034401085", new Object[]{this, view, str});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("crowd_type", str);
        cn.damai.common.user.c.e().G(view, MemberGuideInfo.authorize, "bottom", MY_PAGE, hashMap);
    }

    public a.b p() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "825450023") ? (a.b) ipChange.ipc$dispatch("825450023", new Object[]{this}) : b(MY_COUPON_PAGE);
    }

    public void p0(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-198020154")) {
            ipChange.ipc$dispatch("-198020154", new Object[]{this, view, str});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("vip_status", str);
        cn.damai.common.user.c.e().G(view, "vipcenter", "listtools", MY_PAGE, hashMap);
    }

    public a.b q(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1201360533")) {
            return (a.b) ipChange.ipc$dispatch("1201360533", new Object[]{this, str, str2, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("scm", str);
        hashMap.put("contentlabel", str2);
        return e(MY_PAGE, "center", "resource_item_" + i, hashMap, Boolean.TRUE);
    }

    public a.b q0(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1451756840")) {
            return (a.b) ipChange.ipc$dispatch("-1451756840", new Object[]{this, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        return e(FEED_BACK_PAGE, "feedback_type", "feedback_type_" + i, hashMap, Boolean.FALSE);
    }

    public a.b r() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "368352434") ? (a.b) ipChange.ipc$dispatch("368352434", new Object[]{this}) : e(MY_PAGE, "center", "more_item", null, Boolean.FALSE);
    }

    public a.b s() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "980032871")) {
            return (a.b) ipChange.ipc$dispatch("980032871", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        return e(REALNAME_AUTHCENTER_PAGE, "center", "face_recognition", hashMap, Boolean.FALSE);
    }

    public a.b t() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1997659345") ? (a.b) ipChange.ipc$dispatch("-1997659345", new Object[]{this}) : b(FEED_BACK_PAGE);
    }

    public a.b u(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1886009221")) {
            return (a.b) ipChange.ipc$dispatch("-1886009221", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        hashMap.put("contentlabel", str2);
        return e(FEED_BACK_PAGE, "submit_feedback", "submit_feedbackbtn", hashMap, Boolean.FALSE);
    }

    public a.b v(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1457895507")) {
            return (a.b) ipChange.ipc$dispatch("1457895507", new Object[]{this, Long.valueOf(j), str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        return e(FEED_BACK_LIST_PAGE, "feedbacktype", "selectfeedback_" + j, hashMap, Boolean.TRUE);
    }

    public a.b w() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1131502960") ? (a.b) ipChange.ipc$dispatch("-1131502960", new Object[]{this}) : b(FEED_BACK_LIST_PAGE);
    }

    public a.b y() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1333510595") ? (a.b) ipChange.ipc$dispatch("1333510595", new Object[]{this}) : b(LOGISTICS_DETAIL);
    }

    public a.b z(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-362224602")) {
            return (a.b) ipChange.ipc$dispatch("-362224602", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("crowd_type", str);
        return e(MY_PAGE, "bottom", MemberGuideInfo.authorize, hashMap, Boolean.FALSE);
    }

    private vf1() {
    }
}
