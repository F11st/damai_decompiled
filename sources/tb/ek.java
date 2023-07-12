package tb;

import com.alibaba.pictures.cornerstone.protocol.ICloudConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ek extends hb<ICloudConfig> implements ICloudConfig {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final ek INSTANCE;
    private static String d;

    static {
        ek ekVar = new ek();
        INSTANCE = ekVar;
        ekVar.e(new ck(), new dk());
    }

    private ek() {
    }

    private final void g() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "391244588")) {
            ipChange.ipc$dispatch("391244588", new Object[]{this});
            return;
        }
        String str = d;
        if ((str == null || str.length() == 0) ? true : true) {
            ab1.INSTANCE.e("CloudConfigProxy:defaultGroupName 没有配置使用默认名：cornerstone_config");
            d = "cornerstone_config";
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    public void forceCheckUpdate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1422432825")) {
            ipChange.ipc$dispatch("-1422432825", new Object[]{this});
        } else {
            a().forceCheckUpdate();
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    @Nullable
    public Map<String, String> getAllConfig(@Nullable String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "921122143") ? (Map) ipChange.ipc$dispatch("921122143", new Object[]{this, str}) : a().getAllConfig(str);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    @Nullable
    public <T> T getConfigObj(@Nullable String str, @Nullable String str2, @Nullable Class<T> cls, @Nullable String str3) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1183222035") ? (T) ipChange.ipc$dispatch("-1183222035", new Object[]{this, str, str2, cls, str3}) : (T) a().getConfigObj(str, str2, cls, str3);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    @Nullable
    public String getCustomConfig(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1416689496") ? (String) ipChange.ipc$dispatch("1416689496", new Object[]{this, str, str2}) : a().getCustomConfig(str, str2);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    public float getFloat(@Nullable String str, @Nullable String str2, float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "449155157") ? ((Float) ipChange.ipc$dispatch("449155157", new Object[]{this, str, str2, Float.valueOf(f)})).floatValue() : a().getFloat(str, str2, f);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    public int getInt(@Nullable String str, @Nullable String str2, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1028397394") ? ((Integer) ipChange.ipc$dispatch("-1028397394", new Object[]{this, str, str2, Integer.valueOf(i)})).intValue() : a().getInt(str, str2, i);
    }

    @Nullable
    public final String getString(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1894160938")) {
            return (String) ipChange.ipc$dispatch("-1894160938", new Object[]{this, str, str2});
        }
        g();
        return getString(d, str, str2);
    }

    public final void h(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1740854060")) {
            ipChange.ipc$dispatch("1740854060", new Object[]{this, str});
            return;
        }
        b41.i(str, "defaultGroupName");
        d = str;
    }

    public final void i(@Nullable String[] strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "586645893")) {
            ipChange.ipc$dispatch("586645893", new Object[]{this, strArr});
            return;
        }
        g();
        markCacheableKeys(d, strArr);
    }

    public final boolean isExpected(@Nullable String str, @NotNull String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1824742105")) {
            return ((Boolean) ipChange.ipc$dispatch("1824742105", new Object[]{this, str, str2, Boolean.valueOf(z)})).booleanValue();
        }
        b41.i(str2, "expectedValue");
        g();
        return isExpected(d, str, str2, z);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    public void markCacheableKeys(@Nullable String str, @Nullable String[] strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1474744827")) {
            ipChange.ipc$dispatch("1474744827", new Object[]{this, str, strArr});
        } else {
            a().markCacheableKeys(str, strArr);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    public void registerGroupConfigUpdateListener(@Nullable String str, @Nullable ICloudConfig.OnGroupUpdateListener onGroupUpdateListener, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-420474593")) {
            ipChange.ipc$dispatch("-420474593", new Object[]{this, str, onGroupUpdateListener, Boolean.valueOf(z)});
        } else {
            a().registerGroupConfigUpdateListener(str, onGroupUpdateListener, z);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    public void startCheckAndUpdateCacheableKV() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1333351712")) {
            ipChange.ipc$dispatch("-1333351712", new Object[]{this});
        } else {
            a().startCheckAndUpdateCacheableKV();
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    public void stopCheckAndUpdateCacheableKV() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-535335088")) {
            ipChange.ipc$dispatch("-535335088", new Object[]{this});
        } else {
            a().stopCheckAndUpdateCacheableKV();
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    public void unRegisterGroupConfigUpdateListener(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1557488005")) {
            ipChange.ipc$dispatch("1557488005", new Object[]{this, str});
        } else {
            a().unRegisterGroupConfigUpdateListener(str);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    @Nullable
    public String getString(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1151215564") ? (String) ipChange.ipc$dispatch("1151215564", new Object[]{this, str, str2, str3}) : a().getString(str, str2, str3);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    public boolean isExpected(@Nullable String str, @Nullable String str2, @NotNull String str3, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-202126321")) {
            return ((Boolean) ipChange.ipc$dispatch("-202126321", new Object[]{this, str, str2, str3, Boolean.valueOf(z)})).booleanValue();
        }
        b41.i(str3, "expectedValue");
        return a().isExpected(str, str2, str3, z);
    }
}
