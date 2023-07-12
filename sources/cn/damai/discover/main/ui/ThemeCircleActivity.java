package cn.damai.discover.main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.commonbusiness.discover.bean.ThemeRelationQueryBean;
import cn.damai.commonbusiness.discover.request.ThemeRelationQueryRequest;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.wannasee.listener.OnBizListener;
import cn.damai.discover.main.bean.PublishStateBean;
import cn.damai.discover.main.ui.listener.ScrollTitleCircleAlphaListener;
import cn.damai.discover.main.ui.model.PublishModel;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.login.LoginManager;
import cn.damai.login.havana.ILoginListener;
import cn.damai.uikit.view.CircleSimpleTitleLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.d23;
import tb.lm2;
import tb.pb;
import tb.r92;
import tb.s90;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ThemeCircleActivity extends SimpleBaseActivity implements ScrollTitleCircleAlphaListener, ILoginListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private CircleFragment fragment;
    private LinearLayout mSubmitLayout;
    private CircleSimpleTitleLayout mTitleBar;
    private boolean isCanShowPublishUi = false;
    private lm2 mUt = new lm2();
    private PublishModel mPublishModel = new PublishModel();
    private String themeId = null;
    private boolean addCircleStatue = false;
    int alpha = 0;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class a implements CircleSimpleTitleLayout.OnBtnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.uikit.view.CircleSimpleTitleLayout.OnBtnClickListener
        public void onAddClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-375060868")) {
                ipChange.ipc$dispatch("-375060868", new Object[]{this});
            } else if (ThemeCircleActivity.this.fragment == null || ThemeCircleActivity.this.fragment.getTheme() == null) {
            } else {
                ThemeCircleActivity themeCircleActivity = ThemeCircleActivity.this;
                themeCircleActivity.followCircle(themeCircleActivity.addCircleStatue ? "0" : "1", ThemeCircleActivity.this.fragment.getTheme().id, "21");
            }
        }

        @Override // cn.damai.uikit.view.CircleSimpleTitleLayout.OnBtnClickListener
        public void onBackClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-806059290")) {
                ipChange.ipc$dispatch("-806059290", new Object[]{this});
            } else if (ThemeCircleActivity.this.fragment == null) {
            } else {
                ThemeCircleActivity.this.fragment.getActivity().finish();
            }
        }

        @Override // cn.damai.uikit.view.CircleSimpleTitleLayout.OnBtnClickListener
        public void onShareClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1980204090")) {
                ipChange.ipc$dispatch("1980204090", new Object[]{this});
            } else if (ThemeCircleActivity.this.fragment == null) {
            } else {
                ThemeCircleActivity.this.fragment.share();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class b implements OnBizListener<PublishStateBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.commonbusiness.wannasee.listener.OnBizListener
        /* renamed from: a */
        public void onBizSuccess(PublishStateBean publishStateBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1446882558")) {
                ipChange.ipc$dispatch("1446882558", new Object[]{this, publishStateBean});
            } else {
                ThemeCircleActivity.this.showPublishView(publishStateBean.isNeedShowPublishBtn());
            }
        }

        @Override // cn.damai.commonbusiness.wannasee.listener.OnBizListener
        public void onBizFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1559951944")) {
                ipChange.ipc$dispatch("1559951944", new Object[]{this, str, str2});
            } else {
                ThemeCircleActivity.this.showPublishView(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void followCircle(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1563562894")) {
            ipChange.ipc$dispatch("-1563562894", new Object[]{this, str, str2, str3});
        } else if (LoginManager.k().q()) {
            ThemeRelationQueryRequest themeRelationQueryRequest = new ThemeRelationQueryRequest();
            themeRelationQueryRequest.operateType = str;
            themeRelationQueryRequest.targetId = str2;
            themeRelationQueryRequest.targetType = str3;
            themeRelationQueryRequest.request(new DMMtopRequestListener<ThemeRelationQueryBean>(ThemeRelationQueryBean.class) { // from class: cn.damai.discover.main.ui.ThemeCircleActivity.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str4, String str5) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "238301434")) {
                        ipChange2.ipc$dispatch("238301434", new Object[]{this, str4, str5});
                    } else {
                        ToastUtil.i(str5);
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(ThemeRelationQueryBean themeRelationQueryBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "602478877")) {
                        ipChange2.ipc$dispatch("602478877", new Object[]{this, themeRelationQueryBean});
                        return;
                    }
                    if (!themeRelationQueryBean.hasJoin) {
                        if (ThemeCircleActivity.this.addCircleStatue != themeRelationQueryBean.hasJoin) {
                            ToastUtil.i("您已取消加入改圈子");
                        } else {
                            ToastUtil.i(themeRelationQueryBean.joinTotal);
                        }
                    } else {
                        ToastUtil.i("您已加入该圈子");
                    }
                    HashMap<String, String> f = d23.f();
                    f.put("type", ThemeCircleActivity.this.addCircleStatue ? "0" : "1");
                    f.put("quanziid", ThemeCircleActivity.this.fragment.themeId);
                    pb.j(ThemeCircleActivity.this.mUt.y(f));
                    boolean z = ThemeCircleActivity.this.addCircleStatue;
                    boolean z2 = themeRelationQueryBean.hasJoin;
                    if (z != z2) {
                        ThemeCircleActivity.this.addCircleStatue = z2;
                        ThemeCircleActivity.this.mTitleBar.joinBtnStyleView(ThemeCircleActivity.this.addCircleStatue);
                        ThemeCircleActivity.this.fragment.requestTetris(false);
                    }
                }
            });
        } else {
            LoginManager.k().x(this, new Intent(), 1000);
        }
    }

    private void initFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1190365589")) {
            ipChange.ipc$dispatch("1190365589", new Object[]{this});
            return;
        }
        int i = R$id.fragment_container;
        onResponseSuccess(findViewById(i));
        findViewById(i).setVisibility(0);
        this.fragment = CircleFragment.newInstance(this.themeId);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(i, this.fragment);
        beginTransaction.commitAllowingStateLoss();
        this.fragment.setScrollAlphaListener(this);
        publishView();
        loadPublish();
    }

    private void loadPublish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "807730156")) {
            ipChange.ipc$dispatch("807730156", new Object[]{this});
        } else if (isFinishing() || this.mPublishModel == null) {
        } else {
            showPublishView(false);
            this.mPublishModel.loadPublish(new b());
        }
    }

    private void publishView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1830276863")) {
            ipChange.ipc$dispatch("-1830276863", new Object[]{this});
        } else {
            this.mSubmitLayout = (LinearLayout) findViewById(R$id.circle_new_publish_ui);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPublishView(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1803635402")) {
            ipChange.ipc$dispatch("-1803635402", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isCanShowPublishUi = z;
        if (z) {
            this.mSubmitLayout.setVisibility(0);
            this.mSubmitLayout.setOnClickListener(this);
            return;
        }
        this.mSubmitLayout.setVisibility(8);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-815952755") ? ((Integer) ipChange.ipc$dispatch("-815952755", new Object[]{this})).intValue() : R$layout.theme_circle_activity_layout;
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1386730354")) {
            ipChange.ipc$dispatch("-1386730354", new Object[]{this, Integer.valueOf(i)});
        } else {
            initFragment();
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-32187129")) {
            ipChange.ipc$dispatch("-32187129", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i == 100 && i2 == -1 && intent != null && intent.getBooleanExtra("needRefresh", false)) {
            ToastUtil.i("发布成功，稍等一会儿展示出来哦~");
        }
        ShareManager.E().r0(i, i2, intent);
    }

    @Override // cn.damai.discover.main.ui.listener.ScrollTitleCircleAlphaListener
    public void onAlphaChanged(float f) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1364604480")) {
            ipChange.ipc$dispatch("-1364604480", new Object[]{this, Float.valueOf(f)});
            return;
        }
        if (f > 0.3d) {
            f = 1.0f;
        }
        CircleSimpleTitleLayout circleSimpleTitleLayout = this.mTitleBar;
        if (circleSimpleTitleLayout != null) {
            circleSimpleTitleLayout.setAlpha(f);
            if (f == 0.0f) {
                if (this.mTitleBar.getVisibility() != 8) {
                    this.mTitleBar.setVisibility(8);
                }
            } else if (this.mTitleBar.getVisibility() != 0) {
                this.mTitleBar.setVisibility(0);
                CircleFragment circleFragment = this.fragment;
                if (circleFragment == null || circleFragment.getTheme() == null) {
                    return;
                }
                if (this.fragment.getTheme().colorGroup != null && this.fragment.getTheme().colorGroup.colors != null && this.fragment.getTheme().colorGroup.colors.size() >= 2) {
                    this.mTitleBar.setColor(this.fragment.getTheme().colorGroup.colors.get(0), this.fragment.getTheme().colorGroup.colors.get(1));
                }
                boolean z2 = this.fragment.getTheme().hasJoin;
                this.addCircleStatue = z2;
                this.mTitleBar.joinBtnStyleView(z2);
                this.mTitleBar.setShareVisibility((this.fragment.getShare() == null || this.fragment.getShare().shareUrl == null) ? false : false);
                this.mTitleBar.setImg(this.fragment.getTheme().headImage);
                this.mTitleBar.setTitle(this.fragment.getThemeName());
            }
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1689432697")) {
            ipChange.ipc$dispatch("1689432697", new Object[]{this});
        } else {
            super.onBackPressed();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2106568454")) {
            ipChange.ipc$dispatch("2106568454", new Object[]{this, view});
        } else if (!r92.c() && view.getId() == R$id.circle_new_publish_ui) {
            pb.j(this.mUt.q());
            if (LoginManager.k().q()) {
                PublishStateBean stateBean = this.mPublishModel.getStateBean();
                if (stateBean == null || !stateBean.isNeedShowPublishBtn()) {
                    return;
                }
                stateBean.themeId = this.themeId;
                CircleFragment circleFragment = this.fragment;
                if (circleFragment != null) {
                    stateBean.themeName = circleFragment.getThemeName();
                }
                s90.l(this, stateBean, 100);
                return;
            }
            LoginManager.k().x(this, new Intent(), 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1801871130")) {
            ipChange.ipc$dispatch("1801871130", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        c.e().K(this);
        hideBaseLayout();
        if (getIntent() == null || getIntent().getExtras() == null) {
            return;
        }
        String stringExtra = getIntent().getStringExtra("themeId");
        this.themeId = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            ToastUtil.i("请求数据出错.");
            return;
        }
        this.mUt.F(this.themeId);
        this.mUt.G("圈子");
        setDamaiUTKeyBuilder(this.mUt.o());
        CircleSimpleTitleLayout circleSimpleTitleLayout = (CircleSimpleTitleLayout) findViewById(R$id.theme_circle_title_bar);
        this.mTitleBar = circleSimpleTitleLayout;
        circleSimpleTitleLayout.enableImmersiveMode(this);
        this.mTitleBar.setAlpha(this.alpha);
        this.mTitleBar.setVisibility(8);
        this.mTitleBar.setListener(new a());
        initFragment();
        LoginManager.k().c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "744737498")) {
            ipChange.ipc$dispatch("744737498", new Object[]{this});
            return;
        }
        super.onDestroy();
        PublishModel publishModel = this.mPublishModel;
        if (publishModel != null) {
            publishModel.destroy();
        }
        LoginManager.k().C(this);
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginCancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-599704719")) {
            ipChange.ipc$dispatch("-599704719", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginFail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1592797747")) {
            ipChange.ipc$dispatch("-1592797747", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "263042716")) {
            ipChange.ipc$dispatch("263042716", new Object[]{this});
            return;
        }
        CircleFragment circleFragment = this.fragment;
        if (circleFragment != null) {
            circleFragment.refreshByType(1);
        }
        showPublishView(this.isCanShowPublishUi);
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLogout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1346267180")) {
            ipChange.ipc$dispatch("1346267180", new Object[]{this});
        }
    }

    @Override // cn.damai.discover.main.ui.listener.ScrollTitleCircleAlphaListener
    public void onPublishChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-401505085")) {
            ipChange.ipc$dispatch("-401505085", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-716965823")) {
            return (String) ipChange.ipc$dispatch("-716965823", new Object[]{this});
        }
        return null;
    }
}
