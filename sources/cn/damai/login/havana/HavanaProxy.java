package cn.damai.login.havana;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Fragment;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.CompliantUtUtils;
import cn.damai.common.util.ToastUtil;
import cn.damai.h5container.DamaiCookieManager;
import cn.damai.wxapi.WXEntryActivity;
import com.ali.user.mobile.common.api.AliUserLogin;
import com.ali.user.mobile.common.api.LoginApprearanceExtensions;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.mobile.login.ui.BaseFaceLoginFragment;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.Site;
import com.ali.user.open.core.util.ParamsConstants;
import com.ali.user.open.jsbridge.UccJsBridge;
import com.ali.user.open.oauth.OauthService;
import com.ali.user.open.oauth.OauthServiceProviderFactory;
import com.ali.user.open.ucc.UccCallback;
import com.ali.user.open.ucc.UccService;
import com.ali.user.open.ucc.webview.UccSystemJSBridge;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.sns4android.SNSAuth;
import com.taobao.android.sns4android.SNSConfig;
import com.taobao.android.sns4android.SNSPlatform;
import com.taobao.android.sns4android.jsbridge.TbAuthJsBridge;
import com.taobao.login4android.Login;
import com.taobao.login4android.broadcast.LoginAction;
import com.taobao.login4android.broadcast.LoginBroadcastHelper;
import com.taobao.login4android.constants.LoginConstants;
import com.taobao.login4android.session.ISession;
import com.taobao.login4android.session.SessionManager;
import com.taobao.login4android.session.constants.SessionConstants;
import com.tencent.tauth.Tencent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import mtopsdk.mtop.util.ErrorConstant;
import org.json.JSONObject;
import tb.ew0;
import tb.mm2;
import tb.mu0;
import tb.nk1;
import tb.vb1;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class HavanaProxy {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static int d = 100;
    private static String e = "";
    private static boolean f;
    private static HavanaProxy g;
    private BroadcastReceiver a;
    private Context b;
    private List<ILoginListener> c = new ArrayList();

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface UccTrustLoginListener {
        void onFail();

        void onSuccess();
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.login.havana.HavanaProxy$a */
    /* loaded from: classes5.dex */
    public class C1335a extends LoginApprearanceExtensions {
        private static transient /* synthetic */ IpChange $ipChange;

        C1335a(HavanaProxy havanaProxy) {
        }

        @Override // com.ali.user.mobile.common.api.LoginApprearanceExtensions
        public boolean needCountryModule() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1545265384")) {
                return ((Boolean) ipChange.ipc$dispatch("-1545265384", new Object[]{this})).booleanValue();
            }
            return true;
        }

        @Override // com.ali.user.mobile.common.api.LoginApprearanceExtensions
        public boolean needHelp() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1838764791")) {
                return ((Boolean) ipChange.ipc$dispatch("1838764791", new Object[]{this})).booleanValue();
            }
            return false;
        }

        @Override // com.ali.user.mobile.ui.widget.WidgetExtension
        public boolean needLoginBackButton() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1657312568")) {
                return ((Boolean) ipChange.ipc$dispatch("1657312568", new Object[]{this})).booleanValue();
            }
            return true;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.login.havana.HavanaProxy$b */
    /* loaded from: classes5.dex */
    public class C1336b implements UccCallback {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ UccTrustLoginListener a;

        C1336b(HavanaProxy havanaProxy, UccTrustLoginListener uccTrustLoginListener) {
            this.a = uccTrustLoginListener;
        }

        @Override // com.ali.user.open.ucc.UccCallback
        public void onFail(String str, int i, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-28416845")) {
                ipChange.ipc$dispatch("-28416845", new Object[]{this, str, Integer.valueOf(i), str2});
                return;
            }
            UccTrustLoginListener uccTrustLoginListener = this.a;
            if (uccTrustLoginListener != null) {
                uccTrustLoginListener.onFail();
            }
        }

        @Override // com.ali.user.open.ucc.UccCallback
        public void onSuccess(String str, Map map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1042996382")) {
                ipChange.ipc$dispatch("-1042996382", new Object[]{this, str, map});
                return;
            }
            UccTrustLoginListener uccTrustLoginListener = this.a;
            if (uccTrustLoginListener != null) {
                uccTrustLoginListener.onSuccess();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.login.havana.HavanaProxy$c */
    /* loaded from: classes15.dex */
    static /* synthetic */ class C1337c {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LoginAction.values().length];
            a = iArr;
            try {
                iArr[LoginAction.NOTIFY_LOGIN_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LoginAction.NOTIFY_LOGIN_CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[LoginAction.NOTIFY_LOGIN_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[LoginAction.NOTIFY_LOGOUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    HavanaProxy() {
    }

    private boolean C() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1840525487")) {
            return ((Boolean) ipChange.ipc$dispatch("1840525487", new Object[]{this})).booleanValue();
        }
        SharedPreferences sharedPreferences = mu0.a().getSharedPreferences(SessionManager.USERINFO, 4);
        String string = sharedPreferences.getString("sid", "");
        String string2 = sharedPreferences.getString(SessionConstants.SUBSID, "");
        return (!(!TextUtils.isEmpty(string) && ((System.currentTimeMillis() / 1000) > sharedPreferences.getLong(SessionConstants.SESSION_EXPIRED_TIME, 0L) ? 1 : ((System.currentTimeMillis() / 1000) == sharedPreferences.getLong(SessionConstants.SESSION_EXPIRED_TIME, 0L) ? 0 : -1)) < 0) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(z20.q())) ? false : true;
    }

    private void F() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-578223196")) {
            ipChange.ipc$dispatch("-578223196", new Object[]{this});
        } else {
            Login.login(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "371674048")) {
            ipChange.ipc$dispatch("371674048", new Object[]{this});
            return;
        }
        l();
        for (ILoginListener iLoginListener : this.c) {
            if (iLoginListener != null) {
                iLoginListener.onLoginCancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1250667996")) {
            ipChange.ipc$dispatch("1250667996", new Object[]{this});
            return;
        }
        if (this.b != null) {
            ToastUtil.i(ErrorConstant.ERRMSG_ANDROID_SYS_LOGIN_FAIL);
        }
        l();
        for (ILoginListener iLoginListener : this.c) {
            if (iLoginListener != null) {
                iLoginListener.onLoginFail();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "311013421")) {
            ipChange.ipc$dispatch("311013421", new Object[]{this});
            return;
        }
        S();
        for (ILoginListener iLoginListener : this.c) {
            if (iLoginListener != null) {
                iLoginListener.onLoginSuccess();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1068835453")) {
            ipChange.ipc$dispatch("1068835453", new Object[]{this});
            return;
        }
        l();
        for (ILoginListener iLoginListener : this.c) {
            if (iLoginListener != null) {
                iLoginListener.onLogout();
            }
        }
    }

    private void M() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "748676200")) {
            ipChange.ipc$dispatch("748676200", new Object[]{this});
            return;
        }
        WVPluginManager.registerPlugin("aluTbAuthJSBridge", (Class<? extends WVApiPlugin>) TbAuthJsBridge.class);
        WVPluginManager.registerPlugin(UccSystemJSBridge.ALU_SYSTEM_JSBRIDGE, (Class<? extends WVApiPlugin>) UccJsBridge.class);
    }

    private void S() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1392062673")) {
            ipChange.ipc$dispatch("-1392062673", new Object[]{this});
            return;
        }
        z20.r0(Login.getSubSid());
        String userId = Login.getUserId();
        z20.k0(userId);
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(Login.getExtJson()).getString("damaiExt"));
            String string = jSONObject.getString("damaiUserId");
            z20.T(Login.getHeadPicLink(), jSONObject.getString("headImageUrl"));
            if (!TextUtils.isEmpty(string)) {
                z20.x0(string);
                vb1.a(string);
                vb1.b(string);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        String loginPhone = Login.getLoginPhone();
        if (loginPhone != null && loginPhone.length() > 3) {
            z20.b0(true);
        }
        C0529c.e().E(loginPhone, userId);
        CompliantUtUtils.c(userId);
    }

    private void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1049632829")) {
            ipChange.ipc$dispatch("-1049632829", new Object[]{this});
            return;
        }
        z20.r0("");
        DamaiCookieManager.getInstance().removeAllCookie();
        z20.x0("");
        z20.k0("");
    }

    private void t() {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1402636781")) {
            ipChange.ipc$dispatch("-1402636781", new Object[]{this});
            return;
        }
        String x = z20.x();
        if (!TextUtils.isEmpty(x) && !A()) {
            Bundle bundle = new Bundle();
            bundle.putString(LoginConstant.OUTTER_LOGIN_TOKEN, x);
            bundle.putString(LoginConstant.OUTTER_LOGIN_TOKEN_TYPE, "damai");
            Login.login(false, bundle);
            z20.s0("");
            return;
        }
        if ((TextUtils.isEmpty(Login.getSid()) || Login.checkSessionValid()) ? false : false) {
            Login.login(false);
        } else {
            m();
        }
    }

    public static HavanaProxy v() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1808478157")) {
            return (HavanaProxy) ipChange.ipc$dispatch("-1808478157", new Object[0]);
        }
        if (g == null) {
            synchronized (HavanaProxy.class) {
                if (g == null) {
                    g = new HavanaProxy();
                }
            }
        }
        return g;
    }

    private void z() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "823333465")) {
            ipChange.ipc$dispatch("823333465", new Object[]{this});
            return;
        }
        C1335a c1335a = new C1335a(this);
        c1335a.setNeedHelp(false);
        c1335a.setFullyCustomizeMobileLoginFragment(DamaiHavanaFragment.class);
        c1335a.setFullyCustomizeLoginFragment(DamaiAccountLoginFragment.class);
        c1335a.setFullyCustomizeMobileRegisterFragment(DamaiRegisterFragment.class);
        c1335a.setFullyCustomizeGuideFragment(DamaiGuideFragment.class);
        c1335a.setFullyCustomizedFaceLoginFragment(BaseFaceLoginFragment.class);
        c1335a.setDialogHelper(HavanaDialogHelper.class);
        AliUserLogin.setLoginAppreanceExtions(c1335a);
    }

    public boolean A() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "708713138")) {
            return ((Boolean) ipChange.ipc$dispatch("708713138", new Object[]{this})).booleanValue();
        }
        boolean checkSessionValid = Login.checkSessionValid();
        String subSid = Login.getSubSid();
        String q = z20.q();
        String i = z20.i();
        if (f) {
            return (!checkSessionValid || TextUtils.isEmpty(subSid) || TextUtils.isEmpty(q) || TextUtils.isEmpty(i)) ? false : true;
        }
        return C();
    }

    public boolean B(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-82343301")) {
            return ((Boolean) ipChange.ipc$dispatch("-82343301", new Object[]{this, str})).booleanValue();
        }
        OauthService oauthService = (OauthService) AliMemberSDK.getService(OauthService.class);
        return oauthService != null && oauthService.isLoginUrl("taobao", str);
    }

    public boolean D() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-371944687") ? ((Boolean) ipChange.ipc$dispatch("-371944687", new Object[]{this})).booleanValue() : d != 100;
    }

    public void E(Context context, ILoginListener iLoginListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-705759832")) {
            ipChange.ipc$dispatch("-705759832", new Object[]{this, context, iLoginListener});
            return;
        }
        Log.d("damai-login", "HavanaProxy.login()");
        l();
        if (!f) {
            ToastUtil.i("登录组件初始化错误");
            return;
        }
        N();
        ISession iSession = Login.session;
        if (iSession != null) {
            iSession.clearSessionInfo();
            Login.session.clearAutoLoginInfo();
        }
        F();
    }

    public void G() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-448571725")) {
            ipChange.ipc$dispatch("-448571725", new Object[]{this});
            return;
        }
        vb1.d();
        vb1.c();
        l();
        Login.logout();
    }

    public void L(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "807264270")) {
            ipChange.ipc$dispatch("807264270", new Object[]{this, context});
        } else if (context == null) {
        } else {
            if (this.b != context) {
                R();
            }
            this.b = context;
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: cn.damai.login.havana.HavanaProxy.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1436836022")) {
                        ipChange2.ipc$dispatch("-1436836022", new Object[]{this, context2, intent});
                    } else if (intent == null) {
                    } else {
                        String action = intent.getAction();
                        String unused = HavanaProxy.e = intent.getStringExtra(LoginConstants.LOGIN_FAIL_REASON);
                        TLogAdapter.e("Login.DemoBroadcastReceiver", "ref=" + intent.getStringExtra(LoginConstants.BROWSER_REF_URL) + ", onReceive| action : " + action);
                        LoginAction valueOf = LoginAction.valueOf(action);
                        if (valueOf == null) {
                            return;
                        }
                        ew0 f2 = ew0.f();
                        int x = HavanaProxy.this.x();
                        f2.l(x, action + AltriaXLaunchTime.SPACE + HavanaProxy.e);
                        int i = C1337c.a[valueOf.ordinal()];
                        if (i == 1) {
                            HavanaProxy.this.J();
                        } else if (i == 2) {
                            HavanaProxy.this.H();
                        } else if (i == 3) {
                            HavanaProxy.this.I();
                        } else if (i != 4) {
                        } else {
                            HavanaProxy.this.K();
                        }
                    }
                }
            };
            this.a = broadcastReceiver;
            LoginBroadcastHelper.registerLoginReceiver(context, broadcastReceiver);
            z();
            y();
            M();
            t();
            f = true;
        }
    }

    public void N() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-869379650")) {
            ipChange.ipc$dispatch("-869379650", new Object[]{this});
        } else {
            O(100);
        }
    }

    public void O(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "986199975")) {
            ipChange.ipc$dispatch("986199975", new Object[]{this, Integer.valueOf(i)});
        } else {
            d = i;
        }
    }

    public void P(Activity activity, UccTrustLoginListener uccTrustLoginListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1153803379")) {
            ipChange.ipc$dispatch("-1153803379", new Object[]{this, activity, uccTrustLoginListener});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ParamsConstants.Key.PARAM_H5ONLY, "1");
        ((UccService) AliMemberSDK.getService(UccService.class)).trustLogin(activity, "taobao", hashMap, new C1336b(this, uccTrustLoginListener));
    }

    public void Q(ILoginListener iLoginListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1092686571")) {
            ipChange.ipc$dispatch("1092686571", new Object[]{this, iLoginListener});
        } else if (iLoginListener == null) {
        } else {
            this.c.remove(iLoginListener);
        }
    }

    public void R() {
        BroadcastReceiver broadcastReceiver;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-177389887")) {
            ipChange.ipc$dispatch("-177389887", new Object[]{this});
            return;
        }
        Context context = this.b;
        if (context == null || (broadcastReceiver = this.a) == null) {
            return;
        }
        LoginBroadcastHelper.unregisterLoginReceiver(context, broadcastReceiver);
        this.c.clear();
        this.a = null;
        this.b = null;
    }

    public void g(ILoginListener iLoginListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1010901276")) {
            ipChange.ipc$dispatch("-1010901276", new Object[]{this, iLoginListener});
        } else if (iLoginListener == null || this.c.contains(iLoginListener)) {
        } else {
            this.c.add(iLoginListener);
        }
    }

    public void h(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1672034342")) {
            ipChange.ipc$dispatch("-1672034342", new Object[]{this, context});
        } else {
            Login.navByScene(context, "h5EmailBind");
        }
    }

    public void i(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2147135687")) {
            ipChange.ipc$dispatch("2147135687", new Object[]{this, context});
        } else {
            Login.navByScene(context, "h5EmailModify");
        }
    }

    public void j(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "247416157")) {
            ipChange.ipc$dispatch("247416157", new Object[]{this, context});
        } else {
            Login.navByScene(context, "changeMobile");
        }
    }

    public void k(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-305144362")) {
            ipChange.ipc$dispatch("-305144362", new Object[]{this, context});
        } else {
            Login.navByScene(context, "changePassword");
        }
    }

    public void m() {
        ISession iSession;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1170633147")) {
            ipChange.ipc$dispatch("1170633147", new Object[]{this});
        } else if (!A() || (iSession = Login.session) == null || iSession.getSessionExpiredTime() == 0) {
        } else {
            if (System.currentTimeMillis() / 1000 < Login.session.getSessionExpiredTime() - 7200) {
                return;
            }
            Login.login(false);
        }
    }

    public void n(Fragment fragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1821624303")) {
            ipChange.ipc$dispatch("-1821624303", new Object[]{this, fragment});
        } else if (fragment == null || fragment.getActivity() == null) {
        } else {
            try {
                SNSAuth.signIn(SNSPlatform.PLATFORM_ALIPAY, fragment.getActivity());
                O(101);
            } catch (Throwable th) {
                th.printStackTrace();
                ToastUtil.i("支付宝登录组件错误，请重新登录");
            }
        }
    }

    public void o(Fragment fragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "116223847")) {
            ipChange.ipc$dispatch("116223847", new Object[]{this, fragment});
        } else if (fragment == null || fragment.getActivity() == null) {
        } else {
            if (!mm2.c().d("com.tencent.mobileqq")) {
                ToastUtil.i("暂未安装QQ，请使用其他方式登录");
                return;
            }
            try {
                Tencent.setIsPermissionGranted(true);
                SNSAuth.signIn(SNSPlatform.PLATFORM_QQ, fragment.getActivity());
                O(104);
            } catch (Throwable th) {
                th.printStackTrace();
                ToastUtil.i("QQ登录组件错误，请重新登录");
            }
        }
    }

    public void p(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "633458095")) {
            ipChange.ipc$dispatch("633458095", new Object[]{this, activity});
        } else if (activity == null) {
        } else {
            try {
                SNSAuth.uccOAuthLogin(activity, SNSPlatform.PLATFORM_TAOBAO);
                O(102);
            } catch (Throwable th) {
                th.printStackTrace();
                ToastUtil.i("手淘登录组件错误，请重新登录");
            }
        }
    }

    public void q(Fragment fragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-465177835")) {
            ipChange.ipc$dispatch("-465177835", new Object[]{this, fragment});
        } else if (fragment == null || fragment.getActivity() == null) {
        } else {
            try {
                SNSAuth.uccOAuthLogin(fragment.getActivity(), SNSPlatform.PLATFORM_TAOBAO);
                O(102);
            } catch (Throwable th) {
                th.printStackTrace();
                ToastUtil.i("手淘登录组件错误，请重新登录");
            }
        }
    }

    public void r(Fragment fragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1353778601")) {
            ipChange.ipc$dispatch("1353778601", new Object[]{this, fragment});
            return;
        }
        try {
            SNSAuth.signIn(SNSPlatform.PLATFORM_WEIBO, fragment.getActivity());
            O(103);
        } catch (Throwable th) {
            th.printStackTrace();
            ToastUtil.i("微博登录组件错误，请重新登录");
        }
    }

    public void s(Fragment fragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1271803977")) {
            ipChange.ipc$dispatch("1271803977", new Object[]{this, fragment});
        } else if (fragment == null || fragment.getActivity() == null) {
        } else {
            if (!mm2.c().d("com.tencent.mm")) {
                ToastUtil.i("暂未安装微信，请使用其他方式登录");
                return;
            }
            try {
                SNSAuth.signIn(SNSPlatform.PLATFORM_WEIXIN, fragment.getActivity());
                WXEntryActivity.setWXType(1);
                O(105);
            } catch (Throwable th) {
                th.printStackTrace();
                ToastUtil.i("微信登录组件错误，请重新登录");
            }
        }
    }

    public String u() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1806810677") ? (String) ipChange.ipc$dispatch("-1806810677", new Object[]{this}) : e;
    }

    public String w() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1976260232") ? (String) ipChange.ipc$dispatch("-1976260232", new Object[]{this}) : Login.getLoginPhone();
    }

    public int x() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1571677245") ? ((Integer) ipChange.ipc$dispatch("-1571677245", new Object[]{this})).intValue() : d;
    }

    public void y() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-387563261")) {
            ipChange.ipc$dispatch("-387563261", new Object[]{this});
            return;
        }
        SNSAuth.init(SNSPlatform.PLATFORM_WEIXIN, mm2.c().k(), mm2.c().l());
        SNSAuth.init(SNSPlatform.PLATFORM_QQ, mm2.c().f(), mm2.c().g());
        SNSAuth.init(SNSPlatform.PLATFORM_WEIBO, mm2.c().h(), mm2.c().i(), mm2.j());
        SNSAuth.init(SNSPlatform.PLATFORM_TAOBAO, "", "", "");
        SNSConfig sNSConfig = new SNSConfig();
        sNSConfig.app_id = "2015122801047887";
        sNSConfig.pid = "2088301101387851";
        sNSConfig.sign_type = "RSA";
        sNSConfig.target_id = "61ef37122e104d148c855d14e9bf90e2";
        sNSConfig.platform = SNSPlatform.PLATFORM_ALIPAY;
        sNSConfig.scope = "auth_user";
        SNSAuth.init(sNSConfig);
        OauthServiceProviderFactory.getInstance().putOauthServiceProvider(Site.WEIBO, new nk1());
    }
}
