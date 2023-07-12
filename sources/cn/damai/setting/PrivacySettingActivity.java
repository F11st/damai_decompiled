package cn.damai.setting;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.damai.common.nav.DMNav;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.login.LoginManager;
import cn.damai.setting.bean.PrivacyPermissionBean;
import cn.damai.setting.bean.PrivacyPermissionItemBean;
import cn.damai.setting.bean.SetPrivacyPermissionBean;
import cn.damai.setting.net.QueryPrivacyPermissonRequest;
import cn.damai.setting.net.SetupPermissionListRequest;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.switchbutton.SwitchButton;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.kg2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class PrivacySettingActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isCheckedProtocol;
    private boolean isReturnProtocol;
    private TextView mDnaContentTv;
    private TextView mDnaErrorTv;
    private SwitchButton mDnaSwitch;
    private DMIconFontTextView mDneCheckIcon;
    private DMIconFontTextView mDneErrorIcon;
    private SwitchButton mRecSwitchNoLogin;
    private SwitchButton mRecommendSwitch;
    private SwitchButton mSeeSwitch;
    private View mViewWhenLogin;
    private View mViewWhenNoLogin;
    private final HashMap<Integer, Integer> switchRecode = new HashMap<>();

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a extends ClickableSpan {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "778566446")) {
                ipChange.ipc$dispatch("778566446", new Object[]{this, view});
            } else {
                DMNav.from(PrivacySettingActivity.this).toUri(this.a);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1023522487")) {
                ipChange.ipc$dispatch("-1023522487", new Object[]{this, textPaint});
                return;
            }
            textPaint.setColor(Color.parseColor("#FF2869"));
            textPaint.setUnderlineText(false);
        }
    }

    private void initRecommendConfig() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1905009774")) {
            ipChange.ipc$dispatch("1905009774", new Object[]{this});
            return;
        }
        this.mRecommendSwitch.setChecked(z20.K());
        this.mRecSwitchNoLogin.setChecked(z20.K());
    }

    private void initTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1276236724")) {
            ipChange.ipc$dispatch("1276236724", new Object[]{this});
            return;
        }
        hideBaseLayout();
        ((TextView) findViewById(R$id.mine_title_tv)).setText(getResources().getString(R$string.mine_privacy_setting_tips));
        ((DMIconFontTextView) findViewById(R$id.mine_title_left_icon_font_tv)).setOnClickListener(this);
    }

    private void initTitleStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1316074453")) {
            ipChange.ipc$dispatch("1316074453", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.title_bar_space);
        if (Build.VERSION.SDK_INT >= 23) {
            if (findViewById != null) {
                findViewById.getLayoutParams().height = kg2.a(this);
                findViewById.setVisibility(0);
            }
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
            return;
        }
        kg2.f(this, false, R$color.black);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    private void initViewContent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2024964408")) {
            ipChange.ipc$dispatch("2024964408", new Object[]{this});
            return;
        }
        this.mDnaSwitch = (SwitchButton) findViewById(R$id.switch_dna);
        this.mRecommendSwitch = (SwitchButton) findViewById(R$id.recommend_switch);
        this.mSeeSwitch = (SwitchButton) findViewById(R$id.see_switch);
        this.mDneCheckIcon = (DMIconFontTextView) findViewById(R$id.dtv_dna_check);
        this.mDnaContentTv = (TextView) findViewById(R$id.tv_dna_content);
        this.mDneErrorIcon = (DMIconFontTextView) findViewById(R$id.dtv_dna_error_icon);
        this.mDnaErrorTv = (TextView) findViewById(R$id.tv_dna_error);
        this.mViewWhenLogin = findViewById(R$id.privacy_view_when_login);
        this.mViewWhenNoLogin = findViewById(R$id.rl_recommend_switch_when_not_login);
        this.mRecSwitchNoLogin = (SwitchButton) findViewById(R$id.recommend_switch_when_not_login);
    }

    private void requestQueryPermissionList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2136268104")) {
            ipChange.ipc$dispatch("2136268104", new Object[]{this});
        } else {
            new QueryPrivacyPermissonRequest().request(new DMMtopRequestListener<PrivacyPermissionBean>(PrivacyPermissionBean.class) { // from class: cn.damai.setting.PrivacySettingActivity.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-2012304494")) {
                        ipChange2.ipc$dispatch("-2012304494", new Object[]{this, str, str2});
                        return;
                    }
                    PrivacySettingActivity privacySettingActivity = PrivacySettingActivity.this;
                    privacySettingActivity.setDnaContent(privacySettingActivity.getString(R$string.mine_privacy_setting_dna_protocol_error), null);
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(PrivacyPermissionBean privacyPermissionBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1593918700")) {
                        ipChange2.ipc$dispatch("-1593918700", new Object[]{this, privacyPermissionBean});
                        return;
                    }
                    for (int i = 0; i < privacyPermissionBean.queryPermissionList.size(); i++) {
                        PrivacyPermissionItemBean privacyPermissionItemBean = privacyPermissionBean.queryPermissionList.get(i);
                        PrivacySettingActivity.this.switchRecode.put(privacyPermissionItemBean.permissionType, privacyPermissionItemBean.value);
                        if (PrivacyPermissionItemBean.DNA_TAG.equals(privacyPermissionItemBean.permissionType)) {
                            PrivacySettingActivity privacySettingActivity = PrivacySettingActivity.this;
                            privacySettingActivity.setDnaContent("《" + privacyPermissionItemBean.protocolName + "》", privacyPermissionItemBean.protocolLink);
                            PrivacySettingActivity.this.isCheckedProtocol = privacyPermissionItemBean.value.intValue() == 1;
                            PrivacySettingActivity.this.mDneCheckIcon.setText(!PrivacySettingActivity.this.isCheckedProtocol ? R$string.iconfont_gouxuanweixuanzhong28 : R$string.iconfont_gouxuanxuanzhong28);
                        }
                    }
                    PrivacySettingActivity.this.upDateAllSwitchState();
                }
            });
        }
    }

    private void requestSetupPermission() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-169902159")) {
            ipChange.ipc$dispatch("-169902159", new Object[]{this});
            return;
        }
        SetupPermissionListRequest setupPermissionListRequest = new SetupPermissionListRequest();
        setupPermissionListRequest.setSetupPermissionMap(this.switchRecode);
        setupPermissionListRequest.request(new DMMtopRequestListener<SetPrivacyPermissionBean>(SetPrivacyPermissionBean.class) { // from class: cn.damai.setting.PrivacySettingActivity.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2020063853")) {
                    ipChange2.ipc$dispatch("-2020063853", new Object[]{this, str, str2});
                    return;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = "设置失败啦";
                }
                ToastUtil.i(str2);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(SetPrivacyPermissionBean setPrivacyPermissionBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-861250129")) {
                    ipChange2.ipc$dispatch("-861250129", new Object[]{this, setPrivacyPermissionBean});
                    return;
                }
                for (int i = 0; i < setPrivacyPermissionBean.setupPermissionList.size(); i++) {
                    PrivacyPermissionItemBean privacyPermissionItemBean = setPrivacyPermissionBean.setupPermissionList.get(i);
                    PrivacySettingActivity.this.switchRecode.put(privacyPermissionItemBean.permissionType, privacyPermissionItemBean.value);
                }
                PrivacySettingActivity.this.upDateAllSwitchState();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDnaContent(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1474041460")) {
            ipChange.ipc$dispatch("-1474041460", new Object[]{this, str, str2});
            return;
        }
        String string = getString(R$string.mine_privacy_setting_dna_content_tips_part1);
        String str3 = string + str + getString(R$string.mine_privacy_setting_dna_content_tips_part2);
        int length = string.length();
        int length2 = string.length() + str.length();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str3);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            spannableStringBuilder.setSpan(new a(str2), length, length2, 33);
            showDnaError(false);
            this.isReturnProtocol = true;
            this.mDneCheckIcon.setClickable(true);
        } else {
            showDnaError(true);
            this.isReturnProtocol = false;
            this.mDneCheckIcon.setClickable(false);
        }
        this.mDnaContentTv.setMovementMethod(LinkMovementMethod.getInstance());
        this.mDnaContentTv.setText(spannableStringBuilder);
        this.mDnaContentTv.setHighlightColor(Color.parseColor("#00000000"));
    }

    private void setProtocolCheck(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2140029044")) {
            ipChange.ipc$dispatch("2140029044", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mDneCheckIcon.setText(!z ? R$string.iconfont_gouxuanweixuanzhong28 : R$string.iconfont_gouxuanxuanzhong28);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void upDateAllSwitchState() {
        IpChange ipChange = $ipChange;
        Integer num = 1;
        if (AndroidInstantRuntime.support(ipChange, "982436841")) {
            ipChange.ipc$dispatch("982436841", new Object[]{this});
            return;
        }
        for (Integer num2 : this.switchRecode.keySet()) {
            if (PrivacyPermissionItemBean.WANT_SEE_TAG.equals(num2)) {
                this.mSeeSwitch.setChecked(num.equals(this.switchRecode.get(num2)));
            } else if (PrivacyPermissionItemBean.DNA_TAG.equals(num2)) {
                this.mDnaSwitch.setChecked(num.equals(this.switchRecode.get(num2)));
                this.mDneCheckIcon.setClickable(!this.mDnaSwitch.isChecked());
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1650337962")) {
            ipChange.ipc$dispatch("-1650337962", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 10003) {
            finish();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "364043476") ? ((Integer) ipChange.ipc$dispatch("364043476", new Object[]{this})).intValue() : R$layout.mine_privacy_setting_layout;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "833414439")) {
            ipChange.ipc$dispatch("833414439", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1436904932")) {
            ipChange.ipc$dispatch("1436904932", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-137070023")) {
            ipChange.ipc$dispatch("-137070023", new Object[]{this});
            return;
        }
        initTitle();
        initTitleStatusBar();
        initViewContent();
        registerListener();
        initRecommendConfig();
        if (LoginManager.k().q()) {
            this.mViewWhenNoLogin.setVisibility(8);
            this.mViewWhenLogin.setVisibility(0);
            requestQueryPermissionList();
            return;
        }
        this.mViewWhenNoLogin.setVisibility(0);
        this.mViewWhenLogin.setVisibility(8);
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        SwitchButton switchButton;
        SwitchButton switchButton2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1197795295")) {
            ipChange.ipc$dispatch("1197795295", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        int id = view.getId();
        if (id == R$id.mine_title_left_icon_font_tv) {
            finish();
        } else if (id != R$id.dtv_dna_error_icon && id != R$id.tv_dna_error) {
            if (id == R$id.dtv_dna_check) {
                boolean z = !this.isCheckedProtocol;
                this.isCheckedProtocol = z;
                this.mDneCheckIcon.setText(!z ? R$string.iconfont_gouxuanweixuanzhong28 : R$string.iconfont_gouxuanxuanzhong28);
            } else if (id == R$id.switch_dna) {
                if (!this.isReturnProtocol) {
                    ToastUtil.i("协议加载失败，稍后再试");
                    this.mDnaSwitch.setChecked(!switchButton2.isChecked());
                    return;
                }
                if (this.isCheckedProtocol) {
                    this.switchRecode.put(PrivacyPermissionItemBean.DNA_TAG, Integer.valueOf(this.mDnaSwitch.isChecked() ? 1 : 0));
                    requestSetupPermission();
                    this.mDneCheckIcon.setClickable(!this.mDnaSwitch.isChecked());
                } else {
                    ToastUtil.i("请先勾选同意协议哦");
                    this.mDnaSwitch.setChecked(!switchButton.isChecked());
                }
                boolean isChecked = this.mDnaSwitch.isChecked();
                this.isCheckedProtocol = isChecked;
                this.mDneCheckIcon.setText(!isChecked ? R$string.iconfont_gouxuanweixuanzhong28 : R$string.iconfont_gouxuanxuanzhong28);
            } else if (id == R$id.recommend_switch) {
                z20.a0(this.mRecommendSwitch.isChecked());
            } else if (id == R$id.recommend_switch_when_not_login) {
                z20.a0(this.mRecSwitchNoLogin.isChecked());
            } else if (id == R$id.see_switch) {
                this.switchRecode.put(PrivacyPermissionItemBean.WANT_SEE_TAG, Integer.valueOf(this.mSeeSwitch.isChecked() ? 1 : 0));
                requestSetupPermission();
            }
        } else {
            requestQueryPermissionList();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-600293023")) {
            ipChange.ipc$dispatch("-600293023", new Object[]{this, bundle});
        } else {
            super.onCreate(bundle);
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2075965014")) {
            ipChange.ipc$dispatch("2075965014", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-713575169")) {
            ipChange.ipc$dispatch("-713575169", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "533756866")) {
            ipChange.ipc$dispatch("533756866", new Object[]{this});
        } else {
            super.onResume();
        }
    }

    public void registerListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1077781161")) {
            ipChange.ipc$dispatch("-1077781161", new Object[]{this});
            return;
        }
        this.mDneCheckIcon.setOnClickListener(this);
        this.mDneErrorIcon.setOnClickListener(this);
        this.mDnaErrorTv.setOnClickListener(this);
        this.mDnaSwitch.setOnClickListener(this);
        this.mRecommendSwitch.setOnClickListener(this);
        this.mSeeSwitch.setOnClickListener(this);
        this.mRecSwitchNoLogin.setOnClickListener(this);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1609023560") ? (String) ipChange.ipc$dispatch("1609023560", new Object[]{this}) : "";
    }

    public void showDnaError(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "229468468")) {
            ipChange.ipc$dispatch("229468468", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mDneErrorIcon.setVisibility(z ? 0 : 8);
        this.mDnaErrorTv.setVisibility(z ? 0 : 8);
    }
}
