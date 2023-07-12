package cn.damai.user.star.second;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import cn.damai.common.user.a;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.user.star.view.ScrollAlphaListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.kg2;
import tb.l8;
import tb.xr;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class StarSecondActivity extends SimpleBaseActivity implements ScrollAlphaListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String FORCE_TAG = "StarSecondActivity_FORCE_TAG";
    private StarSecondFragment fragment;
    private View navBar;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1886321807")) {
                ipChange.ipc$dispatch("1886321807", new Object[]{this, view});
                return;
            }
            StarSecondActivity.this.setResult(-1);
            StarSecondActivity.this.onBackPressed();
        }
    }

    private void initFragment(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1447125541")) {
            ipChange.ipc$dispatch("1447125541", new Object[]{this, str, str2});
            return;
        }
        this.fragment = StarSecondFragment.newInstance(str, str2);
        getSupportFragmentManager().beginTransaction().replace(R$id.fragment_container, this.fragment).commit();
        this.fragment.setScrollAlphaListener(this);
    }

    private void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1122790097")) {
            ipChange.ipc$dispatch("1122790097", new Object[]{this});
            return;
        }
        View findViewById = findViewById(cn.damai.commonbusiness.R$id.status_bar_gap);
        if (Build.VERSION.SDK_INT >= 23) {
            if (findViewById != null) {
                findViewById.getLayoutParams().height = kg2.a(this);
                findViewById.setVisibility(0);
            }
            kg2.f(this, true, R$color.black);
            findViewById.setBackgroundColor(getColor(R$color.white));
            kg2.d(true, this);
            return;
        }
        findViewById.setVisibility(8);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-440646383") ? ((Integer) ipChange.ipc$dispatch("-440646383", new Object[]{this})).intValue() : R$layout.star_second_activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2101341181")) {
            ipChange.ipc$dispatch("-2101341181", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i != 10002 && i != 10001 && i != 100) {
            StarSecondFragment starSecondFragment = this.fragment;
            if (starSecondFragment != null) {
                starSecondFragment.onActivityResult(i, i2, intent);
                return;
            }
            return;
        }
        getSupportFragmentManager().beginTransaction().detach(this.fragment).commit();
        this.fragment = null;
        Intent intent2 = getIntent();
        if (intent2 != null) {
            setIntent(intent2);
            initFragment(intent2.getStringExtra(l8.KEY_ARTIST_ID), intent2.getStringExtra("type"));
        }
    }

    @Override // cn.damai.user.star.view.ScrollAlphaListener
    public void onAlphaChanged(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1909415868")) {
            ipChange.ipc$dispatch("-1909415868", new Object[]{this, Float.valueOf(f)});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1581603325")) {
            ipChange.ipc$dispatch("1581603325", new Object[]{this});
            return;
        }
        super.onBackPressed();
        xr.c(FORCE_TAG, 1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1259630690")) {
            ipChange.ipc$dispatch("-1259630690", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setContentView(R$layout.star_second_activity);
        setImmersionStyle();
        View findViewById = findViewById(R$id.nav_bar);
        this.navBar = findViewById;
        if (findViewById != null) {
            findViewById.setAlpha(1.0f);
        }
        Intent intent = getIntent();
        String str2 = "";
        if (intent != null) {
            setIntent(intent);
            str2 = intent.getStringExtra(l8.KEY_ARTIST_ID);
            str = intent.getStringExtra("type");
        } else {
            str = "";
        }
        initFragment(str2, str);
        findViewById(R$id.star_second_activity_goback).setOnClickListener(new a());
        setDamaiUTKeyBuilder(new a.b().i("content_extend"));
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2023979461")) {
            return (String) ipChange.ipc$dispatch("2023979461", new Object[]{this});
        }
        return null;
    }
}
