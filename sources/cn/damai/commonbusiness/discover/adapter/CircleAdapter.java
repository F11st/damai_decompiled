package cn.damai.commonbusiness.discover.adapter;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.discover.bean.CircleBean;
import cn.damai.commonbusiness.discover.viewholder.CircleCardViewHolder;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class CircleAdapter extends RecyclerView.Adapter<CircleCardViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<CircleBean> a;
    private OnItemBindListener<CircleBean> b;

    public CircleAdapter(OnItemBindListener<CircleBean> onItemBindListener) {
        this.b = onItemBindListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull CircleCardViewHolder circleCardViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1726280900")) {
            ipChange.ipc$dispatch("-1726280900", new Object[]{this, circleCardViewHolder, Integer.valueOf(i)});
        } else {
            circleCardViewHolder.a(this.a.get(i), i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: b */
    public CircleCardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1963045958") ? (CircleCardViewHolder) ipChange.ipc$dispatch("-1963045958", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new CircleCardViewHolder(viewGroup, this.b);
    }

    public void c(List<CircleBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-846965345")) {
            ipChange.ipc$dispatch("-846965345", new Object[]{this, list});
            return;
        }
        this.a = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "895634372")) {
            return ((Integer) ipChange.ipc$dispatch("895634372", new Object[]{this})).intValue();
        }
        List<CircleBean> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
