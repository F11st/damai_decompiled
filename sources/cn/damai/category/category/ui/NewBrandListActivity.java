package cn.damai.category.category.ui;

import cn.damai.common.user.c;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import cn.damai.uikit.view.SimpleTitleLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.kd;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class NewBrandListActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements SimpleTitleLayout.OnBtnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.uikit.view.SimpleTitleLayout.OnBtnClickListener
        public void onBackClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1080922414")) {
                ipChange.ipc$dispatch("-1080922414", new Object[]{this});
            } else {
                NewBrandListActivity.this.finish();
            }
        }

        @Override // cn.damai.uikit.view.SimpleTitleLayout.OnBtnClickListener
        public void onShareClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2049381838")) {
                ipChange.ipc$dispatch("2049381838", new Object[]{this});
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1357020295") ? ((Integer) ipChange.ipc$dispatch("-1357020295", new Object[]{this})).intValue() : R$layout.activity_new_brand_list;
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1222827444")) {
            ipChange.ipc$dispatch("1222827444", new Object[]{this});
            return;
        }
        super.initView();
        hideBaseLayout();
        setDamaiUTKeyBuilder(kd.k());
        c.e().K(this);
        SimpleTitleLayout simpleTitleLayout = (SimpleTitleLayout) findViewById(R$id.nbl_stl);
        simpleTitleLayout.setTitle(ErrControlViewInfo.TYPE_BRAND_IP);
        simpleTitleLayout.showShareBtn(false);
        simpleTitleLayout.enableImmersiveMode(this);
        simpleTitleLayout.switchMode(true);
        simpleTitleLayout.setListener(new a());
        getSupportFragmentManager().beginTransaction().add(R$id.nbl_fragment_container, new BrandFragment()).commitAllowingStateLoss();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1763926573")) {
            return (String) ipChange.ipc$dispatch("1763926573", new Object[]{this});
        }
        return null;
    }
}
