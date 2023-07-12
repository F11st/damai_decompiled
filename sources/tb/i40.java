package tb;

import cn.damai.common.user.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class i40 extends cn.damai.common.user.b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String PAGE_NAME_DRAMA_COMMING = "coming_drama";
    private static i40 b = new i40();

    public static i40 f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "216669063") ? (i40) ipChange.ipc$dispatch("216669063", new Object[0]) : b;
    }

    public a.b g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "720178847")) {
            return (a.b) ipChange.ipc$dispatch("720178847", new Object[]{this});
        }
        String E = z20.E();
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", E);
        return new a.b().j(hashMap).a(z20.d()).i(PAGE_NAME_DRAMA_COMMING);
    }
}
