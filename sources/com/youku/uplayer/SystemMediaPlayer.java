package com.youku.uplayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.youku.e.a;
import com.youku.player.util.c;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class SystemMediaPlayer extends OriginalMediaPlayer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int SEEKING_DELAYED = 2;
    private static final int SEEKING_IN_PROGRESS = 1;
    private static final int SEEKING_NONE = 0;
    private int mCurrentItemIndex;
    private MediaPlayer mCurrentPlayer;
    private Handler mHandler;
    private boolean mIsPlaylistPrepared;
    private int mLastSeekPositionInMills;
    private boolean mNeedAnotherSeek;
    private int mPlayerState;
    private int mSeekPositionInMills;
    private int mSeekingState;
    private Vector<PlayListItem> mUrlList;
    private boolean released;
    private static ReentrantLock mLock = new ReentrantLock();
    private static int RELEASE_TIMEOUT = 10;
    private static final String TAG = LogTag.TAG_PREFIX + SystemMediaPlayer.class.getSimpleName();
    private int mTotalDurationInMills = 0;
    private String mPath = null;
    private SurfaceHolder mHolder = null;
    private MediaPlayer.OnBufferingUpdateListener mExternalBufferingUpdateListener = null;
    private MediaPlayer.OnCompletionListener mExternalCompletionListener = null;
    private MediaPlayer.OnErrorListener mExternalErrorListener = null;
    private MediaPlayer.OnInfoListener mExternalInfoListener = null;
    private MediaPlayer.OnPreparedListener mExternalPreparedListener = null;
    private MediaPlayer.OnSeekCompleteListener mExternalSeekCompleteListener = null;
    private MediaPlayer.OnVideoSizeChangedListener mExternalVideoSizeChangedListener = null;
    private MediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.youku.uplayer.SystemMediaPlayer.1
        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, final int i) {
            SystemMediaPlayer.this.myLogger("onBufferingUpdate ");
            SystemMediaPlayer.this.mHandler.post(new Runnable() { // from class: com.youku.uplayer.SystemMediaPlayer.1.1
                @Override // java.lang.Runnable
                public void run() {
                    SystemMediaPlayer.this.mExternalBufferingUpdateListener.onBufferingUpdate(null, i);
                }
            });
        }
    };
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() { // from class: com.youku.uplayer.SystemMediaPlayer.2
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            SystemMediaPlayer.this.myLogger("onCompletion ");
            SystemMediaPlayer.this.mHandler.post(new Runnable() { // from class: com.youku.uplayer.SystemMediaPlayer.2.1
                @Override // java.lang.Runnable
                public void run() {
                    SystemMediaPlayer.this.mExternalCompletionListener.onCompletion(null);
                }
            });
        }
    };
    private MediaPlayer.OnErrorListener mErrorListener = new MediaPlayer.OnErrorListener() { // from class: com.youku.uplayer.SystemMediaPlayer.3
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, final int i, final int i2) {
            SystemMediaPlayer.this.myLogger("onError ");
            SystemMediaPlayer.this.mHandler.post(new Runnable() { // from class: com.youku.uplayer.SystemMediaPlayer.3.1
                @Override // java.lang.Runnable
                public void run() {
                    SystemMediaPlayer.this.mExternalErrorListener.onError(null, i, i2);
                }
            });
            return true;
        }
    };
    private MediaPlayer.OnInfoListener mInfoListener = new MediaPlayer.OnInfoListener() { // from class: com.youku.uplayer.SystemMediaPlayer.4
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, final int i, final int i2) {
            SystemMediaPlayer systemMediaPlayer = SystemMediaPlayer.this;
            systemMediaPlayer.myLogger("onInfo what:" + i + " extra:" + i2);
            SystemMediaPlayer.this.mHandler.post(new Runnable() { // from class: com.youku.uplayer.SystemMediaPlayer.4.1
                @Override // java.lang.Runnable
                public void run() {
                    SystemMediaPlayer.this.mExternalInfoListener.onInfo(null, i, i2);
                }
            });
            return true;
        }
    };
    private MediaPlayer.OnPreparedListener mPreparedListener = new MediaPlayer.OnPreparedListener() { // from class: com.youku.uplayer.SystemMediaPlayer.5
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            SystemMediaPlayer.this.myLogger("onPrepared ");
            if (!SystemMediaPlayer.this.mIsPlaylistPrepared) {
                SystemMediaPlayer.this.mHandler.post(new Runnable() { // from class: com.youku.uplayer.SystemMediaPlayer.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SystemMediaPlayer.this.mExternalPreparedListener.onPrepared(null);
                    }
                });
                SystemMediaPlayer.this.mIsPlaylistPrepared = true;
            } else if (SystemMediaPlayer.this.mSeekingState != 2) {
                SystemMediaPlayer.this.mCurrentPlayer.start();
            } else {
                SystemMediaPlayer.this.mSeekingState = 1;
                SystemMediaPlayer.this.mCurrentPlayer.seekTo(SystemMediaPlayer.this.mSeekPositionInMills);
            }
        }
    };
    private MediaPlayer.OnSeekCompleteListener mSeekCompleteListener = new MediaPlayer.OnSeekCompleteListener() { // from class: com.youku.uplayer.SystemMediaPlayer.6
        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            SystemMediaPlayer.this.myLogger("onSeekComplete ");
            SystemMediaPlayer.this.mSeekingState = 0;
            SystemMediaPlayer.this.mHandler.post(new Runnable() { // from class: com.youku.uplayer.SystemMediaPlayer.6.1
                @Override // java.lang.Runnable
                public void run() {
                    SystemMediaPlayer.this.mExternalSeekCompleteListener.onSeekComplete(null);
                }
            });
        }
    };
    private MediaPlayer.OnVideoSizeChangedListener mVideoSizeChangedListener = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.youku.uplayer.SystemMediaPlayer.7
        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, final int i, final int i2) {
            SystemMediaPlayer.this.myLogger("onVideoSizeChanged ");
            SystemMediaPlayer.this.mHandler.post(new Runnable() { // from class: com.youku.uplayer.SystemMediaPlayer.7.1
                @Override // java.lang.Runnable
                public void run() {
                    SystemMediaPlayer.this.mExternalVideoSizeChangedListener.onVideoSizeChanged(null, i, i2);
                }
            });
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class PlayListItem {
        public int duration;
        public int offset;
        public String url;

        private PlayListItem() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private class SMPState {
        public static final int CHANGING_VIDEO = 1;
        public static final int NORMAL = 0;

        private SMPState() {
        }
    }

    public SystemMediaPlayer() {
        this.mPlayerState = 0;
        this.mCurrentItemIndex = 0;
        this.mSeekPositionInMills = 0;
        this.mLastSeekPositionInMills = 0;
        this.mNeedAnotherSeek = false;
        this.mIsPlaylistPrepared = false;
        this.mSeekingState = 0;
        this.mCurrentPlayer = null;
        c.a(TAG, "init wait");
        try {
        } catch (InterruptedException e) {
            c.a(TAG, e);
        }
        if (!mLock.tryLock(RELEASE_TIMEOUT, TimeUnit.SECONDS)) {
            throw new ReleaseTimeoutException("SystemMediaPlayer release timeout");
        }
        mLock.unlock();
        c.a(TAG, "init wait over");
        myLogger("SystemMediaPlayer() ");
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mCurrentItemIndex = 0;
        this.mPlayerState = 0;
        this.mSeekingState = 0;
        this.mSeekPositionInMills = 0;
        this.mLastSeekPositionInMills = 0;
        this.mNeedAnotherSeek = false;
        this.mIsPlaylistPrepared = false;
        this.mCurrentPlayer = new MediaPlayer();
        setListeners();
    }

    private void _seekTo(int i) {
        this.mSeekPositionInMills = i;
        this.mSeekingState = 1;
        this.mCurrentPlayer.seekTo(i);
    }

    private int calcSeekCoord(int i) {
        int i2 = 0;
        while (i2 < this.mUrlList.size() && this.mUrlList.get(i2).offset < i) {
            i2++;
        }
        return i2 - 1;
    }

    private void changeVideo() {
        String str = this.mUrlList.get(this.mCurrentItemIndex).url;
        try {
            this.mPlayerState = 1;
            this.mCurrentPlayer.reset();
            this.mCurrentPlayer.setDataSource(str);
            this.mCurrentPlayer.setDisplay(this.mHolder);
            this.mCurrentPlayer.prepareAsync();
            this.mPlayerState = 0;
        } catch (Exception e) {
            c.a(TAG, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void myLogger(String str) {
        String str2 = TAG;
        c.a(str2, str + " is called.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.mPath = null;
        this.mUrlList = null;
        this.mCurrentItemIndex = 0;
        this.mTotalDurationInMills = 0;
        this.mSeekPositionInMills = 0;
        this.mLastSeekPositionInMills = 0;
        this.mNeedAnotherSeek = false;
        this.mIsPlaylistPrepared = false;
        this.mPlayerState = 0;
        this.mSeekingState = 0;
    }

    @Override // com.youku.uplayer.Mediaplayer
    public int getCurrentPosition() {
        MediaPlayer mediaPlayer = this.mCurrentPlayer;
        int currentPosition = mediaPlayer != null ? mediaPlayer.getCurrentPosition() : 0;
        myLogger("getCurrentPosition:" + currentPosition);
        return currentPosition;
    }

    @Override // com.youku.uplayer.Mediaplayer
    public int getDuration() {
        myLogger("getDuration ");
        MediaPlayer mediaPlayer = this.mCurrentPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.getDuration();
        }
        return 0;
    }

    @Override // com.youku.uplayer.Mediaplayer
    public int getVideoHeight() {
        myLogger("getVideoHeight ");
        return this.mCurrentPlayer.getVideoHeight();
    }

    @Override // com.youku.uplayer.Mediaplayer
    public int getVideoWidth() {
        myLogger("getVideoWidth ");
        return this.mCurrentPlayer.getVideoWidth();
    }

    @Override // com.youku.uplayer.Mediaplayer
    public boolean isLooping() {
        myLogger("isLooping ");
        return this.mCurrentPlayer.isLooping();
    }

    @Override // com.youku.uplayer.Mediaplayer
    public boolean isPlaying() {
        try {
            boolean isPlaying = this.mCurrentPlayer.isPlaying();
            myLogger("isPlaying: " + isPlaying);
            return isPlaying;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void onSeekStart() {
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void pause() {
        myLogger("pause ");
        this.mCurrentPlayer.pause();
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void prepare() {
        myLogger("prepare ");
        this.mCurrentPlayer.prepare();
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void prepareAsync() {
        myLogger("prepareAsync ");
        this.mCurrentPlayer.prepareAsync();
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void release() {
        if (this.released) {
            return;
        }
        this.released = true;
        new Thread(new Runnable() { // from class: com.youku.uplayer.SystemMediaPlayer.8
            @Override // java.lang.Runnable
            public void run() {
                SystemMediaPlayer.mLock.lock();
                try {
                    SystemMediaPlayer.this.myLogger("release ");
                    c.a(SystemMediaPlayer.TAG, "start release");
                    SystemMediaPlayer.this.mCurrentPlayer.setDisplay(null);
                    SystemMediaPlayer.this.mCurrentPlayer.reset();
                    SystemMediaPlayer.this.mCurrentPlayer.release();
                    c.a(SystemMediaPlayer.TAG, "end release");
                    SystemMediaPlayer.this.resetData();
                    SystemMediaPlayer.this.mCurrentPlayer = null;
                } finally {
                    SystemMediaPlayer.mLock.unlock();
                }
            }
        }).start();
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void reset() {
        myLogger("reset ");
        this.mCurrentPlayer.reset();
        resetData();
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void seekTo(int i) {
        myLogger("seekTo: " + i);
        _seekTo(i);
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void setAudioStreamType(int i) {
        myLogger("setAudioStreamType ");
        this.mCurrentPlayer.setAudioStreamType(i);
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void setDataSource(String str) {
        myLogger("setDataSource ");
        this.mPath = str;
        this.mCurrentPlayer.setDataSource(a.a, Uri.parse(str));
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        myLogger("setDisplay ");
        this.mHolder = surfaceHolder;
        this.mCurrentPlayer.setDisplay(surfaceHolder);
    }

    void setListeners() {
        this.mCurrentPlayer.setOnBufferingUpdateListener(this.mBufferingUpdateListener);
        this.mCurrentPlayer.setOnCompletionListener(this.mCompletionListener);
        this.mCurrentPlayer.setOnErrorListener(this.mErrorListener);
        this.mCurrentPlayer.setOnInfoListener(this.mInfoListener);
        this.mCurrentPlayer.setOnPreparedListener(this.mPreparedListener);
        this.mCurrentPlayer.setOnSeekCompleteListener(this.mSeekCompleteListener);
        this.mCurrentPlayer.setOnVideoSizeChangedListener(this.mVideoSizeChangedListener);
    }

    public void setLooping(boolean z) {
        myLogger("setLooping ");
        this.mCurrentPlayer.setLooping(z);
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        myLogger("setOnBufferingUpdateListener ");
        this.mExternalBufferingUpdateListener = onBufferingUpdateListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        myLogger("setOnCompletionListener ");
        this.mExternalCompletionListener = onCompletionListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        myLogger("setOnErrorListener ");
        this.mExternalErrorListener = onErrorListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        myLogger("setOnInfoListener ");
        this.mExternalInfoListener = onInfoListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        myLogger("setOnPreparedListener ");
        this.mExternalPreparedListener = onPreparedListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        myLogger("setOnSeekCompleteListener ");
        this.mExternalSeekCompleteListener = onSeekCompleteListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        myLogger("setOnVideoSizeChangedListener ");
        this.mExternalVideoSizeChangedListener = onVideoSizeChangedListener;
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void setScreenOnWhilePlaying(boolean z) {
        myLogger("setScreenOnWhilePlaying ");
        this.mCurrentPlayer.setScreenOnWhilePlaying(z);
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setSurface(Surface surface) {
        myLogger("setSurface ");
        this.mCurrentPlayer.setSurface(surface);
    }

    public void setVolume(float f, float f2) {
        myLogger("setVolume ");
        this.mCurrentPlayer.setVolume(f, f2);
    }

    public void setWakeMode(Context context, int i) {
        myLogger("setWakeMode ");
        this.mCurrentPlayer.setWakeMode(context, i);
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void start() {
        myLogger("start ");
        this.mCurrentPlayer.start();
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void stop() {
        myLogger("stop ");
        this.mCurrentPlayer.stop();
    }
}
