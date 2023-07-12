package cn.damai.category.category.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.category.bean.CategoryEntity;
import cn.damai.category.category.ui.viewholder.CategoryDetailHolder;
import cn.damai.category.common.bean.CategoryBean;
import cn.damai.category.common.bean.CategoryPerformBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CategoryDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private View.OnClickListener b;
    private List<CategoryBean> c = new ArrayList();
    private CategoryEntity d;

    public CategoryDetailAdapter(Context context, View.OnClickListener onClickListener) {
        this.a = context;
        this.b = onClickListener;
    }

    public void a(CategoryPerformBean categoryPerformBean, CategoryEntity categoryEntity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1459197480")) {
            ipChange.ipc$dispatch("1459197480", new Object[]{this, categoryPerformBean, categoryEntity});
        } else if (categoryPerformBean == null || wh2.e(categoryPerformBean.statistics) <= 0) {
        } else {
            this.c.clear();
            this.c = categoryPerformBean.statistics;
            if (categoryEntity != null) {
                this.d = categoryEntity;
            }
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "81708394") ? ((Integer) ipChange.ipc$dispatch("81708394", new Object[]{this})).intValue() : wh2.e(this.c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "694220111")) {
            ipChange.ipc$dispatch("694220111", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            ((CategoryDetailHolder) viewHolder).a(i, this.c.get(i), this.d, this.b);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1115901319") ? (RecyclerView.ViewHolder) ipChange.ipc$dispatch("1115901319", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new CategoryDetailHolder(LayoutInflater.from(this.a));
    }
}
