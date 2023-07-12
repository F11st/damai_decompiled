package cn.damai.h5container;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.webkit.JavascriptInterface;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.pay.alipay.Result2;
import cn.damai.weex.WeexActivity;
import cn.damai.wxapi.WXEntryActivity;
import cn.damai.wxapi.WXPayEntryActivity;
import com.alipay.sdk.app.PayTask;
import com.alipay.sdk.m.u.C4316l;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import org.json.JSONObject;
import tb.cm2;
import tb.mu0;
import tb.tr2;
import tb.v20;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class JSBridge {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int SDK_PAY_FLAG = 1;
    private String mAliPayJSCallBack;
    private Context mContext;
    private Handler mHandler = new Handler() { // from class: cn.damai.h5container.JSBridge.3
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2133673718")) {
                ipChange.ipc$dispatch("-2133673718", new Object[]{this, message});
            } else if (message.what != 1) {
            } else {
                Result2 result2 = new Result2((String) message.obj);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(C4316l.a, result2.resultStatus);
                    jSONObject.put("result", result2.result);
                    jSONObject.put(C4316l.b, result2.memo);
                    JSBridge jSBridge = JSBridge.this;
                    jSBridge.onAlipay(jSBridge.mAliPayJSCallBack, jSONObject.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
    private DamaiWebView mWebView;
    private String mWxPayJSCallBack;

    public JSBridge(Context context, DamaiWebView damaiWebView) {
        this.mContext = context;
        this.mWebView = damaiWebView;
    }

    private boolean canWxPay(IWXAPI iwxapi) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1369460114")) {
            return ((Boolean) ipChange.ipc$dispatch("1369460114", new Object[]{this, iwxapi})).booleanValue();
        }
        boolean isWXAppInstalled = iwxapi.isWXAppInstalled();
        boolean z = iwxapi.getWXAppSupportAPI() >= 570425345;
        if (isWXAppInstalled && z) {
            return true;
        }
        int i = !isWXAppInstalled ? -1000 : !z ? -1001 : 0;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("errCode", i);
            jSONObject.put("errStr", "");
            jSONObject.put("transaction", "");
            jSONObject.put("openId", "");
            onWxPay(this.mWxPayJSCallBack, jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ToastUtil a = ToastUtil.a();
        Context context = this.mContext;
        a.j(context, cm2.b(context, R$string.pay_wx_not_support_toast));
        return false;
    }

    private void doAliPay(String str, final String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1744357326")) {
            ipChange.ipc$dispatch("1744357326", new Object[]{this, str, str2, str3});
        } else {
            new Thread(new Runnable() { // from class: cn.damai.h5container.JSBridge.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "812096524")) {
                        ipChange2.ipc$dispatch("812096524", new Object[]{this});
                        return;
                    }
                    String pay = new PayTask((Activity) JSBridge.this.mContext).pay(str2, true);
                    Message message = new Message();
                    message.what = 1;
                    message.obj = pay;
                    JSBridge.this.mHandler.sendMessage(message);
                }
            }).start();
        }
    }

    private void doWxPay(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2097564899")) {
            ipChange.ipc$dispatch("-2097564899", new Object[]{this, str, str2});
            return;
        }
        String a = v20.a(WXEntryActivity.APP_ID_CRYPT);
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this.mContext, a);
        createWXAPI.registerApp(a);
        if (canWxPay(createWXAPI)) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                PayReq payReq = new PayReq();
                payReq.appId = jSONObject.getString("appid");
                payReq.partnerId = jSONObject.getString("partnerid");
                payReq.prepayId = jSONObject.getString("prepayid");
                payReq.nonceStr = jSONObject.getString("noncestr");
                payReq.timeStamp = jSONObject.getString("timestamp");
                payReq.packageValue = jSONObject.getString("package");
                payReq.sign = jSONObject.getString("sign");
                payReq.extData = str;
                createWXAPI.sendReq(payReq);
                WXPayEntryActivity.setWXPayType(WXPayEntryActivity.FROM_H5);
                WXPayEntryActivity.mDamaiWebView = this.mWebView;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAlipay(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1075876368")) {
            ipChange.ipc$dispatch("1075876368", new Object[]{this, str, str2});
            return;
        }
        try {
            String format = String.format("javascript:%s(%s);", str, str2);
            Log.d("JsCallBack", format);
            this.mWebView.loadUrl(format);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void alipay(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1486654683")) {
            ipChange.ipc$dispatch("-1486654683", new Object[]{this, str});
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.getString("orderId");
            String string = jSONObject.getString("payParam");
            String string2 = jSONObject.getString("jsCallBack");
            this.mAliPayJSCallBack = string2;
            doAliPay(string, string, string2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public long getCityId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1174901725") ? ((Long) ipChange.ipc$dispatch("1174901725", new Object[]{this})).longValue() : mu0.b();
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void goWalletKeFu() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1503173115")) {
            ipChange.ipc$dispatch("1503173115", new Object[]{this});
        } else {
            DMNav.from(this.mContext).toUri(NavUri.b("trade_bridge"));
        }
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void gotoRealNameThenticate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "794772728")) {
            ipChange.ipc$dispatch("794772728", new Object[]{this});
            return;
        }
        z20.v0(true);
        DMNav.from(this.mContext).forResult(H5MainActivity.REQUEST_REALNAME).toUri(NavUri.b("nameauth"));
    }

    public void onWxPay(BaseResp baseResp) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "738361464")) {
            ipChange.ipc$dispatch("738361464", new Object[]{this, baseResp});
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("errCode", baseResp.errCode);
            jSONObject.put("errStr", baseResp.errStr);
            jSONObject.put("transaction", baseResp.transaction);
            jSONObject.put("openId", baseResp.openId);
            onWxPay(this.mWxPayJSCallBack, jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void openPage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1686125782")) {
            ipChange.ipc$dispatch("1686125782", new Object[]{this, str});
        } else {
            tr2.b().q((Activity) this.mContext, str);
        }
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void setSpecialTitle(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "434021070")) {
            ipChange.ipc$dispatch("434021070", new Object[]{this, str});
        } else {
            this.mWebView.post(new Runnable() { // from class: cn.damai.h5container.JSBridge.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1008610029")) {
                        ipChange2.ipc$dispatch("1008610029", new Object[]{this});
                    } else if (JSBridge.this.mContext instanceof DamaiBaseActivity) {
                        ((DamaiBaseActivity) JSBridge.this.mContext).setTitleContent(str);
                    } else if (JSBridge.this.mContext instanceof WeexActivity) {
                        ((WeexActivity) JSBridge.this.mContext).setTitleContent(str);
                    } else if (JSBridge.this.mContext instanceof DMH5Activity) {
                        ((DMH5Activity) JSBridge.this.mContext).setTitleContent(str);
                    }
                }
            });
        }
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void wxpay(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1398450424")) {
            ipChange.ipc$dispatch("-1398450424", new Object[]{this, str});
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("orderId");
            String string2 = jSONObject.getString("payParam");
            this.mWxPayJSCallBack = jSONObject.getString("jsCallBack");
            doWxPay(string, string2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onWxPay(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-528742799")) {
            ipChange.ipc$dispatch("-528742799", new Object[]{this, str, str2});
            return;
        }
        try {
            String format = String.format("javascript:%s(%s);", this.mWxPayJSCallBack, str2);
            Log.d("JsCallBack", format);
            this.mWebView.loadUrl(format);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
