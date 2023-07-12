package cn.damai.commonbusiness.calendar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.calendar.bean.CalendarBean;
import cn.damai.commonbusiness.calendar.bean.CalendarEntity;
import cn.damai.commonbusiness.calendar.bean.Day;
import cn.damai.commonbusiness.calendar.viewholder.CalendarViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.nf;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class CalendarListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private View.OnClickListener b;
    private CalendarBean c;
    private List<Day> d;
    private List<CalendarEntity> e;

    public CalendarListAdapter(Context context, View.OnClickListener onClickListener) {
        this.e = new ArrayList();
        this.a = context;
        this.b = onClickListener;
        this.e = nf.b(12);
    }

    public void a(CalendarBean calendarBean, List<Day> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1228371239")) {
            ipChange.ipc$dispatch("-1228371239", new Object[]{this, calendarBean, list});
            return;
        }
        this.c = calendarBean;
        this.d = list;
        if (wh2.e(list) > 0) {
            if (this.d.size() == 1) {
                if (this.d.get(0) != null) {
                    this.d.get(0).selectType = 1;
                }
            } else if (this.d.size() == 2) {
                if (this.d.get(0) != null && this.d.get(1) != null) {
                    this.d.get(0).selectType = 2;
                    this.d.get(1).selectType = 3;
                }
            } else {
                if (this.d.get(0) != null) {
                    this.d.get(0).selectType = 2;
                }
                for (int i = 1; i < this.d.size() - 1; i++) {
                    if (this.d.get(i) != null) {
                        this.d.get(i).selectType = 4;
                    }
                }
                List<Day> list2 = this.d;
                if (list2.get(list2.size() - 1) != null) {
                    List<Day> list3 = this.d;
                    list3.get(list3.size() - 1).selectType = 3;
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "29104237")) {
            return ((Integer) ipChange.ipc$dispatch("29104237", new Object[]{this})).intValue();
        }
        List<CalendarEntity> list = this.e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1956699028")) {
            ipChange.ipc$dispatch("-1956699028", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        CalendarEntity calendarEntity = this.e.get(i);
        if (viewHolder == null || calendarEntity == null) {
            return;
        }
        ((CalendarViewHolder) viewHolder).a(calendarEntity.year, calendarEntity.month, this.d, this.c, this.b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1775867638") ? (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-1775867638", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new CalendarViewHolder(LayoutInflater.from(this.a));
    }
}
