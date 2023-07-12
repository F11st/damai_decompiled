package cn.damai.trade.newtradeorder.ui.orderdetail.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.trade.R$color;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import com.alibaba.pictures.bricks.orderresult.CouponPayResultFragment;
import com.alibaba.pictures.bricks.orderresult.couponpayresult.PayResultUtListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.kg2;
import tb.wt2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class CouponPayResultActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final C2145a Companion = new C2145a(null);
    public static final int DM_REQUEST_CODE_PAY_SUCCESS = 100001;
    @Nullable
    private final String mOrderId;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.orderdetail.ui.activity.CouponPayResultActivity$a */
    /* loaded from: classes16.dex */
    public static final class C2145a {
        private C2145a() {
        }

        public /* synthetic */ C2145a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.orderdetail.ui.activity.CouponPayResultActivity$b */
    /* loaded from: classes8.dex */
    public static final class C2146b implements PayResultUtListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2146b() {
        }

        @Override // com.alibaba.pictures.bricks.orderresult.couponpayresult.PayResultUtListener
        public void updateUTParam(@NotNull String str, @NotNull String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1795900741")) {
                ipChange.ipc$dispatch("1795900741", new Object[]{this, str, str2});
                return;
            }
            b41.i(str, "isPaid");
            b41.i(str2, SocialConstants.PARAM_APP_DESC);
            CouponPayResultActivity.this.addUtPage(str, str2);
        }
    }

    private final void addFragment() {
        Bundle extras;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1568807821")) {
            ipChange.ipc$dispatch("-1568807821", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        String string = (intent == null || (extras = intent.getExtras()) == null) ? null : extras.getString("orderId");
        C2146b c2146b = new C2146b();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        int i = R$id.coupon_result_container;
        CouponPayResultFragment couponPayResultFragment = new CouponPayResultFragment();
        Bundle bundle = new Bundle();
        if (string != null) {
            bundle.putString("orderId", string);
            bundle.putString("cityId", z20.c());
        }
        couponPayResultFragment.setArguments(bundle);
        couponPayResultFragment.setUtListener(c2146b);
        wt2 wt2Var = wt2.INSTANCE;
        beginTransaction.add(i, couponPayResultFragment);
        beginTransaction.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addUtPage(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "424798793")) {
            ipChange.ipc$dispatch("424798793", new Object[]{this, str, str2});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("orderid", this.mOrderId);
        hashMap.put("titlelable", str);
        hashMap.put("contentlabel", str2);
        setDamaiUTKeyBuilder(new C0525a.C0527b().i("scriptkill_payresult").j(hashMap));
    }

    private final void fixStatusBar(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-490213480")) {
            ipChange.ipc$dispatch("-490213480", new Object[]{this, view});
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

    private final void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1097316444")) {
            ipChange.ipc$dispatch("1097316444", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.coupon_title_bar_space_view);
        b41.h(findViewById, "statusBar");
        fixStatusBar(findViewById);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2146916060") ? ((Integer) ipChange.ipc$dispatch("2146916060", new Object[]{this})).intValue() : R$layout.coupon_pay_result_layout;
    }

    @Nullable
    public final String getMOrderId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1703063218") ? (String) ipChange.ipc$dispatch("-1703063218", new Object[]{this}) : this.mOrderId;
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1443046664")) {
            ipChange.ipc$dispatch("1443046664", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1214796951")) {
            ipChange.ipc$dispatch("-1214796951", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setContentView(getLayoutId());
        setImmersionStyle();
        addFragment();
        C0529c.e().K(this);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    @NotNull
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-492172208") ? (String) ipChange.ipc$dispatch("-492172208", new Object[]{this}) : "";
    }
}
