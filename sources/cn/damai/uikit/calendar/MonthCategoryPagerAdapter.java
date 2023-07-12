package cn.damai.uikit.calendar;

import cn.damai.uikit.calendar.MonthPagerAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class MonthCategoryPagerAdapter extends CalendarPagerAdapter<MonthCategoryView> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MonthCategoryPagerAdapter(MaterialCalendarView materialCalendarView) {
        super(materialCalendarView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.calendar.CalendarPagerAdapter
    /* renamed from: B */
    public MonthCategoryView c(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1846602339") ? (MonthCategoryView) ipChange.ipc$dispatch("-1846602339", new Object[]{this, Integer.valueOf(i)}) : new MonthCategoryView(this.b, f(i), this.b.getFirstDayOfWeek());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.calendar.CalendarPagerAdapter
    /* renamed from: C */
    public int k(MonthCategoryView monthCategoryView) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1682520297") ? ((Integer) ipChange.ipc$dispatch("-1682520297", new Object[]{this, monthCategoryView})).intValue() : g().indexOf(monthCategoryView.getMonth());
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerAdapter
    protected DateRangeIndex b(CalendarDay calendarDay, CalendarDay calendarDay2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1575202092") ? (DateRangeIndex) ipChange.ipc$dispatch("1575202092", new Object[]{this, calendarDay, calendarDay2}) : new MonthPagerAdapter.a(calendarDay, calendarDay2);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerAdapter
    protected boolean n(Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-557940029") ? ((Boolean) ipChange.ipc$dispatch("-557940029", new Object[]{this, obj})).booleanValue() : obj instanceof MonthCategoryView;
    }
}
