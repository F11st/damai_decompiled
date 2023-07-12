package com.ali.user.mobile.login.ui;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.BooleanOrangeResult;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.UIBaseConstants;
import com.ali.user.mobile.base.helper.BroadCastHelper;
import com.ali.user.mobile.base.ui.BaseFragment;
import com.ali.user.mobile.common.api.AliUserLogin;
import com.ali.user.mobile.common.api.LoginApprearanceExtensions;
import com.ali.user.mobile.helper.ActivityUIHelper;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.LoginFrom;
import com.ali.user.mobile.login.action.LoginResActions;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.mobile.login.presenter.BioPresenter;
import com.ali.user.mobile.login.presenter.FaceLoginPresenter;
import com.ali.user.mobile.login.presenter.RegionPresenter;
import com.ali.user.mobile.login.presenter.UserLoginPresenter;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.RegionInfo;
import com.ali.user.mobile.register.RegistConstants;
import com.ali.user.mobile.register.ui.AliUserRegisterChoiceRegionActivity;
import com.ali.user.mobile.register.ui.RegionDialogFragment;
import com.ali.user.mobile.register.ui.RegionListener;
import com.ali.user.mobile.rpc.HistoryAccount;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.ui.widget.BottomMenuFragment;
import com.ali.user.mobile.ui.widget.MenuItem;
import com.ali.user.mobile.ui.widget.MenuItemOnClickListener;
import com.ali.user.mobile.utils.CountryUtil;
import com.ali.user.mobile.utils.ElderUtil;
import com.ali.user.mobile.utils.StringUtil;
import com.ali.user.mobile.utils.UTConstans;
import com.alibaba.fastjson.JSON;
import com.taobao.login4android.config.LoginSwitch;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class AliUserLoginFragment extends BaseLoginFragment implements UserLoginView {
    protected static final String TAG = AliUserLoginFragment.class.getSimpleName();
    private boolean isInBindMode;
    protected View mAccountClearBtn;
    protected EditText mAccountET;
    protected TextView mAccountTV;
    protected String mCurrentAccount;
    protected String mCurrentPassword;
    protected String mCurrentSelectedAccount;
    protected LinearLayout mFirstLoginLL;
    protected TextView mForgetPasswordTV;
    protected LinearLayout mHistoryLoginLL;
    protected Button mLoginBtn;
    protected LinearLayout mLoginBtnLL;
    protected LinearLayout mLoginLL;
    protected View mPasswordClearBtn;
    protected EditText mPasswordET;
    protected TextView mRegTV;
    protected RegionInfo mRegionInfo;
    protected RegionPresenter mRegionPresenter;
    protected TextView mRegionTV;
    protected ImageView mShowPasswordIV;
    protected String mSource;
    protected TextView mSwitchFaceLoginBtn;
    protected TextView mSwitchMoreLoginBtn;
    protected TextView mSwitchSmsLoginBtn;
    public UserLoginPresenter mUserLoginPresenter;
    protected boolean isForceNormalMode = false;
    protected TextWatcher mTextWatcherAccount = null;
    protected TextWatcher mTextWatcherPassword = null;
    protected boolean mActiveLogin = false;
    protected LoginParam loginParam = null;
    private boolean checkcodeUT = true;
    protected boolean faceLoginEnable = false;
    protected boolean smsLoginEnable = false;

    /* compiled from: Taobao */
    @TargetApi(21)
    /* loaded from: classes17.dex */
    public class MobileTextWatcher extends PhoneNumberFormattingTextWatcher {
        private WeakReference<EditText> editText;

        @Override // android.telephony.PhoneNumberFormattingTextWatcher, android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.editText.get().getId() == R.id.aliuser_login_mobile_et && AliUserLoginFragment.this.mAccountClearBtn != null) {
                if (charSequence != null && charSequence.length() != 0) {
                    if (AliUserLoginFragment.this.mAccountClearBtn.getVisibility() != 0 && AliUserLoginFragment.this.mAccountClearBtn.isEnabled()) {
                        AliUserLoginFragment.this.mAccountClearBtn.setVisibility(0);
                    }
                } else if (AliUserLoginFragment.this.mAccountClearBtn.getVisibility() != 8) {
                    AliUserLoginFragment.this.mAccountClearBtn.setVisibility(8);
                }
            }
            AliUserLoginFragment.this.checkSignInable();
        }

        private MobileTextWatcher(EditText editText, String str) {
            super(str);
            this.editText = new WeakReference<>(editText);
        }
    }

    private void initTextWatcher() {
        initAccountWatcher();
        this.mTextWatcherPassword = new TextWatcher() { // from class: com.ali.user.mobile.login.ui.AliUserLoginFragment.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AliUserLoginFragment.this.beforePasspordChange();
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AliUserLoginFragment.this.mPasswordClearBtn != null) {
                    if (charSequence != null && charSequence.length() != 0) {
                        if (AliUserLoginFragment.this.mPasswordClearBtn.getVisibility() != 0) {
                            AliUserLoginFragment.this.mPasswordClearBtn.setVisibility(0);
                        }
                    } else if (AliUserLoginFragment.this.mPasswordClearBtn.getVisibility() != 8) {
                        AliUserLoginFragment.this.mPasswordClearBtn.setVisibility(8);
                    }
                }
                AliUserLoginFragment aliUserLoginFragment = AliUserLoginFragment.this;
                if (aliUserLoginFragment.mPasswordET == null) {
                    return;
                }
                aliUserLoginFragment.checkSignInable();
                if (charSequence == null || charSequence.length() <= 0 || !AliUserLoginFragment.this.checkcodeUT) {
                    return;
                }
                AliUserLoginFragment.this.checkcodeUT = false;
                AliUserLoginFragment.this.addControl("password_input");
            }
        };
    }

    protected void adjustMobileETMaxLength() {
        RegionInfo regionInfo = this.mRegionInfo;
        if (regionInfo != null && TextUtils.equals("CN", regionInfo.domain) && DataProviderFactory.getDataProvider().enableMobilePwdLogin()) {
            this.mAccountET.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
            if (Build.VERSION.SDK_INT >= 21) {
                MobileTextWatcher mobileTextWatcher = new MobileTextWatcher(this.mAccountET, Locale.CHINA.getCountry());
                this.mTextWatcherAccount = mobileTextWatcher;
                this.mAccountET.addTextChangedListener(mobileTextWatcher);
                return;
            }
            return;
        }
        this.mAccountET.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        if (Build.VERSION.SDK_INT >= 21) {
            initAccountWatcher();
            this.mAccountET.addTextChangedListener(this.mTextWatcherAccount);
        }
    }

    protected void applyRegion() {
        this.mRegionPresenter.region(0);
    }

    protected void beforeAccountChange() {
    }

    protected void beforePasspordChange() {
    }

    protected void checkSignInable() {
        String obj = this.mAccountET.getText().toString();
        if (this.isHistoryMode) {
            obj = this.mAccountTV.getText().toString();
        }
        this.mLoginBtn.setEnabled((TextUtils.isEmpty(obj) || TextUtils.isEmpty(this.mPasswordET.getText().toString())) ? false : true);
    }

    @Override // com.ali.user.mobile.login.ui.UserLoginView
    public void clearPasswordInput() {
        EditText editText = this.mPasswordET;
        if (editText != null) {
            editText.setText("");
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    protected String getAccountName() {
        if (this.isHistoryMode) {
            return this.mCurrentSelectedAccount;
        }
        RegionInfo regionInfo = this.mRegionInfo;
        if (regionInfo != null && !"+86".equals(regionInfo.code)) {
            return this.mRegionInfo.code.replace(jn1.PLUS, "") + "-" + this.mAccountET.getText().toString().trim().replaceAll(" ", "");
        }
        return this.mAccountET.getText().toString().trim().replaceAll(" ", "");
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    protected int getLayoutContent() {
        return R.C2965layout.aliuser_fragment_user_login;
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public int getLoginSite() {
        HistoryAccount historyAccount;
        if (this.isHistoryMode && (historyAccount = this.mUserLoginActivity.mHistoryAccount) != null) {
            return historyAccount.getLoginSite();
        }
        return DataProviderFactory.getDataProvider().getSite();
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public String getPageName() {
        return this.isHistoryMode ? UTConstant.PageName.UT_PAGE_HISTORY_LOGIN : UTConstant.PageName.UT_PAGE_FIRST_LOGIN;
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public String getPageSpm() {
        return UTConstant.PageName.F_HISTORY_LOGIN;
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    protected void initAccountEditText(String str) {
        if (this.mAccountET == null || !TextUtils.isEmpty(getAccountName()) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mAccountET.setText(str);
    }

    protected void initAccountWatcher() {
        this.mTextWatcherAccount = new TextWatcher() { // from class: com.ali.user.mobile.login.ui.AliUserLoginFragment.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AliUserLoginFragment.this.beforeAccountChange();
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AliUserLoginFragment.this.mAccountClearBtn != null) {
                    if (charSequence != null && charSequence.length() != 0) {
                        if (AliUserLoginFragment.this.mAccountClearBtn.getVisibility() != 0 && AliUserLoginFragment.this.mAccountClearBtn.isEnabled()) {
                            AliUserLoginFragment.this.mAccountClearBtn.setVisibility(0);
                        }
                    } else if (AliUserLoginFragment.this.mAccountClearBtn.getVisibility() != 8) {
                        AliUserLoginFragment.this.mAccountClearBtn.setVisibility(8);
                    }
                }
                AliUserLoginFragment.this.checkSignInable();
            }
        };
    }

    protected void initMode() {
        if (!this.isForceNormalMode && DataProviderFactory.getDataProvider().getMaxHistoryAccount() != 0) {
            UserLoginActivity userLoginActivity = this.mUserLoginActivity;
            if (userLoginActivity.hadReadHistory) {
                HistoryAccount historyAccount = userLoginActivity.mHistoryAccount;
                if (historyAccount != null) {
                    this.isHistoryMode = true;
                    switchToHistoryMode(historyAccount);
                    return;
                }
                this.isHistoryMode = false;
                switchMode(false, null);
                return;
            }
            this.isHistoryMode = false;
            switchMode(false, null);
            return;
        }
        this.isHistoryMode = false;
        if (TextUtils.isEmpty(this.mCurrentAccount)) {
            switchMode(this.isHistoryMode, null);
        } else {
            this.mAccountET.setText(this.mCurrentAccount);
        }
    }

    protected void initParams() {
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
            this.isForceNormalMode = arguments.getBoolean(LoginConstant.FORCE_NORMAL_MODE);
            this.mCurrentAccount = arguments.getString(LoginConstant.ACCOUNT);
        }
        this.mUserLoginPresenter = new UserLoginPresenter(this, this.loginParam);
        this.mRegionPresenter = new RegionPresenter(this);
        this.mFaceLoginPresenter = new FaceLoginPresenter(this, this.loginParam);
        this.mBioPresenter = new BioPresenter(this, this.loginParam);
    }

    protected void initRegionInfo() {
        if (this.mRegionTV == null || !DataProviderFactory.getDataProvider().enableMobilePwdLogin()) {
            return;
        }
        this.mRegionTV.setVisibility(0);
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
            }
        }
        adjustMobileETMaxLength();
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment
    public void initViews(View view) {
        LoginApprearanceExtensions loginApprearanceExtensions;
        super.initViews(view);
        initTextWatcher();
        this.mLoginLL = (LinearLayout) view.findViewById(R.id.aliuser_user_login_ll);
        EditText editText = (EditText) view.findViewById(R.id.aliuser_login_account_et);
        this.mAccountET = editText;
        if (editText != null) {
            editText.setSingleLine();
        }
        this.mAccountClearBtn = view.findViewById(R.id.aliuser_login_account_clear_iv);
        this.mHistoryLoginLL = (LinearLayout) view.findViewById(R.id.aliuser_login_history_ll);
        this.mFirstLoginLL = (LinearLayout) view.findViewById(R.id.aliuser_login_normal_ll);
        this.mAccountTV = (TextView) view.findViewById(R.id.aliuser_login_account_tv);
        EditText editText2 = this.mAccountET;
        if (editText2 != null) {
            editText2.addTextChangedListener(this.mTextWatcherAccount);
            this.mAccountET.setTypeface(Typeface.SANS_SERIF);
        }
        EditText editText3 = (EditText) view.findViewById(R.id.aliuser_login_password_et);
        this.mPasswordET = editText3;
        if (editText3 != null) {
            editText3.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.mPasswordET.addTextChangedListener(this.mTextWatcherPassword);
            this.mPasswordET.setTypeface(Typeface.SANS_SERIF);
        }
        this.mPasswordClearBtn = view.findViewById(R.id.aliuser_login_password_clear_iv);
        Button button = (Button) view.findViewById(R.id.aliuser_login_login_btn);
        this.mLoginBtn = button;
        if (button != null) {
            button.setEnabled(false);
        }
        TextView textView = (TextView) view.findViewById(R.id.aliuser_login_forgot_password_tv);
        this.mForgetPasswordTV = textView;
        if (textView != null) {
            BooleanOrangeResult needFindPassword = DataProviderFactory.getOrangeConfig().needFindPassword();
            if (needFindPassword.orangeExist && !needFindPassword.value) {
                this.mForgetPasswordTV.setVisibility(8);
            }
        }
        this.mShowPasswordIV = (ImageView) view.findViewById(R.id.aliuser_login_show_password_btn);
        this.mRegionTV = (TextView) view.findViewById(R.id.aliuser_region_tv);
        initRegionInfo();
        this.mLoginBtnLL = (LinearLayout) view.findViewById(R.id.aliuser_login_login_btn_ll);
        TextView textView2 = (TextView) view.findViewById(R.id.aliuser_reg_tv);
        this.mRegTV = textView2;
        if (textView2 != null && (loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions) != null && loginApprearanceExtensions.needRegister()) {
            this.mRegTV.setVisibility(0);
        } else {
            TextView textView3 = this.mRegTV;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
        }
        this.mSwitchSmsLoginBtn = (TextView) view.findViewById(R.id.aliuser_login_switch_smslogin);
        try {
            this.mSwitchMoreLoginBtn = (TextView) view.findViewById(R.id.aliuser_login_switch_more_login);
            this.mSwitchFaceLoginBtn = (TextView) view.findViewById(R.id.aliuser_login_switch_face_login);
        } catch (Throwable unused) {
        }
        ImageView imageView = this.mShowPasswordIV;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        setOnClickListener(this.mLoginBtn, this.mForgetPasswordTV, this.mRegionTV, this.mAccountClearBtn, this.mPasswordClearBtn, this.mRegTV, this.mSwitchSmsLoginBtn, this.mSwitchMoreLoginBtn, this.mSwitchFaceLoginBtn);
        this.mUserLoginPresenter.onStart();
        this.mRegionPresenter.onStart();
        initMode();
        showPushLogoutAlertIfHas();
        if (!LoginSwitch.getSwitch(LoginSwitch.OPEN_LOGIN_PAGE_WHEN_IS_LOGIN, "false")) {
            BroadCastHelper.sendLocalBroadCast(new Intent(LoginResActions.LOGIN_OPEN_ACTION));
        }
        if (this.needAdaptElder) {
            ElderUtil.scaleTextSize(this.mProtocolTV, this.mRegTV, this.mAccountTV, this.mSwitchFaceLoginBtn, this.mSwitchMoreLoginBtn, this.mSwitchSmsLoginBtn, this.mLoginBtn, this.mForgetPasswordTV, this.mAccountET, this.mPasswordET);
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public boolean isHistoryMode() {
        return this.isHistoryMode;
    }

    protected boolean isMobileValid(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("^1[0-9]{10}$");
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        TextView textView;
        super.onActivityResult(i, i2, intent);
        if (i2 != -1 || i != 2001) {
            this.mUserLoginPresenter.onActivityResult(i, i2, intent);
        } else if (intent != null) {
            RegionInfo regionInfo = (RegionInfo) intent.getParcelableExtra(RegistConstants.REGION_INFO);
            this.mRegionInfo = regionInfo;
            if (regionInfo == null || (textView = this.mRegionTV) == null) {
                return;
            }
            textView.setText(regionInfo.code);
            adjustMobileETMaxLength();
        }
    }

    protected void onClearAccountBtnClickAction() {
        if (!DataProviderFactory.getDataProvider().isShowHistoryFragment() && !TextUtils.isEmpty(this.mAccountET.getText()) && !this.mAccountET.isEnabled()) {
            onDeleteAccount();
            this.mAccountET.setEnabled(true);
            return;
        }
        this.mAccountET.getEditableText().clear();
        this.mAccountET.setEnabled(true);
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.aliuser_login_login_btn) {
            addCheckAction(LoginClickAction.ACTION_LOGIN);
        } else if (id == R.id.aliuser_login_forgot_password_tv) {
            addControl("Button-ForgetPwd");
            onForgetPasswordAction();
        } else if (id == R.id.aliuser_login_account_clear_iv) {
            onClearAccountBtnClickAction();
        } else if (id == R.id.aliuser_login_password_clear_iv) {
            this.mPasswordET.getEditableText().clear();
        } else if (id == R.id.aliuser_login_show_password_btn) {
            int selectionEnd = this.mPasswordET.getSelectionEnd();
            if (view.getTag() != null && ((Boolean) view.getTag()).booleanValue()) {
                this.mPasswordET.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.mShowPasswordIV.setImageResource(R.C2964drawable.aliuser_ic_visibility_off);
                this.mShowPasswordIV.setContentDescription(getString(R.string.aliuser_assist_password_hide));
                view.setTag(Boolean.FALSE);
                addControl("Button-HidePwd");
            } else {
                this.mPasswordET.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                this.mShowPasswordIV.setImageResource(R.C2964drawable.aliuser_ic_visibility);
                this.mShowPasswordIV.setContentDescription(getString(R.string.aliuser_assist_password_show));
                view.setTag(Boolean.TRUE);
                addControl("Button-ShowPwd");
            }
            if (selectionEnd > 0) {
                this.mPasswordET.setSelection(selectionEnd);
            }
            this.mPasswordET.postInvalidate();
        } else if (id == R.id.aliuser_login_switch_smslogin) {
            addControl(UTConstans.Controls.UT_CHOOSE_OTHER_SMS);
            switchToSmsLogin();
        } else if (id == R.id.aliuser_login_switch_face_login) {
            addCheckAction(LoginClickAction.ACTION_FACE);
        } else if (id == R.id.aliuser_login_switch_more_login) {
            addControl("Button-ChooseMoreLogin");
            showMoreLoginBottomMenu();
        } else if (id == R.id.aliuser_region_tv) {
            addControl("Button-Region");
            if (DataProviderFactory.getDataProvider().useRegionFragment()) {
                applyRegion();
                return;
            }
            Intent intent = new Intent(this.mAttachedActivity, AliUserRegisterChoiceRegionActivity.class);
            intent.putExtra("from_login", true);
            this.mAttachedActivity.startActivityForResult(intent, 2001);
        } else {
            super.onClick(view);
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initParams();
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        UserLoginPresenter userLoginPresenter = this.mUserLoginPresenter;
        if (userLoginPresenter != null) {
            userLoginPresenter.onDestory();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        EditText editText = this.mAccountET;
        if (editText != null) {
            editText.removeTextChangedListener(this.mTextWatcherAccount);
        }
        EditText editText2 = this.mPasswordET;
        if (editText2 != null) {
            editText2.removeTextChangedListener(this.mTextWatcherPassword);
        }
        super.onDestroyView();
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    protected void onForgetPasswordAction() {
        HistoryAccount historyAccount;
        String accountName = getAccountName();
        UserLoginPresenter userLoginPresenter = this.mUserLoginPresenter;
        String str = (userLoginPresenter == null || userLoginPresenter.getLoginParam() == null) ? "" : this.mUserLoginPresenter.mLoginParam.source;
        if (this.isHistoryMode && (historyAccount = this.mUserLoginActivity.mHistoryAccount) != null) {
            if (historyAccount.alipayHid != 0) {
                alert("", this.mAttachedActivity.getResources().getString(R.string.aliuser_alipay_findpwd), this.mAttachedActivity.getResources().getString(R.string.aliuser_confirm), new DialogInterface.OnClickListener() { // from class: com.ali.user.mobile.login.ui.AliUserLoginFragment.5
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ((BaseFragment) AliUserLoginFragment.this).mActivityHelper.dismissAlertDialog();
                    }
                }, null, null);
                return;
            } else if (!TextUtils.isEmpty(historyAccount.tokenKey) && getLoginSite() == 0) {
                this.mUserLoginPresenter.fetchUrlAndToWebViewWithUserId(this.mAttachedActivity, accountName, this.mUserLoginActivity.mHistoryAccount.userId, str);
                return;
            } else {
                this.mUserLoginPresenter.fetchUrlAndToWebView(this.mAttachedActivity, accountName, LoginType.LocalLoginType.RETRIVE_PWD_LOGIN, str);
                return;
            }
        }
        this.mUserLoginPresenter.fetchUrlAndToWebView(this.mAttachedActivity, accountName, LoginType.LocalLoginType.RETRIVE_PWD_LOGIN, str);
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.BaseView
    public void onGetRegion(List<RegionInfo> list) {
        if (isActive()) {
            RegionDialogFragment regionDialogFragment = new RegionDialogFragment();
            regionDialogFragment.setList(list);
            regionDialogFragment.setRegionListener(new RegionListener() { // from class: com.ali.user.mobile.login.ui.AliUserLoginFragment.6
                @Override // com.ali.user.mobile.register.ui.RegionListener
                public void onClick(RegionInfo regionInfo) {
                    AliUserLoginFragment aliUserLoginFragment = AliUserLoginFragment.this;
                    aliUserLoginFragment.mRegionInfo = regionInfo;
                    if (regionInfo != null) {
                        aliUserLoginFragment.mRegionTV.setText(regionInfo.code);
                        AliUserLoginFragment.this.adjustMobileETMaxLength();
                    }
                }
            });
            regionDialogFragment.setCurrentRegion(this.mRegionInfo);
            regionDialogFragment.setupAdapter(getActivity());
            regionDialogFragment.show(getActivity().getSupportFragmentManager(), "UserRegionDialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    public void onLoginAction() {
        LoginFrom.setCurrentLoginFrom("4");
        this.mActiveLogin = true;
        this.mCurrentAccount = getAccountName();
        this.mCurrentPassword = this.mPasswordET.getText().toString().trim();
        if (TextUtils.isEmpty(this.mCurrentAccount)) {
            showErrorMessage(R.string.aliuser_sign_in_account_hint);
        } else if (TextUtils.isEmpty(this.mCurrentPassword)) {
            showErrorMessage(R.string.aliuser_sign_in_please_enter_password);
        } else {
            ActivityUIHelper activityUIHelper = this.mActivityHelper;
            if (activityUIHelper != null) {
                activityUIHelper.hideInputMethod();
            }
            this.mUserLoginPresenter.buildLoginParam(this.mCurrentAccount, this.mCurrentPassword);
            this.mUserLoginPresenter.getLoginParam().traceId = ApiReferer.generateTraceId(LoginType.LocalLoginType.PWD_LOGIN, getPageName());
            this.mUserLoginPresenter.getLoginParam().loginSourceType = LoginType.LocalLoginType.PWD_LOGIN;
            this.mUserLoginPresenter.getLoginParam().loginSourcePage = getPageName();
            this.mUserLoginPresenter.getLoginParam().loginSourceSpm = getPageSpm();
            if (this.mUserLoginActivity != null) {
                this.mUserLoginPresenter.getLoginParam().alipayInstalled = this.mUserLoginActivity.mAlipayInstall;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("sdkTraceId", this.mUserLoginPresenter.getLoginParam().traceId + "");
            hashMap.put("spm", getPageSpm());
            UserTrackAdapter.control(getPageName(), getPageSpm(), UTConstant.CustomEvent.UT_LOGIN_ACTION, "", LoginType.LocalLoginType.PWD_LOGIN, hashMap);
            if (!LoginSwitch.isInABTestRegion("api", 10000)) {
                Properties properties = new Properties();
                properties.setProperty("sdkTraceId", this.mUserLoginPresenter.getLoginParam().traceId + "");
                properties.setProperty("monitor", "T");
                properties.setProperty("site", getLoginSite() + "");
                properties.setProperty("loginId", this.mCurrentAccount + "");
                UserTrackAdapter.sendUT(getPageName(), UTConstant.CustomEvent.UT_SINGLE_LOGIN_COMMIT, "", LoginType.LocalLoginType.PWD_LOGIN, properties);
            }
            this.mUserLoginPresenter.login();
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.login.ui.UserLoginView
    public void onPwdError() {
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public void setLoginAccountInfo(String str) {
        this.mAccountET.setText(str);
    }

    public void setSnsToken(String str) {
        this.isInBindMode = true;
        UserLoginPresenter userLoginPresenter = this.mUserLoginPresenter;
        if (userLoginPresenter != null) {
            userLoginPresenter.setSnsToken(str);
        }
    }

    protected void showErrorMessage(int i) {
        toast(getString(i), 0);
    }

    @Override // com.ali.user.mobile.login.ui.UserLoginView
    public void showFindPasswordAlert(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse) {
        showFindPasswordAlert(loginParam, rpcResponse, this.mUserLoginPresenter, this.mPasswordET, this.mShowPasswordIV);
    }

    protected void showMoreLoginBottomMenu() {
        if (isActive()) {
            BottomMenuFragment bottomMenuFragment = getBottomMenuFragment();
            ArrayList arrayList = new ArrayList();
            addFingeritem(bottomMenuFragment, arrayList);
            if (this.smsLoginEnable) {
                MenuItem menuItem = new MenuItem();
                menuItem.setText(getString(R.string.aliuser_login_sms_login));
                menuItem.setMenuItemOnClickListener(new MenuItemOnClickListener(bottomMenuFragment, menuItem) { // from class: com.ali.user.mobile.login.ui.AliUserLoginFragment.3
                    @Override // com.ali.user.mobile.ui.widget.MenuItemOnClickListener
                    public void onClickMenuItem(View view, MenuItem menuItem2) {
                        if (AliUserLoginFragment.this.isActive()) {
                            AliUserLoginFragment.this.addControl(UTConstans.Controls.UT_CHOOSE_OTHER_SMS);
                            AliUserLoginFragment.this.switchToSmsLogin();
                        }
                    }
                });
                arrayList.add(menuItem);
            }
            if (this.faceLoginEnable) {
                MenuItem menuItem2 = new MenuItem();
                menuItem2.setText(getString(R.string.aliuser_scan_login_text));
                menuItem2.setMenuItemOnClickListener(new MenuItemOnClickListener(bottomMenuFragment, menuItem2) { // from class: com.ali.user.mobile.login.ui.AliUserLoginFragment.4
                    @Override // com.ali.user.mobile.ui.widget.MenuItemOnClickListener
                    public void onClickMenuItem(View view, MenuItem menuItem3) {
                        if (AliUserLoginFragment.this.isActive()) {
                            AliUserLoginFragment.this.onCheckLogin(LoginClickAction.ACTION_FACE);
                        }
                    }
                });
                arrayList.add(menuItem2);
            }
            bottomMenuFragment.setMenuItems(arrayList);
            bottomMenuFragment.show(getFragmentManager(), getPageName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    public void switchAccount() {
        Intent intent = new Intent();
        intent.putExtra(LoginConstant.FORCE_NORMAL_MODE, true);
        UserLoginPresenter userLoginPresenter = this.mUserLoginPresenter;
        if (userLoginPresenter != null && userLoginPresenter.getLoginParam() != null) {
            LoginParam loginParam = new LoginParam();
            loginParam.source = this.mUserLoginPresenter.getLoginParam().source;
            intent.putExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, JSON.toJSONString(loginParam));
        }
        CheckBox checkBox = this.mProtocolCB;
        if (checkBox != null) {
            intent.putExtra("check", checkBox.isChecked());
        }
        UserLoginActivity userLoginActivity = this.mUserLoginActivity;
        if (userLoginActivity != null) {
            userLoginActivity.gotoPwdLoginFragment(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c5 A[Catch: all -> 0x015c, TryCatch #0 {all -> 0x015c, blocks: (B:4:0x0006, B:6:0x0012, B:8:0x001a, B:10:0x0022, B:11:0x0025, B:13:0x002f, B:14:0x0031, B:16:0x003b, B:18:0x0041, B:20:0x0045, B:21:0x0047, B:23:0x0052, B:25:0x0056, B:29:0x005d, B:35:0x00c1, B:37:0x00c5, B:64:0x014f, B:66:0x0155, B:30:0x0078, B:32:0x007c, B:33:0x0097, B:34:0x00a7, B:38:0x00ca, B:40:0x00de, B:42:0x00f6, B:44:0x0104, B:46:0x0108, B:48:0x010e, B:52:0x011b, B:54:0x0125, B:56:0x0129, B:58:0x012d, B:60:0x0131, B:62:0x0135, B:63:0x0140, B:49:0x0114, B:51:0x0118, B:41:0x00f1), top: B:69:0x0004 }] */
    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void switchMode(boolean r8, com.ali.user.mobile.rpc.HistoryAccount r9) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.user.mobile.login.ui.AliUserLoginFragment.switchMode(boolean, com.ali.user.mobile.rpc.HistoryAccount):void");
    }

    protected void switchToHistoryMode(HistoryAccount historyAccount) {
        if (isActivityAvaiable()) {
            String str = historyAccount.userInputName;
            this.mCurrentSelectedAccount = str;
            String dataMasking = StringUtil.dataMasking(str);
            if (TextUtils.isEmpty(dataMasking)) {
                return;
            }
            this.mAccountTV.setText(dataMasking);
            updateAvatar(historyAccount.headImg);
            switchMode(this.isHistoryMode, historyAccount);
        }
    }

    protected void switchToSmsLogin() {
        EditText editText;
        Intent intent = new Intent();
        intent.putExtra(LoginConstant.FORCE_NORMAL_MODE, !this.isHistoryMode);
        if (!this.isHistoryMode && (editText = this.mAccountET) != null) {
            String obj = editText.getText().toString();
            if (isMobileValid(obj)) {
                intent.putExtra(LoginConstant.ACCOUNT, obj);
            }
        }
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
}
