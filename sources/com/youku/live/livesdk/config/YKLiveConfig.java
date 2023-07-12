package com.youku.live.livesdk.config;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.constants.CcodeConstants;
import com.youku.live.livesdk.constants.SDKConstants;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class YKLiveConfig {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String NAMESPACE_YKLIVE = "YKLive";

    public static String getCcode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1716488072") ? (String) ipChange.ipc$dispatch("1716488072", new Object[0]) : ConfigUtils.getConfig("YKLive", "ccode", CcodeConstants.YOUKU_APP_CCODE);
    }

    public static String getOttCcode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1981523487") ? (String) ipChange.ipc$dispatch("1981523487", new Object[0]) : ConfigUtils.getConfig("YKLive", "ccode_ott", CcodeConstants.YOUKU_APP_OTT_CCODE);
    }

    public static String getSdkVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2021786308") ? (String) ipChange.ipc$dispatch("-2021786308", new Object[0]) : ConfigUtils.getConfig("YKLive", "sdk_version", SDKConstants.SDK_VERSION_NUMBER);
    }
}
