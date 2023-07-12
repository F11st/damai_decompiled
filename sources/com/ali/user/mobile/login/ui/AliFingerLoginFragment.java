package com.ali.user.mobile.login.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.ali.user.mobile.base.UIBaseConstants;
import com.ali.user.mobile.login.presenter.BaseLoginPresenter;
import com.ali.user.mobile.login.presenter.BioPresenter;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.rpc.HistoryAccount;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.utils.ElderUtil;
import com.alibaba.fastjson.JSON;
import com.taobao.login4android.config.LoginSwitch;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class AliFingerLoginFragment extends BaseHistoryFragment implements BaseLoginView {
    protected LoginParam loginParam = null;
    protected TextView mAlipayLoginTV;
    protected Button mainButton;

    public static boolean isMultiAccountPageEnable() {
        return LoginSwitch.isInABTestRegion("enable_multi_account_new", 10000);
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    protected int getLayoutContent() {
        return R.C2965layout.aliuser_finger_fragment;
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public String getPageName() {
        return "Page_BioLogin";
    }

    protected void initParams() {
        Bundle arguments = getArguments();
        this.loginParam = null;
        if (arguments != null) {
            try {
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
            } catch (Throwable unused) {
            }
        }
        this.mBioPresenter = new BioPresenter(this, this.loginParam);
        this.mPresenter = new BaseLoginPresenter(this, this.loginParam);
    }

    @Override // com.ali.user.mobile.login.ui.BaseHistoryFragment, com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment
    public void initViews(View view) {
        super.initViews(view);
        initMode();
        this.mainButton = (Button) view.findViewById(R.id.aliuser_login_btn);
        TextView textView = (TextView) view.findViewById(R.id.ali_user_login_alipay_login_tv);
        this.mAlipayLoginTV = textView;
        if (textView != null) {
            textView.setOnClickListener(this);
            showAlipay();
        }
        setOnClickListener(this.mainButton);
        this.mPresenter.onStart();
        if (this.needAdaptElder) {
            ElderUtil.scaleTextSize(this.mainButton);
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseHistoryFragment, com.ali.user.mobile.login.ui.BaseLoginFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.ali_user_login_alipay_login_tv) {
            addCheckAction(LoginClickAction.ACTION_ALIPAY);
        } else if (id == R.id.aliuser_login_btn) {
            addCheckAction(LoginClickAction.ACTION_FINGER);
        } else {
            super.onClick(view);
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initParams();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    public void onDeleteAccount() {
        if (isMultiAccountPageEnable()) {
            return;
        }
        super.onDeleteAccount();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    public void onLoginAction() {
        super.onLoginAction();
    }

    protected void showAlipay() {
    }

    @Override // com.ali.user.mobile.login.ui.BaseHistoryFragment
    protected void switchToHistoryMode(HistoryAccount historyAccount) {
        super.switchToHistoryMode(historyAccount);
    }
}
