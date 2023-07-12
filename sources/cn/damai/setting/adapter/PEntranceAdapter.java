package cn.damai.setting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2;
import cn.damai.commonbusiness.discover.viewholder.OnItemClickListener;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.setting.bean.PermissionBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class PEntranceAdapter extends RecyclerView.Adapter<BaseViewHolderV2> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<PermissionBean> b;
    private OnItemClickListener<PermissionBean> c;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class PEntranceVh extends BaseViewHolderV2<PermissionBean> implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView c;
        private TextView d;

        public PEntranceVh(Context context, ViewGroup viewGroup) {
            super(LayoutInflater.from(context).inflate(R$layout.item_permission_entrance, viewGroup, false));
            this.d = (TextView) this.itemView.findViewById(R$id.ipe_name);
            this.c = (TextView) this.itemView.findViewById(R$id.ipe_desc);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2
        /* renamed from: d */
        public void c(PermissionBean permissionBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1202488574")) {
                ipChange.ipc$dispatch("-1202488574", new Object[]{this, permissionBean, Integer.valueOf(i)});
                return;
            }
            this.d.setText(permissionBean.pName);
            this.c.setText(permissionBean.pDesc);
            this.itemView.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1390742843")) {
                ipChange.ipc$dispatch("-1390742843", new Object[]{this, view});
            } else if (PEntranceAdapter.this.c == null || this.a == 0) {
            } else {
                PEntranceAdapter.this.c.onItemClick((PermissionBean) this.a, this.b);
            }
        }
    }

    public PEntranceAdapter(Context context, OnItemClickListener<PermissionBean> onItemClickListener) {
        this.a = context;
        this.c = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public void onBindViewHolder(@NonNull BaseViewHolderV2 baseViewHolderV2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1728821344")) {
            ipChange.ipc$dispatch("-1728821344", new Object[]{this, baseViewHolderV2, Integer.valueOf(i)});
        } else {
            baseViewHolderV2.a(this.b.get(i), i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: c */
    public BaseViewHolderV2 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1556049322") ? (BaseViewHolderV2) ipChange.ipc$dispatch("-1556049322", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new PEntranceVh(this.a, viewGroup);
    }

    public void d(List<PermissionBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1291974008")) {
            ipChange.ipc$dispatch("-1291974008", new Object[]{this, list});
            return;
        }
        this.b = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "918839277")) {
            return ((Integer) ipChange.ipc$dispatch("918839277", new Object[]{this})).intValue();
        }
        List<PermissionBean> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
