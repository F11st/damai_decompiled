package com.youku.playerservice.axp.item;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class CacheBitStream extends BitStream {
    private DownloadType mDownloadType;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum DownloadType {
        DOWNLOADING,
        FINISH
    }

    public CacheBitStream(Quality quality, String str, Codec codec, int i) {
        super(quality, str, codec, i);
    }

    public DownloadType getDownloadType() {
        return this.mDownloadType;
    }

    public void setDownloadType(DownloadType downloadType) {
        this.mDownloadType = downloadType;
    }
}
