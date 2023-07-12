package tb;

import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0528b;
import cn.damai.common.user.C0529c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class y3 extends C0528b {
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

    public C0525a.C0527b g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-181626563") ? (C0525a.C0527b) ipChange.ipc$dispatch("-181626563", new Object[]{this}) : new C0525a.C0527b().i("addaddress");
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
        C0529c.e().x(e("addaddress", "top", "save", hashMap, Boolean.FALSE));
    }
}
