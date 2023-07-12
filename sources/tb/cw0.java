package tb;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.login.LoginManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class cw0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static cw0 a;

    private cw0() {
    }

    public static cw0 a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1177665769")) {
            return (cw0) ipChange.ipc$dispatch("-1177665769", new Object[0]);
        }
        if (a == null) {
            synchronized (cw0.class) {
                a = new cw0();
            }
        }
        return a;
    }

    public void b(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1561689395")) {
            ipChange.ipc$dispatch("1561689395", new Object[]{this, context});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(LoginManager.ACTION_DO_LOGIN, 0);
        if (context instanceof Activity) {
            DMNav.from(context).forResult(1005).withExtras(bundle).toUri(NavUri.b("login"));
        } else {
            DMNav.from(context).withExtras(bundle).toUri(NavUri.b("login"));
        }
    }
}
