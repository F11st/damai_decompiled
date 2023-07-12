package com.youku.alixplayer.opensdk;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.youku.alixplayer.opensdk.fast.FastData;
import com.youku.alixplayer.opensdk.ups.data.Quality;
import com.youku.live.livesdk.LiveRoomConstants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class PlayVideoInfo {
    private FastData mFastData;
    private String mId;
    private boolean mIsUseH265;
    private PlayType mPlayType;
    private int mPosition;
    private String mRequestLanguageCode;
    private int mRequestLiveQuality;
    private String mUrl;
    private Quality mRequestQuality = Quality.UNKNOWN;
    private boolean mForceReplay = true;
    private Map<String, Double> mDoubleMap = new ConcurrentHashMap();
    private Map<String, String> mStringMap = new ConcurrentHashMap();
    private Map<String, Object> mObjectMap = new ConcurrentHashMap();

    public PlayVideoInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mId = str;
            return;
        }
        throw new IllegalArgumentException("PlayVideoInfo id is null");
    }

    public void clean() {
        putString("playControlRequireId", "");
        putString("change_quality_setdatasource", "0");
        this.mStringMap.put(LiveRoomConstants.PLAY_CLICK_TIME, "-1");
    }

    public double getDouble(String str, double d) {
        Double d2 = this.mDoubleMap.get(str);
        return d2 != null ? d2.doubleValue() : d;
    }

    public FastData getFastData() {
        return this.mFastData;
    }

    public String getLiveId() {
        return this.mId;
    }

    @Deprecated
    public String getMonitor(String str, String str2) {
        String str3 = this.mStringMap.get(str);
        return str3 != null ? str3 : str2;
    }

    public PlayType getPlayType() {
        return this.mPlayType;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public String getRequestLanguageCode() {
        return this.mRequestLanguageCode;
    }

    public int getRequestLiveQuality() {
        return this.mRequestLiveQuality;
    }

    public Quality getRequestQuality() {
        return this.mRequestQuality;
    }

    public String getString(String str) {
        return this.mStringMap.get(str);
    }

    public Object getTag(String str) {
        return this.mObjectMap.get(str);
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getVid() {
        return this.mId;
    }

    public boolean isForceReplay() {
        return this.mForceReplay;
    }

    public boolean isSamePlay(PlayVideoInfo playVideoInfo) {
        return playVideoInfo != null && this.mPlayType == playVideoInfo.mPlayType && this.mRequestLiveQuality == playVideoInfo.mRequestLiveQuality && this.mRequestQuality == playVideoInfo.mRequestQuality && this.mId == playVideoInfo.mId;
    }

    public boolean isUseH265() {
        return this.mIsUseH265;
    }

    @Deprecated
    public void putMonitor(String str, String str2) {
        this.mStringMap.put(str, String.valueOf(str2));
    }

    public void putString(String str, String str2) {
        this.mStringMap.put(str, String.valueOf(str2));
    }

    public void removeTag(String str) {
        this.mObjectMap.remove(str);
    }

    public void setFastData(FastData fastData) {
        this.mFastData = fastData;
    }

    public void setForceReplay(boolean z) {
        this.mForceReplay = z;
    }

    public PlayVideoInfo setPlayType(PlayType playType) {
        this.mPlayType = playType;
        return this;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setRequestLanguageCode(String str) {
        this.mRequestLanguageCode = str;
    }

    public void setRequestLiveQuality(int i) {
        this.mRequestLiveQuality = i;
    }

    public void setRequestQuality(Quality quality) {
        this.mRequestQuality = quality;
    }

    public void setTag(String str, Object obj) {
        this.mObjectMap.put(str, obj);
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public void setUseH265(boolean z) {
        this.mIsUseH265 = z;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" id:");
        sb.append(this.mId);
        sb.append(" playType:");
        sb.append(this.mPlayType);
        if (this.mPlayType == PlayType.VOD) {
            sb.append(" quality:");
            sb.append(this.mRequestQuality);
        } else {
            sb.append(" quality:");
            sb.append(this.mRequestLiveQuality);
        }
        sb.append(" lang:");
        sb.append(this.mRequestLanguageCode);
        sb.append(" isFast:");
        sb.append(this.mFastData != null);
        sb.append(" isForceReplay:");
        sb.append(this.mForceReplay);
        return sb.toString();
    }

    public String getString(String str, String str2) {
        String str3 = this.mStringMap.get(str);
        return str3 != null ? str3 : str2;
    }
}
