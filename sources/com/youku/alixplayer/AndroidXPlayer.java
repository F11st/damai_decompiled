package com.youku.alixplayer;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.alipay.sdk.m.e0.a;
import com.youku.alixplayer.AlixPlayerConfig;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.alirtc.OnAlixRtcInfoListener;
import com.youku.alixplayer.alirtc.OnRtcMessageListener;
import com.youku.alixplayer.instances.Aliplayer;
import com.youku.alixplayer.instances.System.AndroidPlayer;
import com.youku.alixplayer.instances.System.AndroidPlayerStateMachine;
import com.youku.alixplayer.instances.System.SystemPlayerQueue;
import com.youku.alixplayer.model.Period;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class AndroidXPlayer extends AbsAlixPlayer implements OnStateChangeListener {
    private static int BUFFER_START_TIMEOUT = 300000;
    public static final String DATASOURCE_HEADER_KEY_START_TIME_MS = "datasource_start_time_ms";
    public static final String DATASOURCE_HEADER_KEY_SYSPLAYER_BUFFER_START_TIMEOUT_MS = "datasource_sys_bufferstart_timeout_ms";
    private static final String TAG = "AndroidXPlayer";
    private static int mLastAdSeq = -1;
    private static int sInternalCountDown = 800;
    private static int sInternalPositionUpdate = 500;
    private boolean isPreVidAdComplete;
    private long mAdDuration;
    private AndroidPlayer mAndroidPlayer;
    private OnCurrentPositionChangeListener mCurrentPostionChangeListener;
    private volatile Handler mHandler;
    private HandlerThread mHandlerThread;
    private boolean mIsLoading;
    private boolean mIsMute;
    private boolean mIsSeeking;
    private IMediaSource mMediaSource;
    private boolean mMidAdFailed;
    private IAlixPlayer.State mMuteState;
    private OnInfoListener mOnInfoListener;
    private OnStateChangeListener mOnStateChangeListener;
    private String mPlayerId;
    private SystemPlayerQueue mPlayerQueue;
    private IPlaylist mPlaylist;
    private IAlixPlayer.State mState;
    private AndroidPlayerStateMachine mStateMachine;
    private Surface mSurface;
    private String mVideoStartVPMInfo;
    @NonNull
    private volatile Handler playerMsgHandler;
    private AlixPlayerConfig playerconfig;
    private List<OnCurrentPositionChangeListener> mOnCurrentPositionChangeListeners = new CopyOnWriteArrayList();
    private List<OnSeekCompleteListener> mOnSeekCompleteListeners = new CopyOnWriteArrayList();
    protected List<OnStateChangeListener> mOnStateChangeListeners = new CopyOnWriteArrayList();
    protected List<OnLoadingChangeListener> mOnLoadingChangeListeners = new CopyOnWriteArrayList();
    protected List<OnInfoListener> mOnInfoListeners = new CopyOnWriteArrayList();
    protected List<OnQualityChangeListener> mOnQualityChangeListeners = new CopyOnWriteArrayList();
    protected List<OnAdEventListener> mOnAdEventListeners = new CopyOnWriteArrayList();
    protected List<OnVideoSizeChangedListener> mOnVideoSizeChangeListeners = new CopyOnWriteArrayList();
    private volatile Handler mUIHandler = new Handler(Looper.getMainLooper());
    private int lastType = -1;
    private VideoUriInfo info = null;
    private boolean mIsCheckAdSeq = false;
    private final int delayMs = 1000;
    private final int INVALID_SEEK_POS_MS = -1;
    private int seekMs = -1;
    private OnInfoListener onInfoListener = new OnInfoListener() { // from class: com.youku.alixplayer.AndroidXPlayer.3
        @Override // com.youku.alixplayer.OnInfoListener
        public void onInfo(int i, int i2, int i3, Object obj) {
            AndroidXPlayer.this.playerEventOnNotify(i, i2, i3, obj);
        }
    };

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    private interface MESSAGE {
        public static final int AD_COUNT_DOWN = 0;
        public static final int CURRENT_POSITION_CHANGE = 1;
        public static final int MSG_REPORT_BUFFER_ERROR = 3;
        public static final int NETSPEED_UPDATE = 2;
    }

    public AndroidXPlayer(Context context) {
        Log.d(TAG, "new AndroidXPlayer");
        this.mState = IAlixPlayer.State.STATE_IDLE;
        HandlerThread handlerThread = new HandlerThread("AndroidPlayer");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper()) { // from class: com.youku.alixplayer.AndroidXPlayer.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                AndroidXPlayer.this.internalHandleMessage(message);
            }
        };
        this.playerMsgHandler = new Handler(this.mHandlerThread.getLooper());
        this.playerconfig = new AlixPlayerConfig(AlixPlayerConfig.AlixPlayerType.PLAYER_ANDROID);
        this.mPlayerQueue = SystemPlayerQueue.create();
        AndroidPlayerStateMachine androidPlayerStateMachine = new AndroidPlayerStateMachine();
        this.mStateMachine = androidPlayerStateMachine;
        androidPlayerStateMachine.setOnStateChangeListener(this);
        this.mStateMachine.setPlayerQueue(this.mPlayerQueue);
    }

    private int checkCurrentPosition(int i) {
        if (this.info == null) {
            return -1;
        }
        int i2 = 0;
        while (true) {
            int[] iArr = this.info.endPos;
            if (i2 >= iArr.length) {
                return -1;
            }
            if (i <= iArr[i2]) {
                return i2;
            }
            i2++;
        }
    }

    private void handleComplete(int i, int i2, int i3, Object obj) {
        if (i != 0) {
            for (OnAdEventListener onAdEventListener : this.mOnAdEventListeners) {
                Log.d(TAG, "onAdEnd index=" + i2 + ", type=" + i);
                onAdEventListener.onAdEnd(i2, i);
            }
        }
        if (i == 0) {
            Log.d(TAG, "ON_VIDEO_COMPLETION, index=" + i2 + ", period.index=" + i3);
            this.mStateMachine.handleEvent(EventType.ON_VIDEO_COMPLETION);
            this.mHandler.removeMessages(1);
        } else if (i == 2) {
            this.isPreVidAdComplete = true;
            for (OnInfoListener onInfoListener : this.mOnInfoListeners) {
                onInfoListener.onInfo(3012, i2, 0, obj);
            }
        } else if (i == 4 || i == 5) {
            for (OnInfoListener onInfoListener2 : this.mOnInfoListeners) {
                onInfoListener2.onInfo(3016, i2, 0, obj);
            }
            this.mStateMachine.handleEvent(EventType.ON_POST_AD_COMPLETION);
        }
    }

    private void handleFirstFrame(int i, int i2, int i3, Object obj) {
        int i4;
        AndroidPlayerStateMachine androidPlayerStateMachine;
        EventType eventType;
        int videoWidth = this.mAndroidPlayer.getVideoWidth();
        int videoHeight = this.mAndroidPlayer.getVideoHeight();
        Log.d(TAG, "type : " + i + " , videoWidth=" + videoWidth + ", videoHeight=" + videoHeight);
        for (OnVideoSizeChangedListener onVideoSizeChangedListener : this.mOnVideoSizeChangeListeners) {
            onVideoSizeChangedListener.onVideoSizeChange(videoWidth, videoHeight);
        }
        if (i == 0) {
            this.mStateMachine.handleEvent(EventType.ON_VIDEO_START);
            i4 = 1017;
        } else if (i != 1) {
            if (i == 2) {
                i4 = 3011;
                this.isPreVidAdComplete = false;
                androidPlayerStateMachine = this.mStateMachine;
                eventType = EventType.ON_PRE_VIP_START;
            } else if (i == 3) {
                i4 = 1013;
                androidPlayerStateMachine = this.mStateMachine;
                eventType = EventType.ON_MID_AD_START;
            } else if (i == 4 || i == 5) {
                i4 = 3015;
                androidPlayerStateMachine = this.mStateMachine;
                eventType = EventType.ON_POST_AD_START;
            } else {
                i4 = 0;
            }
            androidPlayerStateMachine.handleEvent(eventType);
        } else {
            this.mStateMachine.handleEvent(EventType.ON_PRE_AD_START);
            i4 = 1011;
        }
        for (OnInfoListener onInfoListener : this.mOnInfoListeners) {
            onInfoListener.onInfo(i4, i2, i3, obj);
        }
        if (i == 0) {
            Log.d(TAG, "notify position update!");
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler.sendEmptyMessage(1);
            this.mHandler.sendEmptyMessage(2);
        } else {
            this.mAdDuration = this.mAndroidPlayer.getDuration();
            for (OnAdEventListener onAdEventListener : this.mOnAdEventListeners) {
                Log.d(TAG, "onAdStart index=" + i2 + ", type=" + i);
                onAdEventListener.onAdStart(i2, i);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler.sendEmptyMessageDelayed(0, 200L);
        }
        for (OnInfoListener onInfoListener2 : this.mOnInfoListeners) {
            onInfoListener2.onInfo(1004, 1, 0, "newEndLoading=1");
        }
        Log.d(TAG, "send MEDIA_INFO_END_LOADING");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalHandleMessage(Message message) {
        Handler handler;
        int i;
        int i2;
        int i3 = message.what;
        if (i3 != 0) {
            i = 1;
            if (i3 != 1) {
                i = 2;
                if (i3 != 2 || this.mAndroidPlayer == null || this.mHandler == null) {
                    return;
                }
            } else if (this.mAndroidPlayer == null || this.mHandler == null) {
                return;
            } else {
                int currentPosition = (int) this.mAndroidPlayer.getCurrentPosition(Aliplayer.PositionType.NORMAL);
                if (currentPosition > 0) {
                    OnCurrentPositionChangeListener onCurrentPositionChangeListener = this.mCurrentPostionChangeListener;
                    if (onCurrentPositionChangeListener != null) {
                        onCurrentPositionChangeListener.onCurrentPostionChange(currentPosition);
                    }
                    for (OnCurrentPositionChangeListener onCurrentPositionChangeListener2 : this.mOnCurrentPositionChangeListeners) {
                        onCurrentPositionChangeListener2.onCurrentPostionChange(currentPosition);
                    }
                }
            }
            handler = this.mHandler;
            i2 = sInternalPositionUpdate;
        } else if (this.mAndroidPlayer == null || this.mHandler == null) {
            return;
        } else {
            int adCountDown = this.mAndroidPlayer.getAdCountDown() - (((int) this.mAndroidPlayer.getCurrentPosition(Aliplayer.PositionType.NORMAL)) / 1000);
            Log.d(TAG, "onAdCountDown count=" + adCountDown);
            if (adCountDown >= 0) {
                for (OnAdEventListener onAdEventListener : this.mOnAdEventListeners) {
                    onAdEventListener.onAdCountDown(adCountDown);
                }
            }
            if (adCountDown <= 0) {
                return;
            }
            handler = this.mHandler;
            i = 0;
            i2 = sInternalCountDown;
        }
        handler.sendEmptyMessageDelayed(i, i2);
    }

    private boolean isErrorInfo(int i) {
        return i == 1009 || i == 1002 || i == 3001 || i == 3002 || i == 1007 || i == 1006 || i == 1112 || i == 1023 || i == 30000;
    }

    private void makeUriList(Map<String, String> map) {
        if (map == null || !map.containsKey("number") || map.get("number") == null) {
            this.info = null;
            return;
        }
        try {
            int intValue = Integer.valueOf(map.get("number")).intValue();
            VideoUriInfo videoUriInfo = new VideoUriInfo();
            this.info = videoUriInfo;
            videoUriInfo.init(intValue);
            int i = 0;
            while (i < intValue) {
                String[] strArr = this.info.uri;
                strArr[i] = map.get("uri" + i);
                String[] strArr2 = this.info.id;
                strArr2[i] = map.get("id" + i);
                int[] iArr = this.info.duration;
                iArr[i] = Integer.valueOf(map.get(ApcConstants.KEY_DURATION + i)).intValue();
                VideoUriInfo videoUriInfo2 = this.info;
                int[] iArr2 = videoUriInfo2.endPos;
                int[] iArr3 = videoUriInfo2.duration;
                iArr2[i] = iArr3[i] + (i == 0 ? 0 : iArr3[i - 1]);
                i++;
            }
        } catch (ClassCastException | NullPointerException | NumberFormatException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playerEventInternal(int i, int i2, int i3, Object obj) {
        IPeriod currentPeriod;
        StringBuilder sb;
        AndroidPlayer androidPlayer = this.mAndroidPlayer;
        if (androidPlayer == null || (currentPeriod = androidPlayer.getCurrentPeriod()) == null) {
            return;
        }
        int type = currentPeriod.getType();
        int i4 = 1;
        if (this.lastType != type && type == 0) {
            for (OnInfoListener onInfoListener : this.mOnInfoListeners) {
                onInfoListener.onInfo(1003, 1, 0, "newStartLoading=1");
            }
            Log.d(TAG, "send MEDIA_INFO_START_LOADING");
        }
        if (type != 3 && (i < 3003 || i > 3008)) {
            this.lastType = type;
        }
        if (isErrorInfo(i)) {
            if (type == 0) {
                if (i == 1112) {
                    i = 1111;
                }
                this.mStateMachine.handleEvent(EventType.ON_ERROR);
            } else if (type == 1) {
                i = 2205;
            } else if (type == 2) {
                i = 2206;
            } else if (type == 3) {
                i = 2200;
            } else if (type == 4) {
                i = MsgID.MEDIA_INFO_POSTAD_ERROR;
            } else if (type == 5) {
                i = 2211;
            }
        }
        if (i == 4) {
            for (OnSeekCompleteListener onSeekCompleteListener : this.mOnSeekCompleteListeners) {
                onSeekCompleteListener.onSeekComplete();
            }
            return;
        }
        if (i != 306) {
            if (i == 340) {
                Log.d(TAG, "AndroidXPlayer 340 msg, call onSeekComplete");
                for (OnSeekCompleteListener onSeekCompleteListener2 : this.mOnSeekCompleteListeners) {
                    onSeekCompleteListener2.onSeekComplete();
                }
                return;
            } else if (i == 1030) {
                return;
            } else {
                if (i != 10240) {
                    if (i == 701) {
                        for (OnLoadingChangeListener onLoadingChangeListener : this.mOnLoadingChangeListeners) {
                            onLoadingChangeListener.onStartLoading(obj);
                        }
                        IAlixPlayer.State currentState = getCurrentState();
                        IAlixPlayer.State state = IAlixPlayer.State.STATE_VIDEO_STARTED;
                        if ((currentState == state || getCurrentState() == IAlixPlayer.State.STATE_PRE_AD_STARTED || getCurrentState() == IAlixPlayer.State.STATE_MID_AD_STARTED || getCurrentState() == IAlixPlayer.State.STATE_POST_AD_STARTED) && !this.mIsLoading) {
                            this.mIsLoading = true;
                            boolean z = this.mIsSeeking;
                            String str = z ? "isAlixSeeking=1;" : "isAlixSeeking=0;";
                            if (z) {
                                i2 = 1;
                            }
                            String str2 = str + obj;
                            i4 = (getCurrentState() == state || getCurrentState() == IAlixPlayer.State.STATE_VIDEO_PAUSED) ? 0 : 0;
                            for (OnInfoListener onInfoListener2 : this.mOnInfoListeners) {
                                onInfoListener2.onInfo(1003, i2, i4, str2);
                            }
                            return;
                        }
                        return;
                    } else if (i == 702) {
                        for (OnLoadingChangeListener onLoadingChangeListener2 : this.mOnLoadingChangeListeners) {
                            onLoadingChangeListener2.onEndLoading(obj);
                        }
                        if (getCurrentState() == IAlixPlayer.State.STATE_VIDEO_STARTED || getCurrentState() == IAlixPlayer.State.STATE_PRE_AD_STARTED || getCurrentState() == IAlixPlayer.State.STATE_MID_AD_STARTED || getCurrentState() == IAlixPlayer.State.STATE_POST_AD_STARTED) {
                            this.mIsLoading = false;
                            if (this.mIsSeeking) {
                                i2 = 1;
                            }
                            this.mIsSeeking = false;
                            for (OnInfoListener onInfoListener3 : this.mOnInfoListeners) {
                                onInfoListener3.onInfo(1004, i2, i3, obj);
                            }
                            return;
                        }
                        return;
                    } else if (i == 1000) {
                        Log.d(TAG, "MEDIA_INFO_PREPARED index=0, type=" + type);
                        if (getCurrentState() == this.mMuteState && type != 0) {
                            Log.d(TAG, "keep audio mute at " + this.mMuteState);
                            this.mAndroidPlayer.setAudioMute(1);
                        }
                        this.mStateMachine.handleEvent(EventType.ON_PREPARED);
                        return;
                    } else if (i == 1001) {
                        handleComplete(type, 0, 0, obj);
                        return;
                    } else if (i == 1021) {
                        for (OnInfoListener onInfoListener4 : this.mOnInfoListeners) {
                            onInfoListener4.onInfo(i, i2, i3, obj);
                        }
                        for (OnQualityChangeListener onQualityChangeListener : this.mOnQualityChangeListeners) {
                            Log.d(TAG, "MEDIA_INFO_SWITCH_FINISH, index=0, period.index=");
                            onQualityChangeListener.onQualityChangeSuccess();
                        }
                        return;
                    } else if (i == 1022) {
                        for (OnInfoListener onInfoListener5 : this.mOnInfoListeners) {
                            onInfoListener5.onInfo(i, i2, i3, obj);
                        }
                        for (OnQualityChangeListener onQualityChangeListener2 : this.mOnQualityChangeListeners) {
                            Log.d(TAG, "MEDIA_INFO_SWITCH_FAILED, index=0, period.index=");
                            onQualityChangeListener2.onQualityChangeFailed();
                        }
                        return;
                    } else if (i != 2200) {
                        for (OnInfoListener onInfoListener6 : this.mOnInfoListeners) {
                            onInfoListener6.onInfo(i, i2, i3, obj);
                        }
                        return;
                    } else {
                        if (getCurrentState() != IAlixPlayer.State.STATE_MID_AD_STARTED) {
                            sb = new StringBuilder();
                            sb.append("mid ad prepared error! extra=");
                            sb.append(i2);
                        } else {
                            sb = new StringBuilder();
                            sb.append("mid ad playing error, go next. extra=");
                            sb.append(i3);
                        }
                        Log.d(TAG, sb.toString());
                        return;
                    }
                }
            }
        }
        this.mIsSeeking = false;
        this.mIsLoading = false;
        handleFirstFrame(type, 0, i3, obj);
    }

    private void sendInfoExtendToMainThread(int i, int i2, Object obj) {
        this.mHandler.post(new Runnable() { // from class: com.youku.alixplayer.AndroidXPlayer.4
            @Override // java.lang.Runnable
            public void run() {
            }
        });
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void addOnAdEventListener(OnAdEventListener onAdEventListener) {
        this.mOnAdEventListeners.add(onAdEventListener);
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void addOnCurrentPositionChangeListener(OnCurrentPositionChangeListener onCurrentPositionChangeListener) {
        Log.d(TAG, "addOnCurrentPositionChangeListener");
        this.mOnCurrentPositionChangeListeners.add(onCurrentPositionChangeListener);
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    @RequiresApi(api = 3)
    public void addOnInfoListener(OnInfoListener onInfoListener) {
        this.mOnInfoListeners.add(onInfoListener);
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void addOnLoadingChangeListener(OnLoadingChangeListener onLoadingChangeListener) {
        Log.d(TAG, "addOnLoadingChangeListener");
        this.mOnLoadingChangeListeners.add(onLoadingChangeListener);
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void addOnPlayerStateListener(OnStateChangeListener onStateChangeListener) {
        this.mOnStateChangeListeners.add(onStateChangeListener);
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void addOnQualityChangeListener(OnQualityChangeListener onQualityChangeListener) {
        Log.d(TAG, "addOnQualityChangeListener");
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

    public AlixPlayerConfig getAlixPlayerConfig() {
        return this.playerconfig;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public IMediaSource getCurrentMediaSource() {
        return null;
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public long getCurrentPosition(Aliplayer.PositionType positionType) {
        try {
            AndroidPlayer androidPlayer = this.mAndroidPlayer;
            if (androidPlayer != null) {
                androidPlayer.isPlaying();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Log.d(TAG, "getCurrentPosition: 0");
        return 0L;
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public IAlixPlayer.State getCurrentState() {
        return this.mStateMachine.getCurrentState();
    }

    public double getDoubleParameter(int i) {
        return 0.0d;
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public long getDuration() {
        AndroidPlayer androidPlayer = this.mAndroidPlayer;
        long duration = androidPlayer != null ? androidPlayer.getDuration() : 0L;
        Log.d(TAG, "getDuration: " + duration);
        return duration;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public AlixPlayerHolderUnbindListener getHolder() {
        return null;
    }

    public int getIntParameter(int i) {
        return 0;
    }

    public long getLongParameter(int i) {
        return 0L;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public String getParameterString(int i) {
        return null;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public String getPlayerId() {
        return this.mPlayerId;
    }

    public String getStringParameter(int i) {
        return "";
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public int getVideoHeight() {
        Log.d(TAG, "getVideoHeight");
        AndroidPlayer androidPlayer = this.mAndroidPlayer;
        if (androidPlayer != null) {
            return androidPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public int getVideoWidth() {
        Log.d(TAG, "getVideoWidth");
        AndroidPlayer androidPlayer = this.mAndroidPlayer;
        if (androidPlayer != null) {
            return androidPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public boolean isMuted() {
        Log.d(TAG, "isMuted");
        return false;
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer
    public boolean isPlaying() {
        AndroidPlayer androidPlayer = this.mAndroidPlayer;
        if (androidPlayer != null) {
            return androidPlayer.isPlaying();
        }
        return false;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public boolean isReuse() {
        return false;
    }

    protected boolean isValid() {
        IAlixPlayer.State currentState = getCurrentState();
        return (currentState == IAlixPlayer.State.STATE_STOPPED || currentState == IAlixPlayer.State.STATE_IDLE || currentState == IAlixPlayer.State.STATE_RELEASED) ? false : true;
    }

    @Override // com.youku.alixplayer.OnStateChangeListener
    public void onStateChange(IAlixPlayer.State state, IAlixPlayer.State state2) {
        if (state == IAlixPlayer.State.STATE_SOURCE_GETTING && state2 == IAlixPlayer.State.STATE_SOURCE_READY) {
            this.mPlaylist = this.mStateMachine.getPlaylist();
        }
        for (OnStateChangeListener onStateChangeListener : this.mOnStateChangeListeners) {
            onStateChangeListener.onStateChange(state, state2);
        }
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void pause() {
        this.mStateMachine.handleEvent(EventType.PAUSE);
        if (getCurrentState() == IAlixPlayer.State.STATE_PRE_AD_PAUSED || getCurrentState() == IAlixPlayer.State.STATE_MID_AD_PAUSED || getCurrentState() == IAlixPlayer.State.STATE_PRE_VIP_PAUSED || getCurrentState() == IAlixPlayer.State.STATE_POST_AD_PAUSED) {
            Log.d(TAG, "AD_PAUSED pause(), remove mAdCountDownRunnable");
            this.mHandler.removeMessages(0);
        }
        IAlixPlayer.State currentState = getCurrentState();
        IAlixPlayer.State state = IAlixPlayer.State.STATE_VIDEO_PAUSED;
        if (currentState == state) {
            Log.d(TAG, "VIDEO_PAUSED pause(), remove mCurrentPositionUpdateRunnable");
            this.mHandler.removeMessages(1);
        }
        this.mState = state;
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void playMidAd(Period period) {
    }

    public void playerEventOnNotify(final int i, final int i2, final int i3, final Object obj) {
        this.playerMsgHandler.post(new Runnable() { // from class: com.youku.alixplayer.AndroidXPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                AndroidXPlayer.this.playerEventInternal(i, i2, i3, obj);
            }
        });
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void prepareAsync() {
        AndroidPlayer androidPlayer;
        int i;
        Log.d(TAG, "prepareAsync  " + this.mAndroidPlayer);
        if (this.mIsMute) {
            Log.d(TAG, "prepare and setAudioMute 1");
            androidPlayer = this.mAndroidPlayer;
            i = 1;
        } else {
            Log.d(TAG, "prepare and setAudioMute 0");
            androidPlayer = this.mAndroidPlayer;
            i = 0;
        }
        androidPlayer.setAudioMute(i);
        this.mStateMachine.handleEvent(EventType.PREPARE);
        this.mHandler.sendEmptyMessage(2);
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    @RequiresApi(api = 5)
    public void release() {
        Log.d(TAG, "release  " + this.mAndroidPlayer);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.playerMsgHandler != null) {
            this.playerMsgHandler.removeCallbacksAndMessages(null);
        }
        AndroidPlayer androidPlayer = this.mAndroidPlayer;
        if (androidPlayer != null) {
            androidPlayer.release();
        }
        this.mAndroidPlayer = null;
        this.mState = IAlixPlayer.State.STATE_RELEASED;
        this.mIsLoading = false;
        this.mIsSeeking = false;
        this.mOnStateChangeListeners.clear();
        this.mOnInfoListeners.clear();
        this.mOnLoadingChangeListeners.clear();
        this.mOnQualityChangeListeners.clear();
        this.mOnAdEventListeners.clear();
        this.mOnSeekCompleteListeners.clear();
        this.mOnVideoSizeChangeListeners.clear();
        this.mOnCurrentPositionChangeListeners.clear();
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
        Log.e(TAG, "reset");
        AndroidPlayer androidPlayer = this.mAndroidPlayer;
        if (androidPlayer != null) {
            androidPlayer.reset();
            this.mState = IAlixPlayer.State.STATE_IDLE;
        }
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void seekTo(int i, int i2) {
        Log.d(TAG, "seekTo: " + i);
        if (getCurrentState() == IAlixPlayer.State.STATE_VIDEO_STARTED || getCurrentState() == IAlixPlayer.State.STATE_VIDEO_PAUSED) {
            this.mIsSeeking = true;
            this.mAndroidPlayer.seekTo(i, 0);
        }
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    @Deprecated
    public void setAudioCallback(Object obj) {
    }

    public void setAudioStreamType(int i) {
        Log.e(TAG, "setAudioStreamType:" + i);
        AndroidPlayer androidPlayer = this.mAndroidPlayer;
        if (androidPlayer != null) {
            androidPlayer.setAudioStreamType(i);
        }
    }

    @RequiresApi(api = 14)
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        Log.d(TAG, "setDataSource: " + uri.toString() + AltriaXLaunchTime.SPACE + this.mAndroidPlayer);
        makeUriList(map);
        if (map != null && map.get(DATASOURCE_HEADER_KEY_START_TIME_MS) != null) {
            try {
                this.seekMs = Integer.valueOf(map.get(DATASOURCE_HEADER_KEY_START_TIME_MS)).intValue();
            } catch (NumberFormatException unused) {
            }
            if (this.seekMs < 0) {
                Log.e(TAG, "seek startTime < 0");
            }
            Log.d(TAG, "setDataSource and need seek to " + this.seekMs);
        }
        if (map == null || map.get(DATASOURCE_HEADER_KEY_SYSPLAYER_BUFFER_START_TIMEOUT_MS) == null) {
            return;
        }
        try {
            BUFFER_START_TIMEOUT = Integer.valueOf(map.get(DATASOURCE_HEADER_KEY_SYSPLAYER_BUFFER_START_TIMEOUT_MS)).intValue();
        } catch (NumberFormatException unused2) {
        }
        if (BUFFER_START_TIMEOUT < 0) {
            BUFFER_START_TIMEOUT = a.a;
        }
        Log.d(TAG, "set buffer start timeout:" + BUFFER_START_TIMEOUT);
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void setDataSource(IMediaSource iMediaSource) {
        String sourceKey = iMediaSource.getSourceKey();
        if (this.mPlayerQueue.get(sourceKey) == null) {
            Log.d(TAG, "create new item");
            this.mPlayerQueue.addItem(SystemPlayerQueue.QueueItem.create(sourceKey));
            this.mPlayerQueue.bringToFront(sourceKey);
        }
        if (this.mPlayerQueue.getActiveItem() == null) {
            Log.e(TAG, "ERROR:mPlayerQueue.getActiveItem() = null");
            return;
        }
        AndroidPlayer mainPlayer = this.mPlayerQueue.getActiveItem().getMainPlayer();
        this.mAndroidPlayer = mainPlayer;
        mainPlayer.setOnInfoListener(this.onInfoListener);
        this.mStateMachine.setAndroidPlayer(this.mAndroidPlayer);
        this.mStateMachine.handleEvent(EventType.SET_DATASOURCE);
        IMediaSource iMediaSource2 = this.mMediaSource;
        if (iMediaSource2 != null) {
            iMediaSource2.deinit();
        }
        this.mMediaSource = iMediaSource;
        iMediaSource.addMediaSourceUpdatedListener(this.mStateMachine);
        this.mMediaSource.preparePlaylist();
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    @RequiresApi(api = 14)
    public void setDisplay(Surface surface) {
        Log.d(TAG, "setDisplay: " + surface);
        this.mSurface = surface;
        AndroidPlayer androidPlayer = this.mAndroidPlayer;
        if (androidPlayer != null) {
            androidPlayer.setDisplay(surface);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setExtraParam(Map<Object, Object> map) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setHolder(AlixPlayerHolderUnbindListener alixPlayerHolderUnbindListener) {
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void setIsLoopPlay(boolean z) {
        Log.e(TAG, "setIsLoopPlay: " + z);
        AndroidPlayer androidPlayer = this.mAndroidPlayer;
        if (androidPlayer != null) {
            androidPlayer.setLooping(z);
        }
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void setMidAd(Period period) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setMute(boolean z) {
        this.mIsMute = z;
        this.mMuteState = z ? getCurrentState() : null;
        AndroidPlayer androidPlayer = this.mAndroidPlayer;
        if (androidPlayer != null) {
            androidPlayer.setAudioMute(z ? 1 : 0);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setOnAlixRtcData(int i, Object obj) {
        Log.d(TAG, "setOnAlixRtcData");
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setOnAlixRtcInfo(OnAlixRtcInfoListener onAlixRtcInfoListener) {
        Log.d(TAG, "setOnAlixRtcInfo");
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void setOnCurrentPostionChangeListener(OnCurrentPositionChangeListener onCurrentPositionChangeListener) {
        Log.d(TAG, "setOnCurrentPostionChangeListener");
        this.mOnCurrentPositionChangeListeners.add(onCurrentPositionChangeListener);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setOnRtcMessageListener(OnRtcMessageListener onRtcMessageListener) {
        Log.d(TAG, "setOnRtcMessageListener");
    }

    public void setParameter(int i, int i2) {
    }

    public void setParameter(int i, String str) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setPlayerId(String str) {
        this.mPlayerId = str;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setReuse(boolean z) {
    }

    public void setScreenOnWhilePlaying(boolean z) {
        Log.e(TAG, "setScreenOnWhilePlaying: " + z);
        AndroidPlayer androidPlayer = this.mAndroidPlayer;
        if (androidPlayer != null) {
            androidPlayer.setScreenOnWhilePlaying(z);
        }
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void setVolume(float f) {
        AndroidPlayer androidPlayer;
        Log.e(TAG, "setVolume: " + f);
        if (!isValid() || (androidPlayer = this.mAndroidPlayer) == null) {
            return;
        }
        androidPlayer.setVolume(f);
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void start() {
        Log.d(TAG, "start  " + this.mAndroidPlayer);
        this.mStateMachine.handleEvent(EventType.START);
        if (getCurrentState() == IAlixPlayer.State.STATE_VIDEO_STARTED) {
            Log.d(TAG, "STATE_VIDEO_STARTED start(), recall mCurrentPositionUpdateRunnable");
            this.mHandler.sendEmptyMessage(1);
        }
        if (getCurrentState() == IAlixPlayer.State.STATE_PRE_AD_STARTED || getCurrentState() == IAlixPlayer.State.STATE_MID_AD_STARTED || getCurrentState() == IAlixPlayer.State.STATE_PRE_VIP_STARTED || getCurrentState() == IAlixPlayer.State.STATE_POST_AD_STARTED) {
            Log.d(TAG, "AD_VIDEO_STARTED start(), recall mAdCountDownRunnable");
            this.mHandler.sendEmptyMessage(0);
        }
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void stop() {
        Log.d(TAG, "stop()>>");
        IAlixPlayer.State currentState = getCurrentState();
        IAlixPlayer.State state = IAlixPlayer.State.STATE_STOPPED;
        if (currentState == state || getCurrentState() == IAlixPlayer.State.STATE_RELEASED) {
            Log.d(TAG, "stop in wrong state!");
        } else {
            this.mIsLoading = false;
            this.mIsSeeking = false;
            this.mIsMute = false;
            this.mMuteState = null;
            if (this.mHandler != null) {
                this.mHandler.removeCallbacksAndMessages(null);
            }
            AndroidPlayerStateMachine androidPlayerStateMachine = this.mStateMachine;
            if (androidPlayerStateMachine != null) {
                androidPlayerStateMachine.handleEvent(EventType.STOP);
            }
            IMediaSource iMediaSource = this.mMediaSource;
            if (iMediaSource != null) {
                Object sourceKey = iMediaSource.getSourceKey();
                SystemPlayerQueue systemPlayerQueue = this.mPlayerQueue;
                if (sourceKey == null) {
                    sourceKey = this.mMediaSource;
                }
                SystemPlayerQueue.QueueItem queueItem = systemPlayerQueue.get(sourceKey);
                if (queueItem != null) {
                    this.mPlayerQueue.removeItem(queueItem);
                }
                this.mMediaSource.deinit();
                this.mMediaSource = null;
            }
        }
        Log.d(TAG, "stop()<<");
        this.mState = state;
    }

    @Override // com.youku.alixplayer.AbsAlixPlayer, com.youku.alixplayer.IAlixPlayer
    public void stopMidAd(Period period) {
    }
}
