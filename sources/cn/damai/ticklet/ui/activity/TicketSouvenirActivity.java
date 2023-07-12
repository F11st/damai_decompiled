package cn.damai.ticklet.ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.bean.TicketSouvenirParams;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import cn.damai.ticklet.ui.fragment.TicketSouvenirFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.un2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TicketSouvenirActivity extends TickletBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String EXTRAS = "EXTRAS";
    private TicketSouvenirParams mParams;
    private TicketSouvenirFragment mSouvenirFragment;

    public static void invoke(Activity activity, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1307619856")) {
            ipChange.ipc$dispatch("-1307619856", new Object[]{activity, str, str2, str3});
        } else if (activity == null || TextUtils.isEmpty(str)) {
        } else {
            Intent intent = new Intent(activity, TicketSouvenirActivity.class);
            intent.putExtra(TicketDetailExtFragment.PERFORM_ID, str);
            intent.putExtra("venueName", str2);
            intent.putExtra(TicketDetailExtFragment.PRODUCT_SYSTEM_ID, str3);
            activity.startActivity(intent);
        }
    }

    private void obtainExtras(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2065764292")) {
            ipChange.ipc$dispatch("2065764292", new Object[]{this, bundle});
        } else if (getIntent() == null) {
        } else {
            TicketSouvenirParams ticketSouvenirParams = new TicketSouvenirParams();
            this.mParams = ticketSouvenirParams;
            ticketSouvenirParams.performId = getIntent().getStringExtra(TicketDetailExtFragment.PERFORM_ID);
            this.mParams.venueName = getIntent().getStringExtra("venueName");
            this.mParams.productSystemId = getIntent().getStringExtra(TicketDetailExtFragment.PRODUCT_SYSTEM_ID);
        }
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1700727776")) {
            ipChange.ipc$dispatch("-1700727776", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 10003) {
            finish();
        }
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-353146422") ? ((Integer) ipChange.ipc$dispatch("-353146422", new Object[]{this})).intValue() : R$layout.activity_ticket_souvenir;
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "75364081")) {
            ipChange.ipc$dispatch("75364081", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-587819686")) {
            ipChange.ipc$dispatch("-587819686", new Object[]{this});
        }
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-642121469")) {
            ipChange.ipc$dispatch("-642121469", new Object[]{this});
            return;
        }
        TicketSouvenirParams ticketSouvenirParams = this.mParams;
        if (ticketSouvenirParams == null || !ticketSouvenirParams.isValid()) {
            return;
        }
        hideBaseLayout();
        this.mSouvenirFragment = TicketSouvenirFragment.instance(this.mParams);
        getSupportFragmentManager().beginTransaction().add(R$id.ticket_souvenir_layout, this.mSouvenirFragment).commitAllowingStateLoss();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-230280074")) {
            ipChange.ipc$dispatch("-230280074", new Object[]{this});
            return;
        }
        TicketSouvenirFragment ticketSouvenirFragment = this.mSouvenirFragment;
        if (ticketSouvenirFragment != null) {
            ticketSouvenirFragment.onActivityBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1709432233")) {
            ipChange.ipc$dispatch("-1709432233", new Object[]{this, bundle});
            return;
        }
        obtainExtras(bundle);
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(un2.k().l(un2.TICKLET_SOUVENIR));
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1317914656")) {
            ipChange.ipc$dispatch("1317914656", new Object[]{this});
        }
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1430765067")) {
            ipChange.ipc$dispatch("-1430765067", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"MissingSuperCall"})
    public void onSaveInstanceState(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "764621794")) {
            ipChange.ipc$dispatch("764621794", new Object[]{this, bundle});
        }
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1545299646") ? (String) ipChange.ipc$dispatch("1545299646", new Object[]{this}) : "换纪念票";
    }
}
