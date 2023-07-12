package com.youku.uplayer;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.youku.e.C7901a;
import com.youku.player.util.C8063c;
import com.youku.player.util.C8064d;
import com.youku.player.util.C8068f;
import com.youku.player.util.C8070g;
import com.youku.player.util.TLogUtilNative;
import com.youku.uplayer.bridging.SystemDelegate;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class AliMediaPlayer extends OriginalMediaPlayer {
    public static final String ALIPLAYER = "aliplayer";
    public static final int COPY_RIGHT_KEY_CLIENT = 11;
    private static long D_Native_MainThread_PreAd_StartTime = 0;
    private static long D_Native_MainThread_RealVideo_StartTime = 0;
    private static final int INTERNAL_START_LOADING = 66666;
    private static final int LOADING_START_DEFAULT_DELAY = 100;
    public static final int MEDIAPLAYER_NATIVE_SETPROPERTY_CLEAR_TIMEOUT = 9;
    public static final int MEDIA_PLAYMODE_U_Plus = 1;
    public static final int MEDIA_PLAYMODE_VR = 101;
    public static final int MINIMUM_BUFFER_TIME = 22;
    public static final int MSG_PARAMS_MIN_SET = 1901;
    public static final int OPEN_RENDER_VV_BEGIN = 187;
    private static final int SEEK_LOADING_DEFAULT_DELAY = 300;
    private static final String TAG = "AliMediaPlayer";
    public static final int TYPE_BITRATE_RATE = 32;
    public static final int TYPE_BUFFERTIME_BEFORE_PLAY = 20;
    public static final int TYPE_BUFFERTIME_MAX_DURATION = 27;
    public static final int TYPE_BUFFERTIME__PLAYING = 21;
    public static final int TYPE_ENABLE_CPUMONITOR = 37;
    public static final int TYPE_KS_DEFAULTIP = 38;
    public static final int TYPE_LIMITSPEED_LIVE = 28;
    public static final int TYPE_MEMFREE_RATE = 33;
    public static final int TYPE_MULTI_CDN_ENABLE = 30;
    public static final int TYPE_MULTI_TASK = 31;
    public static final int TYPE_NETCACHE_SIZE = 10;
    public static final int TYPE_NETWORKSPEED_SAMPLE_INTERVAL = 47;
    public static final int TYPE_POSITION_FRESH_FREQUENCY = 6;
    public static final int TYPE_RTMPE_NETCACHE = 34;
    public static final int TYPE_SIMPLE_DOWNLOAD_HTTP = 35;
    public static final int TYPE_SIMPLE_DOWNLOAD_RTMPE = 36;
    public static final int TYPE_SUBTITLE_DEFAULT_FONT = 17;
    public static final int TYPE_SUBTITLE_FONT_PATH = 16;
    public static final int TYPE_SUBTITLE_LIB_PATH = 190;
    public static final int TYPE_SUBTITLE_NATIVE_RENDER = 15;
    public static final int TYPE_SUBTITLE_PATH = 12;
    public static final int TYPE_SUBTITLE_PATH2 = 13;
    public static final int TYPE_SUBTITLE_STYLE = 18;
    public static final int TYPE_SUBTITLE_SWITCH = 14;
    public static final int TYPE_SUBTITLE_SWITCH_SOURCE = 19;
    public static final int TYPE_TIMEOUT_CDN = 2;
    public static final int TYPE_TIMEOUT_CDN_READ = 3;
    public static final int TYPE_TIMEOUT_KEY = 1;
    public static final int TYPE_TIMEOUT_RTMPE_CDN = 4;
    public static final int TYPE_TIMEOUT_RTMPE_CDN_READ = 5;
    public static final int TYPE_TWO_SUBTITLE_STYLE = 29;
    public static final int TYPE_ZHANGBEI_K_IP = 38;
    public static final String UPLAYER24 = "uplayer24";
    public static final String UPLAYER_EXTRA_VID = "vid";
    public static final int UPLAYER_KEY_SLICE_DURATION = 204;
    public static final int UPLAYER_PROPERTY_DRM_LICENSE_URI = 188;
    public static final int UPLAYER_PROPERTY_DRM_TYPE = 189;
    public static final int UPLAYER_PROPERTY_ENABLE_OPEN_RENDER = 131;
    public static final int UPLAYER_PROPERTY_MAX_SIZE_ADD_DATASOURCE = 71;
    public static final int UPLAYER_PROPERTY_START_TS_PARAM = 202;
    public static final int UPLAYER_PROPERTY_START_TS_URL = 201;
    public static final int UPLAYER_PROPERTY_SUM_PLAYER_INSTANCE = 70;
    public static final int UPLAYER_PROPERTY_TYPE_ABR_NETWORK_STATUS = 982;
    public static final int UPLAYER_PROPERTY_TYPE_ABR_RES_4G = 921;
    public static final int UPLAYER_PROPERTY_TYPE_ADAPTIVE_SPEED_BITRATE_CHANGE_FACTOR = 59;
    public static final int UPLAYER_PROPERTY_TYPE_ADAPTIVE_SPEED_BITRATE_FACTOR = 58;
    public static final int UPLAYER_PROPERTY_TYPE_ADAPTIVE_SPEED_BUFFER_FACTOR = 60;
    public static final int UPLAYER_PROPERTY_TYPE_ADAPTIVE_SPEED_CONTROL_BUFFERSIZE = 55;
    public static final int UPLAYER_PROPERTY_TYPE_ADAPTIVE_SPEED_CONTROL_ENABLE = 54;
    public static final int UPLAYER_PROPERTY_TYPE_ADAPTIVE_SPEED_CONTROL_FREQUENCY = 57;
    public static final int UPLAYER_PROPERTY_TYPE_ADAPTIVE_SPEED_CONTROL_HUNGRYGAP = 64;
    public static final int UPLAYER_PROPERTY_TYPE_ADAPTIVE_SPEED_CONTROL_HUNGRYGAP_FACTOR = 65;
    public static final int UPLAYER_PROPERTY_TYPE_ADAPTIVE_SPEED_CONTROL_PAUSEDOWNLOAD_FACTOR = 66;
    public static final int UPLAYER_PROPERTY_TYPE_ADAPTIVE_SPEED_CONTROL_WINDOWSIZE = 56;
    public static final int UPLAYER_PROPERTY_TYPE_ADAPTIVE_SPEED_INCRATE = 134;
    public static final int UPLAYER_PROPERTY_TYPE_ADAPTIVE_SPEED_INIT_SPEED = 61;
    public static final int UPLAYER_PROPERTY_TYPE_ADAPTIVE_SPEED_LAUNCHTIME = 137;
    public static final int UPLAYER_PROPERTY_TYPE_ADAPTIVE_SPEED_MAXBUFFER = 133;
    public static final int UPLAYER_PROPERTY_TYPE_ADAPTIVE_SPEED_MINBUFFER = 132;
    public static final int UPLAYER_PROPERTY_TYPE_ADPATIVE_ALIX_SAMPLED = 63;
    public static final int UPLAYER_PROPERTY_TYPE_ADPATIVE_UT_SAMPLED = 62;
    public static final int UPLAYER_PROPERTY_TYPE_AD_NETCACHE_ENABLE = 42;
    public static final int UPLAYER_PROPERTY_TYPE_AUTO_SWITCH_DATASOURCE = 90;
    public static final int UPLAYER_PROPERTY_TYPE_BUFFER_CHANGE_IP_DURATION_MS = 140;
    public static final int UPLAYER_PROPERTY_TYPE_BUFFER_CHANGE_IP_DURATION_THRESHOLD_MS = 141;
    public static final int UPLAYER_PROPERTY_TYPE_BUFFER_SPEED_TO_BITRATE_RATIO = 142;
    public static final int UPLAYER_PROPERTY_TYPE_DISABLE_LIMITSPEED_P2P = 143;
    public static final int UPLAYER_PROPERTY_TYPE_DISABLE_P2P_PLAYBEGIN = 72;
    public static final int UPLAYER_PROPERTY_TYPE_DOLBY_DAP_ONOFF = 80;
    public static final int UPLAYER_PROPERTY_TYPE_DOLBY_DIALOG_ENHANCEMENT = 82;
    public static final int UPLAYER_PROPERTY_TYPE_DOLBY_ENDPOINT = 81;
    public static final int UPLAYER_PROPERTY_TYPE_ENABLE_ACCURATE_SEEK = 52;
    public static final int UPLAYER_PROPERTY_TYPE_ENABLE_ACCURATE_SEEK_DURATION = 53;
    public static final int UPLAYER_PROPERTY_TYPE_ENABLE_BUMBLEBEE_DOWNLOADER = 121;
    public static final int UPLAYER_PROPERTY_TYPE_ENABLE_CALC_SEEK_BUFFER = 150;
    public static final int UPLAYER_PROPERTY_TYPE_ENABLE_DECODER_HW_RETRY_SOFT = 180;
    public static final int UPLAYER_PROPERTY_TYPE_ENABLE_GET_SEI_INFO = 92;
    public static final int UPLAYER_PROPERTY_TYPE_ENABLE_KEEP_ALIVE = 118;
    public static final int UPLAYER_PROPERTY_TYPE_ENABLE_M3U8_NETCACHE = 100;
    public static final int UPLAYER_PROPERTY_TYPE_ENABLE_SEEKCACHE = 50;
    public static final int UPLAYER_PROPERTY_TYPE_ENABLE_START_INDEX_CONTROL = 103;
    public static final int UPLAYER_PROPERTY_TYPE_ENABLE_UPLOAD_M3U8_PARAM_NORMAL = 119;
    public static final int UPLAYER_PROPERTY_TYPE_FASTMODE_EXTSIZE = 123;
    public static final int UPLAYER_PROPERTY_TYPE_FEEDSMODE = 48;
    public static final int UPLAYER_PROPERTY_TYPE_GET_SEI_INTERVAL_MS = 93;
    public static final int UPLAYER_PROPERTY_TYPE_HLS_BUFFER_TIME = 102;
    public static final int UPLAYER_PROPERTY_TYPE_IS_AudioMode = 184;
    public static final int UPLAYER_PROPERTY_TYPE_IS_INTERACTIVE_VIDEO = 107;
    public static final int UPLAYER_PROPERTY_TYPE_IS_LOCAL_SOURCE = 182;
    public static final int UPLAYER_PROPERTY_TYPE_IS_VIP = 185;
    public static final int UPLAYER_PROPERTY_TYPE_IS_WIFI = 183;
    public static final int UPLAYER_PROPERTY_TYPE_JITTER_MONITOR_DURATION_THRESHOLD = 178;
    public static final int UPLAYER_PROPERTY_TYPE_JITTER_MONITOR_LOWSPEED_THRESHOLD = 179;
    public static final int UPLAYER_PROPERTY_TYPE_LIVE_DELAY_MAX_VALUE = 25;
    public static final int UPLAYER_PROPERTY_TYPE_LIVE_NETCACHE_HLS = 40;
    public static final int UPLAYER_PROPERTY_TYPE_LIVE_NETCACHE_RTMP = 41;
    public static final int UPLAYER_PROPERTY_TYPE_LIVE_PLAY_LOW_SPEED_TYPE = 124;
    public static final int UPLAYER_PROPERTY_TYPE_MINIMUM_BUFFER_TIME = 23;
    public static final int UPLAYER_PROPERTY_TYPE_NETWORK_STATUS = 920;
    public static final int UPLAYER_PROPERTY_TYPE_NET_TYPE = 203;
    public static final int UPLAYER_PROPERTY_TYPE_PARSE_CONTENT_LENGTH = 104;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_ADAPT_SPEED_MAX_SAFE_BUFFER_FACTOR = 159;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_ADAPT_SPEED_MIN_SAFE_BUFFER_DIFF = 160;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_BUFFER_BASE_ADAPT_HIGH_GEAR_INDEX = 169;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_BUFFER_BASE_ADAPT_LOW_GEAR_INDEX = 167;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_BUFFER_BASE_ADAPT_METHOD = 166;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_BUFFER_BASE_ADAPT_SAFE_GEAR_INDEX = 168;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_DISALBE_ADAPT_SPEED = 158;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_DOWNLOAD_TIMEOUT_FACTOR = 181;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_FIXED_GEAR_INDEX = 153;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_HD2_LOADING_FACTOR_STEP = 176;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_HD2_UP_GEAR_NEED_BUFFER = 156;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_HD3_LOADING_FACTOR_STEP = 177;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_HD3_UP_GEAR_NEED_BUFFER = 157;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_HD_LOADING_FACTOR_STEP = 175;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_HD_UPGEAR_NEED_BUFFER = 155;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_MAX_DOWN_GEAR_FACTOR = 113;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_MAX_GEAR_KEEP = 144;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_MAX_MIN_SAFE_BUFFER_DIFF = 162;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_MAX_SAFE_BUFFER = 136;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_MAX_UP_GEAR_FACTOR = 111;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_MIN_DOWN_GEAR_FACTOR = 112;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_MIN_SAFE_BUFFER = 135;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_MIN_SAFE_BUFFER_LOW_VALUE = 161;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_MIN_UP_GEAR_FACTOR = 110;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_DOWNLOAD_SPEED_CALC_COUNT = 171;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT = 170;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_PREDICT_DEVIATION = 117;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_QOE_FACTOR1 = 114;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_QOE_FACTOR2 = 115;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_QOE_FACTOR3 = 116;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_SD_LOADING_FACTOR_STEP = 174;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_SD_UP_GEAR_NEED_BUFFER = 154;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_SEEK_GEAR_INDEX = 173;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_SEGMENT_SPEED_CALC_COUNT = 163;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_SPEED_LIGHT_SHAKE_VARIANCE_VALUE = 164;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_SPEED_SERIOUS_SHAKE_VARIANCE_VALUE = 165;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_START_PLAY_GEAR_INDEX = 172;
    public static final int UPLAYER_PROPERTY_TYPE_PATTAYA_USING_FIXED_GEAR = 152;
    public static final int UPLAYER_PROPERTY_TYPE_SEEKBUFFERDONE_CHECKINTERVAL = 49;
    public static final int UPLAYER_PROPERTY_TYPE_SEEK_BUFFER_TIME = 26;
    public static final int UPLAYER_PROPERTY_TYPE_SEEK_BUFFER_TIME_MS = 130;
    public static final int UPLAYER_PROPERTY_TYPE_SEEK_MODE = 108;
    public static final int UPLAYER_PROPERTY_TYPE_SET_LIVE_MULTIVIEW_URL = 686;
    public static final int UPLAYER_PROPERTY_TYPE_SET_MINSET_POSITION = 552;
    public static final int UPLAYER_PROPERTY_TYPE_SET_REAL_DRMKEY = 551;
    public static final int UPLAYER_PROPERTY_TYPE_SET_REAL_URL = 510;
    public static final int UPLAYER_PROPERTY_TYPE_SOURCE_ADAPTIVE_MODE = 109;
    public static final int UPLAYER_PROPERTY_TYPE_SOURCE_SELECT_TYPE = 120;
    public static final int UPLAYER_PROPERTY_TYPE_SPEEDMAX_NETCACHE_PLAY = 43;
    public static final int UPLAYER_PROPERTY_TYPE_SPEEDMAX_NETCACHE_PRELOAD = 44;
    public static final int UPLAYER_PROPERTY_TYPE_SPEEDMIN_NETCACHE_PLAY = 45;
    public static final int UPLAYER_PROPERTY_TYPE_SPEEDMIN_NETCACHE_PRELOAD = 46;
    public static final int UPLAYER_PROPERTY_TYPE_SPEED_CONTROL_TIME = 122;
    public static final int UPLAYER_PROPERTY_TYPE_SPEED_RATIO_TO_ADJUST_HIGH = 24;
    public static final int UPLAYER_PROPERTY_TYPE_UPSCOST = 963;
    public static final int UPLAYER_PROPERYT_TYPE_ENABLE_REPORT_BUFFERSET = 91;
    public static final int UPLAYER_UPS_START_GEAR = 186;
    public static final int VIDEO_VR_180_3D_LEFT_RIGHT = 5;
    public static final int VIDEO_VR_180_3D_TOP_DOWN = 4;
    public static final int VIDEO_VR_360_2D = 1;
    public static final int VIDEO_VR_360_3D_LEFT_RIGHT = 3;
    public static final int VIDEO_VR_360_3D_TOP_DOWN = 2;
    public static final int VIDEO_VR_NULL = 0;
    public static String path;
    public static String path_pre;
    private MediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener;
    private MediaPlayer.OnCompletionListener mCompletionListener;
    private MediaPlayer.OnErrorListener mErrorListener;
    private EventHandler mEventHandler;
    private OnInfoListener mInfoListener;
    private OnADCountListener mOnADCountListener;
    private OnADPlayListener mOnADPlayListener;
    private OnCombineVideoListener mOnCombineVideoListener;
    private OnConnectDelayListener mOnConnectDelayListener;
    private OnCoreMsgListener mOnCoreMsgListener;
    private OnCpuUsageListener mOnCpuUsageListener;
    private OnCurrentPositionUpdateListener mOnCurrentPositionUpdateListener;
    private OnDropVideoFramesListener mOnDropVideoFramesListener;
    private OnErrorListener mOnErrorListener;
    private OnFirstFrameListener mOnFirstFrameListener;
    private OnHttp302DelayListener mOnHttp302DelayListener;
    private OnHwDecodeErrorListener mOnHwDecodeErrorListener;
    private OnIsInitialListener mOnIsInitialListener;
    private OnLoadingStatusListener mOnLodingStatusListener;
    private OnLoadingStatusListenerNoTrack mOnLodingStatusListenerNoTrack;
    private OnMidADPlayListener mOnMidADPlayListener;
    private OnNativeShotDownListener mOnNativeShotDownListener;
    private OnNetworkErrorListener mOnNetworkErrorListener;
    private OnNetworkSpeedListener mOnNetworkSpeedListener;
    private OnPlayerHostListener mOnPlayerHostListener;
    private OnPlayerP2PListener mOnPlayerP2PListener;
    private OnPostADPlayListener mOnPostADPlayListener;
    private OnPreLoadPlayListener mOnPreLoadPlayListener;
    private OnQualityChangeListener mOnQualityChangeListener;
    private OnRealVideoCompletionListener mOnRealVideoCompletionListener;
    private OnRealVideoStartListener mOnRealVideoStartListener;
    private OnScreenShotFinishListener mOnScreenShotFinishListener;
    private OnSliceUpdateListener mOnSliceUpdateListener;
    private OnTimeoutListener mOnTimeoutListener;
    private OnVideoCurrentIndexUpdateListener mOnVideoCurrentIndexUpdateListener;
    private OnVideoIndexUpdateListener mOnVideoIndexUpdateListener;
    private MediaPlayer.OnPreparedListener mPreparedListener;
    private MediaPlayer.OnSeekCompleteListener mSeekCompleteListener;
    private MediaPlayer.OnVideoSizeChangedListener mVideoSizeChangedListener;
    private boolean useHardwareDecode;
    private boolean inSeek = false;
    private boolean showLoading = false;
    private ConcurrentHashMap<String, String> mExtraInfos = new ConcurrentHashMap<>();
    private long mNativeContext = 0;
    private Surface mSurface = null;
    private Surface mTextureSurface = null;
    private SurfaceHolder mSurfaceHolder = null;
    private boolean mScreenOnWhilePlaying = false;
    private boolean mStayAwake = false;
    private PowerManager.WakeLock mWakeLock = null;
    private boolean mPreparedFlag = false;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private interface ConfigGetter {
        String get(String str, String str2, String str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class EventHandler extends Handler {
        AliMediaPlayer mp;

        public EventHandler(AliMediaPlayer aliMediaPlayer, Looper looper) {
            super(looper);
            this.mp = null;
            this.mp = aliMediaPlayer;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
            	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:817)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
            	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
            */
        @Override // android.os.Handler
        public void handleMessage(android.os.Message r17) {
            /*
                Method dump skipped, instructions count: 2858
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.youku.uplayer.AliMediaPlayer.EventHandler.handleMessage(android.os.Message):void");
        }
    }

    /* compiled from: Taobao */
    @Deprecated
    /* loaded from: classes3.dex */
    public static class MsgID extends com.youku.uplayer.MsgID {
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class PlayerInfoKey {
        public static final int PLAYER_INFO_KEY_EXTERNAL_BUFFER_USED_SIZE = 5;
        public static final int PLAYER_INFO_KEY_TOTAL_CONSUMED_SIZE = 1;
        public static final int PLAYER_INFO_KEY_TOTAL_DOWNLOAD_SIZE = 0;
        public static final int UPLAYER_INFO_KEY_BUFFER_ADAPT_INFO = 6;
        public static final int UPLAYER_INFO_KEY_CLASSIFIED_DOWNLOAD_SIZE = 7;
        public static final int UPLAYER_INFO_KEY_GET_PLAYER_MONITOR_INFO = 8;
        public static final int UPLAYER_INFO_KEY_HLS_ABR_GEAR_INFO = 9;
        public static final int UPLAYER_INFO_KEY_HLS_ABR_SWITHC_INFO = 4;
        public static final int UPLAYER_INFO_KEY_HLS_PLAY_INFO = 2;
        public static final int UPLAYER_INFO_KEY_HLS_PLAY_INFO_VVBEGIN = 3;
        public static final int UPLAYER_INFO_KEY_LIVE_ABR_GROUP = 14;
        public static final int UPLAYER_INFO_KEY_NETM3S_DOWNLOAD_INFO = 10;
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private interface ReconfigHandler {
        String reconfig(ConfigGetter configGetter, String str, String str2);
    }

    static {
        initPlayerNative();
    }

    public AliMediaPlayer() {
        this.mEventHandler = null;
        C8063c.a(TAG, "AliMediaPlayer is created");
        Looper mainLooper = Looper.getMainLooper();
        this.mEventHandler = mainLooper != null ? new EventHandler(this, mainLooper) : null;
        try {
            native_setup(new WeakReference(this));
        } catch (Exception unused) {
            C8068f.a().a(TAG, "native_setup recall initPlayerNative!");
            initPlayerNative();
            native_setup(new WeakReference(this));
        }
        SystemDelegate.init(C7901a.a);
        sendBroadCast();
    }

    private native void _pause();

    private native void _release();

    private native void _reset();

    private native void _setVideoSurface(Surface surface);

    private native void _setVideoSurface2(Surface surface, boolean z);

    private native void _start();

    private native void _stop();

    public static native int addPreloadSource(String str, String str2);

    public static native int closeAllPreloadSource();

    public static native int closePreloadSource(String str);

    public static native String getAbility(int i);

    /* JADX WARN: Code restructure failed: missing block: B:50:0x012b, code lost:
        if (r2 == false) goto L8;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.String] */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String getConfigFromJava(java.lang.String r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.uplayer.AliMediaPlayer.getConfigFromJava(java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x015a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Object getConfigsByNS(java.lang.String r25) {
        /*
            Method dump skipped, instructions count: 457
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.uplayer.AliMediaPlayer.getConfigsByNS(java.lang.String):java.lang.Object");
    }

    public static native int getCpuCount();

    public static native int getFFmpegVersionCode();

    public static native String getFFmpegVersionName();

    public static native synchronized int getFileDuration(String str);

    public static native String getGlobalInfoByKey(int i);

    public static String getHostForSingleSlice(Object obj, String str, String str2) {
        String str3 = TAG;
        C8063c.a(str3, "get host for single slice called with:" + str);
        AliMediaPlayer aliMediaPlayer = (AliMediaPlayer) ((WeakReference) obj).get();
        if (aliMediaPlayer == null || aliMediaPlayer.mOnPlayerHostListener == null) {
            return null;
        }
        return aliMediaPlayer.mOnPlayerHostListener.getHost(str, parse(str2));
    }

    public static int getSDKVersionNumber() {
        try {
            return Integer.valueOf(Build.VERSION.SDK).intValue();
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static native int getUplayerVersionCode();

    public static native String getUplayerVersionName();

    private static void initPlayerNative() {
        String str;
        String str2;
        long j = 0;
        try {
            if (!"mounted".equals(Environment.getExternalStorageState()) || C7901a.a.getExternalCacheDir() == null) {
                str = TAG;
                str2 = "not mounted";
            } else {
                j = (long) (((C8070g.a() * 0.02d) / 1024.0d) / 1024.0d);
                str = TAG;
                str2 = "size:" + j;
            }
            C8063c.a(str, str2);
        } catch (Exception e) {
            C8063c.a(TAG, "initPlayer().Exception");
            e.printStackTrace();
        }
        long j2 = j;
        if (path == null) {
            path = NetCacheSource.getInitPath();
        }
        if (path_pre == null) {
            path_pre = NetCacheSource.getPath();
        }
        try {
            native_init(path, j2, path_pre, 50L);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDownloading(Object obj) {
        try {
            return ((String) obj).split("=")[1].equals("1");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isNeedUseP2P(Object obj) {
        OnPlayerP2PListener onPlayerP2PListener;
        AliMediaPlayer aliMediaPlayer = (AliMediaPlayer) ((WeakReference) obj).get();
        if (aliMediaPlayer == null || (onPlayerP2PListener = aliMediaPlayer.mOnPlayerP2PListener) == null) {
            return false;
        }
        return onPlayerP2PListener.isUseP2P();
    }

    private final native void native_finalize();

    private static final native void native_init(String str, long j, String str2, long j2);

    private static final native void native_set_egl_path(String str);

    private final native void native_setup(Object obj);

    private native int native_suspend_resume(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public void onInfo(Message message, long j) {
        if (this.mOnCoreMsgListener != null) {
            Message message2 = new Message();
            message2.copyFrom(message);
            this.mOnCoreMsgListener.onMsg(message2, j);
        }
        OnInfoListener onInfoListener = this.mInfoListener;
        if (onInfoListener != null) {
            onInfoListener.onInfo(message.what, message.arg1, message.arg2, message.obj, j);
        }
    }

    private static Map<String, String> parse(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(";")) {
                String[] split = str2.split("=", 2);
                if (split.length == 2) {
                    hashMap.put(split[0], split[1]);
                }
            }
        }
        return hashMap;
    }

    private static void postEventFromNative(Object obj, int i, int i2, int i3, Object obj2) {
        EventHandler eventHandler;
        int i4;
        AliMediaPlayer aliMediaPlayer = (AliMediaPlayer) ((WeakReference) obj).get();
        if (aliMediaPlayer == null || (eventHandler = aliMediaPlayer.mEventHandler) == null) {
            return;
        }
        Message obtainMessage = eventHandler.obtainMessage(i, i2, i3, obj2);
        int i5 = obtainMessage.what;
        if (i5 == 309) {
            String obj3 = obj2.toString();
            C8063c.a(TAG, obj3);
            TLogUtilNative.aliplayerLog(obj3);
        } else if (i5 == 1011) {
            TLogUtilNative.loge("YKPlayer.PlayFlow.Track", "MEDIA_INFO_PRE_AD_START  Native");
            C8063c.a(TAG, "MEDIA_INFO_PRE_AD_START is received");
            obtainMessage.what = 1011;
            obtainMessage.arg1 = i2;
            obtainMessage.arg2 = i3;
            D_Native_MainThread_PreAd_StartTime = System.currentTimeMillis();
        } else if (i5 == 1017) {
            TLogUtilNative.loge("YKPlayer.PlayFlow.Track", "MEDIA_INFO_VIDEO_START  From Native");
            obtainMessage.what = 1017;
            D_Native_MainThread_RealVideo_StartTime = System.currentTimeMillis();
            OnFirstFrameListener onFirstFrameListener = aliMediaPlayer.mOnFirstFrameListener;
            if (onFirstFrameListener != null) {
                onFirstFrameListener.onFirstFrame();
            }
        } else if (i5 == 1000) {
            C8063c.a(TAG, "MEDIA_INFO_PREPARED is received");
            obtainMessage.what = 1;
        } else if (i5 != 1001) {
            if (i5 == 1030) {
                String str = TAG;
                C8063c.a(str, "MEDIA_INFO_SET_VIDEO_SIZE is received width:" + i2 + " height:" + i3);
                i4 = 5;
            } else if (i5 == 1031) {
                C8063c.a(TAG, "MEDIA_INFO_BUFFERING_UPDATE is received");
                i4 = 3;
            }
            obtainMessage.what = i4;
            obtainMessage.arg1 = i2;
            obtainMessage.arg2 = i3;
        } else {
            C8063c.a(TAG, "MEDIA_INFO_COMPLETED is received");
            obtainMessage.what = 2;
        }
        int i6 = obtainMessage.what;
        if (i6 == 1 || i6 == 1011 || i6 == 1017) {
            aliMediaPlayer.mEventHandler.sendMessageAtFrontOfQueue(obtainMessage);
        } else if (i6 == 1003) {
            int i7 = 100;
            try {
                i7 = Integer.parseInt(C8064d.a().a("youku_player_config", "loading_start_delay", String.valueOf(100)));
            } catch (Exception e) {
                e.printStackTrace();
            }
            aliMediaPlayer.mEventHandler.sendMessageDelayed(obtainMessage, i7);
        } else {
            if (i6 == 1004) {
                aliMediaPlayer.mEventHandler.removeMessages(1003);
            } else if (i6 == 309) {
                return;
            }
            aliMediaPlayer.mEventHandler.sendMessage(obtainMessage);
        }
    }

    public static native int preloadDataSource(String str, int i);

    private static void preloadSourceCallback(int i, int i2, int i3, Object obj) {
        if (C8063c.d) {
            String str = TAG;
            C8063c.b(str, "preloadSourceCallback() called with: what = [" + i + "], arg1 = [" + i2 + "], arg2 = [" + i3 + "], obj = [" + obj + jn1.ARRAY_END_STR);
        }
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.arg1 = i2;
        obtain.arg2 = i3;
        obtain.obj = obj;
        StaticEventHandler.getInstance().sendMessage(2, obtain);
    }

    public static native void registerAVcodec();

    private native void setTextureView(Surface surface);

    public static native void set_property(int i, String str);

    private void stayAwake(boolean z) {
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (z && !wakeLock.isHeld()) {
                this.mWakeLock.acquire();
            } else if (!z && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        }
        this.mStayAwake = z;
        updateSurfaceScreenOn();
    }

    private void updateSurfaceScreenOn() {
        this.mEventHandler.post(new Runnable() { // from class: com.youku.uplayer.AliMediaPlayer.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AliMediaPlayer.this.mSurfaceHolder != null) {
                        TLogUtilNative.loge("YKPlayer.PlayFlow.Track", "setKeepScreenOn  mScreenOnWhilePlaying=" + AliMediaPlayer.this.mScreenOnWhilePlaying + " mStayAwake=" + AliMediaPlayer.this.mStayAwake);
                        AliMediaPlayer.this.mSurfaceHolder.setKeepScreenOn(AliMediaPlayer.this.mScreenOnWhilePlaying && AliMediaPlayer.this.mStayAwake);
                    }
                } catch (Exception e) {
                    C8063c.a(AliMediaPlayer.TAG, e);
                }
            }
        });
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native int GetDownloadSpeed(int[] iArr);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void addDataSource(String str, Object obj);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void addPostADUrl(String str, double d, int i, boolean z);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void audioMute(int i);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void changeVideoSize(int i, int i2);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native int checkSource(String str);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void closePreloadDataSource(int i);

    protected void finalize() {
        native_finalize();
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native int generateCacheFile(String str, String str2);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native double getAvgKeyFrameSize();

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native double getAvgVideoBitrate();

    public native String getConfigParameter(String str);

    @Override // com.youku.uplayer.Mediaplayer
    public int getCurrentPosition() {
        return getCurrentPosition(0);
    }

    public native int getCurrentPosition(int i);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native int getCurrentRenderType();

    @Override // com.youku.uplayer.Mediaplayer
    public native int getDuration();

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native String getPlayerInfoByKey(int i);

    public native int getSoVersion();

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native int getVideoCode();

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native double getVideoFrameRate();

    @Override // com.youku.uplayer.Mediaplayer
    public native int getVideoHeight();

    @Override // com.youku.uplayer.Mediaplayer
    public native int getVideoWidth();

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native int getVoiceStatus();

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native float getVolume();

    @Override // com.youku.uplayer.Mediaplayer
    public boolean isLooping() {
        return false;
    }

    @Override // com.youku.uplayer.Mediaplayer
    public native boolean isPlaying();

    public native boolean isSeeking();

    public native int mediaSplitBegin(String str, String str2, int i);

    public native int mediaSplitEnd();

    public native int mediaTranslateBegin(int i, String str, String str2, int i2, int i3, long j, long j2);

    public native int mediaTranslateEnd();

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void onAdInteract();

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void onSeekStart() {
        int i = 300;
        try {
            i = Integer.parseInt(C8064d.a().a("youku_player_config", "seek_loading_delay", String.valueOf(300)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.inSeek = true;
        this.mEventHandler.sendEmptyMessageDelayed(INTERNAL_START_LOADING, i);
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void panGuesture(int i, float f, float f2);

    @Override // com.youku.uplayer.Mediaplayer
    public void pause() {
        _pause();
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void pinchForZoom(int i, float f);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native int playBackupAD(String str, int i);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void playMidADConfirm(int i, int i2);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void playPostAD();

    @Override // com.youku.uplayer.Mediaplayer
    public native void prepare();

    @Override // com.youku.uplayer.Mediaplayer
    public native void prepareAsync();

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void prepareMidAD();

    @Override // com.youku.uplayer.Mediaplayer
    public void release() {
        _release();
        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() { // from class: com.youku.uplayer.AliMediaPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                AliMediaPlayer.this.mPreparedListener = null;
                AliMediaPlayer.this.mBufferingUpdateListener = null;
                AliMediaPlayer.this.mCompletionListener = null;
                AliMediaPlayer.this.mOnRealVideoCompletionListener = null;
                AliMediaPlayer.this.mSeekCompleteListener = null;
                AliMediaPlayer.this.mErrorListener = null;
                AliMediaPlayer.this.mVideoSizeChangedListener = null;
                AliMediaPlayer.this.mInfoListener = null;
                AliMediaPlayer.this.mOnHttp302DelayListener = null;
                AliMediaPlayer.this.mOnMidADPlayListener = null;
                AliMediaPlayer.this.mOnNetworkErrorListener = null;
            }
        });
        EventHandler eventHandler = this.mEventHandler;
        if (eventHandler != null && eventHandler.hasMessages(2000)) {
            C8063c.a(TAG, "MSG MEDIA_INFO_CURRENT_POSITION_UPDATE DELAY! REMOVE MANUALLY!");
            this.mEventHandler.removeMessages(2000);
        }
        TLogUtilNative.playLog("AliMediaPlayer release");
        stayAwake(false);
        updateSurfaceScreenOn();
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void releaseSurface() {
        this.mTextureSurface = null;
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void reset() {
        stayAwake(false);
        _reset();
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void resetPanoramic();

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native int screenShotMultiFramesBegin(String str, int i, int i2, String str2, long j, long j2, int i3);

    public native int screenShotMultiFramesEnd(int i, int i2, long j, long j2, int i3, Object obj);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native int screenShotOneFrame(AssetManager assetManager, String str, int i, int i2, int i3, String str2, int i4, int i5, int i6, int i7);

    @Override // com.youku.uplayer.Mediaplayer
    public void seekTo(int i) {
        seekTo(i, 0);
    }

    public native void seekTo(int i, int i2);

    public void sendBroadCast() {
        Intent intent = new Intent("com.youku.phone.force.quit.pip");
        String obj = toString();
        intent.putExtra("PlayerInstance", obj);
        String str = TAG;
        C8063c.a(str, "AliMediaPlayer com.youku.phone.force.quit.pip playerInstance: " + obj);
        LocalBroadcastManager.getInstance(C7901a.a).sendBroadcast(intent);
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void setAdjectiveSource(String str, Object obj, String str2, Object obj2);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native int setAudioCallback(AudioCallback audioCallback);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void setAudioEnhance(boolean z);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native int setAudioInfo(int i, int i2);

    @Override // com.youku.uplayer.Mediaplayer
    public native void setAudioStreamType(int i);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void setBinocularMode(boolean z);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native int setColorBlindType(int i, int i2);

    public native int setConfigParameter(String str);

    @Override // com.youku.uplayer.Mediaplayer
    public native void setDataSource(String str);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void setDataSource(String str, Object obj);

    @Override // com.youku.uplayer.Mediaplayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        Surface surface;
        this.mSurfaceHolder = surfaceHolder;
        EGLUtil.setSurfaceHolder(surfaceHolder);
        SurfaceHolder surfaceHolder2 = this.mSurfaceHolder;
        if (surfaceHolder2 != null) {
            surfaceHolder2.setFormat(4);
            surface = this.mSurfaceHolder.getSurface();
        } else {
            surface = null;
        }
        this.mSurface = surface;
        if (this.useHardwareDecode) {
            setHWVideoSurface(this.mSurface);
        } else {
            _setVideoSurface(this.mSurface);
        }
        stayAwake(true);
    }

    @Deprecated
    public native void setDomainAfterNetChanged(String str);

    public native void setDomainStrategyAfterNetChanged(Object obj);

    public native void setDomainStrategyAfterNetChanged(String str);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void setEnhanceMode(boolean z, float f, float f2);

    public native void setEulerAngles(float f, float f2, float f3);

    public void setExtraInfo(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.mExtraInfos.put(str, str2);
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void setFilter(int i, Object obj);

    public native void setFrameAvailable();

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void setGyroscope(float f, float f2, float f3, float f4);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void setGyroscopeActive(boolean z);

    public native SurfaceTexture setHWVideoSurface(Surface surface);

    public native SurfaceTexture setHWVideoSurface2(Surface surface, boolean z);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void setHttpUserAgent(String str);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void setInterfaceOrientation(int i);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void setLaifengTSMode(boolean z);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void setLiveSeiGettingMode(boolean z);

    public native int setLooping(boolean z);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setLoopingMode(boolean z) {
        setLooping(z);
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void setMidADDataSource(String str, Object obj);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void setNightMode(int i);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnADCountListener(OnADCountListener onADCountListener) {
        this.mOnADCountListener = onADCountListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnADPlayListener(OnADPlayListener onADPlayListener) {
        this.mOnADPlayListener = onADPlayListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mBufferingUpdateListener = onBufferingUpdateListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnCombineVideoListener(OnCombineVideoListener onCombineVideoListener) {
        this.mOnCombineVideoListener = onCombineVideoListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.mCompletionListener = onCompletionListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnConnectDelayListener(OnConnectDelayListener onConnectDelayListener) {
        this.mOnConnectDelayListener = onConnectDelayListener;
    }

    public void setOnCoreMsgListener(OnCoreMsgListener onCoreMsgListener) {
        this.mOnCoreMsgListener = onCoreMsgListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnCpuUsageListener(OnCpuUsageListener onCpuUsageListener) {
        this.mOnCpuUsageListener = onCpuUsageListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnCurrentPositionUpdateListener(OnCurrentPositionUpdateListener onCurrentPositionUpdateListener) {
        this.mOnCurrentPositionUpdateListener = onCurrentPositionUpdateListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnDropVideoFramesListener(OnDropVideoFramesListener onDropVideoFramesListener) {
        this.mOnDropVideoFramesListener = onDropVideoFramesListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    @Deprecated
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.mErrorListener = onErrorListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    public void setOnFirstFrameListener(OnFirstFrameListener onFirstFrameListener) {
        this.mOnFirstFrameListener = onFirstFrameListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnHttp302DelayListener(OnHttp302DelayListener onHttp302DelayListener) {
        this.mOnHttp302DelayListener = onHttp302DelayListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnHwDecodeErrorListener(OnHwDecodeErrorListener onHwDecodeErrorListener) {
        this.mOnHwDecodeErrorListener = onHwDecodeErrorListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.mInfoListener = onInfoListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnIsInitialListener(OnIsInitialListener onIsInitialListener) {
        this.mOnIsInitialListener = onIsInitialListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnLodingStatusListener(OnLoadingStatusListener onLoadingStatusListener) {
        this.mOnLodingStatusListener = onLoadingStatusListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnMidADPlayListener(OnMidADPlayListener onMidADPlayListener) {
        this.mOnMidADPlayListener = onMidADPlayListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnNativeShotDownListener(OnNativeShotDownListener onNativeShotDownListener) {
        this.mOnNativeShotDownListener = onNativeShotDownListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    @Deprecated
    public void setOnNetworkErrorListener(OnNetworkErrorListener onNetworkErrorListener) {
        this.mOnNetworkErrorListener = onNetworkErrorListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnNetworkSpeedListener(OnNetworkSpeedListener onNetworkSpeedListener) {
        this.mOnNetworkSpeedListener = onNetworkSpeedListener;
    }

    public void setOnPlayerHostListener(OnPlayerHostListener onPlayerHostListener) {
        this.mOnPlayerHostListener = onPlayerHostListener;
    }

    public void setOnPlayerP2PListener(OnPlayerP2PListener onPlayerP2PListener) {
        this.mOnPlayerP2PListener = onPlayerP2PListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnPostADPlayListener(OnPostADPlayListener onPostADPlayListener) {
        this.mOnPostADPlayListener = onPostADPlayListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnPreLoadPlayListener(OnPreLoadPlayListener onPreLoadPlayListener) {
        this.mOnPreLoadPlayListener = onPreLoadPlayListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.mPreparedListener = onPreparedListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnQualityChangeListener(OnQualityChangeListener onQualityChangeListener) {
        this.mOnQualityChangeListener = onQualityChangeListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnRealVideoCompletionListener(OnRealVideoCompletionListener onRealVideoCompletionListener) {
        this.mOnRealVideoCompletionListener = onRealVideoCompletionListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnRealVideoStartListener(OnRealVideoStartListener onRealVideoStartListener) {
        this.mOnRealVideoStartListener = onRealVideoStartListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnScreenShotFinishListener(OnScreenShotFinishListener onScreenShotFinishListener) {
        this.mOnScreenShotFinishListener = onScreenShotFinishListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mSeekCompleteListener = onSeekCompleteListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnSliceUpdateListener(OnSliceUpdateListener onSliceUpdateListener) {
        this.mOnSliceUpdateListener = onSliceUpdateListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnVideoCurrentIndexUpdateListener(OnVideoCurrentIndexUpdateListener onVideoCurrentIndexUpdateListener) {
        this.mOnVideoCurrentIndexUpdateListener = onVideoCurrentIndexUpdateListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnVideoIndexUpdateListener(OnVideoIndexUpdateListener onVideoIndexUpdateListener) {
        this.mOnVideoIndexUpdateListener = onVideoIndexUpdateListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mVideoSizeChangedListener = onVideoSizeChangedListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setPlayRate(int i) {
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void setPlaySpeed(double d);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void setPlaybackParam(int i, String str);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setPreparedFlag(boolean z) {
        this.mPreparedFlag = z;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void setPursueVideoFrameType(int i);

    public native void setQuaternion(float f, float f2, float f3, float f4);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void setRenderVideo(boolean z);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void setRotationMatrix(int i, float[] fArr);

    @Override // com.youku.uplayer.Mediaplayer
    public void setScreenOnWhilePlaying(boolean z) {
        if (this.mScreenOnWhilePlaying != z) {
            this.mScreenOnWhilePlaying = z;
            updateSurfaceScreenOn();
        }
    }

    public native void setScreenState(int i);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setSurface(Surface surface) {
        String str = TAG;
        C8063c.a(str, "<********> alimediaplayer.surface()---" + surface);
        this.mTextureSurface = surface;
        if (this.useHardwareDecode) {
            setHWVideoSurface(surface);
        } else {
            _setVideoSurface(surface);
        }
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native int setTcConfigParam(int i);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setTimeout(int i, int i2) {
        set_timeout(i, i2);
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setUseHardwareDecode(boolean z) {
        this.useHardwareDecode = z;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void setVideoOrientation(int i);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void setVideoRendCutMode(int i, float f, float f2);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void setVideoRendMove(float f, float f2);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native int setVideoVisionIndex(int i);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native int setVolume(float f);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native int setWaterMarkInfo(int i, String str, int i2, int i3, float f, float f2, float f3);

    public native void setZoomValue(float f);

    public native void set_timeout(int i, int i2);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setmOnLodingStatusListenerNoTrack(OnLoadingStatusListenerNoTrack onLoadingStatusListenerNoTrack) {
        this.mOnLodingStatusListenerNoTrack = onLoadingStatusListenerNoTrack;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void setmOnTimeoutListener(OnTimeoutListener onTimeoutListener) {
        this.mOnTimeoutListener = onTimeoutListener;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void skipAd(int i);

    @Override // com.youku.uplayer.Mediaplayer
    public void start() {
        _start();
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native int startDetectImage(int i, int i2);

    @Override // com.youku.uplayer.Mediaplayer
    public void stop() {
        stayAwake(false);
        _stop();
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native int stopDetectImage();

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void stopVideoSurface(Surface surface);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native int switchDataSource(String str, Object obj);

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public native void switchPlayerMode(int i, int i2);

    public void testGetKey() {
        String str = TAG;
        C8063c.a(str, "testGetKey:{\"key3\":\"1\",\"hw_audio_dec_ac3\":\"true\",\"key4\":\"asdfgk4k4k4\"}");
        String configParameter = getConfigParameter("{\"key3\":\"1\",\"hw_audio_dec_ac3\":\"true\",\"key4\":\"asdfgk4k4k4\"}");
        C8063c.a(str, "testGetKey res=" + configParameter);
        C8063c.a(str, "testGetKey:null");
        String configParameter2 = getConfigParameter(null);
        C8063c.a(str, "testGetKey res=" + configParameter2);
    }

    public void testPutKey() {
        String str = TAG;
        C8063c.a(str, "tesyPutKey:{\"hw_audio_dec_ac3\":\"enable:1\",\"hw_video_dec_h263\":\"adf\",\"key3\":\"asdfgh\"}");
        int configParameter = setConfigParameter("{\"hw_audio_dec_ac3\":\"enable:1\",\"hw_video_dec_h263\":\"adf\",\"key3\":\"asdfgh\"}");
        C8063c.a(str, "testPutKey res=" + configParameter);
        C8063c.a(str, "tesyPutKey:{\"hw_audio_dec_ac3\":\"enable:0\",\"hw_video_dec_h263\":\"adf\",\"key3\":\"asdfgh\"}");
        int configParameter2 = setConfigParameter("{\"hw_audio_dec_ac3\":\"enable:0\",\"hw_video_dec_h263\":\"adf\",\"key3\":\"asdfgh\"}");
        C8063c.a(str, "testPutKey res=" + configParameter2);
    }
}
