package com.alibaba.pictures.bricks.component.ipbrand;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.ContentInfo;
import com.alibaba.pictures.bricks.bean.IpDramaBrandArchBean;
import com.alibaba.pictures.bricks.bean.VideoAlbum;
import com.alibaba.pictures.bricks.component.artist.BaccountInfo;
import com.alibaba.pictures.bricks.component.artist.UserTrackInterface;
import com.alibaba.pictures.bricks.component.ipbrand.IpDramaBrandContract;
import com.alibaba.pictures.bricks.onearch.AbsView;
import com.alibaba.pictures.bricks.view.BricksIconFontTextView;
import com.alibaba.pictures.bricks.view.DMDigitTextView;
import com.alibaba.pictures.bricks.view.DMPosterView;
import com.alibaba.pictures.bricks.view.RoundRadiusImageView;
import com.alibaba.pictures.bricks.view.ScoreStarViewV2;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import java.util.ArrayList;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import tb.cs;
import tb.n91;
import tb.s60;
import tb.vh2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class IpDramaBrandView extends AbsView<IItem<ItemValue>, IpDramaBrandContract.Model<IItem<ItemValue>>, IpDramaBrandContract.Presenter<IItem<ItemValue>, IpDramaBrandContract.Model<IItem<ItemValue>>>> implements IpDramaBrandContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    ArtistHorAdapter artistHorAdapter;
    View bottomLine;
    TextView brand_quickreport_ipuv;
    BricksIconFontTextView brand_quickreport_ipuv_icon;
    TextView brand_quickreport_time;
    Context context;
    DMPosterView drama_image;
    FrameLayout drama_image_layout;
    TextView ip_brand_fans_and_show;
    ImageView ip_brand_icon;
    TextView ip_brand_name;
    RelativeLayout ip_brand_quickreport;
    DMPosterView ip_brand_quickreport_img;
    TextView ip_brand_quickreport_title;
    TextView ip_brand_right_layout_page;
    LinearLayout ip_brand_right_layout_score;
    DMDigitTextView ip_brand_score;
    ScoreStarViewV2 ip_brand_score_star_view;
    LinearLayout ip_brand_top_layout;
    TextView ip_brand_video_time;
    RoundRadiusImageView ip_music_avatar_avatar;
    FrameLayout ip_music_brand_avatar_layout;
    RecyclerView ircArtist;
    TextView show_city;
    ImageView vip_tag;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements UserTrackInterface {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // com.alibaba.pictures.bricks.component.artist.UserTrackInterface
        public void userTrackClick(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "53422190")) {
                ipChange.ipc$dispatch("53422190", new Object[]{this, str, Integer.valueOf(i)});
            } else {
                ((IpDramaBrandContract.Presenter) IpDramaBrandView.this.presenter).artistTrackClick(str, i);
            }
        }

        @Override // com.alibaba.pictures.bricks.component.artist.UserTrackInterface
        public void userTrackExpose(View view, String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1808243674")) {
                ipChange.ipc$dispatch("1808243674", new Object[]{this, view, str, Integer.valueOf(i)});
            } else {
                ((IpDramaBrandContract.Presenter) IpDramaBrandView.this.presenter).artistTrackExpose(view, str, i);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-644374715")) {
                ipChange.ipc$dispatch("-644374715", new Object[]{this, view});
            } else {
                ((IpDramaBrandContract.Presenter) IpDramaBrandView.this.presenter).gotoIpDramaBrandPage();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ VideoAlbum a;

        c(VideoAlbum videoAlbum) {
            this.a = videoAlbum;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1466915654")) {
                ipChange.ipc$dispatch("1466915654", new Object[]{this, view});
                return;
            }
            ((IpDramaBrandContract.Presenter) IpDramaBrandView.this.presenter).contentTrackClick(this.a.getId());
            Action action = new Action();
            action.setActionType(1);
            ContentInfo contentInfo = this.a.contentInfo;
            if (contentInfo != null && !TextUtils.isEmpty(contentInfo.schema)) {
                action.setActionUrl(this.a.contentInfo.schema);
            } else {
                action.setActionUrl(new Uri.Builder().scheme("damai").authority(cs.DISCOVER_CONTENT_DETAIL).build().toString());
                Bundle bundle = new Bundle();
                bundle.putString("contentId", this.a.getId());
                action.setExtra(bundle);
            }
            NavProviderProxy.getProxy().toUri(IpDramaBrandView.this.context, action);
        }
    }

    public IpDramaBrandView(View view) {
        super(view);
        this.context = view.getContext();
        this.ip_brand_top_layout = (LinearLayout) view.findViewById(R$id.ip_brand_top_layout);
        this.ip_music_brand_avatar_layout = (FrameLayout) view.findViewById(R$id.ip_music_brand_avatar_layout);
        this.ip_music_avatar_avatar = (RoundRadiusImageView) view.findViewById(R$id.ip_music_avatar_avatar);
        this.vip_tag = (ImageView) view.findViewById(R$id.vip_tag);
        this.drama_image_layout = (FrameLayout) view.findViewById(R$id.drama_image_layout);
        this.drama_image = (DMPosterView) view.findViewById(R$id.drama_image);
        this.ip_brand_name = (TextView) view.findViewById(R$id.ip_brand_name);
        this.ip_brand_icon = (ImageView) view.findViewById(R$id.ip_brand_icon);
        this.ip_brand_fans_and_show = (TextView) view.findViewById(R$id.ip_brand_fans_and_show);
        this.show_city = (TextView) view.findViewById(R$id.show_city);
        this.ip_brand_right_layout_page = (TextView) view.findViewById(R$id.ip_brand_right_layout_page);
        this.ip_brand_right_layout_score = (LinearLayout) view.findViewById(R$id.ip_brand_right_layout_score);
        this.ip_brand_score = (DMDigitTextView) view.findViewById(R$id.ip_brand_score);
        this.ip_brand_score_star_view = (ScoreStarViewV2) view.findViewById(R$id.ip_brand_score_star_view);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.ip_brand_artist);
        this.ircArtist = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.context, 0, false));
        ArtistHorAdapter artistHorAdapter = new ArtistHorAdapter(this.context);
        this.artistHorAdapter = artistHorAdapter;
        this.ircArtist.setAdapter(artistHorAdapter);
        this.artistHorAdapter.d(new a());
        this.ip_brand_quickreport = (RelativeLayout) view.findViewById(R$id.ip_brand_quickreport);
        this.ip_brand_quickreport_img = (DMPosterView) view.findViewById(R$id.ip_brand_quickreport_img);
        this.ip_brand_quickreport_title = (TextView) view.findViewById(R$id.ip_brand_quickreport_title);
        this.brand_quickreport_time = (TextView) view.findViewById(R$id.brand_quickreport_time);
        this.brand_quickreport_ipuv_icon = (BricksIconFontTextView) view.findViewById(R$id.brand_quickreport_ipuv_icon);
        this.brand_quickreport_ipuv = (TextView) view.findViewById(R$id.brand_quickreport_ipuv);
        this.ip_brand_video_time = (TextView) view.findViewById(R$id.ip_brand_video_time);
        this.bottomLine = view.findViewById(R$id.item_bottom_line);
        this.ip_brand_top_layout.setOnClickListener(new b());
    }

    private void imgShow(DMPosterView dMPosterView, String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-391031730")) {
            ipChange.ipc$dispatch("-391031730", new Object[]{this, dMPosterView, str, Boolean.valueOf(z)});
            return;
        }
        dMPosterView.setPlaceholder(R$drawable.bricks_uikit_default_image_bg_gradient);
        dMPosterView.setImageUrl(str);
        dMPosterView.getImageView().setGifRoundCornerSupport(true);
        dMPosterView.getImageView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (z) {
            dMPosterView.setVideoIconVisibility(0);
        } else {
            dMPosterView.setVideoIconVisibility(8);
        }
    }

    private void setViewGone(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1861144399")) {
            ipChange.ipc$dispatch("1861144399", new Object[]{this, view, Integer.valueOf(i)});
        } else if (view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.ipbrand.IpDramaBrandContract.View
    public void artistView(String str, ArrayList<BaccountInfo> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "212819174")) {
            ipChange.ipc$dispatch("212819174", new Object[]{this, str, arrayList});
        } else if (!"brand".equals(str) && n91.a(arrayList) > 1) {
            setViewGone(this.ircArtist, 0);
            this.artistHorAdapter.e(arrayList);
        } else {
            setViewGone(this.ircArtist, 8);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.ipbrand.IpDramaBrandContract.View
    public RelativeLayout getContentLayout() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-922193879") ? (RelativeLayout) ipChange.ipc$dispatch("-922193879", new Object[]{this}) : this.ip_brand_quickreport;
    }

    @Override // com.alibaba.pictures.bricks.component.ipbrand.IpDramaBrandContract.View
    public LinearLayout getTopLayout() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1071005996") ? (LinearLayout) ipChange.ipc$dispatch("-1071005996", new Object[]{this}) : this.ip_brand_top_layout;
    }

    @Override // com.alibaba.pictures.bricks.component.ipbrand.IpDramaBrandContract.View
    public void informationView(String str, ArrayList<VideoAlbum> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-369874227")) {
            ipChange.ipc$dispatch("-369874227", new Object[]{this, str, arrayList});
        } else if ("brand".equals(str) && n91.a(arrayList) > 0 && arrayList.get(0) != null) {
            VideoAlbum videoAlbum = arrayList.get(0);
            setViewGone(this.ip_brand_quickreport, 0);
            ((IpDramaBrandContract.Presenter) this.presenter).contentTrackExpose(videoAlbum.getId());
            String pic = videoAlbum.getPic();
            int i = videoAlbum.contentTag;
            if (i > 0) {
                if (i == 1) {
                    if (n91.a(videoAlbum.imgList) > 0) {
                        Drawable drawable = this.context.getResources().getDrawable(R$drawable.bricks_icon_nine_grid_pic_indicator);
                        int b2 = s60.INSTANCE.b(this.context, 10);
                        drawable.setBounds(0, 0, b2, b2);
                        this.ip_brand_video_time.setCompoundDrawables(drawable, null, null, null);
                        TextView textView = this.ip_brand_video_time;
                        textView.setText(AltriaXLaunchTime.SPACE + videoAlbum.imgList.size());
                    } else {
                        this.ip_brand_video_time.setText("图文");
                    }
                    String pic2 = videoAlbum.getPic();
                    setViewGone(this.ip_brand_video_time, 0);
                    imgShow(this.ip_brand_quickreport_img, pic2, false);
                } else if (i == 2) {
                    this.ip_brand_video_time.setCompoundDrawables(null, null, null, null);
                    if (videoAlbum.getVideoInfo() != null) {
                        if (!TextUtils.isEmpty(videoAlbum.getVideoInfo().getCoverUrl())) {
                            pic = videoAlbum.getVideoInfo().getCoverUrl();
                        }
                        if (videoAlbum.getVideoInfo().getVideoTime() > 0) {
                            this.ip_brand_video_time.setText(vh2.INSTANCE.h(videoAlbum.getVideoInfo().getVideoTime()));
                            setViewGone(this.ip_brand_video_time, 0);
                        } else {
                            setViewGone(this.ip_brand_video_time, 8);
                        }
                    }
                    imgShow(this.ip_brand_quickreport_img, pic, true);
                    this.ip_brand_quickreport_img.setVideoIconSize(24.0f, 40.0f, 26.0f);
                }
                setViewGone(this.ip_brand_quickreport_img, 0);
            } else {
                setViewGone(this.ip_brand_video_time, 8);
                setViewGone(this.ip_brand_quickreport_img, 8);
            }
            ContentInfo contentInfo = videoAlbum.contentInfo;
            if (contentInfo != null && !TextUtils.isEmpty(contentInfo.title)) {
                this.ip_brand_quickreport_title.setText(videoAlbum.contentInfo.title);
                setViewGone(this.ip_brand_quickreport_title, 0);
            } else {
                setViewGone(this.ip_brand_quickreport_title, 8);
            }
            if (!TextUtils.isEmpty(videoAlbum.publishTimeStr)) {
                this.brand_quickreport_time.setText(videoAlbum.publishTimeStr);
                setViewGone(this.brand_quickreport_time, 0);
            } else {
                setViewGone(this.brand_quickreport_time, 8);
            }
            if (!TextUtils.isEmpty(videoAlbum.ipvuv)) {
                this.brand_quickreport_ipuv.setText(videoAlbum.ipvuv);
                setViewGone(this.brand_quickreport_ipuv_icon, 0);
                setViewGone(this.brand_quickreport_ipuv, 0);
            } else {
                setViewGone(this.brand_quickreport_ipuv_icon, 8);
                setViewGone(this.brand_quickreport_ipuv, 8);
            }
            this.ip_brand_quickreport.setOnClickListener(new c(videoAlbum));
        } else {
            setViewGone(this.ip_brand_quickreport, 8);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.ipbrand.IpDramaBrandContract.View
    public void ipBrandCenterView(IpDramaBrandArchBean ipDramaBrandArchBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1229503697")) {
            ipChange.ipc$dispatch("-1229503697", new Object[]{this, ipDramaBrandArchBean});
            return;
        }
        if (!TextUtils.isEmpty(ipDramaBrandArchBean.name)) {
            setViewGone(this.ip_brand_name, 0);
            this.ip_brand_name.setText(ipDramaBrandArchBean.name);
        } else {
            setViewGone(this.ip_brand_name, 8);
        }
        int tagImageResourceRid = ipDramaBrandArchBean.getTagImageResourceRid();
        if (tagImageResourceRid != -1) {
            this.ip_brand_icon.setImageResource(tagImageResourceRid);
            this.ip_brand_icon.setVisibility(0);
        } else {
            this.ip_brand_icon.setVisibility(8);
        }
        String str = "";
        SpannableString spannableString = new SpannableString("");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#000000"));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(Color.parseColor("#000000"));
        if (!TextUtils.isEmpty(ipDramaBrandArchBean.fansCount)) {
            str = ipDramaBrandArchBean.fansCount + " 粉丝";
        }
        if ("brand".equals(ipDramaBrandArchBean.getIpBrandType())) {
            if (!TextUtils.isEmpty(ipDramaBrandArchBean.performanceCount)) {
                if (!TextUtils.isEmpty(ipDramaBrandArchBean.fansCount)) {
                    str = str + " | " + ipDramaBrandArchBean.performanceCount + "场 在售演出";
                } else {
                    str = ipDramaBrandArchBean.performanceCount + "场 在售演出";
                }
            }
            if (!TextUtils.isEmpty(str)) {
                spannableString = new SpannableString(str);
                if (!TextUtils.isEmpty(ipDramaBrandArchBean.fansCount)) {
                    spannableString.setSpan(foregroundColorSpan2, 0, ipDramaBrandArchBean.fansCount.length(), 33);
                }
                if (!TextUtils.isEmpty(ipDramaBrandArchBean.performanceCount)) {
                    spannableString.setSpan(foregroundColorSpan, (str.length() - 6) - ipDramaBrandArchBean.performanceCount.length(), (str.length() - 6) + 1, 33);
                }
            }
        } else if (!TextUtils.isEmpty(ipDramaBrandArchBean.fansCount)) {
            spannableString = new SpannableString(str);
            spannableString.setSpan(foregroundColorSpan, 0, ipDramaBrandArchBean.fansCount.length(), 33);
        }
        if (!TextUtils.isEmpty(spannableString.toString())) {
            setViewGone(this.ip_brand_fans_and_show, 0);
            this.ip_brand_fans_and_show.setText(spannableString);
        } else {
            setViewGone(this.ip_brand_fans_and_show, 8);
        }
        if (!"brand".equals(ipDramaBrandArchBean.getIpBrandType()) && !TextUtils.isEmpty(ipDramaBrandArchBean.tourInfos)) {
            setViewGone(this.show_city, 0);
            this.show_city.setText(ipDramaBrandArchBean.tourInfos);
            return;
        }
        setViewGone(this.show_city, 8);
    }

    @Override // com.alibaba.pictures.bricks.component.ipbrand.IpDramaBrandContract.View
    public void ipBrandLeftView(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-273137336")) {
            ipChange.ipc$dispatch("-273137336", new Object[]{this, str, str2, Boolean.valueOf(z)});
        } else if (!"drama".equals(str)) {
            setViewGone(this.ip_music_brand_avatar_layout, 0);
            setViewGone(this.drama_image_layout, 8);
            ImageLoaderProviderProxy.getProxy().loadinto(str2, this.ip_music_avatar_avatar);
            if (z) {
                setViewGone(this.vip_tag, 0);
            } else {
                setViewGone(this.vip_tag, 8);
            }
        } else {
            setViewGone(this.ip_music_brand_avatar_layout, 8);
            setViewGone(this.drama_image_layout, 0);
            this.drama_image.setImageUrl(str2);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.ipbrand.IpDramaBrandContract.View
    public void ipBrandRightView(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-722404327")) {
            ipChange.ipc$dispatch("-722404327", new Object[]{this, str, str2});
        } else if (!TextUtils.isEmpty(str2) && !"brand".equals(str)) {
            setViewGone(this.ip_brand_right_layout_page, 8);
            setViewGone(this.ip_brand_right_layout_score, 0);
            DMDigitTextView dMDigitTextView = this.ip_brand_score;
            dMDigitTextView.setText(str2 + "");
            try {
                this.ip_brand_score_star_view.updateView(Float.parseFloat(str2));
                setViewGone(this.ip_brand_score_star_view, 0);
            } catch (Exception unused) {
                setViewGone(this.ip_brand_score_star_view, 8);
            }
        } else {
            setViewGone(this.ip_brand_right_layout_page, 0);
            setViewGone(this.ip_brand_right_layout_score, 8);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.ipbrand.IpDramaBrandContract.View
    public void setBottomLine(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1794844241")) {
            ipChange.ipc$dispatch("1794844241", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            setViewGone(this.bottomLine, 0);
        } else {
            setViewGone(this.bottomLine, 8);
        }
    }
}
