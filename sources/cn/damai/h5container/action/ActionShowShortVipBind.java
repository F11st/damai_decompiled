package cn.damai.h5container.action;

import android.app.Activity;
import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import cn.damai.commonbusiness.yymember.view.MemberAuthPopWindow;
import cn.damai.h5container.DMH5Activity;
import cn.damai.h5container.H5MainActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.k23;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionShowShortVipBind extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionShowShortVipBind(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, final WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "939941981")) {
            return ((Boolean) ipChange.ipc$dispatch("939941981", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        Context context = this.contextReference;
        if ((context instanceof H5MainActivity) || (context instanceof DMH5Activity)) {
            k23.g(this.contextReference, (Activity) context, getParam("url"), new MemberAuthPopWindow.ICustomDialogEventListener() { // from class: cn.damai.h5container.action.ActionShowShortVipBind.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.commonbusiness.yymember.view.MemberAuthPopWindow.ICustomDialogEventListener
                public void dialogItemEvent(String str3) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1518238975")) {
                        ipChange2.ipc$dispatch("1518238975", new Object[]{this, str3});
                    } else if ("success".equals(str3)) {
                        WVResult wVResult = new WVResult();
                        wVResult.addData("success", "true");
                        wVCallBackContext.success(wVResult);
                    }
                }
            });
        }
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1372934965") ? (String) ipChange.ipc$dispatch("-1372934965", new Object[]{this}) : "showShortVipBind";
    }
}
