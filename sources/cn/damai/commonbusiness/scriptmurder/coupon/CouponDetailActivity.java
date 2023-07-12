package cn.damai.commonbusiness.scriptmurder.coupon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity;
import cn.damai.commonbusiness.scriptmurder.coupon.CouponDetailActivity;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.im.AliMeUtil;
import cn.damai.login.LoginManager;
import com.alibaba.pictures.bricks.bean.BuyBtnVO;
import com.alibaba.pictures.bricks.bean.CouponInfoBean;
import com.alibaba.pictures.bricks.bean.ShareInfoBean;
import com.alibaba.pictures.bricks.bean.SkuInfoBean;
import com.alibaba.pictures.bricks.orderconfirm.CouponOrderConfirmFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.cs;
import tb.k50;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class CouponDetailActivity extends CommonNavbarActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final C0799a Companion = new C0799a(null);
    @NotNull
    public static final String TAG = "CouponDetailActivity";
    @Nullable
    private CouponInfoBean couponInfoBean;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.scriptmurder.coupon.CouponDetailActivity$a */
    /* loaded from: classes4.dex */
    public static final class C0799a {
        private C0799a() {
        }

        public /* synthetic */ C0799a(k50 k50Var) {
            this();
        }
    }

    private final void createOrder() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "647774632")) {
            ipChange.ipc$dispatch("647774632", new Object[]{this});
        } else if (!LoginManager.k().q()) {
            LoginManager.k().v(this);
        } else {
            Bundle bundle = new Bundle();
            HashMap hashMap = new HashMap();
            CouponInfoBean couponInfoBean = this.couponInfoBean;
            if (couponInfoBean != null) {
                bundle.putString("itemId", couponInfoBean.getItemId());
                hashMap.put("itemId", couponInfoBean.getItemId() + "");
                ArrayList<SkuInfoBean> skuList = couponInfoBean.getSkuList();
                if (skuList != null && skuList.size() > 0) {
                    bundle.putString(CouponOrderConfirmFragment.SKU_ID, skuList.get(0).skuId);
                }
            }
            DMNav.from(this).withExtras(bundle).toUri(NavUri.b(cs.COUPON_ORDER_CONFIRM));
            C0529c.e().x(new C0525a.C0527b().i("scriptkill_coupon").f("bottom").l("buy").g(true).j(hashMap));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initBaseInfo$lambda-7$lambda-5$lambda-4  reason: not valid java name */
    public static final void m17initBaseInfo$lambda7$lambda5$lambda4(CouponDetailActivity couponDetailActivity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1496935607")) {
            ipChange.ipc$dispatch("-1496935607", new Object[]{couponDetailActivity, view});
            return;
        }
        b41.i(couponDetailActivity, "this$0");
        couponDetailActivity.createOrder();
    }

    private final void launchAliMe(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1898086501")) {
            ipChange.ipc$dispatch("-1898086501", new Object[]{this, view});
            return;
        }
        CouponInfoBean couponInfoBean = this.couponInfoBean;
        AliMeUtil.m(this, AliMeUtil.SESSION_COUPON_DETAIL, couponInfoBean != null ? couponInfoBean.getItemId() : null, "");
    }

    @Override // cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity
    public void addFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "420665065")) {
            ipChange.ipc$dispatch("420665065", new Object[]{this});
            return;
        }
        String stringExtra = getIntent().getStringExtra(CouponDetailFragment.COUPON_ID);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        CouponDetailFragment couponDetailFragment = new CouponDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(CouponDetailFragment.COUPON_ID, stringExtra);
        couponDetailFragment.setArguments(bundle);
        beginTransaction.add(R$id.container, couponDetailFragment);
        beginTransaction.commit();
    }

    @Override // cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity
    public void addUtPage() {
        String stringExtra;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1518681173")) {
            ipChange.ipc$dispatch("-1518681173", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap();
        Intent intent = getIntent();
        if (intent != null && (stringExtra = intent.getStringExtra(CouponDetailFragment.COUPON_ID)) != null) {
            hashMap.put("coupon_id", stringExtra);
        }
        setDamaiUTKeyBuilder(new C0525a.C0527b().i("scriptkill_coupon").a(z20.d()).j(hashMap));
    }

    @Nullable
    public final CouponInfoBean getCouponInfoBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1175488846") ? (CouponInfoBean) ipChange.ipc$dispatch("-1175488846", new Object[]{this}) : this.couponInfoBean;
    }

    @Override // cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity, cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-158578350") ? ((Integer) ipChange.ipc$dispatch("-158578350", new Object[]{this})).intValue() : R$layout.activity_script_murder_coupon_detail;
    }

    @Override // cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity
    public void initBaseInfo(@NotNull Object obj) {
        BuyBtnVO buyBtnVO;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1928664029")) {
            ipChange.ipc$dispatch("1928664029", new Object[]{this, obj});
            return;
        }
        b41.i(obj, "bean");
        HashMap hashMap = obj instanceof HashMap ? (HashMap) obj : null;
        Object obj2 = hashMap != null ? hashMap.get("value") : null;
        CouponInfoBean couponInfoBean = obj2 instanceof CouponInfoBean ? (CouponInfoBean) obj2 : null;
        if (couponInfoBean != null) {
            this.couponInfoBean = couponInfoBean;
        }
        CouponInfoBean couponInfoBean2 = this.couponInfoBean;
        if (couponInfoBean2 == null || (buyBtnVO = couponInfoBean2.getBuyBtnVO()) == null) {
            return;
        }
        if ("1".equals(buyBtnVO.getBtnStatus())) {
            View findViewById = findViewById(R$id.coupon_bottom_buy_btn_tv);
            if (findViewById != null) {
                b41.h(findViewById, "findViewById<TextView>(R…coupon_bottom_buy_btn_tv)");
                TextView textView = (TextView) findViewById;
                textView.setText(buyBtnVO.getBtnText());
                textView.setClickable(true);
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: tb.xo
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CouponDetailActivity.m17initBaseInfo$lambda7$lambda5$lambda4(CouponDetailActivity.this, view);
                    }
                });
                return;
            }
            return;
        }
        View findViewById2 = findViewById(R$id.coupon_bottom_buy_btn_tv);
        if (findViewById2 != null) {
            b41.h(findViewById2, "findViewById<TextView>(R…coupon_bottom_buy_btn_tv)");
            TextView textView2 = (TextView) findViewById2;
            textView2.setText(buyBtnVO.getBtnText());
            textView2.setBackground(findViewById2.getResources().getDrawable(R$drawable.coupon_buy_btn_unusable_bg));
            textView2.setClickable(false);
        }
    }

    @Override // cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity
    public void onShareClick() {
        ShareInfoBean shareDO;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2147411912")) {
            ipChange.ipc$dispatch("2147411912", new Object[]{this});
            return;
        }
        CouponInfoBean couponInfoBean = this.couponInfoBean;
        if (couponInfoBean == null || (shareDO = couponInfoBean.getShareDO()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("title", shareDO.getShareTitle());
        bundle.putString("message", shareDO.getShareSubTitle());
        bundle.putString("imageurl", shareDO.getShareImage());
        bundle.putString("producturl", shareDO.getShareUrl());
        ShareManager.E().T(this, bundle, getWindow().getDecorView());
        ShareManager.E().l0();
    }

    public final void setCouponInfoBean(@Nullable CouponInfoBean couponInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1548291506")) {
            ipChange.ipc$dispatch("-1548291506", new Object[]{this, couponInfoBean});
        } else {
            this.couponInfoBean = couponInfoBean;
        }
    }
}
