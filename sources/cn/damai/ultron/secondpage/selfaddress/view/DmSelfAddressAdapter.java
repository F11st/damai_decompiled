package cn.damai.ultron.secondpage.selfaddress.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.ultron.R$id;
import cn.damai.ultron.R$layout;
import cn.damai.ultron.secondpage.selfaddress.bean.DmSelfAddressBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class DmSelfAddressAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<DmSelfAddressBean> a;
    private Context b;
    private int c;
    private String d;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class SelfAddressViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a;
        private TextView b;
        private TextView c;
        private TextView d;
        private TextView e;
        private TextView f;
        private View g;
        private View h;

        public SelfAddressViewHolder(View view) {
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

        public void a(DmSelfAddressBean dmSelfAddressBean, int i) {
            boolean z;
            String str;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "820357679")) {
                ipChange.ipc$dispatch("820357679", new Object[]{this, dmSelfAddressBean, Integer.valueOf(i)});
                return;
            }
            this.d.setText(dmSelfAddressBean.pointAddr);
            if (TextUtils.isEmpty(dmSelfAddressBean.tag)) {
                this.b.setVisibility(8);
                z = false;
            } else {
                this.b.setText(dmSelfAddressBean.tag);
                this.b.setVisibility(0);
                z = true;
            }
            if (TextUtils.isEmpty(dmSelfAddressBean.distance)) {
                this.c.setVisibility(8);
            } else {
                this.c.setText(dmSelfAddressBean.distance);
                this.c.setVisibility(0);
                z = true;
            }
            if (TextUtils.isEmpty(dmSelfAddressBean.pointName)) {
                this.a.setText("");
            } else if (z) {
                if (dmSelfAddressBean.pointName.length() > 10) {
                    str = dmSelfAddressBean.pointName.substring(0, 10) + "...";
                } else {
                    str = dmSelfAddressBean.pointName;
                }
                this.a.setText(str);
            } else {
                this.a.setText(dmSelfAddressBean.pointName);
            }
            if (!TextUtils.isEmpty(dmSelfAddressBean.bizTimeShow)) {
                this.e.setVisibility(0);
                this.e.setText("时间：" + dmSelfAddressBean.bizTimeShow);
            } else {
                this.e.setVisibility(8);
            }
            this.f.setVisibility(8);
            if (DmSelfAddressAdapter.this.getItemCount() != 1 && i != DmSelfAddressAdapter.this.getItemCount() - 1) {
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(8);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class SelfTipViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a;

        public SelfTipViewHolder(DmSelfAddressAdapter dmSelfAddressAdapter, View view) {
            super(view);
            this.a = (TextView) view.findViewById(R$id.tv_self_tip);
        }

        public void a(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1646195245")) {
                ipChange.ipc$dispatch("1646195245", new Object[]{this, str});
            } else {
                this.a.setText(str);
            }
        }
    }

    public DmSelfAddressAdapter(Context context, List<DmSelfAddressBean> list, String str, int i) {
        this.b = context;
        this.a = list;
        this.d = str;
        this.c = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1911457559")) {
            return ((Integer) ipChange.ipc$dispatch("-1911457559", new Object[]{this})).intValue();
        }
        if (this.c != 1) {
            return wh2.e(this.a);
        }
        return !TextUtils.isEmpty(this.d) ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1543784048")) {
            ipChange.ipc$dispatch("1543784048", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (this.c != 1) {
            ((SelfAddressViewHolder) viewHolder).a(this.a.get(i), i);
        } else {
            ((SelfTipViewHolder) viewHolder).a(this.d);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1032901510")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("1032901510", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        if (this.c != 1) {
            return new SelfAddressViewHolder(LayoutInflater.from(this.b).inflate(R$layout.dm_item_pickup_address, viewGroup, false));
        }
        return new SelfTipViewHolder(this, LayoutInflater.from(this.b).inflate(R$layout.dm_item_self_tip, viewGroup, false));
    }
}
