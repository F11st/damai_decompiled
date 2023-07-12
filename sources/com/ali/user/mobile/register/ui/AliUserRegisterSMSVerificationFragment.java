package com.ali.user.mobile.register.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.ui.BaseActivity;
import com.ali.user.mobile.base.ui.BaseFragment;
import com.ali.user.mobile.common.api.AliUserLogin;
import com.ali.user.mobile.common.api.LoginApprearanceExtensions;
import com.ali.user.mobile.data.model.SmsApplyResult;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.RegionInfo;
import com.ali.user.mobile.model.RegistParam;
import com.ali.user.mobile.navigation.NavigatorManager;
import com.ali.user.mobile.register.RegistConstants;
import com.ali.user.mobile.register.model.OceanRegisterParam;
import com.ali.user.mobile.register.presenter.MobileRegisterPresenter;
import com.ali.user.mobile.register.ui.AliUserSmsCodeView;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.service.NavigatorService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.ui.widget.CountDownButton;
import com.ali.user.mobile.utils.ElderUtil;
import com.ali.user.mobile.utils.ProtocolHelper;
import com.ali.user.mobile.utils.UTConstans;
import com.alibaba.fastjson.JSON;
import com.taobao.login4android.config.LoginSwitch;
import java.util.List;
import java.util.Properties;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class AliUserRegisterSMSVerificationFragment extends BaseFragment implements View.OnClickListener, RegisterFormView {
    public static final String TAG = "login.numAuthReg";
    protected String codeLength;
    protected boolean isVoice = false;
    protected String mAreaCode;
    protected String mCountryCode;
    protected String mMobileNum;
    protected MobileRegisterPresenter mPresenter;
    protected CountDownButton mSendSMSCodeBtn;
    protected AliUserSmsCodeView mSmsCodeView;
    protected OceanRegisterParam mTraceParam;
    protected String mVideoUrl;
    protected TextView mVoiceTV;
    protected String regionInfoStr;

    private void addShowVoice(final int i) {
        this.mSendSMSCodeBtn.setTickListener(new CountDownButton.CountListener() { // from class: com.ali.user.mobile.register.ui.AliUserRegisterSMSVerificationFragment.2
            @Override // com.ali.user.mobile.ui.widget.CountDownButton.CountListener
            public void onTick(long j) {
                if (i != j / 1000 || AliUserRegisterSMSVerificationFragment.this.mVoiceTV == null) {
                    return;
                }
                if (LoginSwitch.getSwitch("show_voice_tv", "true")) {
                    AliUserRegisterSMSVerificationFragment.this.mVoiceTV.setVisibility(0);
                } else {
                    AliUserRegisterSMSVerificationFragment.this.mVoiceTV.setVisibility(8);
                }
            }
        });
    }

    private void initParams() {
        String str;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mMobileNum = arguments.getString(RegistConstants.REGISTER_MOBILE_NUM);
            str = arguments.getString("session_id");
            try {
                this.codeLength = arguments.getString(RegistConstants.REGISTER_CODE_LENGTH);
                String string = arguments.getString(RegistConstants.REGION_INFO);
                this.regionInfoStr = string;
                RegionInfo regionInfo = (RegionInfo) JSON.parseObject(string, RegionInfo.class);
                if (regionInfo != null) {
                    this.mAreaCode = regionInfo.code;
                    this.mCountryCode = regionInfo.domain;
                }
                this.mTraceParam = (OceanRegisterParam) JSON.parseObject(arguments.getString(RegistConstants.REGISTER_TRACE_PARAM), OceanRegisterParam.class);
                this.mVideoUrl = arguments.getString("url", this.mVideoUrl);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            str = "";
        }
        this.mPresenter = new MobileRegisterPresenter(this);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mPresenter.setSessionId(str);
    }

    protected OceanRegisterParam buildRegisterParam() {
        OceanRegisterParam oceanRegisterParam = new OceanRegisterParam();
        oceanRegisterParam.mobileNum = this.mMobileNum;
        oceanRegisterParam.checkCode = this.mSmsCodeView.getText();
        oceanRegisterParam.countryCode = TextUtils.isEmpty(this.mCountryCode) ? "CN" : this.mCountryCode;
        if (this.isVoice) {
            oceanRegisterParam.sendType = "voice";
        } else {
            oceanRegisterParam.sendType = "";
        }
        OceanRegisterParam oceanRegisterParam2 = this.mTraceParam;
        if (oceanRegisterParam2 != null) {
            oceanRegisterParam.loginSourcePage = oceanRegisterParam2.loginSourcePage;
            oceanRegisterParam.loginSourceType = oceanRegisterParam2.loginSourceType;
            oceanRegisterParam.traceId = oceanRegisterParam2.traceId;
        }
        return oceanRegisterParam;
    }

    protected RegistParam createBaseRegisterParam() {
        return new RegistParam();
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    protected int getLayoutContent() {
        return R.C2965layout.aliuser_fragment_register_sms_verification;
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public String getPageName() {
        return UTConstans.PageName.UT_PAGE_SMS_CODE;
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public String getPageSpm() {
        return UTConstans.PageName.F_REG_CODE;
    }

    @Override // com.ali.user.mobile.register.ui.RegisterFormView
    public String getRegType() {
        return UTConstant.Args.UT_MOBILE_REG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.base.ui.BaseFragment
    public void initViews(View view) {
        String string;
        super.initViews(view);
        try {
            if (getActivity() != null && ((BaseActivity) getActivity()).getSupportActionBar() != null) {
                ((BaseActivity) getActivity()).getSupportActionBar().setTitle("");
                ((BaseActivity) getActivity()).setNavigationBackIcon();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        TextView textView = (TextView) view.findViewById(R.id.aliuser_register_sms_code_secondary_title_tv);
        if (!TextUtils.isEmpty(this.mAreaCode) && !TextUtils.isEmpty(this.mMobileNum)) {
            String str = this.mMobileNum;
            if (TextUtils.equals(this.mAreaCode, "+86") && !TextUtils.isEmpty(this.mMobileNum) && this.mMobileNum.length() == 11) {
                int i = R.string.aliuser_sms_code_secondary_title;
                string = getString(i, " " + (this.mMobileNum.substring(0, 3) + ' ' + this.mMobileNum.substring(3, 7) + ' ' + this.mMobileNum.substring(7, 11)));
            } else {
                string = getString(R.string.aliuser_sms_code_secondary_title, " " + this.mAreaCode + " " + str);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
            try {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#111111")), 7, string.length() - 10, 33);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            textView.setText(spannableStringBuilder);
        }
        AliUserSmsCodeView aliUserSmsCodeView = (AliUserSmsCodeView) view.findViewById(R.id.aliuser_register_sms_code_view);
        this.mSmsCodeView = aliUserSmsCodeView;
        if (aliUserSmsCodeView != null && !TextUtils.isEmpty(this.codeLength)) {
            this.mSmsCodeView.setTextCount(Integer.parseInt(this.codeLength));
        }
        this.mSmsCodeView.setOnCompletedListener(new AliUserSmsCodeView.OnCompletedListener() { // from class: com.ali.user.mobile.register.ui.AliUserRegisterSMSVerificationFragment.1
            @Override // com.ali.user.mobile.register.ui.AliUserSmsCodeView.OnCompletedListener
            public void onCompleted(String str2) {
                AliUserRegisterSMSVerificationFragment.this.submitRegisterForm();
            }
        });
        this.mSmsCodeView.focus();
        CountDownButton countDownButton = (CountDownButton) view.findViewById(R.id.aliuser_register_send_smscode_btn);
        this.mSendSMSCodeBtn = countDownButton;
        countDownButton.setOnClickListener(this);
        this.mSendSMSCodeBtn.setGetCodeTitle(R.string.aliuser_signup_verification_reGetCode2);
        this.mSendSMSCodeBtn.setTickTitleRes(R.string.aliuser_sms_code_success_hint2);
        this.mSendSMSCodeBtn.startCountDown(DateUtils.MILLIS_PER_MINUTE, 1000L);
        try {
            TextView textView2 = (TextView) view.findViewById(R.id.aliuser_register_send_voicecode_tv);
            this.mVoiceTV = textView2;
            if (textView2 != null) {
                textView2.setOnClickListener(this);
            }
            addShowVoice(29);
            TextView textView3 = (TextView) view.findViewById(R.id.aliuser_reg_operational_location_tv);
            if (textView3 != null) {
                ProtocolHelper.setRegOperationText(textView3);
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
        if (this.needAdaptElder) {
            ElderUtil.scaleTextSize(this.mSendSMSCodeBtn, this.mVoiceTV, textView);
        }
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment, com.ali.user.mobile.base.BaseView
    public boolean isActive() {
        return isActivityAvaiable();
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    public boolean onBackPressed() {
        alert(getString(R.string.aliuser_exit_smscode_hint), "", getString(R.string.aliuser_wait_a_moment), new DialogInterface.OnClickListener() { // from class: com.ali.user.mobile.register.ui.AliUserRegisterSMSVerificationFragment.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                AliUserRegisterSMSVerificationFragment.this.addControl(UTConstans.Controls.UT_REG_BACK_BUTTON_CANCEL);
            }
        }, getString(R.string.aliuser_text_back), new DialogInterface.OnClickListener() { // from class: com.ali.user.mobile.register.ui.AliUserRegisterSMSVerificationFragment.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                AliUserRegisterSMSVerificationFragment.this.addControl(UTConstans.Controls.UT_REG_BACK_BUTTON_CLICK);
                if (AliUserRegisterSMSVerificationFragment.this.getActivity() != null) {
                    Properties properties = new Properties();
                    properties.setProperty("monitor", "T");
                    UserTrackAdapter.sendUT(AliUserRegisterSMSVerificationFragment.this.getPageName(), "single_register_cancel", "", AliUserRegisterSMSVerificationFragment.this.getRegType(), properties);
                    Intent intent = new Intent();
                    intent.putExtra(RegistConstants.REGISTER_MOBILE_NUM, AliUserRegisterSMSVerificationFragment.this.mMobileNum);
                    intent.putExtra(RegistConstants.REGION_INFO, AliUserRegisterSMSVerificationFragment.this.regionInfoStr);
                    MobileRegisterPresenter mobileRegisterPresenter = AliUserRegisterSMSVerificationFragment.this.mPresenter;
                    intent.putExtra("session_id", mobileRegisterPresenter != null ? mobileRegisterPresenter.getSessionId() : "");
                    intent.putExtra(RegistConstants.REGISTER_CODE_LENGTH, AliUserRegisterSMSVerificationFragment.this.codeLength);
                    intent.putExtra("check", true);
                    ((AliUserRegisterActivity) AliUserRegisterSMSVerificationFragment.this.getActivity()).changeFragmentByConfig(intent);
                }
            }
        });
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.aliuser_register_send_smscode_btn) {
            this.isVoice = false;
            sendCodeAction();
            this.mSendSMSCodeBtn.setBackgroundDrawable(null);
        } else if (id == R.id.aliuser_register_send_voicecode_tv) {
            this.isVoice = true;
            this.mSendSMSCodeBtn.cancelCountDown();
            addShowVoice(0);
            sendCodeAction();
            TextView textView = this.mVoiceTV;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initParams();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menu.clear();
        menuInflater.inflate(R.C2966menu.aliuser_menu, menu);
        if (!TextUtils.isEmpty(this.mVideoUrl)) {
            try {
                menu.findItem(R.id.aliuser_menu_item_help).setTitle(new SpannableString(getResources().getString(R.string.aliuser_sms_need_help)));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        super.onCreateOptionsMenu(menu, menuInflater);
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
            loginParam.loginSourceSpm = oceanRegisterParam.loginSourceSpm;
            loginParam.loginSourceType = oceanRegisterParam.loginSourceType;
            loginParam.traceId = oceanRegisterParam.traceId;
        }
        NavigatorManager.getInstance().navToRegWebViewPage(this.mAttachedActivity, str, getPageName(), getRegType(), loginParam);
    }

    @Override // com.ali.user.mobile.register.ui.RegisterFormView
    public void onNumAuthRegisterFail(RpcResponse rpcResponse) {
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.aliuser_menu_item_help) {
            openHelp();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        UserTrackAdapter.pageDisAppear(getActivity());
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        int i = R.id.aliuser_menu_item_help;
        if (menu.findItem(i) != null) {
            int i2 = R.id.aliuser_menu_item_more;
            if (menu.findItem(i2) != null) {
                menu.findItem(i2).setVisible(false);
                LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
                if (loginApprearanceExtensions != null && !loginApprearanceExtensions.needHelp()) {
                    menu.findItem(i).setVisible(false);
                } else {
                    menu.findItem(i).setVisible(true);
                }
            }
        }
        super.onPrepareOptionsMenu(menu);
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
        UserTrackAdapter.sendUT(getPageName(), "single_register_success", "", getRegType(), properties);
        ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).navToLoginPage(this.mAttachedActivity, JSON.toJSONString(loginParam), true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        UserTrackAdapter.updatePageName(getActivity(), getPageName());
    }

    @Override // com.ali.user.mobile.register.ui.RegisterFormView
    public void onSMSSendFail(RpcResponse rpcResponse) {
        AliUserSmsCodeView aliUserSmsCodeView;
        if (!isActive() || (aliUserSmsCodeView = this.mSmsCodeView) == null) {
            return;
        }
        aliUserSmsCodeView.clearText();
        if (rpcResponse != null && !TextUtils.isEmpty(rpcResponse.message)) {
            toast(rpcResponse.message, 0);
        }
        Properties properties = new Properties();
        properties.setProperty("monitor", "T");
        String pageName = getPageName();
        String str = "";
        if (rpcResponse != null) {
            str = rpcResponse.code + "";
        }
        UserTrackAdapter.sendUT(pageName, UTConstans.CustomEvent.UT_SMS_SEND_FAIL, str, getRegType(), properties);
    }

    protected void onSendSMSAction() {
        this.mPresenter.sendSMS(createBaseRegisterParam(), buildRegisterParam());
    }

    @Override // com.ali.user.mobile.register.ui.RegisterFormView
    public void onSendSMSSuccess(long j, SmsApplyResult smsApplyResult) {
        CountDownButton countDownButton;
        if (!isActive() || (countDownButton = this.mSendSMSCodeBtn) == null) {
            return;
        }
        countDownButton.startCountDown(j, 1000L);
        if ("voice".equals(smsApplyResult.sendType)) {
            this.mVideoUrl = null;
        } else if (TextUtils.isEmpty(smsApplyResult.helpVideoUrl)) {
        } else {
            this.mVideoUrl = smsApplyResult.helpVideoUrl;
        }
    }

    protected void openHelp() {
        if (TextUtils.isEmpty(this.mVideoUrl)) {
            addControl("Button-Help");
            AliUserRegisterActivity.goRegHelp(getBaseActivity());
            return;
        }
        addControl("Button-Help-Video");
        NavigatorManager.getInstance().navToTransparentWeb(getActivity(), this.mVideoUrl);
    }

    protected void sendCodeAction() {
        AliUserSmsCodeView aliUserSmsCodeView = this.mSmsCodeView;
        if (aliUserSmsCodeView != null) {
            aliUserSmsCodeView.clearText();
        }
        TextView textView = this.mVoiceTV;
        if (textView != null) {
            textView.setVisibility(8);
        }
        UserTrackAdapter.sendControlUT(getPageName(), getPageSpm(), "Button-SendSms", TextUtils.isEmpty(this.mMobileNum) ? "" : this.mMobileNum);
        try {
            onSendSMSAction();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void submitRegisterForm() {
        Properties properties = new Properties();
        properties.setProperty("type", UTConstant.Args.UT_MOBILE_REG);
        properties.setProperty("monitor", "T");
        UserTrackAdapter.sendUT(getPageName(), UTConstans.CustomEvent.UT_REG_RPC_COMMIT, "", UTConstant.Args.UT_MOBILE_REG, properties);
        UserTrackAdapter.sendUT(getPageName(), "single_register_commit", "", getRegType(), properties);
        this.mPresenter.register(createBaseRegisterParam(), buildRegisterParam());
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    public void toast(String str, int i) {
        if (getActivity() != null) {
            Toast.makeText(getActivity(), str, i).show();
        }
    }
}
