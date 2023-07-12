package cn.damai.launcher.initialize;

import android.content.Context;
import android.text.TextUtils;
import cn.damai.common.AppConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class ProcessUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String ATLAS_DEXOAT_PROCESS_NAME = "cn.damai:dex2oat";
    public static final String CHANNEL_PROCESS_NAME = "cn.damai:channel";
    public static final String MAIN_PROCESS_NAME = "cn.damai";
    public static final String TCMSSERVICE_PROCESS_NAME = "cn.damai:TcmsService";

    private ProcessUtils() {
    }

    public static boolean a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1398727016")) {
            return ((Boolean) ipChange.ipc$dispatch("-1398727016", new Object[]{context})).booleanValue();
        }
        String n = AppConfig.n(context);
        return !TextUtils.isEmpty(n) && n.equals("cn.damai:channel");
    }

    public static boolean b(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-911501096")) {
            return ((Boolean) ipChange.ipc$dispatch("-911501096", new Object[]{context})).booleanValue();
        }
        String n = AppConfig.n(context);
        return !TextUtils.isEmpty(n) && n.equals("cn.damai");
    }
}
