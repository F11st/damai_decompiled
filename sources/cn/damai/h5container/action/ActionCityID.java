package cn.damai.h5container.action;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionCityID extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionCityID(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2086758232")) {
            return ((Boolean) ipChange.ipc$dispatch("-2086758232", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        long b = mu0.b();
        WVResult wVResult = new WVResult();
        if (b == 0) {
            wVResult.addData("cityid", "");
        } else {
            wVResult.addData("cityid", Long.valueOf(b));
        }
        wVCallBackContext.success(wVResult);
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1063489878") ? (String) ipChange.ipc$dispatch("1063489878", new Object[]{this}) : "getCityId";
    }
}
