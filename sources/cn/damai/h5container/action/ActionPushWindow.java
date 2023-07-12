package cn.damai.h5container.action;

import android.content.Context;
import android.net.Uri;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.text.TextUtils;
import cn.damai.common.nav.DMNav;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionPushWindow extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionPushWindow(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1364268276")) {
            return ((Boolean) ipChange.ipc$dispatch("-1364268276", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        String str3 = (String) JSON.parseObject(str2).get("url");
        if (TextUtils.isEmpty(str3)) {
            wVCallBackContext.error();
        } else {
            DMNav.from(this.contextReference).toUri(Uri.parse(str3.trim()));
            wVCallBackContext.success();
        }
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-800612678") ? (String) ipChange.ipc$dispatch("-800612678", new Object[]{this}) : "pushWindow";
    }
}
