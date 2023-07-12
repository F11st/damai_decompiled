package cn.damai.uikit.calendar;

import androidx.annotation.NonNull;
import androidx.collection.SparseArrayCompat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class MonthPagerAdapter extends CalendarPagerAdapter<MonthView> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.calendar.MonthPagerAdapter$a */
    /* loaded from: classes8.dex */
    public static class C2488a implements DateRangeIndex {
        private static transient /* synthetic */ IpChange $ipChange;
        private final CalendarDay a;
        private final int b;
        private SparseArrayCompat<CalendarDay> c = new SparseArrayCompat<>();

        public C2488a(@NonNull CalendarDay calendarDay, @NonNull CalendarDay calendarDay2) {
            this.a = CalendarDay.from(calendarDay.getYear(), calendarDay.getMonth(), 1);
            this.b = indexOf(CalendarDay.from(calendarDay2.getYear(), calendarDay2.getMonth(), 1)) + 1;
        }

        @Override // cn.damai.uikit.calendar.DateRangeIndex
        public int getCount() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-41255869") ? ((Integer) ipChange.ipc$dispatch("-41255869", new Object[]{this})).intValue() : this.b;
        }

        @Override // cn.damai.uikit.calendar.DateRangeIndex
        public CalendarDay getItem(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1371466169")) {
                return (CalendarDay) ipChange.ipc$dispatch("-1371466169", new Object[]{this, Integer.valueOf(i)});
            }
            CalendarDay calendarDay = this.c.get(i);
            if (calendarDay != null) {
                return calendarDay;
            }
            int year = this.a.getYear() + (i / 12);
            int month = this.a.getMonth() + (i % 12);
            if (month >= 12) {
                year++;
                month -= 12;
            }
            CalendarDay from = CalendarDay.from(year, month, 1);
            this.c.put(i, from);
            return from;
        }

        @Override // cn.damai.uikit.calendar.DateRangeIndex
        public int indexOf(CalendarDay calendarDay) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1452944071") ? ((Integer) ipChange.ipc$dispatch("1452944071", new Object[]{this, calendarDay})).intValue() : ((calendarDay.getYear() - this.a.getYear()) * 12) + (calendarDay.getMonth() - this.a.getMonth());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MonthPagerAdapter(MaterialCalendarView materialCalendarView) {
        super(materialCalendarView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.calendar.CalendarPagerAdapter
    /* renamed from: B */
    public MonthView c(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1808950567") ? (MonthView) ipChange.ipc$dispatch("-1808950567", new Object[]{this, Integer.valueOf(i)}) : new MonthView(this.b, f(i), this.b.getFirstDayOfWeek());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.calendar.CalendarPagerAdapter
    /* renamed from: C */
    public int k(MonthView monthView) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2094850089") ? ((Integer) ipChange.ipc$dispatch("-2094850089", new Object[]{this, monthView})).intValue() : g().indexOf(monthView.getMonth());
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerAdapter
    protected DateRangeIndex b(CalendarDay calendarDay, CalendarDay calendarDay2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2111362058") ? (DateRangeIndex) ipChange.ipc$dispatch("2111362058", new Object[]{this, calendarDay, calendarDay2}) : new C2488a(calendarDay, calendarDay2);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerAdapter
    protected boolean n(Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "71454629") ? ((Boolean) ipChange.ipc$dispatch("71454629", new Object[]{this, obj})).booleanValue() : obj instanceof MonthView;
    }
}
