package cn.damai.category.discountticket.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.category.discountticket.bean.biz.DtParams;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.kg2;
import tb.mv2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class DiscountTicketActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String EXTRA = "EXTRA_2";
    private DtParams mParams;

    public static void open(Activity activity, @NonNull DtParams dtParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1064979790")) {
            ipChange.ipc$dispatch("-1064979790", new Object[]{activity, dtParams});
        } else if (activity != null) {
            Intent intent = new Intent(activity, DiscountTicketActivity.class);
            intent.putExtra(EXTRA, dtParams);
            activity.startActivity(intent);
        }
    }

    protected void adjustStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1026468856")) {
            ipChange.ipc$dispatch("1026468856", new Object[]{this});
            return;
        }
        removeHeadTitleView();
        if (Build.VERSION.SDK_INT >= 23) {
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
            return;
        }
        kg2.f(this, false, R$color.black);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1092017528")) {
            ipChange.ipc$dispatch("-1092017528", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1684940190") ? ((Integer) ipChange.ipc$dispatch("-1684940190", new Object[]{this})).intValue() : R$layout.activity_discount_container;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1739430233")) {
            ipChange.ipc$dispatch("1739430233", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-541376526")) {
            ipChange.ipc$dispatch("-541376526", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1638602603")) {
            ipChange.ipc$dispatch("1638602603", new Object[]{this});
            return;
        }
        adjustStatusBar();
        getSupportFragmentManager().beginTransaction().add(R$id.fg_root, DiscountTicketFragment.instance(this.mParams)).commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2126255250")) {
            ipChange.ipc$dispatch("2126255250", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        ShareManager.E().r0(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2068421905")) {
            ipChange.ipc$dispatch("-2068421905", new Object[]{this, bundle});
            return;
        }
        DtParams dtParams = (DtParams) getIntent().getParcelableExtra(EXTRA);
        this.mParams = dtParams;
        if (dtParams == null) {
            this.mParams = new DtParams(6);
        }
        super.onCreate(bundle);
        int i = this.mParams.type;
        if (i == 6) {
            setDamaiUTKeyBuilder(mv2.i());
            C0529c.e().K(this);
        } else if (i == 7) {
            setDamaiUTKeyBuilder(mv2.o());
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-117641898")) {
            return (String) ipChange.ipc$dispatch("-117641898", new Object[]{this});
        }
        return null;
    }
}
