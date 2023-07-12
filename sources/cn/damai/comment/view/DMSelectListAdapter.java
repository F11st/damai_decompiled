package cn.damai.comment.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.comment.R$layout;
import cn.damai.comment.bean.DmInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class DMSelectListAdapter extends RecyclerView.Adapter<PublishDMSelectViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private OnItemClickListener a;
    @Nullable
    private DmInfo b;
    @Nullable
    private List<DmInfo> c;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public static final class a implements OnItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.comment.view.OnItemClickListener
        public void onItemClick(@NotNull View view, int i, @Nullable DmInfo dmInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1283084188")) {
                ipChange.ipc$dispatch("-1283084188", new Object[]{this, view, Integer.valueOf(i), dmInfo});
                return;
            }
            b41.i(view, "itemView");
            DMSelectListAdapter dMSelectListAdapter = DMSelectListAdapter.this;
            Long dmId = dmInfo != null ? dmInfo.getDmId() : null;
            DmInfo b = DMSelectListAdapter.this.b();
            if (b41.d(dmId, b != null ? b.getDmId() : null)) {
                dmInfo = null;
            }
            dMSelectListAdapter.g(dmInfo);
            DMSelectListAdapter dMSelectListAdapter2 = DMSelectListAdapter.this;
            dMSelectListAdapter2.notifyItemRangeChanged(0, dMSelectListAdapter2.getItemCount());
            OnItemClickListener a = DMSelectListAdapter.this.a();
            if (a != null) {
                a.onItemClick(view, i, DMSelectListAdapter.this.b());
            }
        }
    }

    public DMSelectListAdapter(@Nullable OnItemClickListener onItemClickListener) {
        this.a = onItemClickListener;
    }

    @Nullable
    public final OnItemClickListener a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1089802941") ? (OnItemClickListener) ipChange.ipc$dispatch("1089802941", new Object[]{this}) : this.a;
    }

    @Nullable
    public final DmInfo b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1359936364") ? (DmInfo) ipChange.ipc$dispatch("-1359936364", new Object[]{this}) : this.b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public void onBindViewHolder(@NotNull PublishDMSelectViewHolder publishDMSelectViewHolder, int i) {
        DmInfo dmInfo;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1320471803")) {
            ipChange.ipc$dispatch("-1320471803", new Object[]{this, publishDMSelectViewHolder, Integer.valueOf(i)});
            return;
        }
        b41.i(publishDMSelectViewHolder, "viewHolder");
        List<DmInfo> list = this.c;
        if (list == null || (dmInfo = list.get(i)) == null) {
            return;
        }
        Long dmId = dmInfo.getDmId();
        if (dmId != null) {
            DmInfo dmInfo2 = this.b;
            z = dmId.equals(dmInfo2 != null ? dmInfo2.getDmId() : null);
        }
        publishDMSelectViewHolder.c(dmInfo, z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: d */
    public PublishDMSelectViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-683793583")) {
            return (PublishDMSelectViewHolder) ipChange.ipc$dispatch("-683793583", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        b41.i(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.view_dm_select_item_view, viewGroup, false);
        b41.h(inflate, "from(parent.context)\n   …item_view, parent, false)");
        return new PublishDMSelectViewHolder(inflate, new a());
    }

    public final void e(@Nullable List<DmInfo> list, @Nullable DmInfo dmInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1175959433")) {
            ipChange.ipc$dispatch("1175959433", new Object[]{this, list, dmInfo});
            return;
        }
        this.b = dmInfo;
        this.c = list;
        notifyDataSetChanged();
    }

    public final void f(@Nullable OnItemClickListener onItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "634722035")) {
            ipChange.ipc$dispatch("634722035", new Object[]{this, onItemClickListener});
        } else {
            this.a = onItemClickListener;
        }
    }

    public final void g(@Nullable DmInfo dmInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-144689666")) {
            ipChange.ipc$dispatch("-144689666", new Object[]{this, dmInfo});
        } else {
            this.b = dmInfo;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "83774071")) {
            return ((Integer) ipChange.ipc$dispatch("83774071", new Object[]{this})).intValue();
        }
        List<DmInfo> list = this.c;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
