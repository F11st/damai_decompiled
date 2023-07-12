package cn.damai.commonbusiness.base;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import cn.damai.commonbusiness.R$id;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import tb.kg2;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public abstract class SimpleBaseActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-869424222")) {
                ipChange.ipc$dispatch("-869424222", new Object[]{this, view});
            } else {
                SimpleBaseActivity.this.finish();
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1293646028")) {
            ipChange.ipc$dispatch("1293646028", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public int getInt(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "594114312")) {
            return ((Integer) ipChange.ipc$dispatch("594114312", new Object[]{this, str})).intValue();
        }
        if (getIntent() != null && getIntent().getExtras() != null) {
            Bundle extras = getIntent().getExtras();
            if (extras.containsKey(str)) {
                return extras.getInt(str);
            }
        }
        return 0;
    }

    public long getLong(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "808289266")) {
            return ((Long) ipChange.ipc$dispatch("808289266", new Object[]{this, str})).longValue();
        }
        if (getIntent() == null || getIntent().getExtras() == null) {
            return 0L;
        }
        Bundle extras = getIntent().getExtras();
        if (extras.containsKey(str)) {
            return extras.getLong(str);
        }
        return 0L;
    }

    public String getString(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-108926729")) {
            return (String) ipChange.ipc$dispatch("-108926729", new Object[]{this, str});
        }
        if (getIntent() == null || getIntent().getExtras() == null) {
            return "";
        }
        Bundle extras = getIntent().getExtras();
        return extras.containsKey(str) ? extras.getString(str) : "";
    }

    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1074941539")) {
            ipChange.ipc$dispatch("-1074941539", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1887555538")) {
            ipChange.ipc$dispatch("-1887555538", new Object[]{this});
        }
    }

    public void initTransStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "398895131")) {
            ipChange.ipc$dispatch("398895131", new Object[]{this});
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

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1523977809")) {
            ipChange.ipc$dispatch("-1523977809", new Object[]{this});
        } else {
            this.base_header_left.setOnClickListener(new a());
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "167609036")) {
            ipChange.ipc$dispatch("167609036", new Object[]{this});
        } else {
            stopProgressDialog();
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-498040375")) {
            ipChange.ipc$dispatch("-498040375", new Object[]{this});
        } else {
            startProgressDialog();
        }
    }

    public void setDarkStatusBarColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1985625388")) {
            ipChange.ipc$dispatch("1985625388", new Object[]{this});
        } else {
            getWindow().getDecorView().setSystemUiVisibility(9216);
        }
    }

    public void setImmersionsStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "104073117")) {
            ipChange.ipc$dispatch("104073117", new Object[]{this});
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
        initTransStatusBar();
        setDarkStatusBarColor();
    }

    public void setLightStatusBarColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1084124274")) {
            ipChange.ipc$dispatch("-1084124274", new Object[]{this});
        } else {
            getWindow().getDecorView().setSystemUiVisibility(1024);
        }
    }
}
