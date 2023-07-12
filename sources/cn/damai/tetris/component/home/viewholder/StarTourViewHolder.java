package cn.damai.tetris.component.home.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.home.adapter.StarTourTabAdapter;
import cn.damai.tetris.component.home.bean.HomeStarTourBean;
import cn.damai.tetris.component.home.utils.RankItemDividerDecoration;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.mvp.CommonBean;
import cn.damai.tetris.mvp.CommonViewHolder;
import cn.damai.uikit.number.DMDigitTextView;
import cn.damai.uikit.view.DMLabelType;
import cn.damai.uikit.view.DMPosterView;
import cn.damai.uikit.view.RoundImageView;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cs;
import tb.mu0;
import tb.oy0;
import tb.qz1;
import tb.t60;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class StarTourViewHolder extends CommonViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private int currentPosition;
    private Context mContext;
    private List<HomeStarTourBean.HomeStarTourItem> mData;
    private TextView mModuleTitle;
    private TextView mMoreTitle;
    private LinearLayout mMoreTitleLayout;
    private View.OnClickListener mOnClickListener;
    private StarTourTabAdapter.OnTabItemClickListener mOnTabItemClickListener;
    private DMPosterView mPosterView;
    private TextView mProjectCityName;
    private RelativeLayout mProjectLayout;
    private View mProjectLine;
    private DMDigitTextView mProjectPrice;
    private FrameLayout mProjectPriceLayout;
    private DMDigitTextView mProjectPriceUnknown;
    private TextView mProjectTime;
    private TextView mProjectTitle;
    private TextView mProjectVenueName;
    private TextView mSaleProjectCount;
    private RoundImageView mStarAvatar;
    private LinearLayout mStarLayout;
    private TextView mStarName;
    private RecyclerView mTabList;
    private StarTourTabAdapter mTabListAdapter;
    private TextView mTourCityCount;
    private LinearLayout mTourCityListLayout;
    private TextView mTourCityName;
    private TrackInfo mTrackInfo;
    private String moduleTitle;
    private View starTourCardLayout;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.home.viewholder.StarTourViewHolder$a */
    /* loaded from: classes7.dex */
    public class C1864a implements StarTourTabAdapter.OnTabItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1864a() {
        }

        @Override // cn.damai.tetris.component.home.adapter.StarTourTabAdapter.OnTabItemClickListener
        public void onItemClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2088800938")) {
                ipChange.ipc$dispatch("-2088800938", new Object[]{this, view});
                return;
            }
            HomeStarTourBean.HomeStarTourItem homeStarTourItem = (HomeStarTourBean.HomeStarTourItem) view.getTag();
            if (homeStarTourItem == null) {
                return;
            }
            oy0.B().t(StarTourViewHolder.this.mTrackInfo, StarTourViewHolder.this.moduleTitle, homeStarTourItem.artistId, homeStarTourItem.position);
            if (StarTourViewHolder.this.currentPosition != homeStarTourItem.position) {
                ((HomeStarTourBean.HomeStarTourItem) StarTourViewHolder.this.mData.get(StarTourViewHolder.this.currentPosition)).isSelected = false;
                homeStarTourItem.isSelected = true;
                StarTourViewHolder.this.currentPosition = homeStarTourItem.position;
                StarTourViewHolder.this.mTabListAdapter.notifyDataSetChanged();
                StarTourViewHolder.this.handleProject(homeStarTourItem);
            }
            qz1.a(StarTourViewHolder.this.mContext, StarTourViewHolder.this.mTabList, view);
            oy0.B().K(StarTourViewHolder.this.mTrackInfo, view, StarTourViewHolder.this.moduleTitle, homeStarTourItem.artistId, homeStarTourItem.position);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.home.viewholder.StarTourViewHolder$b */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1865b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1865b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "291275370")) {
                ipChange.ipc$dispatch("291275370", new Object[]{this, view});
                return;
            }
            int id = view.getId();
            if (id == R$id.homepage_module_title_more_layout) {
                oy0.B().q(StarTourViewHolder.this.mTrackInfo, StarTourViewHolder.this.moduleTitle);
                DMNav.from(StarTourViewHolder.this.mContext).toUri(NavUri.b(cs.r));
            } else if (id == R$id.homepage_star_tour_star) {
                HomeStarTourBean.HomeStarTourItem homeStarTourItem = (HomeStarTourBean.HomeStarTourItem) view.getTag();
                if (homeStarTourItem == null || TextUtils.isEmpty(homeStarTourItem.artistId)) {
                    return;
                }
                oy0.B().s(StarTourViewHolder.this.mTrackInfo, StarTourViewHolder.this.moduleTitle, homeStarTourItem.artistId, homeStarTourItem.position);
                Bundle bundle = new Bundle();
                bundle.putString(RepertoireDetailFragment.USERTYPE, "2");
                bundle.putString("userId", homeStarTourItem.artistId);
                DMNav.from(StarTourViewHolder.this.mContext).withExtras(bundle).toUri(NavUri.b(cs.Y));
            } else {
                HomeStarTourBean.HomeStarTourItem homeStarTourItem2 = (HomeStarTourBean.HomeStarTourItem) view.getTag();
                if (homeStarTourItem2 == null) {
                    return;
                }
                oy0.B().r(StarTourViewHolder.this.mTrackInfo, StarTourViewHolder.this.moduleTitle, homeStarTourItem2.artistId, homeStarTourItem2.projectId, homeStarTourItem2.position);
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean(MonitorType.SKIP, true);
                bundle2.putString("from_page", "homepage");
                bundle2.putString("projectImage", homeStarTourItem2.projectPic);
                if (!TextUtils.isEmpty(homeStarTourItem2.schema)) {
                    DMNav.from(StarTourViewHolder.this.mContext).withExtras(bundle2).toUri(homeStarTourItem2.schema);
                    return;
                }
                bundle2.putString("id", homeStarTourItem2.projectId);
                DMNav.from(StarTourViewHolder.this.mContext).withExtras(bundle2).toUri(NavUri.b(cs.b));
            }
        }
    }

    public StarTourViewHolder(View view) {
        super(view);
        this.mData = new ArrayList();
        this.mOnTabItemClickListener = new C1864a();
        this.mOnClickListener = new View$OnClickListenerC1865b();
        this.mContext = mu0.a();
        this.mModuleTitle = (TextView) this.itemView.findViewById(R$id.homepage_module_title_label);
        this.mMoreTitle = (TextView) this.itemView.findViewById(R$id.homepage_module_title_more_text);
        LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R$id.homepage_module_title_more_layout);
        this.mMoreTitleLayout = linearLayout;
        linearLayout.setOnClickListener(this.mOnClickListener);
        this.mTabList = (RecyclerView) this.itemView.findViewById(R$id.homepage_star_tour_tab);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext);
        linearLayoutManager.setOrientation(0);
        this.mTabList.setLayoutManager(linearLayoutManager);
        StarTourTabAdapter starTourTabAdapter = new StarTourTabAdapter();
        this.mTabListAdapter = starTourTabAdapter;
        this.mTabList.setAdapter(starTourTabAdapter);
        this.mTabListAdapter.g(this.mOnTabItemClickListener);
        this.mTabList.addItemDecoration(new RankItemDividerDecoration(21, 21));
        this.starTourCardLayout = (LinearLayout) this.itemView.findViewById(R$id.homepage_star_tour_card);
        LinearLayout linearLayout2 = (LinearLayout) this.itemView.findViewById(R$id.homepage_star_tour_star);
        this.mStarLayout = linearLayout2;
        linearLayout2.setOnClickListener(this.mOnClickListener);
        this.mStarAvatar = (RoundImageView) this.itemView.findViewById(R$id.homepage_star_tour_star_avatar);
        this.mStarName = (TextView) this.itemView.findViewById(R$id.homepage_star_tour_star_name);
        this.mSaleProjectCount = (TextView) this.itemView.findViewById(R$id.homepage_star_tour_count);
        RelativeLayout relativeLayout = (RelativeLayout) this.itemView.findViewById(R$id.homepage_star_tour_project_layout);
        this.mProjectLayout = relativeLayout;
        relativeLayout.setOnClickListener(this.mOnClickListener);
        this.mPosterView = (DMPosterView) this.itemView.findViewById(R$id.homepage_star_tour_project_image);
        this.mProjectTitle = (TextView) this.itemView.findViewById(R$id.homepage_star_tour_project_title);
        this.mProjectTime = (TextView) this.itemView.findViewById(R$id.homepage_star_tour_project_time);
        this.mProjectCityName = (TextView) this.itemView.findViewById(R$id.homepage_star_tour_project_city);
        this.mProjectLine = this.itemView.findViewById(R$id.homepage_star_tour_project_line);
        this.mProjectVenueName = (TextView) this.itemView.findViewById(R$id.homepage_star_tour_project_venue);
        this.mProjectPriceLayout = (FrameLayout) this.itemView.findViewById(R$id.homepage_star_tour_project_price_layout);
        this.mProjectPrice = (DMDigitTextView) this.itemView.findViewById(R$id.homepage_star_tour_project_price);
        DMDigitTextView dMDigitTextView = (DMDigitTextView) this.itemView.findViewById(R$id.homepage_star_tour_project_price_unknown);
        this.mProjectPriceUnknown = dMDigitTextView;
        dMDigitTextView.setVisibility(8);
        LinearLayout linearLayout3 = (LinearLayout) this.itemView.findViewById(R$id.homepage_star_tour_city_list);
        this.mTourCityListLayout = linearLayout3;
        linearLayout3.setOnClickListener(this.mOnClickListener);
        this.mTourCityCount = (TextView) this.itemView.findViewById(R$id.homepage_star_tour_city_count);
        this.mTourCityName = (TextView) this.itemView.findViewById(R$id.homepage_star_tour_city_name);
        this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void handleProject(HomeStarTourBean.HomeStarTourItem homeStarTourItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "453582152")) {
            ipChange.ipc$dispatch("453582152", new Object[]{this, homeStarTourItem});
        } else if (homeStarTourItem != null) {
            this.mStarLayout.setTag(homeStarTourItem);
            DMImageCreator c = C0504a.b().c(homeStarTourItem.artistHeadPic);
            int i = R$drawable.uikit_user_default_icon;
            c.i(i).c(i).g(this.mStarAvatar);
            this.mStarName.setText(homeStarTourItem.artistName);
            if (TextUtils.isEmpty(homeStarTourItem.total)) {
                this.mSaleProjectCount.setText("");
            } else {
                this.mSaleProjectCount.setText(String.format("%s场在售演出", homeStarTourItem.total));
            }
            this.mProjectLayout.setTag(homeStarTourItem);
            this.mTourCityListLayout.setTag(homeStarTourItem);
            this.mPosterView.setImageUrlForWebp(homeStarTourItem.projectPic, t60.a(this.mContext, 98.0f), t60.a(this.mContext, 131.0f));
            this.mPosterView.setLabelType(DMLabelType.LABEL_TYPE_TOUR);
            if (TextUtils.isEmpty(homeStarTourItem.projectName)) {
                this.mProjectTitle.setText("");
            } else {
                this.mProjectTitle.setText(homeStarTourItem.projectName);
            }
            if (TextUtils.isEmpty(homeStarTourItem.projectDatetime)) {
                this.mProjectTime.setText("");
            } else {
                this.mProjectTime.setText(homeStarTourItem.projectDatetime);
            }
            if (TextUtils.isEmpty(homeStarTourItem.cityName)) {
                this.mProjectCityName.setText("");
            } else {
                this.mProjectCityName.setText(homeStarTourItem.cityName);
            }
            if (TextUtils.isEmpty(homeStarTourItem.venueName)) {
                this.mProjectVenueName.setText("");
            } else {
                this.mProjectVenueName.setText(homeStarTourItem.venueName);
            }
            if (!TextUtils.isEmpty(homeStarTourItem.cityName) && !TextUtils.isEmpty(homeStarTourItem.venueName)) {
                this.mProjectLine.setVisibility(0);
            } else {
                this.mProjectLine.setVisibility(8);
            }
            if (!TextUtils.isEmpty(homeStarTourItem.priceLow) && !homeStarTourItem.priceLow.equals("价格待定") && !homeStarTourItem.priceLow.equals("待定")) {
                this.mProjectPriceUnknown.setVisibility(8);
                this.mProjectPriceLayout.setVisibility(0);
                this.mProjectPrice.setText(homeStarTourItem.priceLow);
            } else {
                this.mProjectPriceLayout.setVisibility(8);
                this.mProjectPriceUnknown.setVisibility(0);
            }
            int e = wh2.e(homeStarTourItem.tourCityNames);
            if (e <= 0) {
                this.mTourCityListLayout.setVisibility(4);
            } else {
                this.mTourCityListLayout.setVisibility(0);
                this.mTourCityCount.setText(String.valueOf(e));
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < e; i2++) {
                    String str = homeStarTourItem.tourCityNames.get(i2);
                    if (!TextUtils.isEmpty(str)) {
                        sb.append(str);
                        if (i2 != e - 1) {
                            sb.append(" | ");
                        }
                    }
                }
                this.mTourCityName.setText(sb.toString());
            }
            oy0.B().K(this.mTrackInfo, this.starTourCardLayout, this.moduleTitle, homeStarTourItem.artistId, homeStarTourItem.position);
            oy0.B().J(this.mTrackInfo, this.mProjectLayout, this.moduleTitle, homeStarTourItem.artistId, homeStarTourItem.projectId, homeStarTourItem.position);
        }
    }

    @Override // cn.damai.tetris.mvp.CommonViewHolder
    protected void setData(CommonBean commonBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-350243324")) {
            ipChange.ipc$dispatch("-350243324", new Object[]{this, commonBean});
        } else if (commonBean == null || !(commonBean instanceof HomeStarTourBean)) {
        } else {
            this.mTrackInfo = commonBean.trackInfo;
            HomeStarTourBean homeStarTourBean = (HomeStarTourBean) commonBean;
            String str = homeStarTourBean.mainTitle;
            this.moduleTitle = str;
            this.mModuleTitle.setText(str);
            this.mMoreTitle.setText(homeStarTourBean.moreText);
            if (!TextUtils.isEmpty(homeStarTourBean.moreText)) {
                oy0.B().L(this.mTrackInfo, this.mMoreTitle);
            }
            this.mMoreTitleLayout.setVisibility(TextUtils.isEmpty(homeStarTourBean.moreText) ? 8 : 0);
            this.mData.clear();
            this.mData.addAll(homeStarTourBean.content);
            this.mData.get(this.currentPosition).isSelected = true;
            this.mTabListAdapter.f(this.mData, this.mTrackInfo, this.moduleTitle);
            handleProject(this.mData.get(this.currentPosition));
        }
    }
}
