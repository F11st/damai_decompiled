package tb;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import cn.damai.common.user.a;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.InFieldCommentsBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.PromotionItemBean;
import cn.damai.user.star.StarIndexFragment;
import com.alibaba.aliweex.adapter.module.location.ILocatable;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.login4android.constants.LoginConstants;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.taobao.weex.common.Constants;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class pp2 extends gb {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CUSTOM_ORDER = "submitorder";
    public static final String CUSTOM_SAFE = "securityverification";
    public static final String HN_ORDER_CREATE_INVOICE_PAGE = "get_invoice";
    public static final String HOME_MESSAGE_PAGE = "message";
    public static final String ORDER_DETAL_PAGE = "orderdetails";
    public static final String ORDER_INVOICE_DETAIL_PAGE = "invoice_details";
    public static final String ORDER_LIST_PAGE = "showorder";
    public static final String ORDER_MODIFY_ADDRESS_PAGE = "modify_order_address";
    public static final String ORDER_PROGRESS_PAGE = "order_progress";
    public static final String PROJECT_CONFIRM_PAGE = "confirm";
    public static final String PROJECT_EVALUATE = "evaluate";
    public static final String PROJECT_FILL_INFORMATION = "fill_information";
    public static final String PROJECT_NOTICKET_PAGE = "noticketregister";
    public static final String PROJECT_PAGE_WARM_PROMPT = "visualhints";
    public static final String PROJECT_PREFEREBTIAL_PAGE = "preferentialexplain";
    public static final String PROJECT_SCRIPTKILL_ORDRR_DETAILS_PAGE = "scriptkill_orderdetails";
    public static final String PROJECT_TICKET_PAGE = "ticketexplain";
    public static final String PROJECT_TICKET_STRATEGY = "ticket_strategy";
    public static final String PROJECT_VENUEMAP_PAGE = "venuemap";
    public static final String PROJRCT_CONFIRM_PAY = "payorder";

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    private static class a {
        private static final pp2 a = new pp2();
    }

    private void Q1(String str, View view, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2108389716")) {
            ipChange.ipc$dispatch("2108389716", new Object[]{this, str, view, str2});
        } else if (view == null || str == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", str2);
            cn.damai.common.user.c.e().G(view, str, "bottom", gb.PROJECT_PAGE, hashMap);
        }
    }

    private void R1(String str, View view, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1102657150")) {
            ipChange.ipc$dispatch("1102657150", new Object[]{this, str, view, str2});
        } else if (view == null || str == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", str2);
            cn.damai.common.user.c.e().G(view, str, "center", gb.PROJECT_PAGE, hashMap);
        }
    }

    private Map<String, String> q(String str, String str2, String str3, String str4, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-815795281")) {
            return (Map) ipChange.ipc$dispatch("-815795281", new Object[]{this, str, str2, str3, str4, Boolean.valueOf(z)});
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("item_id", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("orderid", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("titlelabel", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("contentlabel", str4);
        }
        hashMap.put("is_seat", z ? "1" : "0");
        return hashMap;
    }

    public static final pp2 u() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1661241019") ? (pp2) ipChange.ipc$dispatch("1661241019", new Object[0]) : a.a;
    }

    public a.b A(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2102634468")) {
            return (a.b) ipChange.ipc$dispatch("2102634468", new Object[]{this, str, str2, Boolean.valueOf(z)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("orderid", str2);
        return e(ORDER_DETAL_PAGE, z ? "bottom" : "top", "closeorder", hashMap, Boolean.FALSE);
    }

    public a.b A0(long j, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1403600449")) {
            return (a.b) ipChange.ipc$dispatch("1403600449", new Object[]{this, Long.valueOf(j), Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e(gb.PROJECT_PAGE, "details", "itemimages_" + i, hashMap, Boolean.TRUE);
    }

    public a.b A1(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-177868008")) {
            return (a.b) ipChange.ipc$dispatch("-177868008", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("orderid", str);
        return e(ORDER_PROGRESS_PAGE, "order_info", "queue_status", hashMap, Boolean.FALSE);
    }

    public a.b A2(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1416839363")) {
            return (a.b) ipChange.ipc$dispatch("1416839363", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("usercode", z20.E());
        return e(PROJECT_FILL_INFORMATION, "center", "address_info", hashMap, Boolean.FALSE);
    }

    public a.b B(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-934706892")) {
            return (a.b) ipChange.ipc$dispatch("-934706892", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", str);
        hashMap.put("orderid", str2);
        return e(ORDER_DETAL_PAGE, "order_info", "orderid_copy", hashMap, Boolean.FALSE);
    }

    public a.b B0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1644848330")) {
            return (a.b) ipChange.ipc$dispatch("1644848330", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e(gb.PROJECT_PAGE, "center", "more_service", hashMap, Boolean.FALSE);
    }

    public a.b B1(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-708650976")) {
            return (a.b) ipChange.ipc$dispatch("-708650976", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("orderid", str);
        return e(ORDER_PROGRESS_PAGE, "order_info", "seat_remind", hashMap, Boolean.FALSE);
    }

    public a.b B2(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "794162274")) {
            return (a.b) ipChange.ipc$dispatch("794162274", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("usercode", z20.E());
        return e(PROJECT_FILL_INFORMATION, "center", "user_info", hashMap, Boolean.FALSE);
    }

    public a.b C(String str, String str2, String str3, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-372591244")) {
            return (a.b) ipChange.ipc$dispatch("-372591244", new Object[]{this, str, str2, str3, Boolean.valueOf(z)});
        }
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("item_id", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("orderid", str2);
        hashMap.put("contentlabel", str3);
        return e(ORDER_DETAL_PAGE, z ? "bottom" : "top", "submitpay", hashMap, Boolean.FALSE);
    }

    public a.b C0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "600467891")) {
            return (a.b) ipChange.ipc$dispatch("600467891", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("item_id", String.valueOf(j));
        return e(gb.PROJECT_PAGE, "top", "announcement", hashMap, Boolean.FALSE);
    }

    public a.b C1(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1206776382")) {
            return (a.b) ipChange.ipc$dispatch("-1206776382", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("orderid", str);
        return e(ORDER_PROGRESS_PAGE, "order_info", "check_ticketwallet", hashMap, Boolean.TRUE);
    }

    public a.b C2(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1639239259")) {
            return (a.b) ipChange.ipc$dispatch("1639239259", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("usercode", z20.E());
        return e(PROJECT_FILL_INFORMATION, "center", "email_info", hashMap, Boolean.FALSE);
    }

    public a.b D(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-463663297")) {
            return (a.b) ipChange.ipc$dispatch("-463663297", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("orderid", str);
        return e(ORDER_DETAL_PAGE, "bottom", "logistics_info_btn", hashMap, Boolean.TRUE);
    }

    public a.b D0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-743568069")) {
            return (a.b) ipChange.ipc$dispatch("-743568069", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e(gb.PROJECT_PAGE, "center", PROJECT_TICKET_PAGE, hashMap, Boolean.TRUE);
    }

    public a.b D1(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-842312485")) {
            return (a.b) ipChange.ipc$dispatch("-842312485", new Object[]{this, str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("usercode", z20.E());
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("ip_id", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("score", str3);
        }
        return e(gb.PROJECT_PAGE, "center", "score_description", hashMap, Boolean.TRUE);
    }

    public a.b D2(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "890955723")) {
            return (a.b) ipChange.ipc$dispatch("890955723", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("usercode", z20.E());
        return e(PROJECT_TICKET_STRATEGY, "center", "login", hashMap, Boolean.FALSE);
    }

    public a.b E(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1105339167")) {
            return (a.b) ipChange.ipc$dispatch("1105339167", new Object[]{this, str, str2, Boolean.valueOf(z)});
        }
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("item_id", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("orderid", str2);
        return e(ORDER_DETAL_PAGE, z ? "bottom" : "top", "unable_pay", hashMap, Boolean.FALSE);
    }

    public a.b E0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "397695568")) {
            return (a.b) ipChange.ipc$dispatch("397695568", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        hashMap.put("usercode", z20.E());
        return e(gb.PROJECT_PAGE, "top", "entrance", hashMap, Boolean.TRUE);
    }

    public void E1(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1182199865")) {
            ipChange.ipc$dispatch("1182199865", new Object[]{this, view, str});
        } else if (view == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", str);
            cn.damai.common.user.c.e().G(view, "addtocalendar", "remindme", gb.PROJECT_PAGE, hashMap);
        }
    }

    public a.b E2(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1420245453")) {
            return (a.b) ipChange.ipc$dispatch("-1420245453", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("usercode", z20.E());
        return e(PROJECT_TICKET_STRATEGY, "center", "addtocalendar", hashMap, Boolean.FALSE);
    }

    public a.b F(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "775208038")) {
            return (a.b) ipChange.ipc$dispatch("775208038", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", str);
        hashMap.put("orderid", str2);
        return e(ORDER_DETAL_PAGE, pl.MY_ALIME_PAGE, pl.MY_ALIME_PAGE, hashMap, Boolean.TRUE);
    }

    public a.b F0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-429629031")) {
            return (a.b) ipChange.ipc$dispatch("-429629031", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e(gb.PROJECT_PAGE, "center", "perform", hashMap, Boolean.TRUE);
    }

    public void F1(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-223637527")) {
            ipChange.ipc$dispatch("-223637527", new Object[]{this, view, str});
        } else if (view == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", str);
            cn.damai.common.user.c.e().G(view, "announcement", "top", gb.PROJECT_PAGE, hashMap);
        }
    }

    public a.b F2(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1770013935")) {
            return (a.b) ipChange.ipc$dispatch("1770013935", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("usercode", z20.E());
        return e(PROJECT_TICKET_STRATEGY, "center", LoginConstants.LOGIN_UPGRADE, hashMap, Boolean.FALSE);
    }

    public a.b G(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-389886058")) {
            return (a.b) ipChange.ipc$dispatch("-389886058", new Object[]{this, str, str2, Boolean.valueOf(z)});
        }
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("item_id", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("orderid", str2);
        return e(ORDER_DETAL_PAGE, z ? "bottom" : "top", "pay_mode", hashMap, Boolean.FALSE);
    }

    public a.b G0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1946750661")) {
            return (a.b) ipChange.ipc$dispatch("-1946750661", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e(gb.PROJECT_PAGE, "top", "poster", hashMap, Boolean.FALSE);
    }

    public void G1(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1636485888")) {
            ipChange.ipc$dispatch("-1636485888", new Object[]{this, view, str});
        } else {
            Q1("buy", view, str);
        }
    }

    public void G2(long j, Activity activity, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2029744926")) {
            ipChange.ipc$dispatch("-2029744926", new Object[]{this, Long.valueOf(j), activity, str});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("current_ab", str);
        a.b bVar = new a.b();
        bVar.d(String.valueOf(j)).i(gb.PROJECT_PAGE).j(hashMap);
        cn.damai.common.user.c.e().l(activity, bVar);
    }

    public a.b H(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-138753275")) {
            return (a.b) ipChange.ipc$dispatch("-138753275", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("orderid", str);
        return e(ORDER_DETAL_PAGE, "order_info", "queue_status", hashMap, Boolean.FALSE);
    }

    public a.b H0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "229722868")) {
            return (a.b) ipChange.ipc$dispatch("229722868", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e(gb.PROJECT_PAGE, "bottom", "vipbuy", hashMap, Boolean.FALSE);
    }

    public void H1(View view, String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2146399168")) {
            ipChange.ipc$dispatch("2146399168", new Object[]{this, view, str, str2, Integer.valueOf(i)});
        } else if (view == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", str);
            hashMap.put("comment_id", str2);
            cn.damai.common.user.c e = cn.damai.common.user.c.e();
            e.G(view, "comment_" + i, PROJECT_EVALUATE, gb.PROJECT_PAGE, hashMap);
        }
    }

    public a.b I(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "362193978")) {
            return (a.b) ipChange.ipc$dispatch("362193978", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        if (str == null) {
            str = "";
        }
        hashMap.put("orderid", str);
        return e(ORDER_DETAL_PAGE, "refund", "apply", hashMap, Boolean.TRUE);
    }

    public a.b I0(long j, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1919275056")) {
            return (a.b) ipChange.ipc$dispatch("1919275056", new Object[]{this, Long.valueOf(j), str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        hashMap.put("titlelabel", "特权码");
        hashMap.put("privilege_id", str);
        hashMap.put("privilege_code", str2);
        return e(gb.PROJECT_PAGE, "vip", "confimbtn", hashMap, Boolean.FALSE);
    }

    public void I1(View view, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1328100309")) {
            ipChange.ipc$dispatch("1328100309", new Object[]{this, view, str, Integer.valueOf(i)});
        } else if (view == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", str);
            cn.damai.common.user.c e = cn.damai.common.user.c.e();
            e.G(view, "commonproblem_" + i, "commonproblem", gb.PROJECT_PAGE, hashMap);
        }
    }

    public a.b J(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "871214217")) {
            return (a.b) ipChange.ipc$dispatch("871214217", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("orderid", str);
        return e(ORDER_DETAL_PAGE, "order_info", "remind", hashMap, Boolean.FALSE);
    }

    public a.b J0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "884284195")) {
            return (a.b) ipChange.ipc$dispatch("884284195", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e(gb.PROJECT_PAGE, "bottom", "vipselect", hashMap, Boolean.FALSE);
    }

    public a.b J1(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-25046202")) {
            return (a.b) ipChange.ipc$dispatch("-25046202", new Object[]{this, str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("orderid", str);
        hashMap.put("invoice_type", str2);
        hashMap.put("acquisition_mode", str3);
        return e(HN_ORDER_CREATE_INVOICE_PAGE, "bottom", "submit", hashMap, Boolean.FALSE);
    }

    public a.b K(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "58514825")) {
            return (a.b) ipChange.ipc$dispatch("58514825", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("orderid", str);
        return e(ORDER_DETAL_PAGE, "order_info", "gotoseatselect", hashMap, Boolean.TRUE);
    }

    public a.b K0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-259892881")) {
            return (a.b) ipChange.ipc$dispatch("-259892881", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return d(gb.PROJECT_PAGE, "vip", "buy", "vip_buy", hashMap, Boolean.TRUE);
    }

    public void K1(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1775483302")) {
            ipChange.ipc$dispatch("1775483302", new Object[]{this, view, str});
        } else {
            Q1("onsale_checkin", view, str);
        }
    }

    public a.b L(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1671681277")) {
            return (a.b) ipChange.ipc$dispatch("1671681277", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        hashMap.put("orderid", str);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        hashMap.put("item_id", str2);
        return e(ORDER_DETAL_PAGE, "answers", "showanswerbtn", hashMap, Boolean.FALSE);
    }

    public a.b L0(String str, String str2, String str3, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1519673939")) {
            return (a.b) ipChange.ipc$dispatch("1519673939", new Object[]{this, str, str2, str3, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str2);
        hashMap.put("contentlabel", str);
        hashMap.put("alg", String.valueOf(str3));
        return e(gb.PROJECT_PAGE, "rec", "item_" + i, hashMap, Boolean.TRUE);
    }

    public void L1(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1701614373")) {
            ipChange.ipc$dispatch("-1701614373", new Object[]{this, view, str});
        } else if (view == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("usercode", z20.E());
            hashMap.put("item_id", str);
            cn.damai.common.user.c.e().G(view, "award_share", "center", ORDER_LIST_PAGE, hashMap);
        }
    }

    public a.b M(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "139760736")) {
            return (a.b) ipChange.ipc$dispatch("139760736", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("orderid", str2);
        return e(ORDER_DETAL_PAGE, "bottom", "submitpay", hashMap, Boolean.FALSE);
    }

    public a.b M0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2025125729")) {
            return (a.b) ipChange.ipc$dispatch("2025125729", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e(gb.PROJECT_PAGE, "bottom", "saleremind", hashMap, Boolean.FALSE);
    }

    public void M1(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "26489499")) {
            ipChange.ipc$dispatch("26489499", new Object[]{this, view, str});
        } else if (view == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", str);
            cn.damai.common.user.c.e().G(view, "perform", "center", gb.PROJECT_PAGE, hashMap);
        }
    }

    public Map<String, String> N(String str, String str2, String str3, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-891102459")) {
            return (Map) ipChange.ipc$dispatch("-891102459", new Object[]{this, str, str2, str3, Boolean.valueOf(z)});
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "网络超时";
        }
        return q(str, str2, "false", str3, z);
    }

    public a.b N0(long j, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1720716788")) {
            return (a.b) ipChange.ipc$dispatch("-1720716788", new Object[]{this, Long.valueOf(j), Boolean.valueOf(z)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        hashMap.put(SocialConstants.PARAM_APP_DESC, z ? "无座位图" : "座位图");
        return e(gb.PROJECT_PAGE, "center", "seatmap", hashMap, Boolean.FALSE);
    }

    public void N1(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1021171853")) {
            ipChange.ipc$dispatch("1021171853", new Object[]{this, view, str});
        } else if (view == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", str);
            hashMap.put("type", gb.PROJECT_PAGE);
            cn.damai.common.user.c.e().G(view, "poster", "top", gb.PROJECT_PAGE, hashMap);
        }
    }

    public Map<String, String> O(String str, String str2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "399099754") ? (Map) ipChange.ipc$dispatch("399099754", new Object[]{this, str, str2}) : q(str, str2, "true", null, false);
    }

    public a.b O0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1886363423")) {
            return (a.b) ipChange.ipc$dispatch("1886363423", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e(gb.PROJECT_PAGE, "bottom", "service", hashMap, Boolean.TRUE);
    }

    public void O1(View view, int i, String str) {
        String str2;
        String str3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "49296431")) {
            ipChange.ipc$dispatch("49296431", new Object[]{this, view, Integer.valueOf(i), str});
        } else if (view == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", str);
            if (i != 0) {
                if (i == 1) {
                    str3 = PROJECT_EVALUATE;
                } else if (i == 2) {
                    str3 = "notice";
                } else if (i == 3) {
                    str3 = "recommend";
                }
                str2 = str3;
                cn.damai.common.user.c.e().G(view, str2, "anchor", gb.PROJECT_PAGE, hashMap);
            }
            str2 = "details";
            cn.damai.common.user.c.e().G(view, str2, "anchor", gb.PROJECT_PAGE, hashMap);
        }
    }

    public Map<String, String> P(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "270938996") ? (Map) ipChange.ipc$dispatch("270938996", new Object[]{this, str, str2, Boolean.valueOf(z)}) : q(str, str2, "true", null, z);
    }

    public a.b P0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1806717676")) {
            return (a.b) ipChange.ipc$dispatch("-1806717676", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e(gb.PROJECT_PAGE, "center", "servicedivbtn", hashMap, Boolean.FALSE);
    }

    public void P1(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-417359223")) {
            ipChange.ipc$dispatch("-417359223", new Object[]{this, view, str});
        } else if (view == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", str);
            cn.damai.common.user.c.e().G(view, gh1.MODULE_BANNER, "center", gb.PROJECT_PAGE, hashMap);
        }
    }

    public a.b Q(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1776905260")) {
            return (a.b) ipChange.ipc$dispatch("-1776905260", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("orderid", str);
        return e(ORDER_DETAL_PAGE, "bottom", "ticket_info", hashMap, Boolean.TRUE);
    }

    public a.b Q0(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1744657691")) {
            return (a.b) ipChange.ipc$dispatch("1744657691", new Object[]{this, str, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        return e(gb.PROJECT_PAGE, "center", "tour_item_" + i, hashMap, Boolean.TRUE);
    }

    public a.b R(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-825850375")) {
            return (a.b) ipChange.ipc$dispatch("-825850375", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("orderid", str);
        return e(ORDER_DETAL_PAGE, "distribution_info", vf1.LOGISTICS_DETAIL, hashMap, Boolean.TRUE);
    }

    public a.b R0(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1852379301")) {
            return (a.b) ipChange.ipc$dispatch("-1852379301", new Object[]{this, intent});
        }
        try {
            a.b b = b("venuemap");
            long longExtra = intent.getLongExtra("projectId", 0L);
            if (longExtra != 0) {
                b.d(String.valueOf(longExtra));
            }
            b.a(z20.d());
            return b;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public a.b S(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-395959150")) {
            return (a.b) ipChange.ipc$dispatch("-395959150", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("orderid", str);
        return e(ORDER_DETAL_PAGE, "distribution_info", "modify_address", hashMap, Boolean.TRUE);
    }

    public a.b S0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1072350404")) {
            return (a.b) ipChange.ipc$dispatch("1072350404", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e(gb.PROJECT_PAGE, "center", "venuenamebtn", hashMap, Boolean.TRUE);
    }

    public void S1(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-705977002")) {
            ipChange.ipc$dispatch("-705977002", new Object[]{this, view, str});
        } else if (view == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", str);
            cn.damai.common.user.c.e().G(view, "license_tag", "top", gb.PROJECT_PAGE, hashMap);
        }
    }

    public a.b T(String str, String str2, String str3, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1248918098")) {
            return (a.b) ipChange.ipc$dispatch("-1248918098", new Object[]{this, str, str2, str3, Boolean.valueOf(z)});
        }
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("item_id", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("orderid", str2);
        hashMap.put("contentlabel", str3);
        return e(z ? PROJECT_SCRIPTKILL_ORDRR_DETAILS_PAGE : ORDER_DETAL_PAGE, "bottom", "confirm_pay", hashMap, Boolean.FALSE);
    }

    public a.b T0(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "650632581")) {
            return (a.b) ipChange.ipc$dispatch("650632581", new Object[]{this, Long.valueOf(j), str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        hashMap.put("titlelabel", str);
        return e(gb.PROJECT_PAGE, "vip", "confimbtn", hashMap, Boolean.FALSE);
    }

    public void T1(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1866276148")) {
            ipChange.ipc$dispatch("-1866276148", new Object[]{this, view, str});
        } else if (view == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", str);
            cn.damai.common.user.c.e().G(view, "evaluate_list", PROJECT_EVALUATE, gb.PROJECT_PAGE, hashMap);
        }
    }

    public a.b U(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-175472862")) {
            return (a.b) ipChange.ipc$dispatch("-175472862", new Object[]{this, str, str2, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", str);
        hashMap.put("orderid", str2);
        return e(ORDER_LIST_PAGE, "order_info", "gotoseatselect_" + i, hashMap, Boolean.TRUE);
    }

    public a.b U0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1212741228")) {
            return (a.b) ipChange.ipc$dispatch("1212741228", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e(gb.PROJECT_PAGE, "center", PROJECT_PAGE_WARM_PROMPT, hashMap, Boolean.TRUE);
    }

    public void U1(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2297224")) {
            ipChange.ipc$dispatch("2297224", new Object[]{this, view, str});
        } else if (view == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", str);
            cn.damai.common.user.c.e().G(view, "moreitem", "details", gb.PROJECT_PAGE, hashMap);
        }
    }

    public a.b V(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "960234475")) {
            return (a.b) ipChange.ipc$dispatch("960234475", new Object[]{this, str, str2, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", str);
        hashMap.put("orderid", str2);
        return e(ORDER_LIST_PAGE, "order_info", "remind_" + i, hashMap, Boolean.FALSE);
    }

    public a.b V0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-423259283")) {
            return (a.b) ipChange.ipc$dispatch("-423259283", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        hashMap.put("usercode", z20.E());
        return e(gb.PROJECT_PAGE, "center", "ranklist", hashMap, Boolean.TRUE);
    }

    public void V1(String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "591252654")) {
            ipChange.ipc$dispatch("591252654", new Object[]{this, str, Long.valueOf(j)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        cn.damai.common.user.c.e().C("gotoopen_tips", "bottom", gb.PROJECT_PAGE, "1.0", System.currentTimeMillis() - j, hashMap, 2201);
    }

    public a.b W(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-153589489")) {
            return (a.b) ipChange.ipc$dispatch("-153589489", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", str);
        return e(ORDER_LIST_PAGE, "tabbar", "order_all", hashMap, Boolean.FALSE);
    }

    public a.b W0(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "56864136")) {
            return (a.b) ipChange.ipc$dispatch("56864136", new Object[]{this, str, str2, Boolean.valueOf(z)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        return e(gb.PROJECT_PAGE, AgooConstants.MESSAGE_POPUP, str2, hashMap, Boolean.valueOf(z));
    }

    public void W1(long j, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-533182592")) {
            ipChange.ipc$dispatch("-533182592", new Object[]{this, Long.valueOf(j), str, str2, str3});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("itempromotionids", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("itemcouponids", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("privilegeids", str3);
        }
        cn.damai.common.user.c.e().A(hashMap, "yhtc_project_discountinfo", gb.PROJECT_PAGE);
    }

    public a.b X(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1816181720")) {
            return (a.b) ipChange.ipc$dispatch("-1816181720", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", str);
        return e(ORDER_LIST_PAGE, "tabbar", "order_pay", hashMap, Boolean.FALSE);
    }

    public a.b X0(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "984102517")) {
            return (a.b) ipChange.ipc$dispatch("984102517", new Object[]{this, Long.valueOf(j), str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e(gb.PROJECT_PAGE, "center", str, hashMap, Boolean.TRUE);
    }

    public void X1(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-694238928")) {
            ipChange.ipc$dispatch("-694238928", new Object[]{this, view, str});
        } else if (view == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", str);
            cn.damai.common.user.c.e().G(view, "award_share", "top", gb.PROJECT_PAGE, hashMap);
        }
    }

    public a.b Y(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-304013160")) {
            return (a.b) ipChange.ipc$dispatch("-304013160", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", str);
        return e(ORDER_LIST_PAGE, "tabbar", "order_receipt", hashMap, Boolean.FALSE);
    }

    public a.b Y0(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2126223755")) {
            return (a.b) ipChange.ipc$dispatch("-2126223755", new Object[]{this, str, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("usercode", z20.E());
        return e(gb.PROJECT_PAGE, "score", "evaluate_" + i, hashMap, Boolean.FALSE);
    }

    public void Y1(View view, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1206794302")) {
            ipChange.ipc$dispatch("1206794302", new Object[]{this, view, str, str2});
        } else if (view == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", str);
            hashMap.put("titlelabel", str2);
            cn.damai.common.user.c.e().G(view, "remind_tips", "bottom", gb.PROJECT_PAGE, hashMap);
        }
    }

    public a.b Z(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "175266783")) {
            return (a.b) ipChange.ipc$dispatch("175266783", new Object[]{this, str});
        }
        a.b bVar = new a.b();
        if (str == null) {
            str = "0";
        }
        return bVar.h(str).i(ORDER_PROGRESS_PAGE);
    }

    public a.b Z0(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-523996299")) {
            return (a.b) ipChange.ipc$dispatch("-523996299", new Object[]{this, str, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("usercode", z20.E());
        return e(gb.PROJECT_PAGE, "score", "tags_" + i, hashMap, Boolean.FALSE);
    }

    public a.b Z1(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1704070674")) {
            return (a.b) ipChange.ipc$dispatch("1704070674", new Object[]{this, str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("preemption_stage", str2);
        hashMap.put("preemption_btn_status", str3);
        return e(gb.PROJECT_PAGE, "preemption_area", "exchangebtn", hashMap, Boolean.FALSE);
    }

    public a.b a0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "707191057")) {
            return (a.b) ipChange.ipc$dispatch("707191057", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e(gb.PROJECT_PAGE, ILocatable.ADDRESS, "item", hashMap, Boolean.TRUE);
    }

    public a.b a1(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2033803768")) {
            return (a.b) ipChange.ipc$dispatch("-2033803768", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("usercode", z20.E());
        return e(gb.PROJECT_PAGE, "top", "award_share", hashMap, Boolean.TRUE);
    }

    public void a2(View view, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-44782862")) {
            ipChange.ipc$dispatch("-44782862", new Object[]{this, view, str, str2, str3});
        } else if (view == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", str);
            hashMap.put("preemption_stage", str2);
            hashMap.put("preemption_btn_status", str3);
            cn.damai.common.user.c.e().G(view, "exchangebtn", "preemption_area", gb.PROJECT_PAGE, hashMap);
        }
    }

    public void b0(int i, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1410490604")) {
            ipChange.ipc$dispatch("1410490604", new Object[]{this, Integer.valueOf(i), Long.valueOf(j)});
            return;
        }
        a.b bVar = null;
        if (i == 0) {
            bVar = c0(j);
        } else if (i == 1) {
            bVar = d0(j);
        } else if (i == 2) {
            bVar = e0(j);
        } else if (i == 3) {
            bVar = f0(j);
        }
        cn.damai.common.user.c.e().x(bVar);
    }

    public a.b b1() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "85610656") ? (a.b) ipChange.ipc$dispatch("85610656", new Object[]{this}) : b(ORDER_LIST_PAGE);
    }

    public a.b b2(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-473987797")) {
            return (a.b) ipChange.ipc$dispatch("-473987797", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        return e(gb.PROJECT_PAGE, "bottom", "resetaudiencealert", hashMap, Boolean.FALSE);
    }

    public a.b c0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1568581193")) {
            return (a.b) ipChange.ipc$dispatch("-1568581193", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e(gb.PROJECT_PAGE, "anchor", "details", hashMap, Boolean.FALSE);
    }

    public a.b c1(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "868925103")) {
            return (a.b) ipChange.ipc$dispatch("868925103", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("remind_type", str2);
        hashMap.put("is_exclusivepurchase", "1");
        return e(gb.PROJECT_PAGE, "preemption_area", "addtoremind", hashMap, Boolean.FALSE);
    }

    public void c2(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1648549579")) {
            ipChange.ipc$dispatch("1648549579", new Object[]{this, view, str});
        } else if (view == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", str);
            cn.damai.common.user.c.e().G(view, "resetaudiencealert", "bottom", gb.PROJECT_PAGE, hashMap);
        }
    }

    public a.b d0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-448889444")) {
            return (a.b) ipChange.ipc$dispatch("-448889444", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e(gb.PROJECT_PAGE, "anchor", PROJECT_EVALUATE, hashMap, Boolean.FALSE);
    }

    public a.b d1(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1995455089") ? (a.b) ipChange.ipc$dispatch("-1995455089", new Object[]{this, str}) : new a.b().d(str).i(PROJECT_FILL_INFORMATION);
    }

    public void d2(View view, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-958495673")) {
            ipChange.ipc$dispatch("-958495673", new Object[]{this, view, str, str2});
        } else if (view == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("usercode", z20.i());
            hashMap.put("item_id", str);
            hashMap.put("score", str2);
            cn.damai.common.user.c.e().G(view, "score_description", "center", gb.PROJECT_PAGE, hashMap);
        }
    }

    public a.b e0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1440167003")) {
            return (a.b) ipChange.ipc$dispatch("1440167003", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e(gb.PROJECT_PAGE, "anchor", "notice", hashMap, Boolean.FALSE);
    }

    public a.b e1(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1175526607") ? (a.b) ipChange.ipc$dispatch("-1175526607", new Object[]{this, str}) : new a.b().d(str).i(PROJECT_TICKET_STRATEGY);
    }

    public void e2(View view, String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1686091540")) {
            ipChange.ipc$dispatch("1686091540", new Object[]{this, view, str, str2, Integer.valueOf(i)});
        } else if (view == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", str);
            hashMap.put("titlelabel", str2);
            cn.damai.common.user.c e = cn.damai.common.user.c.e();
            e.G(view, "tags_" + i, "score", gb.PROJECT_PAGE, hashMap);
        }
    }

    public a.b f0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1878347151")) {
            return (a.b) ipChange.ipc$dispatch("-1878347151", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e(gb.PROJECT_PAGE, "anchor", "recommend", hashMap, Boolean.FALSE);
    }

    public a.b f1(long j, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2075257394")) {
            return (a.b) ipChange.ipc$dispatch("-2075257394", new Object[]{this, Long.valueOf(j), Boolean.valueOf(z)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        hashMap.put("usercode", z20.E());
        return e(gb.PROJECT_PAGE, "top", Constants.Event.RETURN, hashMap, Boolean.valueOf(z));
    }

    public void f2(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "297884280")) {
            ipChange.ipc$dispatch("297884280", new Object[]{this, view, str});
        } else {
            R1("seatmap", view, str);
        }
    }

    public a.b g0(String str, String str2, String str3, int i, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2006232765")) {
            return (a.b) ipChange.ipc$dispatch("-2006232765", new Object[]{this, str, str2, str3, Integer.valueOf(i), str4});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("biz_type", str2);
        hashMap.put("biz_id", str3);
        hashMap.put("project_category", str4);
        return e(gb.PROJECT_PAGE, StarIndexFragment.Default_PAGE, "artistdetail_" + i, hashMap, Boolean.TRUE);
    }

    public a.b g1(long j, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "122531825")) {
            return (a.b) ipChange.ipc$dispatch("122531825", new Object[]{this, Long.valueOf(j), Boolean.valueOf(z)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e(gb.PROJECT_PAGE, "top", "license_tag", hashMap, Boolean.valueOf(z));
    }

    public void g2(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-781605252")) {
            ipChange.ipc$dispatch("-781605252", new Object[]{this, view, str});
        } else {
            Q1("select", view, str);
        }
    }

    public a.b h0(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1126814820")) {
            return (a.b) ipChange.ipc$dispatch("-1126814820", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("item_id", String.valueOf(str));
        return e(gb.PROJECT_PAGE, "center", gh1.MODULE_BANNER, hashMap, Boolean.TRUE);
    }

    public a.b h1(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1547215759")) {
            return (a.b) ipChange.ipc$dispatch("-1547215759", new Object[]{this, str, str2, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", str);
        hashMap.put("orderid", str2);
        return e(ORDER_LIST_PAGE, "order_info", "orderinfo_" + i, hashMap, Boolean.TRUE);
    }

    public void h2(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "95765916")) {
            ipChange.ipc$dispatch("95765916", new Object[]{this, view, str});
        } else if (view == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", str);
            cn.damai.common.user.c.e().G(view, "servicedivbtn", "center", gb.PROJECT_PAGE, hashMap);
        }
    }

    public a.b i0(long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2432545") ? (a.b) ipChange.ipc$dispatch("-2432545", new Object[]{this, Long.valueOf(j)}) : f(j, gb.PROJECT_PAGE);
    }

    public a.b i1(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1244477656")) {
            return (a.b) ipChange.ipc$dispatch("1244477656", new Object[]{this, str, str2, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", str);
        hashMap.put("orderid", str2);
        return e(ORDER_LIST_PAGE, "order_info", "refund_info_" + i, hashMap, Boolean.TRUE);
    }

    public a.b i2(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1935258431")) {
            return (a.b) ipChange.ipc$dispatch("1935258431", new Object[]{this, str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("preemption_stage", str2);
        hashMap.put("preemption_btn_status", str3);
        hashMap.put("is_exclusivepurchase", "1");
        return e(gb.PROJECT_PAGE, "preemption_area", "exchangebtn", hashMap, Boolean.FALSE);
    }

    public a.b j(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1490305651")) {
            return (a.b) ipChange.ipc$dispatch("1490305651", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("orderid", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("item_id", str2);
        return e(ORDER_MODIFY_ADDRESS_PAGE, "pop", "cancel", hashMap, Boolean.FALSE);
    }

    public a.b j0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1403908304")) {
            return (a.b) ipChange.ipc$dispatch("-1403908304", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e(gb.PROJECT_PAGE, "bottom", "buy", hashMap, Boolean.TRUE);
    }

    public a.b j1(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1441043553")) {
            return (a.b) ipChange.ipc$dispatch("1441043553", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("orderid", str2);
        return e(ORDER_DETAL_PAGE, "invoice", HN_ORDER_CREATE_INVOICE_PAGE, hashMap, Boolean.TRUE);
    }

    public void j2(View view, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "480653663")) {
            ipChange.ipc$dispatch("480653663", new Object[]{this, view, str, str2, str3});
        } else if (view == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", str);
            hashMap.put("preemption_stage", str2);
            hashMap.put("preemption_btn_status", str3);
            hashMap.put("is_exclusivepurchase", "1");
            cn.damai.common.user.c.e().G(view, "exchangebtn", "preemption_area", gb.PROJECT_PAGE, hashMap);
        }
    }

    public a.b k(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2130668533")) {
            return (a.b) ipChange.ipc$dispatch("-2130668533", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("orderid", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("item_id", str2);
        return e(ORDER_MODIFY_ADDRESS_PAGE, "pop", "confirm", hashMap, Boolean.FALSE);
    }

    public a.b k0(long j, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-762306418")) {
            return (a.b) ipChange.ipc$dispatch("-762306418", new Object[]{this, Long.valueOf(j), Boolean.valueOf(z)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        hashMap.put("titlelabel", z ? "1" : "0");
        return e(gb.PROJECT_PAGE, "top", "favorite", hashMap, Boolean.FALSE);
    }

    public a.b k1(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "760228373")) {
            return (a.b) ipChange.ipc$dispatch("760228373", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("orderid", str2);
        return e(ORDER_DETAL_PAGE, "invoice", ORDER_INVOICE_DETAIL_PAGE, hashMap, Boolean.TRUE);
    }

    public void k2(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-793505200")) {
            ipChange.ipc$dispatch("-793505200", new Object[]{this, view, str});
        } else {
            Q1("stock_checkin", view, str);
        }
    }

    public void l(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "443728292")) {
            ipChange.ipc$dispatch("443728292", new Object[]{this, str, str2});
            return;
        }
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("orderid", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("item_id", str2);
        cn.damai.common.user.c.e().C("confirm", "pop", ORDER_MODIFY_ADDRESS_PAGE, "1.0", 3000L, hashMap, 2201);
    }

    public a.b l0(long j, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-101671840")) {
            return (a.b) ipChange.ipc$dispatch("-101671840", new Object[]{this, Long.valueOf(j), Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e(gb.PROJECT_PAGE, "commonproblem", "commonproblem_" + i, hashMap, Boolean.TRUE);
    }

    public a.b l1(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1330454156")) {
            return (a.b) ipChange.ipc$dispatch("-1330454156", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("orderid", str2);
        return e(ORDER_MODIFY_ADDRESS_PAGE, "new_address", kb0.DM_ADDRESS_LIST_PAGE, hashMap, Boolean.TRUE);
    }

    public void l2(View view, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "439692882")) {
            ipChange.ipc$dispatch("439692882", new Object[]{this, view, str, Integer.valueOf(i)});
            return;
        }
        R1("tour_item_" + i, view, str);
    }

    public void m(View view, String str, InFieldCommentsBean inFieldCommentsBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "153947558")) {
            ipChange.ipc$dispatch("153947558", new Object[]{this, view, str, inFieldCommentsBean, Integer.valueOf(i)});
        } else if (view == null || str == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", str);
            String str2 = "item_";
            if (inFieldCommentsBean.isTypeStrategy()) {
                hashMap.put("content_id", inFieldCommentsBean.id);
            } else if (inFieldCommentsBean.isTypeGROUP()) {
                hashMap.put("tips_id", inFieldCommentsBean.id);
                str2 = "item_pro_";
            }
            cn.damai.common.user.c e = cn.damai.common.user.c.e();
            e.G(view, str2 + i, "tips", gb.PROJECT_PAGE, hashMap);
        }
    }

    public a.b m0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-74009709")) {
            return (a.b) ipChange.ipc$dispatch("-74009709", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e(gb.PROJECT_PAGE, "commonproblem", "commonproblem_more", hashMap, Boolean.TRUE);
    }

    public a.b m1(String str, String str2, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1566852628")) {
            return (a.b) ipChange.ipc$dispatch("-1566852628", new Object[]{this, str, str2, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("remind_type", str2);
        hashMap.put("sellStartTime", j + "");
        if (str == null) {
            str = "";
        }
        hashMap.put("item_id", str);
        return e(ORDER_DETAL_PAGE, "top", "remindme", hashMap, Boolean.FALSE);
    }

    public void m2(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-153935648")) {
            ipChange.ipc$dispatch("-153935648", new Object[]{this, view, str});
        } else {
            R1("venuenamebtn", view, str);
        }
    }

    public a.b n(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-46715559")) {
            return (a.b) ipChange.ipc$dispatch("-46715559", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        hashMap.put("usercode", z20.E());
        return e(gb.PROJECT_PAGE, "remindme", "addtocalendar", hashMap, Boolean.FALSE);
    }

    public a.b n0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1389602744")) {
            return (a.b) ipChange.ipc$dispatch("-1389602744", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e(gb.PROJECT_PAGE, PROJECT_EVALUATE, "evaluate_list", hashMap, Boolean.TRUE);
    }

    public a.b n1(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-321989047")) {
            return (a.b) ipChange.ipc$dispatch("-321989047", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("item_id", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("orderid", str2);
        return e(ORDER_DETAL_PAGE, "purchase_service", "close", hashMap, Boolean.FALSE);
    }

    public void n2(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "515381609")) {
            ipChange.ipc$dispatch("515381609", new Object[]{this, view, str});
        } else {
            Q1("vipbuy", view, str);
        }
    }

    public a.b o(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1058849926")) {
            return (a.b) ipChange.ipc$dispatch("1058849926", new Object[]{this, str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("remind_type", str2);
        hashMap.put(TLogEventConst.PARAM_UPLOAD_STAGE, str3);
        return e(gb.PROJECT_PAGE, "preemption_area", "addtoremind", hashMap, Boolean.FALSE);
    }

    public a.b o0(String str, long j, String str2, String str3, String str4, String str5, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "16354652")) {
            return (a.b) ipChange.ipc$dispatch("16354652", new Object[]{this, str, Long.valueOf(j), str2, str3, str4, str5, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        hashMap.put("usercode", str);
        hashMap.put("titlelabel", str2 + "&" + str4);
        hashMap.put("circle_id", str3);
        hashMap.put("commenttype", String.valueOf(str5));
        return e(gb.PROJECT_PAGE, PROJECT_EVALUATE, "enter_circle_" + i, hashMap, Boolean.TRUE);
    }

    public a.b o1(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-416582553")) {
            return (a.b) ipChange.ipc$dispatch("-416582553", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("item_id", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("orderid", str2);
        return e(ORDER_DETAL_PAGE, "bottom", "quicklydistributionbtn", hashMap, Boolean.FALSE);
    }

    public void o2(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "606824227")) {
            ipChange.ipc$dispatch("606824227", new Object[]{this, view, str});
        } else {
            R1(PROJECT_PAGE_WARM_PROMPT, view, str);
        }
    }

    public a.b p(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "291524800")) {
            return (a.b) ipChange.ipc$dispatch("291524800", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        hashMap.put("usercode", z20.E());
        return e(gb.PROJECT_PAGE, "remindme", "cancel", hashMap, Boolean.FALSE);
    }

    public a.b p0(String str, long j, String str2, String str3, String str4, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-394757581")) {
            return (a.b) ipChange.ipc$dispatch("-394757581", new Object[]{this, str, Long.valueOf(j), str2, str3, str4, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        hashMap.put("usercode", str);
        hashMap.put("titlelabel", str2 + "&" + str3);
        hashMap.put("commenttype", String.valueOf(str4));
        return e(gb.PROJECT_PAGE, PROJECT_EVALUATE, "comment_" + i, hashMap, Boolean.TRUE);
    }

    public a.b p1(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1316163057")) {
            return (a.b) ipChange.ipc$dispatch("-1316163057", new Object[]{this, str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("item_id", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("orderid", str2);
        hashMap.put("order_status", str3);
        return e(ORDER_DETAL_PAGE, ORDER_PROGRESS_PAGE, "open", hashMap, Boolean.TRUE);
    }

    public void p2(View view, String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1759735383")) {
            ipChange.ipc$dispatch("1759735383", new Object[]{this, view, str, Long.valueOf(j)});
        } else if (view != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", str);
            hashMap.put("titlelabel", j + "");
            cn.damai.common.user.c.e().G(view, "favorite_cnt", "center", gb.PROJECT_PAGE, hashMap);
        }
    }

    public a.b q0(String str, long j, String str2, String str3, String str4, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "518644327")) {
            return (a.b) ipChange.ipc$dispatch("518644327", new Object[]{this, str, Long.valueOf(j), str2, str3, str4, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        hashMap.put("usercode", str);
        hashMap.put("titlelabel", str2 + "&" + str3);
        hashMap.put("commenttype", String.valueOf(str4));
        return e(gb.PROJECT_PAGE, PROJECT_EVALUATE, "release_pages_" + i, hashMap, Boolean.FALSE);
    }

    public a.b q1(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1602255781")) {
            return (a.b) ipChange.ipc$dispatch("-1602255781", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("item_id", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("orderid", str2);
        return e(ORDER_DETAL_PAGE, "purchase_service", "open", hashMap, Boolean.FALSE);
    }

    public void q2(View view, String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1025507223")) {
            ipChange.ipc$dispatch("1025507223", new Object[]{this, view, str, Boolean.valueOf(z)});
        } else if (view == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", str);
            hashMap.put("type", gb.PROJECT_PAGE);
            hashMap.put("titlelabel", z ? BQCCameraParam.VALUE_YES : "no");
            cn.damai.common.user.c.e().G(view, "favorite", "bottom", gb.PROJECT_PAGE, hashMap);
        }
    }

    public a.b r(String str, int i, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "507069402")) {
            return (a.b) ipChange.ipc$dispatch("507069402", new Object[]{this, str, Integer.valueOf(i), str2, str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        hashMap.put("item_id", str2);
        hashMap.put("orderid", str3);
        return e(PROJECT_SCRIPTKILL_ORDRR_DETAILS_PAGE, "bottom", "pay_" + i, hashMap, Boolean.FALSE);
    }

    public a.b r0(String str, long j, String str2, String str3, String str4, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "491889791")) {
            return (a.b) ipChange.ipc$dispatch("491889791", new Object[]{this, str, Long.valueOf(j), str2, str3, str4, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        hashMap.put("usercode", str);
        hashMap.put("titlelabel", str2 + "&" + str3);
        hashMap.put("commenttype", String.valueOf(str4));
        return e(gb.PROJECT_PAGE, PROJECT_EVALUATE, "likes_" + i, hashMap, Boolean.FALSE);
    }

    public a.b r1(String str, String str2, String str3, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1518636855")) {
            return (a.b) ipChange.ipc$dispatch("-1518636855", new Object[]{this, str, str2, str3, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("item_id", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("orderid", str2);
        hashMap.put("titlelabel", str3);
        return e(ORDER_DETAL_PAGE, "question", "item_" + i, hashMap, Boolean.TRUE);
    }

    public void r2(View view, String str, String str2, String str3, int i, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2040086514")) {
            ipChange.ipc$dispatch("-2040086514", new Object[]{this, view, str, str2, str3, Integer.valueOf(i), str4});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("biz_type", str2);
        hashMap.put("biz_id", str3);
        hashMap.put("project_category", str4);
        cn.damai.common.user.c e = cn.damai.common.user.c.e();
        e.G(view, "artistdetail_" + i, StarIndexFragment.Default_PAGE, gb.PROJECT_PAGE, hashMap);
    }

    public a.b s() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "899271442") ? (a.b) ipChange.ipc$dispatch("899271442", new Object[]{this}) : new a.b().i(ORDER_INVOICE_DETAIL_PAGE);
    }

    public a.b s0(long j, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1625294514")) {
            return (a.b) ipChange.ipc$dispatch("-1625294514", new Object[]{this, Long.valueOf(j), str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        hashMap.put("usercode", str);
        hashMap.put("titlelabel", str2);
        return e(gb.PROJECT_PAGE, PROJECT_EVALUATE, "my_comment", hashMap, Boolean.TRUE);
    }

    public a.b s1(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "962025393")) {
            return (a.b) ipChange.ipc$dispatch("962025393", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("orderid", str);
        hashMap.put("usercode", z20.E());
        return e(ORDER_DETAL_PAGE, "center", "resell", hashMap, Boolean.FALSE);
    }

    public void s2(View view, String str, List<PromotionItemBean> list) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "395933185")) {
            ipChange.ipc$dispatch("395933185", new Object[]{this, view, str, list});
        } else if (view != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", str);
            hashMap.put("usercode", z20.E());
            if (!cb2.d(list)) {
                StringBuffer stringBuffer = new StringBuffer();
                for (PromotionItemBean promotionItemBean : list) {
                    if (promotionItemBean != null) {
                        stringBuffer.append(promotionItemBean.type);
                        if (i < list.size() - 1) {
                            stringBuffer.append(",");
                        }
                    }
                    i++;
                }
                if (!TextUtils.isEmpty(stringBuffer.toString())) {
                    hashMap.put("discount_type", stringBuffer.toString());
                }
            }
            cn.damai.common.user.c.e().G(view, "entrance", "top", gb.PROJECT_PAGE, hashMap);
        }
    }

    public a.b t(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1729058237")) {
            return (a.b) ipChange.ipc$dispatch("1729058237", new Object[]{this, str});
        }
        a.b bVar = new a.b();
        if (str == null) {
            str = "0";
        }
        return bVar.h(str).i(ORDER_DETAL_PAGE);
    }

    public a.b t0(String str, long j, String str2, String str3, String str4, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1073247999")) {
            return (a.b) ipChange.ipc$dispatch("-1073247999", new Object[]{this, str, Long.valueOf(j), str2, str3, str4, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        hashMap.put("usercode", str);
        hashMap.put("titlelabel", str2 + "&" + str3);
        hashMap.put("commenttype", String.valueOf(str4));
        return e(gb.PROJECT_PAGE, PROJECT_EVALUATE, "sharecomment_" + i, hashMap, Boolean.TRUE);
    }

    public a.b t1(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1343438321")) {
            return (a.b) ipChange.ipc$dispatch("-1343438321", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("orderid", str);
        hashMap.put("usercode", z20.E());
        return e(ORDER_DETAL_PAGE, "resell", "agree", hashMap, Boolean.FALSE);
    }

    public void t2(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "664965211")) {
            ipChange.ipc$dispatch("664965211", new Object[]{this, view, str});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("item_id", str);
        cn.damai.common.user.c.e().G(view, "ranklist", "center", gb.PROJECT_PAGE, hashMap);
    }

    public a.b u0(String str, long j, String str2, String str3, String str4, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-747697022")) {
            return (a.b) ipChange.ipc$dispatch("-747697022", new Object[]{this, str, Long.valueOf(j), str2, str3, str4, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        hashMap.put("usercode", str);
        hashMap.put("titlelabel", str2 + "&" + str3);
        hashMap.put("commenttype", String.valueOf(str4));
        return e(gb.PROJECT_PAGE, PROJECT_EVALUATE, "evaluate_pic_" + i, hashMap, Boolean.TRUE);
    }

    public a.b u1(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2002149216")) {
            return (a.b) ipChange.ipc$dispatch("-2002149216", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("orderid", str);
        hashMap.put("usercode", z20.E());
        return e(ORDER_DETAL_PAGE, "center", "check_resell", hashMap, Boolean.FALSE);
    }

    public void u2(View view, long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-272699795")) {
            ipChange.ipc$dispatch("-272699795", new Object[]{this, view, Long.valueOf(j), str});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        cn.damai.common.user.c.e().G(view, str, "center", gb.PROJECT_PAGE, hashMap);
    }

    public a.b v(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1044208574")) {
            return (a.b) ipChange.ipc$dispatch("1044208574", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        hashMap.put("usercode", z20.E());
        return e(gb.PROJECT_PAGE, "details", "video", hashMap, Boolean.TRUE);
    }

    public a.b v0(String str, long j, String str2, String str3, String str4, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-407473054")) {
            return (a.b) ipChange.ipc$dispatch("-407473054", new Object[]{this, str, Long.valueOf(j), str2, str3, str4, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        hashMap.put("usercode", str);
        hashMap.put("titlelabel", str2 + "&" + str3);
        hashMap.put("commenttype", String.valueOf(str4));
        return e(gb.PROJECT_PAGE, PROJECT_EVALUATE, "reply_" + i, hashMap, Boolean.TRUE);
    }

    public a.b v1(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1961389715")) {
            return (a.b) ipChange.ipc$dispatch("1961389715", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("orderid", str);
        hashMap.put("usercode", z20.E());
        return e(ORDER_DETAL_PAGE, "resell", "disagree", hashMap, Boolean.FALSE);
    }

    public void v2(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-428691504")) {
            ipChange.ipc$dispatch("-428691504", new Object[]{this, view, str});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("item_id", str);
        cn.damai.common.user.c.e().G(view, PROJECT_TICKET_STRATEGY, "center", gb.PROJECT_PAGE, hashMap);
    }

    public a.b w(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "429831559")) {
            return (a.b) ipChange.ipc$dispatch("429831559", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e(gb.PROJECT_PAGE, "bottom", "gotoopen_tips", hashMap, Boolean.TRUE);
    }

    public a.b w0(String str, long j, String str2, String str3, String str4, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1597930770")) {
            return (a.b) ipChange.ipc$dispatch("1597930770", new Object[]{this, str, Long.valueOf(j), str2, str3, str4, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        hashMap.put("usercode", str);
        hashMap.put("titlelabel", str2 + "&" + str3);
        hashMap.put("commenttype", String.valueOf(str4));
        return e(gb.PROJECT_PAGE, PROJECT_EVALUATE, "portrait_" + i, hashMap, Boolean.TRUE);
    }

    public a.b w1(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1798294405")) {
            return (a.b) ipChange.ipc$dispatch("-1798294405", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("item_id", str);
        hashMap.put(SocialConstants.PARAM_APP_DESC, str2);
        return e(ORDER_DETAL_PAGE, "center", "seatmap", hashMap, Boolean.FALSE);
    }

    public void w2(View view, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1365006886")) {
            ipChange.ipc$dispatch("-1365006886", new Object[]{this, view, str, str2});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("item_id", str);
        hashMap.put("titlelabel", str2);
        cn.damai.common.user.c.e().G(view, "venuenamebtn", "center", gb.PROJECT_PAGE, hashMap);
    }

    public a.b x(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1802237653")) {
            return (a.b) ipChange.ipc$dispatch("1802237653", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        return e(ORDER_DETAL_PAGE, "problem", "aftersalesservice", hashMap, Boolean.TRUE);
    }

    public a.b x0(long j, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1166296487")) {
            return (a.b) ipChange.ipc$dispatch("1166296487", new Object[]{this, Long.valueOf(j), Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e(gb.PROJECT_PAGE, "details", "projectposter_" + i, hashMap, Boolean.TRUE);
    }

    public a.b x1(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1741756119")) {
            return (a.b) ipChange.ipc$dispatch("1741756119", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("item_id", str);
        hashMap.put("usercode", z20.E());
        return e(ORDER_DETAL_PAGE, "center", "award_share", hashMap, Boolean.TRUE);
    }

    public a.b x2(String str, InFieldCommentsBean inFieldCommentsBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-506389170")) {
            return (a.b) ipChange.ipc$dispatch("-506389170", new Object[]{this, str, inFieldCommentsBean, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        String str2 = "item_";
        if (inFieldCommentsBean.isTypeStrategy()) {
            hashMap.put("content_id", inFieldCommentsBean.id);
        } else if (inFieldCommentsBean.isTypeGROUP()) {
            hashMap.put("tips_id", inFieldCommentsBean.id);
            str2 = "item_pro_";
        }
        return e(gb.PROJECT_PAGE, "tips", str2 + i, hashMap, Boolean.TRUE);
    }

    public a.b y(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-989915306")) {
            return (a.b) ipChange.ipc$dispatch("-989915306", new Object[]{this, str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("item_id", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("orderid", str2);
        if (str3 == null) {
            str3 = "";
        }
        hashMap.put("titlelabel", str3);
        return e(ORDER_DETAL_PAGE, "banners", "bannerimg", hashMap, Boolean.TRUE);
    }

    public a.b y0(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-314936264")) {
            return (a.b) ipChange.ipc$dispatch("-314936264", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e(gb.PROJECT_PAGE, "details", "moreitem", hashMap, Boolean.FALSE);
    }

    public a.b y1(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1369777806")) {
            return (a.b) ipChange.ipc$dispatch("-1369777806", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("orderid", str);
        return e(ORDER_PROGRESS_PAGE, "order_info", "choose_seat", hashMap, Boolean.TRUE);
    }

    public a.b y2(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1150797089")) {
            return (a.b) ipChange.ipc$dispatch("-1150797089", new Object[]{this, str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("orderid", str2);
        if (str3 == null) {
            str3 = "";
        }
        hashMap.put("titlelabel", str3);
        return e(ORDER_MODIFY_ADDRESS_PAGE, "bottom", "save", hashMap, Boolean.FALSE);
    }

    public a.b z(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1111123597")) {
            return (a.b) ipChange.ipc$dispatch("1111123597", new Object[]{this, str, str2});
        }
        a.b d = new a.b().d(str);
        if (str2 == null) {
            str2 = "0";
        }
        return d.h(str2).i(ORDER_DETAL_PAGE);
    }

    public a.b z0(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1304661149")) {
            return (a.b) ipChange.ipc$dispatch("1304661149", new Object[]{this, str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(str));
        return e(gb.PROJECT_PAGE, str2, str3, hashMap, Boolean.TRUE);
    }

    public a.b z1(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1332698929")) {
            return (a.b) ipChange.ipc$dispatch("-1332698929", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("orderid", str);
        return e(ORDER_PROGRESS_PAGE, "order_info", "remind", hashMap, Boolean.FALSE);
    }

    public a.b z2(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-413629707")) {
            return (a.b) ipChange.ipc$dispatch("-413629707", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("usercode", z20.E());
        return e(PROJECT_TICKET_STRATEGY, "center", PROJECT_FILL_INFORMATION, hashMap, Boolean.TRUE);
    }
}
