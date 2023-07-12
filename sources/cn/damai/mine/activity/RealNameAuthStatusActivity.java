package cn.damai.mine.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.common.image.C0504a;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.faceverify.bean.BaseFaceVerifyBean;
import cn.damai.commonbusiness.faceverify.request.FaceVerifyNextStepRequest;
import cn.damai.commonbusiness.model.RealNameAuthStatusBean;
import cn.damai.h5container.H5MainActivity;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.im.AliMeUtil;
import cn.damai.login.LoginManager;
import cn.damai.mine.bean.RealNameVerifyBean;
import cn.damai.mine.contract.RealNameAuthStatusContract;
import cn.damai.mine.presenter.RealNameAuthStatusPresenter;
import com.alibaba.security.rp.RPSDK;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.uikit.feature.features.FeatureFactory;
import java.util.HashMap;
import tb.kg2;
import tb.m62;
import tb.mu0;
import tb.my1;
import tb.vf1;
import tb.xr;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class RealNameAuthStatusActivity extends DamaiBaseActivity<RealNameAuthStatusPresenter, RealNameAuthStatusContract.Model> implements RealNameAuthStatusContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private int faceAuthStatus;
    private String isFrom;
    private TextView mAuthCertNum;
    private TextView mAuthErrorMsg;
    private TextView mAuthErrorRightBtn;
    private TextView mAuthErrorStatus;
    private TextView mAuthName;
    private TextView mAuthStatus;
    private RealNameAuthStatusBean mAuthStatusBean;
    private LinearLayout mAuthedTagLayout;
    private ImageView mErrorImg;
    private RelativeLayout mFaceVerifyLayout;
    private ScrollView mRealNameFailedLayout;
    private ImageView mRealNameImg;
    private RelativeLayout mRealNameStatusLayout;
    private TextView mTitle;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.activity.RealNameAuthStatusActivity$a */
    /* loaded from: classes6.dex */
    public class C1409a implements RPSDK.RPCompletedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1409a() {
        }

        @Override // com.alibaba.security.rp.RPSDK.RPCompletedListener
        public void onAuditResult(RPSDK.AUDIT audit) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "51531003")) {
                ipChange.ipc$dispatch("51531003", new Object[]{this, audit});
            } else if (audit != RPSDK.AUDIT.AUDIT_NOT) {
                RealNameAuthStatusActivity.this.notifyServer(audit);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.activity.RealNameAuthStatusActivity$b */
    /* loaded from: classes6.dex */
    public class C1410b implements AliMeUtil.UserCodeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.mine.activity.RealNameAuthStatusActivity$b$a */
        /* loaded from: classes6.dex */
        public class C1411a implements AliMeUtil.AliMeTokenListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C1411a() {
            }

            @Override // cn.damai.im.AliMeUtil.AliMeTokenListener
            public void onFailed() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1629714770")) {
                    ipChange.ipc$dispatch("-1629714770", new Object[]{this});
                } else {
                    AliMeUtil.o();
                }
            }

            @Override // cn.damai.im.AliMeUtil.AliMeTokenListener
            public void onSuccess(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1643284090")) {
                    ipChange.ipc$dispatch("-1643284090", new Object[]{this, str});
                } else {
                    AliMeUtil.b(RealNameAuthStatusActivity.this, AliMeUtil.c(AliMeUtil.FROM_REALNAME_AUTH, str));
                }
            }
        }

        C1410b() {
        }

        @Override // cn.damai.im.AliMeUtil.UserCodeListener
        public void onFailed() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1972497951")) {
                ipChange.ipc$dispatch("-1972497951", new Object[]{this});
            } else {
                AliMeUtil.o();
            }
        }

        @Override // cn.damai.im.AliMeUtil.UserCodeListener
        public void onSuccess(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1237242363")) {
                ipChange.ipc$dispatch("1237242363", new Object[]{this, Long.valueOf(j)});
            } else {
                AliMeUtil.e(j, AliMeUtil.FROM_REALNAME_AUTH, new C1411a());
            }
        }
    }

    private void fetchAuthStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-582181656")) {
            ipChange.ipc$dispatch("-582181656", new Object[]{this});
        } else if (LoginManager.k().q()) {
            ((RealNameAuthStatusPresenter) this.mPresenter).getAuthResult();
        }
    }

    private void getFaceVerifyToken(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "60198963")) {
            ipChange.ipc$dispatch("60198963", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ((RealNameAuthStatusPresenter) this.mPresenter).getFaceVerifyToken(z);
        this.mAuthStatus.setClickable(false);
    }

    private int getHeight(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-257889609") ? ((Integer) ipChange.ipc$dispatch("-257889609", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})).intValue() : ((DisplayMetrics.getwidthPixels(m62.c(this)) - i3) * i2) / i;
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-533302594")) {
            ipChange.ipc$dispatch("-533302594", new Object[]{this});
            return;
        }
        this.mAuthName = (TextView) findViewById(R$id.realname_auth_result_name);
        this.mAuthCertNum = (TextView) findViewById(R$id.real_name_cert_num);
        this.mAuthStatus = (TextView) findViewById(R$id.realname_auth_status);
        this.mTitle = (TextView) findViewById(R$id.mine_base_header_title);
        this.mFaceVerifyLayout = (RelativeLayout) findViewById(R$id.realname_center_certnum_layout);
        this.mRealNameFailedLayout = (ScrollView) findViewById(R$id.realname_autherror_layout);
        this.mRealNameStatusLayout = (RelativeLayout) findViewById(R$id.realname_authstatus_layout);
        this.mAuthedTagLayout = (LinearLayout) findViewById(R$id.realname_authed_tag_layout);
        this.mRealNameImg = (ImageView) findViewById(R$id.realname_status_face_status_img);
        this.mAuthErrorStatus = (TextView) findViewById(R$id.realname_error_status);
        this.mAuthErrorMsg = (TextView) findViewById(R$id.realname_error_msg);
        this.mAuthErrorRightBtn = (TextView) findViewById(R$id.realname_error_right_btn);
        this.mErrorImg = (ImageView) findViewById(R$id.realname_error_img);
        initExtras();
    }

    private void initExtras() {
        Bundle extras;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-28996965")) {
            ipChange.ipc$dispatch("-28996965", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        this.isFrom = extras.getString("from");
    }

    private void initTitleStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1158911733")) {
            ipChange.ipc$dispatch("1158911733", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.title_bar_space);
        if (Build.VERSION.SDK_INT >= 23) {
            if (findViewById != null) {
                findViewById.getLayoutParams().height = kg2.a(this);
                findViewById.setVisibility(0);
            }
            kg2.f(this, true, R$color.white);
            kg2.d(true, this);
            return;
        }
        kg2.f(this, false, R$color.black);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    private void jumpByAuthStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-504483537")) {
            ipChange.ipc$dispatch("-504483537", new Object[]{this});
            return;
        }
        int i = this.faceAuthStatus;
        if (i == 1) {
            getFaceVerifyToken(false);
        } else if (i == 4) {
            jumpRealNameAuthErrorPage();
        } else if (i != 5 || this.mAuthStatusBean == null) {
        } else {
            Intent intent = new Intent(this, RealNameFaceVerifyFailedActivity.class);
            intent.putExtra("failedType", this.mAuthStatusBean.getFaceVerifyFailedType());
            startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpRealNameAuthErrorPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1300811228")) {
            ipChange.ipc$dispatch("-1300811228", new Object[]{this});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(RealNameAuthErrorActivity.REALNAME_AUTH_ERROR_TAG, 3);
        DMNav.from(this).withExtras(bundle).toUri(NavUri.b("realname_error"));
    }

    private void jumpRealNameAuthPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-905212928")) {
            ipChange.ipc$dispatch("-905212928", new Object[]{this});
        } else {
            DMNav.from(this).toUri(NavUri.b("nameauth"));
        }
    }

    private void loadBanner() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1883608548")) {
            ipChange.ipc$dispatch("-1883608548", new Object[]{this});
            return;
        }
        ImageView imageView = (ImageView) findViewById(R$id.authenticate_banner);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, getHeight(FeatureFactory.PRIORITY_ABOVE_NORMAL, H5MainActivity.REQUEST_REALNAME, 0)));
        C0504a.b().c("https://static.damai.cn/mapi/2017-04-07/5e0c314c-f09f-475e-a38f-7b25546035a9.jpg").g(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyServer(final RPSDK.AUDIT audit) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1355887823")) {
            ipChange.ipc$dispatch("1355887823", new Object[]{this, audit});
            return;
        }
        FaceVerifyNextStepRequest faceVerifyNextStepRequest = new FaceVerifyNextStepRequest();
        faceVerifyNextStepRequest.loginKey = z20.q();
        faceVerifyNextStepRequest.scene = "accountVerify";
        faceVerifyNextStepRequest.request(new DMMtopRequestListener<BaseFaceVerifyBean>(BaseFaceVerifyBean.class) { // from class: cn.damai.mine.activity.RealNameAuthStatusActivity.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1829338957")) {
                    ipChange2.ipc$dispatch("-1829338957", new Object[]{this, str, str2});
                } else {
                    ToastUtil.i(str2);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(BaseFaceVerifyBean baseFaceVerifyBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1267889741")) {
                    ipChange2.ipc$dispatch("-1267889741", new Object[]{this, baseFaceVerifyBean});
                    return;
                }
                RPSDK.AUDIT audit2 = audit;
                if (audit2 == RPSDK.AUDIT.AUDIT_PASS) {
                    ToastUtil.i("认证通过");
                    xr.c("auth_success", "");
                } else if (audit2 == RPSDK.AUDIT.AUDIT_IN_AUDIT) {
                    RealNameAuthStatusActivity.this.jumpRealNameAuthErrorPage();
                    ToastUtil.i("审核中");
                    xr.c("auth_verifing", "");
                } else if (audit2 == RPSDK.AUDIT.AUDIT_FAIL) {
                    ToastUtil.i("认证失败");
                }
            }
        });
    }

    private void refreshErrorView(RealNameAuthStatusBean realNameAuthStatusBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1719705513")) {
            ipChange.ipc$dispatch("1719705513", new Object[]{this, realNameAuthStatusBean});
            return;
        }
        findViewById(R$id.realname_right_icon).setVisibility(8);
        this.mRealNameStatusLayout.setVisibility(8);
        this.mRealNameFailedLayout.setVisibility(0);
        this.mErrorImg.setImageResource(R$drawable.realname_auth_failed_pic);
        this.mTitle.setText("审核失败");
        this.mAuthErrorStatus.setText("审核失败");
        if (!TextUtils.isEmpty(realNameAuthStatusBean.getFaceVerifyFailedMsg())) {
            this.mAuthErrorMsg.setText(realNameAuthStatusBean.getFaceVerifyFailedMsg());
        }
        this.mAuthErrorRightBtn.setText("重新认证");
    }

    private void refreshFaceUI(RealNameAuthStatusBean realNameAuthStatusBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-507599075")) {
            ipChange.ipc$dispatch("-507599075", new Object[]{this, realNameAuthStatusBean});
            return;
        }
        int faceVerifyCode = realNameAuthStatusBean.getFaceVerifyCode();
        if (faceVerifyCode == 1) {
            this.mRealNameImg.setImageResource(R$drawable.realname_noauth);
            this.mRealNameImg.setVisibility(0);
            findViewById(R$id.icon_more3).setVisibility(0);
        } else if (faceVerifyCode == 2) {
            this.mRealNameImg.setImageResource(R$drawable.realname_auth_success);
            this.mRealNameImg.setVisibility(0);
            findViewById(R$id.icon_more3).setVisibility(8);
        } else if (faceVerifyCode == 4) {
            this.mRealNameImg.setImageResource(R$drawable.realname_verifing);
            this.mRealNameImg.setVisibility(0);
            findViewById(R$id.icon_more3).setVisibility(0);
        } else if (faceVerifyCode == 5) {
            this.mRealNameImg.setImageResource(R$drawable.realname_auth_failed);
            this.mRealNameImg.setVisibility(0);
            findViewById(R$id.icon_more3).setVisibility(0);
        }
    }

    private void refreshUI(RealNameAuthStatusBean realNameAuthStatusBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2137003590")) {
            ipChange.ipc$dispatch("-2137003590", new Object[]{this, realNameAuthStatusBean});
            return;
        }
        this.mTitle.setText("实名认证中心");
        findViewById(R$id.realname_right_icon).setVisibility(0);
        this.mRealNameStatusLayout.setVisibility(0);
        this.mRealNameFailedLayout.setVisibility(8);
        this.faceAuthStatus = realNameAuthStatusBean.getFaceVerifyCode();
        int accountVerifyCode = realNameAuthStatusBean.getAccountVerifyCode();
        if (!TextUtils.isEmpty(realNameAuthStatusBean.getMaskName())) {
            this.mAuthName.setText(realNameAuthStatusBean.getMaskName());
        }
        if (accountVerifyCode != 2 && accountVerifyCode != 3) {
            this.mAuthedTagLayout.setVisibility(8);
        } else {
            this.mAuthedTagLayout.setVisibility(0);
        }
        if (!TextUtils.isEmpty(realNameAuthStatusBean.getMaskIdCard())) {
            this.mAuthCertNum.setText(realNameAuthStatusBean.getMaskIdCard());
        }
        if (!TextUtils.isEmpty(realNameAuthStatusBean.getFaceVerifyMsg())) {
            this.mAuthStatus.setText(realNameAuthStatusBean.getFaceVerifyMsg());
        }
        if (realNameAuthStatusBean.isFaceVerifyEnable()) {
            this.mFaceVerifyLayout.setVisibility(0);
        } else {
            this.mFaceVerifyLayout.setVisibility(8);
        }
        refreshFaceUI(realNameAuthStatusBean);
    }

    private void retryAuth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "224042572")) {
            ipChange.ipc$dispatch("224042572", new Object[]{this});
            return;
        }
        RealNameAuthStatusBean realNameAuthStatusBean = this.mAuthStatusBean;
        if (realNameAuthStatusBean != null) {
            int accountVerifyCode = realNameAuthStatusBean.getAccountVerifyCode();
            int faceVerifyCode = this.mAuthStatusBean.getFaceVerifyCode();
            if (accountVerifyCode == 1 || accountVerifyCode == 5) {
                jumpRealNameAuthPage();
            } else if (faceVerifyCode == 5) {
                getFaceVerifyToken(true);
            }
        }
    }

    private void setListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "641247238")) {
            ipChange.ipc$dispatch("641247238", new Object[]{this});
            return;
        }
        findViewById(R$id.realname_auth_status).setOnClickListener(this);
        findViewById(R$id.realname_title_back).setOnClickListener(this);
        findViewById(R$id.realname_right_icon).setOnClickListener(this);
        findViewById(R$id.realname_error_right_btn).setOnClickListener(this);
        findViewById(R$id.realname_error_left_btn).setOnClickListener(this);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "329384566")) {
            ipChange.ipc$dispatch("329384566", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.mine.contract.RealNameAuthStatusContract.View
    public void faceVerifing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-529880305")) {
            ipChange.ipc$dispatch("-529880305", new Object[]{this});
        } else if (TextUtils.isEmpty(this.isFrom) || !this.isFrom.equals("push")) {
        } else {
            finish();
        }
    }

    @Override // cn.damai.mine.contract.RealNameAuthStatusContract.View
    public void faceVerifySuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1805393071")) {
            ipChange.ipc$dispatch("1805393071", new Object[]{this});
        } else if (TextUtils.isEmpty(this.isFrom) || !this.isFrom.equals("push")) {
        } else {
            finish();
        }
    }

    @Override // cn.damai.mine.contract.RealNameAuthStatusContract.View
    public void getAuthStatus(RealNameAuthStatusBean realNameAuthStatusBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1487316057")) {
            ipChange.ipc$dispatch("1487316057", new Object[]{this, realNameAuthStatusBean});
        } else if (realNameAuthStatusBean == null) {
        } else {
            this.mAuthStatusBean = realNameAuthStatusBean;
            if (!TextUtils.isEmpty(this.isFrom) && this.isFrom.equals("push")) {
                if (realNameAuthStatusBean.getAccountVerifyCode() != 5 && (realNameAuthStatusBean.getAccountVerifyCode() != 3 || realNameAuthStatusBean.getFaceVerifyCode() != 5)) {
                    if (realNameAuthStatusBean.getAccountVerifyCode() == 1) {
                        jumpRealNameAuthPage();
                        finish();
                        return;
                    } else if (realNameAuthStatusBean.getAccountVerifyCode() == 4) {
                        jumpRealNameAuthErrorPage();
                        finish();
                        return;
                    }
                } else {
                    refreshErrorView(realNameAuthStatusBean);
                    return;
                }
            } else if (realNameAuthStatusBean.getAccountVerifyCode() == 5) {
                refreshErrorView(realNameAuthStatusBean);
                return;
            }
            refreshUI(realNameAuthStatusBean);
        }
    }

    @Override // cn.damai.mine.contract.RealNameAuthStatusContract.View
    public void getAuthStatusFailed(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "642292323")) {
            ipChange.ipc$dispatch("642292323", new Object[]{this, str, str2});
        } else if (TextUtils.isEmpty(str2)) {
        } else {
            ToastUtil.i(str2);
        }
    }

    @Override // cn.damai.mine.contract.RealNameAuthStatusContract.View
    public void getFaceVerifyTokenFailed(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1231422632")) {
            ipChange.ipc$dispatch("-1231422632", new Object[]{this, str, str2});
            return;
        }
        if (!TextUtils.isEmpty(str2)) {
            ToastUtil.i(str2);
        }
        this.mAuthStatus.setClickable(true);
    }

    @Override // cn.damai.mine.contract.RealNameAuthStatusContract.View
    public void getFaceVerifyTokenSuccess(RealNameVerifyBean realNameVerifyBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "97719339")) {
            ipChange.ipc$dispatch("97719339", new Object[]{this, realNameVerifyBean});
            return;
        }
        if (realNameVerifyBean != null && !TextUtils.isEmpty(realNameVerifyBean.getVerifyToken())) {
            C0529c.e().x(vf1.x().s());
            try {
                if (mu0.a() == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("contentlabel", "application 为null");
                    C0529c.e().A(hashMap, "RPSDK_Application", vf1.REALNAME_AUTHCENTER_PAGE);
                    return;
                }
                my1.a(mu0.a());
                if (RPSDK.getContext() == null) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("contentlabel", "RPSDK Context 为null");
                    C0529c.e().A(hashMap2, "RPSDK_Context", vf1.REALNAME_AUTHCENTER_PAGE);
                    return;
                }
                RPSDK.start(realNameVerifyBean.getVerifyToken(), this, new C1409a());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.mAuthStatus.setClickable(true);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1228128844") ? ((Integer) ipChange.ipc$dispatch("-1228128844", new Object[]{this})).intValue() : R$layout.activity_realname_authcenter_layout;
    }

    public void gotoAliMe() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-542950487")) {
            ipChange.ipc$dispatch("-542950487", new Object[]{this});
        } else {
            AliMeUtil.j(new C1410b());
        }
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1279287225")) {
            ipChange.ipc$dispatch("-1279287225", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "367662788")) {
            ipChange.ipc$dispatch("367662788", new Object[]{this});
        } else {
            ((RealNameAuthStatusPresenter) this.mPresenter).setVM(this, (RealNameAuthStatusContract.Model) this.mModel);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "365020505")) {
            ipChange.ipc$dispatch("365020505", new Object[]{this});
            return;
        }
        hideBaseLayout();
        init();
        initTitleStatusBar();
        setListener();
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1140959999")) {
            ipChange.ipc$dispatch("1140959999", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        int id = view.getId();
        if (id == R$id.realname_auth_status) {
            jumpByAuthStatus();
        } else if (id == R$id.realname_title_back) {
            finish();
        } else if (id == R$id.realname_right_icon) {
            C0529c.e().x(vf1.x().V());
            gotoAliMe();
        } else if (id == R$id.realname_error_right_btn) {
            retryAuth();
        } else if (id == R$id.realname_error_left_btn) {
            gotoAliMe();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle, @Nullable PersistableBundle persistableBundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1386697365")) {
            ipChange.ipc$dispatch("-1386697365", new Object[]{this, bundle, persistableBundle});
            return;
        }
        super.onCreate(bundle, persistableBundle);
        setDamaiUTKeyBuilder(vf1.x().N());
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-36736650")) {
            ipChange.ipc$dispatch("-36736650", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1989219807")) {
            ipChange.ipc$dispatch("1989219807", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1035847394")) {
            ipChange.ipc$dispatch("1035847394", new Object[]{this});
            return;
        }
        super.onResume();
        fetchAuthStatus();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1995040472")) {
            return (String) ipChange.ipc$dispatch("-1995040472", new Object[]{this});
        }
        return null;
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-859460089")) {
            ipChange.ipc$dispatch("-859460089", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2001141501")) {
            ipChange.ipc$dispatch("-2001141501", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1822195623")) {
            ipChange.ipc$dispatch("1822195623", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-108499486")) {
            ipChange.ipc$dispatch("-108499486", new Object[]{this});
        }
    }
}
