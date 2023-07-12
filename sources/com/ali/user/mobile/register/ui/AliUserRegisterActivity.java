package com.ali.user.mobile.register.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.ali.user.mobile.app.constant.FragmentConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.app.dataprovider.StringOrangeResult;
import com.ali.user.mobile.base.helper.BroadCastHelper;
import com.ali.user.mobile.base.ui.BaseActivity;
import com.ali.user.mobile.base.ui.BaseFragment;
import com.ali.user.mobile.common.api.AliUserLogin;
import com.ali.user.mobile.common.api.LoginApprearanceExtensions;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.action.LoginResActions;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.mobile.model.RegistParam;
import com.ali.user.mobile.register.RegistConstants;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.ui.WebConstant;
import com.ali.user.mobile.utils.UTConstans;
import com.ali.user.mobile.webview.WebViewActivity;
import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.session.SessionManager;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class AliUserRegisterActivity extends BaseActivity {
    public static final String NEW_REGISTER_PERCENT = "new_register_percent";
    private Fragment mCurrentFragment;
    protected FragmentManager mFragmentManager;
    private RegistParam mRegistParam;
    private String token = "";

    private void addControl() {
        UserTrackAdapter.sendControlUT(UTConstans.PageName.UT_PAGE_REG, UTConstans.Controls.UT_BTN_BACK);
    }

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, AliUserRegisterActivity.class);
    }

    private Fragment getMobileRegisterFragment(Intent intent, LoginApprearanceExtensions loginApprearanceExtensions) throws InstantiationException, IllegalAccessException {
        Fragment aliUserMobileRegisterFragment;
        Fragment aliUserOneKeyRegisterFragment;
        if (intent != null && TextUtils.equals(RegPageType.TWO_STEP_MOBILE_REG, intent.getStringExtra(RegistConstants.REG_PAGE_TYPE)) && loginApprearanceExtensions != null && loginApprearanceExtensions.getFullyCustomizedTwoStepMobileRegisterFragment() != null) {
            return (Fragment) loginApprearanceExtensions.getFullyCustomizedTwoStepMobileRegisterFragment().newInstance();
        }
        Properties properties = new Properties();
        RegistParam registParam = this.mRegistParam;
        if (registParam != null && !TextUtils.isEmpty(registParam.source)) {
            properties.put("source", this.mRegistParam.source);
        }
        properties.put("newUser", Boolean.valueOf(TextUtils.isEmpty(SessionManager.getInstance(DataProviderFactory.getApplicationContext()).getOldUserId())));
        UserTrackAdapter.sendUT("toRegisterPage", properties);
        if (DataProviderFactory.getDataProvider().supportOneKeyRegister()) {
            String str = "";
            try {
                str = intent.getStringExtra("number");
                String stringExtra = intent.getStringExtra("scene");
                if (!TextUtils.isEmpty(stringExtra)) {
                    properties.setProperty("scene", stringExtra);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (!TextUtils.isEmpty(str)) {
                if (loginApprearanceExtensions != null && loginApprearanceExtensions.getFullyCustomizeOneKeyRegisterFragment() != null) {
                    aliUserOneKeyRegisterFragment = (Fragment) loginApprearanceExtensions.getFullyCustomizeOneKeyRegisterFragment().newInstance();
                } else {
                    aliUserOneKeyRegisterFragment = new AliUserOneKeyRegisterFragment();
                }
                UserTrackAdapter.sendUT("toSimRegisterPage", properties);
                return aliUserOneKeyRegisterFragment;
            }
        }
        if (LoginSwitch.isInABTestRegion(NEW_REGISTER_PERCENT, 10000) && DataProviderFactory.getDataProvider().supportTwoStepMobileRegister()) {
            if (loginApprearanceExtensions != null && loginApprearanceExtensions.getFullyCustomizedTwoStepMobileRegisterFragment() != null) {
                aliUserMobileRegisterFragment = (Fragment) loginApprearanceExtensions.getFullyCustomizedTwoStepMobileRegisterFragment().newInstance();
            } else {
                aliUserMobileRegisterFragment = new AliUserTwoStepMobileRegisterFragment();
            }
        } else if (loginApprearanceExtensions != null && loginApprearanceExtensions.getFullyCustomizeMobileRegisterFragment() != null) {
            aliUserMobileRegisterFragment = (Fragment) loginApprearanceExtensions.getFullyCustomizeMobileRegisterFragment().newInstance();
        } else {
            aliUserMobileRegisterFragment = new AliUserMobileRegisterFragment();
        }
        UserTrackAdapter.sendUT("toSmsRegisterPage", properties);
        return aliUserMobileRegisterFragment;
    }

    public static void goRegHelp(Activity activity) {
        String str;
        StringOrangeResult helpLink = DataProviderFactory.getOrangeConfig().helpLink();
        if (helpLink.orangeExist) {
            str = helpLink.value;
        } else if (DataProviderFactory.getDataProvider().getSite() == 3) {
            str = LoginConstant.CBU_HELP_URL;
        } else {
            str = DataProviderFactory.getDataProvider().isTaobaoApp() ? LoginConstant.TAOBAO_HELP_URL : "https://ihelp.taobao.com/pocket/visitorServicePortal.htm?from=n_registration_inputphone";
        }
        Intent intent = new Intent(activity, WebViewActivity.class);
        intent.putExtra(WebConstant.WEBURL, str);
        activity.startActivity(intent);
    }

    private void hideAllFragment() {
        for (String str : FragmentConstant.getRegFragmentTagList()) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(str);
            if (findFragmentByTag != null) {
                this.mFragmentManager.beginTransaction().hide(findFragmentByTag).commitAllowingStateLoss();
            }
        }
    }

    private void initParam(Intent intent) {
        this.mFragmentManager = getSupportFragmentManager();
        if (intent != null) {
            this.mRegistParam = (RegistParam) intent.getParcelableExtra(RegistConstants.REGISTPARAM);
        }
        String dataString = intent.getDataString();
        try {
            if (TextUtils.isEmpty(dataString)) {
                return;
            }
            this.token = Uri.parse(dataString).getQueryParameter(AbstractC3893a.d);
        } catch (Throwable unused) {
        }
    }

    public void addFragment(Fragment fragment, String str) {
        hideAllFragment();
        Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(str);
        if (findFragmentByTag != null) {
            this.mFragmentManager.beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
        }
        this.mCurrentFragment = fragment;
        this.mFragmentManager.beginTransaction().add(R.id.aliuser_content_frame, fragment, str).commitAllowingStateLoss();
        this.mFragmentManager.beginTransaction().show(fragment).commitAllowingStateLoss();
    }

    public void changeFragmentByConfig(Intent intent) {
        try {
            Fragment mobileRegisterFragment = getMobileRegisterFragment(intent, AliUserLogin.mAppreanceExtentions);
            if (intent != null) {
                try {
                    Bundle extras = intent.getExtras();
                    if (extras == null) {
                        extras = new Bundle();
                    }
                    if (!TextUtils.isEmpty(this.token)) {
                        extras.putString("token", this.token);
                    }
                    mobileRegisterFragment.setArguments(extras);
                } catch (Throwable unused) {
                }
            }
            addFragment(mobileRegisterFragment, FragmentConstant.REG_FRAGMENT_TAG);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void finishCurrentAndNotify() {
        Fragment fragment;
        if (getSupportFragmentManager() == null || getSupportFragmentManager().isDestroyed() || (fragment = this.mCurrentFragment) == null || !((BaseFragment) fragment).onBackPressed()) {
            try {
                addControl();
                BroadCastHelper.sendLocalBroadCast(new Intent(LoginResActions.REG_CANCEL));
                finish();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.ali.user.mobile.base.ui.BaseActivity
    protected int getLayoutContent() {
        return R.C2965layout.aliuser_activity_frame_content;
    }

    public void gotoMobileRegFragment(Intent intent) {
        Fragment aliUserMobileRegisterFragment;
        try {
            LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
            if (loginApprearanceExtensions != null && loginApprearanceExtensions.getFullyCustomizeMobileRegisterFragment() != null) {
                aliUserMobileRegisterFragment = (Fragment) loginApprearanceExtensions.getFullyCustomizeMobileRegisterFragment().newInstance();
            } else {
                aliUserMobileRegisterFragment = new AliUserMobileRegisterFragment();
            }
            aliUserMobileRegisterFragment.setArguments(intent.getExtras());
            addFragment(aliUserMobileRegisterFragment, FragmentConstant.REG_FRAGMENT_TAG);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gotoSmsCodeFragment(Intent intent) {
        AliUserRegisterSMSVerificationFragment aliUserRegisterSMSVerificationFragment;
        try {
            LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
            if (loginApprearanceExtensions != null && loginApprearanceExtensions.getFullyCustomizedRegSmsCodeFragment() != null) {
                aliUserRegisterSMSVerificationFragment = (AliUserRegisterSMSVerificationFragment) loginApprearanceExtensions.getFullyCustomizedRegSmsCodeFragment().newInstance();
            } else {
                aliUserRegisterSMSVerificationFragment = new AliUserRegisterSMSVerificationFragment();
            }
            aliUserRegisterSMSVerificationFragment.setArguments(intent.getExtras());
            addFragment(aliUserRegisterSMSVerificationFragment, FragmentConstant.REG_SMSCODE_FRAGMENT_TAG);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gotoTwoStepMobileRegFragment(Intent intent) {
        AliUserTwoStepMobileRegisterFragment aliUserTwoStepMobileRegisterFragment;
        try {
            LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
            if (loginApprearanceExtensions != null && loginApprearanceExtensions.getFullyCustomizedTwoStepMobileRegisterFragment() != null) {
                aliUserTwoStepMobileRegisterFragment = (AliUserTwoStepMobileRegisterFragment) loginApprearanceExtensions.getFullyCustomizedTwoStepMobileRegisterFragment().newInstance();
            } else {
                aliUserTwoStepMobileRegisterFragment = new AliUserTwoStepMobileRegisterFragment();
            }
            aliUserTwoStepMobileRegisterFragment.setArguments(intent.getExtras());
            addFragment(aliUserTwoStepMobileRegisterFragment, FragmentConstant.REG_FRAGMENT_TAG);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.base.ui.BaseActivity
    public void initViews() {
        try {
            if (getSupportActionBar() != null) {
                LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
                if (loginApprearanceExtensions != null && !loginApprearanceExtensions.isNeedToolbar()) {
                    getSupportActionBar().hide();
                }
                getSupportActionBar().setTitle(R.string.aliuser_signup_page_title);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        changeFragmentByConfig(getIntent());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.mCurrentFragment.onActivityResult(i, i2, intent);
        super.onActivityResult(i, i2, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finishCurrentAndNotify();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.base.ui.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.isLoginObserver = true;
        try {
            initParam(getIntent());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        UserTrackAdapter.skipPage(this);
        super.onCreate(bundle);
    }

    @Override // com.ali.user.mobile.base.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        try {
            this.mFragmentManager = null;
            super.onDestroy();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            initParam(intent);
            initViews();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        try {
            super.onPause();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
