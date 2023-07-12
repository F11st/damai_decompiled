package tb;

import cn.damai.common.user.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class z8 extends cn.damai.common.user.b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String PAGE_NAME = "authorize_sanfang";

    public a.b f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "379783547")) {
            return (a.b) ipChange.ipc$dispatch("379783547", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("partnername", str);
        hashMap.put("usercode", z20.E());
        return e(PAGE_NAME, "center", "agreement", hashMap, Boolean.TRUE);
    }

    public a.b g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "468412225")) {
            return (a.b) ipChange.ipc$dispatch("468412225", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("partnername", str);
        hashMap.put("usercode", z20.E());
        return e(PAGE_NAME, "center", "confirm", hashMap, Boolean.TRUE);
    }

    public a.b h(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-58834969")) {
            return (a.b) ipChange.ipc$dispatch("-58834969", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("partnername", str);
        hashMap.put("usercode", z20.E());
        return e(PAGE_NAME, "top", Constants.Event.RETURN, hashMap, Boolean.TRUE);
    }

    public a.b i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1106080417")) {
            return (a.b) ipChange.ipc$dispatch("-1106080417", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("partnername", str);
        hashMap.put("usercode", z20.E());
        return new a.b().i(PAGE_NAME).j(hashMap);
    }
}
