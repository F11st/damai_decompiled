package cn.damai.tetris.component.drama.viewholder;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.tetris.component.drama.bean.DramaV1Bean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class DramaListV1RecyAdapter extends RecyclerView.Adapter<DramaCardVerticalViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<DramaV1Bean> a;
    private OnItemBindListener<DramaV1Bean> b;

    public DramaListV1RecyAdapter(OnItemBindListener<DramaV1Bean> onItemBindListener) {
        this.b = onItemBindListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull DramaCardVerticalViewHolder dramaCardVerticalViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1788861750")) {
            ipChange.ipc$dispatch("-1788861750", new Object[]{this, dramaCardVerticalViewHolder, Integer.valueOf(i)});
            return;
        }
        DramaV1Bean dramaV1Bean = this.a.get(i);
        OnItemBindListener<DramaV1Bean> onItemBindListener = this.b;
        if (onItemBindListener != null) {
            onItemBindListener.exposeItem(dramaCardVerticalViewHolder.itemView, dramaV1Bean, i);
        }
        dramaCardVerticalViewHolder.a(dramaV1Bean, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: b */
    public DramaCardVerticalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-343214740") ? (DramaCardVerticalViewHolder) ipChange.ipc$dispatch("-343214740", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new DramaCardVerticalViewHolder(mu0.a(), viewGroup, this.b);
    }

    public void c(List<DramaV1Bean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-559921964")) {
            ipChange.ipc$dispatch("-559921964", new Object[]{this, list});
            return;
        }
        this.a = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "942721337")) {
            return ((Integer) ipChange.ipc$dispatch("942721337", new Object[]{this})).intValue();
        }
        List<DramaV1Bean> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
