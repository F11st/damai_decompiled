package cn.damai.uikit.calendar;

import cn.damai.uikit.calendar.MonthPagerAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class MonthLabelPagerAdapter extends CalendarPagerAdapter<MonthLabelView> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MonthLabelPagerAdapter(MaterialCalendarView materialCalendarView) {
        super(materialCalendarView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.calendar.CalendarPagerAdapter
    /* renamed from: B */
    public MonthLabelView c(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1280833411") ? (MonthLabelView) ipChange.ipc$dispatch("-1280833411", new Object[]{this, Integer.valueOf(i)}) : new MonthLabelView(this.b, f(i), this.b.getFirstDayOfWeek());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.calendar.CalendarPagerAdapter
    /* renamed from: C */
    public int k(MonthLabelView monthLabelView) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-462097341") ? ((Integer) ipChange.ipc$dispatch("-462097341", new Object[]{this, monthLabelView})).intValue() : g().indexOf(monthLabelView.getMonth());
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerAdapter
    protected DateRangeIndex b(CalendarDay calendarDay, CalendarDay calendarDay2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1476387668") ? (DateRangeIndex) ipChange.ipc$dispatch("-1476387668", new Object[]{this, calendarDay, calendarDay2}) : new MonthPagerAdapter.C2488a(calendarDay, calendarDay2);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerAdapter
    protected boolean n(Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1231682749") ? ((Boolean) ipChange.ipc$dispatch("-1231682749", new Object[]{this, obj})).booleanValue() : obj instanceof MonthLabelView;
    }
}
