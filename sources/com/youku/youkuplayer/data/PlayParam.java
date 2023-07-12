package com.youku.youkuplayer.data;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayParam {
    private boolean mIsLocalPlay;
    private String mLiveUrl;
    private String mPath;
    private int mQualityType;
    private String mShowId;
    private long mStartTime;
    private String mToken;
    private String mUrl;
    private String mVid;
    private boolean mDisableAd = true;
    private boolean mAutoPlay = true;
    private boolean mLoopPlay = false;
    private boolean mIsUseSystemPlayer = false;
    private Map<String, String> extMap = new HashMap();

    public Map<String, String> getExtMap() {
        return this.extMap;
    }

    public String getLiveUrl() {
        return this.mLiveUrl;
    }

    public String getPath() {
        return this.mPath;
    }

    public int getQualityType() {
        return this.mQualityType;
    }

    public String getShowId() {
        return this.mShowId;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public String getToken() {
        return this.mToken;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getVid() {
        return this.mVid;
    }

    public boolean isAutoPlay() {
        return this.mAutoPlay;
    }

    public boolean isDisableAd() {
        return this.mDisableAd;
    }

    public boolean isLocalPlay() {
        return this.mIsLocalPlay;
    }

    public boolean isLoopPlay() {
        return this.mLoopPlay;
    }

    public boolean isUseSystemPlayer() {
        return this.mIsUseSystemPlayer;
    }

    public void putString(String str, String str2) {
        this.extMap.put(str, str2);
    }

    public void setAutoPlay(boolean z) {
        this.mAutoPlay = z;
    }

    public void setDisableAd(boolean z) {
        this.mDisableAd = z;
    }

    public void setLiveUrl(String str) {
        this.mLiveUrl = str;
    }

    public void setLocalPlay(boolean z) {
        this.mIsLocalPlay = z;
    }

    public void setLoopPlay(boolean z) {
        this.mLoopPlay = z;
    }

    public void setPath(String str) {
        this.mPath = str;
    }

    public void setQualityType(int i) {
        this.mQualityType = i;
    }

    public void setShowId(String str) {
        this.mShowId = str;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setToken(String str) {
        this.mToken = str;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public void setUseSystemPlayer(boolean z) {
        this.mIsUseSystemPlayer = z;
    }

    public void setVid(String str) {
        this.mVid = str;
    }
}
