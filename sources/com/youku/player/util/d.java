package com.youku.player.util;

import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.media.arch.instruments.GetterFactory;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class d {
    private ConfigFetcher.ConfigGetter a;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    private static class a {
        private static final d a = new d();
    }

    /* compiled from: Taobao */
    @Deprecated
    /* loaded from: classes13.dex */
    public interface b {
    }

    private d() {
        this.a = new ConfigFetcher.ConfigGetter() { // from class: com.youku.player.util.d.1
            @Override // com.youku.media.arch.instruments.ConfigFetcher.ConfigGetter
            public String getConfig(String str, String str2, String str3) {
                return str3;
            }

            @Override // com.youku.media.arch.instruments.ConfigFetcher.ConfigGetter
            public Map<String, String> getConfigs(String str) {
                return null;
            }

            @Override // com.youku.media.arch.instruments.ConfigFetcher.ConfigGetter
            public void registerConfigUpdateListener(String[] strArr, ConfigFetcher.OnConfigUpdatedListener onConfigUpdatedListener) {
            }

            @Override // com.youku.media.arch.instruments.ConfigFetcher.ConfigGetter
            public void unregisterConfigUpdateListener(String[] strArr) {
            }
        };
        a((b) null);
        a((ConfigFetcher.ConfigGetter) null);
    }

    public static d a() {
        return a.a;
    }

    public String a(String str, String str2, String str3) {
        c.a("OrangeConfigProxy", "getConfig, namespace=%s, key=%s, defVal=%s", str, str2, str3);
        return ConfigFetcher.getInstance() == null ? str3 : ConfigFetcher.getInstance().getConfig(str, str2, str3);
    }

    public Map<String, String> a(String str) {
        c.a("OrangeConfigProxy", "getConfigs, namespace=%s", str);
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("get configs from namespace:");
            sb.append(str);
            sb.append(", fetcher:");
            String str2 = "null";
            sb.append(ConfigFetcher.getInstance() == null ? "null" : ConfigFetcher.getInstance().toString());
            TLogUtilNative.loge("OrangeConfigProxy", sb.toString());
            if (ConfigFetcher.getInstance() != null) {
                GetterFactory getterFactory = ConfigFetcher.getInstance().getGetterFactory();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("config factory:");
                sb2.append(getterFactory == null ? "null" : getterFactory.toString());
                TLogUtilNative.loge("OrangeConfigProxy", sb2.toString());
                if (getterFactory != null) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("config getter:");
                    if (getterFactory.getGetter() != null) {
                        str2 = getterFactory.getGetter().toString();
                    }
                    sb3.append(str2);
                    TLogUtilNative.loge("OrangeConfigProxy", sb3.toString());
                }
            }
        } catch (Throwable unused) {
        }
        return ConfigFetcher.getInstance() == null ? new HashMap() : ConfigFetcher.getInstance().getConfigs(str);
    }

    public void a(ConfigFetcher.ConfigGetter configGetter) {
    }

    @Deprecated
    public void a(b bVar) {
    }
}
