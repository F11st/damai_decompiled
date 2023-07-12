package cn.damai.ultron.view.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.ultron.utils.DmChooseSwitchListenerImpl;
import cn.damai.ultron.view.adapter.DmUltronPromotionAdapterOld;
import cn.damai.ultron.view.bean.DmPromotionOptionsBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.pictures.bricks.selector.ScriptSelectFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import tb.ua0;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class DmUltronPromotionActivityOld extends DmPopWindowBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private String TAG_ID;
    DmChooseSwitchListenerImpl<DmPromotionOptionsBean> itemClickListener = new a();
    private List<DmPromotionOptionsBean> mPromotionBeanList;
    private String selectId;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class a implements DmChooseSwitchListenerImpl<DmPromotionOptionsBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.ultron.utils.DmChooseSwitchListenerImpl
        /* renamed from: a */
        public void chooseItemListener(DmPromotionOptionsBean dmPromotionOptionsBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1877508849")) {
                ipChange.ipc$dispatch("1877508849", new Object[]{this, dmPromotionOptionsBean, Integer.valueOf(i)});
            } else if (dmPromotionOptionsBean == null) {
            } else {
                try {
                    ua0.h(DmUltronPromotionActivityOld.this, dmPromotionOptionsBean.fullTitle);
                    ua0.i(DmUltronPromotionActivityOld.this, dmPromotionOptionsBean.id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (DmUltronPromotionActivityOld.this.selectId == null || !DmUltronPromotionActivityOld.this.selectId.equals(dmPromotionOptionsBean.id)) {
                    Intent intent = new Intent();
                    intent.putExtra(ScriptSelectFragment.EXTRA_KEY_SELECT_ID, dmPromotionOptionsBean.id);
                    intent.putExtra(SocialConstants.PARAM_APP_DESC, dmPromotionOptionsBean.title);
                    intent.putExtra("tag_id", DmUltronPromotionActivityOld.this.TAG_ID);
                    DmUltronPromotionActivityOld.this.setResult(-1, intent);
                }
                DmUltronPromotionActivityOld.this.finishActivity();
            }
        }
    }

    private void getData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-446655155")) {
            ipChange.ipc$dispatch("-446655155", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (extras != null) {
            this.selectId = extras.getString(ScriptSelectFragment.EXTRA_KEY_SELECT_ID);
            String string = extras.getString("paramvalue");
            this.TAG_ID = extras.getString("tag_id");
            List parseArray = JSON.parseArray(string, DmPromotionOptionsBean.class);
            if (this.mPromotionBeanList == null) {
                this.mPromotionBeanList = new ArrayList();
            }
            if (parseArray != null) {
                this.mPromotionBeanList.addAll(parseArray);
            }
        }
    }

    private void setRecyclerView() {
        List<DmPromotionOptionsBean> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "760454823")) {
            ipChange.ipc$dispatch("760454823", new Object[]{this});
            return;
        }
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView == null || (list = this.mPromotionBeanList) == null) {
            return;
        }
        DmUltronPromotionAdapterOld dmUltronPromotionAdapterOld = new DmUltronPromotionAdapterOld(this, list, this.itemClickListener);
        dmUltronPromotionAdapterOld.g(this.selectId);
        recyclerView.setAdapter(dmUltronPromotionAdapterOld);
    }

    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity
    public boolean getRightTextVis() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "864945636")) {
            return ((Boolean) ipChange.ipc$dispatch("864945636", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity
    public String getTitleContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2130148042") ? (String) ipChange.ipc$dispatch("2130148042", new Object[]{this}) : "店铺优惠";
    }

    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity
    public boolean isLoadUt() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2026682930")) {
            return ((Boolean) ipChange.ipc$dispatch("2026682930", new Object[]{this})).booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1088431794")) {
            ipChange.ipc$dispatch("1088431794", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        getData();
        setRecyclerView();
    }
}
