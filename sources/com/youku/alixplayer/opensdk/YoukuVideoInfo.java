package com.youku.alixplayer.opensdk;

import com.youku.alixplayer.opensdk.live.LiveInfo;
import com.youku.alixplayer.opensdk.ups.data.BitStream;
import com.youku.android.liveservice.bean.BypassPlayInfo;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.upsplayer.module.VideoInfo;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class YoukuVideoInfo {
    private static final String TAG = "YoukuVideoInfo";
    protected PlayVideoInfo mPlayVideoInfo;

    public YoukuVideoInfo(PlayVideoInfo playVideoInfo) {
        this.mPlayVideoInfo = playVideoInfo;
    }

    public String getAdString() {
        return null;
    }

    public List<AlixVideoItem> getAlixVideoItems(String str) {
        return null;
    }

    public List<BitStream> getBitStreamList() {
        return null;
    }

    public BypassPlayInfo getBypassPlayInfo() {
        return null;
    }

    public String getDolbyStreamType() {
        return null;
    }

    public int getDuration() {
        return 0;
    }

    public String getLiveId() {
        return null;
    }

    public LiveInfo getLiveInfo() {
        return null;
    }

    public LivePlayControl getLivePlayControl() {
        return null;
    }

    public PlayVideoInfo getPlayVideoInfo() {
        return this.mPlayVideoInfo;
    }

    public String getPsid() {
        return null;
    }

    public String getScreenId() {
        return null;
    }

    public String getShowId() {
        return null;
    }

    public VideoInfo getUpsVideoInfo() {
        return null;
    }

    public String getVid() {
        return null;
    }

    public String getVideoType() {
        return null;
    }

    public String isMcu() {
        return null;
    }

    public String isPK() {
        return null;
    }
}
