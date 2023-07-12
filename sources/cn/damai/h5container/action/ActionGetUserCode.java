package cn.damai.h5container.action;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionGetUserCode extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionGetUserCode(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1099379002")) {
            return ((Boolean) ipChange.ipc$dispatch("-1099379002", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        WVResult wVResult = new WVResult();
        wVResult.addData("usercode", z20.E());
        wVCallBackContext.success(wVResult);
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1314642444") ? (String) ipChange.ipc$dispatch("-1314642444", new Object[]{this}) : "getUserCode";
    }
}
