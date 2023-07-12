package cn.damai.h5container.action;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import cn.damai.pay.alipay.Result2;
import com.alipay.sdk.app.PayTask;
import com.alipay.sdk.m.u.C4316l;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionAlipay extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int SDK_PAY_FLAG = 1;
    private WVCallBackContext callback;
    private Handler mHandler;

    public ActionAlipay(Context context) {
        super(context);
        this.mHandler = new Handler() { // from class: cn.damai.h5container.action.ActionAlipay.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-224699432")) {
                    ipChange.ipc$dispatch("-224699432", new Object[]{this, message});
                } else if (message.what != 1) {
                } else {
                    Result2 result2 = new Result2((String) message.obj);
                    try {
                        WVResult wVResult = new WVResult();
                        wVResult.addData(C4316l.a, result2.resultStatus);
                        wVResult.addData("result", result2.result);
                        wVResult.addData(C4316l.b, result2.memo);
                        ActionAlipay.this.onAlipay(wVResult);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    private void doAliPay(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "444239213")) {
            ipChange.ipc$dispatch("444239213", new Object[]{this, str});
        } else {
            new Thread(new Runnable() { // from class: cn.damai.h5container.action.ActionAlipay.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2048097114")) {
                        ipChange2.ipc$dispatch("2048097114", new Object[]{this});
                        return;
                    }
                    String pay = ActionAlipay.this.contextReference instanceof Activity ? new PayTask((Activity) ActionAlipay.this.contextReference).pay(str, true) : "";
                    Message message = new Message();
                    message.what = 1;
                    message.obj = pay;
                    ActionAlipay.this.mHandler.sendMessage(message);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAlipay(WVResult wVResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2035419549")) {
            ipChange.ipc$dispatch("2035419549", new Object[]{this, wVResult});
        } else {
            this.callback.success(wVResult);
        }
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1137513428")) {
            return ((Boolean) ipChange.ipc$dispatch("-1137513428", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        this.callback = wVCallBackContext;
        doAliPay(this.jsonObject.getString("payParam"));
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-469501990") ? (String) ipChange.ipc$dispatch("-469501990", new Object[]{this}) : "alipay";
    }
}
