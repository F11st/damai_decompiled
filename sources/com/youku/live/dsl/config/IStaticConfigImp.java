package com.youku.live.dsl.config;

import android.app.Application;
import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.arch.Arch;
import com.youku.live.arch.utils.AssetUtils;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IStaticConfigImp implements IStaticConfig {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String STATIC_CONFIG_ASSETS_FILE_NAME = "yklive_static_config.json";
    private volatile boolean isInit = false;
    private volatile JSONObject staticConfigJsonObject = null;

    private String getStringInternal(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1747058064")) {
            return (String) ipChange.ipc$dispatch("1747058064", new Object[]{this, str, str2, str3});
        }
        if (!this.isInit) {
            Application app2 = Arch.getApp();
            JSONObject jSONObject = null;
            Context applicationContext = app2 != null ? app2.getApplicationContext() : null;
            String readContent = applicationContext != null ? AssetUtils.readContent(applicationContext, "yklive_static_config.json") : null;
            if (readContent != null) {
                try {
                    jSONObject = new JSONObject(readContent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (jSONObject == null) {
                synchronized (this) {
                    if (!this.isInit) {
                        this.staticConfigJsonObject = jSONObject;
                        this.isInit = true;
                    }
                }
            }
        }
        if (this.staticConfigJsonObject != null) {
            try {
                return this.staticConfigJsonObject.getJSONObject(str).getString(str3);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return str3;
            } catch (Throwable th) {
                th.printStackTrace();
                return str3;
            }
        }
        return str3;
    }

    @Override // com.youku.live.dsl.config.IConfigBase
    public boolean getBoolean(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "517021378")) {
            return ((Boolean) ipChange.ipc$dispatch("517021378", new Object[]{this, str, str2, Boolean.valueOf(z)})).booleanValue();
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
        if (AndroidInstantRuntime.support(ipChange, "-693896183")) {
            return ((Double) ipChange.ipc$dispatch("-693896183", new Object[]{this, str, str2, Double.valueOf(d)})).doubleValue();
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
        if (AndroidInstantRuntime.support(ipChange, "518943886")) {
            return ((Float) ipChange.ipc$dispatch("518943886", new Object[]{this, str, str2, Float.valueOf(f)})).floatValue();
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
        if (AndroidInstantRuntime.support(ipChange, "1107985703")) {
            return ((Integer) ipChange.ipc$dispatch("1107985703", new Object[]{this, str, str2, Integer.valueOf(i)})).intValue();
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
        if (AndroidInstantRuntime.support(ipChange, "-1722085504")) {
            return ((Long) ipChange.ipc$dispatch("-1722085504", new Object[]{this, str, str2, Long.valueOf(j)})).longValue();
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
        if (AndroidInstantRuntime.support(ipChange, "-1078046477")) {
            return (String) ipChange.ipc$dispatch("-1078046477", new Object[]{this, str, str2, str3});
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
        if (AndroidInstantRuntime.support(ipChange, "-440832958")) {
            return (String[]) ipChange.ipc$dispatch("-440832958", new Object[]{this, str, str2, strArr, str3});
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
        if (AndroidInstantRuntime.support(ipChange, "-146322570")) {
            return (List) ipChange.ipc$dispatch("-146322570", new Object[]{this, str, str2, list, str3});
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
