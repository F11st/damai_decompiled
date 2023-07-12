package cn.damai.ultron.secondpage.pickup;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.ultron.R$id;
import cn.damai.ultron.R$layout;
import cn.damai.ultron.view.bean.DMUltronPickUpBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class DmUltronPickAddressAdapter extends RecyclerView.Adapter<PickupAddressViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<DMUltronPickUpBean> a;
    private Context b;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class PickupAddressViewHolder extends RecyclerView.ViewHolder {
        private TextView a;
        private TextView b;
        private TextView c;
        private TextView d;
        private TextView e;
        private TextView f;
        private View g;
        private View h;

        public PickupAddressViewHolder(DmUltronPickAddressAdapter dmUltronPickAddressAdapter, View view) {
            super(view);
            this.h = view;
            this.a = (TextView) view.findViewById(R$id.tv_pickup_name);
            this.b = (TextView) view.findViewById(R$id.tv_pickup_tag);
            this.c = (TextView) view.findViewById(R$id.tv_pickup_location);
            this.d = (TextView) view.findViewById(R$id.text_address);
            this.e = (TextView) view.findViewById(R$id.text_time);
            this.f = (TextView) view.findViewById(R$id.text_phone);
            this.g = view.findViewById(R$id.line);
        }
    }

    public DmUltronPickAddressAdapter(Context context, List<DMUltronPickUpBean> list) {
        this.b = context;
        this.a = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(PickupAddressViewHolder pickupAddressViewHolder, int i) {
        boolean z;
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-380919951")) {
            ipChange.ipc$dispatch("-380919951", new Object[]{this, pickupAddressViewHolder, Integer.valueOf(i)});
            return;
        }
        DMUltronPickUpBean dMUltronPickUpBean = this.a.get(i);
        pickupAddressViewHolder.d.setText(dMUltronPickUpBean.address);
        if (TextUtils.isEmpty(dMUltronPickUpBean.label)) {
            pickupAddressViewHolder.b.setVisibility(8);
            z = false;
        } else {
            pickupAddressViewHolder.b.setText(dMUltronPickUpBean.label);
            pickupAddressViewHolder.b.setVisibility(0);
            z = true;
        }
        if (TextUtils.isEmpty(dMUltronPickUpBean.distance)) {
            pickupAddressViewHolder.c.setVisibility(8);
        } else {
            pickupAddressViewHolder.c.setText(dMUltronPickUpBean.distance);
            pickupAddressViewHolder.c.setVisibility(0);
            z = true;
        }
        if (TextUtils.isEmpty(dMUltronPickUpBean.name)) {
            pickupAddressViewHolder.a.setText("");
        } else if (!z) {
            pickupAddressViewHolder.a.setText(dMUltronPickUpBean.name);
        } else {
            if (dMUltronPickUpBean.name.length() > 10) {
                str = dMUltronPickUpBean.name.substring(0, 10) + "...";
            } else {
                str = dMUltronPickUpBean.name;
            }
            pickupAddressViewHolder.a.setText(str);
        }
        if (!TextUtils.isEmpty(dMUltronPickUpBean.addressTime)) {
            pickupAddressViewHolder.e.setVisibility(0);
            pickupAddressViewHolder.e.setText("时间：" + dMUltronPickUpBean.addressTime);
        } else {
            pickupAddressViewHolder.e.setVisibility(8);
        }
        if (!TextUtils.isEmpty(dMUltronPickUpBean.addressPhone)) {
            pickupAddressViewHolder.f.setVisibility(0);
            pickupAddressViewHolder.f.setText("电话：" + dMUltronPickUpBean.addressPhone);
        } else {
            pickupAddressViewHolder.f.setVisibility(8);
        }
        if (getItemCount() == 1 || i == getItemCount() - 1) {
            pickupAddressViewHolder.g.setVisibility(8);
        } else {
            pickupAddressViewHolder.g.setVisibility(0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public PickupAddressViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "770740901") ? (PickupAddressViewHolder) ipChange.ipc$dispatch("770740901", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new PickupAddressViewHolder(this, LayoutInflater.from(this.b).inflate(R$layout.ultron_pickup_address_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2139440002") ? ((Integer) ipChange.ipc$dispatch("2139440002", new Object[]{this})).intValue() : wh2.e(this.a);
    }
}
