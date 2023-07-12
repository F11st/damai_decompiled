package cn.damai.uikit.calendar;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Calendar;

/* compiled from: Taobao */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes8.dex */
public class MonthView extends CalendarPagerView {
    private static transient /* synthetic */ IpChange $ipChange;

    public MonthView(@NonNull MaterialCalendarView materialCalendarView, CalendarDay calendarDay, int i) {
        super(materialCalendarView, calendarDay, i);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    protected void buildDayViews(Calendar calendar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1784333154")) {
            ipChange.ipc$dispatch("1784333154", new Object[]{this, calendar});
            return;
        }
        for (int i = 0; i < 6; i++) {
            for (int i2 = 0; i2 < 7; i2++) {
                addDayView(calendar);
            }
        }
    }

    public CalendarDay getMonth() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1265118411") ? (CalendarDay) ipChange.ipc$dispatch("1265118411", new Object[]{this}) : getFirstViewDay();
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    protected int getRows() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1313266667")) {
            return ((Integer) ipChange.ipc$dispatch("-1313266667", new Object[]{this})).intValue();
        }
        return 6;
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    protected boolean isDayEnabled(CalendarDay calendarDay) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "675834086") ? ((Boolean) ipChange.ipc$dispatch("675834086", new Object[]{this, calendarDay})).booleanValue() : calendarDay.getMonth() == getFirstViewDay().getMonth();
    }
}
