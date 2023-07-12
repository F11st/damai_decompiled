package cn.damai.player.controller.muteonly;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import cn.damai.player.base.DMBaseVideoController;
import cn.damai.player.base.IVideoController;
import cn.damai.player.controller.DMVideoPlayerDefaultErrorView;
import cn.damai.player.listener.OnPlayerUTReportListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.mu0;
import tb.pj1;
import tb.qx2;
import tb.sx2;
import tb.xs;
import tb.ys;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class DMVideoPlayerMuteOnlyController extends DMBaseVideoController implements View.OnClickListener, IVideoController {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isLoopOnWifi;
    private boolean isNewRequest;
    private boolean isVideoStart;
    private DMVideoPlayerMuteOnlyBottomView mBottomView;
    private FrameLayout mContainer;
    private xs mDataHolder;
    private DMVideoPlayerDefaultErrorView mErrorView;

    public DMVideoPlayerMuteOnlyController(Context context) {
        super(context);
        this.isNewRequest = false;
        this.isVideoStart = false;
        this.isLoopOnWifi = false;
        init();
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "610516887")) {
            ipChange.ipc$dispatch("610516887", new Object[]{this});
            return;
        }
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.mContainer = frameLayout;
        frameLayout.setBackgroundColor(0);
        addView(this.mContainer, new FrameLayout.LayoutParams(-1, -1));
        setOnClickListener(this);
    }

    private void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1128680148")) {
            ipChange.ipc$dispatch("1128680148", new Object[]{this});
            return;
        }
        this.isNewRequest = false;
        this.isVideoStart = false;
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void assembleLayers() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "583893491")) {
            ipChange.ipc$dispatch("583893491", new Object[]{this});
            return;
        }
        super.assembleLayers();
        this.mBottomView = new DMVideoPlayerMuteOnlyBottomView(this.mContext, this.mPlayer);
        this.mErrorView = new DMVideoPlayerDefaultErrorView(this.mContext, this.mPlayer);
        this.mBottomView.setIVideoController(this);
        this.mErrorView.setIVideoController(this);
        qx2.a(this.mBottomView, this.mContainer);
        qx2.a(this.mErrorView, this.mContainer);
        this.mDataHolder = ys.d().c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "368631576")) {
            ipChange.ipc$dispatch("368631576", new Object[]{this, view});
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onLoadingEnd(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "542801477")) {
            ipChange.ipc$dispatch("542801477", new Object[]{this, obj});
            return;
        }
        DMVideoPlayerMuteOnlyBottomView dMVideoPlayerMuteOnlyBottomView = this.mBottomView;
        if (dMVideoPlayerMuteOnlyBottomView != null) {
            dMVideoPlayerMuteOnlyBottomView.onLoadingEnd();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onLoadingStart(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1138737826")) {
            ipChange.ipc$dispatch("-1138737826", new Object[]{this, obj});
            return;
        }
        DMVideoPlayerMuteOnlyBottomView dMVideoPlayerMuteOnlyBottomView = this.mBottomView;
        if (dMVideoPlayerMuteOnlyBottomView != null) {
            dMVideoPlayerMuteOnlyBottomView.onLoadingStart();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onNewRequest(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1744180875")) {
            ipChange.ipc$dispatch("-1744180875", new Object[]{this, obj});
            return;
        }
        this.mBottomView.onNewRequest();
        this.isNewRequest = true;
        this.mDataHolder.i(System.currentTimeMillis());
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void onPlayScreenModeChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1015519602")) {
            ipChange.ipc$dispatch("1015519602", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mDataHolder.c().e(i);
        onScreenModeChanged(this.mPlayer.isFullScreen());
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void onPlayStateChanged(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1322052430")) {
            ipChange.ipc$dispatch("1322052430", new Object[]{this, Integer.valueOf(i), obj});
        } else if (i == 1 || i == 2) {
        } else {
            if (i == 3) {
                onPlayerPrepared(obj);
            } else if (i == 10) {
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
            } else if (i == 16) {
                onPlayerRelease(obj);
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
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1843675943")) {
            ipChange.ipc$dispatch("1843675943", new Object[]{this, obj});
            return;
        }
        DMVideoPlayerMuteOnlyBottomView dMVideoPlayerMuteOnlyBottomView = this.mBottomView;
        if (dMVideoPlayerMuteOnlyBottomView != null) {
            dMVideoPlayerMuteOnlyBottomView.onPlayerCompletion();
        }
        if (this.isLoopOnWifi && pj1.a(mu0.a())) {
            this.mPlayer.play();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerError(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1748315735")) {
            ipChange.ipc$dispatch("1748315735", new Object[]{this, obj});
            return;
        }
        DMVideoPlayerDefaultErrorView dMVideoPlayerDefaultErrorView = this.mErrorView;
        if (dMVideoPlayerDefaultErrorView != null) {
            dMVideoPlayerDefaultErrorView.onPlayerError();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerGetVideoInfoFailed(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1078321747")) {
            ipChange.ipc$dispatch("1078321747", new Object[]{this, obj});
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
        if (AndroidInstantRuntime.support(ipChange, "-1544606353")) {
            ipChange.ipc$dispatch("-1544606353", new Object[]{this, obj});
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPause(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-44614871")) {
            ipChange.ipc$dispatch("-44614871", new Object[]{this, obj});
            return;
        }
        DMVideoPlayerMuteOnlyBottomView dMVideoPlayerMuteOnlyBottomView = this.mBottomView;
        if (dMVideoPlayerMuteOnlyBottomView != null) {
            dMVideoPlayerMuteOnlyBottomView.onPlayerPause();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPlaying(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1794771057")) {
            ipChange.ipc$dispatch("1794771057", new Object[]{this, obj});
            return;
        }
        this.isVideoStart = true;
        if (this.isNewRequest) {
            this.mDataHolder.h(System.currentTimeMillis());
            sx2.f().g(this.mContext, this.mDataHolder.e().getVid(), "video", this.mDataHolder.d());
            reset();
        }
        DMVideoPlayerDefaultErrorView dMVideoPlayerDefaultErrorView = this.mErrorView;
        if (dMVideoPlayerDefaultErrorView != null) {
            dMVideoPlayerDefaultErrorView.setVisibility(8);
        }
        DMVideoPlayerMuteOnlyBottomView dMVideoPlayerMuteOnlyBottomView = this.mBottomView;
        if (dMVideoPlayerMuteOnlyBottomView != null) {
            dMVideoPlayerMuteOnlyBottomView.onPlayerRealVideoStart();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPositionChange(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1411568618")) {
            ipChange.ipc$dispatch("1411568618", new Object[]{this, obj});
            return;
        }
        this.mBottomView.playViewGone();
        if (this.mDataHolder.c().c()) {
            return;
        }
        this.mDataHolder.c().f(5);
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPrepared(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1149304294")) {
            ipChange.ipc$dispatch("1149304294", new Object[]{this, obj});
            return;
        }
        DMVideoPlayerMuteOnlyBottomView dMVideoPlayerMuteOnlyBottomView = this.mBottomView;
        if (dMVideoPlayerMuteOnlyBottomView != null) {
            dMVideoPlayerMuteOnlyBottomView.onPlayerPrepared();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPreparing(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1371077339")) {
            ipChange.ipc$dispatch("1371077339", new Object[]{this, obj});
        }
    }

    public void onPlayerRelease(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "30753336")) {
            ipChange.ipc$dispatch("30753336", new Object[]{this, obj});
            return;
        }
        DMVideoPlayerMuteOnlyBottomView dMVideoPlayerMuteOnlyBottomView = this.mBottomView;
        if (dMVideoPlayerMuteOnlyBottomView != null) {
            dMVideoPlayerMuteOnlyBottomView.onPlayerRelease();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onReloadSo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1385462829")) {
            ipChange.ipc$dispatch("-1385462829", new Object[]{this});
            return;
        }
        DMVideoPlayerDefaultErrorView dMVideoPlayerDefaultErrorView = this.mErrorView;
        if (dMVideoPlayerDefaultErrorView != null) {
            dMVideoPlayerDefaultErrorView.setVisibility(8);
        }
        DMVideoPlayerMuteOnlyBottomView dMVideoPlayerMuteOnlyBottomView = this.mBottomView;
        if (dMVideoPlayerMuteOnlyBottomView != null) {
            dMVideoPlayerMuteOnlyBottomView.onReloadSo();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onReloadSoFailed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-542766122")) {
            ipChange.ipc$dispatch("-542766122", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "-943380844")) {
            ipChange.ipc$dispatch("-943380844", new Object[]{this});
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onScreenModeChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-319959657")) {
            ipChange.ipc$dispatch("-319959657", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onSoLoadFailed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1236595625")) {
            ipChange.ipc$dispatch("1236595625", new Object[]{this});
            return;
        }
        DMVideoPlayerDefaultErrorView dMVideoPlayerDefaultErrorView = this.mErrorView;
        if (dMVideoPlayerDefaultErrorView != null) {
            dMVideoPlayerDefaultErrorView.onSoLoadFailed(false);
        }
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void refresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-557527480")) {
            ipChange.ipc$dispatch("-557527480", new Object[]{this});
            return;
        }
        DMVideoPlayerMuteOnlyBottomView dMVideoPlayerMuteOnlyBottomView = this.mBottomView;
        if (dMVideoPlayerMuteOnlyBottomView != null) {
            dMVideoPlayerMuteOnlyBottomView.refresh();
        }
        DMVideoPlayerDefaultErrorView dMVideoPlayerDefaultErrorView = this.mErrorView;
        if (dMVideoPlayerDefaultErrorView != null) {
            dMVideoPlayerDefaultErrorView.setVisibility(8);
        }
    }

    public void setLoopOnWifi(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1354617589")) {
            ipChange.ipc$dispatch("-1354617589", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isLoopOnWifi = z;
        }
    }

    public void setPlayerMute(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "244282189")) {
            ipChange.ipc$dispatch("244282189", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        DMVideoPlayerMuteOnlyBottomView dMVideoPlayerMuteOnlyBottomView = this.mBottomView;
        if (dMVideoPlayerMuteOnlyBottomView != null) {
            dMVideoPlayerMuteOnlyBottomView.setPlayerMute(z);
        }
    }

    public void setUTReportListener(OnPlayerUTReportListener onPlayerUTReportListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1691360200")) {
            ipChange.ipc$dispatch("-1691360200", new Object[]{this, onPlayerUTReportListener});
            return;
        }
        this.mUTReportListener = onPlayerUTReportListener;
        this.mBottomView.registerUTReporter(onPlayerUTReportListener);
    }

    public void setVideoCoverClickListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-293227472")) {
            ipChange.ipc$dispatch("-293227472", new Object[]{this, onClickListener});
        } else {
            setOnClickListener(onClickListener);
        }
    }

    public void setVideoCoverImage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1986199724")) {
            ipChange.ipc$dispatch("-1986199724", new Object[]{this, str});
            return;
        }
        DMVideoPlayerMuteOnlyBottomView dMVideoPlayerMuteOnlyBottomView = this.mBottomView;
        if (dMVideoPlayerMuteOnlyBottomView != null) {
            dMVideoPlayerMuteOnlyBottomView.setCoverImgUrl(str);
        }
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1072815973")) {
            ipChange.ipc$dispatch("1072815973", new Object[]{this});
            return;
        }
        DMVideoPlayerMuteOnlyBottomView dMVideoPlayerMuteOnlyBottomView = this.mBottomView;
        if (dMVideoPlayerMuteOnlyBottomView != null) {
            dMVideoPlayerMuteOnlyBottomView.stop();
        }
    }
}
