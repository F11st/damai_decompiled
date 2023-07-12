package com.youku.alixplayer.opensdk.statistics;

import android.text.TextUtils;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.statistics.param.CustomParams;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.upsplayer.module.UpsTimeTraceBean;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class PlayTimeTrack implements IPlayTimeTrack {
    public static final String CLICK_PLAY = "D_Activity_Create_time";
    public static final String PLAY_SOURCEREADY = "D_UPS_Pre_Request";
    public static final String PREPARED_FIRSTFRAME = "D_before_videogeted";
    public static final String SOURCEREADY_PREPARED = "D_prepareDone";
    public static final String TAG = "PlayTimeTrack";
    private long mActivityCreateTime;
    private long mDidAppearTime;
    private long mLiveControlEndTime;
    private long mLiveControlStartTime;
    private long mNewRequestStartTime;
    private long mPlayStartTime;
    private long mPlayWidgetInitTime;
    private long mPlayerPrepareTime;
    private long mPlayerStartTime;
    private long mPrepareStartTime;
    private long mRotateStayTime;
    private long mSetDisplayTime;
    public UpsTimeTraceBean mUpsTimeTraceBean;
    private long mWillAppearTime;
    private Map<String, Double> mFastPlayTimes = new ConcurrentHashMap<String, Double>() { // from class: com.youku.alixplayer.opensdk.statistics.PlayTimeTrack.1
        {
            Double valueOf = Double.valueOf(0.0d);
            put(PlayTimeTrack.CLICK_PLAY, valueOf);
            put(PlayTimeTrack.PLAY_SOURCEREADY, valueOf);
            put("ups_url_req_times", valueOf);
            put("D_makeM3u8", valueOf);
            put(PlayTimeTrack.SOURCEREADY_PREPARED, valueOf);
            put("D_create_prepare", valueOf);
            put(PlayTimeTrack.PREPARED_FIRSTFRAME, valueOf);
        }
    };
    private Map<String, Long> mPlayerCoreTimestamp = new ConcurrentHashMap<String, Long>() { // from class: com.youku.alixplayer.opensdk.statistics.PlayTimeTrack.2
    };
    private Map<String, Double> mPlayerCoreTimes = new ConcurrentHashMap<String, Double>() { // from class: com.youku.alixplayer.opensdk.statistics.PlayTimeTrack.3
        {
            Double valueOf = Double.valueOf(-1.0d);
            put("cdnUrlReqDuration", valueOf);
            put("D_CDN_ONPrepare", valueOf);
            put("D_CDN_ONPrepare_open", valueOf);
            put("D_CDN_Find_StreamInfo", valueOf);
            put("D_CDN_READ_First_Frame", valueOf);
            put("D_Decode_First_Frame", valueOf);
            put("D_CND_OPEN_AVIO", valueOf);
            put("D_CND_OPEN_Header", valueOf);
            put("D_PIPE_Create", valueOf);
            put("D_CDN_M3U8_Download", valueOf);
            put("D_CDN_M3U8_Parser", valueOf);
            put("D_Sourcer_Read_First_Frame", valueOf);
        }
    };
    private Map<String, Long> mTraceMap = new HashMap();
    private Map<String, Long> mIntervalMap = new HashMap();
    private Map<String, Long> mTimestamps = new ConcurrentHashMap();

    public PlayTimeTrack(PlayVideoInfo playVideoInfo) {
        String string = playVideoInfo.getString("willAppearTime", "0");
        String string2 = playVideoInfo.getString("didAppearTime", "0");
        try {
            this.mWillAppearTime = Long.parseLong(string);
            this.mDidAppearTime = Long.parseLong(string2);
        } catch (Exception unused) {
        }
        this.mPlayStartTime = System.currentTimeMillis();
        put("willAppearTs", (Long) playVideoInfo.getTag("willAppearTs"));
        put("playTs", (Long) playVideoInfo.getTag("playTs"));
    }

    private double cut(String str, String str2) {
        Long l = this.mTimestamps.get(str2);
        Long l2 = this.mTimestamps.get(str);
        if (l == null || l.longValue() <= 0 || l2 == null || l2.longValue() <= 0 || l.longValue() <= l2.longValue()) {
            return 0.0d;
        }
        return l.longValue() - l2.longValue();
    }

    private long getCurrentTime() {
        return System.currentTimeMillis();
    }

    private void put(String str, Long l) {
        if (l != null) {
            putTimestamp(str, l.longValue());
        }
    }

    @Override // com.youku.alixplayer.opensdk.statistics.IPlayTimeTrack
    public void finish() {
        this.mFastPlayTimes.put(CLICK_PLAY, Double.valueOf(cut("clickTs", "playTs")));
        this.mFastPlayTimes.put(PLAY_SOURCEREADY, Double.valueOf(cut("playTs", "requestStartTs")));
        this.mFastPlayTimes.put("ups_url_req_times", Double.valueOf(cut("requestStartTs", "requestEndTs")));
        this.mFastPlayTimes.put("D_makeM3u8", Double.valueOf(cut("playlistStartTs", "playlistEndTs")));
        this.mFastPlayTimes.put(SOURCEREADY_PREPARED, Double.valueOf(cut("playerPrepareTs", "playerPreparedTs")));
        this.mFastPlayTimes.put("D_create_prepare", Double.valueOf(cut("playerPrepareTs", "playerPreparedTs")));
        this.mFastPlayTimes.put(PREPARED_FIRSTFRAME, Double.valueOf(cut("playerPreparedTs", "realVideoStartTs")));
    }

    public long getActivityCreateTime() {
        return this.mActivityCreateTime;
    }

    public long getClickStartTime() {
        return getTimestamp("clickTs");
    }

    public long getDidAppearTime() {
        return this.mDidAppearTime;
    }

    public Map<String, Double> getFastPlayTimes() {
        return this.mFastPlayTimes;
    }

    public long getLiveControlEndTime() {
        return this.mLiveControlEndTime;
    }

    public long getLiveControlStartTime() {
        return this.mLiveControlStartTime;
    }

    public long getNewRequestStartTime() {
        return this.mNewRequestStartTime;
    }

    public long getPlayStartTime() {
        return this.mPlayStartTime;
    }

    public long getPlayWidgetInitTime() {
        return this.mPlayWidgetInitTime;
    }

    public Map<String, Double> getPlayerCoreTimes() {
        return this.mPlayerCoreTimes;
    }

    public Map<String, Long> getPlayerCoreTimestamp() {
        return this.mPlayerCoreTimestamp;
    }

    public long getPlayerPrepareTime() {
        return this.mPlayerPrepareTime;
    }

    public long getPlayerStartTime() {
        return this.mPlayerStartTime;
    }

    public long getPrepareStartTime() {
        return this.mPrepareStartTime;
    }

    public long getRotateStayTime() {
        return this.mRotateStayTime;
    }

    public long getSetDisplayTime() {
        return this.mSetDisplayTime;
    }

    @Override // com.youku.alixplayer.opensdk.statistics.IPlayTimeTrack
    public long getTimestamp(String str) {
        Long l = this.mTimestamps.get(str);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    @Override // com.youku.alixplayer.opensdk.statistics.IPlayTimeTrack
    public Map<String, Long> getTimestamps() {
        return this.mTimestamps;
    }

    public long getWillAppearTime() {
        return this.mWillAppearTime;
    }

    public synchronized void onStart(String str) {
        Logger.d("PlayTimeTrack", "--------------------- onRequest:" + str + " ---------------------");
        long currentTime = getCurrentTime();
        if (PLAY_SOURCEREADY.equals(str)) {
            this.mNewRequestStartTime = currentTime;
        } else if (SOURCEREADY_PREPARED.equals(str)) {
            this.mPrepareStartTime = currentTime;
        }
        this.mTraceMap.put(str, Long.valueOf(currentTime));
    }

    public void putCoreParams(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] split = str.split(":");
        if (split.length >= 2) {
            String str2 = split[0];
            String str3 = split[1];
            if (this.mPlayerCoreTimestamp.containsKey(str2) || !TextUtils.isDigitsOnly(str3)) {
                return;
            }
            this.mPlayerCoreTimestamp.put(str2, Long.valueOf(str3));
        }
    }

    public synchronized void putInterval(String str, long j) {
        this.mIntervalMap.put(str, Long.valueOf(j));
    }

    @Override // com.youku.alixplayer.opensdk.statistics.IPlayTimeTrack
    public void putTimestamp(String str, long j) {
        if (j == 0 || this.mTimestamps.containsKey(str)) {
            return;
        }
        this.mTimestamps.put(str, Long.valueOf(j));
    }

    public void setActivityCreateTime(long j) {
        this.mActivityCreateTime = j;
    }

    public void setDidAppearTime(long j) {
        this.mDidAppearTime = j;
    }

    public void setLiveControlEndTime(long j) {
        this.mLiveControlEndTime = j;
    }

    public void setLiveControlStartTime(long j) {
        this.mLiveControlStartTime = j;
    }

    public void setPlayWidgetInitTime(long j) {
        this.mPlayWidgetInitTime = j;
    }

    public void setPlayerPrepareTime(long j) {
        this.mPlayerPrepareTime = j;
    }

    public void setPlayerStartTime(long j) {
        this.mPlayerStartTime = j;
    }

    public void setPrepareInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (Map.Entry<String, String> entry : new CustomParams(str).getData().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (TextUtils.isDigitsOnly(value)) {
                this.mPlayerCoreTimes.put(key, Double.valueOf(value));
            }
        }
    }

    public void setRotateStayTime(long j) {
        this.mRotateStayTime = j;
    }

    public void setSetDisplayTime(long j) {
        if (this.mSetDisplayTime != 0 || j == 0) {
            return;
        }
        this.mSetDisplayTime = j;
    }

    public void setWillAppearTime(long j) {
        this.mWillAppearTime = j;
    }

    @Override // com.youku.alixplayer.opensdk.statistics.IPlayTimeTrack
    public Map<String, Double> toMap() {
        return this.mFastPlayTimes;
    }
}
