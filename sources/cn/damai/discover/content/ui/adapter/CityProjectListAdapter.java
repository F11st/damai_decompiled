package cn.damai.discover.content.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2;
import cn.damai.discover.content.bean.ContentTour;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class CityProjectListAdapter extends RecyclerView.Adapter<CityProjectVh> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<ContentTour.ContentRelatedTourListItem> a;
    private OnItemBindListener<ContentTour.ContentRelatedTourListItem> b;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class CityProjectVh extends BaseViewHolderV2<ContentTour.ContentRelatedTourListItem> implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView c;
        private TextView d;

        public CityProjectVh(ViewGroup viewGroup) {
            super(LayoutInflater.from(mu0.a()).inflate(R$layout.item_city_project, viewGroup, false));
            this.c = (TextView) this.itemView.findViewById(R$id.city_project_name);
            this.d = (TextView) this.itemView.findViewById(R$id.city_project_time);
            this.itemView.setOnClickListener(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2
        /* renamed from: d */
        public void c(ContentTour.ContentRelatedTourListItem contentRelatedTourListItem, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1417112870")) {
                ipChange.ipc$dispatch("1417112870", new Object[]{this, contentRelatedTourListItem, Integer.valueOf(i)});
            } else if (contentRelatedTourListItem == null) {
            } else {
                this.c.setText(contentRelatedTourListItem.cityName);
                this.d.setText(contentRelatedTourListItem.showTime);
                if (CityProjectListAdapter.this.b != null) {
                    CityProjectListAdapter.this.b.exposeItem(this.itemView, (ContentTour.ContentRelatedTourListItem) this.a, i);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1810790791")) {
                ipChange.ipc$dispatch("1810790791", new Object[]{this, view});
            } else if (this.a == 0 || CityProjectListAdapter.this.b == null) {
            } else {
                CityProjectListAdapter.this.b.onItemClick((ContentTour.ContentRelatedTourListItem) this.a, this.b);
            }
        }
    }

    public CityProjectListAdapter(OnItemBindListener<ContentTour.ContentRelatedTourListItem> onItemBindListener) {
        this.b = onItemBindListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public void onBindViewHolder(@NonNull CityProjectVh cityProjectVh, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "622134376")) {
            ipChange.ipc$dispatch("622134376", new Object[]{this, cityProjectVh, Integer.valueOf(i)});
        } else {
            cityProjectVh.a(this.a.get(i), i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: c */
    public CityProjectVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1171371214") ? (CityProjectVh) ipChange.ipc$dispatch("1171371214", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new CityProjectVh(viewGroup);
    }

    public void d(List<ContentTour.ContentRelatedTourListItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-466189662")) {
            ipChange.ipc$dispatch("-466189662", new Object[]{this, list});
            return;
        }
        this.a = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1121276039")) {
            return ((Integer) ipChange.ipc$dispatch("1121276039", new Object[]{this})).intValue();
        }
        List<ContentTour.ContentRelatedTourListItem> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
