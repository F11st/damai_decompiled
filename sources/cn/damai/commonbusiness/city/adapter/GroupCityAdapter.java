package cn.damai.commonbusiness.city.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.city.listener.OnCityListItemClickListener;
import cn.damai.commonbusiness.city.model.SitesBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.r92;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class GroupCityAdapter extends RecyclerView.Adapter<GroupCityViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnCityListItemClickListener a;
    private Context b;
    private List<SitesBean> c;
    private View.OnClickListener d = new a();

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class GroupCityViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a;
        private View b;
        private View c;

        public GroupCityViewHolder() {
            super(LayoutInflater.from(GroupCityAdapter.this.b).inflate(R$layout.layout_select_city_group_list_item, (ViewGroup) null));
            this.a = (TextView) this.itemView.findViewById(R$id.select_city_list_item);
            this.b = this.itemView.findViewById(R$id.select_city_list_item_divider);
            this.c = this.itemView.findViewById(R$id.select_city_list_item_divider_bottom);
            this.itemView.setOnClickListener(GroupCityAdapter.this.d);
            this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }

        public void a(SitesBean sitesBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-834564344")) {
                ipChange.ipc$dispatch("-834564344", new Object[]{this, sitesBean, Integer.valueOf(i)});
                return;
            }
            this.b.setVisibility(i == 0 ? 8 : 0);
            this.c.setVisibility(i != GroupCityAdapter.this.getItemCount() - 1 ? 8 : 0);
            if (sitesBean != null) {
                this.a.setText(sitesBean.getCityName());
                this.itemView.setTag(sitesBean);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SitesBean sitesBean;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "342984603")) {
                ipChange.ipc$dispatch("342984603", new Object[]{this, view});
            } else if (r92.c() || (sitesBean = (SitesBean) view.getTag()) == null || GroupCityAdapter.this.a == null) {
            } else {
                GroupCityAdapter.this.a.onGroupCityClick(sitesBean.getCityId(), sitesBean.getCityName());
            }
        }
    }

    public GroupCityAdapter(Context context) {
        this.b = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public void onBindViewHolder(@NonNull GroupCityViewHolder groupCityViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "531445961")) {
            ipChange.ipc$dispatch("531445961", new Object[]{this, groupCityViewHolder, Integer.valueOf(i)});
            return;
        }
        SitesBean sitesBean = this.c.get(i);
        if (groupCityViewHolder != null) {
            groupCityViewHolder.a(sitesBean, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: e */
    public GroupCityViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "886810253") ? (GroupCityViewHolder) ipChange.ipc$dispatch("886810253", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new GroupCityViewHolder();
    }

    public void f(OnCityListItemClickListener onCityListItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "61297730")) {
            ipChange.ipc$dispatch("61297730", new Object[]{this, onCityListItemClickListener});
        } else {
            this.a = onCityListItemClickListener;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-915939510") ? ((Integer) ipChange.ipc$dispatch("-915939510", new Object[]{this})).intValue() : wh2.e(this.c);
    }

    public void setData(List<SitesBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1016641006")) {
            ipChange.ipc$dispatch("-1016641006", new Object[]{this, list});
        } else {
            this.c = list;
        }
    }
}
