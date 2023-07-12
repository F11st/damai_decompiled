package com.youku.alixplayer.alirtc;

import android.util.Log;
import android.view.Surface;
import com.uc.webview.export.media.CommandID;
import com.youku.alixplayer.AbsAlixPlayer;
import com.youku.alixplayer.AlixPlayerHolderUnbindListener;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.IMediaSource;
import com.youku.alixplayer.MsgID;
import com.youku.alixplayer.OnAdEventListener;
import com.youku.alixplayer.OnCurrentPositionChangeListener;
import com.youku.alixplayer.OnInfoListener;
import com.youku.alixplayer.OnLoadingChangeListener;
import com.youku.alixplayer.OnQualityChangeListener;
import com.youku.alixplayer.OnSeekCompleteListener;
import com.youku.alixplayer.OnStateChangeListener;
import com.youku.alixplayer.OnVideoSizeChangedListener;
import com.youku.alixplayer.instances.Aliplayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class AlixRtcPlayer extends AbsAlixPlayer {
    private static final String TAG = "AlixRtcPlayer";
    private OnAlixRtcInfoListener mOnRtcInfoListener;
    private OnRtcMessageListener mOnRtcMessageListener;
    private List<OnStateChangeListener> mOnStateChangeListeners = new ArrayList();
    private List<OnLoadingChangeListener> mOnLoadingChangeListeners = new ArrayList();
    private List<OnInfoListener> mOnInfoListeners = new ArrayList();
    private List<OnQualityChangeListener> mOnQualityChangeListeners = new ArrayList();
    private List<OnSeekCompleteListener> mOnSeekCompleteListeners = new ArrayList();
    private List<OnVideoSizeChangedListener> mOnVideoSizeChangeListeners = new ArrayList();
    private List<OnCurrentPositionChangeListener> mOnCurrentPositionChangeListeners = new ArrayList();

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void addOnCurrentPositionChangeListener(OnCurrentPositionChangeListener onCurrentPositionChangeListener) {
        this.mOnCurrentPositionChangeListeners.add(onCurrentPositionChangeListener);
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void addOnInfoListener(OnInfoListener onInfoListener) {
        this.mOnInfoListeners.add(onInfoListener);
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void addOnLoadingChangeListener(OnLoadingChangeListener onLoadingChangeListener) {
        this.mOnLoadingChangeListeners.add(onLoadingChangeListener);
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void addOnPlayerStateListener(OnStateChangeListener onStateChangeListener) {
        this.mOnStateChangeListeners.add(onStateChangeListener);
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void addOnQualityChangeListener(OnQualityChangeListener onQualityChangeListener) {
        this.mOnQualityChangeListeners.add(onQualityChangeListener);
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void addOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListeners.add(onSeekCompleteListener);
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void addOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOnVideoSizeChangeListeners.add(onVideoSizeChangedListener);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public IMediaSource getCurrentMediaSource() {
        return null;
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public long getCurrentPosition(Aliplayer.PositionType positionType) {
        return 0L;
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public IAlixPlayer.State getCurrentState() {
        return null;
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public long getDuration() {
        return 0L;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public AlixPlayerHolderUnbindListener getHolder() {
        return null;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public String getParameterString(int i) {
        return null;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public String getPlayerId() {
        return null;
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public int getVideoHeight() {
        return 0;
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public int getVideoWidth() {
        return 0;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public boolean isMuted() {
        return false;
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer
    public boolean isPlaying() {
        return getCurrentState() == IAlixPlayer.State.STATE_STARTING;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public boolean isReuse() {
        return false;
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void pause() {
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void prepareAsync() {
        Log.d(TAG, CommandID.prepareAsync);
        for (OnStateChangeListener onStateChangeListener : this.mOnStateChangeListeners) {
            Log.d(TAG, "onStateChange change to STATE_PREPARED");
            onStateChangeListener.onStateChange(IAlixPlayer.State.STATE_SOURCE_READY, IAlixPlayer.State.STATE_PREPARED);
        }
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void release() {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void removeOnAdEventListener(OnAdEventListener onAdEventListener) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void removeOnInfoListener(OnInfoListener onInfoListener) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void removeOnPlayerStateListener(OnStateChangeListener onStateChangeListener) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void removeOnQualityChangeListener(OnQualityChangeListener onQualityChangeListener) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void removeOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void removeOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void reset() {
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void setDataSource(IMediaSource iMediaSource) {
        Log.d(TAG, CommandID.setDataSource);
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void setDisplay(Surface surface) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setExtraParam(Map<Object, Object> map) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setHolder(AlixPlayerHolderUnbindListener alixPlayerHolderUnbindListener) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setMute(boolean z) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setOnAlixRtcData(int i, Object obj) {
        OnRtcMessageListener onRtcMessageListener;
        if (i == 10011000 && (onRtcMessageListener = this.mOnRtcMessageListener) != null) {
            onRtcMessageListener.onRtcMessage(i, obj);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setOnAlixRtcInfo(OnAlixRtcInfoListener onAlixRtcInfoListener) {
        this.mOnRtcInfoListener = onAlixRtcInfoListener;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setOnRtcMessageListener(OnRtcMessageListener onRtcMessageListener) {
        this.mOnRtcMessageListener = onRtcMessageListener;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setPlayerId(String str) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setReuse(boolean z) {
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void start() {
        if (this.mOnRtcInfoListener != null) {
            Log.d(TAG, "ALIX_RTC_PLAYER_START_INFO");
            this.mOnRtcInfoListener.onRtcInfo(MsgID.ALIX_RTC_PLAYER_START_INFO, null);
        }
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void stop() {
        if (this.mOnRtcInfoListener != null) {
            Log.d(TAG, "ALIX_RTC_PLAYER_STOP_INFO");
            this.mOnRtcInfoListener.onRtcInfo(MsgID.ALIX_RTC_PLAYER_STOP_INFO, null);
        }
    }
}
