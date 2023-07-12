package cn.damai.category.category.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.category.bean.CategoryBannerBean;
import cn.damai.category.category.ui.viewholder.CategoryGalleyHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.df;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class HorizontalGalleyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<CategoryBannerBean> b;
    private View.OnClickListener c;
    private df d;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2034423449")) {
            return ((Integer) ipChange.ipc$dispatch("-2034423449", new Object[]{this})).intValue();
        }
        List<CategoryBannerBean> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-836194510")) {
            ipChange.ipc$dispatch("-836194510", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            CategoryBannerBean categoryBannerBean = this.b.get(i);
            if (i == 0) {
                ((CategoryGalleyHolder) viewHolder).a(i, this.c, categoryBannerBean, this.d, true, false);
            } else if (i == this.b.size() - 1) {
                ((CategoryGalleyHolder) viewHolder).a(i, this.c, categoryBannerBean, this.d, false, true);
            } else {
                ((CategoryGalleyHolder) viewHolder).a(i, this.c, categoryBannerBean, this.d, false, false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1818388740") ? (RecyclerView.ViewHolder) ipChange.ipc$dispatch("1818388740", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new CategoryGalleyHolder(LayoutInflater.from(this.a));
    }
}
