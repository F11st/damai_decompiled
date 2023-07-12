package cn.damai.tetris.component.live.mvp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.DMVideoPlayer;
import cn.damai.player.controller.discover.DMVideoPlayerDiscoverController;
import cn.damai.tetris.component.discover.bean.VideoInfo;
import cn.damai.tetris.component.live.bean.LiveHeaderPicBean;
import cn.damai.tetris.core.AbsView;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.ut.TrackType;
import cn.damai.uikit.banner.Banner;
import cn.damai.uikit.banner.listener.OnBannerListener;
import cn.damai.uikit.banner.transformer.AlphaTransformer;
import cn.damai.uikit.scrollsky.SendYouToTheSkyView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import tb.f91;
import tb.l62;
import tb.pb;
import tb.ys;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class HeaderView extends AbsView<HeaderContract$Presenter> implements HeaderContract$View<HeaderContract$Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Banner mBannerView;
    private LiveHeaderPicBean mBean;
    private View mBgView;
    private int[] mColors;
    private Context mContext;
    private DMVideoPlayerDiscoverController mController;
    private ys mDMVideoPlayerManager;
    private TextView mDescTv;
    private View mHeaderView;
    private View mIconImgView;
    private SendYouToTheSkyView mSkyView;
    private TextView mTitleTv;
    private DMVideoPlayer mVideoPlayerView;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements OnBannerListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ LiveHeaderPicBean a;

        a(LiveHeaderPicBean liveHeaderPicBean) {
            this.a = liveHeaderPicBean;
        }

        @Override // cn.damai.uikit.banner.listener.OnBannerListener
        public void OnBannerClick(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "709705904")) {
                ipChange.ipc$dispatch("709705904", new Object[]{this, Integer.valueOf(i)});
            } else {
                HeaderView.this.getPresenter().headerClick(this.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ LiveHeaderPicBean a;

        b(LiveHeaderPicBean liveHeaderPicBean) {
            this.a = liveHeaderPicBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1164427092")) {
                ipChange.ipc$dispatch("-1164427092", new Object[]{this, view});
            } else {
                HeaderView.this.getPresenter().headerClick(this.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ LiveHeaderPicBean a;

        c(LiveHeaderPicBean liveHeaderPicBean) {
            this.a = liveHeaderPicBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "946863277")) {
                ipChange.ipc$dispatch("946863277", new Object[]{this, view});
            } else {
                HeaderView.this.getPresenter().headerClick(this.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class d implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1713586184")) {
                ipChange.ipc$dispatch("1713586184", new Object[]{this, view});
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1907352197")) {
                ipChange.ipc$dispatch("1907352197", new Object[]{this, view});
            } else {
                HeaderView.this.mBannerView.stopAutoPlay();
            }
        }
    }

    public HeaderView(View view) {
        super(view);
        this.mColors = new int[]{Color.parseColor("#00000000"), Color.parseColor("#0a000000"), Color.parseColor("#19000000"), Color.parseColor("#45000000"), Color.parseColor("#70000000"), Color.parseColor("#99000000"), Color.parseColor("#dd000000"), Color.parseColor("#ff000000"), Color.parseColor("#ff000000"), Color.parseColor("#ff000000")};
        this.mContext = view.getContext();
        this.mHeaderView = view.findViewById(R$id.layout_header);
        this.mDMVideoPlayerManager = ys.d();
        this.mVideoPlayerView = (DMVideoPlayer) view.findViewById(R$id.player);
        DMVideoPlayerDiscoverController dMVideoPlayerDiscoverController = new DMVideoPlayerDiscoverController(this.mContext);
        this.mController = dMVideoPlayerDiscoverController;
        dMVideoPlayerDiscoverController.setAutoReport(true);
        this.mController.setSpmData("live", "video");
        this.mVideoPlayerView.setController(this.mController);
        this.mDMVideoPlayerManager.k(this.mVideoPlayerView);
        this.mBgView = view.findViewById(R$id.view_bg);
        this.mBannerView = (Banner) view.findViewById(R$id.banner);
        this.mSkyView = (SendYouToTheSkyView) view.findViewById(R$id.sky_view);
        this.mTitleTv = (TextView) view.findViewById(R$id.tv_title);
        this.mIconImgView = view.findViewById(R$id.img_video);
        this.mDescTv = (TextView) view.findViewById(R$id.tv_desc);
        bannerSetting();
    }

    @SuppressLint({"NewApi"})
    private void bannerSetting() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-445127495")) {
            ipChange.ipc$dispatch("-445127495", new Object[]{this});
            return;
        }
        this.mBannerView.setBannerStyle(0);
        this.mBannerView.setImageLoader(new BannerImageLoader());
        this.mBannerView.setImages(new ArrayList());
        this.mBannerView.setPageTransformer(true, new AlphaTransformer());
        this.mBannerView.setOffscreenPageLimit(5);
        this.mBannerView.setImageClipChildren(false);
        this.mBannerView.setPageMargin(l62.a(this.mContext, 0.0f));
        this.mBannerView.setViewPagerLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mBannerView.isAutoPlay(true);
        this.mBannerView.setIndicatorGravity(5);
        this.mBannerView.start();
        this.mBannerView.addOnAttachStateChangeListener(new d());
    }

    private Drawable newLinearGDrawable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1610952147")) {
            return (Drawable) ipChange.ipc$dispatch("-1610952147", new Object[]{this});
        }
        f91 f91Var = new f91();
        f91Var.b(this.mColors, null);
        return f91Var;
    }

    @Override // cn.damai.tetris.component.live.mvp.HeaderContract$View
    public void setData(LiveHeaderPicBean liveHeaderPicBean) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1318795784")) {
            ipChange.ipc$dispatch("-1318795784", new Object[]{this, liveHeaderPicBean});
        } else if (liveHeaderPicBean == null) {
        } else {
            this.mBean = liveHeaderPicBean;
            String[] strArr = liveHeaderPicBean.themePic;
            this.mIconImgView.setVisibility(liveHeaderPicBean.isShowVideoIcon() ? 0 : 8);
            if (strArr != null && strArr.length > 0) {
                this.mVideoPlayerView.setVisibility(8);
                this.mBannerView.setVisibility(0);
                this.mBannerView.update(Arrays.asList(strArr));
                this.mBannerView.setOnBannerListener(new a(liveHeaderPicBean));
            } else {
                VideoInfo videoInfo = liveHeaderPicBean.videoInfo;
                if (videoInfo != null && !TextUtils.isEmpty(videoInfo.url) && !TextUtils.isEmpty(liveHeaderPicBean.videoInfo.coverUrl)) {
                    this.mBannerView.setVisibility(8);
                    this.mVideoPlayerView.setVisibility(0);
                    cn.damai.commonbusiness.imagebrowse.bean.VideoInfo videoInfo2 = new cn.damai.commonbusiness.imagebrowse.bean.VideoInfo();
                    videoInfo2.setPicUrl(liveHeaderPicBean.videoInfo.coverUrl);
                    videoInfo2.setVideoUrl(liveHeaderPicBean.videoInfo.url);
                    videoInfo2.setType(VideoInfo.VideoType.VIDEO_URL);
                    this.mVideoPlayerView.setVideoData(videoInfo2);
                    this.mVideoPlayerView.mute(0);
                    this.mDMVideoPlayerManager.a();
                    this.mVideoPlayerView.setOnClickListener(new b(liveHeaderPicBean));
                } else {
                    getView().setOnClickListener(new c(liveHeaderPicBean));
                }
            }
            if (getPresenter() != null) {
                HeaderPresenter headerPresenter = (HeaderPresenter) getPresenter();
                if (headerPresenter.mTrackInfo != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("city", headerPresenter.mTrackInfo.get("city") + "");
                    hashMap.put("contentlabel", liveHeaderPicBean.themeName);
                    hashMap.put("usercode", headerPresenter.mTrackInfo.get("usercode") + "");
                    hashMap.put(pb.PRE_CONTENT_ID, liveHeaderPicBean.themeId);
                    hashMap.put(pb.PRE_CONTENT_TYPE, "theme");
                    TrackType trackType = TrackType.expose;
                    SendYouToTheSkyView sendYouToTheSkyView = this.mSkyView;
                    TrackInfo trackInfo = headerPresenter.mTrackInfo;
                    ((HeaderPresenter) getPresenter()).userTrack(trackType, sendYouToTheSkyView, trackInfo.trackB, trackInfo.trackC, "big_pic", hashMap, false);
                }
            }
            this.mSkyView.setData(liveHeaderPicBean.barrage, 4, getContext().getActivity());
            this.mTitleTv.setText(liveHeaderPicBean.themeName);
            if (!TextUtils.isEmpty(liveHeaderPicBean.contentCount)) {
                if (!TextUtils.isEmpty(liveHeaderPicBean.ipvuv)) {
                    str = liveHeaderPicBean.contentCount + " | " + liveHeaderPicBean.ipvuv;
                } else {
                    str = liveHeaderPicBean.contentCount;
                }
            } else {
                str = liveHeaderPicBean.ipvuv;
            }
            this.mDescTv.setText(str);
        }
    }

    public void videoDestory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1243980404")) {
            ipChange.ipc$dispatch("1243980404", new Object[]{this});
            return;
        }
        ys ysVar = this.mDMVideoPlayerManager;
        if (ysVar != null) {
            ysVar.j();
        }
    }

    public void videoPlay() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1829089294")) {
            ipChange.ipc$dispatch("1829089294", new Object[]{this});
            return;
        }
        ys ysVar = this.mDMVideoPlayerManager;
        if (ysVar != null) {
            ysVar.a();
            if (this.mDMVideoPlayerManager.b() != null) {
                this.mDMVideoPlayerManager.b().mute(0);
            }
        }
    }

    public void videoStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "438327424")) {
            ipChange.ipc$dispatch("438327424", new Object[]{this});
            return;
        }
        ys ysVar = this.mDMVideoPlayerManager;
        if (ysVar != null) {
            ysVar.n();
        }
    }
}
