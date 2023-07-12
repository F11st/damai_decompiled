package cn.damai.tetris.component.livehouse.viewholder;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.tetris.component.drama.viewholder.OnItemClickListener;
import cn.damai.tetris.component.livehouse.bean.ArtistItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ArtistRecycleAdapter extends RecyclerView.Adapter<ArtistListViewHolder> implements OnItemClickListener<ArtistItemBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<ArtistItemBean> a;
    private OnItemBindListener<ArtistItemBean> b;

    public ArtistRecycleAdapter(OnItemBindListener<ArtistItemBean> onItemBindListener) {
        this.b = onItemBindListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull ArtistListViewHolder artistListViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1256219177")) {
            ipChange.ipc$dispatch("-1256219177", new Object[]{this, artistListViewHolder, Integer.valueOf(i)});
            return;
        }
        ArtistItemBean artistItemBean = this.a.get(i);
        OnItemBindListener<ArtistItemBean> onItemBindListener = this.b;
        if (onItemBindListener != null) {
            onItemBindListener.exposeItem(artistListViewHolder.itemView, artistItemBean, i);
        }
        artistListViewHolder.a(artistItemBean, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: b */
    public ArtistListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1924637631") ? (ArtistListViewHolder) ipChange.ipc$dispatch("1924637631", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new ArtistListViewHolder(mu0.a(), viewGroup, this);
    }

    @Override // cn.damai.tetris.component.drama.viewholder.OnItemClickListener
    /* renamed from: c */
    public void onItemClick(ArtistItemBean artistItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-678715007")) {
            ipChange.ipc$dispatch("-678715007", new Object[]{this, artistItemBean, Integer.valueOf(i)});
            return;
        }
        OnItemBindListener<ArtistItemBean> onItemBindListener = this.b;
        if (onItemBindListener != null && artistItemBean != null) {
            onItemBindListener.onItemClick(artistItemBean, i);
        }
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            this.a.get(i2).artistVo.flag = 0;
        }
        this.a.get(i).artistVo.flag = 1;
        notifyDataSetChanged();
    }

    public void d(List<ArtistItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1219073342")) {
            ipChange.ipc$dispatch("1219073342", new Object[]{this, list});
            return;
        }
        this.a = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1520060893")) {
            return ((Integer) ipChange.ipc$dispatch("-1520060893", new Object[]{this})).intValue();
        }
        List<ArtistItemBean> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
