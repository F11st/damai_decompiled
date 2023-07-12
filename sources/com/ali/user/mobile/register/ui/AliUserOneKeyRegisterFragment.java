package com.ali.user.mobile.register.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.ui.BaseActivity;
import com.ali.user.mobile.base.ui.BaseFragment;
import com.ali.user.mobile.common.api.AliUserLogin;
import com.ali.user.mobile.common.api.LoginApprearanceExtensions;
import com.ali.user.mobile.data.model.SmsApplyResult;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.ui.LoginClickAction;
import com.ali.user.mobile.model.AliValidRequest;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.NumAuthTokenCallback;
import com.ali.user.mobile.model.RegionInfo;
import com.ali.user.mobile.navigation.NavigatorManager;
import com.ali.user.mobile.register.ProtocolModel;
import com.ali.user.mobile.register.RegistConstants;
import com.ali.user.mobile.register.model.OceanRegisterParam;
import com.ali.user.mobile.register.presenter.MobileRegisterPresenter;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.service.NavigatorService;
import com.ali.user.mobile.service.NumberAuthService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.utils.ElderUtil;
import com.ali.user.mobile.utils.ProtocolHelper;
import com.ali.user.mobile.utils.UTConstans;
import com.alibaba.fastjson.JSON;
import com.taobao.login4android.ui.TaobaoRegProtocolDialogFragment;
import com.ut.mini.UTAnalytics;
import com.youku.alixplayer.opensdk.statistics.StaticsUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class AliUserOneKeyRegisterFragment extends BaseFragment implements View.OnClickListener, RegisterFormView {
    public static final String TAG = "login.numAuthReg";
    protected String mAreaCode;
    protected boolean mCheckBoxSwitch;
    protected String mCountryCode;
    protected String mMobileNum;
    protected String mOneKeyMobileNum;
    protected String mOneKeyProtocolTitle;
    protected String mOneKeyProtocolUrl;
    protected Button mOneKeyRegBtn;
    protected MobileRegisterPresenter mPresenter;
    protected boolean mPreviousChecked;
    protected CheckBox mProtocolCB;
    protected TextView mProtocolView;
    protected TextView mShowIdTextView;
    protected TextView mSwitchMobileRegTV;
    protected OceanRegisterParam mTraceParam = new OceanRegisterParam();
    private long lastClickRegisterBtnTime = 0;

    private void initParams() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            try {
                this.mAreaCode = arguments.getString(RegistConstants.REGISTER_AREA_CODE);
                this.mMobileNum = arguments.getString(RegistConstants.REGISTER_MOBILE_NUM);
                this.mCountryCode = arguments.getString(RegistConstants.REGISTER_COUNTRY_CODE);
                this.mPreviousChecked = arguments.getBoolean("check");
                this.mOneKeyMobileNum = arguments.getString("number", "");
                this.mOneKeyProtocolTitle = arguments.getString("protocolName", "");
                this.mOneKeyProtocolUrl = arguments.getString("protocolURL", "");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void addCheckAction(int i) {
        if (this.mCheckBoxSwitch) {
            onCheckLogin(i);
        } else {
            doRealAction(i);
        }
    }

    protected OceanRegisterParam buildRegisterParam() {
        OceanRegisterParam oceanRegisterParam = new OceanRegisterParam();
        OceanRegisterParam oceanRegisterParam2 = this.mTraceParam;
        if (oceanRegisterParam2 != null) {
            oceanRegisterParam.loginSourcePage = oceanRegisterParam2.loginSourcePage;
            oceanRegisterParam.loginSourceType = oceanRegisterParam2.loginSourceType;
            oceanRegisterParam.traceId = oceanRegisterParam2.traceId;
        }
        return oceanRegisterParam;
    }

    protected void createPresenter() {
        this.mPresenter = new MobileRegisterPresenter(this);
    }

    public void doRealAction(int i) {
        if (i == LoginClickAction.ACTION_REG) {
            registerAction();
        }
    }

    protected void generateProtocol() {
        ProtocolHelper.generateProtocol(getProtocolModel(), this.mAttachedActivity, this.mProtocolView, getPageName(), getPageSpm(), false);
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    protected int getLayoutContent() {
        return R.C2965layout.aliuser_fragment_onekey_register;
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public String getPageName() {
        return UTConstans.PageName.UT_PAGE_ONEKEY_REG_NEW;
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public String getPageSpm() {
        return UTConstans.PageName.F_ONEKEY_REG;
    }

    protected ProtocolModel getProtocolModel() {
        return ProtocolHelper.getProtocolModel(getActivity(), this.mOneKeyProtocolTitle, this.mOneKeyProtocolUrl);
    }

    @Override // com.ali.user.mobile.register.ui.RegisterFormView
    public String getRegType() {
        return "oneKeyRegister";
    }

    protected TaobaoRegProtocolDialogFragment getRrotocolFragment() {
        return new TaobaoRegProtocolDialogFragment();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.base.ui.BaseFragment
    public void initViews(View view) {
        try {
            ((BaseActivity) getActivity()).getSupportActionBar().setTitle("");
            ((BaseActivity) getActivity()).setNavigationCloseIcon();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            TextView textView = (TextView) view.findViewById(R.id.aliuser_onekey_reg_account_tv);
            this.mShowIdTextView = textView;
            if (textView != null && !TextUtils.isEmpty(this.mOneKeyMobileNum)) {
                this.mShowIdTextView.setText(this.mOneKeyMobileNum);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        Button button = (Button) view.findViewById(R.id.aliuser_onekey_reg_btn);
        this.mOneKeyRegBtn = button;
        button.setOnClickListener(this);
        TextView textView2 = (TextView) view.findViewById(R.id.aliuser_switch_mobile_reg);
        this.mSwitchMobileRegTV = textView2;
        textView2.setOnClickListener(this);
        this.mProtocolView = (TextView) view.findViewById(R.id.aliuser_protocol_tv);
        try {
            this.mCheckBoxSwitch = true;
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.aliuser_reg_checkbox);
            this.mProtocolCB = checkBox;
            ProtocolHelper.setCheckBox(this, checkBox, getPageName(), getPageSpm(), this.mCheckBoxSwitch, this.mPreviousChecked);
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
        generateProtocol();
        TextView textView3 = (TextView) view.findViewById(R.id.aliuser_reg_func_menu);
        if (textView3 != null) {
            LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
            if (loginApprearanceExtensions != null && !loginApprearanceExtensions.needHelp()) {
                textView3.setVisibility(8);
            } else {
                textView3.setVisibility(0);
                textView3.setOnClickListener(this);
            }
        }
        if (this.needAdaptElder) {
            ElderUtil.scaleTextSize(this.mOneKeyRegBtn, this.mSwitchMobileRegTV, this.mShowIdTextView, this.mProtocolView, textView3);
        }
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment, com.ali.user.mobile.base.BaseView
    public boolean isActive() {
        return isActivityAvaiable();
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    public boolean onBackPressed() {
        alert(getString(R.string.aliuser_onekey_reg_retain_title), "", getString(R.string.aliuser_reg_continue), new DialogInterface.OnClickListener() { // from class: com.ali.user.mobile.register.ui.AliUserOneKeyRegisterFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                AliUserOneKeyRegisterFragment.this.addControl(UTConstans.Controls.UT_REG_BACK_BUTTON_CANCEL);
            }
        }, getString(R.string.aliuser_exit), new DialogInterface.OnClickListener() { // from class: com.ali.user.mobile.register.ui.AliUserOneKeyRegisterFragment.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                AliUserOneKeyRegisterFragment.this.addControl(UTConstans.Controls.UT_REG_BACK_BUTTON_CLICK);
                if (AliUserOneKeyRegisterFragment.this.getActivity() != null) {
                    AliUserOneKeyRegisterFragment.this.getActivity().finish();
                }
            }
        });
        return true;
    }

    protected void onCheckLogin(final int i) {
        CheckBox checkBox;
        if (this.mCheckBoxSwitch && (checkBox = this.mProtocolCB) != null && !checkBox.isChecked()) {
            UserTrackAdapter.sendUT(getPageName(), "RegAgreement");
            final TaobaoRegProtocolDialogFragment rrotocolFragment = getRrotocolFragment();
            rrotocolFragment.setNeedAdaptElder(true);
            rrotocolFragment.setFirst(false);
            rrotocolFragment.setPostiveBtnText(getString(R.string.aliuser_agree));
            rrotocolFragment.setNegativeBtnText(getString(R.string.aliuser_protocol_disagree));
            rrotocolFragment.setNagetive(new View.OnClickListener() { // from class: com.ali.user.mobile.register.ui.AliUserOneKeyRegisterFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AliUserOneKeyRegisterFragment.this.isActive()) {
                        UserTrackAdapter.sendControlUT(AliUserOneKeyRegisterFragment.this.getPageName(), "Agreement_Button_Cancel");
                        rrotocolFragment.dismissAllowingStateLoss();
                    }
                }
            });
            rrotocolFragment.setPositive(new View.OnClickListener() { // from class: com.ali.user.mobile.register.ui.AliUserOneKeyRegisterFragment.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AliUserOneKeyRegisterFragment.this.isActive()) {
                        UserTrackAdapter.sendControlUT(AliUserOneKeyRegisterFragment.this.getPageName(), "Agreement_Button_Agree");
                        rrotocolFragment.dismissAllowingStateLoss();
                        AliUserOneKeyRegisterFragment.this.mProtocolCB.setChecked(true);
                        AliUserOneKeyRegisterFragment.this.doRealAction(i);
                    }
                }
            });
            rrotocolFragment.show(getActivity().getSupportFragmentManager(), getPageName());
            return;
        }
        doRealAction(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.aliuser_onekey_reg_btn) {
            addCheckAction(LoginClickAction.ACTION_REG);
        } else if (id == R.id.aliuser_switch_mobile_reg) {
            addControl(UTConstans.Controls.UT_OTHER_NUMBERS);
            switchToMobileRegPage();
        } else if (id == R.id.aliuser_reg_func_menu) {
            addControl(UTConstans.Controls.UT_HELP);
            openHelp();
        }
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        createPresenter();
        initParams();
    }

    @Override // com.ali.user.mobile.base.BaseView
    public void onGetRegion(List<RegionInfo> list) {
    }

    @Override // com.ali.user.mobile.register.ui.RegisterFormView
    public void onH5(String str) {
        LoginParam loginParam = new LoginParam();
        OceanRegisterParam oceanRegisterParam = this.mTraceParam;
        if (oceanRegisterParam != null) {
            loginParam.loginSourcePage = oceanRegisterParam.loginSourcePage;
            loginParam.loginSourceType = oceanRegisterParam.loginSourceType;
            loginParam.traceId = oceanRegisterParam.traceId;
        }
        NavigatorManager.getInstance().navToRegWebViewPage(this.mAttachedActivity, str, getPageName(), getRegType(), loginParam);
    }

    @Override // com.ali.user.mobile.register.ui.RegisterFormView
    public void onNumAuthRegisterFail(RpcResponse rpcResponse) {
        String str;
        String str2 = rpcResponse == null ? "" : rpcResponse.message;
        if (TextUtils.isEmpty(str2)) {
            str2 = getString(R.string.aliuser_onekey_reg_fail_tip);
        }
        toast(str2, 0);
        Properties properties = new Properties();
        properties.setProperty("monitor", "T");
        String pageName = getPageName();
        if (rpcResponse == null) {
            str = StaticsUtil.PLAY_CODE_100;
        } else {
            str = rpcResponse.code + "";
        }
        UserTrackAdapter.sendUT(pageName, UTConstans.CustomEvent.UT_REG_RPC_FAILURE, str, getRegType(), properties);
        UserTrackAdapter.sendUT(getPageName(), "to_mobile_reg");
        switchToMobileRegPage();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        UserTrackAdapter.pageDisAppear(getActivity());
    }

    @Override // com.ali.user.mobile.register.ui.RegisterFormView
    public void onRegisterFail(int i, String str) {
        Properties properties = new Properties();
        properties.setProperty("monitor", "T");
        UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "single_register_failure", String.valueOf(i), getRegType(), properties);
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.aliuser_sever_error);
        }
        toast(str, 0);
    }

    @Override // com.ali.user.mobile.register.ui.RegisterFormView
    public void onRegisterSuccess(String str) {
        LoginParam loginParam = new LoginParam();
        loginParam.token = str;
        loginParam.scene = "1012";
        loginParam.tokenType = UTConstant.CustomEvent.UT_TYPE_SMS_LOGIN_TO_REG;
        loginParam.loginSite = DataProviderFactory.getDataProvider().getSite();
        OceanRegisterParam oceanRegisterParam = this.mTraceParam;
        if (oceanRegisterParam != null) {
            loginParam.loginSourcePage = oceanRegisterParam.loginSourcePage;
            loginParam.loginSourceSpm = oceanRegisterParam.loginSourceSpm;
            loginParam.loginSourceType = oceanRegisterParam.loginSourceType;
            loginParam.traceId = oceanRegisterParam.traceId;
        }
        Properties properties = new Properties();
        properties.setProperty("sdkTraceId", loginParam.traceId + "");
        properties.setProperty("monitor", "T");
        properties.setProperty("loginId", loginParam.loginAccount + "");
        properties.setProperty("site", DataProviderFactory.getDataProvider().getSite() + "");
        UserTrackAdapter.sendUT(getPageName(), UTConstant.CustomEvent.UT_SINGLE_LOGIN_COMMIT, "", getRegType(), properties);
        UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "single_register_success", "", getRegType(), properties);
        ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).navToLoginPage(this.mAttachedActivity, JSON.toJSONString(loginParam), true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        UTAnalytics.getInstance().getDefaultTracker().updatePageProperties(getActivity(), new HashMap());
        UserTrackAdapter.updatePageName(getActivity(), getPageName());
    }

    @Override // com.ali.user.mobile.register.ui.RegisterFormView
    public void onSMSSendFail(RpcResponse rpcResponse) {
    }

    @Override // com.ali.user.mobile.register.ui.RegisterFormView
    public void onSendSMSSuccess(long j, SmsApplyResult smsApplyResult) {
    }

    protected void openHelp() {
        AliUserRegisterActivity.goRegHelp(getBaseActivity());
    }

    protected void registerAction() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastClickRegisterBtnTime < 1000) {
            return;
        }
        this.lastClickRegisterBtnTime = currentTimeMillis;
        OceanRegisterParam oceanRegisterParam = new OceanRegisterParam();
        this.mTraceParam = oceanRegisterParam;
        oceanRegisterParam.loginSourcePage = getPageName();
        this.mTraceParam.loginSourceSpm = getPageSpm();
        this.mTraceParam.loginSourceType = "oneKeyRegister";
        String generateTraceId = ApiReferer.generateTraceId("oneKeyRegister", getPageName());
        this.mTraceParam.traceId = generateTraceId;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("sdkTraceId", generateTraceId);
            UserTrackAdapter.control(getPageName(), getPageSpm(), UTConstans.Controls.UT_REG_BTN, "", hashMap);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (ServiceFactory.getService(NumberAuthService.class) != null) {
            showLoading();
            final Properties properties = new Properties();
            properties.setProperty("monitor", "T");
            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "get_onekey_login_token_commit", "", getRegType(), properties);
            ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).getLoginToken("openRegView", new NumAuthTokenCallback() { // from class: com.ali.user.mobile.register.ui.AliUserOneKeyRegisterFragment.1
                @Override // com.ali.user.mobile.model.NumAuthTokenCallback
                public void onGetAuthTokenFail(int i, String str) {
                    Properties properties2 = new Properties();
                    properties2.setProperty("code", i + "");
                    properties2.setProperty("cause", str + "");
                    UserTrackAdapter.sendUT(AliUserOneKeyRegisterFragment.this.getPageName(), UTConstans.CustomEvent.UT_REG_GET_ACCESSCODE_FAIL, properties2);
                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "get_onekey_login_token_failure", "", AliUserOneKeyRegisterFragment.this.getRegType(), properties);
                    if (AliUserOneKeyRegisterFragment.this.isActive()) {
                        AliUserOneKeyRegisterFragment.this.dismissLoading();
                        AliUserOneKeyRegisterFragment aliUserOneKeyRegisterFragment = AliUserOneKeyRegisterFragment.this;
                        aliUserOneKeyRegisterFragment.toast(aliUserOneKeyRegisterFragment.getString(R.string.aliuser_onekey_reg_fail_tip), 0);
                        AliUserOneKeyRegisterFragment.this.switchToMobileRegPage();
                    }
                }

                @Override // com.ali.user.mobile.model.NumAuthTokenCallback
                public void onGetAuthTokenSuccess(String str) {
                    Properties properties2 = new Properties();
                    if (AliUserOneKeyRegisterFragment.this.mTraceParam != null) {
                        properties2.setProperty("sdkTraceId", AliUserOneKeyRegisterFragment.this.mTraceParam.traceId + "");
                    }
                    UserTrackAdapter.sendUT(AliUserOneKeyRegisterFragment.this.getPageName(), UTConstans.CustomEvent.UT_REG_GET_ACCESSCODE_SUCCESS, properties2);
                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "get_onekey_login_token_success", "", AliUserOneKeyRegisterFragment.this.getRegType(), properties);
                    if (AliUserOneKeyRegisterFragment.this.isActivityAvaiable()) {
                        try {
                            AliValidRequest aliValidRequest = new AliValidRequest();
                            aliValidRequest.vendorAccessToken = str;
                            AliUserOneKeyRegisterFragment aliUserOneKeyRegisterFragment = AliUserOneKeyRegisterFragment.this;
                            aliUserOneKeyRegisterFragment.mPresenter.numAuthRegister(aliValidRequest, aliUserOneKeyRegisterFragment.buildRegisterParam());
                            Properties properties3 = new Properties();
                            properties3.setProperty("monitor", "T");
                            UserTrackAdapter.sendUT(AliUserOneKeyRegisterFragment.this.getPageName(), UTConstans.CustomEvent.UT_REG_RPC_COMMIT, "", AliUserOneKeyRegisterFragment.this.getRegType(), properties3);
                            UserTrackAdapter.sendUT(AliUserOneKeyRegisterFragment.this.getPageName(), "single_register_commit", "", AliUserOneKeyRegisterFragment.this.getRegType(), properties3);
                        } catch (Throwable unused) {
                            AliUserOneKeyRegisterFragment.this.dismissLoading();
                            AliUserOneKeyRegisterFragment.this.switchToMobileRegPage();
                        }
                    }
                }
            });
        }
    }

    protected void switchToMobileRegPage() {
        if (getActivity() != null) {
            Intent intent = new Intent();
            CheckBox checkBox = this.mProtocolCB;
            if (checkBox != null) {
                intent.putExtra("check", checkBox.isChecked());
            }
            ((AliUserRegisterActivity) getActivity()).gotoTwoStepMobileRegFragment(intent);
        }
    }
}
