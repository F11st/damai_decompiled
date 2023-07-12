package cn.damai.commonbusiness.seatbiz.sku.xflush;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.b23;
import tb.pl;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ProjectDetailXFlushUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public enum PopLayerErrorType {
        TYPE_SKU_LOAD_FAIL,
        TYPE_COUPON_LIST,
        TYPE_COUPON_APPLY
    }

    private static String a(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1078935541")) {
            return (String) ipChange.ipc$dispatch("-1078935541", new Object[]{str, str2, str3, str4});
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

    public static void b(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "540633525")) {
            ipChange.ipc$dispatch("540633525", new Object[]{str, str2, str3});
            return;
        }
        b23.a(a(str2, str3, "mtop.alibaba.detail.subpage.getdetail", str), "-3100", "SKU接口加载失败 Uid:" + z20.E());
    }
}
