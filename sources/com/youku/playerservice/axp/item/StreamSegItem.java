package com.youku.playerservice.axp.item;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class StreamSegItem {
    private int mAd;
    private int mDuration;
    private long mFileSize;
    private String mUrl;

    public StreamSegItem(String str, int i) {
        this.mDuration = i;
        this.mUrl = str;
    }

    public int getAD() {
        return this.mAd;
    }

    public float getDuration() {
        return this.mDuration;
    }

    public long getFileSize() {
        return this.mFileSize;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setAd(int i) {
        this.mAd = i;
    }

    public void setFileSize(long j) {
        this.mFileSize = j;
    }
}
