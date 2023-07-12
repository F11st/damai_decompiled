package com.alimm.xadsdk.business.playerad.model;

import androidx.annotation.NonNull;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class PlayerVideoInfo implements Serializable {
    public static final int STREAM_LIVE = 1;
    public static final int STREAM_NORMAL = 0;
    public static final int VIDEO_MODE_AUDIO = 1;
    public static final int VIDEO_MODE_NORMAL = 0;
    private int mDuration;
    private boolean mIsFullscreen;
    private int mLiveFlag;
    private String mLiveId;
    private int mLiveState;
    private String mSessionId;
    private String mShowId;
    private int mStartPosition;
    private String mVideoId;
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

    public boolean isFullscreen() {
        return this.mIsFullscreen;
    }

    public boolean isMuted() {
        return this.mIsMuted;
    }

    public boolean isOffline() {
        return this.mIsOffline;
    }

    public boolean isVertical() {
        return this.mIsVertical;
    }

    public PlayerVideoInfo setDuration(int i) {
        this.mDuration = i;
        return this;
    }

    public PlayerVideoInfo setFullscreen(boolean z) {
        this.mIsFullscreen = z;
        return this;
    }

    public PlayerVideoInfo setIsOffline(boolean z) {
        this.mIsOffline = z;
        return this;
    }

    public PlayerVideoInfo setIsVertical(boolean z) {
        this.mIsVertical = z;
        return this;
    }

    public PlayerVideoInfo setLiveFlag(int i) {
        this.mLiveFlag = i;
        return this;
    }

    public PlayerVideoInfo setLiveId(@NonNull String str) {
        this.mLiveId = str;
        return this;
    }

    public PlayerVideoInfo setLiveState(int i) {
        this.mLiveState = i;
        return this;
    }

    public PlayerVideoInfo setMuted(boolean z) {
        this.mIsMuted = z;
        return this;
    }

    public PlayerVideoInfo setSessionId(@NonNull String str) {
        this.mSessionId = str;
        return this;
    }

    public PlayerVideoInfo setShowId(@NonNull String str) {
        this.mShowId = str;
        return this;
    }

    public PlayerVideoInfo setStartPosition(int i) {
        this.mStartPosition = i;
        return this;
    }

    public PlayerVideoInfo setStreamType(int i) {
        this.mStreamType = i;
        return this;
    }

    public PlayerVideoInfo setVideoId(@NonNull String str) {
        this.mVideoId = str;
        return this;
    }

    public PlayerVideoInfo setVideoMode(int i) {
        this.mVideoMode = i;
        return this;
    }
}
