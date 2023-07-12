package cn.damai.mine.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.AppConfig;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.model.CertificationInfoBean;
import cn.damai.commonbusiness.model.UserBaseInfoBean;
import cn.damai.commonbusiness.model.UserData;
import cn.damai.commonbusiness.model.UserMemberInfo;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.im.UserInfoUtil;
import cn.damai.im.request.PersonalInfoRequest;
import cn.damai.login.LoginManager;
import cn.damai.login.havana.HavanaProxy;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.wxapi.WXEntryActivity;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.model.TokenType;
import com.ali.user.mobile.model.UrlParam;
import com.ali.user.mobile.service.NavigatorService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.callback.MemberCallback;
import com.ali.user.open.ucc.UccService;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.sns4android.SNSAuth;
import com.taobao.android.sns4android.bind.SNSBind;
import com.taobao.login4android.session.SessionManager;
import com.tencent.tauth.Tencent;
import tb.cm2;
import tb.cs;
import tb.k23;
import tb.kg2;
import tb.uf1;
import tb.uh1;
import tb.vf1;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class AccountSafeActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private RelativeLayout accountSettingly;
    RelativeLayout accountUnRegister;
    private CertificationInfoBean certificationInfoBean;
    private ImageView icon_real;
    private RelativeLayout mMemberLayout;
    private View mMemberLine;
    private TextView mMemberStatus;
    private TextView mMemberTip;
    private TextView mMemberTitle;
    private TextView mTitleTV;
    private DMIconFontTextView mTvTitleBack;
    private UserData mUserData;
    RelativeLayout ray_bind_phone;
    RelativeLayout ray_login_pw;
    RelativeLayout ray_pay_pw;
    private RelativeLayout realNameLayout;
    private TextView tv_email;
    private TextView tv_phone;
    private TextView tv_real_name;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.activity.AccountSafeActivity$a */
    /* loaded from: classes6.dex */
    public class C1355a implements UserInfoUtil.OnUserInfoListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1355a() {
        }

        @Override // cn.damai.im.UserInfoUtil.OnUserInfoListener
        public void onFailed(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1450171364")) {
                ipChange.ipc$dispatch("1450171364", new Object[]{this, str, str2});
            } else if (TextUtils.isEmpty(str2)) {
            } else {
                AccountSafeActivity.this.accountSettingly.setTag(null);
                ToastUtil.i(str2);
            }
        }

        @Override // cn.damai.im.UserInfoUtil.OnUserInfoListener
        public void onSuccess(UserData userData) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-603518075")) {
                ipChange.ipc$dispatch("-603518075", new Object[]{this, userData});
            } else {
                AccountSafeActivity.this.fetchUserDataSuccess(userData);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.activity.AccountSafeActivity$b */
    /* loaded from: classes15.dex */
    public class DialogInterface$OnClickListenerC1356b implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        DialogInterface$OnClickListenerC1356b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "12256049")) {
                ipChange.ipc$dispatch("12256049", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            C0529c.e().x(vf1.x().l());
            AccountSafeActivity.this.setTencentPermissionAndOpenAuth();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.activity.AccountSafeActivity$c */
    /* loaded from: classes15.dex */
    public class DialogInterface$OnClickListenerC1357c implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        DialogInterface$OnClickListenerC1357c(AccountSafeActivity accountSafeActivity) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "981837072")) {
                ipChange.ipc$dispatch("981837072", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else {
                C0529c.e().x(vf1.x().k());
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.activity.AccountSafeActivity$d */
    /* loaded from: classes6.dex */
    public class C1358d implements MemberCallback<String> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        C1358d(String str) {
            this.a = str;
        }

        @Override // com.ali.user.open.core.callback.MemberCallback
        /* renamed from: a */
        public void onSuccess(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1983051393")) {
                ipChange.ipc$dispatch("1983051393", new Object[]{this, str});
                return;
            }
            SessionManager sessionManager = SessionManager.getInstance(DataProviderFactory.getApplicationContext());
            if (sessionManager != null && !TextUtils.isEmpty(sessionManager.getUserId())) {
                try {
                    AccountSafeActivity.newManageUrl(str, this.a);
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    AccountSafeActivity.newManageUrl(str, this.a);
                    return;
                }
            }
            AccountSafeActivity.newManageUrl(str, this.a);
        }

        @Override // com.ali.user.open.core.callback.FailureCallback
        public void onFailure(int i, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1485975939")) {
                ipChange.ipc$dispatch("-1485975939", new Object[]{this, Integer.valueOf(i), str});
            } else {
                SNSAuth.toastBusy(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchUserDataSuccess(UserData userData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "782473494")) {
            ipChange.ipc$dispatch("782473494", new Object[]{this, userData});
            return;
        }
        CertificationInfoBean certificationBaseInfo = userData.getCertificationBaseInfo();
        UserBaseInfoBean userBaseInfo = userData.getUserBaseInfo();
        UserMemberInfo memberInfo = userData.getMemberInfo();
        if (memberInfo != null) {
            this.accountSettingly.setTag(memberInfo.getThirdConfigDialogTip());
            this.mMemberLayout.setVisibility(0);
            this.mMemberLine.setVisibility(0);
            this.mMemberTitle.setText(getMemberContent(memberInfo.getMemberTitle(), "淘麦VIP会员"));
            this.mMemberStatus.setText(getMemberContent(memberInfo.getMemberStatusDesc(), ""));
            this.mMemberTip.setText(getMemberContent(memberInfo.getMemberTip(), ""));
            findViewById(R$id.rv_max_vip).setOnClickListener(this);
            vf1.x().n0(this.mMemberTitle);
        }
        if (certificationBaseInfo == null || userBaseInfo == null) {
            return;
        }
        this.certificationInfoBean = certificationBaseInfo;
        this.mUserData = userData;
        if (!TextUtils.isEmpty(userBaseInfo.getMaskMobile())) {
            this.tv_phone.setText(userBaseInfo.getMaskMobile());
        }
        if (!TextUtils.isEmpty(certificationBaseInfo.getAccountVerifyMsg())) {
            this.tv_real_name.setText(certificationBaseInfo.getAccountVerifyMsg());
        }
        if (!TextUtils.isEmpty(userBaseInfo.getMaskEmail())) {
            this.tv_email.setText(userBaseInfo.getMaskEmail());
        } else {
            this.tv_email.setText("设置邮箱");
        }
        int parseInt = Integer.parseInt(certificationBaseInfo.getAccountVerifyCode());
        if (parseInt == 1) {
            this.icon_real.setImageResource(R$drawable.realname_noauth);
            this.icon_real.setVisibility(0);
        } else if (parseInt == 2) {
            this.icon_real.setImageResource(R$drawable.realname_auth_success);
            this.icon_real.setVisibility(0);
        } else if (parseInt == 3) {
            this.icon_real.setImageResource(R$drawable.realname_gotoauthface);
            this.icon_real.setVisibility(0);
        } else if (parseInt == 4) {
            this.icon_real.setImageResource(R$drawable.realname_verifing);
            this.icon_real.setVisibility(0);
        } else if (parseInt == 5) {
            this.icon_real.setImageResource(R$drawable.realname_auth_failed);
            this.icon_real.setVisibility(0);
        }
    }

    private void getAuthStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "460944507")) {
            ipChange.ipc$dispatch("460944507", new Object[]{this});
        } else if (LoginManager.k().q()) {
            PersonalInfoRequest personalInfoRequest = new PersonalInfoRequest();
            personalInfoRequest.needUserBaseInfo = "true";
            personalInfoRequest.needCertificationBaseInfo = "true";
            personalInfoRequest.canAcceptDelay = "false";
            UserInfoUtil.b(personalInfoRequest, new C1355a());
        }
    }

    private String getMemberContent(String str, String str2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1827310646") ? (String) ipChange.ipc$dispatch("1827310646", new Object[]{this, str, str2}) : !TextUtils.isEmpty(str) ? str : str2;
    }

    private void gotoAuth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "262195572")) {
            ipChange.ipc$dispatch("262195572", new Object[]{this});
            return;
        }
        CertificationInfoBean certificationInfoBean = this.certificationInfoBean;
        if (certificationInfoBean != null) {
            int parseInt = Integer.parseInt(certificationInfoBean.getAccountVerifyCode());
            if (parseInt == 1) {
                Bundle bundle = new Bundle();
                bundle.putBoolean(TokenType.LOGIN, false);
                DMNav.from(this).withExtras(bundle).toUri(NavUri.b("nameauth"));
            } else if (parseInt == 2 || parseInt == 3) {
                DMNav.from(this).toUri(NavUri.b("realname_auth_result"));
            } else if (parseInt == 4) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt(RealNameAuthErrorActivity.REALNAME_AUTH_ERROR_TAG, 3);
                DMNav.from(this).withExtras(bundle2).toUri(NavUri.b("realname_error"));
            } else if (parseInt == 5) {
                gotoRealNameFaceVerifyFailedPage();
            }
        }
    }

    private void gotoRealNameFaceVerifyFailedPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-176854511")) {
            ipChange.ipc$dispatch("-176854511", new Object[]{this});
            return;
        }
        Intent intent = new Intent(this, RealNameFaceVerifyFailedActivity.class);
        intent.putExtra("failedType", this.certificationInfoBean.getFaceVerifyFailedType());
        startActivity(intent);
    }

    private void initBindEmailLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-869727022")) {
            ipChange.ipc$dispatch("-869727022", new Object[]{this});
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R$id.email_set);
        if (uf1.a().b()) {
            relativeLayout.setVisibility(0);
            relativeLayout.setOnClickListener(this);
            return;
        }
        relativeLayout.setVisibility(8);
    }

    private void initMemberLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-4285205")) {
            ipChange.ipc$dispatch("-4285205", new Object[]{this});
            return;
        }
        this.mMemberLine = findViewById(R$id.rv_max_vip_line);
        this.mMemberLayout = (RelativeLayout) findViewById(R$id.rv_max_vip);
        this.mMemberTitle = (TextView) findViewById(R$id.tv_max_vip_title);
        this.mMemberStatus = (TextView) findViewById(R$id.tv_max_vip_state);
        this.mMemberTip = (TextView) findViewById(R$id.tv_max_vip_tip);
        this.mMemberLayout.setVisibility(8);
        this.mMemberLine.setVisibility(8);
    }

    private void initThirdAccoutLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1577075491")) {
            ipChange.ipc$dispatch("-1577075491", new Object[]{this});
            return;
        }
        this.accountSettingly = (RelativeLayout) findViewById(R$id.third_account_setting_layout);
        if (uf1.a().d()) {
            this.accountSettingly.setVisibility(0);
            this.accountSettingly.setTag(null);
            this.accountSettingly.setOnClickListener(this);
            HavanaProxy.v().y();
            WXEntryActivity.setWXType(1);
            return;
        }
        this.accountSettingly.setVisibility(8);
    }

    private void initTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "6613251")) {
            ipChange.ipc$dispatch("6613251", new Object[]{this});
            return;
        }
        hideBaseLayout();
        this.mTvTitleBack = (DMIconFontTextView) findViewById(R$id.mine_title_left_icon_font_tv);
        TextView textView = (TextView) findViewById(R$id.mine_title_tv);
        this.mTitleTV = textView;
        textView.setText("账户安全");
        this.mTvTitleBack.setOnClickListener(this);
        setImmersionStyle();
    }

    protected static void newManageUrl(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1967507529")) {
            ipChange.ipc$dispatch("1967507529", new Object[]{str, str2});
            return;
        }
        String str3 = str2 + "&site=" + AliMemberSDK.getMasterSite() + "&request_token=" + str;
        UrlParam urlParam = new UrlParam();
        urlParam.url = str3;
        if (ServiceFactory.getService(NavigatorService.class) != null) {
            ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).openWebViewPage(DataProviderFactory.getApplicationContext(), urlParam);
        }
    }

    public static void openAuthManagerPage() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-142407679")) {
            ipChange.ipc$dispatch("-142407679", new Object[0]);
            return;
        }
        uh1.a();
        if (DataProviderFactory.getDataProvider().getEnvType() == 1) {
            str = "https://market.wapa.taobao.com/app/vip/ucc/pages/bind_manage?env=daily";
        } else {
            str = DataProviderFactory.getDataProvider().getEnvType() == 2 ? "https://market.wapa.taobao.com/app/vip/ucc/pages/bind_manage?env=pre" : "https://market.m.taobao.com/app/vip/ucc/pages/bind_manage?";
        }
        if (((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider() != null) {
            ((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider().getUserToken("", new C1358d(str));
        } else {
            SNSAuth.toastBusy("data provider为空");
        }
    }

    private void registerListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1623555800")) {
            ipChange.ipc$dispatch("-1623555800", new Object[]{this});
            return;
        }
        this.ray_bind_phone.setOnClickListener(this);
        this.ray_login_pw.setOnClickListener(this);
        this.ray_pay_pw.setOnClickListener(this);
        this.realNameLayout.setOnClickListener(this);
        this.accountUnRegister.setOnClickListener(this);
    }

    private void setEmail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1767994469")) {
            ipChange.ipc$dispatch("1767994469", new Object[]{this});
            return;
        }
        UserData userData = this.mUserData;
        if (userData == null || userData.getUserBaseInfo() == null) {
            return;
        }
        if (TextUtils.isEmpty(this.mUserData.getUserBaseInfo().getMaskEmail())) {
            LoginManager.k().d(this);
        } else {
            LoginManager.k().e(this);
        }
    }

    private void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1245788835")) {
            ipChange.ipc$dispatch("1245788835", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.title_bar_space);
        if (Build.VERSION.SDK_INT >= 23) {
            if (findViewById != null) {
                findViewById.getLayoutParams().height = kg2.a(this);
                findViewById.setVisibility(0);
            }
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
            return;
        }
        kg2.f(this, false, R$color.black);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTencentPermissionAndOpenAuth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-358742700")) {
            ipChange.ipc$dispatch("-358742700", new Object[]{this});
            return;
        }
        try {
            Tencent.setIsPermissionGranted(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        SNSBind.openAuthManagerPage();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2098854695")) {
            ipChange.ipc$dispatch("2098854695", new Object[]{this, Integer.valueOf(i)});
        } else {
            finish();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "26597987") ? ((Integer) ipChange.ipc$dispatch("26597987", new Object[]{this})).intValue() : R$layout.account_safe_activity;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1037461128")) {
            ipChange.ipc$dispatch("-1037461128", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-725662797")) {
            ipChange.ipc$dispatch("-725662797", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "791805706")) {
            ipChange.ipc$dispatch("791805706", new Object[]{this});
            return;
        }
        hideBaseLayout();
        this.ray_bind_phone = (RelativeLayout) findViewById(R$id.ray_bind_phone);
        this.ray_login_pw = (RelativeLayout) findViewById(R$id.ray_login_pw);
        this.ray_pay_pw = (RelativeLayout) findViewById(R$id.ray_pay_pw);
        this.accountUnRegister = (RelativeLayout) findViewById(R$id.to_un_register_page);
        this.tv_phone = (TextView) findViewById(R$id.tv_phone);
        this.tv_real_name = (TextView) findViewById(R$id.tv_real_name);
        this.tv_email = (TextView) findViewById(R$id.tv_email);
        this.icon_real = (ImageView) findViewById(R$id.icon_real);
        this.realNameLayout = (RelativeLayout) findViewById(R$id.rl_real_name);
        initTitle();
        registerListener();
        uf1.a().f();
        uf1.a().e();
        initThirdAccoutLayout();
        initBindEmailLayout();
        initMemberLayout();
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "67320432")) {
            ipChange.ipc$dispatch("67320432", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.ray_bind_phone) {
            String b = cm2.b(this, R$string.damai_usercenter_phone_number);
            C0529c.e().x(vf1.x().g());
            if (uf1.a().c()) {
                LoginManager.k().f(this);
            } else {
                onClickSafetyCenter("https://msecurity.damai.cn/securityCenter-front-wap/automatic/mobile/start", b, true);
            }
        } else if (id == R$id.ray_login_pw) {
            C0529c.e().x(vf1.x().f());
            LoginManager.k().g(this);
        } else if (id == R$id.ray_pay_pw) {
            String b2 = cm2.b(this, R$string.damai_usercenter_pay_password);
            C0529c.e().x(vf1.x().h());
            onClickSafetyCenter("https://msecurity.damai.cn/securityCenter-front-wap/automatic/paypassword/start", b2, true);
        } else if (id == R$id.rl_real_name) {
            C0529c.e().x(vf1.x().i());
            gotoAuth();
        } else if (id == R$id.mine_title_left_icon_font_tv) {
            finish();
        } else if (id == R$id.third_account_setting_layout) {
            String str = view.getTag() != null ? (String) view.getTag() : null;
            if (!TextUtils.isEmpty(str)) {
                vf1.x().m0(this.accountSettingly);
                new DMDialog(this).v("温馨提示").q(str).h("取消", Color.parseColor("#000000"), new DialogInterface$OnClickListenerC1357c(this)).m("继续", Color.parseColor("#ff2d79"), new DialogInterface$OnClickListenerC1356b()).show();
                return;
            }
            setTencentPermissionAndOpenAuth();
        } else if (id == R$id.email_set) {
            setEmail();
        } else if (id == R$id.to_un_register_page) {
            String str2 = "https://m.damai.cn/shows/pages/logout.html?pullRefresh=FALSE";
            if (AppConfig.v() && AppConfig.h() != AppConfig.EnvMode.online) {
                str2 = "https://market.wapa.damai.cn/shows/pages/logout.html?pullRefresh=FALSE";
            }
            DMNav.from(this).toUri(str2);
        } else if (id == R$id.rv_max_vip) {
            C0529c.e().x(vf1.x().m());
            DMNav.from(this).toUri(k23.c());
        } else {
            super.onClick(view);
        }
    }

    public void onClickSafetyCenter(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "283620549")) {
            ipChange.ipc$dispatch("283620549", new Object[]{this, str, str2, Boolean.valueOf(z)});
        } else if (TextUtils.isEmpty(z20.q())) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putBoolean("status", z);
            bundle.putString("title", str2);
            DMNav.from(this).withExtras(bundle).toUri(NavUri.b(cs.t));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1285275408")) {
            ipChange.ipc$dispatch("-1285275408", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(vf1.x().j());
        C0529c.e().K(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "115447344")) {
            ipChange.ipc$dispatch("115447344", new Object[]{this});
            return;
        }
        super.onDestroy();
        uf1.a().h();
        uf1.a().g();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "205089447")) {
            ipChange.ipc$dispatch("205089447", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1051020658")) {
            ipChange.ipc$dispatch("-1051020658", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1462632595")) {
            ipChange.ipc$dispatch("1462632595", new Object[]{this});
            return;
        }
        super.onResume();
        getAuthStatus();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-505653353") ? (String) ipChange.ipc$dispatch("-505653353", new Object[]{this}) : "账户安全";
    }
}
