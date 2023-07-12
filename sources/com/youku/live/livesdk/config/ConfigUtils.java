package com.youku.live.livesdk.config;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.config.IDynamicConfig;
import com.youku.live.dsl.config.IStaticConfig;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ConfigUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String getConfig(String str, String str2, String str3) {
        IStaticConfig iStaticConfig;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1120824481")) {
            return (String) ipChange.ipc$dispatch("-1120824481", new Object[]{str, str2, str3});
        }
        IDynamicConfig iDynamicConfig = (IDynamicConfig) Dsl.getService(IDynamicConfig.class);
        String string = iDynamicConfig != null ? iDynamicConfig.getString(str, str2, null) : null;
        if (string == null && (iStaticConfig = (IStaticConfig) Dsl.getService(IStaticConfig.class)) != null) {
            string = iStaticConfig.getString(str, str2, null);
        }
        return string == null ? str3 : string;
    }
}
