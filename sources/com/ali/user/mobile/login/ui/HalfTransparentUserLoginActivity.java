package com.ali.user.mobile.login.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.ali.user.mobile.app.constant.FragmentConstant;
import com.ali.user.mobile.base.UIBaseConstants;
import com.ali.user.mobile.common.api.AliUserLogin;
import com.ali.user.mobile.common.api.LoginApprearanceExtensions;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.mobile.navigation.NavigatorManager;
import com.ali.user.mobile.ui.R;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class HalfTransparentUserLoginActivity extends UserLoginActivity {
    private static final String TAG = "login.UserLoginActivity";

    private void addFragment(Fragment fragment, String str) {
        this.mFragmentManager.beginTransaction().replace(R.id.aliuser_content_frame, fragment, str).show(fragment).commitAllowingStateLoss();
        this.mCurrentFragmentTag = str;
    }

    public static Intent getCallingIntent(Context context, String str) {
        Intent intent = new Intent(context, HalfTransparentUserLoginActivity.class);
        intent.putExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, str);
        return intent;
    }

    private void openFragmentByIntent(Intent intent) {
        try {
            boolean booleanExtra = intent.getBooleanExtra(LoginConstant.LAUNCH_PASS_GUIDE_FRAGMENT, false);
            LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
            if (loginApprearanceExtensions != null && loginApprearanceExtensions.getFullyCustomizeHalfGuideFragment() != null && this.mOpenGuide && intent != null && !booleanExtra) {
                gotoGuideFragment(loginApprearanceExtensions);
                return;
            }
            Bundle extras = intent.getExtras();
            extras.remove(UIBaseConstants.LoginPage.PAGE_LOGIN_TYPE);
            NavigatorManager.getInstance().navToLoginPage(getApplicationContext(), extras, null, false);
            finish();
        }
    }

    public void gotoGuideFragment(LoginApprearanceExtensions loginApprearanceExtensions) {
        try {
            addFragment((Fragment) loginApprearanceExtensions.getFullyCustomizeHalfGuideFragment().newInstance(), FragmentConstant.GUIDE_FRAGMENT_TAG);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.ali.user.mobile.login.ui.UserLoginActivity
    public void gotoOneKeyLoginFragment(Intent intent) {
        try {
            Fragment fragment = (Fragment) AliUserLogin.mAppreanceExtentions.getFullyCustomizeHalfOneKeyFragment().newInstance();
            fragment.setArguments(intent.getExtras());
            addFragment(fragment, FragmentConstant.ONE_KEY_LOGIN_FRAGMENT_TAG);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.ali.user.mobile.login.ui.UserLoginActivity
    protected void initParam(Intent intent) {
        this.isLoginObserver = true;
        UserTrackAdapter.skipPage(this);
        this.mFragmentManager = getSupportFragmentManager();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.ui.UserLoginActivity, com.ali.user.mobile.base.ui.BaseActivity
    public void initViews() {
        try {
            if (getSupportActionBar() != null) {
                getSupportActionBar().hide();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        openFragmentByConfig(getIntent());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.ui.UserLoginActivity, com.ali.user.mobile.base.ui.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        TLogAdapter.d(TAG, "onCreate");
        this.activityIsTranslucent = true;
        super.onCreate(bundle);
    }

    @Override // com.ali.user.mobile.login.ui.UserLoginActivity
    public void openFragmentByConfig(Intent intent) {
        String str;
        String str2 = "";
        try {
            str = intent.getStringExtra("number");
            try {
                str2 = intent.getStringExtra(UIBaseConstants.LoginPage.PAGE_LOGIN_TYPE);
            } catch (Throwable th) {
                th = th;
                th.printStackTrace();
                LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
                if (TextUtils.equals(str2, UIBaseConstants.LoginPage.HALF_PAGE_GUIDE_LOGIN)) {
                }
                openFragmentByIntent(intent);
            }
        } catch (Throwable th2) {
            th = th2;
            str = "";
        }
        LoginApprearanceExtensions loginApprearanceExtensions2 = AliUserLogin.mAppreanceExtentions;
        if (TextUtils.equals(str2, UIBaseConstants.LoginPage.HALF_PAGE_GUIDE_LOGIN) && !TextUtils.isEmpty(str) && loginApprearanceExtensions2 != null && AliUserLogin.mAppreanceExtentions.getFullyCustomizeHalfOneKeyFragment() != null) {
            gotoOneKeyLoginFragment(intent);
        } else {
            openFragmentByIntent(intent);
        }
    }
}
