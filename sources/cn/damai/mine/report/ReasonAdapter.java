package cn.damai.mine.report;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.mine.report.bean.ReportReason;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ReasonAdapter extends RecyclerView.Adapter {
    private static transient /* synthetic */ IpChange $ipChange;
    List<ReportReason> a;
    ReportViewModel b;
    Context c;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.report.ReasonAdapter$a */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1452a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;

        View$OnClickListenerC1452a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1243202044")) {
                ipChange.ipc$dispatch("-1243202044", new Object[]{this, view});
            } else {
                ReasonAdapter.this.b.selectReasonItem(this.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.report.ReasonAdapter$b */
    /* loaded from: classes6.dex */
    class C1453b extends RecyclerView.ViewHolder {
        public TextView a;
        public TextView b;

        public C1453b(ReasonAdapter reasonAdapter, View view) {
            super(view);
            this.a = (TextView) view.findViewById(R$id.report_item_tv);
            this.b = (TextView) view.findViewById(R$id.report_item_check);
        }
    }

    public ReasonAdapter(ReportViewModel reportViewModel) {
        this.b = reportViewModel;
    }

    public void a(List<ReportReason> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-858279218")) {
            ipChange.ipc$dispatch("-858279218", new Object[]{this, list});
            return;
        }
        this.a = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "192972723")) {
            return ((Integer) ipChange.ipc$dispatch("192972723", new Object[]{this})).intValue();
        }
        List<ReportReason> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-514657946")) {
            ipChange.ipc$dispatch("-514657946", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        List<ReportReason> list = this.a;
        if (list == null || list.get(i) == null) {
            return;
        }
        ReportReason reportReason = this.a.get(i);
        C1453b c1453b = (C1453b) viewHolder;
        c1453b.a.setText(reportReason.reasonStr);
        viewHolder.itemView.setOnClickListener(new View$OnClickListenerC1452a(i));
        if (reportReason.checked) {
            c1453b.b.setTextColor(this.c.getResources().getColor(R$color.red_text));
            c1453b.b.setText(R$string.iconfont_danxuanxuanzhong24);
            return;
        }
        c1453b.b.setTextColor(this.c.getResources().getColor(R$color.black));
        c1453b.b.setText(R$string.iconfont_danxuanweixuanzhong24);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1005893296")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-1005893296", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        if (viewGroup.getContext() == null) {
            return null;
        }
        Context context = viewGroup.getContext();
        this.c = context;
        return new C1453b(this, LayoutInflater.from(context).inflate(R$layout.report_list_item, viewGroup, false));
    }
}
