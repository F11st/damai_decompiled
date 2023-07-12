package cn.damai.projectfilter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.projectfilter.bean.CategoryBean;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cb2;
import tb.kh0;
import tb.mu0;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes6.dex */
public class CategoryAdapter extends RecyclerView.Adapter<CVh> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int MAX_COUNT = 5;
    private Context a;
    public List<CategoryBean> b;
    private OnItemBindListener<CategoryBean> c;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class CVh extends RecyclerView.ViewHolder implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a;
        private TextView b;
        private CategoryBean c;
        private int d;

        public CVh(@NonNull View view) {
            super(view);
            this.a = (TextView) view.findViewById(R$id.item_category_one_name);
            this.b = (TextView) view.findViewById(R$id.item_category_one_tag);
        }

        public void a(CategoryBean categoryBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1626434612")) {
                ipChange.ipc$dispatch("-1626434612", new Object[]{this, categoryBean, Integer.valueOf(i)});
                return;
            }
            this.c = categoryBean;
            this.d = i;
            this.a.setText(categoryBean.name);
            this.b.setText(categoryBean.isSelected ? R$string.iconfont_duihaomian_ : R$string.iconfont_danxuanweixuanzhong24);
            this.b.setTextColor(categoryBean.isSelected ? kh0.C_FF2869 : kh0.C_C8C8C8);
            this.itemView.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "461736783")) {
                ipChange.ipc$dispatch("461736783", new Object[]{this, view});
            } else if (this.c.isSelected || !CategoryAdapter.this.c()) {
                CategoryAdapter.this.c.onItemClick(this.c, this.d);
            } else {
                ToastUtil.a().j(mu0.a(), "最多可选5个");
            }
        }
    }

    public List<CategoryBean> b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-659339120")) {
            return (List) ipChange.ipc$dispatch("-659339120", new Object[]{this});
        }
        ArrayList arrayList = new ArrayList();
        if (!cb2.d(this.b)) {
            for (CategoryBean categoryBean : this.b) {
                if (categoryBean.isSelected) {
                    arrayList.add(new CategoryBean(categoryBean.name, categoryBean.value, true));
                }
            }
        }
        return arrayList;
    }

    public boolean c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2054134656")) {
            return ((Boolean) ipChange.ipc$dispatch("-2054134656", new Object[]{this})).booleanValue();
        }
        if (cb2.d(this.b)) {
            return false;
        }
        int i = 0;
        for (CategoryBean categoryBean : this.b) {
            if (categoryBean.isSelected) {
                i++;
            }
        }
        return i >= 5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public void onBindViewHolder(@NonNull CVh cVh, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-27470467")) {
            ipChange.ipc$dispatch("-27470467", new Object[]{this, cVh, Integer.valueOf(i)});
        } else {
            cVh.a(this.b.get(i), i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: e */
    public CVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "510999577") ? (CVh) ipChange.ipc$dispatch("510999577", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new CVh(LayoutInflater.from(this.a).inflate(R$layout.item_filter_one_category_item, viewGroup, false));
    }

    public void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-338778994")) {
            ipChange.ipc$dispatch("-338778994", new Object[]{this});
        } else if (!cb2.d(this.b)) {
            boolean z = false;
            for (CategoryBean categoryBean : this.b) {
                if (categoryBean.isSelected) {
                    categoryBean.isSelected = false;
                    z = true;
                }
            }
            if (z) {
                notifyDataSetChanged();
            }
        }
    }

    public void g(List<CategoryBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "669109157")) {
            ipChange.ipc$dispatch("669109157", new Object[]{this, list});
        } else if (!cb2.d(this.b)) {
            if (list == null) {
                list = new ArrayList<>();
            }
            boolean z = false;
            for (CategoryBean categoryBean : this.b) {
                if (list.contains(categoryBean)) {
                    if (!categoryBean.isSelected) {
                        categoryBean.isSelected = true;
                        z = true;
                    }
                } else if (categoryBean.isSelected) {
                    categoryBean.isSelected = false;
                    z = true;
                }
            }
            if (z) {
                notifyDataSetChanged();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1972085542")) {
            return ((Integer) ipChange.ipc$dispatch("-1972085542", new Object[]{this})).intValue();
        }
        List<CategoryBean> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
