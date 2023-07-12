package cn.damai.category.calendar.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.calendar.bean.CalendarEntity;
import cn.damai.category.calendar.bean.Day;
import cn.damai.category.calendar.ui.viewholder.CalendarViewHolder;
import cn.damai.category.common.bean.CalendarBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.rf;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
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
        this.e = rf.b(12);
    }

    public void a(CalendarBean calendarBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1625915426")) {
            ipChange.ipc$dispatch("-1625915426", new Object[]{this, calendarBean});
        } else if (calendarBean == null) {
        } else {
            this.c = calendarBean;
            notifyDataSetChanged();
        }
    }

    public void b(CalendarBean calendarBean, List<Day> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1770680113")) {
            ipChange.ipc$dispatch("-1770680113", new Object[]{this, calendarBean, list});
        } else if (calendarBean != null) {
            this.d = list;
            if (wh2.e(list) > 0) {
                if (this.d.size() == 1) {
                    if (this.d.get(0) != null) {
                        this.d.get(0).selectType = 1;
                    }
                } else if (this.d.size() == 2) {
                    if (this.d.get(0) != null && this.d.get(1) != null) {
                        this.d.get(0).selectType = 2;
                        this.d.get(1).selectType = 4;
                    }
                } else {
                    if (this.d.get(0) != null) {
                        this.d.get(0).selectType = 2;
                    }
                    for (int i = 1; i < this.d.size() - 1; i++) {
                        if (this.d.get(i) != null) {
                            this.d.get(i).selectType = 3;
                        }
                    }
                    List<Day> list2 = this.d;
                    if (list2.get(list2.size() - 1) != null) {
                        List<Day> list3 = this.d;
                        list3.get(list3.size() - 1).selectType = 4;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-549947715")) {
            return ((Integer) ipChange.ipc$dispatch("-549947715", new Object[]{this})).intValue();
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
        if (AndroidInstantRuntime.support(ipChange, "1447007260")) {
            ipChange.ipc$dispatch("1447007260", new Object[]{this, viewHolder, Integer.valueOf(i)});
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
        return AndroidInstantRuntime.support(ipChange, "1203371866") ? (RecyclerView.ViewHolder) ipChange.ipc$dispatch("1203371866", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new CalendarViewHolder(LayoutInflater.from(this.a));
    }
}
