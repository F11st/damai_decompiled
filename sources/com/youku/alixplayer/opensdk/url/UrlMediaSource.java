package com.youku.alixplayer.opensdk.url;

import com.youku.alixplayer.BaseMediaSource;
import com.youku.alixplayer.model.Period;
import com.youku.alixplayer.model.Playlist;
import com.youku.alixplayer.model.Source;
import com.youku.alixplayer.opensdk.AlixVideoItem;
import com.youku.alixplayer.opensdk.IVideoStream;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.PlayerConfig;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.ups.data.BitStream;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.alixplayer.util.NativeMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class UrlMediaSource extends BaseMediaSource implements IVideoStream {
    private PlayVideoInfo mPlayVideoInfo;
    private PlayerConfig mPlayerConfig;
    private String mUrl;

    public UrlMediaSource(PlayVideoInfo playVideoInfo, PlayerConfig playerConfig) {
        this.mPlayVideoInfo = playVideoInfo;
        this.mPlayerConfig = playerConfig;
        this.mUrl = playVideoInfo.getUrl();
        this.mPlayList = new Playlist();
        Period period = new Period();
        NativeMap nativeMap = new NativeMap();
        nativeMap.put("datasource_live_type", "0");
        nativeMap.put("source force hardware decode", this.mPlayerConfig.isUseHardwareDecode() ? "1" : "0");
        if (!this.mUrl.startsWith("http")) {
            nativeMap.put("datasource_local_type", "1");
            nativeMap.put("player_source", "1");
        }
        period.setHeader(nativeMap);
        period.setMixedCodec(false);
        period.addSource(new Source(this.mUrl));
        this.mPlayList.addPeriod(period);
    }

    @Override // com.youku.alixplayer.opensdk.IVideoStream
    public void changeSource(boolean z, String str, int i) {
    }

    @Override // com.youku.alixplayer.opensdk.IVideoStream
    public AlixVideoItem getCurAlixVideoItem() {
        return null;
    }

    @Override // com.youku.alixplayer.opensdk.IVideoStream
    public BitStream getCurrentBitStream() {
        return null;
    }

    @Override // com.youku.alixplayer.opensdk.IVideoStream
    public List<String> getLanguageList() {
        return null;
    }

    @Override // com.youku.alixplayer.opensdk.IVideoStream
    public PlayVideoInfo getPlayVideoInfo() {
        return this.mPlayVideoInfo;
    }

    @Override // com.youku.alixplayer.IMediaSource
    public String getSourceKey() {
        return this.mUrl;
    }

    @Override // com.youku.alixplayer.opensdk.IVideoStream
    public List<AlixVideoItem> getVideoList(String str) {
        return null;
    }

    @Override // com.youku.alixplayer.opensdk.IVideoStream
    public YoukuVideoInfo getYoukuVideoInfo() {
        return null;
    }

    @Override // com.youku.alixplayer.BaseMediaSource, com.youku.alixplayer.IMediaSource
    public void preparePlaylist() {
        TLogUtil.playLog("设置播放地址 url");
        TLogUtil.playLog(this.mPlayList.toString());
        notifyPlaylistPrepared(this.mPlayList);
    }
}
