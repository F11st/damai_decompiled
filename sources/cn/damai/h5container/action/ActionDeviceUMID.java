package cn.damai.h5container.action;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import cn.damai.common.AppConfig;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.umid.IUMIDComponent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionDeviceUMID extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionDeviceUMID(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        int i = 2;
        if (AndroidInstantRuntime.support(ipChange, "1681525035")) {
            return ((Boolean) ipChange.ipc$dispatch("1681525035", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        try {
            IUMIDComponent uMIDComp = SecurityGuardManager.getInstance(this.contextReference).getUMIDComp();
            if (AppConfig.g() == AppConfig.EnvMode.prepare) {
                i = 1;
            } else if (AppConfig.g() != AppConfig.EnvMode.test) {
                i = 0;
            }
            String securityToken = uMIDComp.getSecurityToken(i);
            WVResult wVResult = new WVResult();
            wVResult.addData("securityToken", securityToken);
            wVCallBackContext.success(wVResult);
        } catch (SecException e) {
            e.printStackTrace();
            wVCallBackContext.error();
        }
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "13236249") ? (String) ipChange.ipc$dispatch("13236249", new Object[]{this}) : "getDeviceUMID";
    }
}
