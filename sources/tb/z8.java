package tb;

import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0528b;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class z8 extends C0528b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String PAGE_NAME = "authorize_sanfang";

    public C0525a.C0527b f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "379783547")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("379783547", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("partnername", str);
        hashMap.put("usercode", z20.E());
        return e(PAGE_NAME, "center", "agreement", hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "468412225")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("468412225", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("partnername", str);
        hashMap.put("usercode", z20.E());
        return e(PAGE_NAME, "center", "confirm", hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b h(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-58834969")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-58834969", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("partnername", str);
        hashMap.put("usercode", z20.E());
        return e(PAGE_NAME, "top", Constants.Event.RETURN, hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1106080417")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1106080417", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("partnername", str);
        hashMap.put("usercode", z20.E());
        return new C0525a.C0527b().i(PAGE_NAME).j(hashMap);
    }
}
