package com.taobao.weex.common;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXJSService implements IWXObject {
    private String name;
    private Map<String, Object> options = new HashMap();
    private String script;

    public String getName() {
        return this.name;
    }

    public Map<String, Object> getOptions() {
        return this.options;
    }

    public String getScript() {
        return this.script;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOptions(Map<String, Object> map) {
        this.options = map;
    }

    public void setScript(String str) {
        this.script = str;
    }
}
