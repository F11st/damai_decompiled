package cn.damai.mine.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.mine.activity.CustomersActivity;
import cn.damai.mine.bean.CustomerBean;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class CustomerListAdapter extends RecyclerView.Adapter<C1424b> {
    private static transient /* synthetic */ IpChange $ipChange;
    private CustomersActivity a;
    private List<CustomerBean> b;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.adapter.CustomerListAdapter$a */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1423a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CustomerBean a;

        View$OnClickListenerC1423a(CustomerBean customerBean) {
            this.a = customerBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-366801139")) {
                ipChange.ipc$dispatch("-366801139", new Object[]{this, view});
            } else {
                CustomerListAdapter.this.a.showDeleteCustomerDialog(this.a.getIdentityHash());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.adapter.CustomerListAdapter$b */
    /* loaded from: classes6.dex */
    public class C1424b extends RecyclerView.ViewHolder {
        TextView a;
        TextView b;
        TextView c;
        DMIconFontTextView d;
        View e;

        public C1424b(CustomerListAdapter customerListAdapter, View view) {
            super(view);
            this.a = (TextView) view.findViewById(R$id.user_name);
            this.b = (TextView) view.findViewById(R$id.idTypeName);
            this.c = (TextView) view.findViewById(R$id.idCard);
            this.d = (DMIconFontTextView) view.findViewById(R$id.custom_delete);
            this.e = view.findViewById(R$id.customer_item_bottom_line);
        }
    }

    public CustomerListAdapter(CustomersActivity customersActivity) {
        this.b = new ArrayList();
        this.a = customersActivity;
        this.b = new ArrayList();
    }

    private void d(C1424b c1424b, CustomerBean customerBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-606487203")) {
            ipChange.ipc$dispatch("-606487203", new Object[]{this, c1424b, customerBean});
            return;
        }
        if (!TextUtils.isEmpty(customerBean.getMaskedName())) {
            c1424b.a.setText(customerBean.getMaskedName());
        }
        if (!TextUtils.isEmpty(customerBean.getIdentityTypeName())) {
            c1424b.b.setText(customerBean.getIdentityTypeName());
        }
        if (!TextUtils.isEmpty(customerBean.getMaskedIdentityNo())) {
            c1424b.c.setText(customerBean.getMaskedIdentityNo());
        }
        c1424b.d.setOnClickListener(new View$OnClickListenerC1423a(customerBean));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public void onBindViewHolder(C1424b c1424b, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1797472651")) {
            ipChange.ipc$dispatch("-1797472651", new Object[]{this, c1424b, Integer.valueOf(i)});
            return;
        }
        d(c1424b, this.b.get(i));
        if (i == getItemCount() - 1) {
            c1424b.e.setVisibility(8);
        } else {
            c1424b.e.setVisibility(0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public C1424b onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "126433057") ? (C1424b) ipChange.ipc$dispatch("126433057", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new C1424b(this, LayoutInflater.from(this.a).inflate(R$layout.customer_item, (ViewGroup) null));
    }

    public List<CustomerBean> getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1902291476") ? (List) ipChange.ipc$dispatch("-1902291476", new Object[]{this}) : this.b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2788028") ? ((Integer) ipChange.ipc$dispatch("2788028", new Object[]{this})).intValue() : this.b.size();
    }

    public void setData(List<CustomerBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "905405280")) {
            ipChange.ipc$dispatch("905405280", new Object[]{this, list});
            return;
        }
        this.b = list;
        notifyDataSetChanged();
    }
}
