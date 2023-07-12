package cn.damai.h5container.action;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.login4android.Login;
import tb.vd1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionHavanaId extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionHavanaId(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "55731252")) {
            return ((Boolean) ipChange.ipc$dispatch("55731252", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        String userId = Login.getUserId();
        WVResult wVResult = new WVResult();
        wVResult.addData("havanaId", userId);
        try {
            String c = vd1.c(userId);
            if (!TextUtils.isEmpty(c) && c.length() == 32) {
                wVResult.addData("mixId", vd1.c(userId).substring(8, 24));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        wVCallBackContext.success(wVResult);
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1175169566") ? (String) ipChange.ipc$dispatch("-1175169566", new Object[]{this}) : "getHavanaId";
    }
}
