package cn.damai.tetris.component.star.content.base.video;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import cn.damai.common.image.a;
import cn.damai.player.base.IVideoPlayer;
import cn.damai.player.listener.OnPlayerUTReportListener;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.irecycler.widget.LoadingView;
import cn.damai.videoplayer.R$color;
import cn.damai.videoplayer.R$id;
import cn.damai.videoplayer.R$layout;
import cn.damai.videoplayer.R$string;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.t60;
import tb.xs;
import tb.ys;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ContentVideoPlayerView extends FrameLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Activity mActivity;
    private ImageView mBofangBtn;
    private FrameLayout mBottomBarContainer;
    private ImageView mCoverImg;
    private xs mDataHolder;
    private LoadingView mLoadingImg;
    private DMIconFontTextView mMuteBtn;
    private View mPaddingView;
    private RelativeLayout mPauseContainer;
    private IVideoPlayer mPlayer;
    private OnPlayerUTReportListener mUTReportListener;
    private String mVid;
    private int mVoice;
    MuteListener muteListener;
    BasePresenter presenter;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface MuteListener {
        void onStateChanged(int i);
    }

    public ContentVideoPlayerView(Activity activity, IVideoPlayer iVideoPlayer, BasePresenter basePresenter) {
        super(activity);
        this.mVoice = 0;
        this.mActivity = activity;
        this.mPlayer = iVideoPlayer;
        this.presenter = basePresenter;
        init();
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-212435207")) {
            ipChange.ipc$dispatch("-212435207", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.mActivity).inflate(R$layout.yk_player_home_handler_layout, this);
        this.mMuteBtn = (DMIconFontTextView) inflate.findViewById(R$id.yk_player_voice_btn);
        this.mCoverImg = (ImageView) inflate.findViewById(R$id.yk_player_video_cover);
        this.mBottomBarContainer = (FrameLayout) inflate.findViewById(R$id.yk_bottom_bar_layout);
        this.mPauseContainer = (RelativeLayout) inflate.findViewById(R$id.yk_pause_container);
        this.mBofangBtn = (ImageView) inflate.findViewById(R$id.yk_player_video_bofang_btn);
        this.mPaddingView = inflate.findViewById(R$id.yk_player_bottom_padding);
        this.mLoadingImg = (LoadingView) inflate.findViewById(R$id.yk_player_loading);
        this.mDataHolder = ys.d().c();
        this.mMuteBtn.setOnClickListener(this);
        this.mMuteBtn.setPadding(t60.a(getContext(), 21.0f), this.mMuteBtn.getPaddingTop(), this.mMuteBtn.getPaddingRight(), this.mMuteBtn.getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void changeVideoData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1017495372")) {
            ipChange.ipc$dispatch("1017495372", new Object[]{this});
            return;
        }
        this.mLoadingImg.setVisibility(8);
        this.mBofangBtn.setVisibility(0);
        this.mCoverImg.setVisibility(0);
        this.mBottomBarContainer.setVisibility(0);
        this.mMuteBtn.setVisibility(4);
    }

    public int getVoice() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-507393280") ? ((Integer) ipChange.ipc$dispatch("-507393280", new Object[]{this})).intValue() : this.mVoice;
    }

    public void mute() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-747271856")) {
            ipChange.ipc$dispatch("-747271856", new Object[]{this});
        } else if (this.mVoice == 1) {
        } else {
            this.mMuteBtn.setText(this.mActivity.getText(R$string.iconfont_shengyinguan22));
            this.mVoice = 0;
            IVideoPlayer iVideoPlayer = this.mPlayer;
            if (iVideoPlayer != null) {
                iVideoPlayer.mute(0);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1413543686")) {
            ipChange.ipc$dispatch("-1413543686", new Object[]{this, view});
        } else if (view.getId() == R$id.yk_player_voice_btn) {
            voice();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLoadingEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-290995189")) {
            ipChange.ipc$dispatch("-290995189", new Object[]{this});
        } else {
            this.mLoadingImg.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLoadingStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-829262108")) {
            ipChange.ipc$dispatch("-829262108", new Object[]{this});
        } else {
            this.mLoadingImg.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "525114171")) {
            ipChange.ipc$dispatch("525114171", new Object[]{this});
            return;
        }
        mute();
        this.mLoadingImg.setVisibility(0);
        this.mCoverImg.setVisibility(0);
        this.mBofangBtn.setVisibility(4);
        this.mBottomBarContainer.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPlayerCompletion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1766673389")) {
            ipChange.ipc$dispatch("1766673389", new Object[]{this});
            return;
        }
        this.mLoadingImg.setVisibility(8);
        this.mCoverImg.setVisibility(0);
        this.mBofangBtn.setVisibility(0);
        this.mBottomBarContainer.setVisibility(0);
        this.mMuteBtn.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPlayerPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-641604757")) {
            ipChange.ipc$dispatch("-641604757", new Object[]{this});
            return;
        }
        this.mBofangBtn.setVisibility(0);
        this.mBottomBarContainer.setVisibility(0);
        this.mMuteBtn.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPlayerPlaying() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-94457037")) {
            ipChange.ipc$dispatch("-94457037", new Object[]{this});
            return;
        }
        this.mLoadingImg.setVisibility(8);
        this.mCoverImg.setVisibility(4);
        this.mBofangBtn.setVisibility(4);
        this.mBottomBarContainer.setVisibility(0);
        this.mMuteBtn.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onReloadSo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "87404981")) {
            ipChange.ipc$dispatch("87404981", new Object[]{this});
            return;
        }
        this.mLoadingImg.setVisibility(0);
        this.mCoverImg.setVisibility(0);
        this.mBofangBtn.setVisibility(4);
        this.mBottomBarContainer.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void playViewGone() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1026519343")) {
            ipChange.ipc$dispatch("-1026519343", new Object[]{this});
            return;
        }
        if (this.mCoverImg.getVisibility() == 0) {
            this.mCoverImg.setVisibility(4);
        }
        if (this.mBofangBtn.getVisibility() == 0) {
            this.mBofangBtn.setVisibility(4);
        }
    }

    public void refresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1450034266")) {
            ipChange.ipc$dispatch("-1450034266", new Object[]{this});
            return;
        }
        if (this.mDataHolder.e() != null && !TextUtils.isEmpty(this.mDataHolder.e().getPicUrl())) {
            a.b().c(this.mDataHolder.e().getPicUrl()).c(R$color.color_111111).g(this.mCoverImg);
        }
        if (this.mDataHolder.e() != null) {
            this.mVid = this.mDataHolder.e().getVid();
        }
    }

    public void registerUTReporter(OnPlayerUTReportListener onPlayerUTReportListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "399366796")) {
            ipChange.ipc$dispatch("399366796", new Object[]{this, onPlayerUTReportListener});
        } else {
            this.mUTReportListener = onPlayerUTReportListener;
        }
    }

    public void setMuteListener(MuteListener muteListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2104581458")) {
            ipChange.ipc$dispatch("2104581458", new Object[]{this, muteListener});
        } else {
            this.muteListener = muteListener;
        }
    }

    public void setPaddingBottom(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-741536908")) {
            ipChange.ipc$dispatch("-741536908", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ((LinearLayout.LayoutParams) this.mPaddingView.getLayoutParams()).height = i;
        ((RelativeLayout.LayoutParams) this.mPauseContainer.getLayoutParams()).bottomMargin = i;
    }

    public void setPresenter(BasePresenter basePresenter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1715790736")) {
            ipChange.ipc$dispatch("1715790736", new Object[]{this, basePresenter});
        } else {
            this.presenter = basePresenter;
        }
    }

    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "249863879")) {
            ipChange.ipc$dispatch("249863879", new Object[]{this});
            return;
        }
        this.mLoadingImg.setVisibility(8);
        this.mBofangBtn.setVisibility(0);
        this.mCoverImg.setVisibility(0);
        this.mBottomBarContainer.setVisibility(0);
        this.mMuteBtn.setVisibility(4);
    }

    public void voice() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-235207441")) {
            ipChange.ipc$dispatch("-235207441", new Object[]{this});
            return;
        }
        int i = 1 - this.mVoice;
        this.mVoice = i;
        if (i == 1) {
            this.mMuteBtn.setText(this.mActivity.getText(R$string.iconfont_shengyinkai22));
            OnPlayerUTReportListener onPlayerUTReportListener = this.mUTReportListener;
            if (onPlayerUTReportListener != null) {
                onPlayerUTReportListener.onMuteBtnClick(this.mVid, 1);
            }
        } else {
            this.mMuteBtn.setText(this.mActivity.getText(R$string.iconfont_shengyinguan22));
            OnPlayerUTReportListener onPlayerUTReportListener2 = this.mUTReportListener;
            if (onPlayerUTReportListener2 != null) {
                onPlayerUTReportListener2.onMuteBtnClick(this.mVid, 0);
            }
        }
        BasePresenter basePresenter = this.presenter;
        if (basePresenter != null) {
            basePresenter.userTrackClick("mute", false);
        }
        IVideoPlayer iVideoPlayer = this.mPlayer;
        if (iVideoPlayer != null) {
            iVideoPlayer.mute(this.mVoice);
        }
        MuteListener muteListener = this.muteListener;
        if (muteListener != null) {
            muteListener.onStateChanged(this.mVoice);
        }
    }
}
