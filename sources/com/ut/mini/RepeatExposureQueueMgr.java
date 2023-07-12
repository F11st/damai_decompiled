package com.ut.mini;

import android.text.TextUtils;
import com.alibaba.analytics.utils.Logger;
import com.ut.mini.UTPageHitHelper;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import tb.hl2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class RepeatExposureQueueMgr implements Runnable {
    private static final String TAG = "RepeatExposureQueueMgr";
    private static final Map<String, String> EMPTY_MAP = new HashMap();
    private static RepeatExposureQueueMgr mRepeatExposureQueueMgr = new RepeatExposureQueueMgr();
    private boolean isRunning = false;
    private BlockingQueue<Map<String, String>> mQueueCache = new LinkedBlockingQueue();
    private HashSet<Integer> mExposureSet = new HashSet<>();
    private boolean isOpenLog = false;
    private Map<String, String> mSortMap = new TreeMap(new Comparator<String>() { // from class: com.ut.mini.RepeatExposureQueueMgr.1
        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    });

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class RepeatExposurePageChangerMonitor implements UTPageHitHelper.PageChangeListener {
        RepeatExposurePageChangerMonitor() {
        }

        @Override // com.ut.mini.UTPageHitHelper.PageChangeListener
        public void onPageAppear(Object obj) {
            RepeatExposureQueueMgr.getInstance().putClearEvent();
        }

        @Override // com.ut.mini.UTPageHitHelper.PageChangeListener
        public void onPageDisAppear(Object obj) {
            RepeatExposureQueueMgr.getInstance().putClearEvent();
        }
    }

    RepeatExposureQueueMgr() {
    }

    public static RepeatExposureQueueMgr getInstance() {
        return mRepeatExposureQueueMgr;
    }

    private synchronized int getMapHashCode(Map<String, String> map) {
        if (map != null) {
            if (!map.isEmpty()) {
                this.mSortMap.putAll(map);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> entry : this.mSortMap.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        sb.append(key);
                    }
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(value)) {
                        sb.append(value);
                    }
                }
                this.mSortMap.clear();
                return sb.toString().hashCode();
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putClearEvent() {
        if (this.isRunning) {
            this.mQueueCache.add(EMPTY_MAP);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putExposureEvent(Map<String, String> map) {
        if (!this.isRunning || map == null || map.isEmpty()) {
            return;
        }
        this.mQueueCache.add(map);
    }

    @Override // java.lang.Runnable
    public void run() {
        int mapHashCode;
        int i = 0;
        while (true) {
            if (!this.isRunning && i <= 0) {
                return;
            }
            try {
                if (this.isOpenLog) {
                    Logger.f(TAG, "------");
                    Logger.f(TAG, "take mQueueCache size", Integer.valueOf(this.mQueueCache.size()));
                    Logger.f(TAG, "mExposureSet size", Integer.valueOf(this.mExposureSet.size()));
                }
                Map<String, String> take = this.mQueueCache.take();
                if (this.isOpenLog) {
                    long currentTimeMillis = System.currentTimeMillis();
                    mapHashCode = getMapHashCode(take);
                    Logger.f(TAG, "getMapHashCode cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                } else {
                    mapHashCode = getMapHashCode(take);
                }
                if (mapHashCode == 0) {
                    Logger.f(TAG, "clear ExposureSet");
                    this.mExposureSet.clear();
                } else if (this.mExposureSet.contains(Integer.valueOf(mapHashCode))) {
                    Logger.f(TAG, "repeat Exposure");
                } else {
                    this.mExposureSet.add(Integer.valueOf(mapHashCode));
                    Logger.f(TAG, "send Exposure");
                    UTAnalytics.getInstance().transferLog(take);
                }
                i = this.mQueueCache.size();
                if (this.isOpenLog) {
                    Logger.f(TAG, "isRunning", Boolean.valueOf(this.isRunning), "mQueueCache size", Integer.valueOf(i));
                }
            } catch (Throwable th) {
                Logger.f("", th);
            }
        }
    }

    public synchronized void start() {
        if (!this.isRunning) {
            this.isRunning = true;
            hl2.c().f(getInstance());
            UTPageHitHelper.addPageChangerListener(new RepeatExposurePageChangerMonitor());
        }
    }

    public synchronized void stop() {
        if (this.isRunning) {
            this.isRunning = false;
            try {
                this.mQueueCache.clear();
                this.mExposureSet.clear();
            } catch (Exception unused) {
            }
        }
    }
}
