package cn.damai.ultron.secondpage.phonecode;

import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.util.ToastUtil;
import cn.damai.ultron.secondpage.phonecode.bean.DmPhoneCodeBean;
import cn.damai.ultron.utils.DmUltronChooseListenerImpl;
import cn.damai.ultron.view.activity.DmPopWindowBaseActivity;
import com.alibaba.aliweex.adapter.component.WXTabbar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class DmUltronPhoneCodeActivity extends DmPopWindowBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    public static List<DmPhoneCodeBean> dmDeliveryWayBeans;
    private DmPhoneCodeAdapter dmChoseCodeAdapter;
    public String selectedIndex = "0";
    DmUltronChooseListenerImpl<String> itemClickListener = new C2643a();

    /* compiled from: Taobao */
    /* renamed from: cn.damai.ultron.secondpage.phonecode.DmUltronPhoneCodeActivity$a */
    /* loaded from: classes9.dex */
    public class C2643a implements DmUltronChooseListenerImpl<String> {
        private static transient /* synthetic */ IpChange $ipChange;

        C2643a() {
        }

        @Override // cn.damai.ultron.utils.DmUltronChooseListenerImpl
        /* renamed from: a */
        public void chooseItemListener(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1898308933")) {
                ipChange.ipc$dispatch("-1898308933", new Object[]{this, str});
            } else if (str.equals(DmUltronPhoneCodeActivity.this.selectedIndex)) {
                DmUltronPhoneCodeActivity.this.finishActivity();
            } else {
                Intent intent = new Intent();
                intent.putExtra(WXTabbar.SELECT_INDEX, str);
                DmUltronPhoneCodeActivity.this.setResult(-1, intent);
                DmUltronPhoneCodeActivity.this.finishActivity();
            }
        }
    }

    private void getData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "626660264")) {
            ipChange.ipc$dispatch("626660264", new Object[]{this});
            return;
        }
        if (dmDeliveryWayBeans == null) {
            dmDeliveryWayBeans = new ArrayList();
        }
        dmDeliveryWayBeans.clear();
        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                ToastUtil.i("暂不支持切换区号");
                finish();
                return;
            }
            if (extras.containsKey("selectCode")) {
                this.selectedIndex = extras.getString("selectCode", "0");
            }
            if (extras.containsKey("code")) {
                ArrayList parcelableArrayList = extras.getParcelableArrayList("code");
                if (wh2.e(parcelableArrayList) == 0) {
                    ToastUtil.i("暂不支持切换区号");
                    finish();
                    return;
                }
                dmDeliveryWayBeans.addAll(parcelableArrayList);
            }
        }
    }

    private void setRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-951938558")) {
            ipChange.ipc$dispatch("-951938558", new Object[]{this});
            return;
        }
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            DmPhoneCodeAdapter dmPhoneCodeAdapter = new DmPhoneCodeAdapter(this, dmDeliveryWayBeans, this.selectedIndex, this.itemClickListener);
            this.dmChoseCodeAdapter = dmPhoneCodeAdapter;
            recyclerView.setAdapter(dmPhoneCodeAdapter);
        }
    }

    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity
    public boolean getRightTextVis() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-847447745")) {
            return ((Boolean) ipChange.ipc$dispatch("-847447745", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity
    public String getTitleContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1740093233") ? (String) ipChange.ipc$dispatch("-1740093233", new Object[]{this}) : "选择国家和地区";
    }

    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity
    public boolean isLoadUt() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "939722551")) {
            return ((Boolean) ipChange.ipc$dispatch("939722551", new Object[]{this})).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1920079475")) {
            ipChange.ipc$dispatch("-1920079475", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        getData();
        setRecyclerView();
    }
}
