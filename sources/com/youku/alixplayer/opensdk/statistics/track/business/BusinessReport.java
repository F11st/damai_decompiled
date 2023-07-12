package com.youku.alixplayer.opensdk.statistics.track.business;

import android.content.Context;
import android.text.TextUtils;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.vpm.constants.TableField;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class BusinessReport {
    private static final String TAG = "BusinessReport";
    public static boolean mVVTrigger;
    public static long shownTime;
    private Map<String, String> mBaseArgs;
    private OnBusinessTrackListener mBusinessTrackListener;
    private Context mContext;
    private HeartBeatHelper mHeartBeatHelper;
    private boolean mIsAppear;
    private boolean mIsFirstPlay;
    private String mLiveId;
    private long mStartTime;
    private boolean mVVBeginReported;
    private boolean mVVEndReported;

    public BusinessReport(Context context, String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<String, String>() { // from class: com.youku.alixplayer.opensdk.statistics.track.business.BusinessReport.1
            {
                put(TableField.DRM_TYPE, "0");
                put("view", "默认");
                put("decodingType", "1");
                put("data_source", "1");
                put("biz_type", "3");
                put("live_type", "4");
                put("stream_type", "video");
                put("play_codes", "200");
                put("videoCode", "0");
                put("direction", "vplayer");
                put("live_container_sdk_version", "");
                put("screenType", "0");
                put("smallplayer_au", "0");
                put("background_mode", "0");
                put("usePIP", "0");
                put("isPIP", "0");
            }
        };
        this.mBaseArgs = concurrentHashMap;
        this.mLiveId = str;
        this.mContext = context;
        concurrentHashMap.put("guid", getGuid(context));
        this.mBaseArgs.put("liveId", str);
    }

    private String getGuid(Context context) {
        return UUID.randomUUID().toString();
    }

    public boolean containsKey(String str) {
        return this.mBaseArgs.containsKey(str);
    }

    public void put(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.mBaseArgs.put(str, str2);
    }

    public void putAll(Map<String, String> map) {
        this.mBaseArgs.putAll(map);
    }

    public void putHeatArgs(String str, String str2) {
        HeartBeatHelper heartBeatHelper = this.mHeartBeatHelper;
        if (heartBeatHelper != null) {
            heartBeatHelper.put(str, str2);
        }
    }

    public void remove(String str) {
        if (this.mBaseArgs.containsKey(str)) {
            this.mBaseArgs.remove(str);
        }
    }

    public synchronized boolean reportPlayEnd() {
        if (this.mVVBeginReported && !this.mVVEndReported) {
            HashMap hashMap = new HashMap();
            hashMap.put("vv-trigger", mVVTrigger ? "1" : "0");
            long j = shownTime;
            if (j > 0) {
                hashMap.put("showntime", String.valueOf(j));
                Logger.d("showntime", "reportShownTime:" + shownTime + "|" + this.mBaseArgs.get("ismcu") + "|" + this.mBaseArgs.get("ispk"));
                shownTime = 0L;
            }
            hashMap.putAll(this.mBaseArgs);
            String valueOf = String.valueOf(System.currentTimeMillis() - this.mStartTime);
            if (this.mBusinessTrackListener != null) {
                hashMap.put("duration", valueOf);
                this.mBusinessTrackListener.onMonitorPoint(this, "12003", hashMap);
            }
            this.mHeartBeatHelper.stopTime();
            this.mVVEndReported = true;
            return true;
        }
        return false;
    }

    public synchronized void reportPlayStart() {
        if (this.mVVBeginReported) {
            return;
        }
        if (this.mIsAppear && this.mIsFirstPlay) {
            HashMap hashMap = new HashMap();
            hashMap.put("vv-trigger", mVVTrigger ? "1" : "0");
            if (this.mBaseArgs.containsKey("spm-url")) {
                Map<String, String> map = this.mBaseArgs;
                map.put("spm-pre", map.get("spm-url"));
            }
            hashMap.putAll(this.mBaseArgs);
            OnBusinessTrackListener onBusinessTrackListener = this.mBusinessTrackListener;
            if (onBusinessTrackListener != null) {
                onBusinessTrackListener.onMonitorPoint(this, "12002", hashMap);
            }
            this.mVVBeginReported = true;
            this.mStartTime = System.currentTimeMillis();
            HeartBeatHelper heartBeatHelper = new HeartBeatHelper(this.mContext, this.mLiveId, this.mBaseArgs.get("screen_id"), this.mBaseArgs);
            this.mHeartBeatHelper = heartBeatHelper;
            heartBeatHelper.setBusinessTrackListener(this.mBusinessTrackListener);
            this.mHeartBeatHelper.startTime();
        }
    }

    public void setAppear(boolean z) {
        this.mIsAppear = z;
    }

    public void setBusinessTrackListener(OnBusinessTrackListener onBusinessTrackListener) {
        this.mBusinessTrackListener = onBusinessTrackListener;
    }

    public void setDelay(long j) {
        HeartBeatHelper heartBeatHelper = this.mHeartBeatHelper;
        if (heartBeatHelper != null) {
            heartBeatHelper.setDelay(j);
        }
    }

    public void setFirstPlay(boolean z) {
        this.mIsFirstPlay = z;
    }

    public void setSeiDelay(SeiDelay seiDelay) {
        HeartBeatHelper heartBeatHelper = this.mHeartBeatHelper;
        if (heartBeatHelper != null) {
            heartBeatHelper.setSeiDelay(seiDelay);
        }
    }
}
