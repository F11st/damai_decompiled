package com.youku.live.dsl.account;

import android.content.Context;
import cn.damai.login.LoginManager;
import cn.damai.login.api.IPassportListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ILoginImp implements ILogin {
    private static transient /* synthetic */ IpChange $ipChange;
    private static ILoginImp sInstance;
    private Map<String, IPassportListener> mPassportListener;

    public static ILoginImp getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1376293445")) {
            return (ILoginImp) ipChange.ipc$dispatch("-1376293445", new Object[0]);
        }
        if (sInstance == null) {
            synchronized (ILoginImp.class) {
                if (sInstance == null) {
                    sInstance = new ILoginImp();
                }
            }
        }
        return sInstance;
    }

    private Map<String, IPassportListener> getPassportListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1673770396")) {
            return (Map) ipChange.ipc$dispatch("1673770396", new Object[]{this});
        }
        if (this.mPassportListener == null) {
            synchronized (this) {
                if (this.mPassportListener == null) {
                    this.mPassportListener = new HashMap();
                }
            }
        }
        return this.mPassportListener;
    }

    private boolean isLoginDmYk() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "67073910") ? ((Boolean) ipChange.ipc$dispatch("67073910", new Object[]{this})).booleanValue() : LoginManager.k().q() && LoginManager.k().s();
    }

    @Override // com.youku.live.dsl.account.ILogin
    public boolean isLogined() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "182183922") ? ((Boolean) ipChange.ipc$dispatch("182183922", new Object[]{this})).booleanValue() : isLoginDmYk();
    }

    @Override // com.youku.live.dsl.account.ILogin
    public void login() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1377641827")) {
            ipChange.ipc$dispatch("1377641827", new Object[]{this});
        } else if (!LoginManager.k().q()) {
            LoginManager.k().v(Dsl.getContext());
        } else {
            LoginManager.k().t(Dsl.getContext());
        }
    }

    @Override // com.youku.live.dsl.account.ILogin
    public void logout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-62274924")) {
            ipChange.ipc$dispatch("-62274924", new Object[]{this});
        } else {
            LoginManager.k().u();
        }
    }

    @Override // com.youku.live.dsl.account.ILogin
    public void registerLoginChangedListener(final ILoginChangedListener iLoginChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-698291706")) {
            ipChange.ipc$dispatch("-698291706", new Object[]{this, iLoginChangedListener});
        } else if (iLoginChangedListener == null) {
        } else {
            IPassportListener iPassportListener = new IPassportListener() { // from class: com.youku.live.dsl.account.ILoginImp.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.login.api.IPassportListener
                public void onCookieRefreshed(String str) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-196764014")) {
                        ipChange2.ipc$dispatch("-196764014", new Object[]{this, str});
                    } else {
                        iLoginChangedListener.onLoginChanged(true);
                    }
                }

                @Override // cn.damai.login.api.IPassportListener
                public void onExpireLogout() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1706247645")) {
                        ipChange2.ipc$dispatch("-1706247645", new Object[]{this});
                    } else {
                        iLoginChangedListener.onLoginChanged(false);
                    }
                }

                @Override // cn.damai.login.api.IPassportListener
                public void onLoginCancel() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1638219675")) {
                        ipChange2.ipc$dispatch("1638219675", new Object[]{this});
                    }
                }

                @Override // cn.damai.login.api.IPassportListener
                public void onTokenRefreshed(String str) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2094207797")) {
                        ipChange2.ipc$dispatch("2094207797", new Object[]{this, str});
                    } else {
                        iLoginChangedListener.onLoginChanged(true);
                    }
                }

                @Override // cn.damai.login.api.IPassportListener
                public void onUserLogin() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1695088416")) {
                        ipChange2.ipc$dispatch("-1695088416", new Object[]{this});
                    } else {
                        iLoginChangedListener.onLoginChanged(true);
                    }
                }

                @Override // cn.damai.login.api.IPassportListener
                public void onUserLogout() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-827631945")) {
                        ipChange2.ipc$dispatch("-827631945", new Object[]{this});
                    } else {
                        iLoginChangedListener.onLoginChanged(false);
                    }
                }
            };
            getPassportListeners().put(String.valueOf(iLoginChangedListener.hashCode()), iPassportListener);
            LoginManager.k();
            LoginManager.A(iPassportListener);
        }
    }

    @Override // com.youku.live.dsl.account.ILogin
    public void unregisterLoginChangedListener(ILoginChangedListener iLoginChangedListener) {
        IPassportListener remove;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1900105139")) {
            ipChange.ipc$dispatch("-1900105139", new Object[]{this, iLoginChangedListener});
        } else if (iLoginChangedListener == null || (remove = getPassportListeners().remove(String.valueOf(iLoginChangedListener.hashCode()))) == null) {
        } else {
            LoginManager.k();
            LoginManager.E(remove);
        }
    }

    @Override // com.youku.live.dsl.account.ILogin
    public void login(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-79680571")) {
            ipChange.ipc$dispatch("-79680571", new Object[]{this, context});
        } else if (LoginManager.k().q()) {
            LoginManager.k().t(context);
        } else if (context != null) {
            LoginManager.k().v(context);
        }
    }
}
