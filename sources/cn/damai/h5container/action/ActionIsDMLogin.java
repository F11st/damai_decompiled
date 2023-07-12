package cn.damai.h5container.action;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import cn.damai.login.LoginManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionIsDMLogin extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionIsDMLogin(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-704331346")) {
            return ((Boolean) ipChange.ipc$dispatch("-704331346", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        try {
            z = LoginManager.k().q();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (wVCallBackContext != null) {
            WVResult wVResult = new WVResult();
            wVResult.addData("isDMLogin", Boolean.valueOf(z));
            wVCallBackContext.success(wVResult);
        }
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1756735196") ? (String) ipChange.ipc$dispatch("1756735196", new Object[]{this}) : "isDMLogin";
    }
}
