package tb;

import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import cn.damai.login.LoginManager;
import cn.damai.login.YouKuTrustListener;
import cn.damai.login.api.IPassportListener;
import cn.damai.login.api.PassportBroadCastReceiver;
import cn.damai.login.havana.HavanaProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.usercenter.passport.IPassport;
import com.youku.usercenter.passport.PassportManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class zb1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static zb1 d;
    private static List<IPassportListener> e = new ArrayList();
    PassportBroadCastReceiver a;
    private int b = -1;
    private boolean c = false;

    /* compiled from: Taobao */
    /* renamed from: tb.zb1$a */
    /* loaded from: classes5.dex */
    public class C10018a implements YouKuTrustListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C10018a() {
        }

        @Override // cn.damai.login.YouKuTrustListener
        public void showLoading(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-251298718")) {
                ipChange.ipc$dispatch("-251298718", new Object[]{this, Boolean.valueOf(z)});
            }
        }

        @Override // cn.damai.login.YouKuTrustListener
        public void trustYouKuFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "70105438")) {
                ipChange.ipc$dispatch("70105438", new Object[]{this, str, str2});
                return;
            }
            zb1.this.c = false;
            zb1.this.b = -1;
            b23.a(b23.i("", "", str, str2, ""), fw0.LOGIN_YOUKU_FAILED_CODE, fw0.LOGIN_YOUKU_FAILED_MSG);
        }

        @Override // cn.damai.login.YouKuTrustListener
        public void trustYouKuSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1684890113")) {
                ipChange.ipc$dispatch("-1684890113", new Object[]{this});
            } else {
                zb1.this.c = true;
            }
        }
    }

    zb1() {
    }

    public static zb1 c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1946158123")) {
            return (zb1) ipChange.ipc$dispatch("-1946158123", new Object[0]);
        }
        if (d == null) {
            synchronized (HavanaProxy.class) {
                if (d == null) {
                    d = new zb1();
                }
            }
        }
        return d;
    }

    private void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2130461470")) {
            ipChange.ipc$dispatch("2130461470", new Object[]{this});
            return;
        }
        z20.C0("");
        x20.h();
    }

    public boolean d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "610167622") ? ((Boolean) ipChange.ipc$dispatch("610167622", new Object[]{this})).booleanValue() : PassportManager.getInstance().isLogin();
    }

    public void e(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "911453331")) {
            ipChange.ipc$dispatch("911453331", new Object[]{this, context});
        } else if (context == null) {
        } else {
            if (!LoginManager.k().q()) {
                LoginManager.k().v(context);
                this.c = false;
            } else if (this.c) {
            } else {
                this.b = 0;
                LoginManager.k().i(context, 0, new C10018a());
            }
        }
    }

    public synchronized void f(IPassportListener iPassportListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2141607157")) {
            ipChange.ipc$dispatch("-2141607157", new Object[]{this, iPassportListener});
            return;
        }
        if (iPassportListener != null) {
            e.add(iPassportListener);
        }
    }

    public void g(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-994521825")) {
            ipChange.ipc$dispatch("-994521825", new Object[]{this, context});
            return;
        }
        h(context);
        this.a = new PassportBroadCastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IPassport.ACTION_USER_LOGIN);
        intentFilter.addAction(IPassport.ACTION_USER_LOOUT);
        intentFilter.addAction(IPassport.ACTION_LOGIN_CANCEL);
        intentFilter.addAction(IPassport.ACTION_EXPIRE_LOGOUT);
        intentFilter.addAction(IPassport.ACTION_TOKEN_REFRESHED);
        intentFilter.addAction(IPassport.ACTION_COOKIE_REFRESHED);
        LocalBroadcastManager.getInstance(context).registerReceiver(this.a, intentFilter);
        this.c = false;
    }

    public void h(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-635024308")) {
            ipChange.ipc$dispatch("-635024308", new Object[]{this, context});
        } else if (this.a != null) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this.a);
        }
    }

    public synchronized void i(IPassportListener iPassportListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-8928046")) {
            ipChange.ipc$dispatch("-8928046", new Object[]{this, iPassportListener});
            return;
        }
        if (iPassportListener != null) {
            e.remove(iPassportListener);
        }
    }

    public void k(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "532779210")) {
            ipChange.ipc$dispatch("532779210", new Object[]{this, str, str2});
        } else if (this.b != 0) {
        } else {
            Iterator<IPassportListener> it = e.iterator();
            while (true) {
                char c = 65535;
                if (it.hasNext()) {
                    IPassportListener next = it.next();
                    try {
                        next.onExpireLogout();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    try {
                        switch (str.hashCode()) {
                            case -1554963513:
                                if (str.equals(IPassport.ACTION_TOKEN_REFRESHED)) {
                                    c = 4;
                                    break;
                                }
                                break;
                            case -1401691070:
                                if (str.equals(IPassport.ACTION_USER_LOGIN)) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case -904311011:
                                if (str.equals(IPassport.ACTION_LOGIN_CANCEL)) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case -631641812:
                                if (str.equals(IPassport.ACTION_COOKIE_REFRESHED)) {
                                    c = 5;
                                    break;
                                }
                                break;
                            case -502744111:
                                if (str.equals(IPassport.ACTION_USER_LOOUT)) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case 1952037693:
                                if (str.equals(IPassport.ACTION_EXPIRE_LOGOUT)) {
                                    c = 3;
                                    break;
                                }
                                break;
                        }
                        if (c == 0) {
                            Log.d("passportReceiver", "LoginManager  ACTION_USER_LOGIN");
                            next.onUserLogin();
                        } else if (c == 1) {
                            next.onLoginCancel();
                        } else if (c == 2) {
                            next.onUserLogout();
                        } else if (c == 3) {
                            Log.d("passportReceiver", "LoginManager  ACTION_EXPIRE_LOGOUT");
                            next.onExpireLogout();
                        } else if (c == 4) {
                            Log.d("passportReceiver", "LoginManager  ACTION_EXPIRE_LOGOUT");
                            next.onTokenRefreshed(str2);
                        } else if (c == 5) {
                            Log.d("passportReceiver", "LoginManager  ACTION_EXPIRE_LOGOUT");
                            next.onCookieRefreshed(str2);
                        }
                    } catch (Exception unused) {
                    }
                } else {
                    this.b = -1;
                    return;
                }
            }
        }
    }

    public void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1146276053")) {
            ipChange.ipc$dispatch("-1146276053", new Object[]{this});
            return;
        }
        PassportManager.getInstance().logout();
        j();
    }
}
