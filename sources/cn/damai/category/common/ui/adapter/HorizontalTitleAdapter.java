package cn.damai.category.common.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.category.bean.CategoryNewTitleBean;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class HorizontalTitleAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private View.OnClickListener c;
    private List<CategoryNewTitleBean> b = new ArrayList();
    private int d = 0;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a;
        private View b;
        private View c;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.category.common.ui.adapter.HorizontalTitleAdapter$ViewHolder$a */
        /* loaded from: classes.dex */
        public class View$OnClickListenerC0374a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            View$OnClickListenerC0374a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-85363768")) {
                    ipChange.ipc$dispatch("-85363768", new Object[]{this, view});
                    return;
                }
                HorizontalTitleAdapter.this.d = ((CategoryNewTitleBean) view.getTag()).index;
                HorizontalTitleAdapter.this.notifyDataSetChanged();
                HorizontalTitleAdapter.this.c.onClick(view);
            }
        }

        public ViewHolder() {
            super(LayoutInflater.from(HorizontalTitleAdapter.this.a).inflate(R$layout.category_title_item, (ViewGroup) null));
            this.a = (TextView) this.itemView.findViewById(R$id.tv_title);
            this.b = this.itemView.findViewById(R$id.view_left);
            this.c = this.itemView.findViewById(R$id.view_right);
        }

        public void a(CategoryNewTitleBean categoryNewTitleBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1400517837")) {
                ipChange.ipc$dispatch("1400517837", new Object[]{this, categoryNewTitleBean, Integer.valueOf(i)});
            } else if (categoryNewTitleBean == null) {
            } else {
                if (i == 0) {
                    this.b.setVisibility(0);
                } else {
                    this.b.setVisibility(8);
                }
                if (i == HorizontalTitleAdapter.this.b.size() - 1) {
                    this.c.setVisibility(0);
                } else {
                    this.c.setVisibility(8);
                }
                if (HorizontalTitleAdapter.this.d == categoryNewTitleBean.index) {
                    this.a.setTextColor(HorizontalTitleAdapter.this.a.getResources().getColor(R$color.color_FF2869));
                } else {
                    this.a.setTextColor(HorizontalTitleAdapter.this.a.getResources().getColor(R$color.color_9C9CA5));
                }
                this.a.setText(categoryNewTitleBean.name);
                this.itemView.setTag(categoryNewTitleBean);
                this.itemView.setOnClickListener(new View$OnClickListenerC0374a());
            }
        }
    }

    public HorizontalTitleAdapter(Context context, View.OnClickListener onClickListener) {
        this.a = context;
        this.c = onClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1723073023")) {
            ipChange.ipc$dispatch("1723073023", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            CategoryNewTitleBean categoryNewTitleBean = this.b.get(i);
            categoryNewTitleBean.index = i;
            viewHolder.a(categoryNewTitleBean, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1936082665") ? (ViewHolder) ipChange.ipc$dispatch("-1936082665", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new ViewHolder();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1977648810")) {
            return ((Integer) ipChange.ipc$dispatch("1977648810", new Object[]{this})).intValue();
        }
        List<CategoryNewTitleBean> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void h(List<CategoryNewTitleBean> list, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1281032849")) {
            ipChange.ipc$dispatch("1281032849", new Object[]{this, list, Integer.valueOf(i)});
        } else if (wh2.e(list) > 0) {
            this.d = i;
            this.b = list;
            notifyDataSetChanged();
        }
    }

    public void i(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-809869004")) {
            ipChange.ipc$dispatch("-809869004", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.d = i;
        notifyDataSetChanged();
    }
}
