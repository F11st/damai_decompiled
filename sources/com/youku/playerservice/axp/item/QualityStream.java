package com.youku.playerservice.axp.item;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class QualityStream {
    private BitStream mBitStream;
    private boolean mCanPlay;
    private int mClarityAbnormal;
    private String mClarityAbnormalReason;
    private String mDisplay;
    private int mFps;
    private String mLanguageCode;
    private String mMarkSuffix;
    private Quality mQuality;
    private int mResolu;
    private long mStreamSize;
    private String mStreamType;

    public QualityStream(BitStream bitStream) {
        this.mQuality = Quality.UNKNOWN;
        this.mBitStream = bitStream;
        this.mQuality = bitStream.getQuality();
        this.mLanguageCode = bitStream.getLangCode();
        this.mStreamType = bitStream.getStreamType();
    }

    public QualityStream(Quality quality, String str, String str2) {
        this.mQuality = Quality.UNKNOWN;
        this.mQuality = quality;
        this.mLanguageCode = str;
        this.mStreamType = str2;
    }

    public boolean canPlay() {
        return this.mCanPlay;
    }

    public int getClarityAbnormal() {
        return this.mClarityAbnormal;
    }

    public String getClarityAbnormalReason() {
        return this.mClarityAbnormalReason;
    }

    public String getDisplay() {
        return this.mDisplay;
    }

    public int getDuration() {
        BitStream bitStream = this.mBitStream;
        if (bitStream != null) {
            return bitStream.getDuration();
        }
        return 0;
    }

    public int getFps() {
        return this.mFps;
    }

    public String getLanguageCode() {
        return this.mLanguageCode;
    }

    public String getMarkSuffix() {
        return this.mMarkSuffix;
    }

    public Quality getQuality() {
        return this.mQuality;
    }

    public int getResolu() {
        return this.mResolu;
    }

    public long getStreamSize() {
        return this.mStreamSize;
    }

    public String getStreamType() {
        return this.mStreamType;
    }

    public boolean isCanPlay() {
        return this.mCanPlay;
    }

    public boolean isTrail() {
        return false;
    }

    public void setCanPlay(boolean z) {
        this.mCanPlay = z;
    }

    public void setClarityAbnormal(int i) {
        this.mClarityAbnormal = i;
    }

    public void setClarityAbnormalReason(String str) {
        this.mClarityAbnormalReason = str;
    }

    public void setDisplay(String str) {
        this.mDisplay = str;
    }

    public void setFps(int i) {
        this.mFps = i;
    }

    public void setMarkSuffix(String str) {
        this.mMarkSuffix = str;
    }

    public void setQuality(Quality quality) {
        this.mQuality = quality;
    }

    public void setResolu(int i) {
        this.mResolu = i;
    }

    public void setStreamSize(long j) {
        this.mStreamSize = this.mStreamSize;
    }
}
