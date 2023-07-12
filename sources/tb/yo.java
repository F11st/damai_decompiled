package tb;

import cn.damai.common.user.C0528b;
import cn.damai.common.user.C0529c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class yo extends C0528b {
    private static transient /* synthetic */ IpChange $ipChange;
    private static yo b;

    public static yo f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1216123269")) {
            return (yo) ipChange.ipc$dispatch("-1216123269", new Object[0]);
        }
        if (b == null) {
            b = new yo();
        }
        return b;
    }

    public void g(long j, String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1060651539")) {
            ipChange.ipc$dispatch("-1060651539", new Object[]{this, Long.valueOf(j), str, str2, Integer.valueOf(i)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d() + "市");
        hashMap.put("usercode", z20.E());
        hashMap.put("eventTrack", str2);
        long currentTimeMillis = System.currentTimeMillis() - j;
        C0529c e = C0529c.e();
        e.C("item_" + i, "redpaper", str, "1.0", currentTimeMillis, hashMap, 2201);
    }

    public void h(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-62215718")) {
            ipChange.ipc$dispatch("-62215718", new Object[]{this, str});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.c());
        hashMap.put("usercode", z20.E());
        hashMap.put("eventTrack", str);
        C0529c.e().A(hashMap, "damai_redpacket_data_event", "redpacket_data");
    }
}
