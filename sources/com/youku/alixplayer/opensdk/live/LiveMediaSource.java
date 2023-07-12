package com.youku.alixplayer.opensdk.live;

import android.content.Context;
import com.youku.alixplayer.model.Period;
import com.youku.alixplayer.model.Playlist;
import com.youku.alixplayer.opensdk.AlixVideoItem;
import com.youku.alixplayer.opensdk.BaseLiveVideoStream;
import com.youku.alixplayer.opensdk.IPlaylistBuilder;
import com.youku.alixplayer.opensdk.OnChangeVideoListener;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.PlayerConfig;
import com.youku.alixplayer.opensdk.interceptor.Chain;
import com.youku.alixplayer.opensdk.interceptor.Interceptor;
import com.youku.alixplayer.opensdk.interceptor.RealInterceptionWrapper;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class LiveMediaSource extends BaseLiveVideoStream {
    private static final String TAG = "LiveMediaSource";
    private List<Interceptor> mInterceptors;
    private onChangeSourceListener mOnChangeSourceListener;
    private List<OnChangeVideoListener> mOnChangeVideoListeners;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface onChangeSourceListener {
        void changeSource(boolean z, String str, int i);
    }

    public LiveMediaSource(Context context, PlayVideoInfo playVideoInfo, PlayerConfig playerConfig, LiveInfo liveInfo) {
        super(context, playVideoInfo);
        this.mPlayVideoInfo = playVideoInfo;
        LiveVideoInfo liveVideoInfo = new LiveVideoInfo(playVideoInfo);
        this.mLiveVideoInfo = liveVideoInfo;
        liveVideoInfo.setLiveVideoInfo(liveInfo);
    }

    @Override // com.youku.alixplayer.opensdk.BaseLiveVideoStream, com.youku.alixplayer.opensdk.IVideoStream
    public void changeSource(boolean z, String str, int i) {
        if (this.mOnChangeVideoListeners != null) {
            AlixVideoItem curAlixVideoItem = getCurAlixVideoItem();
            for (OnChangeVideoListener onChangeVideoListener : this.mOnChangeVideoListeners) {
                onChangeVideoListener.onChangeVideo(curAlixVideoItem.getLiveQuality(), i);
            }
        }
        TLogUtil.playLog("直播切换清晰度：" + i);
        onChangeSourceListener onchangesourcelistener = this.mOnChangeSourceListener;
        if (onchangesourcelistener != null) {
            onchangesourcelistener.changeSource(z, str, i);
        }
    }

    @Override // com.youku.alixplayer.opensdk.BaseLiveVideoStream, com.youku.alixplayer.opensdk.IVideoStream
    public PlayVideoInfo getPlayVideoInfo() {
        return this.mPlayVideoInfo;
    }

    @Override // com.youku.alixplayer.opensdk.BaseLiveVideoStream, com.youku.alixplayer.IMediaSource
    public String getSourceKey() {
        return this.mPlayVideoInfo.getLiveId();
    }

    @Override // com.youku.alixplayer.opensdk.BaseLiveVideoStream, com.youku.alixplayer.BaseMediaSource, com.youku.alixplayer.IMediaSource
    public void preparePlaylist() {
        super.preparePlaylist();
        final Period buildPlaylistByLiveInfo = this.mPlaylistBuilder.buildPlaylistByLiveInfo(this.mPlayVideoInfo, this.mLiveVideoInfo.getLiveInfo());
        if (buildPlaylistByLiveInfo != null) {
            this.mPlayList = new Playlist();
            List<Interceptor> list = this.mInterceptors;
            if (list != null && !list.isEmpty()) {
                new RealInterceptionWrapper(2, this.mPlayList, this.mInterceptors, new Interceptor() { // from class: com.youku.alixplayer.opensdk.live.LiveMediaSource.1
                    @Override // com.youku.alixplayer.opensdk.interceptor.Interceptor
                    public void intercept(Chain<Object> chain) {
                        LiveMediaSource.this.playlistPrepared(buildPlaylistByLiveInfo, "intercentor");
                    }
                });
                return;
            } else {
                playlistPrepared(buildPlaylistByLiveInfo, "");
                return;
            }
        }
        notifyPlaylistFailed();
    }

    public void setInterceptors(List<Interceptor> list) {
        this.mInterceptors = list;
    }

    public void setLiveVideoInfo(LiveInfo liveInfo) {
        this.mLiveVideoInfo.setLiveVideoInfo(liveInfo);
    }

    public void setOnChangeSourceListener(onChangeSourceListener onchangesourcelistener) {
        this.mOnChangeSourceListener = onchangesourcelistener;
    }

    public void setOnChangeVideoListeners(List<OnChangeVideoListener> list) {
        this.mOnChangeVideoListeners = list;
    }

    @Override // com.youku.alixplayer.opensdk.BaseLiveVideoStream
    public void setPlaylistBuilder(IPlaylistBuilder iPlaylistBuilder) {
        this.mPlaylistBuilder = iPlaylistBuilder;
    }
}
