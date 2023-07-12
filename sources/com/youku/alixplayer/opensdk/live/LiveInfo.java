package com.youku.alixplayer.opensdk.live;

import android.text.TextUtils;
import com.youku.alixplayer.opensdk.FileFormat;
import com.youku.android.liveservice.bean.BypassPlayInfo;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.Quality;
import com.youku.android.liveservice.bean.VideoInfo;
import com.youku.android.liveservice.bean.WaterMarkV2;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class LiveInfo {
    public String adInfo;
    public BypassPlayInfo bypassPlayInfo;
    private FileFormat fileFormat;
    public boolean isTrail;
    private Quality mQuality;
    public LivePlayControl playControl;
    private String url;
    public VideoInfo videoInfo;
    public List<WaterMarkV2> waterMarkV2List;
    public long timeshift = -1;
    public long requestCostTime = 0;

    public LiveInfo(FileFormat fileFormat, String str) {
        this.fileFormat = FileFormat.UNKNOWN;
        this.fileFormat = fileFormat;
        this.url = str;
    }

    public FileFormat getFileFormat() {
        return this.fileFormat;
    }

    public Quality getQuality() {
        return this.mQuality;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean hasAd() {
        VideoInfo videoInfo = this.videoInfo;
        return (videoInfo == null || TextUtils.isEmpty(videoInfo.adInfo) || !this.videoInfo.ad) ? false : true;
    }

    public LiveInfo(FileFormat fileFormat, LivePlayControl livePlayControl) {
        this.fileFormat = FileFormat.UNKNOWN;
        this.fileFormat = fileFormat;
        this.playControl = livePlayControl;
        this.mQuality = livePlayControl.getDefaultQuality();
    }
}
