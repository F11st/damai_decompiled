package com.taobao.orange.cache;

import android.text.TextUtils;
import com.taobao.orange.ConfigCenter;
import com.taobao.orange.GlobalOrange;
import com.taobao.orange.OConstant;
import com.taobao.orange.OThreadFactory;
import com.taobao.orange.model.ConfigDO;
import com.taobao.orange.model.CustomConfigDO;
import com.taobao.orange.model.NameSpaceDO;
import com.taobao.orange.util.FileUtil;
import com.taobao.orange.util.OLog;
import com.taobao.orange.util.OrangeMonitor;
import com.taobao.orange.util.OrangeUtils;
import com.taobao.orange.util.SPUtil;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ConfigCache {
    private static final String TAG = "ConfigCache";
    private Map<String, ConfigDO> mConfigMap = new ConcurrentHashMap();
    private AtomicInteger mPendingUsedListToSave = new AtomicInteger(0);

    private ConfigDO restoreConfig(NameSpaceDO nameSpaceDO) {
        ConfigDO configDO = (ConfigDO) FileUtil.restoreObject(nameSpaceDO.name);
        if (configDO != null) {
            if (OLog.isPrintLog(1)) {
                if (configDO.candidate == null) {
                    OLog.d(TAG, "restoreConfig", configDO);
                } else {
                    OLog.d(TAG, "restoreAbConfig", configDO);
                }
            }
            return configDO;
        }
        return null;
    }

    private ConfigDO restoreConfigLocked(String str) {
        ConfigDO configDO = (ConfigDO) FileUtil.restoreObjectLocked(str);
        if (configDO != null) {
            if (OLog.isPrintLog(1)) {
                if (configDO.candidate == null) {
                    OLog.d(TAG, "restoreConfigLocked", configDO);
                } else {
                    OLog.d(TAG, "restoreAbConfigLocked", configDO);
                }
            }
            return configDO;
        }
        return null;
    }

    private void updateUsedNamespacesListToLocal() {
        this.mPendingUsedListToSave.incrementAndGet();
        OThreadFactory.executeDisk(new Runnable() { // from class: com.taobao.orange.cache.ConfigCache.2
            @Override // java.lang.Runnable
            public void run() {
                if (ConfigCache.this.mPendingUsedListToSave.getAndSet(0) > 0) {
                    HashSet hashSet = new HashSet(ConfigCache.this.mConfigMap.keySet());
                    SPUtil.saveSetToSharePreference(GlobalOrange.context, OConstant.SP_KEY_USED_LIST, hashSet);
                    OLog.e(ConfigCache.TAG, "save used list success, size", Integer.valueOf(hashSet.size()));
                }
            }
        });
    }

    public void cache(final ConfigDO configDO) {
        this.mConfigMap.put(configDO.name, configDO);
        ConfigCenter.getInstance().notifyListeners(configDO.name, configDO.getCurVersion(), false);
        if (ConfigCenter.getInstance().isAfterIdle.get()) {
            OThreadFactory.executeDisk(new Runnable() { // from class: com.taobao.orange.cache.ConfigCache.1
                @Override // java.lang.Runnable
                public void run() {
                    ConfigDO configDO2 = configDO;
                    FileUtil.persistObject(configDO2, configDO2.name);
                }
            });
        } else {
            configDO.persisted = false;
        }
    }

    public void cacheAndUpdateUsedNamespaceFilterToLocal(ConfigDO configDO) {
        cache(configDO);
        updateUsedNamespacesListToLocal();
    }

    public Map<String, ConfigDO> getConfigMap() {
        return this.mConfigMap;
    }

    public <T> T getConfigObj(String str) {
        ConfigDO configDO = this.mConfigMap.get(str);
        T t = null;
        if (configDO != null) {
            if (NameSpaceDO.TYPE_STANDARD.equals(configDO.type)) {
                t = (T) configDO.content;
            } else if ("CUSTOM".equals(configDO.type)) {
                t = (T) ((CustomConfigDO) configDO).stringContent;
            } else {
                OLog.e(TAG, "getConfigs fail unsupport type", new Object[0]);
            }
            if (!configDO.monitored) {
                OrangeMonitor.commitConfigMonitor(OConstant.POINT_CONFIG_USE, configDO.name, configDO.version);
                configDO.monitored = true;
            }
        }
        return t;
    }

    public Set<NameSpaceDO> load(Set<NameSpaceDO> set) {
        HashSet hashSet = new HashSet();
        if (set != null && !set.isEmpty()) {
            for (NameSpaceDO nameSpaceDO : set) {
                ConfigDO restoreConfig = restoreConfig(nameSpaceDO);
                if (restoreConfig != null) {
                    restoreConfig.persisted = true;
                    this.mConfigMap.put(restoreConfig.name, restoreConfig);
                    ConfigCenter.getInstance().removeFail(restoreConfig.name);
                    ConfigCenter.getInstance().notifyListeners(restoreConfig.name, restoreConfig.getCurVersion(), true);
                    if (restoreConfig.candidate == null && OrangeUtils.parseLong(nameSpaceDO.version) > OrangeUtils.parseLong(restoreConfig.version)) {
                        hashSet.add(nameSpaceDO);
                        OLog.d(TAG, "load not match as version", "name", nameSpaceDO.name);
                    }
                } else if (NameSpaceDO.LEVEL_HIGH.equals(nameSpaceDO.loadLevel)) {
                    hashSet.add(nameSpaceDO);
                }
            }
            return hashSet;
        }
        OLog.w(TAG, "load config cache empty", new Object[0]);
        return null;
    }

    public Set<NameSpaceDO> loadByUseNamespacesFilter(Set<NameSpaceDO> set) {
        ConfigDO restoreConfigLocked;
        HashSet hashSet = new HashSet();
        if (set != null && !set.isEmpty()) {
            Set<String> setFromSharePreference = SPUtil.getSetFromSharePreference(GlobalOrange.context, OConstant.SP_KEY_USED_LIST, new HashSet());
            setFromSharePreference.add("orange");
            for (NameSpaceDO nameSpaceDO : set) {
                if (setFromSharePreference.contains(nameSpaceDO.name) && (restoreConfigLocked = restoreConfigLocked(nameSpaceDO.name)) != null) {
                    restoreConfigLocked.persisted = true;
                    this.mConfigMap.put(restoreConfigLocked.name, restoreConfigLocked);
                    ConfigCenter.getInstance().removeFail(restoreConfigLocked.name);
                    ConfigCenter.getInstance().notifyListeners(restoreConfigLocked.name, restoreConfigLocked.getCurVersion(), true);
                    if (restoreConfigLocked.candidate == null && OrangeUtils.parseLong(nameSpaceDO.version) > OrangeUtils.parseLong(restoreConfigLocked.version)) {
                        hashSet.add(nameSpaceDO);
                        OLog.d(TAG, "load not match as version", "name", nameSpaceDO.name);
                    }
                }
            }
            return hashSet;
        }
        OLog.w(TAG, "load config cache empty", new Object[0]);
        return null;
    }

    public void remove(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        FileUtil.deleteConfigFile(str);
    }
}
