package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class tn2 {
    private static transient /* synthetic */ IpChange $ipChange;

    private static String a(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-522502603")) {
            return (String) ipChange.ipc$dispatch("-522502603", new Object[]{Integer.valueOf(i)});
        }
        switch (i) {
            case 1:
                return "转送列表";
            case 2:
                return "取消转送";
            case 3:
                return "发起转送";
            case 4:
                return "解绑人脸";
            case 5:
                return "接收列表";
            case 6:
                return "接收转送";
            case 7:
                return "三方接收转送";
            default:
                return "";
        }
    }

    private static String b(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1654291798")) {
            return (String) ipChange.ipc$dispatch("-1654291798", new Object[]{Integer.valueOf(i)});
        }
        switch (i) {
            case 1:
                return "mtop.damai.wireless.ticklet2.transfer.query";
            case 2:
                return "mtop.damai.wireless.ticklet2.transfer.cancel";
            case 3:
            case 7:
                return "mtop.damai.wireless.ticklet2.transfer.grant";
            case 4:
                return "mtop.damai.wireless.ticklet.face.unbinding";
            case 5:
                return "mtop.damai.wireless.ticklet2.transfer.accept.query";
            case 6:
                return "mtop.damai.wireless.ticklet2.transfer.accept";
            default:
                return "";
        }
    }

    public static void c(int i, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1528792499")) {
            ipChange.ipc$dispatch("-1528792499", new Object[]{Integer.valueOf(i), str, str2, str3});
        } else {
            xn2.d(xn2.i(a(i), b(i), str, str2, str3), "-5300", str, "转送接口失败");
        }
    }
}
