package com.youku.alixplayer.opensdk;

import com.youku.alixplayer.opensdk.ups.data.BitStream;
import com.youku.alixplayer.opensdk.ups.data.Quality;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class AlixVideoItem {
    private BitStream mBitStream;
    private boolean mCanPlay;
    private int mFps;
    private String mLanguageCode;
    private int mLiveQuality;
    private String mName;
    private Quality mQuality;
    private int mResolu;
    private long mStreamSize;
    private String mStreamType;

    public AlixVideoItem(Quality quality, String str, String str2) {
        this.mQuality = Quality.UNKNOWN;
        this.mLiveQuality = -1;
        this.mQuality = quality;
        this.mLanguageCode = str;
        this.mStreamType = str2;
        this.mName = quality.getDescription();
    }

    public boolean canPlay() {
        return this.mCanPlay;
    }

    public int getDuration() {
        BitStream bitStream = this.mBitStream;
        if (bitStream != null) {
            return bitStream.getLength();
        }
        return 0;
    }

    public String getLanguageCode() {
        return this.mLanguageCode;
    }

    public int getLiveQuality() {
        return this.mLiveQuality;
    }

    public String getName() {
        return this.mName;
    }

    public Quality getQuality() {
        return this.mQuality;
    }

    public String getStreamType() {
        return this.mStreamType;
    }

    public boolean isTrail() {
        return false;
    }

    public void setCanPlay(boolean z) {
        this.mCanPlay = z;
    }

    public void setFps(int i) {
        this.mFps = i;
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

    public AlixVideoItem(BitStream bitStream) {
        this.mQuality = Quality.UNKNOWN;
        this.mLiveQuality = -1;
        this.mBitStream = bitStream;
        this.mQuality = bitStream.getQuality();
        this.mLanguageCode = bitStream.getAudioLang();
        this.mStreamType = bitStream.getStreamType();
        this.mName = bitStream.getQuality().getDescription();
    }

    public AlixVideoItem(int i, String str, String str2) {
        this.mQuality = Quality.UNKNOWN;
        this.mLiveQuality = -1;
        this.mLanguageCode = str;
        this.mStreamType = str2;
        this.mLiveQuality = i;
    }

    public AlixVideoItem(int i, String str, String str2, String str3) {
        this.mQuality = Quality.UNKNOWN;
        this.mLiveQuality = -1;
        this.mLanguageCode = str2;
        this.mStreamType = str3;
        this.mLiveQuality = i;
        this.mName = str;
    }
}
