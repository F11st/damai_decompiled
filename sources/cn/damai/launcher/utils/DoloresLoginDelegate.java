package cn.damai.launcher.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.login.LoginManager;
import cn.damai.login.havana.ILoginListener;
import com.alibaba.pictures.dolores.login.IDoloresLoginDelegate;
import com.alibaba.pictures.dolores.login.IDoloresLoginListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DoloresLoginDelegate implements IDoloresLoginDelegate {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.alibaba.pictures.dolores.login.IDoloresLoginDelegate
    public void doLogin(boolean z, @NonNull final IDoloresLoginListener iDoloresLoginListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "892082242")) {
            ipChange.ipc$dispatch("892082242", new Object[]{this, Boolean.valueOf(z), iDoloresLoginListener});
            return;
        }
        LoginManager.k().c(new ILoginListener(this) { // from class: cn.damai.launcher.utils.DoloresLoginDelegate.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.login.havana.ILoginListener
            public void onLoginCancel() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-180985130")) {
                    ipChange2.ipc$dispatch("-180985130", new Object[]{this});
                } else {
                    iDoloresLoginListener.onLoginCancel();
                }
            }

            @Override // cn.damai.login.havana.ILoginListener
            public void onLoginFail() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1887333774")) {
                    ipChange2.ipc$dispatch("-1887333774", new Object[]{this});
                } else {
                    iDoloresLoginListener.onLoginFail();
                }
            }

            @Override // cn.damai.login.havana.ILoginListener
            public void onLoginSuccess() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "358448087")) {
                    ipChange2.ipc$dispatch("358448087", new Object[]{this});
                } else {
                    iDoloresLoginListener.onLoginSuccess();
                }
            }

            @Override // cn.damai.login.havana.ILoginListener
            public void onLogout() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1316129369")) {
                    ipChange2.ipc$dispatch("-1316129369", new Object[]{this});
                }
            }
        });
        if (z) {
            LoginManager.k().v(mu0.a());
        }
    }

    @Override // com.alibaba.pictures.dolores.login.IDoloresLoginDelegate
    public void doRegisterSessionFail(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1338646901")) {
            ipChange.ipc$dispatch("-1338646901", new Object[]{this, str});
        }
    }

    @Override // com.alibaba.pictures.dolores.login.IDoloresLoginDelegate
    public boolean isSessionValid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-119583369") ? ((Boolean) ipChange.ipc$dispatch("-119583369", new Object[]{this})).booleanValue() : LoginManager.k().q();
    }

    @Override // com.alibaba.pictures.dolores.login.IDoloresLoginDelegate
    public void registerSession(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-985364130")) {
            ipChange.ipc$dispatch("-985364130", new Object[]{this, str});
        }
    }
}
