package com.youku.alixplayer.opensdk;

import android.content.Context;
import com.youku.alixplayer.model.Period;
import com.youku.alixplayer.model.Playlist;
import com.youku.alixplayer.opensdk.live.LiveInfo;
import com.youku.alixplayer.opensdk.live.LiveVideoInfo;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class FastMediaSource extends BaseLiveVideoStream {
    private LiveInfo mLiveInfo;

    public FastMediaSource(Context context, PlayVideoInfo playVideoInfo, PlayerConfig playerConfig, LiveInfo liveInfo) {
        super(context, playVideoInfo);
        LiveVideoInfo liveVideoInfo = new LiveVideoInfo(this.mPlayVideoInfo);
        this.mLiveVideoInfo = liveVideoInfo;
        liveVideoInfo.setLiveVideoInfo(liveInfo);
        this.mLiveInfo = liveInfo;
    }

    @Override // com.youku.alixplayer.opensdk.BaseLiveVideoStream, com.youku.alixplayer.BaseMediaSource, com.youku.alixplayer.IMediaSource
    public void preparePlaylist() {
        super.preparePlaylist();
        Period buildPlaylistByLiveInfo = this.mPlaylistBuilder.buildPlaylistByLiveInfo(this.mPlayVideoInfo, this.mLiveInfo);
        if (buildPlaylistByLiveInfo != null) {
            this.mPlayList = new Playlist();
            playlistPrepared(buildPlaylistByLiveInfo, "Fast");
            return;
        }
        notifyPlaylistFailed();
    }
}
