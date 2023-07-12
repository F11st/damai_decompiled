package cn.damai.ticklet.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.ticklet.inteface.TickletTransferCallback;
import cn.damai.ticklet.ui.activity.TickletTransferManageActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.rp2;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletManageAdapter extends RecyclerView.Adapter<ViewHolder> implements TickletTransferCallback {
    private static transient /* synthetic */ IpChange $ipChange;
    private TickletTransferManageActivity a;
    private LayoutInflater b;
    private TickletTransferCallback d;
    private List<rp2> c = new ArrayList();
    public List<ViewHolder> e = new ArrayList();

    public TickletManageAdapter(TickletTransferManageActivity tickletTransferManageActivity) {
        this.a = tickletTransferManageActivity;
        this.b = LayoutInflater.from(tickletTransferManageActivity);
    }

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1653221269")) {
            ipChange.ipc$dispatch("-1653221269", new Object[]{this});
            return;
        }
        notifyDataSetChanged();
        List<ViewHolder> list = this.e;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.e.size(); i++) {
            if (this.e.get(i) instanceof TickletTransferManagerViewHolder) {
                ((TickletTransferManagerViewHolder) this.e.get(i)).b();
            }
        }
    }

    public void b(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "289777656")) {
            ipChange.ipc$dispatch("289777656", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        List<ViewHolder> list = this.e;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            if (this.e.get(i2) instanceof TickletTransferManagerViewHolder) {
                ((TickletTransferManagerViewHolder) this.e.get(i2)).c(i);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2125028751")) {
            ipChange.ipc$dispatch("-2125028751", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        rp2 rp2Var = this.c.get(i);
        if (rp2Var == null || viewHolder == null) {
            return;
        }
        int f = rp2Var.f();
        if (f == 0 || f == 1 || f == 2) {
            ((TickletTransferManagerViewHolder) viewHolder).a(rp2Var, rp2Var.f());
        } else if (f != 4) {
        } else {
            ((TickletTransferTipsViewHolder) viewHolder).b(rp2Var);
        }
    }

    @Override // cn.damai.ticklet.inteface.TickletTransferCallback
    public void callCancelTransfer(String str, int i, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2076413130")) {
            ipChange.ipc$dispatch("-2076413130", new Object[]{this, str, Integer.valueOf(i), str2});
        } else {
            this.d.callCancelTransfer(str, i, str2);
        }
    }

    @Override // cn.damai.ticklet.inteface.TickletTransferCallback
    public void chooseUpdateView(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1053462024")) {
            ipChange.ipc$dispatch("-1053462024", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.d.chooseUpdateView(i);
        }
    }

    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "927440717")) {
            ipChange.ipc$dispatch("927440717", new Object[]{this});
        } else if (wh2.e(this.c) > 0) {
            this.c.clear();
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1826537765")) {
            return (ViewHolder) ipChange.ipc$dispatch("1826537765", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        ViewHolder viewHolder = null;
        if (i == 0 || i == 1 || i == 2) {
            viewHolder = new TickletTransferManagerViewHolder(this.a, this, this.b, i);
        } else if (i == 3) {
            viewHolder = new TransferDividerViewHolder(this.a, this.b);
        } else if (i == 4) {
            viewHolder = new TickletTransferTipsViewHolder(this.a, this.b);
        } else if (i == 5) {
            viewHolder = new TickletTransferLimitViewHolder(this.a, viewGroup, this.b);
        }
        if (!this.e.contains(viewHolder)) {
            this.e.add(viewHolder);
        }
        return viewHolder;
    }

    public void e(TickletTransferCallback tickletTransferCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "764715920")) {
            ipChange.ipc$dispatch("764715920", new Object[]{this, tickletTransferCallback});
        } else {
            this.d = tickletTransferCallback;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1185699395") ? ((Integer) ipChange.ipc$dispatch("-1185699395", new Object[]{this})).intValue() : this.c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1910210020") ? ((Integer) ipChange.ipc$dispatch("1910210020", new Object[]{this, Integer.valueOf(i)})).intValue() : this.c.get(i).f();
    }

    public void setData(List<rp2> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-471430721")) {
            ipChange.ipc$dispatch("-471430721", new Object[]{this, list});
            return;
        }
        this.c = list;
        notifyDataSetChanged();
    }
}
