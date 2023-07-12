package com.alimm.xadsdk.business.common.model;

import androidx.annotation.NonNull;
import com.alimm.xadsdk.base.utils.LogUtils;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class YouKuPlayerVideoInfo {
    public static final int STREAM_LIVE = 1;
    public static final int STREAM_NORMAL = 0;
    private static final String TAG = "YouKuPlayerVideoInfo";
    public static final int VIDEO_MODE_AUDIO = 1;
    public static final int VIDEO_MODE_NORMAL = 0;
    private int mDuration;
    private boolean mIsFullscreen;
    private boolean mIsVip;
    private int mLiveFlag;
    private String mLiveId;
    private int mLiveState;
    private int mPayType;
    private String mQuality;
    private String mSessionId;
    private String mShowId;
    private int mStartPosition;
    private boolean mSupportHttps;
    private String mVideoId;
    private String[] mVideoTypes;
    private int mStreamType = 0;
    private int mVideoMode = 0;
    private boolean mIsVertical = false;
    private boolean mIsMuted = false;
    private boolean mIsOffline = false;

    public int getDuration() {
        return this.mDuration;
    }

    public int getLiveFlag() {
        return this.mLiveFlag;
    }

    public String getLiveId() {
        return this.mLiveId;
    }

    public int getLiveState() {
        return this.mLiveState;
    }

    public int getPayType() {
        return this.mPayType;
    }

    public String getQuality() {
        return this.mQuality;
    }

    public String getSessionId() {
        return this.mSessionId;
    }

    public String getShowId() {
        return this.mShowId;
    }

    public int getStartPosition() {
        return this.mStartPosition;
    }

    public int getStreamType() {
        return this.mStreamType;
    }

    public String getVideoId() {
        return this.mVideoId;
    }

    public int getVideoMode() {
        return this.mVideoMode;
    }

    public String[] getVideoTypes() {
        return this.mVideoTypes;
    }

    public boolean isFullscreen() {
        return this.mIsFullscreen;
    }

    public boolean isMuted() {
        return this.mIsMuted;
    }

    public boolean isOffline() {
        return this.mIsOffline;
    }

    public boolean isSupportHttps() {
        return this.mSupportHttps;
    }

    public boolean isVertical() {
        return this.mIsVertical;
    }

    public boolean isVip() {
        return this.mIsVip;
    }

    public YouKuPlayerVideoInfo setDuration(int i) {
        this.mDuration = i;
        return this;
    }

    public YouKuPlayerVideoInfo setFullscreen(boolean z) {
        this.mIsFullscreen = z;
        return this;
    }

    public YouKuPlayerVideoInfo setIsOffline(boolean z) {
        this.mIsOffline = z;
        return this;
    }

    public YouKuPlayerVideoInfo setIsVertical(boolean z) {
        this.mIsVertical = z;
        return this;
    }

    public YouKuPlayerVideoInfo setLiveFlag(int i) {
        this.mLiveFlag = i;
        return this;
    }

    public YouKuPlayerVideoInfo setLiveId(@NonNull String str) {
        this.mLiveId = str;
        return this;
    }

    public YouKuPlayerVideoInfo setLiveState(int i) {
        this.mLiveState = i;
        return this;
    }

    public YouKuPlayerVideoInfo setMuted(boolean z) {
        this.mIsMuted = z;
        return this;
    }

    public void setPayType(int i) {
        this.mPayType = i;
    }

    public void setQuality(String str) {
        this.mQuality = str;
    }

    public YouKuPlayerVideoInfo setSessionId(@NonNull String str) {
        this.mSessionId = str;
        return this;
    }

    public YouKuPlayerVideoInfo setShowId(@NonNull String str) {
        this.mShowId = str;
        return this;
    }

    public YouKuPlayerVideoInfo setStartPosition(int i) {
        this.mStartPosition = i;
        return this;
    }

    public YouKuPlayerVideoInfo setStreamType(int i) {
        this.mStreamType = i;
        return this;
    }

    public YouKuPlayerVideoInfo setSupportHttps(boolean z) {
        if (LogUtils.DEBUG) {
            String str = TAG;
            LogUtils.d(str, "setSupportHttps: supportHttps = " + z);
        }
        this.mSupportHttps = z;
        return this;
    }

    public YouKuPlayerVideoInfo setVideoId(@NonNull String str) {
        this.mVideoId = str;
        return this;
    }

    public YouKuPlayerVideoInfo setVideoMode(int i) {
        this.mVideoMode = i;
        return this;
    }

    public void setVideoTypes(String[] strArr) {
        this.mVideoTypes = strArr;
    }

    public void setVip(boolean z) {
        this.mIsVip = z;
    }
}
