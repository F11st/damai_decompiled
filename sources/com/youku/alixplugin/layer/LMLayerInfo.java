package com.youku.alixplugin.layer;

import androidx.collection.ArrayMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class LMLayerInfo {
    private Map<String, String> params = new ArrayMap();
    private String pluginId;
    private int priority;
    private String viewClass;

    public Map<String, String> getParams() {
        return this.params;
    }

    public String getPluginId() {
        return this.pluginId;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getViewClass() {
        return this.viewClass;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public void setPluginId(String str) {
        this.pluginId = str;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public void setViewClass(String str) {
        this.viewClass = str;
    }
}
