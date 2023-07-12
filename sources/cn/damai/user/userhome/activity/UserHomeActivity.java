package cn.damai.user.userhome.activity;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.user.userhome.fragment.UserHomeFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.iv2;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UserHomeActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;

    private void replaceFragment(Fragment fragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "750872716")) {
            ipChange.ipc$dispatch("750872716", new Object[]{this, fragment});
            return;
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R$id.user_home_container, fragment);
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1271952528") ? ((Integer) ipChange.ipc$dispatch("-1271952528", new Object[]{this})).intValue() : R$layout.activity_user_home;
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2031374051")) {
            ipChange.ipc$dispatch("-2031374051", new Object[]{this});
            return;
        }
        hideBaseLayout();
        replaceFragment(new UserHomeFragment());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1625540611")) {
            ipChange.ipc$dispatch("-1625540611", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(new a.b().i(iv2.USER_HOME_PAGE));
        c.e().K(this);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-649024028")) {
            return (String) ipChange.ipc$dispatch("-649024028", new Object[]{this});
        }
        return null;
    }
}
