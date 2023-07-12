package android.taobao.windvane.extra.embed.video;

import android.app.Activity;
import android.content.Context;
import android.taobao.windvane.embed.BaseEmbedView;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.avplayer.DWAspectRatio;
import com.taobao.avplayer.DWInstanceType;
import com.taobao.avplayer.IDWVideoLifecycleListener;
import com.taobao.avplayer.IDWVideoLoopCompleteListener;
import com.taobao.avplayer.TBDWInstance;
import com.taobao.avplayer.TBHighPerformanceDWInstance;
import com.taobao.avplayer.common.IDWMutedChangeListener;
import com.taobao.avplayer.common.IDWRootViewClickListener;
import com.taobao.avplayer.interactivelifecycle.frontcover.model.DWFrontCover;
import com.taobao.avplayer.interactivelifecycle.frontcover.model.DWFrontCoverBean;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.taobao.weex.common.Constants;
import com.uc.webview.export.extension.EmbedViewConfig;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class MyTBVideoEmbedView extends BaseEmbedView implements IDWVideoLifecycleListener, IDWVideoLoopCompleteListener, IDWMutedChangeListener, IDWRootViewClickListener {
    private static String ERROR = "error";
    private static String FINISH = "finish";
    private static final String FULL_SCREEN_MODE = "fullScreen";
    private static String LANDSCAPE = "landscape";
    private static String METADATA = "meta";
    private static String MUTEDCHANGE = "mutedChange";
    public static final String NAME = "wvvideo";
    private static final String NORMAL_SCREEN_MODE = "inlineScreen";
    private static String PAUSED = "paused";
    private static String PLAYING = "playing";
    private static String PREPARED = "prepared";
    private static String SCREENMODECHANGE = "screenModeChange";
    private static final String SMALL_SCREEN_MODE = "smallScreen";
    private static final String VALUE_FALSE = "false";
    private static final long VALUE_LONG = -1;
    private static final String VALUE_TRUE = "true";
    private static String VIDEOEND = "end";
    private DWAspectRatio mAspectRatio;
    private boolean mAutoPlay;
    private boolean mBackCoverDisPlay;
    private Context mContext;
    private boolean mControlsViewHidden;
    private boolean mGestureViewHidden;
    private boolean mHasDisappear;
    private TBHighPerformanceDWInstance mHigDWInstance;
    private boolean mInit;
    private long mInteractiveId;
    private boolean mIsVideoLoop;
    private boolean mLoadingHidden;
    private boolean mMiniProgressViewHidden;
    private boolean mNetworkErrorViewHidden;
    private boolean mPlayErrorViewHidden;
    private boolean mPlayingIconHidden;
    private ImageView.ScaleType mPosterScaleType;
    private String mScreenMode;
    private boolean mShownMuteBtn;
    private TBDWInstance mTBDWInstance;
    private boolean mToastViewHidden;
    private long mUserId;
    private HashMap<String, String> utParams;
    private int mWidth = 0;
    private int mHeight = 0;
    private String mSrc = null;
    private String mPlayerScene = null;
    private String mThumbnailSrc = null;
    private boolean mShowInteractive = false;
    private String mContentId = null;
    private boolean mMuted = false;
    private String mVideoSource = null;
    private String mVideoId = null;
    private String mFrom = null;
    private String mPreload = null;
    private String mPlayControl = null;
    private String mContentMode = null;
    private boolean mNeedFirstPlayUT = true;
    private DWInstanceType mDWInstanceType = null;
    private int mCurrentTime = 0;
    private boolean mHasPlay = false;
    private boolean mResume = false;
    private boolean mStarted = false;
    private int mVideoDuration = 0;
    private boolean mLandscape = false;
    private FrameLayout mComponentHostView = null;
    private boolean mNeedAD = true;
    private boolean isCompleted = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public enum EmbedProperties {
        playerScene { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.1
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setPlayerScene(String.valueOf(obj), z);
                    return true;
                }
                return true;
            }
        },
        instanceType { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.2
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setDWInstanceType(String.valueOf(obj), z);
                    return true;
                }
                return true;
            }
        },
        src { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.3
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setSrc(String.valueOf(obj), z);
                    return true;
                }
                return true;
            }
        },
        loop { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.4
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setIsVideoLoop(toBoolean(obj), z);
                    return true;
                }
                return true;
            }
        },
        autoplay { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.5
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setAutoPlay(toBoolean(obj), z);
                    return true;
                }
                return true;
            }
        },
        thumbnailSrc { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.6
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setThumbnailSrc(String.valueOf(obj), z);
                    return true;
                }
                return true;
            }
        },
        poster { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.7
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setThumbnailSrc(String.valueOf(obj), z);
                    return true;
                }
                return true;
            }
        },
        interactiveHidden { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.8
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setInteractiveHidden(toBoolean(obj), z);
                    return true;
                }
                return true;
            }
        },
        contentId { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.9
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setContentId(String.valueOf(obj), z);
                    return true;
                }
                return true;
            }
        },
        backCoverDisplay { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.10
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setBackCoverDisPlay(toBoolean(obj), z);
                    return true;
                }
                return true;
            }
        },
        muted { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.11
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setMuted(toBoolean(obj), z);
                    return true;
                }
                return true;
            }
        },
        preload { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.12
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setPreLoad(String.valueOf(obj), z);
                    return true;
                }
                return true;
            }
        },
        videoSource { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.13
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setVideoSource(String.valueOf(obj), z);
                    return true;
                }
                return true;
            }
        },
        videoId { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.14
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setVideoId(String.valueOf(obj), z);
                    return true;
                }
                return true;
            }
        },
        from { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.15
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setFrom(String.valueOf(obj), z);
                    return true;
                }
                return true;
            }
        },
        utParams { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.16
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setUtParams(new HashMap<>(), z);
                    return true;
                }
                return true;
            }
        },
        playControl { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.17
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setPlayControl(String.valueOf(obj), z);
                    return true;
                }
                return true;
            }
        },
        contentMode { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.18
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setContentMode(String.valueOf(obj), z);
                    return true;
                }
                return true;
            }
        },
        interactiveId { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.19
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setInteractiveId(toLong(obj), z);
                    return true;
                }
                return true;
            }
        },
        userId { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.20
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setUserId(toLong(obj), z);
                    return true;
                }
                return true;
            }
        },
        miniProgressViewHidden { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.21
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setMiniProgressViewHidden(toBoolean(obj), z);
                    return true;
                }
                return true;
            }
        },
        networkErrorViewHidden { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.22
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setNetworkErrorViewHidden(toBoolean(obj), z);
                    return true;
                }
                return true;
            }
        },
        toastViewHidden { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.23
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setToastViewHidden(toBoolean(obj), z);
                    return true;
                }
                return true;
            }
        },
        playingIconHidden { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.24
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setPlayingIconHidden(toBoolean(obj), z);
                    return true;
                }
                return true;
            }
        },
        gestureViewHidden { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.25
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setGestureViewHidden(toBoolean(obj), z);
                    return true;
                }
                return true;
            }
        },
        controlsViewHidden { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.26
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setControlsViewHidden(toBoolean(obj), z);
                    return true;
                }
                return true;
            }
        },
        loadingHidden { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.27
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setLoadingHidden(toBoolean(obj), z);
                    return true;
                }
                return true;
            }
        },
        playErrorViewHidden { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.28
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setPlayErrorViewHidden(toBoolean(obj), z);
                    return true;
                }
                return true;
            }
        },
        setWidth { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.29
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setWidth((int) toLong(obj), true);
                }
                return true;
            }
        },
        setHeight { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.30
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setHeight((int) toLong(obj), true);
                }
                return true;
            }
        },
        shownMuteBtn { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties.31
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setShownMuteBtn(toBoolean(obj), z);
                    return true;
                }
                return true;
            }
        };

        public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
            return (obj == null || myTBVideoEmbedView == null) ? false : true;
        }

        public boolean toBoolean(Object obj) {
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            String valueOf = String.valueOf(obj);
            return "true".equals(valueOf) || "1".equals(valueOf);
        }

        public long toLong(Object obj) {
            if (obj instanceof Long) {
                return ((Long) obj).longValue();
            }
            try {
                return Long.parseLong(String.valueOf(obj));
            } catch (Throwable unused) {
                return -1L;
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    private enum JSMethod {
        getCurrentTime { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod.1
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
            public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
                if (wVCallBackContext == null) {
                    return false;
                }
                int currentPosition = myTBVideoEmbedView.getCurrentPosition();
                wVCallBackContext.success("" + (currentPosition / 1000.0f));
                return true;
            }
        },
        setCurrentTime { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod.2
            /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean doSomething(android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView r3, java.lang.String r4, android.taobao.windvane.jsbridge.WVCallBackContext r5) {
                /*
                    r2 = this;
                    boolean r0 = android.text.TextUtils.isEmpty(r4)
                    r1 = 1
                    if (r0 != 0) goto L37
                    com.alibaba.fastjson.JSONObject r4 = com.alibaba.fastjson.JSON.parseObject(r4)
                    if (r4 == 0) goto L37
                    java.lang.String r0 = "time"
                    java.lang.String r4 = r4.getString(r0)
                    int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.Throwable -> L37
                    int r4 = r4 * 1000
                    com.taobao.avplayer.TBDWInstance r0 = android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.access$200(r3)     // Catch: java.lang.Throwable -> L37
                    if (r0 == 0) goto L28
                    com.taobao.avplayer.TBDWInstance r3 = android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.access$200(r3)     // Catch: java.lang.Throwable -> L37
                    r3.seekTo(r4)     // Catch: java.lang.Throwable -> L37
                    goto L35
                L28:
                    com.taobao.avplayer.TBHighPerformanceDWInstance r0 = android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.access$300(r3)     // Catch: java.lang.Throwable -> L37
                    if (r0 == 0) goto L35
                    com.taobao.avplayer.TBHighPerformanceDWInstance r3 = android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.access$300(r3)     // Catch: java.lang.Throwable -> L37
                    r3.seekTo(r4)     // Catch: java.lang.Throwable -> L37
                L35:
                    r3 = 1
                    goto L38
                L37:
                    r3 = 0
                L38:
                    if (r5 == 0) goto L43
                    if (r3 == 0) goto L40
                    r5.success()
                    goto L43
                L40:
                    r5.error()
                L43:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod.AnonymousClass2.doSomething(android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView, java.lang.String, android.taobao.windvane.jsbridge.WVCallBackContext):boolean");
            }
        },
        getDuration { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod.3
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
            public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
                if (wVCallBackContext != null) {
                    wVCallBackContext.success(String.valueOf(myTBVideoEmbedView.mVideoDuration / 1000.0f));
                    return true;
                }
                return true;
            }
        },
        getMuted { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod.4
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
            public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
                if (wVCallBackContext != null) {
                    wVCallBackContext.success(String.valueOf(myTBVideoEmbedView.isMute()));
                    return true;
                }
                return true;
            }
        },
        setMuted { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod.5
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
            public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
                JSONObject parseObject;
                if (TextUtils.isEmpty(str) || (parseObject = JSON.parseObject(str)) == null) {
                    return true;
                }
                myTBVideoEmbedView.mute(Boolean.TRUE.equals(parseObject.getBoolean("muted")));
                if (wVCallBackContext != null) {
                    wVCallBackContext.success();
                    return true;
                }
                return true;
            }
        },
        setScreenMode { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod.6
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
            public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
                JSONObject parseObject;
                Object obj;
                if (TextUtils.isEmpty(str) || (parseObject = JSON.parseObject(str)) == null || (obj = parseObject.get("screenMode")) == null) {
                    return false;
                }
                myTBVideoEmbedView.setScreenMode(String.valueOf(obj), true);
                if (wVCallBackContext != null) {
                    wVCallBackContext.success();
                }
                return true;
            }
        },
        getScreenMode { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod.7
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
            public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
                if (wVCallBackContext != null) {
                    wVCallBackContext.success(myTBVideoEmbedView.mScreenMode);
                    return true;
                }
                return true;
            }
        },
        play { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod.8
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
            public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
                myTBVideoEmbedView.play();
                if (wVCallBackContext != null) {
                    wVCallBackContext.success();
                    return true;
                }
                return true;
            }
        },
        pause { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod.9
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
            public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
                if (myTBVideoEmbedView.mTBDWInstance != null) {
                    myTBVideoEmbedView.mTBDWInstance.pauseVideo();
                } else if (myTBVideoEmbedView.mHigDWInstance != null) {
                    myTBVideoEmbedView.mHigDWInstance.pauseVideo();
                }
                if (wVCallBackContext != null) {
                    wVCallBackContext.success();
                    return true;
                }
                return true;
            }
        },
        setInstanceMode { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod.10
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
            public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
                JSONObject parseObject;
                Object obj;
                if (TextUtils.isEmpty(str) || (parseObject = JSON.parseObject(str)) == null || (obj = parseObject.get("instanceMode")) == null) {
                    return false;
                }
                myTBVideoEmbedView.setDWInstanceType(String.valueOf(obj), true);
                if (wVCallBackContext != null) {
                    wVCallBackContext.success();
                }
                return true;
            }
        },
        updateEmbedProperty { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod.11
            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
            public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
                JSONObject parseObject;
                EmbedProperties embedProperties;
                if (myTBVideoEmbedView == null || TextUtils.isEmpty(str) || (parseObject = JSON.parseObject(str)) == null) {
                    return false;
                }
                Object obj = parseObject.get("key");
                Object obj2 = parseObject.get("value");
                if (obj == null || obj2 == null) {
                    return false;
                }
                try {
                    embedProperties = EmbedProperties.valueOf(String.valueOf(obj));
                } catch (Throwable unused) {
                    embedProperties = null;
                }
                if (embedProperties == null) {
                    return false;
                }
                embedProperties.setValue(myTBVideoEmbedView, obj2, true);
                return true;
            }
        };

        public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
            return false;
        }
    }

    private void destroyInner() {
        TBDWInstance tBDWInstance = this.mTBDWInstance;
        if (tBDWInstance != null) {
            boolean z = this.mHasPlay;
            if (!z) {
                z = tBDWInstance.adIsPlaying();
            }
            this.mHasPlay = z;
            if (this.mTBDWInstance.isFullScreen()) {
                ViewGroup view = this.mTBDWInstance.getView();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
                this.mTBDWInstance.toggleScreen();
            }
            FrameLayout frameLayout = this.mComponentHostView;
            if (frameLayout != null) {
                frameLayout.removeView(this.mTBDWInstance.getView());
            }
            this.mTBDWInstance.setVideoLifecycleListener((IDWVideoLifecycleListener) null);
            this.mTBDWInstance.destroy();
            this.mTBDWInstance = null;
            return;
        }
        TBHighPerformanceDWInstance tBHighPerformanceDWInstance = this.mHigDWInstance;
        if (tBHighPerformanceDWInstance != null) {
            FrameLayout frameLayout2 = this.mComponentHostView;
            if (frameLayout2 != null) {
                frameLayout2.removeView(tBHighPerformanceDWInstance.getView());
            }
            this.mHigDWInstance.setVideoLifecycleListener((IDWVideoLifecycleListener) null);
            this.mHigDWInstance.destroy();
            this.mHigDWInstance = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireEvent(String str, String str2) {
        EmbedViewEvent.firevent(this.webView, this.id, str, str2);
    }

    private View genVideoView() {
        View initNormalInstance;
        boolean z;
        if ("highPerformance".equals(this.mPlayerScene)) {
            initNormalInstance = initHighInstance();
            z = true;
        } else {
            initNormalInstance = initNormalInstance();
            z = false;
        }
        this.mInit = true;
        if (this.mComponentHostView == null) {
            this.mComponentHostView = new FrameLayout(this.mContext) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.1
                @Override // android.view.View
                protected void onSizeChanged(int i, int i2, int i3, int i4) {
                    super.onSizeChanged(i, i2, i3, i4);
                    if (i4 == i3 && i4 == 0) {
                        return;
                    }
                    if (MyTBVideoEmbedView.this.mHeight == i2 && MyTBVideoEmbedView.this.mWidth == i) {
                        return;
                    }
                    MyTBVideoEmbedView.this.mHeight = i2;
                    MyTBVideoEmbedView.this.mWidth = i;
                    if (MyTBVideoEmbedView.this.mTBDWInstance != null) {
                        MyTBVideoEmbedView.this.mTBDWInstance.setFrame(i, i2);
                    } else if (MyTBVideoEmbedView.this.mHigDWInstance != null) {
                        MyTBVideoEmbedView.this.mHigDWInstance.setFrame(i, i2);
                    }
                }
            };
        }
        ViewParent parent = initNormalInstance.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(initNormalInstance);
        }
        this.mComponentHostView.addView(initNormalInstance);
        if (this.mAutoPlay) {
            if (z) {
                this.mHigDWInstance.start();
            } else {
                this.mTBDWInstance.start();
            }
            fireEvent(PLAYING, "");
        }
        initNormalInstance.setOnTouchListener(new View.OnTouchListener() { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                MyTBVideoEmbedView.this.fireEvent("click", "");
                return false;
            }
        });
        return this.mComponentHostView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentPosition() {
        TBDWInstance tBDWInstance = this.mTBDWInstance;
        if (tBDWInstance != null) {
            return tBDWInstance.getCurrentPosition();
        }
        TBHighPerformanceDWInstance tBHighPerformanceDWInstance = this.mHigDWInstance;
        if (tBHighPerformanceDWInstance != null) {
            return tBHighPerformanceDWInstance.getCurrentPosition();
        }
        return 0;
    }

    private View initHighInstance() {
        TBHighPerformanceDWInstance.TBBuilder tBBuilder = new TBHighPerformanceDWInstance.TBBuilder((Activity) this.mContext);
        tBBuilder.setBizCode(this.mFrom);
        tBBuilder.setContentId(this.mContentId);
        tBBuilder.setUserId(this.mUserId);
        tBBuilder.setVideoUrl(this.mSrc);
        tBBuilder.setMute(this.mMuted);
        tBBuilder.setUTParams(this.utParams);
        tBBuilder.setWidth(this.mWidth);
        tBBuilder.setVideoId(this.mVideoId);
        tBBuilder.setVideoSource(this.mVideoSource);
        tBBuilder.setHeight(this.mHeight);
        tBBuilder.setVideoLoop(this.mIsVideoLoop);
        DWAspectRatio dWAspectRatio = this.mAspectRatio;
        if (dWAspectRatio != null) {
            tBBuilder.setVideoAspectRatio(dWAspectRatio);
        }
        tBBuilder.setDWInstanceType(DWInstanceType.PIC);
        this.mHigDWInstance = tBBuilder.create();
        if (!TextUtils.isEmpty(this.mThumbnailSrc)) {
            TUrlImageView tUrlImageView = new TUrlImageView(this.mContext);
            ImageView.ScaleType scaleType = this.mPosterScaleType;
            if (scaleType != null) {
                tUrlImageView.setScaleType(scaleType);
            }
            tUrlImageView.asyncSetImageUrl(this.mThumbnailSrc);
            this.mHigDWInstance.setPicImageView(tUrlImageView);
        }
        this.mHigDWInstance.setVideoLifecycleListener(this);
        if (this.mIsVideoLoop) {
            this.mHigDWInstance.setIVideoLoopCompleteListener(this);
        }
        this.mHigDWInstance.setRootViewClickListener(this);
        this.mHigDWInstance.setIDWMutedChangeListener(this);
        if (!this.mAutoPlay && (!this.mResume || !this.mStarted)) {
            if (METADATA.equals(this.mPreload)) {
                this.mHigDWInstance.setInstanceType(DWInstanceType.VIDEO);
                this.mHigDWInstance.asyncPrepareVideo();
            }
        } else {
            this.mHigDWInstance.setInstanceType(DWInstanceType.VIDEO);
            this.mStarted = true;
            this.mNeedFirstPlayUT = false;
            this.mHigDWInstance.start();
        }
        return this.mHigDWInstance.getView();
    }

    private View initNormalInstance() {
        TBDWInstance.TBBuilder tBBuilder = new TBDWInstance.TBBuilder((Activity) this.mContext);
        tBBuilder.setVideoUrl(this.mSrc);
        if (!TextUtils.isEmpty(this.mPlayerScene)) {
            tBBuilder.setScene(this.mPlayerScene);
        }
        DWInstanceType dWInstanceType = this.mDWInstanceType;
        if (dWInstanceType != null) {
            tBBuilder.setDWInstanceType(dWInstanceType);
        }
        tBBuilder.setVideoLoop(this.mIsVideoLoop);
        tBBuilder.setMute(this.mMuted);
        if (!TextUtils.isEmpty(this.mContentId)) {
            tBBuilder.setContentId(this.mContentId);
        }
        tBBuilder.setNeedBackCover(this.mBackCoverDisPlay);
        tBBuilder.setVideoSource(this.mVideoSource);
        tBBuilder.setVideoId(this.mVideoId);
        tBBuilder.setBizCode(this.mFrom);
        tBBuilder.setUTParams(this.utParams);
        if (this.mUserId != -1) {
            tBBuilder.setInteractiveId(this.mInteractiveId);
        }
        long j = this.mUserId;
        if (j != -1) {
            tBBuilder.setUserId(j);
        }
        if (!TextUtils.isEmpty(this.mThumbnailSrc)) {
            tBBuilder.setNeedFrontCover(true);
            DWFrontCover dWFrontCover = new DWFrontCover();
            DWFrontCoverBean dWFrontCoverBean = new DWFrontCoverBean(0L, (String) null, this.mThumbnailSrc);
            dWFrontCoverBean.setScaleType(this.mPosterScaleType);
            dWFrontCover.setFrontCoverView(dWFrontCoverBean);
            tBBuilder.setFrontCoverData(dWFrontCover);
        }
        tBBuilder.setMiniProgressAnchorShown(this.mMiniProgressViewHidden);
        tBBuilder.hiddenNetworkErrorView(this.mNetworkErrorViewHidden);
        tBBuilder.hiddenToastView(this.mToastViewHidden);
        tBBuilder.hiddenPlayingIcon(this.mPlayingIconHidden);
        tBBuilder.hiddenGestureView(this.mGestureViewHidden);
        tBBuilder.hiddenLoading(this.mLoadingHidden);
        tBBuilder.hiddenPlayErrorView(this.mPlayErrorViewHidden);
        tBBuilder.setMuteDisplay(this.mShownMuteBtn);
        tBBuilder.setWidth(this.mWidth);
        tBBuilder.setHeight(this.mHeight);
        TBDWInstance create = tBBuilder.create();
        this.mTBDWInstance = create;
        create.setVideoLifecycleListener(this);
        this.mTBDWInstance.setIDWMutedChangeListener(this);
        this.mTBDWInstance.hideCloseView();
        this.mTBDWInstance.hideController();
        return this.mTBDWInstance.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isMute() {
        TBDWInstance tBDWInstance = this.mTBDWInstance;
        return tBDWInstance != null ? tBDWInstance.isMute() : this.mHigDWInstance.isMute();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mute(boolean z) {
        this.mMuted = z;
        if (!this.mInit || this.mHasDisappear) {
            return;
        }
        TBDWInstance tBDWInstance = this.mTBDWInstance;
        if (tBDWInstance != null) {
            tBDWInstance.mute(z);
            return;
        }
        TBHighPerformanceDWInstance tBHighPerformanceDWInstance = this.mHigDWInstance;
        if (tBHighPerformanceDWInstance != null) {
            tBHighPerformanceDWInstance.mute(z);
        }
    }

    private void parseParam() {
        EmbedProperties[] values;
        setWidth(this.params.mWidth, false);
        setHeight(this.params.mHeight, false);
        for (EmbedProperties embedProperties : EmbedProperties.values()) {
            embedProperties.setValue(this, this.params.mObjectParam.get(embedProperties.name()), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        TBDWInstance tBDWInstance = this.mTBDWInstance;
        if (tBDWInstance != null) {
            if (tBDWInstance.getVideoState() != 0 && this.mTBDWInstance.getVideoState() != 5 && this.mTBDWInstance.getVideoState() != 8 && this.mTBDWInstance.getVideoState() != 4) {
                this.mTBDWInstance.playVideo();
                return;
            }
            this.mStarted = true;
            this.mTBDWInstance.start();
            return;
        }
        TBHighPerformanceDWInstance tBHighPerformanceDWInstance = this.mHigDWInstance;
        if (tBHighPerformanceDWInstance != null) {
            tBHighPerformanceDWInstance.setInstanceType(DWInstanceType.VIDEO);
            if (this.mHigDWInstance.getVideoState() != 0 && this.mHigDWInstance.getVideoState() != 5 && this.mHigDWInstance.getVideoState() != 8 && this.mHigDWInstance.getVideoState() != 4) {
                this.mHigDWInstance.playVideo();
                return;
            }
            this.mStarted = true;
            this.mNeedFirstPlayUT = false;
            this.mHigDWInstance.start();
        }
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView, android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        JSMethod jSMethod;
        try {
            jSMethod = JSMethod.valueOf(str);
        } catch (Throwable unused) {
            jSMethod = null;
        }
        if (jSMethod != null) {
            return jSMethod.doSomething(this, str2, wVCallBackContext);
        }
        return super.execute(str, str2, wVCallBackContext);
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView
    protected View generateView(Context context) {
        Map map;
        EmbedViewConfig embedViewConfig = this.params;
        if (embedViewConfig == null || (map = embedViewConfig.mObjectParam) == null || map.isEmpty()) {
            return null;
        }
        this.mContext = context;
        parseParam();
        return genVideoView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.taobao.windvane.embed.BaseEmbedView
    public String getViewType() {
        return NAME;
    }

    public boolean hook() {
        return false;
    }

    void log(String str) {
        Log.e("dyy", str);
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView, com.uc.webview.export.extension.IEmbedViewContainer.OnStateChangedListener
    public void onAttachedToWebView() {
        super.onAttachedToWebView();
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView, android.taobao.windvane.jsbridge.WVApiPlugin, com.uc.webview.export.extension.IEmbedViewContainer.OnStateChangedListener
    public void onDestroy() {
        super.onDestroy();
        destroyInner();
        this.mInit = false;
        this.mContext = null;
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView, com.uc.webview.export.extension.IEmbedViewContainer.OnStateChangedListener
    public void onDetachedFromWebView() {
        super.onDetachedFromWebView();
    }

    public void onLoopCompletion() {
    }

    public void onMutedChange(boolean z) {
        fireEvent(MUTEDCHANGE, z ? "true" : "false");
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView, com.uc.webview.export.extension.IEmbedViewContainer.OnParamChangedListener
    public void onParamChanged(String[] strArr, String[] strArr2) {
        EmbedProperties embedProperties;
        super.onParamChanged(strArr, strArr2);
        if (strArr == null || strArr.length == 0 || strArr2 == null || strArr2.length == 0) {
            return;
        }
        String str = strArr[0];
        String str2 = strArr2[0];
        try {
            embedProperties = EmbedProperties.valueOf(str);
        } catch (Throwable unused) {
            embedProperties = null;
        }
        if (embedProperties == null) {
            return;
        }
        embedProperties.setValue(this, str2, true);
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void onPause() {
        super.onPause();
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void onResume() {
        super.onResume();
    }

    public void onVideoClose() {
    }

    public void onVideoComplete() {
        this.mNeedAD = true;
        this.isCompleted = true;
        TBDWInstance tBDWInstance = this.mTBDWInstance;
        if (tBDWInstance != null) {
            tBDWInstance.needAD(true);
        }
        this.mHasPlay = false;
        this.mCurrentTime = 0;
        fireEvent(FINISH, "");
        fireEvent(VIDEOEND, "");
    }

    public void onVideoError(Object obj, int i, int i2) {
        fireEvent(ERROR, "");
    }

    public void onVideoFullScreen() {
        TBDWInstance tBDWInstance = this.mTBDWInstance;
        if (tBDWInstance == null) {
            return;
        }
        tBDWInstance.mute(false);
        this.mLandscape = true;
        this.mTBDWInstance.showOrHideInteractive(true);
        this.mTBDWInstance.showTopEventView();
        this.mTBDWInstance.showGoodsListView();
        fireEvent(SCREENMODECHANGE, FULL_SCREEN_MODE);
        HashMap hashMap = new HashMap(1);
        hashMap.put("landscape", Boolean.TRUE);
        fireEvent(LANDSCAPE, JSON.toJSONString(hashMap));
        this.mScreenMode = FULL_SCREEN_MODE;
    }

    public void onVideoInfo(Object obj, int i, int i2) {
    }

    public void onVideoNormalScreen() {
        TBDWInstance tBDWInstance = this.mTBDWInstance;
        if (tBDWInstance == null) {
            return;
        }
        this.mLandscape = false;
        tBDWInstance.mute(this.mMuted);
        this.mTBDWInstance.showOrHideInteractive(this.mShowInteractive);
        this.mTBDWInstance.hideGoodsListView();
        this.mTBDWInstance.hideTopEventView();
        fireEvent(SCREENMODECHANGE, SMALL_SCREEN_MODE);
        HashMap hashMap = new HashMap(1);
        hashMap.put("landscape", Boolean.FALSE);
        fireEvent(LANDSCAPE, JSON.toJSONString(hashMap));
        this.mScreenMode = SMALL_SCREEN_MODE;
    }

    public void onVideoPause(boolean z) {
        fireEvent(PAUSED, "");
    }

    public void onVideoPlay() {
        this.isCompleted = false;
        fireEvent(PLAYING, "");
    }

    public void onVideoPrepared(Object obj) {
        this.isCompleted = false;
        fireEvent(PREPARED, "");
    }

    public void onVideoProgressChanged(int i, int i2, int i3) {
        this.mCurrentTime = i;
        if (this.mVideoDuration == 0) {
            this.mVideoDuration = i3;
        }
    }

    public void onVideoSeekTo(int i) {
    }

    public void onVideoStart() {
        TBDWInstance tBDWInstance;
        this.mNeedAD = false;
        this.mStarted = true;
        this.isCompleted = false;
        if (this.mResume && !this.mHasPlay && (tBDWInstance = this.mTBDWInstance) != null) {
            tBDWInstance.pauseVideo();
            return;
        }
        this.mHasPlay = true;
        int i = this.mCurrentTime;
        if (i > 0) {
            TBDWInstance tBDWInstance2 = this.mTBDWInstance;
            if (tBDWInstance2 != null) {
                tBDWInstance2.seekTo(i);
                return;
            }
            TBHighPerformanceDWInstance tBHighPerformanceDWInstance = this.mHigDWInstance;
            if (tBHighPerformanceDWInstance != null) {
                tBHighPerformanceDWInstance.seekTo(i);
            }
        }
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView, com.uc.webview.export.extension.IEmbedViewContainer.OnVisibilityChangedListener
    public void onVisibilityChanged(int i) {
        super.onVisibilityChanged(i);
    }

    public void setAutoPlay(boolean z, boolean z2) {
        this.mAutoPlay = z;
    }

    public void setBackCoverDisPlay(boolean z, boolean z2) {
        this.mBackCoverDisPlay = z;
    }

    public void setContentId(String str, boolean z) {
        this.mContentId = str;
    }

    public void setContentMode(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1362001767:
                    if (str.equals("aspectFit")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3143043:
                    if (str.equals("fill")) {
                        c = 1;
                        break;
                    }
                    break;
                case 727618043:
                    if (str.equals("aspectFill")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.mAspectRatio = DWAspectRatio.DW_FIT_CENTER;
                    this.mPosterScaleType = ImageView.ScaleType.FIT_CENTER;
                    break;
                case 1:
                    this.mAspectRatio = DWAspectRatio.DW_FIT_X_Y;
                    this.mPosterScaleType = ImageView.ScaleType.FIT_XY;
                    break;
                case 2:
                    this.mAspectRatio = DWAspectRatio.DW_CENTER_CROP;
                    this.mPosterScaleType = ImageView.ScaleType.CENTER_CROP;
                    break;
            }
        }
        this.mContentMode = str;
    }

    public void setControlsViewHidden(boolean z, boolean z2) {
        this.mControlsViewHidden = z;
    }

    public void setDWInstanceType(String str, boolean z) {
        DWInstanceType[] values;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (DWInstanceType dWInstanceType : DWInstanceType.values()) {
            if (dWInstanceType != null && str.equals(dWInstanceType.getValue())) {
                this.mDWInstanceType = dWInstanceType;
            }
        }
        TBHighPerformanceDWInstance tBHighPerformanceDWInstance = this.mHigDWInstance;
        if (tBHighPerformanceDWInstance == null || !z) {
            return;
        }
        tBHighPerformanceDWInstance.setInstanceType(DWInstanceType.VIDEO.equals(this.mDWInstanceType) ? DWInstanceType.VIDEO : DWInstanceType.PIC);
    }

    public void setFrom(String str, boolean z) {
        this.mFrom = str;
    }

    public void setGestureViewHidden(boolean z, boolean z2) {
        this.mGestureViewHidden = z;
    }

    public void setHeight(int i, boolean z) {
        this.mHeight = i;
        if (z) {
            TBDWInstance tBDWInstance = this.mTBDWInstance;
            if (tBDWInstance != null) {
                tBDWInstance.setFrame(this.mWidth, i);
                return;
            }
            TBHighPerformanceDWInstance tBHighPerformanceDWInstance = this.mHigDWInstance;
            if (tBHighPerformanceDWInstance != null) {
                tBHighPerformanceDWInstance.setFrame(this.mWidth, i);
            }
        }
    }

    public void setInteractiveHidden(boolean z, boolean z2) {
        TBDWInstance tBDWInstance;
        boolean z3 = !z;
        this.mShowInteractive = z3;
        if (!this.mInit || this.mHasDisappear || (tBDWInstance = this.mTBDWInstance) == null) {
            return;
        }
        tBDWInstance.showOrHideInteractive(z3);
    }

    public void setInteractiveId(long j, boolean z) {
        this.mInteractiveId = j;
    }

    public void setIsVideoLoop(boolean z, boolean z2) {
        this.mIsVideoLoop = z;
    }

    public void setLoadingHidden(boolean z, boolean z2) {
        this.mLoadingHidden = z;
    }

    public void setMiniProgressViewHidden(boolean z, boolean z2) {
        this.mMiniProgressViewHidden = z;
    }

    public void setMuted(boolean z, boolean z2) {
        TBDWInstance tBDWInstance;
        this.mMuted = z;
        if (!z2 || (tBDWInstance = this.mTBDWInstance) == null) {
            return;
        }
        tBDWInstance.mute(z);
    }

    public void setNetworkErrorViewHidden(boolean z, boolean z2) {
        this.mNetworkErrorViewHidden = z;
    }

    public void setPlayControl(String str, boolean z) {
        this.mPlayControl = str;
        if (!z || this.mTBDWInstance == null) {
            return;
        }
        this.mHasPlay = true;
        if (Constants.Value.PLAY.equals(str)) {
            if (this.mTBDWInstance.getVideoState() != 0 && this.mTBDWInstance.getVideoState() != 5 && this.mTBDWInstance.getVideoState() != 8 && this.mTBDWInstance.getVideoState() != 4) {
                this.mTBDWInstance.playVideo();
                return;
            }
            this.mStarted = true;
            this.mTBDWInstance.start();
        } else if ("pause".equals(str)) {
            this.mTBDWInstance.pauseVideo();
        }
    }

    public void setPlayErrorViewHidden(boolean z, boolean z2) {
        this.mPlayErrorViewHidden = z;
    }

    public void setPlayerScene(String str, boolean z) {
        this.mPlayerScene = str;
    }

    public void setPlayingIconHidden(boolean z, boolean z2) {
        this.mPlayingIconHidden = z;
    }

    public void setPreLoad(String str, boolean z) {
        this.mPreload = str;
    }

    public void setScreenMode(String str, boolean z) {
        this.mScreenMode = str;
        if (!z || TextUtils.isEmpty(str) || this.mTBDWInstance == null) {
            return;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -883285933:
                if (str.equals(SMALL_SCREEN_MODE)) {
                    c = 0;
                    break;
                }
                break;
            case -806066213:
                if (str.equals(FULL_SCREEN_MODE)) {
                    c = 1;
                    break;
                }
                break;
            case 370161765:
                if (str.equals(NORMAL_SCREEN_MODE)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (this.mTBDWInstance.isFullScreen() || this.mTBDWInstance.isSmallWindow()) {
                    return;
                }
                this.mTBDWInstance.toSmall();
                return;
            case 1:
                if (this.mTBDWInstance.isFullScreen()) {
                    return;
                }
                this.mTBDWInstance.toggleScreen();
                return;
            case 2:
                if (this.mTBDWInstance.isFullScreen()) {
                    this.mTBDWInstance.toggleScreen();
                    return;
                } else if (this.mTBDWInstance.isSmallWindow()) {
                    this.mTBDWInstance.toNormal();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void setShownMuteBtn(boolean z, boolean z2) {
        this.mShownMuteBtn = z;
    }

    public void setSrc(String str, boolean z) {
        this.mSrc = str;
    }

    public void setThumbnailSrc(String str, boolean z) {
        this.mThumbnailSrc = str;
    }

    public void setToastViewHidden(boolean z, boolean z2) {
        this.mToastViewHidden = z;
    }

    public void setUserId(long j, boolean z) {
        this.mUserId = j;
    }

    public void setUtParams(HashMap<String, String> hashMap, boolean z) {
        this.utParams = hashMap;
    }

    public void setVideoId(String str, boolean z) {
        this.mVideoId = str;
    }

    public void setVideoSource(String str, boolean z) {
        this.mVideoSource = str;
    }

    public void setWidth(int i, boolean z) {
        this.mWidth = i;
        if (z) {
            TBDWInstance tBDWInstance = this.mTBDWInstance;
            if (tBDWInstance != null) {
                tBDWInstance.setFrame(i, this.mHeight);
                return;
            }
            TBHighPerformanceDWInstance tBHighPerformanceDWInstance = this.mHigDWInstance;
            if (tBHighPerformanceDWInstance != null) {
                tBHighPerformanceDWInstance.setFrame(i, this.mHeight);
            }
        }
    }
}
