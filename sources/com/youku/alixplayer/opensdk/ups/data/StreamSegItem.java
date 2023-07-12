package com.youku.alixplayer.opensdk.ups.data;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class StreamSegItem {
    private int mAd;
    private long mAudioLength;
    private String[] mBackupUrlList;
    private String mCDNUrl;
    private long mFileSize;
    private String mFiledId;
    private String mRTMPUrl;
    private long mVideoLength;

    public StreamSegItem(String str, long j, long j2, long j3, String str2, String str3, int i) {
        this.mFiledId = str;
        this.mFileSize = j;
        this.mVideoLength = j2;
        this.mAudioLength = j3;
        this.mCDNUrl = str2;
        this.mRTMPUrl = str3;
        this.mAd = i;
    }

    public int getAD() {
        return this.mAd;
    }

    public long getAudioLength() {
        return this.mAudioLength;
    }

    public String[] getBackupUrlList() {
        return this.mBackupUrlList;
    }

    public String getCDNUrl() {
        return this.mCDNUrl;
    }

    public String getFiledId() {
        return this.mFiledId;
    }

    public String getRTMPUrl() {
        return this.mRTMPUrl;
    }

    public long getSize() {
        return this.mFileSize;
    }

    public float getVideoLength() {
        return ((float) this.mVideoLength) / 1000.0f;
    }

    public void setCDNBackup(String[] strArr) {
        this.mBackupUrlList = strArr;
    }
}
