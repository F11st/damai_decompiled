package cn.damai.h5container.action;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$string;
import cn.damai.wxapi.WXEntryActivity;
import cn.damai.wxapi.WXPayEntryActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import org.json.JSONObject;
import tb.cm2;
import tb.v20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionWxPay extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;
    private WVCallBackContext callback;

    public ActionWxPay(Context context) {
        super(context);
    }

    private void callback(WVResult wVResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-785068890")) {
            ipChange.ipc$dispatch("-785068890", new Object[]{this, wVResult});
            return;
        }
        WVCallBackContext wVCallBackContext = this.callback;
        if (wVCallBackContext != null) {
            wVCallBackContext.success(wVResult);
        }
    }

    private boolean canWxPay(IWXAPI iwxapi) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "82338060")) {
            return ((Boolean) ipChange.ipc$dispatch("82338060", new Object[]{this, iwxapi})).booleanValue();
        }
        boolean isWXAppInstalled = iwxapi.isWXAppInstalled();
        boolean z = iwxapi.getWXAppSupportAPI() >= 570425345;
        if (isWXAppInstalled && z) {
            return true;
        }
        int i = !isWXAppInstalled ? -1000 : !z ? -1001 : 0;
        try {
            WVResult wVResult = new WVResult();
            wVResult.addData("errCode", Integer.valueOf(i));
            wVResult.addData("errStr", "");
            wVResult.addData("transaction", "");
            wVResult.addData("openId", "");
            callback(wVResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ToastUtil a = ToastUtil.a();
        Context context = this.contextReference;
        a.j(context, cm2.b(context, R$string.pay_wx_not_support_toast));
        return false;
    }

    private void doWxPay(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-621112425")) {
            ipChange.ipc$dispatch("-621112425", new Object[]{this, str, str2});
            return;
        }
        String a = v20.a(WXEntryActivity.APP_ID_CRYPT);
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this.contextReference, a);
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
                WXPayEntryActivity.actionWxPay = this;
            } catch (Exception e) {
                e.printStackTrace();
                this.callback.error("error payParam");
            }
        }
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1525983359")) {
            return ((Boolean) ipChange.ipc$dispatch("1525983359", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        this.callback = wVCallBackContext;
        try {
            doWxPay(this.jsonObject.getString("orderId"), this.jsonObject.getString("payParam"));
        } catch (Exception e) {
            e.printStackTrace();
            wVCallBackContext.error("error params");
        }
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "420497005") ? (String) ipChange.ipc$dispatch("420497005", new Object[]{this}) : "wxpay";
    }

    public void onWxPay(BaseResp baseResp) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1553269438")) {
            ipChange.ipc$dispatch("1553269438", new Object[]{this, baseResp});
            return;
        }
        try {
            WVResult wVResult = new WVResult();
            wVResult.addData("errCode", Integer.valueOf(baseResp.errCode));
            wVResult.addData("errStr", baseResp.errStr);
            wVResult.addData("transaction", baseResp.transaction);
            wVResult.addData("openId", baseResp.openId);
            callback(wVResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
