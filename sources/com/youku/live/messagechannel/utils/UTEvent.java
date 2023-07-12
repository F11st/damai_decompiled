package com.youku.live.messagechannel.utils;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OrangeConfig;
import com.ut.mini.UTAnalytics;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.youku.live.messagechannel.conf.OrangeConfKey;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class UTEvent {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static String closeDataReportSwitch = null;
    private static int eventId = 19999;
    private static String pageName = "MessageChannel";

    static {
        OrangeConfig orangeConfig = OrangeConfig.getInstance();
        OrangeConfKey.KeyInfo keyInfo = OrangeConfKey.closeDataReport;
        closeDataReportSwitch = orangeConfig.getConfig(OrangeConfKey.Group.android_youku_messagechannel, keyInfo.name, keyInfo.def);
    }

    public static void record(String str, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "107172214")) {
            ipChange.ipc$dispatch("107172214", new Object[]{str, map});
        } else if ("0".equals(closeDataReportSwitch)) {
            UTAnalytics.getInstance().getDefaultTracker().send(new UTOriginalCustomHitBuilder(pageName, eventId, str, "", "", map).build());
        }
    }
}
