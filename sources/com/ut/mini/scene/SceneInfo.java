package com.ut.mini.scene;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class SceneInfo {
    private Map<String, String> mProperties = new HashMap();
    private Map<String, String> mPropertiesRule = new HashMap();
    private boolean mRuleFlag = false;
    private String mScene;

    public SceneInfo(String str, Map<String, String> map, Map<String, String> map2) {
        this.mScene = str;
        if (map != null) {
            this.mProperties.putAll(map);
        }
        setPropertiesRule(map2);
    }

    private void setPropertiesRule(Map<String, String> map) {
        if (map != null && map.size() > 0) {
            this.mPropertiesRule.putAll(map);
            this.mRuleFlag = true;
            return;
        }
        this.mRuleFlag = false;
    }

    public Map<String, String> getSceneProperties() {
        return this.mProperties;
    }

    public void updateProperties(Map<String, String> map) {
        if (map != null) {
            this.mProperties.putAll(map);
        }
    }

    public void updatePropertiesByRule(Map<String, String> map) {
        Map<String, String> map2;
        if (this.mRuleFlag && map != null && map.size() >= 1 && (map2 = this.mPropertiesRule) != null && map2.size() >= 1) {
            for (Map.Entry<String, String> entry : this.mPropertiesRule.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    String str = map.get(key);
                    if (!TextUtils.isEmpty(str)) {
                        this.mProperties.put(value, str);
                    }
                }
            }
            this.mRuleFlag = false;
            return;
        }
        this.mRuleFlag = false;
    }
}
