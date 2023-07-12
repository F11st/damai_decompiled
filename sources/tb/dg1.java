package tb;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class dg1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String BRANCH_NAME = "mine";
    public static final String MINE_ADDRESSMANAGE_ERROR_CODE = "-7101";
    public static final String MINE_ADDRESSMANAGE_ERROR_MSG = "管理地址失败（新增，修改，删除)";
    public static final String MINE_COIN_ERROR_CODE = "-7201";
    public static final String MINE_COIN_ERROR_MSG = "积分查询失败";
    public static final String MINE_COPONLIST_ERROR_CODE = "-7200";
    public static final String MINE_COPONLIST_ERROR_MSG = "优惠券加载失败";

    public static void a(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1501478654")) {
            ipChange.ipc$dispatch("1501478654", new Object[]{str, str2});
        } else {
            b23.a(d("mtop.damai.wireless.mkt.coupon.queryCouponsOfUser", str, str2), MINE_COPONLIST_ERROR_CODE, MINE_COPONLIST_ERROR_MSG);
        }
    }

    public static void b(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "944172011")) {
            ipChange.ipc$dispatch("944172011", new Object[]{str, str2});
        } else {
            b23.a(d("mtop.damai.wireless.user.shippingaddress.del", str, str2), MINE_ADDRESSMANAGE_ERROR_CODE, MINE_ADDRESSMANAGE_ERROR_MSG);
        }
    }

    public static void c(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-458326026")) {
            ipChange.ipc$dispatch("-458326026", new Object[]{str, str2});
        } else {
            b23.a(d("mtop.damai.wireless.score.getlist", str, str2), MINE_COIN_ERROR_CODE, MINE_COIN_ERROR_MSG);
        }
    }

    public static String d(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-990053367")) {
            return (String) ipChange.ipc$dispatch("-990053367", new Object[]{str, str2, str3});
        }
        StringBuilder sb = new StringBuilder();
        sb.append("mine");
        sb.append(":jsondata={apiName: ");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        sb.append(str);
        sb.append(", retCode: ");
        if (TextUtils.isEmpty(str2)) {
            str2 = "0";
        }
        sb.append(str2);
        sb.append(", retMsg: ");
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", loginKey: ");
        sb.append(TextUtils.isEmpty(z20.q()) ? "" : z20.q());
        sb.append("}");
        return sb.toString();
    }
}
