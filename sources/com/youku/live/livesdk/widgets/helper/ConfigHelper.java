package com.youku.live.livesdk.widgets.helper;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.config.IRemoteConfig;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ConfigHelper {
    private static transient /* synthetic */ IpChange $ipChange;

    public static boolean getBoolean(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1636579232") ? ((Boolean) ipChange.ipc$dispatch("-1636579232", new Object[]{str, str2, Boolean.valueOf(z)})).booleanValue() : ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getBoolean(str, str2, z);
    }

    public static double getDouble(String str, String str2, double d) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "760653483") ? ((Double) ipChange.ipc$dispatch("760653483", new Object[]{str, str2, Double.valueOf(d)})).doubleValue() : ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getDouble(str, str2, d);
    }

    public static float getFloat(String str, String str2, float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1674243500") ? ((Float) ipChange.ipc$dispatch("1674243500", new Object[]{str, str2, Float.valueOf(f)})).floatValue() : ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getFloat(str, str2, f);
    }

    public static int getInteger(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-426225772") ? ((Integer) ipChange.ipc$dispatch("-426225772", new Object[]{str, str2, Integer.valueOf(i)})).intValue() : ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getInt(str, str2, i);
    }

    public static long getLong(String str, String str2, long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1130628446") ? ((Long) ipChange.ipc$dispatch("-1130628446", new Object[]{str, str2, Long.valueOf(j)})).longValue() : ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getLong(str, str2, j);
    }
}
