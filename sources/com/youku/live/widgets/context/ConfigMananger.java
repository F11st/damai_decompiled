package com.youku.live.widgets.context;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.config.IConfigBase;
import com.youku.live.dsl.config.IRemoteConfig;
import com.youku.live.widgets.protocol.IDestroyable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ConfigMananger implements IConfigBase, IDestroyable {
    private static transient /* synthetic */ IpChange $ipChange;
    private Map<String, Object> mCache;

    private Map<String, Object> getCache() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1752005500")) {
            return (Map) ipChange.ipc$dispatch("-1752005500", new Object[]{this});
        }
        if (this.mCache == null) {
            synchronized (this) {
                if (this.mCache == null) {
                    this.mCache = new ConcurrentHashMap();
                }
            }
        }
        return this.mCache;
    }

    @Override // com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1344559595")) {
            ipChange.ipc$dispatch("-1344559595", new Object[]{this});
        } else if (this.mCache != null) {
            getCache().clear();
            this.mCache = null;
        }
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public boolean getBoolean(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1849800005") ? ((Boolean) ipChange.ipc$dispatch("-1849800005", new Object[]{this, str, str2, Boolean.valueOf(z)})).booleanValue() : ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getBoolean(str, str2, z);
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public double getDouble(String str, String str2, double d) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-908792592") ? ((Double) ipChange.ipc$dispatch("-908792592", new Object[]{this, str, str2, Double.valueOf(d)})).doubleValue() : ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getDouble(str, str2, d);
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public float getFloat(String str, String str2, float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-319272249") ? ((Float) ipChange.ipc$dispatch("-319272249", new Object[]{this, str, str2, Float.valueOf(f)})).floatValue() : ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getFloat(str, str2, f);
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public int getInt(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "316052896") ? ((Integer) ipChange.ipc$dispatch("316052896", new Object[]{this, str, str2, Integer.valueOf(i)})).intValue() : ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getInt(str, str2, i);
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public long getLong(String str, String str2, long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-502198745") ? ((Long) ipChange.ipc$dispatch("-502198745", new Object[]{this, str, str2, Long.valueOf(j)})).longValue() : ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getLong(str, str2, j);
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public String getString(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-397916134") ? (String) ipChange.ipc$dispatch("-397916134", new Object[]{this, str, str2, str3}) : ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getString(str, str2, str3);
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public String[] getStringArray(String str, String str2, String[] strArr, String str3) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "815726331") ? (String[]) ipChange.ipc$dispatch("815726331", new Object[]{this, str, str2, strArr, str3}) : ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getStringArray(str, str2, strArr, str3);
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public List<String> getStringArray(String str, String str2, List<String> list, String str3) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-140796689") ? (List) ipChange.ipc$dispatch("-140796689", new Object[]{this, str, str2, list, str3}) : ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getStringArray(str, str2, list, str3);
    }
}
