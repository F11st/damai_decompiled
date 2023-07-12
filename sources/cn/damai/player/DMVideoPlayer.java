package cn.damai.player;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.network.NetStateChangeReceiver;
import cn.damai.network.OnNetWorkChangeListener;
import cn.damai.player.PlayerEventListener;
import cn.damai.player.base.DMBaseVideoController;
import cn.damai.player.base.IVideoPlayer;
import cn.damai.player.video.opt.PlayOptHelper;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.youkuplayer.data.PlayParam;
import tb.db1;
import tb.e80;
import tb.fl1;
import tb.m62;
import tb.mu0;
import tb.pj1;
import tb.qx2;
import tb.w01;
import tb.xs;
import tb.ys;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class DMVideoPlayer extends FrameLayout implements OnNetWorkChangeListener, IVideoPlayer {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "DMVideoPlayer";
    public int adaptHeight;
    public int adaptWidth;
    private boolean autoAdaptSize;
    private boolean autoPaused;
    private boolean autoStopByLocation;
    private boolean isAttachedToWindow;
    private FrameLayout mContainer;
    private Context mContext;
    private DMBaseVideoController mController;
    private int mCurrentMode;
    private int mCurrentState;
    private xs mDataHolder;
    private PlayOptHelper mOptHelper;
    private w01 mPlayer;
    private ys mPlayerManager;
    ViewTreeObserver.OnScrollChangedListener onScrollChangedListener;
    private PlayerEventListener playerEventListener;
    private int videoPlayerHeight;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class a implements PlayerEventListener.OnRealVideoStartListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.player.PlayerEventListener.OnRealVideoStartListener
        public void getVideoSize(int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "355760868")) {
                ipChange.ipc$dispatch("355760868", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            int c = e80.c();
            int d = e80.d();
            if (d == 0 || c == 0) {
                return;
            }
            double d2 = i;
            DMVideoPlayer dMVideoPlayer = DMVideoPlayer.this;
            dMVideoPlayer.adaptWidth = d;
            double d3 = i2;
            int i3 = (int) ((d / d2) * d3);
            dMVideoPlayer.adaptHeight = i3;
            if (i3 > c) {
                dMVideoPlayer.adaptWidth = (int) (d2 * (c / d3));
                dMVideoPlayer.adaptHeight = c;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) dMVideoPlayer.mContainer.getLayoutParams();
            DMVideoPlayer dMVideoPlayer2 = DMVideoPlayer.this;
            layoutParams.width = dMVideoPlayer2.adaptWidth;
            layoutParams.height = dMVideoPlayer2.adaptHeight;
            layoutParams.gravity = 17;
            dMVideoPlayer2.mContainer.setLayoutParams(layoutParams);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class b implements ViewTreeObserver.OnScrollChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2119081161")) {
                ipChange.ipc$dispatch("-2119081161", new Object[]{this});
                return;
            }
            int[] iArr = new int[2];
            DMVideoPlayer.this.getLocationOnScreen(iArr);
            Log.d("videoPlayer pos", iArr[0] + " pause ===== " + iArr[0] + ", h :" + DMVideoPlayer.this.getHeight() + " , th: " + DisplayMetrics.getheightPixels(m62.b(DMVideoPlayer.this.getContext())));
            if (iArr[0] <= 0 && iArr[1] <= 0) {
                if (!DMVideoPlayer.this.isPause()) {
                    DMVideoPlayer.this.pause(false);
                }
                DMVideoPlayer.this.autoPaused = true;
                Log.d("videoPlayerx", iArr[0] + " start ===== " + iArr[0]);
                return;
            }
            if (!DMVideoPlayer.this.isPlaying() && DMVideoPlayer.this.autoPaused) {
                DMVideoPlayer.this.start();
                DMVideoPlayer.this.autoPaused = false;
            }
            Log.d("videoPlayerx", iArr[0] + " start ===== " + iArr[0]);
        }
    }

    public DMVideoPlayer(Context context) {
        this(context, null);
    }

    private void checkViewLocation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1967134037")) {
            ipChange.ipc$dispatch("-1967134037", new Object[]{this});
        } else if (this.autoStopByLocation) {
            getViewTreeObserver().addOnScrollChangedListener(this.onScrollChangedListener);
        }
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "135550029")) {
            ipChange.ipc$dispatch("135550029", new Object[]{this});
        } else {
            initContainer();
        }
    }

    private void initContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-838565476")) {
            ipChange.ipc$dispatch("-838565476", new Object[]{this});
            return;
        }
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.mContainer = frameLayout;
        frameLayout.setBackgroundColor(-16777216);
        this.videoPlayerHeight = qx2.c();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(qx2.d(), qx2.c());
        layoutParams.gravity = 17;
        addView(this.mContainer, layoutParams);
    }

    private boolean isConditionSupportPlay() {
        PlayOptHelper playOptHelper;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1782475855")) {
            return ((Boolean) ipChange.ipc$dispatch("1782475855", new Object[]{this})).booleanValue();
        }
        xs xsVar = this.mDataHolder;
        return xsVar != null && xsVar.e() != null && this.isAttachedToWindow && pj1.a(mu0.a()) && (playOptHelper = this.mOptHelper) != null && playOptHelper.isOutConditionSupportPlay();
    }

    private void playUrlVideo(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-301529235")) {
            ipChange.ipc$dispatch("-301529235", new Object[]{this, str, Boolean.valueOf(z)});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            PlayParam playParam = new PlayParam();
            playParam.setUseSystemPlayer(z);
            playParam.setUrl(str);
            this.mPlayer.playVideo(playParam);
        }
    }

    private void playVidVideo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "963530857")) {
            ipChange.ipc$dispatch("963530857", new Object[]{this, str});
            return;
        }
        PlayParam playParam = new PlayParam();
        playParam.setVid(str);
        playParam.setDisableAd(true);
        this.mPlayer.playVideo(playParam);
    }

    @Override // cn.damai.player.base.IVideoPlayer
    public void autoPlay() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1752211718")) {
            ipChange.ipc$dispatch("-1752211718", new Object[]{this});
            return;
        }
        Log.e("DMVideoPlayerxw", "autoPlay :" + getTag());
        if (pj1.a(mu0.a())) {
            play();
            db1.b(TAG, "autoPlay :class" + this.mContext.getClass());
        }
    }

    public void disableAutoStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-461508972")) {
            ipChange.ipc$dispatch("-461508972", new Object[]{this});
        } else {
            this.autoStopByLocation = false;
        }
    }

    public void enableAutoStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1556841495")) {
            ipChange.ipc$dispatch("-1556841495", new Object[]{this});
            return;
        }
        this.autoStopByLocation = true;
        checkViewLocation();
    }

    @Override // cn.damai.player.base.IVideoPlayer
    public void enterFullScreen() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1964241114")) {
            ipChange.ipc$dispatch("1964241114", new Object[]{this});
        } else if (this.mCurrentMode == 15) {
        } else {
            qx2.e(this.mContext);
            qx2.f(this.mContext).setRequestedOrientation(0);
            removeView(this.mContainer);
            ((ViewGroup) qx2.f(this.mContext).findViewById(16908290)).addView(this.mContainer, new FrameLayout.LayoutParams(-1, -1));
            this.mCurrentMode = 15;
            this.mController.onPlayScreenModeChanged(15);
        }
    }

    @Override // cn.damai.player.base.IVideoPlayer
    public boolean exitFullScreen() {
        FrameLayout.LayoutParams layoutParams;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-181317848")) {
            return ((Boolean) ipChange.ipc$dispatch("-181317848", new Object[]{this})).booleanValue();
        }
        if (this.mCurrentMode == 15) {
            qx2.g(this.mContext);
            qx2.f(this.mContext).setRequestedOrientation(1);
            ((ViewGroup) qx2.f(this.mContext).findViewById(16908290)).removeView(this.mContainer);
            if (this.adaptHeight != 0 && this.adaptWidth != 0) {
                layoutParams = new FrameLayout.LayoutParams(this.adaptWidth, this.adaptHeight);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, this.videoPlayerHeight);
            }
            addView(this.mContainer, layoutParams);
            this.mCurrentMode = 14;
            this.mController.onPlayScreenModeChanged(14);
            return true;
        }
        return false;
    }

    public DMBaseVideoController getController() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1308333336") ? (DMBaseVideoController) ipChange.ipc$dispatch("1308333336", new Object[]{this}) : this.mController;
    }

    public int getCurrentState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1627508046")) {
            return ((Integer) ipChange.ipc$dispatch("-1627508046", new Object[]{this})).intValue();
        }
        PlayerEventListener playerEventListener = this.playerEventListener;
        if (playerEventListener != null) {
            return playerEventListener.e();
        }
        return -1;
    }

    @Override // cn.damai.player.base.IVideoPlayer
    public int getDuration() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-933261514")) {
            return ((Integer) ipChange.ipc$dispatch("-933261514", new Object[]{this})).intValue();
        }
        w01 w01Var = this.mPlayer;
        if (w01Var != null) {
            return w01Var.getDuration();
        }
        return 0;
    }

    public PlayerEventListener getEventListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-979850500") ? (PlayerEventListener) ipChange.ipc$dispatch("-979850500", new Object[]{this}) : this.playerEventListener;
    }

    @Override // cn.damai.player.base.IVideoPlayer
    public String getSessionId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2113479422")) {
            return (String) ipChange.ipc$dispatch("2113479422", new Object[]{this});
        }
        w01 w01Var = this.mPlayer;
        if (w01Var != null) {
            return w01Var.getSessionId();
        }
        return null;
    }

    @Override // cn.damai.player.base.IVideoPlayer
    public boolean isFullScreen() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1038923620") ? ((Boolean) ipChange.ipc$dispatch("-1038923620", new Object[]{this})).booleanValue() : this.mDataHolder.c().b();
    }

    @Override // cn.damai.player.base.IVideoPlayer
    public boolean isPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1870663643")) {
            return ((Boolean) ipChange.ipc$dispatch("-1870663643", new Object[]{this})).booleanValue();
        }
        xs xsVar = this.mDataHolder;
        if (xsVar == null || xsVar.c() == null) {
            return false;
        }
        return this.mDataHolder.c().c();
    }

    public boolean isPlayInited() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1185517196")) {
            return ((Boolean) ipChange.ipc$dispatch("-1185517196", new Object[]{this})).booleanValue();
        }
        w01 w01Var = this.mPlayer;
        if (w01Var != null) {
            return w01Var.a();
        }
        return false;
    }

    @Override // cn.damai.player.base.IVideoPlayer
    public boolean isPlaying() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-104043923")) {
            return ((Boolean) ipChange.ipc$dispatch("-104043923", new Object[]{this})).booleanValue();
        }
        xs xsVar = this.mDataHolder;
        if (xsVar == null || xsVar.c() == null) {
            return false;
        }
        return this.mDataHolder.c().d();
    }

    @Override // cn.damai.player.base.IVideoPlayer
    public void mute(int i) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "507046111")) {
            ipChange.ipc$dispatch("507046111", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        try {
            if (this.mPlayer != null) {
                Log.d(TAG, "mute: " + i);
                w01 w01Var = this.mPlayer;
                if (i != 0) {
                    z = false;
                }
                w01Var.setMuted(z);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1828092559")) {
            ipChange.ipc$dispatch("1828092559", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        this.isAttachedToWindow = true;
        Log.e("DMVideoPlayerxw", "onAttachedToWindow :" + getTag());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-754226702")) {
            ipChange.ipc$dispatch("-754226702", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.isAttachedToWindow = false;
        Log.e("DMVideoPlayerxw", "onDetachedFromWindow :" + getTag());
        pause(false);
    }

    @Override // cn.damai.network.OnNetWorkChangeListener
    public void onNetWorkChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1939303176")) {
            ipChange.ipc$dispatch("-1939303176", new Object[]{this});
            return;
        }
        xs xsVar = this.mDataHolder;
        if (xsVar == null || !xsVar.c().d()) {
            return;
        }
        ToastUtil.a().e(this.mContext, "当前处于非WIFI环境");
    }

    @Override // cn.damai.player.base.IVideoPlayer
    public void pause(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1741594915")) {
            ipChange.ipc$dispatch("-1741594915", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        db1.b(TAG, "pause :class" + this.mContext.getClass());
        xs xsVar = this.mDataHolder;
        if (xsVar != null) {
            if (z) {
                xsVar.c().f(11);
            } else {
                xsVar.c().f(4);
            }
        }
        w01 w01Var = this.mPlayer;
        if (w01Var != null) {
            w01Var.pause();
        }
        Log.d(TAG, "pause: " + z);
    }

    @Override // cn.damai.player.base.IVideoPlayer
    public void play() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1988610985")) {
            ipChange.ipc$dispatch("1988610985", new Object[]{this});
            return;
        }
        try {
            VideoInfo e = this.mDataHolder.e();
            VideoInfo.VideoType type = e.getType();
            if (type != null) {
                if (type == VideoInfo.VideoType.VIDEO_VID) {
                    Log.d(TAG, "play: " + e.getVid());
                    playVidVideo(e.getVid());
                } else if (type == VideoInfo.VideoType.VIDEO_URL) {
                    Log.d(TAG, "play: " + e.getVideoUrl());
                    playUrlVideo(e.getVideoUrl(), e.isUseNativePlayer());
                }
            } else if (getController() != null) {
                getController().stop();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // cn.damai.player.base.IVideoPlayer
    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "426754342")) {
            ipChange.ipc$dispatch("426754342", new Object[]{this});
            return;
        }
        if (this.mPlayer != null) {
            db1.b(TAG, "destory :class" + this.mContext.getClass());
            this.mPlayer.release();
        }
        NetStateChangeReceiver.a().d(this.mContext);
        NetStateChangeReceiver.a().c(null);
        ys ysVar = this.mPlayerManager;
        if (ysVar != null) {
            ysVar.h();
            this.mPlayerManager.l(null);
            this.mPlayerManager = null;
        }
        if (this.onScrollChangedListener != null) {
            getViewTreeObserver().removeOnScrollChangedListener(this.onScrollChangedListener);
            this.onScrollChangedListener = null;
        }
        PlayerEventListener playerEventListener = this.playerEventListener;
        if (playerEventListener != null) {
            playerEventListener.release();
            this.playerEventListener = null;
        }
        DMBaseVideoController dMBaseVideoController = this.mController;
        if (dMBaseVideoController != null) {
            dMBaseVideoController.destroy();
            this.mController = null;
        }
    }

    @Override // cn.damai.player.base.IVideoPlayer
    public void seek(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "634920382")) {
            ipChange.ipc$dispatch("634920382", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mPlayer != null) {
            Log.d(TAG, "seek: " + i);
            this.mPlayer.seekTo(i, true);
        }
    }

    public void setAutoAdaptVideoSize(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1156655086")) {
            ipChange.ipc$dispatch("-1156655086", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.autoAdaptSize = z;
        }
    }

    public void setController(DMBaseVideoController dMBaseVideoController) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2136809076")) {
            ipChange.ipc$dispatch("-2136809076", new Object[]{this, dMBaseVideoController});
            return;
        }
        this.mContainer.removeView(this.mController);
        this.mController = dMBaseVideoController;
        dMBaseVideoController.setPlayer(this);
        this.mDataHolder = new xs((FragmentActivity) this.mContext, this);
        ys d = ys.d();
        this.mPlayerManager = d;
        d.l(this.mDataHolder);
        this.mPlayerManager.i(this);
        this.mController.assembleLayers();
        NetStateChangeReceiver.a().b(this.mContext);
        NetStateChangeReceiver.a().c(this);
        this.mPlayer = this.mDataHolder.b();
        PlayerEventListener playerEventListener = new PlayerEventListener(this.mController, this.mDataHolder, this.mContext);
        this.playerEventListener = playerEventListener;
        if (this.autoAdaptSize) {
            playerEventListener.h(new a());
        }
        this.mPlayer.addPlayerEventListener(this.playerEventListener);
    }

    public void setOptHelper(PlayOptHelper playOptHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-310858823")) {
            ipChange.ipc$dispatch("-310858823", new Object[]{this, playOptHelper});
        } else if (playOptHelper != null) {
            this.mOptHelper = playOptHelper;
        }
    }

    @Override // cn.damai.player.base.IVideoPlayer
    public void setVideoData(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1216200532")) {
            ipChange.ipc$dispatch("-1216200532", new Object[]{this, videoInfo});
        } else if (this.mController == null) {
        } else {
            db1.b(TAG, "setVideoData :class" + this.mContext.getClass());
            this.mDataHolder.j(videoInfo);
            qx2.a(this.mPlayer.getView(), this.mContainer);
            qx2.a(this.mController, this.mContainer);
            this.mController.changeVideoData();
            autoPlay();
        }
    }

    public void setVideoPlayerSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2022829762")) {
            ipChange.ipc$dispatch("2022829762", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (this.mContainer != null) {
            this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(i, i2));
        }
    }

    @Override // cn.damai.player.base.IVideoPlayer
    public void start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "956754155")) {
            ipChange.ipc$dispatch("956754155", new Object[]{this});
            return;
        }
        Log.e("DMVideoPlayerxw", "start :" + getTag());
        if (this.mPlayer != null) {
            if (!isConditionSupportPlay()) {
                Log.e("DMVideoPlayerxw", "start error : isConditionSupportPlay false");
                return;
            }
            db1.b(TAG, "start :class" + this.mContext.getClass());
            this.mPlayer.start();
        }
    }

    @Override // cn.damai.player.base.IVideoPlayer
    public void stop() {
        xs xsVar;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "597849115")) {
            ipChange.ipc$dispatch("597849115", new Object[]{this});
            return;
        }
        if (this.mPlayer != null) {
            db1.b(TAG, "stop :class" + this.mContext.getClass());
            this.mPlayer.stop();
            DMBaseVideoController dMBaseVideoController = this.mController;
            if (dMBaseVideoController != null && dMBaseVideoController.getUTReportListener() != null && (xsVar = this.mDataHolder) != null && xsVar.e() != null) {
                this.mController.getUTReportListener().playEnd(this.mDataHolder.e().getVid(), this.mPlayer.getDuration());
            }
        }
        DMBaseVideoController dMBaseVideoController2 = this.mController;
        if (dMBaseVideoController2 != null) {
            dMBaseVideoController2.stop();
        }
    }

    public DMVideoPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentState = 0;
        this.mCurrentMode = 14;
        this.autoAdaptSize = false;
        this.adaptHeight = 0;
        this.adaptWidth = 0;
        this.autoStopByLocation = false;
        this.autoPaused = false;
        this.onScrollChangedListener = new b();
        this.mOptHelper = new fl1();
        this.mContext = context;
        init();
    }

    private void playUrlVideo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1375745095")) {
            ipChange.ipc$dispatch("1375745095", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            PlayParam playParam = new PlayParam();
            playParam.setUrl(str);
            this.mPlayer.playVideo(playParam);
        }
    }
}
