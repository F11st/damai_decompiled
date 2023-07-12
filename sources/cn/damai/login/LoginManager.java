package cn.damai.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$string;
import cn.damai.h5container.DamaiCookieManager;
import cn.damai.login.api.IGetAuthCallback;
import cn.damai.login.api.IPassportListener;
import cn.damai.login.authlogin.AuthLoginActivity;
import cn.damai.login.authlogin.req.GetAuthorizationTokenRequest;
import cn.damai.login.authlogin.req.ThirdPartyAuthRequest;
import cn.damai.login.authlogin.resp.AuthorizationModel;
import cn.damai.login.authlogin.resp.ThirdSessionModel;
import cn.damai.login.havana.HavanaProxy;
import cn.damai.login.havana.ILoginListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.connect.common.Constants;
import com.youku.passport.result.AbsResult;
import com.youku.usercenter.passport.Account;
import com.youku.usercenter.passport.PassportManager;
import com.youku.usercenter.passport.callback.ICallback;
import com.youku.usercenter.passport.result.UserInfo;
import mtopsdk.mtop.util.ErrorConstant;
import tb.cs;
import tb.m91;
import tb.wh2;
import tb.x20;
import tb.z20;
import tb.zb1;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class LoginManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String ACTION_DO_LOGIN = "action_do_login";
    public static final String ACTION_LOGIN_FIRST_CONFIRM_CANCEL = "action_login_first_confirm_cancel";
    public static final int LOGIN_FROM_ALIPAY = 101;
    public static final int LOGIN_FROM_AUTO_LOGIN = 110;
    public static final int LOGIN_FROM_NORMAL = 100;
    public static final int LOGIN_FROM_QQ = 104;
    public static final int LOGIN_FROM_TAOBAO = 102;
    public static final int LOGIN_FROM_WEIBO = 103;
    public static final int LOGIN_FROM_WEIXIN = 105;
    private static LoginManager a;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class a implements ICallback<AbsResult> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ YouKuTrustListener a;

        a(YouKuTrustListener youKuTrustListener) {
            this.a = youKuTrustListener;
        }

        @Override // com.youku.usercenter.passport.callback.ICallback
        public void onFailure(AbsResult absResult) {
            String str;
            IpChange ipChange = $ipChange;
            int i = 0;
            if (AndroidInstantRuntime.support(ipChange, "857165803")) {
                ipChange.ipc$dispatch("857165803", new Object[]{this, absResult});
                return;
            }
            this.a.showLoading(false);
            if (absResult != null) {
                i = absResult.getResultCode();
                str = absResult.getResultMsg();
            } else {
                str = "";
            }
            if (i != 1403) {
                YouKuTrustListener youKuTrustListener = this.a;
                youKuTrustListener.trustYouKuFail(i + "", str);
            }
        }

        @Override // com.youku.usercenter.passport.callback.ICallback
        public void onSuccess(AbsResult absResult) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1851870876")) {
                ipChange.ipc$dispatch("-1851870876", new Object[]{this, absResult});
                return;
            }
            this.a.showLoading(false);
            this.a.trustYouKuSuccess();
            LoginManager.this.F();
        }
    }

    LoginManager() {
        p();
    }

    public static synchronized void A(IPassportListener iPassportListener) {
        synchronized (LoginManager.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1107565343")) {
                ipChange.ipc$dispatch("-1107565343", new Object[]{iPassportListener});
            } else {
                zb1.c().f(iPassportListener);
            }
        }
    }

    public static synchronized void E(IPassportListener iPassportListener) {
        synchronized (LoginManager.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1567809832")) {
                ipChange.ipc$dispatch("1567809832", new Object[]{iPassportListener});
            } else {
                zb1.c().i(iPassportListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1184983593")) {
            ipChange.ipc$dispatch("-1184983593", new Object[]{this});
            return;
        }
        z20.C0(n());
        x20.g();
    }

    public static LoginManager k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1116709673")) {
            return (LoginManager) ipChange.ipc$dispatch("1116709673", new Object[0]);
        }
        if (a == null) {
            synchronized (LoginManager.class) {
                if (a == null) {
                    a = new LoginManager();
                }
            }
        }
        return a;
    }

    private void p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1782092142")) {
            ipChange.ipc$dispatch("-1782092142", new Object[]{this});
        }
    }

    public void B(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1896168693")) {
            ipChange.ipc$dispatch("1896168693", new Object[]{this, context});
        } else {
            zb1.c().g(context);
        }
    }

    public void C(ILoginListener iLoginListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-89291504")) {
            ipChange.ipc$dispatch("-89291504", new Object[]{this, iLoginListener});
        } else {
            HavanaProxy.v().Q(iLoginListener);
        }
    }

    public void D(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1122360374")) {
            ipChange.ipc$dispatch("1122360374", new Object[]{this, context});
        } else {
            zb1.c().h(context);
        }
    }

    public void G() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-908660971")) {
            ipChange.ipc$dispatch("-908660971", new Object[]{this});
        } else {
            zb1.c().l();
        }
    }

    public void b(final Context context, final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "758374053")) {
            ipChange.ipc$dispatch("758374053", new Object[]{this, context, str});
        } else if (wh2.j(str)) {
        } else {
            ThirdPartyAuthRequest thirdPartyAuthRequest = new ThirdPartyAuthRequest();
            thirdPartyAuthRequest.setTarget(str);
            thirdPartyAuthRequest.setOperator("login");
            thirdPartyAuthRequest.request(new DMMtopRequestListener<ThirdSessionModel>(ThirdSessionModel.class) { // from class: cn.damai.login.LoginManager.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str2, String str3) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-145483641")) {
                        ipChange2.ipc$dispatch("-145483641", new Object[]{this, str2, str3});
                    } else if (TextUtils.equals(ErrorConstant.ERRCODE_ANDROID_SYS_LOGIN_CANCEL, str2)) {
                    } else {
                        ToastUtil.f(str3);
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(ThirdSessionModel thirdSessionModel) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "503544737")) {
                        ipChange2.ipc$dispatch("503544737", new Object[]{this, thirdSessionModel});
                    } else if (thirdSessionModel == null) {
                    } else {
                        if (thirdSessionModel.hasAllow && !m91.a(thirdSessionModel.cookies)) {
                            DamaiCookieManager.getInstance().setCookie(str, thirdSessionModel.cookies);
                            ToastUtil.c(context, 0, R$string.toast_opening_third_h5);
                            Bundle bundle = new Bundle();
                            bundle.putString("url", str);
                            DMNav.from(context).withExtras(bundle).toUri(NavUri.b(cs.t));
                            return;
                        }
                        Bundle bundle2 = new Bundle();
                        bundle2.putSerializable(AuthLoginActivity.KEY_INFO_NEED_AUTH, thirdSessionModel);
                        bundle2.putString(AuthLoginActivity.KEY_THIRD_URL, str);
                        DMNav.from(context).withExtras(bundle2).toUri(NavUri.b(cs.w));
                    }
                }
            });
        }
    }

    public void c(ILoginListener iLoginListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2120509879")) {
            ipChange.ipc$dispatch("-2120509879", new Object[]{this, iLoginListener});
        } else {
            HavanaProxy.v().g(iLoginListener);
        }
    }

    public void d(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-857754561")) {
            ipChange.ipc$dispatch("-857754561", new Object[]{this, context});
        } else {
            HavanaProxy.v().h(context);
        }
    }

    public void e(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1309009940")) {
            ipChange.ipc$dispatch("-1309009940", new Object[]{this, context});
        } else {
            HavanaProxy.v().i(context);
        }
    }

    public void f(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "481084120")) {
            ipChange.ipc$dispatch("481084120", new Object[]{this, context});
        } else {
            HavanaProxy.v().j(context);
        }
    }

    public void g(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "911468689")) {
            ipChange.ipc$dispatch("911468689", new Object[]{this, context});
        } else {
            HavanaProxy.v().k(context);
        }
    }

    public void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1978875254")) {
            ipChange.ipc$dispatch("1978875254", new Object[]{this});
        } else {
            HavanaProxy.v().m();
        }
    }

    public void i(Context context, int i, YouKuTrustListener youKuTrustListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2061360633")) {
            ipChange.ipc$dispatch("-2061360633", new Object[]{this, context, Integer.valueOf(i), youKuTrustListener});
        } else if (youKuTrustListener == null || context == null) {
        } else {
            youKuTrustListener.showLoading(true);
            PassportManager.getInstance().uccTrustLogin("youku", null, new a(youKuTrustListener));
        }
    }

    public void j(String str, String str2, String str3, String str4, final IGetAuthCallback iGetAuthCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-677105630")) {
            ipChange.ipc$dispatch("-677105630", new Object[]{this, str, str2, str3, str4, iGetAuthCallback});
            return;
        }
        GetAuthorizationTokenRequest getAuthorizationTokenRequest = new GetAuthorizationTokenRequest();
        getAuthorizationTokenRequest.setSiteCode(str);
        getAuthorizationTokenRequest.setAction(str3);
        getAuthorizationTokenRequest.setTarget(str2);
        getAuthorizationTokenRequest.setFeature(str4);
        getAuthorizationTokenRequest.request(new DMMtopRequestListener<AuthorizationModel>(AuthorizationModel.class) { // from class: cn.damai.login.LoginManager.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str5, String str6) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-153243000")) {
                    ipChange2.ipc$dispatch("-153243000", new Object[]{this, str5, str6});
                    return;
                }
                IGetAuthCallback iGetAuthCallback2 = iGetAuthCallback;
                if (iGetAuthCallback2 != null) {
                    iGetAuthCallback2.onAuthTokenFail(str5, str6);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(AuthorizationModel authorizationModel) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "11792580")) {
                    ipChange2.ipc$dispatch("11792580", new Object[]{this, authorizationModel});
                    return;
                }
                String str5 = authorizationModel != null ? authorizationModel.token : null;
                IGetAuthCallback iGetAuthCallback2 = iGetAuthCallback;
                if (iGetAuthCallback2 != null) {
                    iGetAuthCallback2.onAuthTokenSuccess(str5);
                }
            }
        });
    }

    public int l() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2042076696") ? ((Integer) ipChange.ipc$dispatch("-2042076696", new Object[]{this})).intValue() : HavanaProxy.v().x();
    }

    public String m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1168787062")) {
            return (String) ipChange.ipc$dispatch("1168787062", new Object[]{this});
        }
        switch (HavanaProxy.v().x()) {
            case 100:
                return "普通";
            case 101:
                return "支付宝";
            case 102:
                return "手淘";
            case 103:
                return "微博";
            case 104:
                return Constants.SOURCE_QQ;
            case 105:
                return "微信";
            default:
                return "";
        }
    }

    public String n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "374306996")) {
            return (String) ipChange.ipc$dispatch("374306996", new Object[]{this});
        }
        try {
            Account account = PassportManager.getInstance().getAccount();
            if (account != null) {
                return account.mYtid;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public UserInfo o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1197975198")) {
            return (UserInfo) ipChange.ipc$dispatch("1197975198", new Object[]{this});
        }
        if (PassportManager.getInstance() != null) {
            return PassportManager.getInstance().getUserInfo();
        }
        return null;
    }

    public boolean q() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2055459181") ? ((Boolean) ipChange.ipc$dispatch("2055459181", new Object[]{this})).booleanValue() : HavanaProxy.v().A();
    }

    public boolean r() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1040360436") ? ((Boolean) ipChange.ipc$dispatch("-1040360436", new Object[]{this})).booleanValue() : HavanaProxy.v().D();
    }

    public boolean s() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-613699428") ? ((Boolean) ipChange.ipc$dispatch("-613699428", new Object[]{this})).booleanValue() : zb1.c().d();
    }

    public void t(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-900729859")) {
            ipChange.ipc$dispatch("-900729859", new Object[]{this, context});
        } else {
            zb1.c().e(context);
        }
    }

    public void u() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-128033640")) {
            ipChange.ipc$dispatch("-128033640", new Object[]{this});
            return;
        }
        HavanaProxy.v().G();
        G();
    }

    public void v(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-545437248")) {
            ipChange.ipc$dispatch("-545437248", new Object[]{this, context});
        } else if (context == null) {
        } else {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.putExtra(ACTION_DO_LOGIN, 0);
            DMNav.from(context).withFlags(268435456).withExtras(intent.getExtras()).toUri(NavUri.b(cs.v));
        }
    }

    public void w(Context context, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1524133507")) {
            ipChange.ipc$dispatch("-1524133507", new Object[]{this, context, intent});
        } else if (context == null || intent == null) {
        } else {
            intent.putExtra(ACTION_DO_LOGIN, 0);
            DMNav.from(context).withExtras(intent.getExtras()).toUri(NavUri.b(cs.v));
        }
    }

    public void x(Activity activity, Intent intent, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1886553848")) {
            ipChange.ipc$dispatch("1886553848", new Object[]{this, activity, intent, Integer.valueOf(i)});
        } else if (activity == null || intent == null) {
        } else {
            intent.putExtra(ACTION_DO_LOGIN, 0);
            DMNav.from(activity).forResult(i).withExtras(intent.getExtras()).toUri(NavUri.b(cs.v));
        }
    }

    public void y(Fragment fragment, Intent intent, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1646574354")) {
            ipChange.ipc$dispatch("1646574354", new Object[]{this, fragment, intent, Integer.valueOf(i)});
        } else if (fragment == null || intent == null) {
        } else {
            intent.putExtra(ACTION_DO_LOGIN, 0);
            intent.setClassName(fragment.getContext(), "cn.damai.login.havana.LoginActivity");
            fragment.startActivityForResult(intent, i);
        }
    }

    public void z(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2075962615")) {
            ipChange.ipc$dispatch("-2075962615", new Object[]{this, context});
        } else {
            HavanaProxy.v().L(context);
        }
    }
}
