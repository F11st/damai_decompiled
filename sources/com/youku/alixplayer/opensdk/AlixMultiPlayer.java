package com.youku.alixplayer.opensdk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.IMediaSource;
import com.youku.alixplayer.OnStateChangeListener;
import com.youku.alixplayer.opensdk.statistics.IPlayerTrack;
import com.youku.alixplayer.opensdk.statistics.ITrack;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class AlixMultiPlayer implements IMultiPlayerWrapper {
    private Context mContext;
    private boolean mIsMuted;
    private IPlayerTrack mPlayerTrack;
    private List<IPlayer> mAlixPlayers = new CopyOnWriteArrayList();
    private List<IPlayerWrapper> mTempPlayers = new CopyOnWriteArrayList();

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public final class StateChangeListener implements OnStateChangeListener {
        private IPlayerWrapper mAlixPlayer;
        private IPlayerTrack mPlayerTrack;

        public StateChangeListener(@NonNull IPlayerWrapper iPlayerWrapper, @NonNull IPlayerTrack iPlayerTrack) {
            this.mAlixPlayer = iPlayerWrapper;
            this.mPlayerTrack = iPlayerTrack;
        }

        @Override // com.youku.alixplayer.OnStateChangeListener
        public void onStateChange(IAlixPlayer.State state, IAlixPlayer.State state2) {
            if (state2 == IAlixPlayer.State.STATE_SOURCE_READY) {
                this.mAlixPlayer.prepareAsync();
            } else if (state2 == IAlixPlayer.State.STATE_PREPARED) {
                this.mAlixPlayer.firstStart();
            } else if (state2 == IAlixPlayer.State.STATE_VIDEO_STARTED) {
                long currentTimeMillis = System.currentTimeMillis();
                ITrack track = this.mPlayerTrack.getTrack();
                track.putString("secondVideoStartTime", currentTimeMillis + "");
            }
        }
    }

    public AlixMultiPlayer(@NonNull Context context, @NonNull IPlayerTrack iPlayerTrack) {
        this.mContext = context;
        this.mPlayerTrack = iPlayerTrack;
    }

    private IPlayerWrapper getPlayerWrapper(int i) {
        if (this.mTempPlayers.size() > i) {
            return this.mTempPlayers.get(i);
        }
        AlixPlayerWrapper alixPlayerWrapper = new AlixPlayerWrapper(this.mContext);
        alixPlayerWrapper.addOnPlayerStateListener(new StateChangeListener(alixPlayerWrapper, this.mPlayerTrack));
        this.mTempPlayers.add(alixPlayerWrapper);
        return alixPlayerWrapper;
    }

    @Override // com.youku.alixplayer.opensdk.IMultiPlayerWrapper
    public <T extends IMediaSource & IVideoStream> Map<IPlayerWrapper, T> createPlayers(List<T> list) {
        for (IPlayer iPlayer : this.mAlixPlayers) {
            iPlayer.stop();
        }
        this.mAlixPlayers.clear();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (list.size() > 0) {
            IPlayerWrapper playerWrapper = getPlayerWrapper(0);
            playerWrapper.setMute(this.mIsMuted);
            this.mAlixPlayers.add(playerWrapper);
            concurrentHashMap.put(playerWrapper, list.get(0));
        }
        return concurrentHashMap;
    }

    @Override // com.youku.alixplayer.opensdk.IMultiPlayerWrapper
    public IAlixPlayer.State getCurrentState() {
        if (this.mAlixPlayers.size() > 0) {
            return this.mAlixPlayers.get(0).getCurrentState();
        }
        return IAlixPlayer.State.STATE_IDLE;
    }

    @Override // com.youku.alixplayer.opensdk.IMultiPlayer
    public IPlayer getPlayer(int i) {
        if (this.mAlixPlayers.size() > i) {
            return this.mAlixPlayers.get(i);
        }
        return null;
    }

    @Override // com.youku.alixplayer.opensdk.IMultiPlayerWrapper
    public IPlayerTrack getPlayerTrack() {
        return this.mPlayerTrack;
    }

    @Override // com.youku.alixplayer.opensdk.IMultiPlayer
    public List<IPlayer> getPlayers() {
        return this.mAlixPlayers;
    }

    @Override // com.youku.alixplayer.opensdk.IMultiPlayer
    public void pause() {
        for (IPlayer iPlayer : this.mAlixPlayers) {
            iPlayer.pause();
        }
    }

    @Override // com.youku.alixplayer.opensdk.IMultiPlayerWrapper
    public <T extends IMediaSource & IVideoStream> void play(Map<IPlayerWrapper, T> map) {
        if (map != null) {
            for (IPlayerWrapper iPlayerWrapper : map.keySet()) {
                iPlayerWrapper.setVideoStream(map.get(iPlayerWrapper));
            }
        }
    }

    @Override // com.youku.alixplayer.opensdk.IMultiPlayer
    public void release() {
        for (IPlayer iPlayer : this.mAlixPlayers) {
            iPlayer.setResizer(null);
            iPlayer.release();
        }
        this.mAlixPlayers.clear();
        this.mTempPlayers.clear();
    }

    @Override // com.youku.alixplayer.opensdk.IMultiPlayer
    public void setMute(boolean z) {
        this.mIsMuted = z;
        for (IPlayer iPlayer : this.mAlixPlayers) {
            iPlayer.setMute(z);
        }
    }

    @Override // com.youku.alixplayer.opensdk.IMultiPlayer
    public void setPlaybackParam(int i, String str) {
        for (IPlayer iPlayer : this.mAlixPlayers) {
            iPlayer.setPlaybackParam(i, str);
        }
    }

    @Override // com.youku.alixplayer.opensdk.IMultiPlayer
    public void start() {
        for (IPlayer iPlayer : this.mAlixPlayers) {
            iPlayer.start();
        }
    }

    @Override // com.youku.alixplayer.opensdk.IMultiPlayer
    public void stop() {
        for (IPlayer iPlayer : this.mAlixPlayers) {
            iPlayer.stop();
        }
    }
}
