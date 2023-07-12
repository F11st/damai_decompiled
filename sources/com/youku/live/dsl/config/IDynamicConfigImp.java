package com.youku.live.dsl.config;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.application.common.C6673b;
import com.taobao.application.common.IAppPreferences;
import java.util.Arrays;
import java.util.List;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IDynamicConfigImp implements IDynamicConfig {
    private static transient /* synthetic */ IpChange $ipChange;

    private String getDeviceScore() {
        Context applicationContext;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "406729569")) {
            return (String) ipChange.ipc$dispatch("406729569", new Object[]{this});
        }
        IAppPreferences d = C6673b.d();
        int i = d != null ? d.getInt("oldDeviceScore", -1) : -1;
        if (i == -1 && (applicationContext = mu0.a().getApplicationContext()) != null) {
            i = applicationContext.getSharedPreferences("device_score", 0).getInt("device_score", -1);
        }
        return i + "";
    }

    private String getStringInternal(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-982483615") ? (String) ipChange.ipc$dispatch("-982483615", new Object[]{this, str, str2, str3}) : ("device".equalsIgnoreCase(str) && IDynamicConfig.KEY_DEVICE_SCORE.equalsIgnoreCase(str2)) ? getDeviceScore() : str3;
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public boolean getBoolean(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1058626513")) {
            return ((Boolean) ipChange.ipc$dispatch("1058626513", new Object[]{this, str, str2, Boolean.valueOf(z)})).booleanValue();
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
        if (AndroidInstantRuntime.support(ipChange, "-1092067046")) {
            return ((Double) ipChange.ipc$dispatch("-1092067046", new Object[]{this, str, str2, Double.valueOf(d)})).doubleValue();
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

    @Override // com.youku.live.dsl.config.IConfigBase
    public float getFloat(String str, String str2, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "921741661")) {
            return ((Float) ipChange.ipc$dispatch("921741661", new Object[]{this, str, str2, Float.valueOf(f)})).floatValue();
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
        if (AndroidInstantRuntime.support(ipChange, "1398907318")) {
            return ((Integer) ipChange.ipc$dispatch("1398907318", new Object[]{this, str, str2, Integer.valueOf(i)})).intValue();
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
        if (AndroidInstantRuntime.support(ipChange, "-1293450031")) {
            return ((Long) ipChange.ipc$dispatch("-1293450031", new Object[]{this, str, str2, Long.valueOf(j)})).longValue();
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
        if (AndroidInstantRuntime.support(ipChange, "-284282428")) {
            return (String) ipChange.ipc$dispatch("-284282428", new Object[]{this, str, str2, str3});
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
        if (AndroidInstantRuntime.support(ipChange, "-395155311")) {
            return (String[]) ipChange.ipc$dispatch("-395155311", new Object[]{this, str, str2, strArr, str3});
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

    @Override // com.youku.live.dsl.config.IConfigBase
    public List<String> getStringArray(String str, String str2, List<String> list, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1179348741")) {
            return (List) ipChange.ipc$dispatch("1179348741", new Object[]{this, str, str2, list, str3});
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
