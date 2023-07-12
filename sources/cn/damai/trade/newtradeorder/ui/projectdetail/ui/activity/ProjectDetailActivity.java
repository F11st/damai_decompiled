package cn.damai.trade.newtradeorder.ui.projectdetail.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.comment.util.SoftInputUtils;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.view.AttentionView;
import cn.damai.login.LoginManager;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.ProjectSwitchIdDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.contract.ProjectContract;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.model.ProjectModel;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.presenter.ProjectPresenter;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.fragment.ProjectBookingRegisterFragment;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment;
import cn.damai.trade.newtradeorder.ui.projectdetail.util.ProjectIntentExtraParser;
import com.alibaba.security.common.track.model.C3834a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cs;
import tb.ns2;
import tb.pc0;
import tb.pv1;
import tb.wh2;
import tb.xr;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectDetailActivity extends DamaiBaseActivity<ProjectPresenter, ProjectModel> implements ProjectContract.View, AttentionView.StateListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long MIN_NEW_PROJECT_ID = 100000000;
    private static final long MIN_PRODUCT_ID = 100000000000L;
    private FragmentManager fm;
    private boolean mAttachPending;
    private Fragment mFragment;
    private ProjectIntentExtraParser.ProjectDetailExtrasData mProjectDetailExtrasData;
    private FragmentTransaction transaction;
    private boolean mCanAttachData = true;
    int changedState = 0;

    private void addFragment(Fragment fragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-398999499")) {
            ipChange.ipc$dispatch("-398999499", new Object[]{this, fragment});
        } else if (isActivityFinsihed()) {
        } else {
            FragmentTransaction beginTransaction = this.fm.beginTransaction();
            this.transaction = beginTransaction;
            beginTransaction.replace(R$id.scheme_project_detail_flyt, fragment);
            this.transaction.commitAllowingStateLoss();
        }
    }

    private void addFragmentByProjectId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1954411984")) {
            ipChange.ipc$dispatch("-1954411984", new Object[]{this});
            return;
        }
        long j = this.mProjectDetailExtrasData.projectId;
        if (isNewProject(j)) {
            this.mFragment = ProjectDetailItemMainFragment.newInstance(this.mProjectDetailExtrasData);
        }
        if (isBookingRegisterProduct(j)) {
            this.mFragment = ProjectBookingRegisterFragment.newInstance(this.mProjectDetailExtrasData);
        }
        if (canAttachData()) {
            addFragment(this.mFragment);
        } else {
            this.mAttachPending = true;
        }
    }

    private boolean canAttachData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1023491283") ? ((Boolean) ipChange.ipc$dispatch("1023491283", new Object[]{this})).booleanValue() : this.mCanAttachData;
    }

    private void executeOldProjectItemId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1700612939")) {
            ipChange.ipc$dispatch("1700612939", new Object[]{this, Long.valueOf(j)});
            return;
        }
        startProgressDialog();
        ((ProjectPresenter) this.mPresenter).retrieveOldProjectItemId(String.valueOf(j));
    }

    private boolean isBookingRegisterProduct(long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-163695575") ? ((Boolean) ipChange.ipc$dispatch("-163695575", new Object[]{this, Long.valueOf(j)})).booleanValue() : j >= 100000000 && j <= MIN_PRODUCT_ID;
    }

    private void parseProjectIntentData() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-571865872")) {
            ipChange.ipc$dispatch("-571865872", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        ProjectIntentExtraParser.ProjectDetailExtrasData a = ProjectIntentExtraParser.a(intent);
        this.mProjectDetailExtrasData = a;
        if (a != null && a.projectId > 0) {
            if (new pc0().a(cs.a + cs.b, this.mProjectDetailExtrasData.projectId) && intent != null && !TextUtils.isEmpty(intent.getDataString())) {
                String dataString = intent.getDataString();
                if (dataString.startsWith("http")) {
                    Bundle bundle = new Bundle();
                    if (dataString.contains("?")) {
                        str = dataString + "&" + pc0.j;
                    } else {
                        str = dataString + "?" + pc0.j;
                    }
                    bundle.putString("url", str);
                    DMNav.from(this).withExtras(bundle).toUri(NavUri.b(C3834a.C3837c.d));
                    finish();
                    return;
                }
            }
            switchProjectFragment();
            return;
        }
        ToastUtil.a().j(this, "获取项目信息失败");
        finish();
    }

    private void setCanAttachData(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1879752075")) {
            ipChange.ipc$dispatch("-1879752075", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mCanAttachData = z;
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-826954300")) {
            ipChange.ipc$dispatch("-826954300", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1322042976")) {
            return ((Boolean) ipChange.ipc$dispatch("1322042976", new Object[]{this, motionEvent})).booleanValue();
        }
        if (motionEvent.getAction() == 0 && SoftInputUtils.b(this, motionEvent)) {
            SoftInputUtils.a(this);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public Fragment getCurrentFragment() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "478352549") ? (Fragment) ipChange.ipc$dispatch("478352549", new Object[]{this}) : this.fm.findFragmentById(R$id.scheme_project_detail_flyt);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "3291558") ? ((Integer) ipChange.ipc$dispatch("3291558", new Object[]{this})).intValue() : R$layout.trade_main_layout;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1759960427")) {
            ipChange.ipc$dispatch("-1759960427", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1648304586")) {
            ipChange.ipc$dispatch("-1648304586", new Object[]{this});
        } else {
            ((ProjectPresenter) this.mPresenter).setVM(this, (ProjectContract.Model) this.mModel);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-471556441")) {
            ipChange.ipc$dispatch("-471556441", new Object[]{this});
            return;
        }
        hideBaseLayout();
        this.fm = getSupportFragmentManager();
        parseProjectIntentData();
    }

    public boolean isNewProject(long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "508520399") ? ((Boolean) ipChange.ipc$dispatch("508520399", new Object[]{this, Long.valueOf(j)})).booleanValue() : j > MIN_PRODUCT_ID;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1700737842")) {
            ipChange.ipc$dispatch("-1700737842", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        ShareManager.E().r0(i, i2, intent);
        if (getCurrentFragment() == null || !(getCurrentFragment() instanceof ProjectDetailItemMainFragment)) {
            return;
        }
        ((ProjectDetailItemMainFragment) getCurrentFragment()).onSelfActivityResult(i, i2, intent);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        pv1 projectDataHolderManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1290764974")) {
            ipChange.ipc$dispatch("-1290764974", new Object[]{this});
            return;
        }
        if (this.changedState > 0) {
            Fragment fragment = this.mFragment;
            if ((fragment instanceof ProjectDetailItemMainFragment) && fragment != null && (projectDataHolderManager = ((ProjectDetailItemMainFragment) fragment).getProjectDataHolderManager()) != null && projectDataHolderManager.j() != null && projectDataHolderManager.j().brandOrArtists != null) {
                Bundle bundle = new Bundle();
                bundle.putString("brandId", projectDataHolderManager.j().brandOrArtists.id + "");
                bundle.putString("followState", this.changedState + "");
                xr.c("brand_state_changed", bundle);
            }
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "534231603")) {
            ipChange.ipc$dispatch("534231603", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        LoginManager.k().h();
        C0529c.e().K(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Fragment currentFragment;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1155534967")) {
            return ((Boolean) ipChange.ipc$dispatch("-1155534967", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        if (i == 4) {
            if (this.fm == null || (currentFragment = getCurrentFragment()) == null || !(currentFragment instanceof ProjectDetailItemMainFragment) || !((ProjectDetailItemMainFragment) currentFragment).handlerBack()) {
                return super.onKeyDown(i, keyEvent);
            }
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-517409852")) {
            ipChange.ipc$dispatch("-517409852", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1074327087")) {
            ipChange.ipc$dispatch("-1074327087", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2114382736")) {
            ipChange.ipc$dispatch("2114382736", new Object[]{this, str, str2, str3});
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1041386985")) {
            ipChange.ipc$dispatch("-1041386985", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-739462985")) {
            ipChange.ipc$dispatch("-739462985", new Object[]{this});
            return;
        }
        super.onPause();
        setCanAttachData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Fragment fragment;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "199270448")) {
            ipChange.ipc$dispatch("199270448", new Object[]{this});
            return;
        }
        super.onResume();
        setCanAttachData(true);
        if (this.mAttachPending && (fragment = this.mFragment) != null) {
            this.mAttachPending = false;
            addFragment(fragment);
        }
        ns2.a().c();
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.common.contract.ProjectContract.View
    public void onRetrieveOldProjectIdError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "466145954")) {
            ipChange.ipc$dispatch("466145954", new Object[]{this, str, str2});
            return;
        }
        stopProgressDialog();
        addFragmentByProjectId();
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.common.contract.ProjectContract.View
    public void onRetrieveOldProjectIdSuccess(ProjectSwitchIdDataBean.ProjectSwitchIdResultBean projectSwitchIdResultBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1792786955")) {
            ipChange.ipc$dispatch("1792786955", new Object[]{this, projectSwitchIdResultBean});
            return;
        }
        stopProgressDialog();
        if (projectSwitchIdResultBean != null) {
            long n = wh2.n(projectSwitchIdResultBean.result);
            if (n > 0) {
                this.mProjectDetailExtrasData.projectId = n;
            }
        }
        addFragmentByProjectId();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1171432826")) {
            ipChange.ipc$dispatch("-1171432826", new Object[]{this, bundle});
        }
    }

    @Override // cn.damai.commonbusiness.view.AttentionView.StateListener
    public void onStateChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1731638135")) {
            ipChange.ipc$dispatch("-1731638135", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.changedState = i - this.changedState;
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "273892762") ? (String) ipChange.ipc$dispatch("273892762", new Object[]{this}) : "";
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1419539833")) {
            ipChange.ipc$dispatch("1419539833", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "250318837")) {
            ipChange.ipc$dispatch("250318837", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2141856537")) {
            ipChange.ipc$dispatch("2141856537", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1122920916")) {
            ipChange.ipc$dispatch("1122920916", new Object[]{this});
        }
    }

    public void switchProjectFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2054585127")) {
            ipChange.ipc$dispatch("-2054585127", new Object[]{this});
        } else if (!canAttachData() || isActivityFinsihed()) {
        } else {
            long j = this.mProjectDetailExtrasData.projectId;
            if (isNewProject(j)) {
                addFragmentByProjectId();
                return;
            }
            if (j < 100000000) {
                ToastUtil.f("该项目已失效~");
                finish();
            }
            executeOldProjectItemId(j);
        }
    }
}
