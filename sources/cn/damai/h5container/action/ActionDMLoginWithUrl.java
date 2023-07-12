package cn.damai.h5container.action;

import android.content.Context;
import android.os.Bundle;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.login.LoginManager;
import cn.damai.login.havana.ILoginListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cs;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionDMLoginWithUrl extends DMBridgeAction implements ILoginListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private String mRedirectUrl;

    public ActionDMLoginWithUrl(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-965038133")) {
            return ((Boolean) ipChange.ipc$dispatch("-965038133", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        String param = getParam("url");
        try {
            if (LoginManager.k().q()) {
                Bundle bundle = new Bundle();
                bundle.putString("url", param);
                DMNav.from(this.contextReference).withExtras(bundle).toUri(NavUri.b(cs.t));
            } else {
                this.mRedirectUrl = param;
                LoginManager.k().c(this);
                LoginManager.k().v(this.contextReference);
            }
            if (wVCallBackContext != null) {
                wVCallBackContext.success();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (wVCallBackContext != null) {
                wVCallBackContext.error();
            }
        }
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1611065671") ? (String) ipChange.ipc$dispatch("-1611065671", new Object[]{this}) : "dmLoginWithUrl";
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginCancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1250024463")) {
            ipChange.ipc$dispatch("1250024463", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginFail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "27002347")) {
            ipChange.ipc$dispatch("27002347", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1770072510")) {
            ipChange.ipc$dispatch("1770072510", new Object[]{this});
            return;
        }
        LoginManager.k().C(this);
        if (wh2.j(this.mRedirectUrl)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("url", this.mRedirectUrl);
        DMNav.from(this.contextReference).withExtras(bundle).toUri(NavUri.b(cs.t));
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLogout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1645781810")) {
            ipChange.ipc$dispatch("-1645781810", new Object[]{this});
        }
    }
}
