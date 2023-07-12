package tb;

import android.content.Context;
import cn.damai.common.AppConfig;
import com.alibaba.security.rp.RPSDK;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class my1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "63576522")) {
            ipChange.ipc$dispatch("63576522", new Object[]{context});
            return;
        }
        RPSDK.RPSDKEnv rPSDKEnv = RPSDK.RPSDKEnv.RPSDKEnv_ONLINE;
        if (AppConfig.g() == AppConfig.EnvMode.test) {
            rPSDKEnv = RPSDK.RPSDKEnv.RPSDKEnv_DAILY;
        } else if (AppConfig.g() == AppConfig.EnvMode.prepare) {
            rPSDKEnv = RPSDK.RPSDKEnv.RPSDKEnv_PRE;
        }
        RPSDK.initialize(rPSDKEnv, context);
    }
}
