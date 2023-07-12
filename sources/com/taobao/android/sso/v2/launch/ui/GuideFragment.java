package com.taobao.android.sso.v2.launch.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.helper.BroadCastHelper;
import com.ali.user.mobile.base.ui.BaseFragment;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.action.LoginResActions;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.mobile.login.ui.LoginClickAction;
import com.ali.user.mobile.service.NavigatorService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.utils.ProtocolHelper;
import com.ali.user.mobile.utils.ResourceUtil;
import com.taobao.android.sso.v2.R;
import com.taobao.android.sso.v2.launch.SsoLogin;
import com.taobao.login4android.ui.TaobaoRegProtocolDialogFragment;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GuideFragment extends BaseFragment implements View.OnClickListener {
    public static final String PAGE_NAME = "Page_Login4";
    protected String KEY_GUIDE_FRAGMENT_LAYOUT = "key_fragment_guide";
    private ImageButton mAlipaySsoButton;
    private TextView mAppNameTextView;
    protected boolean mCheckBoxSwitch;
    private LinearLayout mCloseBtn;
    private ImageView mCloseImageView;
    private BroadcastReceiver mLoginReceiver;
    protected CheckBox mProtocolCB;
    protected TextView mProtocolTV;
    private ImageButton mPwdButton;
    private ImageButton mTaobaoSsoButton;

    public void addCheckAction(int i) {
        if (this.mCheckBoxSwitch) {
            onCheckLogin(i);
        } else {
            doRealAction(i);
        }
    }

    public void doRealAction(int i) {
        if (i == LoginClickAction.ACTION_TAOBAO) {
            UserTrackAdapter.sendControlUT(PAGE_NAME, "Button-TaoSSO");
            onTbLoginClick(null);
        } else if (i == LoginClickAction.ACTION_ALIPAY) {
            UserTrackAdapter.sendControlUT(PAGE_NAME, "Button-AlipaySSO");
            onAlipayLoginClick(null);
        }
    }

    protected void generateProtocol(String str, String str2) {
        ProtocolHelper.generateProtocol(ProtocolHelper.getProtocolModel(getActivity(), str, str2, true), this.mAttachedActivity, this.mProtocolTV, getPageName(), "", false);
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    protected int getLayoutContent() {
        return R.C6645layout.ali_user_sso_guide_activity;
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public String getPageName() {
        return PAGE_NAME;
    }

    protected TaobaoRegProtocolDialogFragment getRrotocolFragment() {
        return new TaobaoRegProtocolDialogFragment();
    }

    protected void goTaobaoLoginFragment() {
        if (ServiceFactory.getService(NavigatorService.class) != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(LoginConstant.LAUNCH_PASS_GUIDE_FRAGMENT, true);
            ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).openLoginPage(this.mAttachedActivity, "", bundle);
        }
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    public void initViews(View view) {
        super.initViews(view);
        this.mTaobaoSsoButton = (ImageButton) view.findViewById(R.id.ali_user_guide_tb_login_btn);
        this.mAlipaySsoButton = (ImageButton) view.findViewById(R.id.ali_user_guide_alipay_login_btn);
        this.mPwdButton = (ImageButton) view.findViewById(R.id.ali_user_guide_account_login_btn);
        this.mCloseImageView = (ImageView) view.findViewById(R.id.ali_user_guide_close);
        this.mAppNameTextView = (TextView) view.findViewById(R.id.ali_user_guide_app_name);
        this.mCloseBtn = (LinearLayout) view.findViewById(R.id.ali_user_guide_close_layout);
        this.mTaobaoSsoButton.setOnClickListener(this);
        this.mAlipaySsoButton.setOnClickListener(this);
        this.mPwdButton.setOnClickListener(this);
        this.mAppNameTextView.setOnClickListener(this);
        this.mCloseBtn.setOnClickListener(this);
        if (!TextUtils.isEmpty(DataProviderFactory.getDataProvider().getGuideAppName())) {
            try {
                this.mAppNameTextView.setBackgroundDrawable(ResourceUtil.findDrawableById(DataProviderFactory.getDataProvider().getGuideAppName()));
                this.mAppNameTextView.setText("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(DataProviderFactory.getDataProvider().getGuideBackground())) {
            try {
                view.setBackgroundDrawable(ResourceUtil.findDrawableById(DataProviderFactory.getDataProvider().getGuideBackground()));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(DataProviderFactory.getDataProvider().getGuideCloseResource())) {
            try {
                this.mCloseImageView.setBackgroundDrawable(ResourceUtil.findDrawableById(DataProviderFactory.getDataProvider().getGuideCloseResource()));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(DataProviderFactory.getDataProvider().getGuidePwdLoginResource())) {
            try {
                this.mPwdButton.setBackgroundDrawable(ResourceUtil.findDrawableById(DataProviderFactory.getDataProvider().getGuidePwdLoginResource()));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        boolean z = DataProviderFactory.getDataProvider().isNeedTaobaoSsoGuide() && SsoLogin.isSupportTBSsoV2(DataProviderFactory.getApplicationContext());
        boolean z2 = DataProviderFactory.getDataProvider().isNeedAlipaySsoGuide() && SsoLogin.isSupportAliaySso() && !TextUtils.isEmpty(DataProviderFactory.getDataProvider().getAlipaySsoDesKey());
        boolean isNeedPwdGuide = DataProviderFactory.getDataProvider().isNeedPwdGuide();
        if (z) {
            this.mTaobaoSsoButton.setVisibility(0);
        }
        if (z2) {
            this.mAlipaySsoButton.setVisibility(0);
        }
        if (isNeedPwdGuide) {
            this.mPwdButton.setVisibility(0);
        }
        try {
            setCheckBoxSwitch();
            CheckBox checkBox = (CheckBox) view.findViewById(com.ali.user.mobile.ui.R.id.aliuser_reg_checkbox);
            this.mProtocolCB = checkBox;
            ProtocolHelper.setCheckBox(checkBox, getPageName(), "", this.mCheckBoxSwitch, false);
            this.mProtocolTV = (TextView) view.findViewById(com.ali.user.mobile.ui.R.id.aliuser_protocol_tv);
            if (this.mCheckBoxSwitch) {
                generateProtocol("", "");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.mLoginReceiver = new BroadcastReceiver() { // from class: com.taobao.android.sso.v2.launch.ui.GuideFragment.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (!LoginResActions.LOGIN_SUCCESS_ACTION.equals(intent.getAction()) || ((BaseFragment) GuideFragment.this).mAttachedActivity == null) {
                    return;
                }
                ((BaseFragment) GuideFragment.this).mAttachedActivity.finish();
            }
        };
        LocalBroadcastManager.getInstance(DataProviderFactory.getApplicationContext()).registerReceiver(this.mLoginReceiver, new IntentFilter(LoginResActions.LOGIN_SUCCESS_ACTION));
        if (!z2 && !z) {
            goTaobaoLoginFragment();
            this.mAttachedActivity.supportTaobaoOrAlipay = false;
            return;
        }
        this.mAttachedActivity.supportTaobaoOrAlipay = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onAccountLoginClick(View view) {
        goTaobaoLoginFragment();
    }

    protected void onAlipayLoginClick(View view) {
        try {
            SsoLogin.launchAlipay(this.mAttachedActivity);
        } catch (Exception e) {
            e.printStackTrace();
            BroadCastHelper.sendLocalBroadCast(new Intent(LoginResActions.LOGIN_NETWORK_ERROR));
            Toast.makeText(DataProviderFactory.getApplicationContext(), DataProviderFactory.getApplicationContext().getString(R.string.aliuser_network_error), 0).show();
        }
    }

    protected void onCheckLogin(final int i) {
        CheckBox checkBox;
        if (this.mCheckBoxSwitch && (checkBox = this.mProtocolCB) != null && !checkBox.isChecked()) {
            UserTrackAdapter.sendUT(getPageName(), "RegAgreement");
            final TaobaoRegProtocolDialogFragment rrotocolFragment = getRrotocolFragment();
            rrotocolFragment.setFirst(true);
            rrotocolFragment.setPostiveBtnText(getString(com.ali.user.mobile.ui.R.string.aliuser_agree));
            rrotocolFragment.setNegativeBtnText(getString(com.ali.user.mobile.ui.R.string.aliuser_protocol_disagree));
            rrotocolFragment.setNagetive(new View.OnClickListener() { // from class: com.taobao.android.sso.v2.launch.ui.GuideFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UserTrackAdapter.sendControlUT(GuideFragment.this.getPageName(), "Agreement_Button_Agree");
                    rrotocolFragment.dismissAllowingStateLoss();
                }
            });
            rrotocolFragment.setPositive(new View.OnClickListener() { // from class: com.taobao.android.sso.v2.launch.ui.GuideFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UserTrackAdapter.sendControlUT(GuideFragment.this.getPageName(), "Agreement_Button_Cancel");
                    rrotocolFragment.dismissAllowingStateLoss();
                    GuideFragment.this.mProtocolCB.setChecked(true);
                    GuideFragment.this.doRealAction(i);
                }
            });
            rrotocolFragment.show(getActivity().getSupportFragmentManager(), getPageName());
            return;
        }
        doRealAction(i);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.ali_user_guide_close_layout) {
            UserTrackAdapter.sendControlUT(PAGE_NAME, "Button-GuideClose");
            onCloseClick(view);
        } else if (id == R.id.ali_user_guide_tb_login_btn) {
            addCheckAction(LoginClickAction.ACTION_TAOBAO);
        } else if (id == R.id.ali_user_guide_alipay_login_btn) {
            addCheckAction(LoginClickAction.ACTION_ALIPAY);
        } else if (id == R.id.ali_user_guide_account_login_btn) {
            UserTrackAdapter.sendControlUT(PAGE_NAME, "Button-PwdLogin");
            onAccountLoginClick(view);
        }
    }

    protected void onCloseClick(View view) {
        BroadCastHelper.sendLocalBroadCast(new Intent(LoginResActions.LOGIN_CANCEL_ACTION));
        this.mAttachedActivity.finish();
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mLoginReceiver != null) {
            LocalBroadcastManager.getInstance(DataProviderFactory.getApplicationContext()).unregisterReceiver(this.mLoginReceiver);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        UserTrackAdapter.updatePageName(getActivity(), PAGE_NAME);
    }

    protected void onTbLoginClick(View view) {
        try {
            SsoLogin.launchTao(this.mAttachedActivity);
        } catch (Exception e) {
            e.printStackTrace();
            BroadCastHelper.sendLocalBroadCast(new Intent(LoginResActions.LOGIN_NETWORK_ERROR));
            Toast.makeText(DataProviderFactory.getApplicationContext(), DataProviderFactory.getApplicationContext().getString(R.string.aliuser_network_error), 0).show();
        }
    }

    protected void setCheckBoxSwitch() {
        this.mCheckBoxSwitch = true;
    }
}
