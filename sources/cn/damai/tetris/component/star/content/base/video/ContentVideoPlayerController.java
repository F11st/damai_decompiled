package cn.damai.tetris.component.star.content.base.video;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.FrameLayout;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
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
import tb.cs;
import tb.qx2;
import tb.sx2;
import tb.xs;
import tb.ys;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ContentVideoPlayerController extends DMBaseVideoController implements View.OnClickListener, IVideoController {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isNewRequest;
    private boolean isVideoStart;
    private ContentVideoPlayerView mBottomView;
    private FrameLayout mContainer;
    private xs mDataHolder;
    private DMVideoPlayerDefaultErrorView mErrorView;
    BasePresenter presenter;

    public ContentVideoPlayerController(Context context, BasePresenter basePresenter) {
        super(context);
        this.isNewRequest = false;
        this.isVideoStart = false;
        init();
        this.presenter = basePresenter;
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1503506704")) {
            ipChange.ipc$dispatch("-1503506704", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "-1444140501")) {
            ipChange.ipc$dispatch("-1444140501", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "18458267")) {
            ipChange.ipc$dispatch("18458267", new Object[]{this});
            return;
        }
        this.isNewRequest = false;
        this.isVideoStart = false;
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void assembleLayers() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1118270988")) {
            ipChange.ipc$dispatch("1118270988", new Object[]{this});
            return;
        }
        super.assembleLayers();
        this.mBottomView = new ContentVideoPlayerView(this.mContext, this.mPlayer, this.presenter);
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
        if (AndroidInstantRuntime.support(ipChange, "-707191051")) {
            ipChange.ipc$dispatch("-707191051", new Object[]{this});
            return;
        }
        ContentVideoPlayerView contentVideoPlayerView = this.mBottomView;
        if (contentVideoPlayerView != null) {
            contentVideoPlayerView.changeVideoData();
        }
        DMVideoPlayerDefaultErrorView dMVideoPlayerDefaultErrorView = this.mErrorView;
        if (dMVideoPlayerDefaultErrorView != null) {
            dMVideoPlayerDefaultErrorView.setVisibility(8);
        }
    }

    public ContentVideoPlayerView getBottomView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2073534701") ? (ContentVideoPlayerView) ipChange.ipc$dispatch("2073534701", new Object[]{this}) : this.mBottomView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        xs xsVar;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1699771825")) {
            ipChange.ipc$dispatch("1699771825", new Object[]{this, view});
        } else if (view != this || (xsVar = this.mDataHolder) == null || xsVar.e() == null) {
        } else {
            if (this.mDataHolder.e().getType() == VideoInfo.VideoType.VIDEO_VID) {
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                arrayList.add(this.mDataHolder.e());
                Bundle bundle = new Bundle();
                bundle.putInt("position", 0);
                bundle.putParcelableArrayList("video_info", arrayList);
                NavProxy.from(this.mContext).withExtras(bundle).toUri(INavUri.page("videobrowse"));
            } else if (this.mDataHolder.e().getType() == VideoInfo.VideoType.VIDEO_URL) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("contentId", (String) view.getTag(R$id.offical_content_item_content_id));
                DMNav.from(this.mContext).withExtras(bundle2).toUri(NavUri.b(cs.DISCOVER_CONTENT_DETAIL));
            }
            if (this.presenter != null) {
                try {
                    int intValue = ((Integer) view.getTag(R$id.offical_content_item_index_id)).intValue();
                    BasePresenter basePresenter = this.presenter;
                    basePresenter.userTrackClick("card_" + intValue, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onLoadingEnd(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "912466014")) {
            ipChange.ipc$dispatch("912466014", new Object[]{this, obj});
            return;
        }
        ContentVideoPlayerView contentVideoPlayerView = this.mBottomView;
        if (contentVideoPlayerView != null) {
            contentVideoPlayerView.onLoadingEnd();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onLoadingStart(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1921563959")) {
            ipChange.ipc$dispatch("1921563959", new Object[]{this, obj});
            return;
        }
        ContentVideoPlayerView contentVideoPlayerView = this.mBottomView;
        if (contentVideoPlayerView != null) {
            contentVideoPlayerView.onLoadingStart();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onNewRequest(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1374516338")) {
            ipChange.ipc$dispatch("-1374516338", new Object[]{this, obj});
            return;
        }
        this.isNewRequest = true;
        this.mDataHolder.i(System.currentTimeMillis());
        this.mBottomView.onNewRequest();
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void onPlayScreenModeChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1512701365")) {
            ipChange.ipc$dispatch("-1512701365", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mDataHolder.c().e(i);
        }
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void onPlayStateChanged(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2094568683")) {
            ipChange.ipc$dispatch("-2094568683", new Object[]{this, Integer.valueOf(i), obj});
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
        if (AndroidInstantRuntime.support(ipChange, "-1176031616")) {
            ipChange.ipc$dispatch("-1176031616", new Object[]{this, obj});
            return;
        }
        ContentVideoPlayerView contentVideoPlayerView = this.mBottomView;
        if (contentVideoPlayerView != null) {
            contentVideoPlayerView.onPlayerCompletion();
            reset();
            this.mPlayer.play();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerError(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "323014494")) {
            ipChange.ipc$dispatch("323014494", new Object[]{this, obj});
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerGetVideoInfoFailed(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-940022612")) {
            ipChange.ipc$dispatch("-940022612", new Object[]{this, obj});
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
        if (AndroidInstantRuntime.support(ipChange, "311227958")) {
            ipChange.ipc$dispatch("311227958", new Object[]{this, obj});
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPause(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1469916112")) {
            ipChange.ipc$dispatch("-1469916112", new Object[]{this, obj});
            return;
        }
        ContentVideoPlayerView contentVideoPlayerView = this.mBottomView;
        if (contentVideoPlayerView != null) {
            contentVideoPlayerView.onPlayerPause();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPlaying(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2120121416")) {
            ipChange.ipc$dispatch("-2120121416", new Object[]{this, obj});
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
        ContentVideoPlayerView contentVideoPlayerView = this.mBottomView;
        if (contentVideoPlayerView != null) {
            contentVideoPlayerView.onPlayerPlaying();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPositionChange(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1013028157")) {
            ipChange.ipc$dispatch("-1013028157", new Object[]{this, obj});
        } else {
            this.mBottomView.playViewGone();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPrepared(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "46721919")) {
            ipChange.ipc$dispatch("46721919", new Object[]{this, obj});
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onPlayerPreparing(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1550762082")) {
            ipChange.ipc$dispatch("1550762082", new Object[]{this, obj});
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onReloadSo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "940403820")) {
            ipChange.ipc$dispatch("940403820", new Object[]{this});
            return;
        }
        DMVideoPlayerDefaultErrorView dMVideoPlayerDefaultErrorView = this.mErrorView;
        if (dMVideoPlayerDefaultErrorView != null) {
            dMVideoPlayerDefaultErrorView.setVisibility(8);
        }
        ContentVideoPlayerView contentVideoPlayerView = this.mBottomView;
        if (contentVideoPlayerView != null) {
            contentVideoPlayerView.onReloadSo();
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onReloadSoFailed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1892900271")) {
            ipChange.ipc$dispatch("1892900271", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "1547833307")) {
            ipChange.ipc$dispatch("1547833307", new Object[]{this});
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onScreenModeChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1594062096")) {
            ipChange.ipc$dispatch("-1594062096", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    @Override // cn.damai.player.base.IVideoController
    public void onSoLoadFailed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1770973122")) {
            ipChange.ipc$dispatch("1770973122", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "1966101583")) {
            ipChange.ipc$dispatch("1966101583", new Object[]{this});
            return;
        }
        ContentVideoPlayerView contentVideoPlayerView = this.mBottomView;
        if (contentVideoPlayerView != null) {
            contentVideoPlayerView.refresh();
        }
    }

    public void setBottomPadding(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "884081063")) {
            ipChange.ipc$dispatch("884081063", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ContentVideoPlayerView contentVideoPlayerView = this.mBottomView;
        if (contentVideoPlayerView != null) {
            contentVideoPlayerView.setPaddingBottom(i);
        }
    }

    public void setPresenter(BasePresenter basePresenter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "590470407")) {
            ipChange.ipc$dispatch("590470407", new Object[]{this, basePresenter});
            return;
        }
        this.presenter = basePresenter;
        ContentVideoPlayerView contentVideoPlayerView = this.mBottomView;
        if (contentVideoPlayerView != null) {
            contentVideoPlayerView.setPresenter(basePresenter);
        }
    }

    public void setUTReportListener(OnPlayerUTReportListener onPlayerUTReportListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "538098001")) {
            ipChange.ipc$dispatch("538098001", new Object[]{this, onPlayerUTReportListener});
            return;
        }
        this.mUTReportListener = onPlayerUTReportListener;
        this.mBottomView.registerUTReporter(onPlayerUTReportListener);
    }

    @Override // cn.damai.player.base.DMBaseVideoController
    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1041207618")) {
            ipChange.ipc$dispatch("-1041207618", new Object[]{this});
            return;
        }
        ContentVideoPlayerView contentVideoPlayerView = this.mBottomView;
        if (contentVideoPlayerView != null) {
            contentVideoPlayerView.stop();
        }
    }
}
