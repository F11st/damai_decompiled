package com.youku.vpm;

import android.os.SystemClock;
import android.text.TextUtils;
import com.youku.vpm.param.CustomParams;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayTimeTrack implements IPlayTimeTrack {
    public static final String TAG = "PlayTimeTrack";
    private static final String[] sBusinessTimestampKeys = {"clickTs", "navTs", "pageCreateTs", "initPlayerTs", "initHostViewTs", "initHostViewEndTs", "initWithDataTs", "willAppearTs", "didAppearTs"};
    private static final String[] sPreloadTsKeys = {"prePlayTs", "preRequestStartTs", "preRequestEndTs", "prePlaylistStartTs", "prePlaylistEndTs", "prePlayerPrepareTs", "prePlayerPreparedTs", "preRealVideoStartTs", "historyReadTs", "historyReadDoneTs"};
    private long mRotateStayTime;
    private Map<String, Double> mFastPlayTimes = new ConcurrentHashMap<String, Double>() { // from class: com.youku.vpm.PlayTimeTrack.1
        {
            Double valueOf = Double.valueOf(0.0d);
            put(com.youku.alixplayer.opensdk.statistics.PlayTimeTrack.CLICK_PLAY, valueOf);
            put(com.youku.alixplayer.opensdk.statistics.PlayTimeTrack.PLAY_SOURCEREADY, valueOf);
            put("ups_url_req_times", valueOf);
            put("D_makeM3u8", valueOf);
            put(com.youku.alixplayer.opensdk.statistics.PlayTimeTrack.SOURCEREADY_PREPARED, valueOf);
            put("D_create_prepare", valueOf);
            put(com.youku.alixplayer.opensdk.statistics.PlayTimeTrack.PREPARED_FIRSTFRAME, valueOf);
        }
    };
    private Map<String, Long> mPlayerCoreTimestamp = new ConcurrentHashMap<String, Long>() { // from class: com.youku.vpm.PlayTimeTrack.2
    };
    private Map<String, Double> mPlayerCoreTimes = new ConcurrentHashMap<String, Double>() { // from class: com.youku.vpm.PlayTimeTrack.3
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
    private Map<String, Long> mTimestamps = new ConcurrentHashMap();

    public PlayTimeTrack(IVpmInfo iVpmInfo) {
        String[] strArr;
        String[] strArr2;
        for (String str : sBusinessTimestampKeys) {
            putTimestamp(str, getTimestampFromInfo(iVpmInfo, str));
        }
        for (String str2 : sPreloadTsKeys) {
            putTimestamp(str2, getTimestampFromInfo(iVpmInfo, str2));
        }
        String string = iVpmInfo.getString("prePlayerCoreParams", null);
        if (!TextUtils.isEmpty(string)) {
            putCoreParams(string);
        }
        this.mTimestamps.put("uptimeDiff", Long.valueOf(System.currentTimeMillis() - SystemClock.uptimeMillis()));
    }

    private double cut(String str, String str2) {
        Long l = this.mTimestamps.get(str2);
        Long l2 = this.mTimestamps.get(str);
        if (l == null || l.longValue() <= 0 || l2 == null || l2.longValue() <= 0 || l.longValue() <= l2.longValue()) {
            return 0.0d;
        }
        return l.longValue() - l2.longValue();
    }

    private long getTimestampFromInfo(IVpmInfo iVpmInfo, String str) {
        String string = iVpmInfo.getString(str, null);
        try {
            if (TextUtils.isEmpty(string)) {
                return 0L;
            }
            return Long.parseLong(string);
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.youku.vpm.IPlayTimeTrack
    public void finish() {
        this.mFastPlayTimes.put(com.youku.alixplayer.opensdk.statistics.PlayTimeTrack.CLICK_PLAY, Double.valueOf(cut("clickTs", "playTs")));
        this.mFastPlayTimes.put(com.youku.alixplayer.opensdk.statistics.PlayTimeTrack.PLAY_SOURCEREADY, Double.valueOf(cut("playTs", "requestStartTs")));
        this.mFastPlayTimes.put("ups_url_req_times", Double.valueOf(cut("requestStartTs", "requestEndTs")));
        this.mFastPlayTimes.put("D_makeM3u8", Double.valueOf(cut("playlistStartTs", "playlistEndTs")));
        this.mFastPlayTimes.put(com.youku.alixplayer.opensdk.statistics.PlayTimeTrack.SOURCEREADY_PREPARED, Double.valueOf(cut("playerPrepareTs", "playerPreparedTs")));
        this.mFastPlayTimes.put("D_create_prepare", Double.valueOf(cut("playerPrepareTs", "playerPreparedTs")));
        this.mFastPlayTimes.put(com.youku.alixplayer.opensdk.statistics.PlayTimeTrack.PREPARED_FIRSTFRAME, Double.valueOf(cut("playerPreparedTs", "realVideoStartTs")));
    }

    public Map<String, Double> getFastPlayTimes() {
        return this.mFastPlayTimes;
    }

    public Map<String, Double> getPlayerCoreTimes() {
        return this.mPlayerCoreTimes;
    }

    public Map<String, Long> getPlayerCoreTimestamp() {
        return this.mPlayerCoreTimestamp;
    }

    public long getRotateStayTime() {
        return this.mRotateStayTime;
    }

    @Override // com.youku.vpm.IPlayTimeTrack
    public long getTimestamp(String str) {
        Long l = this.mTimestamps.get(str);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    @Override // com.youku.vpm.IPlayTimeTrack
    public Map<String, Long> getTimestamps() {
        return this.mTimestamps;
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

    @Override // com.youku.vpm.IPlayTimeTrack
    public void putTimestamp(String str, long j) {
        if (j == 0 || this.mTimestamps.containsKey(str)) {
            return;
        }
        this.mTimestamps.put(str, Long.valueOf(j));
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

    @Override // com.youku.vpm.IPlayTimeTrack
    public Map<String, Double> toMap() {
        return this.mFastPlayTimes;
    }
}
