package cn.damai.projectfilter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.projectfilter.bean.FilterBean;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.kh0;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class FastFilterAdapter extends RecyclerView.Adapter<FastVh> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private OnItemBindListener<FilterBean> b;
    private List<FilterBean> c;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static class FastVh extends RecyclerView.ViewHolder implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a;
        private FilterBean b;
        private int c;
        private OnItemBindListener<FilterBean> d;

        public FastVh(@NonNull View view, OnItemBindListener<FilterBean> onItemBindListener) {
            super(view);
            TextView textView = (TextView) view.findViewById(R$id.fast_filter_tv);
            this.a = textView;
            this.d = onItemBindListener;
            textView.setOnClickListener(this);
        }

        public void a(FilterBean filterBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "609290162")) {
                ipChange.ipc$dispatch("609290162", new Object[]{this, filterBean, Integer.valueOf(i)});
                return;
            }
            this.b = filterBean;
            this.c = i;
            this.a.setText(filterBean.name);
            this.a.setSelected(filterBean.isSelected);
            this.a.setTextColor(filterBean.isSelected ? kh0.C_FF2869 : kh0.C_333333);
            this.d.exposeItem(this.a, filterBean, i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FilterBean filterBean;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1847776514")) {
                ipChange.ipc$dispatch("-1847776514", new Object[]{this, view});
                return;
            }
            OnItemBindListener<FilterBean> onItemBindListener = this.d;
            if (onItemBindListener == null || (filterBean = this.b) == null) {
                return;
            }
            onItemBindListener.onItemClick(filterBean, this.c);
        }
    }

    public FastFilterAdapter(Context context, OnItemBindListener<FilterBean> onItemBindListener) {
        this.a = context;
        this.b = onItemBindListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull FastVh fastVh, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-63565828")) {
            ipChange.ipc$dispatch("-63565828", new Object[]{this, fastVh, Integer.valueOf(i)});
        } else {
            fastVh.a(this.c.get(i), i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: b */
    public FastVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1141586118") ? (FastVh) ipChange.ipc$dispatch("-1141586118", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new FastVh(LayoutInflater.from(this.a).inflate(R$layout.item_filter_fast_btn, viewGroup, false), this.b);
    }

    public void c(List<FilterBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "122945727")) {
            ipChange.ipc$dispatch("122945727", new Object[]{this, list});
            return;
        }
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new FastDiffCallback(this.c, list), true);
        this.c = list;
        calculateDiff.dispatchUpdatesTo(new AdapterListUpdateCallback(this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1469538020")) {
            return ((Integer) ipChange.ipc$dispatch("1469538020", new Object[]{this})).intValue();
        }
        List<FilterBean> list = this.c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
