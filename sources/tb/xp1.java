package tb;

import android.app.Activity;
import android.os.Bundle;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class xp1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(Activity activity, Bundle bundle, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "354895699")) {
            ipChange.ipc$dispatch("354895699", new Object[]{activity, bundle, Boolean.valueOf(z)});
        } else if (activity == null || bundle == null) {
        } else {
            DMNav.from(activity).withExtras(bundle).toUri(NavUri.b(cs.c));
        }
    }
}
