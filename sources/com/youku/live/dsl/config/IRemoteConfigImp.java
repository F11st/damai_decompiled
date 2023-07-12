package com.youku.live.dsl.config;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OrangeConfig;
import com.youku.live.dsl.config.IRemoteConfig;
import java.util.Arrays;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IRemoteConfigImp implements IRemoteConfig {
    private static transient /* synthetic */ IpChange $ipChange;

    private String getStringInternal(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1370403000") ? (String) ipChange.ipc$dispatch("1370403000", new Object[]{this, str, str2, str3}) : OrangeConfig.getInstance().getConfig(str, str2, str3);
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public boolean getBoolean(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1825840794")) {
            return ((Boolean) ipChange.ipc$dispatch("1825840794", new Object[]{this, str, str2, Boolean.valueOf(z)})).booleanValue();
        }
        String stringInternal = getStringInternal(str, str2, null);
        if (stringInternal == null) {
            return z;
        }
        try {
            return Boolean.valueOf(stringInternal).booleanValue();
        } catch (Throwable unused) {
            return z;
        }
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public double getDouble(String str, String str2, double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1898602191")) {
            return ((Double) ipChange.ipc$dispatch("-1898602191", new Object[]{this, str, str2, Double.valueOf(d)})).doubleValue();
        }
        String stringInternal = getStringInternal(str, str2, null);
        if (stringInternal == null) {
            return d;
        }
        try {
            return Double.valueOf(stringInternal).doubleValue();
        } catch (Throwable unused) {
            return d;
        }
    }

    @Override // com.youku.live.dsl.config.IRemoteConfig
    public String getEnv() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-523273285")) {
            return (String) ipChange.ipc$dispatch("-523273285", new Object[]{this});
        }
        return null;
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public float getFloat(String str, String str2, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "618629734")) {
            return ((Float) ipChange.ipc$dispatch("618629734", new Object[]{this, str, str2, Float.valueOf(f)})).floatValue();
        }
        String stringInternal = getStringInternal(str, str2, null);
        if (stringInternal == null) {
            return f;
        }
        try {
            return Float.valueOf(stringInternal).floatValue();
        } catch (Throwable unused) {
            return f;
        }
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public int getInt(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "813117695")) {
            return ((Integer) ipChange.ipc$dispatch("813117695", new Object[]{this, str, str2, Integer.valueOf(i)})).intValue();
        }
        String stringInternal = getStringInternal(str, str2, null);
        if (stringInternal == null) {
            return i;
        }
        try {
            return Integer.valueOf(stringInternal).intValue();
        } catch (Throwable unused) {
            return i;
        }
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public long getLong(String str, String str2, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2021908136")) {
            return ((Long) ipChange.ipc$dispatch("2021908136", new Object[]{this, str, str2, Long.valueOf(j)})).longValue();
        }
        String stringInternal = getStringInternal(str, str2, null);
        if (stringInternal == null) {
            return j;
        }
        try {
            return Long.valueOf(stringInternal).longValue();
        } catch (Throwable unused) {
            return j;
        }
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public String getString(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-249254885")) {
            return (String) ipChange.ipc$dispatch("-249254885", new Object[]{this, str, str2, str3});
        }
        try {
            return getStringInternal(str, str2, str3);
        } catch (Throwable unused) {
            return str3;
        }
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public String[] getStringArray(String str, String str2, String[] strArr, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2106879514")) {
            return (String[]) ipChange.ipc$dispatch("2106879514", new Object[]{this, str, str2, strArr, str3});
        }
        String stringInternal = getStringInternal(str, str2, null);
        if (stringInternal == null) {
            return strArr;
        }
        try {
            return stringInternal.split(str3);
        } catch (Throwable unused) {
            return strArr;
        }
    }

    @Override // com.youku.live.dsl.config.IRemoteConfig
    public boolean isInited() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-401960761")) {
            return ((Boolean) ipChange.ipc$dispatch("-401960761", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // com.youku.live.dsl.config.IRemoteConfig
    public void registerListener(String[] strArr, IRemoteConfig.OnRemoteConfigUpdateListener onRemoteConfigUpdateListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "235072518")) {
            ipChange.ipc$dispatch("235072518", new Object[]{this, strArr, onRemoteConfigUpdateListener});
        }
    }

    @Override // com.youku.live.dsl.config.IRemoteConfig
    public void unregisterListener(String[] strArr, IRemoteConfig.OnRemoteConfigUpdateListener onRemoteConfigUpdateListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1788381473")) {
            ipChange.ipc$dispatch("-1788381473", new Object[]{this, strArr, onRemoteConfigUpdateListener});
        }
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public List<String> getStringArray(String str, String str2, List<String> list, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1218350926")) {
            return (List) ipChange.ipc$dispatch("1218350926", new Object[]{this, str, str2, list, str3});
        }
        String stringInternal = getStringInternal(str, str2, null);
        if (stringInternal == null) {
            return list;
        }
        try {
            return Arrays.asList(stringInternal.split(str3));
        } catch (Throwable unused) {
            return list;
        }
    }
}
