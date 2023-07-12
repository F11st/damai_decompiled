package cn.damai.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.base.PermissionsHelper;
import cn.damai.commonbusiness.screenshot.ScreenShotDetector;
import cn.damai.h5container.DamaiWebView;
import cn.damai.h5container.action.ActionWxPay;
import cn.damai.pay.AliPayActivity;
import cn.damai.pay.DamaiPayConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import tb.b23;
import tb.cm2;
import tb.cs;
import tb.m61;
import tb.v20;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class WXPayEntryActivity extends DamaiBaseActivity implements IWXAPIEventHandler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static int FORM_MOVIE = 1;
    public static int FROM_H5 = 2;
    public static int FROM_HN_CREATE_ORDER = 4;
    public static int FROM_ORDER_DETAIL = 3;
    public static int FROM_SCRIPT_MURDER_CREATE_ORDER = 5;
    public static ActionWxPay actionWxPay = null;
    public static Activity context = null;
    public static Activity context2 = null;
    public static DamaiWebView mDamaiWebView = null;
    private static int mFrom = 0;
    public static String orderId = "";
    private IWXAPI api;
    private final String mPayName = "wxpay";
    private boolean mPayResult;

    private void jumpHNOrderDetailtPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-868589552")) {
            ipChange.ipc$dispatch("-868589552", new Object[]{this});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("orderId", orderId);
        bundle.putBoolean("payResult", this.mPayResult);
        bundle.putBoolean(AliPayActivity.FROM_HN_CRETE_ORDER_PAGE, true);
        DMNav.from(this).clearTop().withExtras(bundle).toUri(NavUri.b(cs.h));
    }

    private void jumpOrderListPage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1339807201")) {
            ipChange.ipc$dispatch("-1339807201", new Object[]{this, str});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("from_pay", "wxpay");
        bundle.putString("pageType", str);
        DMNav.from(this).withExtras(bundle).forResult(1000).toUri(NavUri.b(cs.f));
    }

    private void jumpOrderResultPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-123504650")) {
            ipChange.ipc$dispatch("-123504650", new Object[]{this});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("orderId", orderId);
        DMNav.from(this).clearTop().withExtras(bundle).toUri(NavUri.b(cs.e));
    }

    private void jumpPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1555322773")) {
            ipChange.ipc$dispatch("-1555322773", new Object[]{this});
            return;
        }
        Activity activity = context;
        if (activity != null) {
            activity.setResult(1000);
            context.finish();
        }
        Activity activity2 = context2;
        if (activity2 != null) {
            activity2.finish();
            context2 = null;
        }
        int i = mFrom;
        if (i == FROM_ORDER_DETAIL) {
            mFrom = 0;
            Intent intent = new Intent();
            intent.putExtra("payResult", this.mPayResult);
            setResult(1000, intent);
            finish();
        } else if (i == FROM_HN_CREATE_ORDER) {
            mFrom = 0;
            if (!TextUtils.isEmpty(orderId)) {
                if (this.mPayResult) {
                    jumpOrderResultPage();
                } else {
                    jumpHNOrderDetailtPage();
                }
            } else {
                jumpOrderListPage(null);
            }
            finish();
        } else if (i == FORM_MOVIE) {
            mFrom = 0;
            jumpOrderListPage(null);
            finish();
        } else if (i == FROM_SCRIPT_MURDER_CREATE_ORDER) {
            mFrom = 0;
            if (!TextUtils.isEmpty(orderId)) {
                Bundle bundle = new Bundle();
                bundle.putString("orderId", orderId);
                boolean z = this.mPayResult;
                if (z) {
                    DMNav.from(this).clearTop().withExtras(bundle).toUri(NavUri.b(cs.SCRIPT_COUPON_PAY_RESULT));
                } else {
                    bundle.putBoolean("payResult", z);
                    bundle.putBoolean("CouponCreateOrderPage", true);
                    DMNav.from(this).clearTop().withExtras(bundle).toUri(NavUri.b(cs.COUPON_ORDER_DETAIL));
                }
            } else {
                jumpOrderListPage("jubensha");
            }
            finish();
        } else {
            mFrom = 0;
            Bundle bundle2 = new Bundle();
            bundle2.putString("from_pay", "wxpay");
            setResult(1000);
            DMNav.from(this).withExtras(bundle2).toUri(NavUri.b(cs.f));
            finish();
        }
    }

    public static void setWXPayType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "363267162")) {
            ipChange.ipc$dispatch("363267162", new Object[]{Integer.valueOf(i)});
        } else {
            mFrom = i;
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "283869328")) {
            ipChange.ipc$dispatch("283869328", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-914434214") ? ((Integer) ipChange.ipc$dispatch("-914434214", new Object[]{this})).intValue() : R$layout.wx_pay_activity;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-144688287")) {
            ipChange.ipc$dispatch("-144688287", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1180491498")) {
            ipChange.ipc$dispatch("1180491498", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-103809677")) {
            ipChange.ipc$dispatch("-103809677", new Object[]{this});
        } else {
            hideBaseLayout();
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1246072857")) {
            ipChange.ipc$dispatch("-1246072857", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this, v20.a(WXEntryActivity.APP_ID_CRYPT));
        this.api = createWXAPI;
        createWXAPI.handleIntent(getIntent(), this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1878825753")) {
            ipChange.ipc$dispatch("-1878825753", new Object[]{this});
            return;
        }
        super.onDestroy();
        ScreenShotDetector.k().z(false);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1097862288")) {
            ipChange.ipc$dispatch("1097862288", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1992052859")) {
            ipChange.ipc$dispatch("-1992052859", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1040517890")) {
            ipChange.ipc$dispatch("1040517890", new Object[]{this, intent});
            return;
        }
        super.onNewIntent(intent);
        setIntent(intent);
        this.api.handleIntent(intent, this);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "288937552")) {
            ipChange.ipc$dispatch("288937552", new Object[]{this, baseReq});
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "306973020")) {
            ipChange.ipc$dispatch("306973020", new Object[]{this, baseResp});
            return;
        }
        this.mPayResult = false;
        if (baseResp.getType() == 5) {
            int i = baseResp.errCode;
            if (i == 0) {
                if (DamaiPayConstants.PAY_SUCCESS_PUSH_OPEN_STAYUS_SHOW.equals(z20.B(DamaiPayConstants.PAY_SUCCESS_PUSH_OPEN_STAYUS)) || PermissionsHelper.a(getApplicationContext())) {
                    ToastUtil.i(cm2.b(this, R$string.data_string_001));
                }
            } else if (i == -4) {
                ToastUtil.i(cm2.b(this, R$string.data_string_002));
            } else if (i == -1) {
                ToastUtil.i(cm2.b(this, R$string.data_string_003));
            } else if (i == -3) {
                ToastUtil.i(cm2.b(this, R$string.data_string_004));
            } else if (i == -5) {
                ToastUtil.i(cm2.b(this, R$string.data_string_005));
            } else if (i == -2) {
                ToastUtil.i(cm2.b(this, R$string.data_string_006));
            }
            if (mFrom == FROM_H5) {
                DamaiWebView damaiWebView = mDamaiWebView;
                if (damaiWebView != null && damaiWebView.getJSBridge() != null) {
                    mDamaiWebView.getJSBridge().onWxPay(baseResp);
                    mDamaiWebView = null;
                }
                ActionWxPay actionWxPay2 = actionWxPay;
                if (actionWxPay2 != null) {
                    actionWxPay2.onWxPay(baseResp);
                    actionWxPay = null;
                }
                mFrom = 0;
                finish();
                return;
            }
            int i2 = baseResp.errCode;
            if (i2 == 0) {
                this.mPayResult = true;
            } else {
                this.mPayResult = false;
                String str = baseResp.errStr;
                if (i2 != -2) {
                    wxPayFailXFlush(String.valueOf(i2), str, baseResp);
                }
            }
            jumpPage();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "567017212")) {
            ipChange.ipc$dispatch("567017212", new Object[]{this});
            return;
        }
        super.onResume();
        ScreenShotDetector.k().z(true);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1661982798")) {
            return (String) ipChange.ipc$dispatch("1661982798", new Object[]{this});
        }
        return null;
    }

    public void wxPayFailXFlush(String str, String str2, BaseResp baseResp) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-274429488")) {
            ipChange.ipc$dispatch("-274429488", new Object[]{this, str, str2, baseResp});
            return;
        }
        StringBuilder sb = new StringBuilder();
        String e = m61.e(baseResp);
        int i = mFrom;
        String str3 = i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "剧本杀下单" : "麒麟订单确认" : "订单详情" : "FROM_H5" : "FORM_MOVIE";
        sb.append("┋");
        sb.append("orderId: ");
        sb.append(orderId);
        sb.append("┋retMsg: ");
        sb.append("微信支付失败， 完成信息：" + e);
        sb.append("┋customCode: ");
        sb.append("原-4340");
        sb.append("┋fromWhere: " + str3);
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        b23.c("wechatPay", "dmpay", sb2, str, str2);
    }
}
