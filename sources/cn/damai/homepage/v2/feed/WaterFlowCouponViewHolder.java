package cn.damai.homepage.v2.feed;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.h5container.h5url.VipUrlGetter;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.bean.WaterFlowRecommendItem;
import cn.damai.login.LoginManager;
import cn.damai.tetris.component.home.HomeData;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import tb.C9826vr;
import tb.gh1;
import tb.gi0;
import tb.nk;
import tb.t60;
import tb.ux0;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
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

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.v2.feed.WaterFlowCouponViewHolder$a */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC1262a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1262a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1762051949")) {
                ipChange.ipc$dispatch("-1762051949", new Object[]{this, view});
            } else {
                WaterFlowCouponViewHolder.this.vipClick(view);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.v2.feed.WaterFlowCouponViewHolder$b */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC1263b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1263b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "349238420")) {
                ipChange.ipc$dispatch("349238420", new Object[]{this, view});
            } else {
                WaterFlowCouponViewHolder.this.couponClick(view);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.v2.feed.WaterFlowCouponViewHolder$c */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC1264c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1264c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1834438507")) {
                ipChange.ipc$dispatch("-1834438507", new Object[]{this, view});
            } else {
                WaterFlowCouponViewHolder.this.marktingClick(view);
            }
        }
    }

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

    /* JADX INFO: Access modifiers changed from: private */
    public void couponClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "992083039")) {
            ipChange.ipc$dispatch("992083039", new Object[]{this, view});
            return;
        }
        WaterFlowRecommendItem waterFlowRecommendItem = (WaterFlowRecommendItem) view.getTag();
        ux0.i().m(ux0.g(getComponentActions()), waterFlowRecommendItem.projectId, waterFlowRecommendItem.alg, waterFlowRecommendItem.scm, waterFlowRecommendItem.cardType, "", getData().getIndex());
        if (LoginManager.k().q()) {
            return;
        }
        LoginManager.k().v(this.mContext);
        HomeData.isClickRedPacket = true;
    }

    private void handleCouponView(WaterFlowRecommendItem waterFlowRecommendItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "718387964")) {
            ipChange.ipc$dispatch("718387964", new Object[]{this, waterFlowRecommendItem});
            return;
        }
        if (wh2.j(waterFlowRecommendItem.title)) {
            this.mCouponTitle.setVisibility(4);
        } else {
            this.mCouponTitle.setVisibility(0);
            this.mCouponTitle.setText(waterFlowRecommendItem.title);
            this.mCouponTitle.setTextColor(Color.parseColor("#FFF8D5"));
        }
        if (wh2.j(waterFlowRecommendItem.subTitle)) {
            this.mCouponSubTitle.setVisibility(4);
        } else {
            this.mCouponSubTitle.setVisibility(0);
            this.mCouponSubTitle.setText(waterFlowRecommendItem.subTitle);
            this.mCouponSubTitle.setTextColor(Color.parseColor("#FFF8D5"));
        }
        if (wh2.j(waterFlowRecommendItem.giftsAmount)) {
            this.mCouponPrice.setVisibility(8);
            this.mCouponRMBSymbol.setVisibility(8);
        } else {
            this.mCouponPrice.setVisibility(0);
            this.mCouponRMBSymbol.setVisibility(0);
            this.mCouponPrice.setText(waterFlowRecommendItem.giftsAmount);
        }
        this.mMarktingPrice.setVisibility(4);
        this.mBackGroundImg.setImageResource(R$drawable.homepage_recommend_coupon_bg);
        this.mCouponGetbutton.setBackgroundResource(R$drawable.homepage_recommend_coupon_btn_bg);
        this.mCouponGetbutton.setTextColor(Color.parseColor("#ffffff"));
        this.mCouponGetbutton.setText("立即领取");
        this.itemView.setTag(waterFlowRecommendItem);
        this.itemView.setOnClickListener(new View$OnClickListenerC1263b());
    }

    private void handleMarktingView(WaterFlowRecommendItem waterFlowRecommendItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1846035025")) {
            ipChange.ipc$dispatch("1846035025", new Object[]{this, waterFlowRecommendItem});
            return;
        }
        this.mCouponTitle.setVisibility(4);
        this.mCouponSubTitle.setVisibility(4);
        this.mCouponPrice.setVisibility(4);
        this.mCouponRMBSymbol.setVisibility(4);
        this.mMarktingPrice.setVisibility(4);
        if (this.mBackGroundImg.getTag() instanceof C9826vr) {
            ((C9826vr) this.mBackGroundImg.getTag()).cancel();
        }
        this.mBackGroundImg.setImageDrawable(null);
        DMImageCreator f = C0504a.b().f(waterFlowRecommendItem.pic, this.imageViewWidth, this.imageViewHeight);
        int i = R$drawable.uikit_default_image_bg_gradient;
        this.mBackGroundImg.setTag(f.i(i).c(i).g(this.mBackGroundImg));
        if (!wh2.j(waterFlowRecommendItem.buttonText)) {
            this.mCouponGetbutton.setText(waterFlowRecommendItem.buttonText);
            this.mCouponGetbutton.setTextColor(nk.a(waterFlowRecommendItem.textColor));
            if (!wh2.j(waterFlowRecommendItem.buttonColor1) && !wh2.j(waterFlowRecommendItem.buttonColor2)) {
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor(waterFlowRecommendItem.buttonColor1), Color.parseColor(waterFlowRecommendItem.buttonColor2)});
                gradientDrawable.setCornerRadius(t60.a(this.mContext, 15.0f));
                this.mCouponGetbutton.setBackground(gradientDrawable);
            } else {
                this.mCouponGetbutton.setBackgroundColor(nk.a(waterFlowRecommendItem.buttonColor1));
            }
            this.mCouponGetbutton.setVisibility(0);
        } else {
            this.mCouponGetbutton.setVisibility(4);
        }
        this.itemView.setTag(waterFlowRecommendItem);
        this.itemView.setOnClickListener(new View$OnClickListenerC1264c());
    }

    private void handleVipView(WaterFlowRecommendItem waterFlowRecommendItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1477905565")) {
            ipChange.ipc$dispatch("-1477905565", new Object[]{this, waterFlowRecommendItem});
            return;
        }
        if (wh2.j(waterFlowRecommendItem.name)) {
            this.mCouponTitle.setVisibility(4);
        } else {
            this.mCouponTitle.setVisibility(0);
            this.mCouponTitle.setText(waterFlowRecommendItem.name);
        }
        if (wh2.j(waterFlowRecommendItem.desc)) {
            this.mCouponSubTitle.setVisibility(4);
        } else {
            this.mCouponSubTitle.setVisibility(0);
            this.mCouponSubTitle.setText(waterFlowRecommendItem.desc);
        }
        if (wh2.j(waterFlowRecommendItem.price)) {
            this.mMarktingPrice.setVisibility(4);
        } else {
            this.mMarktingPrice.setVisibility(0);
            TextView textView = this.mMarktingPrice;
            textView.setText("原价 ¥ " + waterFlowRecommendItem.price);
            this.mMarktingPrice.getPaint().setFlags(16);
        }
        if (wh2.j(waterFlowRecommendItem.priceLow)) {
            this.mCouponPrice.setVisibility(4);
        } else {
            this.mCouponPrice.setVisibility(0);
            this.mCouponPrice.setText(waterFlowRecommendItem.priceLow);
        }
        this.mBackGroundImg.setImageDrawable(null);
        this.mBackGroundImg.setImageResource(R$drawable.homepage_recommend_vip_bg);
        this.mCouponGetbutton.setBackgroundResource(R$drawable.homepage_recommend_vip_btn_bg);
        this.mCouponGetbutton.setText("立即开通");
        this.mCouponGetbutton.setTextColor(Color.parseColor("#11172D"));
        this.itemView.setTag(waterFlowRecommendItem);
        this.itemView.setOnClickListener(new View$OnClickListenerC1262a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void marktingClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-10847190")) {
            ipChange.ipc$dispatch("-10847190", new Object[]{this, view});
            return;
        }
        WaterFlowRecommendItem waterFlowRecommendItem = (WaterFlowRecommendItem) view.getTag();
        ux0.i().m(ux0.g(getComponentActions()), waterFlowRecommendItem.projectId, waterFlowRecommendItem.alg, waterFlowRecommendItem.scm, waterFlowRecommendItem.cardType, "", getData().getIndex());
        DMNav.from(this.mContext).toUri(waterFlowRecommendItem.schema);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vipClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "738939592")) {
            ipChange.ipc$dispatch("738939592", new Object[]{this, view});
            return;
        }
        WaterFlowRecommendItem waterFlowRecommendItem = (WaterFlowRecommendItem) view.getTag();
        ux0.i().m(ux0.g(getComponentActions()), waterFlowRecommendItem.projectId, waterFlowRecommendItem.alg, waterFlowRecommendItem.scm, waterFlowRecommendItem.cardType, "", getData().getIndex());
        if (LoginManager.k().q()) {
            DMNav.from(this.mContext).toUri(VipUrlGetter.vipBuyUrl());
        } else {
            LoginManager.k().v(this.mContext);
        }
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NonNull IItem<ItemValue> iItem) {
        Integer num;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-918224700")) {
            ipChange.ipc$dispatch("-918224700", new Object[]{this, iItem});
            return;
        }
        int a = gi0.INSTANCE.a(this.itemView.getContext());
        this.imageViewWidth = a;
        this.imageViewHeight = (int) (((a * 214) * 1.0f) / 160.0f);
        ViewGroup.LayoutParams layoutParams = this.mCouponLayout.getLayoutParams();
        layoutParams.width = this.imageViewWidth;
        layoutParams.height = this.imageViewHeight;
        this.mCouponLayout.setLayoutParams(layoutParams);
        this.itemView.setLayoutParams(new FrameLayout.LayoutParams(-1, ((int) (((this.imageViewWidth * 214) * 1.0f) / 160.0f)) + t60.a(this.context, 9.0f)));
        if (!gh1.a.containsKey(getValue().cardType) || (num = gh1.a.get(getValue().cardType)) == null) {
            return;
        }
        handleView(num.intValue(), getValue());
    }

    public void handleView(int i, WaterFlowRecommendItem waterFlowRecommendItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1789311715")) {
            ipChange.ipc$dispatch("1789311715", new Object[]{this, Integer.valueOf(i), waterFlowRecommendItem});
        } else if (waterFlowRecommendItem == null) {
        } else {
            if (i == 309) {
                handleVipView(waterFlowRecommendItem);
            } else if (i == 301) {
                handleCouponView(waterFlowRecommendItem);
            } else if (i == 302) {
                handleMarktingView(waterFlowRecommendItem);
            }
            ux0.i().k(ux0.g(getComponentActions()), this.itemView, waterFlowRecommendItem.projectId, waterFlowRecommendItem.alg, waterFlowRecommendItem.scm, waterFlowRecommendItem.cardType, "", waterFlowRecommendItem.index);
        }
    }
}
