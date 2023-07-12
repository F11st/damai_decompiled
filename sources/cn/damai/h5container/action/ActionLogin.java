package cn.damai.h5container.action;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionLogin extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionLogin(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2001648737")) {
            return ((Boolean) ipChange.ipc$dispatch("2001648737", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        DMNav.from(this.contextReference).withExtras(paramToBundle()).toUri(NavUri.b("login"));
        wVCallBackContext.success();
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-388793393") ? (String) ipChange.ipc$dispatch("-388793393", new Object[]{this}) : "gotoLogin";
    }
}
