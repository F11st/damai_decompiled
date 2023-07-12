package cn.damai.player.controller.home;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.base.DMBaseVideoController;
import cn.damai.player.base.IVideoController;
import cn.damai.player.base.IVideoPlayer;
import cn.damai.player.controller.DMVideoPlayerDefaultErrorView;
import cn.damai.player.listener.OnPlayerUTReportListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.qx2;
import tb.sx2;
import tb.xs;
import tb.ys;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class DMVideoPlayerHomeController extends DMBaseVideoController implements View.OnClickListener, IVideoController {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isClickByUser;
    private boolean isNewRequest;
    private boolean isVideoStart;
    private DMVideoPlayerHomeBottomView mBottomView;
    private FrameLayout mContainer;
    private xs mDataHolder;
    private DMVideoPlayerDefaultErrorView mErrorView;
    private OnEventListener mListener;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface OnEventListener {
        void onVideoEnd(VideoInfo videoInfo, int i);

        void onVideoPlay(boolean z, VideoInfo videoInfo, int i);
    }

    public DMVideoPlayerHomeController(Context context) {
        super(context);
        this.isNewRequest = false;
        this.isVideoStart = false;
        this.isClickByUser = false;
        init();
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1053456043")) {
            ipChange.ipc$dispatch("1053456043", new Object[]{this});
            return;
        }
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.mContainer = frameLayout;
        frameLayout.setBackgroundColor(0);
        addView(this.mContainer, new FrameLayout.LayoutParams(-1, -1));
        setOnClickListener(this);
    }

    private void playOrPause(boolean z) {
        xs xsVar;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-18347324")) {
            ipChange.ipc$dispatch("-18347324", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (this.mUTReportListener != null && (xsVar = this.mDataHolder) != null && xsVar.e() != null && this.mDataHolder.c() != null) {
            this.mUTReportListener.onPauseOrPlayClick(this.mDataHolder.e().getVid(), this.mDataHolder.c().a());
        }
        if (z) {
            if (this.mDataHolder.c().d()) {
                this.mPlayer.pause(true);
            } else if (this.mDataHolder.c().c()) {
                this.mPlayer.start();
            } else {
                this.mPlayer.play();
            }
        }
    }

    private void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1974892096")) {
            ipChange.ipc$dispatch("1974892096", new Object[]{this});
            return;
        }
        this.isNewRequest = false;
        this.isVideoStart = false;
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void assembleLayers() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "324628487")) {
            ipChange.ipc$dispatch("324628487", new Object[]{this});
            return;
        }
        super.assembleLayers();
        this.mBottomView = new DMVideoPlayerHomeBottomView(this.mContext, this.mPlayer);
        DMVideoPlayerDefaultErrorView dMVideoPlayerDefaultErrorView = new DMVideoPlayerDefaultErrorView(this.mContext, this.mPlayer);
        this.mErrorView = dMVideoPlayerDefaultErrorView;
        dMVideoPlayerDefaultErrorView.setIVideoController(this);
        qx2.a(this.mBottomView, this.mContainer);
        qx2.a(this.mErrorView, this.mContainer);
        this.mDataHolder = ys.d().c();
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void changeVideoData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "459695194")) {
            ipChange.ipc$dispatch("459695194", new Object[]{this});
            return;
        }
        DMVideoPlayerHomeBottomView dMVideoPlayerHomeBottomView = this.mBottomView;
        if (dMVideoPlayerHomeBottomView != null) {
            dMVideoPlayerHomeBottomView.changeVideoData();
        }
        DMVideoPlayerDefaultErrorView dMVideoPlayerDefaultErrorView = this.mErrorView;
        if (dMVideoPlayerDefaultErrorView != null) {
            dMVideoPlayerDefaultErrorView.setVisibility(8);
        }
    }

    public void mute() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "518619394")) {
            ipChange.ipc$dispatch("518619394", new Object[]{this});
            return;
        }
        DMVideoPlayerHomeBottomView dMVideoPlayerHomeBottomView = this.mBottomView;
        if (dMVideoPlayerHomeBottomView != null) {
            dMVideoPlayerHomeBottomView.mute();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "5001004")) {
            ipChange.ipc$dispatch("5001004", new Object[]{this, view});
        } else if (view == this) {
            playOrPause(false);
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onLoadingEnd(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-728775591")) {
            ipChange.ipc$dispatch("-728775591", new Object[]{this, obj});
            return;
        }
        DMVideoPlayerHomeBottomView dMVideoPlayerHomeBottomView = this.mBottomView;
        if (dMVideoPlayerHomeBottomView != null) {
            dMVideoPlayerHomeBottomView.onLoadingEnd();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onLoadingStart(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "941379186")) {
            ipChange.ipc$dispatch("941379186", new Object[]{this, obj});
            return;
        }
        DMVideoPlayerHomeBottomView dMVideoPlayerHomeBottomView = this.mBottomView;
        if (dMVideoPlayerHomeBottomView != null) {
            dMVideoPlayerHomeBottomView.onLoadingStart();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onNewRequest(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1279209353")) {
            ipChange.ipc$dispatch("1279209353", new Object[]{this, obj});
            return;
        }
        this.isNewRequest = true;
        this.mDataHolder.i(System.currentTimeMillis());
        this.mBottomView.onNewRequest();
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void onPlayScreenModeChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2069888646")) {
            ipChange.ipc$dispatch("2069888646", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mDataHolder.c().e(i);
        }
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void onPlayStateChanged(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "349464250")) {
            ipChange.ipc$dispatch("349464250", new Object[]{this, Integer.valueOf(i), obj});
        } else if (i == 1) {
        } else {
            if (i == 10) {
                onPlayerGetVideoInfoSuccess(obj);
            } else if (i == 9) {
                onPlayerGetVideoInfoFailed(obj);
            } else if (i == 6) {
                onPlayerPositionChange(obj);
            } else if (i == 5) {
                onNewRequest(obj);
                onPlayerPlaying(obj);
            } else if (i == 4) {
                onPlayerPause(obj);
            } else if (i == 8) {
                onPlayerError(obj);
            } else if (i == 7) {
                onPlayerCompletion(obj);
            } else if (i == 12) {
                onLoadingStart(obj);
            } else if (i == 13) {
                onLoadingEnd(obj);
            } else if (i == 17) {
                onSoLoadFailed();
            } else if (i == 18) {
                onReloadSo();
            } else if (i == 20) {
                onReloadSoFailed();
            }
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerCompletion(Object obj) {
        VideoInfo e;
        IVideoPlayer iVideoPlayer;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2089396795")) {
            ipChange.ipc$dispatch("2089396795", new Object[]{this, obj});
            return;
        }
        DMVideoPlayerHomeBottomView dMVideoPlayerHomeBottomView = this.mBottomView;
        if (dMVideoPlayerHomeBottomView != null) {
            dMVideoPlayerHomeBottomView.onPlayerCompletion();
        }
        if (this.mListener == null || (e = this.mDataHolder.e()) == null || (iVideoPlayer = this.mPlayer) == null) {
            return;
        }
        this.mListener.onVideoEnd(e, iVideoPlayer.getDuration());
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerError(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "984132291")) {
            ipChange.ipc$dispatch("984132291", new Object[]{this, obj});
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerGetVideoInfoFailed(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-135465625")) {
            ipChange.ipc$dispatch("-135465625", new Object[]{this, obj});
            return;
        }
        DMVideoPlayerDefaultErrorView dMVideoPlayerDefaultErrorView = this.mErrorView;
        if (dMVideoPlayerDefaultErrorView != null) {
            dMVideoPlayerDefaultErrorView.onGetVideoInfoFailed();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerGetVideoInfoSuccess(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-517309221")) {
            ipChange.ipc$dispatch("-517309221", new Object[]{this, obj});
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPause(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-808798315")) {
            ipChange.ipc$dispatch("-808798315", new Object[]{this, obj});
            return;
        }
        DMVideoPlayerHomeBottomView dMVideoPlayerHomeBottomView = this.mBottomView;
        if (dMVideoPlayerHomeBottomView != null) {
            dMVideoPlayerHomeBottomView.onPlayerPause();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPlaying(Object obj) {
        VideoInfo e;
        IVideoPlayer iVideoPlayer;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1853888989")) {
            ipChange.ipc$dispatch("1853888989", new Object[]{this, obj});
            return;
        }
        this.isVideoStart = true;
        if (this.isNewRequest) {
            this.mDataHolder.h(System.currentTimeMillis());
            sx2.f().g(this.mContext, this.mDataHolder.e().getVid(), "homepage_video", this.mDataHolder.d());
            reset();
        }
        DMVideoPlayerDefaultErrorView dMVideoPlayerDefaultErrorView = this.mErrorView;
        if (dMVideoPlayerDefaultErrorView != null) {
            dMVideoPlayerDefaultErrorView.setVisibility(8);
        }
        DMVideoPlayerHomeBottomView dMVideoPlayerHomeBottomView = this.mBottomView;
        if (dMVideoPlayerHomeBottomView != null) {
            dMVideoPlayerHomeBottomView.onPlayerPlaying();
        }
        if (this.mListener == null || (e = this.mDataHolder.e()) == null || (iVideoPlayer = this.mPlayer) == null) {
            return;
        }
        this.mListener.onVideoPlay(this.isClickByUser, e, iVideoPlayer.getDuration());
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPositionChange(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "886477054")) {
            ipChange.ipc$dispatch("886477054", new Object[]{this, obj});
        } else {
            this.mBottomView.playViewGone();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPrepared(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1313007110")) {
            ipChange.ipc$dispatch("-1313007110", new Object[]{this, obj});
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPreparing(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1946132153")) {
            ipChange.ipc$dispatch("-1946132153", new Object[]{this, obj});
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onReloadSo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1716937753")) {
            ipChange.ipc$dispatch("-1716937753", new Object[]{this});
            return;
        }
        DMVideoPlayerDefaultErrorView dMVideoPlayerDefaultErrorView = this.mErrorView;
        if (dMVideoPlayerDefaultErrorView != null) {
            dMVideoPlayerDefaultErrorView.setVisibility(8);
        }
        DMVideoPlayerHomeBottomView dMVideoPlayerHomeBottomView = this.mBottomView;
        if (dMVideoPlayerHomeBottomView != null) {
            dMVideoPlayerHomeBottomView.onReloadSo();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onReloadSoFailed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-588331798")) {
            ipChange.ipc$dispatch("-588331798", new Object[]{this});
            return;
        }
        DMVideoPlayerDefaultErrorView dMVideoPlayerDefaultErrorView = this.mErrorView;
        if (dMVideoPlayerDefaultErrorView != null) {
            dMVideoPlayerDefaultErrorView.onSoLoadFailed(true);
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onReloadSoSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1939050496")) {
            ipChange.ipc$dispatch("1939050496", new Object[]{this});
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onScreenModeChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "910941355")) {
            ipChange.ipc$dispatch("910941355", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onSoLoadFailed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "977330621")) {
            ipChange.ipc$dispatch("977330621", new Object[]{this});
            return;
        }
        DMVideoPlayerDefaultErrorView dMVideoPlayerDefaultErrorView = this.mErrorView;
        if (dMVideoPlayerDefaultErrorView != null) {
            dMVideoPlayerDefaultErrorView.onSoLoadFailed(false);
        }
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void openVoice(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "890534140")) {
            ipChange.ipc$dispatch("890534140", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.openVoice(i);
        DMVideoPlayerHomeBottomView dMVideoPlayerHomeBottomView = this.mBottomView;
        if (dMVideoPlayerHomeBottomView != null) {
            dMVideoPlayerHomeBottomView.unMute();
        }
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void refresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "903335604")) {
            ipChange.ipc$dispatch("903335604", new Object[]{this});
            return;
        }
        DMVideoPlayerHomeBottomView dMVideoPlayerHomeBottomView = this.mBottomView;
        if (dMVideoPlayerHomeBottomView != null) {
            dMVideoPlayerHomeBottomView.refresh();
        }
    }

    public void setBottomPadding(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1275298252")) {
            ipChange.ipc$dispatch("1275298252", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        DMVideoPlayerHomeBottomView dMVideoPlayerHomeBottomView = this.mBottomView;
        if (dMVideoPlayerHomeBottomView != null) {
            dMVideoPlayerHomeBottomView.setPaddingBottom(i);
        }
    }

    public void setClickByUser(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "491478689")) {
            ipChange.ipc$dispatch("491478689", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isClickByUser = z;
        }
    }

    public void setListener(OnEventListener onEventListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1425237889")) {
            ipChange.ipc$dispatch("-1425237889", new Object[]{this, onEventListener});
        } else {
            this.mListener = onEventListener;
        }
    }

    public void setUTReportListener(OnPlayerUTReportListener onPlayerUTReportListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-22378932")) {
            ipChange.ipc$dispatch("-22378932", new Object[]{this, onPlayerUTReportListener});
            return;
        }
        this.mUTReportListener = onPlayerUTReportListener;
        this.mBottomView.registerUTReporter(onPlayerUTReportListener);
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1515755129")) {
            ipChange.ipc$dispatch("1515755129", new Object[]{this});
            return;
        }
        DMVideoPlayerHomeBottomView dMVideoPlayerHomeBottomView = this.mBottomView;
        if (dMVideoPlayerHomeBottomView != null) {
            dMVideoPlayerHomeBottomView.stop();
        }
    }
}
