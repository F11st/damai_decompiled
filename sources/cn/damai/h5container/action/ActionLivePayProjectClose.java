package cn.damai.h5container.action;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionLivePayProjectClose extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionLivePayProjectClose(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1604235475")) {
            return ((Boolean) ipChange.ipc$dispatch("1604235475", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1022313023") ? (String) ipChange.ipc$dispatch("-1022313023", new Object[]{this}) : "liveroomCloseHalfviewModal";
    }
}
