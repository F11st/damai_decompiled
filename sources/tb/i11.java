package tb;

import cn.damai.common.user.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class i11 extends cn.damai.common.user.b {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    private static class a {
        private static final i11 a = new i11();
    }

    public static final i11 g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-184364165") ? (i11) ipChange.ipc$dispatch("-184364165", new Object[0]) : a.a;
    }

    public a.b f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1484333615")) {
            return (a.b) ipChange.ipc$dispatch("-1484333615", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        return new a.b().j(hashMap).i("poster");
    }
}
