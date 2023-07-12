package com.alibaba.pictures.bricks.component.home.feed;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.WaterFlowRecommendItem;
import com.alibaba.pictures.bricks.util.C3550a;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.alient.oneservice.image.ImageLoaderProvider;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.image.ImageTicket;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import tb.mk;
import tb.s60;
import tb.vh2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class WaterFlowCouponViewHolder extends BaseViewHolder<WaterFlowRecommendItem> {
    private static transient /* synthetic */ IpChange $ipChange;
    private int imageViewHeight;
    private int imageViewWidth;
    private ImageView mBackGroundImg;
    private Context mContext;
    private TextView mCouponGetbutton;
    private RelativeLayout mCouponLayout;
    private TextView mCouponPrice;
    private TextView mCouponRMBSymbol;
    private TextView mCouponSubTitle;
    private TextView mCouponTitle;
    private String mMainTitle;
    private TextView mMarktingPrice;

    public WaterFlowCouponViewHolder(View view) {
        super(view);
        this.mContext = view.getContext();
        this.mCouponLayout = (RelativeLayout) this.itemView.findViewById(R$id.homepage_waterflow_coupon_layout);
        this.mCouponPrice = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_coupon_money);
        this.mMarktingPrice = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_markting_price);
        this.mCouponTitle = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_coupon_title);
        this.mCouponSubTitle = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_coupon_subtitle);
        this.mCouponGetbutton = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_coupon_get_btn);
        this.mCouponRMBSymbol = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_coupon_rmb_symbol);
        this.mBackGroundImg = (ImageView) this.itemView.findViewById(R$id.homepage_waterflow_coupon_image);
    }

    private void handleMarktingView(WaterFlowRecommendItem waterFlowRecommendItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "582112706")) {
            ipChange.ipc$dispatch("582112706", new Object[]{this, waterFlowRecommendItem});
            return;
        }
        this.mCouponTitle.setVisibility(4);
        this.mCouponSubTitle.setVisibility(4);
        this.mCouponPrice.setVisibility(4);
        this.mCouponRMBSymbol.setVisibility(4);
        this.mMarktingPrice.setVisibility(4);
        if (this.mBackGroundImg.getTag() instanceof ImageTicket) {
            ((ImageTicket) this.mBackGroundImg.getTag()).cancel();
        }
        this.mBackGroundImg.setImageDrawable(null);
        String c = C3550a.c(waterFlowRecommendItem.pic, this.imageViewWidth, this.imageViewHeight);
        ImageLoaderProvider proxy = ImageLoaderProviderProxy.getProxy();
        ImageView imageView = this.mBackGroundImg;
        int i = R$drawable.bricks_uikit_default_image_bg_gradient;
        this.mBackGroundImg.setTag(proxy.loadinto(c, imageView, i, i));
        vh2 vh2Var = vh2.INSTANCE;
        if (!vh2Var.c(waterFlowRecommendItem.buttonText)) {
            this.mCouponGetbutton.setText(waterFlowRecommendItem.buttonText);
            this.mCouponGetbutton.setTextColor(mk.a(waterFlowRecommendItem.textColor));
            if (!vh2Var.c(waterFlowRecommendItem.buttonColor1) && !vh2Var.c(waterFlowRecommendItem.buttonColor2)) {
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{mk.a(waterFlowRecommendItem.buttonColor1), mk.a(waterFlowRecommendItem.buttonColor2)});
                gradientDrawable.setCornerRadius(s60.INSTANCE.b(this.mContext, 15));
                this.mCouponGetbutton.setBackground(gradientDrawable);
            } else {
                this.mCouponGetbutton.setBackgroundColor(mk.a(waterFlowRecommendItem.buttonColor1));
            }
            this.mCouponGetbutton.setVisibility(0);
        } else {
            this.mCouponGetbutton.setVisibility(4);
        }
        this.itemView.setTag(waterFlowRecommendItem);
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NonNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1853067817")) {
            ipChange.ipc$dispatch("-1853067817", new Object[]{this, iItem});
            return;
        }
        s60 s60Var = s60.INSTANCE;
        int e = s60Var.e(this.itemView.getContext());
        this.imageViewWidth = e;
        this.imageViewHeight = (int) (((e * 214) * 1.0f) / 160.0f);
        ViewGroup.LayoutParams layoutParams = this.mCouponLayout.getLayoutParams();
        layoutParams.width = this.imageViewWidth;
        layoutParams.height = this.imageViewHeight;
        this.mCouponLayout.setLayoutParams(layoutParams);
        this.itemView.setLayoutParams(new FrameLayout.LayoutParams(-1, ((int) (((this.imageViewWidth * 214) * 1.0f) / 160.0f)) + s60Var.b(this.context, 9)));
        handleView(getValue());
    }

    public void handleView(WaterFlowRecommendItem waterFlowRecommendItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1398658713")) {
            ipChange.ipc$dispatch("-1398658713", new Object[]{this, waterFlowRecommendItem});
        } else if (waterFlowRecommendItem == null) {
        } else {
            handleMarktingView(waterFlowRecommendItem);
        }
    }
}
