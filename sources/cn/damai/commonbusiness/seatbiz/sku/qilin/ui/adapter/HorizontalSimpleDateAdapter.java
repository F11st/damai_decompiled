package cn.damai.commonbusiness.seatbiz.sku.qilin.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.seatbiz.sku.qilin.ui.view.NcovSkuSimpleDateView;
import cn.damai.commonbusiness.seatbiz.sku.qilin.widget.DayEntity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes.dex */
public class HorizontalSimpleDateAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<DayEntity> b;
    private View.OnClickListener c;
    private NcovSkuSimpleDateView.ViewSelectListener d;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private View a;
        private View b;
        private View c;
        private TextView d;
        private TextView e;
        private TextView f;

        /* compiled from: Taobao */
        /* loaded from: classes.dex */
        public class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1231066222")) {
                    ipChange.ipc$dispatch("1231066222", new Object[]{this, view});
                    return;
                }
                DayEntity dayEntity = (DayEntity) view.getTag();
                if (dayEntity == null || !dayEntity.hasPerform || !dayEntity.hasPermission || HorizontalSimpleDateAdapter.this.c == null) {
                    return;
                }
                HorizontalSimpleDateAdapter.this.c.onClick(view);
            }
        }

        public ViewHolder() {
            super(LayoutInflater.from(HorizontalSimpleDateAdapter.this.a).inflate(R$layout.fragment_sku_ncov_simple_date_item, (ViewGroup) null));
            this.a = this.itemView.findViewById(R$id.left_view);
            this.b = this.itemView.findViewById(R$id.right_view);
            this.c = this.itemView.findViewById(R$id.view_bg);
            this.d = (TextView) this.itemView.findViewById(R$id.tv_week);
            this.e = (TextView) this.itemView.findViewById(R$id.tv_tag);
            this.f = (TextView) this.itemView.findViewById(R$id.tv_date);
        }

        public void a(DayEntity dayEntity, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1014964559")) {
                ipChange.ipc$dispatch("1014964559", new Object[]{this, dayEntity, Integer.valueOf(i)});
            } else if (dayEntity == null) {
            } else {
                this.a.setVisibility(8);
                this.b.setVisibility(8);
                if (i == 0) {
                    this.a.setVisibility(0);
                }
                if (i == HorizontalSimpleDateAdapter.this.b.size() - 1) {
                    this.b.setVisibility(0);
                }
                if (dayEntity.isSelected) {
                    if (HorizontalSimpleDateAdapter.this.d != null) {
                        HorizontalSimpleDateAdapter.this.d.viewSelect(this.itemView);
                    }
                    if (dayEntity.isSeePage) {
                        this.c.setBackgroundResource(R$drawable.ncov_sku_calendar_day_select_bg_red);
                    } else {
                        this.c.setBackgroundResource(R$drawable.ncov_sku_calendar_day_select_bg);
                    }
                } else {
                    this.c.setBackgroundResource(R$drawable.ncov_sku_simple_date_bg);
                }
                this.d.setVisibility(0);
                this.d.setText(dayEntity.week);
                this.f.setText(dayEntity.monthAndDay);
                this.e.setVisibility(8);
                if (dayEntity.topTag != null) {
                    this.e.setVisibility(0);
                    this.e.setText(dayEntity.topTag);
                    int i2 = dayEntity.tag;
                    if (i2 != 1 && i2 != 4 && i2 != 5) {
                        this.d.setVisibility(0);
                        this.e.setTextColor(HorizontalSimpleDateAdapter.this.a.getResources().getColor(R$color.color_FF2869));
                    } else {
                        this.d.setVisibility(8);
                        this.e.setTextColor(HorizontalSimpleDateAdapter.this.a.getResources().getColor(R$color.color_6A7A99));
                    }
                }
                if (dayEntity.hasPerform && dayEntity.hasPermission) {
                    TextView textView = this.d;
                    Resources resources = HorizontalSimpleDateAdapter.this.a.getResources();
                    int i3 = R$color.color_000000;
                    textView.setTextColor(resources.getColor(i3));
                    this.f.setTextColor(HorizontalSimpleDateAdapter.this.a.getResources().getColor(i3));
                } else {
                    TextView textView2 = this.d;
                    Resources resources2 = HorizontalSimpleDateAdapter.this.a.getResources();
                    int i4 = R$color.color_cccccc;
                    textView2.setTextColor(resources2.getColor(i4));
                    this.f.setTextColor(HorizontalSimpleDateAdapter.this.a.getResources().getColor(i4));
                }
                this.itemView.setTag(dayEntity);
                this.itemView.setOnClickListener(new a());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1425538431")) {
            ipChange.ipc$dispatch("1425538431", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            viewHolder.a(this.b.get(i), i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "835780759") ? (ViewHolder) ipChange.ipc$dispatch("835780759", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new ViewHolder();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1057700412")) {
            return ((Integer) ipChange.ipc$dispatch("-1057700412", new Object[]{this})).intValue();
        }
        List<DayEntity> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
