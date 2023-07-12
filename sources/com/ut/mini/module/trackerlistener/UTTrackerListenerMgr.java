package com.ut.mini.module.trackerlistener;

import android.text.TextUtils;
import com.alibaba.analytics.core.config.UTClientConfigMgr;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.fastjson.JSON;
import com.ut.mini.UTEvent;
import com.ut.mini.UTTracker;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTTrackerListenerMgr {
    private static final String TAG = "UTTrackerListenerMgr";
    private static UTTrackerListenerMgr mInstance;
    private UTTrackerListenerConfig listenerConfig = null;
    private Map<String, UTTrackerListener> allTrackerListenerMap = new ConcurrentHashMap();
    private Map<String, UTTrackerListener> openTrackerListenerMap = new ConcurrentHashMap();

    private UTTrackerListenerMgr() {
        UTClientConfigMgr.d().f(new UTClientConfigMgr.IConfigChangeListener() { // from class: com.ut.mini.module.trackerlistener.UTTrackerListenerMgr.1
            @Override // com.alibaba.analytics.core.config.UTClientConfigMgr.IConfigChangeListener
            public String getKey() {
                return "trackerListener";
            }

            @Override // com.alibaba.analytics.core.config.UTClientConfigMgr.IConfigChangeListener
            public void onChange(String str) {
                UTTrackerListenerMgr.this.parseListenerConfig(str);
            }
        });
    }

    public static UTTrackerListenerMgr getInstance() {
        if (mInstance == null) {
            synchronized (UTTrackerListenerMgr.class) {
                if (mInstance == null) {
                    mInstance = new UTTrackerListenerMgr();
                }
            }
        }
        return mInstance;
    }

    private boolean isEventIDInRange(int[] iArr, int i) {
        if (iArr != null) {
            if (iArr[0] == -1) {
                return true;
            }
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isOpen(String str) {
        UTTrackerListenerConfig uTTrackerListenerConfig = this.listenerConfig;
        if (uTTrackerListenerConfig == null) {
            return true;
        }
        List<String> open = uTTrackerListenerConfig.getOpen();
        if (open == null || !open.contains(str)) {
            List<String> close = this.listenerConfig.getClose();
            if (close == null || !close.contains(str)) {
                String other = this.listenerConfig.getOther();
                return TextUtils.isEmpty(other) || !other.equals("close");
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void parseListenerConfig(String str) {
        try {
            this.listenerConfig = (UTTrackerListenerConfig) JSON.parseObject(str, UTTrackerListenerConfig.class);
        } catch (Exception unused) {
            this.listenerConfig = null;
        }
        for (Map.Entry<String, UTTrackerListener> entry : this.allTrackerListenerMap.entrySet()) {
            String key = entry.getKey();
            if (!isOpen(key)) {
                this.openTrackerListenerMap.remove(key);
            } else if (!this.openTrackerListenerMap.containsKey(key)) {
                this.openTrackerListenerMap.put(key, entry.getValue());
            }
        }
    }

    public void addExposureViewToCommit(String str, String str2, String str3, String str4, Map<String, String> map) {
        try {
            for (Map.Entry<String, UTTrackerListener> entry : this.openTrackerListenerMap.entrySet()) {
                UTTrackerListener value = entry.getValue();
                if (value != null) {
                    value.addExposureViewToCommit(str, str2, str3, str4, map);
                }
            }
        } catch (Throwable unused) {
            Logger.i(TAG, new Object[0]);
        }
    }

    public void beginEvent(UTEvent uTEvent) {
        try {
            for (Map.Entry<String, UTTrackerListener> entry : this.openTrackerListenerMap.entrySet()) {
                UTTrackerListener value = entry.getValue();
                if (value != null) {
                    value.beginEvent(uTEvent);
                }
            }
        } catch (Throwable unused) {
            Logger.i(TAG, new Object[0]);
        }
    }

    public void beginScene(String str, Map<String, String> map) {
        try {
            for (Map.Entry<String, UTTrackerListener> entry : this.openTrackerListenerMap.entrySet()) {
                UTTrackerListener value = entry.getValue();
                if (value != null) {
                    value.beginScene(str, map);
                }
            }
        } catch (Throwable unused) {
            Logger.i(TAG, new Object[0]);
        }
    }

    public void endEvent(UTEvent uTEvent) {
        try {
            for (Map.Entry<String, UTTrackerListener> entry : this.openTrackerListenerMap.entrySet()) {
                UTTrackerListener value = entry.getValue();
                if (value != null) {
                    value.endEvent(uTEvent);
                }
            }
        } catch (Throwable unused) {
            Logger.i(TAG, new Object[0]);
        }
    }

    public void endScene(String str, Map<String, String> map) {
        try {
            for (Map.Entry<String, UTTrackerListener> entry : this.openTrackerListenerMap.entrySet()) {
                UTTrackerListener value = entry.getValue();
                if (value != null) {
                    value.endScene(str, map);
                }
            }
        } catch (Throwable unused) {
            Logger.i(TAG, new Object[0]);
        }
    }

    public void pageAppear(UTTracker uTTracker, Object obj, String str, boolean z) {
        try {
            for (Map.Entry<String, UTTrackerListener> entry : this.openTrackerListenerMap.entrySet()) {
                UTTrackerListener value = entry.getValue();
                if (value != null) {
                    value.pageAppear(uTTracker, obj, str, z);
                }
            }
        } catch (Throwable unused) {
            Logger.i(TAG, new Object[0]);
        }
    }

    public void pageDisAppear(UTTracker uTTracker, Object obj) {
        try {
            for (Map.Entry<String, UTTrackerListener> entry : this.openTrackerListenerMap.entrySet()) {
                UTTrackerListener value = entry.getValue();
                if (value != null) {
                    value.pageDisAppear(uTTracker, obj);
                }
            }
        } catch (Throwable unused) {
            Logger.i(TAG, new Object[0]);
        }
    }

    public void pageDisAppearEnd(UTTracker uTTracker, Object obj, Map<String, String> map) {
        try {
            for (Map.Entry<String, UTTrackerListener> entry : this.openTrackerListenerMap.entrySet()) {
                UTTrackerListener value = entry.getValue();
                if (value != null) {
                    value.pageDisAppearEnd(uTTracker, obj, map);
                }
            }
        } catch (Throwable unused) {
            Logger.i(TAG, new Object[0]);
        }
    }

    public synchronized void registerListener(UTTrackerListener uTTrackerListener) {
        if (uTTrackerListener != null) {
            String trackerListenerName = uTTrackerListener.trackerListenerName();
            if (!TextUtils.isEmpty(trackerListenerName) && !this.allTrackerListenerMap.containsKey(trackerListenerName)) {
                this.allTrackerListenerMap.put(trackerListenerName, uTTrackerListener);
                if (isOpen(trackerListenerName)) {
                    this.openTrackerListenerMap.put(trackerListenerName, uTTrackerListener);
                }
            }
        }
    }

    public void send(UTTracker uTTracker, Map<String, String> map) {
        try {
            for (Map.Entry<String, UTTrackerListener> entry : this.openTrackerListenerMap.entrySet()) {
                UTTrackerListener value = entry.getValue();
                if (value != null) {
                    value.send(uTTracker, map);
                }
            }
        } catch (Throwable unused) {
            Logger.i(TAG, new Object[0]);
        }
    }

    public void sendEvent(Map<String, String> map, int i) {
        try {
            for (Map.Entry<String, UTTrackerListener> entry : this.openTrackerListenerMap.entrySet()) {
                UTTrackerListener value = entry.getValue();
                if (value != null && isEventIDInRange(value.getAttentionEventIdsForSendEvent(), i)) {
                    value.sendEvent(map);
                }
            }
        } catch (Throwable unused) {
            Logger.i(TAG, new Object[0]);
        }
    }

    public void sessionTimeout() {
        try {
            for (Map.Entry<String, UTTrackerListener> entry : this.openTrackerListenerMap.entrySet()) {
                UTTrackerListener value = entry.getValue();
                if (value != null) {
                    value.sessionTimeout();
                }
            }
        } catch (Throwable unused) {
            Logger.i(TAG, new Object[0]);
        }
    }

    public synchronized void unregisterListener(UTTrackerListener uTTrackerListener) {
        if (uTTrackerListener != null) {
            String trackerListenerName = uTTrackerListener.trackerListenerName();
            if (!TextUtils.isEmpty(trackerListenerName)) {
                this.allTrackerListenerMap.remove(trackerListenerName);
                this.openTrackerListenerMap.remove(trackerListenerName);
            }
        }
    }

    public void updateEvent(UTEvent uTEvent) {
        try {
            for (Map.Entry<String, UTTrackerListener> entry : this.openTrackerListenerMap.entrySet()) {
                UTTrackerListener value = entry.getValue();
                if (value != null) {
                    value.updateEvent(uTEvent);
                }
            }
        } catch (Throwable unused) {
            Logger.i(TAG, new Object[0]);
        }
    }

    public void updateEventPageName(UTEvent uTEvent) {
        try {
            for (Map.Entry<String, UTTrackerListener> entry : this.openTrackerListenerMap.entrySet()) {
                UTTrackerListener value = entry.getValue();
                if (value != null) {
                    value.updateEventPageName(uTEvent);
                }
            }
        } catch (Throwable unused) {
            Logger.i(TAG, new Object[0]);
        }
    }

    public void updateNextPageProperties(UTTracker uTTracker, Map<String, String> map) {
        try {
            for (Map.Entry<String, UTTrackerListener> entry : this.openTrackerListenerMap.entrySet()) {
                UTTrackerListener value = entry.getValue();
                if (value != null) {
                    value.updateNextPageProperties(uTTracker, map);
                }
            }
        } catch (Throwable unused) {
            Logger.i(TAG, new Object[0]);
        }
    }

    public void updateNextPageUtparam(String str) {
        try {
            for (Map.Entry<String, UTTrackerListener> entry : this.openTrackerListenerMap.entrySet()) {
                UTTrackerListener value = entry.getValue();
                if (value != null) {
                    value.updateNextPageUtparam(str);
                }
            }
        } catch (Throwable unused) {
            Logger.i(TAG, new Object[0]);
        }
    }

    public void updatePageName(UTTracker uTTracker, Object obj, String str) {
        try {
            for (Map.Entry<String, UTTrackerListener> entry : this.openTrackerListenerMap.entrySet()) {
                UTTrackerListener value = entry.getValue();
                if (value != null) {
                    value.updatePageName(uTTracker, obj, str);
                }
            }
        } catch (Throwable unused) {
            Logger.i(TAG, new Object[0]);
        }
    }

    public void updatePageProperties(UTTracker uTTracker, Object obj, Map<String, String> map) {
        try {
            for (Map.Entry<String, UTTrackerListener> entry : this.openTrackerListenerMap.entrySet()) {
                UTTrackerListener value = entry.getValue();
                if (value != null) {
                    value.updatePageProperties(uTTracker, obj, map);
                }
            }
        } catch (Throwable unused) {
            Logger.i(TAG, new Object[0]);
        }
    }

    public void updatePagePropertiesEnd(UTTracker uTTracker, Object obj) {
        try {
            for (Map.Entry<String, UTTrackerListener> entry : this.openTrackerListenerMap.entrySet()) {
                UTTrackerListener value = entry.getValue();
                if (value != null) {
                    value.updatePagePropertiesEnd(uTTracker, obj);
                }
            }
        } catch (Throwable unused) {
            Logger.i(TAG, new Object[0]);
        }
    }

    public void updatePageUtparam(Object obj, String str) {
        try {
            for (Map.Entry<String, UTTrackerListener> entry : this.openTrackerListenerMap.entrySet()) {
                UTTrackerListener value = entry.getValue();
                if (value != null) {
                    value.updatePageUtparam(obj, str);
                }
            }
        } catch (Throwable unused) {
            Logger.i(TAG, new Object[0]);
        }
    }

    public void updateScene(String str, Map<String, String> map) {
        try {
            for (Map.Entry<String, UTTrackerListener> entry : this.openTrackerListenerMap.entrySet()) {
                UTTrackerListener value = entry.getValue();
                if (value != null) {
                    value.updateScene(str, map);
                }
            }
        } catch (Throwable unused) {
            Logger.i(TAG, new Object[0]);
        }
    }

    public void viewBecomeVisible(String str, String str2, String str3) {
        try {
            for (Map.Entry<String, UTTrackerListener> entry : this.openTrackerListenerMap.entrySet()) {
                UTTrackerListener value = entry.getValue();
                if (value != null) {
                    value.viewBecomeVisible(str, str2, str3);
                }
            }
        } catch (Throwable unused) {
            Logger.i(TAG, new Object[0]);
        }
    }
}
