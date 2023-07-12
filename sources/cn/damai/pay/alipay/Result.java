package cn.damai.pay.alipay;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.opensdk.ups.request.UpsConstant;
import java.util.HashMap;
import java.util.Map;
import tb.jn1;
import tb.qw2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class Result {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final Map<String, String> sError;

    static {
        HashMap hashMap = new HashMap();
        sError = hashMap;
        hashMap.put("9000", "操作成功");
        hashMap.put(UpsConstant.UPS_NETWORK_4G, "系统异常");
        hashMap.put("4001", "数据格式不正确");
        hashMap.put("4003", "该用户绑定的支付宝账户被冻结或不允许支付");
        hashMap.put("4004", "该用户已解除绑定");
        hashMap.put("4005", "绑定失败或没有绑定");
        hashMap.put("4006", "订单支付失败");
        hashMap.put("4010", "重新绑定账户");
        hashMap.put("6000", "支付服务正在进行升级操作");
        hashMap.put("6001", "用户中途取消支付操作");
    }

    public static String getAppUserId(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "884154610") ? (String) ipChange.ipc$dispatch("884154610", new Object[]{str}) : getContent(str.replace(jn1.BLOCK_START_STR, "").replace("}", ""), "userid=", null);
    }

    private static String getContent(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1897225744")) {
            return (String) ipChange.ipc$dispatch("1897225744", new Object[]{str, str2, str3});
        }
        int indexOf = str.indexOf(str2);
        qw2.d("start", "start = " + indexOf);
        if (indexOf == -1) {
            return null;
        }
        int length = indexOf + str2.length();
        try {
            if (str3 != null) {
                return str.substring(length, str.indexOf(str3));
            }
            return str.substring(length);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getResult(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1330146612") ? (String) ipChange.ipc$dispatch("1330146612", new Object[]{str}) : getContent(str.replace(jn1.BLOCK_START_STR, "").replace("}", ""), "memo=", ";result");
    }

    public static String getToken(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1070101156") ? (String) ipChange.ipc$dispatch("1070101156", new Object[]{str}) : getContent(str.replace(jn1.BLOCK_START_STR, "").replace("}", ""), "token=", "&userid");
    }
}
