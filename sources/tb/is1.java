package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class is1 extends cn.damai.common.user.b {
    private static transient /* synthetic */ IpChange $ipChange;
    private static is1 b;

    public static is1 f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1313089087")) {
            return (is1) ipChange.ipc$dispatch("1313089087", new Object[0]);
        }
        if (b == null) {
            b = new is1();
        }
        return b;
    }

    public void g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1371743540")) {
            ipChange.ipc$dispatch("1371743540", new Object[]{this, str});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        cn.damai.common.user.c.e().x(e("select_pic", "bottom", str, hashMap, Boolean.TRUE));
    }
}
