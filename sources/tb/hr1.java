package tb;

import cn.damai.common.user.C0529c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class hr1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1985912103")) {
            ipChange.ipc$dispatch("-1985912103", new Object[0]);
            return;
        }
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        Map<String, String> map = mr1.PERMISSION_NAME_MAP;
        if (map.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (true) {
            if (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                String str = i != 0 ? "," : "";
                sb.append(str + next.getKey());
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(ir1.g(next.getKey()) ? "1" : "0");
                sb2.append(sb3.toString());
                i++;
            } else {
                hashMap.put("titlelabel", sb.toString());
                hashMap.put("status", sb2.toString());
                C0529c.e().A(hashMap, "state", "overview");
                try {
                    HashMap hashMap2 = new HashMap();
                    int a = C9659rp.a(mu0.a());
                    hashMap2.put("cpu_arch", a + "");
                    hashMap2.put("apk_arch", C9659rp.b(mu0.a()) + "");
                    hashMap2.put("runtime_arch", C9659rp.e(mu0.a()) + "");
                    C0529c.e().A(hashMap2, "userstate", "cpu_state");
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }
}
