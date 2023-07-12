package com.alibaba.pictures.bricks.orderconfirm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.base.BricksBaseFragment;
import com.alibaba.pictures.bricks.orderconfirm.CouponOrderConfirmFragment;
import com.alibaba.pictures.bricks.orderconfirm.bean.CouponOrderRenderBean;
import com.alibaba.pictures.bricks.orderconfirm.bean.CouponSubmitOrderBean;
import com.alibaba.pictures.bricks.orderconfirm.bean.OrderCreateBean;
import com.alibaba.pictures.bricks.orderconfirm.request.CouponOrderRenderRequest;
import com.alibaba.pictures.bricks.orderconfirm.request.CouponSubmitOrderRequest;
import com.alibaba.pictures.bricks.orderconfirm.view.OrderConfirmDetailView;
import com.alibaba.pictures.bricks.util.PaymentService;
import com.alibaba.pictures.bricks.util.toast.BricksToastUtil;
import com.alibaba.pictures.bricks.view.DigitTextView;
import com.alibaba.pictures.dolores.login.DoloresLoginHandler;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.text.C8604o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.cc0;
import tb.dc0;
import tb.k50;
import tb.rb0;
import tb.vn1;
import tb.wt2;
import tb.yb1;
import tb.z13;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class CouponOrderConfirmFragment extends BricksBaseFragment implements OnEventListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final C3532a Companion = new C3532a(null);
    @NotNull
    public static final String EVENT_PAY_TYPE = "pay_type";
    @NotNull
    public static final String ITEM_ID = "itemId";
    public static final int LOGIN_RESULT = 2000;
    @NotNull
    public static final String SKU_ID = "skuId";
    public OrderConfirmAdapter adapter;
    public ImageView bottomArrow;
    public LinearLayout bottomLayout;
    public DigitTextView bottomPriceTotal;
    private int buyAmount = 1;
    private OrderConfirmDetailView detailPopView;
    public ViewGroup errContainer;
    public RecyclerView irc;
    @Nullable
    private String itemId;
    @Nullable
    private String payType;
    @Nullable
    private PaymentService paymentService;
    @Nullable
    private CouponOrderRenderBean.PriceInfo priceInfo;
    @Nullable
    private CouponOrderRenderBean.BaseRequestData requestData;
    public View rootView;
    @Nullable
    private String skuId;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.orderconfirm.CouponOrderConfirmFragment$a */
    /* loaded from: classes7.dex */
    public static final class C3532a {
        private C3532a() {
        }

        public /* synthetic */ C3532a(k50 k50Var) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bottomViewRender(CouponOrderRenderBean.PriceInfo priceInfo) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1577112654")) {
            ipChange.ipc$dispatch("1577112654", new Object[]{this, priceInfo});
            return;
        }
        this.priceInfo = priceInfo;
        if (priceInfo == null || (str = priceInfo.totalPriceTxt) == null) {
            return;
        }
        getBottomPriceTotal().setText(str);
    }

    private final void gotoLogin() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "27786566")) {
            ipChange.ipc$dispatch("27786566", new Object[]{this});
        } else {
            yb1.Companion.d(this, 2000);
        }
    }

    private final void initIrc() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "103890722")) {
            ipChange.ipc$dispatch("103890722", new Object[]{this});
            return;
        }
        Context context = getContext();
        if (context != null) {
            setAdapter(new OrderConfirmAdapter(context, this));
            getIrc().setAdapter(getAdapter());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(1);
            getIrc().setLayoutManager(linearLayoutManager);
        }
    }

    private final void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1619794249")) {
            ipChange.ipc$dispatch("1619794249", new Object[]{this});
            return;
        }
        View findViewById = getRootView().findViewById(R$id.irc);
        b41.h(findViewById, "rootView.findViewById(R.id.irc)");
        setIrc((RecyclerView) findViewById);
        View findViewById2 = getRootView().findViewById(R$id.bottom_total_price);
        b41.h(findViewById2, "rootView.findViewById(R.id.bottom_total_price)");
        setBottomPriceTotal((DigitTextView) findViewById2);
        View findViewById3 = getRootView().findViewById(R$id.order_render_bottom);
        b41.h(findViewById3, "rootView.findViewById(R.id.order_render_bottom)");
        setBottomLayout((LinearLayout) findViewById3);
        View findViewById4 = getRootView().findViewById(R$id.bottom_price_down_arrow);
        b41.g(findViewById4, "null cannot be cast to non-null type android.widget.ImageView");
        setBottomArrow((ImageView) findViewById4);
        vn1 vn1Var = vn1.INSTANCE;
        vn1Var.e(getBottomArrow(), this.itemId);
        getBottomArrow().setOnClickListener(new View.OnClickListener() { // from class: tb.dp
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CouponOrderConfirmFragment.m181initView$lambda0(CouponOrderConfirmFragment.this, view);
            }
        });
        View findViewById5 = getRootView().findViewById(R$id.error_container);
        b41.h(findViewById5, "rootView.findViewById(R.id.error_container)");
        setErrContainer((ViewGroup) findViewById5);
        getRootView().findViewById(R$id.bottom_price_detail_desc).setOnClickListener(new View.OnClickListener() { // from class: tb.cp
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CouponOrderConfirmFragment.m182initView$lambda1(CouponOrderConfirmFragment.this, view);
            }
        });
        final View findViewById6 = getRootView().findViewById(R$id.bottom_submit_order);
        b41.h(findViewById6, "submitOrder");
        vn1Var.i(findViewById6, this.itemId);
        findViewById6.setOnClickListener(new View.OnClickListener() { // from class: tb.ep
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CouponOrderConfirmFragment.m183initView$lambda2(CouponOrderConfirmFragment.this, findViewById6, view);
            }
        });
        View findViewById7 = getRootView().findViewById(R$id.order_detail_pop);
        b41.h(findViewById7, "rootView.findViewById(R.id.order_detail_pop)");
        OrderConfirmDetailView orderConfirmDetailView = (OrderConfirmDetailView) findViewById7;
        this.detailPopView = orderConfirmDetailView;
        OrderConfirmDetailView orderConfirmDetailView2 = null;
        if (orderConfirmDetailView == null) {
            b41.A("detailPopView");
            orderConfirmDetailView = null;
        }
        orderConfirmDetailView.setShowListener(new Function1<View, wt2>() { // from class: com.alibaba.pictures.bricks.orderconfirm.CouponOrderConfirmFragment$initView$4
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(View view) {
                invoke2(view);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-966477203")) {
                    ipChange2.ipc$dispatch("-966477203", new Object[]{this, view});
                    return;
                }
                b41.i(view, AdvanceSetting.NETWORK_TYPE);
                CouponOrderConfirmFragment.this.getBottomArrow().setImageResource(R$drawable.bricks_down_arrow);
            }
        });
        OrderConfirmDetailView orderConfirmDetailView3 = this.detailPopView;
        if (orderConfirmDetailView3 == null) {
            b41.A("detailPopView");
        } else {
            orderConfirmDetailView2 = orderConfirmDetailView3;
        }
        orderConfirmDetailView2.setDismissListener(new Function1<View, wt2>() { // from class: com.alibaba.pictures.bricks.orderconfirm.CouponOrderConfirmFragment$initView$5
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(View view) {
                invoke2(view);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1318386252")) {
                    ipChange2.ipc$dispatch("1318386252", new Object[]{this, view});
                    return;
                }
                b41.i(view, AdvanceSetting.NETWORK_TYPE);
                CouponOrderConfirmFragment.this.getBottomArrow().setImageResource(R$drawable.bricks_up_arrow);
            }
        });
        initIrc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m181initView$lambda0(CouponOrderConfirmFragment couponOrderConfirmFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-284286267")) {
            ipChange.ipc$dispatch("-284286267", new Object[]{couponOrderConfirmFragment, view});
            return;
        }
        b41.i(couponOrderConfirmFragment, "this$0");
        couponOrderConfirmFragment.purchaseDetails();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initView$lambda-1  reason: not valid java name */
    public static final void m182initView$lambda1(CouponOrderConfirmFragment couponOrderConfirmFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-298536412")) {
            ipChange.ipc$dispatch("-298536412", new Object[]{couponOrderConfirmFragment, view});
            return;
        }
        b41.i(couponOrderConfirmFragment, "this$0");
        couponOrderConfirmFragment.purchaseDetails();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initView$lambda-2  reason: not valid java name */
    public static final void m183initView$lambda2(CouponOrderConfirmFragment couponOrderConfirmFragment, View view, View view2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1346205073")) {
            ipChange.ipc$dispatch("-1346205073", new Object[]{couponOrderConfirmFragment, view, view2});
            return;
        }
        b41.i(couponOrderConfirmFragment, "this$0");
        if (couponOrderConfirmFragment.payType == null) {
            BricksToastUtil.INSTANCE.b("请选择支付方式");
            return;
        }
        vn1 vn1Var = vn1.INSTANCE;
        b41.h(view, "submitOrder");
        vn1Var.h(view, couponOrderConfirmFragment.itemId);
        String valueOf = String.valueOf(couponOrderConfirmFragment.buyAmount);
        CouponOrderRenderBean.PriceInfo priceInfo = couponOrderConfirmFragment.priceInfo;
        couponOrderConfirmFragment.submitOrder(valueOf, priceInfo != null ? priceInfo.totalPrice : null, couponOrderConfirmFragment.payType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void parsePayType(CouponOrderRenderBean couponOrderRenderBean) {
        List<OrderCreateBean> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-663011990")) {
            ipChange.ipc$dispatch("-663011990", new Object[]{this, couponOrderRenderBean});
        } else if (this.payType == null && (list = couponOrderRenderBean.dataList) != null) {
            for (OrderCreateBean orderCreateBean : list) {
                if (b41.d(orderCreateBean.templateId, "damai_script_play_payment_method")) {
                    try {
                        this.payType = orderCreateBean.data.getJSONArray("payToolList").getJSONObject(0).getString("code");
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    private final void purchaseDetails() {
        List<CouponOrderRenderBean.PriceDetailBean> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "467977195")) {
            ipChange.ipc$dispatch("467977195", new Object[]{this});
            return;
        }
        vn1.INSTANCE.d(getBottomArrow(), this.itemId);
        OrderConfirmDetailView orderConfirmDetailView = this.detailPopView;
        OrderConfirmDetailView orderConfirmDetailView2 = null;
        if (orderConfirmDetailView == null) {
            b41.A("detailPopView");
            orderConfirmDetailView = null;
        }
        if (orderConfirmDetailView.isShow()) {
            OrderConfirmDetailView orderConfirmDetailView3 = this.detailPopView;
            if (orderConfirmDetailView3 == null) {
                b41.A("detailPopView");
            } else {
                orderConfirmDetailView2 = orderConfirmDetailView3;
            }
            orderConfirmDetailView2.dismiss();
            return;
        }
        CouponOrderRenderBean.PriceInfo priceInfo = this.priceInfo;
        if (priceInfo == null || (list = priceInfo.priceDetailList) == null) {
            return;
        }
        OrderConfirmDetailView orderConfirmDetailView4 = this.detailPopView;
        if (orderConfirmDetailView4 == null) {
            b41.A("detailPopView");
            orderConfirmDetailView4 = null;
        }
        orderConfirmDetailView4.updateContent(list);
        OrderConfirmDetailView orderConfirmDetailView5 = this.detailPopView;
        if (orderConfirmDetailView5 == null) {
            b41.A("detailPopView");
        } else {
            orderConfirmDetailView2 = orderConfirmDetailView5;
        }
        orderConfirmDetailView2.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestOrderRender() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "212541801")) {
            ipChange.ipc$dispatch("212541801", new Object[]{this});
            return;
        }
        showLoading("");
        if (DoloresLoginHandler.Companion.a().c()) {
            rb0.C9647a c9647a = rb0.Companion;
            CouponOrderRenderRequest couponOrderRenderRequest = new CouponOrderRenderRequest();
            couponOrderRenderRequest.setItemId(this.itemId);
            couponOrderRenderRequest.setSkuId(this.skuId);
            couponOrderRenderRequest.setBuyAmount(this.buyAmount);
            c9647a.b(couponOrderRenderRequest).c(getContext()).a().doOnKTSuccess(new Function1<CouponOrderRenderBean, wt2>() { // from class: com.alibaba.pictures.bricks.orderconfirm.CouponOrderConfirmFragment$requestOrderRender$2
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ wt2 invoke(CouponOrderRenderBean couponOrderRenderBean) {
                    invoke2(couponOrderRenderBean);
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull CouponOrderRenderBean couponOrderRenderBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-164863146")) {
                        ipChange2.ipc$dispatch("-164863146", new Object[]{this, couponOrderRenderBean});
                        return;
                    }
                    b41.i(couponOrderRenderBean, AdvanceSetting.NETWORK_TYPE);
                    CouponOrderConfirmFragment.this.parsePayType(couponOrderRenderBean);
                    CouponOrderConfirmFragment.this.setRequestData(couponOrderRenderBean.baseRequestData);
                    CouponOrderConfirmFragment couponOrderConfirmFragment = CouponOrderConfirmFragment.this;
                    CouponOrderRenderBean.BaseRequestData baseRequestData = couponOrderRenderBean.baseRequestData;
                    couponOrderConfirmFragment.setBuyAmount(baseRequestData != null ? baseRequestData.buyAmount : 1);
                    CouponOrderConfirmFragment.this.getAdapter().setData(couponOrderRenderBean.dataList);
                    CouponOrderConfirmFragment.this.bottomViewRender(couponOrderRenderBean.priceInfo);
                    CouponOrderConfirmFragment.this.getBottomLayout().setVisibility(0);
                    CouponOrderConfirmFragment.this.getErrContainer().setVisibility(8);
                    CouponOrderConfirmFragment couponOrderConfirmFragment2 = CouponOrderConfirmFragment.this;
                    couponOrderConfirmFragment2.removeErrorView(couponOrderConfirmFragment2.getErrContainer());
                }
            }).doOnKTFail(new Function1<dc0<CouponOrderRenderBean>, wt2>() { // from class: com.alibaba.pictures.bricks.orderconfirm.CouponOrderConfirmFragment$requestOrderRender$3
                private static transient /* synthetic */ IpChange $ipChange;

                /* compiled from: Taobao */
                /* renamed from: com.alibaba.pictures.bricks.orderconfirm.CouponOrderConfirmFragment$requestOrderRender$3$a */
                /* loaded from: classes7.dex */
                public static final class C3533a implements BricksBaseFragment.IClickListener {
                    private static transient /* synthetic */ IpChange $ipChange;
                    final /* synthetic */ CouponOrderConfirmFragment a;

                    C3533a(CouponOrderConfirmFragment couponOrderConfirmFragment) {
                        this.a = couponOrderConfirmFragment;
                    }

                    @Override // com.alibaba.pictures.bricks.base.BricksBaseFragment.IClickListener
                    public void handleClick(int i) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1107978594")) {
                            ipChange.ipc$dispatch("1107978594", new Object[]{this, Integer.valueOf(i)});
                        } else {
                            this.a.requestOrderRender();
                        }
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ wt2 invoke(dc0<CouponOrderRenderBean> dc0Var) {
                    invoke2(dc0Var);
                    return wt2.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
                    if (r0 == true) goto L12;
                 */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke2(@org.jetbrains.annotations.NotNull tb.dc0<com.alibaba.pictures.bricks.orderconfirm.bean.CouponOrderRenderBean> r15) {
                    /*
                        Method dump skipped, instructions count: 277
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.orderconfirm.CouponOrderConfirmFragment$requestOrderRender$3.invoke2(tb.dc0):void");
                }
            }).doOnKTFinish(new Function0<wt2>() { // from class: com.alibaba.pictures.bricks.orderconfirm.CouponOrderConfirmFragment$requestOrderRender$4
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
                    if (AndroidInstantRuntime.support(ipChange2, "-1665735643")) {
                        ipChange2.ipc$dispatch("-1665735643", new Object[]{this});
                    } else {
                        CouponOrderConfirmFragment.this.hideLoading();
                    }
                }
            });
            return;
        }
        gotoLogin();
    }

    private final void submitOrder(String str, String str2, final String str3) {
        String str4;
        String str5;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-769696620")) {
            ipChange.ipc$dispatch("-769696620", new Object[]{this, str, str2, str3});
            return;
        }
        showLoadingDialog("");
        CouponSubmitOrderRequest couponSubmitOrderRequest = new CouponSubmitOrderRequest();
        CouponOrderRenderBean.BaseRequestData baseRequestData = this.requestData;
        if (baseRequestData == null || (str4 = baseRequestData.itemId) == null) {
            str4 = this.itemId;
        }
        couponSubmitOrderRequest.setItemId(str4);
        CouponOrderRenderBean.BaseRequestData baseRequestData2 = this.requestData;
        if (baseRequestData2 == null || (str5 = baseRequestData2.skuId) == null) {
            str5 = this.skuId;
        }
        couponSubmitOrderRequest.setSkuId(str5);
        CouponOrderRenderBean.BaseRequestData baseRequestData3 = this.requestData;
        couponSubmitOrderRequest.setBuyAmount(baseRequestData3 != null ? Integer.valueOf(baseRequestData3.buyAmount).toString() : null);
        CouponOrderRenderBean.BaseRequestData baseRequestData4 = this.requestData;
        couponSubmitOrderRequest.setItemType(baseRequestData4 != null ? baseRequestData4.itemType : null);
        couponSubmitOrderRequest.setTotalPrice(str2);
        couponSubmitOrderRequest.setPayTypeCode(str3);
        cc0.a(couponSubmitOrderRequest).doOnKTSuccess(new Function1<CouponSubmitOrderBean, wt2>() { // from class: com.alibaba.pictures.bricks.orderconfirm.CouponOrderConfirmFragment$submitOrder$2
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(CouponSubmitOrderBean couponSubmitOrderBean) {
                invoke2(couponSubmitOrderBean);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull CouponSubmitOrderBean couponSubmitOrderBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1774688831")) {
                    ipChange2.ipc$dispatch("-1774688831", new Object[]{this, couponSubmitOrderBean});
                    return;
                }
                b41.i(couponSubmitOrderBean, AdvanceSetting.NETWORK_TYPE);
                couponSubmitOrderBean.payTypeCode = str3;
                PaymentService paymentService = this.getPaymentService();
                if (paymentService != null) {
                    paymentService.startPay(couponSubmitOrderBean);
                }
            }
        }).doOnKTFail(new Function1<dc0<CouponSubmitOrderBean>, wt2>() { // from class: com.alibaba.pictures.bricks.orderconfirm.CouponOrderConfirmFragment$submitOrder$3
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(dc0<CouponSubmitOrderBean> dc0Var) {
                invoke2(dc0Var);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull dc0<CouponSubmitOrderBean> dc0Var) {
                boolean D;
                IpChange ipChange2 = $ipChange;
                boolean z = false;
                if (AndroidInstantRuntime.support(ipChange2, "1057921151")) {
                    ipChange2.ipc$dispatch("1057921151", new Object[]{this, dc0Var});
                    return;
                }
                b41.i(dc0Var, AdvanceSetting.NETWORK_TYPE);
                String e = dc0Var.e();
                if (e != null) {
                    D = C8604o.D(e, "DM_", true);
                    if (D) {
                        z = true;
                    }
                }
                if (z) {
                    BricksToastUtil.INSTANCE.b(dc0Var.f());
                } else {
                    BricksToastUtil.INSTANCE.b("麦麦很忙，系统很累请稍后重试");
                }
                String str6 = new CouponOrderRenderRequest().API_NAME;
                String e2 = dc0Var.e();
                String f = dc0Var.f();
                z13.a(z13.b(str6, "券提交订单接口", e2, f, "itemId: " + CouponOrderConfirmFragment.this.getItemId() + "  skuId：" + CouponOrderConfirmFragment.this.getSkuId() + "  支付方式：" + str3), "-4312", "券提交订单接口错误");
            }
        }).doOnKTFinish(new Function0<wt2>() { // from class: com.alibaba.pictures.bricks.orderconfirm.CouponOrderConfirmFragment$submitOrder$4
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
                if (AndroidInstantRuntime.support(ipChange2, "38329288")) {
                    ipChange2.ipc$dispatch("38329288", new Object[]{this});
                } else {
                    CouponOrderConfirmFragment.this.hideLoadingDialog();
                }
            }
        });
    }

    @NotNull
    public final OrderConfirmAdapter getAdapter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "120389532")) {
            return (OrderConfirmAdapter) ipChange.ipc$dispatch("120389532", new Object[]{this});
        }
        OrderConfirmAdapter orderConfirmAdapter = this.adapter;
        if (orderConfirmAdapter != null) {
            return orderConfirmAdapter;
        }
        b41.A("adapter");
        return null;
    }

    @NotNull
    public final ImageView getBottomArrow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "232938042")) {
            return (ImageView) ipChange.ipc$dispatch("232938042", new Object[]{this});
        }
        ImageView imageView = this.bottomArrow;
        if (imageView != null) {
            return imageView;
        }
        b41.A("bottomArrow");
        return null;
    }

    @NotNull
    public final LinearLayout getBottomLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1829090344")) {
            return (LinearLayout) ipChange.ipc$dispatch("-1829090344", new Object[]{this});
        }
        LinearLayout linearLayout = this.bottomLayout;
        if (linearLayout != null) {
            return linearLayout;
        }
        b41.A("bottomLayout");
        return null;
    }

    @NotNull
    public final DigitTextView getBottomPriceTotal() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-938092932")) {
            return (DigitTextView) ipChange.ipc$dispatch("-938092932", new Object[]{this});
        }
        DigitTextView digitTextView = this.bottomPriceTotal;
        if (digitTextView != null) {
            return digitTextView;
        }
        b41.A("bottomPriceTotal");
        return null;
    }

    public final int getBuyAmount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1278738409") ? ((Integer) ipChange.ipc$dispatch("1278738409", new Object[]{this})).intValue() : this.buyAmount;
    }

    @NotNull
    public final ViewGroup getErrContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1587601509")) {
            return (ViewGroup) ipChange.ipc$dispatch("-1587601509", new Object[]{this});
        }
        ViewGroup viewGroup = this.errContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        b41.A("errContainer");
        return null;
    }

    @NotNull
    public final RecyclerView getIrc() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "673183105")) {
            return (RecyclerView) ipChange.ipc$dispatch("673183105", new Object[]{this});
        }
        RecyclerView recyclerView = this.irc;
        if (recyclerView != null) {
            return recyclerView;
        }
        b41.A("irc");
        return null;
    }

    @Nullable
    public final String getItemId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1717038040") ? (String) ipChange.ipc$dispatch("1717038040", new Object[]{this}) : this.itemId;
    }

    @Nullable
    public final String getPayType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "671165230") ? (String) ipChange.ipc$dispatch("671165230", new Object[]{this}) : this.payType;
    }

    @Nullable
    public final PaymentService getPaymentService() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1445111648") ? (PaymentService) ipChange.ipc$dispatch("1445111648", new Object[]{this}) : this.paymentService;
    }

    @Nullable
    public final CouponOrderRenderBean.PriceInfo getPriceInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-974986477") ? (CouponOrderRenderBean.PriceInfo) ipChange.ipc$dispatch("-974986477", new Object[]{this}) : this.priceInfo;
    }

    @Nullable
    public final CouponOrderRenderBean.BaseRequestData getRequestData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1359753984") ? (CouponOrderRenderBean.BaseRequestData) ipChange.ipc$dispatch("-1359753984", new Object[]{this}) : this.requestData;
    }

    @NotNull
    public final View getRootView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1311812177")) {
            return (View) ipChange.ipc$dispatch("1311812177", new Object[]{this});
        }
        View view = this.rootView;
        if (view != null) {
            return view;
        }
        b41.A("rootView");
        return null;
    }

    @Nullable
    public final String getSkuId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2080982140") ? (String) ipChange.ipc$dispatch("-2080982140", new Object[]{this}) : this.skuId;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2091368194")) {
            ipChange.ipc$dispatch("2091368194", new Object[]{this, bundle});
            return;
        }
        super.onActivityCreated(bundle);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((JSONObject) "itemId", this.itemId);
        OrderConfirmAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.b(jSONObject);
        }
        requestOrderRender();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1911349520")) {
            ipChange.ipc$dispatch("-1911349520", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
        } else if (i2 == -1 && i == 2000) {
            requestOrderRender();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        String str;
        boolean s;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1335646127")) {
            ipChange.ipc$dispatch("-1335646127", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.itemId = arguments != null ? arguments.getString("itemId") : null;
        Bundle arguments2 = getArguments();
        this.skuId = arguments2 != null ? arguments2.getString(SKU_ID) : null;
        String str2 = this.itemId;
        if (str2 != null) {
            s = C8604o.s(str2);
            if (!s) {
                z = false;
            }
        }
        if (z || (str = this.skuId) == null) {
            return;
        }
        C8604o.s(str);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2040470893")) {
            return (View) ipChange.ipc$dispatch("-2040470893", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        b41.i(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R$layout.bricks_coupon_order_confirm_fragment, viewGroup, false);
        b41.h(inflate, "inflater.inflate(R.layou…agment, container, false)");
        setRootView(inflate);
        initView();
        return getRootView();
    }

    @Override // com.alibaba.pictures.bricks.orderconfirm.OnEventListener
    public void onEvent(@NotNull String str, @Nullable View view, @Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1541417261")) {
            ipChange.ipc$dispatch("-1541417261", new Object[]{this, str, view, obj});
            return;
        }
        b41.i(str, "eventId");
        switch (str.hashCode()) {
            case 756293611:
                if (str.equals(OrderPriceInfoViewHolder.EVENT_BUY_AMOUNT_PLUS)) {
                    Integer num = obj instanceof Integer ? (Integer) obj : null;
                    int intValue = num != null ? num.intValue() : this.buyAmount;
                    this.buyAmount = intValue;
                    this.buyAmount = intValue + 1;
                    requestOrderRender();
                    return;
                }
                return;
            case 1370210417:
                if (str.equals(EVENT_PAY_TYPE)) {
                    JSONObject jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
                    if (jSONObject != null) {
                        Object obj2 = jSONObject.get("payType");
                        this.payType = obj2 != null ? obj2.toString() : null;
                        return;
                    }
                    return;
                }
                return;
            case 1963855769:
                if (str.equals(OrderPriceInfoViewHolder.EVENT_BUY_AMOUNT_INPUT)) {
                    Integer num2 = obj instanceof Integer ? (Integer) obj : null;
                    this.buyAmount = num2 != null ? num2.intValue() : this.buyAmount;
                    requestOrderRender();
                    return;
                }
                return;
            case 1967398975:
                if (str.equals(OrderPriceInfoViewHolder.EVENT_BUY_AMOUNT_MINUS)) {
                    Integer num3 = obj instanceof Integer ? (Integer) obj : null;
                    int intValue2 = num3 != null ? num3.intValue() : this.buyAmount;
                    this.buyAmount = intValue2;
                    this.buyAmount = intValue2 - 1;
                    requestOrderRender();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void setAdapter(@NotNull OrderConfirmAdapter orderConfirmAdapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1110690748")) {
            ipChange.ipc$dispatch("1110690748", new Object[]{this, orderConfirmAdapter});
            return;
        }
        b41.i(orderConfirmAdapter, "<set-?>");
        this.adapter = orderConfirmAdapter;
    }

    public final void setBottomArrow(@NotNull ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-396347556")) {
            ipChange.ipc$dispatch("-396347556", new Object[]{this, imageView});
            return;
        }
        b41.i(imageView, "<set-?>");
        this.bottomArrow = imageView;
    }

    public final void setBottomLayout(@NotNull LinearLayout linearLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2051716718")) {
            ipChange.ipc$dispatch("-2051716718", new Object[]{this, linearLayout});
            return;
        }
        b41.i(linearLayout, "<set-?>");
        this.bottomLayout = linearLayout;
    }

    public final void setBottomPriceTotal(@NotNull DigitTextView digitTextView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "671333242")) {
            ipChange.ipc$dispatch("671333242", new Object[]{this, digitTextView});
            return;
        }
        b41.i(digitTextView, "<set-?>");
        this.bottomPriceTotal = digitTextView;
    }

    public final void setBuyAmount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-845227967")) {
            ipChange.ipc$dispatch("-845227967", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.buyAmount = i;
        }
    }

    public final void setErrContainer(@NotNull ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2074465517")) {
            ipChange.ipc$dispatch("2074465517", new Object[]{this, viewGroup});
            return;
        }
        b41.i(viewGroup, "<set-?>");
        this.errContainer = viewGroup;
    }

    public final void setIrc(@NotNull RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "36067537")) {
            ipChange.ipc$dispatch("36067537", new Object[]{this, recyclerView});
            return;
        }
        b41.i(recyclerView, "<set-?>");
        this.irc = recyclerView;
    }

    public final void setItemId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "293479686")) {
            ipChange.ipc$dispatch("293479686", new Object[]{this, str});
        } else {
            this.itemId = str;
        }
    }

    public final void setPayType(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2009999368")) {
            ipChange.ipc$dispatch("2009999368", new Object[]{this, str});
        } else {
            this.payType = str;
        }
    }

    public final void setPaymentService(@Nullable PaymentService paymentService) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1867303950")) {
            ipChange.ipc$dispatch("1867303950", new Object[]{this, paymentService});
        } else {
            this.paymentService = paymentService;
        }
    }

    public final void setPriceInfo(@Nullable CouponOrderRenderBean.PriceInfo priceInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1069298627")) {
            ipChange.ipc$dispatch("-1069298627", new Object[]{this, priceInfo});
        } else {
            this.priceInfo = priceInfo;
        }
    }

    public final void setRequestData(@Nullable CouponOrderRenderBean.BaseRequestData baseRequestData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "101012974")) {
            ipChange.ipc$dispatch("101012974", new Object[]{this, baseRequestData});
        } else {
            this.requestData = baseRequestData;
        }
    }

    public final void setRootView(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-529811281")) {
            ipChange.ipc$dispatch("-529811281", new Object[]{this, view});
            return;
        }
        b41.i(view, "<set-?>");
        this.rootView = view;
    }

    public final void setSkuId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1889536654")) {
            ipChange.ipc$dispatch("-1889536654", new Object[]{this, str});
        } else {
            this.skuId = str;
        }
    }
}
