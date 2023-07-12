package com.alimm.xadsdk.request.builder;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class PlayerAdRequestInfo extends RequestInfo {
    private boolean mIsFullScreen;
    private boolean mIsVert;
    private int mMediaType;
    private String mQuality;
    private String mSessionId;
    private String mVid;
    private int mVideoType;

    public int getMediaType() {
        return this.mMediaType;
    }

    public String getQuality() {
        return this.mQuality;
    }

    public String getSessionId() {
        return this.mSessionId;
    }

    public String getVid() {
        return this.mVid;
    }

    public int getVideoType() {
        return this.mVideoType;
    }

    public boolean isFullScreen() {
        return this.mIsFullScreen;
    }

    public boolean isVert() {
        return this.mIsVert;
    }

    public PlayerAdRequestInfo setFullScreen(boolean z) {
        this.mIsFullScreen = z;
        return this;
    }

    public PlayerAdRequestInfo setMediaType(int i) {
        this.mMediaType = i;
        return this;
    }

    public PlayerAdRequestInfo setQuality(String str) {
        this.mQuality = str;
        return this;
    }

    public PlayerAdRequestInfo setSessionId(String str) {
        this.mSessionId = str;
        return this;
    }

    public PlayerAdRequestInfo setVert(boolean z) {
        this.mIsVert = z;
        return this;
    }

    public PlayerAdRequestInfo setVid(String str) {
        this.mVid = str;
        return this;
    }

    public PlayerAdRequestInfo setVideoType(int i) {
        this.mVideoType = i;
        return this;
    }
}
