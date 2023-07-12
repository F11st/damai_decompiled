package cn.damai.commonbusiness.scriptmurder.scriptdetail;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import com.alibaba.pictures.bricks.fragment.ScriptDetailFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.kg2;
import tb.t60;
import tb.wt2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class ScriptDetailActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private ScriptDetailFragment mFragment;

    private final void initTranslucentStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1716188281")) {
            ipChange.ipc$dispatch("-1716188281", new Object[]{this});
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

    private final void setLightStatusBarFontColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "44697528")) {
            ipChange.ipc$dispatch("44697528", new Object[]{this});
        } else {
            getWindow().getDecorView().setSystemUiVisibility(1024);
        }
    }

    public final void addFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "347203546")) {
            ipChange.ipc$dispatch("347203546", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        String stringExtra = intent != null ? intent.getStringExtra("scriptId") : null;
        Intent intent2 = getIntent();
        String stringExtra2 = intent2 != null ? intent2.getStringExtra("storeId") : null;
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        int i = R$id.container;
        ScriptDetailFragment scriptDetailFragment = new ScriptDetailFragment();
        this.mFragment = scriptDetailFragment;
        Bundle bundle = new Bundle();
        if (stringExtra != null) {
            bundle.putString("scriptId", stringExtra);
        }
        if (stringExtra2 != null) {
            bundle.putString("storeId", stringExtra2);
        }
        scriptDetailFragment.setArguments(bundle);
        wt2 wt2Var = wt2.INSTANCE;
        beginTransaction.add(i, scriptDetailFragment);
        beginTransaction.commit();
    }

    public final void addUtPage() {
        String stringExtra;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1994087644")) {
            ipChange.ipc$dispatch("1994087644", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap();
        Intent intent = getIntent();
        if (intent != null && (stringExtra = intent.getStringExtra("scriptId")) != null) {
            hashMap.put("scriptkillid", stringExtra);
        }
        setDamaiUTKeyBuilder(new a.b().i("scriptkill").a(z20.d()).j(hashMap));
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-232039869") ? ((Integer) ipChange.ipc$dispatch("-232039869", new Object[]{this})).intValue() : R$layout.activity_scriptkill_layout_root;
    }

    @Nullable
    public final ScriptDetailFragment getMFragment() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1045428958") ? (ScriptDetailFragment) ipChange.ipc$dispatch("-1045428958", new Object[]{this}) : this.mFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        ScriptDetailFragment scriptDetailFragment;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "924506257")) {
            ipChange.ipc$dispatch("924506257", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i != 26504) {
                if (i == 26505 && (scriptDetailFragment = this.mFragment) != null && scriptDetailFragment.isAdded() && scriptDetailFragment.isFragmentVisible()) {
                    scriptDetailFragment.autoRefresh();
                    return;
                }
                return;
            }
            ScriptDetailFragment scriptDetailFragment2 = this.mFragment;
            if (scriptDetailFragment2 != null && scriptDetailFragment2.isAdded() && scriptDetailFragment2.isFragmentVisible()) {
                scriptDetailFragment2.autoRefresh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1279393584")) {
            ipChange.ipc$dispatch("-1279393584", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setContentView(getLayoutId());
        setImmersionStyle();
        addFragment();
        addUtPage();
        c.e().K(this);
    }

    public final void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "938431107")) {
            ipChange.ipc$dispatch("938431107", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.status_bar_gap);
        if (findViewById != null) {
            findViewById.getLayoutParams().height = kg2.a(this);
            findViewById.setVisibility(0);
        }
        View findViewById2 = findViewById(R$id.nav_bar);
        ViewGroup.LayoutParams layoutParams = findViewById2 != null ? findViewById2.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.height = findViewById.getLayoutParams().height + t60.a(this, 43.0f);
        }
        initTranslucentStatusBar();
        setLightStatusBarFontColor();
    }

    public final void setMFragment(@Nullable ScriptDetailFragment scriptDetailFragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2024764918")) {
            ipChange.ipc$dispatch("2024764918", new Object[]{this, scriptDetailFragment});
        } else {
            this.mFragment = scriptDetailFragment;
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    @NotNull
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "593792887") ? (String) ipChange.ipc$dispatch("593792887", new Object[]{this}) : "";
    }
}
