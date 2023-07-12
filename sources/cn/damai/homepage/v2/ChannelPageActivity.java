package cn.damai.homepage.v2;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.common.AppConfig;
import cn.damai.common.app.base.AbstractC0470a;
import cn.damai.common.app.base.BaseModel;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.pageut.C0726a;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.bean.TabExtra;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.cb1;
import tb.k50;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class ChannelPageActivity extends DamaiBaseActivity<AbstractC0470a<Object, Object>, BaseModel> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C1251a Companion = new C1251a(null);
    private static final int LOGIN_RESULT = 1008;
    @Nullable
    private ChannelPageTabFragment mChannelTabFragment;
    @Nullable
    private String mCurrentCity;
    @Nullable
    private TabExtra mTabExtra;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.v2.ChannelPageActivity$a */
    /* loaded from: classes14.dex */
    public static final class C1251a {
        private C1251a() {
        }

        public /* synthetic */ C1251a(k50 k50Var) {
            this();
        }
    }

    private final void addFragment(Fragment fragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1155981608")) {
            ipChange.ipc$dispatch("1155981608", new Object[]{this, fragment});
        } else if (fragment == null) {
        } else {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            b41.h(supportFragmentManager, "supportFragmentManager");
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            b41.h(beginTransaction, "fm.beginTransaction()");
            beginTransaction.replace(R$id.channel_fragment_container, fragment);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    private final void initBundle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1980188311")) {
            ipChange.ipc$dispatch("1980188311", new Object[]{this});
        } else if (getIntent() != null) {
            this.mTabExtra = TabExtra.fromIntent(getIntent());
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-491577167")) {
            ipChange.ipc$dispatch("-491577167", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "315221657") ? ((Integer) ipChange.ipc$dispatch("315221657", new Object[]{this})).intValue() : R$layout.channel_page_activity_layout;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-680061950")) {
            ipChange.ipc$dispatch("-680061950", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1763777129")) {
            ipChange.ipc$dispatch("1763777129", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1034309268")) {
            ipChange.ipc$dispatch("1034309268", new Object[]{this});
        } else {
            hideBaseLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-690675418")) {
            ipChange.ipc$dispatch("-690675418", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        C0726a.i(this);
        C0529c.e().K(this);
        initBundle();
        Bundle bundle2 = new Bundle();
        TabExtra tabExtra = this.mTabExtra;
        if (tabExtra != null) {
            b41.f(tabExtra);
            if (tabExtra.isValidExtra()) {
                bundle2.putParcelable("extra_key", this.mTabExtra);
            }
        }
        ChannelPageTabFragment channelPageTabFragment = new ChannelPageTabFragment();
        this.mChannelTabFragment = channelPageTabFragment;
        channelPageTabFragment.setArguments(bundle2);
        addFragment(this.mChannelTabFragment);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-956876826")) {
            ipChange.ipc$dispatch("-956876826", new Object[]{this});
            return;
        }
        super.onDestroy();
        C0726a.j(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(@Nullable Intent intent) {
        ChannelPageTabFragment channelPageTabFragment;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1924533569")) {
            ipChange.ipc$dispatch("1924533569", new Object[]{this, intent});
            return;
        }
        super.onNewIntent(intent);
        setIntent(intent);
        if (intent != null) {
            TabExtra fromIntent = TabExtra.fromIntent(intent);
            this.mTabExtra = fromIntent;
            b41.f(fromIntent);
            if (fromIntent.isValidExtra() && (channelPageTabFragment = this.mChannelTabFragment) != null) {
                channelPageTabFragment.setSelectTab(this.mTabExtra);
            }
            if (AppConfig.v()) {
                cb1.c("IntentTest", "onNewIntent tabExtra :" + m61.e(this.mTabExtra));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1248775978")) {
            ipChange.ipc$dispatch("1248775978", new Object[]{this});
            return;
        }
        super.onPause();
        C0726a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1705136157")) {
            ipChange.ipc$dispatch("1705136157", new Object[]{this});
            return;
        }
        super.onResume();
        C0726a.b(this);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    @Nullable
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "89378125")) {
            return (String) ipChange.ipc$dispatch("89378125", new Object[]{this});
        }
        return null;
    }
}
