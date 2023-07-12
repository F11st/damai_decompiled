package com.ali.user.mobile.register.ui;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.ui.BaseFragment;
import com.ali.user.mobile.common.api.AliUserLogin;
import com.ali.user.mobile.common.api.LoginApprearanceExtensions;
import com.ali.user.mobile.data.model.SmsApplyResult;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.presenter.RegionPresenter;
import com.ali.user.mobile.login.ui.LoginClickAction;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.RegionInfo;
import com.ali.user.mobile.navigation.NavigatorManager;
import com.ali.user.mobile.register.ProtocolModel;
import com.ali.user.mobile.register.RegistConstants;
import com.ali.user.mobile.register.model.OceanRegisterParam;
import com.ali.user.mobile.register.presenter.MobileRegisterPresenter;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.service.NavigatorService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.ui.widget.CountDownButton;
import com.ali.user.mobile.utils.CountryUtil;
import com.ali.user.mobile.utils.ElderUtil;
import com.ali.user.mobile.utils.ProtocolHelper;
import com.ali.user.mobile.utils.UTConstans;
import com.ali.user.mobile.webview.WebViewActivity;
import com.alibaba.fastjson.JSON;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.ui.TaobaoRegProtocolDialogFragment;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Pattern;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class AliUserMobileRegisterFragment extends BaseFragment implements View.OnClickListener, RegisterFormView {
    public static final Pattern REG_EMAIL = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
    public static final int SMS2VOCIE_TIME = 29;
    public static final int SMS_2VOICE_CLICK_TIME = 0;
    protected boolean mCheckBoxSwitch;
    protected EditText mEmailET;
    protected View mMobileClearBtn;
    protected EditText mMobileET;
    protected String mMobileStr;
    protected TextWatcher mMobileTextWatcher;
    protected EditText mPasswordET;
    protected TextView mPasswordHint;
    protected MobileRegisterPresenter mPresenter;
    protected boolean mPreviousChecked;
    protected CheckBox mProtocolCB;
    protected TextView mProtocolTV;
    protected Button mRegBtn;
    protected LinearLayout mRegBtnLL;
    protected ScrollView mRegScroll;
    protected RegionInfo mRegionInfo;
    protected RegionPresenter mRegionPresenter;
    protected TextView mRegionTV;
    protected EditText mSMSCodeET;
    protected CountDownButton mSendSMSCodeBtn;
    protected TextWatcher mSmsCodeTextWatcher;
    protected TextView mSmsSuccessTipTV;
    protected String mSource;
    protected TextView mWelcomeTV;
    protected boolean mobileCheckSimilarity = true;
    protected Pattern REG_PASSWORD = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)(?![`~!@#$%^&*()_\\-+=[{]};:',<.>/?|\\\"]+$)[!-~]{6,20}$");
    protected boolean isVoice = false;
    protected OceanRegisterParam mTraceParam = new OceanRegisterParam();
    private boolean mobileUT = true;
    private boolean checkcodeUT = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    @TargetApi(21)
    /* loaded from: classes17.dex */
    public class MobileTextWatcher extends PhoneNumberFormattingTextWatcher {
        private WeakReference<EditText> editText;

        @Override // android.telephony.PhoneNumberFormattingTextWatcher, android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            super.onTextChanged(charSequence, i, i2, i3);
            AliUserMobileRegisterFragment.this.checkRegAble(this.editText.get());
        }

        private MobileTextWatcher(EditText editText, String str) {
            super(str);
            this.editText = new WeakReference<>(editText);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class RegTextWatcher implements TextWatcher {
        private WeakReference<EditText> editText;

        public RegTextWatcher(EditText editText) {
            this.editText = new WeakReference<>(editText);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.editText.get().getId() == R.id.aliuser_register_mobile_et && AliUserMobileRegisterFragment.this.mMobileClearBtn != null) {
                if (charSequence != null && charSequence.length() != 0) {
                    if (AliUserMobileRegisterFragment.this.mobileUT) {
                        AliUserMobileRegisterFragment.this.mobileUT = false;
                        UserTrackAdapter.sendUT(AliUserMobileRegisterFragment.this.getPageName(), "InputPhone");
                    }
                    if (AliUserMobileRegisterFragment.this.mMobileClearBtn.getVisibility() != 0 && AliUserMobileRegisterFragment.this.mMobileClearBtn.isEnabled()) {
                        AliUserMobileRegisterFragment.this.mMobileClearBtn.setVisibility(0);
                    }
                } else if (AliUserMobileRegisterFragment.this.mMobileClearBtn.getVisibility() != 8) {
                    AliUserMobileRegisterFragment.this.mMobileClearBtn.setVisibility(8);
                }
            } else if (this.editText.get().getId() == R.id.aliuser_register_sms_code_et && charSequence != null && charSequence.length() > 0 && AliUserMobileRegisterFragment.this.checkcodeUT) {
                AliUserMobileRegisterFragment.this.checkcodeUT = false;
                UserTrackAdapter.sendUT(AliUserMobileRegisterFragment.this.getPageName(), "InputCode");
            }
            AliUserMobileRegisterFragment.this.checkRegAble(this.editText.get());
        }
    }

    private void applyRegion() {
        if (isActive()) {
            this.mRegionPresenter.region(1);
        }
    }

    public void addCheckAction(int i) {
        onCheckLogin(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adjustMobileETMaxLength() {
        RegionInfo regionInfo = this.mRegionInfo;
        if (regionInfo != null && TextUtils.equals("CN", regionInfo.domain)) {
            this.mMobileET.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
            if (Build.VERSION.SDK_INT >= 21) {
                TextWatcher textWatcher = this.mMobileTextWatcher;
                if (textWatcher != null) {
                    this.mMobileET.removeTextChangedListener(textWatcher);
                }
                MobileTextWatcher mobileTextWatcher = new MobileTextWatcher(this.mMobileET, Locale.CHINA.getCountry());
                this.mMobileTextWatcher = mobileTextWatcher;
                this.mMobileET.addTextChangedListener(mobileTextWatcher);
            }
        } else {
            this.mMobileET.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
            if (Build.VERSION.SDK_INT >= 21) {
                TextWatcher textWatcher2 = this.mMobileTextWatcher;
                if (textWatcher2 != null) {
                    this.mMobileET.removeTextChangedListener(textWatcher2);
                }
                RegTextWatcher regTextWatcher = new RegTextWatcher(this.mMobileET);
                this.mMobileTextWatcher = regTextWatcher;
                this.mMobileET.addTextChangedListener(regTextWatcher);
            }
        }
        this.mMobileET.setText(getMobile());
    }

    protected OceanRegisterParam buildRegisterParam() {
        EditText editText;
        EditText editText2;
        OceanRegisterParam oceanRegisterParam = new OceanRegisterParam();
        oceanRegisterParam.mobileNum = getMobile();
        EditText editText3 = this.mSMSCodeET;
        if (editText3 != null) {
            oceanRegisterParam.checkCode = editText3.getText().toString().trim();
        }
        oceanRegisterParam.countryCode = getCountryCode();
        if (DataProviderFactory.getDataProvider().enableRegEmailCheck() && (editText2 = this.mEmailET) != null) {
            oceanRegisterParam.email = editText2.getText().toString().trim();
        }
        if (DataProviderFactory.getDataProvider().enableRegPwdCheck() && (editText = this.mPasswordET) != null) {
            oceanRegisterParam.password = editText.getText().toString().trim();
        }
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
        if (this.mobileCheckSimilarity) {
            HashMap hashMap = new HashMap();
            oceanRegisterParam.externParams = hashMap;
            hashMap.put("mobileCheckSimilarity", "true");
        } else {
            oceanRegisterParam.externParams = new HashMap();
        }
        if (LoginSwitch.getSwitch("judgeBlock", "true")) {
            oceanRegisterParam.externParams.put("judgeBlock", "true");
        }
        return oceanRegisterParam;
    }

    protected void checkRegAble(EditText editText) {
        if (editText.getId() == R.id.aliuser_register_mobile_et) {
            if (!TextUtils.isEmpty(this.mMobileET.getText().toString()) && !this.mSendSMSCodeBtn.isCountDowning()) {
                this.mSendSMSCodeBtn.setEnabled(true);
            } else {
                this.mSendSMSCodeBtn.setEnabled(false);
            }
        }
        String obj = this.mSMSCodeET.getText().toString();
        if (!TextUtils.isEmpty(this.mMobileET.getText().toString()) && !TextUtils.isEmpty(obj) && obj.length() >= 4) {
            this.mRegBtn.setEnabled(true);
            return;
        }
        this.mRegBtn.setEnabled(false);
        this.mRegBtnLL.setBackgroundDrawable(null);
    }

    protected void clearMobile() {
        this.mMobileET.getEditableText().clear();
        this.mMobileET.setEnabled(true);
        this.isVoice = false;
        switchSendSMSTipVisibility(4);
    }

    protected void createPresenter() {
        this.mPresenter = new MobileRegisterPresenter(this);
        this.mRegionPresenter = new RegionPresenter(this);
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    public void dismissLoading() {
        if (isActivityAvaiable()) {
            dismissProgress();
        }
    }

    public void doRealAction(int i) {
        if (i == LoginClickAction.ACTION_REG) {
            registerAction();
        } else if (i == LoginClickAction.ACTION_REG_SEND_SMS) {
            sendCodeAction();
        }
    }

    protected void generateProtocol() {
        ProtocolHelper.generateProtocol(getProtocolModel(), this.mAttachedActivity, this.mProtocolTV, getPageName(), getPageSpm(), true);
    }

    public String getCountryCode() {
        RegionInfo regionInfo = this.mRegionInfo;
        return (regionInfo == null || TextUtils.isEmpty(regionInfo.domain)) ? "CN" : this.mRegionInfo.domain;
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    protected int getLayoutContent() {
        return R.layout.aliuser_fragment_mobile_register;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getMobile() {
        return this.mMobileET.getText().toString().trim().replaceAll(" ", "");
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public String getPageName() {
        return UTConstans.PageName.UT_PAGE_REG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ProtocolModel getProtocolModel() {
        return ProtocolHelper.getProtocolModel(this.mAttachedActivity, "", "");
    }

    @Override // com.ali.user.mobile.register.ui.RegisterFormView
    public String getRegType() {
        return UTConstant.Args.UT_MOBILE_REG;
    }

    protected TaobaoRegProtocolDialogFragment getRrotocolFragment() {
        return new TaobaoRegProtocolDialogFragment();
    }

    protected void initRegionInfo() {
        RegionInfo currentRegion = DataProviderFactory.getDataProvider().getCurrentRegion();
        if (currentRegion == null || TextUtils.isEmpty(currentRegion.domain) || TextUtils.isEmpty(currentRegion.name) || TextUtils.isEmpty(currentRegion.code)) {
            currentRegion = CountryUtil.matchRegionFromLocal(getContext(), currentRegion == null ? "" : currentRegion.domain);
        }
        if (currentRegion != null) {
            this.mRegionInfo = currentRegion;
            LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
            if (loginApprearanceExtensions != null && !loginApprearanceExtensions.needCountryModule()) {
                this.mRegionTV.setVisibility(8);
            } else {
                this.mRegionTV.setVisibility(0);
                this.mRegionTV.setText(this.mRegionInfo.code);
                resizeMobileETPadding();
            }
        }
        adjustMobileETMaxLength();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.base.ui.BaseFragment
    public void initViews(View view) {
        TextView textView;
        EditText editText;
        EditText editText2;
        super.initViews(view);
        this.mRegScroll = (ScrollView) view.findViewById(R.id.aliuser_reg_scroll);
        EditText editText3 = (EditText) view.findViewById(R.id.aliuser_register_mobile_et);
        this.mMobileET = editText3;
        RegTextWatcher regTextWatcher = new RegTextWatcher(editText3);
        this.mMobileTextWatcher = regTextWatcher;
        this.mMobileET.addTextChangedListener(regTextWatcher);
        EditText editText4 = (EditText) view.findViewById(R.id.aliuser_register_sms_code_et);
        this.mSMSCodeET = editText4;
        RegTextWatcher regTextWatcher2 = new RegTextWatcher(editText4);
        this.mSmsCodeTextWatcher = regTextWatcher2;
        this.mSMSCodeET.addTextChangedListener(regTextWatcher2);
        CountDownButton countDownButton = (CountDownButton) view.findViewById(R.id.aliuser_register_send_smscode_btn);
        this.mSendSMSCodeBtn = countDownButton;
        countDownButton.setOnClickListener(this);
        Button button = (Button) view.findViewById(R.id.aliuser_register_reg_btn);
        this.mRegBtn = button;
        button.setOnClickListener(this);
        this.mRegBtnLL = (LinearLayout) view.findViewById(R.id.aliuser_register_reg_btn_ll);
        this.mSmsSuccessTipTV = (TextView) view.findViewById(R.id.aliuser_send_sms_success_tip);
        this.mWelcomeTV = (TextView) view.findViewById(R.id.aliuser_register_tips_tv);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.aliuser_region_rl);
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(this);
        }
        this.mRegionTV = (TextView) view.findViewById(R.id.aliuser_region_tv);
        initRegionInfo();
        this.mRegionTV.setOnClickListener(this);
        this.mProtocolTV = (TextView) view.findViewById(R.id.aliuser_protocol_tv);
        try {
            this.mEmailET = (EditText) view.findViewById(R.id.aliuser_register_email_et);
            this.mPasswordET = (EditText) view.findViewById(R.id.aliuser_register_password_et);
            this.mPasswordHint = (TextView) view.findViewById(R.id.aliuser_register_password_tip);
        } catch (Throwable unused) {
        }
        if (DataProviderFactory.getDataProvider().enableRegEmailCheck() && (editText2 = this.mEmailET) != null) {
            editText2.setVisibility(0);
        }
        if (DataProviderFactory.getDataProvider().enableRegPwdCheck() && (editText = this.mPasswordET) != null) {
            editText.setVisibility(0);
        }
        if (DataProviderFactory.getDataProvider().enableRegPwdCheck() && (textView = this.mPasswordHint) != null) {
            textView.setVisibility(0);
        }
        try {
            this.mCheckBoxSwitch = true;
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.aliuser_reg_checkbox);
            this.mProtocolCB = checkBox;
            ProtocolHelper.setCheckBox(checkBox, getPageName(), getPageSpm(), this.mCheckBoxSwitch, this.mPreviousChecked);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        generateProtocol();
        View findViewById = view.findViewById(R.id.aliuser_login_mobile_clear_iv);
        this.mMobileClearBtn = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
        if (this.needAdaptElder) {
            TextView textView2 = this.mProtocolTV;
            ElderUtil.scaleTextSize(textView2, this.mRegionTV, textView2, this.mSMSCodeET, this.mMobileET, this.mSendSMSCodeBtn, this.mRegBtn, this.mEmailET, this.mPasswordET, this.mWelcomeTV);
        }
    }

    protected boolean isEmailValid(String str) {
        return !TextUtils.isEmpty(str) && REG_EMAIL.matcher(str).matches();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isMobileValid(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        RegionInfo regionInfo = this.mRegionInfo;
        if (regionInfo == null || TextUtils.isEmpty(regionInfo.checkPattern)) {
            return str.length() >= 6 && str.length() <= 20;
        }
        String replaceAll = str.replaceAll(" ", "");
        String replace = this.mRegionInfo.code.replace(jn1.PLUS, "");
        return (replace + replaceAll).matches(this.mRegionInfo.checkPattern);
    }

    protected boolean isPasswordValid(String str) {
        return !TextUtils.isEmpty(str) && this.REG_PASSWORD.matcher(str).matches();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 2001 && intent != null) {
            RegionInfo regionInfo = (RegionInfo) intent.getParcelableExtra(RegistConstants.REGION_INFO);
            this.mRegionInfo = regionInfo;
            if (regionInfo != null) {
                this.mRegionTV.setText(regionInfo.code);
                resizeMobileETPadding();
                adjustMobileETMaxLength();
            }
        }
    }

    protected void onCheckLogin(final int i) {
        CheckBox checkBox = this.mProtocolCB;
        if (checkBox != null && !checkBox.isChecked()) {
            UserTrackAdapter.sendUT(getPageName(), "RegAgreement");
            final TaobaoRegProtocolDialogFragment rrotocolFragment = getRrotocolFragment();
            rrotocolFragment.setNeedAdaptElder(true);
            rrotocolFragment.setFirst(false);
            rrotocolFragment.setPostiveBtnText(getString(R.string.aliuser_agree));
            rrotocolFragment.setNegativeBtnText(getString(R.string.aliuser_protocol_disagree));
            rrotocolFragment.setNagetive(new View.OnClickListener() { // from class: com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AliUserMobileRegisterFragment.this.isActive()) {
                        UserTrackAdapter.sendControlUT(AliUserMobileRegisterFragment.this.getPageName(), "Agreement_Button_Agree");
                        rrotocolFragment.dismissAllowingStateLoss();
                    }
                }
            });
            rrotocolFragment.setPositive(new View.OnClickListener() { // from class: com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AliUserMobileRegisterFragment.this.isActive()) {
                        UserTrackAdapter.sendControlUT(AliUserMobileRegisterFragment.this.getPageName(), "Agreement_Button_Cancel");
                        rrotocolFragment.dismissAllowingStateLoss();
                        AliUserMobileRegisterFragment.this.mProtocolCB.setChecked(true);
                        AliUserMobileRegisterFragment.this.doRealAction(i);
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
        if (id == R.id.aliuser_register_send_smscode_btn) {
            addCheckAction(LoginClickAction.ACTION_REG_SEND_SMS);
        } else if (id == R.id.aliuser_register_reg_btn) {
            addCheckAction(LoginClickAction.ACTION_REG);
        } else if (id != R.id.aliuser_region_rl && id != R.id.aliuser_region_tv) {
            if (id == R.id.aliuser_login_mobile_clear_iv) {
                clearMobile();
            }
        } else {
            addControl("Button-ChooseCountry");
            if (DataProviderFactory.getDataProvider().useRegionFragment()) {
                applyRegion();
                return;
            }
            this.mAttachedActivity.startActivityForResult(new Intent(this.mAttachedActivity, AliUserRegisterChoiceRegionActivity.class), 2001);
        }
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mPreviousChecked = getArguments().getBoolean("check");
        }
        createPresenter();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menu.clear();
        menuInflater.inflate(R.menu.aliuser_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.mPresenter.onDestory();
        this.mRegionPresenter.onDestory();
        this.mMobileET.removeTextChangedListener(this.mMobileTextWatcher);
        EditText editText = this.mSMSCodeET;
        if (editText != null) {
            editText.removeTextChangedListener(this.mSmsCodeTextWatcher);
        }
        CountDownButton countDownButton = this.mSendSMSCodeBtn;
        if (countDownButton != null) {
            countDownButton.cancelCountDown();
        }
        super.onDestroy();
    }

    @Override // com.ali.user.mobile.base.BaseView
    public void onGetRegion(List list) {
        if (isActive()) {
            RegionDialogFragment regionDialogFragment = new RegionDialogFragment();
            regionDialogFragment.setList(list);
            regionDialogFragment.setRegionListener(new RegionListener() { // from class: com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment.7
                @Override // com.ali.user.mobile.register.ui.RegionListener
                public void onClick(RegionInfo regionInfo) {
                    AliUserMobileRegisterFragment aliUserMobileRegisterFragment = AliUserMobileRegisterFragment.this;
                    aliUserMobileRegisterFragment.mRegionInfo = regionInfo;
                    if (regionInfo != null) {
                        aliUserMobileRegisterFragment.mRegionTV.setText(regionInfo.code);
                        AliUserMobileRegisterFragment.this.resizeMobileETPadding();
                        AliUserMobileRegisterFragment.this.adjustMobileETMaxLength();
                    }
                }
            });
            regionDialogFragment.setCurrentRegion(this.mRegionInfo);
            regionDialogFragment.setupAdapter(getActivity());
            try {
                regionDialogFragment.show(getActivity().getSupportFragmentManager(), "MobileRegisterRegionDialog");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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
            addControl("Button-Help");
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
        Properties properties = new Properties();
        properties.setProperty("monitor", "T");
        properties.setProperty("site", DataProviderFactory.getDataProvider().getSite() + "");
        UserTrackAdapter.sendUT(getPageName(), UTConstant.CustomEvent.UT_SINGLE_LOGIN_COMMIT, "", UTConstant.Args.UT_MOBILE_REG, properties);
        UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "single_register_success", "", getRegType(), properties);
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
        ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).navToLoginPage(this.mAttachedActivity, JSON.toJSONString(loginParam), true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        UserTrackAdapter.updatePageName(getActivity(), getPageName());
    }

    @Override // com.ali.user.mobile.register.ui.RegisterFormView
    public void onSMSSendFail(RpcResponse rpcResponse) {
        if (isActive()) {
            if (rpcResponse != null && rpcResponse.code == 458825) {
                UserTrackAdapter.sendUT(getPageName(), "CheckSimilarity");
                alert(rpcResponse.message, "", getString(R.string.aliuser_re_enter), new DialogInterface.OnClickListener() { // from class: com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment.4
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AliUserMobileRegisterFragment.this.addControl("Button-Alert-CheckSimilarity-no");
                    }
                }, getString(R.string.aliuser_common_ok), new DialogInterface.OnClickListener() { // from class: com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment.5
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AliUserMobileRegisterFragment aliUserMobileRegisterFragment = AliUserMobileRegisterFragment.this;
                        aliUserMobileRegisterFragment.mobileCheckSimilarity = false;
                        aliUserMobileRegisterFragment.addControl("Button-Alert-CheckSimilarity-yes");
                        AliUserMobileRegisterFragment.this.sendCodeAction();
                    }
                });
            } else if (rpcResponse != null && rpcResponse.code == 458826) {
                toast(getResources().getString(R.string.aliuser_reg_mobile_exist), 0);
                UserTrackAdapter.sendUT(getPageName(), "RegisterBlock");
                if (getActivity() != null) {
                    LoginParam loginParam = new LoginParam();
                    loginParam.loginAccount = getMobile();
                    loginParam.callRpc = true;
                    WebViewActivity.goFistLoginPage(getActivity(), true, true, loginParam);
                }
            } else {
                Properties properties = new Properties();
                properties.setProperty("monitor", "T");
                String pageName = getPageName();
                String str = "";
                if (rpcResponse != null) {
                    str = rpcResponse.code + "";
                }
                UserTrackAdapter.sendUT(pageName, UTConstans.CustomEvent.UT_SMS_SEND_FAIL, str, UTConstant.Args.UT_MOBILE_REG, properties);
                if (rpcResponse != null && rpcResponse.code != 4) {
                    toast(rpcResponse.message, 0);
                    return;
                }
                toast(getString(R.string.aliuser_sever_error), 0);
                switchSendSMSTipVisibility(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSendSMSAction(boolean z) {
        addControl("Button-SendSms");
        String mobile = getMobile();
        this.mMobileStr = mobile;
        if (!isMobileValid(mobile)) {
            toast(getString(R.string.aliuser_phone_number_invalidate), 0);
            return;
        }
        EditText editText = this.mSMSCodeET;
        if (editText != null) {
            editText.requestFocus();
        }
        this.mPresenter.sendSMS(null, buildRegisterParam());
    }

    @Override // com.ali.user.mobile.register.ui.RegisterFormView
    public void onSendSMSSuccess(long j, SmsApplyResult smsApplyResult) {
        switchSendSMSTipVisibility(0);
        this.mSendSMSCodeBtn.startCountDown(j, 1000L);
        if (!this.isVoice) {
            TextView textView = this.mSmsSuccessTipTV;
            if (textView != null) {
                textView.setText(getString(R.string.aliuser_sms_code_success_hint));
            }
            if (!DataProviderFactory.getDataProvider().isEnableVoiceMsg() || "CN".equals(getCountryCode())) {
                return;
            }
            this.mSendSMSCodeBtn.setTickListener(new CountDownButton.CountListener() { // from class: com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment.3
                @Override // com.ali.user.mobile.ui.widget.CountDownButton.CountListener
                public void onTick(long j2) {
                    String trim = AliUserMobileRegisterFragment.this.mSMSCodeET.getText().toString().trim();
                    AliUserMobileRegisterFragment aliUserMobileRegisterFragment = AliUserMobileRegisterFragment.this;
                    if (aliUserMobileRegisterFragment.isVoice || 29 != j2 / 1000 || "CN".equals(aliUserMobileRegisterFragment.getCountryCode()) || !TextUtils.isEmpty(trim)) {
                        return;
                    }
                    AliUserMobileRegisterFragment.this.switchSendSMSTipVisibility(8);
                }
            });
            return;
        }
        TextView textView2 = this.mSmsSuccessTipTV;
        if (textView2 != null) {
            textView2.setText(R.string.aliuser_voice_code_success_hint);
        }
    }

    protected void openHelp() {
        AliUserRegisterActivity.goRegHelp(getBaseActivity());
    }

    protected void registerAction() {
        addControl("Button-Next");
        submitRegisterForm();
    }

    protected void resizeMobileETPadding() {
        this.mRegionTV.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment.6
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AliUserMobileRegisterFragment.this.mRegionTV.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                EditText editText = AliUserMobileRegisterFragment.this.mMobileET;
                editText.setPadding(editText.getPaddingLeft(), AliUserMobileRegisterFragment.this.mMobileET.getPaddingTop(), AliUserMobileRegisterFragment.this.mRegionTV.getWidth() + 30, AliUserMobileRegisterFragment.this.mMobileET.getPaddingBottom());
            }
        });
    }

    protected void sendCodeAction() {
        this.isVoice = false;
        addControl("Button-SendSms");
        try {
            onSendSMSAction(false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    public void showLoading() {
        showProgress("");
    }

    public boolean submitRegisterForm() {
        EditText editText;
        EditText editText2;
        if (DataProviderFactory.getDataProvider().enableRegPwdCheck() && (editText2 = this.mPasswordET) != null && !isPasswordValid(editText2.getText().toString().trim())) {
            toast(getString(R.string.aliuser_password_format_error), 0);
            return false;
        } else if (DataProviderFactory.getDataProvider().enableRegEmailCheck() && (editText = this.mEmailET) != null && !isEmailValid(editText.getText().toString().trim())) {
            toast(getString(R.string.aliuser_email_format_error), 0);
            return false;
        } else if (TextUtils.isEmpty(this.mPresenter.getSessionId())) {
            toast(getString(R.string.aliuser_send_sms_first), 0);
            return false;
        } else if (TextUtils.isEmpty(this.mSMSCodeET.getText())) {
            toast(getString(R.string.aliuser_sms_code_hint), 0);
            return false;
        } else {
            Properties properties = new Properties();
            properties.setProperty("monitor", "T");
            UserTrackAdapter.sendUT(getPageName(), UTConstans.CustomEvent.UT_REG_RPC_COMMIT, properties);
            UserTrackAdapter.sendUT(getPageName(), "single_register_commit", "", UTConstant.Args.UT_SMS_REG, properties);
            this.mPresenter.register(null, buildRegisterParam());
            return true;
        }
    }

    protected void switchSendSMSTipVisibility(int i) {
        TextView textView = this.mSmsSuccessTipTV;
        if (textView != null) {
            textView.setVisibility(i);
        }
    }
}
