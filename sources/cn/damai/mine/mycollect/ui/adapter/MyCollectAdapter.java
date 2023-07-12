package cn.damai.mine.mycollect.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.search.viewholder.ProjectItemViewHolder;
import cn.damai.mine.mycollect.bean.MyCollectDataHolder;
import cn.damai.mine.mycollect.ui.viewholder.MyCollectBottomViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MyCollectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int BOTTOM = 1;
    public static final int PROJECT = 0;
    private Context a;
    private View.OnClickListener b;
    private View.OnLongClickListener c;
    private List<MyCollectDataHolder> d;

    public MyCollectAdapter(Context context, List<MyCollectDataHolder> list) {
        this.a = context;
        this.d = list;
    }

    public void a(View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1688420600")) {
            ipChange.ipc$dispatch("-1688420600", new Object[]{this, onClickListener, onLongClickListener});
            return;
        }
        this.b = onClickListener;
        this.c = onLongClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1812032828") ? ((Integer) ipChange.ipc$dispatch("-1812032828", new Object[]{this})).intValue() : wh2.e(this.d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1152611477") ? ((Integer) ipChange.ipc$dispatch("-1152611477", new Object[]{this, Integer.valueOf(i)})).intValue() : this.d.get(i).type;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "34768821")) {
            ipChange.ipc$dispatch("34768821", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            MyCollectDataHolder myCollectDataHolder = this.d.get(i);
            if (myCollectDataHolder.type != 0) {
                return;
            }
            ((ProjectItemViewHolder) viewHolder).k(myCollectDataHolder.mProjectItemBean);
            viewHolder.itemView.setTag(Integer.valueOf(i));
            View.OnClickListener onClickListener = this.b;
            if (onClickListener != null) {
                viewHolder.itemView.setOnClickListener(onClickListener);
            }
            View.OnLongClickListener onLongClickListener = this.c;
            if (onLongClickListener != null) {
                viewHolder.itemView.setOnLongClickListener(onLongClickListener);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1863247391")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-1863247391", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        LayoutInflater from = LayoutInflater.from(this.a);
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return new MyCollectBottomViewHolder(from);
        }
        return new ProjectItemViewHolder(viewGroup.getContext(), from);
    }
}
