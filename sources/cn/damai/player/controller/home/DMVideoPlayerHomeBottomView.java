package cn.damai.player.controller.home;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import cn.damai.common.image.C0504a;
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
import tb.xs;
import tb.ys;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class DMVideoPlayerHomeBottomView extends FrameLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private FragmentActivity mActivity;
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

    public DMVideoPlayerHomeBottomView(FragmentActivity fragmentActivity, IVideoPlayer iVideoPlayer) {
        super(fragmentActivity);
        this.mVoice = 0;
        this.mActivity = fragmentActivity;
        this.mPlayer = iVideoPlayer;
        init();
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1309054335")) {
            ipChange.ipc$dispatch("1309054335", new Object[]{this});
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
    }

    private void voice() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-313671895")) {
            ipChange.ipc$dispatch("-313671895", new Object[]{this});
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
        IVideoPlayer iVideoPlayer = this.mPlayer;
        if (iVideoPlayer != null) {
            iVideoPlayer.mute(this.mVoice);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void changeVideoData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1624737530")) {
            ipChange.ipc$dispatch("-1624737530", new Object[]{this});
            return;
        }
        this.mLoadingImg.setVisibility(8);
        this.mBofangBtn.setVisibility(0);
        this.mCoverImg.setVisibility(0);
        this.mBottomBarContainer.setVisibility(0);
        this.mMuteBtn.setVisibility(0);
    }

    public void mute() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "774217686")) {
            ipChange.ipc$dispatch("774217686", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "-74393856")) {
            ipChange.ipc$dispatch("-74393856", new Object[]{this, view});
        } else if (view.getId() == R$id.yk_player_voice_btn) {
            voice();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLoadingEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "380892305")) {
            ipChange.ipc$dispatch("380892305", new Object[]{this});
            return;
        }
        this.mLoadingImg.setVisibility(8);
        this.mBofangBtn.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLoadingStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "609525226")) {
            ipChange.ipc$dispatch("609525226", new Object[]{this});
            return;
        }
        this.mLoadingImg.setVisibility(0);
        this.mBofangBtn.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1197001665")) {
            ipChange.ipc$dispatch("1197001665", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "871923699")) {
            ipChange.ipc$dispatch("871923699", new Object[]{this});
            return;
        }
        this.mLoadingImg.setVisibility(8);
        this.mCoverImg.setVisibility(0);
        this.mBofangBtn.setVisibility(0);
        this.mBottomBarContainer.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPlayerPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1287928923")) {
            ipChange.ipc$dispatch("-1287928923", new Object[]{this});
            return;
        }
        this.mBofangBtn.setVisibility(0);
        this.mBottomBarContainer.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPlayerPlaying() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1558277357")) {
            ipChange.ipc$dispatch("1558277357", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "360729531")) {
            ipChange.ipc$dispatch("360729531", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "-354631849")) {
            ipChange.ipc$dispatch("-354631849", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "455036768")) {
            ipChange.ipc$dispatch("455036768", new Object[]{this});
            return;
        }
        if (this.mDataHolder.e() != null && !TextUtils.isEmpty(this.mDataHolder.e().getPicUrl())) {
            C0504a.b().c(this.mDataHolder.e().getPicUrl()).c(R$color.color_111111).g(this.mCoverImg);
        }
        this.mVid = this.mDataHolder.e().getVid();
    }

    public void registerUTReporter(OnPlayerUTReportListener onPlayerUTReportListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1035060422")) {
            ipChange.ipc$dispatch("1035060422", new Object[]{this, onPlayerUTReportListener});
        } else {
            this.mUTReportListener = onPlayerUTReportListener;
        }
    }

    public void setPaddingBottom(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1601683794")) {
            ipChange.ipc$dispatch("-1601683794", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ((LinearLayout.LayoutParams) this.mPaddingView.getLayoutParams()).height = i;
        ((RelativeLayout.LayoutParams) this.mPauseContainer.getLayoutParams()).bottomMargin = i;
    }

    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1771353421")) {
            ipChange.ipc$dispatch("1771353421", new Object[]{this});
            return;
        }
        this.mLoadingImg.setVisibility(8);
        this.mBofangBtn.setVisibility(0);
        this.mCoverImg.setVisibility(0);
        this.mBottomBarContainer.setVisibility(0);
    }

    public void unMute() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "381443197")) {
            ipChange.ipc$dispatch("381443197", new Object[]{this});
        } else if (this.mVoice == 1) {
        } else {
            this.mMuteBtn.setText(this.mActivity.getText(R$string.iconfont_shengyinkai22));
            this.mVoice = 1;
            IVideoPlayer iVideoPlayer = this.mPlayer;
            if (iVideoPlayer != null) {
                iVideoPlayer.mute(1);
            }
        }
    }
}
