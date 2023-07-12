package tb;

import android.app.Application;
import cn.damai.common.AppConfig;
import cn.damai.live.LiveActivity;
import com.alibaba.aliweex.AliWXSDKEngine;
import com.alibaba.aliweex.C3004a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKEngine;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class m13 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1916091754")) {
            ipChange.ipc$dispatch("-1916091754", new Object[]{application});
            return;
        }
        try {
            WXEnvironment.addCustomOptions("appName", "damaiAndroid");
            WXEnvironment.addCustomOptions(LiveActivity.OPTION_TTID, "701088@damai_android_" + AppConfig.q());
            C3004a.l().r(application, new C3004a.C3005a.C3006a().a());
            AliWXSDKEngine.d();
            if (WXSDKEngine.isInitialized()) {
                cb1.c("WXSDKEngine", "damai success");
            } else {
                cb1.c("WXSDKEngine", "damai fail");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
