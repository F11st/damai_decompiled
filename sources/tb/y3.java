package tb;

import cn.damai.common.user.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class y3 extends cn.damai.common.user.b {
    private static transient /* synthetic */ IpChange $ipChange;
    private static y3 b;

    public static y3 f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2011886555")) {
            return (y3) ipChange.ipc$dispatch("2011886555", new Object[0]);
        }
        if (b == null) {
            b = new y3();
        }
        return b;
    }

    public a.b g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-181626563") ? (a.b) ipChange.ipc$dispatch("-181626563", new Object[]{this}) : new a.b().i("addaddress");
    }

    public void h(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-291143686")) {
            ipChange.ipc$dispatch("-291143686", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        HashMap hashMap = new HashMap();
        if (z) {
            hashMap.put("contentlabel", "1");
        } else {
            hashMap.put("contentlabel", "0");
        }
        cn.damai.common.user.c.e().x(e("addaddress", "top", "save", hashMap, Boolean.FALSE));
    }
}
