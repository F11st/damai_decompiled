package com.youku.playerservice.axp.playinfo;

import androidx.annotation.NonNull;
import com.youku.playerservice.axp.item.BitStream;
import com.youku.playerservice.axp.item.Quality;
import com.youku.service.download.DownloadInfoOuter;
import com.youku.upsplayer.module.VideoInfo;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class CacheUpsInfo {
    public static final int DOWN_STATE = 1;
    private BitStream mBitStream;
    private DownloadInfoOuter mDownloadInfo;
    private VideoInfo mVideoInfo;

    public CacheUpsInfo(@NonNull BitStream bitStream, VideoInfo videoInfo, @NonNull DownloadInfoOuter downloadInfoOuter) {
        this.mBitStream = bitStream;
        this.mVideoInfo = videoInfo;
        this.mDownloadInfo = downloadInfoOuter;
    }

    public BitStream getBitStream() {
        return this.mBitStream;
    }

    public String getCacheLangCode() {
        BitStream bitStream = this.mBitStream;
        if (bitStream != null) {
            return bitStream.getLangCode();
        }
        return null;
    }

    public Quality getCacheQuality() {
        BitStream bitStream = this.mBitStream;
        return bitStream != null ? bitStream.getQuality() : Quality.UNKNOWN;
    }

    public DownloadInfoOuter getDownloadInfo() {
        return this.mDownloadInfo;
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }
}
