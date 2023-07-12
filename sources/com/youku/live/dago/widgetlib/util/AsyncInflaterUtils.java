package com.youku.live.dago.widgetlib.util;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OrangeConfig;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AsyncInflaterUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String ASYNC_INFLATER_CONFIG = "android_laifeng_async_inflater_config";
    private static final String SUPPORT_ASYNC_INFLATER = "support_async_inflater";

    public static boolean supportAsyncInflater() {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1075806473")) {
            return ((Boolean) ipChange.ipc$dispatch("-1075806473", new Object[0])).booleanValue();
        }
        try {
            i = Integer.parseInt(OrangeConfig.getInstance().getConfig(ASYNC_INFLATER_CONFIG, SUPPORT_ASYNC_INFLATER, ""));
        } catch (Exception unused) {
            i = 0;
        }
        return i == 1;
    }
}
