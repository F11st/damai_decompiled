package com.ali.user.mobile.login.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.ali.user.mobile.app.LoginContext;
import com.ali.user.mobile.app.constant.FragmentConstant;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.base.UIBaseConstants;
import com.ali.user.mobile.base.ui.BaseActivity;
import com.ali.user.mobile.base.ui.BaseFragment;
import com.ali.user.mobile.data.model.Login2RegParam;
import com.ali.user.mobile.helper.ActivityUIHelper;
import com.ali.user.mobile.info.AppInfo;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.AppMonitorAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.presenter.FaceLoginPresenter;
import com.ali.user.mobile.login.presenter.SMSNickLoginPresenter;
import com.ali.user.mobile.login.presenter.UserMobileLoginPresenter;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.navigation.NavigatorManager;
import com.ali.user.mobile.register.ui.AliUserSmsCodeView;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.service.FaceService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.ui.widget.AliUserDialog;
import com.ali.user.mobile.ui.widget.BottomMenuFragment;
import com.ali.user.mobile.ui.widget.CountDownButton;
import com.ali.user.mobile.ui.widget.MenuItemOnClickListener;
import com.ali.user.mobile.utils.ElderUtil;
import com.ali.user.mobile.utils.MainThreadExecutor;
import com.ali.user.mobile.utils.UTConstans;
import com.alibaba.fastjson.JSON;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.ui.TaobaoRegProtocolDialogFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class AliUserSMSLoginVerificationFragment extends BaseLoginFragment implements UserMobileLoginView {
    public static ILoginMethodChange mLoginMethodChange;
    protected String fromPageTag;
    protected long havanaId;
    protected LoginParam loginParam = null;
    AliUserDialog mAliUserDialog;
    protected ArrayList<String> mAvailableLoginModes;
    protected TextView mChangeLogin;
    protected String mMaskMobile;
    protected SMSNickLoginPresenter mNickLoginPresenter;
    protected String mOutterSourcePage;
    protected UserMobileLoginPresenter mPresenter;
    protected CountDownButton mSendSMSCodeBtn;
    protected AliUserSmsCodeView mSmsCodeView;
    protected String preCheckVerify;
    TaobaoRegProtocolDialogFragment regProtocolDialog;
    protected String verify;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.ali.user.mobile.login.ui.AliUserSMSLoginVerificationFragment$11  reason: invalid class name */
    /* loaded from: classes17.dex */
    public static /* synthetic */ class AnonymousClass11 {
        static final /* synthetic */ int[] $SwitchMap$com$ali$user$mobile$login$ui$LoginModeState;

        static {
            int[] iArr = new int[LoginModeState.values().length];
            $SwitchMap$com$ali$user$mobile$login$ui$LoginModeState = iArr;
            try {
                iArr[LoginModeState.SMS_LOGIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ali$user$mobile$login$ui$LoginModeState[LoginModeState.PASSWORD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ali$user$mobile$login$ui$LoginModeState[LoginModeState.SIM_LOGIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ali$user$mobile$login$ui$LoginModeState[LoginModeState.SCAN_FACE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void initParams() {
        Bundle arguments = getArguments();
        this.loginParam = null;
        if (arguments != null) {
            String str = (String) arguments.get(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM);
            arguments.putString(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, "");
            if (!TextUtils.isEmpty(str)) {
                LoginParam loginParam = (LoginParam) JSON.parseObject(str, LoginParam.class);
                this.loginParam = loginParam;
                if (loginParam != null) {
                    this.mOutterSourcePage = loginParam.loginSourcePage;
                    loginParam.loginSourcePage = getPageName();
                    this.loginParam.loginSourceSpm = getPageSpm();
                }
            }
            this.mMaskMobile = (String) arguments.get("maskMobile");
            arguments.putString("maskMobile", "");
            this.fromPageTag = arguments.getString("pageTag");
            String string = arguments.getString(UIBaseConstants.IntentExtrasNamesConstants.PARAM_METHODS);
            this.preCheckVerify = arguments.getString("preCheckVerify");
            this.verify = arguments.getString("verify");
            this.havanaId = arguments.getLong("havanaId");
            if (!TextUtils.isEmpty(string)) {
                try {
                    ArrayList<String> arrayList = (ArrayList) JSON.parseObject(string, ArrayList.class);
                    this.mAvailableLoginModes = arrayList;
                    if (arrayList != null) {
                        LoginModeState loginModeState = LoginModeState.SCAN_FACE;
                        if (!arrayList.contains(loginModeState.name()) && ("true".equals(this.preCheckVerify) || "true".equals(this.verify))) {
                            this.mAvailableLoginModes.add(loginModeState.name());
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        this.mPresenter = new UserMobileLoginPresenter(this, this.loginParam);
        this.mNickLoginPresenter = new SMSNickLoginPresenter(this, this.loginParam);
        this.mFaceLoginPresenter = new FaceLoginPresenter(this, this.loginParam);
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public void alert(String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2) {
        toast(str2, 0);
        onCheckCodeError();
    }

    protected void doDirectRegister(String str) {
        if (this.loginParam != null) {
            Properties properties = new Properties();
            properties.setProperty("sdkTraceId", this.loginParam.traceId + "");
            UserTrackAdapter.sendUT(getPageName(), UTConstant.CustomEvent.UT_LOGIN_TO_REG, properties);
        }
        UserMobileLoginPresenter userMobileLoginPresenter = this.mPresenter;
        LoginParam loginParam = this.loginParam;
        userMobileLoginPresenter.directRegister(null, str, loginParam != null ? loginParam.traceId : "");
    }

    @Override // com.ali.user.mobile.login.ui.UserMobileLoginView
    public String getCountryCode() {
        LoginParam loginParam = this.loginParam;
        return loginParam == null ? "CN" : loginParam.countryCode;
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    protected int getLayoutContent() {
        return R.C2965layout.aliuser_fragment_sms_login_verification;
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public String getPageName() {
        if (this.loginParam == null || TextUtils.isEmpty(this.mOutterSourcePage)) {
            return UTConstans.PageName.UT_PAGE_LOGIN_SMS_CODE;
        }
        return this.mOutterSourcePage + "_inputcode";
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public String getPageSpm() {
        return UTConstans.PageName.F_SMS_CODE;
    }

    @Override // com.ali.user.mobile.login.ui.UserMobileLoginView
    public String getPhoneCode() {
        LoginParam loginParam = this.loginParam;
        return loginParam == null ? "86" : loginParam.phoneCode;
    }

    protected void goBack() {
        try {
            this.mUserLoginActivity.mFragmentManager.popBackStack();
            this.mUserLoginActivity.mCurrentFragmentTag = TextUtils.isEmpty(this.fromPageTag) ? FragmentConstant.RECOMMEND_LOGIN_FRAGMENT_TAG : this.fromPageTag;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment
    public void initViews(View view) {
        ArrayList<String> arrayList;
        LoginParam loginParam;
        String string;
        this.mUserLoginActivity = (UserLoginActivity) getActivity();
        try {
            ((BaseActivity) getActivity()).getSupportActionBar().setTitle("");
            ((BaseActivity) getActivity()).setNavigationBackIcon();
        } catch (Throwable unused) {
        }
        TextView textView = (TextView) view.findViewById(R.id.aliuser_login_sms_code_secondary_title_tv);
        LoginParam loginParam2 = this.loginParam;
        if (loginParam2 != null && !TextUtils.isEmpty(loginParam2.loginAccount)) {
            String str = this.mMaskMobile;
            if (TextUtils.isEmpty(str)) {
                if ("86".equals(this.loginParam.phoneCode)) {
                    String str2 = this.loginParam.loginAccount;
                    if (str2.length() == 11) {
                        str2 = this.loginParam.loginAccount.substring(0, 3) + " " + this.loginParam.loginAccount.substring(3, 7) + " " + this.loginParam.loginAccount.substring(7, 11);
                    }
                    str = AltriaXLaunchTime.SPACE + str2;
                } else {
                    str = " +" + this.loginParam.phoneCode + AltriaXLaunchTime.SPACE + this.loginParam.loginAccount;
                }
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getString(R.string.aliuser_sms_code_secondary_title, str));
            try {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#111111")), 7, string.length() - 10, 33);
                spannableStringBuilder.setSpan(new StyleSpan(1), 7, string.length() - 10, 33);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            textView.setText(spannableStringBuilder);
        }
        AliUserSmsCodeView aliUserSmsCodeView = (AliUserSmsCodeView) view.findViewById(R.id.aliuser_login_sms_code_view);
        this.mSmsCodeView = aliUserSmsCodeView;
        if (aliUserSmsCodeView != null && (loginParam = this.loginParam) != null && !TextUtils.isEmpty(loginParam.codeLength)) {
            this.mSmsCodeView.setTextCount(Integer.parseInt(this.loginParam.codeLength));
        }
        this.mSmsCodeView.setOnCompletedListener(new AliUserSmsCodeView.OnCompletedListener() { // from class: com.ali.user.mobile.login.ui.AliUserSMSLoginVerificationFragment.1
            @Override // com.ali.user.mobile.register.ui.AliUserSmsCodeView.OnCompletedListener
            public void onCompleted(String str3) {
                AliUserSMSLoginVerificationFragment.this.submitLoginForm();
            }
        });
        this.mSmsCodeView.focus();
        this.mSmsCodeView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.ali.user.mobile.login.ui.AliUserSMSLoginVerificationFragment.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (z) {
                    AliUserSMSLoginVerificationFragment.this.addControl("inputcode_input");
                }
            }
        });
        CountDownButton countDownButton = (CountDownButton) view.findViewById(R.id.aliuser_login_send_smscode_btn);
        this.mSendSMSCodeBtn = countDownButton;
        countDownButton.setOnClickListener(this);
        this.mSendSMSCodeBtn.setGetCodeTitle(R.string.aliuser_signup_verification_reGetCode2);
        this.mSendSMSCodeBtn.setTickTitleRes(R.string.aliuser_sms_code_success_hint2);
        this.mSendSMSCodeBtn.startCountDown(DateUtils.MILLIS_PER_MINUTE, 1000L);
        TextView textView2 = (TextView) view.findViewById(R.id.aliuser_change_login);
        this.mChangeLogin = textView2;
        if (textView2 != null) {
            if (LoginSwitch.getSwitch("showOther", "true") && (arrayList = this.mAvailableLoginModes) != null && arrayList.size() > 1) {
                this.mChangeLogin.setOnClickListener(new View.OnClickListener() { // from class: com.ali.user.mobile.login.ui.AliUserSMSLoginVerificationFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        AliUserSMSLoginVerificationFragment.this.addControl(UTConstans.Controls.UT_CHOOSE_OTHER);
                        AliUserSMSLoginVerificationFragment.this.showMoreLoginModeMenu(LoginModeState.SMS_LOGIN);
                    }
                });
            } else {
                this.mChangeLogin.setVisibility(8);
            }
        }
        if (this.needAdaptElder) {
            ElderUtil.scaleTextSize(this.mSendSMSCodeBtn, this.mChangeLogin, textView);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (!TextUtils.isEmpty(this.mMaskMobile)) {
            this.mNickLoginPresenter.onActivityResult(i, i2, intent);
        } else {
            this.mPresenter.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment
    public boolean onBackPressed() {
        this.mAliUserDialog = AliUserDialog.Builder(getActivity()).setTitle(getString(R.string.aliuser_exit_smscode_hint)).setOnNegativeClickListener(getString(R.string.aliuser_text_back), new AliUserDialog.NegativeClickListener() { // from class: com.ali.user.mobile.login.ui.AliUserSMSLoginVerificationFragment.10
            @Override // com.ali.user.mobile.ui.widget.AliUserDialog.NegativeClickListener
            public void onClick(View view) {
                AliUserDialog aliUserDialog = AliUserSMSLoginVerificationFragment.this.mAliUserDialog;
                if (aliUserDialog != null) {
                    aliUserDialog.dismiss();
                }
                AliUserSMSLoginVerificationFragment.this.addControl(UTConstans.Controls.UT_REG_BACK_BUTTON_CLICK);
                if (!AliUserSMSLoginVerificationFragment.this.isActive() || AliUserSMSLoginVerificationFragment.this.getActivity() == null) {
                    return;
                }
                AliUserSMSLoginVerificationFragment.this.goBack();
            }
        }).setOnPositiveClickListener(getString(R.string.aliuser_wait_a_moment), new AliUserDialog.PositiveClickListener() { // from class: com.ali.user.mobile.login.ui.AliUserSMSLoginVerificationFragment.9
            @Override // com.ali.user.mobile.ui.widget.AliUserDialog.PositiveClickListener
            public void onClick(View view) {
                AliUserDialog aliUserDialog = AliUserSMSLoginVerificationFragment.this.mAliUserDialog;
                if (aliUserDialog != null) {
                    aliUserDialog.dismiss();
                }
                AliUserSMSLoginVerificationFragment.this.addControl(UTConstans.Controls.UT_REG_BACK_BUTTON_CANCEL);
            }
        }).build().shown();
        return true;
    }

    @Override // com.ali.user.mobile.login.ui.UserMobileLoginView
    public void onCheckCodeError() {
        AliUserSmsCodeView aliUserSmsCodeView = this.mSmsCodeView;
        if (aliUserSmsCodeView != null) {
            aliUserSmsCodeView.clearText();
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.aliuser_login_send_smscode_btn) {
            addControl("inputcode_again");
            sendCodeAction();
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            initParams();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        UserMobileLoginPresenter userMobileLoginPresenter = this.mPresenter;
        if (userMobileLoginPresenter != null && userMobileLoginPresenter.getLoginParam() != null && !TextUtils.isEmpty(this.mPresenter.getLoginParam().helpUrl)) {
            menuInflater.inflate(R.C2966menu.aliuser_menu, menu);
            try {
                MenuItem findItem = menu.findItem(R.id.aliuser_menu_item_help);
                SpannableString spannableString = new SpannableString(getResources().getString(R.string.aliuser_sms_need_help));
                spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.C2963color.aliuser_color_orange)), 0, spannableString.length(), 0);
                findItem.setTitle(spannableString);
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        menu.clear();
    }

    protected void onFaceLogin() {
        if (ServiceFactory.getService(FaceService.class) != null) {
            LoginParam loginParam = new LoginParam();
            loginParam.havanaId = this.havanaId;
            loginParam.traceId = ApiReferer.generateTraceId(LoginType.LocalLoginType.SCAN_FACE_LOGIN, getPageName(), AppInfo.getInstance().getUtdid() + String.valueOf(System.currentTimeMillis() / 1000));
            loginParam.loginSourceType = LoginType.LocalLoginType.SCAN_FACE_LOGIN;
            loginParam.loginSourcePage = getPageName();
            loginParam.loginSourceSpm = getPageSpm();
            LoginContext.sCurrentLoginParam = loginParam;
            HashMap hashMap = new HashMap();
            hashMap.put("sdkTraceId", loginParam.traceId + "");
            UserTrackAdapter.control(getPageName(), getPageSpm(), UTConstant.CustomEvent.UT_LOGIN_ACTION, "", LoginType.LocalLoginType.SCAN_FACE_LOGIN, hashMap);
            if ("true".equals(this.verify)) {
                this.mFaceLoginPresenter.fetchScanToken(loginParam);
            } else if ("true".equals(this.preCheckVerify)) {
                this.mFaceLoginPresenter.activeFaceLogin(loginParam);
            }
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public void onNeedReg(Login2RegParam login2RegParam) {
        final String str = login2RegParam.token;
        boolean z = login2RegParam.needAlert;
        String str2 = login2RegParam.tips;
        if (z && LoginSwitch.isInABTestRegion(LoginSwitch.DIRECT_REGISTER_ALERT, 10000)) {
            TaobaoRegProtocolDialogFragment rrotocolFragment = getRrotocolFragment();
            this.regProtocolDialog = rrotocolFragment;
            rrotocolFragment.setNegativeVisible(false);
            TaobaoRegProtocolDialogFragment taobaoRegProtocolDialogFragment = this.regProtocolDialog;
            taobaoRegProtocolDialogFragment.contentVisible = false;
            taobaoRegProtocolDialogFragment.setTitle(str2);
            this.regProtocolDialog.setPostiveBtnText(getString(R.string.aliuser_reg_instant));
            this.regProtocolDialog.setPositive(new View.OnClickListener() { // from class: com.ali.user.mobile.login.ui.AliUserSMSLoginVerificationFragment.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UserTrackAdapter.sendControlUT(AliUserSMSLoginVerificationFragment.this.getPageName(), UTConstant.Controls.UT_SMS_ARGREE_REGISTER);
                    AliUserSMSLoginVerificationFragment.this.doDirectRegister(str);
                }
            });
            this.regProtocolDialog.setCancelListener(new View.OnClickListener() { // from class: com.ali.user.mobile.login.ui.AliUserSMSLoginVerificationFragment.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TaobaoRegProtocolDialogFragment taobaoRegProtocolDialogFragment2 = AliUserSMSLoginVerificationFragment.this.regProtocolDialog;
                    if (taobaoRegProtocolDialogFragment2 != null) {
                        taobaoRegProtocolDialogFragment2.dismiss();
                    }
                }
            });
            this.regProtocolDialog.show(getActivity().getSupportFragmentManager(), getPageName());
        } else if (isActive()) {
            doDirectRegister(str);
        }
    }

    @Override // com.ali.user.mobile.login.ui.UserMobileLoginView
    public void onSMSOverLimit(RpcResponse rpcResponse) {
        if (isActive() && rpcResponse != null && rpcResponse.code == 14100) {
            onSendSMSSuccess(DateUtils.MILLIS_PER_MINUTE, false);
        }
    }

    @Override // com.ali.user.mobile.login.ui.UserMobileLoginView
    public void onSMSSendFail(RpcResponse rpcResponse) {
        AliUserSmsCodeView aliUserSmsCodeView = this.mSmsCodeView;
        if (aliUserSmsCodeView != null) {
            aliUserSmsCodeView.clearText();
        }
    }

    protected void onSendSMSAction() {
        if (!TextUtils.isEmpty(this.mMaskMobile)) {
            SMSNickLoginPresenter sMSNickLoginPresenter = this.mNickLoginPresenter;
            if (sMSNickLoginPresenter == null || sMSNickLoginPresenter.getLoginParam() == null) {
                return;
            }
            this.mNickLoginPresenter.getLoginParam().loginSourcePage = getPageName();
            this.mNickLoginPresenter.getLoginParam().loginSourceSpm = getPageSpm();
            this.mNickLoginPresenter.getLoginParam().loginSourceType = LoginType.LocalLoginType.NICK_SMS_LOGIN;
            this.mNickLoginPresenter.getLoginParam().traceId = ApiReferer.generateTraceId(LoginType.LocalLoginType.NICK_SMS_LOGIN, getPageName());
            HashMap hashMap = new HashMap();
            hashMap.put("sdkTraceId", this.mNickLoginPresenter.getLoginParam().traceId + "");
            UserTrackAdapter.control(getPageName(), getPageSpm(), UTConstans.CustomEvent.UT_SMS_ACTION, "", LoginType.LocalLoginType.NICK_SMS_LOGIN, hashMap);
            SMSNickLoginPresenter sMSNickLoginPresenter2 = this.mNickLoginPresenter;
            sMSNickLoginPresenter2.sendSMS(sMSNickLoginPresenter2.getLoginParam().loginAccount);
            return;
        }
        UserMobileLoginPresenter userMobileLoginPresenter = this.mPresenter;
        if (userMobileLoginPresenter == null || userMobileLoginPresenter.getLoginParam() == null) {
            return;
        }
        this.mPresenter.getLoginParam().loginSourcePage = getPageName();
        this.mPresenter.getLoginParam().loginSourceSpm = getPageSpm();
        this.mPresenter.getLoginParam().loginSourceType = LoginType.LocalLoginType.SMS_LOGIN;
        this.mPresenter.getLoginParam().traceId = ApiReferer.generateTraceId(LoginType.LocalLoginType.SMS_LOGIN, getPageName());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("sdkTraceId", this.mPresenter.getLoginParam().traceId + "");
        UserTrackAdapter.control(getPageName(), getPageSpm(), UTConstans.CustomEvent.UT_SMS_ACTION, "", LoginType.LocalLoginType.SMS_LOGIN, hashMap2);
        AppMonitorAdapter.commitSuccess("Page_Member_Login", "loginMonitorPoint", "action=smsAction;biz=smsLogin;page=" + getPageName());
        this.mPresenter.sendSMS();
    }

    @Override // com.ali.user.mobile.login.ui.UserMobileLoginView
    public void onSendSMSSuccess(long j, boolean z) {
        this.mSendSMSCodeBtn.startCountDown(j, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    public void openHelp() {
        NavigatorManager.getInstance().navToTransparentWeb(getActivity(), this.mPresenter.getLoginParam().helpUrl);
    }

    protected void sendCodeAction() {
        MainThreadExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.login.ui.AliUserSMSLoginVerificationFragment.6
            @Override // java.lang.Runnable
            public void run() {
                AliUserSmsCodeView aliUserSmsCodeView = AliUserSMSLoginVerificationFragment.this.mSmsCodeView;
                if (aliUserSmsCodeView != null) {
                    aliUserSmsCodeView.clearText();
                }
                try {
                    AliUserSMSLoginVerificationFragment.this.onSendSMSAction();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public void setLoginAccountInfo(String str) {
    }

    protected void showMoreLoginModeMenu(LoginModeState loginModeState) {
        this.mChangeLogin.postDelayed(new Runnable() { // from class: com.ali.user.mobile.login.ui.AliUserSMSLoginVerificationFragment.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (((BaseFragment) AliUserSMSLoginVerificationFragment.this).mActivityHelper != null) {
                        ((BaseFragment) AliUserSMSLoginVerificationFragment.this).mActivityHelper.hideInputMethod();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }, 100L);
        BottomMenuFragment bottomMenuFragment = getBottomMenuFragment();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.mAvailableLoginModes.iterator();
        while (it.hasNext()) {
            final String next = it.next();
            if (!TextUtils.equals(loginModeState.name(), next)) {
                com.ali.user.mobile.ui.widget.MenuItem menuItem = new com.ali.user.mobile.ui.widget.MenuItem();
                final LoginModeState valueOf = LoginModeState.valueOf(next);
                int i = valueOf.loginModeName;
                if (i > 0) {
                    menuItem.setText(getString(i));
                    menuItem.setMenuItemOnClickListener(new MenuItemOnClickListener(bottomMenuFragment, menuItem) { // from class: com.ali.user.mobile.login.ui.AliUserSMSLoginVerificationFragment.5
                        @Override // com.ali.user.mobile.ui.widget.MenuItemOnClickListener
                        public void onClickMenuItem(View view, com.ali.user.mobile.ui.widget.MenuItem menuItem2) {
                            if (AliUserSMSLoginVerificationFragment.this.isActive()) {
                                AliUserSMSLoginVerificationFragment.this.switchLoginModeHit(valueOf);
                                if (AliUserSMSLoginVerificationFragment.this.havanaId != 0 && LoginModeState.SCAN_FACE.name().equals(next)) {
                                    AliUserSMSLoginVerificationFragment.this.onFaceLogin();
                                    return;
                                }
                                ILoginMethodChange iLoginMethodChange = AliUserSMSLoginVerificationFragment.mLoginMethodChange;
                                if (iLoginMethodChange != null) {
                                    iLoginMethodChange.onMethodChange(valueOf);
                                }
                                AliUserSMSLoginVerificationFragment.mLoginMethodChange = null;
                                if (!AliUserSMSLoginVerificationFragment.this.isActive() || AliUserSMSLoginVerificationFragment.this.getActivity() == null) {
                                    return;
                                }
                                AliUserSMSLoginVerificationFragment.this.goBack();
                            }
                        }
                    });
                    arrayList.add(menuItem);
                }
            }
        }
        bottomMenuFragment.setMenuItems(arrayList);
        bottomMenuFragment.setMenuTitle(getString(R.string.aliuser_more_login_mode_title));
        bottomMenuFragment.show(getFragmentManager(), getPageName());
    }

    public void submitLoginForm() {
        String str = !TextUtils.isEmpty(this.mMaskMobile) ? LoginType.LocalLoginType.NICK_SMS_LOGIN : LoginType.LocalLoginType.SMS_LOGIN;
        HashMap hashMap = new HashMap();
        hashMap.put("sdkTraceId", this.loginParam.traceId + "");
        UserTrackAdapter.control(getPageName(), getPageSpm(), UTConstant.CustomEvent.UT_LOGIN_ACTION, "", str, hashMap);
        if (!LoginSwitch.isInABTestRegion("api", 10000)) {
            Properties properties = new Properties();
            properties.setProperty("sdkTraceId", this.loginParam.traceId + "");
            properties.setProperty("monitor", "T");
            properties.setProperty("site", getLoginSite() + "");
            properties.setProperty("loginId", this.loginParam.loginAccount + "");
            UserTrackAdapter.sendUT(getPageName(), UTConstant.CustomEvent.UT_SINGLE_LOGIN_COMMIT, "", str, properties);
        }
        try {
            ActivityUIHelper activityUIHelper = this.mActivityHelper;
            if (activityUIHelper != null) {
                activityUIHelper.hideInputMethod();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.mMaskMobile)) {
            this.mNickLoginPresenter.buildSMSLoginParam(this.loginParam.loginAccount, this.mSmsCodeView.getText(), false);
            this.mNickLoginPresenter.login();
            return;
        }
        this.mPresenter.buildSMSLoginParam(this.loginParam.loginAccount, this.mSmsCodeView.getText(), false);
        this.mPresenter.login();
    }

    protected void switchLoginModeHit(LoginModeState loginModeState) {
        int i = AnonymousClass11.$SwitchMap$com$ali$user$mobile$login$ui$LoginModeState[loginModeState.ordinal()];
        if (i == 1) {
            UserTrackAdapter.sendControlUT(getPageName(), getPageSpm(), "chooseother_sms", "");
        } else if (i == 2) {
            UserTrackAdapter.sendControlUT(getPageName(), getPageSpm(), "chooseother_pwd", "");
        } else if (i == 3) {
            UserTrackAdapter.sendControlUT(getPageName(), getPageSpm(), "chooseother_onekey", "");
        } else if (i != 4) {
        } else {
            UserTrackAdapter.sendControlUT(getPageName(), getPageSpm(), "chooseother_face", "");
        }
    }
}
