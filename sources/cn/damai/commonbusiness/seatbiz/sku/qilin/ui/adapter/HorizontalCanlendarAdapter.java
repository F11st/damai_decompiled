package cn.damai.commonbusiness.seatbiz.sku.qilin.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.seatbiz.sku.qilin.widget.MonthEntity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.pf;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class HorizontalCanlendarAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private View.OnClickListener c;
    private List<MonthEntity> b = new ArrayList();
    private int d = 0;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a;

        public ViewHolder() {
            super(LayoutInflater.from(HorizontalCanlendarAdapter.this.a).inflate(R$layout.fragment_project_sku_date_item, (ViewGroup) null));
            this.a = (TextView) this.itemView.findViewById(R$id.tv_date);
        }

        public void a(MonthEntity monthEntity, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-448074209")) {
                ipChange.ipc$dispatch("-448074209", new Object[]{this, monthEntity, Integer.valueOf(i)});
            } else if (monthEntity == null) {
            } else {
                if (HorizontalCanlendarAdapter.this.d == i) {
                    this.a.setTextColor(HorizontalCanlendarAdapter.this.a.getResources().getColor(R$color.color_FF2869));
                } else {
                    this.a.setTextColor(HorizontalCanlendarAdapter.this.a.getResources().getColor(R$color.color_9C9CA5));
                }
                if (monthEntity.isShowYear) {
                    TextView textView = this.a;
                    textView.setText(monthEntity.year + "年" + pf.e(monthEntity.month) + "月");
                } else {
                    TextView textView2 = this.a;
                    textView2.setText(pf.e(monthEntity.month) + "月");
                }
                this.itemView.setTag(monthEntity);
                this.itemView.setOnClickListener(HorizontalCanlendarAdapter.this.c);
            }
        }
    }

    public HorizontalCanlendarAdapter(Context context, View.OnClickListener onClickListener) {
        this.a = context;
        this.c = onClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "283134529")) {
            ipChange.ipc$dispatch("283134529", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            MonthEntity monthEntity = this.b.get(i);
            monthEntity.index = i;
            viewHolder.a(monthEntity, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "60947413") ? (ViewHolder) ipChange.ipc$dispatch("60947413", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new ViewHolder();
    }

    public void f(List<MonthEntity> list, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1407533917")) {
            ipChange.ipc$dispatch("1407533917", new Object[]{this, list, Integer.valueOf(i)});
        } else if (wh2.e(list) > 0) {
            this.d = i;
            this.b = list;
            notifyDataSetChanged();
        }
    }

    public void g(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2086357248")) {
            ipChange.ipc$dispatch("-2086357248", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.d = i;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-661874314")) {
            return ((Integer) ipChange.ipc$dispatch("-661874314", new Object[]{this})).intValue();
        }
        List<MonthEntity> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
