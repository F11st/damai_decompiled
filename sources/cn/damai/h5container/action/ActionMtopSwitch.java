package cn.damai.h5container.action;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.text.TextUtils;
import cn.damai.common.AppConfig;
import cn.damai.net.NetConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.intf.Mtop;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionMtopSwitch extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionMtopSwitch(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1529443582")) {
            return ((Boolean) ipChange.ipc$dispatch("1529443582", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        String param = getParam("mtopCase");
        if (!TextUtils.isEmpty(param)) {
            if ("damai".equals(param)) {
                Mtop.instance(Mtop.Id.INNER, mu0.a(), AppConfig.p()).registerTtid(AppConfig.p());
            } else if ("youku".equals(param)) {
                Mtop.instance(NetConstants.YOUKU_MTOP_INSTANCE_ID, mu0.a(), AppConfig.p()).registerTtid(AppConfig.p());
            }
        }
        wVCallBackContext.success();
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1843816916") ? (String) ipChange.ipc$dispatch("-1843816916", new Object[]{this}) : "mtopSwtich";
    }
}
