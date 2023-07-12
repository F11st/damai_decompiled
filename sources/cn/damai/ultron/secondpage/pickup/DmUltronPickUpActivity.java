package cn.damai.ultron.secondpage.pickup;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.ticklet.bean.TicketServiceFacility;
import cn.damai.ultron.view.activity.DmPopWindowBaseActivity;
import cn.damai.ultron.view.bean.DMUltronPickUpBean;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class DmUltronPickUpActivity extends DmPopWindowBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<DMUltronPickUpBean> dmPickupAddressEntryList;

    private void getData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "480371782")) {
            ipChange.ipc$dispatch("480371782", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (extras != null) {
            List parseArray = JSON.parseArray(extras.getString("fields"), DMUltronPickUpBean.class);
            if (this.dmPickupAddressEntryList == null) {
                this.dmPickupAddressEntryList = new ArrayList();
            }
            if (parseArray != null) {
                this.dmPickupAddressEntryList.addAll(parseArray);
            }
        }
    }

    private void setRecyclerView() {
        List<DMUltronPickUpBean> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1544100704")) {
            ipChange.ipc$dispatch("-1544100704", new Object[]{this});
            return;
        }
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView == null || (list = this.dmPickupAddressEntryList) == null) {
            return;
        }
        recyclerView.setAdapter(new DmUltronPickAddressAdapter(this, list));
    }

    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity
    public boolean getRightTextVis() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1439609891")) {
            return ((Boolean) ipChange.ipc$dispatch("-1439609891", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity
    public String getTitleContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1183565297") ? (String) ipChange.ipc$dispatch("1183565297", new Object[]{this}) : TicketServiceFacility.EXCHANGE_SITE;
    }

    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity
    public boolean isLoadUt() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "699746905")) {
            return ((Boolean) ipChange.ipc$dispatch("699746905", new Object[]{this})).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "691355435")) {
            ipChange.ipc$dispatch("691355435", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        getData();
        setRecyclerView();
    }
}
