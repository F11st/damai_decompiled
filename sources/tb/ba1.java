package tb;

import com.alibaba.pictures.cornerstone.protocol.IKVData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ba1 extends hb<IKVData> implements IKVData {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final ba1 INSTANCE = new ba1();
    @NotNull
    private static String d = "cs_local_kv_data";

    private ba1() {
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public boolean containsKey(@Nullable String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "471218154") ? ((Boolean) ipChange.ipc$dispatch("471218154", new Object[]{this, str})).booleanValue() : g().containsKey(str);
    }

    @NotNull
    protected IKVData g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-682755129")) {
            return (IKVData) ipChange.ipc$dispatch("-682755129", new Object[]{this});
        }
        if (b() == null) {
            hb.f(this, new aa1(d), null, 2, null);
        }
        return (IKVData) super.a();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public boolean getBoolean(@Nullable String str, boolean z) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1453964498") ? ((Boolean) ipChange.ipc$dispatch("1453964498", new Object[]{this, str, Boolean.valueOf(z)})).booleanValue() : g().getBoolean(str, z);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    @Nullable
    public <T> T getConfigObj(@Nullable String str, @Nullable Class<T> cls, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1141739204") ? (T) ipChange.ipc$dispatch("1141739204", new Object[]{this, str, cls, str2}) : (T) g().getConfigObj(str, cls, str2);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public float getFloat(@Nullable String str, float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "340103454") ? ((Float) ipChange.ipc$dispatch("340103454", new Object[]{this, str, Float.valueOf(f)})).floatValue() : g().getFloat(str, f);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public int getInt(@Nullable String str, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1425156599") ? ((Integer) ipChange.ipc$dispatch("1425156599", new Object[]{this, str, Integer.valueOf(i)})).intValue() : g().getInt(str, i);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public long getLong(@Nullable String str, long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "803247556") ? ((Long) ipChange.ipc$dispatch("803247556", new Object[]{this, str, Long.valueOf(j)})).longValue() : g().getLong(str, j);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    @Nullable
    public String getString(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1749895927") ? (String) ipChange.ipc$dispatch("1749895927", new Object[]{this, str, str2}) : g().getString(str, str2);
    }

    public final void h(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1543711589")) {
            ipChange.ipc$dispatch("-1543711589", new Object[]{this, str});
            return;
        }
        b41.i(str, "<set-?>");
        d = str;
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public boolean isExpected(@Nullable String str, @NotNull String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-175114280")) {
            return ((Boolean) ipChange.ipc$dispatch("-175114280", new Object[]{this, str, str2, Boolean.valueOf(z)})).booleanValue();
        }
        b41.i(str2, "expectedValue");
        return g().isExpected(str, str2, z);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putBoolean(@Nullable String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1860730805")) {
            ipChange.ipc$dispatch("1860730805", new Object[]{this, str, Boolean.valueOf(z)});
        } else {
            g().putBoolean(str, z);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putConfigObj(@Nullable String str, @Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1715382350")) {
            ipChange.ipc$dispatch("1715382350", new Object[]{this, str, obj});
        } else {
            g().putConfigObj(str, obj);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putFloat(@Nullable String str, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1353326123")) {
            ipChange.ipc$dispatch("-1353326123", new Object[]{this, str, Float.valueOf(f)});
        } else {
            g().putFloat(str, f);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putInt(@Nullable String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1633450091")) {
            ipChange.ipc$dispatch("1633450091", new Object[]{this, str, Integer.valueOf(i)});
        } else {
            g().putInt(str, i);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putLong(@Nullable String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1329589175")) {
            ipChange.ipc$dispatch("-1329589175", new Object[]{this, str, Long.valueOf(j)});
        } else {
            g().putLong(str, j);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void putString(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1764243024")) {
            ipChange.ipc$dispatch("-1764243024", new Object[]{this, str, str2});
        } else {
            g().putString(str, str2);
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IKVData
    public void removeKey(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "736844043")) {
            ipChange.ipc$dispatch("736844043", new Object[]{this, str});
        } else {
            g().removeKey(str);
        }
    }
}
