package cn.damai.mine.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.faceverify.bean.BaseFaceVerifyBean;
import cn.damai.commonbusiness.faceverify.request.FaceVerifyNextStepRequest;
import cn.damai.commonbusiness.model.RealNameAuthStatusBean;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.im.AliMeUtil;
import cn.damai.mine.bean.RealNameVerifyBean;
import cn.damai.mine.contract.RealNameAuthStatusContract;
import cn.damai.mine.presenter.RealNameAuthStatusPresenter;
import com.alibaba.security.rp.RPSDK;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ut.mini.UTAnalytics;
import java.util.HashMap;
import tb.kg2;
import tb.mu0;
import tb.my1;
import tb.vf1;
import tb.xr;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class RealNameFaceVerifyFailedActivity extends DamaiBaseActivity<RealNameAuthStatusPresenter, RealNameAuthStatusContract.Model> implements RealNameAuthStatusContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private String failedType;
    private TextView mAuthErrorMsg;
    private TextView mAuthErrorRightBtn;
    private TextView mAuthErrorStatus;
    private RealNameAuthStatusBean mAuthStatusBean;
    private ImageView mErrorImg;
    private ScrollView mRealNameFailedLayout;
    private TextView mTitle;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class a implements RPSDK.RPCompletedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // com.alibaba.security.rp.RPSDK.RPCompletedListener
        public void onAuditResult(RPSDK.AUDIT audit) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-400067820")) {
                ipChange.ipc$dispatch("-400067820", new Object[]{this, audit});
            } else if (audit != RPSDK.AUDIT.AUDIT_NOT) {
                RealNameFaceVerifyFailedActivity.this.notifyServer(audit);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class b implements AliMeUtil.UserCodeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* loaded from: classes6.dex */
        public class a implements AliMeUtil.AliMeTokenListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // cn.damai.im.AliMeUtil.AliMeTokenListener
            public void onFailed() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "175929799")) {
                    ipChange.ipc$dispatch("175929799", new Object[]{this});
                } else {
                    AliMeUtil.o();
                }
            }

            @Override // cn.damai.im.AliMeUtil.AliMeTokenListener
            public void onSuccess(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1252485683")) {
                    ipChange.ipc$dispatch("-1252485683", new Object[]{this, str});
                } else {
                    AliMeUtil.b(RealNameFaceVerifyFailedActivity.this, AliMeUtil.c(AliMeUtil.FROM_REALNAME_AUTH, str));
                }
            }
        }

        b() {
        }

        @Override // cn.damai.im.AliMeUtil.UserCodeListener
        public void onFailed() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "661780282")) {
                ipChange.ipc$dispatch("661780282", new Object[]{this});
            } else {
                AliMeUtil.o();
            }
        }

        @Override // cn.damai.im.AliMeUtil.UserCodeListener
        public void onSuccess(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1252080364")) {
                ipChange.ipc$dispatch("-1252080364", new Object[]{this, Long.valueOf(j)});
            } else {
                AliMeUtil.e(j, AliMeUtil.FROM_REALNAME_AUTH, new a());
            }
        }
    }

    private void fetchAuthStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1204758319")) {
            ipChange.ipc$dispatch("1204758319", new Object[]{this});
        } else {
            ((RealNameAuthStatusPresenter) this.mPresenter).getAuthResult();
        }
    }

    private void getFaceVerifyToken(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-106127622")) {
            ipChange.ipc$dispatch("-106127622", new Object[]{this, Boolean.valueOf(z)});
        } else {
            ((RealNameAuthStatusPresenter) this.mPresenter).getFaceVerifyToken(z);
        }
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1912835799")) {
            ipChange.ipc$dispatch("1912835799", new Object[]{this});
            return;
        }
        this.mRealNameFailedLayout = (ScrollView) findViewById(R$id.realname_autherror_layout);
        this.mErrorImg = (ImageView) findViewById(R$id.realname_error_img);
        this.mTitle = (TextView) findViewById(R$id.mine_base_header_title);
        this.mAuthErrorStatus = (TextView) findViewById(R$id.realname_error_status);
        this.mAuthErrorMsg = (TextView) findViewById(R$id.realname_error_msg);
        TextView textView = (TextView) findViewById(R$id.realname_error_right_btn);
        this.mAuthErrorRightBtn = textView;
        textView.setOnClickListener(this);
        findViewById(R$id.realname_error_left_btn).setOnClickListener(this);
        findViewById(R$id.realname_title_back).setOnClickListener(this);
    }

    private void initExtras() {
        Bundle extras;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1689686028")) {
            ipChange.ipc$dispatch("-1689686028", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        this.failedType = extras.getString("failedType");
    }

    private void initTitleStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-231926962")) {
            ipChange.ipc$dispatch("-231926962", new Object[]{this});
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

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyServer(final RPSDK.AUDIT audit) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-129077930")) {
            ipChange.ipc$dispatch("-129077930", new Object[]{this, audit});
            return;
        }
        FaceVerifyNextStepRequest faceVerifyNextStepRequest = new FaceVerifyNextStepRequest();
        faceVerifyNextStepRequest.loginKey = z20.q();
        faceVerifyNextStepRequest.scene = "accountVerify";
        faceVerifyNextStepRequest.request(new DMMtopRequestListener<BaseFaceVerifyBean>(BaseFaceVerifyBean.class) { // from class: cn.damai.mine.activity.RealNameFaceVerifyFailedActivity.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-736374836")) {
                    ipChange2.ipc$dispatch("-736374836", new Object[]{this, str, str2});
                } else {
                    ToastUtil.i(str2);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(BaseFaceVerifyBean baseFaceVerifyBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-371682566")) {
                    ipChange2.ipc$dispatch("-371682566", new Object[]{this, baseFaceVerifyBean});
                    return;
                }
                RPSDK.AUDIT audit2 = audit;
                if (audit2 == RPSDK.AUDIT.AUDIT_PASS) {
                    ToastUtil.i("认证通过");
                    xr.c("auth_success", "");
                } else if (audit2 == RPSDK.AUDIT.AUDIT_IN_AUDIT) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(RealNameAuthErrorActivity.REALNAME_AUTH_ERROR_TAG, 3);
                    DMNav.from(RealNameFaceVerifyFailedActivity.this).withExtras(bundle).toUri(NavUri.b("realname_error"));
                    ToastUtil.i("审核中");
                    xr.c("auth_verifing", "");
                } else if (audit2 == RPSDK.AUDIT.AUDIT_FAIL) {
                    ToastUtil.i("认证失败");
                }
            }
        });
    }

    private void refreshErrorView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-869687947")) {
            ipChange.ipc$dispatch("-869687947", new Object[]{this});
            return;
        }
        findViewById(R$id.realname_right_icon).setVisibility(8);
        this.mRealNameFailedLayout.setVisibility(0);
        this.mErrorImg.setImageResource(R$drawable.realname_auth_failed_pic);
        this.mTitle.setText("审核失败");
        this.mAuthErrorStatus.setText("审核失败");
        RealNameAuthStatusBean realNameAuthStatusBean = this.mAuthStatusBean;
        if (realNameAuthStatusBean != null && !TextUtils.isEmpty(realNameAuthStatusBean.getFaceVerifyFailedMsg())) {
            this.mAuthErrorMsg.setText(this.mAuthStatusBean.getFaceVerifyFailedMsg());
        }
        this.mAuthErrorRightBtn.setText("重新认证");
    }

    private void retryAuth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2046285357")) {
            ipChange.ipc$dispatch("-2046285357", new Object[]{this});
            return;
        }
        RealNameAuthStatusBean realNameAuthStatusBean = this.mAuthStatusBean;
        if (realNameAuthStatusBean != null) {
            int accountVerifyCode = realNameAuthStatusBean.getAccountVerifyCode();
            int faceVerifyCode = this.mAuthStatusBean.getFaceVerifyCode();
            if (accountVerifyCode == 1 || accountVerifyCode == 5) {
                DMNav.from(this).toUri(NavUri.b("nameauth"));
            } else if (faceVerifyCode == 5) {
                getFaceVerifyToken(true);
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-110051057")) {
            ipChange.ipc$dispatch("-110051057", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.mine.contract.RealNameAuthStatusContract.View
    public void faceVerifing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1275764264")) {
            ipChange.ipc$dispatch("1275764264", new Object[]{this});
        } else {
            finish();
        }
    }

    @Override // cn.damai.mine.contract.RealNameAuthStatusContract.View
    public void faceVerifySuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1067790646")) {
            ipChange.ipc$dispatch("1067790646", new Object[]{this});
        } else {
            finish();
        }
    }

    @Override // cn.damai.mine.contract.RealNameAuthStatusContract.View
    public void getAuthStatus(RealNameAuthStatusBean realNameAuthStatusBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1256232672")) {
            ipChange.ipc$dispatch("-1256232672", new Object[]{this, realNameAuthStatusBean});
        } else if (realNameAuthStatusBean == null) {
        } else {
            this.mAuthStatusBean = realNameAuthStatusBean;
            refreshErrorView();
        }
    }

    @Override // cn.damai.mine.contract.RealNameAuthStatusContract.View
    public void getAuthStatusFailed(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1100672598")) {
            ipChange.ipc$dispatch("-1100672598", new Object[]{this, str, str2});
        } else if (TextUtils.isEmpty(str2)) {
        } else {
            ToastUtil.i(str2);
        }
    }

    @Override // cn.damai.mine.contract.RealNameAuthStatusContract.View
    public void getFaceVerifyTokenFailed(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1507326065")) {
            ipChange.ipc$dispatch("1507326065", new Object[]{this, str, str2});
        } else if (TextUtils.isEmpty(str2)) {
        } else {
            ToastUtil.i(str2);
        }
    }

    @Override // cn.damai.mine.contract.RealNameAuthStatusContract.View
    public void getFaceVerifyTokenSuccess(RealNameVerifyBean realNameVerifyBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1322591036")) {
            ipChange.ipc$dispatch("-1322591036", new Object[]{this, realNameVerifyBean});
        } else if (realNameVerifyBean == null || TextUtils.isEmpty(realNameVerifyBean.getVerifyToken())) {
        } else {
            c.e().x(vf1.x().s());
            try {
                if (mu0.a() == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("contentlabel", "application 为null");
                    c.e().A(hashMap, "RPSDK_Application", vf1.REALNAME_VERIFYFAIL_PAGE);
                    return;
                }
                my1.a(mu0.a());
                if (RPSDK.getContext() == null) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("contentlabel", "RPSDK Context 为null");
                    c.e().A(hashMap2, "RPSDK_Context", vf1.REALNAME_VERIFYFAIL_PAGE);
                    return;
                }
                RPSDK.start(realNameVerifyBean.getVerifyToken(), this, new a());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1169882245") ? ((Integer) ipChange.ipc$dispatch("-1169882245", new Object[]{this})).intValue() : R$layout.realname_faceverify_failed_layout;
    }

    public void gotoAliMe() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1481688880")) {
            ipChange.ipc$dispatch("1481688880", new Object[]{this});
        } else {
            AliMeUtil.j(new b());
        }
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "526357344")) {
            ipChange.ipc$dispatch("526357344", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "508069579")) {
            ipChange.ipc$dispatch("508069579", new Object[]{this});
        } else {
            ((RealNameAuthStatusPresenter) this.mPresenter).setVM(this, (RealNameAuthStatusContract.Model) this.mModel);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2063520526")) {
            ipChange.ipc$dispatch("-2063520526", new Object[]{this});
            return;
        }
        hideBaseLayout();
        init();
        initTitleStatusBar();
        fetchAuthStatus();
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2041167448")) {
            ipChange.ipc$dispatch("2041167448", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        int id = view.getId();
        if (id == R$id.realname_error_right_btn) {
            retryAuth();
        } else if (id == R$id.realname_error_left_btn) {
            gotoAliMe();
        } else if (id == R$id.realname_title_back) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-225560056")) {
            ipChange.ipc$dispatch("-225560056", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        initExtras();
        refreshErrorView();
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.failedType)) {
            hashMap.put(vf1.REALNAME_FAILURE_REASON_PAGE, this.failedType);
        } else {
            hashMap.put(vf1.REALNAME_FAILURE_REASON_PAGE, "");
        }
        setDamaiUTKeyBuilder(vf1.x().Z());
        UTAnalytics.getInstance().getDefaultTracker().updatePageProperties(this, hashMap);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1768907919")) {
            ipChange.ipc$dispatch("1768907919", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2047466406")) {
            ipChange.ipc$dispatch("2047466406", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-857622865")) {
            return (String) ipChange.ipc$dispatch("-857622865", new Object[]{this});
        }
        return null;
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-719053298")) {
            ipChange.ipc$dispatch("-719053298", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1610343094")) {
            ipChange.ipc$dispatch("-1610343094", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2126512558")) {
            ipChange.ipc$dispatch("2126512558", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-50252887")) {
            ipChange.ipc$dispatch("-50252887", new Object[]{this});
        }
    }
}
