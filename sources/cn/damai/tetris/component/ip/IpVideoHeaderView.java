package cn.damai.tetris.component.ip;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.DMVideoPlayer;
import cn.damai.player.listener.OnPlayerUTReportListener;
import cn.damai.tetris.component.ip.IpVideoHeaderContract;
import cn.damai.tetris.component.ip.videoheader.IpVideoPlayerController;
import cn.damai.tetris.core.AbsView;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.q60;
import tb.ys;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class IpVideoHeaderView extends AbsView<IpVideoHeaderContract.Presenter> implements IpVideoHeaderContract.View<IpVideoHeaderContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    View coverTop;
    private Context mContext;
    IpVideoPlayerController mController;
    DMVideoPlayer mVideoPlayer;
    ys manager;
    View parent;
    View tip;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.ip.IpVideoHeaderView$a */
    /* loaded from: classes16.dex */
    public class C1915a implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ RecyclerView a;

        C1915a(RecyclerView recyclerView) {
            this.a = recyclerView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "402678437")) {
                ipChange.ipc$dispatch("402678437", new Object[]{this, valueAnimator});
                return;
            }
            Log.d("onLayoutChange", "animation.getAnimatedFraction():" + valueAnimator.getAnimatedFraction());
            Log.d("onLayoutChange", "animation.getAnimatedValue():" + valueAnimator.getAnimatedValue());
            Log.d("onLayoutChange", " ========= coverTop.getTranslationY():" + IpVideoHeaderView.this.coverTop.getTop());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) IpVideoHeaderView.this.parent.getLayoutParams();
            layoutParams.setMargins(0, -q60.a(IpVideoHeaderView.this.mContext, (1.0f - valueAnimator.getAnimatedFraction()) * 123.0f), 0, 0);
            IpVideoHeaderView.this.parent.setLayoutParams(layoutParams);
            RecyclerView recyclerView = this.a;
            if (recyclerView != null) {
                recyclerView.scrollToPosition(0);
            }
            Log.d("onLayoutChange", " ========= height:" + IpVideoHeaderView.this.parent.getLayoutParams().height);
        }
    }

    public IpVideoHeaderView(View view) {
        super(view);
        this.mContext = view.getContext();
        this.coverTop = view.findViewById(R$id.cover_half_top);
        this.tip = view.findViewById(R$id.cover_tip);
        this.parent = view.findViewById(R$id.list_conent_parent);
        this.manager = ys.d();
        this.mVideoPlayer = (DMVideoPlayer) view.findViewById(R$id.list_conent);
        IpVideoPlayerController ipVideoPlayerController = new IpVideoPlayerController(this.mContext, (BasePresenter) getPresenter());
        this.mController = ipVideoPlayerController;
        ipVideoPlayerController.setAutoReport(true);
        this.mController.setSpmData("repertoire_ip", "top");
        this.mVideoPlayer.setController(this.mController);
        this.manager.k(this.mVideoPlayer);
    }

    @Override // cn.damai.tetris.component.ip.IpVideoHeaderContract.View
    public ys getManager() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1807263499") ? (ys) ipChange.ipc$dispatch("-1807263499", new Object[]{this}) : this.manager;
    }

    @Override // cn.damai.tetris.component.ip.IpVideoHeaderContract.View
    public void hideTip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1793651921")) {
            ipChange.ipc$dispatch("1793651921", new Object[]{this});
        }
    }

    @Override // cn.damai.tetris.component.ip.IpVideoHeaderContract.View
    public void setMuteIcon(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1348507149")) {
            ipChange.ipc$dispatch("1348507149", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (i < 0) {
            i = this.mController.getBottomView().getVoice();
        }
        if (this.manager.b() == null) {
            return;
        }
        this.manager.b().mute(i);
        if (i != this.mController.getBottomView().getVoice()) {
            this.mController.getBottomView().voice();
        }
        DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) this.mVideoPlayer.findViewById(R$id.yk_player_voice_btn);
        if (dMIconFontTextView == null || getContext().getActivity() == null) {
            return;
        }
        if (i == 0) {
            dMIconFontTextView.setText(getContext().getActivity().getText(R$string.iconfont_shengyinguan22));
        } else {
            dMIconFontTextView.setText(getContext().getActivity().getText(R$string.iconfont_shengyinkai22));
        }
    }

    @Override // cn.damai.tetris.component.ip.IpVideoHeaderContract.View
    public void setStateListener(OnPlayerUTReportListener onPlayerUTReportListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "121482421")) {
            ipChange.ipc$dispatch("121482421", new Object[]{this, onPlayerUTReportListener});
        } else {
            this.mController.setUTReportListener(onPlayerUTReportListener);
        }
    }

    @Override // cn.damai.tetris.component.ip.IpVideoHeaderContract.View
    public void setVideoInfo(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-787302165")) {
            ipChange.ipc$dispatch("-787302165", new Object[]{this, videoInfo});
        } else if (videoInfo == null || getContext().getActivity() == null) {
        } else {
            IpVideoPlayerController ipVideoPlayerController = this.mController;
            if (ipVideoPlayerController != null) {
                ipVideoPlayerController.setPresenter((BasePresenter) getPresenter());
            }
            this.mVideoPlayer.setVideoData(videoInfo);
            this.manager.a();
            setMuteIcon(0);
            this.mController.getBottomView().mute();
        }
    }

    @Override // cn.damai.tetris.component.ip.IpVideoHeaderContract.View
    public void showTip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2069267892")) {
            ipChange.ipc$dispatch("-2069267892", new Object[]{this});
        }
    }

    @Override // cn.damai.tetris.component.ip.IpVideoHeaderContract.View
    @TargetApi(21)
    public void toogleAnim(RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2065048364")) {
            ipChange.ipc$dispatch("-2065048364", new Object[]{this, recyclerView});
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        View view = this.coverTop;
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationY", view.getTop(), this.coverTop.getTop() - this.coverTop.getHeight()).setDuration(1000L);
        Log.d("onLayoutChange", " ========= coverTop.getHeight()():" + this.coverTop.getHeight());
        duration.addUpdateListener(new C1915a(recyclerView));
        animatorSet.playTogether(duration);
        animatorSet.start();
        this.tip.setVisibility(8);
    }
}
