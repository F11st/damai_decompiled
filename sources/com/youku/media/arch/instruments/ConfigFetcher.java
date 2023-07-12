package com.youku.media.arch.instruments;

import com.youku.media.arch.instruments.GetterFactory;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import com.youku.media.arch.instruments.utils.Logger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class ConfigFetcher {
    private static final String TAG = "ConfigFetcher";
    private static ConfigFetcher sConfigFetcher;
    private static GetterFactory.Provider sGetterFactoryProvider;
    private CachedConfigGetter mCachedConfigGetter;
    private GetterFactory mGetterFactory;
    private OnConfigUpdatedListener mOnConfigUpdatedListener;
    private ConfigGetter mRealGetter;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class CachedConfigGetter implements ConfigGetter {
        private static final int DEFAULT_LENGTH = 5;
        private WeakReference<ConfigFetcher> mFetcherRef;
        private ConfigGetter mGetter;
        private ArrayList<String> CACHED_NAMESPACES = new ArrayList<>();
        private final ArrayList<Map<String, String>> mNamespaceValues = new ArrayList<>();
        private List<String> mPendingCacheNamespaces = new ArrayList();
        private OnConfigUpdatedListener mDefaultConfigUpdateListener = new OnConfigUpdatedListener() { // from class: com.youku.media.arch.instruments.ConfigFetcher.CachedConfigGetter.1
            @Override // com.youku.media.arch.instruments.ConfigFetcher.OnConfigUpdatedListener
            public void onBatchConfigsUpdate(String str, Map<String, String> map) {
                ConfigFetcher configFetcher;
                if (CachedConfigGetter.this.mFetcherRef != null && (configFetcher = (ConfigFetcher) CachedConfigGetter.this.mFetcherRef.get()) != null && configFetcher.mOnConfigUpdatedListener != null) {
                    configFetcher.mOnConfigUpdatedListener.onBatchConfigsUpdate(str, map);
                }
                if (str == null || map == null) {
                    return;
                }
                for (String str2 : map.keySet()) {
                    Map namespaceValueMap = CachedConfigGetter.this.getNamespaceValueMap(str);
                    if (namespaceValueMap != null) {
                        namespaceValueMap.put(str2, map.get(str2));
                    }
                }
            }

            @Override // com.youku.media.arch.instruments.ConfigFetcher.OnConfigUpdatedListener
            public void onConfigUpdate(String str, String str2, String str3) {
                Map namespaceValueMap;
                ConfigFetcher configFetcher;
                if (CachedConfigGetter.this.mFetcherRef != null && (configFetcher = (ConfigFetcher) CachedConfigGetter.this.mFetcherRef.get()) != null && configFetcher.mOnConfigUpdatedListener != null) {
                    configFetcher.mOnConfigUpdatedListener.onConfigUpdate(str, str2, str3);
                }
                if (str == null || str2 == null || str3 == null || (namespaceValueMap = CachedConfigGetter.this.getNamespaceValueMap(str)) == null) {
                    return;
                }
                namespaceValueMap.put(str2, str3);
            }
        };

        public CachedConfigGetter() {
        }

        public CachedConfigGetter(ConfigFetcher configFetcher) {
            if (configFetcher != null) {
                this.mFetcherRef = new WeakReference<>(configFetcher);
            }
        }

        private boolean checkCacheNamespace(String str) {
            return this.mNamespaceValues.indexOf(str) != -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getNamespaceValueMap(String str) {
            int indexOf = this.mNamespaceValues.indexOf(str);
            if (indexOf != -1) {
                Map<String, String> map = this.mNamespaceValues.get(indexOf);
                if (map == null) {
                    synchronized (this) {
                        map = this.mNamespaceValues.get(indexOf);
                        if (map == null) {
                            map = new HashMap<>();
                            this.mNamespaceValues.set(indexOf, map);
                        }
                    }
                }
                return map;
            }
            return null;
        }

        public void addCacheNamespace(String str) {
            if (checkCacheNamespace(str)) {
                return;
            }
            synchronized (this) {
                this.CACHED_NAMESPACES.add(str);
                this.mNamespaceValues.ensureCapacity(this.CACHED_NAMESPACES.size());
                while (this.mNamespaceValues.size() < this.CACHED_NAMESPACES.size()) {
                    this.mNamespaceValues.add(null);
                }
                this.mNamespaceValues.set(this.CACHED_NAMESPACES.indexOf(str), new HashMap());
                ConfigGetter configGetter = this.mGetter;
                if (configGetter != null) {
                    configGetter.registerConfigUpdateListener(new String[]{str}, this.mDefaultConfigUpdateListener);
                } else {
                    this.mPendingCacheNamespaces.add(str);
                }
            }
        }

        @Override // com.youku.media.arch.instruments.ConfigFetcher.ConfigGetter
        public String getConfig(String str, String str2, String str3) {
            if (this.mGetter == null) {
                Logger.t(ConfigFetcher.TAG, "mGetter is null", new Object[0]);
                return str3;
            }
            ConfigReporter.getInstance().commitBit(ConfigReporter.BIT_GETTER_IMP);
            Map<String, String> namespaceValueMap = getNamespaceValueMap(str);
            if (namespaceValueMap == null) {
                Logger.t(ConfigFetcher.TAG, "not matching value map", new Object[0]);
                return this.mGetter.getConfig(str, str2, str3);
            }
            ConfigReporter.getInstance().commitBit(33554432);
            Logger.t(ConfigFetcher.TAG, "matching value map", new Object[0]);
            if (namespaceValueMap.containsKey(str2)) {
                Logger.t(ConfigFetcher.TAG, "value map key found", new Object[0]);
                return namespaceValueMap.get(str2);
            }
            Logger.t(ConfigFetcher.TAG, "value map key not found", new Object[0]);
            String config = this.mGetter.getConfig(str, str2, str3);
            synchronized (this) {
                namespaceValueMap.put(str2, config);
            }
            return config;
        }

        @Override // com.youku.media.arch.instruments.ConfigFetcher.ConfigGetter
        public Map<String, String> getConfigs(String str) {
            ConfigGetter configGetter = this.mGetter;
            if (configGetter != null) {
                return configGetter.getConfigs(str);
            }
            return null;
        }

        public ConfigGetter getGetter() {
            return this.mGetter;
        }

        @Override // com.youku.media.arch.instruments.ConfigFetcher.ConfigGetter
        public void registerConfigUpdateListener(String[] strArr, OnConfigUpdatedListener onConfigUpdatedListener) {
            this.mGetter.registerConfigUpdateListener(strArr, onConfigUpdatedListener);
        }

        public void removeCacheNamespace(String str) {
            if (checkCacheNamespace(str)) {
                synchronized (this) {
                    this.mNamespaceValues.remove(this.CACHED_NAMESPACES.indexOf(str));
                    this.CACHED_NAMESPACES.remove(str);
                    ConfigGetter configGetter = this.mGetter;
                    if (configGetter != null) {
                        configGetter.unregisterConfigUpdateListener(new String[]{str});
                    }
                }
            }
        }

        public void setGetter(ConfigGetter configGetter) {
            List<String> list;
            this.mGetter = configGetter;
            if (configGetter == null || (list = this.mPendingCacheNamespaces) == null || list.size() <= 0) {
                return;
            }
            synchronized (this) {
                for (String str : this.mPendingCacheNamespaces) {
                    addCacheNamespace(str);
                }
                this.mPendingCacheNamespaces.clear();
            }
        }

        @Override // com.youku.media.arch.instruments.ConfigFetcher.ConfigGetter
        public void unregisterConfigUpdateListener(String[] strArr) {
            this.mGetter.unregisterConfigUpdateListener(strArr);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface ConfigGetter {
        String getConfig(String str, String str2, String str3);

        Map<String, String> getConfigs(String str);

        void registerConfigUpdateListener(String[] strArr, OnConfigUpdatedListener onConfigUpdatedListener);

        void unregisterConfigUpdateListener(String[] strArr);
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface OnConfigUpdatedListener {
        void onBatchConfigsUpdate(String str, Map<String, String> map);

        void onConfigUpdate(String str, String str2, String str3);
    }

    public ConfigFetcher() {
        CachedConfigGetter cachedConfigGetter = new CachedConfigGetter();
        this.mCachedConfigGetter = cachedConfigGetter;
        this.mRealGetter = cachedConfigGetter;
        ensureGetterFactory();
    }

    private void ensureGetterFactory() {
        GetterFactory.Provider provider;
        CachedConfigGetter cachedConfigGetter;
        if (this.mGetterFactory != null || (provider = sGetterFactoryProvider) == null) {
            return;
        }
        GetterFactory factory = provider.getFactory();
        this.mGetterFactory = factory;
        if (factory == null || (cachedConfigGetter = this.mCachedConfigGetter) == null || cachedConfigGetter.getGetter() != null) {
            return;
        }
        this.mCachedConfigGetter.setGetter(this.mGetterFactory.getGetter());
    }

    public static GetterFactory.Provider getGlobalProvider() {
        return sGetterFactoryProvider;
    }

    public static ConfigFetcher getInstance() {
        if (sConfigFetcher == null) {
            synchronized (ConfigFetcher.class) {
                if (sConfigFetcher == null) {
                    ConfigFetcher configFetcher = new ConfigFetcher();
                    sConfigFetcher = configFetcher;
                    GetterFactory getterFactory = configFetcher.mGetterFactory;
                    if (getterFactory != null) {
                        getterFactory.fillinPersistentNamespaces(configFetcher);
                    }
                }
            }
        }
        return sConfigFetcher;
    }

    public static void init(GetterFactory.Provider provider) {
        sGetterFactoryProvider = provider;
        getInstance().ensureGetterFactory();
    }

    public void addCacheNamespace(String str) {
        GetterFactory getterFactory = this.mGetterFactory;
        if (getterFactory != null) {
            getterFactory.notifyCachedNamespaceAdded(str);
        }
        GetterFactory getterFactory2 = this.mGetterFactory;
        if (getterFactory2 == null || !getterFactory2.skipDefaultCache()) {
            this.mCachedConfigGetter.addCacheNamespace(str);
        }
    }

    public final String getConfig(String str, String str2, String str3) {
        ConfigReporter.getInstance().clear(ConfigReporter.CFG_ROUTE_MASK);
        if (this.mRealGetter != null) {
            ConfigReporter.getInstance().commitBit(134217728);
            if (this.mRealGetter instanceof CachedConfigGetter) {
                ConfigReporter.getInstance().commitBit(268435456);
            }
        }
        return this.mRealGetter.getConfig(str, str2, str3);
    }

    public final Map<String, String> getConfigs(String str) {
        ensureGetterFactory();
        return this.mRealGetter.getConfigs(str);
    }

    public GetterFactory getGetterFactory() {
        return this.mGetterFactory;
    }

    public void removeCacheNamespace(String str) {
        GetterFactory getterFactory = this.mGetterFactory;
        if (getterFactory != null) {
            getterFactory.notifyCachedNamespaceRemoved(str);
        }
        GetterFactory getterFactory2 = this.mGetterFactory;
        if (getterFactory2 == null || !getterFactory2.skipDefaultCache()) {
            this.mCachedConfigGetter.removeCacheNamespace(str);
        }
    }

    public void setOnConfigUpdatedListener(OnConfigUpdatedListener onConfigUpdatedListener) {
        this.mOnConfigUpdatedListener = onConfigUpdatedListener;
        CachedConfigGetter cachedConfigGetter = this.mCachedConfigGetter;
        if (cachedConfigGetter != null) {
            cachedConfigGetter.mFetcherRef = new WeakReference(this);
        }
    }
}
