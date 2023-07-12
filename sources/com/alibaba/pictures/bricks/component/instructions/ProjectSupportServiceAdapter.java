package com.alibaba.pictures.bricks.component.instructions;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.bricks.bean.TicketNote;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ProjectSupportServiceAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<T> b;
    private ArrayList<TicketNote> c;

    public ProjectSupportServiceAdapter(Context context, List<T> list) {
        this.a = context;
        this.b = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1622838254") ? ((Integer) ipChange.ipc$dispatch("1622838254", new Object[]{this})).intValue() : this.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-236565429")) {
            ipChange.ipc$dispatch("-236565429", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else {
            ((ProjectSupportServiceViewHolder) viewHolder).a((TicketNote) this.b.get(i), i == getItemCount() - 1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2105051659")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("2105051659", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        ProjectSupportServiceViewHolder projectSupportServiceViewHolder = new ProjectSupportServiceViewHolder(this.a, viewGroup);
        ArrayList<TicketNote> arrayList = this.c;
        if (arrayList != null) {
            projectSupportServiceViewHolder.d(arrayList);
        }
        return projectSupportServiceViewHolder;
    }
}
