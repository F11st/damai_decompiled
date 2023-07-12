package cn.damai.category.grab.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.common.listener.ShareImageCallback;
import cn.damai.category.grab.bean.ItemBean;
import cn.damai.category.grab.ui.viewholder.GrabFootorHolder;
import cn.damai.category.grab.ui.viewholder.GrabItemHolder;
import cn.damai.category.grab.ui.viewholder.GrabTitleHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class GrabListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private View.OnClickListener b;
    private List<ItemBean> c = new ArrayList();
    private ShareImageCallback d;
    private boolean e;

    public GrabListAdapter(Context context, View.OnClickListener onClickListener) {
        this.a = context;
        this.b = onClickListener;
    }

    public void a(List<ItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "361596604")) {
            ipChange.ipc$dispatch("361596604", new Object[]{this, list});
        } else if (wh2.e(list) > 0) {
            this.c.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void b(ShareImageCallback shareImageCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-871255088")) {
            ipChange.ipc$dispatch("-871255088", new Object[]{this, shareImageCallback});
        } else {
            this.d = shareImageCallback;
        }
    }

    public void c(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-495199461")) {
            ipChange.ipc$dispatch("-495199461", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.e = z;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1526426847") ? ((Integer) ipChange.ipc$dispatch("-1526426847", new Object[]{this})).intValue() : wh2.e(this.c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-563014328") ? ((Integer) ipChange.ipc$dispatch("-563014328", new Object[]{this, Integer.valueOf(i)})).intValue() : this.c.get(i).groupType;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ItemBean itemBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1152215352")) {
            ipChange.ipc$dispatch("1152215352", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder == null || (itemBean = this.c.get(i)) == null) {
        } else {
            int i2 = itemBean.groupType;
            if (i2 == 0) {
                ((GrabItemHolder) viewHolder).d(this.e, itemBean, i, this.d);
            } else if (i2 == 1) {
                ((GrabTitleHolder) viewHolder).a(itemBean);
            }
            if (this.b != null) {
                viewHolder.itemView.setTag(itemBean);
                viewHolder.itemView.setOnClickListener(this.b);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2082807362")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-2082807362", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        LayoutInflater from = LayoutInflater.from(this.a);
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return new GrabFootorHolder(from);
            }
            return new GrabTitleHolder(from);
        }
        return new GrabItemHolder(from);
    }

    public void setData(List<ItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2065603035")) {
            ipChange.ipc$dispatch("2065603035", new Object[]{this, list});
        } else if (wh2.e(list) > 0) {
            this.c.clear();
            a(list);
        }
    }
}
