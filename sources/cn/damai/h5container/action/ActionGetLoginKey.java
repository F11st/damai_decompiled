package cn.damai.h5container.action;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import cn.damai.common.app.ShareperfenceConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionGetLoginKey extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionGetLoginKey(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1905333724")) {
            return ((Boolean) ipChange.ipc$dispatch("-1905333724", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        WVResult wVResult = new WVResult();
        wVResult.addData(ShareperfenceConstants.OLD_LOGIN_KEY, z20.q());
        wVCallBackContext.success(wVResult);
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1318088750") ? (String) ipChange.ipc$dispatch("-1318088750", new Object[]{this}) : "getLoginkey";
    }
}
