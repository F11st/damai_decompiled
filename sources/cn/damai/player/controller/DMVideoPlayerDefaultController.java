package cn.damai.player.controller;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import cn.damai.player.base.DMBaseVideoController;
import cn.damai.player.base.IVideoController;
import cn.damai.player.base.IVideoPlayerExtend;
import cn.damai.player.listener.OnPlayerUTReportListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.qx2;
import tb.sx2;
import tb.xs;
import tb.ys;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class DMVideoPlayerDefaultController extends DMBaseVideoController implements View.OnClickListener, IVideoController {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isNewRequest;
    private boolean isVideoStart;
    private DMVideoPlayerDefaultBottomView mBottomView;
    private FrameLayout mContainer;
    private xs mDataHolder;
    private DMVideoPlayerDefaultErrorView mErrorView;
    private DMVideoPlayerDefaultTopView mTopView;
    private IVideoPlayerExtend playerExtend;

    public DMVideoPlayerDefaultController(Context context) {
        super(context);
        this.isNewRequest = false;
        this.isVideoStart = false;
        init();
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1594667063")) {
            ipChange.ipc$dispatch("1594667063", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "1572564532")) {
            ipChange.ipc$dispatch("1572564532", new Object[]{this});
            return;
        }
        this.isNewRequest = false;
        this.isVideoStart = false;
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void assembleLayers() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1577440621")) {
            ipChange.ipc$dispatch("-1577440621", new Object[]{this});
            return;
        }
        super.assembleLayers();
        this.mBottomView = new DMVideoPlayerDefaultBottomView(this.mContext, this.mPlayer);
        this.mErrorView = new DMVideoPlayerDefaultErrorView(this.mContext, this.mPlayer);
        DMVideoPlayerDefaultTopView dMVideoPlayerDefaultTopView = new DMVideoPlayerDefaultTopView(this.mContext, this.mPlayer);
        this.mTopView = dMVideoPlayerDefaultTopView;
        dMVideoPlayerDefaultTopView.setIVideoController(this);
        this.mBottomView.setIVideoController(this);
        this.mErrorView.setIVideoController(this);
        qx2.a(this.mBottomView, this.mContainer);
        qx2.a(this.mErrorView, this.mContainer);
        qx2.a(this.mTopView, this.mContainer);
        this.mDataHolder = ys.d().c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DMVideoPlayerDefaultBottomView dMVideoPlayerDefaultBottomView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1095604152")) {
            ipChange.ipc$dispatch("1095604152", new Object[]{this, view});
        } else if (view != this || (dMVideoPlayerDefaultBottomView = this.mBottomView) == null) {
        } else {
            dMVideoPlayerDefaultBottomView.hideOrShowBottomBar();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onLoadingEnd(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1419647259")) {
            ipChange.ipc$dispatch("-1419647259", new Object[]{this, obj});
            return;
        }
        DMVideoPlayerDefaultBottomView dMVideoPlayerDefaultBottomView = this.mBottomView;
        if (dMVideoPlayerDefaultBottomView != null) {
            dMVideoPlayerDefaultBottomView.onLoadingEnd();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onLoadingStart(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1561330178")) {
            ipChange.ipc$dispatch("-1561330178", new Object[]{this, obj});
            return;
        }
        DMVideoPlayerDefaultBottomView dMVideoPlayerDefaultBottomView = this.mBottomView;
        if (dMVideoPlayerDefaultBottomView != null) {
            dMVideoPlayerDefaultBottomView.onLoadingStart();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onNewRequest(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "588337685")) {
            ipChange.ipc$dispatch("588337685", new Object[]{this, obj});
            return;
        }
        this.mBottomView.onNewRequest();
        this.isNewRequest = true;
        this.mDataHolder.i(System.currentTimeMillis());
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void onPlayScreenModeChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-655230446")) {
            ipChange.ipc$dispatch("-655230446", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mDataHolder.c().e(i);
        onScreenModeChanged(this.mPlayer.isFullScreen());
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void onPlayStateChanged(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "81563310")) {
            ipChange.ipc$dispatch("81563310", new Object[]{this, Integer.valueOf(i), obj});
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
        if (AndroidInstantRuntime.support(ipChange, "-274549817")) {
            ipChange.ipc$dispatch("-274549817", new Object[]{this, obj});
            return;
        }
        DMVideoPlayerDefaultBottomView dMVideoPlayerDefaultBottomView = this.mBottomView;
        if (dMVideoPlayerDefaultBottomView != null) {
            dMVideoPlayerDefaultBottomView.onPlayerCompletion();
        }
        DMVideoPlayerDefaultTopView dMVideoPlayerDefaultTopView = this.mTopView;
        if (dMVideoPlayerDefaultTopView != null) {
            dMVideoPlayerDefaultTopView.setVisibilityByScreenMode();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerError(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1041947063")) {
            ipChange.ipc$dispatch("1041947063", new Object[]{this, obj});
            return;
        }
        DMVideoPlayerDefaultTopView dMVideoPlayerDefaultTopView = this.mTopView;
        if (dMVideoPlayerDefaultTopView != null) {
            dMVideoPlayerDefaultTopView.setVisibilityByScreenMode();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerGetVideoInfoFailed(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1084640525")) {
            ipChange.ipc$dispatch("-1084640525", new Object[]{this, obj});
            return;
        }
        DMVideoPlayerDefaultErrorView dMVideoPlayerDefaultErrorView = this.mErrorView;
        if (dMVideoPlayerDefaultErrorView != null) {
            dMVideoPlayerDefaultErrorView.onGetVideoInfoFailed();
        }
        DMVideoPlayerDefaultTopView dMVideoPlayerDefaultTopView = this.mTopView;
        if (dMVideoPlayerDefaultTopView != null) {
            dMVideoPlayerDefaultTopView.setVisibilityByScreenMode();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerGetVideoInfoSuccess(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "123039951")) {
            ipChange.ipc$dispatch("123039951", new Object[]{this, obj});
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPause(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-750983543")) {
            ipChange.ipc$dispatch("-750983543", new Object[]{this, obj});
            return;
        }
        DMVideoPlayerDefaultBottomView dMVideoPlayerDefaultBottomView = this.mBottomView;
        if (dMVideoPlayerDefaultBottomView != null) {
            dMVideoPlayerDefaultBottomView.onPlayerPause();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPlaying(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1579310033")) {
            ipChange.ipc$dispatch("1579310033", new Object[]{this, obj});
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
        DMVideoPlayerDefaultBottomView dMVideoPlayerDefaultBottomView = this.mBottomView;
        if (dMVideoPlayerDefaultBottomView != null) {
            dMVideoPlayerDefaultBottomView.onPlayerRealVideoStart();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPositionChange(Object obj) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-101190518")) {
            ipChange.ipc$dispatch("-101190518", new Object[]{this, obj});
            return;
        }
        this.mBottomView.playViewGone();
        if (!this.mDataHolder.c().c()) {
            this.mDataHolder.c().f(5);
        }
        if (this.mBottomView == null || obj == null) {
            return;
        }
        try {
            i = Integer.parseInt(obj + "");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        this.mBottomView.onCurrentPositionChange(i);
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPrepared(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1235020154")) {
            ipChange.ipc$dispatch("-1235020154", new Object[]{this, obj});
            return;
        }
        DMVideoPlayerDefaultBottomView dMVideoPlayerDefaultBottomView = this.mBottomView;
        if (dMVideoPlayerDefaultBottomView != null) {
            dMVideoPlayerDefaultBottomView.onPlayerPrepared();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPreparing(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "471463483")) {
            ipChange.ipc$dispatch("471463483", new Object[]{this, obj});
        }
    }

    public void onPlayerRelease(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-184707688")) {
            ipChange.ipc$dispatch("-184707688", new Object[]{this, obj});
            return;
        }
        DMVideoPlayerDefaultBottomView dMVideoPlayerDefaultBottomView = this.mBottomView;
        if (dMVideoPlayerDefaultBottomView != null) {
            dMVideoPlayerDefaultBottomView.onPlayerRelease();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onReloadSo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "830831731")) {
            ipChange.ipc$dispatch("830831731", new Object[]{this});
            return;
        }
        DMVideoPlayerDefaultErrorView dMVideoPlayerDefaultErrorView = this.mErrorView;
        if (dMVideoPlayerDefaultErrorView != null) {
            dMVideoPlayerDefaultErrorView.setVisibility(8);
        }
        DMVideoPlayerDefaultBottomView dMVideoPlayerDefaultBottomView = this.mBottomView;
        if (dMVideoPlayerDefaultBottomView != null) {
            dMVideoPlayerDefaultBottomView.onReloadSo();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onReloadSoFailed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1179323510")) {
            ipChange.ipc$dispatch("1179323510", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "901790196")) {
            ipChange.ipc$dispatch("901790196", new Object[]{this});
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onScreenModeChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2115928521")) {
            ipChange.ipc$dispatch("-2115928521", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            this.mBottomView.bottomBarDelayHide();
            this.mBottomView.screenModeChange(true);
            this.mTopView.setVisibility(0);
            this.mTopView.topBarDelayHide();
        } else {
            this.mBottomView.screenModeChange(false);
            this.mTopView.hideTopBar();
        }
        IVideoPlayerExtend iVideoPlayerExtend = this.playerExtend;
        if (iVideoPlayerExtend != null) {
            iVideoPlayerExtend.onScreenModeChangedView(z);
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onSoLoadFailed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-924738487")) {
            ipChange.ipc$dispatch("-924738487", new Object[]{this});
            return;
        }
        DMVideoPlayerDefaultErrorView dMVideoPlayerDefaultErrorView = this.mErrorView;
        if (dMVideoPlayerDefaultErrorView != null) {
            dMVideoPlayerDefaultErrorView.onSoLoadFailed(false);
        }
        DMVideoPlayerDefaultTopView dMVideoPlayerDefaultTopView = this.mTopView;
        if (dMVideoPlayerDefaultTopView != null) {
            dMVideoPlayerDefaultTopView.setVisibilityByScreenMode();
        }
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void refresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "813603240")) {
            ipChange.ipc$dispatch("813603240", new Object[]{this});
            return;
        }
        DMVideoPlayerDefaultBottomView dMVideoPlayerDefaultBottomView = this.mBottomView;
        if (dMVideoPlayerDefaultBottomView != null) {
            dMVideoPlayerDefaultBottomView.refresh();
        }
        DMVideoPlayerDefaultErrorView dMVideoPlayerDefaultErrorView = this.mErrorView;
        if (dMVideoPlayerDefaultErrorView != null) {
            dMVideoPlayerDefaultErrorView.setVisibility(8);
        }
    }

    public void setPlayerExtend(IVideoPlayerExtend iVideoPlayerExtend) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-266163517")) {
            ipChange.ipc$dispatch("-266163517", new Object[]{this, iVideoPlayerExtend});
        } else {
            this.playerExtend = iVideoPlayerExtend;
        }
    }

    public void setUTReportListener(OnPlayerUTReportListener onPlayerUTReportListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1221209304")) {
            ipChange.ipc$dispatch("1221209304", new Object[]{this, onPlayerUTReportListener});
            return;
        }
        this.mUTReportListener = onPlayerUTReportListener;
        this.mBottomView.registerUTReporter(onPlayerUTReportListener);
        this.mTopView.registerUTPlayerListener(onPlayerUTReportListener);
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2056966149")) {
            ipChange.ipc$dispatch("2056966149", new Object[]{this});
            return;
        }
        DMVideoPlayerDefaultBottomView dMVideoPlayerDefaultBottomView = this.mBottomView;
        if (dMVideoPlayerDefaultBottomView != null) {
            dMVideoPlayerDefaultBottomView.stop();
        }
    }
}
