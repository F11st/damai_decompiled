package cn.damai.homepage.v2.feed;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.damai.baseview.RCRelativeLayoutView;
import cn.damai.category.ranking.ui.RankListFragment;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.util.DMRGBUtil;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.bean.WaterFlowRecommendItem;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import tb.cb1;
import tb.cs;
import tb.gi0;
import tb.nk;
import tb.su0;
import tb.t60;
import tb.ux0;
import tb.vr;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WaterFlowRankListViewHolder extends BaseViewHolder<WaterFlowRecommendItem> {
    private static transient /* synthetic */ IpChange $ipChange;
    private int imageViewHeight;
    private int imageViewWidth;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private ImageView mRankGradient;
    private ImageView mRankListImage;
    private TextView mRankListSubTitle;
    private TextView mRankListTitle;
    private TextView mRankListType;
    private ImageView mRankTopImage;
    private RCRelativeLayoutView rankListImageLayout;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1465682921")) {
                ipChange.ipc$dispatch("-1465682921", new Object[]{this, view});
                return;
            }
            WaterFlowRecommendItem waterFlowRecommendItem = (WaterFlowRecommendItem) view.getTag();
            ux0 i = ux0.i();
            String g = ux0.g(WaterFlowRankListViewHolder.this.getComponentActions());
            String str = waterFlowRecommendItem.projectId;
            String str2 = waterFlowRecommendItem.alg;
            String str3 = waterFlowRecommendItem.scm;
            String str4 = waterFlowRecommendItem.cardType;
            i.m(g, str, str2, str3, str4, "5".equals(str4) ? waterFlowRecommendItem.id : waterFlowRecommendItem.detailedListId, WaterFlowRankListViewHolder.this.getData().getIndex());
            Bundle bundle = new Bundle();
            if ("5".equals(waterFlowRecommendItem.cardType)) {
                long j = 0;
                try {
                    j = Long.parseLong(waterFlowRecommendItem.id);
                } catch (Exception e) {
                    cb1.b("WaterFlowRankListViewHolder", e.getMessage());
                }
                bundle.putLong(RankListFragment.KEY_RANK_ID, j);
                DMNav.from(WaterFlowRankListViewHolder.this.mContext).withExtras(bundle).toUri(NavUri.b(cs.C));
                return;
            }
            bundle.putString("id", waterFlowRecommendItem.detailedListId);
            DMNav.from(WaterFlowRankListViewHolder.this.mContext).withExtras(bundle).toUri(NavUri.b("detailed_list"));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class b implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "475830602")) {
                ipChange.ipc$dispatch("475830602", new Object[]{this, dVar});
                return;
            }
            WaterFlowRankListViewHolder.this.mRankListImage.setImageResource(R$drawable.uikit_default_image_bg_gradient);
            WaterFlowRankListViewHolder.this.render(Color.parseColor("#819ef2"));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        /* compiled from: Taobao */
        /* loaded from: classes5.dex */
        public class a implements DMRGBUtil.OnFetchColorListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // cn.damai.commonbusiness.util.DMRGBUtil.OnFetchColorListener
            public void onFetchColor(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "158694070")) {
                    ipChange.ipc$dispatch("158694070", new Object[]{this, Integer.valueOf(i)});
                } else {
                    WaterFlowRankListViewHolder.this.render(i);
                }
            }
        }

        c(String str) {
            this.a = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1534520159")) {
                ipChange.ipc$dispatch("1534520159", new Object[]{this, eVar});
                return;
            }
            WaterFlowRankListViewHolder.this.mRankListImage.setImageDrawable(eVar.a);
            Bitmap bitmap = eVar.b;
            if (bitmap != null) {
                DMRGBUtil.h(bitmap, this.a, new a());
            }
        }
    }

    public WaterFlowRankListViewHolder(View view) {
        super(view);
        this.mOnClickListener = new a();
        this.mContext = view.getContext();
        this.rankListImageLayout = (RCRelativeLayoutView) this.itemView.findViewById(R$id.homepage_waterflow_rank_image_layout);
        this.mRankListImage = (ImageView) this.itemView.findViewById(R$id.homepage_waterflow_rank_image);
        this.mRankGradient = (ImageView) this.itemView.findViewById(R$id.homepage_water_flow_rank_gradient);
        this.mRankTopImage = (ImageView) this.itemView.findViewById(R$id.homepage_waterflow_recommend_ranklist_tag_img);
        this.mRankListType = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_rank_type);
        this.mRankListTitle = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_rank_title);
        this.mRankListSubTitle = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_rank_subtitle);
        this.itemView.setOnClickListener(this.mOnClickListener);
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NonNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1056483392")) {
            ipChange.ipc$dispatch("-1056483392", new Object[]{this, iItem});
            return;
        }
        int a2 = gi0.INSTANCE.a(this.itemView.getContext());
        this.imageViewWidth = a2;
        this.imageViewHeight = (int) (((a2 * 393) * 1.0f) / 342.0f);
        ViewGroup.LayoutParams layoutParams = this.rankListImageLayout.getLayoutParams();
        layoutParams.width = this.imageViewWidth;
        layoutParams.height = this.imageViewHeight;
        this.rankListImageLayout.setLayoutParams(layoutParams);
        this.itemView.setLayoutParams(new FrameLayout.LayoutParams(-1, this.imageViewHeight + t60.a(this.mContext, 9.0f)));
        handleView(getValue());
    }

    public void handleView(WaterFlowRecommendItem waterFlowRecommendItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2049650638")) {
            ipChange.ipc$dispatch("-2049650638", new Object[]{this, waterFlowRecommendItem});
        } else if (waterFlowRecommendItem == null) {
        } else {
            this.itemView.setTag(waterFlowRecommendItem);
            if (this.mRankListImage.getTag() instanceof vr) {
                ((vr) this.mRankListImage.getTag()).cancel();
            }
            String str = "5".equals(waterFlowRecommendItem.cardType) ? waterFlowRecommendItem.pic : waterFlowRecommendItem.backgroundPic;
            this.mRankListImage.setTag(cn.damai.common.image.a.b().f(str, this.imageViewWidth, this.imageViewHeight).n(new c(str)).e(new b()).f());
            this.mRankTopImage.setVisibility("5".equals(waterFlowRecommendItem.cardType) ? 0 : 8);
            if (wh2.j(waterFlowRecommendItem.title)) {
                this.mRankListTitle.setVisibility(4);
            } else {
                this.mRankListTitle.setVisibility(0);
                this.mRankListTitle.setText(waterFlowRecommendItem.title);
            }
            if (wh2.j(waterFlowRecommendItem.subTitle)) {
                this.mRankListSubTitle.setVisibility(4);
            } else {
                this.mRankListSubTitle.setVisibility(0);
                this.mRankListSubTitle.setText(waterFlowRecommendItem.subTitle);
            }
            if ("5".equals(waterFlowRecommendItem.cardType)) {
                this.mRankListType.setBackground(this.mContext.getResources().getDrawable(R$drawable.feed_card_rank_bang));
            } else {
                this.mRankListType.setBackground(this.mContext.getResources().getDrawable(R$drawable.feed_card_rank_mai));
            }
            ux0 i = ux0.i();
            String g = ux0.g(getComponentActions());
            View view = this.itemView;
            String str2 = waterFlowRecommendItem.projectId;
            String str3 = waterFlowRecommendItem.alg;
            String str4 = waterFlowRecommendItem.scm;
            String str5 = waterFlowRecommendItem.cardType;
            i.k(g, view, str2, str3, str4, str5, "5".equals(str5) ? waterFlowRecommendItem.id : waterFlowRecommendItem.detailedListId, waterFlowRecommendItem.index);
        }
    }

    public void render(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1152545504")) {
            ipChange.ipc$dispatch("-1152545504", new Object[]{this, Integer.valueOf(i)});
        } else {
            su0.b(this.mRankGradient, GradientDrawable.Orientation.TOP_BOTTOM, 0.0f, new int[]{nk.c(1.0f, i), nk.c(0.8f, i), nk.c(0.4f, i), nk.c(0.0f, i), nk.c(0.0f, i)});
        }
    }
}
