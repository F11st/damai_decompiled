package tb;

import com.alibaba.mtl.appmonitor.AppMonitor;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class se2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(String str, String str2, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "55201119")) {
            ipChange.ipc$dispatch("55201119", new Object[]{str, str2, map});
        } else {
            b23.c(b23.a, "solidMonitor", v92.b("solidMonitor", map), str, str2);
        }
    }

    public static void b(HashMap<String, String> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-459987108")) {
            ipChange.ipc$dispatch("-459987108", new Object[]{hashMap});
        } else {
            b23.e(b23.a, "solidMonitor", b23.i("solidMonitor", "", "", "", !cb2.f(hashMap) ? m61.e(hashMap) : ""));
        }
    }

    public static void c(String str, String str2, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-280131974")) {
            ipChange.ipc$dispatch("-280131974", new Object[]{str, str2, map});
        } else {
            b23.c(b23.a, "solidXCDNMonitor", v92.b("solidXCDNMonitor", map), str, str2);
        }
    }

    public static void d(HashMap<String, String> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "297068641")) {
            ipChange.ipc$dispatch("297068641", new Object[]{hashMap});
        } else {
            b23.e(b23.a, "solidXCDNMonitor", v92.b("solidXCDNMonitor", hashMap));
        }
    }

    public static void e(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-524160113")) {
            ipChange.ipc$dispatch("-524160113", new Object[]{str});
            return;
        }
        if (str == null) {
            str = "unknown.lib";
        }
        try {
            AppMonitor.Counter.commit(b23.a, "solidXCdnStart", str, 1.0d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
