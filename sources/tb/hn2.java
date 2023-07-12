package tb;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class hn2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2001256183")) {
            ipChange.ipc$dispatch("-2001256183", new Object[0]);
            return;
        }
        if (!TextUtils.isEmpty(z20.i()) && !z20.i().equals(fu1.c())) {
            fu1.d(mu0.a(), fu1.TICKLET_PREFERENCE_USERCODE, z20.i());
        }
        e40.e().d(mu0.a());
    }
}
