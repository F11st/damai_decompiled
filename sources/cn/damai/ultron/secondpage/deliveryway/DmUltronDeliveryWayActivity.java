package cn.damai.ultron.secondpage.deliveryway;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.c;
import cn.damai.ultron.R$id;
import cn.damai.ultron.utils.DmChooseSwitchListenerImpl;
import cn.damai.ultron.view.activity.DmPopWindowBaseActivity;
import cn.damai.ultron.view.bean.DmDeliveryWayBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.pictures.bricks.selector.ScriptSelectFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.kb0;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class DmUltronDeliveryWayActivity extends DmPopWindowBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private DmDeliveryWayAdapter mAdapter;
    private String mCurrentDeliveryWayType;
    private RecyclerView mRecyclerView;
    private List<DmDeliveryWayBean> mDeliveryWayEntries = new ArrayList();
    DmChooseSwitchListenerImpl<List<DmDeliveryWayBean>> itemClickListener = new a();

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class a implements DmChooseSwitchListenerImpl<List<DmDeliveryWayBean>> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.ultron.utils.DmChooseSwitchListenerImpl
        /* renamed from: a */
        public void chooseItemListener(List<DmDeliveryWayBean> list, int i) {
            DmDeliveryWayBean dmDeliveryWayBean;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1320767713")) {
                ipChange.ipc$dispatch("1320767713", new Object[]{this, list, Integer.valueOf(i)});
            } else if (i >= wh2.e(list) || i < 0 || (dmDeliveryWayBean = list.get(i)) == null) {
            } else {
                c.e().x(kb0.u().k(DmUltronDeliveryWayActivity.this, dmDeliveryWayBean.desc, i));
                String str = dmDeliveryWayBean.deliveryType;
                if (DmUltronDeliveryWayActivity.this.mCurrentDeliveryWayType == null || !DmUltronDeliveryWayActivity.this.mCurrentDeliveryWayType.equalsIgnoreCase(str)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("deliveryWayEntries", JSON.toJSONString(list));
                    Intent intent = new Intent();
                    intent.putExtra(ScriptSelectFragment.EXTRA_KEY_SELECT_ID, dmDeliveryWayBean.deliveryType);
                    intent.putExtra(SocialConstants.PARAM_APP_DESC, dmDeliveryWayBean.desc);
                    intent.putExtra("eventparams", JSON.toJSONString(hashMap));
                    DmUltronDeliveryWayActivity.this.setResult(-1, intent);
                }
                DmUltronDeliveryWayActivity.this.finishActivity();
            }
        }
    }

    private void getComponentData(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-93646685")) {
            ipChange.ipc$dispatch("-93646685", new Object[]{this, bundle});
        } else if (bundle != null && bundle.containsKey(ScriptSelectFragment.EXTRA_KEY_SELECT_ID)) {
            this.mCurrentDeliveryWayType = bundle.getString(ScriptSelectFragment.EXTRA_KEY_SELECT_ID);
        }
    }

    private void getData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1528120168")) {
            ipChange.ipc$dispatch("1528120168", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        Bundle extras = intent != null ? intent.getExtras() : null;
        getComponentData(extras);
        getDeliveryWayList(extras);
    }

    private void getDeliveryWayList(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-961295563")) {
            ipChange.ipc$dispatch("-961295563", new Object[]{this, bundle});
        } else if (bundle != null && bundle.containsKey("param")) {
            try {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("param");
                if (wh2.e(parcelableArrayList) > 0) {
                    this.mDeliveryWayEntries.clear();
                    this.mDeliveryWayEntries.addAll(parcelableArrayList);
                    DmDeliveryWayAdapter dmDeliveryWayAdapter = this.mAdapter;
                    if (dmDeliveryWayAdapter != null) {
                        dmDeliveryWayAdapter.notifyDataSetChanged();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void setRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-709754430")) {
            ipChange.ipc$dispatch("-709754430", new Object[]{this});
            return;
        }
        RecyclerView recyclerView = getRecyclerView();
        this.mRecyclerView = recyclerView;
        if (recyclerView != null) {
            DmDeliveryWayAdapter dmDeliveryWayAdapter = new DmDeliveryWayAdapter(this, this.mDeliveryWayEntries, this.itemClickListener);
            this.mAdapter = dmDeliveryWayAdapter;
            this.mRecyclerView.setAdapter(dmDeliveryWayAdapter);
        }
    }

    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity
    public boolean getRightTextVis() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-605263617")) {
            return ((Boolean) ipChange.ipc$dispatch("-605263617", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity
    public String getTitleContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "70144271") ? (String) ipChange.ipc$dispatch("70144271", new Object[]{this}) : "选择配送方式";
    }

    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity
    public boolean isLoadUt() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1179791497")) {
            return ((Boolean) ipChange.ipc$dispatch("-1179791497", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity, cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "402965107")) {
            ipChange.ipc$dispatch("402965107", new Object[]{this, view});
        } else if (view.getId() == R$id.v_outside) {
            finishActivity();
        } else if (view.getId() == R$id.text_ok) {
            c.e().x(kb0.u().j(this));
            finishActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "529774925")) {
            ipChange.ipc$dispatch("529774925", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        getData();
        setRecyclerView();
    }
}
