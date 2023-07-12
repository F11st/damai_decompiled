package com.ut.mini.module.plugin;

import android.text.TextUtils;
import com.alibaba.analytics.core.config.UTClientConfigMgr;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.fastjson.JSON;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class UTPluginConfigMgr {
    private static final String TAG = "UTPluginConfigMgr";
    private UTPluginConfig utPluginConfig = null;
    private UTPlugin2Config utPlugin2Config = new UTPlugin2Config();
    private Map<String, UTPlugin> allUTPluginMap = new ConcurrentHashMap();
    private Map<String, UTPlugin> openUTPluginMap = new ConcurrentHashMap();
    private Map<String, UTPlugin> openAsyncUTPluginMap = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public UTPluginConfigMgr() {
        UTClientConfigMgr.d().f(new UTClientConfigMgr.IConfigChangeListener() { // from class: com.ut.mini.module.plugin.UTPluginConfigMgr.1
            @Override // com.alibaba.analytics.core.config.UTClientConfigMgr.IConfigChangeListener
            public String getKey() {
                return "plugin";
            }

            @Override // com.alibaba.analytics.core.config.UTClientConfigMgr.IConfigChangeListener
            public void onChange(String str) {
                UTPluginConfigMgr.this.parseUTPluginConfig(str);
            }
        });
        UTClientConfigMgr.d().f(new UTClientConfigMgr.IConfigChangeListener() { // from class: com.ut.mini.module.plugin.UTPluginConfigMgr.2
            @Override // com.alibaba.analytics.core.config.UTClientConfigMgr.IConfigChangeListener
            public String getKey() {
                return "plugin2";
            }

            @Override // com.alibaba.analytics.core.config.UTClientConfigMgr.IConfigChangeListener
            public void onChange(String str) {
                UTPluginConfigMgr.this.parseUTPlugin2Config(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void parseUTPlugin2Config(String str) {
        Logger.f(TAG, "parseUTPlugin2Config", str);
        try {
            this.utPlugin2Config.plugin2ConfigMap = (Map) JSON.parseObject(str, Map.class);
        } catch (Exception unused) {
            this.utPlugin2Config.plugin2ConfigMap = null;
        }
        for (Map.Entry<String, UTPlugin> entry : this.allUTPluginMap.entrySet()) {
            String key = entry.getKey();
            if (this.utPlugin2Config.containPluginName(key)) {
                entry.getValue().setUTPluginParam(false, this.utPlugin2Config.isSync(key), this.utPlugin2Config.getWritableKeyList(key), this.utPlugin2Config.getUtparamCntList(key));
            }
        }
        Iterator<Map.Entry<String, UTPlugin>> it = this.openUTPluginMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, UTPlugin> next = it.next();
            String key2 = next.getKey();
            if (this.utPlugin2Config.containPluginName(key2)) {
                UTPlugin value = next.getValue();
                if (!value.isSyncMessage()) {
                    it.remove();
                    this.openAsyncUTPluginMap.put(key2, value);
                    Logger.f(TAG, "move openUTPluginMap to openAsyncUTPluginMap", key2);
                }
            }
        }
        Iterator<Map.Entry<String, UTPlugin>> it2 = this.openAsyncUTPluginMap.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry<String, UTPlugin> next2 = it2.next();
            String key3 = next2.getKey();
            if (this.utPlugin2Config.containPluginName(key3)) {
                UTPlugin value2 = next2.getValue();
                if (value2.isSyncMessage()) {
                    it2.remove();
                    this.openUTPluginMap.put(key3, value2);
                    Logger.f(TAG, "move openAsyncUTPluginMap to openUTPluginMap", key3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void parseUTPluginConfig(String str) {
        Logger.f(TAG, "parseUTPluginConfig", str);
        try {
            this.utPluginConfig = (UTPluginConfig) JSON.parseObject(str, UTPluginConfig.class);
        } catch (Exception unused) {
            this.utPluginConfig = null;
        }
        for (Map.Entry<String, UTPlugin> entry : this.allUTPluginMap.entrySet()) {
            String key = entry.getKey();
            if (!isOpen(key)) {
                this.openUTPluginMap.remove(key);
                this.openAsyncUTPluginMap.remove(key);
                Logger.f(TAG, "remove", key);
            } else {
                UTPlugin value = entry.getValue();
                boolean isSyncMessage = value.isSyncMessage();
                if (!this.openUTPluginMap.containsKey(key) && isSyncMessage) {
                    this.openUTPluginMap.put(key, value);
                    Logger.f(TAG, "openUTPluginMap put", key);
                } else if (!this.openAsyncUTPluginMap.containsKey(key) && !isSyncMessage) {
                    this.openAsyncUTPluginMap.put(key, value);
                    Logger.f(TAG, "openAsyncUTPluginMap put", key);
                }
            }
        }
    }

    public Iterator getOpenAsyncUTPluginMapIterator() {
        return this.openAsyncUTPluginMap.entrySet().iterator();
    }

    public Iterator getOpenUTPluginMapIterator() {
        return this.openUTPluginMap.entrySet().iterator();
    }

    public boolean isAsyncOpen() {
        Map<String, UTPlugin> map = this.openAsyncUTPluginMap;
        return map != null && map.size() > 0;
    }

    public boolean isOpen() {
        Map<String, UTPlugin> map = this.openUTPluginMap;
        return map != null && map.size() > 0;
    }

    public boolean isWritableKey(UTPlugin uTPlugin, String str) {
        if (uTPlugin == null) {
            return false;
        }
        return uTPlugin.isWritableKey(str);
    }

    public boolean isWritableUtparamCnt(UTPlugin uTPlugin, String str) {
        if (uTPlugin == null) {
            return false;
        }
        return uTPlugin.isWritableUtparamCnt(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerPlugin(UTPlugin uTPlugin) {
        if (uTPlugin != null) {
            String pluginName = uTPlugin.getPluginName();
            if (TextUtils.isEmpty(pluginName)) {
                pluginName = "OldUTPlugin_" + uTPlugin.hashCode();
            }
            if (TextUtils.isEmpty(pluginName) || this.allUTPluginMap.containsKey(pluginName)) {
                return;
            }
            if (this.utPlugin2Config.containPluginName(pluginName)) {
                uTPlugin.setUTPluginParam(false, this.utPlugin2Config.isSync(pluginName), this.utPlugin2Config.getWritableKeyList(pluginName), this.utPlugin2Config.getUtparamCntList(pluginName));
            }
            this.allUTPluginMap.put(pluginName, uTPlugin);
            if (isOpen(pluginName)) {
                Logger.f(TAG, "isOpen", pluginName);
                if (uTPlugin.isSyncMessage()) {
                    this.openUTPluginMap.put(pluginName, uTPlugin);
                    Logger.f(TAG, "openUTPluginMap.put", pluginName);
                    return;
                }
                this.openAsyncUTPluginMap.put(pluginName, uTPlugin);
                Logger.f(TAG, "openAsyncUTPluginMap.put", pluginName);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unregisterPlugin(UTPlugin uTPlugin) {
        if (uTPlugin != null) {
            String pluginName = uTPlugin.getPluginName();
            if (TextUtils.isEmpty(pluginName)) {
                pluginName = "OldUTPlugin_" + uTPlugin.hashCode();
            }
            if (TextUtils.isEmpty(pluginName)) {
                return;
            }
            this.allUTPluginMap.remove(pluginName);
            this.openUTPluginMap.remove(pluginName);
            this.openAsyncUTPluginMap.remove(pluginName);
        }
    }

    private boolean isOpen(String str) {
        UTPluginConfig uTPluginConfig = this.utPluginConfig;
        if (uTPluginConfig == null) {
            return true;
        }
        List<String> open = uTPluginConfig.getOpen();
        if (open == null || !open.contains(str)) {
            List<String> close = this.utPluginConfig.getClose();
            if (close == null || !close.contains(str)) {
                String other = this.utPluginConfig.getOther();
                return TextUtils.isEmpty(other) || !other.equals("close");
            }
            return false;
        }
        return true;
    }
}
