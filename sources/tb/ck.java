package tb;

import com.alibaba.pictures.cornerstone.protocol.ICloudConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OConfigListener;
import com.taobao.orange.OrangeConfig;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.ArraysKt___ArraysKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ck implements ICloudConfig, OConfigListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String a = "Orange.";
    private Map<String, String[]> b = new HashMap();

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a implements OConfigListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ICloudConfig.OnGroupUpdateListener a;

        a(ICloudConfig.OnGroupUpdateListener onGroupUpdateListener) {
            this.a = onGroupUpdateListener;
        }

        @Override // com.taobao.orange.OConfigListener
        public void onConfigUpdate(@Nullable String str, @Nullable Map<String, String> map) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "1180356548")) {
                ipChange.ipc$dispatch("1180356548", new Object[]{this, str, map});
                return;
            }
            if (str == null || str.length() == 0) {
                return;
            }
            if (map != null && !map.isEmpty()) {
                z = false;
            }
            if (z) {
                return;
            }
            this.a.onUpdate(str, map);
        }
    }

    private final String a(String str, String str2) {
        String[] strArr;
        boolean r;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1503858196")) {
            return (String) ipChange.ipc$dispatch("-1503858196", new Object[]{this, str, str2});
        }
        if (!((str2 == null || str2.length() == 0) ? true : true) && (strArr = this.b.get(str)) != null) {
            r = ArraysKt___ArraysKt.r(strArr, str2);
            if (r) {
                ab1 ab1Var = ab1.INSTANCE;
                ab1Var.d("CloudConfigImpl", "getCacheableValueByKey:groupName=" + str + ",key=" + str2 + ",cacheable=true");
                ca1 ca1Var = ca1.INSTANCE;
                return ca1Var.getString(this.a + str2, null);
            }
        }
        return null;
    }

    private final void b(String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-36706301")) {
            ipChange.ipc$dispatch("-36706301", new Object[]{this, str});
            return;
        }
        if (str == null || str.length() == 0) {
            return;
        }
        String[] strArr = this.b.get(str);
        Map<String, String> allConfig = getAllConfig(str);
        if (t6.INSTANCE.debugable()) {
            ab1.INSTANCE.d("CloudConfigImpl", "updateCacheKeysValue:groupName=" + str + ",allConfig==" + w41.INSTANCE.toJsonString(allConfig) + "||cacheableKeys==null");
        }
        if (allConfig == null || allConfig.isEmpty()) {
            return;
        }
        if (strArr != null) {
            if (!(strArr.length == 0)) {
                z = false;
            }
        }
        if (z) {
            return;
        }
        for (String str2 : strArr) {
            String str3 = allConfig.get(str2);
            if (str3 == null) {
                ca1.INSTANCE.removeKey(this.a + str2);
            } else {
                ca1.INSTANCE.putString(this.a + str2, str3);
            }
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    public void forceCheckUpdate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-829564201")) {
            ipChange.ipc$dispatch("-829564201", new Object[]{this});
        } else {
            OrangeConfig.getInstance().forceCheckUpdate();
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    @Nullable
    public Map<String, String> getAllConfig(@Nullable String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1247120785")) {
            return (Map) ipChange.ipc$dispatch("-1247120785", new Object[]{this, str});
        }
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            return null;
        }
        return OrangeConfig.getInstance().getConfigs(str);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    @Nullable
    public <T> T getConfigObj(@Nullable String str, @Nullable String str2, @Nullable Class<T> cls, @Nullable String str3) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1297988611")) {
            return (T) ipChange.ipc$dispatch("-1297988611", new Object[]{this, str, str2, cls, str3});
        }
        String string = getString(str, str2, str3);
        if (string != null && string.length() != 0) {
            z = false;
        }
        if (!z && cls != null) {
            try {
                return (T) w41.INSTANCE.parseJson(string, (Class<Object>) cls);
            } catch (Exception e) {
                ab1 ab1Var = ab1.INSTANCE;
                ab1Var.e("CloudConfigImpl", "getConfigObj():" + e);
            }
        }
        return null;
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    @Nullable
    public String getCustomConfig(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1066533992")) {
            return (String) ipChange.ipc$dispatch("1066533992", new Object[]{this, str, str2});
        }
        if (str != null && str.length() != 0) {
            z = false;
        }
        return z ? str2 : OrangeConfig.getInstance().getCustomConfig(str, str2);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    public float getFloat(@Nullable String str, @Nullable String str2, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1953101125")) {
            return ((Float) ipChange.ipc$dispatch("1953101125", new Object[]{this, str, str2, Float.valueOf(f)})).floatValue();
        }
        String string = getString(str, str2, null);
        if (string != null) {
            try {
                return Float.parseFloat(string);
            } catch (Exception e) {
                ab1 ab1Var = ab1.INSTANCE;
                ab1Var.e("CloudConfigImpl", "getFloat():" + e);
                return f;
            }
        }
        return f;
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    public int getInt(@Nullable String str, @Nullable String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-821246050")) {
            return ((Integer) ipChange.ipc$dispatch("-821246050", new Object[]{this, str, str2, Integer.valueOf(i)})).intValue();
        }
        String string = getString(str, str2, null);
        if (string != null) {
            try {
                return Integer.parseInt(string);
            } catch (Exception e) {
                ab1 ab1Var = ab1.INSTANCE;
                ab1Var.e("CloudConfigImpl", "getInt()," + e);
                return i;
            }
        }
        return i;
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    @Nullable
    public String getString(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "365173980")) {
            return (String) ipChange.ipc$dispatch("365173980", new Object[]{this, str, str2, str3});
        }
        if (str == null || str.length() == 0) {
            return str3;
        }
        if (str2 != null && str2.length() != 0) {
            z = false;
        }
        if (z) {
            return str3;
        }
        String config = OrangeConfig.getInstance().getConfig(str, str2, null);
        ab1 ab1Var = ab1.INSTANCE;
        ab1Var.d("CloudConfigImpl", "getString:groupName=" + str + ":key=" + str2 + ",cloudValue=" + config);
        if (config == null) {
            config = a(str, str2);
            ab1Var.d("CloudConfigImpl", "key=" + str2 + ",miss cloud value,cacheValue=" + config);
        }
        return config != null ? config : str3;
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    public boolean isExpected(@Nullable String str, @Nullable String str2, @NotNull String str3, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1562093313")) {
            return ((Boolean) ipChange.ipc$dispatch("-1562093313", new Object[]{this, str, str2, str3, Boolean.valueOf(z)})).booleanValue();
        }
        b41.i(str3, "expectedValue");
        String string = getString(str, str2, null);
        return string != null ? b41.d(string, str3) : z;
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    public void markCacheableKeys(@Nullable String str, @Nullable String[] strArr) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1271724811")) {
            ipChange.ipc$dispatch("1271724811", new Object[]{this, str, strArr});
            return;
        }
        if (str == null || str.length() == 0) {
            return;
        }
        if (strArr != null) {
            if (!(strArr.length == 0)) {
                z = false;
            }
        }
        if (z) {
            return;
        }
        this.b.put(str, strArr);
    }

    @Override // com.taobao.orange.OConfigListener
    public void onConfigUpdate(@Nullable String str, @Nullable Map<String, String> map) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1001324888")) {
            ipChange.ipc$dispatch("-1001324888", new Object[]{this, str, map});
            return;
        }
        if (str == null || str.length() == 0) {
            return;
        }
        if (map != null && !map.isEmpty()) {
            z = false;
        }
        if (z) {
            return;
        }
        ab1 ab1Var = ab1.INSTANCE;
        ab1Var.d("CloudConfigImpl", "onUpdate:groupName=" + str);
        b(str);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    public void registerGroupConfigUpdateListener(@Nullable String str, @Nullable ICloudConfig.OnGroupUpdateListener onGroupUpdateListener, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "553689647")) {
            ipChange.ipc$dispatch("553689647", new Object[]{this, str, onGroupUpdateListener, Boolean.valueOf(z)});
        } else if (str == null || onGroupUpdateListener == null) {
        } else {
            OrangeConfig.getInstance().registerListener(new String[]{str}, new a(onGroupUpdateListener), z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
        return;
     */
    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void startCheckAndUpdateCacheableKV() {
        /*
            r5 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = tb.ck.$ipChange
            java.lang.String r1 = "715326448"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L14
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r4] = r5
            r0.ipc$dispatch(r1, r2)
            return
        L14:
            java.util.Map<java.lang.String, java.lang.String[]> r0 = r5.b     // Catch: java.lang.Exception -> L4f
            if (r0 == 0) goto L20
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Exception -> L4f
            if (r0 == 0) goto L1f
            goto L20
        L1f:
            r3 = 0
        L20:
            if (r3 == 0) goto L23
            return
        L23:
            java.util.Map<java.lang.String, java.lang.String[]> r0 = r5.b     // Catch: java.lang.Exception -> L4f
            java.util.Set r0 = r0.keySet()     // Catch: java.lang.Exception -> L4f
            java.lang.String[] r1 = new java.lang.String[r4]     // Catch: java.lang.Exception -> L4f
            java.lang.Object[] r0 = r0.toArray(r1)     // Catch: java.lang.Exception -> L4f
            if (r0 == 0) goto L47
            java.lang.String[] r0 = (java.lang.String[]) r0     // Catch: java.lang.Exception -> L4f
            int r1 = r0.length     // Catch: java.lang.Exception -> L4f
            r2 = 0
        L35:
            if (r2 >= r1) goto L3f
            r3 = r0[r2]     // Catch: java.lang.Exception -> L4f
            r5.b(r3)     // Catch: java.lang.Exception -> L4f
            int r2 = r2 + 1
            goto L35
        L3f:
            com.taobao.orange.OrangeConfig r1 = com.taobao.orange.OrangeConfig.getInstance()     // Catch: java.lang.Exception -> L4f
            r1.registerListener(r0, r5, r4)     // Catch: java.lang.Exception -> L4f
            goto L68
        L47:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch: java.lang.Exception -> L4f
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T>"
            r0.<init>(r1)     // Catch: java.lang.Exception -> L4f
            throw r0     // Catch: java.lang.Exception -> L4f
        L4f:
            r0 = move-exception
            tb.ab1 r1 = tb.ab1.INSTANCE
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "startCheckAndUpdateCacheableKV:"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r2 = "CloudConfigImpl"
            r1.e(r2, r0)
        L68:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.ck.startCheckAndUpdateCacheableKV():void");
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    public void stopCheckAndUpdateCacheableKV() {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-746343360")) {
            ipChange.ipc$dispatch("-746343360", new Object[]{this});
            return;
        }
        Map<String, String[]> map = this.b;
        if (map != null && !map.isEmpty()) {
            z = false;
        }
        if (z) {
            return;
        }
        Object[] array = this.b.keySet().toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        OrangeConfig.getInstance().unregisterListener((String[]) array, this);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig
    public void unRegisterGroupConfigUpdateListener(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1912744331")) {
            ipChange.ipc$dispatch("-1912744331", new Object[]{this, str});
        } else if (str == null) {
        } else {
            OrangeConfig.getInstance().unregisterListener(new String[]{str});
        }
    }
}
