package com.youku.alixplayer;

import android.util.Log;
import androidx.annotation.Keep;
import com.youku.alixplayer.util.Destructable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
@Keep
/* loaded from: classes.dex */
public class Reporter implements Destructable {
    private static final String TAG = "Reporter";
    private static ConcurrentHashMap<Long, Integer> periodTypeMapping = new ConcurrentHashMap<>();
    private volatile boolean mDestructed;
    private long mNativeId = init();

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public enum MonitorTableName {
        ONE_PLAY,
        IMPAIRMENT,
        BEFORE_PLAY,
        PLAYING,
        ONE_CHANGE_SEEK,
        ONE_CHANGE_QUALITY,
        PLAY_HEART_BEAT,
        ONE_EVENT,
        AD_PLAY,
        AD_ERROR,
        AD_IMPAIRMENT,
        START_LOADING,
        PLAY_ABNORMAL_DETAIL,
        PLAY_ABNORMAL_SUMMARY,
        ABR_PERFORM
    }

    public Reporter() {
        this.mDestructed = false;
        this.mDestructed = false;
    }

    public static void addPeriodTypeMapping(IPeriod iPeriod) {
        if (periodTypeMapping == null) {
            periodTypeMapping = new ConcurrentHashMap<>();
        }
        if (iPeriod != null) {
            Log.d(TAG, "addPeriodTypeMapping identity:" + iPeriod.getIdentity() + " type:" + iPeriod.getType());
            periodTypeMapping.put(Long.valueOf(iPeriod.getIdentity()), Integer.valueOf(iPeriod.getType()));
        }
    }

    private native void deinit();

    public static int getPeriodTypeMapping(long j) {
        Integer num;
        Log.d(TAG, "getPeriodTypeMapping identity:" + j);
        ConcurrentHashMap<Long, Integer> concurrentHashMap = periodTypeMapping;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(Long.valueOf(j)) || (num = periodTypeMapping.get(Long.valueOf(j))) == null) {
            return -1;
        }
        return num.intValue();
    }

    private native long init();

    @Override // com.youku.alixplayer.util.Destructable
    public void destruct() {
        this.mDestructed = true;
        deinit();
    }

    public Map<String, String> getAllDims(MonitorTableName monitorTableName) {
        return this.mDestructed ? new HashMap() : getAllDimsNative(monitorTableName.ordinal());
    }

    public native Map<String, String> getAllDimsNative(int i);

    public Map<String, String> getAllValues(MonitorTableName monitorTableName) {
        return this.mDestructed ? new HashMap() : getAllValuesNative(monitorTableName.ordinal());
    }

    public native Map<String, String> getAllValuesNative(int i);
}
