package cn.damai.category.category.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.category.bean.StarAndBrandItem;
import cn.damai.category.category.bean.StarBean;
import cn.damai.category.category.ui.viewholder.BrandHolder;
import cn.damai.category.category.ui.viewholder.StarHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.kd;
import tb.wh2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class BrandListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private View.OnClickListener b;
    private View.OnClickListener c;
    private View.OnClickListener d;
    private List<StarAndBrandItem> e = new ArrayList();

    public BrandListAdapter(Context context, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.a = context;
        this.c = onClickListener;
        this.b = onClickListener2;
        this.d = onClickListener3;
    }

    public void a(List<StarAndBrandItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1702905169")) {
            ipChange.ipc$dispatch("1702905169", new Object[]{this, list});
        } else if (wh2.e(list) > 0) {
            this.e.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void b(int i) {
        StarAndBrandItem starAndBrandItem;
        StarBean starBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1263051970")) {
            ipChange.ipc$dispatch("-1263051970", new Object[]{this, Integer.valueOf(i)});
        } else if (this.e != null) {
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                if (i2 == i && (starAndBrandItem = this.e.get(i2)) != null && (starBean = starAndBrandItem.starBean) != null) {
                    starBean.followStatus = 1;
                    notifyDataSetChanged();
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1514725460") ? ((Integer) ipChange.ipc$dispatch("-1514725460", new Object[]{this})).intValue() : wh2.e(this.e);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-224107437") ? ((Integer) ipChange.ipc$dispatch("-224107437", new Object[]{this, Integer.valueOf(i)})).intValue() : this.e.get(i).type;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        StarAndBrandItem starAndBrandItem;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "67291597")) {
            ipChange.ipc$dispatch("67291597", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder == null || (starAndBrandItem = this.e.get(i)) == null) {
        } else {
            starAndBrandItem.position = i;
            int i2 = starAndBrandItem.type;
            if (i2 != 2) {
                if (i2 != 8) {
                    return;
                }
                ((BrandHolder) viewHolder).a(starAndBrandItem);
                return;
            }
            ((StarHolder) viewHolder).a(starAndBrandItem, i, this.b);
            if (this.c != null) {
                viewHolder.itemView.setTag(starAndBrandItem);
                viewHolder.itemView.setOnClickListener(this.c);
            }
            if (starAndBrandItem.starBean != null) {
                kd.i(viewHolder.itemView, starAndBrandItem.index, z20.E(), starAndBrandItem.starBean.damaiId);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-791747895")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-791747895", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        LayoutInflater from = LayoutInflater.from(this.a);
        if (i != 2) {
            if (i != 8) {
                return null;
            }
            return new BrandHolder(from, this.d, this.c);
        }
        return new StarHolder(from);
    }

    public void setData(List<StarAndBrandItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-888055696")) {
            ipChange.ipc$dispatch("-888055696", new Object[]{this, list});
        } else if (wh2.e(list) > 0) {
            this.e.clear();
            a(list);
        } else {
            this.e.clear();
            notifyDataSetChanged();
        }
    }
}
