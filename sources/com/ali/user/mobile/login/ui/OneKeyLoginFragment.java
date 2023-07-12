package com.ali.user.mobile.login.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.ali.user.mobile.app.constant.FragmentConstant;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.UIBaseConstants;
import com.ali.user.mobile.base.ui.BaseActivity;
import com.ali.user.mobile.common.api.AliUserLogin;
import com.ali.user.mobile.common.api.LoginApprearanceExtensions;
import com.ali.user.mobile.data.model.Login2RegParam;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.mobile.login.presenter.OneKeyLoginPresenter;
import com.ali.user.mobile.login.presenter.UserMobileLoginPresenter;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.NumAuthTokenCallback;
import com.ali.user.mobile.model.TokenType;
import com.ali.user.mobile.register.ProtocolModel;
import com.ali.user.mobile.rpc.HistoryAccount;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.service.NumberAuthService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.ui.widget.BottomMenuFragment;
import com.ali.user.mobile.ui.widget.MenuItem;
import com.ali.user.mobile.ui.widget.MenuItemOnClickListener;
import com.ali.user.mobile.utils.ElderUtil;
import com.ali.user.mobile.utils.ProtocolHelper;
import com.ali.user.mobile.utils.UTConstans;
import com.alibaba.fastjson.JSON;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.ui.TaobaoRegProtocolDialogFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class OneKeyLoginFragment extends BaseLoginFragment implements OneKeyLoginView, UserMobileLoginView {
    protected TextView mAlipayLoginTV;
    protected OneKeyLoginPresenter mLoginPresenter;
    protected UserMobileLoginPresenter mMobileLoginPresenter;
    protected String mMobileNum;
    protected Button mOneKeyLoginButton;
    protected TextView mProtocolView;
    protected TextView mRecommendLoginTV;
    protected TextView mShowIdTextView;
    protected String mSource;
    TaobaoRegProtocolDialogFragment regProtocolDialog;
    protected LoginParam loginParam = null;
    protected boolean isSendSms = false;

    protected void activeFaceLogin() {
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    public void doRealAction(int i) {
        if (i == LoginClickAction.ACTION_LOGIN) {
            onOneKeyLogin();
        } else if (i == LoginClickAction.ACTION_FACE) {
            activeFaceLogin();
        } else if (i == LoginClickAction.ACTION_ALIPAY) {
            goAlipay();
        } else if (i == LoginClickAction.ACTION_TAOBAO) {
            goTaobao();
        } else {
            super.doRealAction(i);
        }
    }

    protected void generateProtocol() {
        ProtocolHelper.generateProtocol(getProtocolModel(), this.mAttachedActivity, this.mProtocolView, getPageName(), getPageSpm(), false);
    }

    @Override // com.ali.user.mobile.login.ui.UserMobileLoginView
    public String getCountryCode() {
        return "CN";
    }

    protected String getFindAccountText() {
        return getString(R.string.aliuser_find_account);
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    protected int getLayoutContent() {
        return R.C2965layout.aliuser_fragment_onekey_login;
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public int getLoginSite() {
        UserLoginActivity userLoginActivity;
        HistoryAccount historyAccount;
        if (this.isHistoryMode && (userLoginActivity = this.mUserLoginActivity) != null && (historyAccount = userLoginActivity.mHistoryAccount) != null) {
            return historyAccount.getLoginSite();
        }
        return DataProviderFactory.getDataProvider().getSite();
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public String getPageName() {
        return "Page_onekey_login";
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public String getPageSpm() {
        return "a21et.b95226206";
    }

    @Override // com.ali.user.mobile.login.ui.UserMobileLoginView
    public String getPhoneCode() {
        return "86";
    }

    protected ProtocolModel getProtocolModel() {
        return ProtocolHelper.getProtocolModel(this.mAttachedActivity, this.mProtocolTitle, this.mProtocolUrl, !this.isHistoryMode);
    }

    @NonNull
    protected Fragment getSMSVerificationFragment() throws IllegalAccessException, InstantiationException {
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        if (loginApprearanceExtensions != null && loginApprearanceExtensions.getFullyCustomizedLoginSmsCodeFragment() != null) {
            return (Fragment) loginApprearanceExtensions.getFullyCustomizedLoginSmsCodeFragment().newInstance();
        }
        return new AliUserSMSLoginVerificationFragment();
    }

    public void goToSMSVerificationPage(Intent intent) {
        try {
            if (this.mUserLoginActivity == null) {
                return;
            }
            Fragment sMSVerificationFragment = getSMSVerificationFragment();
            sMSVerificationFragment.setArguments(intent.getExtras());
            Fragment findFragmentByTag = this.mUserLoginActivity.mFragmentManager.findFragmentByTag(FragmentConstant.LOGIN_SMSCODE_FRAGMENT_TAG);
            if (findFragmentByTag != null) {
                this.mUserLoginActivity.mFragmentManager.beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
            }
            UserLoginActivity userLoginActivity = this.mUserLoginActivity;
            userLoginActivity.mCurrentFragmentTag = FragmentConstant.LOGIN_SMSCODE_FRAGMENT_TAG;
            userLoginActivity.mFragmentManager.beginTransaction().replace(R.id.aliuser_content_frame, sMSVerificationFragment, FragmentConstant.LOGIN_SMSCODE_FRAGMENT_TAG).addToBackStack(null).commitAllowingStateLoss();
            this.mUserLoginActivity.mFragmentManager.beginTransaction().show(sMSVerificationFragment).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void initParams() {
        try {
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
                this.mMobileNum = arguments.getString("number", "");
                this.mProtocolTitle = arguments.getString("protocolName", "");
                this.mProtocolUrl = arguments.getString("protocolURL", "");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (this.loginParam == null) {
            this.loginParam = new LoginParam();
        }
        this.mLoginPresenter = new OneKeyLoginPresenter(this, this.loginParam);
        this.mMobileLoginPresenter = new UserMobileLoginPresenter(this, this.loginParam);
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment
    public void initViews(View view) {
        try {
            ((BaseActivity) getActivity()).getSupportActionBar().setTitle("");
            ((BaseActivity) getActivity()).setNavigationCloseIcon();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.mUserLoginActivity = (UserLoginActivity) getActivity();
        TextView textView = (TextView) view.findViewById(R.id.aliuser_onekey_login_account_tv);
        this.mShowIdTextView = textView;
        if (textView != null && !TextUtils.isEmpty(this.mMobileNum)) {
            this.mShowIdTextView.setText(this.mMobileNum);
        }
        this.mOneKeyLoginButton = (Button) view.findViewById(R.id.aliuser_onekey_login_btn);
        this.mRecommendLoginTV = (TextView) view.findViewById(R.id.aliuser_switch_recommend_login);
        this.mProtocolView = (TextView) view.findViewById(R.id.aliuser_protocol_tv);
        generateProtocol();
        this.mAlipayLoginTV = (TextView) view.findViewById(R.id.ali_user_login_alipay_login_tv);
        TextView textView2 = (TextView) view.findViewById(R.id.aliuser_onekey_login_menu);
        setOnClickListener(this.mOneKeyLoginButton, this.mRecommendLoginTV, textView2);
        this.mLoginPresenter.onStart();
        try {
            this.mCheckBoxSwitch = true;
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.aliuser_reg_checkbox);
            this.mProtocolCB = checkBox;
            ProtocolHelper.setCheckBox(this, checkBox, getPageName(), getPageSpm(), this.mCheckBoxSwitch, this.mPreviousChecked);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        if (this.needAdaptElder) {
            ElderUtil.scaleTextSize(this.mOneKeyLoginButton, this.mRecommendLoginTV, this.mShowIdTextView, this.mProtocolView, textView2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.isSendSms) {
            this.mMobileLoginPresenter.onActivityResult(i, i2, intent);
        } else {
            this.mLoginPresenter.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment
    public boolean onBackPressed() {
        addControl("close");
        return false;
    }

    @Override // com.ali.user.mobile.login.ui.UserMobileLoginView
    public void onCheckCodeError() {
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.aliuser_onekey_login_btn) {
            addCheckAction(LoginClickAction.ACTION_LOGIN);
        } else if (id == R.id.aliuser_switch_recommend_login) {
            addControl("otherid");
            switchToRecommendLogin();
        } else if (id == R.id.aliuser_onekey_login_menu) {
            addControl("more");
            showBottomMenu();
        } else {
            super.onClick(view);
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initParams();
        this.isSendSms = false;
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menu.clear();
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        OneKeyLoginPresenter oneKeyLoginPresenter = this.mLoginPresenter;
        if (oneKeyLoginPresenter != null) {
            oneKeyLoginPresenter.onDestory();
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public void onError(RpcResponse rpcResponse) {
        this.mLoginPresenter.onLoginFail(rpcResponse);
        if (rpcResponse == null || rpcResponse.code != 14076) {
            return;
        }
        UserTrackAdapter.sendUT(getPageName(), "Page_onekey_login_to_otherlogin");
        switchToRecommendLogin();
    }

    @Override // com.ali.user.mobile.login.ui.OneKeyLoginView
    public void onGetAccessTokenFail() {
        if (isActivityAvaiable()) {
            dismissLoading();
            toast(getString(R.string.aliuser_onekey_login_fail_tip), 0);
            switchToRecommendLogin();
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public void onNeedReg(final Login2RegParam login2RegParam) {
        if (!isActive() || login2RegParam == null) {
            return;
        }
        if (this.loginParam != null) {
            Properties properties = new Properties();
            properties.setProperty("sdkTraceId", this.loginParam.traceId + "");
            UserTrackAdapter.sendUT(getPageName(), UTConstant.CustomEvent.UT_LOGIN_TO_REG, properties);
        }
        if (login2RegParam.needAlert && LoginSwitch.isInABTestRegion(LoginSwitch.DIRECT_REGISTER_ALERT, 10000)) {
            Properties properties2 = new Properties();
            properties2.setProperty("monitor", "T");
            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_LOGIN_TO_REG_AGREEMENT_COMMIT, "", LoginType.LocalLoginType.SIM_LOGIN, properties2);
            TaobaoRegProtocolDialogFragment rrotocolFragment = getRrotocolFragment();
            this.regProtocolDialog = rrotocolFragment;
            rrotocolFragment.setNegativeVisible(false);
            TaobaoRegProtocolDialogFragment taobaoRegProtocolDialogFragment = this.regProtocolDialog;
            taobaoRegProtocolDialogFragment.contentVisible = false;
            taobaoRegProtocolDialogFragment.setTitle(login2RegParam.tips);
            this.regProtocolDialog.setPostiveBtnText(getString(R.string.aliuser_reg_instant));
            this.regProtocolDialog.setPositive(new View.OnClickListener() { // from class: com.ali.user.mobile.login.ui.OneKeyLoginFragment.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UserTrackAdapter.sendControlUT(OneKeyLoginFragment.this.getPageName(), UTConstant.CustomEvent.UT_LOGIN_TO_REG_AGREEMENT_SUCCESS);
                    OneKeyLoginFragment oneKeyLoginFragment = OneKeyLoginFragment.this;
                    UserMobileLoginPresenter userMobileLoginPresenter = oneKeyLoginFragment.mMobileLoginPresenter;
                    String str = login2RegParam.token;
                    LoginParam loginParam = oneKeyLoginFragment.loginParam;
                    userMobileLoginPresenter.directRegister(null, str, loginParam == null ? "" : loginParam.traceId);
                }
            });
            this.regProtocolDialog.setCancelListener(new View.OnClickListener() { // from class: com.ali.user.mobile.login.ui.OneKeyLoginFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UserTrackAdapter.sendControlUT(OneKeyLoginFragment.this.getPageName(), UTConstant.CustomEvent.UT_LOGIN_TO_REG_AGREEMENT_CANCEL);
                    TaobaoRegProtocolDialogFragment taobaoRegProtocolDialogFragment2 = OneKeyLoginFragment.this.regProtocolDialog;
                    if (taobaoRegProtocolDialogFragment2 != null) {
                        taobaoRegProtocolDialogFragment2.dismiss();
                    }
                }
            });
            this.regProtocolDialog.show(getActivity().getSupportFragmentManager(), "RegProtocolDialog");
            return;
        }
        UserMobileLoginPresenter userMobileLoginPresenter = this.mMobileLoginPresenter;
        String str = login2RegParam.token;
        LoginParam loginParam = this.loginParam;
        userMobileLoginPresenter.directRegister(null, str, loginParam != null ? loginParam.traceId : "");
    }

    @Override // com.ali.user.mobile.login.ui.OneKeyLoginView
    public void onNeedVerifyMobileForReg(String str, String str2) {
        this.isSendSms = true;
        this.mMobileLoginPresenter.buildSMSLoginParam(str2, null, false);
        this.mMobileLoginPresenter.getLoginParam().loginSourcePage = getPageName();
        this.mMobileLoginPresenter.getLoginParam().loginSourceSpm = getPageSpm();
        this.mMobileLoginPresenter.getLoginParam().loginSourceType = LoginType.LocalLoginType.SIM_LOGIN;
        this.mMobileLoginPresenter.getLoginParam().traceId = ApiReferer.generateTraceId(LoginType.LocalLoginType.SIM_LOGIN, getPageName());
        HashMap hashMap = new HashMap();
        hashMap.put("sdkTraceId", this.mMobileLoginPresenter.getLoginParam().traceId + "");
        UserTrackAdapter.control(getPageName(), getPageSpm(), UTConstans.CustomEvent.UT_SMS_ACTION, "", LoginType.LocalLoginType.SMS_LOGIN, hashMap);
        this.mMobileLoginPresenter.sendSMS();
    }

    protected void onOneKeyLogin() {
        this.isSendSms = false;
        this.loginParam.traceId = ApiReferer.generateTraceId("oneKeyLogin", getPageName());
        LoginParam loginParam = this.loginParam;
        loginParam.loginSourceType = "oneKeyLogin";
        loginParam.loginSourcePage = getPageName();
        this.loginParam.loginSourceSpm = getPageSpm();
        HashMap hashMap = new HashMap();
        hashMap.put("sdkTraceId", this.loginParam.traceId + "");
        UserTrackAdapter.control(getPageName(), getPageSpm(), UTConstant.CustomEvent.UT_LOGIN_ACTION, "", LoginType.LocalLoginType.SIM_LOGIN, hashMap);
        if (LoginSwitch.isInABTestRegion("api", 10000)) {
            this.mLoginPresenter.login();
        } else if (ServiceFactory.getService(NumberAuthService.class) != null) {
            showLoading();
            final Properties properties = new Properties();
            properties.setProperty("monitor", "T");
            UserTrackAdapter.sendUT(getPageName(), "get_onekey_login_token_commit", "", "oneKeyLogin", properties);
            ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).getLoginToken("openLoginView", new NumAuthTokenCallback() { // from class: com.ali.user.mobile.login.ui.OneKeyLoginFragment.4
                @Override // com.ali.user.mobile.model.NumAuthTokenCallback
                public void onGetAuthTokenFail(int i, String str) {
                    Properties properties2 = new Properties();
                    properties2.setProperty("code", i + "");
                    properties2.setProperty("cause", str + "");
                    UserTrackAdapter.sendUT(OneKeyLoginFragment.this.getPageName(), "get_login_token_fail", properties2);
                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "get_onekey_login_token_failure", i + "", "oneKeyLogin", properties);
                    OneKeyLoginFragment.this.onGetAccessTokenFail();
                }

                @Override // com.ali.user.mobile.model.NumAuthTokenCallback
                public void onGetAuthTokenSuccess(String str) {
                    UserTrackAdapter.sendUT(OneKeyLoginFragment.this.getPageName(), "get_login_token_success");
                    UserTrackAdapter.sendUT(OneKeyLoginFragment.this.getPageName(), "get_onekey_login_token_success", "", "oneKeyLogin", properties);
                    if (OneKeyLoginFragment.this.isActivityAvaiable()) {
                        Properties properties2 = new Properties();
                        if (OneKeyLoginFragment.this.loginParam != null) {
                            properties2.setProperty("sdkTraceId", OneKeyLoginFragment.this.loginParam.traceId + "");
                        }
                        properties2.setProperty("site", DataProviderFactory.getDataProvider().getSite() + "");
                        properties2.setProperty("loginId", OneKeyLoginFragment.this.loginParam.loginAccount + "");
                        properties2.setProperty("monitor", "T");
                        UserTrackAdapter.sendUT(OneKeyLoginFragment.this.getPageName(), UTConstant.CustomEvent.UT_SINGLE_LOGIN_COMMIT, "", LoginType.LocalLoginType.SIM_LOGIN, properties2);
                        OneKeyLoginFragment oneKeyLoginFragment = OneKeyLoginFragment.this;
                        oneKeyLoginFragment.mLoginPresenter.buildTokenParam(oneKeyLoginFragment.loginParam, str, TokenType.NUMBER, "");
                        OneKeyLoginFragment.this.mLoginPresenter.getLoginParam().externParams.put("showReigsterPolicy", "true");
                        OneKeyLoginFragment.this.mLoginPresenter.login();
                    }
                }
            });
        }
    }

    @Override // com.ali.user.mobile.login.ui.UserMobileLoginView
    public void onSMSOverLimit(RpcResponse rpcResponse) {
        onSMSSendFail(rpcResponse);
    }

    @Override // com.ali.user.mobile.login.ui.UserMobileLoginView
    public void onSMSSendFail(RpcResponse rpcResponse) {
        if (rpcResponse != null && rpcResponse.code == 14100 && isActive()) {
            onSendSMSSuccess(DateUtils.MILLIS_PER_MINUTE, false);
        }
    }

    @Override // com.ali.user.mobile.login.ui.UserMobileLoginView
    public void onSendSMSSuccess(long j, boolean z) {
        if (isActive()) {
            Intent intent = new Intent();
            intent.putExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, JSON.toJSONString(this.mMobileLoginPresenter.mLoginParam));
            intent.putExtra("pageTag", FragmentConstant.ONE_KEY_LOGIN_FRAGMENT_TAG);
            goToSMSVerificationPage(intent);
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    protected void showBottomMenu() {
        BottomMenuFragment bottomMenuFragment = getBottomMenuFragment();
        ArrayList arrayList = new ArrayList();
        MenuItem menuItem = new MenuItem();
        menuItem.setText(getString(R.string.aliuser_other_account_login));
        menuItem.setMenuItemOnClickListener(new MenuItemOnClickListener(bottomMenuFragment, menuItem) { // from class: com.ali.user.mobile.login.ui.OneKeyLoginFragment.1
            @Override // com.ali.user.mobile.ui.widget.MenuItemOnClickListener
            public void onClickMenuItem(View view, MenuItem menuItem2) {
                if (OneKeyLoginFragment.this.isActive()) {
                    OneKeyLoginFragment.this.addControl("Button-ChooseOtherAccountLogin");
                    OneKeyLoginFragment.this.switchAccount();
                }
            }
        });
        if (this.isHistoryMode) {
            arrayList.add(menuItem);
        }
        MenuItem menuItem2 = new MenuItem();
        menuItem2.setText(getString(R.string.aliuser_help));
        menuItem2.setMenuItemOnClickListener(new MenuItemOnClickListener(bottomMenuFragment, menuItem2) { // from class: com.ali.user.mobile.login.ui.OneKeyLoginFragment.2
            @Override // com.ali.user.mobile.ui.widget.MenuItemOnClickListener
            public void onClickMenuItem(View view, MenuItem menuItem3) {
                OneKeyLoginFragment.this.addControl("help");
                if (OneKeyLoginFragment.this.isActive()) {
                    OneKeyLoginFragment.this.openHelp();
                }
            }
        });
        MenuItem menuItem3 = new MenuItem();
        menuItem3.setText(getFindAccountText());
        menuItem3.setMenuItemOnClickListener(new MenuItemOnClickListener(bottomMenuFragment, menuItem3) { // from class: com.ali.user.mobile.login.ui.OneKeyLoginFragment.3
            @Override // com.ali.user.mobile.ui.widget.MenuItemOnClickListener
            public void onClickMenuItem(View view, MenuItem menuItem4) {
                OneKeyLoginFragment.this.addControl("findnick");
                if (OneKeyLoginFragment.this.isActive()) {
                    OneKeyLoginFragment.this.openFindAccountPage();
                }
            }
        });
        arrayList.add(menuItem2);
        arrayList.add(menuItem3);
        bottomMenuFragment.setMenuItems(arrayList);
        bottomMenuFragment.setMenuTitle(getString(R.string.aliuser_login_more_func));
        bottomMenuFragment.show(getFragmentManager(), getPageName());
    }

    public void switchToRecommendLogin() {
        Intent intent = this.mUserLoginActivity.getIntent();
        CheckBox checkBox = this.mProtocolCB;
        if (checkBox != null) {
            intent.putExtra("check", checkBox.isChecked());
        }
        intent.putExtra(LoginConstant.FORCE_NORMAL_MODE, true);
        if (DataProviderFactory.getDataProvider().supportRecommendLogin()) {
            this.mUserLoginActivity.switchToRecommendLogin(intent);
        } else {
            this.mUserLoginActivity.goPwdOrSMSFragment(intent);
        }
    }

    @Override // com.ali.user.mobile.login.ui.OneKeyLoginView
    public void waitTokenLogin(final String str, long j) {
        Button button = this.mOneKeyLoginButton;
        if (button != null) {
            button.postDelayed(new Runnable() { // from class: com.ali.user.mobile.login.ui.OneKeyLoginFragment.7
                @Override // java.lang.Runnable
                public void run() {
                    if (OneKeyLoginFragment.this.mMobileLoginPresenter.getLoginParam() != null) {
                        OneKeyLoginFragment.this.mMobileLoginPresenter.getLoginParam().loginSourcePage = OneKeyLoginFragment.this.getPageName();
                        OneKeyLoginFragment.this.mMobileLoginPresenter.getLoginParam().loginSourceSpm = OneKeyLoginFragment.this.getPageSpm();
                        OneKeyLoginFragment.this.mMobileLoginPresenter.getLoginParam().loginSourceType = LoginType.LocalLoginType.SIM_LOGIN;
                        OneKeyLoginFragment.this.mMobileLoginPresenter.getLoginParam().traceId = ApiReferer.generateTraceId(LoginType.LocalLoginType.SIM_LOGIN, OneKeyLoginFragment.this.getPageName());
                        HashMap hashMap = new HashMap();
                        hashMap.put("sdkTraceId", OneKeyLoginFragment.this.mMobileLoginPresenter.getLoginParam().traceId + "");
                        OneKeyLoginFragment.this.mMobileLoginPresenter.getLoginParam().token = str;
                    }
                    OneKeyLoginFragment.this.mMobileLoginPresenter.login();
                }
            }, j);
        }
    }
}
