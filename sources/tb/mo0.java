package tb;

import cn.damai.common.user.C0528b;
import cn.damai.common.user.C0529c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class mo0 extends C0528b {
    private static transient /* synthetic */ IpChange $ipChange;
    private static mo0 b;

    public static mo0 g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1481950773")) {
            return (mo0) ipChange.ipc$dispatch("1481950773", new Object[0]);
        }
        if (b == null) {
            b = new mo0();
        }
        return b;
    }

    public void f(HashMap<String, String> hashMap, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-744469817")) {
            ipChange.ipc$dispatch("-744469817", new Object[]{this, hashMap, str, str2});
        } else {
            C0529c.e().A(hashMap, str, str2);
        }
    }
}
