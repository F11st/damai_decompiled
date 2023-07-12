package cn.damai.tetris.component.ip.videoheader;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.FrameLayout;
import cn.damai.player.base.DMBaseVideoController;
import cn.damai.player.base.IVideoController;
import cn.damai.player.controller.DMVideoPlayerDefaultErrorView;
import cn.damai.player.listener.OnPlayerUTReportListener;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.uikit.nav.INavUri;
import cn.damai.uikit.nav.NavProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.qx2;
import tb.sx2;
import tb.xs;
import tb.ys;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class IpVideoPlayerController extends DMBaseVideoController implements View.OnClickListener, IVideoController {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isNewRequest;
    private boolean isVideoStart;
    private IpVideoPlayerView mBottomView;
    private FrameLayout mContainer;
    private xs mDataHolder;
    private DMVideoPlayerDefaultErrorView mErrorView;
    BasePresenter presenter;

    public IpVideoPlayerController(Context context, BasePresenter basePresenter) {
        super(context);
        this.isNewRequest = false;
        this.isVideoStart = false;
        init();
        this.presenter = basePresenter;
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1470552724")) {
            ipChange.ipc$dispatch("1470552724", new Object[]{this});
            return;
        }
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.mContainer = frameLayout;
        frameLayout.setBackgroundColor(0);
        addView(this.mContainer, new FrameLayout.LayoutParams(-1, -1));
        setOnClickListener(this);
    }

    private void playOrPause() {
        xs xsVar;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1815740921")) {
            ipChange.ipc$dispatch("-1815740921", new Object[]{this});
            return;
        }
        if (this.mUTReportListener != null && (xsVar = this.mDataHolder) != null && xsVar.e() != null && this.mDataHolder.c() != null) {
            this.mUTReportListener.onPauseOrPlayClick(this.mDataHolder.e().getVid(), this.mDataHolder.c().a());
        }
        if (this.mDataHolder.c().d()) {
            this.mPlayer.pause(true);
        } else if (this.mDataHolder.c().c()) {
            this.mPlayer.start();
        } else {
            this.mPlayer.play();
        }
    }

    private void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2019987319")) {
            ipChange.ipc$dispatch("2019987319", new Object[]{this});
            return;
        }
        this.isNewRequest = false;
        this.isVideoStart = false;
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void assembleLayers() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1099119440")) {
            ipChange.ipc$dispatch("-1099119440", new Object[]{this});
            return;
        }
        super.assembleLayers();
        this.mBottomView = new IpVideoPlayerView(this.mContext, this.mPlayer, this.presenter);
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
        if (AndroidInstantRuntime.support(ipChange, "-726817583")) {
            ipChange.ipc$dispatch("-726817583", new Object[]{this});
            return;
        }
        IpVideoPlayerView ipVideoPlayerView = this.mBottomView;
        if (ipVideoPlayerView != null) {
            ipVideoPlayerView.changeVideoData();
        }
        DMVideoPlayerDefaultErrorView dMVideoPlayerDefaultErrorView = this.mErrorView;
        if (dMVideoPlayerDefaultErrorView != null) {
            dMVideoPlayerDefaultErrorView.setVisibility(8);
        }
    }

    public IpVideoPlayerView getBottomView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1709419245") ? (IpVideoPlayerView) ipChange.ipc$dispatch("1709419245", new Object[]{this}) : this.mBottomView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        xs xsVar;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2121208235")) {
            ipChange.ipc$dispatch("-2121208235", new Object[]{this, view});
        } else if (view != this || (xsVar = this.mDataHolder) == null || xsVar.e() == null) {
        } else {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            arrayList.add(this.mDataHolder.e());
            Bundle bundle = new Bundle();
            bundle.putInt("position", 0);
            bundle.putParcelableArrayList("video_info", arrayList);
            NavProxy.from(this.mContext).withExtras(bundle).toUri(INavUri.page("videobrowse"));
            BasePresenter basePresenter = this.presenter;
            if (basePresenter != null) {
                basePresenter.userTrackClick("fullscreen", true);
            }
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onLoadingEnd(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-693197054")) {
            ipChange.ipc$dispatch("-693197054", new Object[]{this, obj});
            return;
        }
        IpVideoPlayerView ipVideoPlayerView = this.mBottomView;
        if (ipVideoPlayerView != null) {
            ipVideoPlayerView.onLoadingEnd();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onLoadingStart(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "772614875")) {
            ipChange.ipc$dispatch("772614875", new Object[]{this, obj});
            return;
        }
        IpVideoPlayerView ipVideoPlayerView = this.mBottomView;
        if (ipVideoPlayerView != null) {
            ipVideoPlayerView.onLoadingStart();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onNewRequest(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1314787890")) {
            ipChange.ipc$dispatch("1314787890", new Object[]{this, obj});
            return;
        }
        this.isNewRequest = true;
        this.mDataHolder.i(System.currentTimeMillis());
        this.mBottomView.onNewRequest();
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void onPlayScreenModeChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "744772591")) {
            ipChange.ipc$dispatch("744772591", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mDataHolder.c().e(i);
        }
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void onPlayStateChanged(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1916396529")) {
            ipChange.ipc$dispatch("1916396529", new Object[]{this, Integer.valueOf(i), obj});
        } else if (i == 1) {
            onNewRequest(obj);
        } else if (i == 10) {
            onPlayerGetVideoInfoSuccess(obj);
        } else if (i == 9) {
            onPlayerGetVideoInfoFailed(obj);
        } else if (i == 6) {
            onPlayerPositionChange(obj);
        } else if (i == 5) {
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

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerCompletion(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "477375012")) {
            ipChange.ipc$dispatch("477375012", new Object[]{this, obj});
            return;
        }
        IpVideoPlayerView ipVideoPlayerView = this.mBottomView;
        if (ipVideoPlayerView != null) {
            ipVideoPlayerView.onPlayerCompletion();
            reset();
            this.mPlayer.play();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerError(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2087066938")) {
            ipChange.ipc$dispatch("2087066938", new Object[]{this, obj});
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerGetVideoInfoFailed(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-214860720")) {
            ipChange.ipc$dispatch("-214860720", new Object[]{this, obj});
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
        if (AndroidInstantRuntime.support(ipChange, "1316410130")) {
            ipChange.ipc$dispatch("1316410130", new Object[]{this, obj});
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPause(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "294136332")) {
            ipChange.ipc$dispatch("294136332", new Object[]{this, obj});
            return;
        }
        IpVideoPlayerView ipVideoPlayerView = this.mBottomView;
        if (ipVideoPlayerView != null) {
            ipVideoPlayerView.onPlayerPause();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPlaying(Object obj) {
        xs xsVar;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "917162644")) {
            ipChange.ipc$dispatch("917162644", new Object[]{this, obj});
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
        IpVideoPlayerView ipVideoPlayerView = this.mBottomView;
        if (ipVideoPlayerView != null) {
            ipVideoPlayerView.onPlayerPlaying();
        }
        if (this.mUTReportListener == null || (xsVar = this.mDataHolder) == null || xsVar.e() == null || this.mDataHolder.c() == null) {
            return;
        }
        this.mUTReportListener.playStart(this.mDataHolder.e().getVid());
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPositionChange(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-633539481")) {
            ipChange.ipc$dispatch("-633539481", new Object[]{this, obj});
        } else {
            this.mBottomView.playViewGone();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPrepared(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-286752733")) {
            ipChange.ipc$dispatch("-286752733", new Object[]{this, obj});
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPreparing(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-197017538")) {
            ipChange.ipc$dispatch("-197017538", new Object[]{this, obj});
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onReloadSo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-872698608")) {
            ipChange.ipc$dispatch("-872698608", new Object[]{this});
            return;
        }
        DMVideoPlayerDefaultErrorView dMVideoPlayerDefaultErrorView = this.mErrorView;
        if (dMVideoPlayerDefaultErrorView != null) {
            dMVideoPlayerDefaultErrorView.setVisibility(8);
        }
        IpVideoPlayerView ipVideoPlayerView = this.mBottomView;
        if (ipVideoPlayerView != null) {
            ipVideoPlayerView.onReloadSo();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onReloadSoFailed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1284477779")) {
            ipChange.ipc$dispatch("1284477779", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "-133394761")) {
            ipChange.ipc$dispatch("-133394761", new Object[]{this});
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onScreenModeChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "849170068")) {
            ipChange.ipc$dispatch("849170068", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onSoLoadFailed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-446417306")) {
            ipChange.ipc$dispatch("-446417306", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "1290171947")) {
            ipChange.ipc$dispatch("1290171947", new Object[]{this});
            return;
        }
        IpVideoPlayerView ipVideoPlayerView = this.mBottomView;
        if (ipVideoPlayerView != null) {
            ipVideoPlayerView.refresh();
        }
    }

    public void setBottomPadding(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-797147005")) {
            ipChange.ipc$dispatch("-797147005", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        IpVideoPlayerView ipVideoPlayerView = this.mBottomView;
        if (ipVideoPlayerView != null) {
            ipVideoPlayerView.setPaddingBottom(i);
        }
    }

    public void setPresenter(BasePresenter basePresenter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1460568747")) {
            ipChange.ipc$dispatch("1460568747", new Object[]{this, basePresenter});
            return;
        }
        this.presenter = basePresenter;
        IpVideoPlayerView ipVideoPlayerView = this.mBottomView;
        if (ipVideoPlayerView != null) {
            ipVideoPlayerView.setPresenter(basePresenter);
        }
    }

    public void setUTReportListener(OnPlayerUTReportListener onPlayerUTReportListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1182518261")) {
            ipChange.ipc$dispatch("1182518261", new Object[]{this, onPlayerUTReportListener});
            return;
        }
        this.mUTReportListener = onPlayerUTReportListener;
        this.mBottomView.registerUTReporter(onPlayerUTReportListener);
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1932851810")) {
            ipChange.ipc$dispatch("1932851810", new Object[]{this});
            return;
        }
        IpVideoPlayerView ipVideoPlayerView = this.mBottomView;
        if (ipVideoPlayerView != null) {
            ipVideoPlayerView.stop();
        }
    }
}
