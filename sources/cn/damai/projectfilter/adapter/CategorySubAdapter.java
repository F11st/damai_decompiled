package cn.damai.projectfilter.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.projectfilter.bean.CategoryLevelTwo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class CategorySubAdapter extends RecyclerView.Adapter<SubVh> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<CategoryLevelTwo> a;
    private Context b;
    private OnCategorySubListener c;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface OnCategorySubListener {
        void onSubClick(int i, CategoryLevelTwo categoryLevelTwo);
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class SubVh extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private final TextView a;
        private final TextView b;

        public SubVh(@NonNull View view) {
            super(view);
            this.b = (TextView) view.findViewById(R$id.id_filter_category_sub);
            this.a = (TextView) view.findViewById(R$id.id_filter_category_sub_tag);
        }

        public void a(CategoryLevelTwo categoryLevelTwo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-399594825")) {
                ipChange.ipc$dispatch("-399594825", new Object[]{this, categoryLevelTwo});
                return;
            }
            this.b.setText(categoryLevelTwo.name);
            if (categoryLevelTwo.select) {
                int parseColor = Color.parseColor("#FF2869");
                this.a.setTextColor(parseColor);
                this.b.setTextColor(parseColor);
            } else {
                this.b.setTextColor(Color.parseColor("#333333"));
                this.a.setTextColor(Color.parseColor("#C8C8C8"));
            }
            this.a.setText(categoryLevelTwo.select ? R$string.iconfont_duihaomian_ : R$string.iconfont_danxuanweixuanzhong24);
            this.itemView.setTag(categoryLevelTwo);
            this.itemView.setOnClickListener(CategorySubAdapter.this);
        }
    }

    public CategorySubAdapter(Context context, OnCategorySubListener onCategorySubListener) {
        this.b = context;
        this.c = onCategorySubListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull SubVh subVh, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-173335412")) {
            ipChange.ipc$dispatch("-173335412", new Object[]{this, subVh, Integer.valueOf(i)});
            return;
        }
        CategoryLevelTwo categoryLevelTwo = this.a.get(i);
        categoryLevelTwo.pos = i;
        subVh.a(categoryLevelTwo);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: b */
    public SubVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1382175062") ? (SubVh) ipChange.ipc$dispatch("-1382175062", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new SubVh(LayoutInflater.from(this.b).inflate(R$layout.item_filter_category_new_sub, viewGroup, false));
    }

    public void c(List<CategoryLevelTwo> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1116958069")) {
            ipChange.ipc$dispatch("-1116958069", new Object[]{this, list});
            return;
        }
        this.a = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1805221808")) {
            return ((Integer) ipChange.ipc$dispatch("1805221808", new Object[]{this})).intValue();
        }
        List<CategoryLevelTwo> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OnCategorySubListener onCategorySubListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1956105740")) {
            ipChange.ipc$dispatch("-1956105740", new Object[]{this, view});
            return;
        }
        Object tag = view.getTag();
        if (!(tag instanceof CategoryLevelTwo) || (onCategorySubListener = this.c) == null) {
            return;
        }
        CategoryLevelTwo categoryLevelTwo = (CategoryLevelTwo) tag;
        onCategorySubListener.onSubClick(categoryLevelTwo.pos, categoryLevelTwo);
    }
}
