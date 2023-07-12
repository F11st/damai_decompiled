package cn.damai.category.calendar.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.common.bean.CategoryBean;
import cn.damai.category.common.bean.CategoryPerformBean;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class HorizontalCategoryAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<CategoryBean> b;
    private View.OnClickListener c;
    private String d = "0";

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a;
        private TextView b;
        private View c;
        private View d;

        /* compiled from: Taobao */
        /* loaded from: classes.dex */
        public class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ CategoryBean a;

            a(CategoryBean categoryBean) {
                this.a = categoryBean;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "78635035")) {
                    ipChange.ipc$dispatch("78635035", new Object[]{this, view});
                    return;
                }
                HorizontalCategoryAdapter.this.d = this.a.id;
                HorizontalCategoryAdapter.this.notifyDataSetChanged();
                if (HorizontalCategoryAdapter.this.c != null) {
                    view.setTag(this.a);
                    HorizontalCategoryAdapter.this.c.onClick(ViewHolder.this.itemView);
                }
            }
        }

        public ViewHolder() {
            super(LayoutInflater.from(HorizontalCategoryAdapter.this.a).inflate(R$layout.calendar_category_item, (ViewGroup) null));
            ViewGroup viewGroup = (ViewGroup) this.itemView.findViewById(R$id.layout_category_tag);
            this.a = (TextView) this.itemView.findViewById(R$id.tv_category);
            this.b = (TextView) this.itemView.findViewById(R$id.tv_num);
            this.c = this.itemView.findViewById(R$id.view_left);
            this.d = this.itemView.findViewById(R$id.view_right);
        }

        public void a(CategoryBean categoryBean, boolean z, boolean z2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-189867312")) {
                ipChange.ipc$dispatch("-189867312", new Object[]{this, categoryBean, Boolean.valueOf(z), Boolean.valueOf(z2)});
            } else if (categoryBean == null) {
            } else {
                if (z) {
                    this.c.setVisibility(0);
                } else {
                    this.c.setVisibility(8);
                }
                if (z2) {
                    this.d.setVisibility(0);
                } else {
                    this.d.setVisibility(8);
                }
                this.a.setText(categoryBean.name);
                TextView textView = this.b;
                textView.setText(categoryBean.count + "");
                if (categoryBean.id.equals(HorizontalCategoryAdapter.this.d)) {
                    TextView textView2 = this.a;
                    Resources resources = HorizontalCategoryAdapter.this.a.getResources();
                    int i = R$color.color_FF2D79;
                    textView2.setTextColor(resources.getColor(i));
                    this.b.setTextColor(HorizontalCategoryAdapter.this.a.getResources().getColor(i));
                } else {
                    TextView textView3 = this.a;
                    Resources resources2 = HorizontalCategoryAdapter.this.a.getResources();
                    int i2 = R$color.color_666666;
                    textView3.setTextColor(resources2.getColor(i2));
                    this.b.setTextColor(HorizontalCategoryAdapter.this.a.getResources().getColor(i2));
                }
                this.itemView.setOnClickListener(new a(categoryBean));
            }
        }
    }

    public HorizontalCategoryAdapter(Context context, View.OnClickListener onClickListener) {
        this.a = context;
        this.c = onClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "302959743")) {
            ipChange.ipc$dispatch("302959743", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            CategoryBean categoryBean = this.b.get(i);
            if (i == 0) {
                viewHolder.a(categoryBean, true, false);
            } else if (i == this.b.size() - 1) {
                viewHolder.a(categoryBean, false, true);
            } else {
                viewHolder.a(categoryBean, false, false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-833751337") ? (ViewHolder) ipChange.ipc$dispatch("-833751337", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new ViewHolder();
    }

    public void g(CategoryPerformBean categoryPerformBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1355589803")) {
            ipChange.ipc$dispatch("1355589803", new Object[]{this, categoryPerformBean});
        } else if (categoryPerformBean == null || wh2.e(categoryPerformBean.statistics) <= 0) {
        } else {
            this.d = "0";
            this.b = categoryPerformBean.statistics;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1395045833")) {
            return ((Integer) ipChange.ipc$dispatch("-1395045833", new Object[]{this})).intValue();
        }
        List<CategoryBean> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
