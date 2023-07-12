package cn.damai.trade.coupon.ui.orderdeatile;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.common.DamaiConstants;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.trade.R$color;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$string;
import cn.damai.trade.coupon.ui.orderdeatile.OrderDetailActivity;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailPayInfo;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.OrderDetailCancelRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.api.OrderDetailConstantsApi;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.fragment.OrderDetailPayFragment;
import com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment;
import com.alibaba.pictures.bricks.coupon.order.OrderDetailListener;
import com.alibaba.pictures.bricks.coupon.order.bean.OrderDetail;
import com.alibaba.pictures.bricks.coupon.order.bean.StatusInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ap1;
import tb.b41;
import tb.cm2;
import tb.cs;
import tb.k50;
import tb.kg2;
import tb.pp2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class OrderDetailActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final C2135a Companion = new C2135a(null);
    @NotNull
    private static final String ERROR_CODE_ORDER_HAS_PAY = "MAPIE98087";
    @NotNull
    private static final String ERROR_CODE_ORDER_NO_CANCEL = "MAPIE98096";
    @Nullable
    private OrderDetailPayFragment dialogFragment;
    @Nullable
    private OrderDetailFragment fragment;
    @Nullable
    private String mOrderId;
    private final int FROM_COUPON_CREATE_ORDER = 1;
    private final int FROM_PUSH = 2;
    private final int BACK_FROM_PAGE = 3;
    private final int FROM_ORDER_LIST;
    private int mFromPage = this.FROM_ORDER_LIST;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.coupon.ui.orderdeatile.OrderDetailActivity$a */
    /* loaded from: classes16.dex */
    public static final class C2135a {
        private C2135a() {
        }

        public /* synthetic */ C2135a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.coupon.ui.orderdeatile.OrderDetailActivity$b */
    /* loaded from: classes8.dex */
    public static final class C2136b implements OrderDetailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2136b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(OrderDetailActivity orderDetailActivity, DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "958299782")) {
                ipChange.ipc$dispatch("958299782", new Object[]{orderDetailActivity, dialogInterface, Integer.valueOf(i)});
                return;
            }
            b41.i(orderDetailActivity, "this$0");
            dialogInterface.dismiss();
            orderDetailActivity.requestCancelOrder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-256903890")) {
                ipChange.ipc$dispatch("-256903890", new Object[]{dialogInterface, Integer.valueOf(i)});
            } else {
                dialogInterface.dismiss();
            }
        }

        @Override // com.alibaba.pictures.bricks.coupon.order.OrderDetailListener
        public void cancelOrder(@NotNull OrderDetail orderDetail) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1452481632")) {
                ipChange.ipc$dispatch("-1452481632", new Object[]{this, orderDetail});
                return;
            }
            b41.i(orderDetail, "detail");
            DMDialog dMDialog = new DMDialog(OrderDetailActivity.this);
            dMDialog.v("取消订单");
            dMDialog.q("订单取消后将自动关闭，确定取消?");
            dMDialog.i("取消", null);
            final OrderDetailActivity orderDetailActivity = OrderDetailActivity.this;
            dMDialog.n("确定", new DialogInterface.OnClickListener() { // from class: tb.xn1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    OrderDetailActivity.C2136b.c(OrderDetailActivity.this, dialogInterface, i);
                }
            });
            dMDialog.show();
        }

        @Override // com.alibaba.pictures.bricks.coupon.order.OrderDetailListener
        public void gotoPay(@NotNull OrderDetail orderDetail) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1694097969")) {
                ipChange.ipc$dispatch("1694097969", new Object[]{this, orderDetail});
                return;
            }
            b41.i(orderDetail, "detail");
            ArrayList<OrderDetailPayInfo> paymentInfoList = orderDetail.getPaymentInfoList();
            String str = null;
            if (!(paymentInfoList == null || paymentInfoList.isEmpty())) {
                Intent intent = new Intent();
                b41.g(paymentInfoList, "null cannot be cast to non-null type java.util.ArrayList<out android.os.Parcelable?>{ kotlin.collections.TypeAliasesKt.ArrayList<out android.os.Parcelable?> }");
                intent.putExtra("payList", paymentInfoList);
                intent.putExtra("isHouNiaoOrder", false);
                StatusInfo statusInfo = orderDetail.getStatusInfo();
                intent.putExtra("amount", statusInfo != null ? statusInfo.getTotalAmount() : null);
                intent.putExtra("orderId", OrderDetailActivity.this.mOrderId);
                intent.putExtra("projectId", orderDetail.getItemId());
                intent.putExtra("isSeat", false);
                intent.putExtra("isCoupon", true);
                if (OrderDetailActivity.this.dialogFragment == null) {
                    OrderDetailActivity.this.dialogFragment = new OrderDetailPayFragment();
                    OrderDetailPayFragment orderDetailPayFragment = OrderDetailActivity.this.dialogFragment;
                    if (orderDetailPayFragment != null) {
                        orderDetailPayFragment.l(OrderDetailActivity.this, intent);
                    }
                }
                try {
                    OrderDetailPayFragment orderDetailPayFragment2 = OrderDetailActivity.this.dialogFragment;
                    Boolean valueOf = orderDetailPayFragment2 != null ? Boolean.valueOf(orderDetailPayFragment2.isAdded()) : null;
                    b41.f(valueOf);
                    if (valueOf.booleanValue()) {
                        return;
                    }
                    OrderDetailPayFragment orderDetailPayFragment3 = OrderDetailActivity.this.dialogFragment;
                    if (orderDetailPayFragment3 != null) {
                        orderDetailPayFragment3.q(System.currentTimeMillis());
                    }
                    OrderDetailPayFragment orderDetailPayFragment4 = OrderDetailActivity.this.dialogFragment;
                    if (orderDetailPayFragment4 != null) {
                        orderDetailPayFragment4.a(OrderDetailActivity.this.getFragmentManager());
                        return;
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            StatusInfo statusInfo2 = orderDetail.getStatusInfo();
            if (TextUtils.isEmpty(statusInfo2 != null ? statusInfo2.getDialogTips() : null)) {
                str = "当前订单不支持此渠道支付，请前往下单渠道完成支付";
            } else {
                StatusInfo statusInfo3 = orderDetail.getStatusInfo();
                if (statusInfo3 != null) {
                    str = statusInfo3.getDialogTips();
                }
            }
            DMDialog dMDialog = new DMDialog(OrderDetailActivity.this);
            dMDialog.q(str);
            dMDialog.n("我知道了", new DialogInterface.OnClickListener() { // from class: tb.yn1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    OrderDetailActivity.C2136b.d(dialogInterface, i);
                }
            });
            dMDialog.show();
        }
    }

    private final void addFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-460027931")) {
            ipChange.ipc$dispatch("-460027931", new Object[]{this});
            return;
        }
        OrderDetailFragment orderDetailFragment = new OrderDetailFragment();
        orderDetailFragment.setListener(new C2136b());
        Bundle bundle = new Bundle();
        String str = this.mOrderId;
        if (str != null) {
            bundle.putString("orderId", str);
        }
        orderDetailFragment.setArguments(bundle);
        this.fragment = orderDetailFragment;
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add(R$id.coupon_confirm_container, orderDetailFragment);
        beginTransaction.commit();
    }

    private final void addUtPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-429096025")) {
            ipChange.ipc$dispatch("-429096025", new Object[]{this});
            return;
        }
        setDamaiUTKeyBuilder(new C0525a.C0527b().i(pp2.PROJECT_SCRIPTKILL_ORDRR_DETAILS_PAGE));
        C0529c.e().K(this);
    }

    private final void backOrderListPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1244629438")) {
            ipChange.ipc$dispatch("-1244629438", new Object[]{this});
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("refresh", true);
        setResult(-1, intent);
        finish();
    }

    private final void handleParams() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1906937574")) {
            ipChange.ipc$dispatch("1906937574", new Object[]{this});
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey(DamaiConstants.PUSH_MSG_SUMMARY)) {
                this.mOrderId = extras.getString(DamaiConstants.PUSH_MSG_SUMMARY);
                this.mFromPage = this.FROM_PUSH;
            } else if (extras.containsKey("backPage")) {
                this.mOrderId = extras.getString("orderId", "");
                this.mFromPage = this.BACK_FROM_PAGE;
            } else {
                this.mOrderId = extras.getString("orderId", "");
                this.mFromPage = this.FROM_ORDER_LIST;
                if (extras.containsKey("CouponCreateOrderPage")) {
                    if (b41.d(extras.getString("CouponCreateOrderPage", "false"), "true")) {
                        this.mFromPage = this.FROM_COUPON_CREATE_ORDER;
                    } else if (extras.getBoolean("CouponCreateOrderPage", false)) {
                        this.mFromPage = this.FROM_COUPON_CREATE_ORDER;
                    }
                }
                if (extras.containsKey("payResult")) {
                    OrderDetailFragment.mPayResultState = extras.getBoolean("payResult", false);
                    OrderDetailFragment.mPayResultOrderId = this.mOrderId;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m88initView$lambda0(OrderDetailActivity orderDetailActivity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "659140485")) {
            ipChange.ipc$dispatch("659140485", new Object[]{orderDetailActivity, view});
            return;
        }
        b41.i(orderDetailActivity, "this$0");
        orderDetailActivity.onBackPressed();
    }

    private final void orderDetailCancelXflush(String str, String str2) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-255675131")) {
            ipChange.ipc$dispatch("-255675131", new Object[]{this, str, str2});
            return;
        }
        if ((TextUtils.isEmpty(str) || !b41.d("FCADE0002", str)) ? true : true) {
            ap1.b(OrderDetailConstantsApi.API_ORDER_DETAIL_CANCEL_ORDER, str, str2, this.mOrderId, "订单取消按钮接口失败");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestCancelOrder() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1852669137")) {
            ipChange.ipc$dispatch("-1852669137", new Object[]{this});
            return;
        }
        OrderDetailCancelRequest orderDetailCancelRequest = new OrderDetailCancelRequest();
        orderDetailCancelRequest.orderId = this.mOrderId;
        orderDetailCancelRequest.request(new DMMtopRequestListener<String>(String.class) { // from class: cn.damai.trade.coupon.ui.orderdeatile.OrderDetailActivity$requestCancelOrder$listener$1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(@Nullable String str, @Nullable String str2) {
                OrderDetailFragment orderDetailFragment;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1399149049")) {
                    ipChange2.ipc$dispatch("-1399149049", new Object[]{this, str, str2});
                    return;
                }
                orderDetailFragment = OrderDetailActivity.this.fragment;
                if (orderDetailFragment != null) {
                    orderDetailFragment.stopLoading();
                }
                OrderDetailActivity.this.stopProgressDialog();
                if (str == null || str2 == null) {
                    return;
                }
                OrderDetailActivity.this.returnOrderDetailCancelFail(str, str2);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(@Nullable String str) {
                OrderDetailFragment orderDetailFragment;
                OrderDetailFragment orderDetailFragment2;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-279358336")) {
                    ipChange2.ipc$dispatch("-279358336", new Object[]{this, str});
                    return;
                }
                orderDetailFragment = OrderDetailActivity.this.fragment;
                if (orderDetailFragment != null) {
                    orderDetailFragment.stopLoading();
                }
                OrderDetailActivity.this.stopProgressDialog();
                orderDetailFragment2 = OrderDetailActivity.this.fragment;
                if (orderDetailFragment2 != null) {
                    orderDetailFragment2.refresh();
                }
            }
        });
    }

    private final void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1094614606")) {
            ipChange.ipc$dispatch("1094614606", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.coupon_title_bar_space_view);
        if (findViewById == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            findViewById.getLayoutParams().height = kg2.a(this);
            findViewById.setVisibility(0);
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
            return;
        }
        kg2.f(this, false, R$color.black);
        findViewById.setVisibility(8);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1039271346") ? ((Integer) ipChange.ipc$dispatch("-1039271346", new Object[]{this})).intValue() : R$layout.coupon_order_detail_layout;
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-456597761")) {
            ipChange.ipc$dispatch("-456597761", new Object[]{this});
            return;
        }
        super.initView();
        setImmersionStyle();
        View findViewById = findViewById(R$id.coupon_iv_left_icon);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: tb.wn1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OrderDetailActivity.m88initView$lambda0(OrderDetailActivity.this, view);
                }
            });
        }
        handleParams();
        addFragment();
        addUtPage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        boolean booleanExtra;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-319359194")) {
            ipChange.ipc$dispatch("-319359194", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i == 2000 && intent != null && (booleanExtra = intent.getBooleanExtra("payResult", false))) {
            OrderDetailFragment.mPayResultState = booleanExtra;
            OrderDetailFragment.mPayResultOrderId = this.mOrderId;
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1828631546")) {
            ipChange.ipc$dispatch("1828631546", new Object[]{this});
            return;
        }
        int i = this.mFromPage;
        if (i == this.FROM_PUSH) {
            DMNav.from(this).toUri(NavUri.b(cs.n));
            finish();
        } else if (i == this.FROM_COUPON_CREATE_ORDER) {
            Bundle bundle = new Bundle();
            bundle.putString("pageType", "jubensha");
            DMNav.from(this).withExtras(bundle).toUri(NavUri.b(cs.f));
            finish();
        } else if (i == this.BACK_FROM_PAGE) {
            finish();
        } else if (i == this.FROM_ORDER_LIST) {
            backOrderListPage();
        } else {
            backOrderListPage();
        }
    }

    public final void returnOrderDetailCancelFail(@NotNull String str, @NotNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1631592899")) {
            ipChange.ipc$dispatch("1631592899", new Object[]{this, str, str2});
            return;
        }
        b41.i(str, "errorCode");
        b41.i(str2, "errorMsg");
        orderDetailCancelXflush(str, str2);
        if (b41.d(ERROR_CODE_ORDER_NO_CANCEL, str)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "该订单状态已经生效，无法操作取消~";
            }
            ToastUtil.i(str2);
            OrderDetailFragment orderDetailFragment = this.fragment;
            if (orderDetailFragment != null) {
                orderDetailFragment.refresh();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = cm2.b(this, R$string.damai_base_net_toast);
            b41.h(str2, "getTextFormat(this@Order…ing.damai_base_net_toast)");
        }
        ToastUtil.i(str2);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    @NotNull
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2124202050")) {
            return (String) ipChange.ipc$dispatch("2124202050", new Object[]{this});
        }
        this.bese_head_view.setVisibility(8);
        return "";
    }
}
