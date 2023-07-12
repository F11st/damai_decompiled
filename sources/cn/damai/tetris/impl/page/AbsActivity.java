package cn.damai.tetris.impl.page;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.tetris.page.AbsFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import tb.kg2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class AbsActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;

    private void initTranslucentStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "450239578")) {
            ipChange.ipc$dispatch("450239578", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "-39676147")) {
            ipChange.ipc$dispatch("-39676147", new Object[]{this});
        } else {
            getWindow().getDecorView().setSystemUiVisibility(9216);
        }
    }

    private void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "444938512")) {
            ipChange.ipc$dispatch("444938512", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.status_bar_gap);
        if (Build.VERSION.SDK_INT < 23) {
            if (findViewById != null) {
                findViewById.setVisibility(8);
                return;
            }
            return;
        }
        if (findViewById != null) {
            findViewById.getLayoutParams().height = kg2.a(this);
            findViewById.setVisibility(0);
        }
        initTranslucentStatusBar();
        setLightStatusBarFontColor();
    }

    private void setLightStatusBarFontColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1077268533")) {
            ipChange.ipc$dispatch("-1077268533", new Object[]{this});
        } else {
            getWindow().getDecorView().setSystemUiVisibility(1024);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1806304486")) {
            ipChange.ipc$dispatch("-1806304486", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public abstract AbsFragment getFragment();

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-627020144")) {
            return ((Integer) ipChange.ipc$dispatch("-627020144", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "175213291")) {
            ipChange.ipc$dispatch("175213291", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1787461472")) {
            ipChange.ipc$dispatch("-1787461472", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1019567619")) {
            ipChange.ipc$dispatch("-1019567619", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1700603107")) {
            ipChange.ipc$dispatch("-1700603107", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setContentView(R$layout.activity_tetris_default);
        hideBaseLayout();
        setImmersionStyle();
        AbsFragment fragment = getFragment();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R$id.content_page_container, fragment, "DemoActivity");
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-966420220")) {
            return (String) ipChange.ipc$dispatch("-966420220", new Object[]{this});
        }
        return null;
    }
}
