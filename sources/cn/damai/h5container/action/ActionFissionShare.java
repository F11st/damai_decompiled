package cn.damai.h5container.action;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import cn.damai.commonbusiness.fission.bean.FissionParam;
import cn.damai.commonbusiness.fission.util.FissionUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionFissionShare extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionFissionShare(Context context) {
        super(context);
    }

    private FissionParam getFissionParam() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1189491777")) {
            return (FissionParam) ipChange.ipc$dispatch("1189491777", new Object[]{this});
        }
        try {
            return (FissionParam) m61.a(this.jsonObject.toJSONString(), FissionParam.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-13017540")) {
            return ((Boolean) ipChange.ipc$dispatch("-13017540", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        FissionParam fissionParam = getFissionParam();
        if (fissionParam != null) {
            new FissionUtil().h(this.contextReference, fissionParam);
        }
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1376105962") ? (String) ipChange.ipc$dispatch("1376105962", new Object[]{this}) : "newShare";
    }
}
