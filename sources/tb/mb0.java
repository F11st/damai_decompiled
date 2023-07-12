package tb;

import android.content.Context;
import android.text.TextUtils;
import cn.damai.common.net.mtop.Util;
import cn.damai.commonbusiness.address.api.AddressApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.util.ErrorConstant;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class mb0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static mb0 b;
    private List<String> a = new ArrayList();

    private mb0() {
        h();
    }

    private String e(Context context, String str, String str2, String str3, String str4) {
        String str5;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "61658720")) {
            return (String) ipChange.ipc$dispatch("61658720", new Object[]{this, context, str, str2, str3, str4});
        }
        StringBuilder sb = new StringBuilder();
        sb.append("dmUltron:jsonData={");
        String str6 = ",";
        if (TextUtils.isEmpty(str)) {
            str5 = "";
        } else {
            sb.append("apiName:" + str);
            str5 = ",";
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str5);
            sb.append(qa.ERROR_CODE + str2);
            str5 = ",";
        }
        if (TextUtils.isEmpty(str3)) {
            str6 = str5;
        } else {
            sb.append(str5);
            sb.append(qa.ERROR_MSG + str3);
        }
        if (ua0.b(context) > 0) {
            sb.append(str6);
            sb.append("itemId:");
            sb.append(ua0.b(context));
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append(str6);
            sb.append(str4);
        }
        sb.append("}");
        return sb.toString();
    }

    public static synchronized mb0 f() {
        synchronized (mb0.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "266083385")) {
                return (mb0) ipChange.ipc$dispatch("266083385", new Object[0]);
            }
            if (b == null) {
                b = new mb0();
            }
            return b;
        }
    }

    private void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-951803084")) {
            ipChange.ipc$dispatch("-951803084", new Object[]{this});
            return;
        }
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.clear();
        this.a.add("ANDROID_SYS_NETWORK_ERROR");
        this.a.add("ANDROID_SYS_NO_NETWORK");
        this.a.add("FAIL_SYS_SYSTEM_BUSY_ERROR");
        this.a.add(e11.FAIL_SYS_TRAFFIC_LIMIT);
        this.a.add(ErrorConstant.ERRCODE_ANDROID_SYS_LOGIN_CANCEL);
        this.a.add("ANDROID_SYS_API_FLOW_LIMIT_LOCKED");
        this.a.add(ErrorConstant.ERRCODE_JSONDATA_BLANK);
        this.a.add(ErrorConstant.ERRCODE_API_41X_ANTI_ATTACK);
        this.a.add("FCADE0002");
        this.a.add("F-10012-01-16-001");
        this.a.add("F-10012-01-16-003");
        this.a.add("F-10001-03-16-113");
        this.a.add("F-10007-10-10-025");
        this.a.add("CUSTOM_REASON_CANNOT_BUY_C");
        this.a.add("CUSTOM_REASON_CANNOT_BUY");
        this.a.add("MAX_BUY_QUANTITY_EXCEEDED");
    }

    public static void i(MtopResponse mtopResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-63798394")) {
            ipChange.ipc$dispatch("-63798394", new Object[]{mtopResponse});
        } else if (mtopResponse == null) {
        } else {
            try {
                b23.c(mtopResponse.getApi(), "mtop", m61.e(mtopResponse), mtopResponse.getRetCode(), mtopResponse.getRetMsg());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void j(Context context, MtopResponse mtopResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1113498459")) {
            ipChange.ipc$dispatch("-1113498459", new Object[]{context, mtopResponse});
        } else if (mtopResponse == null) {
        } else {
            try {
                b23.f(mtopResponse.getApi(), "mtop", "2000", "-", Util.getTraceId(mtopResponse));
                mb0 f = f();
                String api = mtopResponse.getApi();
                f.k(context, api, "2000", "_ traceId=" + Util.getTraceId(mtopResponse), true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(Context context, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1179157525")) {
            ipChange.ipc$dispatch("-1179157525", new Object[]{this, context, str, str2});
            return;
        }
        try {
            b23.a(e(context, AddressApi.API_GET_ADDRESS_LIST, str, str2, null), "-4320", "候鸟项目获取地址列表接口失败");
        } catch (Exception unused) {
        }
    }

    public void b(Context context, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "831744476")) {
            ipChange.ipc$dispatch("831744476", new Object[]{this, context, str, str2, str3});
            return;
        }
        try {
            b23.g(e(context, str, str2, str3, "fromWhere:新奥创下单刷新接口失败"), "-4310", "下单接口失败");
        } catch (Exception unused) {
        }
    }

    public void c(Context context, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1329866695")) {
            ipChange.ipc$dispatch("-1329866695", new Object[]{this, context, str, str2, str3});
            return;
        }
        try {
            b23.g(e(context, str, str2, str3, "fromWhere:新奥创下单渲染接口失败"), "-4310", "下单接口失败");
        } catch (Exception unused) {
        }
    }

    public void d(Context context, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-653156913")) {
            ipChange.ipc$dispatch("-653156913", new Object[]{this, context, str, str2, str3});
            return;
        }
        try {
            b23.g(e(context, str, str2, str3, "fromWhere:新奥创提交订单接口失败"), "-4330", "提交订单接口失败");
        } catch (Exception unused) {
        }
    }

    public boolean g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1505803302")) {
            return ((Boolean) ipChange.ipc$dispatch("-1505803302", new Object[]{this, str})).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("B-00203")) {
            return true;
        }
        if (this.a == null) {
            h();
        }
        return this.a.contains(str);
    }

    public void k(Context context, String str, String str2, String str3, boolean z) {
        String sb;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1117975567")) {
            ipChange.ipc$dispatch("1117975567", new Object[]{this, context, str, str2, str3, Boolean.valueOf(z)});
            return;
        }
        if ("mtop.trade.order.build".equals(str)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("新奥创下单渲染接口");
            sb2.append(z ? "" : "失败");
            sb = sb2.toString();
        } else if ("mtop.trade.order.adjust".equals(str)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("新奥创下单刷新接口");
            sb3.append(z ? "" : "失败");
            sb = sb3.toString();
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("新奥创提交订单接口");
            sb4.append(z ? "" : "失败");
            sb = sb4.toString();
        }
        HashMap hashMap = new HashMap();
        if (context != null && ua0.b(context) > 0) {
            hashMap.put("itemId", ua0.b(context) + "");
        }
        hashMap.put("fromWhere", sb);
        zr.INSTANCE.a().a(str).c(str2).d(str3).e(hashMap).g("订单确认页面").j("confirm").f(z).b();
    }

    public void l(Context context, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1756348964")) {
            ipChange.ipc$dispatch("1756348964", new Object[]{this, context, str, str2});
            return;
        }
        try {
            b23.g(e(context, null, str, str2, "fromWhere:新奥创绑定优酷账号失败"), "-1700", "优酷账号绑定失败");
        } catch (Exception unused) {
        }
    }
}
