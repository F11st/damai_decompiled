package com.youku.live.dsl.config;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IStaticConfigVirtualImp implements IStaticConfig {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.config.IConfigBase
    public boolean getBoolean(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "534168523") ? ((Boolean) ipChange.ipc$dispatch("534168523", new Object[]{this, str, str2, Boolean.valueOf(z)})).booleanValue() : z;
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public double getDouble(String str, String str2, double d) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "692130272") ? ((Double) ipChange.ipc$dispatch("692130272", new Object[]{this, str, str2, Double.valueOf(d)})).doubleValue() : d;
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public float getFloat(String str, String str2, float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1376008233") ? ((Float) ipChange.ipc$dispatch("-1376008233", new Object[]{this, str, str2, Float.valueOf(f)})).floatValue() : f;
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public int getInt(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "230037168") ? ((Integer) ipChange.ipc$dispatch("230037168", new Object[]{this, str, str2, Integer.valueOf(i)})).intValue() : i;
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public long getLong(String str, String str2, long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1126280983") ? ((Long) ipChange.ipc$dispatch("1126280983", new Object[]{this, str, str2, Long.valueOf(j)})).longValue() : j;
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public String getString(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1390358794") ? (String) ipChange.ipc$dispatch("1390358794", new Object[]{this, str, str2, str3}) : str3;
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public List<String> getStringArray(String str, String str2, List<String> list, String str3) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1153126913") ? (List) ipChange.ipc$dispatch("-1153126913", new Object[]{this, str, str2, list, str3}) : list;
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public String[] getStringArray(String str, String str2, String[] strArr, String str3) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1775961099") ? (String[]) ipChange.ipc$dispatch("1775961099", new Object[]{this, str, str2, strArr, str3}) : strArr;
    }
}
