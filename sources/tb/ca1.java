package tb;

import com.alibaba.pictures.cornerstone.protocol.IKVData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ca1 extends hb<IKVData> implements IKVData {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final ca1 INSTANCE;

    static {
        ca1 ca1Var = new ca1();
        INSTANCE = ca1Var;
        hb.f(ca1Var, new aa1("cs_local_orange_kv_data"), null, 2, null);
    }

    private ca1() {
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public boolean containsKey(@Nullable String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1326990792") ? ((Boolean) ipChange.ipc$dispatch("-1326990792", new Object[]{this, str})).booleanValue() : a().containsKey(str);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public boolean getBoolean(@Nullable String str, boolean z) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-344244448") ? ((Boolean) ipChange.ipc$dispatch("-344244448", new Object[]{this, str, Boolean.valueOf(z)})).booleanValue() : a().getBoolean(str, z);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    @Nullable
    public <T> T getConfigObj(@Nullable String str, @Nullable Class<T> cls, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2055856438") ? (T) ipChange.ipc$dispatch("2055856438", new Object[]{this, str, cls, str2}) : (T) a().getConfigObj(str, cls, str2);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public float getFloat(@Nullable String str, float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1802547476") ? ((Float) ipChange.ipc$dispatch("-1802547476", new Object[]{this, str, Float.valueOf(f)})).floatValue() : a().getFloat(str, f);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public int getInt(@Nullable String str, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1351418693") ? ((Integer) ipChange.ipc$dispatch("1351418693", new Object[]{this, str, Integer.valueOf(i)})).intValue() : a().getInt(str, i);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public long getLong(@Nullable String str, long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1482627530") ? ((Long) ipChange.ipc$dispatch("-1482627530", new Object[]{this, str, Long.valueOf(j)})).longValue() : a().getLong(str, j);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    @Nullable
    public String getString(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "853658217") ? (String) ipChange.ipc$dispatch("853658217", new Object[]{this, str, str2}) : a().getString(str, str2);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public boolean isExpected(@Nullable String str, @NotNull String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2018590042")) {
            return ((Boolean) ipChange.ipc$dispatch("-2018590042", new Object[]{this, str, str2, Boolean.valueOf(z)})).booleanValue();
        }
        b41.i(str2, "expectedValue");
        return a().isExpected(str, str2, z);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putBoolean(@Nullable String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "62521859")) {
            ipChange.ipc$dispatch("62521859", new Object[]{this, str, Boolean.valueOf(z)});
        } else {
            a().putBoolean(str, z);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putConfigObj(@Nullable String str, @Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "402208576")) {
            ipChange.ipc$dispatch("402208576", new Object[]{this, str, obj});
        } else {
            a().putConfigObj(str, obj);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putFloat(@Nullable String str, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "798990243")) {
            ipChange.ipc$dispatch("798990243", new Object[]{this, str, Float.valueOf(f)});
        } else {
            a().putFloat(str, f);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putInt(@Nullable String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1559712185")) {
            ipChange.ipc$dispatch("1559712185", new Object[]{this, str, Integer.valueOf(i)});
        } else {
            a().putInt(str, i);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putLong(@Nullable String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "679503035")) {
            ipChange.ipc$dispatch("679503035", new Object[]{this, str, Long.valueOf(j)});
        } else {
            a().putLong(str, j);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putString(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1076293630")) {
            ipChange.ipc$dispatch("1076293630", new Object[]{this, str, str2});
        } else {
            a().putString(str, str2);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void removeKey(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1405806887")) {
            ipChange.ipc$dispatch("-1405806887", new Object[]{this, str});
        } else {
            a().removeKey(str);
        }
    }
}
