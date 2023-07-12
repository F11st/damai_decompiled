package cn.damai.category.category.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.commonbusiness.pageut.C0726a;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.view.SimpleTitleLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class NewStarListActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private StarBaseFragment mStarBaseFragment;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.category.ui.NewStarListActivity$a */
    /* loaded from: classes.dex */
    public class C0338a implements SimpleTitleLayout.OnBtnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0338a() {
        }

        @Override // cn.damai.uikit.view.SimpleTitleLayout.OnBtnClickListener
        public void onBackClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "250297087")) {
                ipChange.ipc$dispatch("250297087", new Object[]{this});
            } else {
                NewStarListActivity.this.finish();
            }
        }

        @Override // cn.damai.uikit.view.SimpleTitleLayout.OnBtnClickListener
        public void onShareClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "367513409")) {
                ipChange.ipc$dispatch("367513409", new Object[]{this});
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1084585702") ? ((Integer) ipChange.ipc$dispatch("1084585702", new Object[]{this})).intValue() : R$layout.activity_new_star_list;
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1942197913")) {
            ipChange.ipc$dispatch("-1942197913", new Object[]{this});
            return;
        }
        super.initView();
        hideBaseLayout();
        C0529c.e().K(this);
        SimpleTitleLayout simpleTitleLayout = (SimpleTitleLayout) findViewById(R$id.nsl_stl);
        simpleTitleLayout.setTitle("大咖");
        simpleTitleLayout.showShareBtn(false);
        simpleTitleLayout.enableImmersiveMode(this);
        simpleTitleLayout.switchMode(true);
        simpleTitleLayout.setListener(new C0338a());
        this.mStarBaseFragment = new StarBaseFragment();
        getSupportFragmentManager().beginTransaction().add(R$id.nsl_fragment_container, this.mStarBaseFragment).commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1760172146")) {
            ipChange.ipc$dispatch("-1760172146", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        StarBaseFragment starBaseFragment = this.mStarBaseFragment;
        if (starBaseFragment != null) {
            starBaseFragment.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1096255629")) {
            ipChange.ipc$dispatch("-1096255629", new Object[]{this, bundle});
            return;
        }
        C0726a.i(this);
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1260681075")) {
            ipChange.ipc$dispatch("1260681075", new Object[]{this});
            return;
        }
        super.onDestroy();
        C0726a.j(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1341092361")) {
            ipChange.ipc$dispatch("-1341092361", new Object[]{this});
            return;
        }
        super.onPause();
        C0726a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1271371024")) {
            ipChange.ipc$dispatch("-1271371024", new Object[]{this});
            return;
        }
        super.onResume();
        C0726a.b(this);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-894283046")) {
            return (String) ipChange.ipc$dispatch("-894283046", new Object[]{this});
        }
        return null;
    }
}
