package com.youku.live.dsl.config;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IDynamicConfigVirtualImp implements IDynamicConfig {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.config.IConfigBase
    public boolean getBoolean(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1550944220") ? ((Boolean) ipChange.ipc$dispatch("1550944220", new Object[]{this, str, str2, Boolean.valueOf(z)})).booleanValue() : z;
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public double getDouble(String str, String str2, double d) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-383449169") ? ((Double) ipChange.ipc$dispatch("-383449169", new Object[]{this, str, str2, Double.valueOf(d)})).doubleValue() : d;
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public float getFloat(String str, String str2, float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1410704344") ? ((Float) ipChange.ipc$dispatch("-1410704344", new Object[]{this, str, str2, Float.valueOf(f)})).floatValue() : f;
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public int getInt(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1003517119") ? ((Integer) ipChange.ipc$dispatch("-1003517119", new Object[]{this, str, str2, Integer.valueOf(i)})).intValue() : i;
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public long getLong(String str, String str2, long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1540803750") ? ((Long) ipChange.ipc$dispatch("1540803750", new Object[]{this, str, str2, Long.valueOf(j)})).longValue() : j;
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public String getString(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-221711591") ? (String) ipChange.ipc$dispatch("-221711591", new Object[]{this, str, str2, str3}) : str3;
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public List<String> getStringArray(String str, String str2, List<String> list, String str3) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "262880144") ? (List) ipChange.ipc$dispatch("262880144", new Object[]{this, str, str2, list, str3}) : list;
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public String[] getStringArray(String str, String str2, String[] strArr, String str3) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "516645084") ? (String[]) ipChange.ipc$dispatch("516645084", new Object[]{this, str, str2, strArr, str3}) : strArr;
    }
}
