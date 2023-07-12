package cn.damai.trade.newtradeorder.ui.projectdetail.xflush;

import android.text.TextUtils;
import cn.damai.network.ApiConstant;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.b23;
import tb.e11;
import tb.gb;
import tb.pl;
import tb.wv1;
import tb.z20;
import tb.zr;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectDetailXFlushUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public enum BuyBtnErrorType {
        TYPE_NOT_DISPLAY_ERROR,
        TYPE_LINK_NULL_ERROR,
        TYPE_COUNT_DOWN_ERROR
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public enum PopLayerErrorType {
        TYPE_SKU_LOAD_FAIL,
        TYPE_COUPON_LIST,
        TYPE_COUPON_APPLY
    }

    private static String a(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1918032232")) {
            return (String) ipChange.ipc$dispatch("1918032232", new Object[]{str, str2, str3, str4, str5});
        }
        StringBuilder sb = new StringBuilder();
        sb.append(pl.PROJECT_DETAIL_PAGE);
        sb.append(":jsondata={");
        sb.append(", errorType:");
        sb.append("从首页跳转到详情页项目不存在");
        sb.append(", projectId:");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        sb.append(str);
        sb.append(", projectName: ");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        sb.append(str2);
        sb.append(", retCode: ");
        if (TextUtils.isEmpty(str4)) {
            str4 = "0";
        }
        sb.append(str4);
        sb.append(", retMsg:");
        if (TextUtils.isEmpty(str5)) {
            str5 = "";
        }
        sb.append(str5);
        sb.append(", apiName: ");
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        sb.append(str3);
        sb.append("}");
        return sb.toString();
    }

    private static String b(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1157217874")) {
            return (String) ipChange.ipc$dispatch("1157217874", new Object[]{str, str2, str3, str4});
        }
        StringBuilder sb = new StringBuilder();
        sb.append(pl.PROJECT_DETAIL_PAGE);
        sb.append(":jsondata={");
        sb.append("apiName: ");
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", retCode: ");
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        sb.append(str);
        sb.append(", retMsg:");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        sb.append(str2);
        sb.append(", projectId:");
        if (TextUtils.isEmpty(str4)) {
            str4 = "";
        }
        sb.append(str4);
        sb.append("}");
        return sb.toString();
    }

    private static String c(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-610037385") ? (String) ipChange.ipc$dispatch("-610037385", new Object[]{str, str2, str3, str4, str5}) : a.a().b(pl.PROJECT_DETAIL_PAGE).i().a(str3).j().e(str).j().f(str2).g(str4).j().h(str5).d().c();
    }

    private static String d(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1485562138")) {
            return (String) ipChange.ipc$dispatch("-1485562138", new Object[]{str, str2, str3});
        }
        StringBuilder sb = new StringBuilder();
        sb.append(pl.PROJECT_DETAIL_PAGE);
        sb.append(":jsondata={");
        sb.append("imageUrl: ");
        if (TextUtils.isEmpty(str2)) {
            str2 = "0";
        }
        sb.append(str2);
        sb.append(", retCode: ");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        sb.append(str);
        sb.append(", projectId:");
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        sb.append(str3);
        sb.append("}");
        return sb.toString();
    }

    private static String e(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "846652900")) {
            return (String) ipChange.ipc$dispatch("846652900", new Object[]{str});
        }
        return f(str) + "详情页接口加载失败";
    }

    private static String f(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1029256575") ? (String) ipChange.ipc$dispatch("1029256575", new Object[]{str}) : wv1.c(str) ? "候鸟 " : "非候鸟 ";
    }

    private static boolean g(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1135788231") ? ((Boolean) ipChange.ipc$dispatch("-1135788231", new Object[]{str})).booleanValue() : "MAPIE98015".equals(str) || e11.FAIL_SYS_TRAFFIC_LIMIT.equals(str) || "ANDROID_SYS_NETWORK_ERROR".equals(str) || "FAIL_SYS_SERVICE_ERROR".equals(str);
    }

    public static void h(String str, String str2, String str3, String str4, String str5, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "348706105")) {
            ipChange.ipc$dispatch("348706105", new Object[]{str, str2, str3, str4, str5, Boolean.valueOf(z)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("projectId", str2);
        hashMap.put("projectName", str5);
        hashMap.put("usercode", z20.i());
        zr.INSTANCE.a().a(str).c(str3).d(str4).e(hashMap).g("商品详情页").j(gb.PROJECT_PAGE).f(z).b();
    }

    public static void i(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-251486142")) {
            ipChange.ipc$dispatch("-251486142", new Object[]{str, str2, str3});
        } else if (g(str2)) {
        } else {
            b23.a(b(str2, str3, "mtop.damai.mxm.user.accesstoken.get", str), "-3200", "获取小蜜token错误");
        }
    }

    public static void j(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1836894333")) {
            ipChange.ipc$dispatch("1836894333", new Object[]{str, str2, str3});
        } else if (g(str2)) {
        } else {
            b23.a(b(str2, str3, "mtop.damai.wireless.comment.module.get", str), "-3300", "讨论区接口加载失败");
        }
    }

    public static void k(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1496832084")) {
            ipChange.ipc$dispatch("-1496832084", new Object[]{str, str2, str3});
        } else if (g(str2)) {
        } else {
            b23.a(b(str2, str3, "mtop.damai.wireless.comment.module.get", str), "-3310", "评价接口加载失败");
        }
    }

    public static void l(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "782436728")) {
            ipChange.ipc$dispatch("782436728", new Object[]{str, str2, str3});
        } else if (g(str2)) {
        } else {
            b23.a(b(str2, str3, ApiConstant.API_NAME_RELATION_UPDATE, str), "-3210", "关注项目错误");
        }
    }

    public static void m(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1313468451")) {
            ipChange.ipc$dispatch("1313468451", new Object[]{str, str2, str3, str4, str5});
        } else if (g(str3)) {
        } else {
            b23.a(c(str3, str4, str, str2, str5), "-3000", e(str2));
        }
    }

    public static void n(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-178652161")) {
            ipChange.ipc$dispatch("-178652161", new Object[]{str, str2, str3});
        } else if (g(str)) {
        } else {
            b23.a(d(str, str2, str3), "-3001", "项目海报图加载失败");
        }
    }

    public static void o(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "345354260")) {
            ipChange.ipc$dispatch("345354260", new Object[]{str, str2, str3, str4, str5});
        } else {
            b23.a(a(str, str2, str3, str4, str5), "-3002", "详情页业务错误");
        }
    }

    public static void p(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1283275267")) {
            ipChange.ipc$dispatch("-1283275267", new Object[]{str, str2, str3});
        }
    }
}
