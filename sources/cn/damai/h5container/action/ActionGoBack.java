package cn.damai.h5container.action;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.ui.component.WXWeb;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionGoBack extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionGoBack(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-560936943")) {
            return ((Boolean) ipChange.ipc$dispatch("-560936943", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        if (this.webView.canGoBack()) {
            this.webView.goBack();
            wVCallBackContext.success();
        } else {
            wVCallBackContext.error();
        }
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1124699007") ? (String) ipChange.ipc$dispatch("1124699007", new Object[]{this}) : WXWeb.GO_BACK;
    }
}
