package cn.damai.dramachannel.ui;

import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.dramachannel.fragment.DramaCommingFragment;
import cn.damai.uikit.view.SimpleTitleLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.i40;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DramaCommingActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.dramachannel.ui.DramaCommingActivity$a */
    /* loaded from: classes5.dex */
    public class C1075a implements SimpleTitleLayout.OnBtnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1075a() {
        }

        @Override // cn.damai.uikit.view.SimpleTitleLayout.OnBtnClickListener
        public void onBackClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1487495357")) {
                ipChange.ipc$dispatch("1487495357", new Object[]{this});
            } else {
                DramaCommingActivity.this.finish();
            }
        }

        @Override // cn.damai.uikit.view.SimpleTitleLayout.OnBtnClickListener
        public void onShareClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "65954115")) {
                ipChange.ipc$dispatch("65954115", new Object[]{this});
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-375336442")) {
            ipChange.ipc$dispatch("-375336442", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1653470244") ? ((Integer) ipChange.ipc$dispatch("1653470244", new Object[]{this})).intValue() : R$layout.activity_drama_comming;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2144028713")) {
            ipChange.ipc$dispatch("-2144028713", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-669519564")) {
            ipChange.ipc$dispatch("-669519564", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-552524567")) {
            ipChange.ipc$dispatch("-552524567", new Object[]{this});
            return;
        }
        setDamaiUTKeyBuilder(i40.f().g());
        C0529c.e().K(this);
        hideBaseLayout();
        SimpleTitleLayout simpleTitleLayout = (SimpleTitleLayout) findViewById(R$id.theme_title_bar);
        simpleTitleLayout.enableImmersiveMode(this);
        simpleTitleLayout.setTitle("大戏将售");
        simpleTitleLayout.showShareBtn(false);
        simpleTitleLayout.switchMode(true);
        simpleTitleLayout.enableDivider(false);
        simpleTitleLayout.setListener(new C1075a());
        getSupportFragmentManager().beginTransaction().add(R$id.drama_activity_root, new DramaCommingFragment()).commitAllowingStateLoss();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1553976216")) {
            return (String) ipChange.ipc$dispatch("1553976216", new Object[]{this});
        }
        return null;
    }
}
