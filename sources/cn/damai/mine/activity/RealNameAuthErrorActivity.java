package cn.damai.mine.activity;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.comment.util.SoftInputUtils;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.homepage.R$anim;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.im.AliMeUtil;
import cn.damai.mine.bean.RealNameVerifyScheduleBean;
import cn.damai.mine.contract.RealNameVerifyScheduleContract;
import cn.damai.mine.fragment.RealNameErrorDetailFragment;
import cn.damai.mine.presenter.RealNameVerifySchedulePresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ut.mini.UTAnalytics;
import java.util.HashMap;
import tb.kg2;
import tb.vf1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class RealNameAuthErrorActivity extends DamaiBaseActivity<RealNameVerifySchedulePresenter, RealNameVerifyScheduleContract.Model> implements RealNameVerifyScheduleContract.View {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int REALNAME_AUTH_ERROR_CONFICT = 1;
    public static final int REALNAME_AUTH_ERROR_FACE_VERIFING = 3;
    public static final String REALNAME_AUTH_ERROR_MSG = "realnameErrorMsg";
    public static final int REALNAME_AUTH_ERROR_NORMAL = 2;
    public static final String REALNAME_AUTH_ERROR_TAG = "realnameError";
    private int errorType;
    private TextView mAuthFailedMsg;
    private TextView mAuthStatus;
    private FrameLayout mContainer;
    private RealNameErrorDetailFragment mErrorDetailFragment;
    private ImageView mErrorImg;
    private LinearLayout mErrorReasonLayout;
    private b mHandler;
    private TextView mLeftBtn;
    private TextView mRightBtn;
    private TextView mShowErrorDetailBtn;
    private TextView mTitleMsg;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class a implements AliMeUtil.UserCodeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.mine.activity.RealNameAuthErrorActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0055a implements AliMeUtil.AliMeTokenListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C0055a() {
            }

            @Override // cn.damai.im.AliMeUtil.AliMeTokenListener
            public void onFailed() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1388939898")) {
                    ipChange.ipc$dispatch("1388939898", new Object[]{this});
                } else {
                    AliMeUtil.o();
                }
            }

            @Override // cn.damai.im.AliMeUtil.AliMeTokenListener
            public void onSuccess(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-75863494")) {
                    ipChange.ipc$dispatch("-75863494", new Object[]{this, str});
                } else {
                    AliMeUtil.b(RealNameAuthErrorActivity.this, AliMeUtil.c(AliMeUtil.FROM_REALNAME_AUTH, str));
                }
            }
        }

        a() {
        }

        @Override // cn.damai.im.AliMeUtil.UserCodeListener
        public void onFailed() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "488741037")) {
                ipChange.ipc$dispatch("488741037", new Object[]{this});
            } else {
                AliMeUtil.o();
            }
        }

        @Override // cn.damai.im.AliMeUtil.UserCodeListener
        public void onSuccess(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-39070265")) {
                ipChange.ipc$dispatch("-39070265", new Object[]{this, Long.valueOf(j)});
            } else {
                AliMeUtil.e(j, AliMeUtil.FROM_REALNAME_AUTH, new C0055a());
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class b extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1745422515")) {
                ipChange.ipc$dispatch("-1745422515", new Object[]{this, message});
                return;
            }
            super.dispatchMessage(message);
            if (RealNameAuthErrorActivity.this.mContainer == null || RealNameAuthErrorActivity.this.mContainer.getVisibility() != 0) {
                return;
            }
            RealNameAuthErrorActivity.this.mContainer.setVisibility(8);
            RealNameAuthErrorActivity.this.mErrorDetailFragment = null;
        }
    }

    private FragmentTransaction getFragmentTransaction() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "565367342")) {
            return (FragmentTransaction) ipChange.ipc$dispatch("565367342", new Object[]{this});
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        int i = R$anim.realname_slide_in_from_bottom;
        int i2 = R$anim.realname_slide_out_from_bottom;
        beginTransaction.setCustomAnimations(i, i2, i, i2);
        return beginTransaction;
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1864556684")) {
            ipChange.ipc$dispatch("1864556684", new Object[]{this});
            return;
        }
        this.mTitleMsg = (TextView) findViewById(R$id.mine_base_header_title);
        this.mAuthStatus = (TextView) findViewById(R$id.realname_error_status);
        this.mAuthFailedMsg = (TextView) findViewById(R$id.realname_error_msg);
        this.mLeftBtn = (TextView) findViewById(R$id.realname_error_left_btn);
        this.mRightBtn = (TextView) findViewById(R$id.realname_error_right_btn);
        this.mContainer = (FrameLayout) findViewById(R$id.popup_layer_container_flv);
        this.mErrorReasonLayout = (LinearLayout) findViewById(R$id.realname_error_reason_lly);
        this.mShowErrorDetailBtn = (TextView) findViewById(R$id.realname_error_reason_detail_btn);
        this.mErrorImg = (ImageView) findViewById(R$id.realname_error_img);
    }

    private void initExtras() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1152378345")) {
            ipChange.ipc$dispatch("1152378345", new Object[]{this});
        } else if (getIntent() != null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                finish();
                return;
            }
            this.errorType = extras.getInt(REALNAME_AUTH_ERROR_TAG, 2);
            String str = "";
            String string = extras.getString(REALNAME_AUTH_ERROR_MSG, "");
            int i = this.errorType;
            String str2 = "认证失败";
            if (i == 1) {
                this.mAuthFailedMsg.setText(string);
                this.mErrorReasonLayout.setVisibility(8);
                this.mErrorImg.setImageResource(R$drawable.realname_auth_failed_pic);
            } else {
                if (i == 3) {
                    ((RealNameVerifySchedulePresenter) this.mPresenter).fetchRealNameVerifySchedule();
                    this.mErrorReasonLayout.setVisibility(8);
                    this.mErrorImg.setImageResource(R$drawable.realname_error);
                    str2 = "审核中";
                    str = "确定";
                } else if (i == 2) {
                    this.mAuthFailedMsg.setText(string);
                    this.mErrorReasonLayout.setVisibility(0);
                    this.mErrorImg.setImageResource(R$drawable.realname_auth_failed_pic);
                } else {
                    str2 = "";
                }
                this.mRightBtn.setText(str);
                this.mTitleMsg.setText(str2);
                this.mAuthStatus.setText(str2);
            }
            str = "重新认证";
            this.mRightBtn.setText(str);
            this.mTitleMsg.setText(str2);
            this.mAuthStatus.setText(str2);
        } else {
            finish();
        }
    }

    private void initTitleStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "30196803")) {
            ipChange.ipc$dispatch("30196803", new Object[]{this});
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

    private void retryAuth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1370530110")) {
            ipChange.ipc$dispatch("1370530110", new Object[]{this});
            return;
        }
        int i = this.errorType;
        if (i != 1 && i != 2) {
            if (i == 3) {
                finish();
                return;
            }
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("retryAuth", true);
        DMNav.from(this).withExtras(bundle).toUri(NavUri.b("nameauth"));
        finish();
    }

    private void setListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1390823816")) {
            ipChange.ipc$dispatch("-1390823816", new Object[]{this});
            return;
        }
        this.mLeftBtn.setOnClickListener(this);
        this.mRightBtn.setOnClickListener(this);
        this.mShowErrorDetailBtn.setOnClickListener(this);
        this.mContainer.setOnClickListener(this);
        findViewById(R$id.realname_title_back).setOnClickListener(this);
    }

    private void showErrorDetailDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1230193142")) {
            ipChange.ipc$dispatch("-1230193142", new Object[]{this});
            return;
        }
        if (this.mHandler == null) {
            this.mHandler = new b();
        }
        SoftInputUtils.a(this);
        this.mErrorDetailFragment = new RealNameErrorDetailFragment();
        FragmentTransaction fragmentTransaction = getFragmentTransaction();
        fragmentTransaction.replace(R$id.popup_layer_container_flv, this.mErrorDetailFragment);
        fragmentTransaction.commitAllowingStateLoss();
        this.mContainer.setVisibility(0);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1472342852")) {
            ipChange.ipc$dispatch("1472342852", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void dismissErrorDetailFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "923717885")) {
            ipChange.ipc$dispatch("923717885", new Object[]{this});
            return;
        }
        RealNameErrorDetailFragment realNameErrorDetailFragment = this.mErrorDetailFragment;
        if (realNameErrorDetailFragment == null || realNameErrorDetailFragment.getActivity() == null) {
            return;
        }
        RealNameErrorDetailFragment realNameErrorDetailFragment2 = this.mErrorDetailFragment;
        if (realNameErrorDetailFragment2 != null && !realNameErrorDetailFragment2.getActivity().isFinishing()) {
            FragmentTransaction fragmentTransaction = getFragmentTransaction();
            int i = R$anim.realname_slide_in_from_bottom;
            int i2 = R$anim.realname_slide_out_from_bottom;
            fragmentTransaction.setCustomAnimations(i, i2, i, i2);
            fragmentTransaction.remove(this.mErrorDetailFragment);
            fragmentTransaction.commitAllowingStateLoss();
        }
        this.mHandler.sendEmptyMessageDelayed(200, 300L);
    }

    @Override // cn.damai.mine.contract.RealNameVerifyScheduleContract.View
    public void fetchRealNameVerifyScheduleFailed(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1030772878")) {
            ipChange.ipc$dispatch("-1030772878", new Object[]{this, str, str2});
        } else {
            this.mAuthFailedMsg.setText(getString(R$string.realname_verifySchedule_init));
        }
    }

    @Override // cn.damai.mine.contract.RealNameVerifyScheduleContract.View
    public void fetchRealNameVerifyScheduleSuccess(RealNameVerifyScheduleBean realNameVerifyScheduleBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1431182418")) {
            ipChange.ipc$dispatch("-1431182418", new Object[]{this, realNameVerifyScheduleBean});
        } else if (realNameVerifyScheduleBean != null && !TextUtils.isEmpty(realNameVerifyScheduleBean.getExpectFinishTimeMsg())) {
            this.mAuthFailedMsg.setText(realNameVerifyScheduleBean.getExpectFinishTimeMsg());
        } else {
            this.mAuthFailedMsg.setText(getString(R$string.realname_verifySchedule_init));
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1034767398") ? ((Integer) ipChange.ipc$dispatch("1034767398", new Object[]{this})).intValue() : R$layout.realname_autherror_layout;
    }

    public void gotoAliMe() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "603537051")) {
            ipChange.ipc$dispatch("603537051", new Object[]{this});
        } else {
            AliMeUtil.j(new a());
        }
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "151019541")) {
            ipChange.ipc$dispatch("151019541", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1757499574")) {
            ipChange.ipc$dispatch("1757499574", new Object[]{this});
        } else {
            ((RealNameVerifySchedulePresenter) this.mPresenter).setVM(this, (RealNameVerifyScheduleContract.Model) this.mModel);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1510382631")) {
            ipChange.ipc$dispatch("1510382631", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "1813490253")) {
            ipChange.ipc$dispatch("1813490253", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        int id = view.getId();
        if (id == R$id.realname_error_left_btn) {
            gotoAliMe();
        } else if (id == R$id.realname_error_right_btn) {
            retryAuth();
        } else if (id == R$id.realname_title_back) {
            finish();
        } else if (id == R$id.realname_error_reason_detail_btn) {
            showErrorDetailDialog();
        } else if (id == R$id.popup_layer_container_flv) {
            dismissErrorDetailFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1306381491")) {
            ipChange.ipc$dispatch("1306381491", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        initExtras();
        int i = this.errorType;
        if (i == 3) {
            setDamaiUTKeyBuilder(vf1.x().a0());
        } else if (i == 2) {
            HashMap hashMap = new HashMap();
            hashMap.put(vf1.REALNAME_FAILURE_REASON_PAGE, "0");
            setDamaiUTKeyBuilder(vf1.x().Q());
            UTAnalytics.getInstance().getDefaultTracker().updatePageProperties(this, hashMap);
        } else if (i == 1) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put(vf1.REALNAME_FAILURE_REASON_PAGE, "1");
            setDamaiUTKeyBuilder(vf1.x().Q());
            UTAnalytics.getInstance().getDefaultTracker().updatePageProperties(this, hashMap2);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1877877257")) {
            return ((Boolean) ipChange.ipc$dispatch("1877877257", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        if (i == 4) {
            if (getSupportFragmentManager() != null && this.mErrorDetailFragment != null) {
                dismissErrorDetailFragment();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1393570116")) {
            ipChange.ipc$dispatch("1393570116", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-42851247")) {
            ipChange.ipc$dispatch("-42851247", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-172230630")) {
            return (String) ipChange.ipc$dispatch("-172230630", new Object[]{this});
        }
        return null;
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "530376697")) {
            ipChange.ipc$dispatch("530376697", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-828087691")) {
            ipChange.ipc$dispatch("-828087691", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1148556697")) {
            ipChange.ipc$dispatch("1148556697", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2140570540")) {
            ipChange.ipc$dispatch("-2140570540", new Object[]{this});
        }
    }
}
