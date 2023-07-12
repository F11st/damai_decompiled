package cn.damai.h5container.action;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import cn.damai.common.nav.DMNav;
import cn.damai.h5container.DamaiWebView;
import cn.damai.h5container.UniH5ContainerSwitcher;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionOpenPage extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionOpenPage(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1795983707")) {
            return ((Boolean) ipChange.ipc$dispatch("1795983707", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        String param = getParam("url");
        if (wh2.j(param)) {
            wVCallBackContext.error("error page url");
            return true;
        }
        Bundle bundle = new Bundle();
        DamaiWebView damaiWebView = this.webView;
        if (damaiWebView != null && damaiWebView.getUrl() != null && this.webView.getUrl().startsWith(UniH5ContainerSwitcher.XIAOMI)) {
            bundle.putBoolean("fromQr", true);
        }
        DMNav.from(this.contextReference).withExtras(bundle).toUri(Uri.parse(param));
        wVCallBackContext.success();
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1946541129") ? (String) ipChange.ipc$dispatch("1946541129", new Object[]{this}) : "openPage";
    }
}
