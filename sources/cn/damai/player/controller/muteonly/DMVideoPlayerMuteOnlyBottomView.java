package cn.damai.player.controller.muteonly;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import cn.damai.common.image.a;
import cn.damai.common.util.ToastUtil;
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
import tb.wh2;
import tb.xj1;
import tb.xs;
import tb.ys;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class DMVideoPlayerMuteOnlyBottomView extends FrameLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private FragmentActivity mActivity;
    private IVideoController mController;
    private ImageView mCoverImg;
    private ImageView mCoverPauseImg;
    private xs mDataHolder;
    private LoadingView mLoading;
    private IVideoPlayer mPlayer;
    private OnPlayerUTReportListener mUTReportListener;
    private String mVid;
    private int mVoice;
    private DMIconFontTextView mVoiceBtn;
    private int position;

    public DMVideoPlayerMuteOnlyBottomView(FragmentActivity fragmentActivity, IVideoPlayer iVideoPlayer) {
        super(fragmentActivity);
        this.mVoice = 1;
        this.mActivity = fragmentActivity;
        this.mPlayer = iVideoPlayer;
        this.mDataHolder = ys.d().c();
        initView(fragmentActivity);
    }

    private void initView(FragmentActivity fragmentActivity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1795573777")) {
            ipChange.ipc$dispatch("-1795573777", new Object[]{this, fragmentActivity});
            return;
        }
        View inflate = LayoutInflater.from(fragmentActivity).inflate(R$layout.yk_player_muteonly_bottom_layout, this);
        this.mVoiceBtn = (DMIconFontTextView) inflate.findViewById(R$id.yk_player_voice_btn);
        this.mLoading = (LoadingView) inflate.findViewById(R$id.yk_player_loading);
        this.mCoverImg = (ImageView) inflate.findViewById(R$id.yk_player_video_cover);
        ImageView imageView = (ImageView) inflate.findViewById(R$id.yk_player_video_bofang_btn);
        this.mCoverPauseImg = imageView;
        imageView.setOnClickListener(this);
        this.mVoiceBtn.setOnClickListener(this);
    }

    private void playOrPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-548386224")) {
            ipChange.ipc$dispatch("-548386224", new Object[]{this});
        } else if (this.mDataHolder.c().d()) {
            pause();
        } else if (this.mDataHolder.c().c()) {
            start();
        } else {
            play(this.mVid);
        }
    }

    private void showTipIfNotWifi() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "671103854")) {
            ipChange.ipc$dispatch("671103854", new Object[]{this});
        } else if (xj1.c(getContext())) {
        } else {
            ToastUtil.a().j(getContext(), "当前非Wi-Fi播放，请注意流量消耗");
        }
    }

    private void voice() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1159883843")) {
            ipChange.ipc$dispatch("-1159883843", new Object[]{this});
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
    }

    protected int getCurrentPosition() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1729111070") ? ((Integer) ipChange.ipc$dispatch("-1729111070", new Object[]{this})).intValue() : this.position;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "289236716")) {
            ipChange.ipc$dispatch("289236716", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.yk_player_voice_btn) {
            voice();
        } else if (id == R$id.yk_player_video_bofang_btn) {
            if (this.mDataHolder.c().a() == 7) {
                rePlay();
            } else if (this.mDataHolder.c().c()) {
                start();
            } else {
                play(this.mVid);
                showTipIfNotWifi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLoadingEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1100714365")) {
            ipChange.ipc$dispatch("1100714365", new Object[]{this});
        } else {
            this.mLoading.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLoadingStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "868790230")) {
            ipChange.ipc$dispatch("868790230", new Object[]{this});
        } else {
            this.mLoading.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1916823725")) {
            ipChange.ipc$dispatch("1916823725", new Object[]{this});
            return;
        }
        this.mLoading.setVisibility(0);
        this.mCoverPauseImg.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPlayerCompletion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1710865375")) {
            ipChange.ipc$dispatch("1710865375", new Object[]{this});
            return;
        }
        this.mPlayer.mute(this.mVoice);
        this.mLoading.setVisibility(8);
        this.mCoverImg.setVisibility(0);
        this.mCoverPauseImg.setVisibility(0);
        this.mVoiceBtn.setVisibility(4);
        OnPlayerUTReportListener onPlayerUTReportListener = this.mUTReportListener;
        if (onPlayerUTReportListener != null) {
            onPlayerUTReportListener.playEnd(this.mVid, this.position);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPlayerPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-448281543")) {
            ipChange.ipc$dispatch("-448281543", new Object[]{this});
            return;
        }
        this.mCoverPauseImg.setVisibility(0);
        this.mVoiceBtn.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPlayerPrepared() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "92527966")) {
            ipChange.ipc$dispatch("92527966", new Object[]{this});
        }
    }

    protected void onPlayerPreparing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1300973973")) {
            ipChange.ipc$dispatch("-1300973973", new Object[]{this});
            return;
        }
        this.mLoading.setVisibility(8);
        this.mCoverImg.setVisibility(4);
        this.mCoverPauseImg.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPlayerRealVideoStart() {
        xs xsVar;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-429381834")) {
            ipChange.ipc$dispatch("-429381834", new Object[]{this});
            return;
        }
        if (this.mUTReportListener != null && (xsVar = this.mDataHolder) != null && xsVar.e() != null) {
            this.mUTReportListener.playStart(this.mDataHolder.e().getVid());
        }
        this.mPlayer.mute(this.mVoice);
        this.mLoading.setVisibility(8);
        this.mCoverImg.setVisibility(4);
        this.mCoverPauseImg.setVisibility(4);
        this.mVoiceBtn.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPlayerRelease() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1576175112")) {
            ipChange.ipc$dispatch("1576175112", new Object[]{this});
            return;
        }
        this.mLoading.setVisibility(8);
        this.mCoverImg.setVisibility(0);
    }

    protected void onPlayerStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-405176755")) {
            ipChange.ipc$dispatch("-405176755", new Object[]{this});
        } else {
            this.mVoiceBtn.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onReloadSo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "692204455")) {
            ipChange.ipc$dispatch("692204455", new Object[]{this});
            return;
        }
        this.mLoading.setVisibility(0);
        this.mCoverPauseImg.setVisibility(4);
    }

    protected void pause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2086332537")) {
            ipChange.ipc$dispatch("2086332537", new Object[]{this});
            return;
        }
        this.mPlayer.pause(true);
        OnPlayerUTReportListener onPlayerUTReportListener = this.mUTReportListener;
        if (onPlayerUTReportListener != null) {
            onPlayerUTReportListener.onPauseOrPlayClick(this.mVid, 11);
        }
    }

    protected void play(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1476344785")) {
            ipChange.ipc$dispatch("1476344785", new Object[]{this, str});
            return;
        }
        IVideoPlayer iVideoPlayer = this.mPlayer;
        if (iVideoPlayer != null) {
            iVideoPlayer.play();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void playViewGone() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "365190211")) {
            ipChange.ipc$dispatch("365190211", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "633579156")) {
            ipChange.ipc$dispatch("633579156", new Object[]{this});
        } else {
            this.mPlayer.play();
        }
    }

    public void refresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1005826316")) {
            ipChange.ipc$dispatch("-1005826316", new Object[]{this});
            return;
        }
        if (this.mDataHolder.e() != null && !TextUtils.isEmpty(this.mDataHolder.e().getPicUrl())) {
            a.b().c(this.mDataHolder.e().getPicUrl()).c(R$color.color_111111).g(this.mCoverImg);
        }
        this.mVid = this.mDataHolder.e().getVid();
    }

    public void registerUTReporter(OnPlayerUTReportListener onPlayerUTReportListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1789724326")) {
            ipChange.ipc$dispatch("-1789724326", new Object[]{this, onPlayerUTReportListener});
        } else {
            this.mUTReportListener = onPlayerUTReportListener;
        }
    }

    public void setCoverImgUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2101275172")) {
            ipChange.ipc$dispatch("2101275172", new Object[]{this, str});
        } else if (wh2.j(str)) {
        } else {
            a.b().c(str).g(this.mCoverImg);
        }
    }

    public void setIVideoController(IVideoController iVideoController) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1744178505")) {
            ipChange.ipc$dispatch("1744178505", new Object[]{this, iVideoController});
        } else {
            this.mController = iVideoController;
        }
    }

    public void setPlayerMute(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1562515745")) {
            ipChange.ipc$dispatch("1562515745", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        int i = !z ? 1 : 0;
        if (i == this.mVoice) {
            return;
        }
        this.mVoice = i;
        IVideoPlayer iVideoPlayer = this.mPlayer;
        if (iVideoPlayer != null) {
            iVideoPlayer.mute(i);
        }
        if (this.mVoice == 1) {
            this.mVoiceBtn.setText(R$string.iconfont_shengyinkai22);
        } else {
            this.mVoiceBtn.setText(R$string.iconfont_shengyinguan22);
        }
    }

    public void setVideoCoverClickListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1479115812")) {
            ipChange.ipc$dispatch("-1479115812", new Object[]{this, onClickListener});
            return;
        }
        ImageView imageView = this.mCoverImg;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    protected void start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2129437325")) {
            ipChange.ipc$dispatch("2129437325", new Object[]{this});
            return;
        }
        IVideoPlayer iVideoPlayer = this.mPlayer;
        if (iVideoPlayer != null) {
            iVideoPlayer.start();
        }
        OnPlayerUTReportListener onPlayerUTReportListener = this.mUTReportListener;
        if (onPlayerUTReportListener != null) {
            onPlayerUTReportListener.onPauseOrPlayClick(this.mVid, 5);
        }
    }

    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1328414265")) {
            ipChange.ipc$dispatch("1328414265", new Object[]{this});
            return;
        }
        this.mLoading.setVisibility(8);
        this.mCoverPauseImg.setVisibility(0);
        this.mCoverImg.setVisibility(0);
    }
}
