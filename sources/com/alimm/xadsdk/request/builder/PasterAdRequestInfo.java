package com.alimm.xadsdk.request.builder;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class PasterAdRequestInfo extends PlayerAdRequestInfo {
    private String mIes;
    private int mIndex;
    private int mLiveAdFlag;
    private String mLiveId;
    private int mLiveState;
    private int mOfflineVideo;
    private int mReqFrom;
    private boolean mSupportHttps;

    public String getIes() {
        return this.mIes;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public int getLiveAdFlag() {
        return this.mLiveAdFlag;
    }

    public String getLiveId() {
        return this.mLiveId;
    }

    public int getLiveState() {
        return this.mLiveState;
    }

    public int getOfflineVideo() {
        return this.mOfflineVideo;
    }

    public int getReqFrom() {
        return this.mReqFrom;
    }

    public boolean isSupportHttps() {
        return this.mSupportHttps;
    }

    public PasterAdRequestInfo setIes(String str) {
        this.mIes = str;
        return this;
    }

    public PasterAdRequestInfo setIndex(int i) {
        this.mIndex = i;
        return this;
    }

    public PasterAdRequestInfo setLiveAdFlag(int i) {
        this.mLiveAdFlag = i;
        return this;
    }

    public PasterAdRequestInfo setLiveId(String str) {
        this.mLiveId = str;
        return this;
    }

    public PasterAdRequestInfo setLiveState(int i) {
        this.mLiveState = i;
        return this;
    }

    public PasterAdRequestInfo setOfflineVideo(int i) {
        this.mOfflineVideo = i;
        return this;
    }

    public PasterAdRequestInfo setReqFrom(int i) {
        this.mReqFrom = i;
        return this;
    }

    public PasterAdRequestInfo setSupportHttps(boolean z) {
        this.mSupportHttps = z;
        return this;
    }
}
