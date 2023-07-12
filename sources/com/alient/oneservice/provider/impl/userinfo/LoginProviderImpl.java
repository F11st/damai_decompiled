package com.alient.oneservice.provider.impl.userinfo;

import android.content.Context;
import cn.damai.login.LoginManager;
import cn.damai.login.havana.ILoginListener;
import com.alient.oneservice.userinfo.LoginProvider;
import com.alient.oneservice.userinfo.YYLoginListener;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class LoginProviderImpl implements LoginProvider {
    @Override // com.alient.oneservice.userinfo.LoginProvider
    public boolean checkSessionValid() {
        return LoginManager.k().q();
    }

    @Override // com.alient.oneservice.userinfo.LoginProvider
    public void notifyLogin(Context context, final YYLoginListener yYLoginListener) {
        LoginManager.k().c(new ILoginListener() { // from class: com.alient.oneservice.provider.impl.userinfo.LoginProviderImpl.1
            @Override // cn.damai.login.havana.ILoginListener
            public void onLoginCancel() {
                yYLoginListener.onLoginCancel();
            }

            @Override // cn.damai.login.havana.ILoginListener
            public void onLoginFail() {
                yYLoginListener.onLoginFail();
            }

            @Override // cn.damai.login.havana.ILoginListener
            public void onLoginSuccess() {
                yYLoginListener.onLoginSuccess();
            }

            @Override // cn.damai.login.havana.ILoginListener
            public void onLogout() {
                yYLoginListener.onLogout();
            }
        });
        LoginManager.k().v(mu0.a());
    }
}
