package cn.damai.tetris.component.drama.viewholder;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolder;
import cn.damai.tetris.component.drama.bean.DramaMonthBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class MonthTabAdapter extends RecyclerView.Adapter<TabVh> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<DramaMonthBean> a;
    private DramaMonthBean b;
    private OnItemClickListener<DramaMonthBean> c;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class TabVh extends BaseViewHolder<DramaMonthBean> implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a;
        private DramaMonthBean b;
        private int c;

        public TabVh(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R$id.month_tab_tv);
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolder
        /* renamed from: c */
        public void a(DramaMonthBean dramaMonthBean, int i) {
            int parseColor;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1731312060")) {
                ipChange.ipc$dispatch("1731312060", new Object[]{this, dramaMonthBean, Integer.valueOf(i)});
                return;
            }
            this.b = dramaMonthBean;
            this.c = i;
            if (dramaMonthBean == MonthTabAdapter.this.b) {
                parseColor = Color.parseColor("#FF2869");
            } else {
                parseColor = Color.parseColor("#9C9CA5");
            }
            this.a.setTextColor(parseColor);
            this.a.setText(dramaMonthBean.labelName);
            this.itemView.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DramaMonthBean dramaMonthBean;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1956720486")) {
                ipChange.ipc$dispatch("-1956720486", new Object[]{this, view});
            } else if (MonthTabAdapter.this.c == null || (dramaMonthBean = this.b) == null || dramaMonthBean == MonthTabAdapter.this.b) {
            } else {
                MonthTabAdapter.this.c.onItemClick(this.b, this.c);
            }
        }
    }

    public MonthTabAdapter(OnItemClickListener<DramaMonthBean> onItemClickListener) {
        this.c = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public void onBindViewHolder(@NonNull TabVh tabVh, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2023964495")) {
            ipChange.ipc$dispatch("2023964495", new Object[]{this, tabVh, Integer.valueOf(i)});
        } else {
            tabVh.a(this.a.get(i), i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: d */
    public TabVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1071381511") ? (TabVh) ipChange.ipc$dispatch("1071381511", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new TabVh(LayoutInflater.from(mu0.a()).inflate(R$layout.item_tetris_month_tab, viewGroup, false));
    }

    public void e(List<DramaMonthBean> list, DramaMonthBean dramaMonthBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "119209824")) {
            ipChange.ipc$dispatch("119209824", new Object[]{this, list, dramaMonthBean});
            return;
        }
        this.a = list;
        this.b = dramaMonthBean;
        notifyDataSetChanged();
    }

    public boolean f(DramaMonthBean dramaMonthBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1614690513")) {
            return ((Boolean) ipChange.ipc$dispatch("1614690513", new Object[]{this, dramaMonthBean})).booleanValue();
        }
        if (this.b == dramaMonthBean) {
            return false;
        }
        this.b = dramaMonthBean;
        notifyDataSetChanged();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-697696781")) {
            return ((Integer) ipChange.ipc$dispatch("-697696781", new Object[]{this})).intValue();
        }
        List<DramaMonthBean> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
