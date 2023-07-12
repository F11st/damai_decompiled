package tb;

import android.content.Context;
import cn.damai.common.nav.DMNav;
import cn.damai.tetris.core.nav.NavigatorProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class bj1 implements NavigatorProxy.INavigator {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.tetris.core.nav.NavigatorProxy.INavigator
    public void toUri(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1717564698")) {
            ipChange.ipc$dispatch("-1717564698", new Object[]{this, context, str});
        } else {
            DMNav.from(context).toUri(str);
        }
    }
}
