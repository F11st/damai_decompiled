package com.youku.alixplayer.opensdk;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import com.uc.webview.export.media.CommandID;
import com.youku.alixplayer.AlixPlayer;
import com.youku.alixplayer.IConfigCenter;
import com.youku.alixplayer.IMediaSource;
import com.youku.alixplayer.OnStateChangeListener;
import com.youku.alixplayer.OnVideoSizeChangedListener;
import com.youku.alixplayer.instances.Aliplayer;
import com.youku.alixplayer.middleware.IRenderMiddleware;
import com.youku.alixplayer.opensdk.config.ConfigUtil;
import com.youku.alixplayer.opensdk.resize.IResizer;
import com.youku.alixplayer.opensdk.statistics.PlayerTrack;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class AlixPlayerWrapper extends AlixPlayer implements IPlayerWrapper {
    private IMediaSource mIMediaSource;
    private IResizer mIResizer;
    private boolean mIsMute;
    private PlayerTrack mPlayerTrack;
    private IVideoStream mVideoStream;

    public AlixPlayerWrapper(Context context) {
        this(context, null);
    }

    @Override // com.youku.alixplayer.opensdk.IPlayer
    public void clearAllListener() {
        this.mOnStateChangeListeners.clear();
        this.mOnLoadingChangeListeners.clear();
        this.mOnInfoListeners.clear();
        this.mOnQualityChangeListeners.clear();
        this.mOnAdEventListeners.clear();
        this.mOnSeekCompleteListeners.clear();
        this.mOnVideoSizeChangeListeners.clear();
        this.mOnCurrentPositionChangeListeners.clear();
        List<IRenderMiddleware> list = this.mRenderMiddlewares;
        if (list == null || list.size() == 0) {
            return;
        }
        for (IRenderMiddleware iRenderMiddleware : this.mRenderMiddlewares) {
            removeRenderMiddleware(iRenderMiddleware);
        }
        this.mRenderMiddlewares.clear();
    }

    @Override // com.youku.alixplayer.opensdk.IPlayerWrapper
    public void firstStart() {
        Log.i("lwj", "start begin" + this);
        TLogUtil.playLog("firstStart", this);
        PlayerTrack playerTrack = this.mPlayerTrack;
        if (playerTrack != null && playerTrack.getPlayTimeTrack() != null) {
            this.mPlayerTrack.getPlayTimeTrack().setPlayerStartTime(System.currentTimeMillis());
        }
        super.start();
        Log.i("lwj", "start end" + this);
    }

    @Override // com.youku.alixplayer.opensdk.IPlayer
    public long getCurrentPosition() {
        return super.getCurrentPosition(Aliplayer.PositionType.NORMAL);
    }

    @Override // com.youku.alixplayer.AlixPlayer, com.youku.alixplayer.IAlixPlayer
    public long getDuration() {
        IVideoStream iVideoStream = this.mVideoStream;
        return Math.max((iVideoStream == null || iVideoStream.getCurrentBitStream() == null) ? 0L : this.mVideoStream.getCurrentBitStream().getLength(), super.getDuration());
    }

    @Override // com.youku.alixplayer.opensdk.IPlayer
    public List<OnStateChangeListener> getOnPlayerStateListeners() {
        return this.mOnStateChangeListeners;
    }

    @Override // com.youku.alixplayer.opensdk.IPlayer
    public List<OnVideoSizeChangedListener> getOnVideoSizeChangedListeners() {
        return this.mOnVideoSizeChangeListeners;
    }

    @Override // com.youku.alixplayer.opensdk.IPlayer
    public IResizer getResizer() {
        return this.mIResizer;
    }

    @Override // com.youku.alixplayer.opensdk.IPlayer
    public IVideoStream getVideoStream() {
        return this.mVideoStream;
    }

    @Override // com.youku.alixplayer.AlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void pause() {
        TLogUtil.playLog("pause", this);
        super.pause();
    }

    @Override // com.youku.alixplayer.AlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void prepareAsync() {
        Log.i("lwj", "prepare async begin " + this);
        TLogUtil.playLog(CommandID.prepareAsync, this);
        PlayerTrack playerTrack = this.mPlayerTrack;
        if (playerTrack != null && playerTrack.getPlayTimeTrack() != null) {
            this.mPlayerTrack.getPlayTimeTrack().setPlayerPrepareTime(System.currentTimeMillis());
        }
        super.prepareAsync();
        Log.i("lwj", "preppare async end " + this);
    }

    @Override // com.youku.alixplayer.AlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void release() {
        TLogUtil.playLog("release", this);
        PlayerTrack playerTrack = this.mPlayerTrack;
        if (playerTrack != null) {
            playerTrack.onPlayerDestroy();
        }
        super.release();
    }

    @Override // com.youku.alixplayer.opensdk.IPlayer
    public void replay() {
        if (this.mVideoStream != null) {
            stop();
            super.setDataSource(this.mIMediaSource);
            return;
        }
        TLogUtil.playLog("replay mediasource is null");
    }

    @Override // com.youku.alixplayer.AlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void reset() {
        TLogUtil.playLog("reset", this);
        super.stop();
    }

    @Override // com.youku.alixplayer.AlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void seekTo(int i, int i2) {
        if (this.mPlayerTrack != null) {
            Bundle bundle = new Bundle();
            bundle.putDouble("position", i);
            this.mPlayerTrack.onAction("seek", bundle);
        }
        super.seekTo(i, i2);
    }

    @Override // com.youku.alixplayer.AlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void setDataSource(IMediaSource iMediaSource) {
        throw new IllegalStateException("use setVideoStream to setDataSource");
    }

    @Override // com.youku.alixplayer.AlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void setDisplay(Surface surface) {
        Log.i("lwj", "set display begin " + this);
        TLogUtil.playLog("setDisplay", this);
        long currentTimeMillis = System.currentTimeMillis();
        PlayerTrack playerTrack = this.mPlayerTrack;
        if (playerTrack != null) {
            playerTrack.putTimestamp("setDisplayTs", currentTimeMillis);
        }
        super.setDisplay(surface);
        Log.i("lwj", "set display end " + this);
    }

    @Override // com.youku.alixplayer.AlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void setMute(boolean z) {
        TLogUtil.playLog("setMute=" + z, this);
        this.mIsMute = z;
        super.setMute(z);
    }

    @Override // com.youku.alixplayer.opensdk.IPlayer
    public void setResizer(IResizer iResizer) {
        this.mIResizer = iResizer;
    }

    @Override // com.youku.alixplayer.opensdk.IPlayerWrapper
    public <T extends IMediaSource & IVideoStream> void setVideoStream(T t) {
        Log.i("lwj", "set data source begin" + this);
        TLogUtil.playLog(CommandID.setDataSource, this);
        super.setDataSource(t);
        this.mVideoStream = t;
        this.mIMediaSource = t;
        super.setMute(this.mIsMute);
        Log.i("lwj", "set data source end " + this);
    }

    @Override // com.youku.alixplayer.AlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void stop() {
        TLogUtil.playLog("internalStop", this);
        PlayerTrack playerTrack = this.mPlayerTrack;
        if (playerTrack != null) {
            playerTrack.onStop();
        }
        super.stop();
    }

    public AlixPlayerWrapper(Context context, PlayerTrack playerTrack) {
        super(context);
        this.mPlayerTrack = playerTrack;
        IConfigCenter configCenter = ConfigUtil.getConfigCenter();
        if (configCenter != null) {
            setConfigCenter(configCenter);
        }
    }
}
