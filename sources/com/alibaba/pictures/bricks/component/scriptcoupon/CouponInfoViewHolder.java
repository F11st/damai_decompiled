package com.alibaba.pictures.bricks.component.scriptcoupon;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.CouponInfoBean;
import com.alibaba.pictures.bricks.bean.SkuInfoBean;
import com.alibaba.pictures.bricks.bean.TicketNote;
import com.alibaba.pictures.bricks.component.scriptcoupon.CouponInfoViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.arch.v3.util.DisplayUtils;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class CouponInfoViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private final ImageView a;
    @Nullable
    private final TextView b;
    @Nullable
    private final AppCompatTextView c;
    @Nullable
    private final TextView d;
    @Nullable
    private final TextView e;
    @Nullable
    private final View f;
    @Nullable
    private final View g;
    @Nullable
    private final TextView h;
    @NotNull
    private final LinearLayout i;
    @Nullable
    private final TextView j;
    @Nullable
    private final TextView k;
    @Nullable
    private OnScriptCouponInfoListener l;
    @Nullable
    private CouponInfoBean m;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface OnScriptCouponInfoListener {
        void onScriptCouponMoreBtnClick(@NotNull View view, @NotNull CouponInfoBean couponInfoBean);

        void onScriptCouponViewExpose(@NotNull View view, @NotNull CouponInfoBean couponInfoBean);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CouponInfoViewHolder(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        this.a = (ImageView) view.findViewById(R$id.script_coupon_store_icon);
        this.b = (TextView) view.findViewById(R$id.script_coupon_store_name);
        this.c = (AppCompatTextView) view.findViewById(R$id.script_coupon_coupon_name);
        this.d = (TextView) view.findViewById(R$id.script_coupon_price);
        this.e = (TextView) view.findViewById(R$id.script_coupon_price_icon);
        this.f = view.findViewById(R$id.script_coupon_service_clickll);
        this.g = view.findViewById(R$id.script_coupon_service_more);
        this.h = (TextView) view.findViewById(R$id.script_coupon_service_title);
        View findViewById = view.findViewById(R$id.script_coupon_service_layout);
        b41.h(findViewById, "itemView.findViewById(R.…pt_coupon_service_layout)");
        this.i = (LinearLayout) findViewById;
        this.j = (TextView) view.findViewById(R$id.script_coupon_limit_desc);
        this.k = (TextView) view.findViewById(R$id.script_coupon_sell_num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(CouponInfoViewHolder couponInfoViewHolder, View view) {
        OnScriptCouponInfoListener onScriptCouponInfoListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "436366033")) {
            ipChange.ipc$dispatch("436366033", new Object[]{couponInfoViewHolder, view});
            return;
        }
        b41.i(couponInfoViewHolder, "this$0");
        CouponInfoBean couponInfoBean = couponInfoViewHolder.m;
        if (couponInfoBean == null || (onScriptCouponInfoListener = couponInfoViewHolder.l) == null) {
            return;
        }
        b41.h(view, AdvanceSetting.NETWORK_TYPE);
        onScriptCouponInfoListener.onScriptCouponMoreBtnClick(view, couponInfoBean);
    }

    public final void b(@NotNull CouponInfoBean couponInfoBean) {
        SkuInfoBean skuInfoBean;
        SkuInfoBean skuInfoBean2;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1699860838")) {
            ipChange.ipc$dispatch("-1699860838", new Object[]{this, couponInfoBean});
            return;
        }
        b41.i(couponInfoBean, "bean");
        this.m = couponInfoBean;
        View view = this.f;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: tb.ap
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CouponInfoViewHolder.c(CouponInfoViewHolder.this, view2);
                }
            });
        }
        String storeName = couponInfoBean.getStoreName();
        if (storeName == null || storeName.length() == 0) {
            ImageView imageView = this.a;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            TextView textView = this.b;
            if (textView != null) {
                textView.setVisibility(8);
            }
        } else {
            ImageView imageView2 = this.a;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            TextView textView2 = this.b;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            TextView textView3 = this.b;
            if (textView3 != null) {
                textView3.setText(couponInfoBean.getStoreName());
            }
        }
        AppCompatTextView appCompatTextView = this.c;
        if (appCompatTextView != null) {
            appCompatTextView.setText(couponInfoBean.getItemName());
        }
        ArrayList<SkuInfoBean> skuList = couponInfoBean.getSkuList();
        String str = null;
        String str2 = (skuList == null || (skuInfoBean2 = skuList.get(0)) == null) ? null : skuInfoBean2.price;
        if (str2 == null || str2.length() == 0) {
            TextView textView4 = this.e;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            TextView textView5 = this.d;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
        } else {
            TextView textView6 = this.e;
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
            TextView textView7 = this.d;
            if (textView7 != null) {
                textView7.setVisibility(0);
            }
            TextView textView8 = this.d;
            if (textView8 != null) {
                ArrayList<SkuInfoBean> skuList2 = couponInfoBean.getSkuList();
                if (skuList2 != null && (skuInfoBean = skuList2.get(0)) != null) {
                    str = skuInfoBean.price;
                }
                textView8.setText(str);
            }
        }
        if (couponInfoBean.getServiceNoteList() == null) {
            View view2 = this.g;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            TextView textView9 = this.h;
            if (textView9 != null) {
                textView9.setVisibility(8);
            }
        } else {
            TextView textView10 = this.h;
            if (textView10 != null) {
                textView10.setVisibility(0);
            }
            View view3 = this.g;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            this.i.removeAllViews();
            List<TicketNote> serviceNoteList = couponInfoBean.getServiceNoteList();
            if (serviceNoteList != null) {
                int size = serviceNoteList.size();
                for (int i = 0; i < size; i++) {
                    ImageView imageView3 = new ImageView(this.i.getContext());
                    imageView3.setImageResource(R$drawable.bricks_coupon_service);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DisplayUtils.dp2px(12), DisplayUtils.dp2px(12));
                    layoutParams.setMargins(DisplayUtils.dp2px(7), 0, 0, 0);
                    layoutParams.gravity = 16;
                    this.i.addView(imageView3, layoutParams);
                    TextView textView11 = new TextView(this.i.getContext());
                    textView11.setText(serviceNoteList.get(i).getTitle());
                    textView11.setTextSize(1, 12.0f);
                    textView11.setTextColor(Color.parseColor("#4D4D56"));
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.setMargins(DisplayUtils.dp2px(4), 0, 0, 0);
                    this.i.addView(textView11, layoutParams2);
                }
            }
        }
        String purchaseLimit = couponInfoBean.getPurchaseLimit();
        if (purchaseLimit == null || purchaseLimit.length() == 0) {
            TextView textView12 = this.j;
            if (textView12 != null) {
                textView12.setVisibility(8);
            }
        } else {
            TextView textView13 = this.j;
            if (textView13 != null) {
                textView13.setVisibility(0);
            }
            TextView textView14 = this.j;
            if (textView14 != null) {
                textView14.setText("每笔订单限购" + couponInfoBean.getPurchaseLimit() + (char) 24352);
            }
        }
        String sales = couponInfoBean.getSales();
        if (sales != null && sales.length() != 0) {
            z = false;
        }
        if (z) {
            TextView textView15 = this.k;
            if (textView15 != null) {
                textView15.setVisibility(8);
            }
        } else {
            TextView textView16 = this.k;
            if (textView16 != null) {
                textView16.setVisibility(0);
            }
            TextView textView17 = this.k;
            if (textView17 != null) {
                textView17.setText("半年内售出" + couponInfoBean.getSales());
            }
        }
        OnScriptCouponInfoListener onScriptCouponInfoListener = this.l;
        if (onScriptCouponInfoListener != null) {
            View view4 = this.itemView;
            b41.h(view4, "itemView");
            onScriptCouponInfoListener.onScriptCouponViewExpose(view4, couponInfoBean);
        }
    }

    public final void d(@Nullable OnScriptCouponInfoListener onScriptCouponInfoListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1832307825")) {
            ipChange.ipc$dispatch("1832307825", new Object[]{this, onScriptCouponInfoListener});
        } else {
            this.l = onScriptCouponInfoListener;
        }
    }

    public final void e(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1023502938")) {
            ipChange.ipc$dispatch("-1023502938", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        View view = this.itemView;
        view.setPadding(view.getPaddingLeft(), i, this.itemView.getPaddingRight(), this.itemView.getPaddingBottom());
    }
}
