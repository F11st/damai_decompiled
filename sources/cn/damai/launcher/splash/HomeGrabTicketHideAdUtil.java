package cn.damai.launcher.splash;

import cn.damai.common.OrangeConfigCenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.on1;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class HomeGrabTicketHideAdUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    public static boolean isHideAd() {
        long m;
        long currentTimeMillis;
        long j;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1226387972")) {
            return ((Boolean) ipChange.ipc$dispatch("1226387972", new Object[0])).booleanValue();
        }
        try {
            m = z20.m();
            int a = OrangeConfigCenter.c().a(on1.GRAB_TICKLET_HIDE_AD_MINUTES, "limit_time", 5) * 60 * 1000;
            currentTimeMillis = System.currentTimeMillis();
            j = a;
        } catch (Exception unused) {
        }
        return m > currentTimeMillis - j && m < currentTimeMillis + j;
    }
}
