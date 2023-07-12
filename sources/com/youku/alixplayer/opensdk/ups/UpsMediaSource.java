package com.youku.alixplayer.opensdk.ups;

import android.content.Context;
import com.youku.alixplayer.BaseMediaSource;
import com.youku.alixplayer.model.Period;
import com.youku.alixplayer.model.Playlist;
import com.youku.alixplayer.opensdk.AlixVideoItem;
import com.youku.alixplayer.opensdk.IPlayerWrapper;
import com.youku.alixplayer.opensdk.IPlaylistBuilder;
import com.youku.alixplayer.opensdk.IVideoRequest;
import com.youku.alixplayer.opensdk.IVideoStream;
import com.youku.alixplayer.opensdk.OnChangeVideoListener;
import com.youku.alixplayer.opensdk.OnVideoStreamListener;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.PlayerConfig;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.interceptor.Chain;
import com.youku.alixplayer.opensdk.interceptor.Interceptor;
import com.youku.alixplayer.opensdk.interceptor.RealInterceptionWrapper;
import com.youku.alixplayer.opensdk.ups.data.BitStream;
import com.youku.alixplayer.opensdk.ups.data.BitStreamFinder;
import com.youku.alixplayer.opensdk.ups.data.Quality;
import com.youku.alixplayer.opensdk.ups.data.utils.BitStreamUtil;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.upsplayer.module.VideoInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class UpsMediaSource extends BaseMediaSource implements IVideoStream {
    private static final String TAG = "UpsMediaSource";
    private Map<String, List<AlixVideoItem>> mAlixVideoItems;
    private BitStream mBitStream;
    private Context mContext;
    private List<Interceptor> mInterceptors;
    private List<OnChangeVideoListener> mOnChangeVideoListeners;
    private List<OnVideoStreamListener> mOnVideoStreamListeners = new ArrayList();
    private PlayVideoInfo mPlayVideoInfo;
    private PlayerConfig mPlayerConfig;
    private IPlayerWrapper mPlayerWrapper;
    private IPlaylistBuilder mPlaylistBuilder;
    private BitStream mTempBitStream;
    private UpsVideoInfo mUpsVideoInfo;
    private IVideoRequest mVideoRequest;
    private IVideoRequest.Callback<VideoInfo, Map<String, String>> mVideoRequestCallback;

    public UpsMediaSource(Context context, PlayVideoInfo playVideoInfo, PlayerConfig playerConfig, IVideoRequest iVideoRequest) {
        IVideoRequest.Callback<VideoInfo, Map<String, String>> callback = new IVideoRequest.Callback<VideoInfo, Map<String, String>>() { // from class: com.youku.alixplayer.opensdk.ups.UpsMediaSource.1
            @Override // com.youku.alixplayer.opensdk.IVideoRequest.Callback
            public void onFailure(VideoRequestError videoRequestError) {
                for (OnVideoStreamListener onVideoStreamListener : UpsMediaSource.this.mOnVideoStreamListeners) {
                    onVideoStreamListener.onDataFail(videoRequestError);
                }
            }

            @Override // com.youku.alixplayer.opensdk.IVideoRequest.Callback
            public void onStat(Map<String, String> map) {
            }

            @Override // com.youku.alixplayer.opensdk.IVideoRequest.Callback
            public void onSuccess(VideoInfo videoInfo, Map<String, String> map) {
                UpsMediaSource upsMediaSource = UpsMediaSource.this;
                upsMediaSource.mUpsVideoInfo = new UpsVideoInfo(upsMediaSource.mPlayVideoInfo);
                UpsMediaSource.this.mUpsVideoInfo.setDRMR1(map.get("drmR1"));
                UpsMediaSource.this.mUpsVideoInfo.setUpsVideoInfo(UpsMediaSource.this.mContext, videoInfo);
                UpsMediaSource upsMediaSource2 = UpsMediaSource.this;
                upsMediaSource2.mAlixVideoItems = upsMediaSource2.mUpsVideoInfo.getAlixVideoItems();
                UpsMediaSource upsMediaSource3 = UpsMediaSource.this;
                upsMediaSource3.mBitStream = BitStreamUtil.getRealVideoQuality(upsMediaSource3.mContext, UpsMediaSource.this.mPlayVideoInfo.getRequestQuality(), UpsMediaSource.this.mPlayVideoInfo.getRequestLanguageCode(), UpsMediaSource.this.mUpsVideoInfo);
                for (OnVideoStreamListener onVideoStreamListener : UpsMediaSource.this.mOnVideoStreamListeners) {
                    onVideoStreamListener.onDataReady(UpsMediaSource.this.mUpsVideoInfo);
                }
                final Period buildPlaylistByBitStream = UpsMediaSource.this.mPlaylistBuilder.buildPlaylistByBitStream(UpsMediaSource.this.mPlayVideoInfo, UpsMediaSource.this.mBitStream, 0);
                if (buildPlaylistByBitStream == null) {
                    UpsMediaSource.this.notifyPlaylistFailed();
                    return;
                }
                ((BaseMediaSource) UpsMediaSource.this).mPlayList = new Playlist();
                if (UpsMediaSource.this.mInterceptors == null || UpsMediaSource.this.mInterceptors.isEmpty()) {
                    ((BaseMediaSource) UpsMediaSource.this).mPlayList.addPeriod(buildPlaylistByBitStream);
                    TLogUtil.playLog("设置播放地址 ups");
                    TLogUtil.playLog(((BaseMediaSource) UpsMediaSource.this).mPlayList.toString());
                    UpsMediaSource upsMediaSource4 = UpsMediaSource.this;
                    upsMediaSource4.notifyPlaylistPrepared(((BaseMediaSource) upsMediaSource4).mPlayList);
                    return;
                }
                new RealInterceptionWrapper(2, ((BaseMediaSource) UpsMediaSource.this).mPlayList, UpsMediaSource.this.mInterceptors, new Interceptor() { // from class: com.youku.alixplayer.opensdk.ups.UpsMediaSource.1.1
                    @Override // com.youku.alixplayer.opensdk.interceptor.Interceptor
                    public void intercept(Chain<Object> chain) {
                        ((BaseMediaSource) UpsMediaSource.this).mPlayList.addPeriod(buildPlaylistByBitStream);
                        TLogUtil.playLog("设置播放地址 ups intercentor");
                        TLogUtil.playLog(((BaseMediaSource) UpsMediaSource.this).mPlayList.toString());
                        UpsMediaSource upsMediaSource5 = UpsMediaSource.this;
                        upsMediaSource5.notifyPlaylistPrepared(((BaseMediaSource) upsMediaSource5).mPlayList);
                    }
                });
            }
        };
        this.mVideoRequestCallback = callback;
        this.mContext = context;
        this.mPlayVideoInfo = playVideoInfo;
        this.mPlayerConfig = playerConfig;
        this.mVideoRequest = iVideoRequest;
        iVideoRequest.setVideoRequestListener(callback);
    }

    public void addVideoStreamListener(OnVideoStreamListener onVideoStreamListener) {
        this.mOnVideoStreamListeners.add(onVideoStreamListener);
    }

    @Override // com.youku.alixplayer.opensdk.IVideoStream
    public void changeSource(boolean z, String str, int i) {
        if (this.mBitStream == null) {
            for (OnChangeVideoListener onChangeVideoListener : this.mOnChangeVideoListeners) {
                onChangeVideoListener.onChangeVideoFinish(false);
            }
            return;
        }
        for (OnChangeVideoListener onChangeVideoListener2 : this.mOnChangeVideoListeners) {
            onChangeVideoListener2.onChangeVideo(this.mBitStream.getQuality().getCode(), i);
        }
        BitStream findBitStream = new BitStreamFinder(this.mUpsVideoInfo, false).findBitStream(Quality.getQualityByCode(i), str);
        this.mTempBitStream = findBitStream;
        if (findBitStream == null) {
            for (OnChangeVideoListener onChangeVideoListener3 : this.mOnChangeVideoListeners) {
                onChangeVideoListener3.onChangeVideoFinish(false);
            }
            TLogUtil.playLog("mTempBitStream is null", this.mPlayerWrapper);
            return;
        }
        Period buildPlaylistByBitStream = this.mPlaylistBuilder.buildPlaylistByBitStream(this.mPlayVideoInfo, findBitStream, 0);
        buildPlaylistByBitStream.setStartTime(this.mPlayerWrapper.getCurrentPosition() + 10000);
        buildPlaylistByBitStream.setDrmKey(this.mTempBitStream.getDrmKey());
        switchDataSource(buildPlaylistByBitStream);
    }

    @Override // com.youku.alixplayer.opensdk.IVideoStream
    public AlixVideoItem getCurAlixVideoItem() {
        BitStream bitStream = this.mBitStream;
        if (bitStream != null) {
            return new AlixVideoItem(bitStream);
        }
        return null;
    }

    @Override // com.youku.alixplayer.opensdk.IVideoStream
    public BitStream getCurrentBitStream() {
        return this.mBitStream;
    }

    @Override // com.youku.alixplayer.opensdk.IVideoStream
    public List<String> getLanguageList() {
        if (this.mAlixVideoItems == null) {
            return null;
        }
        return new ArrayList(this.mAlixVideoItems.keySet());
    }

    @Override // com.youku.alixplayer.opensdk.IVideoStream
    public PlayVideoInfo getPlayVideoInfo() {
        return this.mPlayVideoInfo;
    }

    @Override // com.youku.alixplayer.IMediaSource
    public String getSourceKey() {
        return this.mPlayVideoInfo.getVid();
    }

    @Override // com.youku.alixplayer.opensdk.IVideoStream
    public List<AlixVideoItem> getVideoList(String str) {
        new ArrayList();
        if (str == null) {
            TLogUtil.playLog("当前清晰语言为null，无法输出清晰度列表");
            return new ArrayList();
        }
        Map<String, List<AlixVideoItem>> map = this.mAlixVideoItems;
        if (map == null) {
            TLogUtil.playLog("UPS数据为null，无法输出清晰度列表");
            return new ArrayList();
        }
        return map.get(str);
    }

    @Override // com.youku.alixplayer.opensdk.IVideoStream
    public YoukuVideoInfo getYoukuVideoInfo() {
        return this.mUpsVideoInfo;
    }

    public void onChangeVideoFinish(boolean z) {
        if (z) {
            this.mBitStream = this.mTempBitStream;
        }
        this.mTempBitStream = null;
    }

    @Override // com.youku.alixplayer.BaseMediaSource, com.youku.alixplayer.IMediaSource
    public void preparePlaylist() {
        for (OnVideoStreamListener onVideoStreamListener : this.mOnVideoStreamListeners) {
            onVideoStreamListener.onNewRequest(this.mPlayVideoInfo);
        }
        this.mVideoRequest.request(this.mPlayVideoInfo, null);
    }

    public void setInterceptors(List<Interceptor> list) {
        this.mInterceptors = list;
    }

    public void setOnChangeVideoListeners(List<OnChangeVideoListener> list) {
        this.mOnChangeVideoListeners = list;
    }

    public void setPlayerWrapper(IPlayerWrapper iPlayerWrapper) {
        this.mPlayerWrapper = iPlayerWrapper;
    }

    public void setPlaylistBuilder(IPlaylistBuilder iPlaylistBuilder) {
        this.mPlaylistBuilder = iPlaylistBuilder;
    }

    public void switchDataSource(Period period) {
        for (int i = 0; i < this.mPlayList.getPeriodList().size(); i++) {
            Object obj = this.mPlayList.getPeriodList().get(i);
            if ((obj instanceof Period) && ((Period) obj).getType() == 0) {
                changePeriod(i, period);
            }
        }
        TLogUtil.playLog("切换播放地址 ups");
        TLogUtil.playLog(this.mPlayList.toString());
    }
}
