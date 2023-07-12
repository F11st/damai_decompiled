package cn.damai.h5container.action;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import cn.damai.commonbusiness.update.UpdateUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionAppUpdate extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionAppUpdate(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "453439746")) {
            return ((Boolean) ipChange.ipc$dispatch("453439746", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        UpdateUtil.d();
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "615482672") ? (String) ipChange.ipc$dispatch("615482672", new Object[]{this}) : "appUpdate";
    }
}
