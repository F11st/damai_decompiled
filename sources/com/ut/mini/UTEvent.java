package com.ut.mini;

import android.os.SystemClock;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.utils.Logger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import tb.jn1;
import tb.yh2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTEvent {
    public static final String TAG_UTEVENT = "_UtEvent";
    private String mArg1;
    private String mArg2;
    private String mBizId;
    private WeakReference<Object> mContextWeakReference;
    private String mKey;
    private String mPageName;
    private String mScene;
    private List<String> mSceneNameList;
    private List<ScheduledFuture> mScheduledFutureList;
    private int mEventId = 0;
    private long mBeginTime = 0;
    private long mDuringTimeBegin = 0;
    private long mDuration = 0;
    private Map<String, String> mProperties = new HashMap(16);
    private boolean mH5Pv = false;
    private boolean mToLog = true;
    private boolean mToTrigger = true;
    private int mScrollX = 0;
    private int mScrollY = 0;
    private boolean mBeginScroll = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UTEvent(String str) {
        this.mKey = str;
    }

    private synchronized void destroy() {
        List<String> list = this.mSceneNameList;
        if (list != null) {
            list.clear();
        }
        List<ScheduledFuture> list2 = this.mScheduledFutureList;
        if (list2 != null) {
            for (ScheduledFuture scheduledFuture : list2) {
                Logger.f("UTEvent", "scheduledFuture.cancel");
                scheduledFuture.cancel(false);
            }
            this.mScheduledFutureList.clear();
        }
    }

    private void dropAllIllegalFields(Map<String, String> map) {
        if (map != null) {
            map.remove(LogField.PAGE.toString());
            map.remove(LogField.EVENTID.toString());
            map.remove(LogField.ARG1.toString());
            map.remove(LogField.ARG2.toString());
            map.remove(LogField.ARG3.toString());
            map.remove(LogField.ARGS.toString());
        }
    }

    private void translateFieldsName(Map<String, String> map) {
        if (map != null) {
            if (this.mEventId >= 0) {
                String str = LogField.EVENTID.toString();
                map.put(str, "" + this.mEventId);
            }
            if (this.mPageName != null) {
                map.put(LogField.PAGE.toString(), this.mPageName);
            }
            if (this.mArg1 != null) {
                map.put(LogField.ARG1.toString(), this.mArg1);
            }
            if (this.mArg2 != null) {
                map.put(LogField.ARG2.toString(), this.mArg2);
            }
            String str2 = LogField.RECORD_TIMESTAMP.toString();
            map.put(str2, "" + this.mBeginTime);
            String str3 = LogField.ARG3.toString();
            map.put(str3, "" + this.mDuration);
        }
    }

    @Deprecated
    public synchronized void addSceneName(String str) {
        if (this.mSceneNameList == null) {
            this.mSceneNameList = new ArrayList();
        }
        if (!this.mSceneNameList.contains(str)) {
            this.mSceneNameList.add(str);
        }
    }

    @Deprecated
    public synchronized void addScheduledFuture(ScheduledFuture scheduledFuture) {
        if (this.mScheduledFutureList == null) {
            this.mScheduledFutureList = new ArrayList();
        }
        if (!this.mScheduledFutureList.contains(scheduledFuture)) {
            this.mScheduledFutureList.add(scheduledFuture);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void begin() {
        if (this.mBeginTime <= 0) {
            this.mBeginTime = System.currentTimeMillis();
        }
        if (this.mDuringTimeBegin <= 0) {
            this.mDuringTimeBegin = SystemClock.elapsedRealtime();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Map<String, String> build() {
        if (this.mEventId <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap(this.mProperties);
        hashMap.put(TAG_UTEVENT, "1");
        dropAllIllegalFields(hashMap);
        translateFieldsName(hashMap);
        return hashMap;
    }

    @Deprecated
    public synchronized boolean containScene(String str) {
        List<String> list = this.mSceneNameList;
        if (list == null) {
            return false;
        }
        return list.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void end() {
        if (this.mBeginTime <= 0) {
            return;
        }
        if (this.mDuration <= 0) {
            this.mDuration = SystemClock.elapsedRealtime() - this.mDuringTimeBegin;
        }
        destroy();
    }

    @Deprecated
    public synchronized String get(String str) {
        if (LogField.PAGE.toString().equals(str)) {
            return this.mPageName;
        } else if (LogField.EVENTID.toString().equals(str)) {
            return "" + this.mEventId;
        } else if (LogField.ARG1.toString().equals(str)) {
            return this.mArg1;
        } else if (LogField.ARG2.toString().equals(str)) {
            return this.mArg2;
        } else if (LogField.ARG3.toString().equals(str)) {
            return "" + this.mDuration;
        } else if (LogField.RECORD_TIMESTAMP.toString().equals(str)) {
            return "" + this.mBeginTime;
        } else {
            return this.mProperties.get(str);
        }
    }

    public String getArg1() {
        return this.mArg1;
    }

    public String getArg2() {
        return this.mArg2;
    }

    public String getArg3() {
        return "" + this.mDuration;
    }

    public long getBeginTime() {
        return this.mBeginTime;
    }

    public String getBizId() {
        return this.mBizId;
    }

    public Object getContext() {
        WeakReference<Object> weakReference = this.mContextWeakReference;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int getEventId() {
        return this.mEventId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getH5Pv() {
        return this.mH5Pv;
    }

    public String getKey() {
        return this.mKey;
    }

    @Deprecated
    public synchronized Map<String, String> getLogMap() {
        if (this.mEventId <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap(this.mProperties);
        dropAllIllegalFields(hashMap);
        translateFieldsName(hashMap);
        return hashMap;
    }

    public String getPageName() {
        return this.mPageName;
    }

    public synchronized Map<String, String> getProperties() {
        return new HashMap(this.mProperties);
    }

    public String getScene() {
        return this.mScene;
    }

    public boolean getToLog() {
        return this.mToLog;
    }

    public boolean getToTrigger() {
        return this.mToTrigger;
    }

    public void setArg1(String str) {
        this.mArg1 = str;
    }

    public void setArg2(String str) {
        this.mArg2 = str;
    }

    public void setBizId(String str) {
        this.mBizId = str;
    }

    public void setContext(Object obj) {
        if (obj == null) {
            this.mContextWeakReference = null;
        } else {
            this.mContextWeakReference = new WeakReference<>(obj);
        }
    }

    public void setEventId(int i) {
        this.mEventId = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setH5Pv(boolean z) {
        this.mH5Pv = z;
    }

    public void setPageName(String str) {
        this.mPageName = str;
    }

    public void setScene(String str) {
        this.mScene = str;
    }

    public void setScrollPosition(int i, int i2) {
        if (this.mBeginScroll) {
            this.mScrollX = i;
            this.mScrollY = i2;
        } else {
            int i3 = i - this.mScrollX;
            int i4 = i2 - this.mScrollY;
            setArg2(jn1.BLOCK_START_STR + i3 + "," + i4 + "}");
        }
        this.mBeginScroll = false;
    }

    public void setToLog(boolean z) {
        this.mToLog = z;
    }

    public void setToTrigger(boolean z) {
        this.mToTrigger = z;
    }

    public synchronized void updateProperties(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if ((key instanceof String) && (value instanceof String)) {
                    updateProperty(key, value);
                } else {
                    Logger.v("UTEvent", "updateProperty key", key, "value", value);
                }
            }
        }
    }

    public synchronized void updateProperty(String str, String str2) {
        if (!yh2.f(str) && str2 != null) {
            this.mProperties.put(str, str2);
        } else {
            Logger.v("UTEvent", "updateProperty key", str, "value", str2);
        }
    }
}
