package cn.damai.h5container.action;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ut.device.UTDevice;
import java.net.URLEncoder;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionUtdid extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionUtdid(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "794380600")) {
            return ((Boolean) ipChange.ipc$dispatch("794380600", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        String utdid = UTDevice.getUtdid(this.contextReference);
        try {
            WVResult wVResult = new WVResult();
            wVResult.addData("utdid", URLEncoder.encode(utdid));
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
        return AndroidInstantRuntime.support(ipChange, "-1073844762") ? (String) ipChange.ipc$dispatch("-1073844762", new Object[]{this}) : "getUtdid";
    }
}
