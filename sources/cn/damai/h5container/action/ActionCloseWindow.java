package cn.damai.h5container.action;

import android.app.Activity;
import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionCloseWindow extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionCloseWindow(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1023238528")) {
            return ((Boolean) ipChange.ipc$dispatch("1023238528", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        Context context = this.contextReference;
        if (!(context instanceof Activity)) {
            wVCallBackContext.error("not Activity instance");
            return true;
        }
        Activity activity = (Activity) context;
        if (activity == null) {
            wVCallBackContext.error();
        } else {
            activity.finish();
            wVCallBackContext.success();
        }
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1512217646") ? (String) ipChange.ipc$dispatch("1512217646", new Object[]{this}) : "closeWindow";
    }
}
