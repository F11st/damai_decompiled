package cn.damai.h5container.action;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.h5container.H5MainActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionGotoRealNameThenticate extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionGotoRealNameThenticate(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-193074641")) {
            return ((Boolean) ipChange.ipc$dispatch("-193074641", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        z20.v0(true);
        DMNav.from(this.contextReference).forResult(H5MainActivity.REQUEST_REALNAME).toUri(NavUri.b("nameauth"));
        wVCallBackContext.success();
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-111277027") ? (String) ipChange.ipc$dispatch("-111277027", new Object[]{this}) : "gotoRealNameThenticate";
    }
}
