package cn.damai.h5container.action;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionIsBottom extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionIsBottom(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-495939497")) {
            return ((Boolean) ipChange.ipc$dispatch("-495939497", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        WVResult wVResult = new WVResult();
        wVResult.addData("isbottompage", Boolean.valueOf(!this.webView.canGoBack()));
        wVCallBackContext.success(wVResult);
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1550299205") ? (String) ipChange.ipc$dispatch("1550299205", new Object[]{this}) : "isBottomPage";
    }
}
