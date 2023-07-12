package cn.damai.category.categorygirl.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.search.Daojishi;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.viewholder.ProjectItemViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class GirlShowListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private View.OnClickListener b;
    private List<ProjectItemBean> c = new ArrayList();
    private Daojishi d;

    public GirlShowListAdapter(Context context, View.OnClickListener onClickListener) {
        this.a = context;
        this.b = onClickListener;
    }

    public void a(List<ProjectItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "54336887")) {
            ipChange.ipc$dispatch("54336887", new Object[]{this, list});
        } else if (wh2.e(list) > 0) {
            this.c.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void b(List<ProjectItemBean> list, Daojishi daojishi) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1787587306")) {
            ipChange.ipc$dispatch("1787587306", new Object[]{this, list, daojishi});
        } else if (wh2.e(list) > 0) {
            this.d = daojishi;
            this.c.clear();
            a(list);
        } else {
            this.c.clear();
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1523573574") ? ((Integer) ipChange.ipc$dispatch("1523573574", new Object[]{this})).intValue() : wh2.e(this.c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1038320141")) {
            ipChange.ipc$dispatch("-1038320141", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            ProjectItemViewHolder projectItemViewHolder = (ProjectItemViewHolder) viewHolder;
            ProjectItemBean projectItemBean = this.c.get(i);
            projectItemBean.pos = i;
            projectItemViewHolder.u(this.d);
            projectItemViewHolder.n(projectItemBean, false);
            if (this.b != null) {
                viewHolder.itemView.setTag(projectItemBean);
                viewHolder.itemView.setOnClickListener(this.b);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "92931427") ? (RecyclerView.ViewHolder) ipChange.ipc$dispatch("92931427", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new ProjectItemViewHolder(this.a, LayoutInflater.from(this.a));
    }
}
