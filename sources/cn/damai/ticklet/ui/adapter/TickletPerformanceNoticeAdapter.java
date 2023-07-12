package cn.damai.ticklet.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.bean.TicketPerformanceNoticeResult;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.py2;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletPerformanceNoticeAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private ArrayList<TicketPerformanceNoticeResult.TicketNoticeData> a;
    private Context b;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView a;
        TextView b;

        public ViewHolder(TickletPerformanceNoticeAdapter tickletPerformanceNoticeAdapter, View view) {
            super(view);
        }
    }

    public TickletPerformanceNoticeAdapter(Context context, ArrayList<TicketPerformanceNoticeResult.TicketNoticeData> arrayList) {
        this.a = new ArrayList<>();
        this.b = context;
        this.a = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1684762067")) {
            ipChange.ipc$dispatch("-1684762067", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        TicketPerformanceNoticeResult.TicketNoticeData ticketNoticeData = this.a.get(i);
        if (ticketNoticeData == null) {
            return;
        }
        if (i == 0) {
            View view = viewHolder.itemView;
            view.setPadding(view.getPaddingLeft(), t60.a(this.b, 21.0f), viewHolder.itemView.getPaddingRight(), viewHolder.itemView.getPaddingBottom());
        } else {
            View view2 = viewHolder.itemView;
            view2.setPadding(view2.getPaddingLeft(), t60.a(this.b, 30.0f), viewHolder.itemView.getPaddingRight(), viewHolder.itemView.getPaddingBottom());
        }
        viewHolder.itemView.setTag(Integer.valueOf(i));
        if (ticketNoticeData.name != null) {
            TextView textView = viewHolder.a;
            py2.F(textView, "【" + ticketNoticeData.name + "】");
        }
        if (this.a.get(i).description != null) {
            py2.F(viewHolder.b, ticketNoticeData.description);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1566623639")) {
            return (ViewHolder) ipChange.ipc$dispatch("-1566623639", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        View inflate = LayoutInflater.from(this.b).inflate(R$layout.ticklet_performance_require_item_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(this, inflate);
        viewHolder.a = (TextView) inflate.findViewById(R$id.ticklet_name);
        viewHolder.b = (TextView) inflate.findViewById(R$id.ticklet_desc);
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1141341440") ? ((Integer) ipChange.ipc$dispatch("1141341440", new Object[]{this})).intValue() : this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "75555972")) {
            return ((Long) ipChange.ipc$dispatch("75555972", new Object[]{this, Integer.valueOf(i)})).longValue();
        }
        return 0L;
    }
}
