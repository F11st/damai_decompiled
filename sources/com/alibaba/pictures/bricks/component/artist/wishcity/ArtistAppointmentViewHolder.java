package com.alibaba.pictures.bricks.component.artist.wishcity;

import android.app.Activity;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.projectfiltercopy.commonview.CitySelectBottomDialog;
import cn.damai.projectfiltercopy.floatview.CityFloatLayer;
import cn.damai.rank.RankSquareCMSActivity;
import com.alibaba.fastjson.JSON;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.R$raw;
import com.alibaba.pictures.R$style;
import com.alibaba.pictures.bricks.bean.ArtistCardBean;
import com.alibaba.pictures.bricks.bean.ArtistFutureBean;
import com.alibaba.pictures.bricks.bean.ArtistTourCityBean;
import com.alibaba.pictures.bricks.bean.ArtistTourNoticeBean;
import com.alibaba.pictures.bricks.bean.BaseArtistDataMo;
import com.alibaba.pictures.bricks.component.artist.wishcity.ArtistAppointmentViewHolder;
import com.alibaba.pictures.bricks.component.artist.wishcity.cityrequest.CityWantRequest;
import com.alibaba.pictures.bricks.component.home.FollowStateBean;
import com.alibaba.pictures.bricks.util.toast.BricksToastUtil;
import com.alibaba.pictures.bricks.view.ArtistCitiesTagView;
import com.alibaba.pictures.bricks.view.ArtistRichTextView;
import com.alibaba.pictures.bricks.view.BaseIconButton;
import com.alibaba.pictures.bricks.view.HWRatioLayout;
import com.alibaba.pictures.bricks.view.QuickUpNumTextView;
import com.alibaba.pictures.bricks.view.RoundImageView;
import com.alibaba.pictures.bricks.view.SafeLottieAnimationView;
import com.alibaba.pictures.dolores.login.DoloresLoginHandler;
import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.alient.onearch.adapter.BaseFragment;
import com.alient.onearch.adapter.state.StateViewManager;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.page.GenericFragment;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.dc0;
import tb.oj1;
import tb.rb0;
import tb.s60;
import tb.wt2;
import tb.yb1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ArtistAppointmentViewHolder extends BaseViewHolder<ArtistFutureBean> implements CityFloatLayer.CustomOnCityClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final ArtistRichTextView artistNoticeCardRichTv;
    @NotNull
    private final TextView artistNoticeCardTitle;
    @NotNull
    private final TextView artistWantCardTitle;
    @NotNull
    private final QuickUpNumTextView artistWantCount;
    @NotNull
    private final TextView artistWantCountDesc;
    @NotNull
    private final RecyclerView cityRecycleView;
    @Nullable
    private CitySelectBottomDialog dialog;
    @NotNull
    private final View dividerLineView;
    @Nullable
    private String mTargetId;
    @NotNull
    private final LinearLayout noticeCardContainer;
    @NotNull
    private final RoundImageView poster;
    @NotNull
    private final ConstraintLayout posterCardContainer;
    @NotNull
    private final TextView posterShowMark;
    @NotNull
    private final ImageView posterShowMarkImg;
    @NotNull
    private final TextView posterShowWantTextView;
    @NotNull
    private final ArtistCitiesTagView posterSubTitle;
    @NotNull
    private final TextView posterTitle;
    @NotNull
    private final ConstraintLayout wantCardContainer;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class CityMoreViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private final TextView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CityMoreViewHolder(@NotNull View view) {
            super(view);
            b41.i(view, "itemView");
            View findViewById = view.findViewById(R$id.city_card_time_line_desc);
            b41.h(findViewById, "itemView.findViewById(R.…city_card_time_line_desc)");
            this.a = (TextView) findViewById;
        }

        public final void a(@NotNull String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1740368847")) {
                ipChange.ipc$dispatch("1740368847", new Object[]{this, str});
                return;
            }
            b41.i(str, "status");
            if (b41.d(str, ArtistTourNoticeBean.Status.PRODUCT_ALREADY.value) ? true : b41.d(str, ArtistTourNoticeBean.Status.NOTICE_PART_CITY.value)) {
                this.a.setText("求加场");
            } else {
                this.a.setText("想看其他城市");
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class CityViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private List<? extends ArtistTourCityBean> a;
        @NotNull
        private final String b;
        private final int c;
        @Nullable
        private CityViewHolderClickListener d;
        @Nullable
        private TrackInfo e;
        @Nullable
        private TrackInfo f;

        public CityViewAdapter(@NotNull List<? extends ArtistTourCityBean> list, @NotNull String str) {
            b41.i(list, "dataList");
            b41.i(str, "status");
            this.a = list;
            this.b = str;
            this.c = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(CityViewAdapter cityViewAdapter, View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1286953956")) {
                ipChange.ipc$dispatch("-1286953956", new Object[]{cityViewAdapter, view});
                return;
            }
            b41.i(cityViewAdapter, "this$0");
            CityViewHolderClickListener cityViewHolderClickListener = cityViewAdapter.d;
            if (cityViewHolderClickListener != null) {
                cityViewHolderClickListener.onCityMoreClick();
            }
        }

        @NotNull
        public final List<ArtistTourCityBean> b() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "373463857") ? (List) ipChange.ipc$dispatch("373463857", new Object[]{this}) : this.a;
        }

        public final void d(@Nullable CityViewHolderClickListener cityViewHolderClickListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1105765591")) {
                ipChange.ipc$dispatch("-1105765591", new Object[]{this, cityViewHolderClickListener});
            } else {
                this.d = cityViewHolderClickListener;
            }
        }

        public final void e(@Nullable TrackInfo trackInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-541432297")) {
                ipChange.ipc$dispatch("-541432297", new Object[]{this, trackInfo});
            } else {
                this.e = trackInfo;
            }
        }

        public final void f(@Nullable TrackInfo trackInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "136479401")) {
                ipChange.ipc$dispatch("136479401", new Object[]{this, trackInfo});
            } else {
                this.f = trackInfo;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "557306883") ? ((Integer) ipChange.ipc$dispatch("557306883", new Object[]{this})).intValue() : this.a.size() + 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1686825686")) {
                return ((Integer) ipChange.ipc$dispatch("-1686825686", new Object[]{this, Integer.valueOf(i)})).intValue();
            }
            if (i == getItemCount() - 1) {
                return this.c;
            }
            return super.getItemViewType(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "248230678")) {
                ipChange.ipc$dispatch("248230678", new Object[]{this, viewHolder, Integer.valueOf(i)});
                return;
            }
            b41.i(viewHolder, "holder");
            if (viewHolder instanceof CityMoreViewHolder) {
                ((CityMoreViewHolder) viewHolder).a(this.b);
                TrackInfo trackInfo = this.e;
                if (trackInfo != null) {
                    UserTrackProviderProxy.expose(viewHolder.itemView, trackInfo);
                }
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: tb.d8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ArtistAppointmentViewHolder.CityViewAdapter.c(ArtistAppointmentViewHolder.CityViewAdapter.this, view);
                    }
                });
            } else if (viewHolder instanceof CityViewHolder) {
                TrackInfo trackInfo2 = this.f;
                if (trackInfo2 != null) {
                    trackInfo2.setSpmd("city_" + i);
                    UserTrackProviderProxy.expose(viewHolder.itemView, trackInfo2);
                }
                CityViewHolder cityViewHolder = (CityViewHolder) viewHolder;
                cityViewHolder.c(this.a.get(i), this.f);
                cityViewHolder.g(this.d);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1252445600")) {
                return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("1252445600", new Object[]{this, viewGroup, Integer.valueOf(i)});
            }
            b41.i(viewGroup, "parent");
            if (i == this.c) {
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_bricks_artist_city_more_holder, viewGroup, false);
                b41.h(inflate, "view");
                return new CityMoreViewHolder(inflate);
            }
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_bricks_artist_city_holder, viewGroup, false);
            b41.h(inflate2, "view");
            return new CityViewHolder(inflate2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class CityViewHolder extends RecyclerView.ViewHolder implements OnCityStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private final HWRatioLayout a;
        @NotNull
        private final TextView b;
        @NotNull
        private final TextView c;
        @NotNull
        private final BaseIconButton d;
        @NotNull
        private final TextView e;
        @NotNull
        private final SafeLottieAnimationView f;
        @NotNull
        private final ImageView g;
        @Nullable
        private CityViewHolderClickListener h;
        @NotNull
        private String i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CityViewHolder(@NotNull View view) {
            super(view);
            b41.i(view, "itemView");
            View findViewById = view.findViewById(R$id.city_card_rl);
            b41.h(findViewById, "itemView.findViewById(R.id.city_card_rl)");
            this.a = (HWRatioLayout) findViewById;
            View findViewById2 = view.findViewById(R$id.city_card_city_name_tv);
            b41.h(findViewById2, "itemView.findViewById(R.id.city_card_city_name_tv)");
            this.b = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R$id.city_card_city_distance_tv);
            b41.h(findViewById3, "itemView.findViewById(R.…ty_card_city_distance_tv)");
            this.c = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R$id.city_card_action_btn);
            b41.h(findViewById4, "itemView.findViewById(R.id.city_card_action_btn)");
            this.d = (BaseIconButton) findViewById4;
            View findViewById5 = view.findViewById(R$id.city_card_time_line_desc);
            b41.h(findViewById5, "itemView.findViewById(R.…city_card_time_line_desc)");
            this.e = (TextView) findViewById5;
            View findViewById6 = view.findViewById(R$id.city_card_lottie);
            b41.h(findViewById6, "itemView.findViewById(R.id.city_card_lottie)");
            this.f = (SafeLottieAnimationView) findViewById6;
            View findViewById7 = view.findViewById(R$id.city_card_top_tag);
            b41.h(findViewById7, "itemView.findViewById(R.id.city_card_top_tag)");
            this.g = (ImageView) findViewById7;
            this.i = "0";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(TrackInfo trackInfo, CityViewHolder cityViewHolder, ArtistTourCityBean artistTourCityBean, View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1722883383")) {
                ipChange.ipc$dispatch("1722883383", new Object[]{trackInfo, cityViewHolder, artistTourCityBean, view});
                return;
            }
            b41.i(cityViewHolder, "this$0");
            b41.i(artistTourCityBean, "$data");
            if (trackInfo != null) {
                trackInfo.setSpmd("item_" + cityViewHolder.getAbsoluteAdapterPosition());
                UserTrackProviderProxy.click(trackInfo, true);
            }
            CityViewHolderClickListener cityViewHolderClickListener = cityViewHolder.h;
            if (cityViewHolderClickListener != null) {
                Action action = new Action();
                action.setActionType(1);
                action.setActionUrl(artistTourCityBean.actionUrl);
                cityViewHolderClickListener.onProductClick(action);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(TrackInfo trackInfo, CityViewHolder cityViewHolder, ArtistTourCityBean artistTourCityBean, View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-351137419")) {
                ipChange.ipc$dispatch("-351137419", new Object[]{trackInfo, cityViewHolder, artistTourCityBean, view});
                return;
            }
            b41.i(cityViewHolder, "this$0");
            b41.i(artistTourCityBean, "$data");
            if (trackInfo != null) {
                trackInfo.setSpmd("item_" + cityViewHolder.getAbsoluteAdapterPosition());
                UserTrackProviderProxy.click(trackInfo, false);
            }
            CityViewHolderClickListener cityViewHolderClickListener = cityViewHolder.h;
            if (cityViewHolderClickListener != null) {
                String str = artistTourCityBean.cityId;
                if (str == null) {
                    str = "";
                }
                String str2 = artistTourCityBean.cityName;
                String str3 = str2 != null ? str2 : "";
                String str4 = artistTourCityBean.wantSeeStatus;
                if (str4 == null) {
                    str4 = "0";
                }
                String operateType = ArtistTourCityBean.getOperateType(str4);
                b41.h(operateType, "getOperateType(data.wantSeeStatus?: \"0\")");
                cityViewHolderClickListener.onCityClick(str, str3, operateType, cityViewHolder);
            }
        }

        public final void c(@NotNull final ArtistTourCityBean artistTourCityBean, @Nullable final TrackInfo trackInfo) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "1045976950")) {
                ipChange.ipc$dispatch("1045976950", new Object[]{this, artistTourCityBean, trackInfo});
                return;
            }
            b41.i(artistTourCityBean, "data");
            this.d.setVisibility(0);
            this.g.setVisibility(8);
            this.e.setVisibility(8);
            this.d.setButtonTextSize(10, false);
            TextView textView = this.b;
            String str = artistTourCityBean.cityName;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            this.f.setAnimationFromUrl("https://androiddownload.damai.cn/pic/click_want_anition_json.zip");
            String str2 = artistTourCityBean.hotStatus;
            if (str2 == null) {
                str2 = "0";
            }
            if (ArtistTourCityBean.isHot(str2)) {
                this.g.setVisibility(0);
                ImageLoaderProviderProxy.loadinto("https://gw.alicdn.com/imgextra/i4/O1CN013CvJMJ1JPCpGvKosK_!!6000000001020-2-tps-48-33.png", this.g);
            }
            String str3 = artistTourCityBean.status;
            this.i = str3 == null ? "0" : str3;
            if (str3 == null) {
                str3 = "0";
            }
            if (ArtistTourCityBean.hasProduct(str3)) {
                this.a.setBackground(AppCompatResources.getDrawable(this.itemView.getContext(), R$drawable.bricks_bg_artist_notice_tag_bg_ff335c));
                this.d.setVisibility(8);
                this.e.setVisibility(0);
                TextView textView2 = this.e;
                String str4 = artistTourCityBean.showTime;
                if (str4 == null) {
                    str4 = "";
                }
                textView2.setText(str4);
                this.a.setOnClickListener(new View.OnClickListener() { // from class: tb.e8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ArtistAppointmentViewHolder.CityViewHolder.d(TrackInfo.this, this, artistTourCityBean, view);
                    }
                });
            } else {
                String str5 = artistTourCityBean.wantSeeStatus;
                f(str5 != null ? str5 : "0", true);
                this.a.setOnClickListener(new View.OnClickListener() { // from class: tb.f8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ArtistAppointmentViewHolder.CityViewHolder.e(TrackInfo.this, this, artistTourCityBean, view);
                    }
                });
            }
            String str6 = artistTourCityBean.address;
            if (str6 != null && str6.length() != 0) {
                z = false;
            }
            if (z) {
                this.c.setText("");
            } else {
                this.c.setText(artistTourCityBean.address);
            }
        }

        public final void f(@NotNull String str, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1252609023")) {
                ipChange.ipc$dispatch("-1252609023", new Object[]{this, str, Boolean.valueOf(z)});
                return;
            }
            b41.i(str, "wantSeeStatus");
            if (ArtistTourCityBean.hasProduct(this.i) || this.d.getVisibility() == 8) {
                return;
            }
            if (ArtistTourCityBean.isWant(str)) {
                this.a.setBackground(AppCompatResources.getDrawable(this.itemView.getContext(), R$drawable.bricks_bg_artist_notice_tag_bg_ff335c));
                this.d.setLottieLocalRes(R$raw.artist_city_want);
                if (!z) {
                    this.f.playAnimation();
                    this.d.playLottieAnimation();
                } else {
                    this.d.visibleLottieIconAnimation();
                }
                this.d.setButtonText("已想看");
                return;
            }
            this.a.setBackground(AppCompatResources.getDrawable(this.itemView.getContext(), R$drawable.bricks_bg_artist_tag_gray_corner_896b1));
            this.d.setLottieLocalRes(R$raw.artist_city_want_cancel);
            if (!z) {
                this.d.playLottieAnimation();
            } else {
                this.d.visibleLottieIconAnimation();
            }
            this.d.setButtonText("想看");
        }

        public final void g(@Nullable CityViewHolderClickListener cityViewHolderClickListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1166358459")) {
                ipChange.ipc$dispatch("-1166358459", new Object[]{this, cityViewHolderClickListener});
            } else {
                this.h = cityViewHolderClickListener;
            }
        }

        @Override // com.alibaba.pictures.bricks.component.artist.wishcity.ArtistAppointmentViewHolder.OnCityStateChangeListener
        public void onCityStateChange(@NotNull String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "818699526")) {
                ipChange.ipc$dispatch("818699526", new Object[]{this, str});
                return;
            }
            b41.i(str, "wantSeeStatus");
            f(str, false);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface CityViewHolderClickListener {
        void onCityClick(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable OnCityStateChangeListener onCityStateChangeListener);

        void onCityMoreClick();

        void onProductClick(@NotNull Action action);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface OnCityStateChangeListener {
        void onCityStateChange(@NotNull String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BaseArtistDataMo.ValueType.values().length];
            iArr[BaseArtistDataMo.ValueType.NUM.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class b implements CityViewHolderClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // com.alibaba.pictures.bricks.component.artist.wishcity.ArtistAppointmentViewHolder.CityViewHolderClickListener
        public void onCityClick(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable OnCityStateChangeListener onCityStateChangeListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "205490396")) {
                ipChange.ipc$dispatch("205490396", new Object[]{this, str, str2, str3, onCityStateChangeListener});
                return;
            }
            b41.i(str, "cityId");
            b41.i(str2, RankSquareCMSActivity.PRESET_CITY_NAME);
            b41.i(str3, "operateType");
            ArtistAppointmentViewHolder.this.requestPayResultData(str, str2, str3, onCityStateChangeListener);
        }

        @Override // com.alibaba.pictures.bricks.component.artist.wishcity.ArtistAppointmentViewHolder.CityViewHolderClickListener
        public void onCityMoreClick() {
            FragmentManager parentFragmentManager;
            CitySelectBottomDialog citySelectBottomDialog;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-280448873")) {
                ipChange.ipc$dispatch("-280448873", new Object[]{this});
                return;
            }
            Action action = ArtistAppointmentViewHolder.this.getAction("otherCity");
            if (action == null) {
                return;
            }
            TrackInfo trackInfo = action.getTrackInfo();
            if (trackInfo != null) {
                UserTrackProviderProxy.click(trackInfo, true);
            }
            ArtistAppointmentViewHolder artistAppointmentViewHolder = ArtistAppointmentViewHolder.this;
            CitySelectBottomDialog citySelectBottomDialog2 = new CitySelectBottomDialog();
            citySelectBottomDialog2.setOnCityClickListener(ArtistAppointmentViewHolder.this);
            citySelectBottomDialog2.setStyle(0, R$style.custom_bottom_sheet);
            artistAppointmentViewHolder.dialog = citySelectBottomDialog2;
            GenericFragment fragment = ArtistAppointmentViewHolder.this.getPageContext().getFragment();
            if (fragment == null || (parentFragmentManager = fragment.getParentFragmentManager()) == null || (citySelectBottomDialog = ArtistAppointmentViewHolder.this.dialog) == null) {
                return;
            }
            citySelectBottomDialog.show(parentFragmentManager, "");
        }

        @Override // com.alibaba.pictures.bricks.component.artist.wishcity.ArtistAppointmentViewHolder.CityViewHolderClickListener
        public void onProductClick(@NotNull Action action) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "857158195")) {
                ipChange.ipc$dispatch("857158195", new Object[]{this, action});
                return;
            }
            b41.i(action, "action");
            Activity activity = ArtistAppointmentViewHolder.this.getPageContext().getActivity();
            if (activity != null) {
                NavProviderProxy.toUri(activity, action);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class c implements QuickUpNumTextView.DataListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // com.alibaba.pictures.bricks.view.QuickUpNumTextView.DataListener
        @NotNull
        public String onDataUpdate(float f) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "676053320")) {
                return (String) ipChange.ipc$dispatch("676053320", new Object[]{this, Float.valueOf(f)});
            }
            String format = new DecimalFormat("#,###").format(Float.valueOf(f));
            b41.h(format, "DecimalFormat(\"#,###\").format(data)");
            return format;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtistAppointmentViewHolder(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        View findViewById = view.findViewById(R$id.poster_card_container);
        b41.h(findViewById, "itemView.findViewById(R.id.poster_card_container)");
        this.posterCardContainer = (ConstraintLayout) findViewById;
        View findViewById2 = view.findViewById(R$id.artist_poster_iv);
        b41.h(findViewById2, "itemView.findViewById(R.id.artist_poster_iv)");
        this.poster = (RoundImageView) findViewById2;
        View findViewById3 = view.findViewById(R$id.artist_show_title_tv);
        b41.h(findViewById3, "itemView.findViewById(R.id.artist_show_title_tv)");
        this.posterTitle = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R$id.artist_show_sub_title_tv);
        b41.h(findViewById4, "itemView.findViewById(R.…artist_show_sub_title_tv)");
        this.posterSubTitle = (ArtistCitiesTagView) findViewById4;
        View findViewById5 = view.findViewById(R$id.tv_poster_show_mark);
        b41.h(findViewById5, "itemView.findViewById(R.id.tv_poster_show_mark)");
        this.posterShowMark = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R$id.tv_poster_show_mark_img);
        b41.h(findViewById6, "itemView.findViewById(R.….tv_poster_show_mark_img)");
        this.posterShowMarkImg = (ImageView) findViewById6;
        View findViewById7 = view.findViewById(R$id.artist_show_want_tv);
        b41.h(findViewById7, "itemView.findViewById(R.id.artist_show_want_tv)");
        this.posterShowWantTextView = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R$id.artist_divider_horizontal_line);
        b41.h(findViewById8, "itemView.findViewById(R.…_divider_horizontal_line)");
        this.dividerLineView = findViewById8;
        View findViewById9 = view.findViewById(R$id.notice_card_container);
        b41.h(findViewById9, "itemView.findViewById(R.id.notice_card_container)");
        this.noticeCardContainer = (LinearLayout) findViewById9;
        View findViewById10 = view.findViewById(R$id.want_card_container);
        b41.h(findViewById10, "itemView.findViewById(R.id.want_card_container)");
        this.wantCardContainer = (ConstraintLayout) findViewById10;
        View findViewById11 = view.findViewById(R$id.artist_future_title);
        b41.h(findViewById11, "itemView.findViewById(R.id.artist_future_title)");
        this.artistWantCardTitle = (TextView) findViewById11;
        View findViewById12 = view.findViewById(R$id.artist_future_want_count_tv);
        b41.h(findViewById12, "itemView.findViewById(R.…ist_future_want_count_tv)");
        this.artistWantCount = (QuickUpNumTextView) findViewById12;
        View findViewById13 = view.findViewById(R$id.artist_future_want_count_desc_tv);
        b41.h(findViewById13, "itemView.findViewById(R.…uture_want_count_desc_tv)");
        this.artistWantCountDesc = (TextView) findViewById13;
        View findViewById14 = view.findViewById(R$id.artist_future_want_tag);
        b41.h(findViewById14, "itemView.findViewById(R.id.artist_future_want_tag)");
        this.artistNoticeCardTitle = (TextView) findViewById14;
        View findViewById15 = view.findViewById(R$id.artist_future_want_rich_tv);
        b41.h(findViewById15, "itemView.findViewById(R.…tist_future_want_rich_tv)");
        this.artistNoticeCardRichTv = (ArtistRichTextView) findViewById15;
        View findViewById16 = view.findViewById(R$id.artist_future_city_rl);
        b41.h(findViewById16, "itemView.findViewById(R.id.artist_future_city_rl)");
        RecyclerView recyclerView = (RecyclerView) findViewById16;
        this.cityRecycleView = recyclerView;
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.alibaba.pictures.bricks.component.artist.wishcity.ArtistAppointmentViewHolder.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NotNull Rect rect, @NotNull View view2, @NotNull RecyclerView recyclerView2, @NotNull RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2098084125")) {
                    ipChange.ipc$dispatch("2098084125", new Object[]{this, rect, view2, recyclerView2, state});
                    return;
                }
                b41.i(rect, "outRect");
                b41.i(view2, "view");
                b41.i(recyclerView2, "parent");
                b41.i(state, "state");
                s60 s60Var = s60.INSTANCE;
                rect.right = s60Var.a(ArtistAppointmentViewHolder.this.getContext(), 6.5f);
                rect.bottom = s60Var.b(ArtistAppointmentViewHolder.this.getContext(), 12);
            }
        });
    }

    private final void bindCityCardData(List<? extends ArtistTourCityBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1565947466")) {
            ipChange.ipc$dispatch("1565947466", new Object[]{this, list});
            return;
        }
        String str = getValue().status;
        if (str == null) {
            str = ArtistTourNoticeBean.Status.NO_INFO.value;
        }
        b41.h(str, "value.status ?: ArtistTo…Bean.Status.NO_INFO.value");
        CityViewAdapter cityViewAdapter = new CityViewAdapter(list, str);
        Action action = getAction("otherCity");
        cityViewAdapter.e(action != null ? action.getTrackInfo() : null);
        Action action2 = getAction("tourCity");
        cityViewAdapter.f(action2 != null ? action2.getTrackInfo() : null);
        cityViewAdapter.d(new b());
        this.cityRecycleView.setAdapter(cityViewAdapter);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void bindNoticeViewData(com.alibaba.pictures.bricks.bean.ArtistTourNoticeBean r9) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.component.artist.wishcity.ArtistAppointmentViewHolder.bindNoticeViewData(com.alibaba.pictures.bricks.bean.ArtistTourNoticeBean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void bindStatusNoticeViewData(com.alibaba.pictures.bricks.bean.ArtistTourNoticeBean r6) {
        /*
            r5 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.alibaba.pictures.bricks.component.artist.wishcity.ArtistAppointmentViewHolder.$ipChange
            java.lang.String r1 = "1821167322"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L17
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r5
            r2[r3] = r6
            r0.ipc$dispatch(r1, r2)
            return
        L17:
            java.lang.String r0 = r6.statusDesc
            if (r0 == 0) goto L24
            boolean r0 = kotlin.text.g.s(r0)
            if (r0 == 0) goto L22
            goto L24
        L22:
            r0 = 0
            goto L25
        L24:
            r0 = 1
        L25:
            if (r0 == 0) goto L38
            java.util.List<com.alibaba.pictures.bricks.bean.BaseArtistDataMo> r0 = r6.desc
            if (r0 == 0) goto L34
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L32
            goto L34
        L32:
            r0 = 0
            goto L35
        L34:
            r0 = 1
        L35:
            if (r0 == 0) goto L38
            return
        L38:
            android.widget.LinearLayout r0 = r5.noticeCardContainer
            r0.setVisibility(r4)
            java.lang.String r0 = r6.statusDesc
            if (r0 == 0) goto L46
            android.widget.TextView r1 = r5.artistNoticeCardTitle
            r1.setText(r0)
        L46:
            java.lang.Object r0 = r5.getValue()
            com.alibaba.pictures.bricks.bean.ArtistFutureBean r0 = (com.alibaba.pictures.bricks.bean.ArtistFutureBean) r0
            java.lang.String r0 = r0.status
            if (r0 != 0) goto L54
            com.alibaba.pictures.bricks.bean.ArtistTourNoticeBean$Status r0 = com.alibaba.pictures.bricks.bean.ArtistTourNoticeBean.Status.NO_INFO
            java.lang.String r0 = r0.value
        L54:
            com.alibaba.pictures.bricks.bean.ArtistTourNoticeBean$Status r1 = com.alibaba.pictures.bricks.bean.ArtistTourNoticeBean.Status.NO_INFO
            java.lang.String r1 = r1.value
            boolean r0 = tb.b41.d(r0, r1)
            if (r0 == 0) goto L6e
            android.widget.TextView r0 = r5.artistNoticeCardTitle
            android.content.Context r1 = r5.getContext()
            int r2 = com.alibaba.pictures.R$drawable.bricks_bg_artist_notice_tag_bg_5c93b8
            android.graphics.drawable.Drawable r1 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r1, r2)
            r0.setBackground(r1)
            goto L7d
        L6e:
            android.widget.TextView r0 = r5.artistNoticeCardTitle
            android.content.Context r1 = r5.getContext()
            int r2 = com.alibaba.pictures.R$drawable.bricks_bg_artist_notice_tag_bg_ff4886
            android.graphics.drawable.Drawable r1 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r1, r2)
            r0.setBackground(r1)
        L7d:
            java.util.List<com.alibaba.pictures.bricks.bean.BaseArtistDataMo> r0 = r6.desc
            if (r0 == 0) goto L89
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L88
            goto L89
        L88:
            r3 = 0
        L89:
            if (r3 == 0) goto L8c
            return
        L8c:
            com.alibaba.pictures.bricks.view.ArtistRichTextView r0 = r5.artistNoticeCardRichTv
            java.util.List<com.alibaba.pictures.bricks.bean.BaseArtistDataMo> r6 = r6.desc
            r0.setRichView(r6)
            java.lang.String r6 = "rule"
            com.alient.oneservice.nav.Action r6 = r5.getAction(r6)
            if (r6 != 0) goto L9c
            return
        L9c:
            com.alient.oneservice.ut.TrackInfo r0 = r6.getTrackInfo()
            if (r0 == 0) goto La7
            android.widget.LinearLayout r1 = r5.noticeCardContainer
            com.alient.oneservice.ut.UserTrackProviderProxy.expose(r1, r0)
        La7:
            android.widget.LinearLayout r0 = r5.noticeCardContainer
            tb.c8 r1 = new tb.c8
            r1.<init>()
            r0.setOnClickListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.component.artist.wishcity.ArtistAppointmentViewHolder.bindStatusNoticeViewData(com.alibaba.pictures.bricks.bean.ArtistTourNoticeBean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindStatusNoticeViewData$lambda-17  reason: not valid java name */
    public static final void m112bindStatusNoticeViewData$lambda17(Action action, ArtistAppointmentViewHolder artistAppointmentViewHolder, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "5105005")) {
            ipChange.ipc$dispatch("5105005", new Object[]{action, artistAppointmentViewHolder, view});
            return;
        }
        b41.i(action, "$action");
        b41.i(artistAppointmentViewHolder, "this$0");
        TrackInfo trackInfo = action.getTrackInfo();
        if (trackInfo != null) {
            UserTrackProviderProxy.click(trackInfo, true);
        }
        Activity activity = artistAppointmentViewHolder.getPageContext().getActivity();
        if (activity != null) {
            NavProviderProxy.toUri(activity, action);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void bindTopCardData(final com.alibaba.pictures.bricks.bean.ArtistCardBean r8) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.component.artist.wishcity.ArtistAppointmentViewHolder.bindTopCardData(com.alibaba.pictures.bricks.bean.ArtistCardBean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindTopCardData$lambda-6  reason: not valid java name */
    public static final void m113bindTopCardData$lambda6(ArtistAppointmentViewHolder artistAppointmentViewHolder, ArtistCardBean artistCardBean, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1224703773")) {
            ipChange.ipc$dispatch("1224703773", new Object[]{artistAppointmentViewHolder, artistCardBean, view});
            return;
        }
        b41.i(artistAppointmentViewHolder, "this$0");
        b41.i(artistCardBean, "$cardData");
        Action action = new Action();
        action.setActionType(1);
        String str = artistCardBean.actionUrl;
        if (str == null) {
            str = "";
        }
        action.setActionUrl(str);
        Activity activity = artistAppointmentViewHolder.getPageContext().getActivity();
        if (activity != null) {
            NavProviderProxy.toUri(activity, action);
        }
    }

    private final String getOperateType(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1884142467") ? (String) ipChange.ipc$dispatch("1884142467", new Object[]{this, str}) : "1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestPayResultData(final String str, String str2, String str3, final OnCityStateChangeListener onCityStateChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "847343331")) {
            ipChange.ipc$dispatch("847343331", new Object[]{this, str, str2, str3, onCityStateChangeListener});
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("cityId", str);
        linkedHashMap.put(RankSquareCMSActivity.PRESET_CITY_NAME, str2);
        if (DoloresLoginHandler.Companion.a().c()) {
            rb0.a aVar = rb0.Companion;
            CityWantRequest cityWantRequest = new CityWantRequest();
            cityWantRequest.setGroup(CityWantRequest.GroupType.IP_GROUP.getValue());
            cityWantRequest.setTargetType(CityWantRequest.TargetType.IP_CITY_REMIND.getValue());
            cityWantRequest.setPageName(CityWantRequest.PageName.DM_ARTIST_DETAIL.getValue());
            cityWantRequest.setReturnRelationStatus(1);
            cityWantRequest.setTargetId(String.valueOf(this.mTargetId));
            cityWantRequest.setOperateType(str3);
            cityWantRequest.setSubTargetId(str);
            cityWantRequest.setExtras(JSON.toJSONString(linkedHashMap));
            aVar.b(cityWantRequest).c(getContext()).a().doOnKTStart(new Function1<DoloresRequest<FollowStateBean>, wt2>() { // from class: com.alibaba.pictures.bricks.component.artist.wishcity.ArtistAppointmentViewHolder$requestPayResultData$2
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ wt2 invoke(DoloresRequest<FollowStateBean> doloresRequest) {
                    invoke2(doloresRequest);
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable DoloresRequest<FollowStateBean> doloresRequest) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-139521091")) {
                        ipChange2.ipc$dispatch("-139521091", new Object[]{this, doloresRequest});
                        return;
                    }
                    Activity activity = ArtistAppointmentViewHolder.this.getPageContext().getActivity();
                    if (activity != null) {
                        GenericFragment fragment = ArtistAppointmentViewHolder.this.getPageContext().getFragment();
                        BaseFragment baseFragment = fragment instanceof BaseFragment ? (BaseFragment) fragment : null;
                        if (baseFragment != null) {
                            StateViewManager.IStateFeature.DefaultImpls.showLoadingDialog$default(baseFragment, activity, null, false, 6, null);
                        }
                    }
                }
            }).doOnKTSuccess(new Function1<FollowStateBean, wt2>() { // from class: com.alibaba.pictures.bricks.component.artist.wishcity.ArtistAppointmentViewHolder$requestPayResultData$3
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ wt2 invoke(FollowStateBean followStateBean) {
                    invoke2(followStateBean);
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull FollowStateBean followStateBean) {
                    RecyclerView recyclerView;
                    RecyclerView recyclerView2;
                    List<ArtistTourCityBean> b2;
                    IpChange ipChange2 = $ipChange;
                    int i = 0;
                    if (AndroidInstantRuntime.support(ipChange2, "-1430369045")) {
                        ipChange2.ipc$dispatch("-1430369045", new Object[]{this, followStateBean});
                        return;
                    }
                    b41.i(followStateBean, AdvanceSetting.NETWORK_TYPE);
                    if (!b41.d(followStateBean.success, "true")) {
                        BricksToastUtil.INSTANCE.b(oj1.MAIPIAO_SERVICE_ERROR_FRIENDLY);
                        return;
                    }
                    if (followStateBean.isFollowed()) {
                        BricksToastUtil.INSTANCE.b("想看成功，已为您反馈心愿~");
                    }
                    List<ArtistTourCityBean> list = ArtistAppointmentViewHolder.this.getValue().artistTourCities;
                    b41.h(list, "value.artistTourCities");
                    String str4 = str;
                    Iterator<ArtistTourCityBean> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            i = -1;
                            break;
                        } else if (b41.d(it.next().cityId, str4)) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (i >= 0 && i < ArtistAppointmentViewHolder.this.getValue().artistTourCities.size()) {
                        String str5 = followStateBean.isFollowed() ? "1" : "0";
                        if (b41.d(ArtistAppointmentViewHolder.this.getValue().artistTourCities.get(i).wantSeeStatus, str5)) {
                            return;
                        }
                        ArtistAppointmentViewHolder.this.getValue().artistTourCities.get(i).wantSeeStatus = str5;
                        recyclerView = ArtistAppointmentViewHolder.this.cityRecycleView;
                        RecyclerView.Adapter adapter = recyclerView.getAdapter();
                        ArtistAppointmentViewHolder.CityViewAdapter cityViewAdapter = adapter instanceof ArtistAppointmentViewHolder.CityViewAdapter ? (ArtistAppointmentViewHolder.CityViewAdapter) adapter : null;
                        ArtistTourCityBean artistTourCityBean = (cityViewAdapter == null || (b2 = cityViewAdapter.b()) == null) ? null : b2.get(i);
                        if (artistTourCityBean != null) {
                            artistTourCityBean.wantSeeStatus = str5;
                        }
                        recyclerView2 = ArtistAppointmentViewHolder.this.cityRecycleView;
                        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView2.findViewHolderForAdapterPosition(i);
                        if (findViewHolderForAdapterPosition != null && onCityStateChangeListener == null) {
                            ArtistAppointmentViewHolder.CityViewHolder cityViewHolder = findViewHolderForAdapterPosition instanceof ArtistAppointmentViewHolder.CityViewHolder ? (ArtistAppointmentViewHolder.CityViewHolder) findViewHolderForAdapterPosition : null;
                            if (cityViewHolder != null) {
                                cityViewHolder.onCityStateChange(followStateBean.isFollowed() ? "1" : "0");
                                return;
                            }
                            return;
                        }
                    }
                    ArtistAppointmentViewHolder.OnCityStateChangeListener onCityStateChangeListener2 = onCityStateChangeListener;
                    if (onCityStateChangeListener2 != null) {
                        onCityStateChangeListener2.onCityStateChange(followStateBean.isFollowed() ? "1" : "0");
                    }
                }
            }).doOnKTFail(new Function1<dc0<FollowStateBean>, wt2>() { // from class: com.alibaba.pictures.bricks.component.artist.wishcity.ArtistAppointmentViewHolder$requestPayResultData$4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ wt2 invoke(dc0<FollowStateBean> dc0Var) {
                    invoke2(dc0Var);
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull dc0<FollowStateBean> dc0Var) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-325519565")) {
                        ipChange2.ipc$dispatch("-325519565", new Object[]{this, dc0Var});
                        return;
                    }
                    b41.i(dc0Var, AdvanceSetting.NETWORK_TYPE);
                    BricksToastUtil.INSTANCE.b(oj1.MAIPIAO_SERVICE_ERROR_FRIENDLY);
                }
            }).doOnKTFinish(new Function0<wt2>() { // from class: com.alibaba.pictures.bricks.component.artist.wishcity.ArtistAppointmentViewHolder$requestPayResultData$5
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ wt2 invoke() {
                    invoke2();
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1450190740")) {
                        ipChange2.ipc$dispatch("1450190740", new Object[]{this});
                        return;
                    }
                    GenericFragment fragment = ArtistAppointmentViewHolder.this.getPageContext().getFragment();
                    BaseFragment baseFragment = fragment instanceof BaseFragment ? (BaseFragment) fragment : null;
                    if (baseFragment != null) {
                        baseFragment.hideLoadingDialog(ArtistAppointmentViewHolder.this.getPageContext().getActivity());
                    }
                }
            });
            return;
        }
        yb1.Companion.b(getContext());
    }

    static /* synthetic */ void requestPayResultData$default(ArtistAppointmentViewHolder artistAppointmentViewHolder, String str, String str2, String str3, OnCityStateChangeListener onCityStateChangeListener, int i, Object obj) {
        if ((i & 8) != 0) {
            onCityStateChangeListener = null;
        }
        artistAppointmentViewHolder.requestPayResultData(str, str2, str3, onCityStateChangeListener);
    }

    private final void safeRequest(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1507583841")) {
            ipChange.ipc$dispatch("1507583841", new Object[]{this, str, str2});
            return;
        }
        requestPayResultData$default(this, str, str2, getOperateType(str), null, 8, null);
        CitySelectBottomDialog citySelectBottomDialog = this.dialog;
        if (citySelectBottomDialog != null) {
            citySelectBottomDialog.dismiss();
        }
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NotNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1150669378")) {
            ipChange.ipc$dispatch("-1150669378", new Object[]{this, iItem});
            return;
        }
        b41.i(iItem, "item");
        this.posterCardContainer.setVisibility(8);
        this.noticeCardContainer.setVisibility(8);
        this.wantCardContainer.setVisibility(8);
        this.dividerLineView.setVisibility(8);
        if (getValue() == null) {
            return;
        }
        this.mTargetId = getValue().artistIpId;
        ArtistCardBean artistCardBean = getValue().artistIp;
        if (artistCardBean != null) {
            bindTopCardData(artistCardBean);
        }
        ArtistTourNoticeBean artistTourNoticeBean = getValue().artistTourNotice;
        if (artistTourNoticeBean != null) {
            bindNoticeViewData(artistTourNoticeBean);
            bindStatusNoticeViewData(artistTourNoticeBean);
        }
        if (this.wantCardContainer.getVisibility() == 0 && this.posterCardContainer.getVisibility() == 0) {
            this.dividerLineView.setVisibility(0);
        }
        List<ArtistTourCityBean> list = getValue().artistTourCities;
        if (list == null || !(!list.isEmpty())) {
            return;
        }
        bindCityCardData(list);
    }

    @Nullable
    public final String getMTargetId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1949020664") ? (String) ipChange.ipc$dispatch("-1949020664", new Object[]{this}) : this.mTargetId;
    }

    @Override // com.youku.arch.v3.adapter.VBaseHolder
    public void onCreate() {
        Lifecycle lifecycle;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1177921856")) {
            ipChange.ipc$dispatch("1177921856", new Object[]{this});
            return;
        }
        super.onCreate();
        GenericFragment fragment = getPageContext().getFragment();
        if (fragment == null || (lifecycle = fragment.getLifecycle()) == null) {
            return;
        }
        lifecycle.addObserver(new LifecycleObserver() { // from class: com.alibaba.pictures.bricks.component.artist.wishcity.ArtistAppointmentViewHolder$onCreate$1
            private static transient /* synthetic */ IpChange $ipChange;

            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            public final void onStop() {
                CitySelectBottomDialog citySelectBottomDialog;
                IpChange ipChange2 = $ipChange;
                boolean z = false;
                if (AndroidInstantRuntime.support(ipChange2, "1884971138")) {
                    ipChange2.ipc$dispatch("1884971138", new Object[]{this});
                    return;
                }
                CitySelectBottomDialog citySelectBottomDialog2 = ArtistAppointmentViewHolder.this.dialog;
                if (citySelectBottomDialog2 != null && citySelectBottomDialog2.getShowsDialog()) {
                    z = true;
                }
                if (!z || (citySelectBottomDialog = ArtistAppointmentViewHolder.this.dialog) == null) {
                    return;
                }
                citySelectBottomDialog.dismiss();
            }
        });
    }

    @Override // cn.damai.projectfiltercopy.floatview.CityFloatLayer.CustomOnCityClickListener
    public void onGroupCityClick(@NotNull String str, @NotNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "678688498")) {
            ipChange.ipc$dispatch("678688498", new Object[]{this, str, str2});
            return;
        }
        b41.i(str, "cityId");
        b41.i(str2, RankSquareCMSActivity.PRESET_CITY_NAME);
        safeRequest(str, str2);
    }

    @Override // cn.damai.projectfiltercopy.floatview.CityFloatLayer.CustomOnCityClickListener
    public void onHotCityClick(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "176738378")) {
            ipChange.ipc$dispatch("176738378", new Object[]{this, str, str2, str3});
            return;
        }
        b41.i(str, RankSquareCMSActivity.PRESET_CITY_NAME);
        b41.i(str2, "cityId");
        b41.i(str3, "url");
        safeRequest(str2, str);
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder, com.alient.onearch.adapter.view.ViewCard
    public void onItemClick(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "708796601")) {
            ipChange.ipc$dispatch("708796601", new Object[]{this, view});
        } else {
            b41.i(view, "view");
        }
    }

    @Override // cn.damai.projectfiltercopy.floatview.CityFloatLayer.CustomOnCityClickListener
    public void onLocationCityClick(@NotNull String str, @NotNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2122068166")) {
            ipChange.ipc$dispatch("-2122068166", new Object[]{this, str, str2});
            return;
        }
        b41.i(str, "cityId");
        b41.i(str2, RankSquareCMSActivity.PRESET_CITY_NAME);
        safeRequest(str, str2);
    }

    public final void setMTargetId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2039663982")) {
            ipChange.ipc$dispatch("2039663982", new Object[]{this, str});
        } else {
            this.mTargetId = str;
        }
    }
}
