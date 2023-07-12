package cn.damai.mine.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.mine.bean.CouponData;
import cn.damai.mine.bean.CouponUnbindData;
import cn.damai.mine.net.CouponUnbindRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.apache.commons.lang3.StringUtils;
import tb.cm2;
import tb.kg2;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class CouponDetailActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView btn_header_right;
    private TextView btn_unbind;
    private LinearLayout ll_unbind;
    private CouponData.Coupon mCoupon;
    private TextView tv_shiyong_fanwei;
    private TextView tv_youhuiquan_hm;
    private TextView tv_youhuiquan_name;
    private TextView tv_youhuiquan_sm;
    private TextView tv_youhuiquan_yxq;
    private boolean unbinding = false;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "535338432")) {
                ipChange.ipc$dispatch("535338432", new Object[]{this, view});
                return;
            }
            CouponDetailActivity.this.setResult(-1);
            CouponDetailActivity.this.finish();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* loaded from: classes15.dex */
        public class a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "459124257")) {
                    ipChange.ipc$dispatch("459124257", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                } else {
                    CouponDetailActivity.this.requestUnbind(TextUtils.isEmpty(CouponDetailActivity.this.mCoupon.oldDmCouponId) ? CouponDetailActivity.this.mCoupon.id : CouponDetailActivity.this.mCoupon.oldDmCouponId);
                }
            }
        }

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1648338495")) {
                ipChange.ipc$dispatch("-1648338495", new Object[]{this, view});
            } else if (CouponDetailActivity.this.mCoupon == null) {
            } else {
                String str = !TextUtils.isEmpty(CouponDetailActivity.this.mCoupon.cancelConfirmMsg) ? CouponDetailActivity.this.mCoupon.cancelConfirmMsg : "优惠券转成券码后，该券将从「未使用」列表消失，券码可重新兑换为优惠券。";
                DMDialog dMDialog = new DMDialog(CouponDetailActivity.this);
                dMDialog.q(str);
                dMDialog.n("确定", new a());
                dMDialog.i("取消", null);
                dMDialog.show();
            }
        }
    }

    private void setEventListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1582308886")) {
            ipChange.ipc$dispatch("1582308886", new Object[]{this});
            return;
        }
        findViewById(R$id.iv_left_icon).setOnClickListener(new a());
        this.btn_unbind.setOnClickListener(new b());
    }

    private void setExtraData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "149759914")) {
            ipChange.ipc$dispatch("149759914", new Object[]{this});
            return;
        }
        CouponData.Coupon coupon = this.mCoupon;
        if (coupon == null) {
            return;
        }
        this.tv_youhuiquan_name.setText(cm2.c(this, R$string.damai_coupondeail_coupon_name, coupon.name));
        this.tv_youhuiquan_sm.setText(cm2.c(this, R$string.damai_coupondeail_coupon_description, this.mCoupon.decreaseMoneyNum));
        CouponData.Coupon coupon2 = this.mCoupon;
        String str = coupon2.oldDmCouponId;
        String str2 = coupon2.id;
        if (TextUtils.isEmpty(str)) {
            str = !TextUtils.isEmpty(str2) ? str2 : "";
        }
        if (!TextUtils.isEmpty(str)) {
            this.tv_youhuiquan_hm.setText(cm2.c(this, R$string.damai_coupondeail_coupon_number, str));
        } else {
            this.tv_youhuiquan_hm.setText(cm2.c(this, R$string.damai_coupondeail_coupon_number, ""));
        }
        String str3 = this.mCoupon.effectiveTimeText;
        if (!TextUtils.isEmpty(str3)) {
            this.tv_youhuiquan_yxq.setText(cm2.c(this, R$string.damai_coupondeail_coupon_validity_period, str3));
        } else {
            this.tv_youhuiquan_yxq.setText("");
        }
        String str4 = this.mCoupon.desc;
        if (!TextUtils.isEmpty(str4)) {
            str4 = str4.replaceAll(" ", "");
            if (!TextUtils.isEmpty(str4)) {
                str4 = str4.replaceAll(";", ";\n");
                if (str4.lastIndexOf(StringUtils.LF) == str4.length() - 1) {
                    str4 = str4.substring(0, str4.length() - 1);
                }
            }
        }
        this.tv_shiyong_fanwei.setText(str4);
        CouponData.Coupon coupon3 = this.mCoupon;
        if (coupon3.cancelable && !TextUtils.isEmpty(coupon3.cancelBtnText)) {
            this.btn_unbind.setText(this.mCoupon.cancelBtnText);
            this.ll_unbind.setVisibility(0);
            return;
        }
        this.ll_unbind.setVisibility(8);
    }

    private void setTitleImmersiveStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1517618154")) {
            ipChange.ipc$dispatch("-1517618154", new Object[]{this});
            return;
        }
        int a2 = kg2.a(this);
        View findViewById = findViewById(R$id.title_bar_space);
        if (findViewById != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                findViewById.setLayoutParams(new RelativeLayout.LayoutParams(-1, a2));
                kg2.f(this, true, R$color.black);
                kg2.d(true, this);
                return;
            }
            findViewById.setLayoutParams(new RelativeLayout.LayoutParams(-1, 0));
            kg2.f(this, false, R$color.black);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "493254592") ? ((Integer) ipChange.ipc$dispatch("493254592", new Object[]{this})).intValue() : R$layout.coupondeail_activity;
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "979674829")) {
            ipChange.ipc$dispatch("979674829", new Object[]{this});
            return;
        }
        hideBaseLayout();
        this.mCoupon = (CouponData.Coupon) getIntent().getSerializableExtra("coupon");
        this.tv_youhuiquan_name = (TextView) findViewById(R$id.tv_youhuiquan_name);
        this.tv_youhuiquan_sm = (TextView) findViewById(R$id.tv_youhuiquan_sm);
        this.tv_youhuiquan_hm = (TextView) findViewById(R$id.tv_youhuiquan_hm);
        this.tv_youhuiquan_yxq = (TextView) findViewById(R$id.tv_youhuiquan_yxq);
        this.tv_shiyong_fanwei = (TextView) findViewById(R$id.tv_shiyong_fanwei);
        this.btn_header_right = (TextView) findViewById(R$id.btn_header_right);
        this.btn_unbind = (TextView) findViewById(R$id.tv_unbind);
        this.ll_unbind = (LinearLayout) findViewById(R$id.ll_unbind);
        this.btn_header_right.setVisibility(8);
        this.ll_unbind.setVisibility(8);
        setTitleImmersiveStyle();
        setEventListener();
        setExtraData();
    }

    public void requestUnbind(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "408366957")) {
            ipChange.ipc$dispatch("408366957", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str) || this.unbinding) {
        } else {
            this.unbinding = true;
            onLoadStart();
            CouponUnbindRequest couponUnbindRequest = new CouponUnbindRequest();
            couponUnbindRequest.couponId = str;
            couponUnbindRequest.request(new DMMtopRequestListener<CouponUnbindData>(CouponUnbindData.class) { // from class: cn.damai.mine.activity.CouponDetailActivity.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str2, String str3) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-149794264")) {
                        ipChange2.ipc$dispatch("-149794264", new Object[]{this, str2, str3});
                        return;
                    }
                    CouponDetailActivity.this.unbinding = false;
                    CouponDetailActivity.this.onLoadFinish();
                    if (str3 != null) {
                        ToastUtil.i(str3);
                    } else {
                        ToastUtil.i("解绑失败，请稍后重试");
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(CouponUnbindData couponUnbindData) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-480411576")) {
                        ipChange2.ipc$dispatch("-480411576", new Object[]{this, couponUnbindData});
                        return;
                    }
                    CouponDetailActivity.this.unbinding = false;
                    ToastUtil.i("已解绑");
                    Intent intent = new Intent();
                    intent.putExtra("unbind", true);
                    CouponDetailActivity.this.setResult(-1, intent);
                    CouponDetailActivity.this.finish();
                }
            });
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1183567412")) {
            return (String) ipChange.ipc$dispatch("1183567412", new Object[]{this});
        }
        return null;
    }
}
