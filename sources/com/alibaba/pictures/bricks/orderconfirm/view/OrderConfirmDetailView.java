package com.alibaba.pictures.bricks.orderconfirm.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.orderconfirm.bean.CouponOrderRenderBean;
import com.alibaba.pictures.bricks.orderconfirm.view.OrderConfirmDetailView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.List;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class OrderConfirmDetailView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private final View closeView;
    private final View containerView;
    @NotNull
    private final LinearLayout contentView;
    @Nullable
    private Function1<? super View, wt2> dismissListener;
    @Nullable
    private Function1<? super View, wt2> showListener;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class CouponDetailItemView extends LinearLayout {
        private static transient /* synthetic */ IpChange $ipChange;
        private final TextView tv1;
        private final TextView tv2;
        private final TextView tv3;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public CouponDetailItemView(@NotNull Context context) {
            this(context, null, 2, null);
            b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        }

        public /* synthetic */ CouponDetailItemView(Context context, AttributeSet attributeSet, int i, k50 k50Var) {
            this(context, (i & 2) != 0 ? null : attributeSet);
        }

        public final void bindData(@NotNull CouponOrderRenderBean.PriceDetailBean priceDetailBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "759818211")) {
                ipChange.ipc$dispatch("759818211", new Object[]{this, priceDetailBean});
                return;
            }
            b41.i(priceDetailBean, "data");
            this.tv1.setText(priceDetailBean.amountTip);
            this.tv2.setText(priceDetailBean.numTip);
            this.tv3.setText(priceDetailBean.price);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public CouponDetailItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
            LayoutInflater.from(context).inflate(R$layout.bricks_coupon_order_confirm_detail_pop_item_view, this);
            this.tv1 = (TextView) findViewById(R$id.tv_price);
            this.tv2 = (TextView) findViewById(R$id.tv_number);
            this.tv3 = (TextView) findViewById(R$id.tv_total);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OrderConfirmDetailView(@NotNull Context context) {
        this(context, null, 2, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public /* synthetic */ OrderConfirmDetailView(Context context, AttributeSet attributeSet, int i, k50 k50Var) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m184_init_$lambda0(OrderConfirmDetailView orderConfirmDetailView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1102469118")) {
            ipChange.ipc$dispatch("1102469118", new Object[]{orderConfirmDetailView, view});
            return;
        }
        b41.i(orderConfirmDetailView, "this$0");
        orderConfirmDetailView.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m185_init_$lambda1(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-177412299")) {
            ipChange.ipc$dispatch("-177412299", new Object[]{view});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m186_init_$lambda2(OrderConfirmDetailView orderConfirmDetailView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "218960128")) {
            ipChange.ipc$dispatch("218960128", new Object[]{orderConfirmDetailView, view});
            return;
        }
        b41.i(orderConfirmDetailView, "this$0");
        orderConfirmDetailView.dismiss();
    }

    public final void dismiss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1014963346")) {
            ipChange.ipc$dispatch("1014963346", new Object[]{this});
            return;
        }
        Function1<? super View, wt2> function1 = this.dismissListener;
        if (function1 != null) {
            function1.invoke(this);
        }
        setVisibility(8);
    }

    @Nullable
    public final Function1<View, wt2> getDismissListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1145795734") ? (Function1) ipChange.ipc$dispatch("1145795734", new Object[]{this}) : this.dismissListener;
    }

    @Nullable
    public final Function1<View, wt2> getShowListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-530657785") ? (Function1) ipChange.ipc$dispatch("-530657785", new Object[]{this}) : this.showListener;
    }

    public final boolean isShow() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1133118965") ? ((Boolean) ipChange.ipc$dispatch("-1133118965", new Object[]{this})).booleanValue() : getVisibility() == 0;
    }

    public final void setDismissListener(@Nullable Function1<? super View, wt2> function1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1723002664")) {
            ipChange.ipc$dispatch("-1723002664", new Object[]{this, function1});
        } else {
            this.dismissListener = function1;
        }
    }

    public final void setShowListener(@Nullable Function1<? super View, wt2> function1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "886594799")) {
            ipChange.ipc$dispatch("886594799", new Object[]{this, function1});
        } else {
            this.showListener = function1;
        }
    }

    public final void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-53924655")) {
            ipChange.ipc$dispatch("-53924655", new Object[]{this});
            return;
        }
        Function1<? super View, wt2> function1 = this.showListener;
        if (function1 != null) {
            function1.invoke(this);
        }
        setVisibility(0);
    }

    public final void updateContent(@NotNull List<? extends CouponOrderRenderBean.PriceDetailBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1657079395")) {
            ipChange.ipc$dispatch("-1657079395", new Object[]{this, list});
            return;
        }
        b41.i(list, "dataList");
        this.contentView.removeAllViews();
        if (list.isEmpty()) {
            return;
        }
        for (CouponOrderRenderBean.PriceDetailBean priceDetailBean : list) {
            LinearLayout linearLayout = this.contentView;
            Context context = getContext();
            b41.h(context, WPKFactory.INIT_KEY_CONTEXT);
            CouponDetailItemView couponDetailItemView = new CouponDetailItemView(context, null, 2, null);
            couponDetailItemView.bindData(priceDetailBean);
            linearLayout.addView(couponDetailItemView);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OrderConfirmDetailView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        LayoutInflater.from(context).inflate(R$layout.bricks_coupon_order_confirm_detail_pop_layout, this);
        setOnClickListener(new View.OnClickListener() { // from class: tb.rn1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrderConfirmDetailView.m184_init_$lambda0(OrderConfirmDetailView.this, view);
            }
        });
        View findViewById = findViewById(R$id.order_coupon_detail);
        this.containerView = findViewById;
        View findViewById2 = findViewById(R$id.ll_ticket_info);
        b41.h(findViewById2, "findViewById(R.id.ll_ticket_info)");
        this.contentView = (LinearLayout) findViewById2;
        View findViewById3 = findViewById(R$id.close);
        this.closeView = findViewById3;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: tb.tn1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrderConfirmDetailView.m185_init_$lambda1(view);
            }
        });
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: tb.sn1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrderConfirmDetailView.m186_init_$lambda2(OrderConfirmDetailView.this, view);
            }
        });
    }
}
