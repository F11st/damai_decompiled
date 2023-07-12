package cn.damai.player.video;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.video.NetStateReceiver;
import cn.damai.player.video.decor.BaseVideoUiFacade;
import cn.damai.player.video.decor.HomeVideoUiFacade;
import cn.damai.player.video.listener.VideoListener;
import cn.damai.player.video.opt.PlayOptHelper;
import cn.damai.player.video.view.ApiPlayer;
import cn.damai.player.video.view.FadeVideoView;
import cn.damai.player.video.view.VideoView;
import cn.damai.videoplayer.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.NetworkInfoProviderProxy;
import tb.fl1;
import tb.mu0;
import tb.pj1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ProxyVideoView extends FrameLayout implements ApiPlayer, Runnable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int POST_DELAY = 200;
    private static final float[] sHwRatioArray = {0.5625f, 0.75f};
    private final String NET_TIP;
    private boolean isAttachedToWindow;
    private final boolean isAutoplayJustInWifi;
    private boolean isSetRealVideoPlayer;
    private boolean isToasted;
    private ApiPlayer mApiPlayer;
    private VideoInfo mCurrentInfo;
    private String mFullFadeClassName;
    private Handler mHandler;
    private NetStateReceiver.OnNetStateChangeListener mListener;
    private PlayOptHelper mOptHelper;
    private VideoInfo mTarget;
    public final float mVideoHWRate;
    private VideoListener mVideoListener;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class a implements NetStateReceiver.OnNetStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.player.video.NetStateReceiver.OnNetStateChangeListener
        public void onNetWorkChanged() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "89812374")) {
                ipChange.ipc$dispatch("89812374", new Object[]{this});
            } else if (ProxyVideoView.this.isPlaying()) {
                ToastUtil.a().e(mu0.a(), "当前处于非WIFI环境");
            }
        }
    }

    public ProxyVideoView(@NonNull Context context) {
        this(context, null);
    }

    private void ensureAddRealPlayerOnce() {
        Context context;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-707739175")) {
            ipChange.ipc$dispatch("-707739175", new Object[]{this});
        } else if (this.isSetRealVideoPlayer || (context = getContext()) == null) {
        } else {
            this.isSetRealVideoPlayer = true;
            removeAllViews();
            VideoView videoView = new VideoView(context);
            videoView.setCurrentHWRate(this.mVideoHWRate);
            this.mApiPlayer = videoView;
            videoView.setUiFacade(obtainUiFade(videoView));
            videoView.setListener(this.mVideoListener);
            addView(videoView, -1, -2);
        }
    }

    private boolean isConditionSupportPlay() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1452432544") ? ((Boolean) ipChange.ipc$dispatch("1452432544", new Object[]{this})).booleanValue() : this.isAutoplayJustInWifi ? this.mCurrentInfo != null && this.isAttachedToWindow && pj1.a(mu0.a()) && this.mOptHelper.isOutConditionSupportPlay() : this.mCurrentInfo != null && this.isAttachedToWindow && this.mOptHelper.isOutConditionSupportPlay();
    }

    private BaseVideoUiFacade obtainUiFade(ApiPlayer apiPlayer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1233773542")) {
            return (BaseVideoUiFacade) ipChange.ipc$dispatch("-1233773542", new Object[]{this, apiPlayer});
        }
        BaseVideoUiFacade baseVideoUiFacade = null;
        try {
            if (!TextUtils.isEmpty(this.mFullFadeClassName)) {
                baseVideoUiFacade = (BaseVideoUiFacade) Class.forName(this.mFullFadeClassName).getConstructor(ApiPlayer.class).newInstance(apiPlayer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baseVideoUiFacade == null ? new HomeVideoUiFacade(apiPlayer) : baseVideoUiFacade;
    }

    private void removeRunnable(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1845122379")) {
            ipChange.ipc$dispatch("1845122379", new Object[]{this, runnable});
        } else {
            this.mHandler.removeCallbacks(runnable);
        }
    }

    private void runnablePost(Runnable runnable, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1276920204")) {
            ipChange.ipc$dispatch("-1276920204", new Object[]{this, runnable, Integer.valueOf(i)});
        } else {
            this.mHandler.postDelayed(runnable, i);
        }
    }

    public void autoPlay() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1503346421")) {
            ipChange.ipc$dispatch("-1503346421", new Object[]{this});
            return;
        }
        removeRunnable(this);
        runnablePost(this, 200);
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public int getDuration() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-100751483") ? ((Integer) ipChange.ipc$dispatch("-100751483", new Object[]{this})).intValue() : this.mApiPlayer.getDuration();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public VideoInfo getPlayInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1884279524") ? (VideoInfo) ipChange.ipc$dispatch("1884279524", new Object[]{this}) : this.mApiPlayer.getPlayInfo();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public String getSessionId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1768528499") ? (String) ipChange.ipc$dispatch("-1768528499", new Object[]{this}) : this.mApiPlayer.getSessionId();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void idle(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2036388428")) {
            ipChange.ipc$dispatch("2036388428", new Object[]{this, videoInfo});
        } else {
            this.mApiPlayer.idle(videoInfo);
        }
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public boolean isMute() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1388248687") ? ((Boolean) ipChange.ipc$dispatch("1388248687", new Object[]{this})).booleanValue() : this.mApiPlayer.isMute();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public boolean isPaused() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1905347718") ? ((Boolean) ipChange.ipc$dispatch("-1905347718", new Object[]{this})).booleanValue() : this.mApiPlayer.isPaused();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public boolean isPlaying() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-979154308") ? ((Boolean) ipChange.ipc$dispatch("-979154308", new Object[]{this})).booleanValue() : this.mApiPlayer.isPlaying();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void mute(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-639080385")) {
            ipChange.ipc$dispatch("-639080385", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mApiPlayer.mute(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "623459168")) {
            ipChange.ipc$dispatch("623459168", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        this.isAttachedToWindow = true;
        autoPlay();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1234254467")) {
            ipChange.ipc$dispatch("1234254467", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.isAttachedToWindow = false;
        this.mApiPlayer.pause();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void pause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-232493466")) {
            ipChange.ipc$dispatch("-232493466", new Object[]{this});
            return;
        }
        removeRunnable(this);
        this.mApiPlayer.pause();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void play(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-794543380")) {
            ipChange.ipc$dispatch("-794543380", new Object[]{this, videoInfo});
            return;
        }
        removeRunnable(this);
        this.mCurrentInfo = videoInfo;
        this.mTarget = null;
        this.mApiPlayer.idle(videoInfo);
        if (this.isAutoplayJustInWifi) {
            if (pj1.a(mu0.a())) {
                run();
                return;
            }
            return;
        }
        run();
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1504880395")) {
            ipChange.ipc$dispatch("-1504880395", new Object[]{this});
            return;
        }
        removeRunnable(this);
        this.mApiPlayer.release();
        NetStateReceiver.b().d(this.mListener);
    }

    @Override // java.lang.Runnable
    public void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-894626959")) {
            ipChange.ipc$dispatch("-894626959", new Object[]{this});
        } else if (isConditionSupportPlay()) {
            ensureAddRealPlayerOnce();
            if (this.mTarget == null) {
                this.mTarget = this.mCurrentInfo;
                if (!this.isAutoplayJustInWifi && NetworkInfoProviderProxy.isMobileWithCache() && !this.isToasted) {
                    ToastUtil.a().e(mu0.a(), "当前处于非WIFI环境");
                    this.isToasted = true;
                }
                this.mApiPlayer.play(this.mTarget);
                return;
            }
            boolean isPaused = this.mApiPlayer.isPaused();
            boolean isPlaying = this.mApiPlayer.isPlaying();
            if (!isPaused && !isPlaying) {
                VideoInfo videoInfo = this.mCurrentInfo;
                this.mTarget = videoInfo;
                this.mApiPlayer.play(videoInfo);
                return;
            }
            this.mApiPlayer.start();
        }
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void setListener(VideoListener videoListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2049669338")) {
            ipChange.ipc$dispatch("2049669338", new Object[]{this, videoListener});
            return;
        }
        this.mVideoListener = videoListener;
        this.mApiPlayer.setListener(videoListener);
    }

    public void setOptHelper(PlayOptHelper playOptHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1981091512")) {
            ipChange.ipc$dispatch("-1981091512", new Object[]{this, playOptHelper});
        } else if (playOptHelper != null) {
            this.mOptHelper = playOptHelper;
        }
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-334138823")) {
            ipChange.ipc$dispatch("-334138823", new Object[]{this, videoInfo});
            return;
        }
        this.mCurrentInfo = videoInfo;
        this.mTarget = null;
        idle(videoInfo);
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-189388678")) {
            ipChange.ipc$dispatch("-189388678", new Object[]{this});
        } else {
            run();
        }
    }

    @Override // cn.damai.player.video.view.ApiPlayer
    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1101691220")) {
            ipChange.ipc$dispatch("-1101691220", new Object[]{this});
            return;
        }
        removeRunnable(this);
        this.mApiPlayer.stop();
    }

    public ProxyVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProxyVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isSetRealVideoPlayer = false;
        this.mOptHelper = new fl1();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.isToasted = false;
        this.NET_TIP = "当前处于非WIFI环境";
        this.mListener = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ProxyVideoView);
        int i2 = R$styleable.ProxyVideoView_fade_full_class_name;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.mFullFadeClassName = obtainStyledAttributes.getString(i2);
        }
        this.isAutoplayJustInWifi = obtainStyledAttributes.getBoolean(R$styleable.ProxyVideoView_auto_play_only_wifi, true);
        int i3 = obtainStyledAttributes.getInt(R$styleable.ProxyVideoView_video_h_w_rate, -1);
        if (i3 >= 0) {
            float[] fArr = sHwRatioArray;
            if (i3 < fArr.length) {
                this.mVideoHWRate = fArr[i3];
                obtainStyledAttributes.recycle();
                FadeVideoView fadeVideoView = new FadeVideoView(context);
                fadeVideoView.setCurrentHWRate(this.mVideoHWRate);
                fadeVideoView.setFacade(obtainUiFade(fadeVideoView));
                this.mApiPlayer = fadeVideoView;
                addView(fadeVideoView, -1, -2);
                NetStateReceiver.b().c(this.mListener);
            }
        }
        this.mVideoHWRate = 0.5625f;
        obtainStyledAttributes.recycle();
        FadeVideoView fadeVideoView2 = new FadeVideoView(context);
        fadeVideoView2.setCurrentHWRate(this.mVideoHWRate);
        fadeVideoView2.setFacade(obtainUiFade(fadeVideoView2));
        this.mApiPlayer = fadeVideoView2;
        addView(fadeVideoView2, -1, -2);
        NetStateReceiver.b().c(this.mListener);
    }
}
