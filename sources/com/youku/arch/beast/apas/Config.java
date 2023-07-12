package com.youku.arch.beast.apas;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Config {
    private static transient /* synthetic */ IpChange $ipChange;
    private long mNativeId;

    private Config(long j) {
        this.mNativeId = j;
    }

    public native boolean getBooleanValue(String str);

    public native String getConfigId();

    public native String getConfigValue();

    public native String getConfigVersion();

    public native double getDoubleValue(String str);

    public native int getIntValue(String str);

    public native long getLongValue(String str);

    public native String getStringValue(String str);

    public String getStringValue(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1516620058")) {
            return (String) ipChange.ipc$dispatch("-1516620058", new Object[]{this, str, str2});
        }
        String stringValue = getStringValue(str);
        return stringValue == null ? str2 : stringValue;
    }

    public native int updateConfigValues(String str);
}
