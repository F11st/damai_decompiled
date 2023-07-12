package cn.damai.h5container.action;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import cn.damai.login.LoginManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionAuth3rdParty extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionAuth3rdParty(Context context) {
        super(context);
    }

    private void requestThirdAuthData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "792561239")) {
            ipChange.ipc$dispatch("792561239", new Object[]{this, str});
        } else {
            LoginManager.k().b(this.contextReference, str);
        }
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1380119755")) {
            return ((Boolean) ipChange.ipc$dispatch("1380119755", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        requestThirdAuthData(getParam("url"));
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "658578361") ? (String) ipChange.ipc$dispatch("658578361", new Object[]{this}) : "authThirdPage";
    }
}
