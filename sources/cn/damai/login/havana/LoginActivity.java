package cn.damai.login.havana;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.model.UserBaseInfoBean;
import cn.damai.commonbusiness.model.UserData;
import cn.damai.commonbusiness.model.UserVipBean;
import cn.damai.homepage.R$layout;
import cn.damai.im.UserInfoUtil;
import cn.damai.im.request.PersonalInfoRequest;
import cn.damai.login.LoginManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.fw0;
import tb.wb1;
import tb.xb1;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class LoginActivity extends AppCompatActivity implements ILoginListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CLOSE_SELF = "close_self";
    private boolean isCloseSelf;
    private String returnUrl;
    private String mPlatform = "108001";
    private wb1 loginStatusAppMonitor = new wb1();

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class a implements UserInfoUtil.OnUserInfoListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.im.UserInfoUtil.OnUserInfoListener
        public void onFailed(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "881780259")) {
                ipChange.ipc$dispatch("881780259", new Object[]{this, str, str2});
            } else {
                LoginActivity.this.fetchUserDataFailed();
            }
        }

        @Override // cn.damai.im.UserInfoUtil.OnUserInfoListener
        public void onSuccess(UserData userData) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1967100070")) {
                ipChange.ipc$dispatch("1967100070", new Object[]{this, userData});
            } else {
                LoginActivity.this.fetchUserDataSuccess(userData);
            }
        }
    }

    private void doLoginImpl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-211290066")) {
            ipChange.ipc$dispatch("-211290066", new Object[]{this});
        } else {
            HavanaProxy.v().E(this, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchUserDataFailed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1637494976")) {
            ipChange.ipc$dispatch("-1637494976", new Object[]{this});
            return;
        }
        ToastUtil.i("获取用户信息失败");
        this.loginStatusAppMonitor.a(this.mPlatform, LoginManager.k().m(), "success", "success", "success");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchUserDataSuccess(UserData userData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "430459157")) {
            ipChange.ipc$dispatch("430459157", new Object[]{this, userData});
            return;
        }
        handleUserData(userData);
        if (userData != null && userData.getUserBaseInfo() != null) {
            UserBaseInfoBean userBaseInfo = userData.getUserBaseInfo();
            String valueOf = String.valueOf(userBaseInfo.getUserId());
            if (LoginManager.k().r()) {
                String mobile = userBaseInfo.getMobile();
                if (TextUtils.isEmpty(mobile)) {
                    mobile = valueOf;
                }
                c.e().E(mobile, z20.i());
                c.e().A(xb1.g().f(mobile, valueOf, LoginManager.k().m()), xb1.CUSTOM_LOGIN, "login");
            } else if (!TextUtils.isEmpty(userBaseInfo.getMobile())) {
                c.e().E(userBaseInfo.getMobile(), z20.i());
                c.e().A(xb1.g().f(userBaseInfo.getMobile(), valueOf, LoginManager.k().m()), xb1.CUSTOM_LOGIN, "login");
            }
        }
        this.loginStatusAppMonitor.a(this.mPlatform, LoginManager.k().m(), "success", "success", "success");
    }

    private void handleIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "829847639")) {
            ipChange.ipc$dispatch("829847639", new Object[]{this, intent});
            return;
        }
        if (intent != null && intent.hasExtra("url")) {
            this.returnUrl = intent.getStringExtra("url");
        }
        if (intent.hasExtra(LoginManager.ACTION_LOGIN_FIRST_CONFIRM_CANCEL)) {
            finish();
        } else if (intent.hasExtra(LoginManager.ACTION_DO_LOGIN)) {
            doLoginImpl();
        } else {
            boolean booleanExtra = intent.getBooleanExtra(CLOSE_SELF, false);
            this.isCloseSelf = booleanExtra;
            if (booleanExtra) {
                setResult(-1);
                finish();
                return;
            }
            doLoginImpl();
        }
    }

    private void handleUserData(UserData userData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1256148460")) {
            ipChange.ipc$dispatch("1256148460", new Object[]{this, userData});
        } else if (userData == null) {
        } else {
            if (userData.getUserBaseInfo() != null) {
                z20.z0(Integer.parseInt(userData.getUserBaseInfo().getVtag()));
            }
            UserInfoUtil.d(userData);
            UserInfoUtil.e(new UserVipBean(userData));
        }
    }

    public void fetchUserData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1517592253")) {
            ipChange.ipc$dispatch("1517592253", new Object[]{this});
        } else if (LoginManager.k().q()) {
            PersonalInfoRequest personalInfoRequest = new PersonalInfoRequest();
            personalInfoRequest.needCertificationBaseInfo = "true";
            personalInfoRequest.needUserBaseInfo = "true";
            UserInfoUtil.b(personalInfoRequest, new a());
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-884090704")) {
            ipChange.ipc$dispatch("-884090704", new Object[]{this});
            return;
        }
        super.onBackPressed();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2035623663")) {
            ipChange.ipc$dispatch("-2035623663", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setContentView(R$layout.login_havana_container_activity);
        HavanaProxy.v().N();
        HavanaProxy.v().g(this);
        handleIntent(getIntent());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1157670033")) {
            ipChange.ipc$dispatch("1157670033", new Object[]{this});
            return;
        }
        super.onDestroy();
        HavanaProxy.v().Q(this);
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginCancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1121739176")) {
            ipChange.ipc$dispatch("1121739176", new Object[]{this});
        } else {
            finish();
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginFail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "98377156")) {
            ipChange.ipc$dispatch("98377156", new Object[]{this});
        } else {
            fw0.a();
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2088195909")) {
            ipChange.ipc$dispatch("2088195909", new Object[]{this});
            return;
        }
        fetchUserData();
        setResult(-1);
        finish();
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLogout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2052324245")) {
            ipChange.ipc$dispatch("2052324245", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2085180884")) {
            ipChange.ipc$dispatch("-2085180884", new Object[]{this, intent});
            return;
        }
        super.onNewIntent(intent);
        HavanaProxy.v().N();
        handleIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "323967058")) {
            ipChange.ipc$dispatch("323967058", new Object[]{this});
        } else {
            super.onPostResume();
        }
    }
}
