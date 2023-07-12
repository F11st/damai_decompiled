package cn.damai.h5container.action;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taomai.android.h5container.api.TMUTPlugin;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionUserTrack extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionUserTrack(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2105217656")) {
            return ((Boolean) ipChange.ipc$dispatch("2105217656", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        if (wVCallBackContext != null) {
            wVCallBackContext.success();
        }
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1561712858") ? (String) ipChange.ipc$dispatch("-1561712858", new Object[]{this}) : TMUTPlugin.ACTION_USER_TRACK;
    }
}
