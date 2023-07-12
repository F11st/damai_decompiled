package cn.damai.trade.coupon.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.pay.AliPayActivity;
import cn.damai.trade.R$color;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.coupon.ui.CouponOrderConfirmActivity;
import cn.damai.wxapi.DamaiWXPayActivity;
import cn.damai.wxapi.WXPayEntryActivity;
import com.alibaba.pictures.bricks.orderconfirm.CouponOrderConfirmFragment;
import com.alibaba.pictures.bricks.orderconfirm.bean.CouponSubmitOrderBean;
import com.alibaba.pictures.bricks.util.PaymentService;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.kg2;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class CouponOrderConfirmActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final C2133a Companion = new C2133a(null);
    public static final int DM_REQUEST_CODE_PAY_SUCCESS = 10;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.coupon.ui.CouponOrderConfirmActivity$a */
    /* loaded from: classes16.dex */
    public static final class C2133a {
        private C2133a() {
        }

        public /* synthetic */ C2133a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.coupon.ui.CouponOrderConfirmActivity$b */
    /* loaded from: classes8.dex */
    public static final class C2134b implements PaymentService {
        private static transient /* synthetic */ IpChange $ipChange;

        C2134b() {
        }

        @Override // com.alibaba.pictures.bricks.util.PaymentService
        public void startPay(@NotNull CouponSubmitOrderBean couponSubmitOrderBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1029769340")) {
                ipChange.ipc$dispatch("1029769340", new Object[]{this, couponSubmitOrderBean});
                return;
            }
            b41.i(couponSubmitOrderBean, "bean");
            CouponOrderConfirmActivity.this.doPay(couponSubmitOrderBean);
        }
    }

    private final void addFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1634376163")) {
            ipChange.ipc$dispatch("-1634376163", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        String stringExtra = intent != null ? intent.getStringExtra("itemId") : null;
        Intent intent2 = getIntent();
        String stringExtra2 = intent2 != null ? intent2.getStringExtra(CouponOrderConfirmFragment.SKU_ID) : null;
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        int i = R$id.coupon_confirm_container;
        CouponOrderConfirmFragment couponOrderConfirmFragment = new CouponOrderConfirmFragment();
        Bundle bundle = new Bundle();
        if (stringExtra != null) {
            bundle.putString("itemId", stringExtra);
        }
        if (stringExtra2 != null) {
            bundle.putString(CouponOrderConfirmFragment.SKU_ID, stringExtra2);
        }
        couponOrderConfirmFragment.setArguments(bundle);
        couponOrderConfirmFragment.setPaymentService(new C2134b());
        wt2 wt2Var = wt2.INSTANCE;
        beginTransaction.add(i, couponOrderConfirmFragment);
        beginTransaction.commit();
    }

    private final void addUtPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-117469217")) {
            ipChange.ipc$dispatch("-117469217", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap();
        Intent intent = getIntent();
        hashMap.put("id", intent != null ? intent.getStringExtra("itemId") : null);
        setDamaiUTKeyBuilder(new C0525a.C0527b().i("scriptkill_confirm").j(hashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doPay(CouponSubmitOrderBean couponSubmitOrderBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1780770838")) {
            ipChange.ipc$dispatch("1780770838", new Object[]{this, couponSubmitOrderBean});
            return;
        }
        String str = couponSubmitOrderBean.payTypeCode;
        if (b41.d(str, "ALIPAY_QMPAY")) {
            Intent intent = new Intent(this, AliPayActivity.class);
            intent.putExtra("alipay_param", couponSubmitOrderBean.payUrl);
            intent.putExtra("orderid", couponSubmitOrderBean.orderId);
            intent.putExtra("from", "SMCreateOrderPage");
            startActivityForResult(intent, 10);
        } else if (b41.d(str, "WECHAT")) {
            WXPayEntryActivity.context = this;
            Intent intent2 = new Intent(this, DamaiWXPayActivity.class);
            intent2.putExtra("orderId", couponSubmitOrderBean.orderId);
            intent2.putExtra("PayParm", couponSubmitOrderBean.payUrl);
            intent2.putExtra("from", "SMCreateOrderPage");
            startActivityForResult(intent2, 10);
        }
    }

    private final void fixStatusBar(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1588066370")) {
            ipChange.ipc$dispatch("1588066370", new Object[]{this, view});
        } else if (Build.VERSION.SDK_INT >= 23) {
            if (view != null) {
                view.getLayoutParams().height = kg2.a(this);
                view.setVisibility(0);
            }
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
        } else {
            kg2.f(this, false, R$color.black);
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m87onCreate$lambda0(CouponOrderConfirmActivity couponOrderConfirmActivity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1883448981")) {
            ipChange.ipc$dispatch("-1883448981", new Object[]{couponOrderConfirmActivity, view});
            return;
        }
        b41.i(couponOrderConfirmActivity, "this$0");
        couponOrderConfirmActivity.onBackPressed();
    }

    private final void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1258433914")) {
            ipChange.ipc$dispatch("-1258433914", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.coupon_title_bar_space_view);
        b41.h(findViewById, "statusBar");
        fixStatusBar(findViewById);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2081347718") ? ((Integer) ipChange.ipc$dispatch("2081347718", new Object[]{this})).intValue() : R$layout.coupon_order_confirm_layout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1796714002")) {
            ipChange.ipc$dispatch("-1796714002", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i == 10) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-816146157")) {
            ipChange.ipc$dispatch("-816146157", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setContentView(getLayoutId());
        setImmersionStyle();
        addFragment();
        addUtPage();
        C0529c.e().K(this);
        findViewById(R$id.coupon_iv_left_icon).setOnClickListener(new View.OnClickListener() { // from class: tb.bp
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CouponOrderConfirmActivity.m87onCreate$lambda0(CouponOrderConfirmActivity.this, view);
            }
        });
    }

    @Override // cn.damai.common.app.base.BaseActivity
    @NotNull
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1497342854") ? (String) ipChange.ipc$dispatch("-1497342854", new Object[]{this}) : "";
    }
}
