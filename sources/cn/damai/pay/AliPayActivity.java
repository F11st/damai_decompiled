package cn.damai.pay;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.base.PermissionsHelper;
import cn.damai.commonbusiness.screenshot.ScreenShotDetector;
import cn.damai.pay.alipay.PayResult;
import com.alipay.sdk.app.PayTask;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.opensdk.ups.request.UpsConstant;
import java.util.Map;
import tb.cs;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class AliPayActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String FROM_HN_CRETE_ORDER_PAGE = "HNCreateOrderPage";
    private static final String FROM_SM_CRETE_ORDER_PAGE = "SMCreateOrderPage";
    private static final int SDK_CHECK_FLAG = 2;
    private static final int SDK_PAY_FLAG = 1;
    public boolean isFromMovie;
    public boolean mPayResult;
    public String param;
    private final String FROM_ORDER_MANAGER_PAGE = "OrderDetailPage";
    private final String mPayName = "zhifubao";
    public String mFromPage = "";
    public String orderId = "";
    public int typewansm = 0;
    private final Handler mHandler = new Handler() { // from class: cn.damai.pay.AliPayActivity.2
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1123483032")) {
                ipChange.ipc$dispatch("1123483032", new Object[]{this, message});
                return;
            }
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                AliPayActivity.this.pay();
                return;
            }
            PayResult payResult = new PayResult((Map) message.obj);
            String resultStatus = payResult.getResultStatus();
            if (TextUtils.equals(resultStatus, "9000")) {
                if (DamaiPayConstants.PAY_SUCCESS_PUSH_OPEN_STAYUS_SHOW.equals(z20.B(DamaiPayConstants.PAY_SUCCESS_PUSH_OPEN_STAYUS)) || PermissionsHelper.a(AliPayActivity.this.getApplicationContext())) {
                    AliPayActivity aliPayActivity = AliPayActivity.this;
                    aliPayActivity.toast(aliPayActivity.getResources().getString(R$string.damai_alipay_payment_success_toast));
                }
                AliPayActivity.this.mPayResult = true;
            } else if (!TextUtils.isEmpty(resultStatus)) {
                if (!resultStatus.equals("6001")) {
                    AliPayActivity aliPayActivity2 = AliPayActivity.this;
                    aliPayActivity2.toast(aliPayActivity2.getResources().getString(R$string.damai_alipay_payment_failed_toast));
                }
                if (resultStatus.equals(UpsConstant.UPS_NETWORK_4G) || resultStatus.equals("6002")) {
                    AliPayActivity.this.aliPayFailXFlush(resultStatus, payResult.getResult(), message.obj);
                }
            } else {
                AliPayActivity aliPayActivity3 = AliPayActivity.this;
                aliPayActivity3.toast(aliPayActivity3.getResources().getString(R$string.damai_alipay_payment_failed_toast));
            }
            AliPayActivity.this.jumpOrderManagerPage();
        }
    };

    private void jumpHNOrderDetailtPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1435054592")) {
            ipChange.ipc$dispatch("-1435054592", new Object[]{this});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("orderId", this.orderId);
        bundle.putBoolean("payResult", this.mPayResult);
        bundle.putBoolean(FROM_HN_CRETE_ORDER_PAGE, true);
        DMNav.from(this).clearTop().withExtras(bundle).toUri(NavUri.b(cs.h));
    }

    private void jumpOrderListPage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "36561455")) {
            ipChange.ipc$dispatch("36561455", new Object[]{this, str});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("from_pay", "zhifubao");
        bundle.putString("pageType", str);
        DMNav.from(this).withExtras(bundle).forResult(1000).toUri(NavUri.b(cs.f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpOrderManagerPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1298493092")) {
            ipChange.ipc$dispatch("-1298493092", new Object[]{this});
            return;
        }
        if (this.isFromMovie) {
            setResult(1000);
        } else if ("OrderDetailPage".equals(this.mFromPage)) {
            Intent intent = new Intent();
            intent.putExtra("payResult", this.mPayResult);
            setResult(1000, intent);
        } else if (FROM_HN_CRETE_ORDER_PAGE.equals(this.mFromPage)) {
            if (!TextUtils.isEmpty(this.orderId)) {
                if (this.mPayResult) {
                    jumpOrderResultPage();
                } else {
                    jumpHNOrderDetailtPage();
                }
            } else {
                jumpOrderListPage(null);
            }
        } else if (FROM_SM_CRETE_ORDER_PAGE.equals(this.mFromPage)) {
            if (!TextUtils.isEmpty(this.orderId)) {
                Bundle bundle = new Bundle();
                bundle.putString("orderId", this.orderId);
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
            Bundle bundle2 = new Bundle();
            bundle2.putString("from_pay", "zhifubao");
            setResult(1000);
            DMNav.from(this).withExtras(bundle2).toUri(NavUri.b(cs.f));
        }
        finish();
    }

    private void jumpOrderResultPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2101391354")) {
            ipChange.ipc$dispatch("-2101391354", new Object[]{this});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("orderId", this.orderId);
        DMNav.from(this).clearTop().withExtras(bundle).toUri(NavUri.b(cs.e));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0037, code lost:
        if (r1.equals("FROM_SM_CRETE_ORDER_PAGE") == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void aliPayFailXFlush(java.lang.String r8, java.lang.String r9, java.lang.Object r10) {
        /*
            r7 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.pay.AliPayActivity.$ipChange
            java.lang.String r1 = "-1123194668"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L1d
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r5] = r7
            r2[r4] = r8
            r2[r3] = r9
            r8 = 3
            r2[r8] = r10
            r0.ipc$dispatch(r1, r2)
            return
        L1d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r7.mFromPage
            r1.hashCode()
            r2 = -1
            int r6 = r1.hashCode()
            switch(r6) {
                case -1071799429: goto L45;
                case 178335822: goto L3a;
                case 1082689736: goto L31;
                default: goto L2f;
            }
        L2f:
            r3 = -1
            goto L4f
        L31:
            java.lang.String r4 = "FROM_SM_CRETE_ORDER_PAGE"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L4f
            goto L2f
        L3a:
            java.lang.String r3 = "OrderDetailPage"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L43
            goto L2f
        L43:
            r3 = 1
            goto L4f
        L45:
            java.lang.String r3 = "HNCreateOrderPage"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L4e
            goto L2f
        L4e:
            r3 = 0
        L4f:
            switch(r3) {
                case 0: goto L5b;
                case 1: goto L58;
                case 2: goto L55;
                default: goto L52;
            }
        L52:
            java.lang.String r1 = ""
            goto L5d
        L55:
            java.lang.String r1 = "剧本杀下单"
            goto L5d
        L58:
            java.lang.String r1 = "订单详情"
            goto L5d
        L5b:
            java.lang.String r1 = "麒麟订单确认"
        L5d:
            java.lang.String r10 = tb.m61.e(r10)
            java.lang.String r2 = "┋"
            r0.append(r2)
            java.lang.String r2 = "orderId: "
            r0.append(r2)
            java.lang.String r2 = r7.orderId
            r0.append(r2)
            java.lang.String r2 = "┋retMsg: "
            r0.append(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "支付包支付失败—SDK错误， 完成信息："
            r2.append(r3)
            r2.append(r10)
            java.lang.String r10 = r2.toString()
            r0.append(r10)
            java.lang.String r10 = "┋customCode: "
            r0.append(r10)
            java.lang.String r10 = "原-4340"
            r0.append(r10)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r2 = "┋fromWhere: "
            r10.append(r2)
            r10.append(r1)
            java.lang.String r10 = r10.toString()
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto Lb3
            java.lang.String r8 = "0"
        Lb3:
            java.lang.String r0 = "alipay"
            java.lang.String r1 = "dmpay"
            tb.b23.c(r0, r1, r10, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.pay.AliPayActivity.aliPayFailXFlush(java.lang.String, java.lang.String, java.lang.Object):void");
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1194515840")) {
            ipChange.ipc$dispatch("-1194515840", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 10001 || i == 10003) {
            onBackPressed();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "112967530") ? ((Integer) ipChange.ipc$dispatch("112967530", new Object[]{this})).intValue() : R$layout.ali_pay_fragment;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1639994705")) {
            ipChange.ipc$dispatch("1639994705", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "671089402")) {
            ipChange.ipc$dispatch("671089402", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1487572835")) {
            ipChange.ipc$dispatch("1487572835", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1028629014")) {
            ipChange.ipc$dispatch("1028629014", new Object[]{this});
        } else {
            jumpOrderManagerPage();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-154847241")) {
            ipChange.ipc$dispatch("-154847241", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        this.mPayResult = false;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.param = extras.getString("alipay_param");
            this.isFromMovie = extras.getBoolean("fromMovie");
            this.typewansm = extras.getInt("wanshenme");
            if (extras.containsKey("orderid")) {
                this.orderId = extras.getString("orderid");
            }
            if (extras.containsKey("from")) {
                this.mFromPage = extras.getString("from", "");
            }
        }
        if (!TextUtils.isEmpty(this.param)) {
            pay();
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "209391863")) {
            ipChange.ipc$dispatch("209391863", new Object[]{this});
            return;
        }
        super.onDestroy();
        ScreenShotDetector.k().z(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2136567572")) {
            ipChange.ipc$dispatch("-2136567572", new Object[]{this});
            return;
        }
        super.onResume();
        ScreenShotDetector.k().z(true);
    }

    public void pay() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-477225974")) {
            ipChange.ipc$dispatch("-477225974", new Object[]{this});
            return;
        }
        final String str = this.param;
        new Thread(new Runnable() { // from class: cn.damai.pay.AliPayActivity.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2034543898")) {
                    ipChange2.ipc$dispatch("2034543898", new Object[]{this});
                    return;
                }
                Map<String, String> payV2 = new PayTask(AliPayActivity.this).payV2(str, true);
                Message message = new Message();
                message.what = 1;
                message.obj = payV2;
                AliPayActivity.this.mHandler.sendMessage(message);
            }
        }).start();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1028482142") ? (String) ipChange.ipc$dispatch("1028482142", new Object[]{this}) : getResources().getString(R$string.damai_alipay_title);
    }

    public void toast(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "7117813")) {
            ipChange.ipc$dispatch("7117813", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
            ToastUtil.a().g(this);
        } else {
            ToastUtil.i(str);
        }
    }
}
