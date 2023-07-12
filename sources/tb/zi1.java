package tb;

import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.nav.NavHandler;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class zi1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1081313083")) {
            ipChange.ipc$dispatch("1081313083", new Object[]{this});
            return;
        }
        try {
            DMNav.registerStickPreprocessor(new cn.damai.commonbusiness.nav.a());
            DMNav.registerStickPreprocessor(new y91());
            DMNav.registerStickPreprocessor(new pc0());
            DMNav.registerPreprocessor(new t4());
            DMNav.setExceptionHandler(new NavHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
