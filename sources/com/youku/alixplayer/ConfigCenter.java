package com.youku.alixplayer;

import android.util.Log;
import androidx.annotation.Keep;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ConfigCenter extends IConfigCenter {
    private Map<String, String> extConfigMap = new HashMap();

    @Keep
    private native void deinit();

    @Keep
    private String getConfig(String str, String str2, String str3) {
        Log.d("ConfigCenter", "namespace...key " + str2 + ", defaultValue " + str3);
        Map<String, String> map = this.extConfigMap;
        return (map == null || !map.containsKey(str2)) ? str3 : this.extConfigMap.get(str2);
    }

    @Override // com.youku.alixplayer.IConfigCenter
    @Keep
    protected native long init();

    public void putConfig(String str, String str2) {
        Log.d("ConfigCenter", "putConfig...");
        this.extConfigMap.put(str, str2);
    }

    public void setExtConfigMap(Map<String, String> map) {
        Log.d("ConfigCenter", "setExtConfigMap...");
        if (map == null || map.isEmpty()) {
            return;
        }
        this.extConfigMap = map;
    }
}
