package cn.damai.search.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.search.bean.youku.ArtificialProxy;
import cn.damai.search.ui.viewholder.SearchHeadArtificialViewHolder;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ArtificialAdapter extends RecyclerView.Adapter<SearchHeadArtificialViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<ArtificialProxy> a;
    private Context b;
    private OnItemBindListener<ArtificialProxy> c;

    public ArtificialAdapter(Context context, OnItemBindListener<ArtificialProxy> onItemBindListener) {
        this.b = context;
        this.c = onItemBindListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull SearchHeadArtificialViewHolder searchHeadArtificialViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1947777192")) {
            ipChange.ipc$dispatch("1947777192", new Object[]{this, searchHeadArtificialViewHolder, Integer.valueOf(i)});
        } else {
            searchHeadArtificialViewHolder.a(this.a.get(i), i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: b */
    public SearchHeadArtificialViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-572602418") ? (SearchHeadArtificialViewHolder) ipChange.ipc$dispatch("-572602418", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new SearchHeadArtificialViewHolder(this.b, viewGroup, this.c);
    }

    public void c(List<ArtificialProxy> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "823176003")) {
            ipChange.ipc$dispatch("823176003", new Object[]{this, list});
            return;
        }
        this.a = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1893032344")) {
            return ((Integer) ipChange.ipc$dispatch("-1893032344", new Object[]{this})).intValue();
        }
        List<ArtificialProxy> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
