package cn.damai.player.controller;

import android.media.ThumbnailUtils;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import cn.damai.common.image.C0504a;
import cn.damai.player.base.IVideoController;
import cn.damai.player.base.IVideoPlayer;
import cn.damai.player.listener.OnPlayerUTReportListener;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.irecycler.widget.LoadingView;
import cn.damai.videoplayer.R$color;
import cn.damai.videoplayer.R$id;
import cn.damai.videoplayer.R$layout;
import cn.damai.videoplayer.R$string;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.qx2;
import tb.t60;
import tb.xr;
import tb.xs;
import tb.ys;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class DMVideoPlayerDefaultBottomView extends FrameLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isSeeking;
    private FragmentActivity mActivity;
    private DMIconFontTextView mAllScreenBtn;
    private DMIconFontTextView mBoFangBtn;
    private IVideoController mController;
    private ImageView mCoverImg;
    private ImageView mCoverPauseImg;
    private xs mDataHolder;
    private TextView mDuration;
    private HandlerC1497a mHandler;
    private AtomicBoolean mHasDone;
    private LoadingView mLoading;
    private IVideoPlayer mPlayer;
    private FrameLayout mPlayerBottomBarContainer;
    private TextView mPosition;
    private SeekBar mSeekBar;
    private OnPlayerUTReportListener mUTReportListener;
    private String mVid;
    private int mVoice;
    private DMIconFontTextView mVoiceBtn;
    private int position;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.player.controller.DMVideoPlayerDefaultBottomView$a */
    /* loaded from: classes15.dex */
    public class HandlerC1497a extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        HandlerC1497a() {
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-524366575")) {
                ipChange.ipc$dispatch("-524366575", new Object[]{this, message});
                return;
            }
            super.dispatchMessage(message);
            DMVideoPlayerDefaultBottomView.this.mPlayerBottomBarContainer.setVisibility(8);
        }
    }

    public DMVideoPlayerDefaultBottomView(FragmentActivity fragmentActivity, IVideoPlayer iVideoPlayer) {
        super(fragmentActivity);
        this.mVoice = 1;
        this.mHasDone = new AtomicBoolean(false);
        this.mActivity = fragmentActivity;
        this.mPlayer = iVideoPlayer;
        this.mDataHolder = ys.d().c();
        initView(fragmentActivity);
    }

    private void fullscreen() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "52797440")) {
            ipChange.ipc$dispatch("52797440", new Object[]{this});
            return;
        }
        OnPlayerUTReportListener onPlayerUTReportListener = this.mUTReportListener;
        if (onPlayerUTReportListener != null) {
            onPlayerUTReportListener.fullScreenBtnClick(this.mVid);
        }
        this.mController.onScreenModeChanged(true);
        this.mPlayer.enterFullScreen();
        bottomBarDelayHide();
    }

    private void initView(FragmentActivity fragmentActivity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-831244145")) {
            ipChange.ipc$dispatch("-831244145", new Object[]{this, fragmentActivity});
            return;
        }
        View inflate = LayoutInflater.from(fragmentActivity).inflate(R$layout.yk_player_handler_layout, this);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R$id.yk_bottom_bar_layout);
        this.mPlayerBottomBarContainer = frameLayout;
        this.mBoFangBtn = (DMIconFontTextView) frameLayout.findViewById(R$id.yk_player_bf_btn);
        this.mPosition = (TextView) this.mPlayerBottomBarContainer.findViewById(R$id.yk_bf_allready_time);
        this.mSeekBar = (SeekBar) this.mPlayerBottomBarContainer.findViewById(R$id.yk_player_seekbar);
        this.mDuration = (TextView) this.mPlayerBottomBarContainer.findViewById(R$id.yk_bf_all_time);
        this.mVoiceBtn = (DMIconFontTextView) this.mPlayerBottomBarContainer.findViewById(R$id.yk_player_voice_btn);
        this.mAllScreenBtn = (DMIconFontTextView) this.mPlayerBottomBarContainer.findViewById(R$id.yk_player_fullscreen_btn);
        this.mLoading = (LoadingView) inflate.findViewById(R$id.yk_player_loading);
        this.mCoverImg = (ImageView) inflate.findViewById(R$id.yk_player_video_cover);
        ImageView imageView = (ImageView) inflate.findViewById(R$id.yk_player_video_bofang_btn);
        this.mCoverPauseImg = imageView;
        imageView.setOnClickListener(this);
        this.mHandler = new HandlerC1497a();
        this.mBoFangBtn.setOnClickListener(this);
        this.mVoiceBtn.setOnClickListener(this);
        this.mAllScreenBtn.setOnClickListener(this);
        this.mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: cn.damai.player.controller.DMVideoPlayerDefaultBottomView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "758282602")) {
                    ipChange2.ipc$dispatch("758282602", new Object[]{this, seekBar, Integer.valueOf(i), Boolean.valueOf(z)});
                } else {
                    DMVideoPlayerDefaultBottomView.this.progressChanged(z, i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2142730626")) {
                    ipChange2.ipc$dispatch("2142730626", new Object[]{this, seekBar});
                } else {
                    DMVideoPlayerDefaultBottomView.this.startTrackingTouch();
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1557639930")) {
                    ipChange2.ipc$dispatch("1557639930", new Object[]{this, seekBar});
                } else {
                    DMVideoPlayerDefaultBottomView.this.stopTrackingTouch(seekBar.getProgress());
                }
            }
        });
    }

    private void playOrPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-562731600")) {
            ipChange.ipc$dispatch("-562731600", new Object[]{this});
        } else if (this.mDataHolder.c().d()) {
            pause();
        } else if (this.mDataHolder.c().c()) {
            start();
        } else {
            play(this.mVid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void progressChanged(boolean z, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1003397271")) {
            ipChange.ipc$dispatch("1003397271", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i)});
        } else if (z) {
            this.mPosition.setText(qx2.h(i));
        }
    }

    private void setDuration() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1097689543")) {
            ipChange.ipc$dispatch("-1097689543", new Object[]{this});
            return;
        }
        int duration = this.mDataHolder.b().getDuration();
        if (duration != 0 && this.mHasDone.compareAndSet(false, true)) {
            this.mDuration.setText(qx2.h(duration));
            this.mSeekBar.setMax(duration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTrackingTouch() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1135982677")) {
            ipChange.ipc$dispatch("1135982677", new Object[]{this});
            return;
        }
        this.isSeeking = true;
        this.mHandler.removeMessages(1);
        xr.c("remove_show_message", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopTrackingTouch(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-778641094")) {
            ipChange.ipc$dispatch("-778641094", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.isSeeking = false;
        IVideoPlayer iVideoPlayer = this.mPlayer;
        if (iVideoPlayer != null) {
            iVideoPlayer.seek(i);
        }
        this.mSeekBar.setProgress(i);
        OnPlayerUTReportListener onPlayerUTReportListener = this.mUTReportListener;
        if (onPlayerUTReportListener != null) {
            onPlayerUTReportListener.onSeekBarClick(this.mVid);
        }
        xr.c("topbar_delay_hide", null);
        bottomBarDelayHide();
    }

    private void voice() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-715999459")) {
            ipChange.ipc$dispatch("-715999459", new Object[]{this});
            return;
        }
        int i = 1 - this.mVoice;
        this.mVoice = i;
        if (i == 1) {
            this.mVoiceBtn.setText(this.mActivity.getText(R$string.iconfont_shengyinkai22));
            OnPlayerUTReportListener onPlayerUTReportListener = this.mUTReportListener;
            if (onPlayerUTReportListener != null) {
                onPlayerUTReportListener.onMuteBtnClick(this.mVid, 1);
            }
        } else {
            this.mVoiceBtn.setText(this.mActivity.getText(R$string.iconfont_shengyinguan22));
            OnPlayerUTReportListener onPlayerUTReportListener2 = this.mUTReportListener;
            if (onPlayerUTReportListener2 != null) {
                onPlayerUTReportListener2.onMuteBtnClick(this.mVid, 0);
            }
        }
        IVideoPlayer iVideoPlayer = this.mPlayer;
        if (iVideoPlayer != null) {
            iVideoPlayer.mute(this.mVoice);
        }
        bottomBarDelayHide();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bottomBarDelayHide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1188993566")) {
            ipChange.ipc$dispatch("1188993566", new Object[]{this});
            return;
        }
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
    }

    protected int getCurrentPosition() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-363383678") ? ((Integer) ipChange.ipc$dispatch("-363383678", new Object[]{this})).intValue() : this.position;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideOrShowBottomBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1829061207")) {
            ipChange.ipc$dispatch("-1829061207", new Object[]{this});
        } else if (this.mDataHolder.c().a() == 5 || this.mDataHolder.c().a() == 4 || this.mDataHolder.c().a() == 11) {
            if (this.mPlayerBottomBarContainer.getVisibility() == 8) {
                this.mPlayerBottomBarContainer.setVisibility(0);
                xr.c("topbar_show", null);
                bottomBarDelayHide();
                return;
            }
            this.mPlayerBottomBarContainer.setVisibility(8);
            xr.c("topbar_hide", null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1016209292")) {
            ipChange.ipc$dispatch("1016209292", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.yk_player_bf_btn) {
            playOrPause();
        } else if (id == R$id.yk_player_voice_btn) {
            voice();
        } else if (id == R$id.yk_player_fullscreen_btn) {
            fullscreen();
        } else if (id == R$id.yk_player_video_bofang_btn) {
            if (this.mDataHolder.c().a() == 7) {
                rePlay();
            } else {
                play(this.mVid);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCurrentPositionChange(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1220656185")) {
            ipChange.ipc$dispatch("-1220656185", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.position = i;
        setDuration();
        if (this.isSeeking) {
            return;
        }
        this.mSeekBar.setProgress(this.position);
        this.mPosition.setText(qx2.h(this.position));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLoadingEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "656007709")) {
            ipChange.ipc$dispatch("656007709", new Object[]{this});
            return;
        }
        this.mLoading.setVisibility(8);
        setDuration();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLoadingStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1292543882")) {
            ipChange.ipc$dispatch("-1292543882", new Object[]{this});
        } else {
            this.mLoading.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1472117069")) {
            ipChange.ipc$dispatch("1472117069", new Object[]{this});
            return;
        }
        this.mLoading.setVisibility(0);
        this.mCoverPauseImg.setVisibility(4);
        this.mPlayerBottomBarContainer.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPlayerCompletion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1218374529")) {
            ipChange.ipc$dispatch("-1218374529", new Object[]{this});
            return;
        }
        this.mLoading.setVisibility(8);
        this.mCoverImg.setVisibility(0);
        this.mCoverPauseImg.setVisibility(0);
        this.mPlayerBottomBarContainer.setVisibility(8);
        OnPlayerUTReportListener onPlayerUTReportListener = this.mUTReportListener;
        if (onPlayerUTReportListener != null) {
            onPlayerUTReportListener.playEnd(this.mVid, this.position);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPlayerPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1349285991")) {
            ipChange.ipc$dispatch("-1349285991", new Object[]{this});
        } else {
            this.mBoFangBtn.setText(this.mActivity.getText(R$string.iconfont_bofang22));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPlayerPrepared() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1814617598")) {
            ipChange.ipc$dispatch("1814617598", new Object[]{this});
        }
    }

    protected void onPlayerPreparing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "544197067")) {
            ipChange.ipc$dispatch("544197067", new Object[]{this});
            return;
        }
        this.mLoading.setVisibility(8);
        this.mCoverImg.setVisibility(4);
        this.mCoverPauseImg.setVisibility(4);
        this.mPlayerBottomBarContainer.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPlayerRealVideoStart() {
        xs xsVar;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "221392854")) {
            ipChange.ipc$dispatch("221392854", new Object[]{this});
            return;
        }
        if (this.mUTReportListener != null && (xsVar = this.mDataHolder) != null && xsVar.e() != null) {
            this.mUTReportListener.playStart(this.mDataHolder.e().getVid());
        }
        this.mBoFangBtn.setText(this.mActivity.getText(R$string.iconfont_zanting22));
        this.mLoading.setVisibility(8);
        this.mCoverImg.setVisibility(4);
        this.mCoverPauseImg.setVisibility(4);
        this.mPlayerBottomBarContainer.setVisibility(0);
        bottomBarDelayHide();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPlayerRelease() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1000672920")) {
            ipChange.ipc$dispatch("-1000672920", new Object[]{this});
            return;
        }
        this.mLoading.setVisibility(8);
        this.mCoverImg.setVisibility(0);
        this.mPlayerBottomBarContainer.setVisibility(4);
    }

    protected void onPlayerStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1306181203")) {
            ipChange.ipc$dispatch("-1306181203", new Object[]{this});
        } else {
            this.mBoFangBtn.setText(this.mActivity.getText(R$string.iconfont_zanting22));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onReloadSo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1386468281")) {
            ipChange.ipc$dispatch("-1386468281", new Object[]{this});
            return;
        }
        this.mLoading.setVisibility(0);
        this.mCoverPauseImg.setVisibility(4);
        this.mPlayerBottomBarContainer.setVisibility(4);
    }

    protected void pause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1764750375")) {
            ipChange.ipc$dispatch("-1764750375", new Object[]{this});
            return;
        }
        this.mPlayer.pause(true);
        bottomBarDelayHide();
        OnPlayerUTReportListener onPlayerUTReportListener = this.mUTReportListener;
        if (onPlayerUTReportListener != null) {
            onPlayerUTReportListener.onPauseOrPlayClick(this.mVid, 11);
        }
    }

    protected void play(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2127119473")) {
            ipChange.ipc$dispatch("2127119473", new Object[]{this, str});
            return;
        }
        IVideoPlayer iVideoPlayer = this.mPlayer;
        if (iVideoPlayer != null) {
            iVideoPlayer.play();
        }
        bottomBarDelayHide();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void playViewGone() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-79516445")) {
            ipChange.ipc$dispatch("-79516445", new Object[]{this});
            return;
        }
        if (this.mCoverImg.getVisibility() == 0) {
            this.mCoverImg.setVisibility(4);
        }
        if (this.mCoverPauseImg.getVisibility() == 0) {
            this.mCoverPauseImg.setVisibility(4);
        }
    }

    protected void rePlay() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1509093172")) {
            ipChange.ipc$dispatch("1509093172", new Object[]{this});
        } else {
            this.mPlayer.play();
        }
    }

    public void refresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "365304404")) {
            ipChange.ipc$dispatch("365304404", new Object[]{this});
            return;
        }
        if (this.mDataHolder.e() != null) {
            if (!TextUtils.isEmpty(this.mDataHolder.e().getPicUrl())) {
                C0504a.b().c(this.mDataHolder.e().getPicUrl()).c(R$color.color_111111).g(this.mCoverImg);
            } else if ("1".equals(this.mDataHolder.e().getVideoThumbnailType()) && !TextUtils.isEmpty(this.mDataHolder.e().getVideoUrl())) {
                try {
                    this.mCoverImg.setImageBitmap(ThumbnailUtils.createVideoThumbnail(this.mDataHolder.e().getVideoUrl(), 1));
                } catch (Exception unused) {
                }
            }
        }
        this.mVid = this.mDataHolder.e().getVid();
    }

    public void registerUTReporter(OnPlayerUTReportListener onPlayerUTReportListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-587391814")) {
            ipChange.ipc$dispatch("-587391814", new Object[]{this, onPlayerUTReportListener});
        } else {
            this.mUTReportListener = onPlayerUTReportListener;
        }
    }

    public void screenModeChange(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1616391592")) {
            ipChange.ipc$dispatch("-1616391592", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mAllScreenBtn.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            layoutParams.width = 0;
            layoutParams.height = 0;
            this.mAllScreenBtn.setLayoutParams(layoutParams);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mAllScreenBtn.getLayoutParams();
            layoutParams2.setMargins(0, 0, t60.a(this.mActivity, 15.0f), 0);
            layoutParams2.width = t60.a(this.mActivity, 18.0f);
            layoutParams2.height = t60.a(this.mActivity, 18.0f);
            this.mAllScreenBtn.setLayoutParams(layoutParams2);
        }
    }

    public void setIVideoController(IVideoController iVideoController) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-113228311")) {
            ipChange.ipc$dispatch("-113228311", new Object[]{this, iVideoController});
        } else {
            this.mController = iVideoController;
        }
    }

    protected void start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1721645587")) {
            ipChange.ipc$dispatch("-1721645587", new Object[]{this});
            return;
        }
        IVideoPlayer iVideoPlayer = this.mPlayer;
        if (iVideoPlayer != null) {
            iVideoPlayer.start();
        }
        bottomBarDelayHide();
        OnPlayerUTReportListener onPlayerUTReportListener = this.mUTReportListener;
        if (onPlayerUTReportListener != null) {
            onPlayerUTReportListener.onPauseOrPlayClick(this.mVid, 5);
        }
    }

    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1982402855")) {
            ipChange.ipc$dispatch("-1982402855", new Object[]{this});
            return;
        }
        this.mLoading.setVisibility(8);
        this.mCoverPauseImg.setVisibility(0);
        this.mCoverImg.setVisibility(0);
        this.mPlayerBottomBarContainer.setVisibility(4);
    }
}
