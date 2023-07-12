package com.youku.alixplayer.instances.System;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.Keep;
import com.youku.alixplayer.IPeriod;
import com.youku.alixplayer.IPlaylist;
import com.youku.alixplayer.ISource;
import com.youku.alixplayer.OnInfoListener;
import com.youku.alixplayer.instances.Aliplayer;
import com.youku.alixplayer.util.Destructable;
import com.youku.alixplayer.util.SystemUtil;
import java.io.IOException;
import java.util.List;

/* compiled from: Taobao */
@Keep
/* loaded from: classes.dex */
public class AndroidPlayer implements Destructable {
    private static final String TAG = "AndroidPlayer";
    private AudioManager audioManager;
    private boolean checkVideo;
    private IPeriod currentPeriod;
    private APPlayState currentPlayState;
    private int currentPostion;
    private MediaPlayer mMediaPlayer;
    protected OnInfoListener mOnInfoListener = null;
    private IPlaylist mPlaylist;
    private int mPreAdDuration;
    private Surface mSurface;
    private int periodIndex;
    private boolean playlistEnd;
    private int sourceIndex;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public enum APPlayState {
        AP_START,
        AP_PAUSE,
        AP_BACK_PAUSE,
        AP_PREPARE,
        AP_PREPARED,
        AP_SEEK_TO,
        AP_STOP,
        AP_RELEASE,
        AP_IDLE,
        AP_INIT
    }

    public AndroidPlayer() {
        initPlayer();
    }

    public AndroidPlayer(Context context) {
        initPlayer();
    }

    private void initListeners() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            Log.e(TAG, "initListeners mMediaPlayer == null");
            return;
        }
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.youku.alixplayer.instances.System.AndroidPlayer.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer2) {
                Log.d(AndroidPlayer.TAG, "onCompletion: " + mediaPlayer2);
                if (AndroidPlayer.this.checkVideo) {
                    AndroidPlayer.this.checkVideo = false;
                    return;
                }
                OnInfoListener onInfoListener = AndroidPlayer.this.mOnInfoListener;
                if (onInfoListener != null) {
                    onInfoListener.onInfo(1001, -1, -1, mediaPlayer2);
                }
                if (AndroidPlayer.this.playValid()) {
                    AndroidPlayer.this.playNext();
                }
            }
        });
        this.mMediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() { // from class: com.youku.alixplayer.instances.System.AndroidPlayer.2
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer2, int i) {
                OnInfoListener onInfoListener = AndroidPlayer.this.mOnInfoListener;
                if (onInfoListener != null) {
                    onInfoListener.onInfo(1031, i, 0, this);
                }
            }
        });
        this.mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.youku.alixplayer.instances.System.AndroidPlayer.3
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
                Log.d(AndroidPlayer.TAG, "onError: " + mediaPlayer2 + ", what: " + i + ", extra: " + i2);
                OnInfoListener onInfoListener = AndroidPlayer.this.mOnInfoListener;
                if (onInfoListener != null) {
                    onInfoListener.onInfo(4002, i, i2, mediaPlayer2);
                    return false;
                }
                return false;
            }
        });
        this.mMediaPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() { // from class: com.youku.alixplayer.instances.System.AndroidPlayer.4
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer2) {
                OnInfoListener onInfoListener = AndroidPlayer.this.mOnInfoListener;
                if (onInfoListener != null) {
                    onInfoListener.onInfo(4, 0, 0, mediaPlayer2);
                }
            }
        });
        this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.youku.alixplayer.instances.System.AndroidPlayer.5
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer2) {
                Log.d(AndroidPlayer.TAG, "onPrepared: " + mediaPlayer2);
                if (AndroidPlayer.this.currentPostion > 0) {
                    try {
                        AndroidPlayer.this.mMediaPlayer.seekTo(AndroidPlayer.this.currentPostion);
                    } catch (Exception unused) {
                    }
                    AndroidPlayer.this.currentPostion = 0;
                }
                OnInfoListener onInfoListener = AndroidPlayer.this.mOnInfoListener;
                if (onInfoListener != null) {
                    onInfoListener.onInfo(1000, 0, 0, mediaPlayer2);
                }
                if (AndroidPlayer.this.playlistEnd) {
                    return;
                }
                AndroidPlayer.this.start();
            }
        });
        this.mMediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.youku.alixplayer.instances.System.AndroidPlayer.6
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                Log.d(AndroidPlayer.TAG, "onInfo: " + mediaPlayer2 + ", what: " + i + ", extra: " + i2);
                OnInfoListener onInfoListener = AndroidPlayer.this.mOnInfoListener;
                if (onInfoListener != null) {
                    if (3 == i) {
                        onInfoListener.onInfo(306, 0, 0, null);
                        return true;
                    } else if (701 == i) {
                        onInfoListener.onInfo(306, 0, 0, null);
                        return true;
                    } else if (702 == i) {
                        onInfoListener.onInfo(306, 0, 0, null);
                        return true;
                    }
                }
                return false;
            }
        });
    }

    private void initPlayer() {
        this.mMediaPlayer = new MediaPlayer();
        this.audioManager = (AudioManager) SystemUtil.getApplicationContext().getSystemService("audio");
        this.currentPlayState = APPlayState.AP_IDLE;
        initListeners();
    }

    private void initPreAdDuration() {
        List sourceList;
        this.mPreAdDuration = 0;
        List periodList = this.mPlaylist.getPeriodList();
        if (periodList == null || periodList.isEmpty()) {
            return;
        }
        for (int i = this.periodIndex; i < periodList.size(); i++) {
            IPeriod iPeriod = (IPeriod) periodList.get(i);
            if (iPeriod.getType() == 1 && (sourceList = iPeriod.getSourceList()) != null && !sourceList.isEmpty()) {
                for (int i2 = this.sourceIndex; i2 < sourceList.size(); i2++) {
                    this.mPreAdDuration = (int) (this.mPreAdDuration + ((ISource) sourceList.get(i2)).getDuration());
                }
            }
        }
        Log.d(TAG, "initPreAdDuration mPreAdDuration : " + this.mPreAdDuration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playNext() {
        reset();
        release();
        initPlayer();
        setVideoPlaylistIndex();
        setNativeDataSource();
        if (this.currentPlayState == APPlayState.AP_INIT) {
            this.mMediaPlayer.setSurface(this.mSurface);
            prepareAsync();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean playValid() {
        return !this.playlistEnd && this.mPlaylist.getPeriodList().size() > 0;
    }

    private void setNativeDataSource() {
        List periodList = this.mPlaylist.getPeriodList();
        initPreAdDuration();
        if (this.periodIndex >= periodList.size()) {
            return;
        }
        IPeriod iPeriod = (IPeriod) periodList.get(this.periodIndex);
        this.currentPeriod = iPeriod;
        List sourceList = iPeriod.getSourceList();
        if (this.sourceIndex >= sourceList.size()) {
            return;
        }
        String url = ((ISource) sourceList.get(this.sourceIndex)).getUrl();
        try {
            Log.d(TAG, "setDataSource  " + url);
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.setDataSource(url);
                this.currentPlayState = APPlayState.AP_INIT;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setVideoPlaylistIndex() {
        List periodList = this.mPlaylist.getPeriodList();
        if (this.periodIndex >= periodList.size()) {
            return;
        }
        this.sourceIndex++;
        if (this.sourceIndex >= ((IPeriod) periodList.get(this.periodIndex)).getSourceList().size()) {
            this.sourceIndex = 0;
            this.periodIndex++;
        }
        if (this.periodIndex >= periodList.size()) {
            this.playlistEnd = true;
        }
    }

    public void changePeriod() {
        this.checkVideo = true;
        this.currentPostion = this.mMediaPlayer.getCurrentPosition();
        reset();
        release();
        initPlayer();
        setNativeDataSource();
        this.mMediaPlayer.setSurface(this.mSurface);
        prepareAsync();
    }

    @Override // com.youku.alixplayer.util.Destructable
    public void destruct() {
    }

    public int getAdCountDown() {
        return this.mPreAdDuration;
    }

    public IPeriod getCurrentPeriod() {
        return this.currentPeriod;
    }

    public long getCurrentPosition(Aliplayer.PositionType positionType) {
        int i = 0;
        try {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                i = this.mMediaPlayer.getCurrentPosition();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return i;
    }

    public double getDoubleParameter(int i) {
        return 0.0d;
    }

    public long getDuration() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        int duration = mediaPlayer != null ? mediaPlayer.getDuration() : 0;
        Log.d(TAG, "getDuration: " + duration);
        return duration;
    }

    public int getIntParameter(int i) {
        return 0;
    }

    public long getLongParameter(int i) {
        return 0L;
    }

    public String getStringParameter(int i) {
        return "";
    }

    public int getVideoHeight() {
        Log.d(TAG, "getVideoHeight");
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    public int getVideoWidth() {
        Log.d(TAG, "getVideoWidth");
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    public boolean isMuted() {
        Log.d(TAG, "isMuted");
        return this.audioManager.getStreamVolume(3) <= 0;
    }

    public boolean isPlaying() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.isPlaying();
        }
        return false;
    }

    public void pause() {
        Log.d(TAG, "pause  " + this.mMediaPlayer);
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
        this.currentPlayState = APPlayState.AP_PAUSE;
    }

    public void prepareAsync() {
        Log.d(TAG, "prepareAsync  " + this.mMediaPlayer);
        try {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.prepareAsync();
            }
            this.currentPlayState = APPlayState.AP_PREPARE;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void release() {
        Log.d(TAG, "release  " + this.mMediaPlayer);
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        this.mMediaPlayer = null;
        this.currentPlayState = APPlayState.AP_RELEASE;
    }

    public void reset() {
        Log.e(TAG, "reset");
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.currentPlayState = APPlayState.AP_IDLE;
        }
    }

    public void seekTo(long j, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mMediaPlayer.seekTo(j, i);
        } else {
            this.mMediaPlayer.seekTo((int) j);
        }
    }

    public void setAudioMute(int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.audioManager.adjustStreamVolume(3, i == 1 ? -100 : 100, 0);
        } else {
            this.audioManager.setStreamMute(3, i == 1);
        }
    }

    public void setAudioStreamType(int i) {
        Log.e(TAG, "setAudioStreamType:" + i);
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setAudioStreamType(i);
        }
    }

    public void setDataSource(IPlaylist iPlaylist) {
        this.mPlaylist = iPlaylist;
        this.periodIndex = 0;
        this.sourceIndex = 0;
        this.playlistEnd = false;
        setNativeDataSource();
    }

    public void setDisplay(Surface surface) {
        Log.d(TAG, "setDisplay: " + surface);
        this.mSurface = surface;
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
        }
    }

    public void setLooping(boolean z) {
        Log.e(TAG, "setIsLoopPlay: " + z);
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(z);
        }
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    public void setParameter(int i, int i2) {
    }

    public void setParameter(int i, String str) {
    }

    public void setScreenOnWhilePlaying(boolean z) {
        Log.e(TAG, "setScreenOnWhilePlaying: " + z);
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setScreenOnWhilePlaying(z);
        }
    }

    public void setSurface(Surface surface) {
        if (surface != null) {
            this.mMediaPlayer.setSurface(surface);
        }
    }

    public void setVolume(float f) {
        Log.e(TAG, "setVolume: " + f);
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f, f);
        }
    }

    public void start() {
        Log.d(TAG, "start  " + this.mMediaPlayer);
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
        this.currentPlayState = APPlayState.AP_START;
    }

    public void stop() {
        Log.d(TAG, "stop");
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        this.currentPlayState = APPlayState.AP_STOP;
    }
}
