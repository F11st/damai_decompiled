package cn.damai.tetris.component.drama.viewholder;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.tetris.component.drama.bean.DramaV2Bean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class DramaListV2RecyAdapter extends RecyclerView.Adapter<DramaCardVerticalV2ViewHolder> implements OnItemClickListener<DramaV2Bean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<DramaV2Bean> a;
    private OnItemBindListener<DramaV2Bean> b;

    public DramaListV2RecyAdapter(OnItemBindListener<DramaV2Bean> onItemBindListener) {
        this.b = onItemBindListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull DramaCardVerticalV2ViewHolder dramaCardVerticalV2ViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-787853465")) {
            ipChange.ipc$dispatch("-787853465", new Object[]{this, dramaCardVerticalV2ViewHolder, Integer.valueOf(i)});
            return;
        }
        DramaV2Bean dramaV2Bean = this.a.get(i);
        OnItemBindListener<DramaV2Bean> onItemBindListener = this.b;
        if (onItemBindListener != null) {
            onItemBindListener.exposeItem(dramaCardVerticalV2ViewHolder.itemView, dramaV2Bean, i);
        }
        dramaCardVerticalV2ViewHolder.a(dramaV2Bean, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: b */
    public DramaCardVerticalV2ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1969613167") ? (DramaCardVerticalV2ViewHolder) ipChange.ipc$dispatch("1969613167", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new DramaCardVerticalV2ViewHolder(mu0.a(), viewGroup, this);
    }

    @Override // cn.damai.tetris.component.drama.viewholder.OnItemClickListener
    /* renamed from: c */
    public void onItemClick(DramaV2Bean dramaV2Bean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-557602828")) {
            ipChange.ipc$dispatch("-557602828", new Object[]{this, dramaV2Bean, Integer.valueOf(i)});
            return;
        }
        OnItemBindListener<DramaV2Bean> onItemBindListener = this.b;
        if (onItemBindListener == null || dramaV2Bean == null) {
            return;
        }
        onItemBindListener.onItemClick(dramaV2Bean, i);
    }

    public void d(List<DramaV2Bean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "901658035")) {
            ipChange.ipc$dispatch("901658035", new Object[]{this, list});
            return;
        }
        this.a = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "954037464")) {
            return ((Integer) ipChange.ipc$dispatch("954037464", new Object[]{this})).intValue();
        }
        List<DramaV2Bean> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
