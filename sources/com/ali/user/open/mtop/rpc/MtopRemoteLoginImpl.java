package com.ali.user.open.mtop.rpc;

import com.ali.user.open.callback.LoginCallback;
import com.ali.user.open.core.util.ReflectionUtils;
import com.ali.user.open.service.impl.SessionManager;
import com.ali.user.open.session.Session;
import com.ali.user.open.tbauth.TbAuthServiceImpl;
import com.ali.user.open.ucc.util.MtopRemoteLogin;
import com.taobao.tao.remotebusiness.login.IRemoteLogin;
import com.taobao.tao.remotebusiness.login.LoginContext;
import com.taobao.tao.remotebusiness.login.onLoginListener;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class MtopRemoteLoginImpl implements IRemoteLogin {
    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    public LoginContext getLoginContext() {
        LoginContext loginContext = new LoginContext();
        try {
            loginContext.nickname = SessionManager.INSTANCE.getSession().nick;
        } catch (Exception unused) {
        }
        return loginContext;
    }

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    public boolean isLogining() {
        return false;
    }

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    public boolean isSessionValid() {
        return SessionManager.INSTANCE.isSessionValid();
    }

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    public void login(final onLoginListener onloginlistener, boolean z) {
        LoginCallback loginCallback = new LoginCallback() { // from class: com.ali.user.open.mtop.rpc.MtopRemoteLoginImpl.1
            @Override // com.ali.user.open.core.callback.FailureCallback
            public void onFailure(int i, String str) {
                onLoginListener onloginlistener2 = onloginlistener;
                if (onloginlistener2 != null) {
                    if (i == 10003) {
                        onloginlistener2.onLoginCancel();
                    } else {
                        onloginlistener2.onLoginFail();
                    }
                }
            }

            @Override // com.ali.user.open.callback.LoginCallback
            public void onSuccess(Session session) {
                onLoginListener onloginlistener2 = onloginlistener;
                if (onloginlistener2 != null) {
                    onloginlistener2.onLoginSuccess();
                }
            }
        };
        try {
            MtopRemoteLogin.class.getMethod("login", LoginCallback.class).invoke(null, loginCallback);
        } catch (Throwable unused) {
            try {
                ReflectionUtils.invoke("com.ali.user.open.tbauth.TbAuthServiceImpl", "auth", new String[]{"com.ali.user.open.callback.LoginCallback"}, TbAuthServiceImpl.class.newInstance(), new Object[]{loginCallback});
            } catch (Throwable unused2) {
            }
        }
    }
}
