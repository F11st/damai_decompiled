package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.InFieldCommentsBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.pp2;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class HorizontalDiscoverAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<InFieldCommentsBean> b;
    private View.OnClickListener c;
    private String d;

    public HorizontalDiscoverAdapter(Context context, View.OnClickListener onClickListener) {
        this.a = context;
        this.c = onClickListener;
    }

    public void a(List<InFieldCommentsBean> list, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "201862020")) {
            ipChange.ipc$dispatch("201862020", new Object[]{this, list, str});
            return;
        }
        this.d = str;
        if (wh2.e(list) > 0) {
            this.b = list;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-368241118")) {
            return ((Integer) ipChange.ipc$dispatch("-368241118", new Object[]{this})).intValue();
        }
        List<InFieldCommentsBean> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        InFieldCommentsBean inFieldCommentsBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "834326935")) {
            ipChange.ipc$dispatch("834326935", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder == null || (inFieldCommentsBean = this.b.get(i)) == null) {
        } else {
            inFieldCommentsBean.index = i;
            ((DiscoverItemHolder) viewHolder).a(inFieldCommentsBean, i, this.b.size(), this.c);
            pp2.u().m(viewHolder.itemView, this.d, inFieldCommentsBean, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1759007295") ? (RecyclerView.ViewHolder) ipChange.ipc$dispatch("1759007295", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new DiscoverItemHolder(LayoutInflater.from(this.a));
    }
}
