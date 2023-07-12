package cn.damai.tetris.component.drama.viewholder;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.tetris.component.drama.bean.FilterTagBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class FilterTagAdapter extends RecyclerView.Adapter<FilterTagViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<FilterTagBean> a;
    private OnItemClickListener<FilterTagBean> b;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull FilterTagViewHolder filterTagViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1250646056")) {
            ipChange.ipc$dispatch("-1250646056", new Object[]{this, filterTagViewHolder, Integer.valueOf(i)});
        } else {
            filterTagViewHolder.a(this.a.get(i), i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: b */
    public FilterTagViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "540371614") ? (FilterTagViewHolder) ipChange.ipc$dispatch("540371614", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new FilterTagViewHolder(viewGroup, this.b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1714242336")) {
            return ((Integer) ipChange.ipc$dispatch("1714242336", new Object[]{this})).intValue();
        }
        List<FilterTagBean> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
