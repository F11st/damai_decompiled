package com.ut.mini.behavior;

import android.text.TextUtils;
import com.alibaba.analytics.utils.Logger;
import com.ut.mini.UTEvent;
import com.ut.mini.behavior.trigger.Scene;
import com.ut.mini.behavior.trigger.TriggerMgr;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import tb.hl2;
import tb.pv2;
import tb.yh2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTTrigger {
    private static final String TAG = "UTTrigger";
    private pv2 mHandler;
    private Map<String, List<UTTriggerObserver>> mUTTriggerObserverMap;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class SingletonHolder {
        private static UTTrigger instance = new UTTrigger();

        private SingletonHolder() {
        }
    }

    public static UTTrigger getInstance() {
        return SingletonHolder.instance;
    }

    private synchronized void observeTrigger(final String str, String str2, UTEvent uTEvent) {
        if (uTEvent == null) {
            return;
        }
        uTEvent.addSceneName(str);
        if (yh2.f(str2)) {
            observeTrigger(str);
        } else if (str2.startsWith("delay")) {
            try {
                int parseInt = Integer.parseInt(str2.substring(6));
                ScheduledFuture d = hl2.c().d(null, new Runnable() { // from class: com.ut.mini.behavior.UTTrigger.3
                    @Override // java.lang.Runnable
                    public void run() {
                        UTTrigger.this.observeTrigger(str);
                    }
                }, parseInt);
                Logger.f(TAG, "triggerObserverDelay", str, "delayTime", Integer.valueOf(parseInt));
                uTEvent.addScheduledFuture(d);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerEvent(Map<String, String> map) {
        List<Scene> sceneList = TriggerMgr.getInstance().getSceneList();
        if (sceneList == null) {
            return;
        }
        for (Scene scene : sceneList) {
            if (TriggerMgr.getInstance().triggerEvent(scene, map)) {
                observeTrigger(scene.name);
            }
        }
    }

    public synchronized void registerTrigger(String str, UTTriggerObserver uTTriggerObserver) {
        if (!TextUtils.isEmpty(str) && uTTriggerObserver != null) {
            List<UTTriggerObserver> list = this.mUTTriggerObserverMap.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.mUTTriggerObserverMap.put(str, list);
            }
            if (!list.contains(uTTriggerObserver)) {
                list.add(uTTriggerObserver);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void triggerEventAsync(final Map<String, String> map) {
        if (this.mHandler == null || map == null) {
            return;
        }
        this.mHandler.b(new Runnable() { // from class: com.ut.mini.behavior.UTTrigger.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UTTrigger.this.triggerEvent(map);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public synchronized void unRegisterTrigger(String str, UTTriggerObserver uTTriggerObserver) {
        if (!TextUtils.isEmpty(str) && uTTriggerObserver != null) {
            List<UTTriggerObserver> list = this.mUTTriggerObserverMap.get(str);
            if (list == null) {
                return;
            }
            list.remove(uTTriggerObserver);
        }
    }

    private UTTrigger() {
        try {
            this.mHandler = new pv2();
        } catch (Exception unused) {
        }
        this.mUTTriggerObserverMap = new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void triggerEventAsync(final UTEvent uTEvent) {
        if (this.mHandler == null || uTEvent == null) {
            return;
        }
        this.mHandler.b(new Runnable() { // from class: com.ut.mini.behavior.UTTrigger.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UTTrigger.this.triggerEvent(uTEvent);
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerEvent(UTEvent uTEvent) {
        List<Scene> sceneList = TriggerMgr.getInstance().getSceneList();
        if (sceneList == null) {
            return;
        }
        for (Scene scene : sceneList) {
            if (uTEvent.containScene(scene.name)) {
                Logger.f(TAG, "containScene", scene.name);
            } else if (TriggerMgr.getInstance().triggerEvent(scene, uTEvent)) {
                observeTrigger(scene.name, scene.condition, uTEvent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void observeTrigger(String str) {
        try {
            List<UTTriggerObserver> list = this.mUTTriggerObserverMap.get(str);
            Logger.f(TAG, "triggerObserver", str);
            if (list != null) {
                for (UTTriggerObserver uTTriggerObserver : list) {
                    uTTriggerObserver.onTrigger(str);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
