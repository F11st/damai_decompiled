package cn.damai.user.star;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.user.star.view.ScrollAlphaListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import tb.kg2;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class StarIndexActivity extends SimpleBaseActivity implements ScrollAlphaListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private StarIndexFragment fragment;
    private View navBar;
    int status = 0;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.star.StarIndexActivity$a */
    /* loaded from: classes17.dex */
    public class View$OnClickListenerC2702a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2702a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2137542322")) {
                ipChange.ipc$dispatch("-2137542322", new Object[]{this, view});
            } else {
                StarIndexFragment unused = StarIndexActivity.this.fragment;
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.star.StarIndexActivity$b */
    /* loaded from: classes17.dex */
    public class View$OnClickListenerC2703b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2703b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-26251953")) {
                ipChange.ipc$dispatch("-26251953", new Object[]{this, view});
            } else if (StarIndexActivity.this.fragment == null) {
            } else {
                StarIndexActivity.this.fragment.getActivity().finish();
            }
        }
    }

    private void initFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1942227888")) {
            ipChange.ipc$dispatch("-1942227888", new Object[]{this});
            return;
        }
        String string = getString("userId");
        int i = R$id.fragment_container;
        onResponseSuccess(findViewById(i));
        findViewById(i).setVisibility(0);
        this.fragment = StarIndexFragment.newInstance(string, "2", getInt("id"), null);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(i, this.fragment);
        beginTransaction.commitAllowingStateLoss();
        this.fragment.setScrollAlphaListener(this);
    }

    private void initTranslucentStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-319845448")) {
            ipChange.ipc$dispatch("-319845448", new Object[]{this});
            return;
        }
        Window window = getWindow();
        window.clearFlags(ConfigReporter.BIT_GETTER_IMP);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(1024);
        if (Build.VERSION.SDK_INT >= 21) {
            window.setStatusBarColor(0);
        }
    }

    private void setDarkStatusBarFontColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1857491823")) {
            ipChange.ipc$dispatch("1857491823", new Object[]{this});
        } else {
            getWindow().getDecorView().setSystemUiVisibility(9216);
        }
    }

    private void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "306526066")) {
            ipChange.ipc$dispatch("306526066", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.status_bar_gap);
        if (findViewById != null) {
            findViewById.getLayoutParams().height = kg2.a(this);
            findViewById.setVisibility(0);
        }
        initTranslucentStatusBar();
        setLightStatusBarFontColor();
        this.status = 0;
    }

    private void setLightStatusBarFontColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1900363689")) {
            ipChange.ipc$dispatch("1900363689", new Object[]{this});
        } else {
            getWindow().getDecorView().setSystemUiVisibility(1024);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1471193486")) {
            return ((Integer) ipChange.ipc$dispatch("-1471193486", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-224356535")) {
            ipChange.ipc$dispatch("-224356535", new Object[]{this, Integer.valueOf(i)});
        } else {
            initFragment();
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2119306882")) {
            ipChange.ipc$dispatch("2119306882", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        ShareManager.E().r0(i, i2, intent);
        StarIndexFragment starIndexFragment = this.fragment;
        if (starIndexFragment != null) {
            starIndexFragment.onActivityResult(i, i2, intent);
        }
    }

    @Override // cn.damai.user.star.view.ScrollAlphaListener
    public void onAlphaChanged(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "887496997")) {
            ipChange.ipc$dispatch("887496997", new Object[]{this, Float.valueOf(f)});
            return;
        }
        if (f > 0.3d) {
            f = 1.0f;
        }
        View view = this.navBar;
        if (view != null) {
            view.setAlpha(f);
            if (f >= 1.0f) {
                setDarkStatusBarFontColor();
                this.status = 1;
            } else if (f == 0.0f) {
                setLightStatusBarFontColor();
                this.status = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "411682559")) {
            ipChange.ipc$dispatch("411682559", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setContentView(R$layout.mine_starindex_activity);
        C0529c.e().K(this);
        hideBaseLayout();
        setImmersionStyle();
        if (getIntent() == null || getIntent().getExtras() == null) {
            return;
        }
        setDamaiUTKeyBuilder(new C0525a.C0527b().i(StarIndexFragment.Default_PAGE));
        View findViewById = findViewById(R$id.nav_bar);
        this.navBar = findViewById;
        findViewById.setAlpha(0.0f);
        findViewById(R$id.ll_share).setOnClickListener(new View$OnClickListenerC2702a());
        findViewById(R$id.brand_back).setOnClickListener(new View$OnClickListenerC2703b());
        initFragment();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "930747750")) {
            return (String) ipChange.ipc$dispatch("930747750", new Object[]{this});
        }
        return null;
    }
}
