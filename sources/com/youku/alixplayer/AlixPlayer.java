package com.youku.alixplayer;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.IMediaSource;
import com.youku.alixplayer.alirtc.OnAlixRtcInfoListener;
import com.youku.alixplayer.alirtc.OnRtcMessageListener;
import com.youku.alixplayer.config.FeatureManager;
import com.youku.alixplayer.instances.Aliplayer;
import com.youku.alixplayer.instances.PlayerQueue;
import com.youku.alixplayer.middleware.IDownloadMiddleware;
import com.youku.alixplayer.middleware.IRenderMiddleware;
import com.youku.alixplayer.misc.JNIMisc;
import com.youku.alixplayer.model.Identity;
import com.youku.alixplayer.model.Period;
import com.youku.alixplayer.model.Playlist;
import com.youku.alixplayer.state.PlayerStateMachine;
import com.youku.alixplayer.util.ClassLoader;
import com.youku.alixplayer.util.Destructable;
import com.youku.alixplayer.util.SystemSoLoader;
import com.youku.live.livesdk.util.DebugViewHelper;
import com.youku.media.arch.instruments.ConfigFetcher;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
@Keep
/* loaded from: classes.dex */
public class AlixPlayer implements IAlixPlayer, OnStateChangeListener, Aliplayer.OnPlayerEventListener, Destructable {
    private static String NS_LOCAL_PLAY_INFO = null;
    private static final String TAG = "AlixPlayer-Java";
    private static volatile boolean sGlobalInited;
    private static int sInternalPositionUpdate;
    private boolean isPreVidAdComplete;
    private Aliplayer mAliplayer;
    private Map<String, String> mCDNDomainMap;
    private IConfigCenter mConfigCenter;
    private Context mContext;
    private OnCurrentPositionChangeListener mCurrentPostionChangeListener;
    private volatile Handler mHandler;
    private HandlerThread mHandlerThread;
    private boolean mHasMidAd;
    private IMediaSource mHitPreloadMediaSource;
    private AlixPlayerHolderUnbindListener mHolderUnbindListener;
    private boolean mIsLoading;
    private boolean mIsMute;
    private boolean mIsReuse;
    private boolean mIsSeeking;
    private DefaultLocalConfigCenter mLocalConfigCenter;
    private IMediaSource mMediaSource;
    private boolean mMidAdFailed;
    private IAlixPlayer.State mMuteState;
    private long mNativeId;
    private Aliplayer.OnPlayerHostUpdateListener mOnPlayerHostUpdateListener;
    private Aliplayer.OnPlayerP2PListener mOnPlayerP2PListener;
    private String mPlayerId;
    private PlayerQueue mPlayerQueue;
    private Playlist mPlaylist;
    private Integer mRendCutMode;
    private Map<String, String> mRendCutParams;
    private Reporter mReporter;
    private PlayerStateMachine mStateMachine;
    private Surface mSurface;
    private String mVideoStartVPMInfo;
    @NonNull
    private volatile Handler playerMsgHandler;
    private Object mInitLock = new Object();
    protected List<OnStateChangeListener> mOnStateChangeListeners = new CopyOnWriteArrayList();
    protected List<OnLoadingChangeListener> mOnLoadingChangeListeners = new CopyOnWriteArrayList();
    protected List<OnInfoListener> mOnInfoListeners = new CopyOnWriteArrayList();
    protected List<OnQualityChangeListener> mOnQualityChangeListeners = new CopyOnWriteArrayList();
    protected List<OnAdEventListener> mOnAdEventListeners = new CopyOnWriteArrayList();
    protected List<OnSeekCompleteListener> mOnSeekCompleteListeners = new CopyOnWriteArrayList();
    protected List<OnVideoSizeChangedListener> mOnVideoSizeChangeListeners = new CopyOnWriteArrayList();
    protected List<OnCurrentPositionChangeListener> mOnCurrentPositionChangeListeners = new CopyOnWriteArrayList();
    private volatile Handler mUIHandler = new Handler(Looper.getMainLooper());
    protected List<IRenderMiddleware> mRenderMiddlewares = new CopyOnWriteArrayList();
    private int mPreloadMaxSize = 4;
    private Map<String, IMediaSource> mPreloadSourceMap = new HashMap();
    private Map<String, Playlist> mPreloadPlaylistMap = new HashMap();
    private int lastType = -1;
    private List<String> mPreloadList = new ArrayList();
    private Map<String, String> mStringMap = new ConcurrentHashMap();

    /* compiled from: Taobao */
    /* renamed from: com.youku.alixplayer.AlixPlayer$6  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$alixplayer$IAlixPlayer$State;

        static {
            int[] iArr = new int[IAlixPlayer.State.values().length];
            $SwitchMap$com$youku$alixplayer$IAlixPlayer$State = iArr;
            try {
                iArr[IAlixPlayer.State.STATE_PRE_VIP_STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_PRE_VIP_PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_PRE_AD_STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_PRE_AD_PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_MID_AD_STARTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_MID_AD_PAUSED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_POST_AD_STARTED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_POST_AD_PAUSED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class DefaultLocalConfigCenter implements ILocalConfigCenter, Destructable {
        private OnLocalConfigCenterListener mOnLocalConfigCenterListener;
        private volatile boolean mDestructed = false;
        @Keep
        private long mNativeId = init();
        private Map<String, Map<String, String>> mNamespacedKVs = new HashMap();

        DefaultLocalConfigCenter() {
        }

        @Keep
        private native void deinit();

        @Keep
        private String getLocalConfig(String str, String str2, String str3) {
            String localConfig;
            if (this.mNamespacedKVs.containsKey(str)) {
                localConfig = this.mNamespacedKVs.get(str).get(str2);
            } else {
                OnLocalConfigCenterListener onLocalConfigCenterListener = this.mOnLocalConfigCenterListener;
                localConfig = onLocalConfigCenterListener != null ? onLocalConfigCenterListener.getLocalConfig(str, str2, str3) : null;
            }
            return localConfig == null ? str3 : localConfig;
        }

        @Keep
        private native long init();

        @Keep
        private native void notifyValueChanged(String str, String str2, String str3);

        @Override // com.youku.alixplayer.util.Destructable
        public void destruct() {
            this.mDestructed = true;
            deinit();
        }

        public void setOnLocalConfigCenterListener(OnLocalConfigCenterListener onLocalConfigCenterListener) {
            this.mOnLocalConfigCenterListener = onLocalConfigCenterListener;
        }

        @Override // com.youku.alixplayer.ILocalConfigCenter
        public void updateLocalConfig(String str, String str2, String str3) {
            Map<String, String> map;
            if (this.mNamespacedKVs.containsKey(str)) {
                map = this.mNamespacedKVs.get(str);
            } else {
                map = new HashMap<>();
                this.mNamespacedKVs.put(str, map);
            }
            map.put(str2, str3);
            if (this.mDestructed) {
                return;
            }
            notifyValueChanged(str, str2, str3);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    private class LivePreloadEvent implements Aliplayer.OnPlayerEventListener {
        public Aliplayer aliplayer;
        private boolean mIsPrepared;
        public IMediaSource mediaSource;
        public Playlist playlist;

        private LivePreloadEvent() {
        }

        private void stopCurrentPlayer() {
            AlixPlayer.this.mAliplayer.stop();
            if (AlixPlayer.this.mMediaSource != null) {
                PlayerQueue.QueueItem queueItem = AlixPlayer.this.mPlayerQueue.get(AlixPlayer.this.mMediaSource.getSourceKey());
                if (queueItem != null) {
                    AlixPlayer.this.mPlayerQueue.removeItem(queueItem);
                }
                AlixPlayer.this.mMediaSource.deinit();
            }
            AlixPlayer.this.mAliplayer.setOnPlayerEventListener(null);
            AlixPlayer.this.mMediaSource = this.mediaSource;
        }

        private void stopNewPlayer() {
            this.aliplayer.stop();
            AlixPlayer.this.mPlayerQueue.removeItem(AlixPlayer.this.mPlayerQueue.get(this.mediaSource.getSourceKey()));
            IMediaSource iMediaSource = this.mediaSource;
            if (iMediaSource != null) {
                iMediaSource.deinit();
            }
        }

        @Override // com.youku.alixplayer.instances.Aliplayer.OnPlayerEventListener
        public void onNotify(Identity identity, int i, int i2, int i3, Object obj) {
            int i4 = 0;
            if (i == 1000 && !this.mIsPrepared) {
                this.mIsPrepared = true;
                Log.d(AlixPlayer.TAG, "switchLiveDataSource: onprepared!");
                stopCurrentPlayer();
                AlixPlayer.this.mAliplayer = this.aliplayer;
                if (AlixPlayer.this.mRenderMiddlewares.size() > 0) {
                    AlixPlayer.this.mAliplayer.enableVideoPipeline(true);
                    AlixPlayer.this.mAliplayer.enableAudioPipeline(false);
                    for (IRenderMiddleware iRenderMiddleware : AlixPlayer.this.mRenderMiddlewares) {
                        AlixPlayer.this.mAliplayer.addRenderMiddleware(iRenderMiddleware);
                    }
                }
                AlixPlayer.this.mReporter = this.aliplayer.getmReporter();
                AlixPlayer.this.mStateMachine.setAliplayer(AlixPlayer.this.mAliplayer);
                AlixPlayer.this.mAliplayer.setSurface(AlixPlayer.this.mSurface);
                AlixPlayer.this.mAliplayer.start();
            } else if (AlixPlayer.this.isErrorInfo(i)) {
                if (this.mIsPrepared) {
                    if (i == 1112) {
                        i = 1111;
                    }
                    AlixPlayer.this.mStateMachine.handleEvent(EventType.ON_ERROR);
                    for (OnInfoListener onInfoListener : AlixPlayer.this.mOnInfoListeners) {
                        onInfoListener.onInfo(i, i2, i3, obj);
                    }
                    return;
                }
                stopNewPlayer();
                Log.d(AlixPlayer.TAG, "switchLiveDataSource: error notify MEDIA_INFO_SWITCH_FAILED");
                for (OnInfoListener onInfoListener2 : AlixPlayer.this.mOnInfoListeners) {
                    onInfoListener2.onInfo(1022, i2, i3, obj);
                }
                for (OnQualityChangeListener onQualityChangeListener : AlixPlayer.this.mOnQualityChangeListeners) {
                    onQualityChangeListener.onQualityChangeFailed();
                }
            } else if (i == 306) {
                int videoWidth = this.aliplayer.getVideoWidth();
                int videoHeight = this.aliplayer.getVideoHeight();
                Log.d(AlixPlayer.TAG, "switchLiveDataSource:videoWidth=" + videoWidth + ", videoHeight=" + videoHeight);
                for (OnVideoSizeChangedListener onVideoSizeChangedListener : AlixPlayer.this.mOnVideoSizeChangeListeners) {
                    onVideoSizeChangedListener.onVideoSizeChange(videoWidth, videoHeight);
                }
                Log.d(AlixPlayer.TAG, "switchLiveDataSource:MEDIA_INFO_SWITCH_FINISH");
                for (OnInfoListener onInfoListener3 : AlixPlayer.this.mOnInfoListeners) {
                    onInfoListener3.onInfo(1021, i2, i3, null);
                }
                for (OnQualityChangeListener onQualityChangeListener2 : AlixPlayer.this.mOnQualityChangeListeners) {
                    onQualityChangeListener2.onQualityChangeSuccess();
                }
            } else if (i != 701) {
                if (i != 702) {
                    if (i != 1001) {
                        for (OnInfoListener onInfoListener4 : AlixPlayer.this.mOnInfoListeners) {
                            onInfoListener4.onInfo(i, i2, i3, obj);
                        }
                        return;
                    }
                    Log.d(AlixPlayer.TAG, "switchLiveDataSource:ON_VIDEO_COMPLETION");
                    AlixPlayer.this.mStateMachine.handleEvent(EventType.ON_VIDEO_COMPLETION);
                    AlixPlayer.this.mHandler.removeMessages(1);
                    return;
                }
                Log.d(AlixPlayer.TAG, "switchLiveDataSource:MEDIA_INFO_BUFFERING_END");
                for (OnLoadingChangeListener onLoadingChangeListener : AlixPlayer.this.mOnLoadingChangeListeners) {
                    onLoadingChangeListener.onEndLoading(null);
                }
                if (AlixPlayer.this.getCurrentState() == IAlixPlayer.State.STATE_VIDEO_STARTED || AlixPlayer.this.getCurrentState() == IAlixPlayer.State.STATE_PRE_AD_STARTED || AlixPlayer.this.getCurrentState() == IAlixPlayer.State.STATE_MID_AD_STARTED || AlixPlayer.this.getCurrentState() == IAlixPlayer.State.STATE_POST_AD_STARTED) {
                    AlixPlayer.this.mIsLoading = false;
                    AlixPlayer.this.mIsSeeking = false;
                    for (OnInfoListener onInfoListener5 : AlixPlayer.this.mOnInfoListeners) {
                        onInfoListener5.onInfo(1004, i2, i3, obj);
                    }
                }
            } else {
                Log.d(AlixPlayer.TAG, "switchLiveDataSource:MEDIA_INFO_BUFFERING_START");
                for (OnLoadingChangeListener onLoadingChangeListener2 : AlixPlayer.this.mOnLoadingChangeListeners) {
                    onLoadingChangeListener2.onStartLoading(null);
                }
                IAlixPlayer.State currentState = AlixPlayer.this.getCurrentState();
                IAlixPlayer.State state = IAlixPlayer.State.STATE_VIDEO_STARTED;
                if ((currentState == state || AlixPlayer.this.getCurrentState() == IAlixPlayer.State.STATE_PRE_AD_STARTED || AlixPlayer.this.getCurrentState() == IAlixPlayer.State.STATE_MID_AD_STARTED || AlixPlayer.this.getCurrentState() == IAlixPlayer.State.STATE_POST_AD_STARTED) && !AlixPlayer.this.mIsLoading) {
                    AlixPlayer.this.mIsLoading = true;
                    String str = (AlixPlayer.this.mIsSeeking ? "isAlixSeeking=1;" : "isAlixSeeking=0;") + obj;
                    if (AlixPlayer.this.getCurrentState() != state && AlixPlayer.this.getCurrentState() != IAlixPlayer.State.STATE_VIDEO_PAUSED) {
                        i4 = 1;
                    }
                    for (OnInfoListener onInfoListener6 : AlixPlayer.this.mOnInfoListeners) {
                        onInfoListener6.onInfo(1003, i2, i4, str);
                    }
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    private interface MESSAGE {
        public static final int AD_COUNT_DOWN = 0;
        public static final int CURRENT_POSITION_CHANGE = 1;
        public static final int NETSPEED_UPDATE = 2;
    }

    /* compiled from: Taobao */
    @Keep
    /* loaded from: classes.dex */
    private class PreLoadEvent implements Aliplayer.OnPlayerEventListener {
        public String key;
        public IPreloadListener preloadListener;

        private PreLoadEvent() {
        }

        @Override // com.youku.alixplayer.instances.Aliplayer.OnPlayerEventListener
        public void onNotify(Identity identity, int i, int i2, int i3, Object obj) {
            if (i == 1000) {
                Log.d(AlixPlayer.TAG, "preloadDataSource: onprepared!");
                AlixPlayer.this.mPlayerQueue.get(this.key).setOnprepared(true);
                IPreloadListener iPreloadListener = this.preloadListener;
                if (iPreloadListener != null) {
                    iPreloadListener.onPrepared();
                }
            }
        }
    }

    static {
        FeatureManager.getInstance();
        SystemSoLoader.load("alixplayer");
        SystemSoLoader.load(FeatureManager.FEATURE_KEY_OPR);
        sInternalPositionUpdate = 500;
        NS_LOCAL_PLAY_INFO = DebugViewHelper.PLAY_INFO_TAG;
        sGlobalInited = false;
    }

    public AlixPlayer(Context context) {
        this.mContext = context;
        this.mNativeId = nativeInit(context);
        if (!sGlobalInited) {
            synchronized (AlixPlayer.class) {
                if (!sGlobalInited) {
                    JNIMisc.registerMiscCallbacks(Integer.valueOf(ConfigFetcher.getInstance().getConfig("ns_aliplayer_tlog_config", "key_aliplayer_tlog_config", "1")).intValue());
                    globalInit(getGlobalCacheDir(context));
                    sGlobalInited = true;
                }
            }
        }
        ClassLoader.setApplicationClassLoader(context.getClassLoader());
        this.mPlayerQueue = PlayerQueue.create();
        PlayerStateMachine playerStateMachine = new PlayerStateMachine();
        this.mStateMachine = playerStateMachine;
        playerStateMachine.setOnStateChangeListener(this);
        this.mStateMachine.setPlayerQueue(this.mPlayerQueue);
        HandlerThread handlerThread = new HandlerThread("AlixPlayer");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper()) { // from class: com.youku.alixplayer.AlixPlayer.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                AlixPlayer.this.internalHandleMessage(message);
            }
        };
        this.playerMsgHandler = new Handler(this.mHandlerThread.getLooper());
        this.mLocalConfigCenter = new DefaultLocalConfigCenter();
    }

    private static String getGlobalCacheDir(Context context) {
        if (!"mounted".equals(Environment.getExternalStorageState()) || context.getExternalCacheDir() == null) {
            return "";
        }
        return context.getExternalCacheDir().getAbsolutePath() + File.separator + "youku_video_cache";
    }

    private int getPeriodType(long j) {
        return this.mPlaylist.getPeriodList().get((int) ((j >> 8) & 255)).getType();
    }

    private static native void globalInit(String str);

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
        } else if (i == 1) {
            for (OnInfoListener onInfoListener : this.mOnInfoListeners) {
                onInfoListener.onInfo(1012, i2, 0, obj);
            }
        } else if (i == 2) {
            this.isPreVidAdComplete = true;
            for (OnInfoListener onInfoListener2 : this.mOnInfoListeners) {
                onInfoListener2.onInfo(3012, i2, 0, obj);
            }
        } else if (i == 4 || i == 5) {
            for (OnInfoListener onInfoListener3 : this.mOnInfoListeners) {
                onInfoListener3.onInfo(3016, i2, 0, obj);
            }
            this.mStateMachine.handleEvent(EventType.ON_POST_AD_COMPLETION);
        }
    }

    private void handleFirstFrame(int i, int i2, int i3, Object obj) {
        int i4;
        PlayerStateMachine playerStateMachine;
        EventType eventType;
        if (i == 0) {
            this.mStateMachine.handleEvent(EventType.ON_VIDEO_START);
            i4 = 1017;
        } else if (i != 1) {
            if (i == 2) {
                i4 = 3011;
                this.isPreVidAdComplete = false;
                playerStateMachine = this.mStateMachine;
                eventType = EventType.ON_PRE_VIP_START;
            } else if (i == 3) {
                i4 = 1013;
                this.mMidAdFailed = false;
                playerStateMachine = this.mStateMachine;
                eventType = EventType.ON_MID_AD_START;
            } else if (i == 4 || i == 5) {
                i4 = 3015;
                playerStateMachine = this.mStateMachine;
                eventType = EventType.ON_POST_AD_START;
            } else {
                i4 = 0;
            }
            playerStateMachine.handleEvent(eventType);
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
        int i = message.what;
        if (i == 0) {
            if (this.mAliplayer == null || this.mHandler == null) {
                return;
            }
            long duration = this.mAliplayer.getDuration() - this.mAliplayer.getCurrentPosition(Aliplayer.PositionType.NORMAL);
            int i2 = (int) (duration / 1000);
            if (i2 >= 0) {
                Log.d(TAG, "onAdCountDown count=" + i2);
                for (OnAdEventListener onAdEventListener : this.mOnAdEventListeners) {
                    onAdEventListener.onAdCountDown(i2);
                }
            }
            if (i2 > 0) {
                this.mHandler.sendEmptyMessageAtTime(0, SystemClock.uptimeMillis() + (duration % 1000) + 500);
                return;
            }
            return;
        }
        int i3 = 1;
        if (i != 1) {
            i3 = 2;
            if (i != 2 || this.mAliplayer == null || this.mHandler == null) {
                return;
            }
            int downloadSpeed = this.mAliplayer.getDownloadSpeed(null);
            if (downloadSpeed > 0) {
                for (OnInfoListener onInfoListener : this.mOnInfoListeners) {
                    onInfoListener.onInfo(2006, downloadSpeed, 0, null);
                }
            }
        } else if (this.mAliplayer == null || this.mHandler == null) {
            return;
        } else {
            int currentPosition = (int) this.mAliplayer.getCurrentPosition(Aliplayer.PositionType.NORMAL);
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
        this.mHandler.sendEmptyMessageDelayed(i3, sInternalPositionUpdate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isErrorInfo(int i) {
        return i == 1009 || i == 1002 || i == 3001 || i == 3002 || i == 1007 || i == 1006 || i == 1112 || i == 1023 || i == 30000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isStarted(IAlixPlayer.State state) {
        return state == IAlixPlayer.State.STATE_VIDEO_STARTED || state == IAlixPlayer.State.STATE_PRE_AD_STARTED || state == IAlixPlayer.State.STATE_MID_AD_STARTED || state == IAlixPlayer.State.STATE_POST_AD_STARTED || state == IAlixPlayer.State.STATE_PRE_VIP_STARTED;
    }

    private boolean isVideoPlaying() {
        return getCurrentState() == IAlixPlayer.State.STATE_VIDEO_STARTED || getCurrentState() == IAlixPlayer.State.STATE_VIDEO_PAUSED;
    }

    private native void nativeDeinit();

    private native long nativeInit(Context context);

    /* JADX INFO: Access modifiers changed from: private */
    public void onNotifyInternal(Identity identity, int i, int i2, int i3, Object obj) {
        int type;
        int currentPosition;
        if (this.mAliplayer == null) {
            return;
        }
        int i4 = 0;
        if (i == 10240) {
            Log.d(TAG, "video recover, remove mid ad!");
            this.mAliplayer.resetIsolatePeriod();
            this.mHasMidAd = false;
        }
        if (identity.getCategory() == Identity.Category.ISOLATED) {
            type = 3;
        } else {
            Playlist playlist = this.mPlaylist;
            if (playlist == null) {
                Log.e(TAG, "onNotifyInternal, mPlaylist is null");
                return;
            }
            List<Period> periodList = playlist.getPeriodList();
            int periodId = identity.getPeriodId();
            type = (periodList == null || periodList.size() <= periodId) ? 0 : periodList.get(periodId).getType();
        }
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
        int sourceId = identity.getSourceId();
        int periodId2 = identity.getPeriodId();
        if (i == 4) {
            if (this.mCurrentPostionChangeListener == null || this.mAliplayer == null || this.mHandler == null || (currentPosition = (int) this.mAliplayer.getCurrentPosition(Aliplayer.PositionType.NORMAL)) <= 0) {
                return;
            }
            this.mCurrentPostionChangeListener.onCurrentPostionChange(currentPosition);
            return;
        }
        if (i != 306) {
            if (i == 340) {
                Log.d(TAG, "AlixPlayer 340 msg, call onSeekComplete");
                for (OnSeekCompleteListener onSeekCompleteListener : this.mOnSeekCompleteListeners) {
                    onSeekCompleteListener.onSeekComplete();
                }
                return;
            } else if (i == 1030) {
                for (OnVideoSizeChangedListener onVideoSizeChangedListener : this.mOnVideoSizeChangeListeners) {
                    onVideoSizeChangedListener.onVideoSizeChange(i2, i3);
                }
                return;
            } else if (i != 10240) {
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
                        if (getCurrentState() != state && getCurrentState() != IAlixPlayer.State.STATE_VIDEO_PAUSED) {
                            i4 = 1;
                        }
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
                    Log.d(TAG, "MEDIA_INFO_PREPARED index=" + sourceId + ", type=" + type);
                    if (getCurrentState() == this.mMuteState && type != 0) {
                        Log.d(TAG, "keep audio mute at " + this.mMuteState);
                        this.mAliplayer.setAudioMute(1);
                    }
                    if (this.mRendCutMode != null) {
                        Log.d(TAG, "MEDIA_INFO_PREPARED mRendCutMode=" + this.mRendCutMode + ", mRendCutParams=" + this.mRendCutParams);
                        this.mAliplayer.setVideoRendCutMode(this.mRendCutMode.intValue(), this.mRendCutParams);
                    }
                    this.mStateMachine.handleEvent(EventType.ON_PREPARED);
                    int videoWidth = this.mAliplayer.getVideoWidth();
                    int videoHeight = this.mAliplayer.getVideoHeight();
                    Log.d(TAG, "videoWidth=" + videoWidth + ", videoHeight=" + videoHeight);
                    for (OnVideoSizeChangedListener onVideoSizeChangedListener2 : this.mOnVideoSizeChangeListeners) {
                        onVideoSizeChangedListener2.onVideoSizeChange(videoWidth, videoHeight);
                    }
                    return;
                } else if (i == 1001) {
                    handleComplete(type, sourceId, periodId2, obj);
                    return;
                } else if (i == 1021) {
                    for (OnInfoListener onInfoListener4 : this.mOnInfoListeners) {
                        onInfoListener4.onInfo(i, i2, i3, obj);
                    }
                    for (OnQualityChangeListener onQualityChangeListener : this.mOnQualityChangeListeners) {
                        Log.d(TAG, "MEDIA_INFO_SWITCH_FINISH, index=" + sourceId + ", period.index=" + identity.getPeriodId());
                        onQualityChangeListener.onQualityChangeSuccess();
                    }
                    return;
                } else if (i == 1022) {
                    for (OnInfoListener onInfoListener5 : this.mOnInfoListeners) {
                        onInfoListener5.onInfo(i, i2, i3, obj);
                    }
                    for (OnQualityChangeListener onQualityChangeListener2 : this.mOnQualityChangeListeners) {
                        Log.d(TAG, "MEDIA_INFO_SWITCH_FAILED, index=" + sourceId + ", period.index=" + identity.getPeriodId());
                        onQualityChangeListener2.onQualityChangeFailed();
                    }
                    return;
                } else if (i != 2200) {
                    if (i == 3200) {
                        obj = this.mVideoStartVPMInfo;
                    }
                    for (OnInfoListener onInfoListener6 : this.mOnInfoListeners) {
                        onInfoListener6.onInfo(i, i2, i3, obj);
                    }
                    return;
                } else if (getCurrentState() != IAlixPlayer.State.STATE_MID_AD_STARTED) {
                    Log.d(TAG, "mid ad prepared error! extra=" + i2);
                    this.mMidAdFailed = true;
                    return;
                } else {
                    Log.d(TAG, "mid ad playing error, go next. extra=" + i3);
                    this.mAliplayer.goNext(true);
                    return;
                }
            }
        }
        this.mIsSeeking = false;
        this.mIsLoading = false;
        if (type == 0) {
            this.mVideoStartVPMInfo = obj.toString();
        }
        handleFirstFrame(type, sourceId, i3, obj);
    }

    private void sendBroadcastWhenStarted() {
        int i;
        try {
            i = Integer.valueOf(ConfigFetcher.getInstance().getConfig("pip_config", "start_delay_time", "0")).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        this.mUIHandler.postDelayed(new Runnable() { // from class: com.youku.alixplayer.AlixPlayer.5
            @Override // java.lang.Runnable
            public void run() {
                if (AlixPlayer.this.isStarted(AlixPlayer.this.getCurrentState())) {
                    Intent intent = new Intent("com.youku.phone.player.started");
                    String obj = AlixPlayer.this.toString();
                    intent.putExtra("PlayerInstance", obj);
                    intent.putExtra("isMuted", AlixPlayer.this.isMuted());
                    intent.putExtra("hashCode", AlixPlayer.this.hashCode());
                    Log.d(AlixPlayer.TAG, "com.youku.phone.player.started: " + obj);
                    boolean sendBroadcast = LocalBroadcastManager.getInstance(AlixPlayer.this.mContext).sendBroadcast(intent);
                    Log.d(AlixPlayer.TAG, "sendBroadcastWhenStarted: isFinish1=" + sendBroadcast);
                }
            }
        }, i);
    }

    private native void setConfigCenterNative(IConfigCenter iConfigCenter);

    @Override // com.youku.alixplayer.IAlixPlayer
    public native void addDownloadMiddleware(IDownloadMiddleware iDownloadMiddleware);

    @Override // com.youku.alixplayer.IAlixPlayer
    public void addOnAdEventListener(OnAdEventListener onAdEventListener) {
        this.mOnAdEventListeners.add(onAdEventListener);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void addOnCurrentPositionChangeListener(OnCurrentPositionChangeListener onCurrentPositionChangeListener) {
        this.mOnCurrentPositionChangeListeners.add(onCurrentPositionChangeListener);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void addOnInfoListener(OnInfoListener onInfoListener) {
        this.mOnInfoListeners.add(onInfoListener);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void addOnLoadingChangeListener(OnLoadingChangeListener onLoadingChangeListener) {
        this.mOnLoadingChangeListeners.add(onLoadingChangeListener);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void addOnPlayerStateListener(OnStateChangeListener onStateChangeListener) {
        this.mOnStateChangeListeners.add(onStateChangeListener);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void addOnQualityChangeListener(OnQualityChangeListener onQualityChangeListener) {
        this.mOnQualityChangeListeners.add(onQualityChangeListener);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void addOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListeners.add(onSeekCompleteListener);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void addOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOnVideoSizeChangeListeners.add(onVideoSizeChangedListener);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void addPostAd(Period period) {
        Log.d(TAG, "addPostAd()");
        if (this.mAliplayer != null) {
            this.mPlaylist.addPeriod(period);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void addRenderMiddleware(IRenderMiddleware iRenderMiddleware) {
        this.mRenderMiddlewares.add(iRenderMiddleware);
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.addRenderMiddleware(iRenderMiddleware);
            this.mAliplayer.enableVideoPipeline(true);
            this.mAliplayer.enableAudioPipeline(false);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public int addSubtitle(String str) {
        Log.d(TAG, "addSubtitle: " + str);
        return 0;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public native void applyDownloadMiddleware(Downloader downloader);

    @Override // com.youku.alixplayer.IAlixPlayer
    public native void applyRenderMiddleware(Render render);

    @Override // com.youku.alixplayer.IAlixPlayer
    public void cancelPreloadMediaSource(String str) {
        Log.d(TAG, "cancelPreloadMediaSource: sourceKey=" + str);
        if (this.mPreloadList.contains(str)) {
            PlayerQueue.QueueItem queueItem = this.mPlayerQueue.get(str);
            if (queueItem != null) {
                queueItem.getMainPlayer().stop();
                queueItem.getMainPlayer().getmReporter().destruct();
                this.mPlayerQueue.removeItem(queueItem);
            }
            this.mPreloadList.remove(str);
            IMediaSource iMediaSource = this.mPreloadSourceMap.get(str);
            if (iMediaSource != null) {
                iMediaSource.deinit();
            }
            this.mPreloadSourceMap.remove(str);
            this.mPreloadPlaylistMap.remove(str);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void cancelPreloadMediaSourceList() {
        Log.d(TAG, "cancelPreloadMediaSourceList");
        for (String str : this.mPreloadList) {
            PlayerQueue.QueueItem queueItem = this.mPlayerQueue.get(str);
            if (queueItem != null) {
                queueItem.getMainPlayer().stop();
                queueItem.getMainPlayer().getmReporter().destruct();
                this.mPlayerQueue.removeItem(queueItem);
            }
            this.mPreloadList.remove(str);
            IMediaSource iMediaSource = this.mPreloadSourceMap.get(str);
            if (iMediaSource != null) {
                iMediaSource.deinit();
            }
            this.mPreloadSourceMap.remove(str);
            this.mPreloadPlaylistMap.remove(str);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void changeVideoSize(int i, int i2) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.changeVideoSize(i, i2);
        }
    }

    public void destroy() {
    }

    @Override // com.youku.alixplayer.util.Destructable
    public void destruct() {
        List<IRenderMiddleware> list = this.mRenderMiddlewares;
        if (list != null && list.size() != 0) {
            for (IRenderMiddleware iRenderMiddleware : this.mRenderMiddlewares) {
                removeRenderMiddleware(iRenderMiddleware);
            }
        }
        DefaultLocalConfigCenter defaultLocalConfigCenter = this.mLocalConfigCenter;
        if (defaultLocalConfigCenter != null) {
            defaultLocalConfigCenter.destruct();
            this.mLocalConfigCenter = null;
        }
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.destruct();
        }
        Aliplayer.OnPlayerHostUpdateListener onPlayerHostUpdateListener = this.mOnPlayerHostUpdateListener;
        if (onPlayerHostUpdateListener != null) {
            onPlayerHostUpdateListener.destruct();
            this.mOnPlayerHostUpdateListener = null;
        }
        nativeDeinit();
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void enableVoice(int i) {
        Log.d(TAG, "enable Voice :" + i);
        boolean z = i == 0;
        this.mIsMute = z;
        this.mMuteState = z ? getCurrentState() : null;
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.setAudioMute(i != 0 ? 0 : 1);
        }
    }

    public void finalize() {
        Log.d(TAG, "finalize called");
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public int generateCacheFile(String str, String str2) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.generateCacheFile(str, str2);
            return 0;
        }
        return 0;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public double getAvgKeyFrameSize() {
        Aliplayer aliplayer;
        if (!isValid() || (aliplayer = this.mAliplayer) == null) {
            return 0.0d;
        }
        return aliplayer.getAvgKeyFrameSize();
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public double getAvgVideoBitrate() {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            return aliplayer.getAvgVideoBitrate();
        }
        return 0.0d;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public IMediaSource getCurrentMediaSource() {
        return this.mMediaSource;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public long getCurrentPosition(Aliplayer.PositionType positionType) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            return aliplayer.getCurrentPosition(positionType);
        }
        return 0L;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public int getCurrentRenderType() {
        Aliplayer aliplayer;
        if (!isValid() || (aliplayer = this.mAliplayer) == null) {
            return -1;
        }
        return aliplayer.getCurrentRenderType();
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public IAlixPlayer.State getCurrentState() {
        IAlixPlayer.State state = IAlixPlayer.State.STATE_IDLE;
        PlayerStateMachine playerStateMachine = this.mStateMachine;
        return playerStateMachine != null ? playerStateMachine.getCurrentState() : state;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public float getCurrentZoomScale() {
        Aliplayer aliplayer;
        if (!isValid() || (aliplayer = this.mAliplayer) == null) {
            return 1.0f;
        }
        return aliplayer.getCurrentZoomScale();
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public int getDownloadSpeed(int[] iArr) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.getDownloadSpeed(iArr);
            return 0;
        }
        return 0;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public long getDuration() {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            return aliplayer.getDuration();
        }
        return 0L;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public String getGlobalInfoByKey(int i) {
        Aliplayer aliplayer;
        return (!isValid() || (aliplayer = this.mAliplayer) == null) ? "" : aliplayer.getGlobalInfoByKey(i);
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public IMediaSource getHitPreloadMediaSource() {
        return this.mHitPreloadMediaSource;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public AlixPlayerHolderUnbindListener getHolder() {
        return this.mHolderUnbindListener;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public ILocalConfigCenter getLocalConfigCenter() {
        return this.mLocalConfigCenter;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public Aliplayer getMainPlayer() {
        return this.mAliplayer;
    }

    public long getNativeId() {
        return this.mNativeId;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public String getParameterString(int i) {
        Aliplayer aliplayer;
        if (!isValid() || (aliplayer = this.mAliplayer) == null) {
            return null;
        }
        return aliplayer.getParameterString(i);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public String getPlayerId() {
        return this.mPlayerId;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public String getPlayerInfoByKey(int i) {
        Aliplayer aliplayer;
        if (!isValid() || (aliplayer = this.mAliplayer) == null) {
            return null;
        }
        return aliplayer.getPlayerInfoByKey(i);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public PlayerQueue getPlayerQueue() {
        return this.mPlayerQueue;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public List<String> getPreloadList() {
        return this.mPreloadList;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public Reporter getReporter() {
        return this.mReporter;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public double getVideoFrameRate() {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            return aliplayer.getVideoFrameRate();
        }
        return 0.0d;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public int getVideoHeight() {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            return aliplayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public int getVideoWidth() {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            return aliplayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public float getVolume() {
        Aliplayer aliplayer;
        if (!isValid() || (aliplayer = this.mAliplayer) == null) {
            return 0.0f;
        }
        return aliplayer.getVolume();
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public boolean isMuted() {
        return this.mIsMute;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public boolean isReuse() {
        return this.mIsReuse;
    }

    protected boolean isValid() {
        IAlixPlayer.State currentState = getCurrentState();
        return (currentState == IAlixPlayer.State.STATE_STOPPED || currentState == IAlixPlayer.State.STATE_IDLE || currentState == IAlixPlayer.State.STATE_RELEASED) ? false : true;
    }

    @Override // com.youku.alixplayer.instances.Aliplayer.OnPlayerEventListener
    public void onNotify(final Identity identity, final int i, final int i2, final int i3, final Object obj) {
        this.playerMsgHandler.post(new Runnable() { // from class: com.youku.alixplayer.AlixPlayer.4
            @Override // java.lang.Runnable
            public void run() {
                AlixPlayer.this.onNotifyInternal(identity, i, i2, i3, obj);
            }
        });
    }

    @Override // com.youku.alixplayer.OnStateChangeListener
    public void onStateChange(IAlixPlayer.State state, IAlixPlayer.State state2) {
        IMediaSource iMediaSource;
        if (this.mAliplayer != null && this.mStringMap.containsKey("tlogSession")) {
            HashMap hashMap = new HashMap();
            hashMap.put("tlogSession", this.mStringMap.get("tlogSession"));
            hashMap.put("tlogPeriod", state2.toString());
            this.mAliplayer.setCommonParams(hashMap);
        }
        if (state == IAlixPlayer.State.STATE_SOURCE_GETTING && state2 == IAlixPlayer.State.STATE_SOURCE_READY) {
            Playlist playlist = this.mStateMachine.getPlaylist();
            this.mPlaylist = playlist;
            if ((playlist == null || playlist.getPeriodList().size() == 0) && (iMediaSource = this.mMediaSource) != null) {
                this.mPlaylist = this.mPreloadPlaylistMap.get(iMediaSource.getSourceKey());
            }
        }
        if (isStarted(state2)) {
            sendBroadcastWhenStarted();
        }
        for (OnStateChangeListener onStateChangeListener : this.mOnStateChangeListeners) {
            onStateChangeListener.onStateChange(state, state2);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void panGuesture(int i, float f, float f2) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.panGuesture(i, f, f2);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void pause() {
        this.mStateMachine.handleEvent(EventType.PAUSE);
        if (getCurrentState() == IAlixPlayer.State.STATE_PRE_AD_PAUSED || getCurrentState() == IAlixPlayer.State.STATE_MID_AD_PAUSED || getCurrentState() == IAlixPlayer.State.STATE_PRE_VIP_PAUSED || getCurrentState() == IAlixPlayer.State.STATE_POST_AD_PAUSED) {
            Log.d(TAG, "AD_PAUSED pause(), remove mAdCountDownRunnable");
            this.mHandler.removeMessages(0);
        }
        if (getCurrentState() == IAlixPlayer.State.STATE_VIDEO_PAUSED) {
            Log.d(TAG, "VIDEO_PAUSED pause(), remove mCurrentPositionUpdateRunnable");
            this.mHandler.removeMessages(1);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void playMidAd(Period period) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer == null || !this.mHasMidAd) {
            return;
        }
        aliplayer.playIsolatePeriod();
        if (this.mMidAdFailed) {
            Log.d(TAG, "mid ad prepare failed, play next mid ad");
            this.mAliplayer.goNext(true);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public synchronized void preloadDataSource(IMediaSource iMediaSource, IPreloadListener iPreloadListener) {
        this.mPreloadList.add(iMediaSource.getSourceKey());
        this.mPreloadSourceMap.put(iMediaSource.getSourceKey(), iMediaSource);
        if (this.mPreloadList.size() > this.mPreloadMaxSize) {
            Log.d(TAG, "mPreloadList is full, remove the first unused item");
            for (String str : this.mPreloadList) {
                PlayerQueue.QueueItem queueItem = this.mPlayerQueue.get(str);
                if (queueItem != null) {
                    Aliplayer mainPlayer = queueItem.getMainPlayer();
                    if (mainPlayer != this.mAliplayer) {
                        mainPlayer.stop();
                        this.mPlayerQueue.removeItem(queueItem);
                    } else {
                        Log.d(TAG, "mAliplayer is using, skip " + str);
                    }
                }
                this.mPreloadSourceMap.get(str).deinit();
                this.mPreloadSourceMap.remove(str);
                this.mPreloadPlaylistMap.remove(str);
                this.mPreloadList.remove(str);
                Log.d(TAG, "mPreloadList remove " + str);
            }
        }
        Log.d(TAG, "preloadDataSource: mediasource.key=" + iMediaSource.getSourceKey());
        final String sourceKey = iMediaSource.getSourceKey();
        this.mPlayerQueue.addItem(PlayerQueue.QueueItem.create(sourceKey));
        final Aliplayer mainPlayer2 = this.mPlayerQueue.get(sourceKey).getMainPlayer();
        IConfigCenter iConfigCenter = this.mConfigCenter;
        if (iConfigCenter != null) {
            mainPlayer2.setConfig(iConfigCenter, this.mLocalConfigCenter);
        }
        mainPlayer2.setReporter(new Reporter());
        PreLoadEvent preLoadEvent = new PreLoadEvent();
        preLoadEvent.key = sourceKey;
        preLoadEvent.preloadListener = iPreloadListener;
        mainPlayer2.setOnPlayerEventListener(preLoadEvent);
        iMediaSource.addMediaSourceUpdatedListener(new IMediaSource.OnMediaSourceUpdatedListener() { // from class: com.youku.alixplayer.AlixPlayer.3
            @Override // com.youku.alixplayer.IMediaSource.OnMediaSourceUpdatedListener
            public void onPeriodUpdate(int i, IPeriod iPeriod) {
            }

            @Override // com.youku.alixplayer.IMediaSource.OnMediaSourceUpdatedListener
            public void onPlaylistFailed() {
            }

            @Override // com.youku.alixplayer.IMediaSource.OnMediaSourceUpdatedListener
            public void onPlaylistPrepared(IMediaSource iMediaSource2, IPlaylist iPlaylist) {
                List<Period> periodList;
                Log.d(AlixPlayer.TAG, "preloadDataSource:onPlaylistPrepared");
                if (iPlaylist != null && (periodList = iPlaylist.getPeriodList()) != null) {
                    for (Period period : periodList) {
                        period.addHeader("isPreloadXPlayer", "1");
                    }
                }
                Playlist playlist = (Playlist) iPlaylist;
                AlixPlayer.this.mPreloadPlaylistMap.put(sourceKey, playlist);
                mainPlayer2.setDataSource(playlist);
                if (AlixPlayer.this.mOnPlayerP2PListener != null) {
                    mainPlayer2.setOnPlayerP2PListener(AlixPlayer.this.mOnPlayerP2PListener);
                }
                mainPlayer2.prepare();
            }

            @Override // com.youku.alixplayer.IMediaSource.OnMediaSourceUpdatedListener
            public void onPlaylistUpdate(IPlaylist iPlaylist) {
            }
        });
        iMediaSource.preparePlaylist();
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void prepareAsync() {
        if (this.mSurface != null) {
            boolean z = Looper.getMainLooper() == Looper.myLooper();
            Log.d(TAG, "prepareAsync-setSurface is in mainthread:" + z);
            this.mAliplayer.setSurface(this.mSurface);
        }
        this.mStateMachine.handleEvent(EventType.PREPARE);
        if (this.mIsMute) {
            Log.d(TAG, "prepare and setAudioMute 1");
            this.mAliplayer.setAudioMute(1);
        } else {
            Log.d(TAG, "prepare and setAudioMute 0");
            this.mAliplayer.setAudioMute(0);
        }
        this.mHandler.sendEmptyMessage(2);
    }

    public void putString(String str, String str2) {
        this.mStringMap.put(str, str2);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public float querySixDofAngle() {
        Aliplayer aliplayer;
        if (!isValid() || (aliplayer = this.mAliplayer) == null) {
            return -1.0f;
        }
        return aliplayer.querySixDofAngle();
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void release() {
        this.mIsLoading = false;
        this.mIsSeeking = false;
        this.mIsMute = false;
        this.mMuteState = null;
        Log.d(TAG, "release()");
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.playerMsgHandler != null) {
            this.playerMsgHandler.removeCallbacksAndMessages(null);
        }
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        PlayerStateMachine playerStateMachine = this.mStateMachine;
        if (playerStateMachine != null) {
            playerStateMachine.handleEvent(EventType.RELEASE);
        }
        this.mPreloadList.clear();
        this.mPreloadPlaylistMap.clear();
        this.mPlayerQueue.clearAllItems();
        Reporter reporter = this.mReporter;
        if (reporter != null) {
            reporter.destruct();
            this.mReporter = null;
        }
        this.mOnInfoListeners.clear();
        this.mPreloadSourceMap.clear();
        this.mOnVideoSizeChangeListeners.clear();
        this.mOnAdEventListeners.clear();
        this.mOnCurrentPositionChangeListeners.clear();
        this.mCurrentPostionChangeListener = null;
        this.mOnQualityChangeListeners.clear();
        this.mOnLoadingChangeListeners.clear();
        this.mOnSeekCompleteListeners.clear();
        this.mOnStateChangeListeners.clear();
        IMediaSource iMediaSource = this.mMediaSource;
        if (iMediaSource != null) {
            iMediaSource.deinit();
            this.mMediaSource = null;
        }
        destruct();
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void removeOnAdEventListener(OnAdEventListener onAdEventListener) {
        this.mOnAdEventListeners.remove(onAdEventListener);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void removeOnInfoListener(OnInfoListener onInfoListener) {
        this.mOnInfoListeners.remove(onInfoListener);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void removeOnPlayerStateListener(OnStateChangeListener onStateChangeListener) {
        this.mOnStateChangeListeners.remove(onStateChangeListener);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void removeOnQualityChangeListener(OnQualityChangeListener onQualityChangeListener) {
        this.mOnQualityChangeListeners.remove(onQualityChangeListener);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void removeOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListeners.remove(onSeekCompleteListener);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void removeOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOnVideoSizeChangeListeners.remove(onVideoSizeChangedListener);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void removeRenderMiddleware(IRenderMiddleware iRenderMiddleware) {
        this.mRenderMiddlewares.remove(iRenderMiddleware);
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.removeRenderMiddleware(iRenderMiddleware);
        }
        if (iRenderMiddleware instanceof Destructable) {
            ((Destructable) iRenderMiddleware).destruct();
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void reset() {
        Log.d(TAG, "reset()");
        this.mIsLoading = false;
        this.mIsSeeking = false;
        this.mIsMute = false;
        this.mMuteState = null;
        this.mRendCutMode = 0;
        this.mRendCutParams = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.playerMsgHandler != null) {
            this.playerMsgHandler.removeCallbacksAndMessages(null);
        }
        PlayerStateMachine playerStateMachine = this.mStateMachine;
        if (playerStateMachine != null) {
            playerStateMachine.handleEvent(EventType.RELEASE);
        }
        this.mPreloadList.clear();
        this.mPreloadPlaylistMap.clear();
        this.mPlayerQueue.clearAllItems();
        Reporter reporter = this.mReporter;
        if (reporter != null) {
            reporter.destruct();
            this.mReporter = null;
        }
        List<OnInfoListener> list = this.mOnInfoListeners;
        if (list != null) {
            list.clear();
        }
        Map<String, IMediaSource> map = this.mPreloadSourceMap;
        if (map != null) {
            map.clear();
        }
        List<OnVideoSizeChangedListener> list2 = this.mOnVideoSizeChangeListeners;
        if (list2 != null) {
            list2.clear();
        }
        List<OnAdEventListener> list3 = this.mOnAdEventListeners;
        if (list3 != null) {
            list3.clear();
        }
        List<OnCurrentPositionChangeListener> list4 = this.mOnCurrentPositionChangeListeners;
        if (list4 != null) {
            list4.clear();
        }
        if (this.mCurrentPostionChangeListener != null) {
            this.mCurrentPostionChangeListener = null;
        }
        List<OnQualityChangeListener> list5 = this.mOnQualityChangeListeners;
        if (list5 != null) {
            list5.clear();
        }
        List<OnLoadingChangeListener> list6 = this.mOnLoadingChangeListeners;
        if (list6 != null) {
            list6.clear();
        }
        List<OnSeekCompleteListener> list7 = this.mOnSeekCompleteListeners;
        if (list7 != null) {
            list7.clear();
        }
        List<OnStateChangeListener> list8 = this.mOnStateChangeListeners;
        if (list8 != null) {
            list8.clear();
        }
        IMediaSource iMediaSource = this.mMediaSource;
        if (iMediaSource != null) {
            iMediaSource.deinit();
            this.mMediaSource = null;
        }
        List<IRenderMiddleware> list9 = this.mRenderMiddlewares;
        if (list9 != null && list9.size() != 0) {
            for (IRenderMiddleware iRenderMiddleware : this.mRenderMiddlewares) {
                removeRenderMiddleware(iRenderMiddleware);
            }
        }
        if (this.mOnPlayerP2PListener != null) {
            this.mOnPlayerP2PListener = null;
        }
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.removeOnP2pToCdnChangeListener();
            this.mAliplayer.destruct();
        }
        Aliplayer.OnPlayerHostUpdateListener onPlayerHostUpdateListener = this.mOnPlayerHostUpdateListener;
        if (onPlayerHostUpdateListener != null) {
            onPlayerHostUpdateListener.destruct();
            this.mOnPlayerHostUpdateListener = null;
        }
        DefaultLocalConfigCenter defaultLocalConfigCenter = this.mLocalConfigCenter;
        if (defaultLocalConfigCenter != null) {
            defaultLocalConfigCenter.setOnLocalConfigCenterListener(null);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public int screenShotMultiFramesBegin(String str, int i, int i2, Period period, int i3, int i4, int i5) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            return aliplayer.screenShotMultiFramesBegin(str, i, i2, period, i3, i4, i5);
        }
        return -1;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public int screenShotMultiFramesEnd(int i, int i2, int i3, int i4, int i5, Map<String, String> map) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            return aliplayer.screenShotMultiFramesEnd(i, i2, i3, i4, i5, map);
        }
        return -1;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public int screenShotOneFrame(AssetManager assetManager, String str, int i, int i2, int i3, String str2, int i4, int i5, int i6, int i7) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            return aliplayer.screenShotOneFrame(assetManager, str, i, i2, i3, str2, i4, i5, i6, i7);
        }
        return -1;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void seekTo(int i, int i2) {
        if (getCurrentState() == IAlixPlayer.State.STATE_VIDEO_STARTED || getCurrentState() == IAlixPlayer.State.STATE_VIDEO_PAUSED) {
            this.mIsSeeking = true;
            this.mAliplayer.seek(i, i2);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setAdjectiveSource(List<String> list, Bundle bundle, List<String> list2, Bundle bundle2) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    @Deprecated
    public void setAudioCallback(Object obj) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.setAudioCallback(obj);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setAudioEnhance(boolean z) {
        this.mAliplayer.setAudioEnhance(z);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setAudioInfo(int i, int i2) {
        Aliplayer aliplayer;
        if (!isValid() || (aliplayer = this.mAliplayer) == null) {
            return;
        }
        aliplayer.setAudioInfo(i, i2);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setBinocularMode(boolean z) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.setBinocularMode(z);
        }
    }

    public void setBitmap(Map<String, String> map, Bitmap bitmap) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.setBitmap(map, bitmap);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setCDNDomain(Map<String, String> map) {
        this.mCDNDomainMap = map;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setColorBlindType(int i, int i2) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.setColorBlindType(i, i2);
        }
    }

    public void setCommonParams(Map<String, String> map) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.setCommonParams(map);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setConfigCenter(IConfigCenter iConfigCenter) {
        Log.d("ConfigCenter", "setConfigCenter..." + iConfigCenter.hashCode());
        setConfigCenterNative(iConfigCenter);
        this.mConfigCenter = iConfigCenter;
        if (this.mAliplayer != null) {
            Log.d("ConfigCenter", "setConfigCenter setConfig..." + iConfigCenter.hashCode());
            this.mAliplayer.setConfig(this.mConfigCenter, this.mLocalConfigCenter);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00dd  */
    @Override // com.youku.alixplayer.IAlixPlayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setDataSource(com.youku.alixplayer.IMediaSource r9) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.alixplayer.AlixPlayer.setDataSource(com.youku.alixplayer.IMediaSource):void");
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setDisplay(Surface surface) {
        this.mSurface = surface;
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer == null || surface == null) {
            return;
        }
        aliplayer.setSurface(surface);
        if (getCurrentState() == IAlixPlayer.State.STATE_STARTING) {
            Log.d(TAG, "setSurface when STATE_STARTING call start()!");
            this.mAliplayer.start();
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setDomainStrategyAfterNetChangedM(Object obj) {
        if (obj != null) {
            Log.d(TAG, "setDomainStrategyAfterNetChangedM");
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setEnhanceMode(boolean z, float f, float f2) {
        if (isVideoPlaying()) {
            this.mAliplayer.setEnhanceMode(z, f, f2);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setExtraParam(Map<Object, Object> map) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.setExtraParams(map);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public int setFilter(int i, Map<String, String> map) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.setFilter(i, map);
            return 0;
        }
        return 0;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setGyroscopeActive(boolean z) {
        this.mAliplayer.setGyroscopeActive(z);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setHolder(AlixPlayerHolderUnbindListener alixPlayerHolderUnbindListener) {
        this.mHolderUnbindListener = alixPlayerHolderUnbindListener;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setInterfaceOrientation(int i) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.setInterfaceOrientation(i);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setIsLoopPlay(boolean z) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.setLooping(z);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setLaifengTSMode(int i) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.setLaifengTSMode(i == 1);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setLiveSEIGettingMode(boolean z) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.setLiveSEIGettingMode(z);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setMidAd(Period period) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.resetIsolatePeriod();
            this.mHasMidAd = true;
            Reporter.addPeriodTypeMapping(period);
            this.mAliplayer.addIsolatePeriod(period);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setMute(boolean z) {
        this.mIsMute = z;
        this.mMuteState = z ? getCurrentState() : null;
        if (this.mAliplayer != null) {
            Log.d(TAG, "setMute mute : " + z + " , mAliplayer : " + this.mAliplayer);
            this.mAliplayer.setAudioMute(z ? 1 : 0);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setNightMode(int i) {
        this.mAliplayer.setNightMode(i);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setOnAlixRtcData(int i, Object obj) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setOnAlixRtcInfo(OnAlixRtcInfoListener onAlixRtcInfoListener) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setOnCurrentPostionChangeListener(OnCurrentPositionChangeListener onCurrentPositionChangeListener) {
        this.mCurrentPostionChangeListener = onCurrentPositionChangeListener;
    }

    public void setOnLocalConfigCenterListener(OnLocalConfigCenterListener onLocalConfigCenterListener) {
        DefaultLocalConfigCenter defaultLocalConfigCenter = this.mLocalConfigCenter;
        if (defaultLocalConfigCenter != null) {
            defaultLocalConfigCenter.setOnLocalConfigCenterListener(onLocalConfigCenterListener);
        }
    }

    public void setOnPlayerHostUpdateListener(Aliplayer.OnPlayerHostUpdateListener onPlayerHostUpdateListener) {
        this.mOnPlayerHostUpdateListener = onPlayerHostUpdateListener;
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.setOnPlayerHostUpdateListener(onPlayerHostUpdateListener);
        }
    }

    public void setOnPlayerP2PListener(Aliplayer.OnPlayerP2PListener onPlayerP2PListener) {
        this.mOnPlayerP2PListener = onPlayerP2PListener;
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.setOnPlayerP2PListener(onPlayerP2PListener);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setOnRtcMessageListener(OnRtcMessageListener onRtcMessageListener) {
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setPickCenter(float f) {
        setPickCenter(f, false);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setPickCenter(float f, boolean z) {
        Aliplayer aliplayer;
        if (!isValid() || (aliplayer = this.mAliplayer) == null) {
            return;
        }
        aliplayer.setPickCenter(f, z);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setPickRotate(float f) {
        setPickRotate(f, false);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setPickRotate(float f, boolean z) {
        Aliplayer aliplayer;
        if (!isValid() || (aliplayer = this.mAliplayer) == null) {
            return;
        }
        aliplayer.setPickRotate(f, z);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setPlaySpeed(double d) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.setPlaySpeed(d);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setPlaybackParam(int i, String str) {
        Log.d("AlixPlayer", "setPlaybackParam type=" + i + ", str=" + str);
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.setPlaybackParam(i, str);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setPlayerId(String str) {
        this.mPlayerId = str;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public int setPreloadMaxSize(int i) {
        this.mPreloadMaxSize = i;
        return i;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setRenderVideo(boolean z) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.setRenderVideo(z);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setReuse(boolean z) {
        this.mIsReuse = z;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setRotationMatrix(int i, float[] fArr) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.setRotationMatrix(i, fArr);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setTcConfigParam(int i) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.setTcConfigParam(i);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setVideoRendCutMode(int i, float f, float f2) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.setVideoRendCutMode(i, f, f2);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setVideoRendCutMode(int i, Map<String, String> map) {
        this.mRendCutMode = Integer.valueOf(i);
        this.mRendCutParams = map;
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.setVideoRendCutMode(i, map);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setVideoRendMove(float f, float f2) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.setVideoRendMove(f, f2);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setVideoSuperResolution(int i) {
        Aliplayer aliplayer;
        if (!isValid() || (aliplayer = this.mAliplayer) == null) {
            return;
        }
        aliplayer.setVideoSuperResolution(i);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public int setVideoVisionIndex(int i) {
        return 0;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setVolume(float f) {
        Aliplayer aliplayer;
        if (!isValid() || (aliplayer = this.mAliplayer) == null) {
            return;
        }
        aliplayer.setVolume(f);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setZoom(int i, double d, double d2, double d3) {
        Aliplayer aliplayer;
        if (!isValid() || (aliplayer = this.mAliplayer) == null) {
            return;
        }
        aliplayer.setZoom(i, d, d2, d3);
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void setZoomPickWind(int i, int i2, float f, float f2, float f3, float f4) {
        Aliplayer aliplayer;
        if (!isValid() || (aliplayer = this.mAliplayer) == null) {
            return;
        }
        aliplayer.setZoomPickWind(i, i2, f, f2, f3, f4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.youku.alixplayer.IAlixPlayer
    public int skipAd(int i) {
        if (this.mAliplayer != null) {
            switch (AnonymousClass6.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[this.mStateMachine.getCurrentState().ordinal()]) {
                case 1:
                    if (this.isPreVidAdComplete) {
                        return 0;
                    }
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    return 0;
            }
            Log.d(TAG, "skipAd");
            this.mAliplayer.goNext();
            return 0;
        }
        return 0;
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void start() {
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

    @Override // com.youku.alixplayer.IAlixPlayer
    public void stop() {
        Log.d(TAG, "stop()>>");
        if (getCurrentState() == IAlixPlayer.State.STATE_STOPPED || getCurrentState() == IAlixPlayer.State.STATE_RELEASED) {
            Log.d(TAG, "stop in wrong state!");
        } else {
            this.mCDNDomainMap = null;
            this.mIsLoading = false;
            this.mIsSeeking = false;
            this.mHasMidAd = false;
            this.mMidAdFailed = false;
            this.mIsMute = false;
            this.mMuteState = null;
            if (this.mHandler != null) {
                this.mHandler.removeCallbacksAndMessages(null);
            }
            PlayerStateMachine playerStateMachine = this.mStateMachine;
            if (playerStateMachine != null) {
                playerStateMachine.handleEvent(EventType.STOP);
            }
            IMediaSource iMediaSource = this.mMediaSource;
            if (iMediaSource != null) {
                Object sourceKey = iMediaSource.getSourceKey();
                PlayerQueue playerQueue = this.mPlayerQueue;
                if (sourceKey == null) {
                    sourceKey = this.mMediaSource;
                }
                PlayerQueue.QueueItem queueItem = playerQueue.get(sourceKey);
                if (queueItem != null) {
                    this.mPlayerQueue.removeItem(queueItem);
                }
                this.mMediaSource.deinit();
                this.mMediaSource = null;
            }
            Aliplayer aliplayer = this.mAliplayer;
            if (aliplayer != null) {
                aliplayer.setOnPlayerEventListener(null);
            }
        }
        Log.d(TAG, "stop()<<");
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void stopMidAd(Period period) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.stopIsolatePeriod();
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public synchronized void switchLiveDataSource(IMediaSource iMediaSource) {
        Log.d(TAG, "switchLiveDataSource");
        String sourceKey = iMediaSource.getSourceKey();
        if (this.mPlayerQueue.get(iMediaSource.getSourceKey()) == null) {
            this.mPlayerQueue.addItem(PlayerQueue.QueueItem.create(sourceKey));
        }
        final Aliplayer mainPlayer = this.mPlayerQueue.get(sourceKey).getMainPlayer();
        IConfigCenter iConfigCenter = this.mConfigCenter;
        if (iConfigCenter != null) {
            mainPlayer.setConfig(iConfigCenter, this.mLocalConfigCenter);
        }
        mainPlayer.setReporter(new Reporter());
        final LivePreloadEvent livePreloadEvent = new LivePreloadEvent();
        livePreloadEvent.aliplayer = mainPlayer;
        livePreloadEvent.mediaSource = iMediaSource;
        mainPlayer.setOnPlayerEventListener(livePreloadEvent);
        iMediaSource.addMediaSourceUpdatedListener(new IMediaSource.OnMediaSourceUpdatedListener() { // from class: com.youku.alixplayer.AlixPlayer.2
            @Override // com.youku.alixplayer.IMediaSource.OnMediaSourceUpdatedListener
            public void onPeriodUpdate(int i, IPeriod iPeriod) {
            }

            @Override // com.youku.alixplayer.IMediaSource.OnMediaSourceUpdatedListener
            public void onPlaylistFailed() {
            }

            @Override // com.youku.alixplayer.IMediaSource.OnMediaSourceUpdatedListener
            public void onPlaylistPrepared(IMediaSource iMediaSource2, IPlaylist iPlaylist) {
                Log.d(AlixPlayer.TAG, "switchLiveDataSource:onPlaylistPrepared");
                Playlist playlist = (Playlist) iPlaylist;
                livePreloadEvent.playlist = playlist;
                mainPlayer.setDataSource(playlist);
                mainPlayer.prepare();
            }

            @Override // com.youku.alixplayer.IMediaSource.OnMediaSourceUpdatedListener
            public void onPlaylistUpdate(IPlaylist iPlaylist) {
            }
        });
        iMediaSource.preparePlaylist();
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void switchPlayerMode(int i, int i2) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.switchPlayerMode(i, i2);
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public void switchSubtitle(boolean z) {
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.setPlaybackParam(14, z ? "1" : "0");
        }
    }

    @Override // com.youku.alixplayer.IAlixPlayer
    public int switchSubtitleUrl(String str) {
        Log.d(TAG, "switchSubtitleUrl: " + str);
        return 0;
    }
}
