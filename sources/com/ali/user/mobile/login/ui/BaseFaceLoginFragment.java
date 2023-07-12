package com.ali.user.mobile.login.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.ali.user.mobile.base.UIBaseConstants;
import com.ali.user.mobile.login.presenter.FaceLoginPresenter;
import com.ali.user.mobile.login.presenter.UserLoginPresenter;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.RegionInfo;
import com.ali.user.mobile.rpc.HistoryAccount;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.ui.widget.CircleImageView;
import com.ali.user.mobile.utils.ElderUtil;
import com.ali.user.mobile.utils.StringUtil;
import com.ali.user.mobile.utils.UTConstans;
import com.alibaba.fastjson.JSON;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class BaseFaceLoginFragment extends BaseHistoryFragment implements FaceLoginView {
    protected LoginParam loginParam = null;
    protected CircleImageView mHeadImageView;
    protected TextView mPwdLoginTextView;
    protected TextView mSMSLoginTextView;
    protected Button mScanLoginButton;
    protected TextView mShowIdTextView;
    protected String mSource;
    protected UserLoginPresenter mUserLoginPresenter;

    private void initParams() {
        Bundle arguments = getArguments();
        this.loginParam = null;
        if (arguments != null) {
            this.mPreviousChecked = arguments.getBoolean("check");
            String str = (String) arguments.get(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM);
            arguments.putString(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, "");
            if (!TextUtils.isEmpty(str)) {
                LoginParam loginParam = (LoginParam) JSON.parseObject(str, LoginParam.class);
                this.loginParam = loginParam;
                if (loginParam != null) {
                    this.mSource = loginParam.source;
                }
            }
        }
        this.mUserLoginPresenter = new UserLoginPresenter(this, this.loginParam);
        this.mFaceLoginPresenter = new FaceLoginPresenter(this, this.loginParam);
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    protected int getLayoutContent() {
        return R.C2965layout.aliuser_face_fragment;
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public String getPageName() {
        return "Page_FaceLogin";
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public String getPageSpm() {
        return "a21et.b95358769";
    }

    @Override // com.ali.user.mobile.login.ui.BaseHistoryFragment, com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment
    public void initViews(View view) {
        super.initViews(view);
        this.mHeadImageView = (CircleImageView) view.findViewById(R.id.aliuser_login_avatar);
        this.mShowIdTextView = (TextView) view.findViewById(R.id.aliuser_scan_login_account_tv);
        this.mScanLoginButton = (Button) view.findViewById(R.id.aliuser_scan_login_btn);
        this.mPwdLoginTextView = (TextView) view.findViewById(R.id.aliuser_scan_switch_pwd);
        TextView textView = (TextView) view.findViewById(R.id.aliuser_scan_switch_sms);
        this.mSMSLoginTextView = textView;
        setOnClickListener(this.mScanLoginButton, this.mPwdLoginTextView, textView);
        this.mUserLoginPresenter.onStart();
        initMode();
        if (this.needAdaptElder) {
            ElderUtil.scaleTextSize(this.mScanLoginButton, this.mPwdLoginTextView, this.mSMSLoginTextView, this.mShowIdTextView);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.mUserLoginPresenter.onActivityResult(i, i2, intent);
    }

    @Override // com.ali.user.mobile.login.ui.BaseHistoryFragment, com.ali.user.mobile.login.ui.BaseLoginFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.aliuser_scan_login_btn) {
            onFaceLogin(false);
        } else if (id == R.id.aliuser_scan_switch_sms) {
            addControl(UTConstans.Controls.UT_CHOOSE_OTHER_SMS);
            switchToSmsLogin();
        } else if (id == R.id.aliuser_scan_switch_pwd) {
            addControl(UTConstans.Controls.UT_CHOOSE_OHTER_PWD);
            switchToPwdLogin();
        } else {
            super.onClick(view);
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initParams();
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    protected void onDeleteAccount() {
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        UserLoginPresenter userLoginPresenter = this.mUserLoginPresenter;
        if (userLoginPresenter != null) {
            userLoginPresenter.onDestory();
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.BaseView
    public void onGetRegion(List<RegionInfo> list) {
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        try {
            menu.findItem(R.id.aliuser_menu_item_more).setVisible(false);
            menu.findItem(R.id.aliuser_menu_item_help).setVisible(true);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        super.onPrepareOptionsMenu(menu);
    }

    @Override // com.ali.user.mobile.login.ui.BaseHistoryFragment
    protected void switchToHistoryMode(HistoryAccount historyAccount) {
        if (isActivityAvaiable() && historyAccount != null) {
            String str = historyAccount.userInputName;
            this.mCurrentSelectedAccount = str;
            String dataMasking = StringUtil.dataMasking(str);
            if (TextUtils.isEmpty(dataMasking)) {
                return;
            }
            this.mShowIdTextView.setText(dataMasking);
            updateAvatar(historyAccount.headImg);
            if (historyAccount.hasPwd == 0) {
                this.mPwdLoginTextView.setVisibility(8);
            } else {
                this.mPwdLoginTextView.setVisibility(0);
            }
            if (TextUtils.isEmpty(historyAccount.loginPhone)) {
                this.mSMSLoginTextView.setVisibility(8);
            } else {
                this.mSMSLoginTextView.setVisibility(0);
            }
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseHistoryFragment
    protected void switchToPwdLogin() {
        Intent intent = new Intent();
        CheckBox checkBox = this.mProtocolCB;
        if (checkBox != null) {
            intent.putExtra("check", checkBox.isChecked());
        }
        UserLoginPresenter userLoginPresenter = this.mUserLoginPresenter;
        if (userLoginPresenter != null && userLoginPresenter.getLoginParam() != null) {
            LoginParam loginParam = new LoginParam();
            loginParam.source = this.mUserLoginPresenter.getLoginParam().source;
            intent.putExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, JSON.toJSONString(loginParam));
        }
        this.mUserLoginActivity.gotoPwdLoginFragment(intent);
    }

    @Override // com.ali.user.mobile.login.ui.BaseHistoryFragment
    protected void switchToSmsLogin() {
        Intent intent = new Intent();
        CheckBox checkBox = this.mProtocolCB;
        if (checkBox != null) {
            intent.putExtra("check", checkBox.isChecked());
        }
        UserLoginPresenter userLoginPresenter = this.mUserLoginPresenter;
        if (userLoginPresenter != null && userLoginPresenter.getLoginParam() != null) {
            LoginParam loginParam = new LoginParam();
            loginParam.source = this.mUserLoginPresenter.getLoginParam().source;
            intent.putExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, JSON.toJSONString(loginParam));
        }
        this.mUserLoginActivity.gotoMobileLoginFragment(intent);
    }

    @Override // com.ali.user.mobile.login.ui.FaceLoginView
    public void toLastLoginFragment() {
        Intent intent = new Intent();
        UserLoginPresenter userLoginPresenter = this.mUserLoginPresenter;
        if (userLoginPresenter != null && userLoginPresenter.getLoginParam() != null) {
            LoginParam loginParam = new LoginParam();
            loginParam.source = this.mUserLoginPresenter.getLoginParam().source;
            intent.putExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, JSON.toJSONString(loginParam));
        }
        this.mUserLoginActivity.goPwdOrSMSFragment(intent);
    }
}
