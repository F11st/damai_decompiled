package cn.damai.uikit.calendar;

import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
@Experimental
/* loaded from: classes8.dex */
public class WeekPagerAdapter extends CalendarPagerAdapter<WeekView> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class a implements DateRangeIndex {
        private static transient /* synthetic */ IpChange $ipChange;
        private final CalendarDay a;
        private final int b;

        public a(@NonNull CalendarDay calendarDay, @NonNull CalendarDay calendarDay2, int i) {
            CalendarDay a = a(calendarDay, i);
            this.a = a;
            this.b = b(a, calendarDay2) + 1;
        }

        private CalendarDay a(@NonNull CalendarDay calendarDay, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-399255305")) {
                return (CalendarDay) ipChange.ipc$dispatch("-399255305", new Object[]{this, calendarDay, Integer.valueOf(i)});
            }
            Calendar calendar = Calendar.getInstance();
            calendarDay.copyTo(calendar);
            while (calendar.get(7) != i) {
                calendar.add(7, -1);
            }
            return CalendarDay.from(calendar);
        }

        private int b(@NonNull CalendarDay calendarDay, @NonNull CalendarDay calendarDay2) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1278524850") ? ((Integer) ipChange.ipc$dispatch("1278524850", new Object[]{this, calendarDay, calendarDay2})).intValue() : (int) (TimeUnit.DAYS.convert(((calendarDay2.getDate().getTime() - calendarDay.getDate().getTime()) + calendarDay2.getCalendar().get(16)) - calendarDay.getCalendar().get(16), TimeUnit.MILLISECONDS) / 7);
        }

        @Override // cn.damai.uikit.calendar.DateRangeIndex
        public int getCount() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "2020909235") ? ((Integer) ipChange.ipc$dispatch("2020909235", new Object[]{this})).intValue() : this.b;
        }

        @Override // cn.damai.uikit.calendar.DateRangeIndex
        public CalendarDay getItem(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1353334089") ? (CalendarDay) ipChange.ipc$dispatch("-1353334089", new Object[]{this, Integer.valueOf(i)}) : CalendarDay.from(new Date(this.a.getDate().getTime() + TimeUnit.MILLISECONDS.convert(i * 7, TimeUnit.DAYS)));
        }

        @Override // cn.damai.uikit.calendar.DateRangeIndex
        public int indexOf(CalendarDay calendarDay) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1471076151") ? ((Integer) ipChange.ipc$dispatch("1471076151", new Object[]{this, calendarDay})).intValue() : b(this.a, calendarDay);
        }
    }

    public WeekPagerAdapter(MaterialCalendarView materialCalendarView) {
        super(materialCalendarView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.calendar.CalendarPagerAdapter
    /* renamed from: B */
    public WeekView c(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1876627331") ? (WeekView) ipChange.ipc$dispatch("-1876627331", new Object[]{this, Integer.valueOf(i)}) : new WeekView(this.b, f(i), this.b.getFirstDayOfWeek());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.calendar.CalendarPagerAdapter
    /* renamed from: C */
    public int k(WeekView weekView) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1022804477") ? ((Integer) ipChange.ipc$dispatch("-1022804477", new Object[]{this, weekView})).intValue() : g().indexOf(weekView.getFirstViewDay());
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerAdapter
    protected DateRangeIndex b(CalendarDay calendarDay, CalendarDay calendarDay2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1829583180") ? (DateRangeIndex) ipChange.ipc$dispatch("1829583180", new Object[]{this, calendarDay, calendarDay2}) : new a(calendarDay, calendarDay2, this.b.getFirstDayOfWeek());
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerAdapter
    protected boolean n(Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-213058909") ? ((Boolean) ipChange.ipc$dispatch("-213058909", new Object[]{this, obj})).booleanValue() : obj instanceof WeekView;
    }
}
