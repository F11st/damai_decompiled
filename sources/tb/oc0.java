package tb;

import android.text.TextUtils;
import cn.damai.common.AppConfig;
import cn.damai.ticklet.bean.DowngradeH5Bean;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class oc0 {
    private static transient /* synthetic */ IpChange $ipChange;

    private static DowngradeH5Bean a() {
        JSONObject c;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1233903269")) {
            return (DowngradeH5Bean) ipChange.ipc$dispatch("1233903269", new Object[0]);
        }
        String b = z20.b();
        if (TextUtils.isEmpty(b) || (c = m61.c(b)) == null || !c.containsKey("tickletDowngradeH5") || !(c.get("tickletDowngradeH5") instanceof JSONObject)) {
            return null;
        }
        return (DowngradeH5Bean) m61.d((JSONObject) c.get("tickletDowngradeH5"), DowngradeH5Bean.class);
    }

    public static String b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "946671428")) {
            return (String) ipChange.ipc$dispatch("946671428", new Object[0]);
        }
        DowngradeH5Bean a = a();
        if (a == null) {
            return "";
        }
        if ("2".equals(a.type) || "3".equals(a.type)) {
            if (TextUtils.isEmpty(a.detailH5)) {
                return AppConfig.EnvMode.prepare == AppConfig.g() ? "https://market.wapa.damai.cn/app/dmfe/ticket-wallet/detail.html" : AppConfig.EnvMode.online == AppConfig.g() ? "https://m.damai.cn/app/dmfe/ticket-wallet/detail.html" : "";
            }
            return a.detailH5;
        }
        return "";
    }

    public static String c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2060660497")) {
            return (String) ipChange.ipc$dispatch("2060660497", new Object[0]);
        }
        DowngradeH5Bean a = a();
        if (a == null) {
            return "";
        }
        if ("1".equals(a.type) || "3".equals(a.type)) {
            if (TextUtils.isEmpty(a.listH5)) {
                return AppConfig.EnvMode.prepare == AppConfig.g() ? "https://market.wapa.damai.cn/app/dmfe/ticket-wallet/list.html" : AppConfig.EnvMode.online == AppConfig.g() ? "https://m.damai.cn/app/dmfe/ticket-wallet/list.html" : "";
            }
            return a.listH5;
        }
        return "";
    }
}
