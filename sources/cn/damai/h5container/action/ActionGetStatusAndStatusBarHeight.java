package cn.damai.h5container.action;

import android.app.Activity;
import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taomai.android.h5container.api.TaoMaiClientInfoPlugin;
import com.youku.arch.v3.data.Constants;
import tb.kg2;
import tb.l62;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionGetStatusAndStatusBarHeight extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionGetStatusAndStatusBarHeight(Context context) {
        super(context);
    }

    public static int getStatusBarHeight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1706986430")) {
            return ((Integer) ipChange.ipc$dispatch("1706986430", new Object[0])).intValue();
        }
        int identifier = mu0.a().getResources().getIdentifier("status_bar_height", Constants.DIMEN, "android");
        if (identifier > 0) {
            return mu0.a().getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        int statusBarHeight;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1257673777")) {
            return ((Boolean) ipChange.ipc$dispatch("1257673777", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        Context context = this.contextReference;
        if (context instanceof Activity) {
            statusBarHeight = kg2.a((Activity) context);
        } else {
            statusBarHeight = getStatusBarHeight();
        }
        int a = l62.a(mu0.a(), 46.0f);
        float f = l62.b(mu0.a()).density;
        WVResult wVResult = new WVResult();
        wVResult.addData("titleBarHeight", Integer.valueOf(a));
        wVResult.addData("statusBarHeight", Integer.valueOf(statusBarHeight));
        wVResult.addData("density", Float.valueOf(f));
        wVCallBackContext.success(wVResult);
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-9179233") ? (String) ipChange.ipc$dispatch("-9179233", new Object[]{this}) : TaoMaiClientInfoPlugin.ACTION_STATUS_BAR_HEIGHT;
    }
}
