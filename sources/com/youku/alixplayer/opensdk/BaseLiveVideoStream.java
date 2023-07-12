package com.youku.alixplayer.opensdk;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.youku.alixplayer.BaseMediaSource;
import com.youku.alixplayer.model.Period;
import com.youku.alixplayer.opensdk.live.LiveInfo;
import com.youku.alixplayer.opensdk.live.LiveMediaSource;
import com.youku.alixplayer.opensdk.live.LiveVideoInfo;
import com.youku.alixplayer.opensdk.statistics.PlayerTrack;
import com.youku.alixplayer.opensdk.ups.data.BitStream;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.android.liveservice.bean.BypassPlayInfo;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.Quality;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class BaseLiveVideoStream extends BaseMediaSource implements IVideoStream {
    protected Context mContext;
    protected LiveVideoInfo mLiveVideoInfo;
    protected PlayVideoInfo mPlayVideoInfo;
    protected PlayerTrack mPlayerTrack;
    protected IPlaylistBuilder mPlaylistBuilder;

    public BaseLiveVideoStream(Context context, PlayVideoInfo playVideoInfo) {
        this.mContext = context;
        this.mPlayVideoInfo = playVideoInfo;
    }

    public static boolean needReload(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Uri parse = Uri.parse(str);
            Uri parse2 = Uri.parse(str2);
            String path = parse.getPath();
            String path2 = parse2.getPath();
            if (path.indexOf(46) != -1) {
                path = path.substring(0, path.lastIndexOf(46));
            }
            if (path2.indexOf(46) != -1) {
                path2 = path2.substring(0, path2.lastIndexOf(46));
            }
            return TextUtils.isEmpty(path) || TextUtils.isEmpty(path2) || !path.equals(path2);
        }
        return true;
    }

    @Override // com.youku.alixplayer.opensdk.IVideoStream
    public void changeSource(boolean z, String str, int i) {
    }

    @Override // com.youku.alixplayer.opensdk.IVideoStream
    public AlixVideoItem getCurAlixVideoItem() {
        BypassPlayInfo bypassPlayInfo = this.mLiveVideoInfo.getBypassPlayInfo();
        if (bypassPlayInfo != null) {
            return new AlixVideoItem(bypassPlayInfo.quality, bypassPlayInfo.definition, null, bypassPlayInfo.bitStream);
        }
        return new AlixVideoItem(-1, null, null, null);
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
        return this.mPlayVideoInfo.getLiveId();
    }

    @Override // com.youku.alixplayer.opensdk.IVideoStream
    public List<AlixVideoItem> getVideoList(String str) {
        ArrayList arrayList = new ArrayList();
        LivePlayControl livePlayControl = this.mLiveVideoInfo.getLivePlayControl();
        if (livePlayControl != null && "live".equals(livePlayControl.streamMode)) {
            for (Quality quality : livePlayControl.qualities) {
                arrayList.add(new AlixVideoItem(quality.quality, quality.name, null, quality.bitStream));
            }
        }
        return arrayList;
    }

    @Override // com.youku.alixplayer.opensdk.IVideoStream
    public YoukuVideoInfo getYoukuVideoInfo() {
        return this.mLiveVideoInfo;
    }

    public boolean match(LiveMediaSource liveMediaSource) {
        String url;
        String url2;
        LiveInfo liveInfo = getYoukuVideoInfo().getLiveInfo();
        LiveInfo liveInfo2 = liveMediaSource.getYoukuVideoInfo().getLiveInfo();
        if (liveInfo == null || liveInfo2 == null || !getPlayVideoInfo().getLiveId().equals(liveMediaSource.getPlayVideoInfo().getLiveId())) {
            return false;
        }
        BypassPlayInfo bypassPlayInfo = liveInfo.bypassPlayInfo;
        if (bypassPlayInfo != null) {
            url = bypassPlayInfo.url;
        } else {
            url = liveInfo.getUrl();
        }
        BypassPlayInfo bypassPlayInfo2 = liveInfo2.bypassPlayInfo;
        if (bypassPlayInfo2 != null) {
            url2 = bypassPlayInfo2.url;
        } else {
            url2 = liveInfo2.getUrl();
        }
        return (TextUtils.isEmpty(url2) || TextUtils.isEmpty(url) || needReload(url2, url)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void playlistPrepared(Period period, String str) {
        this.mPlayList.addPeriod(period);
        TLogUtil.playLog("设置播放地址 Live " + str);
        TLogUtil.playLog(this.mPlayList.toString());
        PlayerTrack playerTrack = this.mPlayerTrack;
        if (playerTrack != null && playerTrack.getPlayTimeTrack() != null) {
            this.mPlayerTrack.getPlayTimeTrack().putTimestamp("playlistEndTs", System.currentTimeMillis());
        }
        notifyPlaylistPrepared(this.mPlayList);
    }

    @Override // com.youku.alixplayer.BaseMediaSource, com.youku.alixplayer.IMediaSource
    public void preparePlaylist() {
        PlayerTrack playerTrack = this.mPlayerTrack;
        if (playerTrack == null || playerTrack.getPlayTimeTrack() == null) {
            return;
        }
        this.mPlayerTrack.getPlayTimeTrack().putTimestamp("playlistStartTs", System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPlayerTrack(PlayerTrack playerTrack) {
        this.mPlayerTrack = playerTrack;
    }

    public void setPlaylistBuilder(IPlaylistBuilder iPlaylistBuilder) {
        this.mPlaylistBuilder = iPlaylistBuilder;
    }
}
