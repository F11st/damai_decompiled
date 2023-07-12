package com.ut.mini;

import com.alibaba.analytics.utils.Logger;
import com.ut.mini.module.trackerlistener.UTTrackerListenerMgr;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.yh2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTEventTracker {
    private static final int DEL_COUNT = 50;
    private static final int MAX_COUNT = 500;
    private int mCount;
    private Map<String, UTEvent> mUTEventMap;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class SingletonHolder {
        private static UTEventTracker instance = new UTEventTracker();

        private SingletonHolder() {
        }
    }

    public static UTEventTracker getInstance() {
        return SingletonHolder.instance;
    }

    private synchronized void removeOldEvent() {
        ArrayList<Map.Entry> arrayList = new ArrayList(this.mUTEventMap.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<String, UTEvent>>() { // from class: com.ut.mini.UTEventTracker.1
            @Override // java.util.Comparator
            public int compare(Map.Entry<String, UTEvent> entry, Map.Entry<String, UTEvent> entry2) {
                UTEvent value = entry.getValue();
                UTEvent value2 = entry2.getValue();
                if (value == null || value2 == null || value.getBeginTime() > value2.getBeginTime()) {
                    return 1;
                }
                return value.getBeginTime() < value2.getBeginTime() ? -1 : 0;
            }
        });
        int i = 0;
        for (Map.Entry entry : arrayList) {
            this.mUTEventMap.remove((String) entry.getKey());
            this.mCount--;
            i++;
            if (i >= 50) {
                return;
            }
        }
    }

    public synchronized void beginEvent(UTEvent uTEvent) {
        if (uTEvent == null) {
            return;
        }
        String key = uTEvent.getKey();
        if (yh2.f(key)) {
            return;
        }
        if (this.mUTEventMap.containsKey(key)) {
            if (!uTEvent.getH5Pv()) {
                return;
            }
        } else {
            this.mCount++;
        }
        uTEvent.begin();
        this.mUTEventMap.put(key, uTEvent);
        UTTrackerListenerMgr.getInstance().beginEvent(uTEvent);
        if (this.mCount > 500) {
            long currentTimeMillis = System.currentTimeMillis();
            removeOldEvent();
            Logger.v("UTEventTracker", "removeOldEvent cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public synchronized void endEvent(UTEvent uTEvent) {
        if (uTEvent != null) {
            if (this.mUTEventMap.containsKey(uTEvent.getKey())) {
                this.mUTEventMap.remove(uTEvent.getKey());
                this.mCount--;
                uTEvent.end();
                UTTrackerListenerMgr.getInstance().endEvent(uTEvent);
                if (uTEvent.getEventId() >= 0 && uTEvent.getToLog()) {
                    UTAnalytics.getInstance().getDefaultTracker().send(uTEvent.build());
                }
            }
        }
    }

    public synchronized void endEventByKey(String str) {
        if (this.mUTEventMap.containsKey(str)) {
            endEvent(getEventByKey(str));
        }
    }

    public synchronized UTEvent getEventByKey(String str) {
        UTEvent uTEvent = this.mUTEventMap.get(str);
        if (uTEvent == null) {
            return new UTEvent(str);
        }
        return uTEvent;
    }

    public String getKeyForObject(Object obj) {
        String simpleName;
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            simpleName = (String) obj;
        } else {
            simpleName = obj.getClass().getSimpleName();
        }
        int hashCode = obj.hashCode();
        return simpleName + hashCode;
    }

    public synchronized void sendAndBeginEvent(UTEvent uTEvent, Map<String, String> map) {
        if (map != null) {
            try {
                map.put(UTEvent.TAG_UTEVENT, "1");
                UTAnalytics.getInstance().getDefaultTracker().send(map);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (uTEvent != null) {
            uTEvent.setToLog(false);
            uTEvent.setToTrigger(false);
            beginEvent(uTEvent);
        }
    }

    public synchronized void updateEvent(UTEvent uTEvent) {
        if (uTEvent != null) {
            if (this.mUTEventMap.containsKey(uTEvent.getKey())) {
                UTTrackerListenerMgr.getInstance().updateEvent(uTEvent);
            }
        }
    }

    public synchronized void updateEventPageName(UTEvent uTEvent) {
        if (uTEvent != null) {
            if (this.mUTEventMap.containsKey(uTEvent.getKey())) {
                UTTrackerListenerMgr.getInstance().updateEventPageName(uTEvent);
            }
        }
    }

    private UTEventTracker() {
        this.mCount = 0;
        this.mUTEventMap = new ConcurrentHashMap();
    }
}
