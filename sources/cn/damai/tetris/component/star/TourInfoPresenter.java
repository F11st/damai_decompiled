package cn.damai.tetris.component.star;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.video.ProxyVideoView;
import cn.damai.player.video.opt.MultiConditionPlayOptHelper;
import cn.damai.tetris.component.star.TourInfoContract;
import cn.damai.tetris.component.star.bean.TourCityItem;
import cn.damai.tetris.component.star.bean.TourInfoBean;
import cn.damai.tetris.component.star.bean.TourInfoItem;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.uikit.image.C2497a;
import cn.damai.uikit.nav.INav;
import cn.damai.uikit.nav.NavProxy;
import cn.damai.uikit.view.DMLabelType;
import cn.damai.uikit.view.DMPosterView;
import cn.damai.user.star.StarIndexFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.C9175gc;
import tb.ja;
import tb.ol;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TourInfoPresenter extends BasePresenter<TourInfoContract.Model, TourInfoView, BaseSection> implements TourInfoContract.Presenter<TourInfoContract.Model, TourInfoView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private MultiConditionPlayOptHelper mOptHelper;
    private TrackInfo mTrackInfo;
    private ProxyVideoView mVideoView;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.star.TourInfoPresenter$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1955a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TourInfoBean a;

        View$OnClickListenerC1955a(TourInfoBean tourInfoBean) {
            this.a = tourInfoBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "101589797")) {
                ipChange.ipc$dispatch("101589797", new Object[]{this, view});
            } else if (this.a.getTourCities().get(0) != null) {
                INav from = NavProxy.from(((BasePresenter) TourInfoPresenter.this).mContext.getActivity());
                from.toUri("damai://projectDetail?id=" + this.a.getTourCities().get(0).getItemId());
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.star.TourInfoPresenter$b */
    /* loaded from: classes16.dex */
    public class View$OnAttachStateChangeListenerC1956b implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnAttachStateChangeListenerC1956b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1276402320")) {
                ipChange.ipc$dispatch("1276402320", new Object[]{this, view});
            } else if (view.getParent() instanceof RecyclerView) {
                TourInfoPresenter tourInfoPresenter = TourInfoPresenter.this;
                tourInfoPresenter.mOptHelper = new MultiConditionPlayOptHelper((RecyclerView) view.getParent(), view, tourInfoPresenter.mVideoView);
                TourInfoPresenter.this.mVideoView.setOptHelper(TourInfoPresenter.this.mOptHelper);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1614513395")) {
                ipChange.ipc$dispatch("-1614513395", new Object[]{this, view});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.star.TourInfoPresenter$c */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1957c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TourCityItem a;
        final /* synthetic */ int b;

        View$OnClickListenerC1957c(TourCityItem tourCityItem, int i) {
            this.a = tourCityItem;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "29203239")) {
                ipChange.ipc$dispatch("29203239", new Object[]{this, view});
                return;
            }
            INav from = NavProxy.from(((BasePresenter) TourInfoPresenter.this).mContext.getActivity());
            from.toUri("damai://projectDetail?id=" + this.a.getItemId());
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", this.a.getItemId() + "");
            if (TourInfoPresenter.this.mTrackInfo.getArgsMap() != null) {
                hashMap.putAll(TourInfoPresenter.this.mTrackInfo.getArgsMap());
            }
            TourInfoPresenter tourInfoPresenter = TourInfoPresenter.this;
            tourInfoPresenter.userTrackClick("tour_item_" + this.b, hashMap, true);
        }
    }

    public TourInfoPresenter(TourInfoView tourInfoView, String str, ja jaVar) {
        super(tourInfoView, str, jaVar);
    }

    private void addCities(List<TourCityItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1381330966")) {
            ipChange.ipc$dispatch("-1381330966", new Object[]{this, list});
        } else if (list != null && list.size() != 0) {
            LinearLayout linearLayout = (LinearLayout) getView().getTourCityView().findViewById(R$id.star_tour_info_cities_parent);
            linearLayout.removeAllViews();
            boolean z = false;
            for (int i = 0; i < list.size() && !z; i++) {
                if (!TextUtils.isEmpty(list.get(i).tourCityPic)) {
                    z = true;
                }
            }
            int i2 = 0;
            while (i2 < list.size()) {
                View inflate = LayoutInflater.from(this.mContext.getActivity()).inflate(R$layout.layout_star_tour_cityitem, (ViewGroup) linearLayout, false);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
                layoutParams.setMargins(i2 == 0 ? q60.a(this.mContext.getActivity(), 21.0f) : 0, 0, q60.a(this.mContext.getActivity(), 12.0f), 0);
                linearLayout.addView(inflate, layoutParams);
                bindCity(inflate, list.get(i2), z, i2);
                i2++;
            }
        }
    }

    private void addTags(List<String> list, ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2021459303")) {
            ipChange.ipc$dispatch("-2021459303", new Object[]{this, list, viewGroup});
        } else if (list != null && list.size() != 0) {
            LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R$id.kv_star_tour_info_tags_parent);
            linearLayout.removeAllViews();
            for (int i = 0; i < list.size(); i++) {
                View inflate = LayoutInflater.from(this.mContext.getActivity()).inflate(R$layout.layout_videoinfo_ip_tag, (ViewGroup) linearLayout, false);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
                layoutParams.setMargins(0, 0, q60.a(this.mContext.getActivity(), 3.0f), 0);
                linearLayout.addView(inflate, layoutParams);
                bindTag(inflate, list.get(i));
                userTrackExpose(inflate, "tag_" + i);
            }
        }
    }

    private void bindBaseInfo(TourInfoItem tourInfoItem, ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1138365841")) {
            ipChange.ipc$dispatch("1138365841", new Object[]{this, tourInfoItem, viewGroup});
            return;
        }
        C9175gc.a((TextView) viewGroup.findViewById(R$id.kv_star_tour_info_pricevalue), tourInfoItem.getTourPriceLow());
        C9175gc.a((TextView) viewGroup.findViewById(R$id.kv_star_tour_info_name), tourInfoItem.getTourName());
        C9175gc.a((TextView) viewGroup.findViewById(R$id.kv_star_tour_info_desc), tourInfoItem.getTourDesc());
    }

    private void bindCity(View view, TourCityItem tourCityItem, boolean z, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "219739084")) {
            ipChange.ipc$dispatch("219739084", new Object[]{this, view, tourCityItem, Boolean.valueOf(z), Integer.valueOf(i)});
            return;
        }
        C9175gc.a((TextView) view.findViewById(R$id.star_tour_info_cityname), tourCityItem.getCityName());
        C9175gc.a((TextView) view.findViewById(R$id.star_tour_info_citydesc), tourCityItem.getVenueName());
        C9175gc.a((TextView) view.findViewById(R$id.star_tour_info_citydate), tourCityItem.getShowTime());
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", tourCityItem.getItemId() + "");
        if (this.mTrackInfo.getArgsMap() != null) {
            hashMap.putAll(this.mTrackInfo.getArgsMap());
        }
        userTrackExpose(view, "tour_item_" + i);
        view.setOnClickListener(new View$OnClickListenerC1957c(tourCityItem, i));
        if (!TextUtils.isEmpty(tourCityItem.tourCityPic)) {
            int i2 = R$id.star_tour_info_cityimg;
            view.findViewById(i2).setVisibility(0);
            C2497a.a().loadinto(tourCityItem.tourCityPic, (ImageView) view.findViewById(i2));
        } else if (z) {
            view.findViewById(R$id.star_tour_info_cityimg).setVisibility(0);
        } else {
            view.findViewById(R$id.star_tour_info_cityimg).setVisibility(8);
        }
    }

    private void bindTag(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-643529450")) {
            ipChange.ipc$dispatch("-643529450", new Object[]{this, view, str});
            return;
        }
        int i = R$id.tv_ipinfo_tagleft;
        C9175gc.a((TextView) view.findViewById(i), str);
        ((TextView) view.findViewById(i)).setTextColor(this.mContext.getActivity().getResources().getColor(R$color.color_FF993A));
        view.findViewById(R$id.tv_ipinfo_tagbg).setBackground(this.mContext.getActivity().getResources().getDrawable(R$drawable.bg_border_iptag_ff993a));
    }

    private void hideAndStopVideo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "661104707")) {
            ipChange.ipc$dispatch("661104707", new Object[]{this});
            return;
        }
        ProxyVideoView videoView = getView().getVideoView();
        videoView.setVisibility(8);
        videoView.stop();
    }

    private void showAndPlayVideo(TourInfoBean tourInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1596041596")) {
            ipChange.ipc$dispatch("-1596041596", new Object[]{this, tourInfoBean});
            return;
        }
        ProxyVideoView videoView = getView().getVideoView();
        this.mVideoView = videoView;
        videoView.setVisibility(0);
        this.mVideoView.mute(true);
        TrackInfo trackInfo = this.mTrackInfo;
        this.mVideoView.setListener(new ol(getContext().getActivity(), this.mVideoView, trackInfo == null ? StarIndexFragment.Default_PAGE : trackInfo.trackB, trackInfo == null ? "anchor_tour" : trackInfo.trackC));
        getView().getView().addOnAttachStateChangeListener(new View$OnAttachStateChangeListenerC1956b());
        VideoInfo videoInfo = new VideoInfo();
        if (!TextUtils.isEmpty(tourInfoBean.contentVideoUrl)) {
            videoInfo.setVideoUrl(tourInfoBean.contentVideoUrl);
            videoInfo.setType(VideoInfo.VideoType.VIDEO_URL);
        } else {
            videoInfo.setVid(tourInfoBean.getTourVideoUrl());
            videoInfo.setType(VideoInfo.VideoType.VIDEO_VID);
        }
        videoInfo.setPicUrl(tourInfoBean.getTourVideoCover());
        if (tourInfoBean.getTourInfo() != null) {
            videoInfo.setSourceLabel(tourInfoBean.getTourInfo().getTourName());
        }
        this.mVideoView.setVideoInfo(videoInfo);
        this.mVideoView.autoPlay();
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-780830236")) {
            ipChange.ipc$dispatch("-780830236", new Object[]{this, Integer.valueOf(i), obj});
        } else if (getView() == null || this.mVideoView == null) {
        } else {
            switch (i) {
                case 11001:
                    if (obj instanceof Boolean) {
                        MultiConditionPlayOptHelper multiConditionPlayOptHelper = this.mOptHelper;
                        if (multiConditionPlayOptHelper != null) {
                            multiConditionPlayOptHelper.a(((Boolean) obj).booleanValue());
                        }
                        if (((Boolean) obj).booleanValue()) {
                            this.mVideoView.start();
                            return;
                        } else {
                            this.mVideoView.pause();
                            return;
                        }
                    }
                    return;
                case 11002:
                default:
                    return;
                case 11003:
                    MultiConditionPlayOptHelper multiConditionPlayOptHelper2 = this.mOptHelper;
                    if (multiConditionPlayOptHelper2 != null) {
                        multiConditionPlayOptHelper2.a(false);
                    }
                    this.mVideoView.pause();
                    return;
                case 11004:
                    MultiConditionPlayOptHelper multiConditionPlayOptHelper3 = this.mOptHelper;
                    if (multiConditionPlayOptHelper3 != null) {
                        multiConditionPlayOptHelper3.a(false);
                    }
                    this.mVideoView.release();
                    return;
                case 11005:
                    MultiConditionPlayOptHelper multiConditionPlayOptHelper4 = this.mOptHelper;
                    if (multiConditionPlayOptHelper4 != null) {
                        multiConditionPlayOptHelper4.a(true);
                    }
                    this.mVideoView.start();
                    return;
            }
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(TourInfoContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-656720483")) {
            ipChange.ipc$dispatch("-656720483", new Object[]{this, model});
            return;
        }
        this.mTrackInfo = model.getTrackInfo();
        TourInfoBean data = model.getData();
        if (data == null) {
            return;
        }
        if (!TextUtils.isEmpty(data.getTourVideoUrl())) {
            showAndPlayVideo(data);
            if (data.getTourInfo() != null) {
                TourInfoItem tourInfo = data.getTourInfo();
                bindBaseInfo(tourInfo, getView().getKVInfoView());
                addTags(tourInfo.getTourTags(), getView().getKVInfoView());
            }
        } else {
            hideAndStopVideo();
            if (data.getTourInfo() != null) {
                getView().getKVInfoView().setVisibility(8);
                getView().getNKVInfoView().setVisibility(0);
                getView().getNKVInfoView().removeAllViews();
                View inflate = LayoutInflater.from(getContext().getActivity()).inflate(R$layout.layout_star_card_tourinfo_projinfo, getView().getNKVInfoView(), false);
                getView().getNKVInfoView().addView(inflate);
                TourInfoItem tourInfo2 = data.getTourInfo();
                DMPosterView dMPosterView = (DMPosterView) inflate.findViewById(R$id.kv_star_tour_info_img);
                dMPosterView.setImageUrl(tourInfo2.getTourPic());
                dMPosterView.setLabelType(DMLabelType.LABEL_TYPE_TOUR);
                bindBaseInfo(tourInfo2, getView().getNKVInfoView());
                addTags(tourInfo2.getTourTags(), getView().getNKVInfoView());
            }
        }
        if (data.getTourCities() == null || data.getTourCities().size() <= 0) {
            return;
        }
        addCities(data.getTourCities());
        View$OnClickListenerC1955a view$OnClickListenerC1955a = new View$OnClickListenerC1955a(data);
        getView().getKVInfoView().setOnClickListener(view$OnClickListenerC1955a);
        getView().getNKVInfoView().setOnClickListener(view$OnClickListenerC1955a);
    }
}
