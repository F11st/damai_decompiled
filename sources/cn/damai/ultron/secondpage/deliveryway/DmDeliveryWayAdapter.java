package cn.damai.ultron.secondpage.deliveryway;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.ultron.R$id;
import cn.damai.ultron.R$layout;
import cn.damai.ultron.utils.DmChooseSwitchListenerImpl;
import cn.damai.ultron.view.bean.DmDeliveryWayBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class DmDeliveryWayAdapter extends RecyclerView.Adapter<DeliveryViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<DmDeliveryWayBean> a;
    private Context b;
    private DmChooseSwitchListenerImpl<List<DmDeliveryWayBean>> c;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class DeliveryViewHolder extends RecyclerView.ViewHolder {
        private View a;
        private TextView b;
        private TextView c;
        private CheckBox d;

        public DeliveryViewHolder(DmDeliveryWayAdapter dmDeliveryWayAdapter, View view) {
            super(view);
            this.a = view;
            this.b = (TextView) view.findViewById(R$id.text_name);
            this.c = (TextView) view.findViewById(R$id.text_desc);
            this.d = (CheckBox) view.findViewById(R$id.checkbox);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-116353768")) {
                ipChange.ipc$dispatch("-116353768", new Object[]{this, view});
                return;
            }
            DmDeliveryWayAdapter.this.f(this.a);
            DmDeliveryWayAdapter.this.notifyDataSetChanged();
            DmDeliveryWayAdapter.this.c.chooseItemListener(DmDeliveryWayAdapter.this.a, this.a);
        }
    }

    public DmDeliveryWayAdapter(Context context, List<DmDeliveryWayBean> list, DmChooseSwitchListenerImpl<List<DmDeliveryWayBean>> dmChooseSwitchListenerImpl) {
        this.b = context;
        this.a = list;
        this.c = dmChooseSwitchListenerImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1286562852")) {
            ipChange.ipc$dispatch("-1286562852", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        for (int i2 = 0; i2 < wh2.e(this.a); i2++) {
            if (i2 == i) {
                this.a.get(i2).selected = true;
            } else {
                this.a.get(i2).selected = false;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public void onBindViewHolder(DeliveryViewHolder deliveryViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1233553779")) {
            ipChange.ipc$dispatch("1233553779", new Object[]{this, deliveryViewHolder, Integer.valueOf(i)});
            return;
        }
        DmDeliveryWayBean dmDeliveryWayBean = this.a.get(i);
        deliveryViewHolder.b.setText(dmDeliveryWayBean.desc);
        if (TextUtils.isEmpty(dmDeliveryWayBean.tip)) {
            deliveryViewHolder.c.setVisibility(8);
        } else {
            deliveryViewHolder.c.setText(dmDeliveryWayBean.tip);
            deliveryViewHolder.c.setVisibility(0);
        }
        deliveryViewHolder.d.setOnCheckedChangeListener(null);
        deliveryViewHolder.d.setChecked(dmDeliveryWayBean.getCheckState());
        deliveryViewHolder.a.setOnClickListener(new a(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public DeliveryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1137158557") ? (DeliveryViewHolder) ipChange.ipc$dispatch("-1137158557", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new DeliveryViewHolder(this, LayoutInflater.from(this.b).inflate(R$layout.dm_ultron_delivery_way_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1857845561") ? ((Integer) ipChange.ipc$dispatch("-1857845561", new Object[]{this})).intValue() : wh2.e(this.a);
    }
}
