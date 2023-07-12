package com.alibaba.pictures.bricks.component.home.feed;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.WaterFlowRecommendItem;
import com.alibaba.pictures.bricks.component.home.feed.WaterFlowRankListViewHolder;
import com.alibaba.pictures.bricks.util.C3550a;
import com.alibaba.pictures.bricks.util.DMRGBUtil;
import com.alibaba.pictures.bricks.view.RCRelativeLayoutView;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.image.ImageTicket;
import com.alient.oneservice.image.SuccessEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import tb.mk;
import tb.ru0;
import tb.s60;
import tb.vh2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class WaterFlowRankListViewHolder extends BaseViewHolder<WaterFlowRecommendItem> {
    private static transient /* synthetic */ IpChange $ipChange;
    private int imageViewHeight;
    private int imageViewWidth;
    private Context mContext;
    private ImageView mRankGradient;
    private ImageView mRankListImage;
    private TextView mRankListSubTitle;
    private TextView mRankListTitle;
    private TextView mRankListType;
    private ImageView mRankTopImage;
    private RCRelativeLayoutView rankListImageLayout;

    public WaterFlowRankListViewHolder(View view) {
        super(view);
        this.mContext = view.getContext();
        this.rankListImageLayout = (RCRelativeLayoutView) this.itemView.findViewById(R$id.homepage_waterflow_rank_image_layout);
        this.mRankListImage = (ImageView) this.itemView.findViewById(R$id.homepage_waterflow_rank_image);
        this.mRankGradient = (ImageView) this.itemView.findViewById(R$id.homepage_water_flow_rank_gradient);
        this.mRankTopImage = (ImageView) this.itemView.findViewById(R$id.homepage_waterflow_recommend_ranklist_tag_img);
        this.mRankListType = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_rank_type);
        this.mRankListTitle = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_rank_title);
        this.mRankListSubTitle = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_rank_subtitle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleView$0(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-423458539")) {
            ipChange.ipc$dispatch("-423458539", new Object[]{this, Integer.valueOf(i)});
        } else {
            render(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleView$1(String str, SuccessEvent successEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2138347153")) {
            ipChange.ipc$dispatch("-2138347153", new Object[]{this, str, successEvent});
            return;
        }
        this.mRankListImage.setImageDrawable(successEvent.drawable);
        Bitmap bitmap = successEvent.bitmap;
        if (bitmap != null) {
            DMRGBUtil.g(bitmap, str, new DMRGBUtil.OnFetchColorListener() { // from class: tb.x03
                @Override // com.alibaba.pictures.bricks.util.DMRGBUtil.OnFetchColorListener
                public final void onFetchColor(int i) {
                    WaterFlowRankListViewHolder.this.lambda$handleView$0(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleView$2(FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1444391961")) {
            ipChange.ipc$dispatch("1444391961", new Object[]{this, failEvent});
            return;
        }
        this.mRankListImage.setImageResource(R$drawable.bricks_uikit_default_image_bg_gradient);
        render(Color.parseColor("#819ef2"));
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NonNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1792553965")) {
            ipChange.ipc$dispatch("-1792553965", new Object[]{this, iItem});
            return;
        }
        s60 s60Var = s60.INSTANCE;
        int e = s60Var.e(this.itemView.getContext());
        this.imageViewWidth = e;
        this.imageViewHeight = (int) (((e * 393) * 1.0f) / 342.0f);
        ViewGroup.LayoutParams layoutParams = this.rankListImageLayout.getLayoutParams();
        layoutParams.width = this.imageViewWidth;
        layoutParams.height = this.imageViewHeight;
        this.rankListImageLayout.setLayoutParams(layoutParams);
        this.itemView.setLayoutParams(new FrameLayout.LayoutParams(-1, this.imageViewHeight + s60Var.b(this.mContext, 9)));
        handleView(getValue());
    }

    public void handleView(WaterFlowRecommendItem waterFlowRecommendItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1162676061")) {
            ipChange.ipc$dispatch("-1162676061", new Object[]{this, waterFlowRecommendItem});
        } else if (waterFlowRecommendItem == null) {
        } else {
            this.itemView.setTag(waterFlowRecommendItem);
            if (this.mRankListImage.getTag() instanceof ImageTicket) {
                ((ImageTicket) this.mRankListImage.getTag()).cancel();
            }
            final String str = "5".equals(waterFlowRecommendItem.cardType) ? waterFlowRecommendItem.pic : waterFlowRecommendItem.backgroundPic;
            this.mRankListImage.setTag(ImageLoaderProviderProxy.getProxy().load(C3550a.c(str, this.imageViewWidth, this.imageViewHeight), new IImageSuccListener() { // from class: tb.z03
                @Override // com.alient.oneservice.image.IImageSuccListener
                public final void onSuccess(SuccessEvent successEvent) {
                    WaterFlowRankListViewHolder.this.lambda$handleView$1(str, successEvent);
                }
            }, new IImageFailListener() { // from class: tb.y03
                @Override // com.alient.oneservice.image.IImageFailListener
                public final void onFail(FailEvent failEvent) {
                    WaterFlowRankListViewHolder.this.lambda$handleView$2(failEvent);
                }
            }));
            this.mRankTopImage.setVisibility("5".equals(waterFlowRecommendItem.cardType) ? 0 : 8);
            vh2 vh2Var = vh2.INSTANCE;
            if (vh2Var.c(waterFlowRecommendItem.title)) {
                this.mRankListTitle.setVisibility(4);
            } else {
                this.mRankListTitle.setVisibility(0);
                this.mRankListTitle.setText(waterFlowRecommendItem.title);
            }
            if (vh2Var.c(waterFlowRecommendItem.subTitle)) {
                this.mRankListSubTitle.setVisibility(4);
            } else {
                this.mRankListSubTitle.setVisibility(0);
                this.mRankListSubTitle.setText(waterFlowRecommendItem.subTitle);
            }
            if ("5".equals(waterFlowRecommendItem.cardType)) {
                this.mRankListType.setBackground(this.mContext.getResources().getDrawable(R$drawable.bricks_feed_card_rank_bang));
            } else {
                this.mRankListType.setBackground(this.mContext.getResources().getDrawable(R$drawable.bricks_feed_card_rank_mai));
            }
        }
    }

    public void render(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1178682163")) {
            ipChange.ipc$dispatch("1178682163", new Object[]{this, Integer.valueOf(i)});
        } else {
            ru0.b(this.mRankGradient, GradientDrawable.Orientation.TOP_BOTTOM, 0.0f, new int[]{mk.b(1.0f, i), mk.b(0.8f, i), mk.b(0.4f, i), mk.b(0.0f, i), mk.b(0.0f, i)});
        }
    }
}
