package cn.damai.ticklet.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.common.DamaiConstants;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.tab.DamaiTabbarManager;
import cn.damai.commonbusiness.tab.TabItem;
import cn.damai.commonbusiness.tab.TabbarLayout;
import cn.damai.h5container.WebViewFragment;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.ui.fragment.TickletListFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cs;
import tb.hn2;
import tb.oc0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletListActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private WebViewFragment downH5Fragment;
    private FragmentManager fm;
    private Fragment fragment;
    private DamaiTabbarManager mDMTabBarManager;
    private FragmentTransaction transaction;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.ticklet.ui.activity.TickletListActivity$a */
    /* loaded from: classes7.dex */
    public class C2031a implements WebViewFragment.LoadListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2031a() {
        }

        @Override // cn.damai.h5container.WebViewFragment.LoadListener
        public void onLoadFinish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-642345436")) {
                ipChange.ipc$dispatch("-642345436", new Object[]{this});
            } else {
                TickletListActivity.this.stopProgressDialog();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.ticklet.ui.activity.TickletListActivity$b */
    /* loaded from: classes7.dex */
    public class C2032b implements TabbarLayout.TabBarListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2032b(TickletListActivity tickletListActivity) {
        }

        @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
        public void onTabClicked(TabItem tabItem) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1536431344")) {
                ipChange.ipc$dispatch("1536431344", new Object[]{this, tabItem});
            }
        }

        @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
        public void onTabLongClicked(TabItem tabItem) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1796813356")) {
                ipChange.ipc$dispatch("-1796813356", new Object[]{this, tabItem});
            }
        }

        @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
        public void onTabReselected(TabItem tabItem) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1653697043")) {
                ipChange.ipc$dispatch("1653697043", new Object[]{this, tabItem});
            }
        }

        @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
        public void onTabSelected(TabItem tabItem) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "991231328")) {
                ipChange.ipc$dispatch("991231328", new Object[]{this, tabItem});
            }
        }
    }

    private void gotoHomePage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-334739586")) {
            ipChange.ipc$dispatch("-334739586", new Object[]{this});
            return;
        }
        WebViewFragment webViewFragment = this.downH5Fragment;
        if (webViewFragment == null || !webViewFragment.backPressed()) {
            DMNav.from(this).setTransition(0, 0).toUri(NavUri.b(cs.n));
            finish();
        }
    }

    private void initTabBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1156188671")) {
            ipChange.ipc$dispatch("-1156188671", new Object[]{this});
            return;
        }
        DamaiTabbarManager damaiTabbarManager = new DamaiTabbarManager(this, (TabbarLayout) findViewById(R$id.ticklet_tabbar_container), new C2032b(this));
        this.mDMTabBarManager = damaiTabbarManager;
        damaiTabbarManager.j(DamaiConstants.TAB_MEMBER);
    }

    private void replaceFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "15112535")) {
            ipChange.ipc$dispatch("15112535", new Object[]{this});
            return;
        }
        String c = oc0.c();
        if (!TextUtils.isEmpty(c)) {
            Bundle bundle = new Bundle();
            bundle.putString("url", c);
            WebViewFragment webViewFragment = new WebViewFragment();
            this.downH5Fragment = webViewFragment;
            webViewFragment.setArguments(bundle);
            this.downH5Fragment.setListener(new C2031a());
            getSupportFragmentManager().beginTransaction().replace(R$id.ticklet_list_main_container, this.downH5Fragment).commitAllowingStateLoss();
            return;
        }
        Intent intent = getIntent();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.fm = supportFragmentManager;
        this.transaction = supportFragmentManager.beginTransaction();
        if (intent != null) {
            this.fragment = TickletListFragment.newInstance(intent.getAction());
        } else {
            this.fragment = TickletListFragment.newInstance("normal");
        }
        this.transaction.replace(R$id.ticklet_list_main_container, this.fragment);
        this.transaction.commitAllowingStateLoss();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1959957719")) {
            ipChange.ipc$dispatch("1959957719", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public Fragment getCurrentFragment() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-583361550") ? (Fragment) ipChange.ipc$dispatch("-583361550", new Object[]{this}) : this.fm.findFragmentById(R$id.ticklet_list_main_container);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-823135565") ? ((Integer) ipChange.ipc$dispatch("-823135565", new Object[]{this})).intValue() : R$layout.ticklet_tickletlist_main_layout;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1609397464")) {
            ipChange.ipc$dispatch("-1609397464", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1275820029")) {
            ipChange.ipc$dispatch("-1275820029", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1992865606")) {
            ipChange.ipc$dispatch("-1992865606", new Object[]{this});
            return;
        }
        hn2.a();
        hideBaseLayout();
        initTabBar();
        replaceFragment();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-52481503")) {
            ipChange.ipc$dispatch("-52481503", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        WebViewFragment webViewFragment = this.downH5Fragment;
        if (webViewFragment != null) {
            webViewFragment.onActivityResult(i, i2, intent);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1043630048")) {
            ipChange.ipc$dispatch("-1043630048", new Object[]{this, view});
        } else {
            super.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1365001920")) {
            ipChange.ipc$dispatch("-1365001920", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        C0529c.e().K(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-310017408")) {
            ipChange.ipc$dispatch("-310017408", new Object[]{this});
            return;
        }
        super.onDestroy();
        DamaiTabbarManager damaiTabbarManager = this.mDMTabBarManager;
        if (damaiTabbarManager != null) {
            damaiTabbarManager.p();
        }
        this.downH5Fragment = null;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-899567402")) {
            return ((Boolean) ipChange.ipc$dispatch("-899567402", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        if (i == 4) {
            gotoHomePage();
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-366846889")) {
            ipChange.ipc$dispatch("-366846889", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1900754210")) {
            ipChange.ipc$dispatch("-1900754210", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1298131803")) {
            ipChange.ipc$dispatch("1298131803", new Object[]{this, intent});
            return;
        }
        super.onNewIntent(intent);
        DamaiTabbarManager damaiTabbarManager = this.mDMTabBarManager;
        if (damaiTabbarManager != null) {
            damaiTabbarManager.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1322038717")) {
            ipChange.ipc$dispatch("-1322038717", new Object[]{this});
        } else {
            super.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-431922855")) {
            ipChange.ipc$dispatch("-431922855", new Object[]{this, bundle});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-264395801")) {
            return (String) ipChange.ipc$dispatch("-264395801", new Object[]{this});
        }
        return null;
    }
}
