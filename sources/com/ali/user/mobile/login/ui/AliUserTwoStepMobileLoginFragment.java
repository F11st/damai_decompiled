package com.ali.user.mobile.login.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.ali.user.mobile.app.constant.FragmentConstant;
import com.ali.user.mobile.base.UIBaseConstants;
import com.ali.user.mobile.ui.R;
import com.alibaba.fastjson.JSON;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class AliUserTwoStepMobileLoginFragment extends AliUserMobileLoginFragment {
    protected static final String TAG = AliUserTwoStepMobileLoginFragment.class.getSimpleName();

    @Override // com.ali.user.mobile.login.ui.AliUserMobileLoginFragment
    protected void checkSignInable(EditText editText) {
        EditText editText2 = this.mMobileET;
        if (editText2 == null) {
            this.mLoginBtn.setEnabled(false);
            return;
        }
        String obj = editText2.getText().toString();
        if (this.isHistoryMode) {
            obj = this.mMobileTV.getText().toString();
        }
        this.mLoginBtn.setEnabled(!TextUtils.isEmpty(obj));
    }

    @Override // com.ali.user.mobile.login.ui.AliUserMobileLoginFragment, com.ali.user.mobile.base.ui.BaseFragment
    protected int getLayoutContent() {
        return R.layout.aliuser_fragment_two_step_mobile_login;
    }

    public void goToSMSVerificationPage(Intent intent) {
        UserLoginActivity userLoginActivity = this.mUserLoginActivity;
        if (userLoginActivity == null) {
            return;
        }
        userLoginActivity.goToSMSVerificationPage(intent);
    }

    @Override // com.ali.user.mobile.login.ui.AliUserMobileLoginFragment, com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment
    public void initViews(View view) {
        super.initViews(view);
        checkSignInable(null);
    }

    @Override // com.ali.user.mobile.login.ui.AliUserMobileLoginFragment, com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.ui.AliUserMobileLoginFragment, com.ali.user.mobile.login.ui.BaseLoginFragment
    public void onLoginAction() {
        onSendSMSAction();
    }

    @Override // com.ali.user.mobile.login.ui.AliUserMobileLoginFragment, com.ali.user.mobile.login.ui.UserMobileLoginView
    public void onSendSMSSuccess(long j, boolean z) {
        if (isActive()) {
            Intent intent = new Intent();
            intent.putExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, JSON.toJSONString(this.mMobileLoginPresenter.mLoginParam));
            intent.putExtra("pageTag", FragmentConstant.TWO_STEP_MOBILE_LOGIN_FRAGMENT_TAG);
            goToSMSVerificationPage(intent);
        }
    }
}
