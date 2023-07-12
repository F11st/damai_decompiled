package tb;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ap1 extends qa {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void b(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1403897927")) {
            ipChange.ipc$dispatch("1403897927", new Object[]{str, str2, str3, str4, str5});
            return;
        }
        b23.g(qa.a(str, str2, str3, "orderId:" + str4 + ",fromWhere:" + str5), "-4431", "订单详情底部按键接口错误");
    }

    public static void c(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1887949784")) {
            ipChange.ipc$dispatch("-1887949784", new Object[]{str, str2, str3, str4});
            return;
        }
        b23.g(qa.a(str, str2, str3, "orderId:" + str4), "-4420", "订单详情接口错误");
    }

    public static void d(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-274719464")) {
            ipChange.ipc$dispatch("-274719464", new Object[]{str, str2, str3, str4});
        } else {
            b23.g(qa.a(str, str2, str3, str4), "-4450", "发票模块");
        }
    }

    public static void e(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-955265231")) {
            ipChange.ipc$dispatch("-955265231", new Object[]{str, str2, str3});
        } else {
            b23.h("order_list", qa.a(str, str2, str3, null), "-4400", "订单列表接口错误");
        }
    }

    public static void f(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "425629259")) {
            ipChange.ipc$dispatch("425629259", new Object[]{str, str2, str3, str4});
        } else {
            b23.g(qa.a(str, str2, str3, str4), "-4460", "修改配送地址模块");
        }
    }

    public static void g(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "804370868")) {
            ipChange.ipc$dispatch("804370868", new Object[]{str, str2, str3});
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("pay:jsonData={");
        sb.append(qa.ERROR_CODE);
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        sb.append(str);
        sb.append(",retMsg:");
        sb.append(str2);
        sb.append(",orderId:");
        sb.append(str3);
        sb.append(",fromWhere:战狼-银联支付失败");
        sb.append("}");
        b23.a(sb.toString(), "-4340", "支付失败—SDK错误");
    }
}
