package cn.damai.ultron.secondpage.pickup;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.address.bean.DmPickupAddressBean;
import cn.damai.commonbusiness.address.bean.DmPickupAddressEntry;
import cn.damai.ticklet.bean.TicketServiceFacility;
import cn.damai.ultron.view.activity.DmPopWindowBaseActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class OrderDetailPickupAddressListActivity extends DmPopWindowBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String DM_PICKUP_ADDRESS = "dm_pickup_address";
    private DmPickupAddressBean dmPickupAddressBean;
    private List<DmPickupAddressEntry> dmPickupAddressEntryList;

    private void getData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "962086920")) {
            ipChange.ipc$dispatch("962086920", new Object[]{this});
            return;
        }
        DmPickupAddressBean dmPickupAddressBean = (DmPickupAddressBean) getIntent().getSerializableExtra(DM_PICKUP_ADDRESS);
        this.dmPickupAddressBean = dmPickupAddressBean;
        if (dmPickupAddressBean != null) {
            this.dmPickupAddressEntryList = dmPickupAddressBean.dmPickupAddressEntryList;
        }
    }

    private void setRecyclerView() {
        List<DmPickupAddressEntry> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2104911458")) {
            ipChange.ipc$dispatch("2104911458", new Object[]{this});
            return;
        }
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView == null || (list = this.dmPickupAddressEntryList) == null) {
            return;
        }
        recyclerView.setAdapter(new OrderDetailPickAddressAdapter(this, list));
    }

    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity
    public boolean getRightTextVis() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2085565025")) {
            return ((Boolean) ipChange.ipc$dispatch("-2085565025", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity
    public String getTitleContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "879476847") ? (String) ipChange.ipc$dispatch("879476847", new Object[]{this}) : TicketServiceFacility.EXCHANGE_SITE;
    }

    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity
    public boolean isLoadUt() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1546953001")) {
            return ((Boolean) ipChange.ipc$dispatch("-1546953001", new Object[]{this})).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2117718547")) {
            ipChange.ipc$dispatch("-2117718547", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        getData();
        setRecyclerView();
    }
}
