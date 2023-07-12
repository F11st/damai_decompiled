package cn.damai.livehouse;

import cn.damai.common.user.a;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.uikit.view.SimpleTitleLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.d23;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ComponentActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class a implements SimpleTitleLayout.OnBtnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.uikit.view.SimpleTitleLayout.OnBtnClickListener
        public void onBackClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1889749296")) {
                ipChange.ipc$dispatch("1889749296", new Object[]{this});
            } else {
                ComponentActivity.this.finish();
            }
        }

        @Override // cn.damai.uikit.view.SimpleTitleLayout.OnBtnClickListener
        public void onShareClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-349075664")) {
                ipChange.ipc$dispatch("-349075664", new Object[]{this});
            }
        }
    }

    private void setUpUt() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1188261885")) {
            ipChange.ipc$dispatch("-1188261885", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap();
        d23.a(hashMap);
        setDamaiUTKeyBuilder(new a.b().i("livehouse_all").j(hashMap));
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "213004467")) {
            ipChange.ipc$dispatch("213004467", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1220369751") ? ((Integer) ipChange.ipc$dispatch("1220369751", new Object[]{this})).intValue() : R$layout.activity_component;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1609725188")) {
            ipChange.ipc$dispatch("1609725188", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-267265625")) {
            ipChange.ipc$dispatch("-267265625", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "695107734")) {
            ipChange.ipc$dispatch("695107734", new Object[]{this});
            return;
        }
        setUpUt();
        c.e().K(this);
        removeHeadTitleView();
        SimpleTitleLayout simpleTitleLayout = (SimpleTitleLayout) findViewById(R$id.id_stl);
        if (getIntent() != null) {
            simpleTitleLayout.setTitle(getIntent().getExtras().getString("title", "全部演出"));
        }
        simpleTitleLayout.enableImmersiveMode(this);
        simpleTitleLayout.showShareBtn(false);
        simpleTitleLayout.switchMode(true);
        simpleTitleLayout.enableDivider(false);
        simpleTitleLayout.setListener(new a());
        getSupportFragmentManager().beginTransaction().add(R$id.ca_fragment_container, new ComponentFragment()).commitAllowingStateLoss();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "702128011")) {
            return (String) ipChange.ipc$dispatch("702128011", new Object[]{this});
        }
        return null;
    }
}
