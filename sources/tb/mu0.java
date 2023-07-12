package tb;

import android.app.Application;
import cn.damai.common.OrangeConfigCenter;
import cn.damai.common.R$string;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class mu0 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static Application a = null;
    public static long b = 0;
    public static String c = "";
    public static long d;
    public static boolean e;
    public static long f;
    public static boolean g;

    public static Application a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1878226119")) {
            return (Application) ipChange.ipc$dispatch("-1878226119", new Object[0]);
        }
        if ("true".equals(OrangeConfigCenter.c().b("damai_oneservice_switch", "AppInfoProvider", "false"))) {
            if (AppInfoProviderProxy.getApplication() != null) {
                return AppInfoProviderProxy.getApplication();
            }
            return a;
        }
        return a;
    }

    public static long b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1438989954") ? ((Long) ipChange.ipc$dispatch("-1438989954", new Object[0])).longValue() : b;
    }

    public static void c(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "350992937")) {
            ipChange.ipc$dispatch("350992937", new Object[]{application});
            return;
        }
        a = application;
        cm2.b(application, R$string.damai_citylist_whole_country);
        b = wh2.m(z20.c(), 0L);
    }
}
