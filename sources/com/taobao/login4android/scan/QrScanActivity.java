package com.taobao.login4android.scan;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.ali.user.mobile.base.ui.BaseActivity;
import com.ali.user.mobile.common.api.AliUserLogin;
import com.ali.user.mobile.common.api.LoginApprearanceExtensions;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.model.LoginConstant;
import com.taobao.login4android.sdk.R;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class QrScanActivity extends BaseActivity {
    public static final String FRAGMENT_LABEL = "aliuser_qrcode_confirm";
    private Fragment mFragment;
    protected FragmentManager mFragmentManager;
    public String mScene;

    private void initParam() {
        if (getIntent() != null) {
            try {
                this.mScene = getIntent().getStringExtra(LoginConstant.SCAN_SCENE);
                UserTrackAdapter.skipPage(this);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void openConfirm(Intent intent, LoginApprearanceExtensions loginApprearanceExtensions) {
        Fragment qrScanFragment = new QrScanFragment();
        if (loginApprearanceExtensions != null && loginApprearanceExtensions.getFullyCustomiedScanFragment() != null) {
            try {
                qrScanFragment = (Fragment) loginApprearanceExtensions.getFullyCustomiedScanFragment().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        openFragment(intent, qrScanFragment);
    }

    private void openFragment(Intent intent, Fragment fragment) {
        Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(FRAGMENT_LABEL);
        if (findFragmentByTag != null) {
            this.mFragmentManager.beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
        }
        if (intent != null) {
            fragment.setArguments(intent.getExtras());
        }
        this.mFragment = fragment;
        this.mFragmentManager.beginTransaction().add(R.id.loginContainer, fragment, FRAGMENT_LABEL).commitAllowingStateLoss();
    }

    private void openFragmentById(Intent intent) {
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        if (intent.getData() != null && "youku://passport/qrlogin".equals(intent.getData().toString())) {
            openYoukuConfirm(intent, loginApprearanceExtensions);
        } else {
            openConfirm(intent, loginApprearanceExtensions);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void openYoukuConfirm(android.content.Intent r2, com.ali.user.mobile.common.api.LoginApprearanceExtensions r3) {
        /*
            r1 = this;
            if (r3 == 0) goto L17
            java.lang.Class r0 = r3.getFullyCustomizedScanYoukuFragment()
            if (r0 == 0) goto L17
            java.lang.Class r3 = r3.getFullyCustomizedScanYoukuFragment()     // Catch: java.lang.Throwable -> L13
            java.lang.Object r3 = r3.newInstance()     // Catch: java.lang.Throwable -> L13
            androidx.fragment.app.Fragment r3 = (androidx.fragment.app.Fragment) r3     // Catch: java.lang.Throwable -> L13
            goto L18
        L13:
            r3 = move-exception
            r3.printStackTrace()
        L17:
            r3 = 0
        L18:
            if (r3 == 0) goto L1e
            r1.openFragment(r2, r3)
            goto L21
        L1e:
            r1.finish()
        L21:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.login4android.scan.QrScanActivity.openYoukuConfirm(android.content.Intent, com.ali.user.mobile.common.api.LoginApprearanceExtensions):void");
    }

    @Override // com.ali.user.mobile.base.ui.BaseActivity
    protected int getLayoutContent() {
        return R.layout.user_scan_activity;
    }

    @Override // com.ali.user.mobile.base.ui.BaseActivity
    public void initViews() {
        super.initViews();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.aliuser_scan_login_title);
        }
        openFragmentById(getIntent());
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Fragment fragment = this.mFragment;
        if (fragment != null && fragment.isVisible()) {
            Fragment fragment2 = this.mFragment;
            if (fragment2 instanceof QrScanFragment) {
                ((QrScanFragment) fragment2).handleBack();
                return;
            }
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.base.ui.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mFragmentManager = getSupportFragmentManager();
        initParam();
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initParam();
        openFragmentById(intent);
    }
}
