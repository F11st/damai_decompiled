package cn.damai.uikit.calendar;

import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import cn.damai.uikit.calendar.CalendarPagerView;
import cn.damai.uikit.calendar.MaterialCalendarView;
import cn.damai.uikit.calendar.format.DayFormatter;
import cn.damai.uikit.calendar.format.WeekDayFormatter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class MonthLabelView extends CalendarPagerView {
    private static transient /* synthetic */ IpChange $ipChange;

    public MonthLabelView(@NonNull MaterialCalendarView materialCalendarView, CalendarDay calendarDay, int i) {
        super(materialCalendarView, calendarDay, i);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    protected void buildDayViews(Calendar calendar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-788077052")) {
            ipChange.ipc$dispatch("-788077052", new Object[]{this, calendar});
            return;
        }
        for (int i = 0; i < 6; i++) {
            for (int i2 = 0; i2 < 7; i2++) {
                addDayLabelView(calendar);
            }
        }
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView, android.view.ViewGroup
    public /* bridge */ /* synthetic */ CalendarPagerView.C2481a generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    public CalendarDay getMonth() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1214418711") ? (CalendarDay) ipChange.ipc$dispatch("-1214418711", new Object[]{this}) : getFirstViewDay();
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    protected int getRows() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1429359927")) {
            return ((Integer) ipChange.ipc$dispatch("1429359927", new Object[]{this})).intValue();
        }
        return 6;
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    protected void invalidateDecorators() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1000004188")) {
            ipChange.ipc$dispatch("-1000004188", new Object[]{this});
            return;
        }
        C2490a c2490a = new C2490a();
        for (DayLabelView dayLabelView : this.dayLabelViews) {
            c2490a.q();
            Iterator<C2492b> it = this.decoratorResults.iterator();
            while (it.hasNext()) {
                C2492b next = it.next();
                if (next.a.shouldDecorate(dayLabelView.getDayView().getDate())) {
                    next.b.a(c2490a);
                }
            }
            dayLabelView.applyFacade(c2490a);
        }
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    protected boolean isDayEnabled(CalendarDay calendarDay) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1374619528") ? ((Boolean) ipChange.ipc$dispatch("1374619528", new Object[]{this, calendarDay})).booleanValue() : calendarDay.getMonth() == getFirstViewDay().getMonth();
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView, android.view.View.OnClickListener
    public /* bridge */ /* synthetic */ void onClick(View view) {
        super.onClick(view);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView, android.view.View
    public /* bridge */ /* synthetic */ void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView, android.view.View
    public /* bridge */ /* synthetic */ void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void setDateTextAppearance(int i) {
        super.setDateTextAppearance(i);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void setDayFormatter(DayFormatter dayFormatter) {
        super.setDayFormatter(dayFormatter);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void setMaximumDate(CalendarDay calendarDay) {
        super.setMaximumDate(calendarDay);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void setMinimumDate(CalendarDay calendarDay) {
        super.setMinimumDate(calendarDay);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public void setSelectedDates(Collection<CalendarDay> collection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "264791744")) {
            ipChange.ipc$dispatch("264791744", new Object[]{this, collection});
            return;
        }
        for (DayLabelView dayLabelView : this.dayLabelViews) {
            DayView dayView = dayLabelView.getDayView();
            LabelView dayLabelView2 = dayLabelView.getDayLabelView();
            if (dayView == null || dayLabelView2 == null) {
                return;
            }
            CalendarDay date = dayView.getDate();
            if (collection != null && collection.contains(date)) {
                dayView.setChecked(true);
                dayLabelView2.setChecked(true);
            } else {
                dayView.setChecked(false);
                dayLabelView2.setChecked(false);
            }
        }
        postInvalidate();
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void setSelectionColor(int i) {
        super.setSelectionColor(i);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void setSelectionEnabled(boolean z) {
        super.setSelectionEnabled(z);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void setShowOtherDates(@MaterialCalendarView.ShowOtherDates int i) {
        super.setShowOtherDates(i);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void setWeekDayFormatter(WeekDayFormatter weekDayFormatter) {
        super.setWeekDayFormatter(weekDayFormatter);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void setWeekDayTextAppearance(int i) {
        super.setWeekDayTextAppearance(i);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView, android.view.ViewGroup
    public /* bridge */ /* synthetic */ boolean shouldDelayChildPressedState() {
        return super.shouldDelayChildPressedState();
    }
}
