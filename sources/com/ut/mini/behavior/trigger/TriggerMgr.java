package com.ut.mini.behavior.trigger;

import com.alibaba.analytics.utils.Logger;
import com.alibaba.fastjson.JSON;
import com.ut.mini.UTEvent;
import com.ut.mini.behavior.config.UTBehaviorConfigMgr;
import com.ut.mini.behavior.data.DataType;
import com.ut.mini.behavior.expression.ExpressionEvaluator;
import java.util.List;
import java.util.Map;
import tb.yh2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TriggerMgr {
    private static final String TAG = "TriggerMgr";
    private final Object Lock_Object;
    private TriggerConfig mTriggerConfig;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class SingletonHolder {
        private static TriggerMgr instance = new TriggerMgr();

        private SingletonHolder() {
        }
    }

    public static TriggerMgr getInstance() {
        return SingletonHolder.instance;
    }

    public List<Scene> getSceneList() {
        synchronized (this.Lock_Object) {
            TriggerConfig triggerConfig = this.mTriggerConfig;
            if (triggerConfig != null && UTBehaviorConfigMgr.enableSample(triggerConfig.enableSample)) {
                return this.mTriggerConfig.sceneList;
            }
            return null;
        }
    }

    void init(String str) {
        if (yh2.f(str)) {
            this.mTriggerConfig = null;
            return;
        }
        try {
            this.mTriggerConfig = (TriggerConfig) JSON.parseObject(str, TriggerConfig.class);
        } catch (Exception e) {
            Logger.h(TAG, e, new Object[0]);
        }
    }

    public boolean triggerEvent(Scene scene, Map<String, String> map) {
        synchronized (this.Lock_Object) {
            TriggerConfig triggerConfig = this.mTriggerConfig;
            if (triggerConfig != null && UTBehaviorConfigMgr.enableSample(triggerConfig.enableSample)) {
                if (scene == null || scene.event == null || !DataType.Event.getValue().equals(scene.event.type)) {
                    return false;
                }
                return ExpressionEvaluator.getInstance().evaluateData(scene.event.data, map);
            }
            return false;
        }
    }

    private TriggerMgr() {
        this.Lock_Object = new Object();
    }

    public void init(TriggerConfig triggerConfig) {
        synchronized (this.Lock_Object) {
            this.mTriggerConfig = triggerConfig;
        }
    }

    public boolean triggerEvent(Scene scene, UTEvent uTEvent) {
        synchronized (this.Lock_Object) {
            TriggerConfig triggerConfig = this.mTriggerConfig;
            if (triggerConfig != null && UTBehaviorConfigMgr.enableSample(triggerConfig.enableSample)) {
                if (scene == null || scene.event == null || !DataType.Begin.getValue().equals(scene.event.type)) {
                    return false;
                }
                return ExpressionEvaluator.getInstance().evaluateData(scene.event.data, uTEvent);
            }
            return false;
        }
    }
}
