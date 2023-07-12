package cn.damai.category.calendar.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.calendar.bean.CalendarPerformEntity;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class HorizontalHeadAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<CalendarPerformEntity> b = new ArrayList();
    private View.OnClickListener c;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a;
        private View b;
        private View c;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.category.calendar.ui.adapter.HorizontalHeadAdapter$ViewHolder$a */
        /* loaded from: classes.dex */
        public class View$OnClickListenerC0316a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ CalendarPerformEntity a;

            View$OnClickListenerC0316a(CalendarPerformEntity calendarPerformEntity) {
                this.a = calendarPerformEntity;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1724638211")) {
                    ipChange.ipc$dispatch("-1724638211", new Object[]{this, view});
                    return;
                }
                HorizontalHeadAdapter.this.notifyDataSetChanged();
                if (HorizontalHeadAdapter.this.c != null) {
                    view.setTag(this.a);
                    HorizontalHeadAdapter.this.c.onClick(ViewHolder.this.itemView);
                }
            }
        }

        public ViewHolder() {
            super(LayoutInflater.from(HorizontalHeadAdapter.this.a).inflate(R$layout.calendar_head_item, (ViewGroup) null));
            this.a = (TextView) this.itemView.findViewById(R$id.tv_name);
            this.b = this.itemView.findViewById(R$id.view_left);
            this.c = this.itemView.findViewById(R$id.view_right);
        }

        public void a(CalendarPerformEntity calendarPerformEntity, boolean z, boolean z2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1824126113")) {
                ipChange.ipc$dispatch("1824126113", new Object[]{this, calendarPerformEntity, Boolean.valueOf(z), Boolean.valueOf(z2)});
            } else if (calendarPerformEntity == null) {
            } else {
                if (z) {
                    this.b.setVisibility(0);
                } else {
                    this.b.setVisibility(8);
                }
                if (z2) {
                    this.c.setVisibility(0);
                } else {
                    this.c.setVisibility(8);
                }
                if (calendarPerformEntity.isSelected) {
                    this.a.setBackgroundResource(R$drawable.bg_calendar_category_item_press);
                    this.a.setTextColor(HorizontalHeadAdapter.this.a.getResources().getColor(R$color.color_FF2D79));
                } else {
                    this.a.setBackgroundResource(R$drawable.bg_calendar_category_item_normal);
                    this.a.setTextColor(HorizontalHeadAdapter.this.a.getResources().getColor(R$color.color_000000));
                }
                this.a.setText(calendarPerformEntity.name);
                this.itemView.setOnClickListener(new View$OnClickListenerC0316a(calendarPerformEntity));
            }
        }
    }

    public HorizontalHeadAdapter(Context context, View.OnClickListener onClickListener) {
        this.a = context;
        this.c = onClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2118903997")) {
            ipChange.ipc$dispatch("-2118903997", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            CalendarPerformEntity calendarPerformEntity = this.b.get(i);
            if (i == 0) {
                viewHolder.a(calendarPerformEntity, true, false);
            } else if (i == this.b.size() - 1) {
                viewHolder.a(calendarPerformEntity, false, true);
            } else {
                viewHolder.a(calendarPerformEntity, false, false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1137744275") ? (ViewHolder) ipChange.ipc$dispatch("1137744275", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new ViewHolder();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1456874389")) {
            return ((Integer) ipChange.ipc$dispatch("1456874389", new Object[]{this})).intValue();
        }
        List<CalendarPerformEntity> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void setData(List<CalendarPerformEntity> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1775109913")) {
            ipChange.ipc$dispatch("-1775109913", new Object[]{this, list});
        } else if (wh2.e(list) > 0) {
            this.b = list;
            notifyDataSetChanged();
        }
    }
}
