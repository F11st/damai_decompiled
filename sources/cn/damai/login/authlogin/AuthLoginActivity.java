package cn.damai.login.authlogin;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.common.image.C0504a;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.h5container.DamaiCookieManager;
import cn.damai.login.authlogin.req.ThirdPartyAuthRequest;
import cn.damai.login.authlogin.resp.AuthInfoBean;
import cn.damai.login.authlogin.resp.ThirdSessionModel;
import cn.damai.login.authlogin.ui.DMUrlSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Iterator;
import mtopsdk.mtop.util.ErrorConstant;
import org.apache.commons.lang3.StringUtils;
import tb.cs;
import tb.m91;
import tb.wh2;
import tb.z8;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class AuthLoginActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY_INFO_NEED_AUTH = "key_info_need_auth";
    public static final String KEY_THIRD_URL = "key_third_url";
    private View.OnClickListener mAgreementClickListener = new View$OnClickListenerC1321a();
    private TextView mAuthAgreementView;
    private TextView mAuthButton;
    private TextView mAuthDetailView;
    private AuthInfoBean mAuthInfo;
    private TextView mAuthTitleView;
    private z8 mAuthUtHelper;
    private ImageView mAuthorizedIcon;
    private ThirdSessionModel mAuthorizedModel;
    private ImageView mAuthorizerIcon;
    private String mBizType;
    private ThirdSessionModel mModel;
    private String mThirdUrl;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.login.authlogin.AuthLoginActivity$a */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1321a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1321a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2031520084")) {
                ipChange.ipc$dispatch("2031520084", new Object[]{this, view});
            } else {
                C0529c.e().x(AuthLoginActivity.this.mAuthUtHelper.f(AuthLoginActivity.this.mBizType));
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.login.authlogin.AuthLoginActivity$b */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1322b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1322b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-152156843")) {
                ipChange.ipc$dispatch("-152156843", new Object[]{this, view});
                return;
            }
            AuthLoginActivity.this.requestAuthThirdPage();
            C0529c.e().x(AuthLoginActivity.this.mAuthUtHelper.g(AuthLoginActivity.this.mBizType));
        }
    }

    private void parseParam(Intent intent) {
        ThirdSessionModel.Extra extra;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1076180985")) {
            ipChange.ipc$dispatch("1076180985", new Object[]{this, intent});
        } else if (intent == null) {
        } else {
            this.mThirdUrl = intent.getStringExtra(KEY_THIRD_URL);
            ThirdSessionModel thirdSessionModel = (ThirdSessionModel) intent.getSerializableExtra(KEY_INFO_NEED_AUTH);
            this.mModel = thirdSessionModel;
            if (thirdSessionModel != null && (extra = thirdSessionModel.extra) != null) {
                this.mAuthInfo = extra.authorizePageInfo;
            }
            if (thirdSessionModel != null) {
                this.mBizType = thirdSessionModel.bizType;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestAuthThirdPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-521535241")) {
            ipChange.ipc$dispatch("-521535241", new Object[]{this});
            return;
        }
        ThirdPartyAuthRequest thirdPartyAuthRequest = new ThirdPartyAuthRequest();
        thirdPartyAuthRequest.setOperator(ThirdPartyAuthRequest.OPTR_DO_AUTH);
        thirdPartyAuthRequest.setTarget(this.mThirdUrl);
        thirdPartyAuthRequest.request(new DMMtopRequestListener<ThirdSessionModel>(ThirdSessionModel.class) { // from class: cn.damai.login.authlogin.AuthLoginActivity.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-415328836")) {
                    ipChange2.ipc$dispatch("-415328836", new Object[]{this, str, str2});
                } else if (TextUtils.equals(ErrorConstant.ERRCODE_ANDROID_SYS_LOGIN_CANCEL, str)) {
                } else {
                    ToastUtil.f(str2);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(ThirdSessionModel thirdSessionModel) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1635848490")) {
                    ipChange2.ipc$dispatch("-1635848490", new Object[]{this, thirdSessionModel});
                } else if (thirdSessionModel != null && thirdSessionModel.hasAllow && !m91.a(thirdSessionModel.cookies)) {
                    AuthLoginActivity.this.mAuthorizedModel = thirdSessionModel;
                    DamaiCookieManager.getInstance().setCookie(AuthLoginActivity.this.mThirdUrl, AuthLoginActivity.this.mAuthorizedModel.cookies);
                    ToastUtil.c(AuthLoginActivity.this, 0, R$string.toast_opening_third_h5);
                    Bundle bundle = new Bundle();
                    bundle.putString("url", AuthLoginActivity.this.mThirdUrl);
                    DMNav.from(AuthLoginActivity.this).withExtras(bundle).toUri(NavUri.b(cs.t));
                    AuthLoginActivity.this.finish();
                } else {
                    ToastUtil.f("授权失败，请稍后重试");
                }
            }
        });
    }

    private void updateData(AuthInfoBean authInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "753713020")) {
            ipChange.ipc$dispatch("753713020", new Object[]{this, authInfoBean});
        } else if (authInfoBean == null) {
        } else {
            C0504a.b().loadinto(authInfoBean.fromIconUrl, this.mAuthorizerIcon);
            C0504a.b().loadinto(authInfoBean.toIconUrl, this.mAuthorizedIcon);
            this.mAuthTitleView.setText(authInfoBean.infoTitle);
            if (!m91.a(authInfoBean.infoList)) {
                StringBuilder sb = new StringBuilder();
                Iterator<String> it = authInfoBean.infoList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!wh2.j(next)) {
                        if (sb.length() > 0) {
                            sb.append(StringUtils.LF);
                        }
                        sb.append(next);
                    }
                }
                this.mAuthDetailView.setText(sb);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!wh2.j(authInfoBean.protocolTitle)) {
                spannableStringBuilder.append((CharSequence) authInfoBean.protocolTitle);
            }
            if (!m91.a(authInfoBean.protocolList)) {
                Iterator<AuthInfoBean.ProtocolInfo> it2 = authInfoBean.protocolList.iterator();
                while (it2.hasNext()) {
                    AuthInfoBean.ProtocolInfo next2 = it2.next();
                    if (next2.isValid()) {
                        int length = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) next2.protocolName);
                        DMUrlSpan dMUrlSpan = new DMUrlSpan(this, next2.protocolUrl);
                        dMUrlSpan.setOnClickListener(this.mAgreementClickListener);
                        spannableStringBuilder.setSpan(dMUrlSpan, length, next2.protocolName.length() + length, 17);
                    }
                }
            }
            this.mAuthAgreementView.setClickable(true);
            this.mAuthAgreementView.setMovementMethod(LinkMovementMethod.getInstance());
            this.mAuthAgreementView.setLinkTextColor(Color.parseColor("#10AAFF"));
            this.mAuthAgreementView.setText(spannableStringBuilder);
            this.mAuthButton.setOnClickListener(new View$OnClickListenerC1322b());
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1652958850")) {
            ipChange.ipc$dispatch("-1652958850", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 10001 || i == 10003) {
            onBackPressed();
            C0529c.e().z(this.mAuthUtHelper.h(this.mBizType));
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1717821012") ? ((Integer) ipChange.ipc$dispatch("-1717821012", new Object[]{this})).intValue() : R$layout.activity_third_auth;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "720124751")) {
            ipChange.ipc$dispatch("720124751", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2075075396")) {
            ipChange.ipc$dispatch("-2075075396", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-884661151")) {
            ipChange.ipc$dispatch("-884661151", new Object[]{this});
            return;
        }
        this.mAuthorizerIcon = (ImageView) findViewById(R$id.iv_auth_third_authorizer);
        this.mAuthorizedIcon = (ImageView) findViewById(R$id.iv_auth_third_authorized);
        this.mAuthTitleView = (TextView) findViewById(R$id.tv_auth_third_title);
        this.mAuthDetailView = (TextView) findViewById(R$id.tv_auth_third_detail);
        this.mAuthAgreementView = (TextView) findViewById(R$id.tv_auth_third_agreement);
        this.mAuthButton = (TextView) findViewById(R$id.tv_auth_third_btn);
        parseParam(getIntent());
        updateData(this.mAuthInfo);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1670588871")) {
            ipChange.ipc$dispatch("-1670588871", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        z8 z8Var = new z8();
        this.mAuthUtHelper = z8Var;
        setDamaiUTKeyBuilder(z8Var.i(this.mBizType));
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1902881568") ? (String) ipChange.ipc$dispatch("1902881568", new Object[]{this}) : "大麦账户授权";
    }
}
