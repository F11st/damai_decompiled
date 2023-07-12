package cn.damai.h5container.action;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import cn.damai.common.AppConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionTTID extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionTTID(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "383019485")) {
            return ((Boolean) ipChange.ipc$dispatch("383019485", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        String p = AppConfig.p();
        try {
            WVResult wVResult = new WVResult();
            wVResult.addData("ttid", p);
            wVCallBackContext.success(wVResult);
        } catch (Exception e) {
            e.printStackTrace();
            wVCallBackContext.error();
        }
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "178902603") ? (String) ipChange.ipc$dispatch("178902603", new Object[]{this}) : "getTTID";
    }
}
