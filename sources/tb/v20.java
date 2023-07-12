package tb;

import android.util.Base64;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class v20 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1654573725")) {
            return (String) ipChange.ipc$dispatch("1654573725", new Object[]{str});
        }
        try {
            byte[] a = fl.a(Base64.decode(str, 2), Base64.decode("qJzGEh6hESZDVJeCnFPGuxzaiB7NLQM3", 2));
            return a != null ? new String(a) : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1710716154")) {
            return (String) ipChange.ipc$dispatch("-1710716154", new Object[]{str});
        }
        try {
            return Base64.encodeToString(fl.b(str.getBytes(), Base64.decode("qJzGEh6hESZDVJeCnFPGuxzaiB7NLQM3", 2)), 2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
