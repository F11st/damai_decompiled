package cn.damai.player.controller.discover;

import android.content.Context;
import android.widget.FrameLayout;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.base.DMBaseVideoController;
import cn.damai.player.base.IVideoController;
import cn.damai.player.base.IVideoPlayer;
import cn.damai.player.listener.OnPlayerUTReportListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.qx2;
import tb.sx2;
import tb.xs;
import tb.ys;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class DMVideoPlayerDiscoverController extends DMBaseVideoController implements IVideoController {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isNewRequest;
    private boolean isVideoStart;
    private DMVideoPlayerDiscoverView mBottomView;
    private FrameLayout mContainer;
    private xs mDataHolder;
    private OnEventListener mListener;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface OnEventListener {
        void onVideoEnd(VideoInfo videoInfo, int i);

        void onVideoPlay(boolean z, VideoInfo videoInfo, int i);
    }

    public DMVideoPlayerDiscoverController(Context context) {
        super(context);
        this.isNewRequest = false;
        this.isVideoStart = false;
        init();
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1552402879")) {
            ipChange.ipc$dispatch("1552402879", new Object[]{this});
            return;
        }
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.mContainer = frameLayout;
        frameLayout.setBackgroundColor(0);
        addView(this.mContainer, new FrameLayout.LayoutParams(-1, -1));
    }

    private void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "262374828")) {
            ipChange.ipc$dispatch("262374828", new Object[]{this});
            return;
        }
        this.isNewRequest = false;
        this.isVideoStart = false;
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void assembleLayers() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1331103205")) {
            ipChange.ipc$dispatch("-1331103205", new Object[]{this});
            return;
        }
        super.assembleLayers();
        DMVideoPlayerDiscoverView dMVideoPlayerDiscoverView = new DMVideoPlayerDiscoverView(this.mContext);
        this.mBottomView = dMVideoPlayerDiscoverView;
        qx2.a(dMVideoPlayerDiscoverView, this.mContainer);
        this.mDataHolder = ys.d().c();
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void changeVideoData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "671620294")) {
            ipChange.ipc$dispatch("671620294", new Object[]{this});
            return;
        }
        DMVideoPlayerDiscoverView dMVideoPlayerDiscoverView = this.mBottomView;
        if (dMVideoPlayerDiscoverView != null) {
            dMVideoPlayerDiscoverView.changeVideoData();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onLoadingEnd(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-758077843")) {
            ipChange.ipc$dispatch("-758077843", new Object[]{this, obj});
            return;
        }
        DMVideoPlayerDiscoverView dMVideoPlayerDiscoverView = this.mBottomView;
        if (dMVideoPlayerDiscoverView != null) {
            dMVideoPlayerDiscoverView.onLoadingEnd();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onLoadingStart(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1448281210")) {
            ipChange.ipc$dispatch("-1448281210", new Object[]{this, obj});
            return;
        }
        DMVideoPlayerDiscoverView dMVideoPlayerDiscoverView = this.mBottomView;
        if (dMVideoPlayerDiscoverView != null) {
            dMVideoPlayerDiscoverView.onLoadingStart();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onNewRequest(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1249907101")) {
            ipChange.ipc$dispatch("1249907101", new Object[]{this, obj});
            return;
        }
        this.isNewRequest = true;
        this.mDataHolder.i(System.currentTimeMillis());
        this.mBottomView.onNewRequest();
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void onPlayScreenModeChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-332857446")) {
            ipChange.ipc$dispatch("-332857446", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mDataHolder.c().e(i);
        }
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void onPlayStateChanged(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1976092198")) {
            ipChange.ipc$dispatch("1976092198", new Object[]{this, Integer.valueOf(i), obj});
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
        if (AndroidInstantRuntime.support(ipChange, "756395343")) {
            ipChange.ipc$dispatch("756395343", new Object[]{this, obj});
            return;
        }
        DMVideoPlayerDiscoverView dMVideoPlayerDiscoverView = this.mBottomView;
        if (dMVideoPlayerDiscoverView != null) {
            dMVideoPlayerDiscoverView.onPlayerCompletion();
        }
        if (this.mListener == null || (e = this.mDataHolder.e()) == null || (iVideoPlayer = this.mPlayer) == null) {
            return;
        }
        this.mListener.onVideoEnd(e, iVideoPlayer.getDuration());
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerError(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "75762479")) {
            ipChange.ipc$dispatch("75762479", new Object[]{this, obj});
            return;
        }
        DMVideoPlayerDiscoverView dMVideoPlayerDiscoverView = this.mBottomView;
        if (dMVideoPlayerDiscoverView != null) {
            dMVideoPlayerDiscoverView.onError();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerGetVideoInfoFailed(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1088510853")) {
            ipChange.ipc$dispatch("-1088510853", new Object[]{this, obj});
            return;
        }
        DMVideoPlayerDiscoverView dMVideoPlayerDiscoverView = this.mBottomView;
        if (dMVideoPlayerDiscoverView != null) {
            dMVideoPlayerDiscoverView.onError();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerGetVideoInfoSuccess(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "3059783")) {
            ipChange.ipc$dispatch("3059783", new Object[]{this, obj});
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPause(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1717168127")) {
            ipChange.ipc$dispatch("-1717168127", new Object[]{this, obj});
            return;
        }
        DMVideoPlayerDiscoverView dMVideoPlayerDiscoverView = this.mBottomView;
        if (dMVideoPlayerDiscoverView != null) {
            dMVideoPlayerDiscoverView.onPlayerPause();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPlaying(Object obj) {
        VideoInfo e;
        IVideoPlayer iVideoPlayer;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "788860745")) {
            ipChange.ipc$dispatch("788860745", new Object[]{this, obj});
            return;
        }
        this.isVideoStart = true;
        if (this.isNewRequest) {
            this.mDataHolder.h(System.currentTimeMillis());
            sx2.f().g(this.mContext, this.mDataHolder.e().getVid(), "homepage_video", this.mDataHolder.d());
            reset();
        }
        DMVideoPlayerDiscoverView dMVideoPlayerDiscoverView = this.mBottomView;
        if (dMVideoPlayerDiscoverView != null) {
            dMVideoPlayerDiscoverView.onPlayerPlaying();
        }
        if (this.mListener == null || (e = this.mDataHolder.e()) == null || (iVideoPlayer = this.mPlayer) == null) {
            return;
        }
        this.mListener.onVideoPlay(false, e, iVideoPlayer.getDuration());
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPositionChange(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-356324846")) {
            ipChange.ipc$dispatch("-356324846", new Object[]{this, obj});
        } else {
            this.mBottomView.playViewGone();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPrepared(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "30855694")) {
            ipChange.ipc$dispatch("30855694", new Object[]{this, obj});
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPreparing(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1058909107")) {
            ipChange.ipc$dispatch("1058909107", new Object[]{this, obj});
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onReloadSo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2094616571")) {
            ipChange.ipc$dispatch("2094616571", new Object[]{this});
            return;
        }
        DMVideoPlayerDiscoverView dMVideoPlayerDiscoverView = this.mBottomView;
        if (dMVideoPlayerDiscoverView != null) {
            dMVideoPlayerDiscoverView.onReloadSo();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onReloadSoFailed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1686379006")) {
            ipChange.ipc$dispatch("1686379006", new Object[]{this});
            return;
        }
        DMVideoPlayerDiscoverView dMVideoPlayerDiscoverView = this.mBottomView;
        if (dMVideoPlayerDiscoverView != null) {
            dMVideoPlayerDiscoverView.onError();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onReloadSoSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-559358612")) {
            ipChange.ipc$dispatch("-559358612", new Object[]{this});
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onScreenModeChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1706522689")) {
            ipChange.ipc$dispatch("-1706522689", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onSoLoadFailed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-678401071")) {
            ipChange.ipc$dispatch("-678401071", new Object[]{this});
            return;
        }
        DMVideoPlayerDiscoverView dMVideoPlayerDiscoverView = this.mBottomView;
        if (dMVideoPlayerDiscoverView != null) {
            dMVideoPlayerDiscoverView.onError();
        }
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void refresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "146715424")) {
            ipChange.ipc$dispatch("146715424", new Object[]{this});
            return;
        }
        DMVideoPlayerDiscoverView dMVideoPlayerDiscoverView = this.mBottomView;
        if (dMVideoPlayerDiscoverView != null) {
            dMVideoPlayerDiscoverView.refresh();
        }
    }

    public void setBottomPadding(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1223110856")) {
            ipChange.ipc$dispatch("-1223110856", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void setListener(OnEventListener onEventListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-258018049")) {
            ipChange.ipc$dispatch("-258018049", new Object[]{this, onEventListener});
        } else {
            this.mListener = onEventListener;
        }
    }

    public void setUTReportListener(OnPlayerUTReportListener onPlayerUTReportListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "526697568")) {
            ipChange.ipc$dispatch("526697568", new Object[]{this, onPlayerUTReportListener});
        } else {
            this.mUTReportListener = onPlayerUTReportListener;
        }
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2014701965")) {
            ipChange.ipc$dispatch("2014701965", new Object[]{this});
            return;
        }
        DMVideoPlayerDiscoverView dMVideoPlayerDiscoverView = this.mBottomView;
        if (dMVideoPlayerDiscoverView != null) {
            dMVideoPlayerDiscoverView.stop();
        }
    }
}
