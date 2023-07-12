package com.ut.mini.scene;

import android.text.TextUtils;
import com.alibaba.analytics.utils.Logger;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders;
import com.ut.mini.module.trackerlistener.UTTrackerListenerMgr;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTSceneTracker {
    private static final String TAG = "UTSceneTracker";
    private Map<String, SceneInfo> mSceneInfoMap = new HashMap();

    public void beginScene(String str, Map<String, String> map, Map<String, String> map2) {
        Logger.f(TAG, "beginScene", str, "properties", map, "propertiesRule", map2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.mSceneInfoMap.containsKey(str)) {
            Logger.v(TAG, "repeat beginScene", str);
            return;
        }
        this.mSceneInfoMap.put(str, new SceneInfo(str, map, map2));
        UTTrackerListenerMgr.getInstance().beginScene(str, map);
    }

    public Map<String, String> endScene(String str) {
        Map<String, String> sceneProperties;
        Logger.f(TAG, "endScene", str);
        HashMap hashMap = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SceneInfo sceneInfo = this.mSceneInfoMap.get(str);
        if (sceneInfo != null && (sceneProperties = sceneInfo.getSceneProperties()) != null && sceneProperties.size() > 0) {
            hashMap = new HashMap(sceneProperties);
        }
        this.mSceneInfoMap.remove(str);
        UTTrackerListenerMgr.getInstance().endScene(str, hashMap);
        UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder(str);
        uTCustomHitBuilder.setEventPage("UT_Scene");
        uTCustomHitBuilder.setProperties(hashMap);
        UTAnalytics.getInstance().getDefaultTracker().send(uTCustomHitBuilder.build());
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> eventDispatch(Map<String, String> map) {
        Map<String, SceneInfo> map2 = this.mSceneInfoMap;
        if (map2 == null || map2.size() < 1 || map == null || map.size() < 1) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, SceneInfo> entry : this.mSceneInfoMap.entrySet()) {
            SceneInfo value = entry.getValue();
            if (value != null) {
                value.updatePropertiesByRule(map);
                Map<String, String> sceneProperties = value.getSceneProperties();
                if (sceneProperties != null) {
                    hashMap.putAll(sceneProperties);
                }
            }
        }
        return hashMap;
    }

    public void updateScene(String str, Map<String, String> map) {
        Logger.f(TAG, "updateScene", str, "properties", map);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.mSceneInfoMap.containsKey(str)) {
            Logger.v(TAG, "need beginScene", str);
            return;
        }
        SceneInfo sceneInfo = this.mSceneInfoMap.get(str);
        if (sceneInfo != null) {
            sceneInfo.updateProperties(map);
            UTTrackerListenerMgr.getInstance().updateScene(str, map);
        }
    }
}
