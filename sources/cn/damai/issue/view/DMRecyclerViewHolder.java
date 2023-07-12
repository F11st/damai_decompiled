package cn.damai.issue.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.issue.listener.DMOnRVItemClickListener;
import cn.damai.issue.listener.DMOnRVItemLongClickListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DMRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    protected DMOnRVItemClickListener a;
    protected DMOnRVItemLongClickListener b;
    protected DMViewHolderHelper c;
    protected RecyclerView d;

    public DMRecyclerViewHolder(RecyclerView recyclerView, View view, DMOnRVItemClickListener dMOnRVItemClickListener, DMOnRVItemLongClickListener dMOnRVItemLongClickListener) {
        super(view);
        this.d = recyclerView;
        recyclerView.getContext();
        this.a = dMOnRVItemClickListener;
        this.b = dMOnRVItemLongClickListener;
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        DMViewHolderHelper dMViewHolderHelper = new DMViewHolderHelper(this.d, this.itemView);
        this.c = dMViewHolderHelper;
        dMViewHolderHelper.setRecyclerViewHolder(this);
    }

    public DMViewHolderHelper a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "11942454") ? (DMViewHolderHelper) ipChange.ipc$dispatch("11942454", new Object[]{this}) : this.c;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DMOnRVItemClickListener dMOnRVItemClickListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1041527608")) {
            ipChange.ipc$dispatch("1041527608", new Object[]{this, view});
        } else if (view.getId() != this.itemView.getId() || (dMOnRVItemClickListener = this.a) == null) {
        } else {
            dMOnRVItemClickListener.onRVItemClick(this.d, view, getAdapterPosition());
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        DMOnRVItemLongClickListener dMOnRVItemLongClickListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-603851360")) {
            return ((Boolean) ipChange.ipc$dispatch("-603851360", new Object[]{this, view})).booleanValue();
        }
        if (view.getId() != this.itemView.getId() || (dMOnRVItemLongClickListener = this.b) == null) {
            return false;
        }
        return dMOnRVItemLongClickListener.onRVItemLongClick(this.d, view, getAdapterPosition());
    }
}
