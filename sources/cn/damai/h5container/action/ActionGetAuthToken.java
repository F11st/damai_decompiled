package cn.damai.h5container.action;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import cn.damai.login.LoginManager;
import cn.damai.login.api.IGetAuthCallback;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionGetAuthToken extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionGetAuthToken(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, final WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "57490397")) {
            return ((Boolean) ipChange.ipc$dispatch("57490397", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        try {
            LoginManager.k().j(getParam("siteCode"), getParam("target"), getParam("action"), getParam("feature"), new IGetAuthCallback() { // from class: cn.damai.h5container.action.ActionGetAuthToken.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.login.api.IGetAuthCallback
                public void onAuthTokenFail(String str3, String str4) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1688221432")) {
                        ipChange2.ipc$dispatch("1688221432", new Object[]{this, str3, str4});
                    } else if (wVCallBackContext != null) {
                        WVResult wVResult = new WVResult();
                        wVResult.addData("errorCode", str3);
                        wVResult.addData("errorMsg", str4);
                        wVCallBackContext.error(wVResult);
                    }
                }

                @Override // cn.damai.login.api.IGetAuthCallback
                public void onAuthTokenSuccess(String str3) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1998903377")) {
                        ipChange2.ipc$dispatch("-1998903377", new Object[]{this, str3});
                    } else if (wVCallBackContext != null) {
                        WVResult wVResult = new WVResult();
                        wVResult.addData("token", str3);
                        wVCallBackContext.success(wVResult);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1649944651") ? (String) ipChange.ipc$dispatch("1649944651", new Object[]{this}) : "getAuthToken";
    }
}
