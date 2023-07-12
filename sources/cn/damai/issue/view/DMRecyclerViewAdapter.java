package cn.damai.issue.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.issue.listener.DMOnItemChildCheckedChangeListener;
import cn.damai.issue.listener.DMOnItemChildClickListener;
import cn.damai.issue.listener.DMOnItemChildLongClickListener;
import cn.damai.issue.listener.DMOnRVItemClickListener;
import cn.damai.issue.listener.DMOnRVItemLongClickListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public abstract class DMRecyclerViewAdapter<M> extends RecyclerView.Adapter<DMRecyclerViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    protected final int a;
    protected Context b;
    protected ArrayList<M> c = new ArrayList<>();
    protected DMOnItemChildClickListener d;
    protected DMOnItemChildLongClickListener e;
    protected DMOnItemChildCheckedChangeListener f;
    protected DMOnRVItemClickListener g;
    protected DMOnRVItemLongClickListener h;
    protected RecyclerView i;

    public DMRecyclerViewAdapter(RecyclerView recyclerView, int i) {
        this.i = recyclerView;
        this.b = recyclerView.getContext();
        this.a = i;
    }

    public void a(M m) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "905887904")) {
            ipChange.ipc$dispatch("905887904", new Object[]{this, m});
        } else {
            b(0, m);
        }
    }

    public void b(int i, M m) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "217845999")) {
            ipChange.ipc$dispatch("217845999", new Object[]{this, Integer.valueOf(i), m});
            return;
        }
        this.c.add(i, m);
        notifyItemInserted(i);
    }

    protected abstract void c(DMViewHolderHelper dMViewHolderHelper, int i, M m);

    public ArrayList<M> d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1971558722") ? (ArrayList) ipChange.ipc$dispatch("-1971558722", new Object[]{this}) : this.c;
    }

    public void e(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1918181726")) {
            ipChange.ipc$dispatch("-1918181726", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        ArrayList<M> arrayList = this.c;
        arrayList.add(i2, arrayList.remove(i));
        notifyItemMoved(i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public void onBindViewHolder(DMRecyclerViewHolder dMRecyclerViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1558210157")) {
            ipChange.ipc$dispatch("1558210157", new Object[]{this, dMRecyclerViewHolder, Integer.valueOf(i)});
        } else {
            c(dMRecyclerViewHolder.a(), i, getItem(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(DMRecyclerViewHolder dMRecyclerViewHolder, int i, List<Object> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1318484318")) {
            ipChange.ipc$dispatch("1318484318", new Object[]{this, dMRecyclerViewHolder, Integer.valueOf(i), list});
        } else if (list.isEmpty()) {
            onBindViewHolder(dMRecyclerViewHolder, i);
        } else {
            n(dMRecyclerViewHolder.a(), i, getItem(i), list);
        }
    }

    public M getItem(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1689684310") ? (M) ipChange.ipc$dispatch("-1689684310", new Object[]{this, Integer.valueOf(i)}) : this.c.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1855209075") ? ((Integer) ipChange.ipc$dispatch("1855209075", new Object[]{this})).intValue() : this.c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public DMRecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1377846871")) {
            return (DMRecyclerViewHolder) ipChange.ipc$dispatch("-1377846871", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        DMRecyclerViewHolder dMRecyclerViewHolder = new DMRecyclerViewHolder(this.i, LayoutInflater.from(this.b).inflate(this.a, viewGroup, false), this.g, this.h);
        dMRecyclerViewHolder.a().setOnItemChildClickListener(this.d);
        dMRecyclerViewHolder.a().setOnItemChildLongClickListener(this.e);
        dMRecyclerViewHolder.a().setOnItemChildCheckedChangeListener(this.f);
        k(dMRecyclerViewHolder.a());
        return dMRecyclerViewHolder;
    }

    public void i(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1943189900")) {
            ipChange.ipc$dispatch("-1943189900", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.c.remove(i);
        notifyItemRemoved(i);
    }

    public void j(ArrayList<M> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-384510382")) {
            ipChange.ipc$dispatch("-384510382", new Object[]{this, arrayList});
            return;
        }
        if (arrayList != null) {
            this.c = arrayList;
        } else {
            this.c.clear();
        }
        notifyDataSetChanged();
    }

    protected void k(DMViewHolderHelper dMViewHolderHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1811386119")) {
            ipChange.ipc$dispatch("-1811386119", new Object[]{this, dMViewHolderHelper});
        }
    }

    public void l(DMOnItemChildClickListener dMOnItemChildClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2053916026")) {
            ipChange.ipc$dispatch("2053916026", new Object[]{this, dMOnItemChildClickListener});
        } else {
            this.d = dMOnItemChildClickListener;
        }
    }

    public void m(DMOnRVItemClickListener dMOnRVItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1075740716")) {
            ipChange.ipc$dispatch("1075740716", new Object[]{this, dMOnRVItemClickListener});
        } else {
            this.g = dMOnRVItemClickListener;
        }
    }

    protected abstract void n(DMViewHolderHelper dMViewHolderHelper, int i, M m, List<Object> list);
}
